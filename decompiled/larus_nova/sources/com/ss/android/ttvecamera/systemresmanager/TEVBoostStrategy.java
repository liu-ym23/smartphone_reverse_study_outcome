package com.ss.android.ttvecamera.systemresmanager;

import android.content.Context;
import com.ss.android.ttvecamera.TEVBoostInterface;

/* JADX INFO: loaded from: classes38.dex */
public class TEVBoostStrategy implements ITESystemResourceStrategy {
    public TEVBoostStrategy() {
    }

    @Override // com.ss.android.ttvecamera.systemresmanager.ITESystemResourceStrategy
    public void restoreCpuFreq() {
        TEVBoostInterface.VBoostCapabilityType r100 = TEVBoostInterface.VBoostCapabilityType.CPU_FREQ_MIN;
        if (TEVBoostInterface.isSupportCapability(r100) == false) goto L5;
        TEVBoostInterface.cancelRequest(r100);
    L5:
        TEVBoostInterface.VBoostCapabilityType r101 = TEVBoostInterface.VBoostCapabilityType.CPU_FREQ_MAX;
        if (TEVBoostInterface.isSupportCapability(r101) == false) goto L9;
        TEVBoostInterface.cancelRequest(r101);
        return;
    }

    @Override // com.ss.android.ttvecamera.systemresmanager.ITESystemResourceStrategy
    public void boostCpuFreq(int r100) {
        TEVBoostInterface.VBoostCapabilityType r101 = TEVBoostInterface.VBoostCapabilityType.CPU_FREQ_MIN;
        if (TEVBoostInterface.isSupportCapability(r101) == false) goto L5;
        TEVBoostInterface.requestCustomBoost(r101, 9, r100);
    L5:
        TEVBoostInterface.VBoostCapabilityType r102 = TEVBoostInterface.VBoostCapabilityType.CPU_FREQ_MAX;
        if (TEVBoostInterface.isSupportCapability(r102) == false) goto L9;
        TEVBoostInterface.requestCustomBoost(r102, 9, r100);
        return;
    }

    @Override // com.ss.android.ttvecamera.systemresmanager.ITESystemResourceStrategy
    public void init(Context r100) {
        TEVBoostInterface.init(r100);
    }
}
