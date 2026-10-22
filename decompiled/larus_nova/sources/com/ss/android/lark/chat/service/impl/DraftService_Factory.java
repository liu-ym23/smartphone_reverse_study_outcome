package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class DraftService_Factory implements Factory<r> {
    private final Provider<l6b.a> draftRepositoryProvider;

    @Override // javax.inject.Provider
    public r get() {
        return newInstance(this.draftRepositoryProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DraftService_Factory(Provider<l6b.a> r100) {
        this.draftRepositoryProvider = r100;
    }

    public static DraftService_Factory create(Provider<l6b.a> r100) {
        return new DraftService_Factory(r100);
    }

    public static r newInstance(l6b.a r100) {
        return new r(r100);
    }
}
