package com.douyin.janna.platform;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.Process;
import android.provider.Settings;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.douyin.janna.api.CapabilityType;
import com.xiaomi.NetworkBoost.MiuiNetworkCallback;
import com.xiaomi.NetworkBoost.NetworkBoostManager;
import com.xiaomi.NetworkBoost.ServiceCallback;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class XMProcessor extends com.douyin.janna.platform.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f273591m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f273592n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public NetworkBoostManager f273593o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public m f273594p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f273595q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MiuiNetworkCallback f273596r;

    public class a implements ServiceCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ XMProcessor f273597a;

        @Override // com.xiaomi.NetworkBoost.ServiceCallback
        public final void onServiceDisconnected() {
        }

        @Override // com.xiaomi.NetworkBoost.ServiceCallback
        public final void onServiceConnected() {
            XMProcessor r100 = this.f273597a;
            r100.f273593o.registerCallback(r100.f273596r);
            boolean r101 = hq7.a.f486512a;
        }

        public a(XMProcessor r100) {
            this.f273597a = r100;
        }
    }

    @Override // com.douyin.janna.platform.a
    public final void f() {
        String r100 = this.f273592n;
        if (r100 != null) goto L5;
    L12:
        String r101 = this.f273592n;
        int r102 = this.f273591m;
        boolean r103 = ((Boolean) v8a.a.f553744a.invoke(v8a.a.f553750g, new Object[]{r101, Integer.valueOf(r102)})).booleanValue();     // Catch: Exception -> L15
    L17:
        boolean r104 = hq7.a.f486512a;
        this.f273600c = r103;
    L19:
        if (this.f273600c == false) goto L21;
        ((HashSet) this.f273605h).add(CapabilityType.SET_FPS);
        ((HashSet) this.f273605h).add(CapabilityType.CANCEL_FPS);
        ((HashSet) this.f273605h).add(CapabilityType.APP_LONG_BOOST);
        ((HashSet) this.f273605h).add(CapabilityType.APP_SHORT_BOOST);
        ((HashSet) this.f273605h).add(CapabilityType.GPU_BOOST);
        ((HashSet) this.f273605h).add(CapabilityType.DDR_BOOST);
        ((HashSet) this.f273605h).add(CapabilityType.SET_IMPORTANT_THREAD);
        g(new fs7.a(0, null));
    L21:
        NetworkBoostManager r105 = new NetworkBoostManager(this.f273598a, this.f273595q);
        this.f273593o = r105;
        r105.bindService();
        return;
    L15:
        e = move-exception;
        e.toString();
        r103 = false;
        goto L17
    L5:
        if (r100.contains("janna") == false) goto L12;
        String r106 = this.f273592n;
        int r107 = this.f273591m;
        Context r108 = this.f273598a;
        boolean r109 = ((Boolean) v8a.a.f553745b.invoke(v8a.a.f553750g, new Object[]{r108, r106, Integer.valueOf(r107), "61E01E3EF56867303A78DAF1DAA92DA1"})).booleanValue();     // Catch: Exception -> L9
    L11:
        boolean r110 = hq7.a.f486512a;
        this.f273600c = r109;
    L9:
        e = move-exception;
        e.toString();
        r109 = false;
        goto L11
    }

    public XMProcessor(Context r100) {
        super(r100);
        this.f273595q = new a(this);
        this.f273596r = new AnonymousClass2(this);
        this.f273591m = Process.myUid();
        this.f273592n = this.f273598a.getPackageName();
        Set<CapabilityType> r101 = this.f273605h;
        HashSet r102 = (HashSet) r101;
        r102.add(CapabilityType.SET_REFRESH_RATE);
    }

    @Override // com.douyin.janna.platform.a
    public final void h(fs7.b r110, List<Integer> r111) {
        super.h(r110, r111);
        if (r111.contains(11) == true) goto L5;
        return;
    L5:
        if (this.f273608k != null) goto L7;
        this.f273608k = (PowerManager) this.f273598a.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
    L7:
        boolean r112 = hq7.a.f486512a;
        if (this.f273608k != null) goto L10;
    L38:
        int r113 = this.f273603f;
        if (r113 != 1) goto L46;
        r110.onEvent(com.douyin.janna.platform.a.a(r113));
        return;
    L46:
        return;
    L10:
        if (this.f273594p != null) goto L38;
        IntentFilter r114 = new IntentFilter("hyper.os.POWER_MODE_LEVEL");
        this.f273594p = new m(this);
        int r100 = 0;
        if (Settings.System.getInt(this.f273598a.getContentResolver(), "power_mode_level", 0) <= 0) goto L14;
        r100 = 1;
    L14:
        this.f273603f = r100;
        Context r101 = this.f273598a;
        m r102 = this.f273594p;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L43;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L43:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L37;
        ReceiverRegisterCrashOptimizer.registerReceiver(r102, r114, "hyper.permission.POWER_MODE_LEVEL", null);
        goto L38
    L37:
        throw e;
    L19:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L21;
    L31:
        r101.registerReceiver(r102, r114, "hyper.permission.POWER_MODE_LEVEL", null);     // Catch: Exception -> L33
    L42:
        goto L38
    L21:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r114) == false) goto L31;
        int r103 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r102, r114, 0, "hyper.permission.POWER_MODE_LEVEL", null, 4, r101).result;     // Catch: Exception -> L33
        if (r103 != 1) goto L25;
        r101.registerReceiver(r102, r114, "hyper.permission.POWER_MODE_LEVEL", null);     // Catch: Exception -> L33
        goto L42
    L25:
        if (r103 != 2) goto L27;
        new Intent();     // Catch: Exception -> L33
        goto L42
    L27:
        if (r103 == 3) goto L42;
        r101.registerReceiver(r102, r114, "hyper.permission.POWER_MODE_LEVEL", null);     // Catch: Exception -> L33
        goto L42
    }

    @Override // com.douyin.janna.platform.a
    public final void i(fs7.b r100, List<Integer> r101) {
        super.i(r100, r101);
    }
}
