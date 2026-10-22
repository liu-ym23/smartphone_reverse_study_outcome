package com.ss.android.lark.docs.icon.net;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import qbb.a;
import qbb.b;
import qbb.d;

/* JADX INFO: loaded from: classes35.dex */
public final class UserRustMetaModule_ProvideDwarfUserRustMetaFactory implements Factory<a> {
    private final Provider<l> iRustClientProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideDwarfUserRustMeta(this.iRustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserRustMetaModule_ProvideDwarfUserRustMetaFactory(Provider<l> r100) {
        this.iRustClientProvider = r100;
    }

    public static UserRustMetaModule_ProvideDwarfUserRustMetaFactory create(Provider<l> r100) {
        return new UserRustMetaModule_ProvideDwarfUserRustMetaFactory(r100);
    }

    public static a provideDwarfUserRustMeta(l r100) {
        int r101 = d.f532427a;
        Intrinsics.checkNotNullParameter(r100, "iRustClient");
        return (a) Preconditions.checkNotNullFromProvides(new b(r100));
    }
}
