package com.bytedance.android.livesdk.livecommerce.eventcenter;

import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.LiveListTabResortAbility;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.e0;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.f0;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.h0;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.l;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.m;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.n;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.o;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.r;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.s;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.t;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.u;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.v;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.y;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements com.bytedance.android.livesdk.livecommerce.ability.c {
    public static final h a = null;

    public h() {
    }

    static {
        a = new h();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.c
    public final Map<String, com.bytedance.android.livesdk.livecommerce.ability.d<?>> getAbilities() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("tab_resort", new LiveListTabResortAbility()), TuplesKt.to("show_dialog", new e0()), TuplesKt.to("biz_change_store", new com.bytedance.android.livesdk.livecommerce.eventcenter.ability.j()), TuplesKt.to("open_schema", new t()), TuplesKt.to("showPopCard", new f0()), TuplesKt.to("add_cart", new com.bytedance.android.livesdk.livecommerce.eventcenter.ability.c()), TuplesKt.to("show_toast", new h0()), TuplesKt.to("live_list_show_add_cart_motion", new com.bytedance.android.livesdk.livecommerce.eventcenter.ability.d()), TuplesKt.to("pop_card_show", new f0()), TuplesKt.to("pop_card_close", new l()), TuplesKt.to("live_list_open", new r()), TuplesKt.to("live_list_close", new com.bytedance.android.livesdk.livecommerce.eventcenter.ability.k()), TuplesKt.to("live_list_refresh", new v()), TuplesKt.to("live_list_back_top", new n()), TuplesKt.to("change_list_component_visibility", new o()), TuplesKt.to("card_jump_to_detail", new com.bytedance.android.livesdk.livecommerce.eventcenter.ability.e()), TuplesKt.to("card_jump_to_order", new com.bytedance.android.livesdk.livecommerce.eventcenter.ability.f()), TuplesKt.to("live_guide", new m()), TuplesKt.to("live_report_log", new y()), TuplesKt.to("redirect_api_path", new u()), TuplesKt.to("open_product_detail", new s())});
    }
}
