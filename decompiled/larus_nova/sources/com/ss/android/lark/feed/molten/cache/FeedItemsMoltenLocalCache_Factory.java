package com.ss.android.lark.feed.molten.cache;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedItemsMoltenLocalCache_Factory implements Factory<FeedItemsMoltenLocalCache> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FeedItemsMoltenLocalCache_Factory f421035a = null;

        static {
            f421035a = new FeedItemsMoltenLocalCache_Factory();
        }
    }

    public FeedItemsMoltenLocalCache_Factory() {
    }

    public static FeedItemsMoltenLocalCache newInstance() {
        return new FeedItemsMoltenLocalCache();
    }

    @Override // javax.inject.Provider
    public FeedItemsMoltenLocalCache get() {
        return newInstance();
    }

    public static FeedItemsMoltenLocalCache_Factory create() {
        return a.f421035a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
