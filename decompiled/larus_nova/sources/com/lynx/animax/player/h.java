package com.lynx.animax.player;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.util.AnimaXLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes32.dex */
public final class h extends com.lynx.animax.player.a implements SurfaceTexture.OnFrameAvailableListener, CodecManager.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f380371j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lock f380372k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Condition f380373l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CodecManager f380374m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Handler f380375n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f380376o;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f380377a;

        @Override // java.lang.Runnable
        public final void run() {
            h r100 = this.f380377a;     // Catch: Throwable -> L4
            CodecManager r101 = new CodecManager(r100);     // Catch: Throwable -> L4
            r100.f380374m = r101;     // Catch: Throwable -> L4
            r101.f380330j = 0;     // Catch: Throwable -> L4
            r101.g();     // Catch: Throwable -> L4
            r101.f380325e = -1;     // Catch: Throwable -> L4
            r101.f380328h = 0;     // Catch: Throwable -> L4
            r101.f380326f = 0;     // Catch: Throwable -> L4
            r101.f380327g = -1;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(h r100) {
            this.f380377a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoAsset f380378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f380379b;

        @Override // java.lang.Runnable
        public final void run() {
            CodecManager r100 = this.f380379b.f380374m;     // Catch: Throwable -> L14
            VideoAsset r101 = this.f380378a;     // Catch: Throwable -> L14
            r100.f380334n = r101;     // Catch: Throwable -> L14
            if (r101 != null) goto L6;
        L19:
            return;
        L6:
            if (r101.b() == true) goto L8;
            AnimaXLog.a("CodecManager", "attachAsset error: prepareFrameBuffer fail, reset mAsset");     // Catch: Throwable -> L14
            r100.f380334n = null;     // Catch: Throwable -> L14
            goto L19
        L8:
            long r102 = (long) r100.f380334n.getFrameRate();     // Catch: Throwable -> L14
            if (r102 > 0) goto L12;
            r102 = 30;
        L12:
            r100.f380332l = 1000000 / r102;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }

        public b(h r100, VideoAsset r101) {
            this.f380379b = r100;
            this.f380378a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f380380a;

        @Override // java.lang.Runnable
        public final void run() {
            h r100 = this.f380380a;     // Catch: Throwable -> L4
            CodecManager r101 = r100.f380374m;     // Catch: Throwable -> L4
            r101.f380335o = r100.f380345c;     // Catch: Throwable -> L4
            r101.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(h r100) {
            this.f380380a = r100;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f380381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f380382b;

        public final void a() {
            CodecManager r100 = this.f380382b.f380374m;
            int r101 = this.f380381a;
            if (r100.f380324d == false) goto L6;
            r100.f380324d = false;
            r100.d();
            r100.b();
        L6:
            if (r100.f380323c == true) goto L9;
            return;
        L9:
            if (r101 == r100.f380325e) goto L123;
            VideoAsset r102 = r100.f380334n;
            if (r102 == null) goto L38;
            int r103 = r102.getPrevKeyFrame(r101);
            if ((-1) != r100.f380327g) goto L17;
            r100.f380328h = 0;
            r100.f380326f = r103;
            goto L38
        L17:
            int r104 = (r101 - r103) + 1;
            int r105 = r100.f380325e;
            if (r105 > r101) goto L20;
            int r110 = r105;
            int r106 = r101;
        L21:
            int r107 = r106 - r110;
            int r111 = r100.f380328h;
            if (r107 > r111) goto L24;
            int r108 = 0;
        L25:
            if (r108 <= r104) goto L38;
            if (r111 > 0) goto L104;
        L36:
            r100.f380326f = r103;
            r100.f380327g = -1;
            goto L38
        L104:
            r100.f380321a.flush();     // Catch: IllegalStateException -> L29 MediaCodec.CodecException -> L31
            String r109 = null;
        L33:
            if (r109 == null) goto L35;
            r100.e(r109);
            r100.f380323c = false;
        L35:
            r100.f380328h = 0;
            goto L36
        L31:
            e = move-exception;
            r109 = "[" + r100.f380322b + "]: flush CodecException: " + e.getMessage();
        L29:
            e = move-exception;
            r109 = "[" + r100.f380322b + "]: flush IllegalStateException: " + e.getMessage();
            goto L33
        L24:
            r108 = r107 - r111;
            goto L25
        L20:
            r106 = r100.f380334n.getFrameCount() + r101;
            r110 = r100.f380325e;
        L38:
            if (r100.f380323c == false) goto L124;
            MediaCodec.BufferInfo r112 = new MediaCodec.BufferInfo();
            int r113 = 3;
        L42:
            if (r100.f380325e == r101) goto L97;
        L44:
            if (r100.c() == true) goto L44;
            if (r100.f380328h == 0) goto L125;
            if (r100.f380327g != r101) goto L51;
            boolean r114 = true;
        L53:
            if (r100.f380334n != null) goto L108;
            CodecManager.ProcessFrameStatus r115 = CodecManager.ProcessFrameStatus.FATAL;
        L88:
            if (CodecManager.ProcessFrameStatus.SUCCESS == r115) goto L42;
            if (CodecManager.ProcessFrameStatus.TRY_AGAIN == r115) goto L42;
            if (CodecManager.ProcessFrameStatus.TRY_AGAIN_IF_NECESSARY != r115) goto L126;
            if (r113 <= 0) goto L127;
            r113 = r113 - 1;
            goto L42
        L127:
            return;
        L126:
            return;
        L108:
            int r116 = r100.f380321a.dequeueOutputBuffer(r112, r100.f380332l);     // Catch: IllegalStateException -> L83 MediaCodec.CodecException -> L85
        L57:
            if ((-3) != r116) goto L60;
            AnimaXLog.b("CodecManager", "output buffers changed");
            r115 = CodecManager.ProcessFrameStatus.TRY_AGAIN;
            goto L88
        L60:
            if ((-2) != r116) goto L70;
            StringBuilder r117 = new StringBuilder("output format changed: ");
            MediaCodec r118 = r100.f380321a;
            if (r118 != null) goto L102;
        L68:
            MediaFormat r119 = null;
        L69:
            r117.append(r119);
            AnimaXLog.b("CodecManager", r117.toString());
            r115 = CodecManager.ProcessFrameStatus.TRY_AGAIN;
            goto L88
        L102:
            r119 = r118.getOutputFormat();     // Catch: IllegalStateException -> L66
        L66:
            e = move-exception;
            AnimaXLog.a("CodecManager", "getOutputFormat failed: " + e.getMessage());
            goto L68
        L70:
            if ((-1) != r116) goto L72;
            r100.f380330j++;
            r100.g();
            r115 = CodecManager.ProcessFrameStatus.TRY_AGAIN_IF_NECESSARY;
            goto L88
        L72:
            if (r116 >= 0) goto L106;
            r100.e("[" + r100.f380322b + "]: outputBufferIndex: " + r116);
            r115 = CodecManager.ProcessFrameStatus.FATAL;
            goto L88
        L106:
            r100.f380321a.releaseOutputBuffer(r116, r114);     // Catch: IllegalStateException -> L76 MediaCodec.CodecException -> L78
            String r120 = null;
        L80:
            if (r120 == null) goto L82;
            r100.e(r120);
        L82:
            r100.f380328h--;
            int r121 = r100.f380327g;
            r100.f380325e = r121;
            r100.f380327g = (r121 + 1) % r100.f380334n.getFrameCount();
            r115 = CodecManager.ProcessFrameStatus.SUCCESS;
            goto L88
        L78:
            e = move-exception;
            r120 = "[" + r100.f380322b + "]: releaseOutputBuffer CodecException: " + e.getMessage();
        L76:
            e = move-exception;
            r120 = "[" + r100.f380322b + "]: releaseOutputBuffer IllegalStateException: " + e.getMessage();
        L85:
            e = move-exception;
            r100.e("[" + r100.f380322b + "]: dequeueOutputBuffer CodecException: " + e.getMessage());
            r115 = CodecManager.ProcessFrameStatus.FATAL;
        L83:
            e = move-exception;
            r100.e("[" + r100.f380322b + "]: dequeueOutputBuffer IllegalStateException: " + e.getMessage());
            r100.f380323c = false;
            r100.f380324d = true;
            r115 = CodecManager.ProcessFrameStatus.FATAL;
            goto L88
        L51:
            r114 = false;
            goto L53
        L125:
            return;
        L97:
            CodecManager.a r122 = r100.f380333m;
            if (r122 == null) goto L100;
            h r123 = (h) r122;
            r123.d(new j(r123));
        L100:
            r100.c();
            return;
        L124:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(h r100, int r101) {
            this.f380382b = r100;
            this.f380381a = r101;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f380383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f380384b;

        @Override // java.lang.Runnable
        public final void run() {
            CodecManager r100 = this.f380384b.f380374m;     // Catch: Throwable -> L7
            if (r100 == null) goto L5;
            r100.f380333m = null;     // Catch: Throwable -> L7
            r100.d();     // Catch: Throwable -> L7
        L5:
            this.f380383a.countDown();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public e(h r100, CountDownLatch r101) {
            this.f380384b = r100;
            this.f380383a = r101;
        }
    }

    @Override // com.lynx.animax.player.a, com.lynx.animax.player.IVideoPlayer
    public final void destroy() {
        if (this.f380376o == false) goto L5;
        return;
    L5:
        this.f380376o = true;
        CountDownLatch r100 = new CountDownLatch(1);
        com.lynx.animax.player.c r101 = com.lynx.animax.player.c.a();
        e r102 = new e(this, r100);
        Handler r103 = r101.f380357b;
        if (r103 != null) goto L8;
        AnimaXLog.a("CodecThreadManager", "Attempted to post to codec thread after it was released or not alive.");
    L16:
        long r104 = this.f380351i.f380370d;     // Catch: InterruptedException -> L13
        AnimaXLog.b("VideoPlayerImpl", "destroy: wait for codec thread to complete destroy tasks with " + r104 + "ms");     // Catch: InterruptedException -> L13
        if (r100.await(r104, TimeUnit.MILLISECONDS) == true) goto L14;
        AnimaXLog.d("VideoPlayerImpl", "Timeout waiting for codec thread to complete destroy tasks");     // Catch: InterruptedException -> L13
    L14:
        super.destroy();
        return;
    L13:
        AnimaXLog.d("VideoPlayerImpl", "Interrupted while waiting for codec thread to complete destroy tasks");
        ThreadMethodProxy.currentThread().interrupt();
        goto L14
    L8:
        r103.postAtFrontOfQueue(r102);
        goto L16
    }

    @Override // com.lynx.animax.player.a, com.lynx.animax.player.IVideoPlayer
    public final void attachAsset(VideoAsset r100) {
        super.attachAsset(r100);
        c(new k(this, new b(this, r100)));
    }

    public final void c(Runnable r100) {
        if (this.f380376o == false) goto L5;
        return;
    L5:
        com.lynx.animax.player.c r101 = com.lynx.animax.player.c.a();
        if (r101.f380357b != null) goto L9;
        AnimaXLog.a("CodecThreadManager", "Attempted to post to codec thread after it was released or not alive.");
        return;
    L9:
        if (Looper.myLooper() != r101.f380357b.getLooper()) goto L11;
        r100.run();
        return;
    L11:
        r101.f380357b.post(r100);
    }

    public final void d(Runnable r100) {
        if (this.f380375n != null) goto L5;
        AnimaXLog.a("VideoPlayerImpl", "Attempted to post to GL thread after it was released or not alive.");
        return;
    L5:
        if (Looper.myLooper() != this.f380375n.getLooper()) goto L7;
        r100.run();
        return;
    L7:
        this.f380375n.post(r100);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture r100) {
        ((ReentrantLock) this.f380372k).lock();
        this.f380371j = true;
        this.f380373l.signalAll();     // Catch: Throwable -> L6
        ((ReentrantLock) this.f380372k).unlock();
        return;
    L6:
        th = move-exception;
        ((ReentrantLock) this.f380372k).unlock();
        throw th;
    }

    @Override // com.lynx.animax.player.a, com.lynx.animax.player.IVideoPlayer
    public final void setSurface(int r100) {
        super.setSurface(r100);
        this.f380371j = false;
        this.f380344b.setOnFrameAvailableListener(this, y4a.d.a());
        if (this.f380343a != null) goto L6;
        AnimaXLog.a("VideoPlayerImpl", "setSurface error: mAsset is null");
        return;
    L6:
        c(new k(this, new c(this)));
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public final boolean updateSurface(int r100) {
        if (this.f380376o == false) goto L5;
        return false;
    L5:
        c(new k(this, new d(this, r100)));
        if (this.f380375n == null) goto L26;
        if (Looper.myLooper() != this.f380375n.getLooper()) goto L26;
        ((ReentrantLock) this.f380372k).lock();
        if (this.f380371j == false) goto L27;
        this.f380371j = false;
        ((ReentrantLock) this.f380372k).unlock();
        boolean r101 = true;
    L21:
        if (r101 == true) goto L23;
        AnimaXLog.a("VideoPlayerImpl", "await onFrameAvailable time out");
        return false;
    L23:
        this.f380344b.updateTexImage();
        return true;
    L27:
        this.f380373l.await(this.f380351i.f380369c, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L13 InterruptedException -> L15
    L17:
        r101 = this.f380371j;
        this.f380371j = false;
        ((ReentrantLock) this.f380372k).unlock();
        goto L21
    L15:
        e = move-exception;
        AnimaXLog.a("VideoPlayerImpl", "await onFrameAvailable error: " + e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.f380371j = false;
        ((ReentrantLock) this.f380372k).unlock();
        throw th;
    L26:
        throw new IllegalStateException("Must be called on GL thread, current: " + ThreadMethodProxy.currentThread().getName());
    }

    public h(long r100, g r101) {
        super(r101);
        ReentrantLock r102 = new ReentrantLock();
        this.f380372k = r102;
        this.f380373l = r102.newCondition();
        this.f380376o = false;
        Looper r103 = Looper.myLooper();
        if (r103 == null) goto L5;
        this.f380375n = new Handler(r103);
    L5:
        c(new a(this));
        g r104 = this.f380351i;
        if (r104.f380369c > 0) goto L9;
        r104.f380369c = 20;
    L9:
        if (r104.f380370d > 0) goto L12;
        r104.f380370d = 1000;
        return;
    }
}
