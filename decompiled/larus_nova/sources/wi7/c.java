package wi7;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.model.f;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c {
    public static void a() throws IllegalThreadStateException {
        if (m.a.f271349a.f271344l == true) goto L5;
        return;
    L5:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == true) goto L11;
        return;
    L11:
        throw new IllegalThreadStateException("不能在主线程使用同步方式请求网络");
    L7:
        r100 = false;
        goto L8
    }

    public static SsResponse<String> b(Call<String> r100, String r101) throws Exception {
        if (r100 != null) goto L5;
    L12:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        SsResponse<String> r102 = r100.execute();     // Catch: Exception -> L9
        String r103 = r102.body();     // Catch: Exception -> L9
        c(r101, r102, null);     // Catch: Exception -> L9
        return r102;
    L9:
        e = move-exception;
        c(r101, null, e);
        e.toString();
        throw e;
    }

    public static void c(String r100, SsResponse<String> r101, Exception r102) {
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        r103.put("source", "luckycat");     // Catch: Throwable -> L18
        r103.put("url", r100);     // Catch: Throwable -> L18
        Uri r105 = UriProtector.parse(r100);     // Catch: Throwable -> L18
        r103.put("path", r105.getPath());     // Catch: Throwable -> L18
        r103.put("host", r105.getHost());     // Catch: Throwable -> L18
        int r106 = 0;
        if (r101 != null) goto L7;
        r103.put("success", 0);     // Catch: Throwable -> L18
        r103.put("error_code", b.a(m.a.f271349a.f(), r102));     // Catch: Throwable -> L18
        r103.put("error_msg", r102.getMessage());     // Catch: Throwable -> L18
    L16:
        f.b("luckydog_network_request", 0, null, r103, null, r104);     // Catch: Throwable -> L18
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
        th.getMessage();
    }
}
