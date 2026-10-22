package com.bytedance.android.alog;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class e {
    public static Alog a;

    public static void a() {
        Alog r0 = a;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public static String b() {
        Alog r0 = a;
        if (r0 != null) goto L5;
        return "default log instance is null";
    L5:
        if (Alog.q == true) goto L8;
        return "not inited";
    L8:
        if (r0.f != null) goto L10;
        r0.f = g.a();
    L10:
        String r1 = r0.f;
        if (r1 != null) goto L13;
        return "get process name failed";
    L13:
        String r2 = r1.replace(':', '-');
        PolarisFileWrapper r3 = new PolarisFileWrapper(r0.c);
        if (r3.exists() == true) goto L16;
        return "cache dir not exists";
    L16:
        File[] r4 = r3.listFiles();
        if (r4 != null) goto L19;
        return "cache dir is empty";
    L19:
        String r5 = r2 + "__" + r0.g + ".alog.cache.guard";
        Pattern r6 = PatternProtector.compile("^" + Pattern.quote(r2) + "__" + Pattern.quote(r0.g) + "__\\d{5}\\.alog\\.cache$");
        int r7 = r4.length;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L20:
        if (r8 >= r7) goto L37;
        File r13 = r4[r8];
        if (r13.getName().equals(r5) == false) goto L27;
        r9 = r9 + 1;
        if (r13.length() < 24576) goto L26;
        r10 = r10 + 1;
    L26:
        File[] r16 = r4;
    L34:
        String r15 = r5;
    L35:
        r8 = r8 + 1;
        r5 = r15;
        r4 = r16;
        goto L20
    L27:
        String r14 = r13.getName();
        StringBuilder r17 = new StringBuilder();
        r17.append(r2);
        r17.append("__");
        r16 = r4;
        r17.append(r0.g);
        r17.append("__");
        if (r14.startsWith(r17.toString()) == false) goto L34;
        if (r6.matcher(r13.getName()).find() == false) goto L34;
        r11 = r11 + 1;
        r15 = r5;
        if (r13.length() < r0.d) goto L35;
        r12 = r12 + 1;
        goto L35
    L37:
        if (r9 >= 1) goto L39;
        r3.getAbsolutePath();
        return "cache guard not exists";
    L39:
        if (r10 >= 1) goto L41;
        return "cache guard size insufficiently";
    L41:
        int r18 = r0.e;
        if (r11 >= r18) goto L44;
        return "cache block count insufficiently";
    L44:
        if (r12 >= r18) goto L46;
        return "cache block size insufficiently";
    L46:
        PolarisFileWrapper r19 = new PolarisFileWrapper(r0.b);
        if (r19.exists() == true) goto L49;
        return "log dir not exists";
    L49:
        File[] r20 = r19.listFiles(new a(r0, PatternProtector.compile("^\\d{4}_\\d{2}_\\d{2}_\\d+__" + Pattern.quote(r2) + "__" + Pattern.quote(r0.g) + "\\.alog\\.hot$")));
        if (r20 != null) goto L52;
    L55:
        return "no log file for current process and instance";
    L52:
        if (r20.length == 0) goto L55;
        return "OK";
    }

    public static void c(int r1, String r2, String r3) {
        Alog r0 = a;
        if (r0 == null) goto L6;
        r0.n(r1, r2, r3);
        return;
    }

    public static void d(int r1, String r2, String r3) {
        Alog r0 = a;
        if (r0 == null) goto L6;
        r0.n(r1, r2, r3);
        return;
    }
}
