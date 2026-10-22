package com.ss.android.lark.security.compliance.infra.network;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.utils.n0;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f440432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HttpMethod f440433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HttpParams f440434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HttpHeaders f440435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f440436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f440437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f440438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f440439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f440440i;

    @Override // com.ss.android.lark.security.compliance.infra.network.g
    public final void canLog() {
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.g
    public final String getUrl() {
        String r100 = this.f440438g + this.f440432a;
        LinkedHashMap<String, String> r101 = this.f440434c.urlParamsMap;
        HttpUrl r102 = HttpUrl.parse(r100);
        if (r102 == null) goto L6;
        HttpUrl.a r103 = r102.newBuilder();
        if (r103 == null) goto L6;
    L18:
        Iterator<Map.Entry<String, String>> r104 = r101.entrySet().iterator();
    L20:
        if (r104.hasNext() == false) goto L23;
        Map.Entry<String, String> r105 = r104.next();
        r103.a(r105.getKey(), r105.getValue());
        goto L20
    L23:
        return r103.b().toString();
    L6:
        r103 = new HttpUrl.a();
        String r106 = this.f440438g;
        Pattern r107 = n0.f286044a;
        String r108 = "";
        if (TextUtils.isEmpty(r106) == false) goto L28;
    L13:
        r103.g(r108);
        r103.c(n0.b(this.f440438g));
        String r109 = this.f440432a;
        if (r109 == null) goto L27;
        if (r109.startsWith(HTTP.URL_DEFAULT) == false) goto L25;
        r103.f(r109, 0, r109.length());
        goto L18
    L25:
        throw new IllegalArgumentException("unexpected encodedPath: ".concat(r109));
    L27:
        throw new NullPointerException("encodedPath == null");
    L28:
        r108 = UriProtector.parse(r106).getScheme();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.g
    public final boolean a() {
        return this.f440437f;
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.g
    public final byte[] b() {
        return this.f440440i;
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.g
    public final HttpHeaders getHeaders() {
        return this.f440435d;
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.g
    public final String getHost() {
        return this.f440438g;
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.g
    public final HttpMethod getMethod() {
        return this.f440433b;
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.g
    public final String getMimeType() {
        return this.f440439h;
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.g
    public final String getPath() {
        return this.f440432a;
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.g
    public final JSONObject getRequestBody() {
        return this.f440436e;
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.g
    public final void c(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.f440438g = r100;
    }

    public a(String r100, HttpMethod r101, HttpParams r102, HttpHeaders r103, JSONObject r104, boolean r105) {
        this.f440432a = r100;
        this.f440433b = r101;
        this.f440434c = r102;
        this.f440435d = r103;
        this.f440436e = r104;
        this.f440437f = r105;
        this.f440438g = "";
        this.f440439h = com.larksuite.framework.http.request.HttpParams.RAW_TYPE_JSON;
        this.f440440i = new byte[0];
    }
}
