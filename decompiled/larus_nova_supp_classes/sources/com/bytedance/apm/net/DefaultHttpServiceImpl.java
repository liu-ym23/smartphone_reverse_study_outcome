package com.bytedance.apm.net;

import android.text.TextUtils;
import com.bytedance.apm.util.f;
import com.bytedance.apm.util.k;
import com.bytedance.apm.util.m;
import com.bytedance.apm.util.s;
import com.bytedance.services.apm.api.IHttpService;
import ff7.b;
import ff7.g;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import qs3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class DefaultHttpServiceImpl implements IHttpService {
    private static String METHOD_GET = "GET";
    private static String METHOD_POST = "POST";

    public DefaultHttpServiceImpl() {
    }

    public static byte[] toByteArray(InputStream r4) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
    L3:
        int r2 = r4.read(r1);
        if ((-1) == r2) goto L6;
        r0.write(r1, 0, r2);
        goto L3
    L6:
        r4.close();
        return r0.toByteArray();
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doGet(String r3, Map<String, String> r4) throws Exception {
        return doRequest(r3, null, METHOD_GET, r4);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public g buildMultipartUpload(String r3, String r4, boolean r5) throws IOException {
        return new a(r3, r4, r5, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doPost(String r2, byte[] r3, Map<String, String> r4) throws Exception {
        return doRequest(r2, r3, METHOD_POST, r4);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b uploadFiles(String r1, List<File> r2, Map<String, String> r3) throws Exception {
        return f.a(r1, r2, r3);
    }

    private b doRequest(String r9, byte[] r10, String r11, Map<String, String> r12) throws Exception {
        if (r11 == null) goto L74;
        HttpURLConnection r13 = m.a(r9);     // Catch: Throwable -> L55
        r13.setConnectTimeout(5000);     // Catch: Throwable -> L53
        r13.setReadTimeout(5000);     // Catch: Throwable -> L53
        if (r12 == null) goto L18;
        if (r12.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r14 = r12.entrySet().iterator();     // Catch: Throwable -> L53
    L12:
        if (r14.hasNext() == false) goto L18;
        Map.Entry<String, String> r1 = r14.next();     // Catch: Throwable -> L53
        if (r1 == null) goto L12;
        r13.setRequestProperty(r1.getKey(), r1.getValue());     // Catch: Throwable -> L53
    L18:
        if (TextUtils.equals(r11, METHOD_POST) == false) goto L20;
        r13.setDoOutput(true);     // Catch: Throwable -> L53
    L21:
        r13.setRequestMethod(r11);     // Catch: Throwable -> L53
        if (r10 != null) goto L24;
    L26:
        int r15 = r13.getResponseCode();     // Catch: Throwable -> L53
        if (r15 != 200) goto L50;
        InputStream r16 = r13.getInputStream();     // Catch: Throwable -> L53
        String r17 = r13.getContentEncoding();     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r17) == false) goto L32;
    L34:
        byte[] r2 = toByteArray(r16);     // Catch: Throwable -> L48
    L35:
        Map<String, List<String>> r18 = r13.getHeaderFields();     // Catch: Throwable -> L48
        HashMap r3 = new HashMap();     // Catch: Throwable -> L48
        Iterator<String> r4 = r18.keySet().iterator();     // Catch: Throwable -> L48
    L37:
        if (r4.hasNext() == false) goto L43;
        String r5 = r4.next();     // Catch: Throwable -> L48
        List<String> r6 = r18.get(r5);     // Catch: Throwable -> L48
        if (r6 == null) goto L37;
        if (k.b(r6) == true) goto L37;
        r3.put(r5, r6.get(0));     // Catch: Throwable -> L48
        goto L37
    L43:
        b r19 = new b(r15, r3, r2);     // Catch: Throwable -> L48
        if (r16 != null) goto L97;
    L93:
        r13.disconnect();     // Catch: Exception -> L76
    L47:
        return r19;
    L97:
        r16.close();     // Catch: Exception -> L75
        goto L93
    L32:
        if (r17.equalsIgnoreCase("gzip") == false) goto L34;
        GZIPInputStream r110 = new GZIPInputStream(r16);     // Catch: Throwable -> L48
        r2 = toByteArray(r110);     // Catch: Throwable -> L48
        r110.close();     // Catch: Throwable -> L48
    L48:
        th = th;
    L82:
        th.getMessage();     // Catch: Throwable -> L65
        s.a(th, 10);     // Catch: Throwable -> L65
        if (r16 != null) goto L87;
    L62:
        if (r13 != null) goto L80;
    L64:
        return null;
    L80:
        r13.disconnect();     // Catch: Exception -> L77
        goto L64
    L87:
        r16.close();     // Catch: Exception -> L61
    L65:
        th = move-exception;
        if (r16 != null) goto L91;
    L70:
        if (r13 == null) goto L114;
        r13.disconnect();     // Catch: Exception -> L78
        throw th;
    L115:
        throw th;
    L114:
        throw th;
    L91:
        r16.close();     // Catch: Exception -> L69
        goto L70
    L50:
        b r111 = new b(r15, null);     // Catch: Throwable -> L53
        r13.disconnect();     // Catch: Exception -> L79
    L52:
        return r111;
    L24:
        if (r10.length <= 0) goto L26;
        DataOutputStream r112 = new DataOutputStream(r13.getOutputStream());     // Catch: Throwable -> L53
        r112.write(r10);     // Catch: Throwable -> L53
        r112.flush();     // Catch: Throwable -> L53
        r112.close();     // Catch: Throwable -> L53
        goto L26
    L20:
        r13.setDoOutput(false);     // Catch: Throwable -> L53
    L53:
        th = th;
        r16 = null;
    L55:
        th = th;
        r13 = null;
        r16 = null;
        goto L82
    L74:
        throw new IllegalArgumentException("request method is not null");
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public g buildMultipartUpload(String r2, String r3, boolean r4, Map<String, String> r5) throws Exception {
        return new a(r2, r3, r4, r5);
    }
}
