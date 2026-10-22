package oo1;

import android.media.MediaCodec;
import android.media.MediaMuxer;
import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
public final class h extends PthreadThreadV2 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public MediaCodec f524551v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final MediaCodec.BufferInfo f524552w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public MediaMuxer f524553x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile boolean f524554y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final d.a f524555z;

    public final void l() {
        super.run();
        this.f524554y = false;
        this.f524551v.start();     // Catch: Exception -> L54
    L5:
        if (this.f524554y == false) goto L20;
        MediaCodec r100 = this.f524551v;
        if (r100 != null) goto L9;
    L11:
        this.f524551v = null;
        e.f524539e.set(true);
        if (e.f524538d.get() == false) goto L20;
        MediaMuxer r101 = this.f524553x;
        if (r101 != null) goto L64;
    L19:
        this.f524553x = null;
        this.f524555z.d(2);
    L22:
        this.f524555z.c("VideoCodecThread", "", 0);
        return;
    L64:
        r101.stop();     // Catch: Exception -> L17
        this.f524553x.release();     // Catch: Exception -> L17
    L17:
        e = move-exception;
        ALogger.e("VideoCodecThread", e.getMessage());
        goto L19
    L9:
        if ((this.f524552w.flags & 4) == 0) goto L11;
        r100.stop();
        this.f524551v.release();
    L20:
        MediaCodec r102 = this.f524551v;
        if (r102 == null) goto L22;
        int r103 = r102.dequeueOutputBuffer(this.f524552w, 0);     // Catch: Exception -> L53
        ALogger.d("VideoCodecThread", "outputBufferIndex : " + r103);
        if (r103 != (-2)) goto L32;
        MediaMuxer r104 = this.f524553x;
        if (r104 == null) goto L32;
        e.f524536b.c(r104.addTrack(this.f524551v.getOutputFormat()));
        if (e.f524535a.b() < 0) goto L5;
        ALogger.d("VideoCodecThread", "start MediaMuxer");
        this.f524553x.start();
        e.f524537c.set(true);
        this.f524555z.d(1);
    L32:
        if (r103 < 0) goto L5;
        if (this.f524554y == true) goto L5;
        if (e.f524537c.get() == false) goto L37;
        ByteBuffer r105 = this.f524551v.getOutputBuffers()[r103];
        r105.position(this.f524552w.offset);
        MediaCodec.BufferInfo r106 = this.f524552w;
        r105.limit(r106.offset + r106.size);
        this.f524552w.presentationTimeUs = e.f524541g.get();
    L45:
        e = move-exception;
        ALogger.e("VideoCodecThread", e.getMessage());
    L47:
        this.f524555z.b((int) (this.f524552w.presentationTimeUs / 1000000));
        this.f524551v.releaseOutputBuffer(r103, false);
        ALogger.d("VideoCodecThread", "releaseOutputBuffer");
        r103 = this.f524551v.dequeueOutputBuffer(this.f524552w, 0);     // Catch: Exception -> L50
    L50:
        e = move-exception;
        throw new RuntimeException(e);
    L40:
        if (this.f524554y == true) goto L47;
        MediaMuxer r107 = this.f524553x;     // Catch: Exception -> L45
        if (r107 == null) goto L47;
        r107.writeSampleData(e.f524536b.b(), r105, this.f524552w);     // Catch: Exception -> L45
        goto L47
    L37:
        SystemClock.sleep(10);
    L54:
        this.f524555z.c("VideoCodecThread", "videoCodec start failed", -1);
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

    public h(MediaCodec r100, MediaCodec.BufferInfo r101, MediaMuxer r102, f.a r103) {
        super("VideoCodecThread");
        this.f524551v = r100;
        this.f524552w = r101;
        this.f524553x = r102;
        this.f524555z = r103;
        e.f524536b.c(-1);
    }
}
