package com.ss.android.lark.docs.icon.net;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;
import qbb.b;

/* JADX INFO: loaded from: classes35.dex */
public final class RustMetaFetcherImpl_Factory implements Factory<b> {
    private final Provider<l> userClientProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public RustMetaFetcherImpl_Factory(Provider<l> r100) {
        this.userClientProvider = r100;
    }

    public static RustMetaFetcherImpl_Factory create(Provider<l> r100) {
        return new RustMetaFetcherImpl_Factory(r100);
    }

    public static b newInstance(l r100) {
        return new b(r100);
    }
}
