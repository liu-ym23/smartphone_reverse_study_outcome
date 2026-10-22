package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.event.m1;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements Runnable {
    public final /* synthetic */ ml.b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ RoomContextController c;
    public final /* synthetic */ ECUIPromotion d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ BtmItemBuilder f;
    public final /* synthetic */ String g;
    public final /* synthetic */ gf.a h;
    public final /* synthetic */ Ref.ObjectRef i;
    public final /* synthetic */ Ref.ObjectRef j;
    public final /* synthetic */ String k;
    public final /* synthetic */ Map l;
    public final /* synthetic */ String m;

    public k(ml.b r1, String r2, RoomContextController r3, ECUIPromotion r4, boolean r5, BtmItemBuilder r6, String r7, gf.a r8, Ref.ObjectRef r9, Ref.ObjectRef r10, String r11, Map r12, String r13) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
    }

    public final void a() {
        m1 r6 = new m1(this.a.c(), this.a.roomId(), "live_popup_card", this.b, this.c);
        r6.p(this.d.getPromotionId(), this.d.getEventItemType(), this.d.getProductId(), this.d.getEventParams(), this.d.getExtraEventParams());
        r6.f("label_name", this.d.getTrackLabelName());
        r6.d("has_flash_notice", this.e ? 1 : 0);
        String r0 = this.d.getLabelNameLive();
        Intrinsics.checkNotNullParameter(r0, "labelNameLive");
        r6.f("label_name_live", r0);
        r6.f("base_verified_category", this.d.getBaseVerifiedCategory());
        BtmItemBuilder r1 = this.f;
        if (r1 == null) goto L5;
        r6.f("btm_id", BtmSDK.INSTANCE.createBtmId(r1.copy().setEnterPage(false).build()));
    L5:
        r6.n(this.g);
        if (this.h.a() == false) goto L17;
        Boolean r2 = (Boolean) this.i.element;
        if (r2 != null) goto L10;
    L14:
        r6.o((Map) this.j.element);
        if (this.c.v() == false) goto L17;
        this.c.q().sendLogger("livesdk_preview_guide_click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("module_name", "ecommerce_info_card")}));
        goto L17
    L10:
        if (r2.booleanValue() == false) goto L12;
        String r3 = BDLocationException.ERROR_TIMEOUT;
    L13:
        r6.f("screen_type", r3);
        r6.f("is_preview", String.valueOf(this.c.v()));
        goto L14
    L12:
        r3 = "1";
    L17:
        String r4 = this.k;
        if (r6.c.g("if_clear_mode").booleanValue() == true) goto L20;
        r6.f("if_clear_mode", r4);
    L20:
        r6.m(this.l);
        r6.l(this.m, this.g);
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
