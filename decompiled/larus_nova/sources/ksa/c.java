package ksa;

import android.media.MediaCodec;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes34.dex */
public abstract class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f505956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f505957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f505958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f505959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f505960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f505961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f505962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MediaCodec f505963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakReference<d> f505964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MediaCodec.BufferInfo f505965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f505966k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f505967l;

    public interface a {
    }

    public abstract void f() throws IOException;

    public void g() {
        this.f505957b = false;
        MediaCodec r100 = this.f505963h;
        if (r100 == null) goto L17;
        r100.stop();     // Catch: Throwable -> L8
        MediaCodec r101 = this.f505963h;     // Catch: Exception -> L44
    L6:
        r101.release();     // Catch: Exception -> L44
        goto L7
    L8:
        th = move-exception;
        CertLog.e("MediaRecorder", "failed releasing MediaCodec", th);     // Catch: Throwable -> L12
        EventLogUtils.onExceptionEvent(th, ErrorConstant.Client.ERROR_VIDEO_ENCODE);     // Catch: Throwable -> L12
        r101 = this.f505963h;     // Catch: Exception -> L44
    L12:
        th = move-exception;
        this.f505963h.release();     // Catch: Exception -> L45
    L14:
        this.f505963h = null;
        throw th;
    L17:
        if (this.f505961f == false) goto L36;
        WeakReference<d> r102 = this.f505964i;
        if (r102 == null) goto L21;
        d r103 = r102.get();
    L22:
        if (r103 == null) goto L36;
        monitor-enter(r103);     // Catch: Throwable -> L30
        int r104 = r103.f505970c - 1;     // Catch: Throwable -> L32
        r103.f505970c = r104;     // Catch: Throwable -> L32
        if (r103.f505969b <= 0) goto L28;
        if (r104 > 0) goto L28;
        r103.f505968a.stop();     // Catch: Throwable -> L32
        r103.f505968a.release();     // Catch: Throwable -> L32
        r103.f505971d = false;     // Catch: Throwable -> L32
    L28:
        monitor-exit(r103);     // Catch: Throwable -> L30
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CertLog.e("MediaRecorder", "failed stopping muxer", th);
        goto L36
    L21:
        r103 = null;
    L36:
        this.f505965j = null;
        a r105 = this.f505966k;     // Catch: Throwable -> L41
        if (r105 == null) goto L59;
        ((e.a) r105).b(this);     // Catch: Throwable -> L41
        return;
    L59:
        return;
    L41:
        th = move-exception;
        CertLog.e("MediaRecorder", "failed onStopped", th);
        return;
    L7:
        this.f505963h = null;
        goto L17
    }

    public final void a() {
        Object r100 = this.f505956a;
        monitor-enter(r100);
        this.f505959d = false;     // Catch: Throwable -> L41
        this.f505958c = 0;     // Catch: Throwable -> L41
        this.f505956a.notify();     // Catch: Throwable -> L41
        monitor-exit(r100);     // Catch: Throwable -> L41
    L7:
        Object r101 = this.f505956a;
        monitor-enter(r101);
        boolean r102 = this.f505959d;     // Catch: Throwable -> L38
        int r103 = this.f505958c;     // Catch: Throwable -> L38
        if (r103 <= 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        this.f505958c = r103 - 1;     // Catch: Throwable -> L38
    L15:
        monitor-exit(r101);     // Catch: Throwable -> L38
        if (r102 == true) goto L17;
        if (r104 == true) goto L19;
        Object r105 = this.f505956a;
        monitor-enter(r105);
        this.f505956a.wait();     // Catch: Throwable -> L25 InterruptedException -> L27
        monitor-exit(r105);     // Catch: Throwable -> L25
        goto L7
    L25:
        th = move-exception;
        throw th;
    L27:
    L28:
        Object r106 = this.f505956a;
        monitor-enter(r106);
        this.f505959d = true;     // Catch: Throwable -> L33
        this.f505957b = false;     // Catch: Throwable -> L33
        monitor-exit(r106);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    L19:
        b();
        goto L7
    L17:
        b();
        c(null, 0, e());
        b();
        g();
        goto L28
    L12:
        r104 = false;
    L38:
        th = move-exception;
        throw th;
    L41:
        th = move-exception;
        throw th;
    }

    public final void b() {
        Object r100 = this.f505956a;
        monitor-enter(r100);
        MediaCodec r101 = this.f505963h;     // Catch: Throwable -> L87
        if (r101 != null) goto L90;
        monitor-exit(r100);     // Catch: Throwable -> L87
        return;
    L90:
        r101.getOutputFormat();     // Catch: Exception -> L83 Throwable -> L87
        monitor-exit(r100);     // Catch: Throwable -> L87
        ByteBuffer[] r102 = this.f505963h.getOutputBuffers();     // Catch: Exception -> L12
    L14:
        d r103 = this.f505964i.get();
        if (r103 != null) goto L18;
        CertLog.w("MediaRecorder", "muxer is unexpectedly null");
        return;
    L18:
        int r104 = 0;
    L20:
        if (this.f505957b == false) goto L134;
        int r105 = this.f505963h.dequeueOutputBuffer(this.f505965j, 10000);     // Catch: Exception -> L80
        if (r105 == (-1)) goto L25;
        if (r105 != (-3)) goto L36;
        r102 = this.f505963h.getOutputBuffers();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        CertLog.e("MediaRecorder", "getOutputBuffers failed: " + CertLog.getStackTraceString(e));
        EventLogUtils.onExceptionEvent(e, ErrorConstant.Client.ERROR_VIDEO_ENCODE);
        goto L20
    L36:
        if (r105 == (-2)) goto L38;
        if (r105 < 0) goto L20;
        if (r102 == null) goto L20;
        ByteBuffer r106 = r102[r105];
        if (r106 == null) goto L79;
        MediaCodec.BufferInfo r107 = this.f505965j;
        if ((r107.flags & 2) == 0) goto L65;
        r107.size = 0;
    L65:
        if (r107.size != 0) goto L67;
    L103:
        this.f505963h.releaseOutputBuffer(r105, false);     // Catch: Exception -> L73
    L76:
        if ((this.f505965j.flags & 4) == 0) goto L20;
        this.f505957b = false;
        return;
    L73:
        e = move-exception;
        CertLog.e("MediaRecorder", "MediaCodec is not running", e);
        goto L76
    L67:
        if (this.f505961f == false) goto L70;
        r107.presentationTimeUs = e();
        r103.d(this.f505962g, r106, this.f505965j);
        this.f505967l = this.f505965j.presentationTimeUs;
        r104 = 0;
        goto L103
    L70:
        throw new RuntimeException("drain:muxer hasn't started");
    L79:
        throw new RuntimeException("encoderOutputBuffer " + r105 + " was null");
    L38:
        if (this.f505961f == true) goto L55;
        this.f505962g = r103.a(this.f505963h.getOutputFormat());
        this.f505961f = true;
        if (r103.c() == true) goto L20;
        monitor-enter(r103);
    L98:
    L51:
        th = move-exception;
        throw th;
    L43:
        if (r103.b() == true) goto L49;
        r103.wait(100);     // Catch: InterruptedException -> L47 Throwable -> L51
    L47:
        return;
    L49:
        monitor-exit(r103);     // Catch: Throwable -> L51
        goto L20
    L55:
        throw new RuntimeException("format changed twice");
    L25:
        if (this.f505960e == true) goto L20;
        r104 = r104 + 1;
        if (r104 <= 5) goto L20;
        return;
    L80:
        e = move-exception;
        e.printStackTrace();
        CertLog.e("MediaRecorder", CertLog.getStackTraceString(e));
        EventLogUtils.onExceptionEvent(e, ErrorConstant.Client.ERROR_VIDEO_ENCODE);
        return;
    L134:
        return;
    L12:
        e = move-exception;
        CertLog.e("MediaRecorder", "getOutputBuffers failed: " + CertLog.getStackTraceString(e));
        EventLogUtils.onExceptionEvent(e, ErrorConstant.Client.ERROR_VIDEO_ENCODE);
        r102 = null;
        goto L14
    L83:
        e = move-exception;
        CertLog.e("MediaRecorder", "MediaCodec is not running", e);     // Catch: Throwable -> L87
        return;
    L87:
        th = move-exception;
        throw th;
    }

    public final boolean d() {
        Object r100 = this.f505956a;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f505957b == true) goto L7;
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L15
        return false;
    L7:
        if (this.f505959d == true) goto L12;
        this.f505958c++;     // Catch: Throwable -> L15
        this.f505956a.notifyAll();     // Catch: Throwable -> L15
        monitor-exit(r100);     // Catch: Throwable -> L15
        return true;
    }

    public void h() {
        Object r100 = this.f505956a;
        monitor-enter(r100);
        this.f505957b = true;     // Catch: Throwable -> L8
        this.f505959d = false;     // Catch: Throwable -> L8
        this.f505956a.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void i() {
        Object r100 = this.f505956a;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f505957b == true) goto L7;
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.f505959d == true) goto L12;
        this.f505959d = true;     // Catch: Throwable -> L14
        this.f505956a.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
    }

    public final long e() {
        long r100 = System.nanoTime() / 1000;
        long r101 = this.f505967l;
        if (r100 < r101) goto L5;
        return r100;
    L5:
        return r100 + (r101 - r100);
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

    public c(d r100, e.a r101) {
        Object r102 = new Object();
        this.f505956a = r102;
        this.f505967l = 0;
        if (r101 == null) goto L41;
        if (r100 == null) goto L39;
        this.f505964i = new WeakReference(r100);
        if ((this instanceof f) == false) goto L13;
        if (r100.f505972e != null) goto L11;
        r100.f505972e = this;
    L17:
        int r103 = 1;
        if (r100.f505972e == null) goto L20;
        int r104 = 1;
    L22:
        if (r100.f505973f != null) goto L25;
        r103 = 0;
    L25:
        r100.f505969b = r104 + r103;
        this.f505966k = r101;
        monitor-enter(r102);
        this.f505965j = new MediaCodec.BufferInfo();     // Catch: Throwable -> L31
        ThreadMethodProxy.start(new PthreadThreadV2(this, getClass().getSimpleName()));     // Catch: Throwable -> L31
        r102.wait();     // Catch: InterruptedException -> L42 Throwable -> L31
    L29:
        monitor-exit(r102);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        throw th;
    L20:
        r104 = 0;
        goto L22
    L11:
        throw new IllegalArgumentException("Video encoder already added.");
    L13:
        if ((this instanceof b) == false) goto L37;
        if (r100.f505973f != null) goto L35;
        r100.f505973f = this;
        goto L17
    L35:
        throw new IllegalArgumentException("Video encoder already added.");
    L37:
        throw new IllegalArgumentException("unsupported encoder");
    L39:
        throw new NullPointerException("MediaMuxerWrapper is null");
    L41:
        throw new NullPointerException("MediaEncoderListener is null");
    }

    public void c(ByteBuffer r110, int r111, long r112) {
        if (this.f505957b == true) goto L5;
        return;
    L5:
        Object r100 = this.f505956a;
        monitor-enter(r100);
    L40:
        th = move-exception;
        throw th;
    L8:
        if (this.f505959d == false) goto L12;
        CertLog.e("MediaRecorder", "stopping, cancel encode");     // Catch: Throwable -> L40
        monitor-exit(r100);     // Catch: Throwable -> L40
        return;
    L12:
        MediaCodec r101 = this.f505963h;     // Catch: Throwable -> L40
        if (r101 != null) goto L43;
        CertLog.e("MediaRecorder", "mMediaCodec is null, cannot get input buffers");     // Catch: Throwable -> L40
        monitor-exit(r100);     // Catch: Throwable -> L40
        return;
    L43:
        ByteBuffer[] r102 = r101.getInputBuffers();     // Catch: IllegalStateException -> L36 Throwable -> L40
        monitor-exit(r100);     // Catch: Throwable -> L40
    L20:
        if (this.f505957b == false) goto L56;
        int r103 = this.f505963h.dequeueInputBuffer(10000);     // Catch: Exception -> L33
        if (r103 < 0) goto L20;
        ByteBuffer r104 = r102[r103];
        r104.clear();
        if (r110 == null) goto L46;
        r104.put(r110);
    L46:
        if (r111 <= 0) goto L28;
        this.f505963h.queueInputBuffer(r103, 0, r111, r112, 0);     // Catch: Exception -> L31
    L45:
        return;
    L28:
        this.f505960e = true;     // Catch: Exception -> L31
        this.f505963h.queueInputBuffer(r103, 0, 0, r112, 4);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
        EventLogUtils.onExceptionEvent(e, ErrorConstant.Client.ERROR_VIDEO_ENCODE);
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        EventLogUtils.onExceptionEvent(e, ErrorConstant.Client.ERROR_VIDEO_ENCODE);
        return;
    L56:
        return;
    L36:
        e = move-exception;
        CertLog.e("MediaRecorder", "getInputBuffers failed: " + CertLog.getStackTraceString(e));     // Catch: Throwable -> L40
        EventLogUtils.onExceptionEvent(e, ErrorConstant.Client.ERROR_VIDEO_ENCODE);     // Catch: Throwable -> L40
    }
}
