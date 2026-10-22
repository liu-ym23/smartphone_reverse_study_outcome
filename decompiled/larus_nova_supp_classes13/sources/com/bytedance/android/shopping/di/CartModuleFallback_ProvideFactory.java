package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.g;
import sc3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartModuleFallback_ProvideFactory implements Factory<e> {
    private final g module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public e m850get() {
        return provideInstance(null);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m850get();
    }

    public CartModuleFallback_ProvideFactory(g r1) {
    }

    public static CartModuleFallback_ProvideFactory create(g r1) {
        return new CartModuleFallback_ProvideFactory(r1);
    }

    public static e provideInstance(g r0) {
        return proxyProvide(r0);
    }

    public static e proxyProvide(g r0) {
        throw null;
    }
}
