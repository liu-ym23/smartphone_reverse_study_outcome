package com.bytedance.android.shopping.store.home.view;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.common.floatelement.StoreCartEntryConfig;
import com.bytedance.android.shopping.store.home.entity.ServiceEntryInfo;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l {
    public final s83.e a;
    public final Activity b;
    public final View c;
    public final ECStoreViewModel d;

    public final void a() {
        this.d.setEnterOtherPageCollaspeHeader(true);
        com.bytedance.android.shopping.store.home.entity.n r0 = (com.bytedance.android.shopping.store.home.entity.n) this.d.getHeaderArea().getValue();
        if (r0 == null) goto L25;
        com.bytedance.android.shopping.store.home.entity.g r1 = r0.e;
        if (r1 == null) goto L26;
        StoreCartEntryConfig r2 = r1.d;
        if (r2 == null) goto L27;
        String r3 = r2.getJumpUrl();
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L16:
        if ((!r4) == true) goto L19;
        r2 = null;
    L19:
        if (r2 == null) goto L28;
        this.d.doEventAction("click_cart_entrance", "a1.b6269.c5887.d31199", PageFinder.via(this.c), new Pair[]{TuplesKt.to("page_name", "store_page"), TuplesKt.to("store_type", "shop"), TuplesKt.to("click_area", "menu"), TuplesKt.to("author_id", this.d.getStoreParam().getStoreAccountParam().getUserId()), TuplesKt.to("shop_id", this.d.getStoreParam().getShopId()), TuplesKt.to("sec_shop_id", this.d.getStoreParam().getSecShopId())});
        int r5 = com.bytedance.android.ec.store.utils.b.a;
        String r6 = com.bytedance.android.ec.store.utils.b.b(r2.getJumpUrl(), "a1.b6269.c5887.d31199", PageFinder.via(this.c), null);
        if (r6 != null) goto L23;
        return;
    L23:
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.b, r6);
        return;
    L28:
        return;
    L11:
        if (StringsKt.isBlank(r3) == true) goto L14;
        r4 = false;
        goto L16
    L27:
        return;
    L26:
        return;
    }

    public final void b() {
        this.d.setEnterOtherPageCollaspeHeader(true);
        ECStoreViewModel r0 = this.d;
        Pair<String, String>[] r2 = new Pair[9];
        r2[0] = TuplesKt.to("click_area", "menu");
        r2[1] = TuplesKt.to("author_id", this.d.getStoreParam().getStoreAccountParam().getUserId());
        r2[2] = TuplesKt.to("sec_author_id", this.d.getStoreParam().getStoreAccountParam().getSecUserId());
        r2[3] = TuplesKt.to("shop_id", this.d.getStoreParam().getShopId());
        r2[4] = TuplesKt.to("sec_shop_id", this.d.getStoreParam().getSecShopId());
        r2[5] = TuplesKt.to("entrance_location", this.d.getStoreParam().getEntranceLocation());
        Integer r1 = this.d.getStoreParam().getFollowStatus();
        String r3 = null;
        if (r1 == null) goto L5;
        String r4 = String.valueOf(r1.intValue());
    L6:
        r2[6] = TuplesKt.to("follow_status", r4);
        r2[7] = TuplesKt.to("page_name", "store_page");
        r2[8] = TuplesKt.to("store_type", "shop");
        r0.doEventAction("click_consultation", r2);
        com.bytedance.android.shopping.store.home.entity.n r5 = (com.bytedance.android.shopping.store.home.entity.n) this.d.getHeaderArea().getValue();
        if (r5 == null) goto L20;
        com.bytedance.android.shopping.store.home.entity.g r6 = r5.e;
        if (r6 == null) goto L21;
        ServiceEntryInfo r7 = r6.h;
        if (r7 == null) goto L22;
        String r8 = r7.getSchema();
        if (r8 != null) goto L15;
        return;
    L15:
        if (a2.b(r8) == false) goto L17;
        r3 = r8;
    L17:
        if (r3 == null) goto L24;
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.b, r3);
        return;
    L24:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final boolean d() {
        com.bytedance.android.shopping.store.home.entity.n r0 = (com.bytedance.android.shopping.store.home.entity.n) this.d.getHeaderArea().getValue();
        if (r0 == null) goto L9;
        com.bytedance.android.shopping.store.home.entity.g r1 = r0.e;
        if (r1 == null) goto L9;
        StoreCartEntryConfig r2 = r1.d;
        if (r2 == null) goto L9;
        String r3 = r2.getJumpUrl();
    L11:
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L18:
        return !r4;
    L13:
        if (StringsKt.isBlank(r3) == true) goto L16;
        r4 = false;
    L9:
        r3 = null;
        goto L11
    }

    public final boolean e() {
        com.bytedance.android.shopping.store.home.entity.n r0 = (com.bytedance.android.shopping.store.home.entity.n) this.d.getHeaderArea().getValue();
        if (r0 == null) goto L13;
        com.bytedance.android.shopping.store.home.entity.g r1 = r0.e;
        if (r1 == null) goto L13;
        ServiceEntryInfo r2 = r1.h;
        if (r2 == null) goto L13;
        String r3 = r2.getSchema();
        if (r3 == null) goto L13;
        if (a2.b(r3) != true) goto L13;
        return true;
    L13:
        return false;
    }

    public final ECUrlModel f() {
        com.bytedance.android.shopping.store.home.entity.n r0 = (com.bytedance.android.shopping.store.home.entity.n) this.d.getHeaderArea().getValue();
        if (r0 == null) goto L9;
        com.bytedance.android.shopping.store.home.entity.g r1 = r0.e;
        if (r1 == null) goto L9;
        ServiceEntryInfo r2 = r1.h;
        if (r2 == null) goto L9;
        return r2.getIcon();
    L9:
        return null;
    }

    public static View g(View r1) {
        if ((r1.getParent() instanceof View) == false) goto L10;
        Object r2 = r1.getParent();
        if (r2 == null) goto L9;
        return g((View) r2);
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L10:
        return r1;
    }

    public final void c(View r7) {
        Intrinsics.checkNotNullParameter(r7, "view");
        this.d.setEnterOtherPageCollaspeHeader(true);
        com.bytedance.android.shopping.store.home.entity.n r0 = (com.bytedance.android.shopping.store.home.entity.n) this.d.getHeaderArea().getValue();
        if (r0 == null) goto L7;
        com.bytedance.android.shopping.store.home.entity.g r1 = r0.e;
        if (r1 == null) goto L7;
        String r2 = r1.g;
    L8:
        String r3 = a2.d(r2);
        if (r3 != null) goto L11;
        boolean r4 = ECServiceManager.a;
        r3 = ((s83.g) ECServiceManager.c(s83.g.class)).a();
    L11:
        String r5 = a2.d(r3);
        if (r5 != null) goto L14;
        r5 = i.f;
    L14:
        int r6 = com.bytedance.android.ec.store.utils.b.a;
        String r8 = com.bytedance.android.ec.store.utils.b.b(r5, "a1.b6269.c5887.d3813", PageFinder.via(this.c), null);
        if (r8 != null) goto L17;
        return;
    L17:
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.b, r8);
        this.d.doEventAction("click_order_entrance", "a1.b6269.c5887.d3813", PageFinder.via(r7), new Pair[]{TuplesKt.to("enter_from", "others_store_page"), TuplesKt.to("click_area", "menu")});
        return;
    L7:
        r2 = null;
        goto L8
    }

    public l(Activity r2, View r3, ECStoreViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        boolean r5 = ECServiceManager.a;
        s83.g r6 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r6 == null) goto L5;
        s83.e r7 = r6.W();
    L6:
        this.a = r7;
        return;
    L5:
        r7 = null;
        goto L6
    }
}
