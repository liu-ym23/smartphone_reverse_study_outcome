package com.ss.android.ttvecamera.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class ProxyHelper {
    public ProxyHelper() {
    }

    private static List<Class<?>> getAllInterfaces(Class<?> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        LinkedHashSet r101 = new LinkedHashSet();
        getAllInterfaces(r100, r101);
        return new ArrayList(r101);
    }

    public static Object createProxy(Object r100, InvocationHandler r101) {
        List<Class<?>> r102 = getAllInterfaces(r100.getClass());
        if (r102 != null) goto L5;
    L7:
        Class[] r103 = new Class[0];
    L9:
        return Proxy.newProxyInstance(r100.getClass().getClassLoader(), r103, r101);
    L5:
        if (r102.isEmpty() == true) goto L7;
        r103 = (Class[]) r102.toArray(new Class[0]);
        goto L9
    }

    private static void getAllInterfaces(Class<?> r100, HashSet<Class<?>> r101) {
    L2:
        if (r100 == null) goto L10;
        Class<?>[] r102 = r100.getInterfaces();
        int r103 = r102.length;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L9;
        Class<?> r105 = r102[r104];
        if (r101.add(r105) == false) goto L8;
        getAllInterfaces(r105, r101);
    L8:
        r104 = r104 + 1;
        goto L4
    L9:
        r100 = r100.getSuperclass();
        goto L2
    }
}
