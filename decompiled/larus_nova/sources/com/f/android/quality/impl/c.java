package com.f.android.quality.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> f274089a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Object> f274090b = null;

    static {
        f274089a = new ConcurrentHashMap();
        f274090b = new ConcurrentHashMap();
    }

    public static Map a(Map r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L45;
        Map.Entry r103 = (Map.Entry) r102.next();
        int r104 = st7.a.f543574a;
        String r105 = (String) r103.getKey();
        switch(r105.hashCode()) {
            case -1992012396: goto L39;
            case -1298426279: goto L36;
            case -1294650661: goto L33;
            case -939971977: goto L30;
            case -331732655: goto L27;
            case 3540684: goto L24;
            case 630087769: goto L21;
            case 717572172: goto L18;
            case 764587599: goto L15;
            case 769807573: goto L12;
            case 1381407186: goto L9;
            default: goto L41;
        };
    L41:
        boolean r106 = false;
    L43:
        if ((!r106) == false) goto L4;
        r101.put(r103.getKey(), r103.getValue());
        goto L4
    L9:
        if (r105.equals("err_tips") == false) goto L41;
    L40:
        r106 = true;
        goto L43
    L12:
        if (r105.equals("minor_name") == false) goto L41;
    L15:
        if (r105.equals("valid_steps_duration") == false) goto L41;
    L18:
        if (r105.equals("custom_event") == false) goto L41;
    L21:
        if (r105.equals("business_type") == false) goto L41;
    L24:
        if (r105.equals("step") == false) goto L41;
    L27:
        if (r105.equals("major_name") == false) goto L41;
    L30:
        if (r105.equals("valid_duration") == false) goto L41;
    L33:
        if (r105.equals("err_no") == false) goto L41;
    L36:
        if (r105.equals("exclude_duration") == false) goto L41;
    L39:
        if (r105.equals("duration") == false) goto L41;
    L45:
        return r101;
    }
}
