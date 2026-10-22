package com.ss.android.lark.tab.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class ChatTabRepositoryV2_Factory implements Factory<f> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    @Override // javax.inject.Provider
    public f get() {
        return newInstance(this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatTabRepositoryV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.userClientProvider = r100;
    }

    public static ChatTabRepositoryV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new ChatTabRepositoryV2_Factory(r100);
    }

    public static f newInstance(com.bytedance.lark.rustclient.api.l r100) {
        return new f(r100);
    }
}
