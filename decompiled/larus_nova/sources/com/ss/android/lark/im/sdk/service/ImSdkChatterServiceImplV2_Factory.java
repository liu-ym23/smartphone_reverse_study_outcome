package com.ss.android.lark.im.sdk.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class ImSdkChatterServiceImplV2_Factory implements Factory<ImSdkChatterServiceImplV2> {
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;

    @Override // javax.inject.Provider
    public ImSdkChatterServiceImplV2 get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ImSdkChatterServiceImplV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.rustClientProvider = r100;
    }

    public static ImSdkChatterServiceImplV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new ImSdkChatterServiceImplV2_Factory(r100);
    }

    public static ImSdkChatterServiceImplV2 newInstance(com.bytedance.lark.rustclient.api.l r100) {
        return new ImSdkChatterServiceImplV2(r100);
    }
}
