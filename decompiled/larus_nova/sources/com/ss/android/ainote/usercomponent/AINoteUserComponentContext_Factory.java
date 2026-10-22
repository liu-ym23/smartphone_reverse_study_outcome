package com.ss.android.ainote.usercomponent;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import yra.a;

/* JADX INFO: loaded from: classes34.dex */
public final class AINoteUserComponentContext_Factory implements Factory<a> {
    private final Provider<m> passportProvider;
    private final Provider<l> rustClientProvider;
    private final Provider<String> userIdProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.passportProvider.get(), this.userIdProvider.get(), this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AINoteUserComponentContext_Factory(Provider<m> r100, Provider<String> r101, Provider<l> r102) {
        this.passportProvider = r100;
        this.userIdProvider = r101;
        this.rustClientProvider = r102;
    }

    public static AINoteUserComponentContext_Factory create(Provider<m> r100, Provider<String> r101, Provider<l> r102) {
        return new AINoteUserComponentContext_Factory(r100, r101, r102);
    }

    public static a newInstance(m r100, String r101, l r102) {
        return new a(r100, r101, r102);
    }
}
