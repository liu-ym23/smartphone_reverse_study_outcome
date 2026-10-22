package com.ss.android.lark.rustinfrabridge.netstate.impl;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class UserNetStateService_Factory implements Factory<UserNetStateService> {
    private final Provider<l> rustClientProvider;
    private final Provider<String> userIdProvider;

    @Override // javax.inject.Provider
    public UserNetStateService get() {
        return newInstance(this.rustClientProvider.get(), this.userIdProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserNetStateService_Factory(Provider<l> r100, Provider<String> r101) {
        this.rustClientProvider = r100;
        this.userIdProvider = r101;
    }

    public static UserNetStateService_Factory create(Provider<l> r100, Provider<String> r101) {
        return new UserNetStateService_Factory(r100, r101);
    }

    public static UserNetStateService newInstance(l r100, String r101) {
        return new UserNetStateService(r100, r101);
    }
}
