package com.larksuite.tool.image;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class JPEGTool {
    public JPEGTool() {
    }

    public static native int getJpegQuality(byte[] r100);

    public static native int getJpegQualityByPath(String r100);

    private static native int getJpegQualityByPathSafely(String r100);

    public static native boolean isJPEG(byte[] r100);

    static {
        Intrinsics.checkNotNullParameter("JPEG-LIB", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> JPEG-LIB");
        a.c("JPEG-LIB");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> JPEG-LIB");
    }

    public static int a(String r100, boolean r101) {
        if (r101 == false) goto L5;
        return getJpegQualityByPathSafely(r100);
    L5:
        return getJpegQualityByPath(r100);
    }
}
