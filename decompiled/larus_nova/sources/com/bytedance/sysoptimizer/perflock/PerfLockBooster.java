package com.bytedance.sysoptimizer.perflock;

import android.content.Context;
import android.os.Handler;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sysoptimizer.SysOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class PerfLockBooster {
    private static final String TAG = "PerfLockBooster";
    private static Handler sExecuteHandler = null;
    static boolean sFixQualUnTrustedAppAccessIssue = false;
    private static float sGlobalBoostControlLevel = 1.0f;
    private static int sGlobalExtendBoostEnableLevel = 0;
    private static int sGlobalMaxBoostTimeout = -1;
    private static FrameworkPerfLock.PerfLockImpl sPerfLockImpl;

    public static class DevBoostRunable implements Runnable {
        Context mContext;
        private String mParaString;
        private int[] mParas;
        int mRadix;
        private int mTimeout;

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_sysoptimizer_perflock_PerfLockBooster$DevBoostRunable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_sysoptimizer_perflock_PerfLockBooster$DevBoostRunable__run$___twin___() {
            if (this.mContext != null) goto L5;
            return;
        L5:
            String r100 = this.mParaString;
            if (r100 == null) goto L10;
            int r101 = this.mRadix;
            if (r101 == (-1)) goto L10;
            this.mParas = PerfLockBooster.access$000(r100, r101);
        L10:
            int[] r102 = this.mParas;
            if (r102 != null) goto L13;
            return;
        L13:
            if (r102.length <= 0) goto L25;
            int r103 = this.mTimeout;
            if (r103 == (-1)) goto L26;
            int r104 = PerfLockBooster.access$100(r103);
            if (SysOptimizer.loadOptimizerLibrary(this.mContext) == false) goto L27;
            ByteHook.init();
            PerfLockBooster.access$200(this.mParas, r104);     // Catch: Throwable -> L21
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        }

        private DevBoostRunable() {
            this.mContext = null;
            this.mParas = null;
            this.mTimeout = -1;
            this.mParaString = null;
            this.mRadix = -1;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_sysoptimizer_perflock_PerfLockBooster$DevBoostRunable_com_larus_apm_impl_protector_RunnableLancet_run(DevBoostRunable r100) {
            r100.com_bytedance_sysoptimizer_perflock_PerfLockBooster$DevBoostRunable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public DevBoostRunable(Context r100, int[] r101, int r102) {
            this.mParaString = null;
            this.mRadix = -1;
            this.mContext = r100;
            this.mParas = r101;
            this.mTimeout = r102;
        }

        public DevBoostRunable(Context r100, String r101, int r102, int r103) {
            this.mParas = null;
            this.mContext = r100;
            this.mParaString = r101;
            this.mRadix = r102;
            this.mTimeout = r103;
        }
    }

    public static class FrameworkBoostRunable implements Runnable {
        Context mContext;
        private String mParaString;
        private int mTimeout;
        private int mType;

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_sysoptimizer_perflock_PerfLockBooster$FrameworkBoostRunable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_sysoptimizer_perflock_PerfLockBooster$FrameworkBoostRunable__run$___twin___() {
            if (this.mContext != null) goto L5;
            return;
        L5:
            int r100 = PerfLockBooster.access$100(this.mTimeout);
            String r101 = this.mParaString;
            if (r101 == null) goto L8;
            int[] r102 = PerfLockBooster.access$000(r101, 16);
        L10:
            if (PerfLockBooster.access$300() == null) goto L12;
            PerfLockBooster.access$300().invokePerfBoost(r102, r100);
            return;
        L12:
            PerfLockBooster.access$302(FrameworkPerfLock.getPerfLockImplByType(this.mType));
            if (PerfLockBooster.access$300() != null) goto L15;
            return;
        L15:
            if (PerfLockBooster.access$300().preparePerfParas(this.mContext) == false) goto L20;
            PerfLockBooster.access$300().setExtendBoostEnable(PerfLockBooster.access$400());
            PerfLockBooster.access$300().invokePerfBoost(r102, r100);
            return;
        L20:
            return;
        L8:
            r102 = null;
            goto L10
        }

        private FrameworkBoostRunable() {
            this.mContext = null;
            this.mType = -1;
            this.mTimeout = -1;
            this.mParaString = null;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_sysoptimizer_perflock_PerfLockBooster$FrameworkBoostRunable_com_larus_apm_impl_protector_RunnableLancet_run(FrameworkBoostRunable r100) {
            r100.com_bytedance_sysoptimizer_perflock_PerfLockBooster$FrameworkBoostRunable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public FrameworkBoostRunable(Context r100, int r101, String r102, int r103) {
            this.mContext = r100;
            this.mType = r101;
            this.mParaString = r102;
            this.mTimeout = r103;
        }
    }

    public PerfLockBooster() {
    }

    private static native int boos_mtk_with_params_by_perfservice(int[] r100, int r101);

    private static native int boost_dev_with_params(int[] r100, int r101);

    private static native int boost_mtk_dev_with_params(int[] r100, int r101);

    private static native boolean do_cpu_schedule_opt(int r100, int r101, int r102);

    private static native boolean do_task_schedule_optimize(String[] r100, int r101, int r102);

    private static native boolean is_mtk_perfd_valid();

    private static native boolean is_mtk_perfservice_valid();

    private static native boolean is_qti_perfd_valid();

    private static native void release_perflock_handle(int r100);

    public static boolean isExtendBoostEnable() {
        if (sGlobalExtendBoostEnableLevel <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ FrameworkPerfLock.PerfLockImpl access$300() {
        return sPerfLockImpl;
    }

    public static /* synthetic */ int access$400() {
        return sGlobalExtendBoostEnableLevel;
    }

    public static /* synthetic */ int access$100(int r100) {
        return calculateTimeout(r100);
    }

    public static /* synthetic */ FrameworkPerfLock.PerfLockImpl access$302(FrameworkPerfLock.PerfLockImpl r100) {
        sPerfLockImpl = r100;
        return r100;
    }

    private static int calculateTimeout(int r100) {
        int r101 = (int) (r100 * sGlobalBoostControlLevel);
        int r102 = sGlobalMaxBoostTimeout;
        if (r102 < 0) goto L7;
        if (r101 > r102) goto L6;
        return r101;
    L6:
        return r102;
    L7:
        return r101;
    }

    public static boolean isMTKPerdValid(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        ByteHook.init();
        return is_mtk_perfd_valid();
    L12:
        return false;
    L7:
        return false;
    }

    public static boolean isMTKPerfServiceValid(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        ByteHook.init();
        return is_mtk_perfservice_valid();
    L12:
        return false;
    L7:
        return false;
    }

    public static boolean isQtiPerdValid(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        ByteHook.init();
        return is_qti_perfd_valid();
    L12:
        return false;
    L7:
        return false;
    }

    public static void setGlobalExtendBoostLevel(int r100) {
        sGlobalExtendBoostEnableLevel = r100;
    }

    public static void setGlobalMaxBoostTimeout(int r100) {
        sGlobalMaxBoostTimeout = r100;
    }

    public static void setPerlockExecuteHandler(Handler r100) {
        sExecuteHandler = r100;
    }

    public static void setsFixQualUnTrustedAppAccessIssue(boolean r100) {
        sFixQualUnTrustedAppAccessIssue = r100;
    }

    public static void setsGlobalBoostControlLevel(float r100) {
        sGlobalBoostControlLevel = r100;
    }

    public static /* synthetic */ int[] access$000(String r100, int r101) {
        return parseStringToIntArrayByRadix(r100, r101);
    }

    public static /* synthetic */ int access$200(int[] r100, int r101) {
        return boost_dev_with_params(r100, r101);
    }

    private static int[] parseStringToIntArrayByRadix(String r100, int r101) {
        String[] r102 = r100.split(",");
        int[] r103 = new int[r102.length];
        int r104 = 0;
    L4:
        if (r104 >= r102.length) goto L10;
        r103[r104] = CastIntegerProtector.parseInt(r102[r104], r101);     // Catch: Exception -> L7
        r104 = r104 + 1;
    L7:
        e = move-exception;
        e.toString();
        return null;
    L10:
        return r103;
    }

    public static void releasePerflockHandle(Context r100, int r101) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L10;
        ByteHook.init();
        release_perflock_handle(r101);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    }

    public static boolean awareEvent(Context r100, int r101, int r102) {
        if (sGlobalBoostControlLevel != 0.0f) goto L5;
        return false;
    L5:
        int[] r103 = {r101};
        FrameworkPerfLock.PerfLockImpl r104 = sPerfLockImpl;
        if (r104 != null) goto L8;
        FrameworkPerfLock.PerfLockImpl r105 = FrameworkPerfLock.getPerfLockImplByType(4);
        sPerfLockImpl = r105;
        if (r105 != null) goto L12;
    L15:
        return false;
    L12:
        if (r105.preparePerfParas(r100) == false) goto L15;
        return sPerfLockImpl.invokePerfBoost(r103, r102);
    L8:
        return r104.invokePerfBoost(r103, r102);
    }

    public static int boostDevWithParams(Context r100, int[] r101, int r102) {
        if (sGlobalBoostControlLevel != 0.0f) goto L6;
        return -1;
    L6:
        Handler r103 = sExecuteHandler;
        if (r103 == null) goto L10;
        r103.postAtFrontOfQueue(new DevBoostRunable(r100, r101, r102));
        return 0;
    L10:
        int r104 = calculateTimeout(r102);
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L15;
        ByteHook.init();
        return boost_dev_with_params(r101, r104);
    L15:
        return 0;
    }

    public static int boostMTKByPerfservice(Context r100, int[] r101, int r102) {
        if (sGlobalBoostControlLevel != 0.0f) goto L6;
        return -1;
    L6:
        int r103 = calculateTimeout(r102);
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L11;
        ByteHook.init();
        return boos_mtk_with_params_by_perfservice(r101, r103);
    L16:
        return 0;
    L11:
        return 0;
    }

    public static int boostMTKDEVWithParams(Context r100, int[] r101, int r102) {
        if (sGlobalBoostControlLevel != 0.0f) goto L6;
        return -1;
    L6:
        int r103 = calculateTimeout(r102);
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L11;
        ByteHook.init();
        return boost_mtk_dev_with_params(r101, r103);
    L16:
        return 0;
    L11:
        return 0;
    }

    public static boolean boostByFrameworkPerfLock(Context r100, int r101, String r102, int r103) {
        if (sGlobalBoostControlLevel != 0.0f) goto L5;
        return false;
    L5:
        Handler r104 = sExecuteHandler;
        if (r104 == null) goto L9;
        r104.postAtFrontOfQueue(new FrameworkBoostRunable(r100, r101, r102, r103));
        return true;
    L9:
        int r105 = calculateTimeout(r103);
        if (r102 == null) goto L12;
        int[] r106 = parseStringToIntArrayByRadix(r102, 16);
    L13:
        FrameworkPerfLock.PerfLockImpl r107 = sPerfLockImpl;
        if (r107 != null) goto L16;
        FrameworkPerfLock.PerfLockImpl r108 = FrameworkPerfLock.getPerfLockImplByType(r101);
        sPerfLockImpl = r108;
        if (r108 != null) goto L20;
    L23:
        return false;
    L20:
        if (r108.preparePerfParas(r100) == false) goto L23;
        sPerfLockImpl.setExtendBoostEnable(sGlobalExtendBoostEnableLevel);
        return sPerfLockImpl.invokePerfBoost(r106, r105);
    L16:
        return r107.invokePerfBoost(r106, r105);
    L12:
        r106 = null;
        goto L13
    }

    public static int boostDevWithParamsString(Context r100, String r101, int r102, int r103) {
        if (sGlobalBoostControlLevel != 0.0f) goto L6;
        return -1;
    L6:
        Handler r104 = sExecuteHandler;
        if (r104 == null) goto L10;
        r104.postAtFrontOfQueue(new DevBoostRunable(r100, r101, r102, r103));
        return 0;
    L10:
        int r105 = calculateTimeout(r103);
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L19;
        ByteHook.init();
        int[] r106 = parseStringToIntArrayByRadix(r101, r102);     // Catch: Throwable -> L20
        if (r106 == null) goto L19;
        if (r106.length <= 0) goto L19;
        return boost_dev_with_params(r106, r105);
    L19:
        return 0;
    }

    public static boolean doCPUScheduleOptimize(Context r100, int r101, int r102, int r103) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L7;
        ByteHook.init();
        return do_cpu_schedule_opt(r101, r102, r103);
    L12:
        return false;
    L7:
        return true;
    }

    public static boolean doTaskScheduleOptimize(Context r100, String r101, int r102, int r103) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L10;
        String[] r104 = r101.split(",");
        ByteHook.init();
        if (r104 != null) goto L12;
        return true;
    L12:
        return do_task_schedule_optimize(r104, r102, r103);
    L9:
        return false;
    L10:
        return true;
    }

    public static boolean doTaskScheduleOptimize(Context r100, String[] r101, int r102, int r103) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        ByteHook.init();
        if (r101 != null) goto L12;
        return true;
    L12:
        return do_task_schedule_optimize(r101, r102, r103);
    L14:
        return false;
    L9:
        return true;
    }
}
