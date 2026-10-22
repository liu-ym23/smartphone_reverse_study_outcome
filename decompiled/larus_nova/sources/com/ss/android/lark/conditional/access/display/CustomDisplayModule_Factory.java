package com.ss.android.lark.conditional.access.display;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class CustomDisplayModule_Factory implements Factory<CustomDisplayModule> {
    private final Provider<apb.a> languageServiceProvider;
    private final Provider<h> networkRepositoryProvider;
    private final Provider<m> passportProvider;
    private final Provider<i> storageProvider;

    @Override // javax.inject.Provider
    public CustomDisplayModule get() {
        return newInstance(this.passportProvider.get(), this.networkRepositoryProvider.get(), this.storageProvider.get(), this.languageServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CustomDisplayModule_Factory(Provider<m> r100, Provider<h> r101, Provider<i> r102, Provider<apb.a> r103) {
        this.passportProvider = r100;
        this.networkRepositoryProvider = r101;
        this.storageProvider = r102;
        this.languageServiceProvider = r103;
    }

    public static CustomDisplayModule_Factory create(Provider<m> r100, Provider<h> r101, Provider<i> r102, Provider<apb.a> r103) {
        return new CustomDisplayModule_Factory(r100, r101, r102, r103);
    }

    public static CustomDisplayModule newInstance(m r100, h r101, i r102, apb.a r103) {
        return new CustomDisplayModule(r100, r101, r102, r103);
    }
}
