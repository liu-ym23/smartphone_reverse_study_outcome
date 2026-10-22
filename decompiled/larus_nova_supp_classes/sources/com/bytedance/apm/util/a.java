package com.bytedance.apm.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static String a;
    public static Boolean b;

    public static String a(int r5) {
        if (TextUtils.isEmpty(a) == true) goto L39;
        return a;
    L39:
        BufferedReader r2 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + r5 + "/cmdline"));     // Catch: Throwable -> L19
        String r6 = r2.readLine();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r6) == true) goto L11;
        r6 = r6.trim();     // Catch: Throwable -> L17
    L11:
        a = r6;     // Catch: Throwable -> L17
        r2.close();     // Catch: IOException -> L14
    L16:
        return r6;
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
    L37:
        th.printStackTrace();     // Catch: Throwable -> L28
        if (r2 != null) goto L41;
    L27:
        return null;
    L41:
        r2.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L28:
        th = move-exception;
        if (r2 != null) goto L45;
    L34:
        throw th;
    L45:
        r2.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r2 = null;
        goto L37
    }

    public static boolean b(Context r3) {
        String r0 = a(Process.myPid());
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.equals(r3.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.contains(":") == false) goto L7;
        return false;
    }
}
