package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Debug;
import android.os.Process;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class AnrThreadPriorityOptV2 {
    private static final AnrThreadPriorityOptV2 INSTANCE = null;
    private static final String TAG = "AnrThreadPriorityOptV2";
    private boolean mDebug;
    private volatile boolean mInitialized;
    private List<ThreadPriorityData> mThreadPriorityDataList;
    private Map<String, Integer> mThreadPriorityMapForName;
    private boolean mUseNative;

    public static class ThreadPriorityData {
        int expectedPriority;
        String name;
        int originalPriority;
        int tid;

        public String toString() {
            return "ThreadPriorityData{name='" + this.name + "', tid=" + this.tid + ", expectedPriority=" + this.expectedPriority + ", originalPriority=" + this.originalPriority + '}';
        }

        public ThreadPriorityData(String r100, int r101, int r102, int r103) {
            this.name = r100;
            this.tid = r101;
            this.expectedPriority = r102;
            this.originalPriority = r103;
        }
    }

    private static native void nativeInit(Map<String, Integer> r100, boolean r101);

    private static native void nativeRestoreThreadPriority();

    private static native void nativeSetThreadPriority();

    static {
        INSTANCE = new AnrThreadPriorityOptV2();
    }

    public void restoreThreadPriority() {
        if (this.mUseNative == false) goto L6;
        nativeRestoreThreadPriority();
        return;
    L6:
        List<ThreadPriorityData> r100 = this.mThreadPriorityDataList;
        monitor-enter(r100);
        List<ThreadPriorityData> r101 = this.mThreadPriorityDataList;     // Catch: Throwable -> L21
        if (r101 == null) goto L19;
        Iterator<ThreadPriorityData> r102 = r101.iterator();     // Catch: Throwable -> L21
    L12:
        if (r102.hasNext() == false) goto L19;
        ThreadPriorityData r103 = r102.next();     // Catch: Throwable -> L21
        int r104 = r103.tid;     // Catch: Throwable -> L18
        Process.setThreadPriority(r104, r103.originalPriority);     // Catch: Throwable -> L18
        if (this.mDebug == false) goto L12;
        r103.toString();     // Catch: Throwable -> L18
        Process.getThreadPriority(r104);     // Catch: Throwable -> L18
    L18:
        int r105 = r103.tid;     // Catch: Throwable -> L21
    L19:
        monitor-exit(r100);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public void setThreadPriority() {
        if (this.mUseNative == false) goto L6;
        nativeSetThreadPriority();
        return;
    L6:
        List<ThreadPriorityData> r100 = this.mThreadPriorityDataList;
        monitor-enter(r100);
    L21:
        th = move-exception;
        throw th;
    L9:
        if (this.mThreadPriorityDataList == null) goto L19;
        List<ThreadPriorityData> r101 = getAllThreadPriority();     // Catch: Throwable -> L21
        this.mThreadPriorityDataList = r101;     // Catch: Throwable -> L21
        Iterator<ThreadPriorityData> r102 = r101.iterator();     // Catch: Throwable -> L21
    L12:
        if (r102.hasNext() == false) goto L19;
        ThreadPriorityData r103 = r102.next();     // Catch: Throwable -> L21
        int r104 = r103.tid;     // Catch: Throwable -> L18
        Process.setThreadPriority(r104, r103.expectedPriority);     // Catch: Throwable -> L18
        if (this.mDebug == false) goto L12;
        r103.toString();     // Catch: Throwable -> L18
        Process.getThreadPriority(r104);     // Catch: Throwable -> L18
    L18:
        int r105 = r103.tid;     // Catch: Throwable -> L21
    L19:
        monitor-exit(r100);     // Catch: Throwable -> L21
    }

    private AnrThreadPriorityOptV2() {
        this.mThreadPriorityMapForName = new HashMap();
        this.mThreadPriorityDataList = new ArrayList();
        this.mInitialized = false;
        this.mDebug = false;
        this.mUseNative = false;
    }

    public List<ThreadPriorityData> getAllThreadPriority() {
        long r100 = Debug.threadCpuTimeNanos();
        ArrayList r101 = new ArrayList();
        PolarisFileWrapper r102 = new PolarisFileWrapper("/proc/self/task");
        if (r102.exists() == true) goto L5;
    L20:
        long r103 = (Debug.threadCpuTimeNanos() - r100) / 1000000;
        return r101;
    L5:
        if (r102.isDirectory() == false) goto L20;
        File[] r104 = r102.listFiles();
        if (r104 == null) goto L20;
        int r105 = r104.length;
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L20;
        File r107 = r104[r106];
        int r108 = CastIntegerProtector.parseInt(r107.getName());     // Catch: Exception -> L17 NumberFormatException -> L18
        int r109 = Process.getThreadPriority(r108);     // Catch: Exception -> L17 NumberFormatException -> L18
        if (r109 >= 0) goto L19;
        String r110 = getThreadName(r108);     // Catch: Exception -> L17 NumberFormatException -> L18
        String r111 = r110.replaceAll("\\d+", "*");     // Catch: Exception -> L17 NumberFormatException -> L18
        Integer r112 = this.mThreadPriorityMapForName.get(r111);     // Catch: Exception -> L17 NumberFormatException -> L18
        if (r112 == null) goto L19;
        r101.add(new ThreadPriorityData(r110, r108, r112.intValue(), r109));     // Catch: Exception -> L17 NumberFormatException -> L18
    L19:
        r106 = r106 + 1;
    L18:
        r107.getName();
    L17:
        r107.getName();
        goto L19
    }

    public static AnrThreadPriorityOptV2 getInstance() {
        return INSTANCE;
    }

    private String getThreadName(int r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper("/proc/self/task/" + r100 + "/comm");
        if (r101.exists() == false) goto L26;
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
    L17:
        return "Unknown";
    L26:
        return "Unknown";
    }

    public void init(Context r100, Map<String, Integer> r101, boolean r102, boolean r103) {
        if (this.mInitialized == true) goto L11;
        SysOptimizer.loadOptimizerLibrary(r100);
        this.mInitialized = true;
        this.mDebug = r103;
        this.mUseNative = r102;
        if (r102 == false) goto L7;
        nativeInit(r101, r103);
    L10:
        return;
    L7:
        if (r101 == null) goto L10;
        this.mThreadPriorityMapForName = new HashMap(r101);
        goto L10
    }
}
