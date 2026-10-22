package com.ss.android.lark.passportc.convention;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class NoneContainerSessionGetterImpl_Factory implements Factory<c> {
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public c get() {
        return newInstance(this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public NoneContainerSessionGetterImpl_Factory(Provider<j> r100) {
        this.passportProvider = r100;
    }

    public static NoneContainerSessionGetterImpl_Factory create(Provider<j> r100) {
        return new NoneContainerSessionGetterImpl_Factory(r100);
    }

    public static c newInstance(j r100) {
        return new c(r100);
    }
}
