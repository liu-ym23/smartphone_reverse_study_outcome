package com.ss.android.lark.integrator.security.compliance;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class SCClipboardProviderGlobalOfficeSDK_Factory implements Factory<SCClipboardProviderGlobalOfficeSDK> {
    private final Provider<doc.d> clipboardServiceProvider;

    @Override // javax.inject.Provider
    public SCClipboardProviderGlobalOfficeSDK get() {
        return newInstance(this.clipboardServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SCClipboardProviderGlobalOfficeSDK_Factory(Provider<doc.d> r100) {
        this.clipboardServiceProvider = r100;
    }

    public static SCClipboardProviderGlobalOfficeSDK_Factory create(Provider<doc.d> r100) {
        return new SCClipboardProviderGlobalOfficeSDK_Factory(r100);
    }

    public static SCClipboardProviderGlobalOfficeSDK newInstance(doc.d r100) {
        return new SCClipboardProviderGlobalOfficeSDK(r100);
    }
}
