package com.larus.bmhome.music.save_video.software_decoder;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.larus.utils.logger.FLogger;
import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import java.io.IOException;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class BitmapToVideoEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BitmapToVideoEncoder f313146a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f313147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f313148c;

    static {
        f313146a = new BitmapToVideoEncoder();
    }

    public BitmapToVideoEncoder() {
    }

    public final Object a(int r110, int r210, List<Bitmap> r211, String r212, Integer r213, Integer r214, Integer r215, Continuation<? super Integer> r216) {
        if ((r216 instanceof BitmapToVideoEncoder$startEncoding$1) == false) goto L7;
        BitmapToVideoEncoder$startEncoding$1 r100 = (BitmapToVideoEncoder$startEncoding$1) r216;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L51:
        return Boxing.boxInt(300);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.d("save_music_video", "VideoSRSaverHelper startEncoding, width:" + r110 + ", height:" + r210 + ", bitRate:" + r213 + ", frameRate:" + r214 + ", iFrameInterval:" + r215);
        int r105 = MediaCodecList.getCodecCount();
        int r111 = 0;
    L16:
        if (r111 >= r105) goto L27;
        MediaCodecInfo r112 = MediaCodecList.getCodecInfoAt(r111);
        if (r112.isEncoder() == false) goto L26;
        String[] r106 = r112.getSupportedTypes();
        int r113 = r106.length;
        int r114 = 0;
    L21:
        if (r114 >= r113) goto L26;
        int r115 = r105;
        if (StringsKt.equals(r106[r114], KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE, true) == true) goto L28;
        r114 = r114 + 1;
        r105 = r115;
    L28:
        if (r112 == null) goto L30;
        FLogger.f375446a.d("save_music_video", "Found codec: " + r112.getName());
        MediaCodec r107 = MediaCodec.createEncoderByType(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE);     // Catch: IOException -> L54
        Intrinsics.checkNotNull(r107);
        MediaFormat r108 = MediaFormat.createVideoFormat(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE, r110, r210);
        if (r213 == null) goto L36;
        int r109 = r213.intValue();
    L37:
        r108.setInteger("bitrate", r109);
        if (r214 == null) goto L40;
        int r116 = r214.intValue();
    L41:
        r108.setInteger(com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE, r116);
        r108.setInteger("color-format", 2135033992);
        if (r215 == null) goto L44;
        int r117 = r215.intValue();
    L45:
        r108.setInteger("i-frame-interval", r117);
        r107.configure(r108, null, null, 1);     // Catch: IOException -> L52
        r107.start();     // Catch: IOException -> L52
        MediaMuxer r118 = new MediaMuxer(r212, 0);     // Catch: IOException -> L52
        CoroutineDispatcher r119 = Dispatchers.getIO();
        BitmapToVideoEncoder$startEncoding$2 r120 = new BitmapToVideoEncoder$startEncoding$2(r107, r118, r211, r214, null);
        r100.label = 1;
        if (BuildersKt.withContext(r119, r120, r100) != r103) goto L51;
        return r103;
    L53:
        return Boxing.boxInt(304);
    L44:
        r117 = 10;
        goto L45
    L40:
        r116 = 5;
        goto L41
    L36:
        r109 = 2000000;
    L55:
        return Boxing.boxInt(303);
    L30:
        return Boxing.boxInt(302);
    L26:
        r111 = r111 + 1;
        r105 = r105;
        goto L16
    L27:
        r112 = null;
    L7:
        r100 = new BitmapToVideoEncoder$startEncoding$1(this, r216);
        goto L8
    }
}
