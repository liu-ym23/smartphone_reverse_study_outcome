package com.bytedance.reparo.core;

import dalvik.system.BaseDexClassLoader;

/* JADX INFO: loaded from: classes6.dex */
public final class j extends BaseDexClassLoader {
    public final Class<?> a(String r100) throws ClassNotFoundException {
        return super.findClass(r100);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final Class<?> findClass(String r100) throws ClassNotFoundException {
        return super.findClass(r100);
    }

    public j(String r100, String r101, ClassLoader r102) {
        super(r100, null, r101, r102);
    }
}
