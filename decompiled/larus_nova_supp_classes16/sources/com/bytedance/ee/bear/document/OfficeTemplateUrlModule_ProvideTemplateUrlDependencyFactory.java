package com.bytedance.ee.bear.document;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeTemplateUrlModule_ProvideTemplateUrlDependencyFactory implements Factory<com.bytedance.ee.bear.document.template.a> {
    private final Provider<jdb.g> featureGatingServiceProvider;
    private final t5 module;
    private final Provider<t45.c> spaceKitUrlHelperProvider;
    private final Provider<String> uidProvider;

    public com.bytedance.ee.bear.document.template.a get() {
        return provideTemplateUrlDependency(this.module, (String) this.uidProvider.get(), (t45.c) this.spaceKitUrlHelperProvider.get(), (jdb.g) this.featureGatingServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m180get() {
        return get();
    }

    public OfficeTemplateUrlModule_ProvideTemplateUrlDependencyFactory(t5 r1, Provider<String> r2, Provider<t45.c> r3, Provider<jdb.g> r4) {
        this.module = r1;
        this.uidProvider = r2;
        this.spaceKitUrlHelperProvider = r3;
        this.featureGatingServiceProvider = r4;
    }

    public static OfficeTemplateUrlModule_ProvideTemplateUrlDependencyFactory create(t5 r1, Provider<String> r2, Provider<t45.c> r3, Provider<jdb.g> r4) {
        return new OfficeTemplateUrlModule_ProvideTemplateUrlDependencyFactory(r1, r2, r3, r4);
    }

    public static com.bytedance.ee.bear.document.template.a provideTemplateUrlDependency(t5 r0, String r1, t45.c r2, jdb.g r3) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "uid");
        Intrinsics.checkNotNullParameter(r2, "spaceKitUrlHelper");
        Intrinsics.checkNotNullParameter(r3, "featureGatingService");
        Object r4 = (com.bytedance.ee.bear.document.template.a) OfficeSDKManager.getHostUserService(r1, com.bytedance.ee.bear.document.template.a.class);
        if (r4 != null) goto L6;
        r4 = new s5(r3, r2);
    L6:
        return (com.bytedance.ee.bear.document.template.a) Preconditions.checkNotNullFromProvides(r4);
    }
}
