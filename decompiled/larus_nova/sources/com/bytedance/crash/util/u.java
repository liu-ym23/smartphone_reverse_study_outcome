package com.bytedance.crash.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f203420a = 0;

    static {
        new StackTraceElement("", "", "", 0);
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    public static String a(Throwable r100) {
        StringWriter r101 = new StringWriter();
        PrintWriter r102 = new PrintWriter(r101);
        c(r100, r102);     // Catch: Throwable -> L6
        String r103 = r101.toString();     // Catch: Throwable -> L6
        r102.close();
        return r103;
    L7:
        r102.close();
        return "";
    }

    public static void c(Throwable r110, PrintWriter r111) {
        if (r110 == null) goto L34;
        Set r100 = Collections.newSetFromMap(new IdentityHashMap());
        r100.add(r110);
        r111.println(r110);
        StackTraceElement[] r101 = r110.getStackTrace();
        if (r101.length <= 384) goto L6;
        boolean r102 = true;
    L7:
        int r103 = r101.length;
        int r104 = 0;
        int r105 = 0;
    L9:
        if (r104 >= r103) goto L16;
        StackTraceElement r106 = r101[r104];
        if (r102 == false) goto L15;
        if (r105 <= 256) goto L15;
        r111.println("\t... skip " + ((r101.length - r105) + com.alipay.sdk.m.n.a.f25611g) + " lines");
    L15:
        r111.println("\tat " + r106);
        r105 = r105 + 1;
        r104 = r104 + 1;
    L16:
        if (r102 == false) goto L21;
        int r107 = r101.length + com.alipay.sdk.m.n.a.f25611g;
    L19:
        if (r107 >= r101.length) goto L21;
        r111.println("\tat " + r101[r107]);
        r107 = r107 + 1;
    L21:
        Throwable[] r108 = r110.getSuppressed();
        int r109 = r108.length;
        int r112 = 0;
    L22:
        if (r112 >= r109) goto L24;
        b(r108[r112], r111, "Suppressed: ", "\t", r100, 128);
        r112 = r112 + 1;
        goto L22
    L24:
        Throwable r113 = r110.getCause();
        if (r113 == null) goto L35;
        b(r113, r111, "Caused by: ", "", r100, 128);
        return;
    L35:
        return;
    L6:
        r102 = false;
        goto L7
    }

    public static void b(Throwable r100, PrintWriter r110, String r111, String r112, Set r113, int r114) {
        if (r113.contains(r100) == false) goto L5;
        r110.println("\t[CIRCULAR REFERENCE:" + r100 + "]");
        return;
    L5:
        r113.add(r100);
        StackTraceElement[] r101 = r100.getStackTrace();
        int r102 = 0;
        if (r101.length <= r114) goto L8;
        boolean r103 = true;
    L9:
        r110.println(r112 + r111 + r100);
        int r115 = r101.length;
        int r104 = 0;
        int r105 = 0;
    L11:
        if (r104 >= r115) goto L17;
        StackTraceElement r106 = r101[r104];
        if (r103 == false) goto L16;
        if (r105 <= r114) goto L16;
        r110.println("\t... skip " + ((r101.length - r105) - (r114 / 2)) + " lines");
    L16:
        r110.println("\tat " + r106);
        r105 = r105 + 1;
        r104 = r104 + 1;
    L17:
        if (r103 == false) goto L22;
        int r116 = r101.length - (r114 / 2);
    L20:
        if (r116 >= r101.length) goto L22;
        r110.println("\tat " + r101[r116]);
        r116 = r116 + 1;
    L22:
        Throwable[] r117 = r100.getSuppressed();
        int r107 = r117.length;
    L24:
        if (r102 >= r107) goto L30;
        Throwable r108 = r117[r102];
        String r109 = r112 + "\t";
        int r118 = r114 / 2;
        if (r118 <= 10) goto L28;
        int r119 = r118;
    L29:
        b(r108, r110, "Suppressed: ", r109, r113, r119);
        r102 = r102 + 1;
        goto L24
    L28:
        r119 = 10;
        goto L29
    L30:
        Throwable r120 = r100.getCause();
        if (r120 == null) goto L47;
        int r121 = r114 / 2;
        if (r121 <= 10) goto L35;
        int r122 = r121;
    L36:
        b(r120, r110, "Caused by: ", r112, r113, r122);
        return;
    L35:
        r122 = 10;
        goto L36
    L47:
        return;
    L8:
        r103 = false;
        goto L9
    }
}
