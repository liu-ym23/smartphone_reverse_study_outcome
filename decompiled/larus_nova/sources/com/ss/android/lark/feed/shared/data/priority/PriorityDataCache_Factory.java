package com.ss.android.lark.feed.shared.data.priority;

import dagger.internal.Factory;
import javax.inject.Provider;
import neb.b;

/* JADX INFO: loaded from: classes35.dex */
public final class PriorityDataCache_Factory implements Factory<b> {
    private final Provider<String> userIdProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.userIdProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PriorityDataCache_Factory(Provider<String> r100) {
        this.userIdProvider = r100;
    }

    public static PriorityDataCache_Factory create(Provider<String> r100) {
        return new PriorityDataCache_Factory(r100);
    }

    public static b newInstance(String r100) {
        return new b(r100);
    }
}
