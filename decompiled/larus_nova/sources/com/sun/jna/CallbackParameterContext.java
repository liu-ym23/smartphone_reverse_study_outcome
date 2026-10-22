package com.sun.jna;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes40.dex */
public class CallbackParameterContext extends FromNativeContext {
    private Object[] args;
    private int index;
    private Method method;

    public Object[] getArguments() {
        return this.args;
    }

    public int getIndex() {
        return this.index;
    }

    public Method getMethod() {
        return this.method;
    }

    public CallbackParameterContext(Class<?> r100, Method r101, Object[] r102, int r103) {
        super(r100);
        this.method = r101;
        this.args = r102;
        this.index = r103;
    }
}
