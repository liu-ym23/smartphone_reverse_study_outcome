package com.sun.jna;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes40.dex */
public class MethodResultContext extends FunctionResultContext {
    private final Method method;

    public Method getMethod() {
        return this.method;
    }

    public MethodResultContext(Class<?> r100, Function r101, Object[] r102, Method r103) {
        super(r100, r101, r102);
        this.method = r103;
    }
}
