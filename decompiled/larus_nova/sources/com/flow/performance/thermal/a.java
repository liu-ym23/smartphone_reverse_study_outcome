package com.flow.performance.thermal;

import com.bytedance.apm.ApmAgent;
import com.larus.applog.api.IApplog;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    static {
    }

    public static void a(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        Intrinsics.checkNotNullParameter(r101, "category");
        Map<String, eu7.b> r104 = bu7.a.f20745a;
        bu7.a.b("Thermal report serviceName: " + r100 + " category: " + r101 + " metric: " + r102 + " extraLog: " + r103, "");
        JSONObject r105 = new JSONObject();
        Iterator<String> r106 = r101.keys();
    L4:
        if (r106.hasNext() == false) goto L6;
        String r107 = r106.next();
        r105.put(r107, r101.get(r107));
        goto L4
    L6:
        IApplog.f287053a.reportEvent(r100, r105);
        ApmAgent.monitorEvent(r100, r101, r102, r103);
    }
}
