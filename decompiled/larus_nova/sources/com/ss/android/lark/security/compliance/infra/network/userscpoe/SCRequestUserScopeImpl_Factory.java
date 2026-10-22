package com.ss.android.lark.security.compliance.infra.network.userscpoe;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class SCRequestUserScopeImpl_Factory implements Factory<SCRequestUserScopeImpl> {
    private final Provider<l> userClientProvider;
    private final Provider<jdb.g> userFGProvider;

    @Override // javax.inject.Provider
    public SCRequestUserScopeImpl get() {
        return newInstance(this.userClientProvider.get(), this.userFGProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SCRequestUserScopeImpl_Factory(Provider<l> r100, Provider<jdb.g> r101) {
        this.userClientProvider = r100;
        this.userFGProvider = r101;
    }

    public static SCRequestUserScopeImpl_Factory create(Provider<l> r100, Provider<jdb.g> r101) {
        return new SCRequestUserScopeImpl_Factory(r100, r101);
    }

    public static SCRequestUserScopeImpl newInstance(l r100, jdb.g r101) {
        return new SCRequestUserScopeImpl(r100, r101);
    }
}
