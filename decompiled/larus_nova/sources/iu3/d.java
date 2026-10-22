package iu3;

import android.app.Activity;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f495774h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f495775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ku3.a f495776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f495777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f495778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f495779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f495780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<lu3.a> f495781g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f495782a = null;

        static {
            f495782a = new d();
        }
    }

    public class b extends uu3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f495783a;

        public b(d r100) {
            this.f495783a = r100;
        }

        @Override // uu3.b, uu3.c
        public final void onBackground(Activity r100) {
            boolean r101 = true;
            if (xu3.a.a() == false) goto L11;
            StringBuilder r102 = new StringBuilder("isStopWhenBackground:");
            ku3.a r103 = this.f495783a.f495776b;
            if (r103 != null) goto L7;
        L9:
            boolean r104 = false;
        L10:
            r102.append(r104);
            av3.b.a("APM-Memory", r102.toString());
            goto L11
        L7:
            if (r103.f506205c == false) goto L9;
            r104 = true;
        L11:
            d r105 = this.f495783a;
            ku3.a r106 = r105.f495776b;
            if (r106 != null) goto L14;
        L16:
            r101 = false;
        L17:
            if (r101 == false) goto L20;
            r105.b();
            return;
        L20:
            return;
        L14:
            if (r106.f506205c == false) goto L16;
            goto L16
        }

        @Override // uu3.b, uu3.c
        public final void onFront(Activity r100) {
            boolean r101 = true;
            if (xu3.a.a() == false) goto L11;
            StringBuilder r102 = new StringBuilder("isStopWhenBackground:");
            ku3.a r103 = this.f495783a.f495776b;
            if (r103 != null) goto L7;
        L9:
            boolean r104 = false;
        L10:
            r102.append(r104);
            av3.b.a("APM-Memory", r102.toString());
            goto L11
        L7:
            if (r103.f506205c == false) goto L9;
            r104 = true;
        L11:
            d r105 = this.f495783a;
            ku3.a r106 = r105.f495776b;
            if (r106 != null) goto L14;
        L16:
            r101 = false;
        L17:
            if (r101 == false) goto L20;
            r105.a();
            return;
        L20:
            return;
        L14:
            if (r106.f506205c == false) goto L16;
            goto L16
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f495778d == true) goto L14;
        this.f495778d = true;     // Catch: Throwable -> L16
        if (xu3.a.a() == false) goto L9;
        av3.b.a("APM-Memory", "start");     // Catch: Throwable -> L16
    L9:
        if (this.f495777c != null) goto L14;
        if (xu3.a.a() == false) goto L13;
        av3.b.a("APM-Memory", "scheduleCollectMemory");     // Catch: Throwable -> L16
    L13:
        this.f495777c = new c(this, this.f495779e);     // Catch: Throwable -> L16
        cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(this.f495777c);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
    }

    public final synchronized void b() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f495778d == false) goto L11;
        this.f495778d = false;     // Catch: Throwable -> L13
        if (xu3.a.a() == false) goto L9;
        av3.b.a("APM-Memory", "cancelCollectMemory");     // Catch: Throwable -> L13
    L9:
        if (this.f495777c == null) goto L11;
        cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(this.f495777c);     // Catch: Throwable -> L13
        this.f495777c = null;     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
    }

    public d() {
        this.f495779e = 0;
        this.f495780f = new b(this);
        this.f495781g = new CopyOnWriteArrayList();
    }

    static {
    }

    public final synchronized void c(ku3.a r100) {
        monitor-enter(this);
        if (r100 != null) goto L48;
        monitor-exit(this);
        return;
    L48:
        this.f495776b = r100;     // Catch: Throwable -> L45
        if (xu3.a.a() == false) goto L11;
        av3.b.a("APM-Memory", "updateConfig: " + r100);     // Catch: Throwable -> L45
    L11:
        if (r100.f506208f == true) goto L20;
        b();     // Catch: Throwable -> L45
        uu3.a r101 = (uu3.a) qu3.c.a(uu3.a.class);     // Catch: Throwable -> L45
        if (r101 == null) goto L16;
        r101.b(this.f495780f);     // Catch: Throwable -> L45
    L16:
        if (xu3.a.a() == false) goto L18;
        av3.b.a("APM-Memory", "isApm6SampleEnable: " + r100.f506208f);     // Catch: Throwable -> L45
    L18:
        monitor-exit(this);
        return;
    L20:
        uu3.a r102 = (uu3.a) qu3.c.a(uu3.a.class);     // Catch: Throwable -> L45
        if (r102 != null) goto L23;
    L26:
        long r103 = r100.f506203a * 1000;     // Catch: Throwable -> L45
        this.f495779e = r103;     // Catch: Throwable -> L45
        if (r103 >= 30000) goto L33;
        if (xu3.a.a() == false) goto L31;
        av3.b.a("APM-Memory", "pollingIntervalMillis: " + this.f495779e);     // Catch: Throwable -> L45
    L31:
        this.f495779e = 30000;     // Catch: Throwable -> L45
    L33:
        if (xu3.a.a() == false) goto L35;
        av3.b.a("APM-Memory", "result pollingIntervalMillis: " + this.f495779e);     // Catch: Throwable -> L45
    L35:
        c r104 = this.f495777c;     // Catch: Throwable -> L45
        if (r104 != null) goto L38;
    L40:
        a();     // Catch: Throwable -> L45
        iu3.b r105 = (iu3.b) qu3.c.a(iu3.b.class);     // Catch: Throwable -> L45
        if (r105 == null) goto L43;
        r105.start();     // Catch: Throwable -> L45
    L43:
        monitor-exit(this);
        return;
    L38:
        if (r104.f465485c == this.f495779e) goto L40;
        b();     // Catch: Throwable -> L45
        goto L40
    L23:
        if (r100.f506205c == false) goto L25;
        r102.b(this.f495780f);     // Catch: Throwable -> L45
        r102.a(this.f495780f);     // Catch: Throwable -> L45
        goto L26
    L25:
        r102.b(this.f495780f);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }
}
