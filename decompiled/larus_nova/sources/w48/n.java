package w48;

import android.net.Uri;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
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

/* JADX INFO: loaded from: classes.dex */
public final class n extends px3.a {
    public n() {
    }

    public static String a(Exception r100) {
        String r101 = r100.getMessage();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return r100.getClass().getName();
    }

    public static Pair<String, Map<String, String>> b(Map<String, String> r100) {
        LinkedHashMap r101 = null;
        if (r100 == null) goto L24;
        if (r100.isEmpty() == true) goto L24;
        LinkedHashMap r102 = new LinkedHashMap(r100.size());
        Iterator<Map.Entry<String, String>> r103 = r100.entrySet().iterator();
        String r104 = null;
    L9:
        if (r103.hasNext() == false) goto L18;
        Map.Entry<String, String> r105 = r103.next();
        String r106 = r105.getKey();
        if (r106 == null) goto L9;
        if ("Content-Type".equalsIgnoreCase(r106) == true) goto L15;
        r102.put(r106, r105.getValue());
        goto L9
    L15:
        r104 = r105.getValue();
        goto L9
    L18:
        if (r102.isEmpty() == true) goto L22;
        r101 = r102;
    L22:
        return new Pair(r104, r101);
    L24:
        return new Pair(null, null);
    }

    public static CommonHttpException c(Exception r100) {
        if ((r100 instanceof HttpResponseException) == false) goto L7;
        return new CommonHttpException(((HttpResponseException) r100).getStatusCode(), a(r100));
    L7:
        if ((r100 instanceof NetworkNotAvailabeException) == false) goto L11;
        return new CommonHttpException(((NetworkNotAvailabeException) r100).getCronetInternalErrorCode(), a(r100));
    L11:
        if ((r100 instanceof CronetIOException) == false) goto L19;
        CronetIOException r101 = (CronetIOException) r100;
        if (r101.getCronetInternalErrorCode() != (-555)) goto L17;
        return new CommonHttpException(r101.getCronetInternalErrorCode(), a(r100));
    L17:
        return new CommonHttpException(r101.getStatusCode(), a(r100));
    L19:
        return new CommonHttpException(0, a(r100));
    }

