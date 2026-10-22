package ec4;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.ttnet.ITuringNetworkApi;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import hc4.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public final String a;
    public final Map<String, String> b;
    public final Map<String, String> c;
    public final JSONObject d;
    public final Map<String, String> e;

    public class a implements TypedOutput {
        public final /* synthetic */ byte[] a;

        public final String fileName() {
            return null;
        }

        public final String md5Stub() {
            return null;
        }

        public final String mimeType() {
            return null;
        }

        public final long length() {
            return this.a.length;
        }

        public a(byte[] r1) {
            this.a = r1;
        }

        public final void writeTo(OutputStream r2) throws IOException {
            r2.write(this.a);
        }
    }

    public class b implements Callback<String> {
        public final /* synthetic */ c a;
        public final /* synthetic */ j b;

        public b(j r1, c r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void onFailure(Call<String> r1, Throwable r2) {
            c r3 = this.a;
            if (r3 == null) goto L6;
            r3.onError(r2);
            return;
        }

        public final void onResponse(Call<String> r3, SsResponse<String> r4) {
            if (this.a == null) goto L16;
            String r5 = j.a(this.b, r4);     // Catch: Exception -> L9
            if (TextUtils.isEmpty(r5) == true) goto L7;
            JSONObject r6 = new JSONObject(r5);     // Catch: Exception -> L9
            xb4.a r7 = new xb4.a();     // Catch: Exception -> L9
            r7.a = r6.optInt("code", -9999);     // Catch: Exception -> L9
            r7.c = r6.optString("message");     // Catch: Exception -> L9
            r7.d = r6.optString("sec_message");     // Catch: Exception -> L9
            r7.b = r6.optJSONObject("data");     // Catch: Exception -> L9
            this.a.a(r7);     // Catch: Exception -> L9
        L12:
            return;
        L7:
            this.a.onError(new Throwable("body is Empty"));     // Catch: Exception -> L9
        L9:
            e = move-exception;
            e.printStackTrace();
            this.a.onError(e);
            return;
        }
    }

    public final void c(c r7) {
        String r0 = b(this.a, this.b);     // Catch: Exception -> L29
        Map<String, String> r1 = this.e;     // Catch: Exception -> L29
        BdTuringConfig r3 = qb4.b.c.a.a;     // Catch: Exception -> L11
        if (r3 == null) goto L7;
        Context r4 = r3.getApplicationContext();     // Catch: Exception -> L11
    L8:
        if (r4 == null) goto L13;
        i.a(r4, r0, r1);     // Catch: Exception -> L11
    L13:
        JSONObject r2 = this.d;     // Catch: Exception -> L29
        if (r2 != null) goto L27;
        Map<String, String> r5 = this.c;     // Catch: Exception -> L29
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L29
        if (r5 != null) goto L36;
    L26:
        r2 = r6;
        goto L27
    L36:
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L29
        goto L26
    L18:
        if (r5.size() <= 0) goto L26;
        Iterator<Map.Entry<String, String>> r8 = r5.entrySet().iterator();     // Catch: Exception -> L24
    L21:
        if (r8.hasNext() == false) goto L26;
        Map.Entry<String, String> r9 = r8.next();     // Catch: Exception -> L24
        r6.put(r9.getKey(), r9.getValue());     // Catch: Exception -> L24
    L27:
        ((ITuringNetworkApi) RetrofitUtils.getSsRetrofit(r0).create(ITuringNetworkApi.class)).doPost(r0, null, new a(r2.toString().getBytes(StandardCharsets.UTF_8)), h.c(this.e)).enqueue(new b(this, r7));     // Catch: Exception -> L29
        return;
    L7:
        r4 = null;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
        r7.onError(e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static String a(j r4, SsResponse r5) {
        r4.getClass();
        ?? r0 = 200(0xc8, float:2.8E-43);
        if (r5.code() != 200) goto L47;
        SsResponse r6 = null;
        SsResponse r7 = r5.raw().getBody().in();     // Catch: Throwable -> L23 Exception -> L25
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L19 Exception -> L21
    L54:
        byte[] r8 = new byte[1024];     // Catch: Exception -> L17 Throwable -> L36
    L9:
        int r2 = r7.read(r8);     // Catch: Exception -> L17 Throwable -> L36
        if (r2 == (-1)) goto L12;
        r1.write(r8, 0, r2);     // Catch: Exception -> L17 Throwable -> L36
        goto L9
    L12:
        String r9 = new String(r1.toByteArray(), StandardCharsets.UTF_8);     // Catch: Exception -> L17 Throwable -> L36
        r7.close();     // Catch: Exception -> L15
        r1.close();     // Catch: Exception -> L15
        return r9;
    L15:
        e = move-exception;
        e.printStackTrace();
        return r9;
    L17:
        Exception e = e;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L36
        if (r7 != null) goto L56;
    L32:
        if (r1 == null) goto L47;
        r1.close();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L47
    L56:
        r7.close();     // Catch: Exception -> L30
    L21:
        e = move-exception;
        r1 = null;
        e = e;
    L19:
        th = move-exception;
        r0 = 0;
        r6 = r7;
        Throwable r10 = th;
    L38:
        if (r6 != null) goto L52;
    L42:
        if (r0 == 0) goto L62;
        r0.close();     // Catch: Exception -> L40
        throw r10;
    L40:
        e = move-exception;
        e.printStackTrace();
        throw r10;
    L62:
        throw r10;
    L52:
        r6.close();     // Catch: Exception -> L40
        goto L42
    L36:
        th = move-exception;
        r10 = th;
        r6 = r5;
    L25:
        e = move-exception;
        r1 = null;
        e = e;
        r7 = null;
    L23:
        th = move-exception;
        r10 = th;
        r0 = 0;
    L47:
        return "";
    }

    public static String b(String r6, Map r7) {
        HashMap r0 = new HashMap();
        BdTuringConfig r1 = qb4.b.c.a.a;
        if (r1 == null) goto L5;
        r0.put("aid", r1.getAppId());
        r0.put("lang", r1.getLanguage());
        r0.put("app_name", r1.getAppName());
        r0.put("locale", r1.getLocale());
        r0.put("channel", r1.getChannel());
        r0.put("ch", r1.getChannel());
        r0.put("app_key", r1.getAppKey());
        r0.put("iid", r1.getInstallId());
        r0.put("did", r1.getDeviceId());
        r0.put("vc", r1.getAppVersion());
        r0.put("app_version", r1.getAppVersion());
        r0.put("region", r1.getRegionType().getName());
        Activity r2 = r1.getTopActivity();
        r0.put("resolution", f.i());
        r0.put("orientation", "" + f.g(r2));
        r0.put("sdk_version", "4.1.1.cn");
        r0.put("os_version", hc4.a.c);
        r0.put("device_brand", hc4.a.a);
        String r3 = hc4.a.b;
        r0.put("device_model", r3);
        r0.put("os_name", "android");
        r0.put("version_code", r1.getAppVersionCode());
        r0.put("version_name", r1.getAppVersion());
        r0.put("device_type", r3);
        r0.put("device_platform", "android");
        r0.put("os_type", "0");
    L5:
        if (r7 == null) goto L13;
        if (r7.size() <= 0) goto L13;
        Iterator r4 = r7.keySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L13;
        String r5 = (String) r4.next();
        r0.put(r5, (String) r7.get(r5));
    L13:
        if (r0.size() <= 0) goto L26;
        StringBuilder r8 = new StringBuilder(r6);
        if (r6.contains("?") == true) goto L17;
        r8.append("?");
    L18:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r0.entrySet().iterator();
    L20:
        if (r10.hasNext() == false) goto L22;
        Map.Entry r11 = (Map.Entry) r10.next();
        r9.add(new Pair((String) r11.getKey(), (String) r11.getValue()));
        goto L20
    L22:
        r8.append(NetworkUtils.format(r9, "UTF-8"));
        return r8.toString();
    L17:
        r8.append("&");
        goto L18
    L26:
        return r6;
    }

    public j(String r7, Map<String, String> r8, Map<String, String> r9, Map<String, String> r10) {
        this(r7, r8, r9, null, r10);
    }

    public j(String r1, Map<String, String> r2, Map<String, String> r3, JSONObject r4, Map<String, String> r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        if (r5.containsKey("Content-Type") == true) goto L6;
        r5.put("Content-Type", "application/json; charset=utf-8");
        return;
    }
}
