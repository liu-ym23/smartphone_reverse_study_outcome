package com.ss.android.lark.im.sdk.message;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class SendMessagePipelinesV2_Factory implements Factory<f> {
    private final Provider<l> rustClientProvider;
    private final Provider<com.ss.android.lark.im.sdk.service.e> voiceTextPostProcessServiceProvider;

    @Override // javax.inject.Provider
    public f get() {
        return newInstance(this.rustClientProvider.get(), this.voiceTextPostProcessServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SendMessagePipelinesV2_Factory(Provider<l> r100, Provider<com.ss.android.lark.im.sdk.service.e> r101) {
        this.rustClientProvider = r100;
        this.voiceTextPostProcessServiceProvider = r101;
    }

    public static SendMessagePipelinesV2_Factory create(Provider<l> r100, Provider<com.ss.android.lark.im.sdk.service.e> r101) {
        return new SendMessagePipelinesV2_Factory(r100, r101);
    }

    public static f newInstance(l r100, com.ss.android.lark.im.sdk.service.e r101) {
        return new f(r100, r101);
    }
}
