package com.ss.lark.android.encryption.userscope;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import jkc.d;

/* JADX INFO: loaded from: classes40.dex */
public final class SCCipherManagerUserScope_Factory implements Factory<SCCipherManagerUserScope> {
    private final Provider<d> cipherStreamProvider;
    private final Provider<m> passportProvider;
    private final Provider<l> userClientProvider;

    @Override // javax.inject.Provider
    public SCCipherManagerUserScope get() {
        return newInstance(this.userClientProvider.get(), this.passportProvider.get(), this.cipherStreamProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SCCipherManagerUserScope_Factory(Provider<l> r100, Provider<m> r101, Provider<d> r102) {
        this.userClientProvider = r100;
        this.passportProvider = r101;
        this.cipherStreamProvider = r102;
    }

    public static SCCipherManagerUserScope_Factory create(Provider<l> r100, Provider<m> r101, Provider<d> r102) {
        return new SCCipherManagerUserScope_Factory(r100, r101, r102);
    }

    public static SCCipherManagerUserScope newInstance(l r100, m r101, d r102) {
        return new SCCipherManagerUserScope(r100, r101, r102);
    }
}
