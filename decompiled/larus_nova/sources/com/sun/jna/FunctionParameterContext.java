package com.sun.jna;

/* JADX INFO: loaded from: classes40.dex */
public class FunctionParameterContext extends ToNativeContext {
    private Object[] args;
    private Function function;
    private int index;

    public Function getFunction() {
        return this.function;
    }

    public int getParameterIndex() {
        return this.index;
    }

    public Object[] getParameters() {
        return this.args;
    }

    public FunctionParameterContext(Function r100, Object[] r101, int r102) {
        this.function = r100;
        this.args = r101;
        this.index = r102;
    }
}
