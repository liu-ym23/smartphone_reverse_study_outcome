package com.bytedance.article.common.monitor.stack;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static void b(Throwable r10, PrintWriter r11) {
        Set r0 = Collections.newSetFromMap(new IdentityHashMap());
        r0.add(r10);
        r11.println(r10);
        StackTraceElement[] r1 = r10.getStackTrace();
        if (r1.length <= 384) goto L5;
        boolean r2 = true;
    L6:
        int r3 = r1.length;
        int r5 = 0;
        int r6 = 0;
    L8:
        if (r5 >= r3) goto L15;
        StackTraceElement r8 = r1[r5];
        if (r2 == false) goto L14;
        if (r6 <= 256) goto L14;
        StringBuilder r4 = new StringBuilder("\t... skip ");
        r4.append((r1.length - r6) - 128);
        r4.append(" lines");
        r11.println(r4.toString());
    L14:
        r11.println("\tat " + r8);
        r6 = r6 + 1;
        r5 = r5 + 1;
    L15:
        if (r2 == false) goto L20;
        int r7 = r1.length - 128;
    L18:
        if (r7 >= r1.length) goto L20;
        r11.println("\tat " + r1[r7]);
        r7 = r7 + 1;
    L20:
        Throwable[] r9 = r10.getSuppressed();
        int r12 = r9.length;
        int r13 = 0;
    L21:
        if (r13 >= r12) goto L23;
        a(r9[r13], r11, "Suppressed: ", "\t", r0, 128);
        r13 = r13 + 1;
        goto L21
    L23:
        Throwable r14 = r10.getCause();
        if (r14 == null) goto L33;
        a(r14, r11, "Caused by: ", "", r0, 128);
        return;
    L33:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static void a(Throwable r9, PrintWriter r10, String r11, String r12, Set r13, int r14) {
        if (r13.contains(r9) == false) goto L5;
        r10.println("\t[CIRCULAR REFERENCE:" + r9 + "]");
        return;
    L5:
        r13.add(r9);
        StackTraceElement[] r0 = r9.getStackTrace();
        int r2 = 0;
        if (r0.length <= r14) goto L8;
        boolean r1 = true;
    L9:
        r10.println(r12 + r11 + r9);
        int r15 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L11:
        if (r3 >= r15) goto L17;
        StackTraceElement r6 = r0[r3];
        if (r1 == false) goto L16;
        if (r4 <= r14) goto L16;
        r10.println("\t... skip " + ((r0.length - r4) - (r14 / 2)) + " lines");
    L16:
        r10.println("\tat " + r6);
        r4 = r4 + 1;
        r3 = r3 + 1;
    L17:
        if (r1 == false) goto L22;
        int r16 = r0.length - (r14 / 2);
    L20:
        if (r16 >= r0.length) goto L22;
        r10.println("\tat " + r0[r16]);
        r16 = r16 + 1;
    L22:
        Throwable[] r17 = r9.getSuppressed();
        int r5 = r17.length;
    L24:
        if (r2 >= r5) goto L30;
        Throwable r7 = r17[r2];
        String r8 = r12 + "\t";
        int r18 = r14 / 2;
        if (r18 <= 10) goto L28;
        int r19 = r18;
    L29:
        a(r7, r10, "Suppressed: ", r8, r13, r19);
        r2 = r2 + 1;
        goto L24
    L28:
        r19 = 10;
        goto L29
    L30:
        Throwable r20 = r9.getCause();
        if (r20 == null) goto L47;
        int r110 = r14 / 2;
        if (r110 <= 10) goto L35;
        int r21 = r110;
    L36:
        a(r20, r10, "Caused by: ", r12, r13, r21);
        return;
    L35:
        r21 = 10;
        goto L36
    L47:
        return;
    L8:
        r1 = false;
        goto L9
    }
}
