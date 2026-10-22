package com.flow.performance.thermal;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class n implements f09.a.b {
    public n() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        Iterator<JSONObject> r100 = o.f274223d.iterator();     // Catch: Exception -> L19
        int r101 = 0;
    L5:
        if (r100.hasNext() == false) goto L17;
        JSONObject r102 = r100.next();     // Catch: Exception -> L19
        int r103 = r101 + 1;     // Catch: Exception -> L19
        if (r101 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L19
    L9:
        JSONObject r104 = r102;     // Catch: Exception -> L19
        o r105 = o.f274221b;     // Catch: Exception -> L19
        if (r104 != null) goto L12;
        final JSONObject r106 = new JSONObject();     // Catch: Exception -> L19
    L13:
        final JSONObject r107 = o.f274223d.get(r101);     // Catch: Exception -> L19
        r105.getClass();     // Catch: Exception -> L19
        Intrinsics.checkNotNullParameter("monitor_vivo_thermal", "serviceName");     // Catch: Exception -> L19
        Intrinsics.checkNotNullParameter(r106, "category");     // Catch: Exception -> L19
        t0.a(new m(r106, r107));     // Catch: Exception -> L19
        if (AppHost.f326268a.isDebug() == false) goto L16;
        FLogger.f375446a.d("VivoThermalMonitor", "Current thermal data is : " + r104);     // Catch: Exception -> L19
    L16:
        r101 = r103;
        goto L5
    L12:
        r106 = r104;
        goto L13
    L17:
        o.f274224e.clear();     // Catch: Exception -> L19
        o.f274223d.clear();     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        FLogger.f375446a.e("VivoThermalMonitor", "report thermal error : " + e.getMessage());
        o.f274224e.clear();
        o.f274223d.clear();
    }
}
