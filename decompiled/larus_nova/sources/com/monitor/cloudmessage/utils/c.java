package com.monitor.cloudmessage.utils;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.apm.d;
import com.bytedance.apm.util.g;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes32.dex */
public final class c {
    public static long[] b() {
        long[] r100 = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L8;
        File r101 = g.c(d.getContext());
        if (r101 != null) goto L7;
        return r100;
    L7:
        StatFs r102 = new StatFs(r101.getPath());
        long r103 = r102.getBlockSize();
        long r104 = r102.getBlockCount();
        long r105 = r102.getAvailableBlocks();
        r100[0] = ((r104 * r103) / 1024) / 1024;
        r100[1] = ((r103 * r105) / 1024) / 1024;
    L8:
        return r100;
    }

    public static String[] a() {
        String[] r100 = {"", ""};
        BufferedReader r101 = null;
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper("/proc/cpuinfo");     // Catch: Throwable -> L16 IOException -> L20
        BufferedReader r103 = new BufferedReader(r102, 8192);     // Catch: Throwable -> L14 IOException -> L24
        String[] r104 = r103.readLine().split("\\s+");     // Catch: Throwable -> L11 IOException -> L13
        int r105 = 2;
    L7:
        if (r105 >= r104.length) goto L9;
        r100[0] = r100[0] + r104[r105] + " ";     // Catch: Throwable -> L11 IOException -> L13
        r105 = r105 + 1;     // Catch: Throwable -> L11 IOException -> L13
        goto L7
    L9:
        r100[1] = r100[1] + r103.readLine().split("\\s+")[2];     // Catch: Throwable -> L11 IOException -> L13
        xu3.c.a(r103);
    L22:
        xu3.c.a(r102);
        return r100;
    L13:
        r101 = r103;
    L11:
        th = th;
        r101 = r103;
    L18:
        xu3.c.a(r101);
        xu3.c.a(r102);
        throw th;
    L14:
        th = th;
    L21:
        xu3.c.a(r101);
        goto L22
    L20:
        r102 = null;
    L16:
        th = th;
        r102 = null;
        goto L18
    }

    public static String[] c() {
        String[] r100 = {"null", "null", "null", "null"};
        BufferedReader r101 = null;
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper("/proc/version");     // Catch: Throwable -> L12 IOException -> L16
    L23:
        BufferedReader r103 = new BufferedReader(r102, 8192);     // Catch: Throwable -> L10 IOException -> L20
        goto L17
    L25:
        r100[0] = r103.readLine().split("\\s+")[2];     // Catch: Throwable -> L7 IOException -> L9
        xu3.c.a(r103);
    L18:
        xu3.c.a(r102);
        r100[1] = Build.VERSION.RELEASE;
        r100[2] = Build.MODEL;
        r100[3] = Build.DISPLAY;
        return r100;
    L9:
        r101 = r103;
    L7:
        th = th;
        r101 = r103;
    L14:
        xu3.c.a(r101);
        xu3.c.a(r102);
        throw th;
    L10:
        th = th;
    L17:
        xu3.c.a(r101);
    L16:
        r102 = null;
    L12:
        th = th;
        r102 = null;
        goto L14
    }
}
