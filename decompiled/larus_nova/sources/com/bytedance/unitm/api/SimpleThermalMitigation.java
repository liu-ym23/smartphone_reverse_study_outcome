package com.bytedance.unitm.api;

import com.bytedance.unitm.util.TLog;

/* JADX INFO: loaded from: classes22.dex */
public class SimpleThermalMitigation implements IThermalMitigation {
    public SimpleThermalMitigation() {
    }

    @Override // com.bytedance.unitm.api.IThermalMitigation
    public String getDescription() {
        return "simple mitigaton";
    }

    @Override // com.bytedance.unitm.api.IThermalMitigation
    public void handleThermalStatusDecrease(ThermalStatus r100) {
        TLog.i("simple handleThermalStatusDecrease, status:" + r100);
    }

    @Override // com.bytedance.unitm.api.IThermalMitigation
    public void handleThermalStatusIncrease(ThermalStatus r100) {
        TLog.i("simple handleThermalStatusIncrease, status:" + r100);
    }
}
