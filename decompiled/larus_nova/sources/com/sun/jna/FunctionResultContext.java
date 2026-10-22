package com.sun.jna;

/* JADX INFO: loaded from: classes40.dex */
public class FunctionResultContext extends FromNativeContext {
    private Object[] args;
    private Function function;

    public Object[] getArguments() {
        return this.args;
    }

    public Function getFunction() {
        return this.function;
    }

    public FunctionResultContext(Class<?> r100, Function r101, Object[] r102) {
        super(r100);
        this.function = r101;
        this.args = r102;
    }
}
