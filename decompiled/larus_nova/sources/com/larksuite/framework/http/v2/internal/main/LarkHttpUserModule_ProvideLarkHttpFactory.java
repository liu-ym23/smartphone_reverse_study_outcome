package com.larksuite.framework.http.v2.internal.main;

import com.bytedance.lark.rustclient.api.l;
import com.larksuite.framework.http.v2.internal.rust.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class LarkHttpUserModule_ProvideLarkHttpFactory implements Factory<com.larksuite.framework.http.v2.b> {
    private final Provider<com.larksuite.framework.http.v2.a> larkCookiesProvider;
    private final Provider<l> rustClientProvider;
    private final Provider<e28.c> uaSupporterProvider;

    @Override // javax.inject.Provider
    public com.larksuite.framework.http.v2.b get() {
        return provideLarkHttp(this.larkCookiesProvider.get(), this.uaSupporterProvider.get(), this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LarkHttpUserModule_ProvideLarkHttpFactory(Provider<com.larksuite.framework.http.v2.a> r100, Provider<e28.c> r101, Provider<l> r102) {
        this.larkCookiesProvider = r100;
        this.uaSupporterProvider = r101;
        this.rustClientProvider = r102;
    }

    public static LarkHttpUserModule_ProvideLarkHttpFactory create(Provider<com.larksuite.framework.http.v2.a> r100, Provider<e28.c> r101, Provider<l> r102) {
        return new LarkHttpUserModule_ProvideLarkHttpFactory(r100, r101, r102);
    }

    public static com.larksuite.framework.http.v2.b provideLarkHttp(com.larksuite.framework.http.v2.a r100, e28.c r101, l r102) {
        int r103 = d.f285596a;
        Intrinsics.checkNotNullParameter(r100, "larkCookies");
        Intrinsics.checkNotNullParameter(r101, "uaSupporter");
        Intrinsics.checkNotNullParameter(r102, "rustClient");
        return (com.larksuite.framework.http.v2.b) Preconditions.checkNotNullFromProvides(new LarkHttpImpl(new h(r102), r100, r101));
    }
}
