package com.bytedance.lark.rustclient;

import com.bytedance.lark.rustclient.api.g;
import com.bytedance.lark.rustclient.api.i;
import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class UserRustClientModule_ProvidePureClientFactory implements Factory<i> {
    private final Provider<l> clientProvider;

    @Override // javax.inject.Provider
    public i get() {
        return providePureClient(this.clientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserRustClientModule_ProvidePureClientFactory(Provider<l> r100) {
        this.clientProvider = r100;
    }

    public static UserRustClientModule_ProvidePureClientFactory create(Provider<l> r100) {
        return new UserRustClientModule_ProvidePureClientFactory(r100);
    }

    public static i providePureClient(l r100) {
        int r101 = c.f253942a;
        Intrinsics.checkNotNullParameter(r100, "client");
        return (i) Preconditions.checkNotNullFromProvides(new g(r100));
    }
}
