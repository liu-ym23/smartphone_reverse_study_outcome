package com.bytedance.android.shopping.feed.viewholder;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.bst.models.ShoppingModel;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.innerflow.jedi.JediBaseFragment;
import com.bytedance.android.ec.model.InnerFlowAdRawData;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.BenefitComponent;
import com.bytedance.android.ec.model.response.anchorv3.ProductTopicInfo;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductAuthorEntriesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.TopicItemInfo;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.g;
import com.bytedance.android.shopping.feed.event.h;
import com.bytedance.android.shopping.feed.event.l;
import com.bytedance.android.shopping.feed.event.o;
import com.bytedance.android.shopping.feed.event.u0;
import com.bytedance.android.shopping.feed.utils.ProductFeedActionHelper;
import com.bytedance.android.shopping.feed.utils.k;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.BaseCardDetailView;
import com.bytedance.android.shopping.feed.widget.GuessULikeProductCardDetailView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jd3.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ld3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u00020\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/feed/viewholder/GuessULikeProductCardDetailVH;", "Lcom/bytedance/android/shopping/feed/viewholder/BaseProductFeedCardVH;", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter$b;", "Lrd3/a;", "Lcom/bytedance/android/shopping/feed/viewholder/a;", "", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuessULikeProductCardDetailVH extends BaseProductFeedCardVH<ProductFeedAdapter.b<rd3.a>> implements a {
    public boolean t;
    public boolean u;

    public final void f4() {
        d r0 = new d();
        r0.a = "a1.b7365.c3865.d5531";
        r0.b = PageFinder.via(this.p);
        int r1 = o.a;
        BaseCardDetailView r2 = this.r;
        rd3.a r4 = this.m;
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r0, "btmModel");
        if (r4 == null) goto L57;
        int r3 = 0;
        if (f.b() == false) goto L19;
        String r5 = r0.a;
        Promotion r6 = r4.f();
        if (r6 == null) goto L52;
        PromotionProductStruct r7 = r6.getPromotionInfo();
        if (r7 == null) goto L58;
        h r8 = new h(r2, r4);
        if (r5.length() != 0) goto L15;
        r3 = 1;
    L15:
        if (r3 == 0) goto L17;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L17:
        com.bytedance.android.bst.api.d r9 = new com.bytedance.android.bst.api.d(r2);
        r9.a = r5;
        r9.b = "show_product";
        r9.c = r7;
        r9.d = "like_shopping";
        r9.e = -1;
        r9.f = r8;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.a(r9);
        return;
    L58:
        return;
    L52:
        return;
    L19:
        if (com.bytedance.android.bst.api.f.e().isBstBindEnable("video_product_list") == false) goto L50;
        String r10 = r0.a;
        if (com.bytedance.android.bst.api.f.e().isBstBindEnable("video_product_list") == false) goto L59;
        ProductFeedViewModel r11 = r4.c;
        if (r11 == null) goto L60;
        AnchorV3Param r12 = r11.m907getAnchorV3Param();
        Promotion r13 = r4.f();
        if (r13 == null) goto L54;
        PromotionProductStruct r14 = r13.getPromotionInfo();
        if (r14 == null) goto L61;
        PromotionProductBaseStruct r15 = r14.getBaseInfo();
        if (r15 == null) goto L35;
        String r16 = r15.getProductId();
        if (r16 == null) goto L35;
    L36:
        if (r12 != null) goto L38;
    L40:
        ShoppingModel r17 = new ShoppingModel(r16, r3, "product", 1);
        HashMap r18 = r17.getExtraInfo();
        FeedProductEventTracker.a.getClass();
        u r19 = FeedProductEventTracker.d(r12, r4, r14, null, false, null);
        g.b(r19, r2.getContext());
        Unit r20 = Unit.INSTANCE;
        r18.putAll(r19.getParams());
        ArrayList r21 = new ArrayList();
        LinkedHashMap r22 = new LinkedHashMap();
        ArrayList r23 = new ArrayList();
        int r24 = sc.a.a;
        r21.add("click");
        com.bytedance.android.bst.api.b r25 = null;
        if (com.bytedance.android.bst.api.f.e().isOriginReportEnable("video_product_list") == true) goto L43;
        BtmItemBuilder r26 = new BtmItemBuilder(null, Boolean.FALSE, 1, null).withView(r2);
    L44:
        if (r10 == null) goto L48;
        r25 = new com.bytedance.android.bst.api.b(r2, r10);
        r25.a = r17;
        r25.b = r14;
        r25.c.addAll(r23);
        r25.d.putAll(r22);
        ((ArrayList) r25.e).addAll(r21);
        if (r26 == null) goto L48;
        r26.copy(r10);
    L48:
        if (r25 == null) goto L55;
        com.bytedance.android.bst.api.f.b(r25);
        return;
    L55:
        return;
    L43:
        r26 = null;
        goto L44
    L38:
        if (r12.isLuban() != true) goto L40;
        r3 = 1;
    L35:
        r16 = "";
        goto L36
    L61:
        return;
    L54:
        return;
    L60:
        return;
    L59:
        return;
    L50:
        FeedProductEventTracker.v(FeedProductEventTracker.a, r2.getContext(), r4, BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r0.a, Boolean.FALSE).withPageFinder(r0.b).build()), true, null, 16);
        return;
    }

    @Override // com.bytedance.android.shopping.feed.viewholder.BaseProductFeedCardVH
    public final void T3() {
        super.T3();
        rd3.a r0 = this.m;
        String r1 = null;
        if (r0 == null) goto L7;
        Promotion r2 = r0.f();
        if (r2 == null) goto L7;
        PromotionProductStruct r3 = r2.getPromotionInfo();
    L8:
        if (r3 == null) goto L12;
        PromotionProductBaseStruct r4 = r3.getBaseInfo();
        if (r4 == null) goto L12;
        String r5 = r4.getProductId();
    L14:
        if (this.q.u.contains(r5) == true) goto L93;
        this.q.u.add(r5);
        f4();
        FeedProductEventTracker r6 = FeedProductEventTracker.a;
        rd3.a r7 = this.m;
        Boolean r8 = Boolean.FALSE;
        r6.getClass();
        FeedProductEventTracker.O(r7, r8, null);
        rd3.a r9 = this.m;
        if (r9 == null) goto L30;
        Promotion r10 = r9.f();
        if (r10 == null) goto L30;
        PromotionProductStruct r11 = r10.getPromotionInfo();
        if (r11 == null) goto L30;
        PromotionProductExtraStruct r12 = r11.getExtraInfo();
        if (r12 == null) goto L30;
        ProductTopicInfo r13 = r12.getTopicInfo();
        if (r13 == null) goto L30;
        List r14 = r13.getTopicItemList();
        if (r14 == null) goto L30;
        TopicItemInfo r15 = (TopicItemInfo) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L30;
        FeedProductEventTracker.G(this.r.getContext(), "label_show", r15);
    L30:
        int r16 = ECSdk.a;
        IECUserTrackerService r17 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r17 == null) goto L35;
        of.a r18 = r17.getMarketingService();
        if (r18 == null) goto L35;
        r18.a("video_inner_flow_slide_product", PostActionType.DO, "video_inner_flow");
    L35:
        rd3.a r19 = this.m;
        if (r19 == null) goto L40;
        InnerFlowAdRawData r20 = r19.a;
        if (r20 == null) goto L40;
        int r21 = k.a;
        new com.bytedance.android.shopping.feed.event.d(r20).post(null, null);
    L40:
        if (r3 == null) goto L51;
        PromotionProductPrivilegesStruct r22 = r3.getPrivilegeInfo();
        if (r22 == null) goto L51;
        PromotionProductCouponsStruct r23 = r22.getCoupons();
        if (r23 == null) goto L51;
        BenefitComponent r24 = r23.getBenefitComponent();
        if (r24 == null) goto L51;
        Map r25 = r24.getData();
        if (r25 == null) goto L51;
        r1 = (String) r25.get("detail");
    L51:
        if (r1 != null) goto L53;
    L56:
        boolean r26 = true;
    L57:
        if (r26 == true) goto L59;
        FeedProductEventTracker.M(this.m, this.r.getContext());
    L59:
        if (r3 == null) goto L66;
        PromotionProductAuthorEntriesStruct r27 = r3.getEntryInfo();
        if (r27 == null) goto L66;
        if (r27.getLeaderBoardEntry() == null) goto L66;
        FeedProductEventTracker.I(this.m, this.r.getContext());
    L66:
        rd3.a r28 = this.m;
        if (r28 == null) goto L87;
        ProductFeedViewModel r29 = r28.c;
        if (r29 == null) goto L87;
        InnerFlowPageStyleDTO r30 = r29.getInnerFlowPageStyle();
        if (r30 == null) goto L87;
        PageStyle r31 = r30.getPageStyle();
        if (r31 == null) goto L87;
        if (r31.isGuessULikeShowSearchPdt() != true) goto L87;
        rd3.a r32 = this.m;
        if (r32 == null) goto L87;
        ProductFeedViewModel r33 = r32.c;
        if (r33 == null) goto L87;
        InnerFlowPageStyleDTO r34 = r33.getInnerFlowPageStyle();
        if (r34 == null) goto L87;
        PageStyle r35 = r34.getPageStyle();
        if (r35 == null) goto L87;
        if (r35.getSearchPdtStyle() != 1) goto L87;
        FeedProductEventTracker.A(this.r.getContext(), "show_inflow_similar_tab", true, "product_info");
    L87:
        rd3.a r36 = this.m;
        if (r36 != null) goto L90;
        return;
    L90:
        if (r36.b() != true) goto L95;
        FeedProductEventTracker.p(this.m);
        return;
    L95:
        return;
    L53:
        if (StringsKt.isBlank(r1) == true) goto L56;
        r26 = false;
        goto L57
    L93:
        return;
    L12:
        r5 = null;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.feed.viewholder.a
    public final void O(float r3) {
        BaseCardDetailView r0 = this.r;
        if ((r0 instanceof BaseCardDetailView) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L8;
        r0.setTransitionFactor(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a4(Object r5) {
        ProductFeedAdapter.b r6 = (ProductFeedAdapter.b) r5;
        Intrinsics.checkNotNullParameter(r6, "item");
        rd3.a r7 = (rd3.a) r6.b;
        this.m = r7;
        View r0 = null;
        if (r7 == null) goto L7;
        Promotion r8 = r7.f();
        if (r8 == null) goto L7;
        PromotionProductStruct r9 = r8.getPromotionInfo();
    L8:
        View r1 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r1 instanceof GuessULikeProductCardDetailView) == false) goto L12;
        r0 = r1;
    L12:
        GuessULikeProductCardDetailView r2 = (GuessULikeProductCardDetailView) r0;
        if (r2 == null) goto L15;
        r2.b(this.o, this.m);
    L15:
        f4();
        if (this.u == false) goto L18;
    L20:
        FeedProductEventTracker r10 = FeedProductEventTracker.a;
        rd3.a r3 = this.m;
        r10.getClass();
        FeedProductEventTracker.J(r3);
        if (this.q.F == false) goto L44;
        rd3.a r11 = this.m;
        if (r11 == null) goto L42;
        ProductFeedViewModel r12 = r11.c;
        if (r12 == null) goto L42;
        AnchorV3Param r13 = r12.m907getAnchorV3Param();
        if (r13 == null) goto L42;
        i r4 = i.a;
        com.bytedance.android.ec.monitor.duration.d r14 = r4.get(r13.getFullPageMonitorName());
        if (r14 == null) goto L31;
        r14.a("guess_u_like_render_end");
    L31:
        com.bytedance.android.ec.monitor.duration.d r15 = r4.get(r13.getFullPageMonitorName());
        if (r15 == null) goto L35;
        r15.b("guess_u_like_type", "guess_u_like");
    L35:
        if (this.q.E == true) goto L42;
        com.bytedance.android.ec.monitor.duration.d r16 = r4.get(r13.getFullPageMonitorName());
        if (r16 == null) goto L39;
        r16.a("render_end");
    L39:
        com.bytedance.android.ec.monitor.duration.d r17 = r4.get(r13.getFullPageMonitorName());
        if (r17 == null) goto L42;
        r17.report();
    L42:
        this.q.F = false;
        return;
    L44:
        return;
    L18:
        if (f53.a.b(r9) == false) goto L20;
        this.u = true;
        FeedProductEventTracker r18 = FeedProductEventTracker.a;
        Context r19 = this.r.getContext();
        rd3.a r20 = this.m;
        int r21 = vd3.a.a;
        String r22 = vd3.a.b(this.p, "a1.b7365.c3865.d5531");
        r18.getClass();
        FeedProductEventTracker.F(r19, r20, r22);
    L7:
        r9 = null;
        goto L8
    }

    public final void e4(String r7) {
        this.t = true;
        BtmSDK r0 = BtmSDK.INSTANCE;
        PageFinder r1 = PageFinder.via(this.r);
        BcmParams r2 = new BcmParams();
        r2.put("bst_group_type", "product");
        int r3 = vd3.a.a;
        rd3.a r4 = this.m;
        InnerFlowAdRawData r5 = null;
        if (r4 == null) goto L13;
        Promotion r6 = r4.f();
        if (r6 == null) goto L13;
        PromotionProductStruct r8 = r6.getPromotionInfo();
        if (r8 == null) goto L13;
        PromotionProductExtraStruct r9 = r8.getExtraInfo();
        if (r9 == null) goto L13;
        String r10 = r9.getLogExtra();
        if (r10 == null) goto L13;
        String r11 = com.bytedance.commerce.base.json.b.a(r10).optString("standard_chain_param");
    L14:
        vd3.a.a(r2, r11);
        Unit r12 = Unit.INSTANCE;
        String r13 = r0.createJumpSourceBtmToken("c3865.d5531", r1, r2);
        rd3.a r14 = this.m;
        if (r14 == null) goto L17;
        r5 = r14.a;
    L17:
        if (r5 == null) goto L20;
        int r15 = ProductFeedActionHelper.a;
        if (ProductFeedActionHelper.g(this.r.getContext(), this.m, false, r13, r7) == false) goto L20;
        return;
    L20:
        ProductFeedActionHelper.f(this.r.getContext(), this.m, r13, r7);
        return;
    L13:
        r11 = null;
        goto L14
    }

    public GuessULikeProductCardDetailVH(RecyclerView r5, JediBaseFragment r6, ProductFeedAdapter r7) {
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter(r7, "adapter");
        int r0 = GuessULikeProductCardDetailView.Q;
        Context r8 = r5.getContext();
        Intrinsics.checkNotNullParameter(r8, "context");
        if (ld3.b.a() == false) goto L5;
        Map r1 = ShoppingAsyncCacheInflater.d;
        GuessULikeProductCardDetailView r9 = (GuessULikeProductCardDetailView) ShoppingAsyncCacheInflater.a.a(r8).b("ec_commerce_guessulike_feed_product_detail_card_view", new com.bytedance.android.shopping.feed.widget.f());
    L6:
        super(r6, r7, r9);
        r6.getLifecycle().addObserver(new AnonymousClass1(this));
        return;
    L5:
        r9 = new GuessULikeProductCardDetailView(r8, null, 6, 0);
        goto L6
    }

    @Override // com.bytedance.android.shopping.feed.viewholder.BaseProductFeedCardVH
    public final void b4(ProductFeedAdapter.b<rd3.a> r5, int r6, List r7) {
        ProductFeedAdapter.b<rd3.a> r8 = r5;
        Intrinsics.checkNotNullParameter(r8, "item");
        rd3.a r0 = r8.b;
        if (r0 == null) goto L20;
        if (r0 == null) goto L10;
        ProductFeedViewModel r1 = r0.c;
        if (r1 == null) goto L10;
        List<Object> r2 = r1.getHeaderList();
        if (r2 == null) goto L10;
        int r3 = r2.size();
    L11:
        int r4 = r6 - r3;
        rd3.a r9 = r8.b;
        if (r9 == null) goto L18;
        ProductFeedViewModel r10 = r9.c;
        if (r10 == null) goto L18;
        List<Object> r11 = r10.getFirstLoadGuessULikeResourceCardList();
        if (r11 == null) goto L18;
        int r12 = r11.size();
    L19:
        r0.f = ((r4 - r12) - c4().getSearchCardNumBefore(getAdapterPosition())) - c4().goodPriceAreaNumBefore(getAdapterPosition());
    L18:
        r12 = 0;
    L10:
        r3 = 1;
    L20:
        rd3.a r13 = r8.b;
        if (r13 == null) goto L23;
        r13.g = Integer.valueOf(getLayoutPosition());
    L23:
        super.b4(r8, r6, r7);
    }

    @Override // com.bytedance.android.shopping.feed.viewholder.BaseProductFeedCardVH
    public final void d4(View r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, FreqActions.ACTION_VIEW);
        FeedProductEventTracker r10 = FeedProductEventTracker.a;
        FeedProductEventTracker.m(r10, this.m, r14, null, null, null, null, null, 124);
        if (r14 != null) goto L5;
        e4(r13);
        return;
    L5:
        int r1 = r14.hashCode();
        if (r1 == (-1377687758)) goto L48;
        if (r1 == 110986) goto L16;
        if (r1 == 93819220) goto L13;
        return;
    L13:
        if (r14.equals("blank") == false) goto L56;
    L17:
        d r16 = new d();
        r16.a = "a1.b7365.c3865.d5531";
        r16.b = PageFinder.via(this.p);
        int r2 = o.a;
        rd3.a r3 = this.m;
        Intrinsics.checkNotNullParameter(r12, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r16, "btmModel");
        if (r3 != null) goto L21;
    L38:
        rd3.a r17 = this.m;
        if (r17 != null) goto L41;
        return;
    L41:
        Integer r18 = r17.getType();
        if (r18 != null) goto L45;
        return;
    L45:
        if (r18.intValue() != 2) goto L58;
        e4(r13);
        return;
    L58:
        return;
    L21:
        if (f.b() == false) goto L33;
        String r19 = r16.a;
        if (r3.f() == null) goto L38;
        Promotion r0 = r3.f();
        l r4 = new l(r3, r12, r14);
        if (r19.length() != 0) goto L28;
        boolean r110 = true;
    L29:
        if (r110 == false) goto L31;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L31:
        com.bytedance.android.bst.api.d r111 = new com.bytedance.android.bst.api.d(r12);
        r111.a = r19;
        r111.b = "click_product";
        r111.c = r0;
        r111.d = "like_shopping";
        r111.e = -1;
        r111.f = r4;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.c(r111);
        goto L38
    L28:
        r110 = false;
        goto L29
    L33:
        if (com.bytedance.android.bst.api.f.e().isBstBindEnable("video_product_list") == false) goto L37;
        String r112 = r16.a;
        Intrinsics.checkNotNullParameter(r12, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r112, "btm");
        u0 r113 = FeedProductEventTracker.c(r3, r14, null, false, r3.k, null);
        if (r113 == null) goto L38;
        g.b(r113, r12.getContext());
        int r114 = sc.a.a;
        r113.getParams();
        com.bytedance.android.bst.api.f.g().b();
        goto L38
    L37:
        String r5 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r16.a, Boolean.FALSE).withPageFinder(r16.b).build());
        FeedProductEventTracker.u(r10, r12.getContext(), r3, r14, r5, true, r3.k, 64);
        goto L38
    L56:
        return;
    L16:
        if (r14.equals("pic") == true) goto L17;
        return;
    L48:
        if (r14.equals("button") == false) goto L60;
        String r6 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7365.c3865.d60364", Boolean.FALSE).withView(r12).build());
        Context r7 = r12.getContext();
        rd3.a r8 = this.m;
        if (r8 == null) goto L52;
        Map<String, String> r115 = r8.k;
    L53:
        FeedProductEventTracker.t(r10, r7, r8, r15, r6, r115, 8);
        return;
    L52:
        r115 = null;
        goto L53
    }
}
