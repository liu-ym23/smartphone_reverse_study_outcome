package com.ss.android.lark.diskmanage.storage;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class CipherFileDelegate_CipherFileDelegateFactory_Factory implements Factory<a.C4954a> {
    private final Provider<jkc.c> cipherManagerProvider;

    @Override // javax.inject.Provider
    public a.C4954a get() {
        return newInstance(this.cipherManagerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CipherFileDelegate_CipherFileDelegateFactory_Factory(Provider<jkc.c> r100) {
        this.cipherManagerProvider = r100;
    }

    public static CipherFileDelegate_CipherFileDelegateFactory_Factory create(Provider<jkc.c> r100) {
        return new CipherFileDelegate_CipherFileDelegateFactory_Factory(r100);
    }

    public static a.C4954a newInstance(jkc.c r100) {
        return new a.C4954a(r100);
    }
}
