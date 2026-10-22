package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes41.dex */
class LinkerJni implements Linker.Natives {
    public LinkerJni() {
    }

    private static native void nativeFindMemoryRegionAtRandomAddress(Linker.LibInfo r100, boolean r101);

    private static native boolean nativeFindRegionReservedByWebViewZygote(Linker.LibInfo r100);

    private static native void nativeReserveMemoryForLibrary(Linker.LibInfo r100);

    @Override // com.ttnet.org.chromium.base.library_loader.Linker.Natives
    public boolean findRegionReservedByWebViewZygote(Linker.LibInfo r100) {
        return nativeFindRegionReservedByWebViewZygote(r100);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker.Natives
    public void reserveMemoryForLibrary(Linker.LibInfo r100) {
        nativeReserveMemoryForLibrary(r100);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.Linker.Natives
    public void findMemoryRegionAtRandomAddress(Linker.LibInfo r100, boolean r101) {
        nativeFindMemoryRegionAtRandomAddress(r100, r101);
    }
}
