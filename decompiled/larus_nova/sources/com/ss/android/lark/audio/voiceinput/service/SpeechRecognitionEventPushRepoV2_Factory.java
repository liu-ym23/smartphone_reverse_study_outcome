package com.ss.android.lark.audio.voiceinput.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class SpeechRecognitionEventPushRepoV2_Factory implements Factory<x> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    @Override // javax.inject.Provider
    public x get() {
        return newInstance(this.currentUserIdProvider.get(), this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SpeechRecognitionEventPushRepoV2_Factory(Provider<String> r100, Provider<com.bytedance.lark.rustclient.api.l> r101) {
        this.currentUserIdProvider = r100;
        this.userClientProvider = r101;
    }

    public static SpeechRecognitionEventPushRepoV2_Factory create(Provider<String> r100, Provider<com.bytedance.lark.rustclient.api.l> r101) {
        return new SpeechRecognitionEventPushRepoV2_Factory(r100, r101);
    }

    public static x newInstance(String r100, com.bytedance.lark.rustclient.api.l r101) {
        return new x(r100, r101);
    }
}
