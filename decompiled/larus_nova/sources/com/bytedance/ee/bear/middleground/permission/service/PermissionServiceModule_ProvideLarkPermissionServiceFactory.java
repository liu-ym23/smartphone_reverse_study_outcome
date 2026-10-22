package com.bytedance.ee.bear.middleground.permission.service;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import gi5.b;
import gi5.c;
import hm5.a;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class PermissionServiceModule_ProvideLarkPermissionServiceFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final c module;
    private final Provider<j> passportServiceProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideLarkPermissionService(this.module, this.passportServiceProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PermissionServiceModule_ProvideLarkPermissionServiceFactory(c r100, Provider<j> r101, Provider<v> r102) {
        this.module = r100;
        this.passportServiceProvider = r101;
        this.accessorProvider = r102;
    }

    public static PermissionServiceModule_ProvideLarkPermissionServiceFactory create(c r100, Provider<j> r101, Provider<v> r102) {
        return new PermissionServiceModule_ProvideLarkPermissionServiceFactory(r100, r101, r102);
    }

    public static a provideLarkPermissionService(c r100, j r101, v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passportService");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        b r103 = new b(r101, r102);
        h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}
