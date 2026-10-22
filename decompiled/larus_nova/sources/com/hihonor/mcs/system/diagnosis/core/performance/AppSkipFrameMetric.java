package com.hihonor.mcs.system.diagnosis.core.performance;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class AppSkipFrameMetric extends BasePerformanceMetric {
    private static final long serialVersionUID = 7822286629084246702L;
    private String diagInfo;

    public AppSkipFrameMetric() {
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
        return "AppSkipFrameMetric{" + super.toString() + ", diagInfo='" + this.diagInfo + "'}";
    }
}
