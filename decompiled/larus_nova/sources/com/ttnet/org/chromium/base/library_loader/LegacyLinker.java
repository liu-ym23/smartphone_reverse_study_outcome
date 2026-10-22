package com.ttnet.org.chromium.base.library_loader;

import com.ttnet.org.chromium.base.Log;

/* JADX INFO: loaded from: classes41.dex */
class LegacyLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "LegacyLinker";

    private static native boolean nativeAddZipArchivePath(String r100);

    private static native boolean nativeCreateSharedRelro(String r100, long r101, Linker.LibInfo r102);

    private static native boolean nativeLoadLibrary(String r100, long r101, Linker.LibInfo r102);

    private static native boolean nativeUseSharedRelro(String r100, Linker.LibInfo r101);

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    public boolean keepMemoryReservationUntilLoad() {
        return false;
    }

    static {
    }

    public LegacyLinker() {
    }

    private static void useSharedRelrosLocked(Linker.LibInfo r100) {
        String r101 = r100.mLibFilePath;
        if (nativeUseSharedRelro(r101, r100) == true) goto L6;
        Log.w(TAG, "Could not use shared RELRO section for %s", new Object[]{r101});
        return;
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    public void setApkFilePath(String r100) {
        ensureInitializedImplicitlyAsLastResort();
        Object r101 = this.mLock;
        monitor-enter(r101);
        nativeAddZipArchivePath(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker
    public void loadLibraryImplLocked(String r100, int r101) {
        String r102 = System.mapLibraryName(r100);
        Linker.LibInfo r103 = this.mLocalLibInfo;
        if (nativeLoadLibrary(r102, r103.mLoadAddress, r103) == false) goto L14;
        Linker.LibInfo r104 = this.mLocalLibInfo;
        r104.mLibFilePath = r102;
        if (r101 == 1) goto L10;
        if (r101 == 0) goto L10;
        waitForSharedRelrosLocked();
        useSharedRelrosLocked(this.mRemoteLibInfo);
        this.mRemoteLibInfo.close();
        this.mRemoteLibInfo = null;
        this.mState = 3;
        return;
    L10:
        if (nativeCreateSharedRelro(r102, r104.mLoadAddress, r104) == true) goto L12;
        Log.w(TAG, "Could not create shared RELRO for %s at %x", new Object[]{r102, Long.valueOf(this.mLocalLibInfo.mLoadAddress)});
        this.mLocalLibInfo.mRelroFd = -1;
    L12:
        useSharedRelrosLocked(this.mLocalLibInfo);
        this.mState = 2;
        return;
    L14:
        String r105 = "Unable to load library: " + r102;
        Log.e(TAG, r105, new Object[0]);
        throw new UnsatisfiedLinkError(r105);
    }
}
