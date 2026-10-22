package com.ss.android.lark.security.compliance.infra.network.userscpoe;

import com.bytedance.lark.rustclient.api.h;
import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class SCRequestGlobalImpl_Factory implements Factory<SCRequestGlobalImpl> {
    private final Provider<jdb.e> globalFGProvider;
    private final Provider<h> globalRustProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public SCRequestGlobalImpl get() {
        return newInstance(this.globalRustProvider.get(), this.globalFGProvider.get(), this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SCRequestGlobalImpl_Factory(Provider<h> r100, Provider<jdb.e> r101, Provider<j> r102) {
        this.globalRustProvider = r100;
        this.globalFGProvider = r101;
        this.passportProvider = r102;
    }

    public static SCRequestGlobalImpl_Factory create(Provider<h> r100, Provider<jdb.e> r101, Provider<j> r102) {
        return new SCRequestGlobalImpl_Factory(r100, r101, r102);
    }

    public static SCRequestGlobalImpl newInstance(h r100, jdb.e r101, j r102) {
        return new SCRequestGlobalImpl(r100, r101, r102);
    }
}
