package com.hihonor.mcs.system.diagnosis.core.stability;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class TombstoneMetric extends BaseFaultMetric {
    private static final long serialVersionUID = 531743845553882655L;
    private String diagInfo;

    public TombstoneMetric() {
    }

    @Override // com.hihonor.mcs.system.diagnosis.core.stability.BaseFaultMetric
    public String getDiagInfo() {
        return this.diagInfo;
    }

    public void setDiagInfo(JSONObject r100) {
        this.diagInfo = r100.toString();
    }

    @Override // com.hihonor.mcs.system.diagnosis.core.stability.BaseFaultMetric
    public String toString() {
        return "TombstoneMetric{" + super.toString() + ", diagInfo='" + this.diagInfo + "'}";
    }
}
