package com.bytedance.android.shopping.store.hybridproduct.actionhandler;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.lifecycle.m;
import com.bytedance.android.shopping.store.slicecard.SliceActionType;
import com.bytedance.android.shopping.store.utils.p;
import com.bytedance.android.shopping.store.utils.q;
import com.bytedance.android.shopping.store.utils.s;
import com.bytedance.android.shopping.store.utils.v;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements com.bytedance.android.shopping.store.slicecard.a {
    public final ECStoreParam a;
    public final Fragment b;
    public final ECStoreViewModel c;
    public final ECShopHybridProductViewModel d;

    public final q e() {
        ECShopHybridProductViewModel r0 = this.d;
        String r1 = null;
        if (r0 == null) goto L5;
        ECStoreParam r2 = r0.getStoreParam();
    L6:
        if (r2 == null) goto L8;
        ProductBasicRequestParam r3 = r2.getProductBasicRequestParam();
    L9:
        ECShopHybridProductViewModel r4 = this.d;
        if (r3 == null) goto L14;
        boolean r5 = true;
        if (r3.isCustom() != true) goto L14;
    L15:
        if (r3 == null) goto L18;
        r1 = r3.getMaterialId();
    L18:
        return c.a(r4, r5, r1);
    L14:
        r5 = false;
        goto L15
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public e(Fragment r2, ECStoreViewModel r3, ECShopHybridProductViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        if (r3 == null) goto L5;
        ECStoreParam r5 = r3.getStoreParam();
    L6:
        this.a = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void b(StoreV2ProductItemVO r1, View r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r2, "target");
        com.bytedance.android.shopping.store.slicecard.a.C0017a.c(r1, r2);
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void a(ShopSlcProductItemV2 r20, View r21, Map<String, ? extends Object> r22, Map<String, ? extends Object> r23) {
        Intrinsics.checkNotNullParameter(r20, "item");
        Intrinsics.checkNotNullParameter(r21, "target");
        if (r22 == null) goto L5;
        String r7 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r22, "schema", null);
    L6:
        String r8 = k.j(r7);
        boolean r9 = false;
        if (r8.length() != 0) goto L9;
        boolean r10 = true;
    L10:
        if (r10 == false) goto L17;
        dm.a.b r2 = dm.a.a("OpenProductDetailActionHandler");
        StringBuilder r3 = new StringBuilder("schema 为空 ");
        if (r22 == null) goto L14;
        Object r0 = r22.get("schema");
    L15:
        r3.append(r0);
        r2.b(r3.toString(), null);
        return;
    L14:
        r0 = null;
        goto L15
    L17:
        int r5 = v.a;
        ECShopHybridProductViewModel r6 = this.d;
        if (r6 == null) goto L22;
        jm.a<LayoutTypes> r11 = r6.getLayoutType();
        if (r11 == null) goto L22;
        LayoutTypes r12 = (LayoutTypes) r11.getValue();
    L24:
        if (r12 != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L26;
        r9 = true;
    L26:
        String r13 = v.a(r22, Boolean.valueOf(r9)).b;
        int r1 = p.a;
        String r4 = p.a(PageFinder.via(this.b), r13, (Map) r20.v.getValue());
        Set<String> r14 = s.a;
        JSONObject r15 = s.d(e(), r20.f);
        String r16 = com.bytedance.android.ec.store.utils.b.a(r8, r4);
        if (r16 != null) goto L29;
        return;
    L29:
        hm.b r17 = hm.b.c;
        Context r18 = this.b.requireContext();
        ECStoreParam r19 = this.a;
        if (r19 == null) goto L32;
        Integer r24 = r19.getFollowStatus();
    L33:
        String r110 = String.valueOf(r24);
        ECStoreViewModel r25 = this.c;
        if (r25 == null) goto L38;
        Map<String, Object> r26 = r25.getAdParams();
        if (r26 == null) goto L38;
        r26.put("product_id", r20.j);
        Unit r27 = Unit.INSTANCE;
        Map<String, Object> r111 = r26;
    L39:
        int r28 = ECSdk.a;
        IAdapterService r29 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r29 == null) goto L44;
        wu1.a r30 = r29.getECLiveStateController();
        if (r30 == null) goto L44;
        r30.e();
    L44:
        com.bytedance.android.ec.store.common.starter.e.b(r17, r18, r16, r110, r15, r111, null, r20.q, 128);
        com.bytedance.android.ec.sdk.helper.c r31 = com.bytedance.android.ec.sdk.helper.c.a;
        r31.b("SHOP", "[click product]productId:" + r20.j);
        StringBuilder r32 = new StringBuilder("[click product]secShopId:");
        ECStoreParam r33 = this.a;
        if (r33 == null) goto L47;
        String r34 = r33.getSecShopId();
    L48:
        r32.append(r34);
        r31.b("SHOP", r32.toString());
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L58
        if (r23 == null) goto L52;
        Object r36 = r23.get("event_params");     // Catch: Throwable -> L58
    L54:
        if ((r36 instanceof Map) == true) goto L56;
        r36 = null;
    L56:
        Object r37 = Result.constructor-impl((Map) r36);     // Catch: Throwable -> L58
    L61:
        if (Result.isFailure-impl(r37) == false) goto L63;
        r37 = null;
    L63:
        Map r38 = (Map) r37;
        if (r38 != null) goto L66;
        r38 = MapsKt.emptyMap();
    L66:
        Set<String> r39 = s.a;
        Map<String, String> r40 = r20.f;
        q r41 = e();
        int r112 = r20.h;
        PageFinder r113 = PageFinder.via(this.b);
        ECShopHybridProductViewModel r42 = this.d;
        if (r42 == null) goto L71;
        jm.a<Integer> r43 = r42.getProductViewsNum();
        if (r43 == null) goto L71;
        Integer r114 = (Integer) r43.getValue();
    L72:
        ECShopHybridProductViewModel r44 = this.d;
        if (r44 == null) goto L77;
        jm.a<Integer> r45 = r44.getTotalProductNum();
        if (r45 == null) goto L77;
        Integer r115 = (Integer) r45.getValue();
    L78:
        Map r46 = MapsKt.plus(s.c(r40, r41, r13, r112, r113, r114, r115, Integer.valueOf(r20.i), 256), r38);
        ECShopHybridProductViewModel r47 = this.d;
        if (r47 == null) goto L81;
        com.bytedance.android.ec.store.window.f.b(r21, r13, r20, r46, r47);
    L81:
        Map<Long, m> r48 = com.bytedance.android.shopping.store.lifecycle.a.a;
        ECShopHybridProductViewModel r49 = this.d;
        if (r49 == null) goto L86;
        ECStoreParam r50 = r49.getStoreParam();
        if (r50 == null) goto L86;
        Long r51 = Long.valueOf(r50.getLifecycleMonitorId());
    L87:
        m r52 = com.bytedance.android.shopping.store.lifecycle.a.a(r51);
        if (r52 == null) goto L93;
        com.bytedance.android.shopping.store.lifecycle.c.a.a(r52, "click_product", r46, null, 4);
        return;
    L93:
        return;
    L86:
        r51 = null;
    L77:
        r115 = null;
    L71:
        r114 = null;
        goto L72
    L52:
        r36 = null;
    L58:
        th = move-exception;
        Result.Companion r53 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L61
    L47:
        r34 = null;
    L38:
        r111 = null;
        goto L39
    L32:
        r24 = null;
    L22:
        r12 = null;
        goto L24
    L9:
        r10 = false;
        goto L10
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void c(SliceActionType r1, ShopSlcProductItemV2 r2, View r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "actionType");
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "target");
        com.bytedance.android.shopping.store.slicecard.a.C0017a.b(r1, r2, r3);
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void d(SliceActionType r1, StoreV2ProductItemVO r2, View r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "actionType");
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "target");
        com.bytedance.android.shopping.store.slicecard.a.C0017a.a(r1, r2, r3);
    }
}
