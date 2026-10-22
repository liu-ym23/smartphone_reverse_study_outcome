package com.ss.android.lark.tab.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class ChatTabPushRepositoryV2_Factory implements Factory<ChatTabPushRepositoryV2> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    @Override // javax.inject.Provider
    public ChatTabPushRepositoryV2 get() {
        return newInstance(this.currentUserIdProvider.get(), this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatTabPushRepositoryV2_Factory(Provider<String> r100, Provider<com.bytedance.lark.rustclient.api.l> r101) {
        this.currentUserIdProvider = r100;
        this.userClientProvider = r101;
    }

    public static ChatTabPushRepositoryV2_Factory create(Provider<String> r100, Provider<com.bytedance.lark.rustclient.api.l> r101) {
        return new ChatTabPushRepositoryV2_Factory(r100, r101);
    }

    public static ChatTabPushRepositoryV2 newInstance(String r100, com.bytedance.lark.rustclient.api.l r101) {
        return new ChatTabPushRepositoryV2(r100, r101);
    }
}
