package com.relax.embedding.module;

/* JADX INFO: loaded from: classes34.dex */
public abstract class NativeModule {
    public NativeModule() {
    }

    public abstract String getName();

    public abstract void invoke(String r100, byte[] r101, NativeModuleCallback r102);

    public abstract void invokeNoCodec(String r100, Object r101, NativeModuleCallback r102);

    public void invoke(String r100, Object r101, long r102) {
        invokeNoCodec(r100, r101, new NativeModuleCallback(r102, false));
    }

    public void invoke(String r100, byte[] r101, long r102) {
        invoke(r100, r101, new NativeModuleCallback(r102, true));
    }
}
