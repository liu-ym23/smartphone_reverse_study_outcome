package com.suite.lark.emm.impl.clipboard.userscope;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.convention.b;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.suite.lark.emm.impl.clipboard.userscope.user.a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import doc.e;
import doc.g;
import e0c.k;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class SCClipboardGlobalManagerModule_ProvideUserFactory implements Factory<e> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public e get() {
        return provideUser(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SCClipboardGlobalManagerModule_ProvideUserFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static SCClipboardGlobalManagerModule_ProvideUserFactory create(Provider<j> r100, Provider<v> r101) {
        return new SCClipboardGlobalManagerModule_ProvideUserFactory(r100, r101);
    }

    public static e provideUser(j r100, v r101) {
        int r102 = g.f469538a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        UserSession r103 = r100.b();
        if (r103 != null) goto L5;
        r103 = ContainerConstsKt.a();
    L5:
        a r104 = new a(r100, r101, new b(k.b(r101.c(r103), e.class), e.class));
        h.a(r104);
        return (e) Preconditions.checkNotNullFromProvides(r104);
    }
}
