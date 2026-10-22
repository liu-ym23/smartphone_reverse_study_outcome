package com.ss.android.lark.passport.flow.mfa;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class FlowMfaRepository_Factory implements Factory<FlowMfaRepository> {
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;

    @Override // javax.inject.Provider
    public FlowMfaRepository get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FlowMfaRepository_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.rustClientProvider = r100;
    }

    public static FlowMfaRepository_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new FlowMfaRepository_Factory(r100);
    }

    public static FlowMfaRepository newInstance(com.bytedance.lark.rustclient.api.l r100) {
        return new FlowMfaRepository(r100);
    }
}
