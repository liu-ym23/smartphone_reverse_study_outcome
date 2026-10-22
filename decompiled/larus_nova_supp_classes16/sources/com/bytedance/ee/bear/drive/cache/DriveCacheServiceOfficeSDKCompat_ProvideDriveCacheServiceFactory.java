package com.bytedance.ee.bear.drive.cache;

import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveCacheServiceOfficeSDKCompat_ProvideDriveCacheServiceFactory implements Factory<w> {
    private final Provider<by4.b> kvStorageProvider;
    private final u module;
    private final Provider<com.ss.android.lark.passportc.api.m> userServiceProvider;

    public w get() {
        return provideDriveCacheService(this.module, (by4.b) this.kvStorageProvider.get(), (com.ss.android.lark.passportc.api.m) this.userServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m326get() {
        return get();
    }

    public DriveCacheServiceOfficeSDKCompat_ProvideDriveCacheServiceFactory(u r1, Provider<by4.b> r2, Provider<com.ss.android.lark.passportc.api.m> r3) {
        this.module = r1;
        this.kvStorageProvider = r2;
        this.userServiceProvider = r3;
    }

    public static DriveCacheServiceOfficeSDKCompat_ProvideDriveCacheServiceFactory create(u r1, Provider<by4.b> r2, Provider<com.ss.android.lark.passportc.api.m> r3) {
        return new DriveCacheServiceOfficeSDKCompat_ProvideDriveCacheServiceFactory(r1, r2, r3);
    }

    public static w provideDriveCacheService(u r0, by4.b r1, com.ss.android.lark.passportc.api.m r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "kvStorage");
        Intrinsics.checkNotNullParameter(r2, "userService");
        if (CCMOfficeSDKAssembleFG.b() == true) goto L8;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L8;
        Object r3 = new c0(r1, r2);
    L10:
        return (w) Preconditions.checkNotNullFromProvides(r3);
    L8:
        r3 = new x(r1, r2);
        goto L10
    }
}
