package com.bytedance.common.profilesdk.util;

import android.os.SystemClock;
import com.bytedance.common.profilesdk.deximage.Deximage;
import f06.b;
import f06.c;
import f06.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes15.dex */
public class CmdUtils {
    private static void consumeInputStream(final InputStream r100) {
        Deximage.sExecutor.execute(new AnonymousClass1(r100));
    }

    public static Process exec(String[] r100) throws IOException {
        return com_bytedance_common_profilesdk_util_CmdUtils_java_lang_Runtime_exec(Runtime.getRuntime(), r100);
    }

    public static boolean execCmd(String[] r110) {
        String r100 = " cmd: ";
        if (r110.length > 0) goto L5;
        return false;
    L5:
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L7:
        if (r102 >= r110.length) goto L9;
        r101.append(r110[r102]);
        r101.append(" ");
        r102 = r102 + 1;
        goto L7
    L9:
        long r103 = SystemClock.uptimeMillis();
        int r104 = -1;
        Process r105 = exec(r110);     // Catch: Throwable -> L18 InterruptedException -> L20 IOException -> L23
        InputStream r106 = r105.getErrorStream();     // Catch: Throwable -> L18 InterruptedException -> L20 IOException -> L23
        InputStream r111 = r105.getInputStream();     // Catch: Throwable -> L18 InterruptedException -> L20 IOException -> L23
        consumeInputStream(r106);     // Catch: Throwable -> L18 InterruptedException -> L20 IOException -> L23
        consumeInputStream(r111);     // Catch: Throwable -> L18 InterruptedException -> L20 IOException -> L23
        r104 = r105.waitFor();     // Catch: Throwable -> L18 InterruptedException -> L20 IOException -> L23
        if (r104 == 0) goto L16;
        Logger.d("Exec failed: " + Arrays.toString(r110));     // Catch: Throwable -> L18 InterruptedException -> L20 IOException -> L23
        long r107 = SystemClock.uptimeMillis() - r103;
        StringBuilder r112 = new StringBuilder("Reture: ");
    L14:
        r112.append(r104);
        r112.append(" cmd: ");
        r100 = r101.toString();
        r112.append(r100);
        r112.append(r107);
        r112.append("ms");
        Logger.d(r112.toString());
        return false;
    L16:
        Logger.d("Reture: " + r104 + " cmd: " + r101.toString() + (SystemClock.uptimeMillis() - r103) + "ms");
        return true;
    L18:
        th = move-exception;
        Logger.d("Reture: " + r104 + r100 + r101.toString() + (SystemClock.uptimeMillis() - r103) + "ms");
        throw th;
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        Logger.d("Exec failed IOException: " + e.toString());     // Catch: Throwable -> L18
        r107 = SystemClock.uptimeMillis() - r103;
        r112 = new StringBuilder("Reture: ");
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        Logger.d("Exec failed InterruptedException: " + e.toString());     // Catch: Throwable -> L18
        r107 = SystemClock.uptimeMillis() - r103;
        r112 = new StringBuilder("Reture: ");
        goto L14
    }

    private static Process com_bytedance_common_profilesdk_util_CmdUtils_java_lang_Runtime_exec(Runtime r110, String[] r111) throws IOException {
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
