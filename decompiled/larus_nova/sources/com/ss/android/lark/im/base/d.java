package com.ss.android.lark.im.base;

import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<ImExtensionType, List<Class<?>>> f425883a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<ImExtensionType, List<?>> f425884b = null;

    static {
        f425883a = new ConcurrentHashMap();
        f425884b = new ConcurrentHashMap();
    }

    public static List a(ImExtensionType r100, Class r101) {
        ArrayList r102 = new ArrayList();
        List r103 = (List) ((ConcurrentHashMap) f425883a).get(r100);
        if (r103 == null) goto L11;
        Iterator r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L11;
        Class<?> r105 = (Class) r104.next();
        if (r101.isAssignableFrom(r105) == true) goto L9;
        Log.e("ImExtensionManager", r101.getCanonicalName() + " is not assignable from " + r105.getCanonicalName());
        goto L6
    L9:
        Object r106 = r105.newInstance();
        Intrinsics.checkNotNull(r106);
        r102.add(r106);
    L11:
        return r102;
    }

    public static List b(ImExtensionType r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "extensionType");
        Intrinsics.checkNotNullParameter(r101, "factoryClass");
        c r102 = ImBaseBizModule.f425876c.getValue().f425877a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("extensionDependency");
        r102 = null;
    L6:
        r102.b();
        ConcurrentHashMap r103 = (ConcurrentHashMap) f425884b;
        List r104 = (List) r103.get(r100);
        if (r104 != null) goto L9;
        r104 = a(r100, r101);
        r103.put(r100, r104);
    L9:
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.collections.List<T of com.ss.android.lark.im.base.ImExtensionManager.getCachedFactories>");
        return r104;
    }

    public static List c(ImExtensionType r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "extensionType");
        Intrinsics.checkNotNullParameter(r101, "factoryClass");
        c r102 = ImBaseBizModule.f425876c.getValue().f425877a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("extensionDependency");
        r102 = null;
    L6:
        r102.b();
        List r103 = a(r100, r101);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.List<T of com.ss.android.lark.im.base.ImExtensionManager.getFactoriesWithNewInstances>");
        return r103;
    }

    public static void d(ImExtensionType r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "extensionType");
        Intrinsics.checkNotNullParameter(r101, "factoryClass");
        ConcurrentHashMap r102 = (ConcurrentHashMap) f425883a;
        List r103 = (List) r102.get(r100);
        if (r103 != null) goto L5;
        r103 = new CopyOnWriteArrayList();
        r102.put(r100, r103);
    L5:
        r103.add(r101);
    }
}
