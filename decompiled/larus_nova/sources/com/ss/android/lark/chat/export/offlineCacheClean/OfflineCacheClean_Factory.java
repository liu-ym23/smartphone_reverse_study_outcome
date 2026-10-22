package com.ss.android.lark.chat.export.offlineCacheClean;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: classes35.dex */
public final class OfflineCacheClean_Factory implements Factory<OfflineCacheClean> {
    private final Provider<g> fgServiceProvider;
    private final Provider<m> passportProvider;
    private final Provider<b38.b> rucketProvider;

    @Override // javax.inject.Provider
    public OfflineCacheClean get() {
        return newInstance(this.passportProvider.get(), this.fgServiceProvider.get(), this.rucketProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfflineCacheClean_Factory(Provider<m> r100, Provider<g> r101, Provider<b38.b> r102) {
        this.passportProvider = r100;
        this.fgServiceProvider = r101;
        this.rucketProvider = r102;
    }

    public static OfflineCacheClean_Factory create(Provider<m> r100, Provider<g> r101, Provider<b38.b> r102) {
        return new OfflineCacheClean_Factory(r100, r101, r102);
    }

    public static OfflineCacheClean newInstance(m r100, g r101, b38.b r102) {
        return new OfflineCacheClean(r100, r101, r102);
    }
}
