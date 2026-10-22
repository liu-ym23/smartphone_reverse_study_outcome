package com.lynx.animax;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.animax.util.AnimaX;
import com.lynx.animax.util.AnimaXLog;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXResourceLoader {
    public AnimaXResourceLoader() {
    }

    public static String getCacheDirectory() {
        Context r100 = AnimaX.e().f380466c;
        if (r100 != null) goto L5;
        return null;
    L5:
        File r101 = r100.getCacheDir();
        if (r101 != null) goto L8;
        return null;
    L8:
        String r102 = r101.getAbsolutePath();
        if (r102 != null) goto L11;
        return null;
    L11:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102, "animax");
        if (r103.exists() == true) goto L17;
        if (r103.mkdirs() == true) goto L17;
        AnimaXLog.a("AnimaXResourceLoader", "Failed to make animax cache directory: " + r103.getAbsolutePath());
    L17:
        if (r103.exists() == false) goto L22;
        if (r103.isFile() == false) goto L22;
        AnimaXLog.a("AnimaXResourceLoader", "Failed to make animax cache directory, path is a file: " + r103.getAbsolutePath());
    L22:
        return r103.getAbsolutePath();
    }

    public static byte[] readFile(String r100) {
        if (r100 != null) goto L5;
    L11:
        PolarisFileInputStreamWrapper r101 = null;
    L17:
        int r102 = r101.available();     // Catch: IOException -> L14
    L16:
        return y4a.b.c(r101, r102);
    L14:
        r102 = 0;
        goto L16
    L5:
        if (new PolarisFileWrapper(r100).exists() == false) goto L11;
        r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        AnimaXLog.a("AnimaXStreamUtil", "createFileInputStream error: " + e);
        goto L11
    }

    public static boolean saveByteArrayIntoFile(String r100, byte[] r101) {
        ByteArrayInputStream r102 = new ByteArrayInputStream(r101);
        int r103 = r102.available();     // Catch: IOException -> L5
    L13:
        BufferedOutputStream r104 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r100));     // Catch: IOException -> L8
    L10:
        return y4a.b.b(r102, r104, r103);
    L8:
        AnimaXLog.a("AnimaXStreamUtil", "Failed to create FileOutputStream for file: " + r100);
        r104 = null;
    L5:
        r103 = 0;
        goto L13
    }
}
