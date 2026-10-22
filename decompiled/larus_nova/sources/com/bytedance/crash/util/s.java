package com.bytedance.crash.util;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class s {
    public static Object a(File r100) {
    L25:
        th = move-exception;
        ch4.c.c(th);
        return null;
    L4:
        if (r100.exists() == true) goto L32;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getAbsolutePath() + ".bk");     // Catch: Throwable -> L25
        if (r101.exists() == true) goto L8;
        return null;
    L8:
        r101.renameTo(r100);     // Catch: Throwable -> L25
    L32:
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L15 Exception -> L17
        Object r103 = new ObjectInputStream(r102).readObject();     // Catch: Exception -> L13 Throwable -> L22
        g.a(r102);     // Catch: Throwable -> L25
        return r103;
    L13:
        e = e;
    L19:
        h.b(r100);     // Catch: Throwable -> L22
        ch4.c.c(e);     // Catch: Throwable -> L22
        g.a(r102);     // Catch: Throwable -> L25
        return null;
    L22:
        th = th;
    L23:
        g.a(r102);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L17:
        e = e;
        r102 = null;
    L15:
        th = th;
        r102 = null;
        goto L23
    }

    public static void b(PolarisFileWrapper r100, Object r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getAbsolutePath() + ".bk");     // Catch: Throwable -> L36
        if (r100.isDirectory() == false) goto L6;
        h.b(r100);     // Catch: Throwable -> L36
    L11:
        PolarisFileOutputStreamWrapper r103 = null;
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r100);     // Catch: Throwable -> L20 Exception -> L22
        new ObjectOutputStream(r104).writeObject(r101);     // Catch: Throwable -> L16 Exception -> L18
        g.a(r104);     // Catch: Throwable -> L36
        boolean r105 = true;
    L26:
        if (r102.exists() == false) goto L45;
        if (r105 == false) goto L30;
        h.b(r102);     // Catch: Throwable -> L36
        return;
    L30:
        if (r100.exists() == false) goto L32;
        h.b(r100);     // Catch: Throwable -> L36
    L32:
        r102.renameTo(r100);     // Catch: Throwable -> L36
        return;
    L45:
        return;
    L18:
        e = e;
        r103 = r104;
    L23:
        e.printStackTrace();     // Catch: Throwable -> L20
        ch4.c.c(e);     // Catch: Throwable -> L20
        g.a(r103);     // Catch: Throwable -> L36
        r105 = false;
    L16:
        th = th;
    L34:
        g.a(r104);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L22:
        e = e;
    L20:
        th = th;
        r104 = r103;
        goto L34
    L6:
        if (r100.exists() == false) goto L11;
        if (r102.exists() == false) goto L10;
        r102.delete();     // Catch: Throwable -> L36
    L10:
        r100.renameTo(r102);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        ch4.c.c(th);
    }
}
