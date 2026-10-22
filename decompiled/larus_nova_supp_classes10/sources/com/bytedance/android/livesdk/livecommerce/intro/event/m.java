package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.livesdk.livecommerce.event.m1;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
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
public final class m implements Runnable {
    public final /* synthetic */ ml.b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ RoomContextController c;
    public final /* synthetic */ IntroPromotionVO d;
    public final /* synthetic */ BtmItemBuilder e;
    public final /* synthetic */ String f;
    public final /* synthetic */ Ref.ObjectRef g;
    public final /* synthetic */ Ref.ObjectRef h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;

    public m(com.bytedance.android.livesdk.livecommerce.room.model.e r1, String r2, RoomContextController r3, IntroPromotionVO r4, BtmItemBuilder r5, String r6, Ref.ObjectRef r7, Ref.ObjectRef r8, String r9, String r10) {
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
    }

    public final void a() {
        m1 r6 = new m1(this.a.c(), this.a.roomId(), "live_popup_card", this.b, this.c);
        r6.p(this.d.getPromotionId(), this.d.getEventItemType(), this.d.getProductId(), this.d.getEventParams(), this.d.getExtraEventParams());
        r6.f("label_name", this.d.getTrackLabelName());
        String r0 = this.d.getLabelNameLive();
        Intrinsics.checkNotNullParameter(r0, "labelNameLive");
        r6.f("label_name_live", r0);
        r6.f("base_verified_category", this.d.getBaseVerifiedCategory());
        BtmItemBuilder r1 = this.e;
        if (r1 == null) goto L5;
        r6.f("btm_id", BtmSDK.INSTANCE.createBtmId(r1.copy().setEnterPage(false).build()));
    L5:
        r6.n(this.f);
        Boolean r2 = (Boolean) this.g.element;
        if (r2 != null) goto L8;
    L12:
        r6.f("is_ecom_new", "1");
        r6.o((Map) this.h.element);
        if (this.c.v() == false) goto L15;
        this.c.q().sendLogger("livesdk_preview_guide_click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("module_name", "ecommerce_info_card")}));
    L15:
        String r3 = this.i;
        if (r6.c.g("if_clear_mode").booleanValue() == true) goto L18;
        r6.f("if_clear_mode", r3);
    L18:
        r6.l(this.j, this.f);
        return;
    L8:
        if (r2.booleanValue() == false) goto L10;
        String r4 = BDLocationException.ERROR_TIMEOUT;
    L11:
        r6.f("screen_type", r4);
        r6.f("is_preview", String.valueOf(this.c.v()));
        goto L12
    L10:
        r4 = "1";
        goto L11
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
