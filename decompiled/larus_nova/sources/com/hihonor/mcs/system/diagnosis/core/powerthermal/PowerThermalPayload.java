package com.hihonor.mcs.system.diagnosis.core.powerthermal;

import com.hihonor.mcs.system.diagnosis.core.BasePayload;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class PowerThermalPayload extends BasePayload {
    private static final long serialVersionUID = -5621112259542744996L;
    private List<PowerThermalMetric> powerThermalMetrics;

    public PowerThermalPayload() {
        this.powerThermalMetrics = new ArrayList();
    }

    public List<PowerThermalMetric> getPowerThermalMetrics() {
        return this.powerThermalMetrics;
    }

    public void setPowerThermalMetrics(List<PowerThermalMetric> r100) {
        this.powerThermalMetrics = r100;
    }
}
