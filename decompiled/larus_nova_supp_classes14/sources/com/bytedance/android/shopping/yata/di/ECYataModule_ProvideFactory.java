package com.bytedance.android.shopping.yata.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ml3.a;
import sc3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECYataModule_ProvideFactory implements Factory<j> {
    private final a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public j m507get() {
        return provideInstance(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m507get();
    }

    public ECYataModule_ProvideFactory(a r1) {
        this.module = r1;
    }

    public static ECYataModule_ProvideFactory create(a r1) {
        return new ECYataModule_ProvideFactory(r1);
    }

    public static j provideInstance(a r0) {
        return proxyProvide(r0);
    }

    public static j proxyProvide(a r1) {
        r1.getClass();
        return (j) Preconditions.checkNotNull(new ol3.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
