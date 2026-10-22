package bs3;

import com.bytedance.apm.core.ActivityLifeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class b implements l {
    public volatile boolean a;
    public volatile boolean b;
    public final String c;
    public final boolean d;

    public abstract void e(boolean r1, boolean r2);

    public b(String r1) {
        this.c = r1;
        this.d = com.bytedance.apm.d.k();
        this.a = ActivityLifeObserver.getInstance().isForeground();
        this.b = ds3.a.c(com.bytedance.apm.d.getContext());
    }

    @Override // bs3.l
    public final void b(boolean r2) {
        e(this.a, r2);
    }

    @Override // bs3.l
    public final void d(boolean r2) {
        e(this.a, r2);
    }

    @Override // bs3.l
    public final void f(boolean r2) {
        e(this.a, r2);
        this.a = false;
    }

    @Override // bs3.l
    public final void h(boolean r2) {
        e(this.a, r2);
        this.a = true;
    }

    @Override // bs3.l
    public final void i(boolean r2) {
        e(this.a, r2);
    }

    @Override // bs3.l
    public final void c(boolean r2, boolean r3) {
        e(this.a, r3);
        this.b = r2;
    }

    public final void g(boolean r11, long r12, String r14) {
        if (r12 < 0) goto L5;
        as3.b.a.a.g(new ms3.a(r11, System.currentTimeMillis(), this.c, this.b, r12, r14));
        return;
    L5:
        if (com.bytedance.apm.d.j() == false) goto L8;
        ps3.b.a(new String[]{"AbsBatteryValueStats value error: " + r12 + " type:" + this.c});
    }
}
