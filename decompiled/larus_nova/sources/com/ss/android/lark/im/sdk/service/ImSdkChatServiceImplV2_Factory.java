package com.ss.android.lark.im.sdk.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class ImSdkChatServiceImplV2_Factory implements Factory<f> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;
    private final Provider<String> userIdProvider;

    @Override // javax.inject.Provider
    public f get() {
        return newInstance(this.userIdProvider.get(), this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ImSdkChatServiceImplV2_Factory(Provider<String> r100, Provider<com.bytedance.lark.rustclient.api.l> r101) {
        this.userIdProvider = r100;
        this.userClientProvider = r101;
    }

    public static ImSdkChatServiceImplV2_Factory create(Provider<String> r100, Provider<com.bytedance.lark.rustclient.api.l> r101) {
        return new ImSdkChatServiceImplV2_Factory(r100, r101);
    }

    public static f newInstance(String r100, com.bytedance.lark.rustclient.api.l r101) {
        return new f(r100, r101);
    }
}
