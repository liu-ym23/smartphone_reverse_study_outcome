package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.android.bytehook.ByteHook;

/* JADX INFO: loaded from: classes22.dex */
public class ZipCrcOpt {
    public ZipCrcOpt() {
    }

    private static native int nOptArt();

    private static native int nOptArtBase();

    private static native int nOptZipArchive();

    public static int optArt(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L6;
        ByteHook.init();
        return nOptArt();
    L6:
        return -1;
    }

    public static int optArtBase(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L6;
        ByteHook.init();
        return nOptArtBase();
    L6:
        return -1;
    }

    public static int optZipArchive(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L6;
        ByteHook.init();
        return nOptZipArchive();
    L6:
        return -1;
    }
}
