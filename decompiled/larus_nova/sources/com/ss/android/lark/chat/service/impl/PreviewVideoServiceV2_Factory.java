package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class PreviewVideoServiceV2_Factory implements Factory<z1> {
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;

    @Override // javax.inject.Provider
    public z1 get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PreviewVideoServiceV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.rustClientProvider = r100;
    }

    public static PreviewVideoServiceV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new PreviewVideoServiceV2_Factory(r100);
    }

    public static z1 newInstance(com.bytedance.lark.rustclient.api.l r100) {
        return new z1(r100);
    }
}
