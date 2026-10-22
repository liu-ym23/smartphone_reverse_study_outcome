package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import android.net.Uri;
import android.util.LruCache;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.widgets.aiim.ShoppingAIIMButton;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.functions.Consumer;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;
import vi2.n0;
import xi2.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends c0 {
    public static final /* synthetic */ int d = 0;
    public final Lazy c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.controller.business.a$a, reason: collision with other inner class name */
    public static final class C0100a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ com.bytedance.android.btm.api.model.d e;
        public final /* synthetic */ LiveActionTracker f;
        public final /* synthetic */ AIIMSchemaScene g;
        public final /* synthetic */ Uri h;

        public b(a r1, String r2, String r3, String r4, com.bytedance.android.btm.api.model.d r5, LiveActionTracker r6, AIIMSchemaScene r7, Uri r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final void accept(Object r22) {
            final b0 r1 = (b0) r22;
            String r2 = null;
            if (r1 == null) goto L42;
            b0.b r3 = r1.a();
            if (r3 == null) goto L42;
            b0.a r4 = r3.a();
            if (r4 == null) goto L42;
            int r5 = r4.a();
            if (r5 != 1) goto L11;
            b0.a.b r6 = r4.b();
            if (r6 == null) goto L40;
            String r7 = r6.a();
            if (r7 == null) goto L40;
            String r8 = a2.d(r7);
            if (r8 == null) goto L40;
            jf.d r9 = (jf.d) this.a.c.getValue();
            Context r12 = this.a.m();
            a r10 = this.a;
            jf.d.b.d(r9, r12, a.I(r10, r10.A().m, r8, this.b, this.c, this.d, this.e), this.e, this.f);
            r2 = r8;
        L40:
            UtilityKotlinExtentionsKt.h(r2, new AIIMController$handleAIIMSchema$1$$special$$inlined$also$lambda$1(this, r1));
        L41:
            r2 = r4;
            goto L42
        L11:
            if (r5 != 2) goto L41;
            b0.a.c r11 = r4.c();
            if (r11 == null) goto L16;
            r2 = r11.a();
        L16:
            if (r2 != null) goto L19;
            r2 = "";
        L19:
            if (this.a.u() == true) goto L21;
        L30:
            LiveActionTracker r13 = this.f;
            if (r13 == null) goto L41;
            r13.c("handle_ai_im_schema", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", this.g.getValue()), TuplesKt.to("status_code", Integer.valueOf(((com.bytedance.android.ec.model.g) r1).statusCode)), TuplesKt.to("status_msg", ((com.bytedance.android.ec.model.g) r1).statusMessage)}), false, "toast msg is empty", r1.getLogId(), this.h.toString());
            r13.e(false);
            goto L41
        L21:
            if (r2.length() <= 0) goto L23;
            boolean r14 = true;
        L24:
            if (r14 == false) goto L30;
            com.bytedance.android.ec.sdk.helper.i.a.e(this.a.m(), r2, false, false);
            LiveActionTracker r15 = this.f;
            if (r15 == null) goto L41;
            il2.a r16 = il2.a.C0145a.a(r15, "handle_ai_im_schema", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", this.g.getValue()), TuplesKt.to("status_code", Integer.valueOf(((com.bytedance.android.ec.model.g) r1).statusCode)), TuplesKt.to("status_msg", ((com.bytedance.android.ec.model.g) r1).statusMessage)}), true, null, r1.getLogId(), this.h.toString(), 8);
            if (r16 == null) goto L41;
            ((LiveActionTracker) r16).e(false);
            goto L41
        L23:
            r14 = false;
        L42:
            UtilityKotlinExtentionsKt.h(r2, new AIIMController$handleAIIMSchema$1$2(this, r1));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ LiveActionTracker b;
        public final /* synthetic */ AIIMSchemaScene c;
        public final /* synthetic */ Uri d;

        public c(a r1, LiveActionTracker r2, AIIMSchemaScene r3, Uri r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r13) {
            Throwable r14 = (Throwable) r13;
            if (this.a.u() == false) goto L5;
            com.bytedance.android.ec.sdk.helper.i.a.e(this.a.m(), "网络异常，请稍后重试", false, false);
        L5:
            LiveActionTracker r4 = this.b;
            if (r4 == null) goto L10;
            il2.a r0 = il2.a.C0145a.a(r4, "handle_ai_im_schema", MapsKt.mapOf(TuplesKt.to("scene", this.c.getValue())), false, "network error", null, this.d.toString(), 16);
            if (r0 == null) goto L10;
            ((LiveActionTracker) r0).e(false);
        L10:
            ECExceptionMonitor.e(r14);
        }
    }

    public static final class d implements vd.a, ToolbarComponentCheckInterface {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void a(te.a r2, Function0 r3, Function1 r4) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r3, "loadButton");
            Intrinsics.checkNotNullParameter(r4, "stopLoadCallback");
            b(r2, r3, r4);
        }

        public final void b(Object r4, Function0 r5, Function1 r6) {
            if (this.a.w() == true) goto L7;
            ECLiveEntranceMonitor.trace$default("checkThenLoad roomState not attached", "AIIMController", false, 4, null);
            r6.invoke("roomState is not attached");
            return;
        L7:
            if ((r4 instanceof vd.b) == false) goto L10;
            vd.b r7 = (vd.b) r4;
            r7.a(new ShoppingAIIMButton(this.a.m(), this.a, r7.getComponentExtra()));
        L12:
            r5.invoke();
            return;
        L10:
            if ((r4 instanceof ToolbarMatchInterface) == false) goto L12;
            ToolbarMatchInterface r8 = (ToolbarMatchInterface) r4;
            r8.setExtraDataAfterCheck(new ShoppingAIIMButton(this.a.m(), this.a, r8.getComponentExtra()));
            goto L12
        }

        public final boolean checkThenLoad(ToolbarMatchInterface r2, Function0<Unit> r3, Function1<? super String, Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r3, "loadButton");
            Intrinsics.checkNotNullParameter(r4, "stopLoadCallback");
            b(r2, r3, r4);
            return true;
        }
    }

    static {
    }

    public a(RealRoomController$roomResources$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "roomResources");
        super(r2);
        this.c = LazyKt.lazy(new AIIMController$jumpDispatcher$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r17v3, types: [java.util.Map] */
    public final void J(Uri r33) {
        Intrinsics.checkNotNullParameter(r33, "uri");
        LiveActionTracker r8 = A().t.K().a("livesdk_ai_im_router", null);
        String r0 = r33.getHost();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if ((!Intrinsics.areEqual(r0, "ec_live_ai_im")) == false) goto L12;
        if (r8 == null) goto L168;
        il2.a r1 = il2.a.C0145a.a(r8, "handle_ai_im_schema", null, false, "schema host not match", null, r33.toString(), 18);
        if (r1 == null) goto L169;
        ((LiveActionTracker) r1).e(false);
        return;
    L169:
        return;
    L168:
        return;
    L12:
        String r7 = UriProtector.getQueryParameter(r33, "schema");
        String r4 = UriProtector.getQueryParameter(r33, "goods_detail_url");
        String r5 = UriProtector.getQueryParameter(r33, "promotion_id");
        String r6 = UriProtector.getQueryParameter(r33, "product_id");
        String r2 = UriProtector.getQueryParameter(r33, "item_type");
        String r11 = UriProtector.getQueryParameter(r33, "scene");
        AIIMSchemaScene.Companion.getClass();
        AIIMSchemaScene[] r12 = AIIMSchemaScene.values();
        int r13 = r12.length;
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L18;
        AIIMSchemaScene r16 = r12[r14];
        if (Intrinsics.areEqual(r16.getValue(), r11) == true) goto L16;
        r14 = r14 + 1;
        goto L13
    L16:
        AIIMSchemaScene r3 = r16;
    L19:
        com.bytedance.android.btm.api.model.d r15 = BtmUtilsKt.e(UriProtector.getQueryParameter(r33, "btm"), PageFinder.via(BtmSDK.INSTANCE.getCurrentResumedPage()));
        if (u() == true) goto L30;
        if (r8 != null) goto L23;
        return;
    L23:
        if (r3 == null) goto L25;
        String r9 = r3.getValue();
    L26:
        il2.a r10 = il2.a.C0145a.a(r8, "handle_ai_im_schema", MapsKt.mapOf(TuplesKt.to("scene", r9)), false, "context not attached", null, r33.toString(), 16);
        if (r10 == null) goto L171;
        ((LiveActionTracker) r10).e(false);
        return;
    L171:
        return;
    L25:
        r9 = null;
        goto L26
    L30:
        if (r8 == null) goto L33;
        il2.a.C0145a.a(r8, "handle_ai_im_schema", null, false, null, null, r33.toString(), 30);
    L33:
        if (r3 == null) goto L42;
        int r17 = com.bytedance.android.livesdk.livecommerce.room.controller.business.b.a[r3.ordinal()];
        if (r17 != 1) goto L38;
        K(r7, r15, r8);
        return;
    L38:
        if (r17 == 2) goto L102;
        if (r17 != 3) goto L41;
        if (r5 != null) goto L65;
    L68:
        boolean r18 = true;
    L69:
        if (r18 == true) goto L84;
        if (r6 != null) goto L72;
    L75:
        boolean r19 = true;
    L76:
        if (r19 == true) goto L84;
        if (r2 != null) goto L79;
    L82:
        boolean r110 = true;
    L83:
        if (r110 == true) goto L84;
    L88:
        if (r7 != null) goto L90;
    L93:
        boolean r20 = true;
    L94:
        if (r20 == false) goto L100;
        if (r8 == null) goto L174;
        il2.a r21 = il2.a.C0145a.a(r8, "handle_ai_im_schema", MapsKt.mapOf(TuplesKt.to(r15, r3.getValue())), false, "schema is empty", null, r33.toString(), 16);
        if (r21 == null) goto L175;
        ((LiveActionTracker) r21).e(false);
        return;
    L175:
        return;
    L174:
        return;
    L100:
        ((jf.d) this.c.getValue()).m(m(), r7, I(this, A().m, r4, r5, r6, r2, r15), r15, r8);
        return;
    L90:
        if (r7.length() == 0) goto L93;
        r20 = false;
        goto L94
    L79:
        if (r2.length() == 0) goto L82;
        r110 = false;
        goto L83
    L72:
        if (r6.length() == 0) goto L75;
        r19 = false;
    L84:
        if (r8 == null) goto L87;
        il2.a.C0145a.a(r8, "handle_ai_im_schema", MapsKt.mapOf(new Pair[]{TuplesKt.to("promotionId", r5), TuplesKt.to("productId", r6), TuplesKt.to("itemType", r2)}), false, "core params is empty", null, r33.toString(), 16);
    L87:
        int r22 = com.bytedance.android.ec.sdk.helper.j.a;
        com.bytedance.android.ec.sdk.helper.j.d("AIIMController", "handleAIIMSchema core params is empty, promotionId: " + r5 + ", productId: " + r6 + ", itemType: " + r2, null, null);
        goto L88
    L65:
        if (r5.length() == 0) goto L68;
        r18 = false;
        goto L69
    L41:
        if (r17 != 4) goto L42;
        if (r7 != null) goto L52;
    L55:
        boolean r23 = true;
    L56:
        if (r23 == false) goto L62;
        if (r8 == null) goto L172;
        il2.a r24 = il2.a.C0145a.a(r8, "handle_ai_im_schema", MapsKt.mapOf(TuplesKt.to("scene", r3.getValue())), false, "schema is empty", null, r33.toString(), 16);
        if (r24 == null) goto L173;
        ((LiveActionTracker) r24).e(false);
        return;
    L173:
        return;
    L172:
        return;
    L62:
        jf.d r25 = (jf.d) this.c.getValue();
        Context r26 = m();
        RoomContextController r111 = A().m;
        JSONObject r27 = new JSONObject();
        com.bytedance.android.shopping.extensions.k.l(r27, "enter_from", "live");
        Unit r112 = Unit.INSTANCE;
        r25.k(r26, r7, H(r111, r4, r5, r6, r2, r15, r27), r15, r8);
        return;
    L52:
        if (r7.length() == 0) goto L55;
        r23 = false;
        goto L56
    L102:
        if (r5 != null) goto L104;
    L107:
        boolean r113 = true;
    L108:
        if (r113 == true) goto L125;
        if (r6 != null) goto L111;
    L114:
        boolean r114 = true;
    L115:
        if (r114 == true) goto L125;
        if (r2 != null) goto L118;
    L121:
        boolean r115 = true;
    L122:
        if (r115 == true) goto L125;
        String r116 = null;
    L129:
        if (r7 != null) goto L131;
    L134:
        boolean r28 = true;
    L135:
        if (r28 == false) goto L163;
        LiveRoomParams r29 = l();
        if (r29 == null) goto L139;
        String r30 = r29.getRoomId();
    L140:
        if (r29 == null) goto L142;
        String r31 = r29.getRoomUniqueKey();
    L143:
        if (r29 == null) goto L145;
        String r117 = r29.getAuthorId();
    L146:
        ECEventUtilsV2 r32 = ECEventUtilsV2.b;
        if (r29 == null) goto L151;
        JSONObject r118 = r29.getEntranceInfo();
        if (r118 == null) goto L151;
        ?? r119 = z1.j(r118);
    L152:
        if (r29 == null) goto L154;
        Object r120 = r29.getEcomLiveParamsEventParams();
    L155:
        if (r120 != null) goto L157;
        r120 = MapsKt.emptyMap();
    L157:
        ?? r121 = r120;
        if (r29 == null) goto L160;
        String r210 = r29.getEcomSceneId();
    L161:
        r32.getClass();
        AIIMSchemaScene r122 = r3;
        bk2.c.a(bg4.b.b(vi2.h.e(r30, r31, "/live/promotions/public_comment/action/", new n0(r30, r31, r117, ECEventUtilsV2.b(null, r119, r121, null, null, r210), r6))).subscribe(new b(this, r5, r6, r2, r15, r8, r122, r33), new c(this, r8, r122, r33)), (bk2.d) o().getDisposableContext().getValue());
        return;
    L160:
        r210 = r116;
        goto L161
    L154:
        r120 = r116;
    L151:
        r119 = r116;
        goto L152
    L145:
        r117 = r116;
        goto L146
    L142:
        r31 = r116;
        goto L143
    L139:
        r30 = r116;
        goto L140
    L163:
        jf.d.b.d((jf.d) this.c.getValue(), m(), I(this, A().m, r7, r5, r6, r2, r15), r15, r8);
        return;
    L131:
        if (r7.length() == 0) goto L134;
        r28 = false;
        goto L135
    L118:
        if (r2.length() == 0) goto L121;
        r115 = false;
        goto L122
    L111:
        if (r6.length() == 0) goto L114;
        r114 = false;
    L125:
        if (r8 == null) goto L127;
        String r34 = "handleAIIMSchema core params is empty, promotionId: ";
        il2.a.C0145a.a(r8, "handle_ai_im_schema", MapsKt.mapOf(new Pair[]{TuplesKt.to("promotionId", r5), TuplesKt.to("productId", r6), TuplesKt.to("itemType", r2)}), false, "core params is empty", null, r33.toString(), 16);
    L128:
        int r35 = com.bytedance.android.ec.sdk.helper.j.a;
        r116 = null;
        com.bytedance.android.ec.sdk.helper.j.d("AIIMController", r34 + r5 + ", productId: " + r6 + ", itemType: " + r2, null, null);
        goto L129
    L127:
        r34 = "handleAIIMSchema core params is empty, promotionId: ";
        goto L128
    L104:
        if (r5.length() == 0) goto L107;
        r113 = false;
    L42:
        if (r8 != null) goto L44;
        return;
    L44:
        if (r3 == null) goto L46;
        String r36 = r3.getValue();
    L47:
        il2.a r37 = il2.a.C0145a.a(r8, "handle_ai_im_schema", MapsKt.mapOf(TuplesKt.to(r15, r36)), false, "scene not support", null, r33.toString(), 16);
        if (r37 == null) goto L177;
        ((LiveActionTracker) r37).e(false);
        return;
    L177:
        return;
    L46:
        r36 = null;
        goto L47
    L18:
        r3 = null;
        goto L19
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void d(com.bytedance.android.livesdk.livecommerce.room.api.e r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r2, "handler");
        d r3 = new d(this);
        E().J(r3);
    }

    public final void K(String r20, com.bytedance.android.btm.api.model.d r21, LiveActionTracker r22) {
        Intrinsics.checkNotNullParameter(r21, "btmModel");
        if (r20 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L15;
        if (r22 == null) goto L87;
        il2.a r0 = il2.a.C0145a.a(r22, "handle_ai_im_schema", null, false, "schema is empty", null, r20, 18);
        if (r0 == null) goto L88;
        ((LiveActionTracker) r0).e(false);
        return;
    L88:
        return;
    L87:
        return;
    L15:
        UrlBuilderV2 r4 = new UrlBuilderV2(r20);
        LiveRoomParams r1 = l();
        q.e.getClass();
        LruCache<String, String> r5 = q.d.get(B());
        Object r6 = null;
        if (r5 == null) goto L24;
        Map<String, String> r7 = r5.snapshot();
        if (r7 == null) goto L24;
        Collection<String> r8 = r7.values();
        if (r8 == null) goto L24;
        List r9 = CollectionsKt.reversed(r8);
        if (r9 == null) goto L24;
        String r10 = CollectionsKt.joinToString$default(r9, ",", null, null, 0, null, null, 62, null);
    L25:
        ECEventUtilsV2 r11 = ECEventUtilsV2.b;
        if (r1 == null) goto L30;
        JSONObject r12 = r1.getEntranceInfo();
        if (r12 == null) goto L30;
        Map r13 = z1.j(r12);
    L31:
        if (r1 == null) goto L33;
        Map r14 = r1.getEcomLiveParamsEventParams();
    L34:
        if (r14 != null) goto L36;
        r14 = MapsKt.emptyMap();
    L36:
        Map r15 = r14;
        if (r1 == null) goto L39;
        String r16 = r1.getEcomSceneId();
    L40:
        r11.getClass();
        String r17 = ECEventUtilsV2.b(null, r13, r15, null, null, r16);
        String r18 = r4.getQuery("business_extra");
        if (r18 == null) goto L44;
        JSONObject r19 = z1.g(r18);
        if (r19 == null) goto L44;
    L45:
        JSONObject r110 = z1.g(r19.optString("ecommerce_params"));
        if (r110 != null) goto L48;
        r110 = new JSONObject();
    L48:
        r110.put("viewed_products", r10);
        r110.put("entrance_info", r17);
        Unit r111 = Unit.INSTANCE;
        r19.put("ecommerce_params", r110);
        r19.put("is_ecom_live", 1);
        JSONObject r112 = z1.g(r19.optString("chat_extra"));
        if (r112 != null) goto L51;
        r112 = new JSONObject();
    L51:
        JSONObject r113 = z1.g(r112.optString("ec_live"));
        if (r113 != null) goto L54;
        r113 = new JSONObject();
    L54:
        r113.put("viewed_products", r10);
        r113.put("entrance_info", r17);
        r112.put("ec_live", r113);
        r19.put("chat_extra", r112);
        String r23 = r4.getQuery("log_extra");
        if (r23 == null) goto L58;
        JSONObject r24 = z1.g(r23);
        if (r24 == null) goto L58;
    L59:
        if (r1 == null) goto L63;
        Integer r2 = r1.isEcomNew();
        if (r2 == null) goto L63;
        int r25 = r2.intValue();
    L64:
        r24.put("is_ecom_new", r25);
        String r26 = r19.toString();
        Lazy r27 = UtilityKotlinExtentionsKt.a;
        Intrinsics.checkNotNullParameter(r26, "$this$urlEncode");
        Intrinsics.checkNotNullParameter("UTF-8", "enc");
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L67
        Object r29 = Result.constructor-impl(URLEncoder.encode(r26, "UTF-8"));     // Catch: Throwable -> L67
    L69:
        Throwable r30 = Result.exceptionOrNull-impl(r29);
        if (r30 == null) goto L73;
        ECExceptionMonitor.e(r30);
    L73:
        if (Result.isFailure-impl(r29) == true) goto L76;
        r6 = r29;
    L76:
        String r31 = (String) r6;
        if (r31 == null) goto L79;
        r4.addOrReplaceParam("business_extra", r31);
    L79:
        r4.addOrReplaceParam("log_extra", r24);
        BtmUtilsKt.c(r4, r21);
        String r32 = r4.build();
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(m(), r32);
        if (r22 == null) goto L89;
        il2.a r33 = il2.a.C0145a.a(r22, "handle_ai_im_schema", null, false, null, null, r32, 30);
        if (r33 == null) goto L90;
        ((LiveActionTracker) r33).e(false);
        return;
    L90:
        return;
    L89:
        return;
    L67:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
    L63:
        r25 = 0;
    L58:
        r24 = new JSONObject();
    L44:
        r19 = new JSONObject();
        goto L45
    L39:
        r16 = null;
        goto L40
    L33:
        r14 = null;
    L30:
        r13 = null;
    L24:
        r10 = null;
        goto L25
    L5:
        if (r20.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public static com.bytedance.android.ec.common.api.jump.model.g H(RoomContextController r13, String r14, String r15, String r16, String r17, com.bytedance.android.btm.api.model.d r18, JSONObject r19) {
        com.bytedance.android.ec.common.api.jump.model.b r1 = r13.l();
        if (r1 != null) goto L5;
        com.bytedance.android.ec.common.api.jump.model.b r2 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L6:
        KClass r3 = Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class);
        if (r18 == null) goto L11;
        PageFinder r0 = r18.b;
        if (r0 == null) goto L11;
        String r4 = BtmSDK.INSTANCE.getPageId(r0);
    L12:
        String r6 = r4;
        jf.b.k r7 = jf.b.k.b;
        jf.e.g r8 = jf.e.g.b;
        JSONObject r10 = new JSONObject();
        if (r1 == null) goto L17;
        String r5 = r1.getSourcePage();
        if (r5 == null) goto L17;
        com.bytedance.android.shopping.extensions.k.l(r10, "source_page", r5);
    L17:
        Unit r9 = Unit.INSTANCE;
        com.bytedance.android.ec.common.api.jump.model.f r11 = r2.buildParams(r3, new com.bytedance.android.ec.common.api.jump.model.f.a("c0.d0", r6, r7, r8, "schema", r10, null, 64));
        KClass r12 = Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class);
        ql.a r20 = new ql.a();
        String r21 = "";
        if (r15 != null) goto L20;
        String r22 = "";
    L21:
        r20.setPromotionId(r22);
        if (r16 == null) goto L25;
        r21 = r16;
    L25:
        r20.setProductId(r21);
        r20.setEventItemType(r17);
        r20.setScheme(r14);
        r20.setExtraTransmissibleLogParams(r19);
        return r11.buildParams(r12, new com.bytedance.android.ec.common.api.jump.model.g.a(r20));
    L20:
        r22 = r15;
    L11:
        r4 = null;
        goto L12
    L5:
        r2 = r1;
        goto L6
    }

    public static /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g I(a r7, RoomContextController r8, String r9, String r10, String r11, String r12, com.bytedance.android.btm.api.model.d r13) {
        r7.getClass();
        return H(r8, r9, r10, r11, r12, r13, null);
    }
}
