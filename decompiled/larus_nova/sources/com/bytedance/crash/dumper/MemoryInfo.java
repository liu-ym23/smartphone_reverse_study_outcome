package com.bytedance.crash.dumper;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import com.bytedance.crash.util.s;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class MemoryInfo {

    /* JADX INFO: loaded from: classes15.dex */
    public static class AppMemoryInfo implements Serializable {
        private static final String FILE_NAME = "app_memory.inf";
        private static final long serialVersionUID = 1;
        private int mLargeMemoryClass;
        private int mMemoryClass;
        private final long mNativeHeapAllocSize;
        private final long mNativeHeapFreeSize;
        private final long mNativeHeapSize;
        private final long mRuntimeFree;
        private final long mRuntimeMax;
        private final long mRuntimeTotal;

        public AppMemoryInfo(ActivityManager r100) {
            this.mNativeHeapSize = Debug.getNativeHeapSize();
            this.mNativeHeapAllocSize = Debug.getNativeHeapAllocatedSize();
            this.mNativeHeapFreeSize = Debug.getNativeHeapFreeSize();
            Runtime r101 = Runtime.getRuntime();
            this.mRuntimeMax = r101.maxMemory();
            this.mRuntimeFree = r101.freeMemory();
            this.mRuntimeTotal = r101.totalMemory();
            if (r100 == null) goto L6;
            this.mMemoryClass = r100.getMemoryClass();
            this.mLargeMemoryClass = r100.getLargeMemoryClass();
            return;
        }

        public static AppMemoryInfo load(File r100) {
            return (AppMemoryInfo) s.a(new PolarisFileWrapper(r100, FILE_NAME));
        }

        public void pushTo(JSONObject r100) {
            JSONObject r101 = new JSONObject();
            r101.put("native_heap_size", this.mNativeHeapSize);     // Catch: JSONException -> L5
            r101.put("native_heap_alloc_size", this.mNativeHeapAllocSize);     // Catch: JSONException -> L5
            r101.put("native_heap_free_size", this.mNativeHeapFreeSize);     // Catch: JSONException -> L5
            r101.put("max_memory", this.mRuntimeMax);     // Catch: JSONException -> L5
            r101.put("free_memory", this.mRuntimeFree);     // Catch: JSONException -> L5
            r101.put("total_memory", this.mRuntimeTotal);     // Catch: JSONException -> L5
            r101.put("memory_class", this.mMemoryClass);     // Catch: JSONException -> L5
            r101.put("large_memory_class", this.mLargeMemoryClass);     // Catch: JSONException -> L5
            r100.put("app_memory_info", r101);     // Catch: JSONException -> L5
            return;
        }

        public static void dump(File r100, ActivityManager r101) {
            AppMemoryInfo r102 = new AppMemoryInfo(r101);
            s.b(new PolarisFileWrapper(r100, FILE_NAME), r102);
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class DevMemoryInfo implements Serializable {
        private static final String FILE_NAME = "dev_memory.inf";
        private static final long KB = 1024;
        private static final long serialVersionUID = 1;
        private final long mDalvikPrivateDirty;
        private final long mDalvikPss;
        private final long mDalvikSharedDirty;
        private final long mNativePrivateDirty;
        private final long mNativePss;
        private final long mNativeSharedDirty;
        private final long mOtherPrivateDirty;
        private final long mOtherPss;
        private final long mOtherSharedDirty;
        private final long mSummaryGraphics;
        private final long mTotalPrivateClean;
        private final long mTotalPrivateDirty;
        private final long mTotalPss;
        private final long mTotalSharedClean;
        private final long mTotalSharedDirty;
        private final long mTotalSwappablePss;

        public DevMemoryInfo() {
            Debug.MemoryInfo r100 = new Debug.MemoryInfo();
            Debug.getMemoryInfo(r100);
            this.mDalvikPss = ((long) r100.dalvikPss) * 1024;
            this.mDalvikSharedDirty = ((long) r100.dalvikSharedDirty) * 1024;
            this.mDalvikPrivateDirty = ((long) r100.dalvikPrivateDirty) * 1024;
            this.mNativePss = ((long) r100.nativePss) * 1024;
            this.mNativeSharedDirty = ((long) r100.nativeSharedDirty) * 1024;
            this.mNativePrivateDirty = ((long) r100.nativePrivateDirty) * 1024;
            this.mOtherPss = ((long) r100.otherPss) * 1024;
            this.mOtherSharedDirty = ((long) r100.otherSharedDirty) * 1024;
            this.mOtherPrivateDirty = ((long) r100.otherPrivateDirty) * 1024;
            this.mTotalPss = ((long) r100.getTotalPss()) * 1024;
            this.mTotalSharedClean = ((long) r100.getTotalSharedClean()) * 1024;
            this.mTotalPrivateClean = ((long) r100.getTotalPrivateClean()) * 1024;
            this.mTotalSwappablePss = ((long) r100.getTotalSwappablePss()) * 1024;
            this.mTotalSharedDirty = ((long) r100.getTotalSharedDirty()) * 1024;
            this.mTotalPrivateDirty = ((long) r100.getTotalPrivateDirty()) * 1024;
            this.mSummaryGraphics = getSummaryGraphics(r100);
        }

        public static void dump(File r100) {
            DevMemoryInfo r101 = new DevMemoryInfo();
            s.b(new PolarisFileWrapper(r100, FILE_NAME), r101);
        }

        private static long getSummaryGraphics(Debug.MemoryInfo r100) {
            if (Build.VERSION.SDK_INT >= 23) goto L10;
            return 0;
        L10:
            return ((long) CastIntegerProtector.parseInt(r100.getMemoryStat("summary.graphics"))) * 1024;
        L12:
            return 0;
        }

        public static DevMemoryInfo load(File r100) {
            return (DevMemoryInfo) s.a(new PolarisFileWrapper(r100, FILE_NAME));
        }

        public void pushTo(JSONObject r100) {
            JSONObject r101 = new JSONObject();
            r101.put("dalvikPss", this.mDalvikPss);     // Catch: JSONException -> L5
            r101.put("dalvikSharedDirty", this.mDalvikSharedDirty);     // Catch: JSONException -> L5
            r101.put("dalvikPrivateDirty", this.mDalvikPrivateDirty);     // Catch: JSONException -> L5
            r101.put("nativePss", this.mNativePss);     // Catch: JSONException -> L5
            r101.put("nativeSharedDirty", this.mNativeSharedDirty);     // Catch: JSONException -> L5
            r101.put("nativePrivateDirty", this.mNativePrivateDirty);     // Catch: JSONException -> L5
            r101.put("otherPss", this.mOtherPss);     // Catch: JSONException -> L5
            r101.put("otherSharedDirty", this.mOtherSharedDirty);     // Catch: JSONException -> L5
            r101.put("otherPrivateDirty", this.mOtherPrivateDirty);     // Catch: JSONException -> L5
            r101.put("totalPss", this.mTotalPss);     // Catch: JSONException -> L5
            r101.put("totalPrivateClean", this.mTotalPrivateClean);     // Catch: JSONException -> L5
            r101.put("totalSharedClean", this.mTotalSharedClean);     // Catch: JSONException -> L5
            r101.put("totalSwappablePss", this.mTotalSwappablePss);     // Catch: JSONException -> L5
            r101.put("totalSharedDirty", this.mTotalSharedDirty);     // Catch: JSONException -> L5
            r101.put("totalPrivateDirty", this.mTotalPrivateDirty);     // Catch: JSONException -> L5
            r101.put("summary.graphics", this.mSummaryGraphics);     // Catch: JSONException -> L5
            r100.put("memory_info", r101);     // Catch: JSONException -> L5
            return;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class SysMemoryInfo implements Serializable {
        private static final String FILE_NAME = "sys_memory.inf";
        private static final long UNIT_SIZE = 536870912;
        private static final long serialVersionUID = 1;
        private final long mAvailMem;
        private final boolean mLowMemory;
        private final long mThreshold;
        private final long mTotalMem;

        public SysMemoryInfo(ActivityManager r100) {
            ActivityManager.MemoryInfo r101 = new ActivityManager.MemoryInfo();
            r100.getMemoryInfo(r101);
            this.mLowMemory = r101.lowMemory;
            this.mThreshold = r101.threshold;
            this.mAvailMem = r101.availMem;
            this.mTotalMem = r101.totalMem;
        }

        public static SysMemoryInfo load(File r100) {
            return (SysMemoryInfo) s.a(new PolarisFileWrapper(r100, FILE_NAME));
        }

        public void pushTo(JSONObject r100) {
            JSONObject r101 = new JSONObject();
            r101.put("lowMemory", this.mLowMemory);     // Catch: JSONException -> L5
            r101.put("threshold", this.mThreshold);     // Catch: JSONException -> L5
            r101.put("availMemUnit", this.mAvailMem / UNIT_SIZE);     // Catch: JSONException -> L5
            r101.put("totalMemUnit", this.mTotalMem / UNIT_SIZE);     // Catch: JSONException -> L5
            r100.put("sys_memory_info", r101);     // Catch: JSONException -> L5
            return;
        }

        public static void dump(File r100, ActivityManager r101) {
            if (r101 == null) goto L5;
            SysMemoryInfo r102 = new SysMemoryInfo(r101);
            s.b(new PolarisFileWrapper(r100, FILE_NAME), r102);
            return;
        }
    }

    public static void a(File r100) {
        Context r101 = com.bytedance.crash.i.getContext();
        if (r101 == null) goto L6;
        ActivityManager r102 = (ActivityManager) r101.getSystemService("activity");
        DevMemoryInfo.dump(r100);
        SysMemoryInfo.dump(r100, r102);
        AppMemoryInfo.dump(r100, r102);
        return;
    }

    public static void b(JSONObject r110, File r111) {
        JSONObject r100 = null;
        BufferedReader r101 = null;
        if (r111 == null) goto L20;
        AppMemoryInfo r102 = AppMemoryInfo.load(r111);
        SysMemoryInfo r103 = SysMemoryInfo.load(r111);
        DevMemoryInfo r104 = DevMemoryInfo.load(r111);
        JSONObject r105 = new JSONObject();
        PolarisFileWrapper r106 = new PolarisFileWrapper(r111, "sys_memtrack.txt");
        if (r106.exists() == true) goto L53;
    L19:
        r100 = r105;
    L27:
        if (r102 == null) goto L29;
        r102.pushTo(r110);
    L29:
        if (r103 == null) goto L31;
        r103.pushTo(r110);
    L31:
        if (r104 == null) goto L33;
        r104.pushTo(r110);
    L33:
        if (r100 == null) goto L46;
        JSONObject r107 = r110.optJSONObject("memory_info");
        if (r107 != null) goto L39;
        r110.putOpt("memory_info", r100);     // Catch: Throwable -> L47
        return;
    L70:
        return;
    L39:
        if (r107.has("graphicPss") == true) goto L68;
        Iterator<String> r112 = r100.keys();
    L42:
        if (r112.hasNext() == false) goto L71;
        String r113 = r112.next();
        if (r107.has(r113) == true) goto L42;
        r107.put(r113, r100.opt(r113));
        goto L42
    L71:
        return;
    L68:
        return;
    L46:
        return;
    L53:
        BufferedReader r114 = new BufferedReader(new PolarisFileReaderWrapper(r106));     // Catch: Throwable -> L48
    L51:
        String r108 = r114.readLine();     // Catch: Throwable -> L17
        if (r108 == null) goto L16;
        if ("".equals(r108) == true) goto L51;
        String[] r109 = r108.split(" ");     // Catch: Throwable -> L17
        if (r109.length != 3) goto L51;
        String r115 = r109[0];     // Catch: Throwable -> L17
        r105.putOpt(r115.substring(0, r115.length() - 1), Long.valueOf(Long.parseLong(r109[1]) * 1024));     // Catch: Throwable -> L17
        goto L51
    L16:
        com.bytedance.crash.util.i.a(r114);
    L17:
        r101 = r114;
    L18:
        com.bytedance.crash.util.i.a(r101);
        goto L19
    L20:
        Context r116 = com.bytedance.crash.i.getContext();
        if (r116 == null) goto L25;
        ActivityManager r117 = (ActivityManager) r116.getSystemService("activity");
        if (r117 == null) goto L25;
        r102 = new AppMemoryInfo(r117);
        r103 = new SysMemoryInfo(r117);
    L26:
        r104 = new DevMemoryInfo();
    L25:
        r102 = null;
        r103 = null;
        goto L26
    }
}
