package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.shadowhook.ShadowHook;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public class GCThreadPrioOptWhenBlockGC {
    public GCThreadPrioOptWhenBlockGC() {
    }

    private static native void nStart(int r100, int r101);

    private static int getGCThreadTid() {
        PolarisFileWrapper r100 = new PolarisFileWrapper("/proc/self/task");
        if (r100.exists() == true) goto L5;
    L14:
        return 0;
    L5:
        if (r100.isDirectory() == false) goto L14;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L14;
        int r102 = r101.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        int r104 = CastIntegerProtector.parseInt(r101[r103].getName());
        if ("HeapTaskDaemon".equals(getThreadName(r104)) == true) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return r104;
    }

    private static String getThreadName(int r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper("/proc/self/task/" + r100 + "/comm");
        if (r101.exists() == false) goto L27;
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r101));     // Catch: IOException -> L16
        String r103 = r102.readLine();     // Catch: Throwable -> L8
        r102.close();     // Catch: IOException -> L16
        return r103;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L13
    L15:
        throw th;     // Catch: IOException -> L16
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        return "Unknown";
    L27:
        return "Unknown";
    }

    public static void startOpt(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L8;
        ShadowHook.access$000();
        ShadowHook.access$100();
        int r102 = ShadowHook.Mode.SHARED.getValue();
        ShadowHook.b r103 = new ShadowHook.b();
        r103.f270294a = r102;
        r103.f270295b = true;
        r103.f270296c = false;
        r103.f270297d = false;
        ShadowHook.init(r103);
        int r104 = getGCThreadTid();
        if (r104 == 0) goto L9;
        nStart(r104, r101);
        return;
    L9:
        return;
    }
}
