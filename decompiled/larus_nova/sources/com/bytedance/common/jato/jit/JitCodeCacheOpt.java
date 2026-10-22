package com.bytedance.common.jato.jit;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.common.jato.JatoNativeLoader;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes15.dex */
public class JitCodeCacheOpt {
    public JitCodeCacheOpt() {
    }

    public static native void enableInternal(String r100, long r101);

    public static native void enableJitStackMapOpt();

    public static long bootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    static {
        JatoNativeLoader.loadLibrary();
    }

    public static void enable(Context r100, String r101, long r110) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 30) goto L5;
        return;
    L5:
        if (r102 <= 33) goto L8;
        return;
    L8:
        if (Process.is64Bit() == true) goto L36;
        return;
    L36:
        String r103 = r100.getPackageCodePath();     // Catch: Exception -> L35
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101);     // Catch: Exception -> L35
        int r105 = r103.indexOf("base.apk");     // Catch: Exception -> L35
        boolean r106 = false;
        if (r105 < 0) goto L30;
        String r107 = r103.substring(0, r105);     // Catch: Exception -> L35
        String r108 = r107 + "oat/arm64/base.odex";     // Catch: Exception -> L35
        PolarisFileWrapper r109 = new PolarisFileWrapper(r108);     // Catch: Exception -> L35
        PolarisFileWrapper r111 = new PolarisFileWrapper(r107 + "oat/arm64/base.art");     // Catch: Exception -> L35
        if (r109.exists() == true) goto L15;
    L28:
        r106 = true;
        goto L30
    L15:
        if (r111.exists() == false) goto L28;
        if (r104.exists() == false) goto L21;
        if (r104.lastModified() < r109.lastModified()) goto L28;
    L21:
        if (r104.exists() == false) goto L25;
        if (r104.lastModified() < r111.lastModified()) goto L28;
    L25:
        if (r104.exists() == false) goto L30;
        if (r104.lastModified() < bootTime()) goto L28;
    L30:
        if (r104.exists() == false) goto L33;
        if (r106 == false) goto L33;
        r104.delete();     // Catch: Exception -> L35
    L33:
        enableInternal(r101, r110);
    }
}
