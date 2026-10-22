package com.bytedance.ee.bear.tts.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes18.dex */
public final class TtsService_Factory implements Factory<TtsService> {
    private final Provider<by4.b> kvStorageProvider;

    @Override // javax.inject.Provider
    public TtsService get() {
        return newInstance(this.kvStorageProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public TtsService_Factory(Provider<by4.b> r100) {
        this.kvStorageProvider = r100;
    }

    public static TtsService_Factory create(Provider<by4.b> r100) {
        return new TtsService_Factory(r100);
    }

    public static TtsService newInstance(by4.b r100) {
        return new TtsService(r100);
    }
}
