package com.lynx.tasm.utils;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes32.dex */
public class CallStackUtil {
    public CallStackUtil() {
    }

    public static String a(Throwable r100) {
        String r101 = Log.getStackTraceString(r100);
        if (r101.length() > 900) goto L5;
        return r101;
    L5:
        return r101.substring(0, 900);
    }

    public static String getMessageOfCauseChain(Throwable r100) {
        if (r100 != null) goto L13;
        return "";
    L13:
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L11
        r101.append(r100);     // Catch: Throwable -> L11
        Throwable r102 = r100.getCause();     // Catch: Throwable -> L11
        int r103 = 5;
    L6:
        if (r102 == null) goto L9;
        if (r103 <= 0) goto L9;
        r103 = r103 - 1;     // Catch: Throwable -> L11
        r101.append(": ");     // Catch: Throwable -> L11
        r101.append(r102);     // Catch: Throwable -> L11
        r102 = r102.getCause();     // Catch: Throwable -> L11
    L9:
        return r101.toString();
    L12:
        return r100.toString();
    }

    public static String getStackTraceStringWithLineTrimmed(Throwable r100) {
        if (r100 != null) goto L9;
        return "";
    L9:
        StringWriter r101 = new StringWriter();     // Catch: Throwable -> L7
        PrintWriter r102 = new PrintWriter(r101);     // Catch: Throwable -> L7
        b(r100, Collections.newSetFromMap(new IdentityHashMap()), r102);     // Catch: Throwable -> L7
        r102.flush();     // Catch: Throwable -> L7
        return r101.toString();
    L8:
        return a(r100);
    }

    public static void b(Throwable r100, Set<Throwable> r101, PrintWriter r102) {
        if (r100 == null) goto L19;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.contains(r100) == false) goto L8;
        return;
    L8:
        if (r101.isEmpty() == true) goto L10;
        r102.print("Caused by: ");
    L10:
        r102.println(r100);
        r101.add(r100);
        StackTraceElement[] r103 = r100.getStackTrace();
        int r104 = 9;
        if (r103.length >= 9) goto L13;
        r104 = r103.length;
    L13:
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L16;
        r102.println("\tat " + r103[r105]);
        r105 = r105 + 1;
        goto L14
    L16:
        b(r100.getCause(), r101, r102);
        return;
    }
}
