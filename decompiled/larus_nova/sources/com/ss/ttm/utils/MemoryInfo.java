package com.ss.ttm.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;

/* JADX INFO: loaded from: classes40.dex */
public class MemoryInfo {
    private static long[] mRomMemroy;
    private static long mTotalMemorySize;

    public MemoryInfo() {
    }

    public static long[] getRomMemroy() {
        if (mRomMemroy != null) goto L6;
        StatFs r100 = new StatFs(Environment.getDataDirectory().getPath());
        mRomMemroy = new long[]{getTotalInternalMemorySize(), ((long) r100.getBlockSize()) * ((long) r100.getAvailableBlocks())};
    L6:
        return mRomMemroy;
    }

    public static long getTolalMemory() {
        String r100 = null;
        r100 = null;
        r100 = null;
        r100 = null;
        BufferedReader r101 = null;
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper("/proc/meminfo"), 8);     // Catch: Throwable -> L13 Exception -> L15
        String r103 = r102.readLine();     // Catch: Exception -> L11 Throwable -> L22
        if (r103 == null) goto L7;
        r100 = r103;
    L7:
        r102.close();     // Catch: Exception -> L9
    L32:
    L21:
        return CastIntegerProtector.parseInt(r100.substring(r100.indexOf(58) + 1, r100.indexOf(107)).trim());
    L11:
        e = e;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L22
        if (r102 == null) goto L21;
        r102.close();     // Catch: Exception -> L9
    L22:
        th = th;
        r101 = r102;
    L24:
        if (r101 != null) goto L36;
    L29:
        throw th;
    L36:
        r101.close();     // Catch: Exception -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L9:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = e;
        r102 = null;
    L13:
        th = th;
        goto L24
    }

    public static long getTotalInternalMemorySize() {
        if (mTotalMemorySize != 0) goto L6;
        StatFs r100 = new StatFs(Environment.getDataDirectory().getPath());
        mTotalMemorySize = ((long) r100.getBlockCount()) * r100.getBlockSize();
    L6:
        return mTotalMemorySize;
    }

    public static long getAvailMemory(Context r100) {
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");
        ActivityManager.MemoryInfo r102 = new ActivityManager.MemoryInfo();
        r101.getMemoryInfo(r102);
        return r102.availMem / 1024;
    }
}
