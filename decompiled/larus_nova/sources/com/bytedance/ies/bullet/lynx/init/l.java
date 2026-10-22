package com.bytedance.ies.bullet.lynx.init;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Set<String> f247364a;

    public l(Set<String> r100) {
        this.f247364a = r100;
    }

    public final void a() {
        Set<String> r100 = this.f247364a;
        if (r100 == null) goto L17;
        SDKMonitor r101 = n.f247366a;
        SDKMonitor r102 = n.f247366a;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r100.isEmpty() == false) goto L9;
        String r103 = "";
    L14:
        JSONObject r104 = new JSONObject();
        r104.put("components", r103);
        r102.monitorEvent("lynx_component_info", r104, null, null);
        return;
    L9:
        StringBuilder r105 = new StringBuilder();
        Iterator<String> r106 = r100.iterator();
        r105.append(r106.next());
    L11:
        if (r106.hasNext() == false) goto L13;
        r105.append(",");
        r105.append(r106.next());
        goto L11
    L13:
        r103 = r105.toString();
        goto L14
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
