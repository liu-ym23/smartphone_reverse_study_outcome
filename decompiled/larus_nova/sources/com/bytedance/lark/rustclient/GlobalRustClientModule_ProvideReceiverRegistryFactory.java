package com.bytedance.lark.rustclient;

import com.bytedance.lark.rustclient.internal.k;
import com.bytedance.lark.rustclient.internal.m;
import com.bytedance.lark.rustclient.internal.t;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class GlobalRustClientModule_ProvideReceiverRegistryFactory implements Factory<m> {
    private final Provider<k> definitionProvider;

    @Override // javax.inject.Provider
    public m get() {
        return provideReceiverRegistry(this.definitionProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GlobalRustClientModule_ProvideReceiverRegistryFactory(Provider<k> r100) {
        this.definitionProvider = r100;
    }

    public static GlobalRustClientModule_ProvideReceiverRegistryFactory create(Provider<k> r100) {
        return new GlobalRustClientModule_ProvideReceiverRegistryFactory(r100);
    }

    public static m provideReceiverRegistry(k r100) {
        int r101 = b.f253941a;
        Intrinsics.checkNotNullParameter(r100, "definition");
        return (m) Preconditions.checkNotNullFromProvides(new t(r100));
    }
}
