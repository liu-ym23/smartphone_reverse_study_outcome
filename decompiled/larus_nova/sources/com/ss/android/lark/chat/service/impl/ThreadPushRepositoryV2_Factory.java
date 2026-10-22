package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ThreadPushRepositoryV2_Factory implements Factory<l2> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    @Override // javax.inject.Provider
    public l2 get() {
        return newInstance(this.currentUserIdProvider.get(), this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ThreadPushRepositoryV2_Factory(Provider<String> r100, Provider<com.bytedance.lark.rustclient.api.l> r101) {
        this.currentUserIdProvider = r100;
        this.userClientProvider = r101;
    }

    public static ThreadPushRepositoryV2_Factory create(Provider<String> r100, Provider<com.bytedance.lark.rustclient.api.l> r101) {
        return new ThreadPushRepositoryV2_Factory(r100, r101);
    }

    public static l2 newInstance(String r100, com.bytedance.lark.rustclient.api.l r101) {
        return new l2(r100, r101);
    }
}
