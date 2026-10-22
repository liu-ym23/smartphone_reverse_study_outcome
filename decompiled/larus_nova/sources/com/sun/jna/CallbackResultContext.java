package com.sun.jna;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes40.dex */
public class CallbackResultContext extends ToNativeContext {
    private Method method;

    public Method getMethod() {
        return this.method;
    }

    public CallbackResultContext(Method r100) {
        this.method = r100;
    }
}
