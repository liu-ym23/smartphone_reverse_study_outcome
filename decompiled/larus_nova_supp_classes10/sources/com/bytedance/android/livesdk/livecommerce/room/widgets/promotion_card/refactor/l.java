package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.event.n1;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements Runnable {
    public final /* synthetic */ ml.b a;
    public final /* synthetic */ RoomContextController b;
    public final /* synthetic */ ECUIPromotion c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ gf.a e;
    public final /* synthetic */ Ref.ObjectRef f;
    public final /* synthetic */ Ref.ObjectRef g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ Map j;
    public final /* synthetic */ String k;

    public l(ml.b r1, RoomContextController r2, ECUIPromotion r3, boolean r4, gf.a r5, Ref.ObjectRef r6, Ref.ObjectRef r7, String r8, String r9, Map r10, String r11) {
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
    }

    public final void a() {
        n1 r6 = new n1(this.a.c(), this.a.roomId(), "live_popup_card", this.b);
        r6.q(this.c.getPromotionId(), this.c.getEventItemType(), this.c.getProductId(), this.c.getEventParams(), this.c.getExtraEventParams());
        r6.f("label_name", this.c.getTrackLabelName());
        r6.d("has_flash_notice", this.d ? 1 : 0);
        r6.f("label_name_live", this.c.getLabelNameLive());
        r6.f("base_verified_category", this.c.getBaseVerifiedCategory());
        if (this.e.a() == false) goto L8;
        Boolean r0 = (Boolean) this.f.element;
        if (r0 == null) goto L7;
        r6.r(r0.booleanValue());
    L7:
        r6.p((Map) this.g.element);
        r6.f("is_preview", String.valueOf(this.b.v()));
        this.b.q().sendLogger("livesdk_preview_guide_show", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("module_name", "ecommerce_info_card")}));
    L8:
        String r1 = this.h;
        if (r6.c.g("if_clear_mode").booleanValue() == true) goto L11;
        r6.f("if_clear_mode", r1);
    L11:
        r6.n(this.i);
        r6.m(this.j);
        r6.l(this.k, this.i);
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
