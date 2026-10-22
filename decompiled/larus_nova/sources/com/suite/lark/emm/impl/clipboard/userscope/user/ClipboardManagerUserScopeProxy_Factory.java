package com.suite.lark.emm.impl.clipboard.userscope.user;

import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.convention.b;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import doc.e;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes40.dex */
public final class ClipboardManagerUserScopeProxy_Factory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;
    private final Provider<b<e>> proxyProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.passportProvider.get(), this.accessorProvider.get(), this.proxyProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ClipboardManagerUserScopeProxy_Factory(Provider<j> r100, Provider<v> r101, Provider<b<e>> r102) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
        this.proxyProvider = r102;
    }

    public static ClipboardManagerUserScopeProxy_Factory create(Provider<j> r100, Provider<v> r101, Provider<b<e>> r102) {
        return new ClipboardManagerUserScopeProxy_Factory(r100, r101, r102);
    }

    public static a newInstance(j r100, v r101, b<e> r102) {
        return new a(r100, r101, r102);
    }
}
