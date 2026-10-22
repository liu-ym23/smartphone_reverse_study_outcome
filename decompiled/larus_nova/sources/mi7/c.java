package mi7;

import android.net.Uri;
import android.text.TextUtils;
import ci7.p;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintState;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.deeplink.UriType;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f514093a;

    public static boolean a(String r100, JSONObject r101) {
        e.a("EventUtil", "onEvent event=" + r100 + ",jsonObject=" + r101);
        if (p.a() == null) goto L6;
        p.a().onEvent(r100, r101);
        return true;
    L6:
        return false;
    }

    public static void b(UriType r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        r102.put("act_uri", r101);     // Catch: Throwable -> L8
        r102.put("act_uri_type", r100.toString());     // Catch: Throwable -> L8
        r102.put("act_time", String.valueOf(System.currentTimeMillis() / 1000));     // Catch: Throwable -> L8
        r102.put("growth_deepevent", "1");     // Catch: Throwable -> L8
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L43;
    L32:
        JSONObject r103 = null;
    L33:
        if (r103 == null) goto L41;
        Iterator<String> r104 = r103.keys();
    L48:
    L39:
        th = move-exception;
        th.printStackTrace();
        goto L41
    L36:
        if (r104.hasNext() == false) goto L41;
        String r105 = r104.next();     // Catch: Throwable -> L39
        r102.put(r105, r103.opt(r105));     // Catch: Throwable -> L39
    L41:
        a("zlink_activation_events", r102);
        return;
    L43:
        Uri r106 = UriProtector.parse(r101);     // Catch: Exception -> L30
        if (r106 == null) goto L32;
        String r107 = UriProtector.getQueryParameter(r106, "zlink_data");     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r107) == false) goto L23;
        String r108 = UriProtector.getQueryParameter(r106, "scheme");     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r108) == true) goto L32;
        r107 = UriProtector.getQueryParameter(UriProtector.parse(r108), "zlink_data");     // Catch: Throwable -> L27
    L23:
        if (TextUtils.isEmpty(r107) == true) goto L32;
        r103 = new JSONObject(r107);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
    L8:
        th = move-exception;
        e.d(6, "EventUtil", "EventData getSchemeParams error", th);
        goto L11
    }

    public static void d(long r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("time_consume", System.currentTimeMillis() - r100).put("result", r101).put("message", r102);     // Catch: JSONException -> L5
    L7:
        a("zlink_fingerprint", r103);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void f(int r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("result", r100).put(BdpAppEventConstant.PARAMS_REQUEST_URL, r101).put("request_method", r102);     // Catch: JSONException -> L5
    L7:
        a("zlink_parse_applink", r103);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void c(int r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        r104.put("code", r100);     // Catch: JSONException -> L5
        r104.put("message", r101);     // Catch: JSONException -> L5
        r104.put("zlink", r102);     // Catch: JSONException -> L5
        r104.put("scheme", r103);     // Catch: JSONException -> L5
    L7:
        a("zlink_token_generate", r104);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void e(String r100, int r101, long r102, int r103, String r104) {
        JSONObject r105 = new JSONObject();
        r105.put(BdpAppEventConstant.PARAMS_REQUEST_URL, r100).put(VoicePrintState.EXT_KEY_RESPONSE_CODE, r101).put("time_consume", r102).put("timeout", r103).put("request_method", r104);     // Catch: JSONException -> L5
    L7:
        a("zlink_network_time_consuming", r105);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
