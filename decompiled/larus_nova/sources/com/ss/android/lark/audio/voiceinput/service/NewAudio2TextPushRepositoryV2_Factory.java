package com.ss.android.lark.audio.voiceinput.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class NewAudio2TextPushRepositoryV2_Factory implements Factory<NewAudio2TextPushRepositoryV2> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    @Override // javax.inject.Provider
    public NewAudio2TextPushRepositoryV2 get() {
        return newInstance(this.currentUserIdProvider.get(), this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public NewAudio2TextPushRepositoryV2_Factory(Provider<String> r100, Provider<com.bytedance.lark.rustclient.api.l> r101) {
        this.currentUserIdProvider = r100;
        this.userClientProvider = r101;
    }

    public static NewAudio2TextPushRepositoryV2_Factory create(Provider<String> r100, Provider<com.bytedance.lark.rustclient.api.l> r101) {
        return new NewAudio2TextPushRepositoryV2_Factory(r100, r101);
    }

    public static NewAudio2TextPushRepositoryV2 newInstance(String r100, com.bytedance.lark.rustclient.api.l r101) {
        return new NewAudio2TextPushRepositoryV2(r100, r101);
    }
}
