package com.ivy.ivykit.api.bridge;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, d<?>> f278301a = null;

    static {
        f278301a = new ConcurrentHashMap();
    }

    public static Object a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        d r101 = (d) ((ConcurrentHashMap) f278301a).get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.provideInstance();
    }

    public static void b(Class r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Map<Class<?>, d<?>> r102 = f278301a;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(r100, new f(r101));
    }
}
