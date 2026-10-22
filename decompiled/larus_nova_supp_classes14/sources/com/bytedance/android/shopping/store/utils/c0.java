package com.bytedance.android.shopping.store.utils;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c0 {
    public static final c0 a = null;

    public c0() {
    }

    static {
        a = new c0();
    }

    public static String a(String r16, String r17, String r18, String r19, String r20, FragmentActivity r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r17, "method");
        if (r16 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        Object r6 = null;
        if (r5 == false) goto L12;
        return null;
    L12:
        HashMap r7 = new HashMap();
        Uri r8 = UriProtector.parse(r16);
        Iterator r9 = UriProtector.getQueryParameterNames(r8).iterator();
    L14:
        if (r9.hasNext() == false) goto L20;
        String r10 = (String) r9.next();
        String r11 = UriProtector.getQueryParameter(r8, r10);
        if (r11 == null) goto L14;
        String r12 = a2.d(r11);
        if (r12 == null) goto L14;
        r7.put(r10, r12);
        goto L14
    L20:
        r7.put("channel_id", "1111836");
        r7.put("list_entrance", "store_rec_inner");
        r7.put("enter_from_merge", "store_page");
        r7.put("req_from", "store_rec_inner");
        r7.put("enter_method", r17);
        r7.put("search_params", r18);
        String r0 = (String) r7.get("ecom_live_params");
        if (r19 != null) goto L23;
    L26:
        boolean r13 = true;
    L28:
        if (r13 == true) goto L97;
        JSONObject r14 = com.bytedance.android.shopping.extensions.k.u(r19);
        hm.c.c(r14, r21);
        r14.remove(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
        r14.remove("search_params");
        if (r0 != null) goto L33;
    L36:
        boolean r15 = true;
    L38:
        if (r15 == false) goto L130;
        r7.put("ecom_live_params", JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[]{JsonDslUtilKt.d("pass_through_log_data", r14.toString())}).toString());
        goto L97
    L130:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L42
        Object r1 = Result.constructor-impl((JsonObject) u0.b(r0, JsonObject.class));     // Catch: Throwable -> L42
    L45:
        if (Result.isFailure-impl(r1) == false) goto L47;
        r1 = null;
    L47:
        JsonObject r111 = (JsonObject) r1;
        if (r111 == null) goto L97;
        JsonPrimitive r2 = r111.get("pass_through_log_data");
        if ((r2 instanceof JsonPrimitive) == false) goto L95;
        JsonPrimitive r3 = r2;
        if (r3.isString() == false) goto L95;
        c0 r112 = a;
        String r4 = r3.getAsString();
        r112.getClass();
        if (r19 != null) goto L56;
    L59:
        boolean r113 = true;
    L60:
        if (r113 == false) goto L73;
        if (r4 != null) goto L63;
    L66:
        boolean r23 = true;
    L68:
        if ((!r23) == true) goto L71;
        r4 = null;
    L71:
        if (r4 != null) goto L94;
        r4 = "{}";
    L94:
        JSONObject r24 = com.bytedance.android.shopping.extensions.k.u(r4);
        hm.c.c(r24, r21);
        r24.remove(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
        r24.remove("search_params");
        Unit r25 = Unit.INSTANCE;
        String r26 = r24.toString();
    L96:
        r111.addProperty("pass_through_log_data", r26);
        r7.put("ecom_live_params", u0.d(r111));
        goto L97
    L63:
        if (StringsKt.isBlank(r4) == true) goto L66;
        r23 = false;
        goto L68
    L73:
        if (r4 != null) goto L75;
    L78:
        boolean r114 = true;
    L79:
        if (r114 == false) goto L134;
        r4 = r19;
        goto L94
    L134:
        JsonObject r115 = (JsonObject) u0.b(r19, JsonObject.class);     // Catch: Throwable -> L87
        JsonObject r27 = (JsonObject) u0.b(r4, JsonObject.class);     // Catch: Throwable -> L87
        Iterator r116 = r115.entrySet().iterator();     // Catch: Throwable -> L87
    L83:
        if (r116.hasNext() == false) goto L85;
        Map.Entry r117 = (Map.Entry) r116.next();     // Catch: Throwable -> L87
        r27.add((String) r117.getKey(), (JsonElement) r117.getValue());     // Catch: Throwable -> L87
        goto L83
    L85:
        Object r28 = Result.constructor-impl(u0.d(r27));     // Catch: Throwable -> L87
    L90:
        if (Result.exceptionOrNull-impl(r28) == null) goto L93;
        r28 = r19;
    L93:
        r4 = (String) r28;
    L87:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L90
    L75:
        if (StringsKt.isBlank(r4) == true) goto L78;
        r114 = false;
        goto L79
    L56:
        if (StringsKt.isBlank(r19) == true) goto L59;
        r113 = false;
    L95:
        r26 = r14.toString();
    L42:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L33:
        if (StringsKt.isBlank(r0) == true) goto L36;
        r15 = false;
    L97:
        if (r22 == true) goto L132;
    L110:
        Uri.Builder r29 = r8.buildUpon().clearQuery();
        Iterator r30 = r7.entrySet().iterator();
    L112:
        if (r30.hasNext() == false) goto L123;
        Map.Entry r31 = (Map.Entry) r30.next();
        String r32 = (String) r31.getKey();
        String r33 = (String) r31.getValue();
        if ((!StringsKt.isBlank(r32)) == false) goto L112;
        if (r33 != null) goto L117;
    L120:
        boolean r34 = true;
    L121:
        if (r34 == true) goto L112;
        r29.appendQueryParameter(r32, r33);
        goto L112
    L117:
        if (StringsKt.isBlank(r33) == true) goto L120;
        r34 = false;
        goto L121
    L123:
        String r35 = r29.toString();
        boolean r36 = ECServiceManager.a;
        hf.a r37 = ((cf.l) ECServiceManager.c(cf.l.class)).Ja();
        if (r37 == null) goto L151;
        r37.a(r35);
        String r38 = r37.build();
        if (r38 != null) goto L129;
        return r35;
    L129:
        return r38;
    L151:
        return r35;
    L132:
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L100
        Object r40 = Result.constructor-impl((JsonObject) u0.b((String) r7.get("ecom_live_params"), JsonObject.class));     // Catch: Throwable -> L100
    L103:
        if (Result.isFailure-impl(r40) == true) goto L106;
        r6 = r40;
    L106:
        JsonObject r41 = (JsonObject) r6;
        if (r41 == null) goto L110;
        if (r20 == null) goto L110;
        r41.addProperty("multi_room_data", JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[]{JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, com.bytedance.android.shopping.extensions.k.u(r20).optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID))}).toString());
        r7.put("ecom_live_params", u0.d(r41));
    L100:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L103
    L23:
        if (StringsKt.isBlank(r19) == true) goto L26;
        r13 = false;
        goto L28
    L5:
        if (StringsKt.isBlank(r16) == true) goto L8;
        r5 = false;
        goto L9
    }

    public static String b(c0 r8, String r9, String r10, boolean r11, String r12, String r13, String r14, String r15, String r16, FragmentActivity r17) {
        String r0 = r9;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r10, "method");
        if (r11 == false) goto L17;
        if (r0 == null) goto L15;
        Pair[] r1 = new Pair[4];
        r1[0] = TuplesKt.to("is_ec_shopping", CommentScene.COMMENTSCENE_NO_AWEME);
        String r3 = "";
        if (r12 != null) goto L9;
        String r5 = "";
    L10:
        r1[1] = TuplesKt.to("share_content", r5);
        if (r13 == null) goto L14;
        r3 = r13;
    L14:
        r1[2] = TuplesKt.to("share_object", r3);
        r1[3] = TuplesKt.to("pass_through_log_data", JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[]{JsonDslUtilKt.d("product_source_page", "share_alert")}).toString());
        r0 = l0.b(r9, r1);
        goto L17
    L9:
        r5 = r12;
        goto L10
    L15:
        r0 = null;
    L17:
        return a(r0, r10, r14, r15, r16, r17, true);
    }
}
