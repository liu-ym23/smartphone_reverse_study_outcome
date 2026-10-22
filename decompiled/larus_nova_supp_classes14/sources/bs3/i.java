package bs3;

import android.app.usage.NetworkStatsManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends b {
    public long[] e;
    public Method f;
    public Object g;
    public boolean h;

    public i() {
        super(BatteryTypeInf.BATTERY_NET_ALL_INTERFACE);
        this.h = false;
    }

    public final long[] j() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (this.f != null) goto L10;
        NetworkStatsManager r0 = (NetworkStatsManager) com.bytedance.apm.d.getContext().getSystemService("netstats");
        Field r3 = r0.getClass().getDeclaredField("mService");
        r3.setAccessible(true);
        Object r1 = r3.get(r0);
        this.g = r1;
        Method[] r2 = r1.getClass().getDeclaredMethods();
        int r4 = r2.length;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L10;
        Method r6 = r2[r5];
        if (TextUtils.equals("getDataLayerSnapshotForUid", r6.getName()) == true) goto L8;
        r5 = r5 + 1;
        goto L5
    L8:
        this.f = r6;
        r6.setAccessible(true);
    L10:
        Object r7 = this.f.invoke(this.g, new Object[]{Integer.valueOf(Process.myUid())});
        Field r8 = r7.getClass().getDeclaredField("rxBytes");
        r8.setAccessible(true);
        long[] r9 = (long[]) r8.get(r7);
        Field r10 = r7.getClass().getDeclaredField("txBytes");
        r10.setAccessible(true);
        long[] r11 = (long[]) r10.get(r7);
        Field r12 = r7.getClass().getDeclaredField("rxPackets");
        r12.setAccessible(true);
        long[] r13 = (long[]) r12.get(r7);
        Field r14 = r7.getClass().getDeclaredField("txPackets");
        r14.setAccessible(true);
        return new long[]{l(r9) + l(r11), l(r13) + l((long[]) r14.get(r7))};
    }

    public static long l(long[] r6) {
        long r0 = 0;
        if (r6 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r6.length == 0) goto L10;
        int r2 = r6.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L10;
        r0 = r0 + r6[r3];
        r3 = r3 + 1;
        goto L8
    }

    @Override // bs3.l
    public final void a(as3.c r5, ms3.a r6) {
        if (r6.b == false) goto L11;
        if (TextUtils.equals(r6.h, "source_bytes") == false) goto L8;
        r5.k += r6.g;
        return;
    L8:
        if (TextUtils.equals(r6.h, "source_packets") == false) goto L18;
        r5.l += r6.g;
        return;
    L18:
        return;
    L11:
        if (TextUtils.equals(r6.h, "source_bytes") == false) goto L14;
        r5.t += r6.g;
        return;
    L14:
        if (TextUtils.equals(r6.h, "source_packets") == false) goto L21;
        r5.u += r6.g;
        return;
    }

    @Override // bs3.b
    public final void e(boolean r11, boolean r12) {
        if (this.d == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L21;
        return;
    L21:
        long[] r2 = j();     // Catch: Throwable -> L13
        long[] r3 = this.e;     // Catch: Throwable -> L13
        if (r3 == null) goto L11;
        if (r12 == false) goto L11;
        String r13 = vr3.b.e.a.u;     // Catch: Throwable -> L13
        k(r11, r2[0] - r3[0], "source_bytes", r13);     // Catch: Throwable -> L13
        k(r11, r2[1] - this.e[1], "source_packets", r13);     // Catch: Throwable -> L13
    L11:
        this.e = r2;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L18;
        ps3.b.a(new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L18:
        if (this.h == true) goto L25;
        EnsureManager.ensureNotReachHere(th, "BatteryTrafficAllInterface");
        this.h = true;
        return;
    }

    public final void k(boolean r13, long r14, String r16, String r17) {
        if (r14 < 0) goto L5;
        as3.b.a.a.g(new ms3.a(r13, System.currentTimeMillis(), BatteryTypeInf.BATTERY_NET_ALL_INTERFACE, this.b, r14, r17, r16));
        return;
    L5:
        if (com.bytedance.apm.d.j() == false) goto L8;
        ps3.b.a(new String[]{"BatteryTrafficAllInterface value error: " + r14});
    }
}
