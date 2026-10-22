package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
@MainDex
public class FeatureListJni implements FeatureList.Natives {
    public static final JniStaticTestMocker<FeatureList.Natives> TEST_HOOKS = null;
    private static FeatureList.Natives testInstance;

    public FeatureListJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static FeatureList.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        FeatureList.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.FeatureList.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new FeatureListJni();
    }

    @Override // com.ttnet.org.chromium.base.FeatureList.Natives
    public boolean isInitialized() {
        return GEN_JNI.com_ttnet_org_chromium_base_FeatureList_isInitialized();
    }

    public static /* synthetic */ FeatureList.Natives access$002(FeatureList.Natives r100) {
        testInstance = r100;
        return r100;
    }
}
