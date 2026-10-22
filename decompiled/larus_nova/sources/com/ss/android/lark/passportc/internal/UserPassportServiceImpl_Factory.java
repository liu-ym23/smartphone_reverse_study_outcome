package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class UserPassportServiceImpl_Factory implements Factory<UserPassportServiceImpl> {
    private final Provider<com.ss.android.lark.log.c> loggerProvider;
    private final Provider<t> passportExecutorsProvider;
    private final Provider<f0> userDelegateProvider;
    private final Provider<l0c.c> userFlowMonitorProvider;

    @Override // javax.inject.Provider
    public UserPassportServiceImpl get() {
        return newInstance(this.userDelegateProvider.get(), this.loggerProvider.get(), this.passportExecutorsProvider.get(), this.userFlowMonitorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserPassportServiceImpl_Factory(Provider<f0> r100, Provider<com.ss.android.lark.log.c> r101, Provider<t> r102, Provider<l0c.c> r103) {
        this.userDelegateProvider = r100;
        this.loggerProvider = r101;
        this.passportExecutorsProvider = r102;
        this.userFlowMonitorProvider = r103;
    }

    public static UserPassportServiceImpl_Factory create(Provider<f0> r100, Provider<com.ss.android.lark.log.c> r101, Provider<t> r102, Provider<l0c.c> r103) {
        return new UserPassportServiceImpl_Factory(r100, r101, r102, r103);
    }

    public static UserPassportServiceImpl newInstance(f0 r100, com.ss.android.lark.log.c r101, t r102, l0c.c r103) {
        return new UserPassportServiceImpl(r100, r101, r102, r103);
    }
}
