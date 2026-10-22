package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class PrivateDescriptionService_Factory implements Factory<PrivateDescriptionService> {
    private final Provider<a2b.g> repositoryProvider;

    @Override // javax.inject.Provider
    public PrivateDescriptionService get() {
        return newInstance(this.repositoryProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PrivateDescriptionService_Factory(Provider<a2b.g> r100) {
        this.repositoryProvider = r100;
    }

    public static PrivateDescriptionService_Factory create(Provider<a2b.g> r100) {
        return new PrivateDescriptionService_Factory(r100);
    }

    public static PrivateDescriptionService newInstance(a2b.g r100) {
        return new PrivateDescriptionService(r100);
    }
}
