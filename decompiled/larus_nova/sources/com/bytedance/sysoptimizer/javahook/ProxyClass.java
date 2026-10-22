package com.bytedance.sysoptimizer.javahook;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyClass {
    private static final String TAG = "ProxyClass";

    public ProxyClass() {
    }

    private Method getMethod(String r100, Class<?>[] r101, boolean r102) throws NoSuchMethodException {
        return (Method) AHook.callOrigin("getMethod(Ljava/lang/String;[Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", this, new Object[]{r100, r101, Boolean.valueOf(r102)});
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
