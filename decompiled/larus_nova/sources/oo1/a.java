package oo1;

import android.media.MediaCodec;
import android.media.MediaMuxer;
import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends PthreadThreadV2 {
    public final d.a A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public MediaCodec f524514v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final MediaCodec.BufferInfo f524515w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public MediaMuxer f524516x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile boolean f524517y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f524518z;

    public final void l() {
        super.run();
        this.f524517y = false;
        this.f524514v.start();     // Catch: Exception -> L55
    L5:
        if (this.f524517y == false) goto L20;
        ALogger.d("AudioCodecThread", "准备停止mediaMuxer");
        MediaCodec r100 = this.f524514v;
        if (r100 != null) goto L9;
    L11:
        this.f524514v = null;
        e.f524538d.set(true);
        if (e.f524539e.get() == false) goto L20;
        MediaMuxer r101 = this.f524516x;
        if (r101 != null) goto L59;
    L19:
        this.f524516x = null;
        this.A.d(2);
    L22:
        this.A.c("AudioCodecThread", "", 0);
        return;
    L59:
        r101.stop();     // Catch: Exception -> L17
        this.f524516x.release();     // Catch: Exception -> L17
        ALogger.d("AudioCodecThread", "停止mediaMuxer");     // Catch: Exception -> L17
    L17:
        e = move-exception;
        ALogger.e("AudioCodecThread", e.getMessage());
        goto L19
    L9:
        if ((this.f524515w.flags & 4) == 0) goto L11;
        r100.stop();
        this.f524514v.release();
    L20:
        MediaCodec r102 = this.f524514v;
        if (r102 == null) goto L22;
        int r103 = r102.dequeueOutputBuffer(this.f524515w, 0);     // Catch: Exception -> L54
        ALogger.d("AudioCodecThread", "outputBufferIndex : " + r103);
        if (r103 != (-2)) goto L32;
        MediaMuxer r104 = this.f524516x;
        if (r104 == null) goto L32;
        e.f524535a.c(r104.addTrack(this.f524514v.getOutputFormat()));
        if (e.f524536b.b() < 0) goto L5;
        ALogger.d("AudioCodecThread", "start MediaMuxer");
        this.f524516x.start();
        e.f524537c.set(true);
        this.A.d(1);
    L32:
        if (r103 < 0) goto L5;
        if (this.f524517y == true) goto L5;
        if (e.f524537c.get() == false) goto L37;
        ALogger.d("AudioCodecThread", "尝试写入数据");
        ByteBuffer r105 = this.f524514v.getOutputBuffers()[r103];
        r105.position(this.f524515w.offset);
        MediaCodec.BufferInfo r106 = this.f524515w;
        r105.limit(r106.offset + r106.size);
        if (this.f524518z != 0) goto L41;
        this.f524518z = this.f524515w.presentationTimeUs;
    L41:
        MediaCodec.BufferInfo r107 = this.f524515w;
        long r108 = r107.presentationTimeUs - this.f524518z;
        r107.presentationTimeUs = r108;
        e.f524541g.set(r108);
    L46:
        e = move-exception;
        ALogger.e("AudioCodecThread", e.getMessage());
    L48:
        this.f524514v.releaseOutputBuffer(r103, false);
        ALogger.d("AudioCodecThread", "releaseOutputBuffer");
        r103 = this.f524514v.dequeueOutputBuffer(this.f524515w, 0);     // Catch: Exception -> L51
        ALogger.d("AudioCodecThread", "outputBufferIndex : " + r103);
    L51:
        e = move-exception;
        throw new RuntimeException(e);
    L43:
        if (this.f524517y == true) goto L48;
        this.f524516x.writeSampleData(e.f524535a.b(), r105, this.f524515w);     // Catch: Exception -> L46
        goto L48
    L37:
        ALogger.d("AudioCodecThread", "run: 线程延迟");
        SystemClock.sleep(10);
    L55:
        this.A.c("AudioCodecThread", "audioCodec start Fail", -1);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
        l();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(MediaCodec r100, MediaCodec.BufferInfo r101, MediaMuxer r102, f.a r103) {
        super("AudioCodecThread");
        this.f524514v = r100;
        this.f524515w = r101;
        this.f524516x = r102;
        this.A = r103;
        this.f524518z = 0;
        e.f524541g.set(0);
        e.f524535a.c(-1);
    }
}
