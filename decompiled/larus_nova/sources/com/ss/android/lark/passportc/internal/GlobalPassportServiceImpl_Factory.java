package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class GlobalPassportServiceImpl_Factory implements Factory<GlobalPassportServiceImpl> {
    private final Provider<t> executorsProvider;
    private final Provider<com.ss.android.lark.log.c> loggerProvider;
    private final Provider<com.ss.android.lark.passportc.api.e> passportProvider;
    private final Provider<Set<com.ss.android.lark.passportc.api.p>> staticConventionsProvider;
    private final Provider<l0c.c> userFlowMonitorProvider;

    @Override // javax.inject.Provider
    public GlobalPassportServiceImpl get() {
        return newInstance(this.passportProvider, this.loggerProvider.get(), this.executorsProvider.get(), this.userFlowMonitorProvider.get(), this.staticConventionsProvider);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GlobalPassportServiceImpl_Factory(Provider<com.ss.android.lark.passportc.api.e> r100, Provider<com.ss.android.lark.log.c> r101, Provider<t> r102, Provider<l0c.c> r103, Provider<Set<com.ss.android.lark.passportc.api.p>> r104) {
        this.passportProvider = r100;
        this.loggerProvider = r101;
        this.executorsProvider = r102;
        this.userFlowMonitorProvider = r103;
        this.staticConventionsProvider = r104;
    }

    public static GlobalPassportServiceImpl_Factory create(Provider<com.ss.android.lark.passportc.api.e> r100, Provider<com.ss.android.lark.log.c> r101, Provider<t> r102, Provider<l0c.c> r110, Provider<Set<com.ss.android.lark.passportc.api.p>> r111) {
        return new GlobalPassportServiceImpl_Factory(r100, r101, r102, r110, r111);
    }

    public static GlobalPassportServiceImpl newInstance(Provider<com.ss.android.lark.passportc.api.e> r100, com.ss.android.lark.log.c r101, t r102, l0c.c r110, Provider<Set<com.ss.android.lark.passportc.api.p>> r111) {
        return new GlobalPassportServiceImpl(r100, r101, r102, r110, r111);
    }
}
