package com.bytedance.common.jato.boost.hardware;

import android.content.Context;
import android.os.Build;
import com.bytedance.common.jato.JatoListener;

/* JADX INFO: loaded from: classes3.dex */
public class BoostFramework {
    private static BoostFramework sInstance;
    private ICpuBoost mBooster;
    private JatoListener mDebugListener;

    public synchronized void release() {
        monitor-enter(this);
        ICpuBoost r100 = this.mBooster;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.release();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private ICpuBoost createCpuBoost() {
        String r100 = Build.HARDWARE;
        debugLog("cpuboost hardware: " + r100);
        if (r100.startsWith("qcom") == false) goto L5;
    L28:
        debugLog("cpuboost qcm boost");
        return new QcmCpuBoost();
    L5:
        if (r100.startsWith("msm") == true) goto L28;
        if (r100.startsWith("qsc") == true) goto L28;
        if (r100.startsWith("sdm") == true) goto L28;
        if (r100.startsWith("mt") == false) goto L20;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 > 28) goto L17;
        debugLog("cpuboost mtk boost");
        return new MtkCpuBoost();
    L17:
        debugLog("cpuboost unsupport for MTK Android9: " + r100 + r101);
        return new VoidBoost();
    L20:
        if (r100.startsWith("kirin") == false) goto L22;
    L26:
        debugLog("cpuboost hisilicon boost");
        return new HisiCpuBoost();
    L22:
        if (r100.startsWith("hi") == true) goto L26;
        debugLog("cpuboost not found boost for: " + r100);
        return new VoidBoost();
    }

    public static synchronized BoostFramework getInstance() {
        monitor-enter(BoostFramework.class);
        BoostFramework r100 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(BoostFramework.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public void debugLog(String r100) {
        JatoListener r101 = this.mDebugListener;
        if (r101 == null) goto L6;
        r101.onDebugInfo(r100);
        return;
    }

    public void errorLog(String r100) {
        JatoListener r101 = this.mDebugListener;
        if (r101 == null) goto L6;
        r101.onDebugInfo(r100);
        return;
    }

    public synchronized boolean tryCpuBoost(long r100) {
        monitor-enter(this);
        ICpuBoost r101 = this.mBooster;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        boolean r102 = r101.tryBoostCpu(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        monitor-exit(this);
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized boolean tryGpuBoost(long r100) {
        monitor-enter(this);
        ICpuBoost r101 = this.mBooster;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        boolean r102 = r101.tryBoostGpu(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        monitor-exit(this);
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    private BoostFramework(Context r100, JatoListener r101) {
        this.mDebugListener = r101;
        ICpuBoost r102 = createCpuBoost();
        this.mBooster = r102;
        r102.init(this, r100);
    }

    public static synchronized BoostFramework getInstanceOrCreate(Context r100, JatoListener r101) {
        monitor-enter(BoostFramework.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (sInstance == null) goto L7;
    L14:
        BoostFramework r102 = sInstance;     // Catch: Throwable -> L17
        monitor-exit(BoostFramework.class);
        return r102;
    L7:
        monitor-enter(BoostFramework.class);     // Catch: Throwable -> L17
        sInstance = new BoostFramework(r100, r101);     // Catch: Throwable -> L11
        monitor-exit(BoostFramework.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    }
}
