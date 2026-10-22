package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.q;
import sc3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class YataModuleFallback_ProvideFactory implements Factory<j> {
    private final q module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public j m857get() {
        return provideInstance(null);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m857get();
    }

    public YataModuleFallback_ProvideFactory(q r1) {
    }

    public static YataModuleFallback_ProvideFactory create(q r1) {
        return new YataModuleFallback_ProvideFactory(r1);
    }

    public static j provideInstance(q r0) {
        return proxyProvide(r0);
    }

    public static j proxyProvide(q r0) {
        throw null;
    }
}
