package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class PreviewService_Factory implements Factory<PreviewService> {
    private final Provider<a2b.e> repoProvider;

    @Override // javax.inject.Provider
    public PreviewService get() {
        return newInstance(this.repoProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PreviewService_Factory(Provider<a2b.e> r100) {
        this.repoProvider = r100;
    }

    public static PreviewService_Factory create(Provider<a2b.e> r100) {
        return new PreviewService_Factory(r100);
    }

    public static PreviewService newInstance(a2b.e r100) {
        return new PreviewService(r100);
    }
}
