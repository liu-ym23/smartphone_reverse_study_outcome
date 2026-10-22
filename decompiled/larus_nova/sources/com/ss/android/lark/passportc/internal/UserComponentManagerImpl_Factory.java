package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class UserComponentManagerImpl_Factory implements Factory<UserComponentManagerImpl> {
    private final Provider<b0> componentProvidersProvider;
    private final Provider<com.ss.android.lark.log.c> loggerProvider;

    @Override // javax.inject.Provider
    public UserComponentManagerImpl get() {
        return newInstance(this.componentProvidersProvider.get(), this.loggerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserComponentManagerImpl_Factory(Provider<b0> r100, Provider<com.ss.android.lark.log.c> r101) {
        this.componentProvidersProvider = r100;
        this.loggerProvider = r101;
    }

    public static UserComponentManagerImpl_Factory create(Provider<b0> r100, Provider<com.ss.android.lark.log.c> r101) {
        return new UserComponentManagerImpl_Factory(r100, r101);
    }

    public static UserComponentManagerImpl newInstance(b0 r100, com.ss.android.lark.log.c r101) {
        return new UserComponentManagerImpl(r100, r101);
    }
}
