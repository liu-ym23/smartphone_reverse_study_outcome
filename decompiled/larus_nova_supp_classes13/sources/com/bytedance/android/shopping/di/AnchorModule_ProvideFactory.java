package com.bytedance.android.shopping.di;

import com.bytedance.android.shopping.service.ECAnchorV3Service;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import gd3.a;
import p83.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorModule_ProvideFactory implements Factory<d> {
    private final a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public d m846get() {
        return provideInstance(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m846get();
    }

    public AnchorModule_ProvideFactory(a r1) {
        this.module = r1;
    }

    public static AnchorModule_ProvideFactory create(a r1) {
        return new AnchorModule_ProvideFactory(r1);
    }

    public static d provideInstance(a r0) {
        return proxyProvide(r0);
    }

    public static d proxyProvide(a r1) {
        r1.getClass();
        return (d) Preconditions.checkNotNull(ECAnchorV3Service.i, "Cannot return null from a non-@Nullable @Provides method");
    }
}
