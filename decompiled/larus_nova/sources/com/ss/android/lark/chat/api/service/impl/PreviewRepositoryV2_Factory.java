package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class PreviewRepositoryV2_Factory implements Factory<PreviewRepositoryV2> {
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;

    @Override // javax.inject.Provider
    public PreviewRepositoryV2 get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PreviewRepositoryV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.rustClientProvider = r100;
    }

    public static PreviewRepositoryV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new PreviewRepositoryV2_Factory(r100);
    }

    public static PreviewRepositoryV2 newInstance(com.bytedance.lark.rustclient.api.l r100) {
        return new PreviewRepositoryV2(r100);
    }
}
