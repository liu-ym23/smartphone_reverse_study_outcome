package uk7;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.ug.sdk.luckydog.api.network.CommonApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class n {
    public static Header e() {
    L14:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NetworkWrapper", th.getLocalizedMessage());
    L16:
        return null;
    L4:
        if (rm7.c.a.f538587a.f538577b == null) goto L10;
        ik7.g r100 = rk7.m.f538349c;     // Catch: Throwable -> L14
        if (r100 == null) goto L10;
        Pair r101 = r100.getRequestTagHeader();     // Catch: Throwable -> L14
        if (r101 == null) goto L10;
    L11:
        if (r101 == null) goto L16;
        return new Header((String) r101.first, (String) r101.second);
    L10:
        r101 = null;
        goto L11
    }

    public static SsResponse<String> a(Call<String> r100, String r101) throws Exception {
        if (r100 != null) goto L5;
    L12:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        SsResponse<String> r102 = r100.execute();     // Catch: Exception -> L9
        com.bytedance.ug.sdk.luckydog.api.log.d.d("NetworkWrapper", "execute, response: " + r102.body());     // Catch: Exception -> L9
        f(r101, r102, null);     // Catch: Exception -> L9
        return r102;
    L9:
        e = move-exception;
        f(r101, null, e);
        com.bytedance.ug.sdk.luckydog.api.log.d.b("NetworkWrapper", "execute meet exception: " + e);
        throw e;
    }

    public static SsResponse c(String r100, JSONObject r101) throws Exception {
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        return d(r100, r101.toString().getBytes(XML.CHARSET_UTF8));
    }

    public static SsResponse d(String r100, byte[] r101) throws Exception {
        TypedByteArray r102 = new TypedByteArray("application/json; charset=UTF-8", r101, new String[0]);
        ArrayList r103 = new ArrayList();
        Header r104 = e();
        if (r104 == null) goto L5;
        r103.add(r104);
    L5:
        Map<String, Retrofit> r105 = i.f550532a;
        monitor-enter(i.class);
        Object r106 = i.a("https://polaris.zijieapi.com/").create(CommonApi.class);     // Catch: Throwable -> L11
        monitor-exit(i.class);
        return a(((CommonApi) r106).getDataForPost(rk7.m.f538361o.b(r100), r102, r103), r100);
    L11:
        th = move-exception;
        throw th;
    }

    public static SsResponse b(String r100, Map r101, JSONObject r102) throws Exception {
        TypedByteArray r103 = new TypedByteArray("application/json; charset=UTF-8", r102.toString().getBytes(XML.CHARSET_UTF8), new String[0]);
        ArrayList r104 = new ArrayList();
        Header r105 = e();
        if (r105 == null) goto L5;
        r104.add(r105);
    L5:
        Map<String, Retrofit> r106 = i.f550532a;
        monitor-enter(i.class);
        Object r107 = i.a("https://polaris.zijieapi.com/").create(CommonApi.class);     // Catch: Throwable -> L11
        monitor-exit(i.class);
        return a(((CommonApi) r107).getDataForPost(rk7.m.f538361o.b(r100), r104, r101, r103), r100);
    L11:
        th = move-exception;
        throw th;
    }

    public static void f(String r100, SsResponse<String> r101, Exception r102) {
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        r103.put("source", "luckydog");     // Catch: Throwable -> L18
        r103.put("url", r100);     // Catch: Throwable -> L18
        Uri r105 = UriProtector.parse(r100);     // Catch: Throwable -> L18
        r103.put("path", r105.getPath());     // Catch: Throwable -> L18
        r103.put("host", r105.getHost());     // Catch: Throwable -> L18
        int r106 = 0;
        if (r101 != null) goto L7;
        r103.put("success", 0);     // Catch: Throwable -> L18
        r103.put("error_code", k.a(rk7.m.f538361o.e(), r102));     // Catch: Throwable -> L18
        r103.put("error_msg", r102.getMessage());     // Catch: Throwable -> L18
    L16:
        com.bytedance.ug.sdk.luckydog.api.log.e.a("luckydog_network_request", r103, r104);     // Catch: Throwable -> L18
        return;
    L7:
        r103.put("success", 1);     // Catch: Throwable -> L18
        Response r107 = r101.raw();     // Catch: Throwable -> L18
        r103.put("status_code", r107.getStatus());     // Catch: Throwable -> L18
        JSONObject r108 = new JSONObject(r101.body());     // Catch: Throwable -> L18
        int r109 = r108.optInt("err_no", -1);     // Catch: Throwable -> L18
        if (r109 != 0) goto L10;
        r106 = 1;
    L10:
        r103.put("server_success", r106);     // Catch: Throwable -> L18
        r103.put("server_err_num", r109);     // Catch: Throwable -> L18
        r103.put("server_error_msg", r108.optString("err_tips"));     // Catch: Throwable -> L18
        Iterator<Header> r110 = r107.getHeaders().iterator();     // Catch: Throwable -> L18
    L12:
        if (r110.hasNext() == false) goto L16;
        Header r111 = r110.next();     // Catch: Throwable -> L18
        if (r111 == null) goto L12;
        r104.put(r111.getName(), r111.getValue());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("NetworkWrapper", th.getMessage());
    }
}
