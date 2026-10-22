package com.facebook.soloader.nativeloader;

import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public interface NativeLoaderDelegate {
    public static final int SKIP_MERGED_JNI_ONLOAD = 1;

    String getLibraryPath(String r100) throws IOException;

    int getSoSourcesVersion();

    boolean loadLibrary(String r100, int r101);
}
