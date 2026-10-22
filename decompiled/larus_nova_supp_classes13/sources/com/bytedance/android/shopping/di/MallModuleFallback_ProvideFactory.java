package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.k;
import n83.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallModuleFallback_ProvideFactory implements Factory<h> {
    private final k module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public h m852get() {
        return provideInstance(null);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m852get();
    }

    public MallModuleFallback_ProvideFactory(k r1) {
    }

    public static MallModuleFallback_ProvideFactory create(k r1) {
        return new MallModuleFallback_ProvideFactory(r1);
    }

    public static h provideInstance(k r0) {
        return proxyProvide(r0);
    }

    public static h proxyProvide(k r0) {
        throw null;
    }
}
