package com.ccit.tiktok;

/* JADX INFO: loaded from: classes22.dex */
public class MKeyResultVo {
    private int resultCode;
    private String resultDesc;

    public MKeyResultVo() {
    }

    public String toString() {
        return "MKeyResultVo{resultCode=" + this.resultCode + ", resultDesc='" + this.resultDesc + "'}";
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultDesc() {
        return this.resultDesc;
    }

    public void setResultCode(int r100) {
        this.resultCode = r100;
    }

    public void setResultDesc(String r100) {
        this.resultDesc = r100;
    }
}
