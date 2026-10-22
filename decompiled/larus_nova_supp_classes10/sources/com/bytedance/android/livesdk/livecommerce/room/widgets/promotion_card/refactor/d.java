package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.ec.model.promotion.ECUIActivity;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECCombination;
import com.bytedance.android.ec.model.response.StandardEventTrack;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.ec.opt.asynctask.w;
import com.bytedance.android.livesdk.livecommerce.event.d2;
import com.bytedance.android.livesdk.livecommerce.event.z1;
import com.bytedance.android.livesdk.livecommerce.largemode.ECLiveLargeModeConfigHelper;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a implements w {
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ String b;

        public final com.bytedance.android.ec.opt.asynctask.k r() {
            com.bytedance.android.ec.opt.asynctask.r r0 = new com.bytedance.android.ec.opt.asynctask.r();
            r0.c = true;
            return r0.g.b();
        }

        public final void run() {
            this.a.run();
            System.out.println("Django: Task: event async: " + this.b);
        }

        public a(Runnable r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ RoomContextController c;
        public final /* synthetic */ boolean d;

        public b(String r1, String r2, RoomContextController r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.livesdk.livecommerce.event.h r0 = new com.bytedance.android.livesdk.livecommerce.event.h(this.a, this.b, this.c);     // Catch: Throwable -> L4
            r0.d("has_promotion", this.d ? 1 : 0);     // Catch: Throwable -> L4
            r0.k();     // Catch: Throwable -> L4
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

    public static void a(String r1, Runnable r2) {
        y.o.getClass();
        if (y.l == false) goto L5;
        t.b(new a(r2, r1));
        return;
    L5:
        r2.run();
    }

    public static boolean b(String r2, RoomContextController r3) {
        if (ControllerExtensionsKt.c(r3, r2).x() == false) goto L12;
        com.bytedance.android.ec.adapter.api.state.a r4 = ControllerExtensionsKt.c(r3, r2).L();
        if (r4 == null) goto L7;
        boolean r5 = r4.d;
    L8:
        if (r5 == true) goto L13;
        return false;
    L13:
        return true;
    L7:
        r5 = true;
        goto L8
    L12:
        return true;
    }

    public static void d(String r1, String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "apiPath");
        Intrinsics.checkNotNullParameter(r2, "roomId");
        int r0 = RoomContextController.h;
        a("ECApiRequestSuccessEvent", new b(r1, r2, RoomContextController.a.b(r2, r3), r4));
    }

    public static void e(ECUIPromotion r7, ml.b r8, Map r9, RoomContextController r10) {
        Intrinsics.checkNotNullParameter(r7, "uiPromotion");
        if (r8 == null) goto L5;
        String r0 = r8.roomId();
    L6:
        a("ECHotAtmosphereShowEvent", new i(ControllerExtensionsKt.c(r10, r0), r8, r7, r10, r9));
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static z1 c(ECUIPromotion r4, ml.b r5, boolean r6, int r7, Map r8, String r9, Map r10, RoomContextController r11, String r12, String r13, String r14) {
        z1 r0 = new z1(r7, r11);
        r0.q(r4.getEventParams());
        r0.q(r4.getExtraEventParams());
        r0.f("anchor_id", r5.c());
        r0.f("room_id", r5.roomId());
        r0.f("commodity_id", r4.getPromotionId());
        r0.d("ecom_goods_status", r4.getStatus());
        r0.f("product_id", r4.getProductId());
        r0.f("commodity_type", r4.getEventItemType());
        r0.f("ecom_entrance_form", r14);
        r0.f("product_label", r4.getEventLabel());
        ECUIActivity r15 = r4.getActivity();
        if (r15 == null) goto L6;
        r0.e("ecom_tag_activity_id", r15.getActivityId());
        r0.e("ecom_tag_activity_type", r15.getActivityType());
    L6:
        if (si2.q.a(r4) == false) goto L8;
        String r16 = "seckill";
    L9:
        r0.f("product_activity_type", r16);
        r0.f("is_groupbuying", r4.getIsGroupBuying());
        boolean r17 = r4.isDiscountPrice();
        String r18 = BDLocationException.ERROR_TIMEOUT;
        if (r17 == true) goto L12;
        String r19 = BDLocationException.ERROR_TIMEOUT;
    L13:
        r0.f("avl_discount", r19);
        r0.f("label_name", r4.getTrackLabelName());
        r0.d("has_flash_notice", r6 ? 1 : 0);
        r0.f("inventory_status", r4.getInventoryStatus());
        r0.f("label_name_live", r4.getLabelNameLive());
        Integer r20 = r4.getCampainExtraType();
        if (r20 == null) goto L16;
        r0.d("campaign_extra_type", r20.intValue());
    L16:
        boolean r21 = r4.isShowCombination();
        ECCombination r22 = r4.getCombination();
        String r1 = null;
        if (r22 == null) goto L19;
        String r23 = r22.getCombinationId();
    L20:
        r0.o(r21, r23);
        String r24 = r4.getRealPrice();
        String r25 = r4.getCostPrice();
        String r2 = r4.getLogid();
        if (r24 == null) goto L23;
        r0.f("real_price", r24);
    L23:
        if (r25 == null) goto L25;
        r0.f("cost_price", r25);
    L25:
        if (r2 == null) goto L27;
        r0.f("logid", r2);
    L27:
        String r26 = (String) ECLiveLargeModeConfigHelper.a.getValue();
        Intrinsics.checkNotNullParameter(r26, "fontScale");
        r0.f("ec_live_font_scale", r26);
        if (r13 == null) goto L31;
        r0.f("bst_group_type", r13);
    L31:
        if (com.bytedance.forest.utils.h.a("bst_tag") == false) goto L33;
        r0.f("bst_tag", "bst_tag");
    L33:
        Pair r27 = d2.a(r4);
        List r28 = (List) r27.component1();
        List r29 = (List) r27.component2();
        if ((!r28.isEmpty()) == false) goto L37;
        r0.f("tag_code_list", r28.toString());
    L37:
        if ((!r29.isEmpty()) == false) goto L40;
        r0.f("live_tag_list", r29.toString());
    L40:
        if ((r5 instanceof com.bytedance.android.livesdk.livecommerce.room.model.e) == false) goto L44;
        if (r12 == null) goto L43;
        Intrinsics.checkNotNullParameter(r12, "screenOrientation");
        r0.f("screen_type", r12);
    L43:
        r0.p(r10);
        r0.f("duration", ((com.bytedance.android.livesdk.livecommerce.room.model.e) r5).b());
    L44:
        r0.n(r9);
        if (r4.isPreSale() == false) goto L47;
        r18 = "1";
    L47:
        r0.c.c("upfront_presell", r18);
        r0.m(r8);
        StandardEventTrack r30 = r4.getStandardEventTrack();
        if (r30 == null) goto L50;
        r1 = r30.getTrackParamsJSONStr();
    L50:
        r0.f("standard_track_param", r1);
        return r0;
    L19:
        r23 = null;
        goto L20
    L12:
        r19 = "1";
        goto L13
    L8:
        r16 = "nonactivity";
        goto L9
    }
}
