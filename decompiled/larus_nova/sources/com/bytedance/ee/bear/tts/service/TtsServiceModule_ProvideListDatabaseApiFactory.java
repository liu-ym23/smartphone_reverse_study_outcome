package com.bytedance.ee.bear.tts.service;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import mo5.e;

/* JADX INFO: loaded from: classes18.dex */
public final class TtsServiceModule_ProvideListDatabaseApiFactory implements Factory<e> {
    private final Provider<v> accessorProvider;
    private final a module;
    private final Provider<j> passportServiceProvider;

    @Override // javax.inject.Provider
    public e get() {
        return provideListDatabaseApi(this.module, this.passportServiceProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public TtsServiceModule_ProvideListDatabaseApiFactory(a r100, Provider<j> r101, Provider<v> r102) {
        this.module = r100;
        this.passportServiceProvider = r101;
        this.accessorProvider = r102;
    }

    public static TtsServiceModule_ProvideListDatabaseApiFactory create(a r100, Provider<j> r101, Provider<v> r102) {
        return new TtsServiceModule_ProvideListDatabaseApiFactory(r100, r101, r102);
    }

    public static e provideListDatabaseApi(a r100, j r101, v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passportService");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        b r103 = new b(r101, r102);
        h.a(r103);
        return (e) Preconditions.checkNotNullFromProvides(r103);
    }
}
