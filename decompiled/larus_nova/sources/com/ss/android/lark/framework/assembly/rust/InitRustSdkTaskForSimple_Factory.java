package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class InitRustSdkTaskForSimple_Factory implements Factory<InitRustSdkTaskForSimple> {
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public InitRustSdkTaskForSimple get() {
        return newInstance(this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public InitRustSdkTaskForSimple_Factory(Provider<com.ss.android.lark.passportc.api.j> r100) {
        this.passportProvider = r100;
    }

    public static InitRustSdkTaskForSimple_Factory create(Provider<com.ss.android.lark.passportc.api.j> r100) {
        return new InitRustSdkTaskForSimple_Factory(r100);
    }

    public static InitRustSdkTaskForSimple newInstance(com.ss.android.lark.passportc.api.j r100) {
        return new InitRustSdkTaskForSimple(r100);
    }
}
