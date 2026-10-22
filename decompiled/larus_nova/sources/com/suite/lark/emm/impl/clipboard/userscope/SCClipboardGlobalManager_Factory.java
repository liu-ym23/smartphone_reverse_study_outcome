package com.suite.lark.emm.impl.clipboard.userscope;

import com.ss.android.lark.audit.userscope.auth.j;
import dagger.internal.Factory;
import doc.c;
import doc.f;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes40.dex */
public final class SCClipboardGlobalManager_Factory implements Factory<f> {
    private final Provider<j> authorizationManagerProvider;
    private final Provider<c> fgGlobalInternalProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public f get() {
        return newInstance(this.passportProvider.get(), this.fgGlobalInternalProvider.get(), this.authorizationManagerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SCClipboardGlobalManager_Factory(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<c> r101, Provider<j> r102) {
        this.passportProvider = r100;
        this.fgGlobalInternalProvider = r101;
        this.authorizationManagerProvider = r102;
    }

    public static SCClipboardGlobalManager_Factory create(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<c> r101, Provider<j> r102) {
        return new SCClipboardGlobalManager_Factory(r100, r101, r102);
    }

    public static f newInstance(com.ss.android.lark.passportc.api.j r100, c r101, j r102) {
        return new f(r100, r101, r102);
    }
}
