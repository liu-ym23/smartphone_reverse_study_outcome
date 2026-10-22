package com.ss.android.lark.chat.cot;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class CotFeatureGate_Factory implements Factory<a> {
    private final Provider<jdb.g> fgServiceProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.fgServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CotFeatureGate_Factory(Provider<jdb.g> r100) {
        this.fgServiceProvider = r100;
    }

    public static CotFeatureGate_Factory create(Provider<jdb.g> r100) {
        return new CotFeatureGate_Factory(r100);
    }

    public static a newInstance(jdb.g r100) {
        return new a(r100);
    }
}
