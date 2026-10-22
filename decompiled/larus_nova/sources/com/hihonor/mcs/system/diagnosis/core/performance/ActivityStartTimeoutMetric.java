package com.hihonor.mcs.system.diagnosis.core.performance;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class ActivityStartTimeoutMetric extends BasePerformanceMetric {
    private static final long serialVersionUID = 9017481057796481895L;
    private String diagInfo;

    public ActivityStartTimeoutMetric() {
    }

    @Override // com.hihonor.mcs.system.diagnosis.core.performance.BasePerformanceMetric
    public String getDiagInfo() {
        return this.diagInfo;
    }

    public void setDiagInfo(JSONObject r100) {
        this.diagInfo = r100.toString();
    }

    @Override // com.hihonor.mcs.system.diagnosis.core.performance.BasePerformanceMetric
    public String toString() {
        return "ActivityStartTimeoutMetric{" + super.toString() + ", diagInfo='" + this.diagInfo + "'}";
    }
}
