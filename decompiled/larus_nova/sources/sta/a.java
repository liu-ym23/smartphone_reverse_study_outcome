package sta;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.ttcjpaysdk.integrated.counter.CJPayBaseConstant;
import com.ss.android.dypay.api.IDyPayEventCallback;
import com.ss.android.dypay.base.d;
import com.ss.android.dypay.base.f;
import com.ss.android.dypay.utils.e;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import vta.b;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f543575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f543576b = null;

    static {
        f543576b = new a();
    }

    public a() {
    }

    public static void a(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r101 = new JSONObject();
        r101.put("dy_available", Boolean.valueOf(e.b(r100, "dypay://aweme")));     // Catch: Exception -> L44
    L54:
        r101.put("dy_lite_available", Boolean.valueOf(e.a(r100, "com.ss.android.ugc.aweme.lite", "ttcjpay://dypay/awemelite", null)));     // Catch: Exception -> L45
    L52:
        r101.put("dy_hotsoon_available", Boolean.valueOf(e.a(r100, "com.ss.android.ugc.live", "dypay8663://dypay/cashier", null)));     // Catch: Exception -> L11
    L12:
        JSONObject r102 = e.f(r100, "com.ss.android.ugc.aweme");
        if (r102 == null) goto L22;
        Iterator<String> r103 = r102.keys();
    L16:
        if (r103.hasNext() == false) goto L22;
        String r104 = r103.next();
        String r105 = "dy_pkg_" + r104;
        Object r106 = r102.opt(r104);
        if (r105 == null) goto L16;
        r101.put(r105, r106);     // Catch: Exception -> L21
    L22:
        JSONObject r107 = e.f(r100, "com.ss.android.ugc.aweme.lite");
        if (r107 == null) goto L32;
        Iterator<String> r108 = r107.keys();
    L26:
        if (r108.hasNext() == false) goto L32;
        String r109 = r108.next();
        String r110 = "dy_lite_pkg_" + r109;
        Object r111 = r107.opt(r109);
        if (r110 == null) goto L26;
        r101.put(r110, r111);     // Catch: Exception -> L31
    L32:
        JSONObject r112 = e.f(r100, "com.ss.android.ugc.live");
        if (r112 == null) goto L42;
        Iterator<String> r113 = r112.keys();
    L36:
        if (r113.hasNext() == false) goto L42;
        String r114 = r113.next();
        String r115 = "dy_hotsoon_pkg_" + r114;
        Object r116 = r112.opt(r114);
        if (r115 == null) goto L36;
        r101.put(r115, r116);     // Catch: Exception -> L41
    L42:
        f543575a = r101;
    }

    public static void g(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("msg", r100);     // Catch: Exception -> L6
    L4:
        b(d.f408440g, "out_wallet_rd_dy_pay_exception", r101, -1);
    }

    public final void d(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("btm", r100);     // Catch: Exception -> L5
    L6:
        d r102 = d.f408440g;
        if (r102 == null) goto L11;
        String r103 = r102.f408441a;
        if (r103 == null) goto L11;
    L16:
        r101.put("launch_id", r103);     // Catch: Exception -> L15
    L13:
        f(this, "btm_page_show", r101);
        return;
    L11:
        r103 = "";
        goto L16
    }

    public static void c(d r100, JSONObject r101) {
        if (r100 == null) goto L119;
        r101.put("merchant_id", r100.f408442b);     // Catch: Exception -> L86
    L115:
        r101.put("app_id", r100.f408443c);     // Catch: Exception -> L87
    L125:
        r101.put("cj_source", "outer_pay");     // Catch: Exception -> L88
    L117:
        r101.put(CJPayBaseConstant.CLIENT_SESSION_ID, r100.f408441a);     // Catch: Exception -> L89
    L103:
        r101.put("client_base_time", Long.valueOf(r100.f408444d));     // Catch: Exception -> L90
    L20:
        SharedPreferences r102 = vta.d.f557260a;     // Catch: Exception -> L94
        b r103 = vta.d.b(r100.f408442b, r100.f408443c);     // Catch: Exception -> L94
        if (r103 == null) goto L24;
        String r104 = r103.a();     // Catch: Exception -> L94
    L133:
        r101.put("cj_biz_tag", r104);     // Catch: Exception -> L91
    L26:
        Map<String, Object> r105 = r100.f408446f;     // Catch: Exception -> L94
        if (r105 == null) goto L35;
        Iterator<Map.Entry<String, Object>> r106 = r105.entrySet().iterator();     // Catch: Exception -> L94
    L30:
        if (r106.hasNext() == false) goto L35;
        Map.Entry<String, Object> r107 = r106.next();     // Catch: Exception -> L94
        String r108 = r107.getKey();     // Catch: Exception -> L94
        Object r109 = r107.getValue();     // Catch: Exception -> L94
        if (r108 == null) goto L30;
        r101.put(r108, r109);     // Catch: Exception -> L92
    L35:
        Map<String, Object> r110 = r100.f408445e;     // Catch: Exception -> L94
        if (r110 == null) goto L119;
        Iterator<Map.Entry<String, Object>> r111 = r110.entrySet().iterator();     // Catch: Exception -> L94
    L38:
        if (r111.hasNext() == false) goto L119;
        Map.Entry<String, Object> r112 = r111.next();     // Catch: Exception -> L94
        String r113 = r112.getKey();     // Catch: Exception -> L94
        Object r114 = r112.getValue();     // Catch: Exception -> L94
        if (r113 == null) goto L38;
        r101.put(r113, r114);     // Catch: Exception -> L93
        goto L38
    L24:
        r104 = null;
    L119:
        r101.put("outer_aid", com.ss.android.dypay.core.a.f408462a);     // Catch: Exception -> L95
    L131:
        r101.put("os_name", "android");     // Catch: Exception -> L96
    L107:
        r101.put("app_platform", "native");     // Catch: Exception -> L97
    L113:
        r101.put("sdk_verison", "1.0.0.lite");     // Catch: Exception -> L98
    L121:
        r101.put("params_for_special", com.bytedance.android.ec.core.event.a.VALUE_PARAMS_FOR_SPECIAL);     // Catch: Exception -> L99
    L129:
        r101.put("is_chaselight", 1);     // Catch: Exception -> L100
    L59:
        String r115 = com.ss.android.dypay.core.a.f408462a;     // Catch: Exception -> L70
        if (r115 != null) goto L62;
    L67:
        Integer r116 = null;
    L68:
        r101.put("aid", r116);     // Catch: Exception -> L70
        goto L71
    L62:
        if ((true ^ StringsKt.isBlank(r115)) == true) goto L65;
        r115 = null;
    L65:
        if (r115 == null) goto L67;
        r116 = StringsKt.toIntOrNull(r115);     // Catch: Exception -> L70
    L71:
        JSONObject r117 = f543575a;
        if (r117 == null) goto L85;
        Iterator<String> r118 = r117.keys();
        if (r118 != null) goto L76;
        return;
    L76:
        if (r118.hasNext() == false) goto L149;
        String r119 = r118.next();
        JSONObject r120 = f543575a;
        if (r120 == null) goto L80;
        Object r121 = r120.opt(r119);
    L81:
        if (r119 == null) goto L76;
        r101.put(r119, r121);     // Catch: Exception -> L84
        goto L76
    L80:
        r121 = null;
        goto L81
    L149:
        return;
    }

    public static void f(a r100, String r101, JSONObject r102) {
        d r103 = d.f408440g;
        r100.getClass();
        b(r103, r101, r102, -1);
    }

    public static void b(d r100, String r101, JSONObject r102, long r103) {
        JSONObject r104 = new JSONObject();
        c(r100, r104);     // Catch: Throwable -> L22
        long r105 = 0;
        if (r103 >= 0) goto L7;
        r103 = System.currentTimeMillis();     // Catch: Throwable -> L22
    L7:
        if (r100 == null) goto L30;
        r105 = r100.f408444d;     // Catch: Throwable -> L22
    L30:
        r104.put("client_duration", Long.valueOf(r103 - r105));     // Catch: Exception -> L28 Throwable -> L22
    L11:
        Iterator<String> r106 = r102.keys();     // Catch: Throwable -> L22
    L13:
        if (r106.hasNext() == false) goto L18;
        String r107 = r106.next();     // Catch: Throwable -> L22
        Object r108 = r102.opt(r107);     // Catch: Throwable -> L22
        if (r107 == null) goto L13;
        r104.put(r107, r108);     // Catch: Exception -> L29 Throwable -> L22
        goto L13
    L18:
        IDyPayEventCallback r109 = com.ss.android.dypay.core.a.f408463b;     // Catch: Throwable -> L22
        if (r109 == null) goto L23;
        r109.onEvent(r101, r104);     // Catch: Throwable -> L22
    L23:
        f r110 = com.ss.android.dypay.base.a.f408435a;
        if (r110 == null) goto L26;
        r110.a();
    L26:
        r104.toString();
    }

    public static void e(String r100, String r101, String r102, JSONObject r103, JSONObject r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = "";
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r105 & 32) == 0) goto L14;
        long r106 = -1;
    L15:
        if (r103 != null) goto L36;
        r103 = new JSONObject();
    L36:
        r103.put("process_node", r100);     // Catch: Exception -> L28
    L32:
        r103.put("process_desc", r101);     // Catch: Exception -> L29
    L38:
        r103.put("detail_desc", r102);     // Catch: Exception -> L30
    L34:
        r103.put("ext_params", r104);     // Catch: Exception -> L31
    L26:
        b(d.f408440g, "out_wallet_rd_process_desc", r103, r106);
        return;
    L14:
        r106 = 0;
        goto L15
    }
}
