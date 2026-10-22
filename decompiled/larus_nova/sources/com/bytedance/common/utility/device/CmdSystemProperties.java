package com.bytedance.common.utility.device;

import f06.b;
import f06.c;
import f06.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes15.dex */
public final class CmdSystemProperties {
    public static String getSystemProperty(String r100) {
        BufferedReader r101 = null;
        BufferedReader r102 = new BufferedReader(new InputStreamReader(com_bytedance_common_utility_device_CmdSystemProperties_java_lang_Runtime_exec(Runtime.getRuntime(), "getprop " + r100).getInputStream(), "UTF-8"), 1024);     // Catch: Throwable -> L7 IOException -> L9
        String r103 = r102.readLine();     // Catch: IOException -> L20 Throwable -> L14
        r102.close();     // Catch: IOException -> L20 Throwable -> L14
        r102.close();     // Catch: IOException -> L19
    L6:
        return r103;
    L14:
        th = th;
        r101 = r102;
    L16:
        if (r101 != null) goto L25;
    L18:
        throw th;
    L25:
        r101.close();     // Catch: IOException -> L22
    L10:
        if (r102 != null) goto L29;
    L13:
        return null;
    L29:
        r102.close();     // Catch: IOException -> L21
        goto L13
    L9:
        r102 = null;
    L7:
        th = th;
        goto L16
    }

    private static Process com_bytedance_common_utility_device_CmdSystemProperties_java_lang_Runtime_exec(Runtime r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r111};
        b r112 = new b();
        d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }
}
