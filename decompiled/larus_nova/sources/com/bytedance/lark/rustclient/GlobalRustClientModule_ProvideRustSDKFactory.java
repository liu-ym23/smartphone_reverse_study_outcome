package com.bytedance.lark.rustclient;

import com.bytedance.lark.rustclient.internal.n;
import com.bytedance.lark.rustclient.internal.u;
import com.bytedance.lark.sdk.refactor.o;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class GlobalRustClientModule_ProvideRustSDKFactory implements Factory<n> {
    private final Provider<o> definitionProvider;

    @Override // javax.inject.Provider
    public n get() {
        return provideRustSDK(this.definitionProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GlobalRustClientModule_ProvideRustSDKFactory(Provider<o> r100) {
        this.definitionProvider = r100;
    }

    public static GlobalRustClientModule_ProvideRustSDKFactory create(Provider<o> r100) {
        return new GlobalRustClientModule_ProvideRustSDKFactory(r100);
    }

    public static n provideRustSDK(o r100) {
        int r101 = b.f253941a;
        Intrinsics.checkNotNullParameter(r100, "definition");
        return (n) Preconditions.checkNotNullFromProvides(new u(r100));
    }
}
