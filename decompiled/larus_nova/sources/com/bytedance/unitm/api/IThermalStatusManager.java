package com.bytedance.unitm.api;

import android.util.Pair;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public interface IThermalStatusManager {
    void addThermalStatusDetailListener(IThermalStatusDetailListener r100);

    void addThermalStatusListener(IThermalStatusListener r100);

    void addThermalSurgeListener(IThermalSurgeListener r100, float r101, long r102);

    float getCurrentBatteryTemp();

    ThermalStatusConfig getCurrentConfig();

    int getCurrentThermalStatus();

    ThermalStatus getCurrentThermalStatusDetail();

    void removeThermalStatusDetailListener(IThermalStatusDetailListener r100);

    void removeThermalStatusListener(IThermalStatusListener r100);

    void removeThermalSurgeListener(IThermalSurgeListener r100);

    void setBatteryThermalThresholdList(List<Pair<Float, Float>> r100);

    void setDebugTemp(float r100);

    void updateConfig(ThermalStatusConfig r100);
}
