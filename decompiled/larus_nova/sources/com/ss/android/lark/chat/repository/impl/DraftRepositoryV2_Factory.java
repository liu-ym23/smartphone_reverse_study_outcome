package com.ss.android.lark.chat.repository.impl;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class DraftRepositoryV2_Factory implements Factory<DraftRepositoryV2> {
    private final Provider<l> userClientProvider;

    @Override // javax.inject.Provider
    public DraftRepositoryV2 get() {
        return newInstance(this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DraftRepositoryV2_Factory(Provider<l> r100) {
        this.userClientProvider = r100;
    }

    public static DraftRepositoryV2_Factory create(Provider<l> r100) {
        return new DraftRepositoryV2_Factory(r100);
    }

    public static DraftRepositoryV2 newInstance(l r100) {
        return new DraftRepositoryV2(r100);
    }
}
