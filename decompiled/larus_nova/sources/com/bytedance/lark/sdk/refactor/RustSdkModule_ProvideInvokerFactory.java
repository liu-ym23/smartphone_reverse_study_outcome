package com.bytedance.lark.sdk.refactor;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class RustSdkModule_ProvideInvokerFactory implements Factory<l> {
    private final Provider<k> communicatorProvider;
    private final Provider<o> definitionProvider;

    @Override // javax.inject.Provider
    public l get() {
        return provideInvoker(this.definitionProvider.get(), this.communicatorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public RustSdkModule_ProvideInvokerFactory(Provider<o> r100, Provider<k> r101) {
        this.definitionProvider = r100;
        this.communicatorProvider = r101;
    }

    public static RustSdkModule_ProvideInvokerFactory create(Provider<o> r100, Provider<k> r101) {
        return new RustSdkModule_ProvideInvokerFactory(r100, r101);
    }

    public static l provideInvoker(o r100, k r101) {
        int r102 = h0.f254272a;
        Intrinsics.checkNotNullParameter(r100, "definition");
        Intrinsics.checkNotNullParameter(r101, "communicator");
        Object r103 = r101;
        if (r100.a() == true) goto L7;
        r103 = new com.bytedance.lark.rustclient.internal.u(r100);
    L7:
        return (l) Preconditions.checkNotNullFromProvides(r103);
    }
}
