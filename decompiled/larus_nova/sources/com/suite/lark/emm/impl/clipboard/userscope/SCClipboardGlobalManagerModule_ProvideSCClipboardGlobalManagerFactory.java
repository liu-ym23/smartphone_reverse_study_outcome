package com.suite.lark.emm.impl.clipboard.userscope;

import com.ss.android.lark.audit.userscope.auth.j;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import doc.c;
import doc.d;
import doc.f;
import doc.g;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class SCClipboardGlobalManagerModule_ProvideSCClipboardGlobalManagerFactory implements Factory<d> {
    private final Provider<j> authorizationManagerProvider;
    private final Provider<c> fgGlobalInternalProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public d get() {
        return provideSCClipboardGlobalManager(this.passportProvider.get(), this.fgGlobalInternalProvider.get(), this.authorizationManagerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SCClipboardGlobalManagerModule_ProvideSCClipboardGlobalManagerFactory(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<c> r101, Provider<j> r102) {
        this.passportProvider = r100;
        this.fgGlobalInternalProvider = r101;
        this.authorizationManagerProvider = r102;
    }

    public static SCClipboardGlobalManagerModule_ProvideSCClipboardGlobalManagerFactory create(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<c> r101, Provider<j> r102) {
        return new SCClipboardGlobalManagerModule_ProvideSCClipboardGlobalManagerFactory(r100, r101, r102);
    }

    public static d provideSCClipboardGlobalManager(com.ss.android.lark.passportc.api.j r100, c r101, j r102) {
        int r103 = g.f469538a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "fgGlobalInternal");
        Intrinsics.checkNotNullParameter(r102, "authorizationManager");
        return (d) Preconditions.checkNotNullFromProvides(new f(r100, r101, r102));
    }
}
