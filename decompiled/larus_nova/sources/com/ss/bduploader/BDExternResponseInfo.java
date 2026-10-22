package com.ss.bduploader;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class BDExternResponseInfo {
    public byte[] responseBody;
    public JSONObject responseHeader;
    public String responseHeaderStr;
    public int statusCode;
    public String url;

    public BDExternResponseInfo() {
    }

    public byte[] getResponseBody() {
        return this.responseBody;
    }

    public JSONObject getResponseHeader() {
        return this.responseHeader;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getUrl() {
        return this.url;
    }

    public void setResponseBody(byte[] r100) {
        this.responseBody = r100;
    }

    public void setResponseHeader(JSONObject r100) {
        this.responseHeader = r100;
        if (r100 == null) goto L6;
        this.responseHeaderStr = r100.toString();
        return;
    }

    public void setStatusCode(int r100) {
        this.statusCode = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }
}
