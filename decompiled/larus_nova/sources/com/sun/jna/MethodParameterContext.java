package com.sun.jna;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes40.dex */
public class MethodParameterContext extends FunctionParameterContext {
    private Method method;

    public Method getMethod() {
        return this.method;
    }

    public MethodParameterContext(Function r100, Object[] r101, int r102, Method r103) {
        super(r100, r101, r102);
        this.method = r103;
    }
}
