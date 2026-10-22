package com.bytedance.lark.rustclient;

import com.bytedance.lark.rustclient.api.h;
import com.bytedance.lark.rustclient.internal.i;
import com.bytedance.lark.rustclient.internal.l;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class GlobalRustClientModule_ProvideDispatcherFactory implements Factory<l> {
    private final Provider<h> clientProvider;

    @Override // javax.inject.Provider
    public l get() {
        return provideDispatcher(this.clientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GlobalRustClientModule_ProvideDispatcherFactory(Provider<h> r100) {
        this.clientProvider = r100;
    }

    public static GlobalRustClientModule_ProvideDispatcherFactory create(Provider<h> r100) {
        return new GlobalRustClientModule_ProvideDispatcherFactory(r100);
    }

    public static l provideDispatcher(h r100) {
        int r101 = b.f253941a;
        Intrinsics.checkNotNullParameter(r100, "client");
        return (l) Preconditions.checkNotNullFromProvides(((i) r100).f253991f);
    }
}
