package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ThreadRepositoryV2_Factory implements Factory<l1> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    @Override // javax.inject.Provider
    public l1 get() {
        return newInstance(this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ThreadRepositoryV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.userClientProvider = r100;
    }

    public static ThreadRepositoryV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new ThreadRepositoryV2_Factory(r100);
    }

    public static l1 newInstance(com.bytedance.lark.rustclient.api.l r100) {
        return new l1(r100);
    }
}
