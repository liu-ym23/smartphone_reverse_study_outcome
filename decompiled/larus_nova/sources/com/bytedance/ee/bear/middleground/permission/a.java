package com.bytedance.ee.bear.middleground.permission;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f232845a = 0;

    static {
    }

    public static void a(String r100, JSONObject r101) {
        com.bytedance.ee.bear.contract.d r102 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        HashMap<String, Object> r103 = r102.m("docCommonParams");
        HashMap<String, Object> r104 = r102.m("nativePermissionCommonParams");
        HashMap<String, Object> r105 = r102.m("bitableFormPermCommonParams");
        Iterator<T> r106 = r103.entrySet().iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        Map.Entry r107 = (Map.Entry) r106.next();
        r101.put((String) r107.getKey(), r107.getValue());
        goto L4
    L6:
        Iterator<T> r108 = r104.entrySet().iterator();
    L8:
        if (r108.hasNext() == false) goto L10;
        Map.Entry r109 = (Map.Entry) r108.next();
        r101.put((String) r109.getKey(), r109.getValue());
        goto L8
    L10:
        Iterator<T> r110 = r105.entrySet().iterator();
    L12:
        if (r110.hasNext() == false) goto L14;
        Map.Entry r111 = (Map.Entry) r110.next();
        r101.put((String) r111.getKey(), r111.getValue());
        goto L12
    L14:
        r102.u(r100, r101);
        tt5.a.b("PermBitableShareAnalytic", "eventName = " + r100 + ", params = " + r101);
    }
}
