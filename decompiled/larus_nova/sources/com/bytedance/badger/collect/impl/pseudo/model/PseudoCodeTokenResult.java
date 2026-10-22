package com.bytedance.badger.collect.impl.pseudo.model;

/* JADX INFO: loaded from: classes47.dex */
public class PseudoCodeTokenResult {
    private Integer code;
    private Exception exception;
    private String pcId;
    private String response;

    public PseudoCodeTokenResult() {
        this.code = Integer.MIN_VALUE;
        this.response = "";
        this.pcId = "";
        this.exception = null;
    }

    public Integer getCode() {
        return this.code;
    }

    public Exception getException() {
        return this.exception;
    }

    public String getPcId() {
        return this.pcId;
    }

    public String getResponse() {
        return this.response;
    }

    public void setCode(Integer r100) {
        this.code = r100;
    }

    public void setException(Exception r100) {
        this.exception = r100;
    }

    public void setPcId(String r100) {
        this.pcId = r100;
    }

    public void setResponse(String r100) {
        this.response = r100;
    }
}
