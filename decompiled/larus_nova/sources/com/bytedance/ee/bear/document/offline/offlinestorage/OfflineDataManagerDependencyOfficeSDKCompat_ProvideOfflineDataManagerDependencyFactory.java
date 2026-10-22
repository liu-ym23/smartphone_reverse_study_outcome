package com.bytedance.ee.bear.document.offline.offlinestorage;

import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import k25.a;
import k25.b;
import k25.j0;
import k25.k0;

/* JADX INFO: loaded from: classes16.dex */
public final class OfflineDataManagerDependencyOfficeSDKCompat_ProvideOfflineDataManagerDependencyFactory implements Factory<a> {
    private final k0 module;

    @Override // javax.inject.Provider
    public a get() {
        return provideOfflineDataManagerDependency(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfflineDataManagerDependencyOfficeSDKCompat_ProvideOfflineDataManagerDependencyFactory(k0 r100) {
        this.module = r100;
    }

    public static OfflineDataManagerDependencyOfficeSDKCompat_ProvideOfflineDataManagerDependencyFactory create(k0 r100) {
        return new OfflineDataManagerDependencyOfficeSDKCompat_ProvideOfflineDataManagerDependencyFactory(r100);
    }

    public static a provideOfflineDataManagerDependency(k0 r100) {
        r100.getClass();
        if (CCMOfficeSDKAssembleFG.b() == true) goto L8;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L8;
        Object r101 = new b();
    L10:
        return (a) Preconditions.checkNotNullFromProvides(r101);
    L8:
        r101 = new j0();
        goto L10
    }
}
