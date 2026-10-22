package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class MakeOnlineV2RequestFactory_Factory implements Factory<p> {
    private final Provider<jdb.e> globalFgServiceProvider;
    private final Provider<apb.a> globalLanguageServiceProvider;

    @Override // javax.inject.Provider
    public p get() {
        return newInstance(this.globalFgServiceProvider.get(), this.globalLanguageServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MakeOnlineV2RequestFactory_Factory(Provider<jdb.e> r100, Provider<apb.a> r101) {
        this.globalFgServiceProvider = r100;
        this.globalLanguageServiceProvider = r101;
    }

    public static MakeOnlineV2RequestFactory_Factory create(Provider<jdb.e> r100, Provider<apb.a> r101) {
        return new MakeOnlineV2RequestFactory_Factory(r100, r101);
    }

    public static p newInstance(jdb.e r100, apb.a r101) {
        return new p(r100, r101);
    }
}
