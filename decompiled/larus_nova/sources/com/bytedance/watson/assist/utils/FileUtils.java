package com.bytedance.watson.assist.utils;

import android.util.Log;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public class FileUtils {

    public interface a {
        void a(String r100);
    }

    public FileUtils() {
    }

    public static native void alog(int r100, String r101, String r102);

    public static native String parseFile(String r100);

    public static native String[] parsePidFile(String r100);

    public static native String[] parsePidFileWithExtra(String r100);

    public static native long parseSystemPolicyTimeInSate(String r100, int r101);

    public static native String[] parseTidFile(String r100);

    public static native String[] parseTidFileWithExtra(String r100);

    static {
        Intrinsics.checkNotNullParameter("watson", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> watson");
        com.bytedance.librarian.a.c("watson");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> watson");
    }

    public static void a(BufferedReader r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.getStackTraceString(e);
        boolean r101 = hq7.a.f486512a;
        return;
    }

    public static BufferedReader b(File r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.exists() == true) goto L10;
        r100.getName();
        boolean r101 = hq7.a.f486512a;
        return null;
    L10:
        if (r100.canRead() == true) goto L18;
        r100.getName();
        boolean r102 = hq7.a.f486512a;
        return null;
    L18:
        return new BufferedReader(new PolarisFileReaderWrapper(r100), 10000);
    L15:
        e = move-exception;
        Log.getStackTraceString(e);
        boolean r103 = hq7.a.f486512a;
        return null;
    }

    public static void c(String r100, a r101) {
        if (r100 == null) goto L18;
        BufferedReader r102 = b(new PolarisFileWrapper(r100));
        if (r102 == null) goto L19;
    L14:
        String r103 = r102.readLine();     // Catch: IOException -> L10
        if (r103 == null) goto L12;
        r101.a(r103);     // Catch: IOException -> L10
    L12:
        a(r102);
        return;
    L10:
        e = move-exception;
        Log.getStackTraceString(e);
        boolean r104 = hq7.a.f486512a;
        goto L12
    L19:
        return;
    }
}
