package com.bytedance.sysoptimizer.anr;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sysoptimizer.SysOptimizer;
import com.bytedance.sysoptimizer.anr.utils.ActivityLeakCollect;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class AnrManager {
    private static final String TAG = "SysAnrOpt";
    private static volatile AnrManager instance = null;
    private static int sLooperWaitMs = 1000;
    private static int sProxyTimeMs = 80000;
    private ExecutorService mAnrCallbackThreadPool;
    private int mAnrCallbackThreadPoolSize;
    private final CopyOnWriteArrayList<AnrListener> mAnrListeners;
    private Context mContext;
    private float mCpuHighThreshold;
    private boolean mEnableAllProcessPss;
    private boolean mEnableAnrReason;
    private int mFreedMBForSecondThreshold;
    private float mIoHighThreshold;
    private float mJavaMemHighThreshold;
    GcUsage mLastGcUsage;
    ResourceUsage mLastUsage;
    private long mLeve1Time;
    private int mLowMemThreshold;
    private float mMajFltHighThreshold;
    private boolean mMultiThreadProcessAnrCallback;
    private int mTotalPssThreshold;
    private int mblockGCCountFor10SecondThreshold;
    private int mblockGCTimeForSecondThreshold;

    /* JADX INFO: loaded from: classes22.dex */
    public class AnrReason {
        public static final int REASON_CPU_HIGHT = 3;
        public static final int REASON_GC_HIGHT = 5;
        public static final int REASON_IO_HIGHT = 4;
        public static final int REASON_JAVA_HEAP_HIGHT = 1;
        public static final int REASON_LOW_MEMORY = 8;
        public static final int REASON_MAIN_THREAD_D = 9;
        public static final int REASON_MAIN_THREAD_SLOW = 6;
        public static final int REASON_MAJFLT_HIGHT = 7;
        public static final int REASON_PSS_HIGHT = 2;
        public static final int REASON_UNKONW = 0;
        private Map<String, Integer> mActivityLeakMap;
        private int mAvailMemMB;
        private int mAverageMajFltForSecond;
        private float mBlockGCCountFor10Second;
        private float mBlockGCTimeForSecond;
        private float mCpuUsage;
        private float mFreedMBForSecond;
        private boolean mIsContinuouslyStuck;
        private float mJavaMemUsage;
        private int mNewAnrLevel;
        private Map<String, Integer> mProcessPssInfos;
        private int mReason;
        private int mTotalMemMB;
        private int mTotalPss;
        private int mUsageJavaHeapKb;
        final /* synthetic */ AnrManager this$0;

        public String getReasonDescription(int r100) {
            switch(r100) {
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L17;
                case 4: goto L15;
                case 5: goto L13;
                case 6: goto L11;
                case 7: goto L9;
                case 8: goto L7;
                case 9: goto L5;
                default: goto L3;
            };
        L3:
            return "REASON_UNKONW";
        L5:
            return "REASON_MAIN_THREAD_D";
        L7:
            return "REASON_LOW_MEMORY";
        L9:
            return "REASON_MAJFLT_HIGHT";
        L11:
            return "REASON_MAIN_THREAD_SLOW";
        L13:
            return "REASON_GC_HIGHT";
        L15:
            return "REASON_IO_HIGHT";
        L17:
            return "REASON_CPU_HIGHT";
        L19:
            return "REASON_PSS_HIGHT";
        L21:
            return "REASON_JAVA_HEAP_HIGHT";
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder("AnrReason{javaMemUsage=");
            r100.append(this.mJavaMemUsage);
            r100.append("%, mUsageJavaHeapKb=");
            r100.append(this.mUsageJavaHeapKb);
            r100.append("KB, averageMajFltForSecond=");
            r100.append(this.mAverageMajFltForSecond);
            r100.append(", availMem=");
            r100.append(this.mAvailMemMB);
            r100.append("MB, totalMem=");
            r100.append(this.mTotalMemMB);
            r100.append("MB, totalPss=");
            r100.append(this.mTotalPss);
            r100.append("MB, processPssCount=");
            Map<String, Integer> r101 = this.mProcessPssInfos;
            if (r101 == null) goto L5;
            int r102 = r101.size();
        L6:
            r100.append(r102);
            r100.append(", cpuUsage=");
            r100.append(this.mCpuUsage);
            r100.append("%, blockGCCountFor10Second=");
            r100.append(this.mBlockGCCountFor10Second);
            r100.append(", blockGCTimeForSecond=");
            r100.append(this.mBlockGCTimeForSecond);
            r100.append(", bytesFreedMBForSecond=");
            r100.append(this.mFreedMBForSecond);
            r100.append("MB, mReason=");
            r100.append(getReasonDescription(this.mReason));
            r100.append(i.f25855d);
            return r100.toString();
        L5:
            r102 = 0;
            goto L6
        }

        public Map<String, Integer> getActivityLeakMap() {
            return this.mActivityLeakMap;
        }

        public int getAvailMemMB() {
            return this.mAvailMemMB;
        }

        public int getAverageMajFltForSecond() {
            return this.mAverageMajFltForSecond;
        }

        public float getBlockGCCountFor10Second() {
            return this.mBlockGCCountFor10Second;
        }

        public float getBlockGCTimeForSecond() {
            return this.mBlockGCTimeForSecond;
        }

        public float getCpuUsage() {
            return this.mCpuUsage;
        }

        public float getFreedMBForSecond() {
            return this.mFreedMBForSecond;
        }

        public float getJavaMemUsage() {
            return this.mJavaMemUsage;
        }

        public int getNewAnrLevel() {
            return this.mNewAnrLevel;
        }

        public Map<String, Integer> getProcessPssInfos() {
            return this.mProcessPssInfos;
        }

        public int getReason() {
            return this.mReason;
        }

        public int getTotalMemMB() {
            return this.mTotalMemMB;
        }

        public int getTotalPss() {
            return this.mTotalPss;
        }

        public int getUsageJavaHeapKb() {
            return this.mUsageJavaHeapKb;
        }

        public boolean isContinuouslyStuck() {
            return this.mIsContinuouslyStuck;
        }

        public AnrReason(AnrManager r100) {
            this.this$0 = r100;
            this.mJavaMemUsage = 0.0f;
            this.mTotalPss = 0;
            this.mCpuUsage = 0.0f;
            this.mAverageMajFltForSecond = 0;
            this.mUsageJavaHeapKb = 0;
            this.mBlockGCCountFor10Second = 0.0f;
            this.mBlockGCTimeForSecond = 0.0f;
            this.mFreedMBForSecond = 0.0f;
            this.mAvailMemMB = 0;
            this.mTotalMemMB = 0;
            this.mIsContinuouslyStuck = false;
            this.mNewAnrLevel = 0;
            this.mProcessPssInfos = new HashMap();
            this.mReason = 0;
            this.mActivityLeakMap = new HashMap();
        }

        public void setActivityLeakMap(Map<String, Integer> r100) {
            this.mActivityLeakMap = r100;
        }

        public void setAvailMemMB(int r100) {
            this.mAvailMemMB = r100;
        }

        public void setAverageMajFltForSecond(int r100) {
            this.mAverageMajFltForSecond = r100;
        }

        public void setBlockGCCountFor10Second(float r100) {
            this.mBlockGCCountFor10Second = r100;
        }

        public void setBlockGCTimeForSecond(float r100) {
            this.mBlockGCTimeForSecond = r100;
        }

        public void setCpuUsage(float r100) {
            this.mCpuUsage = r100;
        }

        public void setFreedMBForSecond(float r100) {
            this.mFreedMBForSecond = r100;
        }

        public void setIsContinuouslyStuck(boolean r100) {
            this.mIsContinuouslyStuck = r100;
        }

        public void setJavaMemUsage(float r100) {
            this.mJavaMemUsage = r100;
        }

        public void setNewAnrLevel(int r100) {
            this.mNewAnrLevel = r100;
        }

        public void setProcessPssInfos(Map<String, Integer> r100) {
            if (r100 != null) goto L5;
            this.mProcessPssInfos = new HashMap();
            return;
        L5:
            this.mProcessPssInfos = r100;
        }

        public void setReason(int r100) {
            this.mReason = r100;
        }

        public void setTotalMemMB(int r100) {
            this.mTotalMemMB = r100;
        }

        public void setTotalPss(int r100) {
            this.mTotalPss = r100;
        }

        public void setUsageJavaHeapKb(int r100) {
            this.mUsageJavaHeapKb = r100;
        }
    }

    public static AnrManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(AnrMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new AnrManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AnrMonitor.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private AnrManager() {
        this.mAnrListeners = new CopyOnWriteArrayList();
        this.mEnableAnrReason = true;
        this.mCpuHighThreshold = 30.0f;
        this.mJavaMemHighThreshold = 70.0f;
        this.mIoHighThreshold = 20.0f;
        this.mMajFltHighThreshold = 100.0f;
        this.mLowMemThreshold = 1024;
        this.mTotalPssThreshold = 2048;
        this.mblockGCTimeForSecondThreshold = 200;
        this.mblockGCCountFor10SecondThreshold = 100;
        this.mFreedMBForSecondThreshold = 30;
        this.mEnableAllProcessPss = false;
        this.mMultiThreadProcessAnrCallback = false;
        this.mAnrCallbackThreadPoolSize = -1;
        this.mLastUsage = new ResourceUsage();
        this.mLastGcUsage = new GcUsage();
        this.mLeve1Time = 0;
        SysOptimizer.loadOptimizerLibrary(null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    private float getMemoryUseRate(AnrReason r100) {
        Runtime r101 = Runtime.getRuntime();
        long r102 = r101.maxMemory();
        long r103 = r101.totalMemory() - r101.freeMemory();
        r100.setUsageJavaHeapKb((int) (r103 / 1024));
        return (r103 * 100.0f) / r102;
    }

    private void readCpuData(AnrReason r100) {
        r100.setCpuUsage(0.0f);
        if (0.0f <= this.mCpuHighThreshold) goto L6;
        r100.setReason(3);
        return;
    }

    private void readGcData(AnrReason r100) {
        GcUsage r101 = new GcUsage();
        if (Build.VERSION.SDK_INT < 23) goto L17;
        Map<String, String> r102 = Debug.getRuntimeStats();
        r101.blockingGcCountTotal = readRunTimeStats(r102, "art.gc.blocking-gc-count");
        r101.blockingGcTimeTotal = readRunTimeStats(r102, "art.gc.blocking-gc-time");
        r101.gcCountTotal = readRunTimeStats(r102, "art.gc.gc-count");
        r101.gcTimeTotal = readRunTimeStats(r102, "art.gc.gc-time");
        r101.bytesAllocatedTotal = readRunTimeStats(r102, "art.gc.bytes-allocated");
        r101.bytesFreedTotal = readRunTimeStats(r102, "art.gc.bytes-freed");
        r101.blockingGcCountRateHistogram = readRunTimeStatsRateHistogram(r102, "art.gc.blocking-gc-count-rate-histogram");
        r101.gcCountRateHistogram = readRunTimeStatsRateHistogram(r102, "art.gc.gc-count-rate-histogram");
        r101.recordTimestamp = System.currentTimeMillis();
        r100.setBlockGCCountFor10Second(r101.blockingGcCountRateHistogram);
        if (r101.blockingGcCountRateHistogram <= this.mblockGCCountFor10SecondThreshold) goto L7;
        r100.setReason(5);
    L7:
        long r103 = r101.recordTimestamp;
        GcUsage r104 = this.mLastGcUsage;
        float r105 = (r103 - r104.recordTimestamp) / 1000.0f;
        float r106 = (((r101.bytesFreedTotal - r104.bytesFreedTotal) / 1024) / 1024) / r105;
        if (r106 >= 0.0f) goto L10;
    L12:
        r100.setBlockGCTimeForSecond((r101.blockingGcTimeTotal - this.mLastGcUsage.blockingGcTimeTotal) / r105);
        if (r100.getBlockGCTimeForSecond() <= this.mblockGCTimeForSecondThreshold) goto L15;
        r100.setReason(5);
    L15:
        this.mLastGcUsage = r101;
        return;
    L10:
        if (r106 > 512.0f) goto L12;
        r100.setFreedMBForSecond(r106);
        goto L12
    }

    private void readMemData(AnrReason r100) {
        float r101 = getMemoryUseRate(r100);
        r100.setJavaMemUsage(r101);
        if (r101 <= this.mJavaMemHighThreshold) goto L5;
        r100.setReason(1);
    L5:
        ResourceUsage r102 = new ResourceUsage();
        r102.pss = getPssMemoryMB(this.mContext, r100);
        r102.recordTimestamp = System.currentTimeMillis();
        int r103 = (int) r102.pss;
        r100.setTotalPss(r103);
        if (r103 <= this.mTotalPssThreshold) goto L8;
        r100.setReason(2);
    L8:
        getAvailablePhysicalMemory(this.mContext, r100);
        if (r100.getAvailMemMB() > this.mLowMemThreshold) goto L11;
        r100.setReason(8);
    L11:
        long r104 = r102.recordTimestamp;
        ResourceUsage r105 = this.mLastUsage;
        int r106 = (int) ((r102.majFlt - r105.majFlt) / ((r104 - r105.recordTimestamp) / 1000.0f));
        r100.setAverageMajFltForSecond(r106);
        if (r106 <= this.mMajFltHighThreshold) goto L15;
        r100.setReason(7);
    L15:
        if ("D".equals(r102.threadState) == false) goto L19;
        long r107 = r102.utm + r102.stm;
        ResourceUsage r108 = this.mLastUsage;
        if (((r107 - r108.utm) - r108.stm) >= 50) goto L19;
    L22:
        r100.setReason(9);
    L23:
        r100.setActivityLeakMap(ActivityLeakCollect.getLeaksGreaterThanOne());
        this.mLastUsage = r102;
        return;
    L19:
        if ("D".equals(r102.threadState) == false) goto L23;
        if ("D".equals(this.mLastUsage.threadState) == false) goto L23;
        goto L22
    }

    public void init(Application r100) {
        this.mContext = r100;
        ActivityLeakCollect.registerActivity(r100);
    }

    public void registerListener(AnrListener r100) {
        if (this.mAnrListeners.size() != 0) goto L5;
        AnrMonitor.getInstance().anrOptStart(sProxyTimeMs, sLooperWaitMs);
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (this.mAnrListeners.contains(r100) == true) goto L11;
        this.mAnrListeners.add(r100);
        return;
    }

    public synchronized void setAnrCallbackThreadPoolSize(int r100) {
        monitor-enter(this);
        this.mAnrCallbackThreadPoolSize = r100;     // Catch: Throwable -> L18
        if (r100 <= 0) goto L6;
        boolean r101 = true;
    L7:
        this.mMultiThreadProcessAnrCallback = r101;     // Catch: Throwable -> L18
        if (r101 == true) goto L12;
        monitor-exit(this);
        return;
    L12:
        if (this.mAnrCallbackThreadPool == null) goto L15;
        monitor-exit(this);
        return;
    L15:
        this.mAnrCallbackThreadPool = PThreadExecutorsUtils.newFixedThreadPool(r100, new DefaultThreadFactory("nr/AnrManager"));     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L6:
        r101 = false;
    L18:
        th = move-exception;
        throw th;
    }

    public void setBlockGCCountFor10SecondThreshold(int r100) {
        this.mblockGCCountFor10SecondThreshold = r100;
    }

    public void setBlockGCTimeForSecondThreshold(int r100) {
        this.mblockGCTimeForSecondThreshold = r100;
    }

    public void setCpuHighThreshold(float r100) {
        this.mCpuHighThreshold = r100;
    }

    public void setEnableAllProcessPss(boolean r100) {
        this.mEnableAllProcessPss = r100;
    }

    public void setEnableAnrReason(boolean r100) {
        this.mEnableAnrReason = r100;
    }

    public void setFreedMBForSecondThreshold(int r100) {
        this.mFreedMBForSecondThreshold = r100;
    }

    public void setIoHighThreshold(float r100) {
        this.mIoHighThreshold = r100;
    }

    public void setJavaMemHighThreshold(float r100) {
        this.mJavaMemHighThreshold = r100;
    }

    public void setLooperWaitMs(int r100) {
        sLooperWaitMs = r100;
    }

    public void setMajFltHighThreshold(float r100) {
        this.mMajFltHighThreshold = r100;
    }

    public void setProxyTimeMs(int r100) {
        sProxyTimeMs = r100;
    }

    public void setTotalPssThreshold(int r100) {
        this.mTotalPssThreshold = r100;
    }

    public void unRegisterListener(AnrListener r100) {
        this.mAnrListeners.remove(r100);
        if (this.mAnrListeners.size() != 0) goto L6;
        AnrMonitor.getInstance().pauseThread();
        return;
    }

    public static void getAvailablePhysicalMemory(Context r100, AnrReason r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");
        ActivityManager.MemoryInfo r103 = new ActivityManager.MemoryInfo();
        r102.getMemoryInfo(r103);
        r101.setAvailMemMB((int) ((r103.availMem / 1024) / 1024));
        r101.setTotalMemMB((int) ((r103.totalMem / 1024) / 1024));
    }

    private long readRunTimeStats(Map<String, String> r100, String r101) {
        if (r100.containsKey(r101) == true) goto L9;
    L6:
        return 0;
    L9:
        return CastLongProtector.parseLong(r100.get(r101));
    }

    private int readRunTimeStatsRateHistogram(Map<String, String> r100, String r101) {
        if (r100.containsKey(r101) == false) goto L19;
        String[] r102 = r100.get(r101).split(",");
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L5:
        if (r104 >= r103) goto L12;
        String[] r106 = r102[r104].split(":");
        if (r106.length != 2) goto L10;
        r105 = r105 + (CastIntegerProtector.parseInt(r106[0]) * CastIntegerProtector.parseInt(r106[1]));
    L10:
        r104 = r104 + 1;
        goto L5
    L12:
        return r105;
    L19:
        return 0;
    }

    public int getPssMemoryMB(Context r110, AnrReason r111) {
        if (r110 != null) goto L73;
        return 0;
    L73:
        ActivityManager r100 = (ActivityManager) r110.getSystemService("activity");     // Catch: Throwable -> L70
        if (r100 != null) goto L9;
        return 0;
    L9:
        if (this.mEnableAllProcessPss == true) goto L23;
        Debug.MemoryInfo[] r101 = r100.getProcessMemoryInfo(new int[]{Process.myPid()});     // Catch: Throwable -> L70
        if (r101 != null) goto L13;
    L22:
        return 0;
    L13:
        if (r101.length == 0) goto L22;
        Debug.MemoryInfo r102 = r101[0];     // Catch: Throwable -> L70
        if (r102 == null) goto L22;
        long r103 = ((r102.dalvikPss + r102.nativePss) + r102.otherPss) + r102.getTotalSwappablePss();     // Catch: Throwable -> L70
        if (r111 == null) goto L21;
        HashMap r104 = new HashMap(1);     // Catch: Throwable -> L70
        r104.put(r110.getPackageName(), Integer.valueOf((int) (r103 / 1024)));     // Catch: Throwable -> L70
        r111.setProcessPssInfos(r104);     // Catch: Throwable -> L70
    L21:
        return (int) (r103 / 1024);
    L23:
        List<ActivityManager.RunningAppProcessInfo> r105 = r100.getRunningAppProcesses();     // Catch: Throwable -> L70
        if (r105 != null) goto L26;
    L56:
        Debug.MemoryInfo[] r106 = r100.getProcessMemoryInfo(new int[]{Process.myPid()});     // Catch: Throwable -> L70
        if (r106 != null) goto L59;
    L69:
        return 0;
    L59:
        if (r106.length == 0) goto L69;
        Debug.MemoryInfo r107 = r106[0];     // Catch: Throwable -> L70
        if (r107 == null) goto L69;
        long r108 = ((r107.dalvikPss + r107.nativePss) + r107.otherPss) + r107.getTotalSwappablePss();     // Catch: Throwable -> L70
        if (r111 == null) goto L68;
        HashMap r109 = new HashMap(1);     // Catch: Throwable -> L70
        r109.put(r110.getPackageName(), Integer.valueOf((int) (r108 / 1024)));     // Catch: Throwable -> L70
        r111.setProcessPssInfos(r109);     // Catch: Throwable -> L70
    L68:
        return (int) (r108 / 1024);
    L26:
        if (r105.isEmpty() == true) goto L56;
        int r112 = r105.size();     // Catch: Throwable -> L70
        int[] r113 = new int[r112];     // Catch: Throwable -> L70
        String[] r114 = new String[r112];     // Catch: Throwable -> L70
        int r115 = 0;
    L29:
        if (r115 >= r112) goto L39;
        ActivityManager.RunningAppProcessInfo r116 = (ActivityManager.RunningAppProcessInfo) ListProtector.get(r105, r115);     // Catch: Throwable -> L70
        if (r116 == null) goto L33;
        int r117 = r116.pid;     // Catch: Throwable -> L70
    L34:
        r113[r115] = r117;     // Catch: Throwable -> L70
        if (r116 == null) goto L37;
        String r118 = r116.processName;     // Catch: Throwable -> L70
    L38:
        r114[r115] = r118;     // Catch: Throwable -> L70
        r115 = r115 + 1;     // Catch: Throwable -> L70
        goto L29
    L37:
        r118 = "unknown";
        goto L38
    L33:
        r117 = -1;
        goto L34
    L39:
        Debug.MemoryInfo[] r119 = r100.getProcessMemoryInfo(r113);     // Catch: Throwable -> L70
        HashMap r120 = new HashMap(r112);     // Catch: Throwable -> L70
        long r121 = 0;
        if (r119 == null) goto L52;
        int r122 = Math.min(r119.length, r112);     // Catch: Throwable -> L70
        int r123 = 0;
    L42:
        if (r123 >= r122) goto L52;
        Debug.MemoryInfo r124 = r119[r123];     // Catch: Throwable -> L70
        if (r124 == null) goto L51;
        long r125 = ((r124.dalvikPss + r124.nativePss) + r124.otherPss) + r124.getTotalSwappablePss();     // Catch: Throwable -> L70
        r121 = r121 + r125;     // Catch: Throwable -> L70
        int r126 = (int) (r125 / 1024);     // Catch: Throwable -> L70
        String r127 = r114[r123];     // Catch: Throwable -> L70
        Integer r128 = (Integer) r120.get(r127);     // Catch: Throwable -> L70
        if (r128 == null) goto L50;
        r126 = r126 + r128.intValue();     // Catch: Throwable -> L70
    L50:
        r120.put(r127, Integer.valueOf(r126));     // Catch: Throwable -> L70
    L51:
        r123 = r123 + 1;     // Catch: Throwable -> L70
    L52:
        if (r111 == null) goto L55;
        r111.setProcessPssInfos(r120);     // Catch: Throwable -> L70
    L55:
        return (int) (r121 / 1024);
    L70:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public void onAnrChange(final boolean r110, final int r111, int r112) {
        final AnrReason r100 = new AnrReason(this);
        r100.setNewAnrLevel(r112);     // Catch: Throwable -> L11
        if (r111 != 1) goto L6;
        this.mLeve1Time = System.currentTimeMillis();     // Catch: Throwable -> L11
    L47:
    L14:
        if (this.mEnableAnrReason == false) goto L45;
        long r101 = (Debug.threadCpuTimeNanos() - Debug.threadCpuTimeNanos()) / 100000;     // Catch: Throwable -> L28
        if (this.mCpuHighThreshold == (-1.0f)) goto L19;
        readCpuData(r100);     // Catch: Throwable -> L28
    L19:
        if (this.mJavaMemHighThreshold == (-1.0f)) goto L22;
        readMemData(r100);     // Catch: Throwable -> L28
    L22:
        if (this.mblockGCCountFor10SecondThreshold == (-1)) goto L25;
        readGcData(r100);     // Catch: Throwable -> L28
    L25:
        if (r100.getReason() != 0) goto L45;
        r100.setReason(6);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
    L45:
        Iterator<AnrListener> r113 = this.mAnrListeners.iterator();     // Catch: Throwable -> L40
    L31:
        if (r113.hasNext() == false) goto L58;
        final AnrListener r102 = r113.next();     // Catch: Throwable -> L40
        if (r102 == null) goto L31;
        if (this.mMultiThreadProcessAnrCallback == true) goto L37;
        r102.onAnrChange(r110, r111, r100);     // Catch: Throwable -> L40
        goto L31
    L37:
        this.mAnrCallbackThreadPool.execute(new AnonymousClass1(this, r102, r110, r111, r100));     // Catch: Throwable -> L40
        goto L31
    L58:
        return;
    L40:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (r111 <= 1) goto L47;
        if ((r111 - 1) != ((System.currentTimeMillis() - this.mLeve1Time) / ((long) sLooperWaitMs))) goto L47;
        r100.setIsContinuouslyStuck(true);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L14
    }
}
