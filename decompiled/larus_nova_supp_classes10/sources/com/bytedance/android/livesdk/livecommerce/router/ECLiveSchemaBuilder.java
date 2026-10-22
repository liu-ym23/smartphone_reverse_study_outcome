package com.bytedance.android.livesdk.livecommerce.router;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.l;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.event.t1;
import com.bytedance.android.livesdk.livecommerce.room.f;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveSchemaBuilder implements hf.a {
    public static final Map<String, String> l = null;
    public Uri a;
    public String b;
    public Map<String, String> c;
    public Map<String, String> d;
    public final dm.a.b e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;

    public static final class a {
    }

    public final String build() {
        String r1 = j(false);
        h(false);
        return r1;
    }

    static {
        l = new LinkedHashMap();
    }

    public ECLiveSchemaBuilder() {
        this.e = dm.a.a("ECLiveSchemaBuilder");
        this.f = LazyKt.lazy(ECLiveSchemaBuilder$ecomLiveParamsInfo$2.INSTANCE);
        this.g = LazyKt.lazy(ECLiveSchemaBuilder$passThroughLogDataDenyList$2.INSTANCE);
        this.h = LazyKt.lazy(ECLiveSchemaBuilder$ecomLiveParamError$2.INSTANCE);
        this.i = LazyKt.lazy(ECLiveSchemaBuilder$passThroughLogDataError$2.INSTANCE);
        this.j = LazyKt.lazy(ECLiveSchemaBuilder$passThroughLogDataSuperError$2.INSTANCE);
        this.k = LazyKt.lazy(ECLiveSchemaBuilder$passThroughLogDataFixError$2.INSTANCE);
    }

    public final ECLiveSchemaBuilder a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "baseSchema");
        this.b = r2;
        return this;
    }

    public final ECLiveSchemaBuilder c(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "ecomLiveParams");
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<String> r2 = r6.keys();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r3 = r2.next();
        r1.put(r3, r6.optString(r3));
        goto L4
    L6:
        Intrinsics.checkNotNullParameter(r1, "ecomLiveParams");
        if ((!r1.isEmpty()) == false) goto L9;
        this.d = r1;
    L9:
        return this;
    }

    public final ECLiveSchemaBuilder d(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "query");
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<String> r2 = r6.keys();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r3 = r2.next();
        r1.put(r3, r6.optString(r3));
        goto L4
    L6:
        Intrinsics.checkNotNullParameter(r1, "query");
        if ((!r1.isEmpty()) == false) goto L9;
        this.c = r1;
    L9:
        return this;
    }

    public final boolean f(String r5) {
        JSONObject r0 = (JSONObject) this.f.getValue();
        if (r0 == null) goto L25;
        String r1 = r0.optString(r5);
        if (r1 == null) goto L23;
        int r2 = r1.hashCode();
        if (r2 == (-1034364087)) goto L21;
        if (r2 == (-891985903)) goto L18;
        if (r2 != 107868) goto L23;
        if (r1.equals("map") == false) goto L23;
        return true;
    L18:
        if (r1.equals("string") == false) goto L23;
        return true;
    L21:
        if (r1.equals("number") == false) goto L23;
        return true;
    L23:
        ((List) this.h.getValue()).add(r5);
        return false;
    L25:
        return true;
    }

    public final void h(boolean r4) {
        Uri r0 = this.a;
        if (r0 == null) goto L10;
        t1 r1 = new t1();
        if (r4 == false) goto L7;
        r1.f("is_ec_open", "1");
    L8:
        r1.f("room_id", UriProtector.getQueryParameter(r0, "room_id"));
        r1.f("anchor_id", UriProtector.getQueryParameter(r0, "anchor_id"));
        r1.f("enter_from_merge", UriProtector.getQueryParameter(r0, "enter_from_merge"));
        r1.f("enter_method", UriProtector.getQueryParameter(r0, "enter_method"));
        r1.f("ecom_live_params", UriProtector.getQueryParameter(r0, "ecom_live_params"));
        r1.f("host", r0.getHost());
        r1.k();
        return;
    L7:
        r1.f("is_ec_open", BDLocationException.ERROR_TIMEOUT);
        goto L8
    }

    public final String i(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        String r1 = j(true);
        if ((!StringsKt.isBlank(r1)) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L9;
        h(true);
        Handler r0 = k.a;
        f.b(r4, r1);
        return r1;
    L9:
        return "";
    }

    public final String j(boolean r19) {
        String r0 = this.b;
        if (r0 != null) goto L81;
    L9:
        Uri r1 = this.a;
        if (r1 != null) goto L83;
    L15:
        UtilityKotlinExtentionsKt.f(this.a, this.c, new ECLiveSchemaBuilder$realAddQuery$1(this));
        Uri r3 = this.a;
        if (r3 == null) goto L71;
        UrlBuilderV2 r4 = new UrlBuilderV2(r3);
        if (EComABUtils.liveFixExtraBusinessParamsSourceList().contains(r4.getQuery("enter_from_merge") + "_temai_" + r4.getQuery("enter_method")) == true) goto L71;
        JSONObject r5 = z1.g(r4.getQuery("ecom_live_params"));
        if (r5 == null) goto L71;
        JSONObject r7 = z1.g(r5.optString("pass_through_log_data"));
        if (r7 == null) goto L71;
        String r2 = r7.optString("creative_id");
        String r10 = r7.optString("log_extra");
        String r12 = r7.optString("search_params");
        String r14 = r7.optString("request_id");
        String r6 = r7.optString("live_recommend_info");
        JSONObject r8 = new JSONObject();
        r7.remove("creative_id");
        if (com.bytedance.android.shopping.extensions.k.c(r2) == true) goto L29;
    L36:
        r7.remove("log_extra");
        if (com.bytedance.android.shopping.extensions.k.c(r10) == true) goto L39;
    L46:
        r7.remove("search_params");
        if (com.bytedance.android.shopping.extensions.k.c(r12) == true) goto L49;
    L52:
        r7.remove("request_id");
        if (com.bytedance.android.shopping.extensions.k.c(r14) == true) goto L55;
    L58:
        r7.remove("live_recommend_info");
        if (com.bytedance.android.shopping.extensions.k.c(r6) == true) goto L61;
    L77:
        r5.put("pass_through_log_data", r7.toString());     // Catch: JSONException -> L68
        if (r8.length() <= 0) goto L70;
        r5.put("tmp_log_extra_for_inner", r8.toString());     // Catch: JSONException -> L68
    L70:
        r4.addOrReplaceParam("ecom_live_params", r5.toString());
        Uri r9 = r4.buildUri();
        this.e.a("ec enter room checkAndFixPassThroughLogDataParams origin:" + r3 + " result:" + r9);
        Unit r11 = Unit.INSTANCE;
        this.a = r9;
    L68:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L70
    L61:
        if (com.bytedance.android.shopping.extensions.k.c(r4.getQuery("live_recommend_info")) == false) goto L63;
        ((List) this.j.getValue()).add("live_recommend_info");
        goto L77
    L63:
        r4.addOrReplaceParam("live_recommend_info", r6);
        ((List) this.k.getValue()).add("live_recommend_info");
        goto L77
    L55:
        if (com.bytedance.android.shopping.extensions.k.c(r4.getQuery("request_id")) == false) goto L57;
        ((List) this.j.getValue()).add("request_id");
        goto L58
    L57:
        r4.addOrReplaceParam("request_id", r14);
        ((List) this.k.getValue()).add("request_id");
        goto L58
    L49:
        if (com.bytedance.android.shopping.extensions.k.c(r4.getQuery("live_recommend_info")) == false) goto L51;
        ((List) this.j.getValue()).add("search_params");
        goto L52
    L51:
        r4.addOrReplaceParam("search_params", r12);
        ((List) this.k.getValue()).add("search_params");
        goto L52
    L39:
        if (com.bytedance.android.shopping.extensions.k.c(r4.getQuery("log_extra")) == false) goto L79;
        ((List) this.j.getValue()).add("log_extra");
        goto L46
    L79:
        r8.put("log_extra", r10);     // Catch: JSONException -> L43
    L45:
        ((List) this.k.getValue()).add("log_extra");
    L43:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L45
    L29:
        if (com.bytedance.android.shopping.extensions.k.c(r4.getQuery("creative_id")) == false) goto L85;
        ((List) this.j.getValue()).add("creative_id");
        goto L36
    L85:
        r8.put("creative_id", r2);     // Catch: JSONException -> L33
    L35:
        ((List) this.k.getValue()).add("creative_id");
    L33:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L71:
        Uri r13 = this.a;
        if (r13 == null) goto L75;
        String r15 = r13.toString();
        if (r15 == null) goto L75;
        return r15;
    L75:
        return "";
    L83:
        this.a = l0.t(this.a, "ecom_live_params", k(z1.f(UriProtector.getQueryParameter(r1, "ecom_live_params")), this.d, r19).toString());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L15
    L81:
        Uri r16 = UriProtector.parse(r0);     // Catch: Exception -> L6
    L8:
        this.a = r16;
    L6:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r16 = null;
        goto L8
    }

    public final void b(JSONObject r9, boolean r10) {
        if (r10 == false) goto L5;
        r9.put("is_ec_open", "1");
        long r1 = System.currentTimeMillis();
        r9.put("ec_room_enter_start_time", r1);
        l.put(String.valueOf(r1), r9.toString());
    L6:
        r9.put("ec_room_enter", "1");
        if (ECAppInfoService.e.i() == false) goto L49;
        StringBuilder r11 = new StringBuilder();
        boolean r2 = true;
        if ((!((List) this.h.getValue()).isEmpty()) == false) goto L23;
        r11.append("ecom_live_params中有错误的参数：");
        Iterator r0 = ((List) this.h.getValue()).iterator();
        int r5 = 0;
    L12:
        if (r0.hasNext() == false) goto L21;
        Object r6 = r0.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        r11.append((String) r6);
        if (r5 == (((List) this.h.getValue()).size() - 1)) goto L19;
        r11.append("、");
    L20:
        r5 = r7;
        goto L12
    L19:
        r11.append("\n");
        goto L20
    L21:
        ((List) this.h.getValue()).clear();
    L23:
        if ((!((List) this.i.getValue()).isEmpty()) == false) goto L37;
        r11.append("pass_through_log_data中有错误的参数：");
        Iterator r3 = ((List) this.i.getValue()).iterator();
        int r8 = 0;
    L26:
        if (r3.hasNext() == false) goto L35;
        Object r12 = r3.next();
        int r13 = r8 + 1;
        if (r8 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        r11.append((String) r12);
        if (r8 == (((List) this.i.getValue()).size() - 1)) goto L33;
        r11.append("、");
    L34:
        r8 = r13;
        goto L26
    L33:
        r11.append("\n");
        goto L34
    L35:
        ((List) this.i.getValue()).clear();
    L37:
        if (r11.length() > 0) goto L40;
        r2 = false;
    L40:
        if (r2 == false) goto L50;
        r11.append("这些参数不应该存在，问题咨询 seven.zeng");
        r9.put(LocationMonitorConst.ERROR_MSG, r11.toString());
        return;
    L50:
        return;
    L49:
        return;
    L5:
        r9.put("is_ec_open", BDLocationException.ERROR_TIMEOUT);
        goto L6
    }

    public final JSONObject e(JSONObject r5, Bundle r6) {
        if (EComABUtils.liveRemoveSesitiveParamsDisableSourcePageList().contains(r6.getString("enter_from_merge") + "_temai_" + r6.getString("enter_method")) == false) goto L5;
        return r5;
    L5:
        String r0 = r5.optString("pass_through_log_data");
        this.e.a("ec hook enter room remove pass_through_log_data origin: " + r0);
        JSONObject r1 = z1.g(r0);
        if (r1 == null) goto L19;
        Iterator<T> r2 = EComABUtils.liveRemoveSesitiveParamsList().iterator();
        boolean r3 = false;
    L9:
        if (r2.hasNext() == false) goto L13;
        if (r1.remove((String) r2.next()) == null) goto L9;
        r3 = true;
        goto L9
    L13:
        if (r3 == false) goto L19;
        r5 = x0.a(r5);
        String r4 = r1.toString();     // Catch: JSONException -> L17
        this.e.a("ec hook enter room remove pass_through_log_data ec params result: " + r4);     // Catch: JSONException -> L17
        Unit r7 = Unit.INSTANCE;     // Catch: JSONException -> L17
        r5.put("pass_through_log_data", r4);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L19:
        return r5;
    }

    public final void g(final String r6, final Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "ecomLiveParams");
        Intrinsics.checkNotNullParameter(r7, "bundle");
        l.a(new ECLiveSchemaBuilder$hookECOMLiveParams$1(r6, r7));
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return;
    L5:
        if (EComABUtils.getEnterRoomParamsHook() == false) goto L18;
        JSONObject r2 = new JSONObject(r6);     // Catch: Exception -> L14
        if (Intrinsics.areEqual(r2.optString("is_ec_open"), "1") == false) goto L10;
        b(r2, true);     // Catch: Exception -> L14
    L11:
        r6 = e(r2, r7).toString();     // Catch: Exception -> L14
        goto L12
    L10:
        r2 = k(r2, null, true);     // Catch: Exception -> L14
    L12:
        r7.putString("ecom_live_params", r6);
        t1 r3 = new t1();
        r3.f("is_ec_open", "1");
        r3.f("enter_from_merge", r7.getString("enter_from_merge"));
        r3.f("enter_method", r7.getString("enter_method"));
        r3.f("ecom_live_params", r6);
        r3.k();
        return;
    }

    public final JSONObject k(JSONObject r11, Map<String, String> r12, boolean r13) {
        JSONObject r0 = new JSONObject();
        if (r12 == null) goto L28;
        Iterator<Map.Entry<String, String>> r14 = r12.entrySet().iterator();
    L6:
        if (r14.hasNext() == false) goto L28;
        Map.Entry<String, String> r3 = r14.next();
        String r4 = r3.getValue();
        String r5 = r3.getKey();
        String r6 = r3.getValue();
        if (f(r5) == false) goto L6;
        String r7 = r11.optString(r3.getKey());
        if (Intrinsics.areEqual("multi_room_data", r3.getKey()) == false) goto L13;
    L14:
        JSONObject r8 = z1.g(r4);
        if (r8 == null) goto L27;
        JSONObject r9 = z1.g(r7);
        if (r9 == null) goto L27;
        JSONObject r10 = new JSONObject();
        Iterator<String> r15 = r8.keys();
    L20:
        if (r15.hasNext() == false) goto L22;
        String r16 = r15.next();
        r10.put(r16, r8.optString(r16));
        r9.remove(r16);
        goto L20
    L22:
        Iterator<String> r17 = r9.keys();
    L24:
        if (r17.hasNext() == false) goto L26;
        String r18 = r17.next();
        r10.put(r18, r9.optString(r18));
        goto L24
    L26:
        r4 = r10.toString();
    L27:
        r0.put(r3.getKey(), r4);
        r11.remove(r3.getKey());
        goto L6
    L13:
        if (Intrinsics.areEqual("pass_through_log_data", r3.getKey()) == false) goto L27;
    L28:
        Iterator<String> r19 = r11.keys();
    L30:
        if (r19.hasNext() == false) goto L36;
        String r20 = r19.next();
        Object r21 = r11.optString(r20);
        if (f(r20) == false) goto L30;
        r0.put(r20, r21);
        goto L30
    L36:
        if (EComABUtils.getEnterRoomParamsHook() == false) goto L49;
        JSONObject r110 = z1.g(r0.optString("multi_room_data"));
        if (r110 == null) goto L49;
        JSONObject r111 = new JSONObject();
        Iterator<String> r22 = r110.keys();
    L42:
        if (r22.hasNext() == false) goto L47;
        String r23 = r22.next();
        String r24 = r110.optString(r23);
        if (f(r23) == false) goto L42;
        r111.put(r23, r24);
        goto L42
    L47:
        r0.put("multi_room_data", r111);
    L49:
        if (ECAppInfoService.e.i() == true) goto L51;
    L66:
        b(r0, r13);
        return r0;
    L51:
        if (((List) this.g.getValue()).isEmpty() == true) goto L66;
        if (EComABUtils.getEnterRoomParamsHook() == false) goto L66;
        JSONObject r112 = z1.g(r0.optString("pass_through_log_data"));
        if (r112 == null) goto L66;
        JSONObject r113 = new JSONObject();
        Iterator<String> r2 = r112.keys();
    L60:
        if (r2.hasNext() == false) goto L65;
        String r25 = r2.next();
        if (((List) this.g.getValue()).contains(r25) == false) goto L64;
        ((List) this.i.getValue()).add(r25);
    L64:
        r113.put(r25, r112.opt(r25));
        goto L60
    L65:
        r0.put("pass_through_log_data", r113);
        goto L66
    }
}
