package com.bytedance.ee.space.services;

import com.bytedance.ee.space.sync.b;
import com.bytedance.ee.space.sync.d;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class SpaceCoreServiceModule_ProvideDriveSdkApiFactory implements Factory<b> {
    private final Provider<v> accessorProvider;
    private final a module;
    private final Provider<j> passportServiceProvider;

    @Override // javax.inject.Provider
    public b get() {
        return provideDriveSdkApi(this.module, this.passportServiceProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SpaceCoreServiceModule_ProvideDriveSdkApiFactory(a r100, Provider<j> r101, Provider<v> r102) {
        this.module = r100;
        this.passportServiceProvider = r101;
        this.accessorProvider = r102;
    }

    public static SpaceCoreServiceModule_ProvideDriveSdkApiFactory create(a r100, Provider<j> r101, Provider<v> r102) {
        return new SpaceCoreServiceModule_ProvideDriveSdkApiFactory(r100, r101, r102);
    }

    public static b provideDriveSdkApi(a r100, j r101, v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passportService");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        d r103 = new d(r101, r102);
        h.a(r103);
        return (b) Preconditions.checkNotNullFromProvides(r103);
    }
}
