package com.bytedance.vcloud.networkpredictor;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class SpeedPredictorResultItem {
    private float mbandwidth;
    private String mhost;
    private String mloadType;
    private int mtrackType;

    public JSONObject toJsonObject() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L10
        String r101 = this.mloadType;     // Catch: Exception -> L10
        if (r101 == null) goto L5;
        r100.put("loadType", r101);     // Catch: Exception -> L10
    L5:
        String r102 = this.mhost;     // Catch: Exception -> L10
        if (r102 == null) goto L8;
        r100.put("host", r102);     // Catch: Exception -> L10
    L8:
        r100.put("bandwidth", this.mbandwidth);     // Catch: Exception -> L10
        r100.put("trackType", this.mtrackType);     // Catch: Exception -> L10
        return r100;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public float getBandwidth() {
        return this.mbandwidth;
    }

    public String getHost() {
        return this.mhost;
    }

    public String getLoadType() {
        return this.mloadType;
    }

    public int getTrackType() {
        return this.mtrackType;
    }

    public void setBandwidth(float r100) {
        this.mbandwidth = r100;
    }

    public void setHost(String r100) {
        this.mhost = r100;
    }

    public void setLoadType(String r100) {
        this.mloadType = r100;
    }

    public void setTrackType(int r100) {
        this.mtrackType = r100;
    }

    public SpeedPredictorResultItem(String r100, String r101, float r102, int r103) {
        this.mloadType = r100;
        this.mhost = r101;
        this.mbandwidth = r102;
        this.mtrackType = r103;
    }
}
