package com.douyin.janna.platform;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.douyin.janna.api.CapabilityType;
import com.hihonor.mcs.system.diagnosis.core.powerthermal.PowerThermal;
import com.hihonor.mcs.system.diagnosis.core.powerthermal.PowerThermalMetric;
import com.hihonor.mcs.system.diagnosis.core.powerthermal.PowerThermalPayload;
import com.hihonor.mcs.system.diagnosis.core.pressure.CpuWatchPoint;
import com.hihonor.mcs.system.diagnosis.core.pressure.IoWatchPoint;
import com.hihonor.mcs.system.diagnosis.core.pressure.MemoryWatchPoint;
import com.hihonor.mcs.system.diagnosis.core.pressure.PressureCallback;
import com.hihonor.mcs.system.diagnosis.core.pressure.PressurePayload;
import com.hihonor.mcs.system.diagnosis.core.pressure.Resource;
import com.hihonor.mcs.system.diagnosis.core.pressure.TemperatureWatchPoint;
import com.hihonor.mcs.system.diagnosis.core.stability.KilledMetric;
import com.hihonor.mcs.system.diagnosis.core.stability.Stability;
import com.hihonor.mcs.system.diagnosis.core.stability.StabilityPayload;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class HONORProcessor extends a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f273567m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PowerCallbackImpl f273568n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SystemPressureCallbackImpl f273569o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public StabilityCallbackImpl f273570p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f273571q;

    public class PowerCallbackImpl implements tw7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f273572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<PowerThermalMetric.PowerType, Integer> f273573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HONORProcessor f273574c;

        public PowerCallbackImpl(HONORProcessor r100) {
            this.f273574c = r100;
            this.f273572a = false;
            this.f273573b = new AnonymousClass1(this);
        }

        @Override // tw7.a
        public final void a(PowerThermalPayload r100) {
            List<PowerThermalMetric> r101 = r100.getPowerThermalMetrics();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.size() == 0) goto L21;
            Iterator<PowerThermalMetric> r102 = r101.iterator();
        L8:
            if (r102.hasNext() == false) goto L22;
            PowerThermalMetric r103 = r102.next();
            if (r103 == null) goto L12;
            Bundle r104 = new Bundle();
            Map<PowerThermalMetric.PowerType, Integer> r105 = this.f273573b;
            HashMap r106 = (HashMap) r105;
            r104.putInt("abnormal_type", ((Integer) r106.get(r103.getPowerType())).intValue());
            fs7.a r107 = new fs7.a(10, r104);
        L13:
            if (r107 == null) goto L8;
            this.f273574c.g(r107);
            goto L8
        L12:
            r107 = null;
            goto L13
        L22:
            return;
        }
    }

    public class StabilityCallbackImpl implements uw7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f273575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<KilledMetric.KilledType, Integer> f273576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HONORProcessor f273577c;

        public StabilityCallbackImpl(HONORProcessor r100) {
            this.f273577c = r100;
            this.f273575a = false;
            this.f273576b = new AnonymousClass1(this);
        }

        public final void a(StabilityPayload r100) {
            List<KilledMetric> r101 = r100.getKilledMetrics();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.size() == 0) goto L21;
            Iterator<KilledMetric> r102 = r101.iterator();
        L8:
            if (r102.hasNext() == false) goto L22;
            KilledMetric r103 = r102.next();
            if (r103 == null) goto L12;
            Bundle r104 = new Bundle();
            r104.putInt("stable_type", 4);
            r104.putInt("reason", this.f273576b.get(r103.getType()).intValue());
            fs7.a r105 = new fs7.a(40, r104);
        L13:
            if (r105 == null) goto L8;
            this.f273577c.g(r105);
            goto L8
        L12:
            r105 = null;
            goto L13
        L22:
            return;
        }
    }

    public class SystemPressureCallbackImpl implements PressureCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f273578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<MemoryWatchPoint.MemoryStatus, Integer> f273579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HashMap<TemperatureWatchPoint.TemperatureStatus, Integer> f273580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final HashMap<CpuWatchPoint.CpuStatus, Integer> f273581d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final HashMap<IoWatchPoint.IoStatus, Integer> f273582e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ HONORProcessor f273583f;

        public final void a() {
            if (this.f273578a == false) goto L6;
            boolean r100 = hq7.a.f486512a;
            return;
        L6:
            Resource r101 = new Resource.Builder().withKind(Resource.Kind.RESOURCE_TEMPERATURE).withKind(Resource.Kind.RESOURCE_CPU).withKind(Resource.Kind.RESOURCE_MEMORY).withKind(Resource.Kind.RESOURCE_IO).build();
            vw7.b r102 = vw7.b.a(this.f273583f.f273598a);
            r102.b(r101, this, this.f273583f.f273599b);     // Catch: RuntimeException -> L9
            boolean r103 = hq7.a.f486512a;     // Catch: RuntimeException -> L9
            this.f273578a = true;     // Catch: RuntimeException -> L9
            return;
        L9:
            e = move-exception;
            e.getMessage();
            boolean r104 = hq7.a.f486512a;
        }

        public final void b() {
            if (this.f273578a == true) goto L11;
            boolean r100 = hq7.a.f486512a;
        L11:
            vw7.b.a(this.f273583f.f273598a).c(this);     // Catch: RuntimeException -> L8
            boolean r101 = hq7.a.f486512a;     // Catch: RuntimeException -> L8
            return;
        L8:
            e = move-exception;
            e.getMessage();
            boolean r102 = hq7.a.f486512a;
        }

        public SystemPressureCallbackImpl(HONORProcessor r100) {
            this.f273583f = r100;
            this.f273578a = false;
            this.f273579b = new AnonymousClass1(this);
            this.f273580c = new AnonymousClass2(this);
            this.f273581d = new AnonymousClass3(this);
            this.f273582e = new AnonymousClass4(this);
        }

        @Override // com.hihonor.mcs.system.diagnosis.core.pressure.PressureCallback
        public final void onPressureReported(PressurePayload r100) {
            MemoryWatchPoint r101 = r100.getMemoryWatchPoint();
            if (r101 != null) goto L5;
        L7:
            TemperatureWatchPoint r102 = r100.getTemperatureWatchPoint();
            if (r102 != null) goto L10;
        L12:
            CpuWatchPoint r103 = r100.getCpuWatchPoint();
            if (r103 != null) goto L15;
        L17:
            IoWatchPoint r104 = r100.getIoWatchPoint();
            if (r104 != null) goto L20;
            return;
        L20:
            if (r104.getIoStatus() == null) goto L24;
            Bundle r105 = new Bundle();
            r105.putInt("system_watch_point", 1);
            r105.putInt("status", this.f273582e.get(r104.getIoStatus()).intValue());
            fs7.a r106 = new fs7.a(30, r105);
            this.f273583f.g(r106);
            return;
        L24:
            return;
        L15:
            if (r103.getCpuStatus() == null) goto L17;
            Bundle r107 = new Bundle();
            r107.putInt("system_watch_point", 0);
            r107.putInt("status", this.f273581d.get(r103.getCpuStatus()).intValue());
            fs7.a r108 = new fs7.a(30, r107);
            this.f273583f.g(r108);
            goto L17
        L10:
            if (r102.getTemperatureStatus() == null) goto L12;
            Bundle r109 = new Bundle();
            r109.putInt("thermal_status", this.f273580c.get(r102.getTemperatureStatus()).intValue());
            fs7.a r110 = new fs7.a(1, r109);
            this.f273583f.g(r110);
            goto L12
        L5:
            if (r101.getMemoryStatus() == null) goto L7;
            Bundle r111 = new Bundle();
            r111.putInt("system_watch_point", 2);
            r111.putInt("status", this.f273579b.get(r101.getMemoryStatus()).intValue());
            fs7.a r112 = new fs7.a(30, r111);
            this.f273583f.g(r112);
            goto L7
        }
    }

    public HONORProcessor(Context r100) {
        super(r100);
        this.f273567m = false;
        this.f273568n = null;
        this.f273569o = null;
        this.f273570p = null;
        PackageManager r101 = this.f273598a.getPackageManager();
        Intent r102 = new Intent();
        r102.setComponent(new ComponentName("com.hihonor.hiview", "com.hihonor.mcs.system.diagnosis.service.DiagKitService"));
        if (r101.queryIntentServices(r102, 0).size() == 0) goto L5;
        boolean r103 = true;
    L6:
        this.f273567m = r103;
        if (gs7.c.c("magic.config.support_low_framerate", 0) != 1) goto L9;
        Set<CapabilityType> r104 = this.f273605h;
        HashSet r105 = (HashSet) r104;
        r105.add(CapabilityType.SET_FPS);
        Set<CapabilityType> r106 = this.f273605h;
        HashSet r107 = (HashSet) r106;
        r107.add(CapabilityType.SET_REFRESH_RATE);
    L9:
        boolean r108 = hq7.a.f486512a;
        if (r103 == false) goto L13;
        if (r103 == false) goto L13;
        Set<CapabilityType> r109 = this.f273605h;
        HashSet r110 = (HashSet) r109;
        r110.add(CapabilityType.RECEIVE_THERMAL_STATUS_INFO);
        Set<CapabilityType> r111 = this.f273605h;
        HashSet r112 = (HashSet) r111;
        r112.add(CapabilityType.RECEIVE_POWER_INFO);
        Set<CapabilityType> r113 = this.f273605h;
        HashSet r114 = (HashSet) r113;
        r114.add(CapabilityType.RECEIVE_STABILITY_INFO);
        Set<CapabilityType> r115 = this.f273605h;
        HashSet r116 = (HashSet) r115;
        r116.add(CapabilityType.RECEIVE_SYSTEM_INFO);
        Set<CapabilityType> r117 = this.f273605h;
        HashSet r118 = (HashSet) r117;
        r118.add(CapabilityType.GET_POWER_STATS);
    L13:
        this.f273600c = true;
        g(new fs7.a(0, null));
        return;
    L5:
        r103 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.douyin.janna.platform.HONORProcessor, com.douyin.janna.platform.a] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v5, types: [int] */
    @Override // com.douyin.janna.platform.a
    public final void h(fs7.b r110, List<Integer> r111) {
        if (this.f273567m == true) goto L5;
        return;
    L5:
        ArrayList r100 = new ArrayList();
        Iterator<Integer> r101 = r111.iterator();
    L7:
        if (r101.hasNext() == false) goto L56;
        Integer r102 = r101.next();
        int r103 = r102.intValue();
        if (r103 != 1) goto L11;
        if (d(CapabilityType.RECEIVE_THERMAL_STATUS_INFO) == false) goto L7;
        r100.add(1);
        if (this.f273569o != null) goto L54;
        this.f273569o = new SystemPressureCallbackImpl(this);
    L54:
        this.f273569o.a();
        goto L7
    L11:
        if (r103 != 10) goto L13;
        if (d(CapabilityType.RECEIVE_POWER_INFO) == false) goto L7;
        r100.add(10);
        if (this.f273568n != null) goto L41;
        this.f273568n = new PowerCallbackImpl(this);
    L41:
        PowerCallbackImpl r104 = this.f273568n;
        if (r104.f273572a == true) goto L43;
        PowerThermal.b r105 = new PowerThermal.b();
        r105.f276662a.add(PowerThermal.Kind.POWER_EXCESSIVE_DRAIN);
        PowerThermal r106 = new PowerThermal(r105);
        vw7.a.a(r104.f273574c.f273598a).b(r106, r104, r104.f273574c.f273599b);     // Catch: RuntimeException -> L47
        boolean r107 = hq7.a.f486512a;     // Catch: RuntimeException -> L47
        r104.f273572a = true;     // Catch: RuntimeException -> L47
    L47:
        e = move-exception;
        e.getMessage();
        boolean r108 = hq7.a.f486512a;
        goto L7
    L43:
        boolean r109 = hq7.a.f486512a;
        goto L7
    L13:
        if (r103 != 30) goto L15;
        if (d(CapabilityType.RECEIVE_SYSTEM_INFO) == false) goto L7;
        r100.add(30);
        if (this.f273569o != null) goto L35;
        this.f273569o = new SystemPressureCallbackImpl(this);
    L35:
        this.f273569o.a();
        goto L7
    L15:
        if (r103 != 40) goto L16;
        if (d(CapabilityType.RECEIVE_STABILITY_INFO) == false) goto L7;
        r100.add(40);
        if (this.f273570p != null) goto L22;
        this.f273570p = new StabilityCallbackImpl(this);
    L22:
        StabilityCallbackImpl r112 = this.f273570p;
        if (r112.f273575a == true) goto L24;
        Stability.b r113 = new Stability.b();
        r113.f276671a.add(Stability.Kind.KILLED);
        Stability r114 = new Stability(r113);
        vw7.a.a(r112.f273577c.f273598a).c(r114, r112, r112.f273577c.f273599b);     // Catch: RuntimeException -> L28
        boolean r115 = hq7.a.f486512a;     // Catch: RuntimeException -> L28
        r112.f273575a = true;     // Catch: RuntimeException -> L28
    L28:
        e = move-exception;
        e.getMessage();
        boolean r116 = hq7.a.f486512a;
        goto L7
    L24:
        boolean r117 = hq7.a.f486512a;
        goto L7
    L16:
        r100.add(r102);
        goto L7
    L56:
        if (r100.size() <= 0) goto L59;
        super.h(r110, r100);
    L59:
        if (this.f273600c == true) goto L61;
        return;
    L61:
        if (r111.contains(11) == true) goto L63;
        return;
    L63:
        if (this.f273608k != null) goto L66;
        this.f273608k = (PowerManager) this.f273598a.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
    L66:
        if (this.f273608k != null) goto L68;
    L110:
        int r118 = this.f273603f;
        if (r118 != 1) goto L156;
        r110.onEvent(a.a(r118));
        return;
    L156:
        return;
    L68:
        if (this.f273571q != null) goto L110;
        IntentFilter r119 = new IntentFilter("hihonor.intent.action.HWSYSTEMMANAGER_CHANGE_POWERMODE");
        r119.addAction("hihonor.intent.action.HWSYSTEMMANAGER_SHUTDOWN_LIMIT_POWERMODE");
        r119.addAction("hihonor.intent.action.HWSYSTEMMANAGER_CHANGE_POWERMODE");
        this.f273571q = new d(this);
        Method r120 = gs7.c.f482451c;
        ?? r121 = 0;
        r121 = 0;
        r121 = 0;
        r121 = 0;
        if (r120 != null) goto L121;
    L80:
        this.f273603f = r121;
        boolean r122 = hq7.a.f486512a;
        Context r123 = this.f273598a;
        d r124 = this.f273571q;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L117;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L117:
    L105:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L109;
        ReceiverRegisterCrashOptimizer.registerReceiver(r124, r119);
        goto L110
    L109:
        throw e;
    L84:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L96;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r119) == false) goto L96;
        int r125 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r124, r119, 0, null, null, 2, r123).result;     // Catch: Exception -> L105
        if (r125 == 1) goto L94;
        if (r125 != 2) goto L91;
        new Intent();     // Catch: Exception -> L105
    L116:
        goto L110
    L91:
        if (r125 == 3) goto L116;
        r123.registerReceiver(r124, r119);     // Catch: Exception -> L105
        goto L116
    L94:
        r123.registerReceiver(r124, r119);     // Catch: Exception -> L105
    L96:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L99;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L105
        r123.registerReceiver(r124, r119, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L105
        goto L116
    L99:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L101;
    L103:
        r123.registerReceiver(r124, r119);     // Catch: Exception -> L105
        goto L116
    L101:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r119) == false) goto L103;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L105
        ContextCompat.registerReceiver(r123, r124, r119, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L105
        goto L116
    L121:
        r121 = ((Boolean) r120.invoke(null, new Object[]{"sys.super_power_save", Boolean.FALSE})).booleanValue();     // Catch: InvocationTargetException -> L74 IllegalAccessException -> L76 IllegalArgumentException -> L78
    L76:
        e = move-exception;
        e.printStackTrace();
    L78:
        e = move-exception;
        e.printStackTrace();
    L74:
        e = move-exception;
        e.printStackTrace();
        goto L80
    }

    @Override // com.douyin.janna.platform.a
    public final void i(fs7.b r100, List<Integer> r101) {
        if (this.f273567m == true) goto L6;
        return;
    L6:
        if (r101.size() <= 0) goto L8;
        super.i(r100, r101);
    L8:
        Iterator<Integer> r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L65;
        int r103 = r102.next().intValue();
        if (r103 != 1) goto L14;
        if (d(CapabilityType.RECEIVE_THERMAL_STATUS_INFO) == false) goto L10;
        if (e(1) == true) goto L10;
        if (e(30) == true) goto L10;
        SystemPressureCallbackImpl r104 = this.f273569o;
        if (r104 == null) goto L10;
        r104.b();
        goto L10
    L14:
        if (r103 != 10) goto L15;
        if (d(CapabilityType.RECEIVE_POWER_INFO) == false) goto L10;
        if (e(10) == true) goto L10;
        PowerCallbackImpl r105 = this.f273568n;
        if (r105 == null) goto L10;
        if (r105.f273572a == true) goto L66;
        boolean r106 = hq7.a.f486512a;
    L66:
        vw7.a.a(r105.f273574c.f273598a).d(r105);     // Catch: RuntimeException -> L54
        boolean r107 = hq7.a.f486512a;     // Catch: RuntimeException -> L54
    L54:
        e = move-exception;
        e.getMessage();
        boolean r108 = hq7.a.f486512a;
        goto L10
    L15:
        if (r103 != 30) goto L17;
        if (d(CapabilityType.RECEIVE_SYSTEM_INFO) == false) goto L10;
        if (e(1) == true) goto L10;
        if (e(30) == true) goto L10;
        SystemPressureCallbackImpl r109 = this.f273569o;
        if (r109 == null) goto L10;
        r109.b();
        goto L10
    L17:
        if (r103 != 40) goto L10;
        if (d(CapabilityType.RECEIVE_STABILITY_INFO) == false) goto L10;
        if (e(40) == true) goto L10;
        StabilityCallbackImpl r110 = this.f273570p;
        if (r110 == null) goto L10;
        if (r110.f273575a == true) goto L68;
        boolean r111 = hq7.a.f486512a;
    L68:
        vw7.a.a(r110.f273577c.f273598a).e(r110);     // Catch: RuntimeException -> L31
        boolean r112 = hq7.a.f486512a;     // Catch: RuntimeException -> L31
    L31:
        e = move-exception;
        e.getMessage();
        boolean r113 = hq7.a.f486512a;
        goto L10
    }
}
