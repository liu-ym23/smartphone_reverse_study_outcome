package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageRoomInfo;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Runnable {
        public final /* synthetic */ gi2.a a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Map i;

        public a(gi2.a r1, boolean r2, String r3, String r4, String r5, String r6, String r7, String r8, Map r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
        }

        public final void a() {
            gi2.a r0 = this.a;
            String r1 = null;
            if (r0 == null) goto L5;
            LiveRoomParams r2 = (LiveRoomParams) r0.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        L6:
            StringBuilder r3 = new StringBuilder("livesdk_");
            if (this.b == false) goto L9;
            String r4 = "click";
        L10:
            r3.append(r4);
            r3.append("_store_entrance");
            String r5 = r3.toString();
            com.bytedance.android.ec.common.api.jump.model.b r6 = this.a;
            if (r6 != null) goto L13;
            r6 = com.bytedance.android.ec.common.api.jump.model.b.a;
        L13:
            v r7 = new v(r5, r6);
            r7.c("author_id", this.c);
            r7.c("store_group_type", "live");
            if (r2 == null) goto L16;
            String r8 = r2.getEnterMethod();
        L17:
            r7.c("store_source_method", r8);
            if (r2 == null) goto L20;
            String r9 = r2.getEnterFromMerge();
        L21:
            r7.c("store_source_page", r9);
            r7.c("entrance_location", this.d);
            r7.c("EVENT_ORIGIN_FEATURE", "TEMAI");
            r7.c("store_type", this.e);
            if (r2 == null) goto L24;
            String r10 = r2.getRoomId();
        L25:
            r7.c("pre_room_id", r10);
            r7.c("btm_id", this.f);
            if (this.b == false) goto L33;
            r7.c("list_click_area", this.g);
            int r11 = f.a;
            r7.a("list_top_display_status", 0);
            ECLiveABUtils r12 = ECLiveABUtils.INSTANCE;
            if (r12.getEC_LIVE_EVENT_ATTRIBUTION_PARAMS_UPLOAD() == false) goto L34;
            String r13 = this.h;
            if (r13 == null) goto L32;
            r1 = StringsKt.take(r13, r12.getEC_LIVE_REPORT_PLATFORM_MAX_LENGTH().intValue());
        L32:
            r7.c("schema", r1);
        L34:
            Map r14 = this.i;
            if (r14 == null) goto L40;
            Iterator r15 = r14.entrySet().iterator();
        L38:
            if (r15.hasNext() == false) goto L40;
            Map.Entry r16 = (Map.Entry) r15.next();
            r7.c((String) r16.getKey(), (String) r16.getValue());
        L40:
            gi2.a r17 = this.a;
            if (r17 == null) goto L58;
            Function0<LivePromotionPageRoomInfo> r18 = r17.e;
            if (r18 == null) goto L58;
            LivePromotionPageRoomInfo r19 = (LivePromotionPageRoomInfo) r18.invoke();
            if (r19 == null) goto L58;
            r7.c("room_type", String.valueOf(r19.getRoomType()));
            r7.c("instant_room_type", String.valueOf(r19.getInstantRoomType()));
            String r20 = r19.getStoreId();
            if (r20 == null) goto L49;
            r7.c("store_id", r20);
        L49:
            String r21 = r19.getReceiveAddressId();
            if (r21 == null) goto L52;
            r7.c("receive_address_id", r21);
        L52:
            String r22 = r19.getAddressType();
            if (r22 == null) goto L55;
            r7.c("address_type", r22);
        L55:
            String r23 = r19.getAddressStrategy();
            if (r23 == null) goto L58;
            r7.c("address_strategy_type", r23);
        L58:
            r7.i(this.f);
            return;
        L33:
            r7.c("list_show_area", this.g);
            goto L34
        L24:
            r10 = null;
            goto L25
        L20:
            r9 = null;
            goto L21
        L16:
            r8 = null;
            goto L17
        L9:
            r4 = "show";
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @JvmStatic
    public static final void b(boolean r2, Object r3, Map<String, String> r4, ECPromotionList.d r5, gi2.a r6) {
        Intrinsics.checkNotNullParameter(r3, "page");
        Intrinsics.checkNotNullParameter(r5, "authorReputation");
        if (r2 == false) goto L9;
        String r7 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b0715.c9204.d8210", Boolean.FALSE).withBtmPage(r3).build());
        if (r6 != null) goto L7;
        r6 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L7:
        v r8 = new v("livesdk_influence_entrance_click", r6);
        r8.c("btm_id", r7);
        r8.i(null);
        return;
    L9:
        if (r6 != null) goto L11;
        r6 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L11:
        v r9 = new v("author_sell_score_show", r6);
        r9.c("subject", "user");
        if (r4 == null) goto L14;
        String r10 = r4.get("broadcast_id");
    L15:
        r9.c("author_id", r10);
        r9.c("score", String.valueOf(r5.score));
        r9.c("page_name", "live");
        r9.i(null);
        return;
    L14:
        r10 = null;
        goto L15
    }

    @JvmStatic
    public static final void a(int r9, String r10, Map<String, String> r11, String r12, Map<String, String> r13, gi2.a r14) {
        Intrinsics.checkNotNullParameter(r10, "trackName");
        Object r1 = 0;
        Boolean r5 = null;
        String r6 = null;
        String r7 = "";
        if (r9 == 14) goto L67;
        String r15 = "livesdk_click_".concat(r10);
        if (r14 != null) goto L7;
        r14 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L7:
        v r2 = new v(r15, r14);
        if (r9 == 1) goto L51;
        if (r9 != 2) goto L11;
        BtmSDK r16 = BtmSDK.INSTANCE;
        String r4 = "a1.b0715.c9204.d1198";
        BtmItemBuilder r17 = new BtmItemBuilder("a1.b0715.c9204.d1198", Boolean.FALSE);
        if (r13 == null) goto L50;
        String r18 = r13.get("btm_page_id");
        if (r18 == null) goto L50;
        r7 = r18;
    L50:
        r7 = r16.createBtmId(r17.withPageFinder(PageFinder.via(r7)).build());
    L59:
        if (a2.d(r7) == null) goto L61;
        r2.c("btm_id", r7);
    L61:
        ECLiveABUtils r19 = ECLiveABUtils.INSTANCE;
        if (r19.getEC_LIVE_EVENT_ATTRIBUTION_PARAMS_UPLOAD() == false) goto L66;
        if (r12 == null) goto L65;
        r6 = StringsKt.take(r12, r19.getEC_LIVE_REPORT_PLATFORM_MAX_LENGTH().intValue());
    L65:
        r2.c("schema", r6);
    L66:
        r2.a("list_top_display_status", 0);
        r2.d(r11);
        r2.i(r4);
        return;
    L11:
        if (r9 != 3) goto L13;
        BtmSDK r20 = BtmSDK.INSTANCE;
        r4 = "a1.b0715.c9204.d5770";
        BtmItemBuilder r110 = new BtmItemBuilder("a1.b0715.c9204.d5770", Boolean.FALSE);
        if (r13 == null) goto L43;
        String r111 = r13.get("btm_page_id");
        if (r111 == null) goto L43;
        r7 = r111;
    L43:
        r7 = r20.createBtmId(r110.withPageFinder(PageFinder.via(r7)).build());
        goto L59
    L13:
        if (r9 != 8) goto L15;
        r4 = "a1.b0715.c9204.d052621";
        goto L59
    L15:
        if (r9 != 9) goto L17;
        r2.c("consultation_type", "anchor");
        r4 = "a1.b0715.c9204.d22364";
        goto L59
    L17:
        if (r9 != 12) goto L19;
        BtmSDK r21 = BtmSDK.INSTANCE;
        BtmItemBuilder r112 = new BtmItemBuilder("a1.b0715.c9204.d8081", Boolean.FALSE);
        if (r13 == null) goto L34;
        String r113 = r13.get("btm_page_id");
        if (r113 == null) goto L34;
        r1 = r113;
    L34:
        String r22 = r21.createBtmId(r112.withPageFinder(PageFinder.via(r1)).build());
        r2.c("click_area", "top");
        r4 = "a1.b0715.c9204.d8081";
        r7 = r22;
        goto L59
    L19:
        if (r9 != 6) goto L27;
        BtmSDK r23 = BtmSDK.INSTANCE;
        r4 = "a1.b0715.c9204.d5954";
        BtmItemBuilder r114 = new BtmItemBuilder("a1.b0715.c9204.d5954", Boolean.FALSE);
        if (r13 == null) goto L26;
        String r115 = r13.get("btm_page_id");
        if (r115 == null) goto L26;
        r1 = r115;
    L26:
        r7 = r23.createBtmId(r114.withPageFinder(PageFinder.via(r1)).build());
        goto L59
    L27:
        r4 = "a1.b0715.c9204.d838700";
        goto L59
    L51:
        r2.c("consultation_type", "shop");
        BtmSDK r24 = BtmSDK.INSTANCE;
        r4 = "a1.b0715.c9204.d6819";
        BtmItemBuilder r116 = new BtmItemBuilder("a1.b0715.c9204.d6819", Boolean.FALSE);
        if (r13 == null) goto L57;
        String r117 = r13.get("btm_page_id");
        if (r117 == null) goto L57;
        r7 = r117;
    L57:
        r7 = r24.createBtmId(r116.withPageFinder(PageFinder.via(r7)).setEnterPageTimes(2).build());
        goto L59
    L67:
        if (r14 == null) goto L69;
        LiveRoomParams r25 = (LiveRoomParams) r14.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
    L71:
        if (r14 != null) goto L73;
        gi2.a r118 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L74:
        v r119 = new v("search_box_click", r118);
        r119.c("enter_from", "search_live_product");
        if (r25 == null) goto L77;
        String r120 = r25.getEnterMethod();
    L78:
        if (r120 != null) goto L80;
        r120 = "";
    L80:
        r119.c("enter_from_method", r120);
        if (r25 == null) goto L83;
        String r121 = r25.getEnterFromMerge();
    L84:
        if (r121 != null) goto L86;
        r121 = "";
    L86:
        r119.c("enter_from_second", r121);
        if (r25 == null) goto L89;
        String r26 = r25.getAuthorId();
    L90:
        if (r26 == null) goto L93;
        r7 = r26;
    L93:
        r119.c("author_id", r7);
        r119.c("is_search_button", "1");
        r119.c("page_name", "live_product_detail");
        r119.c("group_id", l0.i("room_id"));
        r119.c("search_entrance_style", "icon");
        r119.c("click_area", "button");
        r119.a("list_top_display_status", 0);
        if (r14 == null) goto L104;
        Function0<Boolean> r122 = r14.h;
        if (r122 == null) goto L104;
        Boolean r123 = (Boolean) r122.invoke();
        if (r123 == null) goto L104;
        if (r123.booleanValue() == false) goto L102;
        r5 = r123;
    L102:
        if (r5 == null) goto L104;
        r5.booleanValue();
        r119.c("page_name", "live_instant_store");
    L104:
        r119.i("a1.b0715.c9204.d70073");
        return;
    L89:
        r26 = null;
        goto L90
    L83:
        r121 = null;
        goto L84
    L77:
        r120 = null;
        goto L78
    L73:
        r118 = r14;
        goto L74
    L69:
        r25 = null;
        goto L71
    }

    @JvmStatic
    public static final void c(String r11, String r12, boolean r13, String r14, String r15, String r16, String r17, gi2.a r18, Map<String, String> r19) {
        Intrinsics.checkNotNullParameter(r11, "anchorId");
        Intrinsics.checkNotNullParameter(r12, "btmId");
        Intrinsics.checkNotNullParameter(r14, LocationMonitorConst.TYPE);
        Intrinsics.checkNotNullParameter(r15, "area");
        Intrinsics.checkNotNullParameter(r16, "entranceLocation");
        oh.a.c("list_shop_info_event", new a(r18, r13, r11, r16, r14, r12, r15, r17, r19));
    }

    @JvmStatic
    public static final void d(View r12, Map<String, String> r13, String r14, String r15, String r16, String r17, gi2.a r18, Pair<Boolean, Boolean> r19, Map<String, String> r20) {
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r14, LocationMonitorConst.TYPE);
        Intrinsics.checkNotNullParameter(r15, "entranceLocation");
        Intrinsics.checkNotNullParameter(r16, "storeEntranceType");
        String r4 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b0715.c9204.d7082", Boolean.FALSE).withView(r12).build());
        LinkedHashMap r11 = new LinkedHashMap();
        String r3 = BDLocationException.ERROR_TIMEOUT;
        if (r19 == null) goto L12;
        boolean r5 = ((Boolean) r19.component1()).booleanValue();
        boolean r9 = ((Boolean) r19.component2()).booleanValue();
        if (r5 == false) goto L7;
        Object r6 = "1";
    L8:
        r11.put("is_eta_show", r6);
        if (r9 == false) goto L11;
        r3 = "1";
    L11:
        r11.put("is_distance_show", r3);
    L13:
        if (r20 == null) goto L18;
        Iterator<Map.Entry<String, String>> r0 = r20.entrySet().iterator();
    L16:
        if (r0.hasNext() == false) goto L18;
        Map.Entry<String, String> r2 = r0.next();
        r11.put(r2.getKey(), r2.getValue());
    L18:
        if (r13 == null) goto L21;
        String r1 = r13.get("anchor_id");
        if (r1 == null) goto L21;
    L22:
        c(r1, r4, false, r14, r15, r16, r17, r18, r11);
        return;
    L21:
        r1 = "";
        goto L22
    L7:
        r6 = BDLocationException.ERROR_TIMEOUT;
        goto L8
    L12:
        r11.put("is_eta_show", BDLocationException.ERROR_TIMEOUT);
        r11.put("is_distance_show", BDLocationException.ERROR_TIMEOUT);
        goto L13
    }
}
