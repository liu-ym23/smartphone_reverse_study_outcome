package com.ss.ttvideoengine.playermetrcis;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.log.DeviceMonitorUtils;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class PlayerMetrics {
    private static final String TAG = "PlayerMetrics";
    private static final int cpuOverload = 100;
    private static final int diagnoseInterval = 5;
    private static ArrayList<String> mTheadList = null;
    private static final String[] mdlNames = null;
    private static final int memoryOverload = 800;
    private static final String[] pcdnNames = null;
    private static final int powerOverload = 1;
    private BatteryListener batteryListener;
    private BatteryMetricsInfo mBatteryMetricsInfo;
    private Context mContext;
    private long mCurDuraiton;
    private ArrayList<DiagnoseInfo> mDiagnoseInfos;
    private long mLastMetricsTime;
    private int mMetricsAbility;
    private int mMetricsInterval;
    private PowerManager.OnThermalStatusChangedListener mThermalListener;
    private ThreadCPU mThreadCPU;
    private DiagnoseResult powResult;

    public static final class InstanceHolder {
        private static final PlayerMetrics sInstance = null;

        private InstanceHolder() {
        }

        static {
            sInstance = new PlayerMetrics(null);
        }

        public static /* synthetic */ PlayerMetrics access$100() {
            return sInstance;
        }
    }

    static {
        pcdnNames = new String[]{"KSThread", "XYThread", "vdp:vidtask:m"};
        mdlNames = new String[]{"MediaLoad", "com.video.mdl.network_manager", "com.video.mdl.network_session"};
        mTheadList = null;
    }

    private void checkAbility() {
        int r100 = 0;
        if ((this.mMetricsAbility & 2) <= 0) goto L15;
        if (this.mBatteryMetricsInfo != null) goto L7;
        this.mBatteryMetricsInfo = new BatteryMetricsInfo();
    L7:
        Context r101 = this.mContext;
        if (r101 == null) goto L15;
        if (this.batteryListener != null) goto L15;
        BatteryListener r102 = new BatteryListener(r101);
        this.batteryListener = r102;
        r102.register(new AnonymousClass1(this));
        if (this.batteryListener.getInitialCharging() == true) goto L15;
        TTVideoEngineLog.i(TAG, "getInitialCharging");
        BatteryMetricsInfo r103 = this.mBatteryMetricsInfo;
        r103.mStartPowerTime = System.currentTimeMillis();
        BatteryMetricsInfo r104 = this.mBatteryMetricsInfo;
        r104.mLastBatteryLevel = DeviceMonitorUtils.getPowerCapacity(this.mContext);
        this.mBatteryMetricsInfo.mPowerState = 0;
    L15:
        if ((this.mMetricsAbility & 4) <= 0) goto L18;
        startThermal();
    L18:
        if ((this.mMetricsAbility & 1) > 0) goto L20;
    L35:
        monitor-enter(this);
    L44:
        th = move-exception;
        throw th;
    L37:
        if (this.powResult != null) goto L40;
        this.powResult = new DiagnoseResult();     // Catch: Throwable -> L44
    L40:
        if (this.mDiagnoseInfos != null) goto L42;
        this.mDiagnoseInfos = new ArrayList();     // Catch: Throwable -> L44
    L42:
        monitor-exit(this);     // Catch: Throwable -> L44
        return;
    L20:
        if (mTheadList != null) goto L33;
        mTheadList = new ArrayList();
        if ((this.mMetricsAbility & 64) <= 0) goto L28;
        int r105 = 0;
    L24:
        String[] r106 = mdlNames;
        if (r105 >= r106.length) goto L28;
        mTheadList.add(r106[r105]);
        r105 = r105 + 1;
    L28:
        if ((this.mMetricsAbility & 128) <= 0) goto L33;
    L29:
        String[] r107 = pcdnNames;
        if (r100 >= r107.length) goto L33;
        mTheadList.add(r107[r100]);
        r100 = r100 + 1;
    L33:
        if (this.mThreadCPU != null) goto L35;
        ThreadCPU r108 = new ThreadCPU();
        this.mThreadCPU = r108;
        r108.initThreadMonitor(mTheadList);
        this.mThreadCPU.refreshStaticThreads();
        goto L35
    }

    private void collectMetrics() {
        TTVideoEngineLog.d(TAG, "start collectMetrics");
        DiagnoseInfo r100 = new DiagnoseInfo();
        if ((this.mMetricsAbility & 1) <= 0) goto L8;
        ThreadCPU r101 = this.mThreadCPU;
        if (r101 == null) goto L8;
        r101.refresh();
    L8:
        if ((this.mMetricsAbility & 2) <= 0) goto L19;
        BatteryMetricsInfo r102 = this.mBatteryMetricsInfo;
        if (r102 == null) goto L19;
        if (r102.mStartPowerTime <= 0) goto L19;
        long r103 = System.currentTimeMillis();
        int r104 = DeviceMonitorUtils.getPowerCapacity(this.mContext);
        long r105 = System.currentTimeMillis();
        BatteryMetricsInfo r106 = this.mBatteryMetricsInfo;
        int r107 = r106.mLastBatteryLevel;
        if (r107 <= 0) goto L16;
        r106.mCurrentBatteryUse = r104 - r107;
    L17:
        r106.mLastBatteryLevel = r104;
        r100.mPowerUsage = r104;
        long r108 = r105 - r106.mStartPowerTime;
        r100.mPowerUsageTime = r108;
        r106.mTotalPowerTime = r108;
        r106.mStartPowerTime = r105;
        TTVideoEngineLog.d(TAG, "METRICS_ABILITY_POWER " + this.mBatteryMetricsInfo.mLastBatteryLevel + " costTime: " + (r105 - r103) + " powertime: " + r100.mPowerUsageTime);
        goto L19
    L16:
        r106.mCurrentBatteryUse = 0;
    L19:
        if ((this.mMetricsAbility & 16) <= 0) goto L22;
        long r109 = System.currentTimeMillis();
        int r110 = DeviceMonitorUtils.getUsingMemory();
        long r111 = System.currentTimeMillis();
        r100.mMemUsage = r110;
        TTVideoEngineLog.d(TAG, "METRICS_ABILITY_MEMORY " + r110 + " costTime: " + (r111 - r109));
    L22:
        if ((this.mMetricsAbility & 4) <= 0) goto L27;
        BatteryMetricsInfo r112 = this.mBatteryMetricsInfo;
        if (r112 == null) goto L27;
        r100.mCiticalTime = r112.getCurCriticalTime();
        r100.mEmergencyTime = this.mBatteryMetricsInfo.getCurEmergencyTime();
    L27:
        if ((this.mMetricsAbility & 256) <= 0) goto L38;
        monitor-enter(this);
        ArrayList<DiagnoseInfo> r113 = this.mDiagnoseInfos;     // Catch: Throwable -> L35
        if (r113 == null) goto L32;
        r113.add(r100);     // Catch: Throwable -> L35
    L32:
        diagnose();     // Catch: Throwable -> L35
        monitor-exit(this);     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        throw th;
    }

    private void diagnose() {
        ArrayList<DiagnoseInfo> r100 = this.mDiagnoseInfos;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return;
    L7:
        if (this.mDiagnoseInfos.size() <= 5) goto L12;
        diagnoseInternal();
        TTVideoEngineLog.d(TAG, "startDiagnose");
        ListProtector.remove(this.mDiagnoseInfos, 0);
        return;
    }

    private void diagnoseInternal() {
        DiagnoseResult r100 = this.powResult;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mDiagnoseInfos == null) goto L28;
        r100.reset();
        Iterator<DiagnoseInfo> r101 = this.mDiagnoseInfos.iterator();
        int r102 = 0;
        int r103 = 0;
    L9:
        if (r101.hasNext() == false) goto L20;
        DiagnoseInfo r104 = r101.next();
        if (r102 <= 0) goto L13;
        r103 = Math.abs(r102 - r104.mPowerUsage);
    L13:
        DiagnoseResult r105 = this.powResult;
        if (r103 <= r105.maxValue) goto L16;
        r105.maxValue = r103;
    L16:
        if (r103 <= 1) goto L18;
        r105.overCount++;
    L18:
        r102 = r104.mPowerUsage;
        goto L9
    L20:
        if (this.mDiagnoseInfos.size() <= 1) goto L27;
        DiagnoseInfo r106 = (DiagnoseInfo) ListProtector.get(this.mDiagnoseInfos, 0);
        ArrayList<DiagnoseInfo> r107 = this.mDiagnoseInfos;
        DiagnoseInfo r108 = (DiagnoseInfo) ListProtector.get(r107, r107.size() - 1);
        this.powResult.avgValue = r106.mPowerUsage - r108.mPowerUsage;
        return;
    L27:
        return;
    }

    private void removeThrmal() {
        Context r100 = this.mContext;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mThermalListener != null) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 29) goto L21;
        PowerManager r101 = (PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Exception -> L15
        if (r101 == null) goto L22;
        PowerManager.OnThermalStatusChangedListener r102 = this.mThermalListener;     // Catch: Exception -> L15
        if (r102 == null) goto L23;
        r101.removeThermalStatusListener(r102);     // Catch: Exception -> L15
        this.mThermalListener = null;     // Catch: Exception -> L15
        return;
    L23:
        return;
    L22:
        return;
    L15:
        e = move-exception;
        TTVideoEngineLog.i(TAG, "thermalError: " + e);
        return;
    }

    private void startThermal() {
        Context r100 = this.mContext;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.mThermalListener == null) goto L9;
        return;
    L9:
        if (Build.VERSION.SDK_INT < 29) goto L19;
        final PowerManager r101 = (PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Exception -> L14
        if (r101 == null) goto L20;
        TTVideoEngineLog.i(TAG, "start thermal");     // Catch: Exception -> L14
        PowerManager.OnThermalStatusChangedListener r102 = new AnonymousClass2(this, r101);     // Catch: Exception -> L14
        this.mThermalListener = r102;     // Catch: Exception -> L14
        r101.addThermalStatusListener(r102);     // Catch: Exception -> L14
        return;
    L20:
        return;
    L14:
        e = move-exception;
        TTVideoEngineLog.i(TAG, "thermalError: " + e);
        return;
    }

    public Map<String, Object> getMetricsLog() {
        HashMap r100 = new HashMap();
        monitor-enter(this);
        DiagnoseResult r101 = this.powResult;     // Catch: Throwable -> L25
        if (r101 != null) goto L7;
    L9:
        BatteryMetricsInfo r102 = this.mBatteryMetricsInfo;     // Catch: Throwable -> L25
        if (r102 == null) goto L16;
        Map<String, Object> r103 = r102.getMetricsInfo(null);     // Catch: Throwable -> L25
        TTVideoEngineLog.d(TAG, "getMetricsLog: " + r103);     // Catch: Throwable -> L25
        if (r103 == null) goto L16;
        if (r103.size() <= 0) goto L16;
        r100.putAll(r103);     // Catch: Throwable -> L25
    L16:
        ThreadCPU r104 = this.mThreadCPU;     // Catch: Throwable -> L25
        if (r104 == null) goto L23;
        Map<String, Object> r105 = r104.getPlayerThreads();     // Catch: Throwable -> L25
        if (r105 == null) goto L23;
        if (r105.size() <= 0) goto L23;
        r100.putAll(r105);     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);     // Catch: Throwable -> L25
        return r100;
    L7:
        if (r101.avgValue <= 0) goto L9;
        r100.putAll(r101.getMetricsInfo("pow"));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public void refreshWhenBegin() {
        if ((this.mMetricsAbility & 1024) <= 0) goto L9;
        ThreadCPU r100 = this.mThreadCPU;
        if (r100 != null) goto L7;
        return;
    L7:
        r100.refreshWhenBegin();
        return;
    }

    public void refreshWhenEnd() {
        if ((this.mMetricsAbility & 512) <= 0) goto L9;
        ThreadCPU r100 = this.mThreadCPU;
        if (r100 != null) goto L7;
        return;
    L7:
        r100.refreshWhenEnd();
        return;
    }

    private PlayerMetrics() {
        this.mContext = null;
        this.mCurDuraiton = 0;
        this.mLastMetricsTime = 0;
        this.powResult = null;
        this.mBatteryMetricsInfo = null;
        this.mThermalListener = null;
        this.batteryListener = null;
        this.mDiagnoseInfos = null;
        this.mThreadCPU = null;
        this.mMetricsInterval = 60;
        this.mMetricsAbility = 0;
    }

    public static PlayerMetrics getInstance() {
        return InstanceHolder.access$100();
    }

    public int getAbility() {
        return this.mMetricsAbility;
    }

    public /* synthetic */ PlayerMetrics(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ BatteryMetricsInfo access$200(PlayerMetrics r100) {
        return r100.mBatteryMetricsInfo;
    }

    public static /* synthetic */ Context access$300(PlayerMetrics r100) {
        return r100.mContext;
    }

    public void beginCpuRefresh(String r100) {
        int r101 = this.mMetricsAbility;
        if ((r101 & 1) > 0) goto L5;
        return;
    L5:
        if ((r101 & 32) <= 0) goto L12;
        ThreadCPU r102 = this.mThreadCPU;
        if (r102 != null) goto L9;
        return;
    L9:
        r102.refreshSingleThreads(r100);
        return;
    }

    public void setMetricsAbilityOption(int r100) {
        this.mMetricsAbility = r100;
    }

    public void setMetricsIntervalOption(int r100) {
        if (r100 != 0) goto L4;
        this.mMetricsInterval = 60;
        return;
    L4:
        this.mMetricsInterval = r100;
    }

    public void startMetric(Context r110) {
        if (this.mMetricsAbility != 0) goto L6;
        return;
    L6:
        if (this.mContext != null) goto L8;
        this.mContext = r110.getApplicationContext();
    L8:
        checkAbility();
        long r100 = System.currentTimeMillis();
        long r101 = this.mLastMetricsTime;
        if (r101 != 0) goto L11;
        this.mCurDuraiton = 0;
    L12:
        this.mLastMetricsTime = r100;
        int r111 = this.mMetricsInterval;
        if (r111 > 0) goto L15;
        return;
    L15:
        if (this.mCurDuraiton < r111) goto L19;
        this.mCurDuraiton = 0;
        collectMetrics();
        return;
    L19:
        return;
    L11:
        this.mCurDuraiton += (r100 - r101) / 1000;
        goto L12
    }
}
