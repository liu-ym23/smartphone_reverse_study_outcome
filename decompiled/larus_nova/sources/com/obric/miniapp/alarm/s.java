package com.obric.miniapp.alarm;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f397484a = 0;

    static {
    }

    public static Long a(w r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return Long.valueOf(r100.b());
    }

    public static Map b(String r100) {
        if (r100 == null) goto L7;
        LinkedHashMap r101 = new LinkedHashMap();
        JSONObject r102 = new JSONObject(r100);
        Iterator<String> r103 = r102.keys();
    L5:
        if (r103.hasNext() == false) goto L10;
        String r104 = r103.next();
        r101.put(r104, r102.optString(r104));
        goto L5
    L10:
        return r101;
    L7:
        return null;
    }

    public static String c(Map r100) {
        if (r100 == null) goto L8;
        JSONObject r101 = new JSONObject();
        Iterator r102 = r100.entrySet().iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), (String) r103.getValue());
        goto L5
    L11:
        return r101.toString();
    L8:
        return null;
    }

    public static w d(Long r100) {
        if (r100 == null) goto L4;
        long r101 = r100.longValue();
        boolean r102 = w.f397489b;
        return w.a.b(r101);
    L4:
        return null;
    }
}
