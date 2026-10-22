package com.ss.android.lark.search.doubao.env;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class ASLRustImpl_Factory implements Factory<b> {
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ASLRustImpl_Factory(Provider<l> r100) {
        this.rustClientProvider = r100;
    }

    public static ASLRustImpl_Factory create(Provider<l> r100) {
        return new ASLRustImpl_Factory(r100);
    }

    public static b newInstance(l r100) {
        return new b(r100);
    }
}
