package xg4;

import android.os.Build;
import android.os.Process;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static volatile boolean D;
    public boolean A;
    public final AtomicBoolean B;
    public final AtomicBoolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f563612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f563613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f563614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f563615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f563616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f563617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f563618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f563619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f563620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f563621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f563622k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f563623l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f563624m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicBoolean f563625n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f563626o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f563627p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicBoolean f563628q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f563629r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f563630s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicBoolean f563631t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicBoolean f563632u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicBoolean f563633v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AtomicBoolean f563634w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicBoolean f563635x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AtomicBoolean f563636y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AtomicBoolean f563637z;

    /* JADX INFO: loaded from: classes15.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f563638a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            ch4.c.a("dumpLooperMessages", th);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        L18:
            return;
        L3:
            if (this.f563638a.f563623l.compareAndSet(false, true) == false) goto L12;
            ih4.c.f489850c.c(this.f563638a.f563612a);     // Catch: Throwable -> L6
            return;
        }

        public a(b r100) {
            this.f563638a = r100;
        }
    }

    /* JADX INFO: renamed from: xg4.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes15.dex */
    public static class C8232b {
        public static void a(File r100, int r101) {
            dh4.f r102 = new dh4.f(r100.getAbsolutePath() + "/anr_config.txt");
            r102.j();
            r102.h("oom_adj");
            r102.b(r101);
            r102.i();
            r102.h("enable_upload_bg_anr");
            r102.f(false);
            r102.i();
            r102.h("enable_new_anr");
            r102.f(com.bytedance.crash.k.f203232b);
            if (Build.VERSION.SDK_INT < 24) goto L5;
            long r103 = com.bytedance.crash.i.a().f203225e - Process.getStartElapsedRealtime();
            r102.i();
            r102.h("init_sub_launch_time");
            r102.c(r103);
        L5:
            r102.k();
            r102.g();
        }
    }

    public final void finalize() {
        NativeBridge.d(this.f563615d);
    }

    public final void a(boolean r100) {
        if (r100 == false) goto L11;
        wh4.b.post(new a(this));
        return;
    L11:
    L8:
        th = move-exception;
        ch4.c.a("dumpLooperMessages", th);
        return;
    L5:
        if (this.f563623l.compareAndSet(false, true) == false) goto L14;
        ih4.c.f489850c.c(this.f563612a);     // Catch: Throwable -> L8
        return;
    }

    public b(PolarisFileWrapper r100, long r101, boolean r102) {
        this.f563616e = new AtomicBoolean(false);
        this.f563617f = new AtomicBoolean(false);
        this.f563618g = new AtomicBoolean(false);
        this.f563619h = new AtomicBoolean(false);
        this.f563620i = new AtomicBoolean(false);
        this.f563621j = new AtomicBoolean(false);
        this.f563622k = new AtomicBoolean(false);
        this.f563623l = new AtomicBoolean(false);
        this.f563624m = new AtomicBoolean(false);
        this.f563625n = new AtomicBoolean(false);
        this.f563626o = new AtomicBoolean(false);
        this.f563627p = new AtomicBoolean(false);
        this.f563628q = new AtomicBoolean(false);
        this.f563629r = new AtomicBoolean(false);
        this.f563630s = new AtomicBoolean(false);
        this.f563631t = new AtomicBoolean(false);
        this.f563632u = new AtomicBoolean(false);
        this.f563633v = new AtomicBoolean(false);
        this.f563634w = new AtomicBoolean(false);
        this.f563635x = new AtomicBoolean(false);
        this.f563636y = new AtomicBoolean(false);
        this.f563637z = new AtomicBoolean(false);
        this.A = false;
        this.B = new AtomicBoolean(false);
        this.C = new AtomicBoolean(false);
        this.f563612a = r100;
        this.f563613b = r101;
        this.f563614c = r102;
        this.f563615d = NativeBridge.f(r100.getAbsolutePath());
    }
}
