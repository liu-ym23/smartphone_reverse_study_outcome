package com.ss.android.lark.statistics.internal;

import dagger.internal.Factory;
import javax.inject.Provider;
import x5c.b;

/* JADX INFO: loaded from: classes38.dex */
public final class StatisticsImpl_Factory implements Factory<b> {
    private final Provider<String> userIdProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.userIdProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public StatisticsImpl_Factory(Provider<String> r100) {
        this.userIdProvider = r100;
    }

    public static StatisticsImpl_Factory create(Provider<String> r100) {
        return new StatisticsImpl_Factory(r100);
    }

    public static b newInstance(String r100) {
        return new b(r100);
    }
}
