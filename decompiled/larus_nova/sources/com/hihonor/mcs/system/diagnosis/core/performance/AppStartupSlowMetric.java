package com.hihonor.mcs.system.diagnosis.core.performance;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class AppStartupSlowMetric extends BasePerformanceMetric {
    private static final long serialVersionUID = 8018128128560484971L;
    private String diagInfo;

    public AppStartupSlowMetric() {
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
        return "AppStartupSlowMetric{" + super.toString() + ", diagInfo='" + this.diagInfo + "'}";
    }
}
