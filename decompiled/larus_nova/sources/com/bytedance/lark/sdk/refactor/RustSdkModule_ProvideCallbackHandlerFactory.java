package com.bytedance.lark.sdk.refactor;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class RustSdkModule_ProvideCallbackHandlerFactory implements Factory<j> {
    private final Provider<k> communicatorProvider;
    private final Provider<o> definitionProvider;

    @Override // javax.inject.Provider
    public j get() {
        return provideCallbackHandler(this.definitionProvider.get(), this.communicatorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public RustSdkModule_ProvideCallbackHandlerFactory(Provider<o> r100, Provider<k> r101) {
        this.definitionProvider = r100;
        this.communicatorProvider = r101;
    }

    public static RustSdkModule_ProvideCallbackHandlerFactory create(Provider<o> r100, Provider<k> r101) {
        return new RustSdkModule_ProvideCallbackHandlerFactory(r100, r101);
    }

    public static j provideCallbackHandler(o r100, k r101) {
        int r102 = h0.f254272a;
        Intrinsics.checkNotNullParameter(r100, "definition");
        Intrinsics.checkNotNullParameter(r101, "communicator");
        if (r100.a() == false) goto L5;
        Object r103 = r101.o();
    L7:
        return (j) Preconditions.checkNotNullFromProvides(r103);
    L5:
        r103 = new d();
        goto L7
    }
}
