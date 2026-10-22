package com.hihonor.mcs.system.diagnosis.core.performance;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class FlingJankFrameMetric extends BasePerformanceMetric {
    private static final long serialVersionUID = 722235295725037435L;
    private String diagInfo;

    public FlingJankFrameMetric() {
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
        return "FlingJankFrameMetric{" + super.toString() + ", diagInfo='" + this.diagInfo + "'}";
    }
}
