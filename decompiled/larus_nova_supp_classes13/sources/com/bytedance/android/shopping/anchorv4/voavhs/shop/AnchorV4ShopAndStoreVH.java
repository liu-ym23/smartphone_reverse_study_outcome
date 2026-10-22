package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv3.repository.dto.RecommendInShopProductStruct;
import com.bytedance.android.shopping.anchorv3.view.AnchorV3RecInShopBoxView;
import com.bytedance.android.shopping.anchorv3.view.AnchorV3RecInShopProductView;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.LocalImage;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.components.LynxCardComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.IconsWithSpaceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.VisibleLogManager;
import com.bytedance.android.shopping.anchorv4.log.g;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.IconsWithSpaceElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.LynxCardView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.MediaBoxElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/b;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ShopAndStoreVH extends AbsFullSpanVH<b> implements com.bytedance.android.shopping.anchorv4.log.d, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public b m;
    public final Lazy n;
    public final ViewGroup o;
    public final VisibleLogManager p;
    public final Context q;
    public final AnchorV4VM r;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r1, Object r2) {
    }

    public final void onVisible() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final int M0() {
        return com.bytedance.android.shopping.extensions.b.b(60);
    }

    public final void onScan() {
        View r1 = ((RecyclerView.ViewHolder) this).itemView;
        if (r1 == null) goto L188;
        AnchorV4ShopAndStoreView r2 = (AnchorV4ShopAndStoreView) r1;
        AnchorV4ShopAndStoreDisplay r3 = ((b) getItem()).b;
        if (r3 == null) goto L206;
        AnchorV4ShopAndStoreMeta r4 = r2.S;
        String r5 = "shop";
        if (r4 == null) goto L14;
        AnchorV4ShopAndStoreBusinessMeta r6 = r4.getBusinessMeta();
        if (r6 == null) goto L14;
        if (r6.isStore() != true) goto L14;
        Object r7 = "shop";
    L15:
        AnchorV4ShopAndStoreMeta r8 = r2.S;
        if (r8 == null) goto L20;
        LinkedTreeMap<String, Object> r9 = r8.getTrackMeta();
        if (r9 == null) goto L20;
        Object r10 = r9.get("is_exist_follow");
    L21:
        boolean r11 = Intrinsics.areEqual(r10, Boolean.TRUE);
        Map r12 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("entrance_location", "product_detail_card"), TuplesKt.to("store_type", r7), TuplesKt.to("is_exist_follow", Integer.valueOf(r11 ? 1 : 0)), TuplesKt.to("btm_id", new BtmItemBuilder("a1.b8094.c4307.d3324", Boolean.FALSE).withView(r2).createBtmId())});
        AnchorV4ShopAndStoreMeta r13 = r2.S;
        if (r13 == null) goto L34;
        LinkedTreeMap<String, Object> r14 = r13.getTrackMeta();
        if (r14 == null) goto L34;
        Set r15 = r14.entrySet();
        if (r15 == null) goto L34;
        Iterator r16 = r15.iterator();
    L29:
        if (r16.hasNext() == false) goto L34;
        Map.Entry r17 = (Map.Entry) r16.next();
        if (r12.containsKey(r17.getKey()) == true) goto L29;
        r12.put(r17.getKey(), r17.getValue());
    L34:
        int r18 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r19 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.J);
        if (r19 != null) goto L37;
    L42:
        AnchorV4ShopAndStoreMeta r20 = r2.S;
        if (r20 == null) goto L64;
        AnchorV4ShopAndStoreBusinessMeta r21 = r20.getBusinessMeta();
        if (r21 == null) goto L64;
        List<Long> r22 = r21.getShopCouponType();
        if (r22 == null) goto L64;
        if (r22.contains(3L) != true) goto L64;
        int r23 = a.d;
        AnchorV4ShopAndStoreMeta r24 = r2.S;
        if (r24 == null) goto L55;
        AnchorV4ShopAndStoreBusinessMeta r25 = r24.getBusinessMeta();
        if (r25 == null) goto L55;
        List<String> r26 = r25.getShopCouponEntranceLocation();
    L56:
        String r27 = a.C0020a.a(3, r26);
        AnchorV4TrackerImpl r110 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.J);
        if (r110 == null) goto L64;
        if (g.a(r2) == true) goto L62;
        r110 = null;
    L62:
        if (r110 == null) goto L64;
        r110.c = MapsKt.mapOf(new Pair[]{TuplesKt.to("entrance_location", r27), TuplesKt.to("store_type", r7), TuplesKt.to("is_exist_follow", Integer.valueOf(r11 ? 1 : 0))});
        AnchorV4TrackerImpl.b(r110, "show_store_entrance", false, r27, false, null, 24);
    L55:
        r26 = null;
    L64:
        AnchorV4ShopAndStoreMeta r28 = r2.S;
        if (r28 == null) goto L86;
        AnchorV4ShopAndStoreBusinessMeta r29 = r28.getBusinessMeta();
        if (r29 == null) goto L86;
        List<Long> r30 = r29.getShopCouponType();
        if (r30 == null) goto L86;
        if (r30.contains(4L) != true) goto L86;
        int r31 = a.d;
        AnchorV4ShopAndStoreMeta r32 = r2.S;
        if (r32 == null) goto L77;
        AnchorV4ShopAndStoreBusinessMeta r33 = r32.getBusinessMeta();
        if (r33 == null) goto L77;
        List<String> r34 = r33.getShopCouponEntranceLocation();
    L78:
        String r35 = a.C0020a.a(4, r34);
        AnchorV4TrackerImpl r111 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.J);
        if (r111 == null) goto L86;
        if (g.a(r2) == true) goto L84;
        r111 = null;
    L84:
        if (r111 == null) goto L86;
        r111.c = MapsKt.mapOf(new Pair[]{TuplesKt.to("entrance_location", r35), TuplesKt.to("store_type", r7), TuplesKt.to("is_exist_follow", Integer.valueOf(r11 ? 1 : 0))});
        AnchorV4TrackerImpl.b(r111, "show_store_entrance", false, r35, false, null, 24);
    L77:
        r34 = null;
    L86:
        TextElement r36 = r3.getRatingScore();
        if (r36 == null) goto L89;
        String r37 = r36.getText();
    L90:
        if (r37 == null) goto L103;
        AnchorV4TrackerImpl r38 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.J);
        if (r38 == null) goto L103;
        AppCompatTextView r39 = r2.q;
        if (r39 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopScore");
    L97:
        if (g.a(r39) == true) goto L100;
        r38 = null;
    L100:
        if (r38 == null) goto L103;
        r38.c = MapsKt.mapOf(TuplesKt.to("score", Long.valueOf(k.y(r36.getText(), 0))));
        AnchorV4TrackerImpl.b(r38, "author_sell_score_show", false, null, false, null, 28);
    L103:
        if (r3.getShopPromotionInfo() == null) goto L134;
        LongContentLabelComponentView r40 = r2.u;
        if (r40 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("shopCouponView");
    L108:
        if (g.a(r40) == false) goto L134;
        AnchorV4ShopAndStoreMeta r41 = r2.S;
        if (r41 == null) goto L134;
        AnchorV4ShopAndStoreBusinessMeta r42 = r41.getBusinessMeta();
        if (r42 == null) goto L134;
        List<Long> r43 = r42.getShopCouponType();
        if (r43 == null) goto L134;
        Iterator<T> r44 = r43.iterator();
    L117:
        if (r44.hasNext() == false) goto L134;
        long r45 = ((Number) r44.next()).longValue();
        if (r45 == 2) goto L124;
        if (r45 == 3) goto L124;
        if (r45 != 4) goto L117;
    L124:
        int r46 = a.d;
        AnchorV4ShopAndStoreMeta r47 = r2.S;
        if (r47 == null) goto L129;
        AnchorV4ShopAndStoreBusinessMeta r48 = r47.getBusinessMeta();
        if (r48 == null) goto L129;
        List<String> r49 = r48.getShopCouponEntranceLocation();
    L130:
        String r50 = a.C0020a.a(r45, r49);
        int r51 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r52 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.J);
        if (r52 == null) goto L117;
        r52.c = MapsKt.mapOf(TuplesKt.to("entrance_location", r50));
        AnchorV4TrackerImpl.b(r52, "show_member_entrance", false, null, false, null, 28);
    L129:
        r49 = null;
    L134:
        if (r3.getRankBanner() == null) goto L151;
        int r53 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r54 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.J);
        if (r54 == null) goto L151;
        LongContentLabelComponentView r55 = r2.A;
        if (r55 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("shopRankListView");
    L142:
        if (g.a(r55) == true) goto L145;
        r54 = null;
    L145:
        if (r54 == null) goto L151;
        AnchorV4ShopAndStoreMeta r56 = r2.S;
        if (r56 == null) goto L149;
        LinkedTreeMap<String, Object> r57 = r56.getTrackMeta();
    L150:
        r54.c = r57;
        AnchorV4TrackerImpl.b(r54, "shop_list_entrance_show", false, null, false, null, 28);
        goto L151
    L149:
        r57 = null;
    L151:
        AnchorV3RecInShopBoxView r58 = r2.x;
        if (r58 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("bvRecInShop");
    L154:
        Iterator r59 = ((ArrayList) r58.c).iterator();
        int r112 = 0;
    L156:
        if (r59.hasNext() == false) goto L165;
        Object r60 = r59.next();
        int r61 = r112 + 1;
        if (r112 >= 0) goto L160;
        CollectionsKt.throwIndexOverflow();
    L160:
        Function1 r62 = ((AnchorV3RecInShopProductView) r60).c;
        if (r62 == null) goto L163;
        Unit r63 = (Unit) r62.invoke(Integer.valueOf(r112));
    L163:
        r112 = r61;
        goto L156
    L165:
        if (r3.getReputationIconsAndFans() == null) goto L207;
        int r64 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r65 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r2.J);
        if (r65 == null) goto L204;
        TagsScrollBoxComponentView r66 = r2.B;
        if (r66 != null) goto L173;
        Intrinsics.throwUninitializedPropertyAccessException("iconsAndFans");
    L173:
        if (g.a(r66) == true) goto L176;
        r65 = null;
    L176:
        if (r65 == null) goto L205;
        Pair[] r67 = new Pair[2];
        r67[0] = TuplesKt.to("entrance_location", "102");
        AnchorV4ShopAndStoreMeta r68 = r2.S;
        if (r68 == null) goto L184;
        AnchorV4ShopAndStoreBusinessMeta r69 = r68.getBusinessMeta();
        if (r69 == null) goto L184;
        if (r69.isStore() != true) goto L184;
    L185:
        r67[1] = TuplesKt.to("store_type", r5);
        r65.c = MapsKt.mapOf(r67);
        AnchorV4TrackerImpl.b(r65, "shop_level_info_explain_page_show", false, null, false, null, 28);
        return;
    L184:
        r5 = "window";
        goto L185
    L205:
        return;
    L204:
        return;
    L207:
        return;
    L89:
        r37 = null;
        goto L90
    L37:
        if (g.a(r2) == true) goto L40;
        r19 = null;
    L40:
        if (r19 == null) goto L42;
        r19.c = r12;
        AnchorV4TrackerImpl.b(r19, "show_store_entrance", false, "product_detail_card", false, null, 24);
    L20:
        r10 = null;
    L14:
        r7 = "window";
        goto L15
    L206:
        return;
    L188:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.shop.AnchorV4ShopAndStoreView");
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v21, types: [android.view.View, com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView] */
    /* JADX WARN: Type inference failed for: r14v23, types: [android.view.View, com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView] */
    /* JADX WARN: Type inference failed for: r3v16, types: [android.widget.TextView, com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a4(Object r37) {
        b r1 = (b) r37;
        Intrinsics.checkNotNullParameter(r1, "item");
        View r2 = ((RecyclerView.ViewHolder) this).itemView;
        String r3 = "null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.shop.AnchorV4ShopAndStoreView";
        if (r2 == null) goto L576;
        AnchorV4ShopAndStoreView r4 = (AnchorV4ShopAndStoreView) r2;
        AnchorV4ShopAndStoreDisplay r5 = r1.b;
        AnchorV4ShopAndStoreMeta r6 = r1.c;
        List<RecommendInShopProductStruct> r7 = r1.d;
        CommonMeta r8 = this.r.commonMeta();
        AnchorV4VM r9 = this.r;
        if (r5 != null) goto L7;
        b r16 = r1;
        String r29 = "null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.shop.AnchorV4ShopAndStoreView";
    L553:
        Unit r0 = Unit.INSTANCE;
        b r10 = r16;
        this.m = r10;
        View r11 = ((RecyclerView.ViewHolder) this).itemView;
        if (r11 == null) goto L562;
        ((AnchorV4ShopAndStoreView) r11).setActionHub(this);
        this.p.b(this, r10, 0);
        View r12 = ((RecyclerView.ViewHolder) this).itemView;
        if (r12 == null) goto L560;
        ExtensionsKt.e((ViewGroup) r12, this);
        return;
    L560:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L562:
        throw new NullPointerException(r29);
    L7:
        r4.J = r9;
        r4.S = r6;
        if (r4.P0 == null) goto L10;
    L12:
        r4.P0 = Boolean.valueOf(r5.getShopStructOptimize());
        MediaBoxElementView r13 = r4.d;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("ibvShopAvatar");
    L15:
        MediaBoxElementView.c(r13, r5.getShopAvatar(), null, false, 6);
        MediaBoxElementView r14 = r4.d;
        if (r14 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("ibvShopAvatar");
    L18:
        r14.post(new d(r4, r7));
        TextWithOneIconElementView r15 = r4.e;
        if (r15 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("liveOrDouyinView");
    L21:
        TextWithOneIconElementView.b(r15, r5.getShopAvatarIcon(), null, false, null, 14);
        TextWithOneIconElement r17 = r5.getShopAvatarIcon();
        if (r17 == null) goto L28;
        ImageModel r18 = r17.getIcon();
        if (r18 == null) goto L28;
        LocalImage r19 = r18.getLocal();
        if (r19 == null) goto L28;
        Integer r20 = Integer.valueOf(r19.getWidth());
    L29:
        if (r20 == null) goto L34;
        r20.intValue();
        View r21 = r4.f;
        if (r21 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("liveOrDouyinViewBackground");
    L33:
        r21.post(new e(r4));
    L34:
        TextWithOneIconElementView r110 = r4.g;
        if (r110 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("tivShopName");
    L37:
        TextWithOneIconElementView.b(r110, r5.getShopInfo(), null, true, null, 10);
        TextWithOneIconElementView r111 = r4.h;
        if (r111 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("tivShopIcon");
    L40:
        TextWithOneIconElementView.b(r111, r5.getShopIcon(), null, false, null, 14);
        TextWithOneIconElementView r112 = r4.i;
        if (r112 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("tivJumpToShop");
    L43:
        TextWithOneIconElementView.b(r112, r5.getJumpButton(), null, false, null, 14);
        IconsWithSpaceElementView r113 = r4.j;
        if (r113 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("ivTrustPics");
    L46:
        r113.a(null);
        TextElement r114 = r5.getRatingScore();
        if (r114 == null) goto L49;
        String r115 = r114.getText();
    L50:
        if (r115 != null) goto L52;
    L55:
        boolean r116 = true;
    L56:
        if (r116 == false) goto L61;
        TextElement r117 = r5.getRatingScore();
        if (r117 == null) goto L60;
        String r118 = r117.getText();
    L66:
        String r119 = r118;
    L67:
        TextElementView r120 = r4.q;
        if (r120 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopScore");
    L70:
        TextElement r121 = r5.getRatingScore();
        if (r121 == null) goto L73;
        TextElement r122 = TextElement.copy$default(r121, null, null, r119, null, null, null, null, null, 0, null, 1019, null);
    L74:
        r120.x(r122);
        TextElement r123 = r5.getRatingScore();
        if (r123 == null) goto L79;
        String r124 = r123.getText();
        if (r124 == null) goto L79;
        Float r125 = StringsKt.toFloatOrNull(r124);
    L81:
        if (r125 == null) goto L87;
        TextElementView r126 = r4.q;
        if (r126 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopScore");
    L85:
        r126.setTypeface(Typeface.SANS_SERIF, 3);
    L87:
        if (r125 == null) goto L118;
        r125.floatValue();
        LinearLayout r127 = r4.r;
        if (r127 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("llStars");
    L91:
        r127.removeAllViews();
        LinearLayout r128 = r4.r;
        if (r128 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("llStars");
    L94:
        r128.setVisibility(0);
        int r129 = 1;
    L96:
        if (r129 > 5) goto L122;
        if (r125.floatValue() < r129) goto L101;
        AnchorV4ShopAndStoreView.StarType r130 = AnchorV4ShopAndStoreView.StarType.FULL;
    L104:
        LinearLayout r131 = r4.r;
        if (r131 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("llStars");
    L107:
        AppCompatImageView r132 = new AppCompatImageView(r4.getContext());
        Float r24 = r125;
        LinearLayout.LayoutParams r22 = new LinearLayout.LayoutParams(-2, -2);
        r22.leftMargin = com.bytedance.android.shopping.extensions.b.b(2);
        Unit r23 = Unit.INSTANCE;
        r132.setLayoutParams(r22);
        int r25 = c.a[r130.ordinal()];
        if (r25 != 1) goto L110;
        r132.setImageDrawable(th.a.b(r132.getContext(), 2131233498));
    L117:
        r131.addView(r132);
        r129 = r129 + 1;
        r125 = r24;
        goto L96
    L110:
        if (r25 != 2) goto L112;
        r132.setImageDrawable(th.a.b(r132.getContext(), 2131233497));
        goto L117
    L112:
        if (r25 != 3) goto L117;
        r132.setImageDrawable(th.a.b(r132.getContext(), 2131233499));
        goto L117
    L101:
        if (r125.floatValue() < (((double) r129) - 0.5d)) goto L103;
        r130 = AnchorV4ShopAndStoreView.StarType.HALF;
        goto L104
    L103:
        r130 = AnchorV4ShopAndStoreView.StarType.BLANK;
    L122:
        Unit r26 = Unit.INSTANCE;
        if (r5.getRatingScore() == null) goto L125;
    L132:
        View r27 = r4.s;
        if (r27 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("viewDivider");
    L135:
        TextElement r133 = r5.getRatingScore();
        if (r133 == null) goto L138;
        String r134 = r133.getText();
    L140:
        if (k.c(r134) == false) goto L148;
        TextElement r135 = r5.getPeersExceeded();
        if (r135 == null) goto L144;
        String r136 = r135.getText();
    L146:
        if (k.c(r136) == false) goto L148;
        boolean r137 = true;
    L149:
        wg.a.h(r27, r137);
        TextElement r28 = r5.getRatingScore();
        if (r28 == null) goto L152;
        String r30 = r28.getText();
    L153:
        if (r30 != null) goto L155;
    L158:
        boolean r31 = true;
    L160:
        if (r31 == false) goto L172;
        AppCompatTextView r32 = r4.t;
        if (r32 != null) goto L164;
        Intrinsics.throwUninitializedPropertyAccessException("tvPeersExceeded");
    L164:
        AppCompatTextView r138 = r4.t;
        if (r138 != null) goto L167;
        Intrinsics.throwUninitializedPropertyAccessException("tvPeersExceeded");
    L167:
        ViewGroup.LayoutParams r139 = r138.getLayoutParams();
        if (r139 == null) goto L171;
        LinearLayout.LayoutParams r140 = (LinearLayout.LayoutParams) r139;
        r140.leftMargin = 0;
        r32.setLayoutParams(r140);
    L181:
        TextElementView r33 = r4.t;
        if (r33 != null) goto L184;
        Intrinsics.throwUninitializedPropertyAccessException("tvPeersExceeded");
    L184:
        r33.x(r5.getPeersExceeded());
        LongContentLabelComponentView r34 = r4.u;
        if (r34 != null) goto L187;
        Intrinsics.throwUninitializedPropertyAccessException("shopCouponView");
    L187:
        r34.bind(r5.getShopPromotionInfo());
        LongContentLabelComponentView r35 = r4.u;
        if (r35 != null) goto L191;
        Intrinsics.throwUninitializedPropertyAccessException("shopCouponView");
    L191:
        if (r5.getShopPromotionInfo() == null) goto L193;
        int r141 = 0;
    L194:
        r35.setVisibility(r141);
        LongContentLabelComponentView r36 = r4.v;
        if (r36 != null) goto L197;
        Intrinsics.throwUninitializedPropertyAccessException("tvShopProfile");
    L197:
        r36.bind(r5.getShopProfile());
        TagsScrollBoxComponentView r38 = r4.B;
        if (r38 != null) goto L200;
        Intrinsics.throwUninitializedPropertyAccessException("iconsAndFans");
    L200:
        TagsScrollBoxComponentView.b(r38, r5.getReputationIconsAndFans(), null, 14);
        AnchorV4ShopAndStoreReputation r39 = r5.getStoreReputation();
        if (r39 == null) goto L203;
        List<TextElement> r142 = r39.getShopFollowerCount();
    L204:
        AnchorV4ShopAndStoreReputation r40 = r5.getStoreReputation();
        if (r40 == null) goto L207;
        List<TextElement> r143 = r40.getShopSellNum();
    L208:
        AnchorV4ShopAndStoreReputation r41 = r5.getStoreReputation();
        if (r41 == null) goto L211;
        List<TagsScrollBoxComponent> r144 = r41.getSubScoreList();
    L213:
        if (r142 == null) goto L287;
        if (r143 == null) goto L287;
        if (r144 == null) goto L287;
        LinearLayout r42 = r4.N;
        if (r42 != null) goto L219;
        Intrinsics.throwUninitializedPropertyAccessException("llShopReputation");
    L219:
        r42.setVisibility(0);
        LinearLayout r43 = r4.K;
        String r145 = "llFollowerCount";
        if (r43 != null) goto L222;
        Intrinsics.throwUninitializedPropertyAccessException("llFollowerCount");
    L222:
        r43.removeAllViews();
        Iterator r146 = r142.iterator();
        int r210 = 0;
    L224:
        if (r146.hasNext() == false) goto L235;
        Object r44 = r146.next();
        int r211 = r210 + 1;
        if (r210 >= 0) goto L228;
        CollectionsKt.throwIndexOverflow();
    L228:
        TextElement r45 = (TextElement) r44;
        Iterator r212 = r146;
        LinearLayout r147 = r4.K;
        if (r147 != 0) goto L231;
        Intrinsics.throwUninitializedPropertyAccessException(r145);
    L231:
        String r310 = r145;
        ?? r148 = new TextElementView(r4.getContext(), null, 0, null, 30);
        r148.x(r45);
        Unit r46 = Unit.INSTANCE;
        String r213 = r3;
        LinearLayout.LayoutParams r47 = new LinearLayout.LayoutParams(-2, -2);
        if (r210 <= 0) goto L234;
        r47.topMargin = com.bytedance.android.shopping.extensions.b.b(4);
    L234:
        r147.addView(r148, r47);
        r210 = r211;
        r146 = r212;
        r3 = r213;
        r145 = r310;
        goto L224
    L235:
        r29 = r3;
        LinearLayout r48 = r4.L;
        String r149 = "llSellNum";
        if (r48 != null) goto L238;
        Intrinsics.throwUninitializedPropertyAccessException("llSellNum");
    L238:
        r48.removeAllViews();
        Iterator r49 = r143.iterator();
        int r150 = 0;
    L240:
        if (r49.hasNext() == false) goto L251;
        Object r50 = r49.next();
        int r151 = r150 + 1;
        if (r150 >= 0) goto L244;
        CollectionsKt.throwIndexOverflow();
    L244:
        TextElement r51 = (TextElement) r50;
        Iterator r214 = r49;
        LinearLayout r52 = r4.L;
        if (r52 != 0) goto L247;
        Intrinsics.throwUninitializedPropertyAccessException(r149);
    L247:
        String r215 = r149;
        ?? r152 = new TextElementView(r4.getContext(), null, 0, null, 30);
        r152.x(r51);
        Unit r53 = Unit.INSTANCE;
        LinearLayout.LayoutParams r54 = new LinearLayout.LayoutParams(-2, -2);
        if (r150 <= 0) goto L250;
        r54.topMargin = com.bytedance.android.shopping.extensions.b.b(4);
    L250:
        r52.addView(r152, r54);
        r49 = r214;
        r149 = r215;
        r150 = r151;
        goto L240
    L251:
        LinearLayout r55 = r4.M;
        String r153 = "llSubScore";
        if (r55 != null) goto L254;
        Intrinsics.throwUninitializedPropertyAccessException("llSubScore");
    L254:
        r55.removeAllViews();
        Iterator r56 = r144.iterator();
        int r154 = 0;
    L256:
        if (r56.hasNext() == false) goto L272;
        Object r155 = r56.next();
        int r156 = r154 + 1;
        if (r154 >= 0) goto L260;
        CollectionsKt.throwIndexOverflow();
    L260:
        TagsScrollBoxComponent r157 = (TagsScrollBoxComponent) r155;
        LinearLayout r57 = r4.M;
        if (r57 != null) goto L263;
        Intrinsics.throwUninitializedPropertyAccessException(r153);
    L263:
        Iterator r216 = r56;
        String r217 = r153;
        b r158 = r1;
        AnchorV4VM r218 = r9;
        TagsScrollBoxComponentView r58 = new TagsScrollBoxComponentView(r4.getContext(), null, 0, 14);
        TagsScrollBoxComponentView.b(r58, r157, null, 14);
        Unit r59 = Unit.INSTANCE;
        LinearLayout.LayoutParams r60 = new LinearLayout.LayoutParams(-2, -2);
        if (r154 <= 0) goto L266;
        int r159 = 2;
        int r219 = com.bytedance.android.shopping.extensions.b.b(2);
    L267:
        r60.topMargin = r219;
        if (r154 != r159) goto L271;
        r60.bottomMargin = com.bytedance.android.shopping.extensions.b.b(3);
    L271:
        r57.addView(r58, r60);
        r1 = r158;
        r154 = r156;
        r9 = r218;
        r56 = r216;
        r153 = r217;
        goto L256
    L266:
        r159 = 2;
        r219 = com.bytedance.android.shopping.extensions.b.b(6);
        goto L267
    L272:
        r16 = r1;
        AnchorV4VM r220 = r9;
        View r61 = r4.O;
        if (r61 != null) goto L275;
        Intrinsics.throwUninitializedPropertyAccessException("repDivider1");
    L275:
        AnchorV4ShopAndStoreReputation r62 = r5.getStoreReputation();
        if (r62 == null) goto L278;
        String r160 = r62.getDividerColor();
    L279:
        r61.setBackgroundColor(ColorProtector.parseColor(r160));
        View r63 = r4.P;
        if (r63 != null) goto L282;
        Intrinsics.throwUninitializedPropertyAccessException("repDivider2");
    L282:
        AnchorV4ShopAndStoreReputation r64 = r5.getStoreReputation();
        if (r64 == null) goto L285;
        String r161 = r64.getDividerColor();
    L286:
        r63.setBackgroundColor(ColorProtector.parseColor(r161));
        Unit r65 = Unit.INSTANCE;
    L288:
        LongContentLabelComponentView r66 = r4.A;
        if (r66 != null) goto L291;
        Intrinsics.throwUninitializedPropertyAccessException("shopRankListView");
    L291:
        r66.bind(r5.getRankBanner());
        LongContentLabelComponentView r67 = r4.C;
        if (r67 != null) goto L294;
        Intrinsics.throwUninitializedPropertyAccessException("superMarketIconList");
    L294:
        r67.bind(r5.getIconList());
        RoundedFrameLayout r68 = r4.Q;
        if (r68 != null) goto L297;
        Intrinsics.throwUninitializedPropertyAccessException("avatarMask");
    L297:
        if (r8 != null) goto L299;
    L301:
        int r69 = 0;
    L302:
        r68.setVisibility(r69);
        TextElement r70 = r5.getShopDistanceText();
        if (r70 == null) goto L308;
        ?? r71 = r4.D;
        if (r71 != 0) goto L307;
        Intrinsics.throwUninitializedPropertyAccessException("superMarketDistance");
    L307:
        r71.x(r70);
        r71.setVisibility(0);
        r71.setCompoundDrawablePadding(com.bytedance.android.shopping.extensions.b.b(4));
    L313:
        if (r5.getShopSlogan() == null) goto L315;
    L316:
        TextWithOneIconElementView r72 = r4.y;
        if (r72 != null) goto L319;
        Intrinsics.throwUninitializedPropertyAccessException("tivSuperMarketSlogan");
    L319:
        TextWithOneIconElementView.b(r72, r5.getShopSlogan(), null, false, null, 14);
        TextElementView r73 = r4.z;
        if (r73 != null) goto L322;
        Intrinsics.throwUninitializedPropertyAccessException("tvSuperMarketSales");
    L322:
        r73.x(r5.getShopSalesText());
        TextWithOneIconElementView r74 = r4.y;
        if (r74 != null) goto L326;
        Intrinsics.throwUninitializedPropertyAccessException("tivSuperMarketSlogan");
    L326:
        if (r5.getShopSlogan() == null) goto L328;
        boolean r75 = true;
    L329:
        wg.a.h(r74, r75);
        AppCompatTextView r76 = r4.z;
        if (r76 != null) goto L333;
        Intrinsics.throwUninitializedPropertyAccessException("tvSuperMarketSales");
    L333:
        if (r5.getShopSalesText() == null) goto L335;
        boolean r77 = true;
    L336:
        wg.a.h(r76, r77);
        IconsWithSpaceElementView r78 = r4.j;
        if (r78 != null) goto L339;
        Intrinsics.throwUninitializedPropertyAccessException("ivTrustPics");
    L339:
        r78.setVisibility(8);
        LinearLayout r79 = r4.k;
        if (r79 != null) goto L342;
        Intrinsics.throwUninitializedPropertyAccessException("llScore");
    L342:
        r79.setVisibility(8);
    L343:
        IconsWithSpaceElement r80 = r5.getTrustPics();
        if (r80 == null) goto L380;
        List r81 = r80.getIconList();
        if (r81 == null) goto L380;
        ArrayList r82 = new ArrayList();
        Iterator r84 = r81.iterator();
    L349:
        if (r84.hasNext() == false) goto L378;
        Object r85 = r84.next();
        ImageModel r86 = (ImageModel) r85;
        ECUrlModel r87 = r86.getRemote();
        if (r87 == null) goto L353;
        String r162 = r87.getUri();
    L354:
        if (r162 != null) goto L356;
    L359:
        boolean r88 = true;
    L360:
        if (r88 == false) goto L374;
        ECUrlModel r89 = r86.getRemote();
        if (r89 == null) goto L364;
        List r163 = r89.getUrlList();
    L365:
        List r164 = r163;
        if (r164 != null) goto L368;
    L371:
        boolean r90 = true;
    L372:
        if (r90 == false) goto L374;
        boolean r91 = true;
    L375:
        if (r91 == true) goto L349;
        r82.add(r85);
        goto L349
    L368:
        if (r164.isEmpty() == true) goto L371;
        r90 = false;
        goto L372
    L364:
        r163 = null;
    L374:
        r91 = false;
        goto L375
    L356:
        if (r162.length() == 0) goto L359;
        r88 = false;
        goto L360
    L353:
        r162 = null;
        goto L354
    L378:
        if (r82.size() != 0) goto L380;
        boolean r92 = true;
    L382:
        if (r5.getTrustPics() == null) goto L384;
        if (r92 == true) goto L384;
    L401:
        LinearLayout r94 = r4.k;
        if (r94 != null) goto L404;
        Intrinsics.throwUninitializedPropertyAccessException("llScore");
    L404:
        LinearLayout r95 = r4.k;
        if (r95 != null) goto L407;
        Intrinsics.throwUninitializedPropertyAccessException("llScore");
    L407:
        ConstraintLayout.LayoutParams r96 = r95.getLayoutParams();
        if (r96 == null) goto L568;
        ConstraintLayout.LayoutParams r97 = r96;
        r97.topToBottom = 2131362895;
        ((ViewGroup.MarginLayoutParams) r97).topMargin = com.bytedance.android.shopping.extensions.b.b(4);
        ((ViewGroup.MarginLayoutParams) r97).width = com.bytedance.android.shopping.extensions.b.b(0);
        r97.rightToLeft = 2131362894;
        ((ViewGroup.MarginLayoutParams) r97).rightMargin = com.bytedance.android.shopping.extensions.b.b(4);
        Unit r98 = Unit.INSTANCE;
        r94.setLayoutParams(r97);
        IconsWithSpaceElementView r99 = r4.j;
        if (r99 != null) goto L412;
        Intrinsics.throwUninitializedPropertyAccessException("ivTrustPics");
    L412:
        IconsWithSpaceElementView r100 = r4.j;
        if (r100 != null) goto L415;
        Intrinsics.throwUninitializedPropertyAccessException("ivTrustPics");
    L415:
        ConstraintLayout.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L566;
        ConstraintLayout.LayoutParams r102 = r101;
        r102.topToBottom = 2131362841;
        ((ViewGroup.MarginLayoutParams) r102).topMargin = com.bytedance.android.shopping.extensions.b.b(4);
        r102.bottomToBottom = 0;
        r99.setLayoutParams(r102);
        TextWithOneIconElementView r103 = r4.g;
        if (r103 != null) goto L420;
        Intrinsics.throwUninitializedPropertyAccessException("tivShopName");
    L420:
        TextWithOneIconElementView r104 = r4.g;
        if (r104 != null) goto L423;
        Intrinsics.throwUninitializedPropertyAccessException("tivShopName");
    L423:
        ConstraintLayout.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L564;
        ConstraintLayout.LayoutParams r106 = r105;
        ((ViewGroup.MarginLayoutParams) r106).topMargin = com.bytedance.android.shopping.extensions.b.b(Double.valueOf(2.5d));
        r103.setLayoutParams(r106);
        LinearLayout r107 = r4.c;
        if (r107 != null) goto L428;
        Intrinsics.throwUninitializedPropertyAccessException("llShopExtra");
    L428:
        ViewGroup.LayoutParams r165 = r107.getLayoutParams();
        if ((r165 instanceof ViewGroup.MarginLayoutParams) == true) goto L431;
        r165 = null;
    L431:
        ViewGroup.MarginLayoutParams r166 = (ViewGroup.MarginLayoutParams) r165;
        if (r166 != null) goto L434;
    L438:
        Background r108 = r5.getShopBackground();
        LinearLayout r109 = r4.a;
        if (r109 != null) goto L441;
        Intrinsics.throwUninitializedPropertyAccessException("llShopInfo");
    L441:
        r109.post(new f(r4, r108));
        View r167 = r4.s;
        if (r167 != null) goto L444;
        Intrinsics.throwUninitializedPropertyAccessException("viewDivider");
    L444:
        Context r168 = r4.getContext();
        if (r5.getShopBackground() != null) goto L447;
        int r169 = 2131101176;
    L448:
        r167.setBackgroundColor(th.a.a(r168, r169));
        if (ECAppInfoService.e.f() == false) goto L477;
        TextWithOneIconElementView r170 = r4.g;
        if (r170 != null) goto L453;
        Intrinsics.throwUninitializedPropertyAccessException("tivShopName");
    L453:
        ViewGroup.LayoutParams r171 = r170.getLayoutParams();
        if ((r171 instanceof ViewGroup.MarginLayoutParams) == true) goto L456;
        r171 = null;
    L456:
        ViewGroup.MarginLayoutParams r172 = (ViewGroup.MarginLayoutParams) r171;
        if (r172 == null) goto L459;
        r172.topMargin = 0;
        r170.setLayoutParams(r172);
    L459:
        LinearLayout r173 = r4.k;
        if (r173 != null) goto L462;
        Intrinsics.throwUninitializedPropertyAccessException("llScore");
    L462:
        ViewGroup.LayoutParams r174 = r173.getLayoutParams();
        if ((r174 instanceof ViewGroup.MarginLayoutParams) == true) goto L465;
        r174 = null;
    L465:
        ViewGroup.MarginLayoutParams r175 = (ViewGroup.MarginLayoutParams) r174;
        if (r175 == null) goto L468;
        r175.topMargin = 0;
        r173.setLayoutParams(r175);
    L468:
        IconsWithSpaceElementView r176 = r4.j;
        if (r176 != null) goto L471;
        Intrinsics.throwUninitializedPropertyAccessException("ivTrustPics");
    L471:
        ViewGroup.LayoutParams r177 = r176.getLayoutParams();
        if ((r177 instanceof ViewGroup.MarginLayoutParams) == true) goto L474;
        r177 = null;
    L474:
        ViewGroup.MarginLayoutParams r178 = (ViewGroup.MarginLayoutParams) r177;
        if (r178 == null) goto L477;
        r178.topMargin = 0;
        r176.setLayoutParams(r178);
    L477:
        if (r7 != null) goto L479;
    L481:
        boolean r179 = false;
    L482:
        if (r220 == null) goto L488;
        com.bytedance.android.shopping.anchorv4.vm.g r180 = r220.pageStatus();
        if (r180 == null) goto L488;
        if (r180.f != 0) goto L488;
    L492:
        if (r179 == false) goto L509;
        LinearLayout r181 = r4.c;
        if (r181 != null) goto L496;
        Intrinsics.throwUninitializedPropertyAccessException("llShopExtra");
    L496:
        r181.setVisibility(0);
        LongContentLabelComponentView r182 = r4.w;
        if (r182 != null) goto L499;
        Intrinsics.throwUninitializedPropertyAccessException("tvRecommendTitle");
    L499:
        r182.setVisibility(0);
        AnchorV3RecInShopBoxView r183 = r4.x;
        if (r183 != null) goto L502;
        Intrinsics.throwUninitializedPropertyAccessException("bvRecInShop");
    L502:
        r183.setVisibility(0);
        LongContentLabelComponentView r184 = r4.w;
        if (r184 != null) goto L505;
        Intrinsics.throwUninitializedPropertyAccessException("tvRecommendTitle");
    L505:
        r184.bind(r5.getShopRecommendTitle());
        AnchorV3RecInShopBoxView r185 = r4.x;
        if (r185 != null) goto L508;
        Intrinsics.throwUninitializedPropertyAccessException("bvRecInShop");
    L508:
        AnchorV4VM r186 = r220;
        r185.b(r7, r8, r186);
    L518:
        if (r5.getShopProfile() != null) goto L536;
        if (r179 == true) goto L536;
        LinearLayout r187 = r4.c;
        if (r187 != null) goto L523;
        Intrinsics.throwUninitializedPropertyAccessException("llShopExtra");
    L523:
        r187.setVisibility(8);
        LinearLayout r188 = r4.a;
        if (r188 != null) goto L526;
        Intrinsics.throwUninitializedPropertyAccessException("llShopInfo");
    L526:
        LinearLayout r189 = r4.a;
        if (r189 != null) goto L529;
        Intrinsics.throwUninitializedPropertyAccessException("llShopInfo");
    L529:
        int r190 = r189.getPaddingLeft();
        LinearLayout r191 = r4.a;
        if (r191 != null) goto L532;
        Intrinsics.throwUninitializedPropertyAccessException("llShopInfo");
    L532:
        int r192 = r191.getPaddingTop();
        LinearLayout r193 = r4.a;
        if (r193 != null) goto L535;
        Intrinsics.throwUninitializedPropertyAccessException("llShopInfo");
    L535:
        r188.setPadding(r190, r192, r193.getPaddingRight(), com.bytedance.android.shopping.extensions.b.b(12));
    L536:
        LynxCardView r194 = r4.p;
        if (r194 != null) goto L539;
        Intrinsics.throwUninitializedPropertyAccessException("storeReputationLynxView");
    L539:
        AnchorV4ShopAndStoreReputation r195 = r5.getStoreReputation();
        if (r195 == null) goto L542;
        LynxCardComponent r196 = r195.getLynxReputation();
        int r197 = 6;
        boolean r198 = false;
    L543:
        LynxCardView.a(r194, r196, r198, r197);
        r4.b(r5);
        r4.a(r5);
        if (r186 == null) goto L548;
        CommonMeta r199 = r186.commonMeta();
        if (r199 == null) goto L548;
        Boolean r1100 = Boolean.valueOf(r199.getEnablePDPOptimize());
    L550:
        if (k.i(r1100) == false) goto L552;
        r4.I.f(new Radius(12, 12, 12, 12));
    L552:
        r4.c(r5);
    L548:
        r1100 = null;
        goto L550
    L542:
        r197 = 6;
        r198 = false;
        r196 = null;
        goto L543
    L509:
        r186 = r220;
        LongContentLabelComponentView r200 = r4.w;
        if (r200 != null) goto L512;
        Intrinsics.throwUninitializedPropertyAccessException("tvRecommendTitle");
    L512:
        r200.setVisibility(8);
        AnchorV3RecInShopBoxView r201 = r4.x;
        if (r201 != null) goto L515;
        Intrinsics.throwUninitializedPropertyAccessException("bvRecInShop");
    L515:
        r201.setVisibility(8);
    L488:
        if (r4.P0 == null) goto L490;
    L516:
        r186 = r220;
        goto L518
    L490:
        if (r5.getShopStructOptimize() == false) goto L516;
    L479:
        if ((!r7.isEmpty()) == false) goto L481;
        r179 = true;
        goto L482
    L447:
        r169 = 2131105946;
        goto L448
    L434:
        if (r5.getShopBackground() == null) goto L436;
        int r221 = 12;
    L437:
        r166.topMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r221));
        r107.setLayoutParams(r166);
        goto L438
    L436:
        r221 = 6;
        goto L437
    L564:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L566:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L568:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L384:
        TextWithOneIconElementView r202 = r4.g;
        if (r202 != null) goto L387;
        Intrinsics.throwUninitializedPropertyAccessException("tivShopName");
    L387:
        TextWithOneIconElementView r203 = r4.g;
        if (r203 != null) goto L390;
        Intrinsics.throwUninitializedPropertyAccessException("tivShopName");
    L390:
        ConstraintLayout.LayoutParams r204 = r203.getLayoutParams();
        if (r204 == null) goto L572;
        ConstraintLayout.LayoutParams r205 = r204;
        ((ViewGroup.MarginLayoutParams) r205).topMargin = com.bytedance.android.shopping.extensions.b.b(10);
        Unit r206 = Unit.INSTANCE;
        r202.setLayoutParams(r205);
        LinearLayout r207 = r4.k;
        if (r207 != null) goto L395;
        Intrinsics.throwUninitializedPropertyAccessException("llScore");
    L395:
        LinearLayout r208 = r4.k;
        if (r208 != null) goto L398;
        Intrinsics.throwUninitializedPropertyAccessException("llScore");
    L398:
        ConstraintLayout.LayoutParams r209 = r208.getLayoutParams();
        if (r209 == null) goto L570;
        ConstraintLayout.LayoutParams r222 = r209;
        r222.topToBottom = 2131362894;
        r207.setLayoutParams(r222);
        goto L401
    L570:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L572:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L380:
        r92 = false;
        goto L382
    L335:
        r77 = false;
        goto L336
    L328:
        r75 = false;
        goto L329
    L315:
        if (r5.getShopSalesText() == null) goto L343;
    L308:
        AppCompatTextView r223 = r4.D;
        if (r223 != null) goto L311;
        Intrinsics.throwUninitializedPropertyAccessException("superMarketDistance");
    L311:
        r223.setVisibility(8);
        goto L313
    L299:
        if (r8.getSupermarketType() != 2) goto L301;
        r69 = 8;
        goto L302
    L285:
        r161 = null;
        goto L286
    L278:
        r160 = null;
    L287:
        r16 = r1;
        r29 = "null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.shop.AnchorV4ShopAndStoreView";
        r220 = r9;
        goto L288
    L211:
        r144 = null;
        goto L213
    L207:
        r143 = null;
        goto L208
    L203:
        r142 = null;
        goto L204
    L193:
        r141 = 8;
        goto L194
    L171:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L172:
        AppCompatTextView r224 = r4.t;
        if (r224 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("tvPeersExceeded");
    L175:
        AppCompatTextView r1101 = r4.t;
        if (r1101 != null) goto L178;
        Intrinsics.throwUninitializedPropertyAccessException("tvPeersExceeded");
    L178:
        ViewGroup.LayoutParams r1102 = r1101.getLayoutParams();
        if (r1102 == null) goto L574;
        LinearLayout.LayoutParams r1103 = (LinearLayout.LayoutParams) r1102;
        r1103.leftMargin = com.bytedance.android.shopping.extensions.b.b(8);
        r224.setLayoutParams(r1103);
        goto L181
    L574:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L155:
        if (r30.length() == 0) goto L158;
        r31 = false;
        goto L160
    L152:
        r30 = null;
        goto L153
    L144:
        r136 = null;
    L148:
        r137 = false;
        goto L149
    L138:
        r134 = null;
        goto L140
    L125:
        if (r5.getShopIcon() != null) goto L132;
        if (r5.getPeersExceeded() != null) goto L132;
        LinearLayout r225 = r4.k;
        if (r225 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("llScore");
    L131:
        r225.setVisibility(8);
        goto L132
    L118:
        LinearLayout r226 = r4.r;
        if (r226 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("llStars");
    L121:
        r226.setVisibility(8);
    L79:
        r125 = null;
        goto L81
    L73:
        r122 = null;
        goto L74
    L60:
        r119 = null;
        goto L67
    L61:
        StringBuilder r1104 = new StringBuilder();
        TextElement r1105 = r5.getRatingScore();
        if (r1105 == null) goto L64;
        String r1106 = r1105.getText();
    L65:
        r1104.append(r1106);
        r1104.append(' ');
        r118 = r1104.toString();
        goto L66
    L64:
        r1106 = null;
        goto L65
    L52:
        if (r115.length() == 0) goto L55;
        r116 = false;
        goto L56
    L49:
        r115 = null;
    L28:
        r20 = null;
        goto L29
    L10:
        if (r5.getShopStructOptimize() == false) goto L12;
        r4.removeAllViews();
        r4.d(2131560517);
        goto L12
    L576:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.shop.AnchorV4ShopAndStoreView");
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r2, Action r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "action");
        ((a) this.n.getValue()).O0(r2, r3, r4);
    }

    public AnchorV4ShopAndStoreVH(ViewGroup r6, VisibleLogManager r7, FragmentActivity r8, AnchorV4VM r9) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "logManager");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "viewModel");
        super(new AnchorV4ShopAndStoreView(r6.getContext(), null, 0, 14), true);
        this.o = r6;
        this.p = r7;
        this.q = r8;
        this.r = r9;
        this.n = LazyKt.lazy(new AnchorV4ShopAndStoreVH$clickHandler$2(this));
    }
}
