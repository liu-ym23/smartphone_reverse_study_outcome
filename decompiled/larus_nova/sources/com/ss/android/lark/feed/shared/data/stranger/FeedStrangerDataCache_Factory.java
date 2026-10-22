package com.ss.android.lark.feed.shared.data.stranger;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import oeb.a;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedStrangerDataCache_Factory implements Factory<a> {
    private final Provider<m> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedStrangerDataCache_Factory(Provider<m> r100) {
        this.passportProvider = r100;
    }

    public static FeedStrangerDataCache_Factory create(Provider<m> r100) {
        return new FeedStrangerDataCache_Factory(r100);
    }

    public static a newInstance(m r100) {
        return new a(r100);
    }
}
