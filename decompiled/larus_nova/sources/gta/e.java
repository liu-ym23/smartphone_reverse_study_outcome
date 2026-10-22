package gta;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.applog.k0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile e f482687l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f482688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f482689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f482690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f482691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f482692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f482693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final gta.b f482694g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<g> f482695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f482696i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f482697j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f482698k;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f482699a;

        @Override // java.lang.Runnable
        public final void run() {
            e r100 = this.f482699a;     // Catch: Throwable -> L10
            g r101 = r100.f482692e;     // Catch: Throwable -> L10
            if (r101 != null) goto L5;
            return;
        L5:
            if (r100.f482696i == false) goto L7;
            r100.f482694g.b(r101);     // Catch: Throwable -> L10
        L8:
            e r102 = this.f482699a;     // Catch: Throwable -> L10
            r102.f482692e = null;     // Catch: Throwable -> L10
            r102.f482694g.a();     // Catch: Throwable -> L10
            return;
        L7:
            ((ArrayList) r100.f482695h).add(r101);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public a(e r100) {
            this.f482699a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f482700a;

        public final void a() {
            this.f482700a.f482696i = true;
            Iterator r100 = new ArrayList(this.f482700a.f482695h).iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            g r101 = (g) r100.next();
            this.f482700a.f482694g.b(r101);
            goto L4
        L6:
            ((ArrayList) this.f482700a.f482695h).clear();
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

        public b(e r100) {
            this.f482700a = r100;
        }
    }

    public final Handler b() {
        if (this.f482693f != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f482693f != null) goto L8;
        this.f482693f = new c(this, k0.d().getLooper());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f482693f;
    }

    public e(Context r100) {
        this.f482688a = false;
        this.f482689b = false;
        this.f482690c = true;
        this.f482691d = System.currentTimeMillis();
        this.f482695h = new ArrayList();
        this.f482696i = false;
        this.f482697j = new a(this);
        this.f482698k = new b(this);
        r100.getApplicationContext();
        this.f482694g = new gta.b(r100);
    }

    public static e c(Context r100) {
        if (f482687l != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f482687l != null) goto L9;
        f482687l = new e(r100.getApplicationContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f482687l;
    }

    public static void a(e r100, String r101) {
        Handler r102 = r100.b();
        r102.removeMessages(1);
        r102.sendMessageDelayed(Message.obtain(r102, 1, r101), 5000);
    }
}
