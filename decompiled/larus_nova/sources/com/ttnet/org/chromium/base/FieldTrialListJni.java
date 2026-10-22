package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
@MainDex
class FieldTrialListJni implements FieldTrialList.Natives {
    public static final JniStaticTestMocker<FieldTrialList.Natives> TEST_HOOKS = null;
    private static FieldTrialList.Natives testInstance;

    public FieldTrialListJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static FieldTrialList.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        FieldTrialList.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.FieldTrialList.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new FieldTrialListJni();
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public void logActiveTrials() {
        GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_logActiveTrials();
    }

    public static /* synthetic */ FieldTrialList.Natives access$002(FieldTrialList.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public String findFullName(String r100) {
        return GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_findFullName(r100);
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public boolean trialExists(String r100) {
        return GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_trialExists(r100);
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public boolean createFieldTrial(String r100, String r101) {
        return GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_createFieldTrial(r100, r101);
    }

    @Override // com.ttnet.org.chromium.base.FieldTrialList.Natives
    public String getVariationParameter(String r100, String r101) {
        return GEN_JNI.com_ttnet_org_chromium_base_FieldTrialList_getVariationParameter(r100, r101);
    }
}
