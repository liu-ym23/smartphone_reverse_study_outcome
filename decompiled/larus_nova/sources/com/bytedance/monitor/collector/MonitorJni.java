package com.bytedance.monitor.collector;

import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class MonitorJni {
    public MonitorJni() {
    }

    public static native void clearAllocateInfo();

    public static native void disableBinderHook();

    public static native void disableLock();

    public static native void doCollect();

    public static native void doDestroy();

    public static native void doDisableAtrace();

    public static native String doDumpAtrace();

    public static native String doDumpAtraceRange(long r100, long r101);

    public static native void doDumpAtraceRangeToALog(long r100, long r101);

    public static native String doDumpNativeStack(int r100);

    public static native void doEnableAtrace(int r100, long r101);

    public static native long doGetAppCpuTime();

    public static native long doGetCpuTime(int r100);

    public static native String doGetSchedInfo(int r100);

    public static native void doInit();

    public static native void doSetDebugMode(boolean r100);

    public static native void doStart();

    public static native void doStop();

    public static native void dumpProcInfoTimeRangeToALog(long r100, long r101);

    public static native void enableBinderHook();

    public static native void enableLock(long r100);

    public static native void enableLockAll(long r100, boolean r101);

    public static native ByteBuffer getAllocReportInfo();

    public static native long getBlockGCCount();

    public static native long getBlockGCTime();

    public static native long getBytesAllocatedEver();

    public static native long getGCCount();

    public static native long getGCTime();

    public static native long getMajorFaults();

    public static native long getMinorFaults();

    public static native long getObjectsAllocatedEver();

    public static native int getProcCGroup(int r100);

    public static native String getProcInfoTimeRange(long r100, long r101);

    public static native String getProcInfos();

    public static native ThreadStatInfo getThreadStatInfo(int r100, int r101);

    public static native long getTotalCPUTimeByTimeInStat(int r100);

    public static native boolean initJavaMem();

    public static native void keepProcHyperOpen(boolean r100);

    public static native boolean readProcFile(String r100, int[] r101, Object[] r102, long[] r103, float[] r104);

    public static native void releaseByteBuffer(long r100);

    public static native void setAlogInstance(long r100);

    public static native void setBufferSize(int r100);

    public static native boolean setEnableAllocatedMonitor(boolean r100, int r101, int r102, int r103, long r104, ClassLoader r105);

    public static native void startHyperMonitor();

    public static native boolean startOrStopAllocatedMonitor(boolean r100, String r101);

    public static native void stopHyperMonitor();
}
