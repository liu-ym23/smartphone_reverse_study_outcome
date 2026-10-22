package com.suite.lark.emm.impl.clipboard.userscope;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import doc.a;
import javax.inject.Provider;
import jdb.e;

/* JADX INFO: loaded from: classes40.dex */
public final class FGGlobalInternal_Factory implements Factory<a> {
    private final Provider<e> fgServiceProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.passportProvider.get(), this.fgServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FGGlobalInternal_Factory(Provider<j> r100, Provider<e> r101) {
        this.passportProvider = r100;
        this.fgServiceProvider = r101;
    }

    public static FGGlobalInternal_Factory create(Provider<j> r100, Provider<e> r101) {
        return new FGGlobalInternal_Factory(r100, r101);
    }

    public static a newInstance(j r100, e r101) {
        return new a(r100, r101);
    }
}
