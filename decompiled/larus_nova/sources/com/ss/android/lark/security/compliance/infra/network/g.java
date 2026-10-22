package com.ss.android.lark.security.compliance.infra.network;

import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public interface g {
    boolean a();

    byte[] b();

    void c(String r100);

    void canLog();

    HttpHeaders getHeaders();

    String getHost();

    HttpMethod getMethod();

    String getMimeType();

    String getPath();

    JSONObject getRequestBody();

    String getUrl();
}
