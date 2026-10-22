package bs3;

import com.bytedance.apm.battery.config.BatteryTypeInf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends b {
    public long e;

    public f() {
        super(BatteryTypeInf.BATTERY_CPU_ACTIVE);
        this.e = 0;
    }

    @Override // bs3.l
    public final void a(as3.c r8, ms3.a r9) {
        if (r9.b == false) goto L5;
        r8.e += (long) ((r9.g / com.bytedance.apm.util.b.f()) * 1000.0d);
        return;
    L5:
        r8.n += (long) ((r9.g / com.bytedance.apm.util.b.f()) * 1000.0d);
    }

    @Override // bs3.b
    public final void e(boolean r8, boolean r9) {
        long r0 = com.bytedance.apm.util.b.a();
        long r2 = this.e;
        if (r2 <= 0) goto L9;
        if (r9 == false) goto L9;
        long r3 = r0 - r2;
        if (r3 <= 0) goto L9;
        g(r8, r3, vr3.b.e.a.u);
    L9:
        this.e = r0;
    }
}
