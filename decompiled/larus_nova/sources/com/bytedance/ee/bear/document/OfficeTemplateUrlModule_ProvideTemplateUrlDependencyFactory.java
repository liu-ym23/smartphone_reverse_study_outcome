package com.bytedance.ee.bear.document;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeTemplateUrlModule_ProvideTemplateUrlDependencyFactory implements Factory<com.bytedance.ee.bear.document.template.a> {
    private final Provider<jdb.g> featureGatingServiceProvider;
    private final t5 module;
    private final Provider<t45.c> spaceKitUrlHelperProvider;
    private final Provider<String> uidProvider;

    @Override // javax.inject.Provider
    public com.bytedance.ee.bear.document.template.a get() {
        return provideTemplateUrlDependency(this.module, this.uidProvider.get(), this.spaceKitUrlHelperProvider.get(), this.featureGatingServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeTemplateUrlModule_ProvideTemplateUrlDependencyFactory(t5 r100, Provider<String> r101, Provider<t45.c> r102, Provider<jdb.g> r103) {
        this.module = r100;
        this.uidProvider = r101;
        this.spaceKitUrlHelperProvider = r102;
        this.featureGatingServiceProvider = r103;
    }

    public static OfficeTemplateUrlModule_ProvideTemplateUrlDependencyFactory create(t5 r100, Provider<String> r101, Provider<t45.c> r102, Provider<jdb.g> r103) {
        return new OfficeTemplateUrlModule_ProvideTemplateUrlDependencyFactory(r100, r101, r102, r103);
    }

    public static com.bytedance.ee.bear.document.template.a provideTemplateUrlDependency(t5 r100, String r101, t45.c r102, jdb.g r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "uid");
        Intrinsics.checkNotNullParameter(r102, "spaceKitUrlHelper");
        Intrinsics.checkNotNullParameter(r103, "featureGatingService");
        Object r104 = (com.bytedance.ee.bear.document.template.a) OfficeSDKManager.getHostUserService(r101, com.bytedance.ee.bear.document.template.a.class);
        if (r104 != null) goto L6;
        r104 = new s5(r103, r102);
    L6:
        return (com.bytedance.ee.bear.document.template.a) Preconditions.checkNotNullFromProvides(r104);
    }
}
