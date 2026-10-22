package com.bytedance.badger.collect.impl.pseudo.model;

/* JADX INFO: loaded from: classes47.dex */
public class PseudoCodeReportResult {
    private Integer code;
    private Exception exception;
    private String message;

    public PseudoCodeReportResult() {
    }

    public String toString() {
        return "PseudoCodeReportResult{code=" + this.code + ", message='" + this.message + "', exception=" + this.exception + '}';
    }

    public Integer getCode() {
        return this.code;
    }

    public Exception getException() {
        return this.exception;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(Integer r100) {
        this.code = r100;
    }

    public void setException(Exception r100) {
        this.exception = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }
}
