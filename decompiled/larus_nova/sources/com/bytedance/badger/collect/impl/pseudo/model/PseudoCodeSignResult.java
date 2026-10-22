package com.bytedance.badger.collect.impl.pseudo.model;

import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public class PseudoCodeSignResult {
    private Integer code;
    private Exception exception;
    private Map<String, String> requestMap;
    private String response;
    private String sign;

    public PseudoCodeSignResult() {
    }

    public Integer getCode() {
        return this.code;
    }

    public Exception getException() {
        return this.exception;
    }

    public Map<String, String> getRequestMap() {
        return this.requestMap;
    }

    public String getResponse() {
        return this.response;
    }

    public String getSign() {
        return this.sign;
    }

    public void setCode(Integer r100) {
        this.code = r100;
    }

    public void setException(Exception r100) {
        this.exception = r100;
    }

    public void setRequestMap(Map<String, String> r100) {
        this.requestMap = r100;
    }

    public void setResponse(String r100) {
        this.response = r100;
    }

    public void setSign(String r100) {
        this.sign = r100;
    }
}
