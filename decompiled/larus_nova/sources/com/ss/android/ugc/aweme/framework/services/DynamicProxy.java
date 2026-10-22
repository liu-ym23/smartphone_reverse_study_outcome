package com.ss.android.ugc.aweme.framework.services;

import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes5.dex */
public class DynamicProxy {
    public DynamicProxy() {
    }

    public static <T> T get(Class<?> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isInterface() == true) goto L7;
        return null;
    L7:
        return (T) Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new AnonymousClass1());
    }
}
