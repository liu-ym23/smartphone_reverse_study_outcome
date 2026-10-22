package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ImSdkChatterPushImplV2_Factory implements Factory<ImSdkChatterPushImplV2> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> userRustClientProvider;

    @Override // javax.inject.Provider
    public ImSdkChatterPushImplV2 get() {
        return newInstance(this.currentUserIdProvider.get(), this.userRustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ImSdkChatterPushImplV2_Factory(Provider<String> r100, Provider<com.bytedance.lark.rustclient.api.l> r101) {
        this.currentUserIdProvider = r100;
        this.userRustClientProvider = r101;
    }

    public static ImSdkChatterPushImplV2_Factory create(Provider<String> r100, Provider<com.bytedance.lark.rustclient.api.l> r101) {
        return new ImSdkChatterPushImplV2_Factory(r100, r101);
    }

    public static ImSdkChatterPushImplV2 newInstance(String r100, com.bytedance.lark.rustclient.api.l r101) {
        return new ImSdkChatterPushImplV2(r100, r101);
    }
}
