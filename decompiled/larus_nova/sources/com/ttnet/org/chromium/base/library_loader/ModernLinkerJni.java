package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes41.dex */
class ModernLinkerJni implements ModernLinker.Natives {
    private static final String TAG = "ModernLinkerJni";

    public ModernLinkerJni() {
    }

    private static native int nativeGetRelroSharingResult();

    private static native boolean nativeLoadLibrary(String r100, Linker.LibInfo r101, boolean r102);

    private static native boolean nativeUseRelros(long r100, Linker.LibInfo r101);

    @Override // com.ttnet.org.chromium.base.library_loader.ModernLinker.Natives
    public int getRelroSharingResult() {
        return nativeGetRelroSharingResult();
    }

    public static void reportDlopenExtTime(long r100) {
        ModernLinker.reportDlopenExtTime(r100);
    }

    public static void reportIteratePhdrTime(long r100) {
        ModernLinker.reportIteratePhdrTime(r100);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.ModernLinker.Natives
    public boolean useRelros(long r100, Linker.LibInfo r101) {
        return nativeUseRelros(r100, r101);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.ModernLinker.Natives
    public boolean loadLibrary(String r100, Linker.LibInfo r101, boolean r102) {
        return nativeLoadLibrary(r100, r101, r102);
    }
}
