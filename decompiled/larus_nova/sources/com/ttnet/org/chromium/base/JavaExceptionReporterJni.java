package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
@MainDex
class JavaExceptionReporterJni implements JavaExceptionReporter.Natives {
    public static final JniStaticTestMocker<JavaExceptionReporter.Natives> TEST_HOOKS = null;
    private static JavaExceptionReporter.Natives testInstance;

    public JavaExceptionReporterJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static JavaExceptionReporter.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        JavaExceptionReporter.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.JavaExceptionReporter.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new JavaExceptionReporterJni();
    }

    public static /* synthetic */ JavaExceptionReporter.Natives access$002(JavaExceptionReporter.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.base.JavaExceptionReporter.Natives
    public void reportJavaStackTrace(String r100) {
        GEN_JNI.com_ttnet_org_chromium_base_JavaExceptionReporter_reportJavaStackTrace(r100);
    }

    @Override // com.ttnet.org.chromium.base.JavaExceptionReporter.Natives
    public void reportJavaException(boolean r100, Throwable r101) {
        GEN_JNI.com_ttnet_org_chromium_base_JavaExceptionReporter_reportJavaException(r100, r101);
    }
}
