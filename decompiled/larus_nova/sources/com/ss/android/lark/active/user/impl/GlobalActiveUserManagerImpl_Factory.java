package com.ss.android.lark.active.user.impl;

import com.ss.android.lark.passportc.api.k;
import com.ss.android.lark.passportc.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class GlobalActiveUserManagerImpl_Factory implements Factory<GlobalActiveUserManagerImpl> {
    private final Provider<nua.a> activeUserSelectProvider;
    private final Provider<nua.c> multiUserOnlineFeatureGatingProvider;
    private final Provider<k> stateManager2Provider;
    private final Provider<l> stateManagerProvider;

    @Override // javax.inject.Provider
    public GlobalActiveUserManagerImpl get() {
        return newInstance(this.stateManagerProvider.get(), this.stateManager2Provider.get(), this.multiUserOnlineFeatureGatingProvider.get(), this.activeUserSelectProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GlobalActiveUserManagerImpl_Factory(Provider<l> r100, Provider<k> r101, Provider<nua.c> r102, Provider<nua.a> r103) {
        this.stateManagerProvider = r100;
        this.stateManager2Provider = r101;
        this.multiUserOnlineFeatureGatingProvider = r102;
        this.activeUserSelectProvider = r103;
    }

    public static GlobalActiveUserManagerImpl_Factory create(Provider<l> r100, Provider<k> r101, Provider<nua.c> r102, Provider<nua.a> r103) {
        return new GlobalActiveUserManagerImpl_Factory(r100, r101, r102, r103);
    }

    public static GlobalActiveUserManagerImpl newInstance(l r100, k r101, nua.c r102, nua.a r103) {
        return new GlobalActiveUserManagerImpl(r100, r101, r102, r103);
    }
}
