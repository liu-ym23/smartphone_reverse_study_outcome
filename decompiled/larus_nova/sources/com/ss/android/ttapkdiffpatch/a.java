package com.ss.android.ttapkdiffpatch;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.sdk.controller.Global;
import ggc.c;
import java.io.File;
import java.util.concurrent.ExecutorService;
import jgc.d;
import jgc.f;
import jv7.e;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static void b() {
        e.f500563a = true;
        if (e.b() == true) goto L11;
        e.f500568f = e.a("java.nio.DirectByteBuffer").getMethod("cleaner", new Class[0]);     // Catch: Throwable -> L8
        if (e.f500565c != null) goto L12;
        e.f500565c = e.a("sun.misc.Cleaner").getMethod(Global.RECORDING_TYPE_CLEAN, new Class[0]);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public static void a(Context r100, ExecutorService r101, long r102) {
        if (r100 == null) goto L33;
        File r103 = r100.getCacheDir();
        if (r103 == null) goto L33;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103.getPath(), "ttApkDiffPatch");
        String r105 = r104.getPath();
        if (r104.exists() == true) goto L8;
    L32:
        r104.mkdirs();
    L34:
        kgc.a r106 = new kgc.a(r101, r102);
        if (f.a(r105) == true) goto L40;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r105);
        r107.mkdirs();
        if (r107.isDirectory() == false) goto L40;
        d.f499061a = r107;
    L40:
        c.f481229a = r106;
        return;
    L8:
        if (r104.isDirectory() == false) goto L32;
        if (r104.exists() == false) goto L32;
        if (r104.isDirectory() == false) goto L32;
        File[] r108 = r104.listFiles();
        if (r108 == null) goto L32;
        if (r108.length == 0) goto L32;
        int r109 = r108.length;
        int r110 = 0;
    L20:
        if (r110 >= r109) goto L32;
        File r111 = r108[r110];
        if (r111.isFile() == false) goto L27;
        if (r111.delete() == false) goto L32;
    L31:
        r110 = r110 + 1;
        goto L20
    L27:
        if (r111.isDirectory() == false) goto L31;
        if (d.b(r111) == true) goto L31;
    L33:
        r105 = null;
        goto L34
    }
}
