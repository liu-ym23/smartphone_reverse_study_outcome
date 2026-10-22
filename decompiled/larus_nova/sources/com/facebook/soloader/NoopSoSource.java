package com.facebook.soloader;

import android.os.StrictMode;
import java.io.File;

/* JADX INFO: loaded from: classes23.dex */
public class NoopSoSource extends SoSource {
    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String r100, int r101, StrictMode.ThreadPolicy r102) {
        return 1;
    }

    public NoopSoSource() {
    }

    @Override // com.facebook.soloader.SoSource
    public File unpackLibrary(String r100) {
        throw new UnsupportedOperationException("unpacking not supported in test mode");
    }
}
