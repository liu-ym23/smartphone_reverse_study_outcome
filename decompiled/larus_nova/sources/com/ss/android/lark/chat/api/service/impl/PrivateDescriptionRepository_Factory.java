package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class PrivateDescriptionRepository_Factory implements Factory<e1> {
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;

    @Override // javax.inject.Provider
    public e1 get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PrivateDescriptionRepository_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.rustClientProvider = r100;
    }

    public static PrivateDescriptionRepository_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new PrivateDescriptionRepository_Factory(r100);
    }

    public static e1 newInstance(com.bytedance.lark.rustclient.api.l r100) {
        return new e1(r100);
    }
}
