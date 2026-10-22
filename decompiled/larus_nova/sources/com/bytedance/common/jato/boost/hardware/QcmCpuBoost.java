package com.bytedance.common.jato.boost.hardware;

import android.content.Context;
import android.os.Build;
import com.bytedance.common.jato.util.DoubleReflector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class QcmCpuBoost implements ICpuBoost {
    private static final int[] APP_LAUNCH_BOOST_2_CLUSTER = null;
    private static final int[] APP_LAUNCH_BOOST_2_CLUSTER_COMMON = null;
    private static final int[] APP_LAUNCH_BOOST_2_CLUSTER_M = null;
    private static final int[] APP_LAUNCH_BOOST_2_CLUSTER_N = null;
    private static final int[] APP_LAUNCH_BOOST_2_CLUSTER_O = null;
    private static final int[] APP_LAUNCH_BOOST_3_CLUSTER = null;
    private static int[] QCOM_DISABLE_LPM;
    private static int[] QCOM_GPU_BOOST;
    private static int[] QCOM_STORAGE_BOOST;
    private static CopyOnWriteArrayList<Integer> sBoostHandles;
    private static Method sQcomBoostMethod;
    private static Object sQcomBoostObj;
    private static Method sQcomReleaseMethod;
    private int[] APP_BOOST_CMD;
    private BoostFramework mFramwork;
    Method[] methods;

    static {
        APP_LAUNCH_BOOST_3_CLUSTER = new int[]{1077936128, 1, 1086324736, 1, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1082130944, UnixStat.PERM_MASK, 1098907648, 255, 1119944704, 1, 1124073472, 255, 1128267776, 65535, 1115799552, 2000, 1115734016, 1000};
        APP_LAUNCH_BOOST_2_CLUSTER = new int[]{1077936128, 1, 1086324736, 1, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1098907648, 255, 1119944704, 1, 1124073472, 255, 1128267776, 65535, 1115799552, 2000, 1115734016, 1000};
        APP_LAUNCH_BOOST_2_CLUSTER_O = new int[]{1077936128, 1, 1086324736, 1, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1098907648, 255, 1119944704, 1, 1124073472, 255, 1128267776, 65535, 1115799552, 1, 1115734016, 1000};
        APP_LAUNCH_BOOST_2_CLUSTER_N = new int[]{1077936128, 1, 1086324736, 1, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1098907648, 255, 1119944704, 1};
        APP_LAUNCH_BOOST_2_CLUSTER_M = new int[]{1077936128, 1, 1086324736, 1, 1090519040, 4, 1090519296, 4, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1098907648, 255};
        APP_LAUNCH_BOOST_2_CLUSTER_COMMON = new int[]{1077936128, 1, 1086324736, 1, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1098907648, 255, 1119944704, 1};
        QCOM_GPU_BOOST = new int[]{1115701248, 1, 1115734016, 2000};
        QCOM_DISABLE_LPM = new int[]{1077936128, 1};
        QCOM_STORAGE_BOOST = new int[]{1119944704, 1};
        sQcomBoostObj = null;
        sQcomBoostMethod = null;
        sQcomReleaseMethod = null;
        sBoostHandles = new CopyOnWriteArrayList();
    }

    private static int getQcomCluster() {
        File[] r100 = new PolarisFileWrapper("/sys/devices/system/cpu/cpufreq").listFiles();
        if (r100 != null) goto L7;
        return 1;
    L7:
        return r100.length;
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public void release() {
        if (sQcomReleaseMethod != null) goto L5;
        return;
    L5:
        if (sQcomBoostObj == null) goto L19;
        int r100 = 0;
    L15:
    L12:
        th = move-exception;
        this.mFramwork.errorLog("cpuboost release fail" + th.getMessage());
        return;
    L8:
        if (r100 >= sBoostHandles.size()) goto L10;
        sQcomReleaseMethod.invoke(sQcomBoostObj, new Object[]{sBoostHandles.get(r100)});     // Catch: Throwable -> L12
        r100 = r100 + 1;     // Catch: Throwable -> L12
        goto L15
    L10:
        sBoostHandles.clear();     // Catch: Throwable -> L12
        return;
    }

    public QcmCpuBoost() {
        this.APP_BOOST_CMD = APP_LAUNCH_BOOST_2_CLUSTER_COMMON;
        this.mFramwork = null;
        this.methods = null;
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public boolean tryBoostCpu(long r100) {
        invokeBoost(r100, QCOM_DISABLE_LPM);
        return invokeBoost(r100, this.APP_BOOST_CMD);
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public boolean tryBoostGpu(long r100) {
        return invokeBoost(r100, QCOM_GPU_BOOST);
    }

    private boolean invokeBoost(long r100, int[] r101) {
        if (r100 > 0) goto L16;
        return false;
    L16:
    L13:
        th = move-exception;
        this.mFramwork.errorLog("cpuboost boost fail:" + th.getMessage());
        return false;
    L6:
        if (sQcomBoostObj != null) goto L8;
    L12:
        return true;
    L8:
        if (sQcomBoostMethod == null) goto L12;
        int r102 = ((Integer) sQcomBoostMethod.invoke(sQcomBoostObj, new Object[]{Integer.valueOf((int) r100), r101})).intValue();     // Catch: Throwable -> L13
        if (r102 == 0) goto L12;
        sBoostHandles.add(Integer.valueOf(r102));     // Catch: Throwable -> L13
        goto L12
    }

    @Override // com.bytedance.common.jato.boost.hardware.ICpuBoost
    public void init(BoostFramework r100, Context r101) {
        this.mFramwork = r100;
        Class<?> r102 = DoubleReflector.getClass("android.util.BoostFramework");     // Catch: Throwable -> L10
        this.methods = r102.getDeclaredMethods();     // Catch: Throwable -> L10
        sQcomBoostObj = DoubleReflector.getConstructor(r102, new Class[]{Context.class}).newInstance(new Object[]{r101});     // Catch: Throwable -> L7
    L8:
        Class r103 = Integer.TYPE;     // Catch: Throwable -> L10
        sQcomBoostMethod = DoubleReflector.getMethod(r102, "perfLockAcquire", new Class[]{r103, int[].class});     // Catch: Throwable -> L10
        sQcomReleaseMethod = DoubleReflector.getMethod(r102, "perfLockReleaseHandler", new Class[]{r103});     // Catch: Throwable -> L10
    L12:
        int r104 = getQcomCluster();
        int r105 = Build.VERSION.SDK_INT;
        if (r105 < 28) goto L19;
        if (r104 != 3) goto L17;
        this.APP_BOOST_CMD = APP_LAUNCH_BOOST_3_CLUSTER;
        return;
    L17:
        this.APP_BOOST_CMD = APP_LAUNCH_BOOST_2_CLUSTER;
        return;
    L19:
        if (r105 < 26) goto L22;
        this.APP_BOOST_CMD = APP_LAUNCH_BOOST_2_CLUSTER_O;
        return;
    L22:
        if (r105 < 24) goto L25;
        this.APP_BOOST_CMD = APP_LAUNCH_BOOST_2_CLUSTER_N;
        return;
    L25:
        if (r105 < 23) goto L36;
        this.APP_BOOST_CMD = APP_LAUNCH_BOOST_2_CLUSTER_M;
        return;
    L36:
        return;
    L7:
        sQcomBoostObj = DoubleReflector.getConstructor(r102, new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mFramwork.errorLog("cpuboost init fail: " + th.getMessage());
        goto L12
    }
}
