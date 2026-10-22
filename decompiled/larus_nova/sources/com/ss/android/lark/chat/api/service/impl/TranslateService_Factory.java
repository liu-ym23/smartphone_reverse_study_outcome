package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class TranslateService_Factory implements Factory<TranslateService> {
    private final Provider<t0> repositoryProvider;

    @Override // javax.inject.Provider
    public TranslateService get() {
        return newInstance(this.repositoryProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public TranslateService_Factory(Provider<t0> r100) {
        this.repositoryProvider = r100;
    }

    public static TranslateService_Factory create(Provider<t0> r100) {
        return new TranslateService_Factory(r100);
    }

    public static TranslateService newInstance(t0 r100) {
        return new TranslateService(r100);
    }
}
