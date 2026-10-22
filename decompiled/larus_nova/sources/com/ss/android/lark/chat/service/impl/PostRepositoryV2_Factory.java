package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class PostRepositoryV2_Factory implements Factory<n1> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    @Override // javax.inject.Provider
    public n1 get() {
        return newInstance(this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PostRepositoryV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.userClientProvider = r100;
    }

    public static PostRepositoryV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new PostRepositoryV2_Factory(r100);
    }

    public static n1 newInstance(com.bytedance.lark.rustclient.api.l r100) {
        return new n1(r100);
    }
}
