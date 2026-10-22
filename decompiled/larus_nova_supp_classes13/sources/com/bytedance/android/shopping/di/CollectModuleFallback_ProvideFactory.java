package com.bytedance.android.shopping.di;

import dagger.internal.Factory;
import gd3.h;
import sc3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CollectModuleFallback_ProvideFactory implements Factory<g> {
    private final h module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public g m851get() {
        return provideInstance(null);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m851get();
    }

    public CollectModuleFallback_ProvideFactory(h r1) {
    }

    public static CollectModuleFallback_ProvideFactory create(h r1) {
        return new CollectModuleFallback_ProvideFactory(r1);
    }

    public static g provideInstance(h r0) {
        return proxyProvide(r0);
    }

    public static g proxyProvide(h r0) {
        throw null;
    }
}
