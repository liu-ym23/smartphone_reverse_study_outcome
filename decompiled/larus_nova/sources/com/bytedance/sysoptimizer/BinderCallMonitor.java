package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.shadowhook.ShadowHook;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public class BinderCallMonitor {
    private static final int MAX_TASK_COMM_LEN = 16;
    private static final String TAG = "BinderCallMonitor";
    private static char[] sComm;

    public BinderCallMonitor() {
    }

    private static native void nStart(int r100, boolean r101);

    private static String getThreadName(int r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper("/proc/self/task/" + r100 + "/comm");
        if (r101.exists() == false) goto L33;
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper(r101);     // Catch: IOException -> L22
        int r103 = r102.read(sComm);     // Catch: Throwable -> L14
        if (r103 > 0) goto L8;
    L12:
        r102.close();     // Catch: IOException -> L22
        return "Unknown";
    L8:
        if (r103 > 16) goto L12;
        String r104 = new String(sComm, 0, r103 - 1);     // Catch: Throwable -> L14
        r102.close();     // Catch: IOException -> L22
        return r104;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: IOException -> L22
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
        return "Unknown";
    L33:
        return "Unknown";
    }

    public static void start(Context r100, String r101, boolean r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L25;
        ShadowHook.access$000();
        ShadowHook.access$100();
        int r103 = ShadowHook.Mode.SHARED.getValue();
        ShadowHook.b r104 = new ShadowHook.b();
        r104.f270294a = r103;
        r104.f270295b = true;
        int r105 = 0;
        r104.f270296c = false;
        r104.f270297d = false;
        ShadowHook.init(r104);
        ByteHook.init();
        sComm = new char[16];
        PolarisFileWrapper r106 = new PolarisFileWrapper("/proc/self/task");
        if (r106.exists() == true) goto L8;
    L18:
        if (r105 <= 0) goto L26;
        nStart(r105, r102);
        return;
    L26:
        return;
    L8:
        if (r106.isDirectory() == false) goto L18;
        File[] r107 = r106.listFiles();
        if (r107 == null) goto L18;
        int r108 = r107.length;
        int r109 = 0;
    L12:
        if (r105 >= r108) goto L17;
        int r110 = CastIntegerProtector.parseInt(r107[r105].getName());
        if (r101.equals(getThreadName(r110)) == false) goto L16;
        r109 = r110;
    L16:
        r105 = r105 + 1;
        goto L12
    L17:
        r105 = r109;
        goto L18
    }
}
