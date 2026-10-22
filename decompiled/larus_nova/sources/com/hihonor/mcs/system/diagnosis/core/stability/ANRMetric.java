package com.hihonor.mcs.system.diagnosis.core.stability;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class ANRMetric extends BaseFaultMetric {
    private static final long serialVersionUID = -387292646126471616L;
    private String diagInfo;
    private String lifeTime;

    public ANRMetric() {
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
        return "ANRMetric{" + super.toString() + ", diagInfo='" + this.diagInfo + "', lifeTime='" + this.lifeTime + "'}";
    }
}
