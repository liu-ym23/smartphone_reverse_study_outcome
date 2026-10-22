package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes5.dex */
class TTAppSecurityManagerJni implements TTAppSecurityManager.Natives {
    public static final JniStaticTestMocker<TTAppSecurityManager.Natives> TEST_HOOKS = null;
    private static TTAppSecurityManager.Natives testInstance;

    public TTAppSecurityManagerJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static TTAppSecurityManager.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        TTAppSecurityManager.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.TTAppSecurityManager.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new TTAppSecurityManagerJni();
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.Natives
    public boolean isTTPRestrictionEnabled() {
        return GEN_JNI.com_ttnet_org_chromium_net_TTAppSecurityManager_isTTPRestrictionEnabled();
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.Natives
    public boolean isUserPrivacyRestrictionEnabled() {
        return GEN_JNI.com_ttnet_org_chromium_net_TTAppSecurityManager_isUserPrivacyRestrictionEnabled();
    }

    public static /* synthetic */ TTAppSecurityManager.Natives access$002(TTAppSecurityManager.Natives r100) {
        testInstance = r100;
        return r100;
    }
}
