package px3;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.article.common.network.ICommonApi;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends NetworkClient {
    public a() {
    }

    public static List<Header> convertHeaders(Map<String, String> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, String> r103 = r102.next();
        r101.add(new Header(r103.getKey(), r103.getValue()));
        goto L7
    L9:
        return r101;
    }

    public static Pair<String, String> parseUrl(String r100) throws Exception {
        Uri r101 = UriProtector.parse(r100);
        StringBuilder r102 = new StringBuilder();
        String r103 = r101.getScheme();
        String r104 = r101.getHost();
        int r105 = r101.getPort();
        if (r104 == null) goto L9;
        if (r103 == null) goto L6;
        r102.append(r103);
        r102.append("://");
    L6:
        r102.append(r104);
        if (r105 <= 0) goto L9;
        r102.append(':');
        r102.append(r105);
    L9:
        String r106 = r102.toString();
        String r107 = r101.getPath();
        String r108 = r101.getQuery();
        if (r108 == null) goto L13;
        r107 = r107 + "?" + r108;
    L13:
        return new Pair(r106, r107);
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String get(String r100, Map<String, String> r101, NetworkClient.ReqContext r102) throws Exception {
        Pair<String, String> r103 = parseUrl(r100);
        String r104 = (String) r103.first;
        String r105 = (String) r103.second;
        ICommonApi r106 = (ICommonApi) RetrofitUtils.createSsService(r104, ICommonApi.class);
        List<Header> r107 = convertHeaders(r101);
        if (r102 == null) goto L5;
        boolean r108 = r102.addCommonParams;
    L7:
        return r106.get(-1, r105, r107, r108).execute().body();
    L5:
        r108 = false;
        goto L7
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String r100, List<Pair<String, String>> r110, Map<String, String> r111, NetworkClient.ReqContext r112) throws CommonHttpException {
        Pair<String, String> r101 = parseUrl(r100);     // Catch: Exception -> L14
        String r102 = (String) r101.first;     // Catch: Exception -> L14
        String r103 = (String) r101.second;     // Catch: Exception -> L14
        ICommonApi r104 = (ICommonApi) RetrofitUtils.createSsService(r102, ICommonApi.class);     // Catch: Exception -> L14
        List<Header> r105 = convertHeaders(r111);     // Catch: Exception -> L14
        LinkedHashMap r106 = new LinkedHashMap();     // Catch: Exception -> L14
        if (r110 == null) goto L9;
        Iterator<Pair<String, String>> r107 = r110.iterator();     // Catch: Exception -> L14
    L7:
        if (r107.hasNext() == false) goto L9;
        Pair<String, String> r113 = r107.next();     // Catch: Exception -> L14
        r106.put(r113.first, r113.second);     // Catch: Exception -> L14
    L9:
        if (r112 == null) goto L11;
        boolean r108 = r112.addCommonParams;     // Catch: Exception -> L14
    L12:
        return r104.postForm(-1, r103, r106, r105, r108).execute().body();
    L11:
        r108 = false;
    L14:
        e = move-exception;
        if ((e instanceof HttpResponseException) == false) goto L20;
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());
    L20:
        throw new CommonHttpException(0, e.getMessage());
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public byte[] postDataStream(String r110, byte[] r111, Map<String, String> r112, NetworkClient.ReqContext r113) throws CommonHttpException {
        InputStream r100 = null;
        Pair<String, String> r114 = parseUrl(r110);     // Catch: Throwable -> L36 Exception -> L38
        String r101 = (String) r114.first;     // Catch: Throwable -> L36 Exception -> L38
        String r102 = (String) r114.second;     // Catch: Throwable -> L36 Exception -> L38
        ICommonApi r103 = (ICommonApi) RetrofitUtils.createSsService(r101, ICommonApi.class);     // Catch: Throwable -> L36 Exception -> L38
        if (r112 == null) goto L6;
        String r104 = r112.get("Content-Type");     // Catch: Throwable -> L36 Exception -> L38
        r112.remove("Content-Type");     // Catch: Throwable -> L36 Exception -> L38
    L7:
        List<Header> r105 = convertHeaders(r112);     // Catch: Throwable -> L36 Exception -> L38
        if (r113 == null) goto L10;
        boolean r106 = r113.addCommonParams;     // Catch: Throwable -> L36 Exception -> L38
    L11:
        InputStream r115 = r103.postDataStream(-1, r102, new TypedByteArray(r104, r111, new String[0]), r105, r106).execute().body().in();     // Catch: Throwable -> L36 Exception -> L38
    L71:
        ByteArrayOutputStream r116 = new ByteArrayOutputStream();     // Catch: Throwable -> L32 Exception -> L34
    L69:
        byte[] r117 = new byte[1024];     // Catch: Throwable -> L28 Exception -> L30
    L15:
        int r118 = r115.read(r117);     // Catch: Throwable -> L28 Exception -> L30
        if (r118 == (-1)) goto L18;
        r116.write(r117, 0, r118);     // Catch: Throwable -> L28 Exception -> L30
        goto L15
    L18:
        byte[] r119 = r116.toByteArray();     // Catch: Throwable -> L28 Exception -> L30
        r115.close();     // Catch: IOException -> L21
    L62:
        r116.close();     // Catch: IOException -> L25
    L27:
        return r119;
    L25:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L62
    L30:
        e = move-exception;
        r100 = r115;
        e = e;
    L64:
    L46:
        th = th;
    L47:
        if (r100 != null) goto L60;
    L52:
        if (r116 == null) goto L74;
        r116.close();     // Catch: IOException -> L55
        throw th;
    L55:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L74:
        throw th;
    L60:
        r100.close();     // Catch: IOException -> L50
    L50:
        e = move-exception;
        e.printStackTrace();
        goto L52
    L41:
        if ((e instanceof HttpResponseException) == false) goto L45;
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());     // Catch: Throwable -> L46
    L45:
        throw new CommonHttpException(0, e.getMessage());     // Catch: Throwable -> L46
    L28:
        th = move-exception;
        r100 = r115;
        th = th;
    L34:
        e = move-exception;
        r100 = r115;
        e = e;
        r116 = null;
    L32:
        th = move-exception;
        r100 = r115;
        th = th;
        r116 = null;
        goto L47
    L10:
        r106 = false;
        goto L11
    L6:
        r104 = null;
    L38:
        e = e;
        r116 = null;
    L36:
        th = th;
        r116 = null;
        goto L47
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String r100, byte[] r110, Map<String, String> r111, NetworkClient.ReqContext r112) throws CommonHttpException {
        Pair<String, String> r101 = parseUrl(r100);     // Catch: Exception -> L13
        String r102 = (String) r101.first;     // Catch: Exception -> L13
        String r103 = (String) r101.second;     // Catch: Exception -> L13
        ICommonApi r104 = (ICommonApi) RetrofitUtils.createSsService(r102, ICommonApi.class);     // Catch: Exception -> L13
        if (r111 == null) goto L6;
        String r105 = r111.get("Content-Type");     // Catch: Exception -> L13
        r111.remove("Content-Type");     // Catch: Exception -> L13
    L7:
        List<Header> r106 = convertHeaders(r111);     // Catch: Exception -> L13
        if (r112 == null) goto L10;
        boolean r107 = r112.addCommonParams;     // Catch: Exception -> L13
    L11:
        return r104.postData(-1, r103, new TypedByteArray(r105, r110, new String[0]), r106, r107).execute().body();
    L10:
        r107 = false;
        goto L11
    L6:
        r105 = null;
    L13:
        e = move-exception;
        if ((e instanceof HttpResponseException) == false) goto L19;
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());
    L19:
        throw new CommonHttpException(0, e.getMessage());
    }
}
