package com.bytedance.ee.bear.tts.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TtsService_Factory implements Factory<TtsService> {
    private final Provider<by4.b> kvStorageProvider;

    public TtsService get() {
        return newInstance((by4.b) this.kvStorageProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m632get() {
        return get();
    }

    public TtsService_Factory(Provider<by4.b> r1) {
        this.kvStorageProvider = r1;
    }

    public static TtsService_Factory create(Provider<by4.b> r1) {
        return new TtsService_Factory(r1);
    }

    public static TtsService newInstance(by4.b r1) {
        return new TtsService(r1);
    }
}
