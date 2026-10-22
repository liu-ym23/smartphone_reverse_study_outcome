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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class PermissionServiceModule_ProvideShareUIServiceFactory implements Factory<c> {
    private final Provider<v> accessorProvider;
    private final gi5.c module;
    private final Provider<j> passportServiceProvider;

    public c get() {
        return provideShareUIService(this.module, (j) this.passportServiceProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m295get() {
        return get();
    }

    public PermissionServiceModule_ProvideShareUIServiceFactory(gi5.c r1, Provider<j> r2, Provider<v> r3) {
        this.module = r1;
        this.passportServiceProvider = r2;
        this.accessorProvider = r3;
    }

    public static PermissionServiceModule_ProvideShareUIServiceFactory create(gi5.c r1, Provider<j> r2, Provider<v> r3) {
        return new PermissionServiceModule_ProvideShareUIServiceFactory(r1, r2, r3);
    }

    public static c provideShareUIService(gi5.c r0, j r1, v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passportService");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        s r3 = new s(r1, r2);
        h.a(r3);
        return (c) Preconditions.checkNotNullFromProvides(r3);
    }
}
