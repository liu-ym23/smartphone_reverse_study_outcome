package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.model.promotion.ECUIActivity;
import com.bytedance.android.ec.model.response.ECCombination;
import com.bytedance.android.ec.model.response.StandardEventTrack;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.event.d2;
import com.bytedance.android.livesdk.livecommerce.event.n1;
import com.bytedance.android.livesdk.livecommerce.event.z1;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.largemode.ECLiveLargeModeConfigHelper;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import si2.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Runnable {
        public final /* synthetic */ ml.b a;
        public final /* synthetic */ RoomContextController b;
        public final /* synthetic */ IntroPromotionVO c;
        public final /* synthetic */ Ref.ObjectRef d;
        public final /* synthetic */ Ref.ObjectRef e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public a(ml.b r1, RoomContextController r2, IntroPromotionVO r3, Ref.ObjectRef r4, Ref.ObjectRef r5, String r6, String r7, String r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final void a() {
            n1 r6 = new n1(this.a.c(), this.a.roomId(), "live_popup_card", this.b);
            r6.q(this.c.getPromotionId(), this.c.getEventItemType(), this.c.getProductId(), this.c.getEventParams(), this.c.getExtraEventParams());
            r6.f("label_name", this.c.getTrackLabelName());
            r6.f("label_name_live", this.c.getLabelNameLive());
            r6.f("base_verified_category", this.c.getBaseVerifiedCategory());
            Boolean r0 = (Boolean) this.d.element;
            if (r0 == null) goto L5;
            r6.r(r0.booleanValue());
        L5:
            r6.p((Map) this.e.element);
            r6.f("is_preview", String.valueOf(this.b.v()));
            r6.f("is_ecom_new", "1");
            this.b.q().sendLogger("livesdk_preview_guide_show", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("module_name", "ecommerce_info_card")}));
            String r1 = this.f;
            if (r6.c.g("if_clear_mode").booleanValue() == true) goto L8;
            r6.f("if_clear_mode", r1);
        L8:
            r6.n(this.g);
            r6.l(this.h, this.g);
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

    public static Map a(RoomContextController r0) {
        if (r0 == null) goto L8;
        com.bytedance.android.ec.adapter.api.state.a r1 = r0.L();
        if (r1 == null) goto L8;
        Map r2 = r1.m;
        if (r2 == null) goto L8;
        return r2;
    L8:
        return new HashMap();
    }

    public static void c(IntroPromotionVO r10, ml.b r11, String r12, String r13, RoomContextController r14) {
        Intrinsics.checkNotNullParameter(r10, "introPromotionVO");
        Intrinsics.checkNotNullParameter(r11, "liveRoomInfo");
        Intrinsics.checkNotNullParameter(r14, "roomContextController");
        r11.roomId();
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = null;
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = null;
        boolean r0 = true;
        if (r14 != null) goto L5;
    L12:
        r5.element = Boolean.valueOf(r0);
        r6.element = a(r14);
        int r1 = ECSdk.a;
        IAdapterService r2 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r2 == null) goto L16;
        String r3 = r2.getIfClearModeValueWithClick();
        if (r3 == null) goto L16;
    L17:
        t.b(new k(new a(r11, r14, r10, r5, r6, r3, r13, r12), "ExplainProductEntranceShowEvent"));
        return;
    L16:
        r3 = BDLocationException.ERROR_TIMEOUT;
        goto L17
    L5:
        if (r14.x() != true) goto L12;
        com.bytedance.android.ec.adapter.api.state.a r4 = r14.L();
        if (r4 == null) goto L12;
        if (r4.d == true) goto L12;
        r0 = false;
        goto L12
    }

    public static z1 b(IntroPromotionVO r5, ml.b r6, int r7, String r8, Map r9, RoomContextController r10, String r11, String r12, String r13) {
        z1 r0 = new z1(r7, r10);
        r0.q(r5.getEventParams());
        r0.q(r5.getExtraEventParams());
        r0.f("anchor_id", r6.c());
        r0.f("room_id", r6.roomId());
        r0.f("commodity_id", r5.getPromotionId());
        r0.d("ecom_goods_status", r5.getStatus());
        r0.f("product_id", r5.getProductId());
        r0.f("commodity_type", r5.getEventItemType());
        r0.f("ecom_entrance_form", r13);
        r0.f("product_label", r5.getEventLabel());
        ECUIActivity r14 = r5.getActivity();
        if (r14 == null) goto L6;
        r0.e("ecom_tag_activity_id", r14.getActivityId());
        r0.e("ecom_tag_activity_type", r14.getActivityType());
    L6:
        if (q.a(r5) == false) goto L8;
        String r15 = "seckill";
    L9:
        r0.f("product_activity_type", r15);
        r0.f("is_groupbuying", r5.getIsGroupBuying());
        boolean r16 = r5.isDiscountPrice();
        String r17 = BDLocationException.ERROR_TIMEOUT;
        if (r16 == true) goto L12;
        String r18 = BDLocationException.ERROR_TIMEOUT;
    L13:
        r0.f("avl_discount", r18);
        r0.f("label_name", r5.getTrackLabelName());
        r0.f("inventory_status", r5.getInventoryStatus());
        r0.f("label_name_live", r5.getLabelNameLive());
        Integer r19 = r5.getCampainExtraType();
        if (r19 == null) goto L16;
        r0.d("campaign_extra_type", r19.intValue());
    L16:
        boolean r20 = r5.isShowCombination();
        ECCombination r1 = r5.getCombination();
        String r2 = null;
        if (r1 == null) goto L19;
        String r3 = r1.getCombinationId();
    L20:
        r0.o(r20, r3);
        String r21 = r5.getRealPrice();
        String r4 = r5.getCostPrice();
        String r22 = r5.getLogid();
        if (r21 == null) goto L23;
        r0.f("real_price", r21);
    L23:
        if (r4 == null) goto L25;
        r0.f("cost_price", r4);
    L25:
        if (r22 == null) goto L27;
        r0.f("logid", r22);
    L27:
        String r23 = (String) ECLiveLargeModeConfigHelper.a.getValue();
        Intrinsics.checkNotNullParameter(r23, "fontScale");
        r0.f("ec_live_font_scale", r23);
        if (r12 == null) goto L31;
        r0.f("bst_group_type", r12);
    L31:
        if (com.bytedance.forest.utils.h.a("bst_tag") == false) goto L33;
        r0.f("bst_tag", "bst_tag");
    L33:
        Pair r24 = d2.a(r5);
        List r110 = (List) r24.component1();
        List r25 = (List) r24.component2();
        if ((!r110.isEmpty()) == false) goto L37;
        r0.f("tag_code_list", r110.toString());
    L37:
        if ((!r25.isEmpty()) == false) goto L40;
        r0.f("live_tag_list", r25.toString());
    L40:
        if ((r6 instanceof com.bytedance.android.livesdk.livecommerce.room.model.e) == false) goto L44;
        if (r11 == null) goto L43;
        Intrinsics.checkNotNullParameter(r11, "screenOrientation");
        r0.f("screen_type", r11);
    L43:
        r0.p(r9);
        r0.f("duration", ((com.bytedance.android.livesdk.livecommerce.room.model.e) r6).b());
    L44:
        r0.n(r8);
        if (r5.isPreSale() == false) goto L47;
        r17 = "1";
    L47:
        r0.c.c("upfront_presell", r17);
        StandardEventTrack r26 = r5.getStandardEventTrack();
        if (r26 == null) goto L50;
        r2 = r26.getTrackParamsJSONStr();
    L50:
        r0.c.c("standard_track_param", r2);
        r0.f("is_ecom_new", "1");
        return r0;
    L19:
        r3 = null;
        goto L20
    L12:
        r18 = "1";
        goto L13
    L8:
        r15 = "nonactivity";
        goto L9
    }
}
