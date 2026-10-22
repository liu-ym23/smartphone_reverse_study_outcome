package com.bytedance.lark.rustclient;

import com.bytedance.lark.rustclient.internal.l;
import com.bytedance.lark.rustclient.internal.x;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class UserRustClientModule_ProvideDispatcherFactory implements Factory<l> {
    private final Provider<com.bytedance.lark.rustclient.api.l> clientProvider;

    @Override // javax.inject.Provider
    public l get() {
        return provideDispatcher(this.clientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserRustClientModule_ProvideDispatcherFactory(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        this.clientProvider = r100;
    }

    public static UserRustClientModule_ProvideDispatcherFactory create(Provider<com.bytedance.lark.rustclient.api.l> r100) {
        return new UserRustClientModule_ProvideDispatcherFactory(r100);
    }

    public static l provideDispatcher(com.bytedance.lark.rustclient.api.l r100) {
        int r101 = c.f253942a;
        Intrinsics.checkNotNullParameter(r100, "client");
        return (l) Preconditions.checkNotNullFromProvides(((x) r100).f254031e);
    }
}
