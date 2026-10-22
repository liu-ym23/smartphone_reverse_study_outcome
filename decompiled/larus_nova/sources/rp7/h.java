package rp7;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes22.dex */
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f538862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f538863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f538864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f538865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f538866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f538867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f538868g;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f538869a;

        public a(h r100) {
            this.f538869a = r100;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f538870a;

        public b(h r100) {
            this.f538870a = r100;
        }
    }

    public final void b() {
        if (this.f538865d.getAndSet(false) == false) goto L6;
        op7.a r100 = (op7.a) this.f538864c;
        r100.getClass();
        r100.f524729a.c(this);
        return;
    }

    public final void a(rp7.a r100) {
        if (this.f538865d.get() == true) goto L5;
        c(new IOException("Session is closed"));
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        i r102 = this.f538863b;
        b r103 = this.f538868g;
        monitor-enter(r102);
        r100.b(r102.f538871a);     // Catch: Throwable -> L12 IOException -> L14
        r102.f538871a.flush();     // Catch: Throwable -> L12 IOException -> L14
        r103.getClass();     // Catch: Throwable -> L12 IOException -> L14
    L16:
        monitor-exit(r102);
        return;
    L12:
        th = move-exception;
        throw th;
    L14:
        e = move-exception;
        r103.f538870a.c(e);     // Catch: Throwable -> L12
        goto L16
    L5:
        r101 = false;
        goto L6
    }

    public final void c(IOException r100) {
        op7.a r101 = (op7.a) this.f538864c;
        r101.getClass();
        r100.getMessage();
        r101.f524729a.c(this);
    }

    public h(pp7.a r100, OutputStream r101, d r102) {
        this.f538865d = new AtomicBoolean(false);
        this.f538867f = new a(this);
        this.f538868g = new b(this);
        this.f538862a = new c(r100);
        this.f538863b = new i(r101);
        this.f538864c = r102;
    }
}
