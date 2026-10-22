package com.ss.ttm.utils;

import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;

/* JADX INFO: loaded from: classes40.dex */
public class VersionInfo {
    private static String[] mVersion;

    public VersionInfo() {
    }

    public static String[] getVersion() {
        if (mVersion != null) goto L44;
        String[] r100 = {"null", "null", "null", "null"};
        BufferedReader r101 = null;
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper("/proc/version");     // Catch: Throwable -> L24
        BufferedReader r103 = new BufferedReader(r102, 8192);     // Catch: Throwable -> L45
        r100[0] = r103.readLine().split("\\s+")[2];     // Catch: Throwable -> L23
        r103.close();     // Catch: Throwable -> L13
        r102.close();     // Catch: Throwable -> L11
    L42:
        r100[1] = Build.VERSION.RELEASE;
        r100[2] = Build.MODEL;
        r100[3] = Build.DISPLAY;
        mVersion = r100;
        goto L44
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
        r102.close();     // Catch: Throwable -> L11
    L17:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L20
    L22:
        throw th;
    L20:
        th = move-exception;
        th.printStackTrace();
    L23:
        r101 = r103;
    L25:
        if (r101 != null) goto L46;
    L40:
        if (r102 == null) goto L42;
        r102.close();     // Catch: Throwable -> L11
        goto L42
    L46:
        r101.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L33
        if (r102 == null) goto L42;
        r102.close();     // Catch: Throwable -> L11
    L33:
        th = move-exception;
        if (r102 != null) goto L49;
    L39:
        throw th;
    L49:
        r102.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        th.printStackTrace();
    L11:
        th = move-exception;
        th.printStackTrace();
    L24:
        r102 = null;
    L44:
        return mVersion;
    }
}
