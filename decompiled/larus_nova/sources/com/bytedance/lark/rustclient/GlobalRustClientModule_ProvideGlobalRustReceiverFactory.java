package com.bytedance.lark.rustclient;

import com.bytedance.lark.rustclient.internal.m;
import com.bytedance.lark.rustclient.internal.t;
import com.bytedance.lark.sdk.refactor.i;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class GlobalRustClientModule_ProvideGlobalRustReceiverFactory implements Factory<i> {
    private final Provider<m> registryProvider;

    @Override // javax.inject.Provider
    public i get() {
        return provideGlobalRustReceiver(this.registryProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GlobalRustClientModule_ProvideGlobalRustReceiverFactory(Provider<m> r100) {
        this.registryProvider = r100;
    }

    public static GlobalRustClientModule_ProvideGlobalRustReceiverFactory create(Provider<m> r100) {
        return new GlobalRustClientModule_ProvideGlobalRustReceiverFactory(r100);
    }

    public static i provideGlobalRustReceiver(m r100) {
        int r101 = b.f253941a;
        Intrinsics.checkNotNullParameter(r100, "registry");
        return (i) Preconditions.checkNotNullFromProvides((t) r100);
    }
}
