package com.ss.android.lark.passportc.ffi;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class KmpUserConvention_Factory implements Factory<KmpUserConvention> {
    private final Provider<m> passportProvider;

    @Override // javax.inject.Provider
    public KmpUserConvention get() {
        return newInstance(this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public KmpUserConvention_Factory(Provider<m> r100) {
        this.passportProvider = r100;
    }

    public static KmpUserConvention_Factory create(Provider<m> r100) {
        return new KmpUserConvention_Factory(r100);
    }

    public static KmpUserConvention newInstance(m r100) {
        return new KmpUserConvention(r100);
    }
}
