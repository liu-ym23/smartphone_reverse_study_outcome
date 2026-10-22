package com.ss.android.lark.passportc.ffi;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class KmpGlobalConvention_Factory implements Factory<a> {
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public KmpGlobalConvention_Factory(Provider<j> r100) {
        this.passportProvider = r100;
    }

    public static KmpGlobalConvention_Factory create(Provider<j> r100) {
        return new KmpGlobalConvention_Factory(r100);
    }

    public static a newInstance(j r100) {
        return new a(r100);
    }
}
