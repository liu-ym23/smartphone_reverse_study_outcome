package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatRepositoryV2_Factory implements Factory<o> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    @Override // javax.inject.Provider
    public o get() {
        return newInstance(this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatRepositoryV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.userClientProvider = r100;
    }

    public static ChatRepositoryV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new ChatRepositoryV2_Factory(r100);
    }

    public static o newInstance(com.bytedance.lark.rustclient.api.l r100) {
        return new o(r100);
    }
}
