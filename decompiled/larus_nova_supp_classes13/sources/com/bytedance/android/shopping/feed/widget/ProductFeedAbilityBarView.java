package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionCustomButtonStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductAuthorEntriesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCommentsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductLink;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPageConfigStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.ShopBindAuthorDTO;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.f2;
import com.bytedance.android.shopping.feed.event.m0;
import com.bytedance.android.shopping.feed.event.p0;
import com.bytedance.android.shopping.feed.event.q0;
import com.bytedance.android.shopping.feed.event.r0;
import com.bytedance.android.shopping.feed.event.w1;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/ProductFeedAbilityBarView;", "Lcom/bytedance/android/shopping/feed/widget/InflowAbilityViewLayout;", "Lcom/bytedance/android/shopping/feed/widget/InflowSimpleAbilityView;", "a", "Lcom/bytedance/android/shopping/feed/widget/InflowSimpleAbilityView;", "getCommentAbilityView", "()Lcom/bytedance/android/shopping/feed/widget/InflowSimpleAbilityView;", "commentAbilityView", "b", "getShopAbilityView", "shopAbilityView", "Lcom/bytedance/android/shopping/feed/widget/InflowCollectAbilityView;", "c", "Lcom/bytedance/android/shopping/feed/widget/InflowCollectAbilityView;", "getCollectionAbilityView", "()Lcom/bytedance/android/shopping/feed/widget/InflowCollectAbilityView;", "collectionAbilityView", "d", "getShareAbilityView", "shareAbilityView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFeedAbilityBarView extends InflowAbilityViewLayout {
    public final InflowSimpleAbilityView a;
    public final InflowSimpleAbilityView b;
    public final InflowCollectAbilityView c;
    public final InflowSimpleAbilityView d;
    public rd3.a e;
    public final HashMap<String, String> f;

    public static final class a {
        public final ProductFeedAdapter a;
        public final ProductFeedAbilityBarView b;

        public final void a(rd3.a r24) {
            Intrinsics.checkNotNullParameter(r24, "anchorInflowFeedItem");
            Promotion r1 = r24.f();
            if (r1 == null) goto L9;
            PromotionProductStruct r2 = r1.getPromotionInfo();
            if (r2 == null) goto L9;
            PromotionProductBaseStruct r3 = r2.getBaseInfo();
            if (r3 == null) goto L9;
            String r4 = r3.getProductId();
        L11:
            if (this.a.v.contains(r4) == true) goto L117;
            this.a.v.add(r4);
            if (this.b.getCommentAbilityView().getVisibility() != 0) goto L15;
            boolean r5 = true;
        L16:
            r0 r13 = r0.a;
            q0 r14 = q0.a;
            if (r5 == true) goto L19;
        L56:
            String r12 = "product_flow_page";
            String r10 = "carrier_source";
        L58:
            if (this.b.getShareAbilityView().getVisibility() != 0) goto L60;
            boolean r6 = true;
        L61:
            if (r6 == false) goto L101;
            if (r24.e == false) goto L65;
            String r7 = "c3865.d3257";
        L66:
            String r8 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r7, Boolean.FALSE).withView(this.b.getShareAbilityView()).build());
            FeedProductEventTracker r9 = FeedProductEventTracker.a;
            Context r11 = this.b.getContext();
            r9.getClass();
            Intrinsics.checkNotNullParameter(r11, "context");
            ProductFeedViewModel r15 = r24.c;
            if (r15 == null) goto L101;
            Promotion r16 = r24.f();
            if (r16 == null) goto L72;
            PromotionProductStruct r17 = r16.getPromotionInfo();
        L73:
            boolean r18 = r24.e;
            AnchorV3Param r19 = r15.m907getAnchorV3Param();
            if (r19 == null) goto L101;
            if (r19.isOptInflowCode() == false) goto L78;
            Single.fromCallable(new p0(2, r11, r19, r18, r17, r24, r8)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(r14, r13);
            goto L101
        L78:
            f2 r20 = new f2();
            String r21 = r19.getEntranceInfo();
            if (r21 == null) goto L83;
            JSONObject r22 = z1.g(r21);
            if (r22 == null) goto L83;
            String r23 = r22.optString(r10);
        L84:
            r20.a = r23;
            r20.d = r19.getRequestParam().getItemId();
            r20.b = r12;
            if (r18 == false) goto L87;
            String r25 = "guess_you_like_product";
        L88:
            r20.f = r25;
            if (r17 == null) goto L93;
            PromotionProductBaseStruct r26 = r17.getBaseInfo();
            if (r26 == null) goto L93;
            String r27 = r26.getProductId();
        L94:
            r20.c = r27;
            r20.e = r19.getAuthorId();
            r20.g = r24.m;
            if (r8 != null) goto L97;
        L99:
            com.bytedance.android.shopping.feed.event.g.d(r20, r11);
            goto L101
        L97:
            if (a2.d(r8) == null) goto L99;
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r20.appendParam("btm_id", r8, com.bytedance.android.ec.core.event.a.b.a.a);
        L93:
            r27 = null;
            goto L94
        L87:
            r25 = null;
        L83:
            r23 = null;
            goto L84
        L72:
            r17 = null;
            goto L73
        L65:
            r7 = "c4701.d559069";
        L101:
            if (this.b.getCollectionAbilityView().getVisibility() != 0) goto L103;
            boolean r28 = true;
        L104:
            if (r28 == false) goto L107;
            FeedProductEventTracker r29 = FeedProductEventTracker.a;
            Context r30 = this.b.getContext();
            r29.getClass();
            FeedProductEventTracker.T("show_wish_button", r30, r24);
        L107:
            if (this.b.getShopAbilityView().getVisibility() != 0) goto L109;
            boolean r110 = true;
        L110:
            if (r110 == true) goto L112;
            return;
        L112:
            if (r24.e == false) goto L114;
            String r31 = "c3865.d1098";
        L115:
            String r32 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r31, Boolean.FALSE).withView(this.b.getShopAbilityView()).build());
            FeedProductEventTracker r33 = FeedProductEventTracker.a;
            Context r34 = this.b.getContext();
            r33.getClass();
            FeedProductEventTracker.S(r24, r34, r32, "", null);
            return;
        L114:
            r31 = "c4701.d801643";
            goto L115
        L109:
            r110 = false;
            goto L110
        L103:
            r28 = false;
            goto L104
        L60:
            r6 = false;
            goto L61
        L19:
            if (r24.e == false) goto L21;
            String r35 = "c3865.d14712";
        L22:
            String r36 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r35, Boolean.FALSE).withView(this.b.getCommentAbilityView()).build());
            FeedProductEventTracker r37 = FeedProductEventTracker.a;
            Context r38 = this.b.getContext();
            r37.getClass();
            Intrinsics.checkNotNullParameter(r38, "context");
            ProductFeedViewModel r39 = r24.c;
            if (r39 == null) goto L56;
            Promotion r40 = r24.f();
            if (r40 == null) goto L28;
            PromotionProductStruct r111 = r40.getPromotionInfo();
        L29:
            boolean r41 = r24.e;
            AnchorV3Param r112 = r39.m907getAnchorV3Param();
            if (r112 == null) goto L56;
            if (r112.isOptInflowCode() == false) goto L34;
            r12 = "product_flow_page";
            r10 = "carrier_source";
            Single.fromCallable(new m0(2, r38, r112, r41, r111, r24, r36)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(r14, r13);
            goto L58
        L34:
            r12 = "product_flow_page";
            r10 = "carrier_source";
            w1 r42 = new w1();
            String r43 = r112.getEntranceInfo();
            if (r43 == null) goto L39;
            JSONObject r44 = z1.g(r43);
            if (r44 == null) goto L39;
            String r45 = r44.optString(r10);
        L40:
            r42.a = r45;
            r42.d = r112.getRequestParam().getItemId();
            r42.b = r12;
            if (r41 == false) goto L43;
            String r46 = "guess_you_like_product";
        L44:
            r42.e = r46;
            if (r111 == null) goto L49;
            PromotionProductBaseStruct r47 = r111.getBaseInfo();
            if (r47 == null) goto L49;
            String r48 = r47.getProductId();
        L50:
            r42.c = r48;
            r42.f = "product_comment";
            r42.g = r24.m;
            if (r36 != null) goto L53;
        L55:
            com.bytedance.android.shopping.feed.event.g.d(r42, r38);
            goto L58
        L53:
            if (a2.d(r36) == null) goto L55;
            com.bytedance.android.ec.core.event.a.b.a.getClass();
            r42.appendParam("btm_id", r36, com.bytedance.android.ec.core.event.a.b.a.a);
        L49:
            r48 = null;
            goto L50
        L43:
            r46 = null;
        L39:
            r45 = null;
            goto L40
        L28:
            r111 = null;
            goto L29
        L21:
            r35 = "c4701.d348477";
            goto L22
        L15:
            r5 = false;
            goto L16
        L117:
            return;
        L9:
            r4 = null;
            goto L11
        }

        public a(ProductFeedAdapter r2, ProductFeedAbilityBarView r3) {
            Intrinsics.checkNotNullParameter(r2, "adapter");
            Intrinsics.checkNotNullParameter(r3, "abilityBarView");
            this.a = r2;
            this.b = r3;
        }
    }

    public ProductFeedAbilityBarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductFeedAbilityBarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final InflowCollectAbilityView getCollectionAbilityView() {
        return this.c;
    }

    public final InflowSimpleAbilityView getCommentAbilityView() {
        return this.a;
    }

    public final InflowSimpleAbilityView getShareAbilityView() {
        return this.d;
    }

    public final InflowSimpleAbilityView getShopAbilityView() {
        return this.b;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(rd3.a r15) {
        Intrinsics.checkNotNullParameter(r15, "anchorInflowFeedItem");
        this.e = r15;
        String r0 = "";
        if (r15 == null) goto L17;
        HashMap<String, String> r1 = this.f;
        String r2 = r15.d;
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        r1.put("request_id", r2);
        HashMap<String, String> r3 = this.f;
        Promotion r16 = r15.f();
        if (r16 == null) goto L15;
        PromotionProductStruct r17 = r16.getPromotionInfo();
        if (r17 == null) goto L15;
        PromotionProductBaseStruct r18 = r17.getBaseInfo();
        if (r18 == null) goto L15;
        String r19 = r18.getProductId();
        if (r19 == null) goto L15;
    L16:
        r3.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r19);
    L15:
        r19 = "";
    L17:
        rd3.a r110 = this.e;
        if (r110 == null) goto L22;
        Promotion r111 = r110.f();
        if (r111 == null) goto L22;
        PromotionProductStruct r112 = r111.getPromotionInfo();
    L23:
        rd3.a r4 = this.e;
        if (r4 == null) goto L28;
        ProductFeedViewModel r5 = r4.c;
        if (r5 == null) goto L28;
        AnchorV3Param r6 = r5.m907getAnchorV3Param();
    L29:
        if (r112 == null) goto L31;
        d63.t r7 = d63.r.b(r112);
    L32:
        if (r112 == null) goto L34;
        d63.q r8 = d63.r.a(r112);
    L36:
        if (r8 != null) goto L38;
    L39:
        if (r112 != null) goto L41;
    L43:
        this.b.setVisibility(8);
    L44:
        InflowSimpleAbilityView r9 = this.b;
        if (r7 == null) goto L50;
        String r10 = r7.a;
        if (r10 == null) goto L50;
        r0 = r10;
    L50:
        r9.setText(r0);
        int r11 = ld3.d.a;
        int r12 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r13 = 0;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L55
        jj4.b r20 = jj4.b.b;     // Catch: Throwable -> L55
        Object r21 = jj4.a.a("video_inner_new_shop_icon", Integer.class, r13, false);     // Catch: Throwable -> L55
        if (r21 != null) goto L62;
        Intrinsics.throwNpe();     // Catch: Throwable -> L55
    L62:
        if (ld3.d.e(((Number) r21).intValue()) == false) goto L72;
        InflowSimpleAbilityView r22 = this.b;
        if (r112 == null) goto L70;
        PromotionProductAuthorEntriesStruct r113 = r112.getEntryInfo();
        if (r113 == null) goto L70;
        ShopBindAuthorDTO r114 = r113.getShopBindAuthor();
        if (r114 == null) goto L70;
        ECUrlModel r115 = r114.getAuthorAvatar();
    L71:
        r22.setIconUrl(r115);
    L70:
        r115 = null;
    L72:
        this.b.setOnClickListener(new r(this, r6));
        rd3.a r116 = this.e;
        if (r116 == null) goto L98;
        Promotion r117 = r116.f();
        if (r117 == null) goto L98;
        PromotionProductStruct r118 = r117.getPromotionInfo();
        if (r118 == null) goto L98;
        PromotionProductPageConfigStruct r23 = r118.getPageComsConfig();
        if (r23 == null) goto L82;
        Boolean r24 = r23.getDisPlayCollectIcon();
    L84:
        if (Intrinsics.areEqual(r24, Boolean.TRUE) == false) goto L86;
    L89:
        this.c.setVisibility(0);
    L90:
        InflowCollectAbilityView r25 = this.c;
        PromotionProductExtraStruct r26 = r118.getExtraInfo();
        if (r26 == null) goto L95;
        Boolean r27 = r26.getFavorited();
        if (r27 == null) goto L95;
        boolean r28 = r27.booleanValue();
    L96:
        r25.setCollected(r28);
        this.c.setOnClickListener(new ProductFeedAbilityBarView$bindCollectAbilityView$1(this, r118));
    L95:
        r28 = false;
        goto L96
    L86:
        if (r118.isUseAnchorInfo() == true) goto L89;
        this.c.setVisibility(8);
        goto L90
    L82:
        r24 = null;
    L98:
        if (ld3.d.e(ld3.d.b()) == true) goto L127;
        rd3.a r119 = this.e;
        if (r119 == null) goto L127;
        Promotion r120 = r119.f();
        if (r120 == null) goto L127;
        PromotionProductStruct r121 = r120.getPromotionInfo();
        if (r121 == null) goto L127;
        rd3.a r29 = this.e;
        if (r29 == null) goto L127;
        ProductFeedViewModel r30 = r29.c;
        if (r30 == null) goto L127;
        AnchorV3Param r31 = r30.m907getAnchorV3Param();
        if (r31 == null) goto L127;
        r31.setPageName("product_flow_page");
        int r32 = ECSdk.a;
        IEShoppingService r33 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r33 == null) goto L127;
        n83.f r122 = r33.getAnchorV3ShareBtn(r31, r121, this.d);
        if (r122 == null) goto L127;
        r122.a();
        r122.c();
        rd3.a r34 = this.e;
        if (r34 != null) goto L119;
    L121:
        boolean r35 = false;
    L122:
        r122.b(r35);
        rd3.a r36 = this.e;
        if (r36 == null) goto L125;
        String r37 = r36.m;
    L126:
        r122.d(r37);
        goto L127
    L125:
        r37 = null;
        goto L126
    L119:
        if (r34.e != true) goto L121;
        r35 = true;
    L127:
        rd3.a r123 = this.e;
        if (r123 == null) goto L132;
        Promotion r124 = r123.f();
        if (r124 == null) goto L132;
        PromotionProductStruct r125 = r124.getPromotionInfo();
    L133:
        if (r125 == null) goto L163;
        Intrinsics.checkNotNullParameter(r125, "$this$transformToInflowFeedCommentVO");
        PromotionCustomButtonStruct r38 = r125.getCustomButton();
        if (r38 == null) goto L137;
        Integer r39 = r38.getType();
    L138:
        if (r39 == null) goto L163;
        if (r39.intValue() != 101) goto L163;
        PromotionCustomButtonStruct r40 = r125.getCustomButton();
        if (r40 == null) goto L147;
        PromotionProductLink r41 = r40.getLinks();
        if (r41 == null) goto L147;
        String r42 = r41.getUniversalLink();
    L148:
        PromotionCustomButtonStruct r43 = r125.getCustomButton();
        if (r43 == null) goto L151;
        Integer r126 = r43.getStyle();
    L152:
        PromotionProductCommentsStruct r44 = r125.getCommentInfo();
        if (r44 == null) goto L157;
        Long r45 = r44.getTotalCount();
        if (r45 == null) goto L157;
        long r46 = r45.longValue();
    L158:
        long r127 = r46;
        PromotionCustomButtonStruct r47 = r125.getCustomButton();
        if (r47 == null) goto L161;
        boolean r128 = r47.isShowCommentCounts();
    L162:
        final rd3.h r48 = new rd3.h(r42, r126, r127, r128);
    L164:
        if (r48 == null) goto L173;
        String r49 = r48.a;
        if (r49 == null) goto L173;
        if (com.bytedance.android.shopping.extensions.k.c(r49) == true) goto L171;
        r49 = null;
    L171:
        if (r49 == null) goto L173;
        com.bytedance.android.ec.core.widget.f.c(this.a, null, "bind_product_flow_card", new ProductFeedAbilityBarView$bindCommentAbilityView$$inlined$let$lambda$1(this, r48), 1);
        this.a.setVisibility(0);
        return;
    L173:
        if (r125 != null) goto L175;
    L177:
        this.a.setVisibility(8);
        return;
    L175:
        if (r125.isUseAnchorInfo() != true) goto L177;
        this.a.setVisibility(0);
        return;
    L161:
        r128 = false;
    L157:
        r46 = 0;
        goto L158
    L151:
        r126 = null;
    L147:
        r42 = null;
        goto L148
    L137:
        r39 = null;
    L163:
        r48 = null;
    L132:
        r125 = null;
    L55:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r51) == true) goto L60;
        r13 = r51;
    L60:
        r21 = r13;
        goto L62
    L41:
        if (r112.isUseAnchorInfo() != true) goto L43;
    L42:
        this.b.setVisibility(0);
        goto L44
    L38:
        if (r8.k == true) goto L42;
    L34:
        r8 = null;
        goto L36
    L31:
        r7 = null;
    L28:
        r6 = null;
    L22:
        r112 = null;
        goto L23
    }

    public ProductFeedAbilityBarView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        int r8 = com.bytedance.android.shopping.feed.view.e.a;
        InflowSimpleAbilityView r9 = com.bytedance.android.shopping.feed.view.e.a(r5, 2131234570, com.bytedance.android.shopping.extensions.j.c(2131913957));
        this.a = r9;
        InflowSimpleAbilityView r10 = com.bytedance.android.shopping.feed.view.e.a(r5, 2131234572, com.bytedance.android.shopping.extensions.j.c(2131913968));
        this.b = r10;
        InflowCollectAbilityView r0 = new InflowCollectAbilityView(r5, null, 6, 0);
        this.c = r0;
        InflowSimpleAbilityView r11 = com.bytedance.android.shopping.feed.view.e.a(r5, 2131234571, com.bytedance.android.shopping.extensions.j.c(2131913967));
        this.d = r11;
        this.f = new HashMap();
        InflowAbilityViewLayout.a(this, r10);
        InflowAbilityViewLayout.a(this, r9);
        if (ld3.d.e(ld3.d.b()) == true) goto L5;
        InflowAbilityViewLayout.a(this, r11);
    L5:
        InflowAbilityViewLayout.a(this, r0);
    }

    public /* synthetic */ ProductFeedAbilityBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
