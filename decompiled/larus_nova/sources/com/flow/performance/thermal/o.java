package com.flow.performance.thermal;

import android.os.Build;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.common.utility.Logger;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.vivo.libra.CallBack;
import com.vivo.libra.VivoLibraManager;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f274221b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f274222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<JSONObject> f274223d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CopyOnWriteArrayList<JSONObject> f274224e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f274225f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l f274226g = null;

    public final synchronized void b() {
        monitor-enter(this);
        VivoLibraManager r100 = (VivoLibraManager) f274225f.getValue();     // Catch: Throwable -> L6
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L6
        r101.add(CallBack.EVENT_POWER_MODE);     // Catch: Throwable -> L6
        r101.add(CallBack.EVENT_SLEEP_MODE);     // Catch: Throwable -> L6
        r101.add(CallBack.EVENT_APP_DEVICE_POWER);     // Catch: Throwable -> L6
        r100.registerCallBack(r101, f274226g);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.flow.performance.thermal.l] */
    static {
        f274221b = new o();
        f274223d = new CopyOnWriteArrayList();
        f274224e = new CopyOnWriteArrayList();
        f274225f = LazyKt.lazy(new k());
        f274226g = new l();
    }

    public final synchronized void a() {
        monitor-enter(this);
        Logger.e("VivoThermalMonitor", "[VivoThermalMonitor]initThermalMonitor start ");     // Catch: Throwable -> L22
        if (f274222c == true) goto L20;
        String r100 = Build.BRAND;     // Catch: Throwable -> L22
        String r101 = Build.MANUFACTURER;     // Catch: Throwable -> L22
        if (StringsKt.equals(DimLocationCheckUtil.VIVO, r100, true) == false) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L20;
        AppHost.Companion r103 = AppHost.f326268a;     // Catch: Throwable -> L22
        if (r103.isOversea() == true) goto L20;
        f274222c = true;     // Catch: Throwable -> L22
        Logger.e("VivoThermalMonitor", "[VivoThermalMonitor]initThermalMonitor inner");     // Catch: Throwable -> L22
        Lazy r104 = f274225f;     // Catch: Throwable -> L22
        boolean r105 = ((VivoLibraManager) r104.getValue()).checkPermission("bc7e6d0cbc7f65d08bcec78644096c244ea49af20474b2baae59a5331e05e1d9");     // Catch: Throwable -> L22
        this.f274207a.f274215a = ((VivoLibraManager) r104.getValue()).getPowerMode();     // Catch: Throwable -> L22
        this.f274207a.f274216b = ((VivoLibraManager) r104.getValue()).getSleepMode();     // Catch: Throwable -> L22
        FLogger.f375446a.d("VivoThermalMonitor", "VivoThermalMonitor init result = " + r105 + " thermal data : " + this.f274207a);     // Catch: Throwable -> L22
        b();     // Catch: Throwable -> L22
        r103.a().j(new n());     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L9:
        if (StringsKt.equals(DimLocationCheckUtil.VIVO, r101, true) == true) goto L12;
        r102 = false;
    L20:
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public o() {
    }
}
