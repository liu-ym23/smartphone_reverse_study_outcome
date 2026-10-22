package com.bytedance.lark.sdk.refactor;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class RustSdkModule_ProvideStateContextFactory implements Factory<com.bytedance.lark.sdk.refactor.state.c> {
    private final Provider<o> definitionProvider;
    private final Provider<l> invokerProvider;

    @Override // javax.inject.Provider
    public com.bytedance.lark.sdk.refactor.state.c get() {
        return provideStateContext(this.definitionProvider.get(), this.invokerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public RustSdkModule_ProvideStateContextFactory(Provider<o> r100, Provider<l> r101) {
        this.definitionProvider = r100;
        this.invokerProvider = r101;
    }

    public static RustSdkModule_ProvideStateContextFactory create(Provider<o> r100, Provider<l> r101) {
        return new RustSdkModule_ProvideStateContextFactory(r100, r101);
    }

    public static com.bytedance.lark.sdk.refactor.state.c provideStateContext(o r100, l r101) {
        int r102 = h0.f254272a;
        Intrinsics.checkNotNullParameter(r100, "definition");
        Intrinsics.checkNotNullParameter(r101, "invoker");
        if (r100.a() == false) goto L5;
        Object r103 = ((RustCommunicator) r101).f254215c;
    L7:
        return (com.bytedance.lark.sdk.refactor.state.c) Preconditions.checkNotNullFromProvides(r103);
    L5:
        r103 = new com.bytedance.lark.sdk.refactor.state.a();
        goto L7
    }
}
