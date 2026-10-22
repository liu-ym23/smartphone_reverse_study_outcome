package com.larksuite.framework.http.v2.internal.main;

import com.bytedance.lark.rustclient.api.h;
import com.larksuite.framework.http.v2.internal.rust.GlobalClientProvider;
import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class LarkHttpGlobalModule_ProvideLarkHttpFactory implements Factory<com.larksuite.framework.http.v2.b> {
    private final Provider<com.larksuite.framework.http.v2.a> larkCookiesProvider;
    private final Provider<j> passportProvider;
    private final Provider<h> rustClientProvider;
    private final Provider<e28.c> uaSupporterProvider;

    @Override // javax.inject.Provider
    public com.larksuite.framework.http.v2.b get() {
        return provideLarkHttp(this.larkCookiesProvider.get(), this.uaSupporterProvider.get(), this.passportProvider.get(), this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LarkHttpGlobalModule_ProvideLarkHttpFactory(Provider<com.larksuite.framework.http.v2.a> r100, Provider<e28.c> r101, Provider<j> r102, Provider<h> r103) {
        this.larkCookiesProvider = r100;
        this.uaSupporterProvider = r101;
        this.passportProvider = r102;
        this.rustClientProvider = r103;
    }

    public static LarkHttpGlobalModule_ProvideLarkHttpFactory create(Provider<com.larksuite.framework.http.v2.a> r100, Provider<e28.c> r101, Provider<j> r102, Provider<h> r103) {
        return new LarkHttpGlobalModule_ProvideLarkHttpFactory(r100, r101, r102, r103);
    }

    public static com.larksuite.framework.http.v2.b provideLarkHttp(com.larksuite.framework.http.v2.a r100, e28.c r101, final j r102, h r103) {
        int r104 = c.f285595a;
        Intrinsics.checkNotNullParameter(r100, "larkCookies");
        Intrinsics.checkNotNullParameter(r101, "uaSupporter");
        Intrinsics.checkNotNullParameter(r102, "passport");
        Intrinsics.checkNotNullParameter(r103, "rustClient");
        return (com.larksuite.framework.http.v2.b) Preconditions.checkNotNullFromProvides(new LarkHttpImpl(new GlobalClientProvider(r103, new LarkHttpGlobalModule$provideLarkHttp$1(r102)), r100, r101));
    }
}
