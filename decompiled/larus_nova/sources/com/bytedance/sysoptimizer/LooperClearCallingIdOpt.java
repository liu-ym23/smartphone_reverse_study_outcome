package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes22.dex */
public class LooperClearCallingIdOpt {
    private static String TAG = "LooperClearCallingIdOpt";

    public LooperClearCallingIdOpt() {
    }

    private static native void nStart(long r100, long r101, long r102, long r103);

    public static void start(Context r110) {
        if (SysOptimizer.loadOptimizerLibrary(r110) == true) goto L44;
        return;
    L44:
        BufferedReader r100 = new BufferedReader(new PolarisFileReaderWrapper("/proc/self/maps"));     // Catch: IOException -> L18
        long r101 = 0;
        long r102 = 0;
    L46:
        String r103 = r100.readLine();     // Catch: IOException -> L16
        if (r103 == null) goto L14;
        if (r103.contains("boot-framework.oat") == false) goto L46;
        if (r103.contains("r-xp") == false) goto L46;
        String[] r104 = r103.split("\\s+")[0].split("-");     // Catch: IOException -> L16
        r101 = CastLongProtector.parseLong(r104[0], 16);     // Catch: IOException -> L16
        r102 = CastLongProtector.parseLong(r104[1], 16);     // Catch: IOException -> L16
        goto L46
    L14:
        r100.close();     // Catch: IOException -> L16
    L21:
        long r105 = r101;
        long r111 = r102;
        if (r105 != 0) goto L24;
        return;
    L24:
        if (r111 == 0) goto L58;
        int r106 = Build.VERSION.SDK_INT;
        if (r106 >= 26) goto L42;
        return;
    L42:
        if (r106 < 31) goto L31;
        Method r107 = Looper.class.getDeclaredMethod("loopOnce", new Class[]{Looper.class, Long.TYPE, Integer.TYPE});     // Catch: Exception -> L41
        Field r108 = Executable.class.getDeclaredField("artMethod");     // Catch: Exception -> L41
        r108.setAccessible(true);     // Catch: Exception -> L41
        long r112 = r108.getLong(r107);     // Catch: Exception -> L41
    L32:
        Class r113 = Long.TYPE;     // Catch: Exception -> L41
        Method r109 = LooperClearCallingIdOpt.class.getDeclaredMethod("nStart", new Class[]{r113, r113, r113, r113});     // Catch: Exception -> L41
        Field r114 = Executable.class.getDeclaredField("artMethod");     // Catch: Exception -> L41
        r114.setAccessible(true);     // Catch: Exception -> L41
        long r115 = r114.getLong(r109);     // Catch: Exception -> L41
        if (r112 != 0) goto L37;
        return;
    L37:
        if (r115 != 0) goto L39;
        return;
    L39:
        nStart(r105, r111, r112, r115);
        return;
    L31:
        Method r116 = Looper.class.getDeclaredMethod("loop", new Class[0]);     // Catch: Exception -> L41
        Field r117 = Executable.class.getDeclaredField("artMethod");     // Catch: Exception -> L41
        r117.setAccessible(true);     // Catch: Exception -> L41
        r112 = r117.getLong(r116);     // Catch: Exception -> L41
    L59:
        return;
    L58:
        return;
    L16:
        e = e;
    L20:
        e.printStackTrace();
    L18:
        e = e;
        r101 = 0;
        r102 = 0;
        goto L20
    }
}
