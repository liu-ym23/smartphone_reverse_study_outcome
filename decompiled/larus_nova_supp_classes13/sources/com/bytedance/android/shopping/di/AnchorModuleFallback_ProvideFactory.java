package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.b;
import p83.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorModuleFallback_ProvideFactory implements Factory<d> {
    private final b module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public d m843get() {
        return provideInstance(null);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m843get();
    }

    public AnchorModuleFallback_ProvideFactory(b r1) {
    }

    public static AnchorModuleFallback_ProvideFactory create(b r1) {
        return new AnchorModuleFallback_ProvideFactory(r1);
    }

    public static d provideInstance(b r0) {
        return proxyProvide(r0);
    }

    public static d proxyProvide(b r0) {
        throw null;
    }
}
