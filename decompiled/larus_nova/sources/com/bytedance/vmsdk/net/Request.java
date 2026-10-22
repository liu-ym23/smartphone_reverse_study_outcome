package com.bytedance.vmsdk.net;

import com.alipay.sdk.m.p.e;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class Request {
    static final String defaultMethod = "GET";
    InputStream body;
    Map<String, String> headers;
    String method;
    String url;

    public String getBodyString() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        byte[] r101 = new byte[4096];
    L12:
        int r102 = this.body.read(r101, 0, 4096);     // Catch: IOException -> L9
        if (r102 <= 0) goto L6;
        r100.write(r101, 0, r102);     // Catch: IOException -> L9
    L6:
        if (r102 > 0) goto L12;
        return r100.toString();
    L9:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public InputStream getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }

    public Request(String r100, JSONObject r101, byte[] r102) {
        this.url = r100;     // Catch: JSONException -> L25
        if (r101.has(e.f25671s) == false) goto L6;
        String r103 = JSONObjectProtectorUtils.getString(r101, e.f25671s);     // Catch: JSONException -> L25
    L7:
        this.method = r103;     // Catch: JSONException -> L25
        if (r102 == null) goto L14;
        if (r102.length == 0) goto L14;
        this.body = new ByteArrayInputStream(r102);     // Catch: JSONException -> L25
    L18:
        JSONObject r104 = (JSONObject) r101.opt("headers");     // Catch: JSONException -> L25
        this.headers = new HashMap();     // Catch: JSONException -> L25
        if (r104 == null) goto L31;
        Iterator<String> r105 = r104.keys();     // Catch: JSONException -> L25
    L21:
        if (r105.hasNext() == false) goto L32;
        String r106 = r105.next();     // Catch: JSONException -> L25
        this.headers.put(r106, JSONObjectProtectorUtils.getString(r104, r106));     // Catch: JSONException -> L25
        goto L21
    L32:
        return;
    L31:
        return;
    L14:
        if (r101.has(ContainerPosition.BODY) == false) goto L16;
        ByteArrayInputStream r107 = new ByteArrayInputStream(JSONObjectProtectorUtils.getString(r101, ContainerPosition.BODY).getBytes());     // Catch: JSONException -> L25
    L17:
        this.body = r107;     // Catch: JSONException -> L25
        goto L18
    L16:
        r107 = null;
        goto L17
    L6:
        r103 = "GET";
    L25:
        e = move-exception;
        e.printStackTrace();
    }
}
