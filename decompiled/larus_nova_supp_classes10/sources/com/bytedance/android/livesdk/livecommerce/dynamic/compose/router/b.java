package com.bytedance.android.livesdk.livecommerce.dynamic.compose.router;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cf.l;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.f;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import jf.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import w83.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements h {
    public String a;

    public b() {
    }

    public final void c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Object r3 = r2.getTag(2131370714);
        if ((r3 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.b) == true) goto L5;
        r3 = null;
    L5:
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r4 = (com.bytedance.android.livesdk.livecommerce.promotion.card.b) r3;
        if (r4 == null) goto L9;
        r4.release();
        return;
    }

    public final void d(View r17, ll.a r18) {
        Intrinsics.checkNotNullParameter(r17, "view");
        Intrinsics.checkNotNullParameter(r18, "data");
        if ((r17 instanceof ViewGroup) == true) goto L5;
        View r3 = null;
    L6:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 != null) goto L9;
        return;
    L9:
        JSONObject r5 = z1.g(r18.c());
        if (r5 != null) goto L13;
        return;
    L13:
        if (r4.getChildCount() != 0) goto L18;
        View r0 = e(r4, r18);
        if (r0 == null) goto L91;
        r4.addView(r0);
        return;
    L91:
        return;
    L18:
        Object r6 = r17.getTag(2131370715);
        if ((r6 instanceof ll.a) == true) goto L21;
        r6 = null;
    L21:
        ll.a r7 = (ll.a) r6;
        if (r7 == null) goto L24;
        String r8 = r7.c();
    L25:
        JSONObject r9 = z1.g(r8);
        if (r9 == null) goto L49;
        String r10 = r9.optString("room_id");
        String r12 = r9.optString("author_id");
        String r14 = r9.optString("sec_author_id");
        JSONObject r11 = r9.optJSONObject("entrance_info");
        String r13 = r9.optString("ecom_entrance_from");
        JSONObject r15 = r9.optJSONObject("btm");
        JSONObject r2 = r5.optJSONObject("list_skin_helper");
        String r16 = r5.optString("room_id");
        String r19 = r5.optString("author_id");
        String r110 = r5.optString("sec_author_id");
        JSONObject r111 = r5.optJSONObject("entrance_info");
        String r20 = r5.optString("ecom_entrance_from");
        JSONObject r1 = r5.optJSONObject("btm");
        JSONObject r21 = r5.optJSONObject("list_skin_helper");
        if ((!Intrinsics.areEqual(r16, r10)) == false) goto L32;
    L48:
        boolean r112 = true;
    L50:
        if (r112 == false) goto L55;
        View r22 = e(r4, r18);
        if (r22 == null) goto L92;
        r4.removeAllViews();
        r4.addView(r22);
        return;
    L92:
        return;
    L55:
        View r23 = r4.getChildAt(0);
        if (r5.optInt("visible") != 1) goto L58;
        int r24 = 0;
    L59:
        r23.setVisibility(r24);
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L83
        String r26 = a2.d(r5.optString("promotion"));     // Catch: Throwable -> L83
        if (r26 == null) goto L80;
        int r27 = t0.a;     // Catch: Throwable -> L83
        ECPromotion r28 = (ECPromotion) t0.a.a.fromJson(r26, ECPromotion.class);     // Catch: Throwable -> L83
        long r29 = r5.optLong("server_time");     // Catch: Throwable -> L83
        int r30 = ECSdk.a;     // Catch: Throwable -> L83
        l r31 = (l) ECSdk.a(l.class);     // Catch: Throwable -> L83
        if (r31 == null) goto L79;
        ECUIPromotion r32 = r31.Ha(r28, ((ViewGroup) r17).getContext(), r29, Boolean.FALSE);     // Catch: Throwable -> L83
        if (r32 == null) goto L79;
        Object r33 = r23.getTag(2131370714);     // Catch: Throwable -> L83
        if ((r33 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.b) == true) goto L69;
        Object r34 = null;
    L70:
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r35 = (com.bytedance.android.livesdk.livecommerce.promotion.card.b) r34;     // Catch: Throwable -> L83
        if (r35 == null) goto L79;
        g r36 = r35.Y0();     // Catch: Throwable -> L83
        if (r36 == null) goto L79;
        com.bytedance.android.ec.common.api.jump.model.a r37 = r36.getParent();     // Catch: Throwable -> L83
        if (r37 == null) goto L79;
        g r38 = r37.buildParams(Reflection.getOrCreateKotlinClass(g.class), new g.a(r32));     // Catch: Throwable -> L83
        if (r38 == null) goto L79;
        com.bytedance.android.livesdk.livecommerce.promotion.card.b.a.b(r35, r38);     // Catch: Throwable -> L83
        goto L79
    L69:
        r34 = r33;
    L79:
        String r39 = r26;
    L81:
        Object r40 = Result.constructor-impl(r39);     // Catch: Throwable -> L83
    L85:
        Throwable r41 = Result.exceptionOrNull-impl(r40);
        if (r41 == null) goto L93;
        ECExceptionMonitor.e(r41);
        return;
    L93:
        return;
    L80:
        r39 = null;
    L83:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L85
    L58:
        r24 = 8;
        goto L59
    L32:
        if ((!Intrinsics.areEqual(r19, r12)) == true) goto L48;
        if ((!Intrinsics.areEqual(r110, r14)) == true) goto L48;
        if ((!Intrinsics.areEqual(r111, r11)) == true) goto L48;
        if ((!Intrinsics.areEqual(r20, r13)) == true) goto L48;
        if ((!Intrinsics.areEqual(r1, r15)) == true) goto L48;
        if ((!Intrinsics.areEqual(r2, r21)) == true) goto L48;
    L49:
        r112 = false;
        goto L50
    L24:
        r8 = null;
        goto L25
    L5:
        r3 = r17;
        goto L6
    }

    public final View e(ViewGroup r30, ll.a r31) {
        JSONObject r0 = z1.g(r31.c());
        View r1 = null;
        if (r0 == null) goto L113;
        String r2 = r0.optString("room_id");
        r0.optString("author_id");
        r0.optString("sec_author_id");
        JSONObject r10 = r0.optJSONObject("entrance_info");
        String r3 = r0.optString("ecom_entrance_from");
        JSONObject r4 = r0.optJSONObject("btm");
        JSONObject r5 = r0.optJSONObject("list_skin_helper");
        String r6 = BtmSDK.INSTANCE.getPageId(PageFinder.via(r30));
        if (r5 == null) goto L8;
        JSONObject r13 = r5.optJSONObject("can_show_module");
    L10:
        if (r4 == null) goto L12;
        String r7 = r4.optString("item_btm");
    L14:
        if (r7 != null) goto L16;
        String r15 = "";
    L17:
        if (r4 == null) goto L19;
        String r8 = r4.optString("add_cart_btm");
    L20:
        if (r8 != null) goto L22;
        String r16 = "";
    L23:
        if (r4 == null) goto L25;
        String r9 = r4.optString("stepper_btm");
    L26:
        if (r9 != null) goto L28;
        String r17 = "";
    L29:
        if (r4 == null) goto L31;
        String r11 = r4.optString("button_btm");
    L32:
        if (r11 != null) goto L34;
        String r18 = "";
    L35:
        if (r4 == null) goto L37;
        String r12 = r4.optString("matching_btm");
    L38:
        if (r12 != null) goto L40;
        String r19 = "";
    L41:
        if (r4 == null) goto L43;
        String r14 = r4.optString("simple_sku_btm");
    L44:
        if (r14 != null) goto L46;
        String r20 = "";
    L47:
        if (r4 == null) goto L49;
        String r21 = r4.optString("given_product_btm");
    L50:
        if (r21 != null) goto L52;
        String r22 = "";
    L53:
        if (r4 == null) goto L55;
        String r23 = r4.optString("playback_btm");
    L56:
        if (r23 != null) goto L58;
        String r24 = "";
    L59:
        if (r4 == null) goto L61;
        String r25 = r4.optString("3d_btm");
    L62:
        if (r25 != null) goto L64;
        String r26 = "";
    L65:
        if (r4 == null) goto L67;
        String r27 = r4.optString("float_icon_btm");
    L68:
        if (r27 != null) goto L70;
        String r28 = "";
    L72:
        if (r4 == null) goto L74;
        String r29 = r4.optString("item_btm_index");
    L75:
        int r32 = 0;
        if (a2.d(r29) == null) goto L78;
        boolean r210 = true;
    L79:
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r33 = new com.bytedance.android.livesdk.livecommerce.promotion.card.g.a(r15, r16, r17, r18, r19, r20, r22, r24, r26, r28, null, r210, 7168);
        a r110 = new a();
        int r34 = ECSdk.a;
        l r35 = (l) ECSdk.a(l.class);
        if (r35 == null) goto L113;
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r111 = r35.Da(r30, new com.bytedance.android.livesdk.livecommerce.promotion.card.g(r33, r110, null, null, new il.a()), false);
        if (r111 == null) goto L113;
        r1 = com.bytedance.android.livesdk.livecommerce.promotion.card.b.a.a(r111);
        if (r0.optInt("visible") == 1) goto L87;
        r32 = 8;
    L87:
        r1.setVisibility(r32);
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L105
        String r37 = a2.d(r0.optString("promotion"));     // Catch: Throwable -> L105
        if (r37 == null) goto L101;
        int r38 = t0.a;     // Catch: Throwable -> L105
        ECPromotion r112 = (ECPromotion) t0.a.a.fromJson(r37, ECPromotion.class);     // Catch: Throwable -> L105
        long r113 = r0.optLong("server_time");     // Catch: Throwable -> L105
        l r114 = (l) ECSdk.a(l.class);     // Catch: Throwable -> L105
        if (r114 == null) goto L101;
        ECUIPromotion r39 = r114.Ha(r112, r30.getContext(), r113, Boolean.FALSE);     // Catch: Throwable -> L105
        if (r39 == null) goto L101;
        int r40 = RoomContextController.h;     // Catch: Throwable -> L105
        com.bytedance.android.ec.common.api.jump.model.b r41 = RoomContextController.a.b(r2, this.a).l();     // Catch: Throwable -> L103
        if (r41 != null) goto L99;
        r41 = com.bytedance.android.ec.common.api.jump.model.b.a;     // Catch: Throwable -> L103
    L99:
        com.bytedance.android.livesdk.livecommerce.promotion.card.b.a.b(r111, r41.buildParams(Reflection.getOrCreateKotlinClass(f.class), new f.a(null, r6, new jf.b.c(r3), e.g.b, null, r10, null, 80)).buildParams(Reflection.getOrCreateKotlinClass(g.class), new g.a(r39)));     // Catch: Throwable -> L103
    L103:
        th = th;
    L107:
        Result.Companion r42 = Result.Companion;
        Object r43 = Result.constructor-impl(ResultKt.createFailure(th));
    L108:
        Throwable r44 = Result.exceptionOrNull-impl(r43);
        if (r44 == null) goto L111;
        ECExceptionMonitor.e(r44);
    L111:
        r1.setTag(2131370714, r111);
    L101:
        PromotionItemComponentUIConfig.a(r111, r13);     // Catch: Throwable -> L103
        r43 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L103
    L105:
        th = th;
        goto L107
    L78:
        r210 = false;
        goto L79
    L74:
        r29 = null;
        goto L75
    L70:
        r28 = r27;
        goto L72
    L67:
        r27 = null;
        goto L68
    L64:
        r26 = r25;
        goto L65
    L61:
        r25 = null;
        goto L62
    L58:
        r24 = r23;
        goto L59
    L55:
        r23 = null;
        goto L56
    L52:
        r22 = r21;
        goto L53
    L49:
        r21 = null;
        goto L50
    L46:
        r20 = r14;
        goto L47
    L43:
        r14 = null;
        goto L44
    L40:
        r19 = r12;
        goto L41
    L37:
        r12 = null;
        goto L38
    L34:
        r18 = r11;
        goto L35
    L31:
        r11 = null;
        goto L32
    L28:
        r17 = r9;
        goto L29
    L25:
        r9 = null;
        goto L26
    L22:
        r16 = r8;
        goto L23
    L19:
        r8 = null;
        goto L20
    L16:
        r15 = r7;
        goto L17
    L12:
        r7 = null;
        goto L14
    L8:
        r13 = null;
    L113:
        return r1;
    }

    public final View b(ViewGroup r2, ll.a r3, w83.b<?> r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "data");
        if (r4 == null) goto L5;
        String r5 = (String) r4.a();
    L6:
        this.a = r5;
        FrameLayout r6 = new FrameLayout(r2.getContext());
        r6.setTag(2131370715, r3);
        View r7 = e(r6, r3);
        if (r7 == null) goto L9;
        r6.addView(r7);
    L9:
        r6.setBackgroundColor(th.a.a(r6.getContext(), 2131109391));
        return r6;
    L5:
        r5 = null;
        goto L6
    }
}
