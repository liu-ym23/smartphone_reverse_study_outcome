package com.bytedance.ee.bear.middleground.permission.service;

import cj5.c;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import jg5.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class PermissionServiceModule_ProvideShareUIServiceFactory implements Factory<c> {
    private final Provider<v> accessorProvider;
    private final gi5.c module;
    private final Provider<j> passportServiceProvider;

    @Override // javax.inject.Provider
    public c get() {
        return provideShareUIService(this.module, this.passportServiceProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PermissionServiceModule_ProvideShareUIServiceFactory(gi5.c r100, Provider<j> r101, Provider<v> r102) {
        this.module = r100;
        this.passportServiceProvider = r101;
        this.accessorProvider = r102;
    }

    public static PermissionServiceModule_ProvideShareUIServiceFactory create(gi5.c r100, Provider<j> r101, Provider<v> r102) {
        return new PermissionServiceModule_ProvideShareUIServiceFactory(r100, r101, r102);
    }

    public static c provideShareUIService(gi5.c r100, j r101, v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passportService");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        s r103 = new s(r101, r102);
        h.a(r103);
        return (c) Preconditions.checkNotNullFromProvides(r103);
    }
}
