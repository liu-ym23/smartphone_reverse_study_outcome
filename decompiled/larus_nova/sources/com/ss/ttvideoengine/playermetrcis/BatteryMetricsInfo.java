package com.ss.ttvideoengine.playermetrcis;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class BatteryMetricsInfo implements IMetricsInfo {
    public int mBatteryUsage;
    public int mCurrentBatteryUse;
    public int mLastBatteryLevel;
    public int mLastThermalState;
    public boolean mLowPowerMode;
    public int mPowerState;
    public long mStartCriticalTime;
    public long mStartEmergencyTime;
    public long mStartPowerTime;
    public long mTotalCriticalTime;
    public long mTotalEmergencyTime;
    public long mTotalPowerTime;

    public long getCurCriticalTime() {
        if (this.mStartCriticalTime <= 0) goto L6;
        long r100 = System.currentTimeMillis();
        this.mTotalCriticalTime += r100 - this.mStartCriticalTime;
        this.mStartCriticalTime = r100;
    L6:
        return this.mTotalCriticalTime;
    }

    public long getCurEmergencyTime() {
        if (this.mStartEmergencyTime <= 0) goto L6;
        long r100 = System.currentTimeMillis();
        this.mTotalEmergencyTime += r100 - this.mStartEmergencyTime;
        this.mStartEmergencyTime = r100;
    L6:
        return this.mTotalEmergencyTime;
    }

    public BatteryMetricsInfo() {
        this.mBatteryUsage = 0;
        this.mLastThermalState = 0;
        this.mLastBatteryLevel = 0;
        this.mCurrentBatteryUse = 0;
        this.mLowPowerMode = false;
        this.mPowerState = 0;
        this.mStartPowerTime = 0;
        this.mTotalPowerTime = 0;
        this.mStartCriticalTime = 0;
        this.mTotalCriticalTime = 0;
        this.mStartEmergencyTime = 0;
        this.mTotalEmergencyTime = 0;
    }

    @Override // com.ss.ttvideoengine.playermetrcis.IMetricsInfo
    public Map<String, Object> getMetricsInfo(String r100) {
        HashMap r101 = new HashMap();
        if (this.mStartEmergencyTime <= 0) goto L6;
        r101.put("cri_t", Long.valueOf(getCurEmergencyTime()));
    L6:
        if (this.mStartCriticalTime <= 0) goto L9;
        r101.put("ser_t", Long.valueOf(getCurCriticalTime()));
    L9:
        if (this.mStartPowerTime <= 0) goto L11;
        r101.put("bu_t", Long.valueOf(this.mTotalPowerTime));
        r101.put("bu_l", Integer.valueOf(this.mCurrentBatteryUse));
    L11:
        return r101;
    }
}
