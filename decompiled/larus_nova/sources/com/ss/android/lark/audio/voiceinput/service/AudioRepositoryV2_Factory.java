package com.ss.android.lark.audio.voiceinput.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class AudioRepositoryV2_Factory implements Factory<d> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    @Override // javax.inject.Provider
    public d get() {
        return newInstance(this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AudioRepositoryV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.userClientProvider = r100;
    }

    public static AudioRepositoryV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new AudioRepositoryV2_Factory(r100);
    }

    public static d newInstance(com.bytedance.lark.rustclient.api.l r100) {
        return new d(r100);
    }
}
