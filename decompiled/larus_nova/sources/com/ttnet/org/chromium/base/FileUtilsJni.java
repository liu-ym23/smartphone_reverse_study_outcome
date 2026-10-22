package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
public class FileUtilsJni implements FileUtils.Natives {
    public static final JniStaticTestMocker<FileUtils.Natives> TEST_HOOKS = null;
    private static FileUtils.Natives testInstance;

    public FileUtilsJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static FileUtils.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        FileUtils.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.FileUtils.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new FileUtilsJni();
    }

    public static /* synthetic */ FileUtils.Natives access$002(FileUtils.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.base.FileUtils.Natives
    public String getAbsoluteFilePath(String r100) {
        return GEN_JNI.com_ttnet_org_chromium_base_FileUtils_getAbsoluteFilePath(r100);
    }
}
