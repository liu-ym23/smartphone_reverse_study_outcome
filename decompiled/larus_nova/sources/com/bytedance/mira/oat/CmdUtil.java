package com.bytedance.mira.oat;

import com.bytedance.mira.helper.MiraThreadPoolHelper;
import com.bytedance.mira.log.MiraLogger;
import f06.b;
import f06.c;
import f06.d;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes21.dex */
public class CmdUtil {
    public CmdUtil() {
    }

    private static void consumeInputStream(final InputStream r100) {
        MiraThreadPoolHelper.sMiraFastExecutor.execute(new AnonymousClass1(r100));
    }

    public static boolean execCmd(String[] r100) {
        if (r100.length > 0) goto L17;
        return false;
    L17:
        Process r101 = com_bytedance_mira_oat_CmdUtil_java_lang_Runtime_exec(Runtime.getRuntime(), r100);     // Catch: InterruptedException -> L11 IOException -> L14
        InputStream r102 = r101.getErrorStream();     // Catch: InterruptedException -> L11 IOException -> L14
        InputStream r103 = r101.getInputStream();     // Catch: InterruptedException -> L11 IOException -> L14
        consumeInputStream(r102);     // Catch: InterruptedException -> L11 IOException -> L14
        consumeInputStream(r103);     // Catch: InterruptedException -> L11 IOException -> L14
        if (r101.waitFor() == 0) goto L9;
        MiraLogger.e("exec dex2oat failed : " + r100.toString());     // Catch: InterruptedException -> L11 IOException -> L14
        return false;
    L9:
        return true;
    L14:
        e = move-exception;
        e.printStackTrace();
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static Process com_bytedance_mira_oat_CmdUtil_java_lang_Runtime_exec(Runtime r110, String[] r111) {
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
