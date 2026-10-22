package com.lynx.tasm.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Process;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;

/* JADX INFO: loaded from: classes32.dex */
public final class m {
    public static Typeface a(String r100) {
        if (TypeFaceOptimizer.getSwitch() == false) goto L14;
        if (r100 == null) goto L14;
        if (TypeFaceLancet.cache.contains(r100) == true) goto L8;
        Typeface r101 = Typeface.createFromFile(r100);
        if (r101 == null) goto L14;
        TypeFaceLancet.cache.put(r100, r101);
        return r101;
    L8:
        return (Typeface) TypeFaceLancet.cache.get(r100);
    L14:
        return Typeface.createFromFile(r100);
    }

    public static boolean b(PolarisFileWrapper r100, byte[] r101) {
        PolarisFileOutputStreamWrapper r102 = null;
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r100);     // Catch: Throwable -> L11 Exception -> L15
        r103.write(r101);     // Catch: Throwable -> L8 Exception -> L10
        r103.flush();     // Catch: Throwable -> L8 Exception -> L10
        r103.close();     // Catch: Exception -> L20
        return true;
    L33:
        return true;
    L10:
        r102 = r103;
    L8:
        th = th;
        r102 = r103;
    L12:
        if (r102 != null) goto L25;
    L14:
        throw th;
    L25:
        r102.close();     // Catch: Exception -> L21
        goto L14
    L11:
        th = th;
    L16:
        if (r102 == null) goto L34;
        r102.close();     // Catch: Exception -> L22
        return false;
    L35:
        return false;
    L34:
        return false;
    }

    public static Typeface c(Context r100, byte[] r101) {
        String r102 = ".lynx-font" + Process.myPid() + "-" + Process.myTid() + "-";
        int r103 = 0;
    L4:
        if (r103 >= 100) goto L10;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100.getCacheDir(), r102 + r103);
        if (r104.createNewFile() == false) goto L9;
    L11:
        if (r104 != null) goto L28;
        return null;
    L28:
    L23:
        r104.delete();
        return null;
    L20:
        th = move-exception;
        r104.delete();
        throw th;
    L14:
        if (b(r104, r101) == true) goto L17;
        r104.delete();
        return null;
    L17:
        Typeface r105 = a(r104.getPath());     // Catch: Throwable -> L20 RuntimeException -> L23
        r104.delete();
        return r105;
    L9:
        r103 = r103 + 1;
        goto L4
    L10:
        r104 = null;
        goto L11
    }
}
