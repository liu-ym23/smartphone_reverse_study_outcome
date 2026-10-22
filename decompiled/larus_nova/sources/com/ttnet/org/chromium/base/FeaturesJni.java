package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
@MainDex
class FeaturesJni implements Features.Natives {
    public static final JniStaticTestMocker<Features.Natives> TEST_HOOKS = null;
    private static Features.Natives testInstance;

    public FeaturesJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static Features.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        Features.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.Features.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new FeaturesJni();
    }

    public static /* synthetic */ Features.Natives access$002(Features.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.base.Features.Natives
    public boolean isEnabled(long r100) {
        return GEN_JNI.com_ttnet_org_chromium_base_Features_isEnabled(r100);
    }

    @Override // com.ttnet.org.chromium.base.Features.Natives
    public boolean getFieldTrialParamByFeatureAsBoolean(long r100, String r101, boolean r102) {
        return GEN_JNI.com_ttnet_org_chromium_base_Features_getFieldTrialParamByFeatureAsBoolean(r100, r101, r102);
    }
}
