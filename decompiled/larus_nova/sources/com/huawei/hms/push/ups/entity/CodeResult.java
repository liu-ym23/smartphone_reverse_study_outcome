package com.huawei.hms.push.ups.entity;

/* JADX INFO: loaded from: classes23.dex */
public class CodeResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f277676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277677b;

    public CodeResult() {
    }

    public String getReason() {
        return this.f277677b;
    }

    public int getReturnCode() {
        return this.f277676a;
    }

    public CodeResult(int r100) {
        this.f277676a = r100;
    }

    public void setReason(String r100) {
        this.f277677b = r100;
    }

    public void setReturnCode(int r100) {
        this.f277676a = r100;
    }

    public CodeResult(int r100, String r101) {
        this.f277676a = r100;
        this.f277677b = r101;
    }
}
