package com.ss.android.downloadlib.utils;

import java.io.File;

/* JADX INFO: loaded from: classes34.dex */
public class FileUtils {
    public FileUtils() {
    }

    public static long getLastModifiedTime(File r100) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        if (r100.exists() == true) goto L7;
        return 0;
    L7:
        return getLastModifiedTime(r100, r100.lastModified(), 0);
    }

    private static long getLastModifiedTime(File r100, long r101, int r102) {
        if (r100 != null) goto L4;
    L16:
        return r101;
    L4:
        if (r100.exists() == false) goto L16;
        r101 = Math.max(r101, r100.lastModified());
        int r103 = r102 + 1;
        if (r103 < 50) goto L10;
        return r101;
    L10:
        if (r100.isDirectory() == false) goto L16;
        File[] r104 = r100.listFiles();
        if (r104 == null) goto L16;
        int r105 = r104.length;
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L16;
        r101 = Math.max(r101, getLastModifiedTime(r104[r106], r101, r103));
        r106 = r106 + 1;
        goto L14
    }
}
