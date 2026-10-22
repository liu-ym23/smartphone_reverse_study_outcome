package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.e;
import sc3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BuyNowModuleFallback_ProvideFactory implements Factory<c> {
    private final e module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public c m848get() {
        return provideInstance(null);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m848get();
    }

    public BuyNowModuleFallback_ProvideFactory(e r1) {
    }

    public static BuyNowModuleFallback_ProvideFactory create(e r1) {
        return new BuyNowModuleFallback_ProvideFactory(r1);
    }

    public static c provideInstance(e r0) {
        return proxyProvide(r0);
    }

    public static c proxyProvide(e r0) {
        throw null;
    }
}
