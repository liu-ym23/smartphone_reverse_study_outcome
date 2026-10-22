package com.bytedance.sysoptimizer;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes22.dex */
public class BitmapRecycleOpt {
    private static String TAG = "BitmapRecycleOpt";

    public BitmapRecycleOpt() {
    }

    private static native int nStart(int r100, int r101, long r102, long r103, long r104, boolean r105);

    public static int start(Context r110, boolean r111) {
        if (SysOptimizer.loadOptimizerLibrary(r110) == false) goto L53;
        Field r100 = Field.class.getDeclaredField("offset");     // Catch: Exception -> L42
        r100.setAccessible(true);     // Catch: Exception -> L42
        int r101 = r100.getInt(Bitmap.class.getDeclaredField("mRecycled"));     // Catch: Exception -> L42
        int r102 = r100.getInt(Bitmap.class.getDeclaredField("mNativePtr"));     // Catch: Exception -> L42
        if (Build.VERSION.SDK_INT < 26) goto L8;
        Class r112 = Integer.TYPE;     // Catch: Exception -> L42
        Class r113 = Long.TYPE;     // Catch: Exception -> L42
        Method r103 = BitmapRecycleOpt.class.getDeclaredMethod("nStart", new Class[]{r112, r112, r113, r113, r113, Boolean.TYPE});     // Catch: Exception -> L42
        Field r104 = Executable.class.getDeclaredField("artMethod");     // Catch: Exception -> L42
        r104.setAccessible(true);     // Catch: Exception -> L42
        long r114 = r104.getLong(r103);     // Catch: Exception -> L42
    L9:
        if (r101 != 0) goto L12;
        return -1;
    L12:
        if (r114 != 0) goto L45;
        return -1;
    L45:
        BufferedReader r105 = new BufferedReader(new PolarisFileReaderWrapper("/proc/self/maps"));     // Catch: IOException -> L30
        long r115 = 0;
        long r116 = 0;
        boolean r106 = false;
    L47:
        String r107 = r105.readLine();     // Catch: IOException -> L28
        if (r107 == null) goto L26;
        if (r107.contains("dalvik-main space") == false) goto L24;
        String[] r108 = r107.split("\\s+")[0].split("-");     // Catch: IOException -> L28
        if (r106 == true) goto L23;
        r115 = CastLongProtector.parseLong(r108[0], 16);     // Catch: IOException -> L28
        r106 = true;
    L23:
        r116 = CastLongProtector.parseLong(r108[1], 16);     // Catch: IOException -> L28
        goto L47
    L24:
        if (r106 == false) goto L47;
    L26:
        r105.close();     // Catch: IOException -> L28
    L34:
        if (r115 != 0) goto L36;
    L40:
        return -1;
    L36:
        if (r116 == 0) goto L40;
        return nStart(r101, r102, r115, r116, r114, r111);
    L28:
        e = e;
    L32:
        e.printStackTrace();
    L30:
        e = e;
        r115 = 0;
        r116 = 0;
        goto L32
    L8:
        r114 = 0;
    L54:
        return -1;
    L53:
        return -1;
    }
}
