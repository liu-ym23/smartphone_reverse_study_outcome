package com.bytedance.badger.collect.impl.model;

import android.util.Pair;
import com.bytedance.badger.collect.impl.constants.ErrorPair;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public class TTResponse {
    private final String body;
    private Throwable exception;
    private final Map<String, String> headers;
    private String logId;
    private final int statusCode;
    private final String url;

    public static TTResponse failed() {
        Pair<Integer, String> r100 = ErrorPair.ERROR_NETWORK_REQUEST;
        return new TTResponse("", ((Integer) r100.first).intValue(), null, (String) r100.second);
    }

    public String toString() {
        return "DeviceResponse{\n body=" + this.body + "\n headers=" + this.headers + "\n code=" + this.statusCode + "\n logId=" + this.logId + "\n url='" + this.url + "'}";
    }

    public String getBody() {
        return this.body;
    }

    public Throwable getException() {
        return this.exception;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getLogId() {
        return this.logId;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getUrl() {
        return this.url;
    }

    public static TTResponse failed(Throwable r100) {
        if (r100 == null) goto L4;
        String r101 = r100.toString();
    L5:
        int r102 = ((Integer) ErrorPair.ERROR_NETWORK_REQUEST.first).intValue();
        return new TTResponse("", r102, null, r101, r100);
    L4:
        r101 = (String) ErrorPair.ERROR_NETWORK_REQUEST.second;
        goto L5
    }

    public void setLogId(String r100) {
        this.logId = r100;
    }

    public static TTResponse failed(TTRequest r100) {
        String r101 = r100.getBaseUrl();
        Pair<Integer, String> r102 = ErrorPair.ERROR_NETWORK_REQUEST;
        return new TTResponse(r101, ((Integer) r102.first).intValue(), null, (String) r102.second);
    }

    public static TTResponse failed(Pair<Integer, String> r100) {
        return new TTResponse("", ((Integer) r100.first).intValue(), null, (String) r100.second);
    }

    public TTResponse(String r100, int r101, Map<String, String> r102, String r103) {
        this.url = r100;
        this.statusCode = r101;
        if (r102 != null) goto L5;
        this.headers = new HashMap();
    L6:
        this.body = r103;
        return;
    L5:
        this.headers = Collections.unmodifiableMap(new HashMap(r102));
        goto L6
    }

    public TTResponse(String r100, int r101, Map<String, String> r102, String r103, Throwable r104) {
        this.url = r100;
        this.statusCode = r101;
        if (r102 != null) goto L5;
        this.headers = new HashMap();
    L6:
        this.body = r103;
        this.exception = r104;
        return;
    L5:
        this.headers = Collections.unmodifiableMap(new HashMap(r102));
        goto L6
    }
}
