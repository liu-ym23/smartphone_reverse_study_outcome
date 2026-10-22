package com.ss.android.lark.feed.molten.page;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedSidebarItemsMoltenViewModelFactory_Factory implements Factory<FeedSidebarItemsMoltenViewModelFactory> {
    private final Provider<com.ss.android.lark.feed.molten.cache.b> localCacheProvider;
    private final Provider<m> passportProvider;

    @Override // javax.inject.Provider
    public FeedSidebarItemsMoltenViewModelFactory get() {
        return newInstance(this.passportProvider.get(), this.localCacheProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedSidebarItemsMoltenViewModelFactory_Factory(Provider<m> r100, Provider<com.ss.android.lark.feed.molten.cache.b> r101) {
        this.passportProvider = r100;
        this.localCacheProvider = r101;
    }

    public static FeedSidebarItemsMoltenViewModelFactory_Factory create(Provider<m> r100, Provider<com.ss.android.lark.feed.molten.cache.b> r101) {
        return new FeedSidebarItemsMoltenViewModelFactory_Factory(r100, r101);
    }

    public static FeedSidebarItemsMoltenViewModelFactory newInstance(m r100, com.ss.android.lark.feed.molten.cache.b r101) {
        return new FeedSidebarItemsMoltenViewModelFactory(r100, r101);
    }
}
