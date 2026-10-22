package com.ss.android.lark.translate.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class TranslatePushRepositoryV2_Factory implements Factory<o> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    @Override // javax.inject.Provider
    public o get() {
        return newInstance(this.currentUserIdProvider.get(), this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public TranslatePushRepositoryV2_Factory(Provider<String> r100, Provider<com.bytedance.lark.rustclient.api.l> r101) {
        this.currentUserIdProvider = r100;
        this.userClientProvider = r101;
    }

    public static TranslatePushRepositoryV2_Factory create(Provider<String> r100, Provider<com.bytedance.lark.rustclient.api.l> r101) {
        return new TranslatePushRepositoryV2_Factory(r100, r101);
    }

    public static o newInstance(String r100, com.bytedance.lark.rustclient.api.l r101) {
        return new o(r100, r101);
    }
}
