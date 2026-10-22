package com.bytedance.android.livesdk.livecommerce.event;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.ExtraController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.EnumEntranceInfoScene;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECEventUtilsV2 {
    public static final Lazy a = null;
    public static final ECEventUtilsV2 b = null;

    public ECEventUtilsV2() {
    }

    static {
        b = new ECEventUtilsV2();
        a = LazyKt.lazy(ECEventUtilsV2$AD_ENTER_FROM_MERGE_PATTERN$2.INSTANCE);
    }

    @Deprecated(message = "减少使用单例获取直播间参数, 改为LiveRoomParams.getEntranceInfo()")
    public static String a(String r6) {
        return b(r6, l0.g(), l0.o(), null, null, null);
    }

    public static JSONObject d(Map r6) {
        Intrinsics.checkNotNullParameter(r6, "reportParams");
        JSONObject r2 = new JSONObject();
        String r3 = (String) r6.get("enter_from_merge");
        String r4 = (String) r6.get("is_other_channel");
        r2.put("room_id", r6.get("room_id"));     // Catch: Exception -> L25
        r2.put("author_id", r6.get("anchor_id"));     // Catch: Exception -> L25
        r2.put("chnid", r3);     // Catch: Exception -> L25
        r2.put("request_id", r6.get("request_id"));     // Catch: Exception -> L25
        String r7 = (String) r6.get("creative_id");     // Catch: Exception -> L25
        if (r7 != null) goto L6;
        r7 = "";
    L6:
        r2.put("cid", r7);     // Catch: Exception -> L25
        b.getClass();     // Catch: Exception -> L25
        boolean r0 = false;
        boolean r1 = ((Pattern) a.getValue()).matcher(r3).matches();     // Catch: Exception -> L10
    L11:
        if (r3 == null) goto L16;
        if (r1 == false) goto L14;
    L19:
        r0 = true;
    L20:
        if (r0 == false) goto L22;
        String r5 = "1";
    L23:
        r2.put("is_from_ad", r5);     // Catch: Exception -> L25
    L27:
        return r2;
    L22:
        r5 = BDLocationException.ERROR_TIMEOUT;
        goto L23
    L14:
        if (Intrinsics.areEqual(r3, "topview") == true) goto L19;
    L16:
        if (Intrinsics.areEqual("effective_ad", r4) == true) goto L19;
        if (Intrinsics.areEqual("dou_plus", r4) == false) goto L20;
    L10:
        r1 = false;
    L25:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L27
    }

    @Deprecated(message = "减少使用单例获取直播间参数, 改为LiveRoomParams.getEntranceInfo()")
    public static String e(String r3) {
        PromotionListController.T.getClass();
        PromotionListController r0 = PromotionListController.a.a();
        if (r0.x() == false) goto L5;
        LivePromotionListFragment r1 = r0.c;
    L6:
        if (r1 == null) goto L10;
        ECEventUtilsV2 r2 = b;
        String r4 = r1.ca0();
        r2.getClass();
        String r5 = c(r2, r3, r4, l0.a);
        if (r5 == null) goto L10;
        return r5;
    L10:
        return a(r3);
    L5:
        r1 = null;
        goto L6
    }

    @Deprecated(message = "减少使用单例获取直播间参数, 改为LiveRoomParams.getEntranceInfo()")
    public static JSONObject f(String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "carrierType");
        HashMap<String, String> r0 = l0.g();
        HashMap<String, String> r1 = l0.o();
        int r2 = RoomContextController.h;
        RoomContextController r3 = RoomContextController.a.a();
        JSONObject r4 = new JSONObject();
        Iterator<T> r5 = r0.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L53;
        Map.Entry r6 = (Map.Entry) r5.next();
        r4.put((String) r6.getKey(), r6.getValue());
        goto L4
    L53:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L19
        if (r10 == null) goto L16;
        JSONObject r11 = com.bytedance.android.ec.core.utils.z1.g(r10);     // Catch: Throwable -> L19
        if (r11 == null) goto L16;
        Iterator<String> r12 = r11.keys();     // Catch: Throwable -> L19
    L13:
        if (r12.hasNext() == false) goto L15;
        String r13 = r12.next();     // Catch: Throwable -> L19
        r4.put(r13, r11.opt(r13));     // Catch: Throwable -> L19
        goto L13
    L15:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Result.constructor-impl(r14);     // Catch: Throwable -> L19
    L21:
        r4.put("enter_from", "live");
        StringBuilder r15 = new StringBuilder();
        String r16 = r0.get("enter_from_merge");
        String r17 = "";
        if (r16 != null) goto L24;
        r16 = "";
    L24:
        r15.append(r16);
        r15.append("_temai_");
        String r18 = r0.get("enter_method");
        if (r18 == null) goto L28;
        r17 = r18;
    L28:
        r15.append(r17);
        r4.put("category_name", r15.toString());
        Iterator<T> r19 = r1.entrySet().iterator();
    L30:
        if (r19.hasNext() == false) goto L33;
        Map.Entry r20 = (Map.Entry) r19.next();
        r4.put((String) r20.getKey(), r20.getValue());
        goto L30
    L33:
        if (TextUtils.isEmpty(r8) == true) goto L35;
        r4.put("carrier_type", r8);
    L35:
        if (r9 == null) goto L37;
        r4.put("live_list_channel", r9);
    L37:
        l0.q(r4);
        r4.put("display_room_id", r3.B());
        r4.put("display_anchor_id", r3.y());
        r4.put("display_sec_anchor_id", r3.z());
        r4.put("display_follow_status", r3.K().get("follow_status"));
        int r21 = com.bytedance.android.livesdk.livecommerce.room.controller.w.h;
        r4.put("ecom_scene_id", com.bytedance.android.livesdk.livecommerce.room.controller.w.a.b());
        com.bytedance.android.ec.model.response.n1 r22 = r3.f;
        if (r22 == null) goto L42;
        List r23 = r22.a();
        if (r23 == null) goto L42;
        int r24 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        r4.put("ecom_linkmic_room_ids", GsonProtectorUtils.toJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r23));
    L42:
        Lazy r25 = ExtraController.l;
        ExtraController r26 = ControllerCenter.c(null, null).u;
        Objects.toString(r26);
        JSONObject r27 = r26.H();
        if (r27 == null) goto L52;
        Iterator<String> r28 = r27.keys();
    L46:
        if (r28.hasNext() == false) goto L52;
        String r110 = r28.next();
        r4.put(r110, r27.optString(r110));     // Catch: JSONException -> L50
    L50:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L52:
        return r4;
    L16:
        r14 = null;
    L19:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    public static String c(ECEventUtilsV2 r6, String r7, String r8, String r9) {
        r6.getClass();
        return b(r7, l0.g(), l0.o(), r8, r9, null);
    }

    public static String b(final String r31, final Map r32, final Map r33, final String r34, final String r35, final String r36) {
        Intrinsics.checkNotNullParameter(r33, "params");
        int r0 = com.bytedance.android.livesdk.livecommerce.utils.q.a;     // Catch: Exception -> L130
        gl.a r12 = com.bytedance.android.livesdk.livecommerce.utils.q.a(EnumEntranceInfoScene.ECOM_LIVE_REQUEST, null);     // Catch: Exception -> L130
        if (r32 == null) goto L13;
        String r1 = (String) r32.get("enter_from_merge");     // Catch: Exception -> L130
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        String r2 = (String) r32.get("enter_method");     // Catch: Exception -> L130
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        String r15 = r1;
        String r7 = r2;
    L15:
        if (r12 == null) goto L43;
        Pair[] r3 = new Pair[8];     // Catch: Exception -> L130
        r3[0] = TuplesKt.to("enter_from_merge", r15);     // Catch: Exception -> L130
        r3[1] = TuplesKt.to("enter_method", r7);     // Catch: Exception -> L130
        if (r32 == null) goto L19;
        String r5 = (String) r32.get("action_type");     // Catch: Exception -> L130
    L20:
        r3[2] = TuplesKt.to("action_type", r5);     // Catch: Exception -> L130
        if (r32 == null) goto L23;
        String r6 = (String) r32.get("creative_id");     // Catch: Exception -> L130
    L24:
        r3[3] = TuplesKt.to("creative_id", r6);     // Catch: Exception -> L130
        if (r32 == null) goto L27;
        String r8 = (String) r32.get("is_other_channel");     // Catch: Exception -> L130
    L28:
        r3[4] = TuplesKt.to("is_other_channel", r8);     // Catch: Exception -> L130
        if (r32 == null) goto L31;
        String r9 = (String) r32.get("enter_from");     // Catch: Exception -> L130
    L32:
        r3[5] = TuplesKt.to("enter_from", r9);     // Catch: Exception -> L130
        if (r32 == null) goto L35;
        String r10 = (String) r32.get("coupon_category");     // Catch: Exception -> L130
    L36:
        r3[6] = TuplesKt.to("coupon_category", r10);     // Catch: Exception -> L130
        if (r32 == null) goto L39;
        String r11 = (String) r32.get("subsidized_activity");     // Catch: Exception -> L130
    L40:
        r3[7] = TuplesKt.to("subsidized_activity", r11);     // Catch: Exception -> L130
        String r25 = "";
        String r27 = "subsidized_activity";
        String r28 = "coupon_category";
        String r24 = "is_other_channel";
        int r13 = 1;
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r12, r3, new ECEventUtilsV2$getEntranceInfo$$inlined$run$lambda$1(r32, r35, r31, r33, r34, r36));     // Catch: Exception -> L52
    L44:
        if (r12 == null) goto L144;
        Pair[] r4 = new Pair[r13];     // Catch: Exception -> L52
        if (r32 == null) goto L49;
        String r14 = (String) r32.get("request_id");     // Catch: Exception -> L52
    L50:
        r4[0] = TuplesKt.to("request_id", r14);     // Catch: Exception -> L52
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r12, r4, new ECEventUtilsV2$getEntranceInfo$$inlined$run$lambda$2(r32, r35, r31, r33, r34, r36));     // Catch: Exception -> L52
        goto L144
    L49:
        r14 = null;
    L144:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L107
        if (r35 == null) goto L57;
        final JSONObject r17 = com.bytedance.android.ec.core.utils.z1.g(r35);     // Catch: Throwable -> L107
    L58:
        if (r12 == null) goto L102;
        Pair[] r18 = new Pair[8];     // Catch: Throwable -> L107
        if (r17 == null) goto L62;
        String r19 = r17.optString("enter_from_merge");     // Catch: Throwable -> L107
    L63:
        r18[0] = TuplesKt.to("enter_from_merge", r19);     // Catch: Throwable -> L107
        if (r17 == null) goto L66;
        String r20 = r17.optString("enter_method");     // Catch: Throwable -> L107
    L67:
        r18[r13] = TuplesKt.to("enter_method", r20);     // Catch: Throwable -> L107
        if (r17 == null) goto L70;
        String r21 = r17.optString("action_type");     // Catch: Throwable -> L107
    L71:
        r18[2] = TuplesKt.to(r4, r21);     // Catch: Throwable -> L107
        if (r17 == null) goto L74;
        String r22 = r17.optString("creative_id");     // Catch: Throwable -> L107
    L75:
        r18[3] = TuplesKt.to("creative_id", r22);     // Catch: Throwable -> L107
        if (r17 == null) goto L81;
        String r23 = r24;
        String r26 = r17.optString(r23);     // Catch: Throwable -> L79
    L82:
        r18[4] = TuplesKt.to(r23, r26);     // Catch: Throwable -> L79
        if (r17 == null) goto L88;
        String r29 = "enter_from";
        String r30 = r17.optString(r29);     // Catch: Throwable -> L86
    L89:
        r18[5] = TuplesKt.to(r29, r30);     // Catch: Throwable -> L86
        if (r17 == null) goto L95;
        String r37 = r28;
        String r38 = r17.optString(r37);     // Catch: Throwable -> L93
    L96:
        r18[6] = TuplesKt.to(r37, r38);     // Catch: Throwable -> L93
        if (r17 == null) goto L100;
        String r39 = r27;
        String r40 = r17.optString(r39);     // Catch: Throwable -> L105
    L101:
        r18[7] = TuplesKt.to(r39, r40);     // Catch: Throwable -> L105
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r12, r18, new ECEventUtilsV2$getEntranceInfo$entranceInfoStr$1$4$1(r17));     // Catch: Throwable -> L105
        Unit r41 = Unit.INSTANCE;     // Catch: Throwable -> L105
    L103:
        Result.constructor-impl(r41);     // Catch: Throwable -> L105
    L110:
        if (r12 == null) goto L113;
        Pair[] r42 = new Pair[3];     // Catch: Exception -> L52
        r42[0] = TuplesKt.to(r29, "live");     // Catch: Exception -> L52
        r42[r13] = TuplesKt.to("category_name", r15 + "_temai_" + r7);     // Catch: Exception -> L52
        r42[2] = TuplesKt.to("carrier_type", r31);     // Catch: Exception -> L52
        r12.g(r42);     // Catch: Exception -> L52
    L113:
        if (r12 == null) goto L115;
        Pair[] r43 = new Pair[8];     // Catch: Exception -> L52
        Object r44 = r37;
        r43[0] = TuplesKt.to("enter_from_merge", r33.get("enter_from_merge"));     // Catch: Exception -> L52
        r43[r13] = TuplesKt.to("enter_method", r33.get("enter_method"));     // Catch: Exception -> L52
        r43[2] = TuplesKt.to(r4, r33.get(r4));     // Catch: Exception -> L52
        r43[3] = TuplesKt.to("creative_id", r33.get("creative_id"));     // Catch: Exception -> L52
        r43[4] = TuplesKt.to(r23, r33.get(r23));     // Catch: Exception -> L52
        r43[5] = TuplesKt.to(r29, r33.get(r29));     // Catch: Exception -> L52
        r43[6] = TuplesKt.to(r44, r33.get(r44));     // Catch: Exception -> L52
        r43[7] = TuplesKt.to(r39, r33.get(r39));     // Catch: Exception -> L52
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r12, r43, new ECEventUtilsV2$getEntranceInfo$$inlined$run$lambda$3(r32, r35, r31, r33, r34, r36));     // Catch: Exception -> L52
    L115:
        if (r12 == null) goto L117;
        Pair[] r45 = new Pair[r13];     // Catch: Exception -> L52
        r45[0] = TuplesKt.to("live_list_channel", r34);     // Catch: Exception -> L52
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r12, r45, ECEventUtilsV2$getEntranceInfo$entranceInfoStr$1$6.INSTANCE);     // Catch: Exception -> L52
    L117:
        if (r12 == null) goto L122;
        Pair[] r46 = new Pair[r13];     // Catch: Exception -> L52
        String r47 = com.bytedance.android.ec.core.utils.a2.d(r36);     // Catch: Exception -> L52
        if (r47 != null) goto L121;
        int r48 = com.bytedance.android.livesdk.livecommerce.room.controller.w.h;     // Catch: Exception -> L52
        r47 = com.bytedance.android.livesdk.livecommerce.room.controller.w.a.b();     // Catch: Exception -> L52
    L121:
        r46[0] = TuplesKt.to("ecom_scene_id", r47);     // Catch: Exception -> L52
        r12.g(r46);     // Catch: Exception -> L52
    L122:
        if (r12 == null) goto L124;
        String r49 = r12.h();     // Catch: Exception -> L52
    L125:
        if (r49 == null) goto L127;
        com.bytedance.android.livesdk.livecommerce.utils.s.c(r49, EnumEntranceInfoScene.ECOM_LIVE_REQUEST);     // Catch: Exception -> L52
        String r110 = r49;
    L128:
        return Uri.encode(r110);
    L127:
        r110 = null;
        goto L128
    L124:
        r49 = null;
    L105:
        th = th;
    L109:
        Result.Companion r50 = Result.Companion;     // Catch: Exception -> L52
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L52
        goto L110
    L100:
        r39 = r27;
        r40 = null;
    L93:
        th = th;
        r39 = r27;
        goto L109
    L95:
        r37 = r28;
        r38 = null;
    L86:
        th = th;
        r39 = r27;
        r37 = r28;
        goto L109
    L88:
        r29 = r6;
        r30 = null;
    L79:
        th = th;
    L80:
        r39 = r27;
        r37 = r28;
        r29 = r6;
        goto L109
    L81:
        r23 = r24;
        r26 = null;
        goto L82
    L74:
        r22 = null;
        goto L75
    L70:
        r21 = null;
        goto L71
    L66:
        r20 = null;
        goto L67
    L62:
        r19 = null;
        goto L63
    L102:
        r23 = r24;
        r39 = r27;
        r37 = r28;
        r29 = r6;
        r41 = null;
        goto L103
    L57:
        r17 = null;
    L107:
        th = th;
        r23 = r24;
    L52:
        e = e;
    L132:
        ECExceptionMonitor.e(e);
        return r25;
    L39:
        r11 = null;
        goto L40
    L35:
        r10 = null;
        goto L36
    L31:
        r9 = null;
        goto L32
    L27:
        r8 = null;
        goto L28
    L23:
        r6 = null;
        goto L24
    L19:
        r5 = null;
        goto L20
    L43:
        r24 = "is_other_channel";
        r28 = "coupon_category";
        r27 = "subsidized_activity";
        r25 = "";
        r13 = 1;
        goto L44
    L13:
        r7 = "";
        r15 = r7;
    L130:
        e = e;
        r25 = "";
        goto L132
    }
}
