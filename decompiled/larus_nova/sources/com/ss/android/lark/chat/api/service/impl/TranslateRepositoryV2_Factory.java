package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class TranslateRepositoryV2_Factory implements Factory<a2> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    @Override // javax.inject.Provider
    public a2 get() {
        return newInstance(this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public TranslateRepositoryV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.userClientProvider = r100;
    }

    public static TranslateRepositoryV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new TranslateRepositoryV2_Factory(r100);
    }

    public static a2 newInstance(com.bytedance.lark.rustclient.api.l r100) {
        return new a2(r100);
    }
}
