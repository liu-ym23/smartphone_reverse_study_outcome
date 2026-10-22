package com.larus.dora.impl.util;

import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Locale;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f338145a;

    static {
    }

    public static boolean a() {
        PolarisFileWrapper r100 = new PolarisFileWrapper("/proc/self/cgroup");
        StringBuilder r101 = new StringBuilder();
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: IOException -> L15
    L45:
        String r103 = r102.readLine();     // Catch: Throwable -> L10
        if (r103 == null) goto L7;
        r101.append(r103);     // Catch: Throwable -> L10
        r101.append("\n");     // Catch: Throwable -> L10
        goto L45
    L7:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r102, null);     // Catch: IOException -> L15
        String r105 = r101.toString();     // Catch: IOException -> L15
    L18:
        if (r105 != null) goto L20;
    L23:
        boolean r106 = true;
    L24:
        if (r106 == false) goto L27;
        g49.d.e("MachineUtils", "don't allow read cgroup info，default non-container environment or insufficient permissions");
        return false;
    L27:
        g49.d.d("MachineUtils", "full cgroup info:\n" + r105);
        String[] r107 = {"isulad", "lxc", "zhuoyi", "com.huawei.zhuoyitong"};
        int r108 = 0;
    L29:
        if (r108 >= 4) goto L36;
        String r109 = r107[r108];
        if (StringsKt.contains$default(r105.toLowerCase(Locale.ROOT), r109, false, 2, null) == true) goto L32;
        r108 = r108 + 1;
        goto L29
    L32:
        g49.d.d("MachineUtils", "environmental characteristics detected: " + r109);
        return true;
    L36:
        if (StringsKt.contains$default(r105, "/lxc/", false, 2, null) == false) goto L38;
    L42:
        g49.d.d("MachineUtils", "the container path structure is detected and determined to be the zyt environment.");
        return true;
    L38:
        if (StringsKt.contains$default(r105, "/isulad/", false, 2, null) == true) goto L42;
        g49.d.d("MachineUtils", "no obvious zyt-related features were detected, and it was determined to be a native environment or a non-container environment.");
        return false;
    L20:
        if (r105.length() == 0) goto L23;
        r106 = false;
        goto L24
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);     // Catch: IOException -> L15
        throw th;     // Catch: IOException -> L15
    L15:
        e = move-exception;
        g49.d.c("MachineUtils", "Error reading cgroup file", e);
        r105 = null;
        goto L18
    }
}
