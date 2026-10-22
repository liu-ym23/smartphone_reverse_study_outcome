package com.ss.android.lark.im.sdk.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class ImSdkThreadServiceImpl_Factory implements Factory<y> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    @Override // javax.inject.Provider
    public y get() {
        return newInstance(this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ImSdkThreadServiceImpl_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.userClientProvider = r100;
    }

    public static ImSdkThreadServiceImpl_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new ImSdkThreadServiceImpl_Factory(r100);
    }

    public static y newInstance(com.bytedance.lark.rustclient.api.l r100) {
        return new y(r100);
    }
}
