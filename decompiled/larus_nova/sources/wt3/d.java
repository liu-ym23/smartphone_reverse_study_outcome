package wt3;

import android.app.Activity;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends uu3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile vt3.d f561204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final uu3.a f561205b;

    public final void b() {
        vt3.d r100 = this.f561204a;
        monitor-enter(r100);
        vt3.f r101 = r100.f557206f;     // Catch: Throwable -> L14
        if (r101 != null) goto L7;
    L12:
        monitor-exit(r100);
        return;
    L7:
        if (r100.f557201a == false) goto L12;
        r101.c();     // Catch: Throwable -> L14
        r100.f557201a = false;     // Catch: Throwable -> L14
        monitor-exit(r100);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public d() {
        uu3.a r100 = (uu3.a) qu3.c.a(uu3.a.class);
        this.f561205b = r100;
        this.f561204a = new vt3.d(r100);
        f r101 = new f(this.f561204a);
        g r102 = new g(this.f561204a);
        h r103 = new h(this.f561204a);
        c r104 = new c(this.f561204a);
        e r105 = new e(this.f561204a);
        vt3.d r106 = this.f561204a;
        if (r106.f557202b == true) goto L8;
        r106.f557208h = r101;
        r106.f557209i = r102;
        r106.f557210j = r103;
        r106.f557211k = r104;
        r106.f557212l = r105;
        r106.f557205e = aq7.b.a(com.bytedance.apm.d.getContext());     // Catch: Throwable -> L10
    L7:
        r106.f557202b = true;
    L8:
        this.f561205b.a(this);
    }

    public final void a(ut3.c r100) {
        vt3.d r101 = this.f561204a;
        monitor-enter(r101);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (r101.f557201a == false) goto L7;
    L20:
        monitor-exit(r101);
        return;
    L7:
        if (r101.f557202b == false) goto L20;
        r101.f557207g = r100;     // Catch: Throwable -> L22
        boolean r102 = true;
        r101.f557201a = true;     // Catch: Throwable -> L22
        String r103 = xu3.e.a(st3.a.b().f543560a.toArray());     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r103) == false) goto L13;
        r103 = "";
    L13:
        vt3.b.f557197a = r103;     // Catch: Throwable -> L22
        if (r101.f557204d.isForeground() == false) goto L17;
        r102 = false;
    L17:
        r101.f557203c = r102;     // Catch: Throwable -> L22
        r101.b();     // Catch: Throwable -> L22
        monitor-exit(r101);
    }

    @Override // uu3.b, uu3.c
    public final void onBackground(Activity r100) {
        vt3.d r101 = this.f561204a;
        monitor-enter(r101);
        vt3.f r102 = r101.f557206f;     // Catch: Throwable -> L19
        if (r102 != null) goto L7;
    L17:
        monitor-exit(r101);
        return;
    L7:
        if (r101.f557201a == false) goto L17;
        if (r101.f557203c != true) goto L14;
        monitor-exit(r101);
        return;
    L14:
        r101.f557203c = true;     // Catch: Throwable -> L19
        r102.a(true);     // Catch: Throwable -> L19
        monitor-exit(r101);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // uu3.b, uu3.c
    public final void onFront(Activity r100) {
        vt3.d r101 = this.f561204a;
        monitor-enter(r101);
        vt3.f r102 = r101.f557206f;     // Catch: Throwable -> L19
        if (r102 != null) goto L7;
    L17:
        monitor-exit(r101);
        return;
    L7:
        if (r101.f557201a == false) goto L17;
        if (r101.f557203c == true) goto L14;
        monitor-exit(r101);
        return;
    L14:
        r101.f557203c = false;     // Catch: Throwable -> L19
        r102.a(false);     // Catch: Throwable -> L19
        monitor-exit(r101);
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
