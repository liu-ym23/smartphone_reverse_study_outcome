package com.bytedance.mira.plugin.core.func.soloader.utils;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes21.dex */
public class SoLoaderUtils {
    public SoLoaderUtils() {
    }

    public static String getFileName(String r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L12;
        int r101 = r100.lastIndexOf(File.separatorChar);
        if (r101 >= 0) goto L10;
        return r100;
    L10:
        return r100.substring(r101 + 1);
    L12:
        return r100;
    }
}
