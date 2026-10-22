package com.bytedance.android.shopping.store.router.hybridpage.action;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.event.c;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.ec.store.common.starter.e;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.window.f;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.lifecycle.m;
import com.bytedance.android.shopping.store.router.hybridpage.presenter.product.b;
import com.bytedance.android.shopping.store.router.hybridpage.slice.SliceProductCardData;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.slicecard.SliceActionType;
import com.bytedance.android.shopping.store.utils.p;
import com.bytedance.android.shopping.store.utils.q;
import com.bytedance.android.shopping.store.utils.s;
import com.bytedance.android.shopping.store.utils.v;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a implements com.bytedance.android.shopping.store.slicecard.a {
    public final Fragment a;
    public final SliceProductCardData b;
    public final c c;

    public final q e() {
        SliceProductCardData r1 = this.b;
        String r2 = null;
        if (r1 == null) goto L5;
        ProductBasicRequestParam r3 = r1.getProductBasicRequestParam();
    L6:
        SliceProductCardData r4 = this.b;
        if (r4 == null) goto L9;
        String r5 = r4.getEcomEntranceFrom();
    L10:
        SliceProductCardData r6 = this.b;
        if (r6 == null) goto L13;
        String r7 = r6.getSearchParams();
    L14:
        SliceProductCardData r8 = this.b;
        if (r8 == null) goto L17;
        String r9 = r8.getPreProductId();
    L18:
        SliceProductCardData r10 = this.b;
        if (r10 == null) goto L21;
        String r11 = r10.getPreRoomId();
    L22:
        SliceProductCardData r12 = this.b;
        if (r12 == null) goto L25;
        String r13 = r12.getPreGroupId();
    L26:
        SliceProductCardData r14 = this.b;
        if (r14 != null) goto L29;
    L31:
        boolean r15 = false;
    L32:
        SliceProductCardData r16 = this.b;
        if (r16 == null) goto L35;
        String r17 = r16.getShareContent();
    L36:
        SliceProductCardData r18 = this.b;
        if (r18 == null) goto L39;
        String r19 = r18.getShareObject();
    L40:
        SliceProductCardData r20 = this.b;
        if (r20 == null) goto L43;
        String r110 = r20.getPageName();
    L44:
        SliceProductCardData r21 = this.b;
        if (r21 == null) goto L47;
        String r111 = r21.getEntranceLocation();
    L48:
        SliceProductCardData r22 = this.b;
        if (r22 == null) goto L51;
        Integer r112 = r22.getFollowStatus();
    L52:
        SliceProductCardData r23 = this.b;
        if (r23 == null) goto L55;
        String r113 = r23.getTempId();
    L56:
        SliceProductCardData r24 = this.b;
        if (r24 == null) goto L59;
        String r114 = r24.getStoreSourcePage();
    L60:
        SliceProductCardData r25 = this.b;
        if (r25 == null) goto L63;
        String r115 = r25.getStoreSourceMethod();
    L64:
        SliceProductCardData r26 = this.b;
        if (r26 == null) goto L67;
        String r27 = r26.getStoreGroupType();
    L68:
        SliceProductCardData r28 = this.b;
        if (r28 == null) goto L71;
        String r29 = r28.getLiveAnchorId();
    L72:
        Set<String> r30 = s.a;
        jm.a<LayoutTypes> r31 = ((b) this).d.x.getLayoutType();
        if (r31 == null) goto L75;
        LayoutTypes r32 = (LayoutTypes) r31.getValue();
    L76:
        String r210 = s.f(r32);
        if (r3 != null) goto L79;
    L81:
        boolean r211 = false;
    L82:
        if (r3 == null) goto L84;
        String r33 = r3.getMaterialId();
    L85:
        SliceProductCardData r34 = this.b;
        if (r34 == null) goto L88;
        String r212 = (String) r34.getPassThroughParam("icon_type");
    L89:
        SliceProductCardData r35 = this.b;
        if (r35 == null) goto L93;
        r2 = (String) r35.getPassThroughParam("pass_through_api");
    L93:
        return new q(r5, r7, r9, r11, r13, r15, r17, r19, r110, r111, r112, r113, r114, r115, r27, r29, r210, CommentServiceId.HOT_SPOT, "0", r211, r33, r212, r2);
    L88:
        r212 = null;
        goto L89
    L84:
        r33 = null;
        goto L85
    L79:
        if (r3.isCustom() != true) goto L81;
        r211 = true;
        goto L82
    L75:
        r32 = null;
        goto L76
    L71:
        r29 = null;
        goto L72
    L67:
        r27 = null;
        goto L68
    L63:
        r115 = null;
        goto L64
    L59:
        r114 = null;
        goto L60
    L55:
        r113 = null;
        goto L56
    L51:
        r112 = null;
        goto L52
    L47:
        r111 = null;
        goto L48
    L43:
        r110 = null;
        goto L44
    L39:
        r19 = null;
        goto L40
    L35:
        r17 = null;
        goto L36
    L29:
        if (r14.isEcShare() != true) goto L31;
        r15 = true;
        goto L32
    L25:
        r13 = null;
        goto L26
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public a(Fragment r2, SliceProductCardData r3, HybridPageViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.b = r3;
        this.c = r4;
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
        int r9 = 0;
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
        String r5 = v.a(r22, null).b;
        if (r23 == null) goto L20;
        String r1 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r23, "live_room_id", null);
    L21:
        String r16 = k.j(r1);
        int r4 = p.a;
        String r6 = p.a(PageFinder.via(this.a), r5, (Map) r20.v.getValue());
        Set<String> r11 = s.a;
        JSONObject r14 = s.d(e(), r20.f);
        String r12 = com.bytedance.android.ec.store.utils.b.a(r8, r6);
        if (r12 != null) goto L24;
        return;
    L24:
        hm.b r13 = hm.b.c;
        Context r15 = this.a.requireContext();
        SliceProductCardData r17 = this.b;
        if (r17 == null) goto L27;
        Integer r18 = r17.getFollowStatus();
    L28:
        String r19 = String.valueOf(r18);
        b r24 = (b) this;
        Map<String, Object> r25 = r24.d.x.getAdParams();
        if (r25 == null) goto L31;
        r25.put("product_id", r20.j);
        Unit r26 = Unit.INSTANCE;
        Map<String, Object> r110 = r25;
    L32:
        e.b(r13, r15, r12, r19, r14, r110, r16, r20.q, 128);
        com.bytedance.android.ec.sdk.helper.c r27 = com.bytedance.android.ec.sdk.helper.c.a;
        r27.b("SHOP", "[click product]productId:" + r20.j);
        StringBuilder r28 = new StringBuilder("[click product]secShopId:");
        SliceProductCardData r111 = this.b;
        if (r111 == null) goto L35;
        String r112 = r111.getSecShopId();
    L36:
        r28.append(r112);
        r27.b("SHOP", r28.toString());
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L46
        if (r23 == null) goto L40;
        Object r30 = r23.get("event_params");     // Catch: Throwable -> L46
    L42:
        if ((r30 instanceof Map) == true) goto L44;
        r30 = null;
    L44:
        Object r31 = Result.constructor-impl((Map) r30);     // Catch: Throwable -> L46
    L49:
        if (Result.isFailure-impl(r31) == false) goto L51;
        r31 = null;
    L51:
        Map r32 = (Map) r31;
        if (r32 != null) goto L54;
        r32 = MapsKt.emptyMap();
    L54:
        Set<String> r33 = s.a;
        Map<String, String> r113 = r20.f;
        q r114 = e();
        int r115 = r20.h;
        PageFinder r116 = PageFinder.via(this.a);
        jm.a<Integer> r34 = r24.d.x.getProductViewsNum();
        if (r34 == null) goto L59;
        Integer r35 = (Integer) r34.getValue();
        if (r35 == null) goto L59;
        int r36 = r35.intValue();
    L60:
        Integer r117 = Integer.valueOf(r36);
        jm.a<Integer> r37 = r24.d.x.getTotalProductNum();
        if (r37 == null) goto L65;
        Integer r38 = (Integer) r37.getValue();
        if (r38 == null) goto L65;
        r9 = r38.intValue();
    L65:
        Map r39 = MapsKt.plus(s.c(r113, r114, r5, r115, r116, r117, Integer.valueOf(r9), Integer.valueOf(r20.i), 256), r32);
        c r40 = this.c;
        if (r40 == null) goto L68;
        f.b(r21, r5, r20, r39, r40);
    L68:
        Map<Long, m> r41 = com.bytedance.android.shopping.store.lifecycle.a.a;
        SliceProductCardData r42 = this.b;
        if (r42 == null) goto L71;
        Long r43 = Long.valueOf(r42.getLifecycleMonitorId());
    L72:
        m r44 = com.bytedance.android.shopping.store.lifecycle.a.a(r43);
        if (r44 == null) goto L78;
        com.bytedance.android.shopping.store.lifecycle.c.a.a(r44, "click_product", r39, null, 4);
        return;
    L78:
        return;
    L71:
        r43 = null;
    L59:
        r36 = 0;
        goto L60
    L40:
        r30 = null;
    L46:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L35:
        r112 = null;
        goto L36
    L31:
        r110 = null;
        goto L32
    L27:
        r18 = null;
        goto L28
    L20:
        r1 = null;
        goto L21
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
