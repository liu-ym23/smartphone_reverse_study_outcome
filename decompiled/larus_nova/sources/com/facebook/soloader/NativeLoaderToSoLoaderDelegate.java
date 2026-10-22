package com.facebook.soloader;

import com.facebook.soloader.nativeloader.NativeLoaderDelegate;
import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public class NativeLoaderToSoLoaderDelegate implements NativeLoaderDelegate {
    public NativeLoaderToSoLoaderDelegate() {
    }

    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public int getSoSourcesVersion() {
        return SoLoader.getSoSourcesVersion();
    }

    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public String getLibraryPath(String r100) throws IOException {
        return SoLoader.getLibraryPath(r100);
    }

    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public boolean loadLibrary(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        int r102 = 16;
    L7:
        return SoLoader.loadLibrary(r100, r102 | 0);
    L5:
        r102 = 0;
        goto L7
    }
}
