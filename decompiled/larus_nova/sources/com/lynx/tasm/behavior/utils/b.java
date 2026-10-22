package com.lynx.tasm.behavior.utils;

import com.lynx.tasm.behavior.LynxUIMethod;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Class, HashMap<String, Method>> f383186a = null;

    static {
        f383186a = new HashMap();
    }

    public static HashMap<String, Method> a(Class<?> r100) {
        HashMap<Class, HashMap<String, Method>> r101 = f383186a;
        if (r101.containsKey(r100) == true) goto L5;
        HashMap<String, Method> r102 = new HashMap();
        Method[] r103 = r100.getDeclaredMethods();
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L12;
        Method r106 = r103[r105];
        if (((LynxUIMethod) r106.getAnnotation(LynxUIMethod.class)) == null) goto L11;
        r102.put(r106.getName(), r106);
    L11:
        r105 = r105 + 1;
        goto L7
    L12:
        Class<? super Object> r107 = r100.getSuperclass();
        if (r107 == null) goto L15;
        r102.putAll(a(r107));
    L15:
        f383186a.put(r100, r102);
        return r102;
    L5:
        return r101.get(r100);
    }
}
