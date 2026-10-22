package com.bytedance.mira.plugin.fast;

/* JADX INFO: loaded from: classes21.dex */
public class Interstellar {
    public Interstellar() {
    }

    private static native long add_classloader(Object r100);

    private static native Class find_clazz(long r100, Object r101, String r102);

    private static native Class find_loaded_and_find_clazz(long r100, Object r101, String r102);

    private static native Class find_loaded_clazz(long r100, Object r101, String r102);

    public static long addClassLoader(ClassLoader r100) {
        return add_classloader(r100);
    }

    public static Class findClazz(long r100, Object r101, String r102) {
        return find_clazz(r100, r101, r102);
    }

    public static Class findLoadedAndFindClazz(long r100, Object r101, String r102) {
        return find_loaded_and_find_clazz(r100, r101, r102);
    }

    public static Class findLoadedClazz(long r100, Object r101, String r102) {
        return find_loaded_clazz(r100, r101, r102);
    }
}
