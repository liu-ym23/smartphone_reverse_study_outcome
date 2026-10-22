package android.ss.com.vboost;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.ss.com.vboost.request.RequestManager;
import android.ss.com.vboost.utils.LogUtil;
import android.ss.com.vboost.utils.RomUtils;
import android.util.SparseArray;
import androidx.camera.core.RetryPolicy;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class CapabilityScheduler {
    private static final FrequencyLevel DEFAULT_CORE_BOOST_LONG_LEVEL = null;
    private static final long DEFAULT_CORE_BOOST_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_CORE_BOOST_SHORT_LEVEL = null;
    private static final long DEFAULT_CORE_BOOST_SHORT_TIMEOUT = 1000;
    private static final FrequencyLevel DEFAULT_CORE_LIMIT_LONG_LEVEL = null;
    private static final long DEFAULT_CORE_LIMIT_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_CORE_LIMIT_SHORT_LEVEL = null;
    private static final long DEFAULT_CORE_LIMIT_SHORT_TIMEOUT = 3000;
    private static final FrequencyLevel DEFAULT_CPU_BOOST_LONG_LEVEL = null;
    private static final long DEFAULT_CPU_BOOST_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_CPU_BOOST_SHORT_LEVEL = null;
    private static final long DEFAULT_CPU_BOOST_SHORT_TIMEOUT = 1000;
    private static final FrequencyLevel DEFAULT_CPU_LIMIT_LONG_LEVEL = null;
    private static final long DEFAULT_CPU_LIMIT_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_CPU_LIMIT_SHORT_LEVEL = null;
    private static final long DEFAULT_CPU_LIMIT_SHORT_TIMEOUT = 3000;
    private static final FrequencyLevel DEFAULT_DDR_BOOST_LONG_LEVEL = null;
    private static final long DEFAULT_DDR_BOOST_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_DDR_BOOST_SHORT_LEVEL = null;
    private static final long DEFAULT_DDR_BOOST_SHORT_TIMEOUT = 1000;
    private static final FrequencyLevel DEFAULT_DDR_LIMIT_LONG_LEVEL = null;
    private static final long DEFAULT_DDR_LIMIT_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_DDR_LIMIT_SHORT_LEVEL = null;
    private static final long DEFAULT_DDR_LIMIT_SHORT_TIMEOUT = 3000;
    private static final FrequencyLevel DEFAULT_GPU_BOOST_LONG_LEVEL = null;
    private static final long DEFAULT_GPU_BOOST_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_GPU_BOOST_SHORT_LEVEL = null;
    private static final long DEFAULT_GPU_BOOST_SHORT_TIMEOUT = 1000;
    private static final FrequencyLevel DEFAULT_GPU_LIMIT_LONG_LEVEL = null;
    private static final long DEFAULT_GPU_LIMIT_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_GPU_LIMIT_SHORT_LEVEL = null;
    private static final long DEFAULT_GPU_LIMIT_SHORT_TIMEOUT = 3000;
    private static final FrequencyLevel DEFAULT_UFS_BOOST_LONG_LEVEL = null;
    private static final long DEFAULT_UFS_BOOST_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_UFS_BOOST_SHORT_LEVEL = null;
    private static final long DEFAULT_UFS_BOOST_SHORT_TIMEOUT = 1000;
    private static final FrequencyLevel DEFAULT_UFS_LIMIT_LONG_LEVEL = null;
    private static final long DEFAULT_UFS_LIMIT_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_UFS_LIMIT_SHORT_LEVEL = null;
    private static final long DEFAULT_UFS_LIMIT_SHORT_TIMEOUT = 3000;
    private static final int PRIORITY_LEVEL = 0;
    private static final String TAG = "CapabilityScheduler";
    private static SparseArray<CustomRequest> curRequest;
    private static ISchedulerInitialConfigProvider mIInitialConfigProvider;
    private static volatile long start;

    static {
        FrequencyLevel r0 = FrequencyLevel.LEVEL_9;
        DEFAULT_CPU_BOOST_SHORT_LEVEL = r0;
        DEFAULT_CPU_BOOST_LONG_LEVEL = r0;
        FrequencyLevel r1 = FrequencyLevel.LEVEL_3;
        DEFAULT_CPU_LIMIT_SHORT_LEVEL = r1;
        DEFAULT_CPU_LIMIT_LONG_LEVEL = r1;
        DEFAULT_GPU_BOOST_SHORT_LEVEL = r0;
        DEFAULT_GPU_BOOST_LONG_LEVEL = r0;
        DEFAULT_GPU_LIMIT_SHORT_LEVEL = r1;
        DEFAULT_GPU_LIMIT_LONG_LEVEL = r1;
        DEFAULT_DDR_BOOST_SHORT_LEVEL = r0;
        DEFAULT_DDR_BOOST_LONG_LEVEL = r0;
        DEFAULT_DDR_LIMIT_SHORT_LEVEL = r1;
        DEFAULT_DDR_LIMIT_LONG_LEVEL = r1;
        DEFAULT_UFS_BOOST_SHORT_LEVEL = r0;
        DEFAULT_UFS_BOOST_LONG_LEVEL = r0;
        DEFAULT_UFS_LIMIT_SHORT_LEVEL = r1;
        DEFAULT_UFS_LIMIT_LONG_LEVEL = r1;
        DEFAULT_CORE_BOOST_SHORT_LEVEL = r0;
        DEFAULT_CORE_BOOST_LONG_LEVEL = r0;
        DEFAULT_CORE_LIMIT_SHORT_LEVEL = r1;
        DEFAULT_CORE_LIMIT_LONG_LEVEL = r1;
        start = 0;
        curRequest = new SparseArray();
        mIInitialConfigProvider = null;
    }

    public CapabilityScheduler() {
    }

    public static ISchedulerInitialConfigProvider getInitialConfigProvider() {
        return mIInitialConfigProvider;
    }

    public static Set<CapabilityType> getSupportCapabilities() {
        return RequestManager.getInstance().getSupportCapabilities();
    }

    public static boolean isSupportCapability(CapabilityType r1) {
        return RequestManager.getInstance().isSupportCapability(r1);
    }

    public static int networkEnhance() {
        return 1;
    }

    public static void perfIn() {
        if ("1".equals(RomUtils.getSystemProperty("debug.vboost.disable")) == false) goto L5;
        boolean r0 = false;
    L6:
        switchVboost(r0);
        start = System.nanoTime();
        return;
    L5:
        r0 = true;
        goto L6
    }

    public static void perfOut() {
        LogUtil.debug(TAG, "cost:" + String.valueOf(System.nanoTime() - start));
    }

    public static int preloadIo() {
        return 1;
    }

    public static void registerApplication(Context r1) {
        RequestManager.getInstance().register(r1);
    }

    public static void registerApplogListener(VboostListener.VboostApplogListener r1) {
        RequestManager.getInstance().registerApplog(r1);
    }

    public static void registerSystemListener(VboostListener.SystemListener r1) {
        RequestManager.getInstance().registerSystemListener(r1);
    }

    public static void requestCpuBoost() {
        CustomRequest r0 = new CustomRequest(CapabilityType.CPU_FREQ_MIN, DEFAULT_CPU_BOOST_SHORT_LEVEL, 1000);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestCpuBoostLong() {
        CustomRequest r0 = new CustomRequest(CapabilityType.CPU_FREQ_MIN, DEFAULT_CPU_BOOST_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestCpuCoreBoost() {
        CustomRequest r0 = new CustomRequest(CapabilityType.CPU_CORE_MIN, DEFAULT_CORE_BOOST_SHORT_LEVEL, 1000);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestCpuCoreBoostLong() {
        CustomRequest r0 = new CustomRequest(CapabilityType.CPU_CORE_MIN, DEFAULT_CORE_BOOST_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestCpuCoreLimit() {
        CustomRequest r0 = new CustomRequest(CapabilityType.CPU_CORE_MAX, DEFAULT_CORE_LIMIT_SHORT_LEVEL, 3000);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestCpuCoreLimitLong() {
        CustomRequest r0 = new CustomRequest(CapabilityType.CPU_CORE_MAX, DEFAULT_CORE_LIMIT_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestCpuLimit() {
        CustomRequest r0 = new CustomRequest(CapabilityType.CPU_FREQ_MAX, DEFAULT_CPU_LIMIT_SHORT_LEVEL, 3000);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestCpuLimitLong() {
        CustomRequest r0 = new CustomRequest(CapabilityType.CPU_FREQ_MAX, DEFAULT_CPU_LIMIT_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static int requestCustomBoost(CustomRequest r1) {
        if (r1.restore == true) goto L5;
        RequestManager.getInstance().commitRequest(r1);
        return 0;
    L5:
        RequestManager.getInstance().cancelRequest(r1);
        return 0;
    }

    public static void requestDdrBoost() {
        CustomRequest r0 = new CustomRequest(CapabilityType.BUS_FREQ_MIN, DEFAULT_DDR_BOOST_SHORT_LEVEL, 1000);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestDdrBoostLong() {
        CustomRequest r0 = new CustomRequest(CapabilityType.BUS_FREQ_MIN, DEFAULT_DDR_BOOST_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestDdrLimit() {
        CustomRequest r0 = new CustomRequest(CapabilityType.BUS_FREQ_MIN, DEFAULT_DDR_LIMIT_SHORT_LEVEL, 3000);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestDdrLimitLong() {
        CustomRequest r0 = new CustomRequest(CapabilityType.BUS_FREQ_MIN, DEFAULT_DDR_LIMIT_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestGpuBoost() {
        CustomRequest r0 = new CustomRequest(CapabilityType.GPU_FREQ_MIN, DEFAULT_GPU_BOOST_SHORT_LEVEL, 1000);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestGpuBoostLong() {
        CustomRequest r0 = new CustomRequest(CapabilityType.GPU_FREQ_MIN, DEFAULT_GPU_BOOST_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestGpuLimit() {
        CustomRequest r0 = new CustomRequest(CapabilityType.GPU_FREQ_MAX, DEFAULT_GPU_LIMIT_SHORT_LEVEL, 3000);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestGpuLimitLong() {
        CustomRequest r0 = new CustomRequest(CapabilityType.GPU_FREQ_MAX, DEFAULT_GPU_LIMIT_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static IImageThumbFetch.Fetcher requestImageThumbFetcher() {
        CustomRequest r0 = new CustomRequest();
        r0.type = CapabilityType.THUMB_FETCH.getIndex();
        Object r1 = RequestManager.getInstance().commitRequest(r0);
        if ((r1 instanceof IImageThumbFetch.Fetcher) == true) goto L5;
        return null;
    L5:
        return (IImageThumbFetch.Fetcher) r1;
    }

    public static int requestOptimizedScene(CustomScene r2, int r3) {
        CustomRequest r0 = new CustomRequest(CapabilityType.PRESET_SCENE, r2);
        r0.timeout = r3;
        RequestManager.getInstance().commitRequest(r0);
        return 1;
    }

    public static int requestOptimizedScene(CustomScene r3, Status r4) {
        if (r4 != Status.END) goto L9;
        CustomRequest r5 = curRequest.get(r3.getId());
        if (r5 != null) goto L8;
        LogUtil.warn(TAG, "restore a not start scene: " + r3.getDesc());
        return 0;
    L8:
        r5.restore = true;
        RequestManager.getInstance().commitRequest(r5);
        curRequest.remove(r3.getId());
    L12:
        return 1;
    L9:
        CustomRequest r6 = new CustomRequest(CapabilityType.PRESET_SCENE, r3);
        r6.restore = false;
        if (RequestManager.getInstance().commitRequest(r6) == null) goto L12;
        curRequest.put(r3.getId(), r6);
        goto L12
    }

    public static void requestUfsBoost() {
        CustomRequest r0 = new CustomRequest(CapabilityType.UFS_FREQ_MIN, DEFAULT_UFS_BOOST_SHORT_LEVEL, 1000);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestUfsBoostLong() {
        CustomRequest r0 = new CustomRequest(CapabilityType.UFS_FREQ_MIN, DEFAULT_UFS_BOOST_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestUfsLimit() {
        CustomRequest r0 = new CustomRequest(CapabilityType.UFS_FREQ_MIN, DEFAULT_UFS_LIMIT_SHORT_LEVEL, 3000);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestUfsLimitLong() {
        CustomRequest r0 = new CustomRequest(CapabilityType.UFS_FREQ_MIN, DEFAULT_UFS_LIMIT_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void requestVibrateCapability(int r3, float r4, float r5, float r6, String r7) {
        CustomRequest r0 = new CustomRequest();
        Bundle r1 = new Bundle();
        r0.bundle = r1;
        r1.putInt("scene_type", r3);
        r0.bundle.putFloat("intensity", r4);
        r0.bundle.putFloat("sharpness", r5);
        r0.bundle.putFloat("duration", r6);
        r0.bundle.putString("jsonFilePath", r7);
        r0.type = CapabilityType.VIBRATE_ENHANCE.getIndex();
        RequestManager.getInstance().commitRequest(r0);
    }

    public static int resetAffinity(int r2) {
        CustomRequest r0 = new CustomRequest();
        r0.type = CapabilityType.CPU_AFFINITY.getIndex();
        r0.tid = r2;
        RequestManager.getInstance().commitRequest(r0);
        return 1;
    }

    public static int resetPowerState() {
        return 1;
    }

    public static int resetPriority(int r2) {
        CustomRequest r0 = new CustomRequest();
        r0.type = CapabilityType.TASK_PRIORITY.getIndex();
        r0.tid = r2;
        RequestManager.getInstance().commitRequest(r0);
        return 1;
    }

    public static void restoreCpuBoost() {
        RequestManager.getInstance().cancelRequest(CapabilityType.CPU_FREQ_MIN);
    }

    public static void restoreCpuCoreBoost() {
        RequestManager.getInstance().cancelRequest(CapabilityType.CPU_CORE_MIN);
    }

    public static void restoreCpuCoreLimit() {
        RequestManager.getInstance().cancelRequest(CapabilityType.CPU_CORE_MAX);
    }

    public static void restoreCpuLimit() {
        RequestManager.getInstance().cancelRequest(CapabilityType.CPU_FREQ_MAX);
    }

    public static void restoreDdrBoost() {
        RequestManager.getInstance().cancelRequest(CapabilityType.BUS_FREQ_MIN);
    }

    public static void restoreDdrLimit() {
        RequestManager.getInstance().cancelRequest(CapabilityType.BUS_FREQ_MAX);
    }

    public static void restoreGpuBoost() {
        RequestManager.getInstance().cancelRequest(CapabilityType.GPU_FREQ_MIN);
    }

    public static void restoreGpuLimit() {
        RequestManager.getInstance().cancelRequest(CapabilityType.GPU_FREQ_MAX);
    }

    public static void restoreUfsBoost() {
        RequestManager.getInstance().cancelRequest(CapabilityType.UFS_FREQ_MIN);
    }

    public static void restoreUfsLimit() {
        RequestManager.getInstance().cancelRequest(CapabilityType.UFS_FREQ_MAX);
    }

    public static int setAffinity(int r2, int r3) {
        CustomRequest r0 = new CustomRequest();
        r0.type = CapabilityType.CPU_AFFINITY.getIndex();
        r0.tid = r2;
        r0.cluster = r3;
        RequestManager.getInstance().commitRequest(r0);
        return 1;
    }

    public static void setAffinity(int r1) {
        setAffinity(Process.myTid(), r1);
    }

    public static void setAllowedScenes(HashSet<Integer> r1) {
        RequestManager.getInstance().setAllowedScenes(r1);
    }

    public static void setInitialConfigProvider(ISchedulerInitialConfigProvider r0) {
        mIInitialConfigProvider = r0;
    }

    public static void setLogLevel(int r0) {
        LogUtil.setLogLevel(r0);
    }

    public static int setPowerState() {
        return 1;
    }

    public static void setPriority(int r1) {
        setPriority(Process.myTid(), r1);
    }

    public static void setPriority(int r2, int r3) {
        CustomRequest r0 = new CustomRequest();
        r0.type = CapabilityType.TASK_PRIORITY.getIndex();
        r0.tid = r2;
        r0.priority = r3;
        RequestManager.getInstance().commitRequest(r0);
    }

    public static void switchVboost(boolean r0) {
        RequestManager.setEnableVboost(r0);
    }

    public static void unregisterSystemListener(VboostListener.SystemListener r1) {
        RequestManager.getInstance().unregisterSystemListener(r1);
    }
}
