package com.bytedance.android.shopping.store.router.hybridpage.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.ability.l0;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainerOpt;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.store.hybridproduct.k0;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.router.hybridpage.vo.HybridPageGeneralCardVO;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceConfig;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECHybridListContainerOpt> {
    public final Gson H3;
    public ECHybridListEngine I3;
    public Integer J3;
    public Map<String, Object> K3;
    public Map<String, Object> L3;
    public boolean M3;
    public ECHybridListDTO N3;
    public k O3;
    public wj3.a P3;
    public String Q3;
    public HybridPageViewModel R3;
    public final Set<String> S3;
    public LayoutTypes T3;
    public boolean U3;
    public View V3;
    public HybridProductListManager$attachGoTopListener$listener$1 W3;
    public boolean X3;
    public ValueAnimator Y3;

    public static final class a {
    }

    static {
    }

    public final void y0(SlcElement r1) {
    }

    public b(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.H3 = new Gson();
        this.S3 = new LinkedHashSet();
        this.U3 = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v11, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.bytedance.android.shopping.store.router.hybridpage.view.HybridScrollShowTopListener] */
    /* JADX WARN: Type inference failed for: r3v12, types: [com.bytedance.android.shopping.store.router.hybridpage.view.HybridProductListManager$attachGoTopListener$listener$1] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    public final void H0(Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "props");
        if (k1() != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, ? extends Object>> r12 = r11.entrySet().iterator();
    L6:
        Map<String, ShopSliceItemConfig> r1 = null;
        if (r12.hasNext() == false) goto L143;
        Map.Entry<String, ? extends Object> r0 = r12.next();
        String r5 = r0.getKey();
        Object r2 = r0.getValue();
        switch(r5.hashCode()) {
            case -1228895449: goto L137;
            case -855399539: goto L131;
            case -659684611: goto L123;
            case -67714352: goto L119;
            case 328286128: goto L113;
            case 707707600: goto L94;
            case 949718014: goto L79;
            case 1519904001: goto L71;
            case 1823929653: goto L12;
            default: goto L6;
        };
    L12:
        if (r5.equals("hybrid_list_load_type") == false) goto L6;
        if (r2 == null) goto L6;
        String r3 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r2);
        if (r3 == null) goto L6;
        wj3.a r6 = this.P3;
        if (r6 == null) goto L20;
        r6.d(r3);
    L20:
        if (Intrinsics.areEqual(r3, "refresh") == false) goto L6;
        HybridPageViewModel r4 = this.R3;
        if (r4 == null) goto L26;
        HashSet<String> r7 = r4.getIdRecords();
        if (r7 == null) goto L26;
        r7.clear();
    L26:
        ECHybridListEngine r8 = this.I3;
        if (r8 == null) goto L31;
        ECHybridRecyclerView r9 = r8.b;
        if (r9 == null) goto L31;
        r9.stopScroll();
    L31:
        ECHybridListEngine r10 = this.I3;
        if (r10 == null) goto L38;
        ECHybridRecyclerView r13 = r10.b;
        if (r13 == null) goto L38;
        VirtualLayoutManager r14 = r13.getLayoutManager();
        if (r14 == null) goto L38;
        r14.scrollToPositionWithOffset(0, 0);
    L38:
        HybridProductListManager$attachGoTopListener$listener$1 r15 = this.W3;
        if (r15 == null) goto L41;
        r15.a = 0;
    L41:
        ValueAnimator r16 = this.Y3;
        if (r16 == null) goto L44;
        r16.cancel();
    L44:
        this.Y3 = null;
        View r17 = this.V3;
        if (r17 == null) goto L47;
        r17.setAlpha(1.0f);
    L47:
        View r18 = this.V3;
        if (r18 == null) goto L50;
        r18.setVisibility(8);
    L50:
        this.S3.addAll(k0.a);
        ECHybridListEngine r19 = this.I3;
        if (r19 == null) goto L6;
        k r20 = r19.c.g;
        if (r20 == null) goto L6;
        ArrayList r21 = r20.c;
        if (r21 == null) goto L63;
        ?? r22 = new ArrayList();
        Iterator r23 = r21.iterator();
    L59:
        if (r23.hasNext() == false) goto L64;
        Object r24 = r23.next();
        if (CollectionsKt.contains(this.S3, ((com.bytedance.android.ec.hybrid.list.entity.i) r24).a) == false) goto L59;
        r22.add(r24);
    L64:
        ECHybridListEngine r25 = this.I3;
        if (r25 == null) goto L67;
        k r26 = new k();
        r26.c = new ArrayList((Collection) r22);
        r26.a = r20.a;
        r26.b = r20.b;
        r26.d = r20.d;
        Unit r27 = Unit.INSTANCE;
        ECHybridListEngine.p(r25, r26, 6);
    L67:
        HybridPageViewModel r28 = this.R3;
        if (r28 == null) goto L6;
        r28.clearHybridListDTO();
        goto L6
    L63:
        r22 = CollectionsKt.emptyList();
        goto L64
    L71:
        if (r5.equals("hybrid_list") == false) goto L6;
        if (r2 == null) goto L6;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L75
        Gson r30 = this.H3;     // Catch: Throwable -> L75
        this.N3 = (ECHybridListDTO) r30.fromJson(r30.toJson(r2), ECHybridListDTO.class);     // Catch: Throwable -> L75
        Object r31 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L75
    L77:
        Result.box-impl(r31);
    L75:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L77
    L79:
        if (r5.equals("footer_has_more") == false) goto L6;
        if (r2 == null) goto L6;
        if (com.bytedance.android.ecom.arch.slice.render.util.b.a(r2) == true) goto L83;
        HybridPageViewModel r33 = this.R3;
        if (r33 == null) goto L6;
        QLiveData<LoadStatus> r34 = r33.getLoadStatus();
        if (r34 == null) goto L6;
        r34.g(LoadStatus.LoadMoreEnd);
        goto L6
    L83:
        HybridPageViewModel r35 = this.R3;
        if (r35 == null) goto L6;
        QLiveData<LoadStatus> r36 = r35.getLoadStatus();
        if (r36 == null) goto L6;
        r36.g(LoadStatus.LoadMoreSuccess);
        goto L6
    L94:
        if (r5.equals("list_style") == false) goto L6;
        if (r2 == null) goto L6;
        Integer r37 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r2);
        if (r37 == null) goto L6;
        if (r37.intValue() == 2) goto L100;
        HybridPageViewModel r38 = this.R3;
        if (r38 == null) goto L111;
        jm.a<LayoutTypes> r39 = r38.getLayoutType();
        if (r39 == null) goto L111;
        r39.setValue(LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE);
    L111:
        this.T3 = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        goto L6
    L100:
        HybridPageViewModel r40 = this.R3;
        if (r40 == null) goto L105;
        jm.a<LayoutTypes> r41 = r40.getLayoutType();
        if (r41 == null) goto L105;
        r41.setValue(LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE);
    L105:
        this.T3 = LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
        goto L6
    L113:
        if (r5.equals("root_globalProps") == false) goto L6;
        if (r2 == null) goto L6;
        Map<String, Object> r42 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r2);
        if (r42 == null) goto L6;
        this.L3 = r42;
        goto L6
    L119:
        if (r5.equals("showScrollToTop") == false) goto L6;
        if (r2 == null) goto L6;
        this.U3 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r2);
        goto L6
    L123:
        if (r5.equals("footer_no_more_text") == false) goto L6;
        if (r2 == null) goto L6;
        String r43 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r2);
        if (r43 == null) goto L6;
        HybridPageViewModel r44 = this.R3;
        if (r44 == null) goto L6;
        r44.setLoadNoMoreText(r43);
        goto L6
    L131:
        if (r5.equals("globalProps") == false) goto L6;
        if (r2 == null) goto L6;
        Map<String, Object> r45 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r2);
        if (r45 == null) goto L6;
        this.K3 = r45;
        goto L6
    L137:
        if (r5.equals("loadMore_range_size") == false) goto L6;
        if (r2 == null) goto L6;
        Integer r46 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r2);
        if (r46 == null) goto L6;
        this.J3 = Integer.valueOf(r46.intValue());
        goto L6
    L143:
        if (this.M3 == true) goto L216;
        SlcTemplateContext r110 = ((BaseSlcViewManager) this).a;
        String r47 = r110.g;
        String r48 = "";
        if (r47 != null) goto L147;
        r47 = "";
    L147:
        Object r111 = r110.o(r47);
        if ((r111 instanceof wj3.a) == true) goto L150;
        r111 = null;
    L150:
        wj3.a r112 = (wj3.a) r111;
        this.P3 = r112;
        if (r112 == null) goto L156;
        HybridPageViewModel r113 = r112.c();
        if (r113 == null) goto L156;
        String r114 = r113.getSceneId();
        if (r114 == null) goto L156;
    L157:
        this.Q3 = r114;
        wj3.a r115 = this.P3;
        if (r115 == null) goto L160;
        HybridPageViewModel r116 = r115.c();
    L161:
        this.R3 = r116;
        if (this.I3 != null) goto L215;
        wj3.a r117 = this.P3;
        if (r117 == null) goto L169;
        Fragment r118 = r117.getFragment();
        if (r118 == null) goto L169;
    L173:
        ECHybridListContainerOpt r49 = k1();
        if (r49 == null) goto L215;
        wj3.a r50 = this.P3;
        if (r50 == null) goto L179;
        Context r51 = r50.getContext();
        if (r51 == null) goto L179;
    L180:
        wj3.a r52 = this.P3;
        if (r52 == null) goto L188;
        HybridPageViewModel r53 = r52.c();
        if (r53 == null) goto L188;
        String r54 = r53.getSceneId();
        if (r54 == null) goto L188;
        r48 = r54;
    L188:
        ECHybridListEngine.a r55 = new ECHybridListEngine.a(r51, r48);
        Intrinsics.checkNotNullParameter(r49, "view");
        r55.b = r49;
        Integer r56 = this.J3;
        if (r56 == null) goto L191;
        int r57 = r56.intValue();
    L192:
        r55.d = r57;
        r55.d(com.bytedance.android.ec.hybrid.list.ability.k0.class, new e(this, r118));
        r55.d(com.bytedance.android.ec.hybrid.list.ability.c.class, new f(this, r118));
        wj3.a r58 = this.P3;
        if (r58 == null) goto L197;
        m0 r59 = r58.b(this.K3, this.L3);
        if (r59 == null) goto L197;
        r55.d(m0.class, r59);
    L197:
        wj3.a r60 = this.P3;
        if (r60 == null) goto L202;
        Fragment r61 = r60.getFragment();
        if (r61 == null) goto L202;
        r55.d(l0.class, new g(r61));
    L202:
        if (r118 == null) goto L204;
        Intrinsics.checkNotNullParameter(r118, "life");
        r55.c = r118;
    L204:
        this.I3 = r55.c();
        ECHybridListContainerOpt r119 = k1();
        if (r119 == null) goto L208;
        r119.setEngine(this.I3);
    L208:
        if ((!Intrinsics.areEqual(((BaseSlcViewManager) this).a.g, ShopSliceUniqueId.CLASSIFICATION_SECOND_PAGE.getId())) == true) goto L215;
        ECHybridListEngine r120 = this.I3;
        if (r120 == null) goto L215;
        ECHybridRecyclerView r121 = r120.b;
        if (r121 == null) goto L215;
        r121.setEdgeEffectFactory(new HybridProductListManager$disableOverScrollBounceIfNeeded$1());
        goto L215
    L191:
        r57 = 10;
    L179:
        r51 = getContext();
    L169:
        Fragment r122 = getContext();
        if ((r122 instanceof LifecycleOwner) == true) goto L172;
        r122 = null;
    L172:
        r118 = (LifecycleOwner) r122;
    L215:
        this.M3 = true;
        goto L216
    L160:
        r116 = null;
    L156:
        r114 = UUID.randomUUID().toString();
    L216:
        ECHybridListEngine r123 = this.I3;
        if (r123 == null) goto L266;
        ECHybridRecyclerView r124 = r123.b;
        if (r124 == null) goto L266;
        wj3.a r62 = this.P3;
        if (r62 == null) goto L235;
        Fragment r63 = r62.getFragment();
        if (r63 == null) goto L235;
        View r64 = r63.getView();
        if (r64 == null) goto L235;
        View r65 = r64.findViewById(2131370756);
        if (r65 == null) goto L235;
        if (this.V3 == r65) goto L236;
        r65.setVisibility(8);
        r65.setAlpha(1.0f);
        r65.setOnClickListener(new d(this, r65));
        this.V3 = r65;
    L236:
        if (r65 == null) goto L266;
        if (this.U3 == true) goto L252;
        r65.setVisibility(8);
        if (this.X3 == false) goto L266;
        HybridProductListManager$attachGoTopListener$listener$1 r66 = this.W3;
        if (r66 == null) goto L246;
        r124.removeOnScrollListener(r66);
    L246:
        this.X3 = false;
        ValueAnimator r125 = this.Y3;
        if (r125 == null) goto L249;
        r125.cancel();
    L249:
        this.Y3 = null;
        View r126 = this.V3;
        if (r126 == null) goto L266;
        r126.setAlpha(1.0f);
        goto L266
    L252:
        HybridProductListManager$attachGoTopListener$listener$1 r67 = this.W3;
        ?? r68 = r67;
        if (r67 != null) goto L256;
        final Function1<Integer, Unit> r69 = new HybridProductListManager$attachGoTopListener$listener$2(this);
        final Function1<Boolean, Unit> r70 = new HybridProductListManager$attachGoTopListener$listener$3(this);
        ?? r71 = new HybridProductListManager$attachGoTopListener$listener$1(r69, r70);
        this.W3 = r71;
        r68 = r71;
    L256:
        if (this.X3 == true) goto L258;
        r124.addOnScrollListener(r68);
        this.X3 = true;
    L258:
        RecyclerView.LayoutManager r127 = r124.getLayoutManager();
        if ((r127 instanceof LinearLayoutManager) == true) goto L261;
        r127 = null;
    L261:
        LinearLayoutManager r128 = (LinearLayoutManager) r127;
        if (r128 == null) goto L264;
        int r129 = r128.findFirstCompletelyVisibleItemPosition();
    L265:
        r68.j(r129);
        goto L266
    L264:
        r129 = 0;
    L235:
        r65 = null;
    L266:
        ECHybridListDTO r130 = this.N3;
        if (r130 == null) goto L511;
        List r131 = r130.getSections();
        if (r131 == null) goto L321;
        Iterator r132 = r131.iterator();
    L273:
        if (r132.hasNext() == false) goto L321;
        ECHybridListSectionDTO r72 = (ECHybridListSectionDTO) r132.next();
        LayoutTypes r73 = this.T3;
        if (r73 != null) goto L278;
        r73 = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
    L278:
        int r74 = r73.getType();
        Intrinsics.checkNotNullParameter(r72, "$this$updateSectionLayoutType");
        if (Intrinsics.areEqual(r72.getSectionId(), "__PRODUCTS_SECTION__") == true) goto L282;
        if (Intrinsics.areEqual(r72.getSectionId(), "__GUESS_LIKE_PRODUCTS_SECTION__") == false) goto L273;
    L282:
        ArrayList r75 = r72.getItems();
        if (r75 == null) goto L273;
        Iterator r76 = r75.iterator();
    L286:
        if (r76.hasNext() == false) goto L273;
        ECHybridListItemDTO r77 = (ECHybridListItemDTO) r76.next();
        r77.setSpanSize(Integer.valueOf(2 - r74));
        Integer r78 = r77.getItemType();
        if (r78 == null) goto L292;
        if (com.bytedance.android.ec.hybrid.list.d.a(r78) != true) goto L292;
        r77.setItemData(com.bytedance.android.shopping.store.hybridproduct.l0.a(r77.getItemData(), r74));
    L292:
        Integer r79 = r77.getItemType();
        ECHybridListItemType r80 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD;
        int r81 = r80.getType();
        if (r79 != null) goto L296;
    L297:
        Integer r82 = r77.getItemType();
        int r83 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE.getType();
        if (r82 == null) goto L303;
        if (r82.intValue() != r83) goto L303;
    L318:
        if (r74 == LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE.getType()) goto L319;
        r77.setItemType(Integer.valueOf(r80.getType()));
        goto L286
    L319:
        r77.setItemType(Integer.valueOf(ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE.getType()));
    L303:
        Integer r84 = r77.getItemType();
        ECHybridListItemType r85 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_NEW;
        int r86 = r85.getType();
        if (r84 != null) goto L307;
    L308:
        Integer r87 = r77.getItemType();
        int r88 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW.getType();
        if (r87 == null) goto L286;
        if (r87.intValue() != r88) goto L286;
    L314:
        if (r74 == LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE.getType()) goto L315;
        r77.setItemType(Integer.valueOf(r85.getType()));
        goto L286
    L315:
        r77.setItemType(Integer.valueOf(ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW.getType()));
        goto L286
    L307:
        if (r84.intValue() == r86) goto L314;
    L296:
        if (r79.intValue() == r81) goto L318;
    L321:
        HybridPageViewModel r133 = this.R3;
        if (r133 == null) goto L324;
        r133.appendHybridListDTO(this.N3);
    L324:
        ECHybridListDTO r134 = this.N3;
        if (r134 == null) goto L327;
        ECHybridListDTO.Companion.getClass();
        this.O3 = ECHybridListDTO.a.d(r134, false, null);
    L327:
        k r135 = this.O3;
        if (r135 == null) goto L351;
        ArrayList r136 = r135.c;
        if (r136 == null) goto L351;
        Iterator r137 = r136.iterator();
    L333:
        if (r137.hasNext() == false) goto L351;
        com.bytedance.android.ec.hybrid.list.entity.i r89 = (com.bytedance.android.ec.hybrid.list.entity.i) r137.next();
        ArrayList r90 = r89.i;
        if (r90 == null) goto L333;
        Iterator r91 = r90.iterator();
    L338:
        if (r91.hasNext() == false) goto L333;
        ECHybridListItemVO r92 = (ECHybridListItemVO) r91.next();
        Object r93 = r92.d();
        if ((r93 instanceof HybridPageGeneralCardVO) == true) goto L342;
        r93 = null;
    L342:
        HybridPageGeneralCardVO r94 = (HybridPageGeneralCardVO) r93;
        if (r94 == null) goto L345;
        r94.b(r92);
        r94.g = r89.a;
    L345:
        Object r95 = r92.d();
        if ((r95 instanceof ShopSlcProductItemV2) == true) goto L348;
        r95 = null;
    L348:
        ShopSlcProductItemV2 r96 = (ShopSlcProductItemV2) r95;
        if (r96 == null) goto L338;
        r96.b(r92);
        r96.g = r89.a;
    L351:
        k r138 = this.O3;
        if (r138 == null) goto L365;
        SliceConfig.a r97 = SliceConfig.Companion;
        Map r98 = r138.d;
        r97.getClass();
        SliceConfig r99 = SliceConfig.a.a(r98);
        if (r99 == null) goto L356;
        r1 = r99.getConfigs();
    L356:
        if (r1 == null) goto L362;
        HybridPageViewModel r100 = this.R3;
        if (r100 == null) goto L362;
        com.bytedance.android.shopping.store.slicecard.b r101 = r100.getSliceService();
        if (r101 == null) goto L362;
        r101.d(r99.getConfigs());
    L362:
        ECHybridListEngine r102 = this.I3;
        if (r102 == null) goto L365;
        r102.c(r138);
    L365:
        ECHybridListEngine r139 = this.I3;
        if (r139 == null) goto L509;
        ECHybridRecyclerView r140 = r139.b;
        if (r140 == null) goto L510;
        r140.post(new h(this));
        return;
    L510:
        return;
    L509:
        return;
    }

    public final View n1(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new ECHybridListContainerOpt(r3, null);
    }
}
