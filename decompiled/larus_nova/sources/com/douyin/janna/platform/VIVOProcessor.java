package com.douyin.janna.platform;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import android.view.Choreographer;
import android.view.Surface;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.douyin.janna.api.CapabilityType;
import com.larus.bmhome.share.panel.ShareChannel;
import com.vivo.libra.CallBack;
import com.vivo.libra.VivoLibraManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class VIVOProcessor extends a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Method f273584m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<String> f273585n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<String> f273586o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<Integer, String> f273587p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, Integer> f273588q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final j f273589r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final k f273590s;

    @Override // com.douyin.janna.platform.a
    public final void f() {
        Set<CapabilityType> r100 = this.f273605h;
        HashSet r101 = (HashSet) r100;
        r101.add(CapabilityType.SET_REFRESH_RATE);
        if (Looper.getMainLooper() == Looper.myLooper()) goto L5;
        new Handler(Looper.getMainLooper()).post(new l(this));
    L9:
        if (this.f273598a.getPackageName().contains(ShareChannel.DOUYIN) == false) goto L11;
        String r102 = "01a47bdb69ebc382f39cfcc8040b0389e38539041d635bc48f72ef68f657db73";
    L12:
        boolean r103 = VivoLibraManager.getInstance().checkPermission(r102);
        boolean r104 = hq7.a.f486512a;
        if (r103 == true) goto L15;
    L23:
        this.f273600c = true;
        g(new fs7.a(0, null));
        return;
    L15:
        if (VivoLibraManager.getInstance().funSupportCheck("getShellTemp") == false) goto L18;
        Set<CapabilityType> r105 = this.f273605h;
        HashSet r106 = (HashSet) r105;
        r106.add(CapabilityType.GET_PHONE_TEMP);
    L18:
        if (VivoLibraManager.getInstance().eventSupportCheck(CallBack.EVENT_THERMAL_RISK_LEVEL) == false) goto L21;
        Set<CapabilityType> r107 = this.f273605h;
        HashSet r108 = (HashSet) r107;
        r108.add(CapabilityType.RECEIVE_THERMAL_STATUS_INFO);
    L21:
        if (VivoLibraManager.getInstance().eventSupportCheck(CallBack.EVENT_THREAD_ABNORMAL) == false) goto L23;
        Set<CapabilityType> r109 = this.f273605h;
        HashSet r110 = (HashSet) r109;
        r110.add(CapabilityType.RECEIVE_POWER_INFO);
        goto L23
    L11:
        r102 = "";
        goto L12
    L5:
        j();
        if (this.f273584m == null) goto L9;
        Set<CapabilityType> r111 = this.f273605h;
        HashSet r112 = (HashSet) r111;
        r112.add(CapabilityType.SET_FPS);
        Set<CapabilityType> r113 = this.f273605h;
        HashSet r114 = (HashSet) r113;
        r114.add(CapabilityType.CANCEL_FPS);
        goto L9
    }

    public final void j() {
        Class r100 = Integer.TYPE;     // Catch: Exception -> L4
        Method r101 = gs7.a.a(Choreographer.class, new Class[]{r100, Surface.class, String.class, r100});     // Catch: Exception -> L4
        this.f273584m = r101;     // Catch: Exception -> L4
        Objects.toString(r101);     // Catch: Exception -> L4
        boolean r102 = hq7.a.f486512a;     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.getStackTraceString(e);
        boolean r103 = hq7.a.f486512a;
    }

    @Override // com.douyin.janna.platform.a
    public final float b() {
        float r100 = VivoLibraManager.getInstance().getShellTemp() / 10.0f;
        this.f273601d = r100;
        boolean r101 = hq7.a.f486512a;
        return r100;
    }

    @Override // com.douyin.janna.platform.a
    public final int c() {
        return this.f273602e;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.douyin.janna.platform.j] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.douyin.janna.platform.k] */
    public VIVOProcessor(Context r100) {
        super(r100);
        this.f273584m = null;
        this.f273585n = new ArrayList();
        this.f273586o = new ArrayList();
        this.f273587p = new AnonymousClass1(this);
        this.f273588q = new AnonymousClass2(this);
        this.f273589r = new j(this);
        this.f273590s = new k(this);
    }

    @Override // com.douyin.janna.platform.a
    public final void h(fs7.b r110, List<Integer> r111) {
        super.h(r110, r111);
        if (r111.contains(11) == true) goto L5;
    L45:
        Iterator<Integer> r112 = r111.iterator();
        boolean r113 = false;
        boolean r100 = false;
    L47:
        if (r112.hasNext() == false) goto L54;
        Integer r101 = r112.next();
        String r102 = (String) ((HashMap) this.f273587p).get(r101);
        if (r102 != null) goto L50;
        if (r101.intValue() != 10) goto L47;
        ((ArrayList) this.f273586o).add(CallBack.EVENT_THREAD_ABNORMAL);
        r100 = true;
        goto L47
    L50:
        ((ArrayList) this.f273585n).add(r102);
        r113 = true;
        goto L47
    L54:
        if (r113 == false) goto L63;
        List<String> r114 = this.f273585n;
        j r115 = this.f273589r;
        if (r114 == null) goto L63;
        if (((ArrayList) r114).isEmpty() == true) goto L63;
        List<String> r116 = VivoLibraManager.getInstance().registerCallBack(r114, r115);
        if (r116 == null) goto L63;
        r116.toString();
    L63:
        if (r100 == false) goto L84;
        List<String> r117 = this.f273586o;
        k r118 = this.f273590s;
        if (r117 != null) goto L67;
        return;
    L67:
        if (((ArrayList) r117).isEmpty() == true) goto L86;
        List<String> r119 = VivoLibraManager.getInstance().registerCallBack(r117, r118);
        if (r119 == null) goto L87;
        r119.toString();
        return;
    L87:
        return;
    L86:
        return;
    L84:
        return;
    L5:
        if (this.f273608k != null) goto L8;
        this.f273608k = (PowerManager) this.f273598a.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
    L8:
        if (this.f273608k != null) goto L10;
    L42:
        int r103 = this.f273603f;
        if (r103 != 1) goto L45;
        r110.onEvent(a.a(r103));
        goto L45
    L10:
        if (this.f273609l != null) goto L42;
        IntentFilter r104 = new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED");
        this.f273609l = new b(this);
        this.f273603f = this.f273608k.isPowerSaveMode() ? 1 : 0;
        boolean r105 = hq7.a.f486512a;
        Context r106 = this.f273598a;
        b r120 = this.f273609l;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L74;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L74:
    L37:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.registerReceiver(r120, r104);
        goto L42
    L41:
        throw e;
    L15:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L28;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r104) == false) goto L28;
        int r107 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r120, r104, 0, null, null, 2, r106).result;     // Catch: Exception -> L37
        if (r107 != 1) goto L21;
        r106.registerReceiver(r120, r104);     // Catch: Exception -> L37
    L73:
        goto L42
    L21:
        if (r107 != 2) goto L23;
        new Intent();     // Catch: Exception -> L37
        goto L73
    L23:
        if (r107 == 3) goto L73;
        r106.registerReceiver(r120, r104);     // Catch: Exception -> L37
    L28:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L31;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L37
        r106.registerReceiver(r120, r104, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L37
        goto L73
    L31:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L33;
    L35:
        r106.registerReceiver(r120, r104);     // Catch: Exception -> L37
        goto L73
    L33:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r104) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L37
        ContextCompat.registerReceiver(r106, r120, r104, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L37
        goto L73
    }
}
