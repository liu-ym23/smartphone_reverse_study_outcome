package com.bytedance.android.shopping.anchorv4.voavhs.car;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.hybrid.utils.r;
import com.bytedance.android.ec.core.utils.d1;
import com.bytedance.android.ec.core.utils.g0;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public final AnchorV4CarAddressMeta a;
    public final Context b;
    public final e c;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r1, Object r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final Context getContext() {
        return this.b;
    }

    public a(AnchorV4CarAddressMeta r2, Context r3, e r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r10, Action r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r11, "action");
        String r13 = r11.getId();
        if (r13 != null) goto L6;
        return;
    L6:
        if (r13.hashCode() == 1733388578) goto L9;
        return;
    L9:
        if (r13.equals("car_address_title") == false) goto L42;
        AnchorV4CarAddressMeta r14 = this.a;
        if (r14 == null) goto L43;
        AnchorV4CarAddressBusinessMeta r15 = r14.getBusinessMeta();
        if (r15 == null) goto L44;
        String r16 = r15.getLinkUrl();
        if (r16 == null) goto L45;
        int r17 = p0.a;
        int r18 = g0.a;
        if (g0.a(this.b) == false) goto L19;
        String r19 = "1";
    L20:
        String r110 = p0.d(r16, "gpsOn", r19);
        ProductSelectPoiInfo r111 = d1.a;
        Context r112 = null;
        if (r111 == null) goto L23;
        String r113 = r111.getPoiId();
    L24:
        if (r113 != null) goto L31;
        AnchorV4CarAddressMeta r114 = this.a;
        if (r114 == null) goto L30;
        AnchorV4CarAddressBusinessMeta r115 = r114.getBusinessMeta();
        if (r115 == null) goto L30;
        r113 = r115.getSelectedShopId();
    L30:
        r113 = null;
    L31:
        if (r113 != null) goto L33;
        r113 = "";
    L33:
        String r116 = p0.d(r110, "selectedShopId", r113);
        Context r117 = this.b;
        if ((r117 instanceof Activity) == false) goto L37;
        r112 = r117;
    L37:
        Activity r118 = (Activity) r112;
        if (r118 == null) goto L40;
        r.a(r116, r118);
    L40:
        f.a.a(this.c, "click_offline_store_entrance", null, false, null, null, null, null, 254);
        return;
    L23:
        r113 = null;
        goto L24
    L19:
        r19 = "0";
        goto L20
    L45:
        return;
    L44:
        return;
    L43:
        return;
    }
}
