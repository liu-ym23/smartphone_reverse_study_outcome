package com.larus.bmhome.music.save_video;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C4095a f313082i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f313083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f313084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MediaFormat f313085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MediaCodec f313086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MediaCodec.BufferInfo f313087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f313088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Surface f313089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MediaExtractor f313090h;

    /* JADX INFO: renamed from: com.larus.bmhome.music.save_video.a$a, reason: collision with other inner class name */
    public static final class C4095a {
        public C4095a() {
        }

        public static MediaFormat b(q r100) {
            MediaFormat r101 = MediaFormat.createVideoFormat(r100.f313132d, r100.f313130b, r100.f313131c);
            r101.setInteger("color-format", 2130708361);
            r101.setInteger("bitrate", r100.f313135g);
            r101.setFloat(com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE, r100.f313134f);
            r101.setInteger("i-frame-interval", r100.f313136h);
            return r101;
        }

        public static Pair a(MediaCodecList r100, int r101, int r102, q r103) {
            Iterator r104 = ArrayIteratorKt.iterator(r100.getCodecInfos());
        L4:
            if (r104.hasNext() == false) goto L22;
            MediaCodecInfo r105 = (MediaCodecInfo) r104.next();
            if (r105.isEncoder() == false) goto L4;
            Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L9
            Object r107 = Result.m9449constructorimpl(r105.getCapabilitiesForType(r103.f313132d).getVideoCapabilities());     // Catch: Throwable -> L9
        L12:
            if (Result.m9455isFailureimpl(r107) == false) goto L14;
            r107 = null;
        L14:
            MediaCodecInfo.VideoCapabilities r108 = (MediaCodecInfo.VideoCapabilities) r107;
            if (r108 == null) goto L4;
            int r109 = (((r108.getWidthAlignment() + r101) - 1) / r108.getWidthAlignment()) * r108.getWidthAlignment();
            int r110 = (((r108.getHeightAlignment() + r102) - 1) / r108.getHeightAlignment()) * r108.getHeightAlignment();
            if (r108.areSizeAndRateSupported(r109, r110, r103.f313134f) == false) goto L4;
            return TuplesKt.to(Integer.valueOf(r109), Integer.valueOf(r110));
        L9:
            th = move-exception;
            Result.Companion r111 = Result.Companion;
            r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L12
        L22:
            return TuplesKt.to(Integer.valueOf(r101), Integer.valueOf(r102));
        }
    }

    static {
        f313082i = new C4095a();
    }

    public final void a(boolean r110) {
        q r100 = this.f313084b;
        long r101 = r100.f313137i;
        boolean r102 = r100.f313138j;
        long r103 = SystemClock.elapsedRealtime();
        if (r110 == false) goto L5;
        this.f313086d.signalEndOfInputStream();
    L5:
        ByteBuffer[] r104 = this.f313086d.getOutputBuffers();
    L6:
        int r105 = this.f313086d.dequeueOutputBuffer(this.f313087e, 10000);
        if (r102 == false) goto L15;
        if (r101 <= 0) goto L15;
        if (r110 == false) goto L15;
        long r106 = SystemClock.elapsedRealtime() - r103;
        if (r106 < r101) goto L15;
        FLogger.f375446a.e("FrameBuilder", "drainCodec overall timeout, waitMs=" + r106 + ", timeoutMs=" + r101);
        return;
    L15:
        if (r105 == (-1)) goto L16;
        if (r105 == (-3)) goto L20;
        boolean r107 = true;
        if (r105 == (-2)) goto L23;
        if (r105 < 0) goto L6;
        if (r104 == null) goto L64;
        ByteBuffer r108 = r104[r105];
        if (r108 == null) goto L64;
        MediaCodec.BufferInfo r109 = this.f313087e;
        if ((r109.flags & 2) == 0) goto L44;
        r109.size = 0;
    L44:
        if (r109.size == 0) goto L65;
        b r111 = this.f313088f;
        if (r111 != null) goto L48;
    L50:
        r107 = false;
    L51:
        if (r107 == false) goto L56;
        b r112 = this.f313088f;
        if (r112 == null) goto L65;
        r112.b(r108, this.f313087e);
        goto L65
    L56:
        throw new RuntimeException("muxer hasn't started");
    L48:
        if (r111.isStarted() != true) goto L50;
    L65:
        this.f313086d.releaseOutputBuffer(r105, false);     // Catch: Exception -> L59
    L61:
        if ((this.f313087e.flags & 4) == 0) goto L6;
        return;
    L64:
        throw new RuntimeException("encoderOutputBuffer  " + r105 + " was null");
    L23:
        b r113 = this.f313088f;
        if (r113 != null) goto L26;
    L28:
        r107 = false;
    L29:
        if (r107 == true) goto L34;
        MediaFormat r114 = this.f313086d.getOutputFormat();
        FLogger.f375446a.i("FrameBuilder", "encoder output format changed: " + r114);
        b r115 = this.f313088f;
        if (r115 == null) goto L6;
        r115.c(r114, this.f313090h);
        goto L6
    L34:
        throw new RuntimeException("format changed twice");
    L26:
        if (r113.isStarted() != true) goto L28;
    L20:
        r104 = this.f313086d.getOutputBuffers();
        goto L6
    L16:
        if (r110 == true) goto L6;
    }

    public a(Context r100, q r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "muxerConfig");
        this.f313083a = r100;
        this.f313084b = r101;
        f313082i.getClass();
        MediaFormat r103 = C4095a.b(r101);
        this.f313085c = r103;
        this.f313086d = MediaCodec.createByCodecName(new MediaCodecList(0).findEncoderForFormat(r103));
        this.f313087e = new MediaCodec.BufferInfo();
        this.f313088f = r101.f313139k;
        if (r102 == null) goto L5;
        MediaExtractor r104 = new MediaExtractor();
        r104.setDataSource(r102);
    L6:
        this.f313090h = r104;
        return;
    L5:
        r104 = null;
        goto L6
    }
}
