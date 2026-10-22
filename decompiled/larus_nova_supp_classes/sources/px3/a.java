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
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class a extends NetworkClient {
    public a() {
    }

    public static List<Header> convertHeaders(Map<String, String> r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        Map.Entry<String, String> r1 = r5.next();
        r0.add(new Header(r1.getKey(), r1.getValue()));
        goto L7
    L9:
        return r0;
    }

    public static Pair<String, String> parseUrl(String r4) throws Exception {
        Uri r5 = UriProtector.parse(r4);
        StringBuilder r0 = new StringBuilder();
        String r1 = r5.getScheme();
        String r2 = r5.getHost();
        int r3 = r5.getPort();
        if (r2 == null) goto L9;
        if (r1 == null) goto L6;
        r0.append(r1);
        r0.append("://");
    L6:
        r0.append(r2);
        if (r3 <= 0) goto L9;
        r0.append(':');
        r0.append(r3);
    L9:
        String r6 = r0.toString();
        String r7 = r5.getPath();
        String r8 = r5.getQuery();
        if (r8 == null) goto L13;
        r7 = r7 + "?" + r8;
    L13:
        return new Pair(r6, r7);
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String get(String r3, Map<String, String> r4, NetworkClient.ReqContext r5) throws Exception {
        Pair<String, String> r6 = parseUrl(r3);
        String r0 = (String) r6.first;
        String r7 = (String) r6.second;
        ICommonApi r1 = (ICommonApi) RetrofitUtils.createSsService(r0, ICommonApi.class);
        List<Header> r8 = convertHeaders(r4);
        if (r5 == null) goto L5;
        boolean r9 = r5.addCommonParams;
    L7:
        return (String) r1.get(-1, r7, r8, r9).execute().body();
    L5:
        r9 = false;
        goto L7
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String r9, List<Pair<String, String>> r10, Map<String, String> r11, NetworkClient.ReqContext r12) throws CommonHttpException {
        Pair<String, String> r13 = parseUrl(r9);     // Catch: Exception -> L14
        String r1 = (String) r13.first;     // Catch: Exception -> L14
        String r4 = (String) r13.second;     // Catch: Exception -> L14
        ICommonApi r2 = (ICommonApi) RetrofitUtils.createSsService(r1, ICommonApi.class);     // Catch: Exception -> L14
        List<Header> r6 = convertHeaders(r11);     // Catch: Exception -> L14
        LinkedHashMap r5 = new LinkedHashMap();     // Catch: Exception -> L14
        if (r10 == null) goto L9;
        Iterator<Pair<String, String>> r14 = r10.iterator();     // Catch: Exception -> L14
    L7:
        if (r14.hasNext() == false) goto L9;
        Pair<String, String> r15 = r14.next();     // Catch: Exception -> L14
        r5.put(r15.first, r15.second);     // Catch: Exception -> L14
    L9:
        if (r12 == null) goto L11;
        boolean r7 = r12.addCommonParams;     // Catch: Exception -> L14
    L12:
        return (String) r2.postForm(-1, r4, r5, r6, r7).execute().body();
    L11:
        r7 = false;
    L14:
        e = move-exception;
        if ((e instanceof HttpResponseException) == false) goto L20;
        throw new CommonHttpException(e.getStatusCode(), e.getMessage());
    L20:
        throw new CommonHttpException(0, e.getMessage());
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public byte[] postDataStream(String r11, byte[] r12, Map<String, String> r13, NetworkClient.ReqContext r14) throws CommonHttpException {
        InputStream r1 = null;
        Pair<String, String> r15 = parseUrl(r11);     // Catch: Throwable -> L36 Exception -> L38
        String r2 = (String) r15.first;     // Catch: Throwable -> L36 Exception -> L38
        String r5 = (String) r15.second;     // Catch: Throwable -> L36 Exception -> L38
        ICommonApi r3 = (ICommonApi) RetrofitUtils.createSsService(r2, ICommonApi.class);     // Catch: Throwable -> L36 Exception -> L38
        if (r13 == null) goto L6;
        String r4 = r13.get("Content-Type");     // Catch: Throwable -> L36 Exception -> L38
        r13.remove("Content-Type");     // Catch: Throwable -> L36 Exception -> L38
    L7:
        List<Header> r7 = convertHeaders(r13);     // Catch: Throwable -> L36 Exception -> L38
        if (r14 == null) goto L10;
        boolean r8 = r14.addCommonParams;     // Catch: Throwable -> L36 Exception -> L38
    L11:
        InputStream r16 = ((TypedInput) r3.postDataStream(-1, r5, new TypedByteArray(r4, r12, new String[0]), r7, r8).execute().body()).in();     // Catch: Throwable -> L36 Exception -> L38
    L71:
        ByteArrayOutputStream r17 = new ByteArrayOutputStream();     // Catch: Throwable -> L32 Exception -> L34
    L69:
        byte[] r18 = new byte[1024];     // Catch: Throwable -> L28 Exception -> L30
    L15:
        int r19 = r16.read(r18);     // Catch: Throwable -> L28 Exception -> L30
        if (r19 == (-1)) goto L18;
        r17.write(r18, 0, r19);     // Catch: Throwable -> L28 Exception -> L30
        goto L15
    L18:
        byte[] r110 = r17.toByteArray();     // Catch: Throwable -> L28 Exception -> L30
        r16.close();     // Catch: IOException -> L21
    L62:
        r17.close();     // Catch: IOException -> L25
    L27:
        return r110;
    L25:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L62
    L30:
        e = move-exception;
        r1 = r16;
        e = e;
    L64:
    L46:
        th = th;
    L47:
        if (r1 != null) goto L60;
    L52:
        if (r17 == null) goto L74;
        r17.close();     // Catch: IOException -> L55
        throw th;
    L55:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L74:
        throw th;
    L60:
        r1.close();     // Catch: IOException -> L50
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
        r1 = r16;
        th = th;
    L34:
        e = move-exception;
        r1 = r16;
        e = e;
        r17 = null;
    L32:
        th = move-exception;
        r1 = r16;
        th = th;
        r17 = null;
        goto L47
    L10:
        r8 = false;
        goto L11
    L6:
        r4 = null;
    L38:
        e = e;
        r17 = null;
    L36:
        th = th;
        r17 = null;
        goto L47
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String r9, byte[] r10, Map<String, String> r11, NetworkClient.ReqContext r12) throws CommonHttpException {
        Pair<String, String> r13 = parseUrl(r9);     // Catch: Exception -> L13
        String r1 = (String) r13.first;     // Catch: Exception -> L13
        String r4 = (String) r13.second;     // Catch: Exception -> L13
        ICommonApi r2 = (ICommonApi) RetrofitUtils.createSsService(r1, ICommonApi.class);     // Catch: Exception -> L13
        if (r11 == null) goto L6;
        String r3 = r11.get("Content-Type");     // Catch: Exception -> L13
        r11.remove("Content-Type");     // Catch: Exception -> L13
    L7:
        List<Header> r6 = convertHeaders(r11);     // Catch: Exception -> L13
        if (r12 == null) goto L10;
        boolean r7 = r12.addCommonParams;     // Catch: Exception -> L13
    L11:
        return (String) r2.postData(-1, r4, new TypedByteArray(r3, r10, new String[0]), r6, r7).execute().body();
    L10:
        r7 = false;
        goto L11
    L6:
        r3 = null;
    L13:
        e = move-exception;
        if ((e instanceof HttpResponseException) == false) goto L19;
        throw new CommonHttpException(e.getStatusCode(), e.getMessage());
    L19:
        throw new CommonHttpException(0, e.getMessage());
    }
}
