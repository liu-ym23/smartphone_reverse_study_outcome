package com.bytedance.ee.bear.tts.service;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import mo5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TtsServiceModule_ProvideListDatabaseApiFactory implements Factory<e> {
    private final Provider<v> accessorProvider;
    private final a module;
    private final Provider<j> passportServiceProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public e m631get() {
        return provideListDatabaseApi(this.module, (j) this.passportServiceProvider.get(), (v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m631get();
    }

    public TtsServiceModule_ProvideListDatabaseApiFactory(a r1, Provider<j> r2, Provider<v> r3) {
        this.module = r1;
        this.passportServiceProvider = r2;
        this.accessorProvider = r3;
    }

    public static TtsServiceModule_ProvideListDatabaseApiFactory create(a r1, Provider<j> r2, Provider<v> r3) {
        return new TtsServiceModule_ProvideListDatabaseApiFactory(r1, r2, r3);
    }

    public static e provideListDatabaseApi(a r0, j r1, v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passportService");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        b r3 = new b(r1, r2);
        h.a(r3);
        return (e) Preconditions.checkNotNullFromProvides(r3);
    }
}
