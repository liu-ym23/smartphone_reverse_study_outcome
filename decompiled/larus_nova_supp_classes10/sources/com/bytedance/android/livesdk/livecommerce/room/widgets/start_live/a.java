package com.bytedance.android.livesdk.livecommerce.room.widgets.start_live;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.process.ProcessDomain;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import vi2.e0;
import xi2.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ StartLivePromotionButton a;
    public final /* synthetic */ Context b;

    public a(StartLivePromotionButton r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        Pair[] r0 = new Pair[2];
        com.bytedance.android.ec.adapter.api.state.c r1 = (com.bytedance.android.ec.adapter.api.state.c) this.a.i.invoke();
        if (r1 == null) goto L5;
        String r2 = r1.a;
    L6:
        r0[0] = TuplesKt.to("anchor_id", String.valueOf(r2));
        r0[1] = TuplesKt.to("event_page", "live_take_page");
        com.bytedance.android.livesdk.livecommerce.room.f.d("livesdk_product_icon_click", MapsKt.mapOf(r0));
        StartLivePromotionButton r3 = this.a;
        if (((Boolean) r3.e.getValue(r3, StartLivePromotionButton.j[1])).booleanValue() == false) goto L14;
        com.bytedance.android.ec.adapter.api.state.c r4 = (com.bytedance.android.ec.adapter.api.state.c) this.a.i.invoke();
        if (r4 == null) goto L12;
        Object r5 = r4.a;
        if (r5 == null) goto L12;
    L13:
        com.bytedance.android.livesdk.livecommerce.room.f.d("livesdk_mp_remind_toast_show", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("anchor_id", String.valueOf(r5)), TuplesKt.to("_param_live_platform", "live"), TuplesKt.to("live_status_type", "live_before")}));
        ECToast r9 = ECToast.INSTANCE;
        Context r6 = this.b;
        r9.showToast(r6, th.a.g(r6, 2131896624), Boolean.TRUE);
        return;
    L12:
        r5 = 0L;
        goto L13
    L14:
        com.bytedance.android.ec.adapter.api.state.c r10 = (com.bytedance.android.ec.adapter.api.state.c) this.a.i.invoke();
        if (r10 == null) goto L27;
        Bundle r11 = r10.d;
        int r7 = com.bytedance.android.ec.adapter.api.state.c.e;
        if (r11.getBoolean("EXTRA_BOOL_ENABLE_SHOW_COMMERCE_SALE", false) == false) goto L19;
        StartLivePromotionButton r12 = this.a;
        Context r13 = this.b;
        com.bytedance.android.ec.adapter.api.state.c r14 = (com.bytedance.android.ec.adapter.api.state.c) r12.i.invoke();
        com.bytedance.android.livesdk.livecommerce.utils.k.i(r13, ECSettingKeys.j().a());
        int r15 = lh.b.a;
        lh.b.c(ProcessDomain.LIVE, "开播页", "跳转全屏管理页");
        return;
    L19:
        final StartLivePromotionButton r16 = this.a;
        final Context r17 = this.b;
        r16.getClass();
        if (hh2.f.f() == false) goto L22;
        Function1<c0, Unit> r18 = new StartLivePromotionButton$requestForShoppingAccess$1(r16, r17);
        String r19 = vi2.h.a;
        r16.w().add(vi2.h.e(null, null, si2.g.J, new e0()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r18, r17), new c(r17)));
        return;
    L22:
        int r20 = ECSdk.a;
        IAdapterService r21 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r21 == null) goto L30;
        r21.requestForShoppingAccess(r17, "live_broadcast_preview");
        return;
    L30:
        return;
    L27:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
