package com.ss.android.lark.tab.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class ChatTabExtraRepositoryV2_Factory implements Factory<b> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatTabExtraRepositoryV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.userClientProvider = r100;
    }

    public static ChatTabExtraRepositoryV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new ChatTabExtraRepositoryV2_Factory(r100);
    }

    public static b newInstance(com.bytedance.lark.rustclient.api.l r100) {
        return new b(r100);
    }
}
