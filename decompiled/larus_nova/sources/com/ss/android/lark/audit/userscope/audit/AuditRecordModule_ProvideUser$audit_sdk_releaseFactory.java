package com.ss.android.lark.audit.userscope.audit;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class AuditRecordModule_ProvideUser$audit_sdk_releaseFactory implements Factory<l> {
    private final Provider<v> accessorProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public l get() {
        return provideUser$audit_sdk_release(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AuditRecordModule_ProvideUser$audit_sdk_releaseFactory(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static AuditRecordModule_ProvideUser$audit_sdk_releaseFactory create(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<v> r101) {
        return new AuditRecordModule_ProvideUser$audit_sdk_releaseFactory(r100, r101);
    }

    public static l provideUser$audit_sdk_release(com.ss.android.lark.passportc.api.j r100, v r101) {
        int r102 = f.f409491a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        UserSession r103 = r100.b();
        if (r103 != null) goto L5;
        r103 = ContainerConstsKt.a();
    L5:
        i r104 = new i(r100, r101, new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r103), l.class), l.class));
        com.ss.android.lark.passportc.api.h.a(r104);
        return (l) Preconditions.checkNotNullFromProvides(r104);
    }
}
