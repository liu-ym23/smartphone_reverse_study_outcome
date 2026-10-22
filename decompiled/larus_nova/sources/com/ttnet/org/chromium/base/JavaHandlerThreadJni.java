package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
@MainDex
class JavaHandlerThreadJni implements JavaHandlerThread.Natives {
    public static final JniStaticTestMocker<JavaHandlerThread.Natives> TEST_HOOKS = null;
    private static JavaHandlerThread.Natives testInstance;

    public JavaHandlerThreadJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static JavaHandlerThread.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        JavaHandlerThread.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.JavaHandlerThread.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new JavaHandlerThreadJni();
    }

    public static /* synthetic */ JavaHandlerThread.Natives access$002(JavaHandlerThread.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.base.JavaHandlerThread.Natives
    public void onLooperStopped(long r100) {
        GEN_JNI.com_ttnet_org_chromium_base_JavaHandlerThread_onLooperStopped(r100);
    }

    @Override // com.ttnet.org.chromium.base.JavaHandlerThread.Natives
    public void initializeThread(long r100, long r101) {
        GEN_JNI.com_ttnet_org_chromium_base_JavaHandlerThread_initializeThread(r100, r101);
    }
}
