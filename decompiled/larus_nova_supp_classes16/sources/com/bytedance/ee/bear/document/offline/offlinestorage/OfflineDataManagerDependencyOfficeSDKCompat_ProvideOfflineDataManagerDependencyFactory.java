package com.bytedance.ee.bear.document.offline.offlinestorage;

import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import k25.a;
import k25.b;
import k25.j0;
import k25.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfflineDataManagerDependencyOfficeSDKCompat_ProvideOfflineDataManagerDependencyFactory implements Factory<a> {
    private final k0 module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m227get() {
        return provideOfflineDataManagerDependency(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m227get();
    }

    public OfflineDataManagerDependencyOfficeSDKCompat_ProvideOfflineDataManagerDependencyFactory(k0 r1) {
        this.module = r1;
    }

    public static OfflineDataManagerDependencyOfficeSDKCompat_ProvideOfflineDataManagerDependencyFactory create(k0 r1) {
        return new OfflineDataManagerDependencyOfficeSDKCompat_ProvideOfflineDataManagerDependencyFactory(r1);
    }

    public static a provideOfflineDataManagerDependency(k0 r0) {
        r0.getClass();
        if (CCMOfficeSDKAssembleFG.b() == true) goto L8;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L8;
        Object r1 = new b();
    L10:
        return (a) Preconditions.checkNotNullFromProvides(r1);
    L8:
        r1 = new j0();
        goto L10
    }
}
