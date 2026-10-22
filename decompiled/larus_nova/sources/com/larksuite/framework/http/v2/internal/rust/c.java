package com.larksuite.framework.http.v2.internal.rust;

import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.Iterator;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;

/* JADX INFO: loaded from: classes24.dex */
public final class c {
    public static Response.Builder a(SendHttpResponse r100, Request r101) {
        if (r100 != null) goto L4;
        Log.e("lark_http_rust", "response is null, request is " + r101);
    L4:
        Response.Builder r102 = new Response.Builder();
        r102.request(r101);
        r102.body(ResponseBody.create(MediaType.get("application/json"), ""));
        b(r102, r100.headers, r100.body);
        r102.code(r100.http_status_code.intValue());
        r102.message(r100.unknown_error);
        return r102;
    }

    public static void b(Response.Builder r100, Map<String, String> r110, ByteString r111) {
        Iterator<Map.Entry<String, String>> r112 = r110.entrySet().iterator();
        boolean r101 = false;
        boolean r102 = false;
    L4:
        if (r112.hasNext() == false) goto L49;
        Map.Entry<String, String> r103 = r112.next();
        if (r103 == null) goto L4;
        String r104 = r103.getKey().toLowerCase();
        String r105 = r103.getValue();
        r104.getClass();
        byte r106 = -1;
        switch(r104.hashCode()) {
            case 785670158: goto L19;
            case 1467947085: goto L15;
            case 2095084583: goto L11;
            default: goto L22;
        };
    L22:
        switch(r106) {
            case 0: goto L44;
            case 1: goto L28;
            case 2: goto L25;
            default: goto L48;
        };
    L25:
        if (DownloadHelper.GZIP.equalsIgnoreCase(r105) == false) goto L48;
    L28:
        if (r105.contains("http/1.0") == false) goto L31;
        Protocol r107 = Protocol.HTTP_1_0;
    L43:
        r100.protocol(r107);
        r101 = true;
        goto L48
    L31:
        if (r105.contains("http/1.1") == false) goto L34;
        r107 = Protocol.HTTP_1_1;
        goto L43
    L34:
        if (r105.contains("spdy/3.1") == false) goto L37;
        r107 = Protocol.SPDY_3;
        goto L43
    L37:
        if (r105.contains("h2") == false) goto L40;
        r107 = Protocol.HTTP_2;
        goto L43
    L40:
        if (r105.contains("quic") == false) goto L42;
        r107 = Protocol.QUIC;
        goto L43
    L42:
        Log.d("lark_http_rust", "unknown protocol: ".concat(r105));
        r107 = Protocol.HTTP_1_1;
        goto L43
    L44:
        if (r105 == null) goto L46;
        r100.body(ResponseBody.create(MediaType.parse(r105), r111.toByteArray()));
    L47:
        r102 = true;
        goto L48
    L46:
        Log.w("lark_http_rust", "contentType is null");
    L48:
        r100.addHeader(r104, r105);
        goto L4
    L11:
        if (r104.equals("content-encoding") == false) goto L22;
        r106 = 2;
        goto L22
    L15:
        if (r104.equals("x-protocol") == false) goto L22;
        r106 = 1;
        goto L22
    L19:
        if (r104.equals(com.alipay.sdk.m.p.e.f25658f) == false) goto L22;
        r106 = 0;
        goto L22
    L49:
        if (r101 == true) goto L51;
        Log.e("lark_http_rust", "Protocol not found, use HTTP/1.0");
        r100.protocol(Protocol.HTTP_1_0);
    L51:
        if (r102 == true) goto L64;
        Log.e("lark_http_rust", "ContentType not found");
        return;
    }
}
