package com.bytedance.badger.collect.impl.model;

import android.net.Network;
import com.bytedance.badger.collect.impl.constants.NetworkMethodEnum;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public class TTRequest {
    private String baseUrl;
    private final Map<String, String> bodyMap;
    private boolean enableOperator;
    private final Map<String, String> headers;
    private final NetworkMethodEnum method;
    private Network network;
    private Map<String, String> queryParams;

    public String toString() {
        return "TTRequest{baseUrl='" + this.baseUrl + "', method=" + this.method + ", headers=" + this.headers + ", queryParams=" + this.queryParams + ", body=" + this.bodyMap + '}';
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public Map<String, String> getBodyMap() {
        return this.bodyMap;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public NetworkMethodEnum getMethod() {
        return this.method;
    }

    public Network getNetwork() {
        return this.network;
    }

    public Map<String, String> getQueryParams() {
        return this.queryParams;
    }

    public boolean isEnableOperator() {
        return this.enableOperator;
    }

    public void setBaseUrl(String r100) {
        this.baseUrl = r100;
    }

    public TTRequest(String r100, NetworkMethodEnum r101, Map<String, String> r102) {
        this.network = null;
        this.baseUrl = r100;
        this.method = r101;
        this.headers = r102;
        this.bodyMap = null;
    }

    public TTRequest(String r100, NetworkMethodEnum r101, Map<String, String> r102, Map<String, String> r103) {
        this.network = null;
        this.baseUrl = r100;
        this.method = r101;
        this.headers = r102;
        this.bodyMap = r103;
    }

    public TTRequest(String r100, boolean r101, Network r102, NetworkMethodEnum r103, Map<String, String> r104, Map<String, String> r105) {
        this.baseUrl = r100;
        this.enableOperator = r101;
        this.network = r102;
        this.method = r103;
        this.headers = r104;
        this.queryParams = r105;
        this.bodyMap = null;
    }

    public TTRequest(boolean r100, String r101, NetworkMethodEnum r102, Map<String, String> r103, Map<String, String> r104, Map<String, String> r105) {
        this.network = null;
        this.enableOperator = r100;
        this.baseUrl = r101;
        this.method = r102;
        this.headers = r103;
        this.queryParams = r104;
        this.bodyMap = r105;
    }

    public TTRequest(String r100, boolean r101, Network r102, NetworkMethodEnum r103, Map<String, String> r104, Map<String, String> r105, Map<String, String> r106) {
        this.baseUrl = r100;
        this.enableOperator = r101;
        this.network = r102;
        this.method = r103;
        this.headers = r104;
        this.queryParams = r105;
        this.bodyMap = r106;
    }
}
