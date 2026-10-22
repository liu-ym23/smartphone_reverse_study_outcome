package com.bytedance.unitm.api;

/* JADX INFO: loaded from: classes22.dex */
public interface IThermalMitigation {
    String getDescription();

    void handleThermalStatusDecrease(ThermalStatus r100);

    void handleThermalStatusIncrease(ThermalStatus r100);
}
