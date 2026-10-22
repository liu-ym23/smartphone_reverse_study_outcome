package com.ttnet.org.chromium.base.library_loader;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
@MainDex
class LibraryPrefetcherJni implements LibraryPrefetcher.Natives {
    public static final JniStaticTestMocker<LibraryPrefetcher.Natives> TEST_HOOKS = null;
    private static LibraryPrefetcher.Natives testInstance;

    public LibraryPrefetcherJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static LibraryPrefetcher.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        LibraryPrefetcher.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.library_loader.LibraryPrefetcher.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new LibraryPrefetcherJni();
    }

    @Override // com.ttnet.org.chromium.base.library_loader.LibraryPrefetcher.Natives
    public int percentageOfResidentNativeLibraryCode() {
        return GEN_JNI.com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_percentageOfResidentNativeLibraryCode();
    }

    @Override // com.ttnet.org.chromium.base.library_loader.LibraryPrefetcher.Natives
    public void forkAndPrefetchNativeLibrary() {
        GEN_JNI.com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_forkAndPrefetchNativeLibrary();
    }

    @Override // com.ttnet.org.chromium.base.library_loader.LibraryPrefetcher.Natives
    public void periodicallyCollectResidency() {
        GEN_JNI.com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_periodicallyCollectResidency();
    }

    public static /* synthetic */ LibraryPrefetcher.Natives access$002(LibraryPrefetcher.Natives r100) {
        testInstance = r100;
        return r100;
    }
}
