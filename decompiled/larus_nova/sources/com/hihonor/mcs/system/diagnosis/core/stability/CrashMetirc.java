package com.hihonor.mcs.system.diagnosis.core.stability;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class CrashMetirc extends BaseFaultMetric {
    private static final long serialVersionUID = -4077277468513803419L;
    private String diagInfo;
    private String lifeTime;

    public CrashMetirc() {
    }

    @Override // com.hihonor.mcs.system.diagnosis.core.stability.BaseFaultMetric
    public String getDiagInfo() {
        return this.diagInfo;
    }

    public String getLifeTime() {
        return this.lifeTime;
    }

    public void setDiagInfo(JSONObject r100) {
        this.diagInfo = r100.toString();
    }

    public void setLifeTime(String r100) {
        this.lifeTime = r100;
    }

    @Override // com.hihonor.mcs.system.diagnosis.core.stability.BaseFaultMetric
    public String toString() {
        return "CrashMetirc{" + super.toString() + ", diagInfo='" + this.diagInfo + "', lifeTime='" + this.lifeTime + "'}";
    }
}
