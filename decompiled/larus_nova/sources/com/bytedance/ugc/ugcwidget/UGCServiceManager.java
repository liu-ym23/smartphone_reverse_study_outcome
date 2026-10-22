package com.bytedance.ugc.ugcwidget;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class UGCServiceManager {
    private static a callback;
    private static final Map<Class, Object> implMap = null;

    public interface a {
    }

    public UGCServiceManager() {
    }

    public static void setCallback(a r100) {
    }

    static {
        implMap = new ConcurrentHashMap();
    }

    private static <T> Constructor<T> checkClass(Class<T> r100) {
        int r101 = r100.getModifiers();
        if (Modifier.isAbstract(r101) == true) goto L14;
        if (Modifier.isInterface(r101) == true) goto L12;
        return r100.getConstructor(new Class[0]);
    L10:
        throw new RuntimeException("UGCServiceManager NO matched public constructor found with".concat(r100.getName()));
    L12:
        throw new RuntimeException("UGCServiceManager DO NOT support interface class with ".concat(r100.getName()));
    L14:
        throw new RuntimeException("UGCServiceManager DO NOT support abstract class with ".concat(r100.getName()));
    }

    public static <T> T getService(Class<T> r100) {
        Map<Class, Object> r101 = implMap;
        T r102 = (T) r101.get(r100);
        if (r102 == null) goto L11;
    L10:
        return r102;
    L11:
        r102 = (T) checkClass(r100).newInstance(new Object[0]);
        r101.put(r100, r102);
    L7:
        th = move-exception;
        throw new RuntimeException("UGCServiceManager UNKNOWN exception found with ".concat(r100.getName()), th);
    }
}
