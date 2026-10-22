package com.bytedance.ee.bear.middleground.permission;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r6, JSONObject r7) {
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        HashMap r1 = r0.m("docCommonParams");
        HashMap r2 = r0.m("nativePermissionCommonParams");
        HashMap r3 = r0.m("bitableFormPermCommonParams");
        Iterator r4 = r1.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r5 = (Map.Entry) r4.next();
        r7.put((String) r5.getKey(), r5.getValue());
        goto L4
    L6:
        Iterator r8 = r2.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r9 = (Map.Entry) r8.next();
        r7.put((String) r9.getKey(), r9.getValue());
        goto L8
    L10:
        Iterator r10 = r3.entrySet().iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        Map.Entry r11 = (Map.Entry) r10.next();
        r7.put((String) r11.getKey(), r11.getValue());
        goto L12
    L14:
        r0.u(r6, r7);
        tt5.a.b("PermBitableShareAnalytic", "eventName = " + r6 + ", params = " + r7);
    }
}
