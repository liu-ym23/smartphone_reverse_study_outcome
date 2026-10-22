package com.ss.android.lark.im.sdk.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class VoiceTextPostProcessServiceImpl_Factory implements Factory<VoiceTextPostProcessServiceImpl> {
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;

    @Override // javax.inject.Provider
    public VoiceTextPostProcessServiceImpl get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public VoiceTextPostProcessServiceImpl_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.rustClientProvider = r100;
    }

    public static VoiceTextPostProcessServiceImpl_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new VoiceTextPostProcessServiceImpl_Factory(r100);
    }

    public static VoiceTextPostProcessServiceImpl newInstance(com.bytedance.lark.rustclient.api.l r100) {
        return new VoiceTextPostProcessServiceImpl(r100);
    }
}
