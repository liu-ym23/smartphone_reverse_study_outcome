package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes5.dex */
class TTSocketAccelerateJni implements TTSocketAccelerate.Natives {
    public static final JniStaticTestMocker<TTSocketAccelerate.Natives> TEST_HOOKS = null;
    private static TTSocketAccelerate.Natives testInstance;

    public TTSocketAccelerateJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static TTSocketAccelerate.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        TTSocketAccelerate.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.TTSocketAccelerate.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new TTSocketAccelerateJni();
    }

    public static /* synthetic */ TTSocketAccelerate.Natives access$002(TTSocketAccelerate.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.net.TTSocketAccelerate.Natives
    public void OnCheckSystemAvailableResult(long r100, TTSocketAccelerate r101, int r102) {
        GEN_JNI.com_ttnet_org_chromium_net_TTSocketAccelerate_OnCheckSystemAvailableResult(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.TTSocketAccelerate.Natives
    public void OnNotifyAccelerateResult(long r100, TTSocketAccelerate r101, int r102, int r103) {
        GEN_JNI.com_ttnet_org_chromium_net_TTSocketAccelerate_OnNotifyAccelerateResult(r100, r101, r102, r103);
    }
}
