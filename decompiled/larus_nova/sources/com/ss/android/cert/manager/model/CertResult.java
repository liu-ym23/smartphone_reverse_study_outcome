package com.ss.android.cert.manager.model;

import android.util.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class CertResult {
    private int ageRange;
    private int certStatus;
    private int code;
    private JSONObject extra;
    private int manualStatus;
    private String message;
    private int remainedTimes;
    private String sdkData;
    private String ticket;
    private String videoPath;

    public CertResult() {
    }

    public int getAgeRange() {
        return this.ageRange;
    }

    public int getCertStatus() {
        return this.certStatus;
    }

    public int getCode() {
        return this.code;
    }

    public JSONObject getExtra() {
        return this.extra;
    }

    public int getManualStatus() {
        return this.manualStatus;
    }

    public String getMessage() {
        return this.message;
    }

    public int getRemainedTimes() {
        return this.remainedTimes;
    }

    public String getSdkData() {
        return this.sdkData;
    }

    public String getTicket() {
        return this.ticket;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public CertResult(Pair<Integer, String> r100) {
        this.code = ((Integer) r100.first).intValue();
        this.message = (String) r100.second;
    }

    public void setAgeRange(int r100) {
        this.ageRange = r100;
    }

    public void setCertStatus(int r100) {
        this.certStatus = r100;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setExtra(JSONObject r100) {
        this.extra = r100;
    }

    public void setManualStatus(int r100) {
        this.manualStatus = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setRemainedTimes(int r100) {
        this.remainedTimes = r100;
    }

    public void setSdkData(String r100) {
        this.sdkData = r100;
    }

    public void setTicket(String r100) {
        this.ticket = r100;
    }

    public void setVideoPath(String r100) {
        this.videoPath = r100;
    }
}
