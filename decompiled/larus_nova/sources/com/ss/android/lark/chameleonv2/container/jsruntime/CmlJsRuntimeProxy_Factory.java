package com.ss.android.lark.chameleonv2.container.jsruntime;

import com.ss.android.lark.chameleon.AbsChameleonJsRuntime;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.convention.b;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import javax.inject.Provider;
import m0b.c;

/* JADX INFO: loaded from: classes35.dex */
public final class CmlJsRuntimeProxy_Factory implements Factory<c> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;
    private final Provider<b<AbsChameleonJsRuntime>> proxyProvider;

    @Override // javax.inject.Provider
    public c get() {
        return newInstance(this.passportProvider.get(), this.accessorProvider.get(), this.proxyProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CmlJsRuntimeProxy_Factory(Provider<j> r100, Provider<v> r101, Provider<b<AbsChameleonJsRuntime>> r102) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
        this.proxyProvider = r102;
    }

    public static CmlJsRuntimeProxy_Factory create(Provider<j> r100, Provider<v> r101, Provider<b<AbsChameleonJsRuntime>> r102) {
        return new CmlJsRuntimeProxy_Factory(r100, r101, r102);
    }

    public static c newInstance(j r100, v r101, b<AbsChameleonJsRuntime> r102) {
        return new c(r100, r101, r102);
    }
}
