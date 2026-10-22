package com.hihonor.mcs.system.diagnosis.core.performance;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class AnimationJankFrameMetric extends BasePerformanceMetric {
    private static final long serialVersionUID = 3296797706037531764L;
    private String diagInfo;

    public AnimationJankFrameMetric() {
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
        return "AnimationJankFrame{" + super.toString() + ", diagInfo='" + this.diagInfo + "'}";
    }
}