    public static List<Header> convertHeaders(Map<String, String> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isEmpty() == true) goto L25;
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L15;
        Map.Entry<String, String> r103 = r102.next();
        if (r103.getKey() == null) goto L9;
        r101.add(new Header(r103.getKey(), r103.getValue()));
        goto L9
    L15:
        if (r101.isEmpty() == false) goto L18;
        return null;
    L18:
        return r101;
    L25:
        return null;
    }

    public static Pair<String, String> parseUrl(String r100) {
        Uri r101 = UriProtector.parse(r100);
        String r102 = r101.getScheme();
        String r103 = r101.getHost();
        int r104 = r101.getPort();
        if (r103 == null) goto L33;
        StringBuilder r105 = new StringBuilder();
        if (r102 == null) goto L7;
        r105.append(r102);
        r105.append("://");
    L7:
        r105.append(r103);
        if (r104 <= 0) goto L10;
        r105.append(':');
        r105.append(r104);
    L10:
        String r106 = r105.toString();
        String r107 = HTTP.URL_DEFAULT;
        if (r106 != null) goto L13;
    L19:
        String r108 = r101.getEncodedPath();
        if (r108 != null) goto L22;
    L25:
        String r109 = r101.getEncodedQuery();
        if (r109 == null) goto L31;
        if (r109.isEmpty() == true) goto L31;
        r107 = r107 + "?" + r109;
    L31:
        return new Pair(r106, r107);
    L22:
        if (r108.length() == 0) goto L25;
        r107 = r108;
        goto L25
    L13:
        if (r106.isEmpty() == true) goto L19;
        if (r106.endsWith(HTTP.URL_DEFAULT) == true) goto L19;
        r106 = r106.concat(HTTP.URL_DEFAULT);
        goto L19
    L33:
        throw new IllegalArgumentException("Invalid url, host is null: " + r100);
    }

    @Override // px3.a, com.bytedance.common.utility.NetworkClient
    public final String get(String r100, Map<String, String> r101, NetworkClient.ReqContext r102) throws CommonHttpException {
        Pair<String, String> r103 = parseUrl(r100);     // Catch: Exception -> L8
        String r104 = (String) r103.first;     // Catch: Exception -> L8
        String r105 = (String) r103.second;     // Catch: Exception -> L8
        ICommonApi r106 = (ICommonApi) RetrofitUtils.createSsService(r104, ICommonApi.class);     // Catch: Exception -> L8
        List<Header> r107 = convertHeaders(r101);     // Catch: Exception -> L8
        if (r102 == null) goto L5;
        boolean r108 = r102.addCommonParams;     // Catch: Exception -> L8
    L6:
        return r106.get(-1, r105, r107, r108).execute().body();
    L5:
        r108 = false;
    L8:
        e = move-exception;
        throw c(e);
    }

    @Override // px3.a, com.bytedance.common.utility.NetworkClient
    public final String post(String r100, List<Pair<String, String>> r101, Map<String, String> r110, NetworkClient.ReqContext r111) throws CommonHttpException {
        Pair<String, String> r102 = parseUrl(r100);     // Catch: Exception -> L21
        String r103 = (String) r102.first;     // Catch: Exception -> L21
        String r104 = (String) r102.second;     // Catch: Exception -> L21
        ICommonApi r105 = (ICommonApi) RetrofitUtils.createSsService(r103, ICommonApi.class);     // Catch: Exception -> L21
        LinkedHashMap r106 = new LinkedHashMap();     // Catch: Exception -> L21
        if (r101 == null) goto L13;
        Iterator<Pair<String, String>> r107 = r101.iterator();     // Catch: Exception -> L21
    L6:
        if (r107.hasNext() == false) goto L13;
        Pair<String, String> r108 = r107.next();     // Catch: Exception -> L21
        if (r108 == null) goto L6;
        Object r109 = r108.first;     // Catch: Exception -> L21
        if (r109 == null) goto L6;
        r106.put((String) r109, (String) r108.second);     // Catch: Exception -> L21
    L13:
        List<Header> r112 = convertHeaders(r110);     // Catch: Exception -> L21
        if (r111 != null) goto L16;
    L18:
        boolean r113 = false;
    L19:
        return r105.postForm(-1, r104, r106, r112, r113).execute().body();
    L16:
        if (r111.addCommonParams == false) goto L18;
        r113 = true;
    L21:
        e = move-exception;
        throw c(e);
    }

    @Override // px3.a, com.bytedance.common.utility.NetworkClient
    public final byte[] postDataStream(String r100, byte[] r101, Map<String, String> r110, NetworkClient.ReqContext r111) throws CommonHttpException {
        Pair<String, String> r102 = parseUrl(r100);     // Catch: Exception -> L36
        String r103 = (String) r102.first;     // Catch: Exception -> L36
        String r104 = (String) r102.second;     // Catch: Exception -> L36
        ICommonApi r105 = (ICommonApi) RetrofitUtils.createSsService(r103, ICommonApi.class);     // Catch: Exception -> L36
        Pair<String, Map<String, String>> r106 = b(r110);     // Catch: Exception -> L36
        String r112 = (String) r106.first;     // Catch: Exception -> L36
        List<Header> r107 = convertHeaders((Map) r106.second);     // Catch: Exception -> L36
        TypedByteArray r108 = new TypedByteArray(r112, r101, new String[0]);     // Catch: Exception -> L36
        if (r111 != null) goto L5;
    L7:
        boolean r109 = false;
    L8:
        TypedInput r113 = r105.postDataStream(-1, r104, r108, r107, r109).execute().body();     // Catch: Exception -> L36
        if (r113 == null) goto L11;
        InputStream r114 = r113.in();     // Catch: Exception -> L36
        ByteArrayOutputStream r115 = new ByteArrayOutputStream();     // Catch: Throwable -> L29
        byte[] r116 = new byte[1024];     // Catch: Throwable -> L23
    L16:
        int r117 = r114.read(r116);     // Catch: Throwable -> L23
        if (r117 == (-1)) goto L19;
        r115.write(r116, 0, r117);     // Catch: Throwable -> L23
        goto L16
    L19:
        byte[] r118 = r115.toByteArray();     // Catch: Throwable -> L23
        r115.close();     // Catch: Throwable -> L29
        r114.close();     // Catch: Exception -> L36
        return r118;
    L23:
        th = move-exception;
        r115.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Throwable -> L29
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        if (r114 != null) goto L39;
    L35:
        throw th;     // Catch: Exception -> L36
    L39:
        r114.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L36
        goto L35
    L11:
        return new byte[0];
    L5:
        if (r111.addCommonParams == false) goto L7;
        r109 = true;
    L36:
        e = move-exception;
        throw c(e);
    }

    @Override // px3.a, com.bytedance.common.utility.NetworkClient
    public final String post(String r100, byte[] r101, Map<String, String> r110, NetworkClient.ReqContext r111) throws CommonHttpException {
        Pair<String, String> r102 = parseUrl(r100);     // Catch: Exception -> L10
        String r103 = (String) r102.first;     // Catch: Exception -> L10
        String r104 = (String) r102.second;     // Catch: Exception -> L10
        ICommonApi r105 = (ICommonApi) RetrofitUtils.createSsService(r103, ICommonApi.class);     // Catch: Exception -> L10
        Pair<String, Map<String, String>> r106 = b(r110);     // Catch: Exception -> L10
        String r112 = (String) r106.first;     // Catch: Exception -> L10
        List<Header> r107 = convertHeaders((Map) r106.second);     // Catch: Exception -> L10
        TypedByteArray r108 = new TypedByteArray(r112, r101, new String[0]);     // Catch: Exception -> L10
        if (r111 != null) goto L5;
    L7:
        boolean r109 = false;
    L8:
        return r105.postData(-1, r104, r108, r107, r109).execute().body();
    L5:
        if (r111.addCommonParams == false) goto L7;
        r109 = true;
    L10:
        e = move-exception;
        throw c(e);
    }
}
