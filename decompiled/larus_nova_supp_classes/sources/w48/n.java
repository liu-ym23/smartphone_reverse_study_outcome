package w48;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.article.common.network.ICommonApi;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class n extends px3.a {
    public n() {
    }

    public static String a(Exception r1) {
        String r0 = r1.getMessage();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return r1.getClass().getName();
    }

    public static Pair<String, Map<String, String>> b(Map<String, String> r6) {
        LinkedHashMap r0 = null;
        if (r6 == null) goto L24;
        if (r6.isEmpty() == true) goto L24;
        LinkedHashMap r1 = new LinkedHashMap(r6.size());
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
        String r2 = null;
    L9:
        if (r7.hasNext() == false) goto L18;
        Map.Entry<String, String> r3 = r7.next();
        String r4 = r3.getKey();
        if (r4 == null) goto L9;
        if ("Content-Type".equalsIgnoreCase(r4) == true) goto L15;
        r1.put(r4, r3.getValue());
        goto L9
    L15:
        r2 = r3.getValue();
        goto L9
    L18:
        if (r1.isEmpty() == true) goto L22;
        r0 = r1;
    L22:
        return new Pair(r2, r0);
    L24:
        return new Pair(null, null);
    }

    public static CommonHttpException c(Exception r3) {
        if ((r3 instanceof HttpResponseException) == false) goto L7;
        return new CommonHttpException(((HttpResponseException) r3).getStatusCode(), a(r3));
    L7:
        if ((r3 instanceof NetworkNotAvailabeException) == false) goto L11;
        return new CommonHttpException(((NetworkNotAvailabeException) r3).getCronetInternalErrorCode(), a(r3));
    L11:
        if ((r3 instanceof CronetIOException) == false) goto L19;
        CronetIOException r0 = (CronetIOException) r3;
        if (r0.getCronetInternalErrorCode() != (-555)) goto L17;
        return new CommonHttpException(r0.getCronetInternalErrorCode(), a(r3));
    L17:
        return new CommonHttpException(r0.getStatusCode(), a(r3));
    L19:
        return new CommonHttpException(0, a(r3));
    }

    public static List<Header> convertHeaders(Map<String, String> r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.isEmpty() == true) goto L25;
        ArrayList r1 = new ArrayList(r5.size());
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L15;
        Map.Entry<String, String> r2 = r6.next();
        if (r2.getKey() == null) goto L9;
        r1.add(new Header(r2.getKey(), r2.getValue()));
        goto L9
    L15:
        if (r1.isEmpty() == false) goto L18;
        return null;
    L18:
        return r1;
    L25:
        return null;
    }

    public static Pair<String, String> parseUrl(String r4) {
        Uri r0 = UriProtector.parse(r4);
        String r1 = r0.getScheme();
        String r2 = r0.getHost();
        int r3 = r0.getPort();
        if (r2 == null) goto L33;
        StringBuilder r5 = new StringBuilder();
        if (r1 == null) goto L7;
        r5.append(r1);
        r5.append("://");
    L7:
        r5.append(r2);
        if (r3 <= 0) goto L10;
        r5.append(':');
        r5.append(r3);
    L10:
        String r6 = r5.toString();
        String r7 = "/";
        if (r6 != null) goto L13;
    L19:
        String r8 = r0.getEncodedPath();
        if (r8 != null) goto L22;
    L25:
        String r9 = r0.getEncodedQuery();
        if (r9 == null) goto L31;
        if (r9.isEmpty() == true) goto L31;
        r7 = r7 + "?" + r9;
    L31:
        return new Pair(r6, r7);
    L22:
        if (r8.length() == 0) goto L25;
        r7 = r8;
        goto L25
    L13:
        if (r6.isEmpty() == true) goto L19;
        if (r6.endsWith("/") == true) goto L19;
        r6 = r6.concat("/");
        goto L19
    L33:
        throw new IllegalArgumentException("Invalid url, host is null: " + r4);
    }

    @Override // px3.a, com.bytedance.common.utility.NetworkClient
    public final String get(String r3, Map<String, String> r4, NetworkClient.ReqContext r5) throws CommonHttpException {
        Pair<String, String> r6 = parseUrl(r3);     // Catch: Exception -> L8
        String r0 = (String) r6.first;     // Catch: Exception -> L8
        String r7 = (String) r6.second;     // Catch: Exception -> L8
        ICommonApi r1 = (ICommonApi) RetrofitUtils.createSsService(r0, ICommonApi.class);     // Catch: Exception -> L8
        List<Header> r8 = convertHeaders(r4);     // Catch: Exception -> L8
        if (r5 == null) goto L5;
        boolean r9 = r5.addCommonParams;     // Catch: Exception -> L8
    L6:
        return (String) r1.get(-1, r7, r8, r9).execute().body();
    L5:
        r9 = false;
    L8:
        e = move-exception;
        throw c(e);
    }

    @Override // px3.a, com.bytedance.common.utility.NetworkClient
    public final String post(String r8, List<Pair<String, String>> r9, Map<String, String> r10, NetworkClient.ReqContext r11) throws CommonHttpException {
        Pair<String, String> r12 = parseUrl(r8);     // Catch: Exception -> L21
        String r0 = (String) r12.first;     // Catch: Exception -> L21
        String r3 = (String) r12.second;     // Catch: Exception -> L21
        ICommonApi r1 = (ICommonApi) RetrofitUtils.createSsService(r0, ICommonApi.class);     // Catch: Exception -> L21
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Exception -> L21
        if (r9 == null) goto L13;
        Iterator<Pair<String, String>> r13 = r9.iterator();     // Catch: Exception -> L21
    L6:
        if (r13.hasNext() == false) goto L13;
        Pair<String, String> r14 = r13.next();     // Catch: Exception -> L21
        if (r14 == null) goto L6;
        Object r2 = r14.first;     // Catch: Exception -> L21
        if (r2 == null) goto L6;
        r4.put((String) r2, (String) r14.second);     // Catch: Exception -> L21
    L13:
        List<Header> r5 = convertHeaders(r10);     // Catch: Exception -> L21
        if (r11 != null) goto L16;
    L18:
        boolean r6 = false;
    L19:
        return (String) r1.postForm(-1, r3, r4, r5, r6).execute().body();
    L16:
        if (r11.addCommonParams == false) goto L18;
        r6 = true;
    L21:
        e = move-exception;
        throw c(e);
    }

    @Override // px3.a, com.bytedance.common.utility.NetworkClient
    public final byte[] postDataStream(String r8, byte[] r9, Map<String, String> r10, NetworkClient.ReqContext r11) throws CommonHttpException {
        Pair<String, String> r12 = parseUrl(r8);     // Catch: Exception -> L36
        String r0 = (String) r12.first;     // Catch: Exception -> L36
        String r3 = (String) r12.second;     // Catch: Exception -> L36
        ICommonApi r1 = (ICommonApi) RetrofitUtils.createSsService(r0, ICommonApi.class);     // Catch: Exception -> L36
        Pair<String, Map<String, String>> r13 = b(r10);     // Catch: Exception -> L36
        String r14 = (String) r13.first;     // Catch: Exception -> L36
        List<Header> r5 = convertHeaders((Map) r13.second);     // Catch: Exception -> L36
        TypedByteArray r4 = new TypedByteArray(r14, r9, new String[0]);     // Catch: Exception -> L36
        if (r11 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        TypedInput r15 = (TypedInput) r1.postDataStream(-1, r3, r4, r5, r6).execute().body();     // Catch: Exception -> L36
        if (r15 == null) goto L11;
        InputStream r16 = r15.in();     // Catch: Exception -> L36
        ByteArrayOutputStream r17 = new ByteArrayOutputStream();     // Catch: Throwable -> L29
        byte[] r18 = new byte[1024];     // Catch: Throwable -> L23
    L16:
        int r2 = r16.read(r18);     // Catch: Throwable -> L23
        if (r2 == (-1)) goto L19;
        r17.write(r18, 0, r2);     // Catch: Throwable -> L23
        goto L16
    L19:
        byte[] r19 = r17.toByteArray();     // Catch: Throwable -> L23
        r17.close();     // Catch: Throwable -> L29
        r16.close();     // Catch: Exception -> L36
        return r19;
    L23:
        th = move-exception;
        r17.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Throwable -> L29
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        if (r16 != null) goto L39;
    L35:
        throw th;     // Catch: Exception -> L36
    L39:
        r16.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L36
        goto L35
    L11:
        return new byte[0];
    L5:
        if (r11.addCommonParams == false) goto L7;
        r6 = true;
    L36:
        e = move-exception;
        throw c(e);
    }

    @Override // px3.a, com.bytedance.common.utility.NetworkClient
    public final String post(String r8, byte[] r9, Map<String, String> r10, NetworkClient.ReqContext r11) throws CommonHttpException {
        Pair<String, String> r12 = parseUrl(r8);     // Catch: Exception -> L10
        String r0 = (String) r12.first;     // Catch: Exception -> L10
        String r3 = (String) r12.second;     // Catch: Exception -> L10
        ICommonApi r1 = (ICommonApi) RetrofitUtils.createSsService(r0, ICommonApi.class);     // Catch: Exception -> L10
        Pair<String, Map<String, String>> r13 = b(r10);     // Catch: Exception -> L10
        String r14 = (String) r13.first;     // Catch: Exception -> L10
        List<Header> r5 = convertHeaders((Map) r13.second);     // Catch: Exception -> L10
        TypedByteArray r4 = new TypedByteArray(r14, r9, new String[0]);     // Catch: Exception -> L10
        if (r11 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        return (String) r1.postData(-1, r3, r4, r5, r6).execute().body();
    L5:
        if (r11.addCommonParams == false) goto L7;
        r6 = true;
    L10:
        e = move-exception;
        throw c(e);
    }
}
