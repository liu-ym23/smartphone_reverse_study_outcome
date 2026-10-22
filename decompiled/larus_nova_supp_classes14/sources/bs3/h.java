package bs3;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends b {
    public volatile long e;
    public volatile long f;
    public final ws3.l g;

    public h() {
        super(BatteryTypeInf.BATTERY_PACKETS);
        this.e = -1;
        this.f = -1;
        this.g = ws3.l.a.a;
    }

    public final void j(boolean r10) {
        long r0 = this.g.a.h();
        long r2 = this.g.a.k();
        if (this.f > (-1)) goto L5;
    L8:
        this.e = r0;
        this.f = r2;
        return;
    L5:
        if (this.e <= (-1)) goto L8;
        if (r10 == false) goto L8;
        String r11 = vr3.b.e.a.u;
        g(true, r0 - this.e, r11);
        g(false, r2 - this.f, r11);
        goto L8
    }

    @Override // bs3.l
    public final void a(as3.c r5, ms3.a r6) {
        if (r6.b == false) goto L5;
        r5.j += r6.g;
        return;
    L5:
        r5.s += r6.g;
    }

    @Override // bs3.b
    public final void e(boolean r3, boolean r4) {
        if (this.d == false) goto L14;
        j(r4);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L10;
        ps3.b.a(new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L10:
        EnsureManager.ensureNotReachHere(th, "BatteryPacketsStatsImpl");
        return;
    }
}
