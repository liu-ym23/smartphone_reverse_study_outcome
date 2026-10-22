package com.ss.android.lark.translate.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class TranslatePush_Factory implements Factory<n> {
    private final Provider<b> pushRepoProvider;

    @Override // javax.inject.Provider
    public n get() {
        return newInstance(this.pushRepoProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public TranslatePush_Factory(Provider<b> r100) {
        this.pushRepoProvider = r100;
    }

    public static TranslatePush_Factory create(Provider<b> r100) {
        return new TranslatePush_Factory(r100);
    }

    public static n newInstance(b r100) {
        return new n(r100);
    }
}
