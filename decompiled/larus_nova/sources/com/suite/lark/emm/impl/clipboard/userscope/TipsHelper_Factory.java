package com.suite.lark.emm.impl.clipboard.userscope;

import dagger.internal.Factory;
import doc.l;
import javax.inject.Provider;
import o5c.b;
import yzb.a;

/* JADX INFO: loaded from: classes40.dex */
public final class TipsHelper_Factory implements Factory<l> {
    private final Provider<b> statisticsProvider;
    private final Provider<a> userApiProvider;
    private final Provider<com.ss.android.lark.storage.kv.storage.a> userKVProvider;

    @Override // javax.inject.Provider
    public l get() {
        return newInstance(this.userKVProvider.get(), this.userApiProvider.get(), this.statisticsProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public TipsHelper_Factory(Provider<com.ss.android.lark.storage.kv.storage.a> r100, Provider<a> r101, Provider<b> r102) {
        this.userKVProvider = r100;
        this.userApiProvider = r101;
        this.statisticsProvider = r102;
    }

    public static TipsHelper_Factory create(Provider<com.ss.android.lark.storage.kv.storage.a> r100, Provider<a> r101, Provider<b> r102) {
        return new TipsHelper_Factory(r100, r101, r102);
    }

    public static l newInstance(com.ss.android.lark.storage.kv.storage.a r100, a r101, b r102) {
        return new l(r100, r101, r102);
    }
}
