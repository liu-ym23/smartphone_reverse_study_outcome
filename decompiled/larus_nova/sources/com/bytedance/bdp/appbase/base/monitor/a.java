package com.bytedance.bdp.appbase.base.monitor;

import android.text.TextUtils;
import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.monitor.BdpMonitorService;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Runnable {
    public a() {
    }

    public static void a() {
        monitor-enter(BdpAppMonitor.class);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (BdpAppMonitor.b() == false) goto L8;
        monitor-exit(BdpAppMonitor.class);
        return;
    L8:
        BdpInfoService r100 = (BdpInfoService) BdpManager.getInst().getService(BdpInfoService.class);     // Catch: Throwable -> L32
        z84.a.a();     // Catch: Throwable -> L32
        if (r100 != null) goto L13;
        g94.b.c().E(new Object[]{"BdpInfoService is null "});     // Catch: Throwable -> L32
        monitor-exit(BdpAppMonitor.class);
        return;
    L13:
        f94.a.c().getClass();     // Catch: Throwable -> L32
        String r101 = f94.a.b("");     // Catch: Throwable -> L32
        g94.b.a("BdpAppMonitor", new Object[]{"Device id is empty: " + TextUtils.isEmpty(r101)});     // Catch: Throwable -> L32
        if (TextUtils.equals(r101, "null") == false) goto L16;
    L19:
        r101 = null;
    L21:
        if (TextUtils.isEmpty(r101) == false) goto L24;
        monitor-exit(BdpAppMonitor.class);
        return;
    L24:
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L32
        r102.put("device_id", r101);     // Catch: JSONException -> L27 Throwable -> L32
        r102.put("channel", r100.getHostInfo().getChannel());     // Catch: JSONException -> L27 Throwable -> L32
        r102.put("host_aid", r100.getHostInfo().getAppId());     // Catch: JSONException -> L27 Throwable -> L32
        r102.put("app_version", r100.getHostInfo().getVersionName());     // Catch: JSONException -> L27 Throwable -> L32
        r102.put("update_version_code", r100.getHostInfo().getVersionCode());     // Catch: JSONException -> L27 Throwable -> L32
    L29:
        BdpAppMonitor.f200604b = r100.getHostInfo().getAppId();     // Catch: Throwable -> L32
        BdpAppMonitor.f200605c = r100.getHostInfo().getUpdateVersionCode();     // Catch: Throwable -> L32
        BdpMonitorService r103 = (BdpMonitorService) BdpManager.getInst().getService(BdpMonitorService.class);     // Catch: Throwable -> L32
        Arrays.asList(e.f200618a);     // Catch: Throwable -> L32
        BdpAppMonitor.f200603a = r103.d();     // Catch: Throwable -> L32
        BdpPool.runOnAsyncIfMain(new b());     // Catch: Throwable -> L32
        monitor-exit(BdpAppMonitor.class);
        return;
    L27:
        e = move-exception;
        g94.b.b("BdpAppMonitor", new Object[]{e.getMessage()});     // Catch: Throwable -> L32
        goto L29
    L16:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        if (TextUtils.equals(r101, "0") == false) goto L21;
        goto L19
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
