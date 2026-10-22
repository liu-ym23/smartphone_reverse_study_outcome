package ksa;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.cert.manager.utils.CertLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements ksa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f505974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f505975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f505976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ksa.a.InterfaceC6605a f505977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f505978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f505979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f505980g;

    public class a implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f505981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f505982b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f505983c;

        /* JADX INFO: renamed from: ksa.e$a$a, reason: collision with other inner class name */
        public class RunnableC6606a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f505984a;

            @Override // java.lang.Runnable
            public final void run() {
                ksa.a.InterfaceC6605a r100 = this.f505984a.f505983c.f505977d;     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.onStopped();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }

            public RunnableC6606a(a r100) {
                this.f505984a = r100;
            }
        }

        public a(e r100) {
            this.f505983c = r100;
            this.f505981a = false;
            this.f505982b = false;
        }

        public final void a(c r100) {
            CertLog.w("MediaRecorder", " onPrepared:encoder=" + r100);
            if ((r100 instanceof f) == false) goto L8;
            e r101 = this.f505983c;
            r101.f505975b = (f) r100;
            ksa.a.InterfaceC6605a r102 = r101.f505977d;
            if (r102 == null) goto L10;
            r102.onPrepared();
        L10:
            this.f505981a = false;
            this.f505982b = false;
            this.f505983c.f505978e.set(false);
            return;
        L8:
            if ((r100 instanceof b) == false) goto L10;
            this.f505983c.f505976c = (b) r100;
            goto L10
        }

        public final void b(c r100) {
            CertLog.w("MediaRecorder", " onStopped:encoder=" + r100 + " videostop " + this.f505981a + " audiostop " + this.f505982b);
            if ((r100 instanceof f) == false) goto L5;
            this.f505981a = true;
        L7:
            if (this.f505981a == false) goto L14;
            e r101 = this.f505983c;
            if (r101.f505979f == true) goto L11;
        L12:
            r101.f505978e.set(true);
            BytedCertManager.getInstance().executeInMainThread(new RunnableC6606a(this));
            return;
        L11:
            if (this.f505982b == true) goto L12;
            return;
        L14:
            return;
        L5:
            this.f505982b = true;
            goto L7
        }
    }

    public final String c() {
        d r100 = this.f505974a;
        if (r100 != null) goto L21;
        return null;
    L21:
        c r101 = r100.f505972e;     // Catch: IOException -> L17
        if (r101 == null) goto L7;
        r101.f();     // Catch: IOException -> L17
    L7:
        c r102 = r100.f505973f;     // Catch: IOException -> L17
        if (r102 == null) goto L10;
        r102.f();     // Catch: IOException -> L17
    L10:
        d r103 = this.f505974a;     // Catch: IOException -> L17
        c r104 = r103.f505972e;     // Catch: IOException -> L17
        if (r104 == null) goto L13;
        r104.h();     // Catch: IOException -> L17
    L13:
        c r105 = r103.f505973f;     // Catch: IOException -> L17
        if (r105 == null) goto L16;
        r105.h();     // Catch: IOException -> L17
    L16:
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        return e.getMessage();
    }

    public final void d() {
        d r100 = this.f505974a;
        if (r100 == null) goto L29;
        c r101 = r100.f505972e;
        if (r101 == null) goto L21;
        Object r102 = r101.f505956a;
        monitor-enter(r102);
    L18:
        th = move-exception;
        throw th;
    L9:
        if (r101.f505957b == true) goto L11;
    L16:
        monitor-exit(r102);     // Catch: Throwable -> L18
    L26:
        goto L21
    L11:
        if (r101.f505959d == true) goto L16;
        r101.f505959d = true;     // Catch: Throwable -> L18
        r101.f505956a.notifyAll();     // Catch: Throwable -> L18
        monitor-exit(r102);     // Catch: Throwable -> L18
    L21:
        r100.f505972e = null;
        c r103 = r100.f505973f;
        if (r103 == null) goto L24;
        r103.i();
    L24:
        r100.f505973f = null;
        this.f505974a = null;
        return;
    }

    public e() {
        this.f505978e = new AtomicBoolean(true);
        this.f505979f = true;
        this.f505980g = new a(this);
    }

    public final void b(byte[] r100, int r101, long r102) {
        f r103 = this.f505975b;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.d() == false) goto L9;
        this.f505975b.c(ByteBuffer.wrap(r100), r101, r102);
        return;
    }

    public final String a(int r100, int r101, String r102, int r110, boolean r111) {
        d r103 = new d(r102);     // Catch: IOException -> L7
        this.f505974a = r103;     // Catch: IOException -> L7
        new f(r103, this.f505980g, r100, r101, r110);     // Catch: IOException -> L7
        this.f505979f = r111;     // Catch: IOException -> L7
        if (r111 == false) goto L12;
        new b(this.f505974a, this.f505980g);     // Catch: IOException -> L7
        return null;
    L12:
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        return e.getMessage();
    }
}
