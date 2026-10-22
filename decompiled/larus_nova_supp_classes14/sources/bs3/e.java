package bs3;

import android.os.BatteryManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends b {
    public final BatteryManager e;
    public boolean f;
    public int g;

    public e() {
        super(BatteryTypeInf.BATTERY_CONSUME);
        this.f = false;
        this.g = -1;
        this.e = (BatteryManager) com.bytedance.apm.d.getContext().getSystemService("batterymanager");
    }

    @Override // bs3.l
    public final void a(as3.c r5, ms3.a r6) {
        r5.m += r6.g / 1000;
    }

    @Override // bs3.b
    public final void e(boolean r5, boolean r6) {
        if (this.d == true) goto L6;
        return;
    L6:
        if (r5 == true) goto L27;
    L13:
        boolean r7 = true;
    L14:
        int r2 = this.e.getIntProperty(1);     // Catch: Throwable -> L11
        if (r7 == true) goto L20;
        if (r6 == false) goto L20;
        if (this.f == false) goto L20;
        g(true, Math.abs(r2 - this.g), vr3.b.e.a.u);     // Catch: Throwable -> L11
    L20:
        this.g = r2;     // Catch: Throwable -> L11
        this.f = true;     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L25;
        ps3.b.a(new String[]{"BatteryConsumeStatsImpl error: " + th.getCause()});
    L25:
        EnsureManager.ensureNotReachHere("BatteryConsumeStatsImpl");
        return;
    L27:
        if (this.b == true) goto L13;
        r7 = false;
        goto L14
    }
}
