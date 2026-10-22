package com.ss.ttvideoengine.utils;

import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes35.dex */
public class FileUtils {
    public FileUtils() {
    }

    public static void checkAndMkdir(File r100) {
        if (r100.exists() == true) goto L6;
        r100.mkdirs();
        return;
    }

    public static String readString(File r100) {
        StringBuilder r101 = new StringBuilder();
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: IOException -> L18
    L25:
        String r103 = r102.readLine();     // Catch: Throwable -> L10
        if (r103 == null) goto L8;
        r101.append(r103);     // Catch: Throwable -> L10
    L8:
        r102.close();     // Catch: IOException -> L18
    L21:
        return r101.toString();
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: IOException -> L18
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }
}
