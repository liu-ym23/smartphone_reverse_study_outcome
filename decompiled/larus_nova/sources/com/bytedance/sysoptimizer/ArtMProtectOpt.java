package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.shadowhook.ShadowHook;
import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public class ArtMProtectOpt {
    private static String TAG = "ArtMProtectOpt";

    public ArtMProtectOpt() {
    }

    private static native int nMemmapSetDebugNameOpt();

    private static native int nStartPharse1(int r100, int r101);

    private static native int nStartPharse2();

    public static int memmapSetDebugNameOpt(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L6;
        ShadowHook.access$000();
        ShadowHook.access$100();
        int r101 = ShadowHook.Mode.SHARED.getValue();
        ShadowHook.b r102 = new ShadowHook.b();
        r102.f270294a = r101;
        r102.f270295b = true;
        r102.f270296c = false;
        r102.f270297d = false;
        ShadowHook.init(r102);
        return nMemmapSetDebugNameOpt();
    L6:
        return -1;
    }

    public static int startPharse1(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L35;
        String r101 = null;
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper("/proc/self/maps"));     // Catch: IOException -> L20
        String r103 = null;
        boolean r104 = false;
    L38:
        String r105 = r102.readLine();     // Catch: IOException -> L18
        if (r105 == null) goto L16;
        if (r105.contains("dalvik-main space") == true) goto L11;
        if (r104 == false) goto L38;
    L11:
        String[] r106 = r105.split("\\s+")[0].split("-");     // Catch: IOException -> L18
        if (r104 == true) goto L14;
        r101 = r106[0];     // Catch: IOException -> L18
        r104 = true;
    L14:
        r103 = r106[1];     // Catch: IOException -> L18
    L16:
        r102.close();     // Catch: IOException -> L18
    L23:
        ByteHook.init();
        if (r101 == null) goto L35;
        if (r103 == null) goto L35;
        if (r101.startsWith("0x") == false) goto L31;
        r101 = r101.substring(2);
    L31:
        if (r103.startsWith("0x") == false) goto L34;
        r103 = r103.substring(2);
    L34:
        return nStartPharse1((int) CastLongProtector.parseLong(r101, 16), (int) CastLongProtector.parseLong(r103, 16));
    L18:
        e = e;
    L22:
        e.printStackTrace();
    L20:
        e = e;
        r103 = null;
    L35:
        return -1;
    }

    public static int startPharse2(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L5;
        return -1;
    L5:
        return nStartPharse2();
    }

    public static int startPharse1(Context r100, int r101, int r102) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L6;
        ByteHook.init();
        return nStartPharse1(r101, r102);
    L6:
        return -1;
    }
}
