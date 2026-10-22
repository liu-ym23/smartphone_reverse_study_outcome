package com.bytedance.crash;

import android.app.Application;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.util.b;
import com.bytedance.crash.util.h;
import com.bytedance.crash.util.i;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class i0 {
    public static final Map<String, String> a = null;
    public static volatile PolarisFileWrapper b;

    static {
        a = new ConcurrentHashMap();
    }

    public static void a(Map r6) {
    L25:
        ObjectOutputStream r0 = null;
    L26:
        i.a(r0);
        return;
    L4:
        if (b != null) goto L20;
        Application r1 = i.a().c;     // Catch: Throwable -> L25
        if (r1 == null) goto L33;
        PolarisFileWrapper r2 = new PolarisFileWrapper(i.d(), "tags");     // Catch: Throwable -> L25
        if (r2.exists() == true) goto L12;
        r2.mkdirs();     // Catch: Throwable -> L25
    L12:
        if (b.e(r1, b.c()) == false) goto L14;
        String r3 = "main";
    L15:
        PolarisFileWrapper r4 = new PolarisFileWrapper(r2, r3);     // Catch: Throwable -> L25
        if (r4.exists() == true) goto L18;
        r4.mkdirs();     // Catch: Throwable -> L25
    L18:
        StringBuilder r5 = new StringBuilder("import_tag_");     // Catch: Throwable -> L25
        ConfigManager r7 = a0.a;     // Catch: Throwable -> L25
        r5.append(i.b());     // Catch: Throwable -> L25
        r5.append(".txt");     // Catch: Throwable -> L25
        b = new PolarisFileWrapper(r4, r5.toString());     // Catch: Throwable -> L25
        goto L20
    L14:
        r3 = b.b().replaceAll(":", "@");     // Catch: Throwable -> L25
        goto L15
    L33:
        return;
    L20:
        if (b == null) goto L34;
        r0 = new ObjectOutputStream(new PolarisFileOutputStreamWrapper(b));     // Catch: Throwable -> L25
        r0.writeObject(r6);     // Catch: Throwable -> L28
        goto L26
    }

    public static void b(PolarisFileWrapper r7) {
        File[] r8 = r7.listFiles();
        if (r8 != null) goto L5;
        return;
    L5:
        int r0 = r8.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L21;
        File r3 = r8[r2];
        if (r3.isFile() == true) goto L19;
        File[] r4 = r3.listFiles();
        if (r4 == null) goto L20;
        if (r4.length <= 5) goto L27;
        Arrays.sort(r4);
        int r5 = 0;
    L17:
        if (r5 >= (r4.length - 5)) goto L20;
        h.b(r4[r5]);
        r5 = r5 + 1;
        goto L17
    L27:
        return;
    L20:
        r2 = r2 + 1;
        goto L6
    L19:
        h.b(r3);
        goto L20
    }

    public static void c(String r2) {
        Map<String, String> r0 = a;
        if (((ConcurrentHashMap) r0).containsKey(r2) == true) goto L5;
        return;
    L5:
        ((ConcurrentHashMap) r0).remove(r2);
        if (d0.d() == true) goto L8;
        return;
    L8:
        wh4.b.post(new a(new HashMap(r0)));
    }
}
