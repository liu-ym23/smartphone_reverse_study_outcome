package com.bytedance.ee.bear;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes15.dex */
public final class OfficeCCMUserServiceImpl_Factory implements Factory<n> {
    private final Provider<ik5.a> docsSdkProvider;
    private final Provider<t45.c> iSpaceKitUrlHelperProvider;
    private final Provider<com.bytedance.ee.bear.init.a> officeCCMGlobalInitProvider;
    private final Provider<com.bytedance.ee.bear.init.b> officeCCMUserInitProvider;
    private final Provider<com.bytedance.ee.bear.office.export.space.a> officeSpaceSdkProvider;

    @Override // javax.inject.Provider
    public n get() {
        return newInstance(this.docsSdkProvider.get(), this.officeSpaceSdkProvider.get(), this.officeCCMGlobalInitProvider.get(), this.officeCCMUserInitProvider.get(), this.iSpaceKitUrlHelperProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeCCMUserServiceImpl_Factory(Provider<ik5.a> r100, Provider<com.bytedance.ee.bear.office.export.space.a> r101, Provider<com.bytedance.ee.bear.init.a> r102, Provider<com.bytedance.ee.bear.init.b> r103, Provider<t45.c> r104) {
        this.docsSdkProvider = r100;
        this.officeSpaceSdkProvider = r101;
        this.officeCCMGlobalInitProvider = r102;
        this.officeCCMUserInitProvider = r103;
        this.iSpaceKitUrlHelperProvider = r104;
    }

    public static OfficeCCMUserServiceImpl_Factory create(Provider<ik5.a> r100, Provider<com.bytedance.ee.bear.office.export.space.a> r101, Provider<com.bytedance.ee.bear.init.a> r102, Provider<com.bytedance.ee.bear.init.b> r110, Provider<t45.c> r111) {
        return new OfficeCCMUserServiceImpl_Factory(r100, r101, r102, r110, r111);
    }

    public static n newInstance(ik5.a r100, com.bytedance.ee.bear.office.export.space.a r101, com.bytedance.ee.bear.init.a r102, com.bytedance.ee.bear.init.b r110, t45.c r111) {
        return new n(r100, r101, r102, r110, r111);
    }
}
