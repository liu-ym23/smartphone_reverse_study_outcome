package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.shopping.anchorv3.i;
import com.bytedance.android.shopping.anchorv3.view.AnchorV4SearchEntryView;
import com.bytedance.android.shopping.anchorv4.components.topbanner.HalfStrandVO;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.topbanner.TopBannerVO;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.prepurchase.arch.container.state.m;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import vg3.l;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ LiveSearchComponent a;

    public d(LiveSearchComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r26) {
        m r1 = (m) r26;
        Intrinsics.checkNotNullParameter(r1, "pair");
        final i r2 = (i) r1.a;
        TopBannerVO r3 = (TopBannerVO) r1.b;
        HalfStrandVO r4 = (HalfStrandVO) r1.c;
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this.a, "searchSuggest=" + r2 + ", topBannerVO=" + r3 + ", halfStrandData=" + r4);
        if (r3 == null) goto L5;
        LiveSearchComponent.h2(this.a, r2, r3);
        return;
    L5:
        if (r2 != null) goto L7;
        return;
    L7:
        if (r4 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        final LiveSearchComponent r11 = this.a;
        r11.getClass();
        l r6 = (l) r11.N1(l.class);
        if (r6 == null) goto L15;
        boolean r7 = r6.s();
    L16:
        ViewGroup.LayoutParams r12 = null;
        if (r7 == false) goto L19;
    L35:
        boolean r8 = false;
    L36:
        if (r8 == false) goto L134;
        if (r5 == true) goto L135;
        View r9 = r11.e2();
        if (r9 == null) goto L131;
        ViewGroup r10 = (ViewGroup) r9;
        r10.removeAllViews();
        PageMeta r13 = (PageMeta) r11.O1().d().getData().b.a();
        if (r13 == null) goto L43;
        LinkedTreeMap r14 = r13.getTrackMeta();
    L44:
        PageMeta r15 = (PageMeta) r11.O1().d().getData().b.a();
        if (r15 == null) goto L47;
        final CommonMeta r16 = r15.getCommonMeta();
    L49:
        if (r16 == null) goto L51;
        Boolean r17 = Boolean.valueOf(r16.isLuban());
    L52:
        if (r16 == null) goto L54;
        Boolean r18 = Boolean.valueOf(r16.getThirdParty());
    L55:
        if (r16 == null) goto L57;
        String r19 = r16.getProductId();
    L58:
        Boolean r20 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r11.O1())).b.d.a();
        if (r20 == null) goto L61;
        boolean r21 = r20.booleanValue();
    L62:
        Boolean r110 = Boolean.valueOf(r21);
        StringBuilder r22 = new StringBuilder();
        if (r14 == null) goto L68;
        Object r23 = r14.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r23 == null) goto L68;
        String r24 = r23.toString();
        if (r24 == null) goto L68;
    L69:
        r22.append(r24);
        r22.append("_");
        if (r16 == null) goto L72;
        String r25 = r16.getSourcePage();
    L73:
        r22.append(r25);
        String r27 = r22.toString();
        if (r16 == null) goto L76;
        String r28 = r16.getSearchPageSchema();
    L77:
        if (r16 == null) goto L79;
        Map r29 = r16.getSearchPageParams();
    L80:
        final com.bytedance.android.shopping.anchorv3.widget.f r30 = new com.bytedance.android.shopping.anchorv3.widget.f(r17, r18, r19, r110, "search_order_center_search_product_detail_half_screen", "half_screen_recom_search", r27, r28, r29, 32);
        w r31 = (w) r11.N1(w.class);
        if (r31 == null) goto L85;
        ProductDetailEventService.b r111 = r31.m();
        if (r111 == null) goto L85;
        Boolean r32 = Boolean.valueOf(com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r111, "product_detail_trending_show", false, null, null, 12));
    L87:
        if (Intrinsics.areEqual(r32, Boolean.TRUE) == false) goto L91;
        w r33 = (w) r11.N1(w.class);
        if (r33 == null) goto L91;
        w.a.a(r33, "product_detail_trending_show", null, 6);
    L91:
        w r34 = (w) r11.N1(w.class);
        if (r34 == null) goto L106;
        ProductDetailEventService.b r35 = r34.m();
        if (r35 == null) goto L106;
        Pair[] r36 = new Pair[8];
        r36[0] = TuplesKt.to("words_source", "search_product_detail_half_screen");
        r36[1] = TuplesKt.to("words_content", r2.a);
        r36[2] = TuplesKt.to("impr_id", r2.c);
        r36[3] = TuplesKt.to(SimilarProductParam.ENTER_FROM, "search_order_center_search_product_detail_half_screen");
        r36[4] = TuplesKt.to("enter_from_second", r30.h);
        r36[5] = TuplesKt.to("group_id", r2.b);
        if (r16 == null) goto L98;
        String r37 = r16.getProductId();
    L99:
        r36[6] = TuplesKt.to("from_gid", r37);
        if (r16 == null) goto L102;
        String r38 = r16.getProductId();
    L103:
        r36[7] = TuplesKt.to("enter_group_id", r38);
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r112 = r35.d(MapsKt.mapOf(r36));
        if (r112 == null) goto L106;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r112, "trending_words_show", false, null, null, 12);
        goto L106
    L102:
        r38 = null;
        goto L103
    L98:
        r37 = null;
    L106:
        int r39 = AnchorV4SearchEntryView.c;
        Context r40 = r11.e2().getContext();
        Intrinsics.checkNotNullParameter(r40, "context");
        final View r113 = new AnchorV4SearchEntryView(r40, null, 6, 0);
        r113.a(r2, new LiveSearchComponent$createSearchView$$inlined$apply$lambda$1(r113, r11, r2, r30, r16));
        r10.addView(r113, -1, -1);
        int[] r41 = new int[2];
        Object r42 = r11.e2().getParent();
        if ((r42 instanceof View) == true) goto L109;
        r42 = null;
    L109:
        View r43 = (View) r42;
        if (r43 == null) goto L112;
        r43.getLocationInWindow(r41);
    L112:
        int r44 = r41[1] - ((Number) r11.s.getValue()).intValue();
        ViewGroup.LayoutParams r45 = r10.getLayoutParams();
        if (r45 != null) goto L115;
        r45 = null;
    L122:
        r10.setLayoutParams(r45);
        ViewGroup.LayoutParams r46 = r10.getLayoutParams();
        if ((r46 instanceof ViewGroup.MarginLayoutParams) == false) goto L126;
        r12 = r46;
    L126:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r12;
        if (r114 == null) goto L129;
        com.bytedance.android.shopping.prepurchase.arch.container.intf.a r47 = r11.O1().getContainerAbility().i7();
        r114.topMargin = ((((r47.b - r47.c) - r47.d) - ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r11.O1())).b.b) - com.bytedance.android.shopping.extensions.b.b(40)) - r44;
        r114.bottomMargin = 0;
        r10.setLayoutParams(r114);
    L129:
        r10.requestLayout();
        return;
    L115:
        if ((r45 instanceof CoordinatorLayout.LayoutParams) == false) goto L118;
        ((CoordinatorLayout.LayoutParams) r45).gravity = 48;
    L120:
        Unit r48 = Unit.INSTANCE;
        goto L122
    L118:
        if ((r45 instanceof FrameLayout.LayoutParams) == false) goto L120;
        ((FrameLayout.LayoutParams) r45).gravity = 48;
    L85:
        r32 = null;
        goto L87
    L79:
        r29 = null;
        goto L80
    L76:
        r28 = null;
        goto L77
    L72:
        r25 = null;
    L68:
        r24 = "";
        goto L69
    L61:
        r21 = true;
        goto L62
    L57:
        r19 = null;
        goto L58
    L54:
        r18 = null;
        goto L55
    L51:
        r17 = null;
        goto L52
    L47:
        r16 = null;
        goto L49
    L43:
        r14 = null;
        goto L44
    L131:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L135:
        return;
    L134:
        return;
    L19:
        if (r11.g2().getNativeParams().getFromLive() == false) goto L35;
        if (r11.g2().getNativeParams().getFullMode() == true) goto L35;
        if (com.bytedance.android.ec.core.opt.ab.c.b() == false) goto L35;
        CommonMeta r49 = r11.O1().d().getData().a().a();
        if (r49 == null) goto L35;
        String r50 = r49.getEntranceInfo();
        if (r50 == null) goto L35;
        JSONObject r51 = k.w(r50);
        if (r51 == null) goto L35;
        String r52 = r51.optString("ecom_scene_id");
        if (r52 == null) goto L35;
        if (StringsKt.endsWith$default(r52, "1001", false, 2, null) != true) goto L35;
        r8 = true;
        goto L36
    L15:
        r7 = false;
        goto L16
    L9:
        if (r4.isShowLiveEntry() != true) goto L11;
        r5 = true;
        goto L12
    }
}
