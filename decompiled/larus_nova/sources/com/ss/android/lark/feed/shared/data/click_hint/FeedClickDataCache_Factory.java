package com.ss.android.lark.feed.shared.data.click_hint;

import dagger.internal.Factory;
import javax.inject.Provider;
import jeb.a;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedClickDataCache_Factory implements Factory<a> {
    private final Provider<String> userIdProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.userIdProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedClickDataCache_Factory(Provider<String> r100) {
        this.userIdProvider = r100;
    }

    public static FeedClickDataCache_Factory create(Provider<String> r100) {
        return new FeedClickDataCache_Factory(r100);
    }

    public static a newInstance(String r100) {
        return new a(r100);
    }
}
