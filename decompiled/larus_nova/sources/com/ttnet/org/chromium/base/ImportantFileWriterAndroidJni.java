package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
class ImportantFileWriterAndroidJni implements ImportantFileWriterAndroid.Natives {
    public static final JniStaticTestMocker<ImportantFileWriterAndroid.Natives> TEST_HOOKS = null;
    private static ImportantFileWriterAndroid.Natives testInstance;

    public ImportantFileWriterAndroidJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static ImportantFileWriterAndroid.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        ImportantFileWriterAndroid.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.ImportantFileWriterAndroid.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new ImportantFileWriterAndroidJni();
    }

    public static /* synthetic */ ImportantFileWriterAndroid.Natives access$002(ImportantFileWriterAndroid.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.base.ImportantFileWriterAndroid.Natives
    public boolean writeFileAtomically(String r100, byte[] r101) {
        return GEN_JNI.com_ttnet_org_chromium_base_ImportantFileWriterAndroid_writeFileAtomically(r100, r101);
    }
}
