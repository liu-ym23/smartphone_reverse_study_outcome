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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class PermissionServiceModule_ProvideLarkPermissionServiceFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final c module;
    private final Provider<j> passportServiceProvider;

    public a get() {
        return provideLarkPermissionService(this.module, (j) this.passportServiceProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m294get() {
        return get();
    }

    public PermissionServiceModule_ProvideLarkPermissionServiceFactory(c r1, Provider<j> r2, Provider<v> r3) {
        this.module = r1;
        this.passportServiceProvider = r2;
        this.accessorProvider = r3;
    }

    public static PermissionServiceModule_ProvideLarkPermissionServiceFactory create(c r1, Provider<j> r2, Provider<v> r3) {
        return new PermissionServiceModule_ProvideLarkPermissionServiceFactory(r1, r2, r3);
    }

    public static a provideLarkPermissionService(c r0, j r1, v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passportService");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        b r3 = new b(r1, r2);
        h.a(r3);
        return (a) Preconditions.checkNotNullFromProvides(r3);
    }
}
