package com.suite.lark.emm.impl.clipboard.userscope.export;

import dagger.internal.Factory;
import doc.d;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes40.dex */
public final class SCClipboardProviderGlobal_Factory implements Factory<b> {
    private final Provider<d> clipboardServiceProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.clipboardServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SCClipboardProviderGlobal_Factory(Provider<d> r100) {
        this.clipboardServiceProvider = r100;
    }

    public static SCClipboardProviderGlobal_Factory create(Provider<d> r100) {
        return new SCClipboardProviderGlobal_Factory(r100);
    }

    public static b newInstance(d r100) {
        return new b(r100);
    }
}
