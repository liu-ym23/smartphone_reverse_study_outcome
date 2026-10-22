package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes5.dex */
class CronetLibraryLoaderJni implements CronetLibraryLoader.Natives {
    public static final JniStaticTestMocker<CronetLibraryLoader.Natives> TEST_HOOKS = null;
    private static CronetLibraryLoader.Natives testInstance;

    public CronetLibraryLoaderJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static CronetLibraryLoader.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetLibraryLoader.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetLibraryLoader.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetLibraryLoaderJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLibraryLoader.Natives
    public String getCronetVersion() {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetLibraryLoader_getCronetVersion();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLibraryLoader.Natives
    public void createNetworkChangeNotifierOnInitThread() {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetLibraryLoader_createNetworkChangeNotifierOnInitThread();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLibraryLoader.Natives
    public void cronetInitOnInitThread() {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetLibraryLoader_cronetInitOnInitThread();
    }

    public static /* synthetic */ CronetLibraryLoader.Natives access$002(CronetLibraryLoader.Natives r100) {
        testInstance = r100;
        return r100;
    }
}
