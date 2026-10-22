package com.bytedance.ee.bear.more.view3;

import com.bytedance.ee.bear.more.protocol3.k;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, Integer> f235022b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f235023a;

    public c() {
    }

    static {
        f235022b = new HashMap();
    }

    public static int a(k r100) {
        Class<?> r101 = r100.getClass();
        Map<Class<?>, Integer> r102 = f235022b;
        Integer r103 = (Integer) ((HashMap) r102).get(r101);
        if (r103 != null) goto L6;
        r103 = Integer.valueOf(((HashMap) r102).size() + 1);
        ((HashMap) r102).put(r101, r103);
    L6:
        return r103.intValue();
    }
}
