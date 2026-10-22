package com.bytedance.unitm.adapter;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.unitm.core.BaseThermalStatusGenerator;
import com.bytedance.unitm.util.TLog;

/* JADX INFO: loaded from: classes22.dex */
public class AOSPThermalStatusAdapter extends BaseThermalStatusGenerator {
    private PowerManager.OnThermalStatusChangedListener listener;
    private PowerManager mPowerManager;

    public class MyOnThermalStatusChangedListener implements PowerManager.OnThermalStatusChangedListener {
        final /* synthetic */ AOSPThermalStatusAdapter this$0;

        public MyOnThermalStatusChangedListener(AOSPThermalStatusAdapter r100) {
            this.this$0 = r100;
        }

        @Override // android.os.PowerManager.OnThermalStatusChangedListener
        public void onThermalStatusChanged(int r100) {
            AOSPThermalStatusAdapter r101 = this.this$0;
            monitor-enter(r101);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (AOSPThermalStatusAdapter.access$000(this.this$0) == null) goto L7;
            AOSPThermalStatusAdapter.access$102(this.this$0, r100);     // Catch: Throwable -> L9
            AOSPThermalStatusAdapter.access$200(this.this$0).onStatusGenerate(r100, -1.0f);     // Catch: Throwable -> L9
            TLog.d("aosp status changed " + r100);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r101);     // Catch: Throwable -> L9
        }
    }

    private int getCurrentThermalStatusFromPowerManager() {
        if (Build.VERSION.SDK_INT < 29) goto L11;
        PowerManager r100 = this.mPowerManager;
        if (r100 == null) goto L12;
        return r100.getCurrentThermalStatus();
    L13:
        return -1;
    L12:
        return -1;
    L11:
        return -1;
    }

    @Override // com.bytedance.unitm.core.BaseThermalStatusGenerator
    public boolean addStatusListener() {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return false;
    L5:
        if (this.mPowerManager != null) goto L7;
        return false;
    L7:
        if (this.listener != null) goto L19;
        this.listener = new MyOnThermalStatusChangedListener(this);
    L19:
        this.mPowerManager.addThermalStatusListener(this.listener);     // Catch: Throwable -> L12 Exception -> L13
        return true;
    L12:
        return true;
    L17:
        this.listener = null;     // Catch: Throwable -> L16
        return false;
    L24:
        return false;
    }

    @Override // com.bytedance.unitm.core.BaseThermalStatusGenerator
    public int getCurrentThermalStatus() {
        if (this.mListener != null) goto L7;
        return getCurrentThermalStatusFromPowerManager();
    L7:
        return this.mStatus;
    }

    @Override // com.bytedance.unitm.core.BaseThermalStatusGenerator
    public void removeStatusListener() {
        if (Build.VERSION.SDK_INT < 29) goto L9;
        PowerManager r100 = this.mPowerManager;
        if (r100 == null) goto L9;
        PowerManager.OnThermalStatusChangedListener r101 = this.listener;
        if (r101 == null) goto L9;
        r100.removeThermalStatusListener(r101);
    L9:
        this.listener = null;
    }

    public static /* synthetic */ BaseThermalStatusGenerator.IListener access$000(AOSPThermalStatusAdapter r100) {
        return r100.mListener;
    }

    public static /* synthetic */ BaseThermalStatusGenerator.IListener access$200(AOSPThermalStatusAdapter r100) {
        return r100.mListener;
    }

    public AOSPThermalStatusAdapter(Context r100, Looper r101) {
        super(r100, r101);
        this.mPowerManager = (PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        this.mStatus = getCurrentThermalStatusFromPowerManager();
    }

    public static /* synthetic */ int access$102(AOSPThermalStatusAdapter r100, int r101) {
        r100.mStatus = r101;
        return r101;
    }
}
