package com.volcengine.zeus.oat;

import com.volcengine.zeus.log.ZeusLogger;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes41.dex */
public final class b {
    public static boolean b(String[] r100) {
        if (r100.length > 0) goto L17;
        return false;
    L17:
        Process r101 = a(Runtime.getRuntime(), r100);     // Catch: InterruptedException -> L11 IOException -> L14
        InputStream r102 = r101.getErrorStream();     // Catch: InterruptedException -> L11 IOException -> L14
        InputStream r103 = r101.getInputStream();     // Catch: InterruptedException -> L11 IOException -> L14
        dqc.e.b(new a(r102));     // Catch: InterruptedException -> L11 IOException -> L14
        dqc.e.b(new a(r103));     // Catch: InterruptedException -> L11 IOException -> L14
        if (r101.waitFor() == 0) goto L9;
        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + r100.toString());     // Catch: InterruptedException -> L11 IOException -> L14
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

    public static Process a(Runtime r110, String[] r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }
}
