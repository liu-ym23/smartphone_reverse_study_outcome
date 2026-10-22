package com.bytedance.android.shopping.feed.viewholder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.bst.models.ShoppingModel;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.innerflow.jedi.JediBaseFragment;
import com.bytedance.android.ec.model.InnerFlowAdRawData;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.BenefitComponent;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductAuthorEntriesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.enums.InflowMainCardLocationType;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.g;
import com.bytedance.android.shopping.feed.event.o;
import com.bytedance.android.shopping.feed.event.o1;
import com.bytedance.android.shopping.feed.event.u0;
import com.bytedance.android.shopping.feed.fragment.ProductFeedContentFragment;
import com.bytedance.android.shopping.feed.utils.ProductFeedActionHelper;
import com.bytedance.android.shopping.feed.utils.q;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.BaseCardDetailView;
import com.bytedance.android.shopping.feed.widget.BaseCardHeaderView;
import com.bytedance.android.shopping.feed.widget.InflowSkuWidget;
import com.bytedance.android.shopping.feed.widget.MainProductCardDetailView;
import com.bytedance.android.shopping.feed.widget.MainProductCardHeaderView;
import com.bytedance.android.shopping.feed.widget.v;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.track.TrackerProvider;
import com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import d63.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ld3.f;
import n83.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u00020\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/feed/viewholder/MainProductCardDetailVH;", "Lcom/bytedance/android/shopping/feed/viewholder/BaseProductFeedCardVH;", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter$b;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "Lcom/bytedance/android/shopping/feed/viewholder/a;", "", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainProductCardDetailVH extends BaseProductFeedCardVH<ProductFeedAdapter.b<PromotionProductStruct>> implements a {
    public boolean t;

    @Override // com.bytedance.android.shopping.feed.viewholder.BaseProductFeedCardVH
    public final void T3() {
        super.T3();
        if (getLayoutPosition() != 0) goto L21;
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof MainProductCardDetailView) == true) goto L7;
        r0 = null;
    L7:
        MainProductCardDetailView r1 = (MainProductCardDetailView) r0;
        if (r1 == null) goto L22;
        BaseCardHeaderView r2 = r1.getCardHeaderView();
        if (r2 == null) goto L20;
        MainProductCardHeaderView r3 = (MainProductCardHeaderView) r2;
        int r4 = ld3.c.a;
        if (r3.A == 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L23;
        ECViewFlipper r6 = r3.x;
        if (r6 == null) goto L24;
        r6.startFlipping();
        return;
    L24:
        return;
    L23:
        return;
    L14:
        r5 = false;
        goto L15
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.feed.widget.MainProductCardHeaderView");
    L22:
        return;
    }

    public final void V3() {
        super/*com.bytedance.jedi.ext.adapter.JediViewHolder*/.V3();
        if (getLayoutPosition() != 0) goto L31;
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        View r2 = null;
        if ((r0 instanceof MainProductCardDetailView) == true) goto L7;
        r0 = null;
    L7:
        MainProductCardDetailView r1 = (MainProductCardDetailView) r0;
        if (r1 == null) goto L14;
        BaseCardHeaderView r3 = r1.getCardHeaderView();
        if (r3 == null) goto L13;
        ((MainProductCardHeaderView) r3).d();
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.feed.widget.MainProductCardHeaderView");
    L14:
        View r4 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r4 instanceof MainProductCardDetailView) == false) goto L18;
        r2 = r4;
    L18:
        MainProductCardDetailView r5 = (MainProductCardDetailView) r2;
        if (r5 == null) goto L32;
        BaseCardHeaderView r6 = r5.getCardHeaderView();
        if (r6 == null) goto L30;
        MainProductCardHeaderView r7 = (MainProductCardHeaderView) r6;
        int r8 = ECSdk.a;
        IEShoppingService r9 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r9 != null) goto L25;
        return;
    L25:
        if (r9.shouldShowSaasCouponUrge() != true) goto L34;
        j r10 = r7.z;
        if (r10 == null) goto L35;
        r10.b();
        return;
    L35:
        return;
    L34:
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.feed.widget.MainProductCardHeaderView");
    L32:
        return;
    }

    @Override // com.bytedance.android.shopping.feed.viewholder.a
    public final void O(float r4) {
        BaseCardDetailView r0 = this.r;
        BaseCardDetailView r2 = null;
        if ((r0 instanceof BaseCardDetailView) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L7;
        r0.setTransitionFactor(r4);
    L7:
        BaseCardDetailView r1 = this.r;
        if ((r1 instanceof MainProductCardDetailView) == false) goto L11;
        r2 = r1;
    L11:
        MainProductCardDetailView r3 = (MainProductCardDetailView) r2;
        if (r3 == null) goto L15;
        r3.setHeaderInfoViewAlpha(r4);
        return;
    }

    public final void a4(Object r18) {
        Intrinsics.checkNotNullParameter((ProductFeedAdapter.b) r18, "item");
        rd3.a r0 = this.m;
        if (r0 == null) goto L7;
        Promotion r1 = r0.f();
        if (r1 == null) goto L7;
        PromotionProductStruct r3 = r1.getPromotionInfo();
    L9:
        if (r3 == null) goto L11;
        r3.isOnlyHeadImg();
    L11:
        boolean r2 = this.q.E;
        if (r3 == null) goto L15;
        r3.isUseAnchorInfo();
    L15:
        if (r3 != null) goto L17;
    L65:
        View r7 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r7 instanceof BaseCardDetailView) == true) goto L68;
        r7 = null;
    L68:
        BaseCardDetailView r8 = (BaseCardDetailView) r7;
        if (r8 == null) goto L71;
        r8.b(this.o, this.m);
    L71:
        if (r3 == null) goto L87;
        if (r3.isUseAnchorInfo() != true) goto L87;
        rd3.a r9 = this.m;
        if (r9 == null) goto L87;
        ProductFeedViewModel r10 = r9.c;
        if (r10 == null) goto L87;
        AnchorV3Param r11 = r10.m907getAnchorV3Param();
        if (r11 == null) goto L87;
        i r12 = i.a;
        d r13 = r12.get(r11.getFullPageMonitorName());
        if (r13 == null) goto L83;
        r13.a("skeleton_render_end");
    L83:
        d r4 = r12.get(r11.getFullPageMonitorName());
        if (r4 == null) goto L87;
        r4.a("fcp_end");
    L87:
        if (this.q.E == false) goto L159;
        if (r3 == null) goto L92;
        if (r3.isUseAnchorInfo() == true) goto L159;
    L92:
        if (r3 != null) goto L94;
    L96:
        com.bytedance.android.shopping.monitor.d.f(this.q.C).i("is_preload", "0");
    L97:
        com.bytedance.android.shopping.monitor.d.f(this.q.C).h();
        String r5 = this.q.D;
        if (r5 == null) goto L105;
        i r14 = i.a;
        d r15 = r14.get(r5);
        if (r15 == null) goto L102;
        r15.a("render_end");
    L102:
        d r6 = r14.get(r5);
        if (r6 == null) goto L105;
        r6.report();
    L105:
        if (r3 != null) goto L107;
    L137:
        rd3.a r16 = this.m;
        if (r16 == null) goto L157;
        ProductFeedViewModel r17 = r16.c;
        if (r17 == null) goto L157;
        AnchorV3Param r19 = r17.m907getAnchorV3Param();
        if (r19 == null) goto L157;
        i r20 = i.a;
        d r21 = r20.get(r19.getFullPageMonitorName());
        if (r21 == null) goto L146;
        r21.a("first_card_update_render_end");
    L146:
        d r22 = r20.get(r19.getFullPageMonitorName());
        if (r22 == null) goto L150;
        r22.a("first_card_end");
    L150:
        if (this.q.F == true) goto L157;
        d r23 = r20.get(r19.getFullPageMonitorName());
        if (r23 == null) goto L154;
        r23.a("render_end");
    L154:
        d r24 = r20.get(r19.getFullPageMonitorName());
        if (r24 == null) goto L157;
        r24.report();
    L157:
        this.q.E = false;
        goto L159
    L107:
        if (r3.isPreload() == true) goto L137;
        if (com.bytedance.android.ec.core.anchorv3.c.a() == true) goto L137;
        if (com.bytedance.android.ec.core.anchorv3.c.g() == false) goto L137;
        int r25 = p.a;
        Object r26 = Boolean.TRUE;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L117
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L117
        Object r29 = jj4.a.a("ec_video_purchase_schema_prefetch_func", Boolean.class, r26, false);     // Catch: Throwable -> L117
        if (r29 != null) goto L124;
        Intrinsics.throwNpe();     // Catch: Throwable -> L117
    L124:
        if (((Boolean) r29).booleanValue() == false) goto L137;
        PromotionProductExtraStruct r30 = r3.getExtraInfo();
        if (r30 == null) goto L133;
        Map r31 = r30.getExtra();
        if (r31 == null) goto L133;
        String r32 = (String) r31.get("ultimate_buy_ab");
        if (r32 == null) goto L133;
        int r33 = k.r(r32, 0);
    L134:
        if (r33 <= 0) goto L137;
        PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("MainProductCardDetailVH")).execute(new c(r3));
    L133:
        r33 = 0;
    L117:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Object r35 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r35) == true) goto L122;
        r26 = r35;
    L122:
        r29 = r26;
        goto L124
    L94:
        if (r3.isPreload() != true) goto L96;
        com.bytedance.android.shopping.monitor.d.f(this.q.C).i("is_preload", "1");
    L159:
        if (this.t == true) goto L339;
        AnchorV3Param r36 = c4().m907getAnchorV3Param();
        if (r36 == null) goto L166;
        PromotionProductStruct r37 = r36.getCurrentPromotion();
        if (r37 == null) goto L166;
        if (r37.isOnlyHeadImg() != true) goto L166;
        return;
    L166:
        if (r3 != null) goto L168;
    L169:
        rd3.a r38 = this.m;
        if (r38 != null) goto L172;
    L174:
        Gson r39 = new Gson();
        AnchorV3Param r40 = c4().m907getAnchorV3Param();
        if (r40 == null) goto L177;
        String r41 = r40.getEntranceInfo();
    L178:
        JsonObject r42 = (JsonObject) GsonProtectorUtils.fromJson(r39, r41, JsonObject.class);
        if (r42 == null) goto L185;
        rd3.a r43 = this.m;
        if (r43 == null) goto L183;
        String r44 = String.valueOf(r43.f);
    L184:
        r42.addProperty("display_rank", r44);
        goto L185
    L183:
        r44 = null;
    L185:
        TrackerProvider.a r45 = TrackerProvider.Companion;
        Context r46 = this.r.getContext();
        if (r46 == null) goto L193;
        Activity r47 = d0.a.getActivity(r46);
        if ((r47 instanceof FragmentActivity) == true) goto L191;
        r47 = null;
    L191:
        FragmentActivity r48 = (FragmentActivity) r47;
        if (r48 == null) goto L193;
        Object r49 = ViewModelProviders.of(r48).get(TrackerProvider.class).getTracker();
        if ((r49 instanceof o1) == true) goto L197;
        r49 = null;
    L197:
        o1 r50 = (o1) r49;
    L198:
        String r51 = "";
        if (r50 == null) goto L204;
        if (r42 == null) goto L202;
        String r52 = r42.toString();
    L203:
        r50.c("entrance_info", r52, "");
        goto L204
    L202:
        r52 = null;
    L204:
        com.bytedance.android.btm.api.model.d r53 = new com.bytedance.android.btm.api.model.d();
        r53.a = "a1.b7365.c4701.d5727";
        r53.b = PageFinder.via(this.p);
        int r54 = o.a;
        BaseCardDetailView r55 = this.r;
        rd3.a r110 = this.m;
        Intrinsics.checkNotNullParameter(r55, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r53, "btmModel");
        if (f.b() == false) goto L221;
        String r56 = r53.a;
        if (r110 == null) goto L262;
        Promotion r57 = r110.f();
        if (r57 == null) goto L262;
        PromotionProductStruct r58 = r57.getPromotionInfo();
        if (r58 == null) goto L262;
        com.bytedance.android.shopping.feed.event.j r111 = new com.bytedance.android.shopping.feed.event.j(r55, r110);
        if (r56.length() != 0) goto L216;
        boolean r112 = true;
    L217:
        if (r112 == false) goto L219;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L219:
        com.bytedance.android.bst.api.d r113 = new com.bytedance.android.bst.api.d(r55);
        r113.a = r56;
        r113.b = "show_product";
        r113.c = r58;
        r113.d = "like_shopping";
        r113.e = -1;
        r113.f = r111;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.a(r113);
        goto L262
    L216:
        r112 = false;
    L262:
        FeedProductEventTracker r59 = FeedProductEventTracker.a;
        rd3.a r60 = this.m;
        Boolean r61 = Boolean.TRUE;
        Context r62 = ((RecyclerView.ViewHolder) this).itemView.getContext();
        r59.getClass();
        FeedProductEventTracker.O(r60, r61, r62);
        FeedProductEventTracker.J(this.m);
        if (r3 == null) goto L273;
        PromotionProductPrivilegesStruct r63 = r3.getPrivilegeInfo();
        if (r63 == null) goto L273;
        PromotionProductCouponsStruct r64 = r63.getCoupons();
        if (r64 == null) goto L273;
        BenefitComponent r65 = r64.getBenefitComponent();
        if (r65 == null) goto L273;
        Map r66 = r65.getData();
        if (r66 == null) goto L273;
        String r67 = (String) r66.get("detail");
    L274:
        if (r67 != null) goto L276;
    L279:
        boolean r68 = true;
    L280:
        if (r68 == true) goto L282;
        FeedProductEventTracker.M(this.m, this.r.getContext());
    L282:
        if (r3 == null) goto L289;
        PromotionProductAuthorEntriesStruct r69 = r3.getEntryInfo();
        if (r69 == null) goto L289;
        if (r69.getLeaderBoardEntry() == null) goto L289;
        FeedProductEventTracker.I(this.m, this.r.getContext());
    L289:
        rd3.a r70 = this.m;
        if (r70 == null) goto L310;
        ProductFeedViewModel r71 = r70.c;
        if (r71 == null) goto L310;
        InnerFlowPageStyleDTO r72 = r71.getInnerFlowPageStyle();
        if (r72 == null) goto L310;
        PageStyle r73 = r72.getPageStyle();
        if (r73 == null) goto L310;
        if (r73.getSearchPdtSwitch() != 1) goto L310;
        rd3.a r74 = this.m;
        if (r74 == null) goto L310;
        ProductFeedViewModel r75 = r74.c;
        if (r75 == null) goto L310;
        InnerFlowPageStyleDTO r76 = r75.getInnerFlowPageStyle();
        if (r76 == null) goto L310;
        PageStyle r77 = r76.getPageStyle();
        if (r77 == null) goto L310;
        if (r77.getSearchPdtStyle() != 1) goto L310;
        FeedProductEventTracker.A(this.r.getContext(), "show_inflow_similar_tab", false, "product_info");
    L310:
        rd3.a r78 = this.m;
        if (r78 == null) goto L319;
        ProductFeedViewModel r79 = r78.c;
        if (r79 == null) goto L319;
        AnchorV3Param r80 = r79.m907getAnchorV3Param();
        if (r80 == null) goto L319;
        AnchorV3PromotionRequestParam r81 = r80.getRequestParam();
        if (r81 == null) goto L319;
        JSONObject r82 = r81.getAggParams();
    L320:
        if (r82 != null) goto L333;
        rd3.a r84 = this.m;
        if (r84 == null) goto L324;
        InnerFlowAdRawData r85 = r84.a;
    L325:
        if (r85 == null) goto L333;
        int r86 = com.bytedance.android.shopping.feed.utils.k.a;
        if (r84 == null) goto L329;
        InnerFlowAdRawData r87 = r84.a;
    L330:
        if (r87 == null) goto L333;
        new com.bytedance.android.shopping.feed.event.d(r87).post(null, null);
        goto L333
    L329:
        r87 = null;
        goto L330
    L324:
        r85 = null;
    L333:
        if (f53.a.b(r3) == false) goto L335;
        Context r88 = this.r.getContext();
        rd3.a r89 = this.m;
        int r90 = vd3.a.a;
        FeedProductEventTracker.F(r88, r89, vd3.a.b(this.p, "a1.b7365.c4701.d5727"));
    L335:
        this.t = true;
        return;
    L319:
        r82 = null;
        goto L320
    L276:
        if (StringsKt.isBlank(r67) == true) goto L279;
        r68 = false;
    L273:
        r67 = null;
        goto L274
    L221:
        if (com.bytedance.android.bst.api.f.e().isBstBindEnable("video_product_list") == false) goto L261;
        String r91 = r53.a;
        if (r110 == null) goto L262;
        Promotion r92 = r110.f();
        if (r92 == null) goto L262;
        PromotionProductStruct r94 = r92.getPromotionInfo();
        if (r94 == null) goto L262;
        ProductFeedViewModel r114 = r110.c;
        if (r114 == null) goto L236;
        AnchorV3Param r115 = r114.m907getAnchorV3Param();
        if (r115 == null) goto L236;
        if (r115.isLuban() != true) goto L236;
        int r116 = 1;
    L237:
        PromotionProductBaseStruct r117 = r94.getBaseInfo();
        if (r117 == null) goto L243;
        String r118 = r117.getProductId();
        if (r118 == null) goto L243;
        r51 = r118;
    L243:
        ShoppingModel r119 = new ShoppingModel(r51, r116, "video", 1);
        HashMap r95 = r119.getExtraInfo();
        FeedProductEventTracker.a.getClass();
        r95.putAll(FeedProductEventTracker.e(r94, r110, null, false, null).getParams());
        ArrayList r96 = new ArrayList();
        LinkedHashMap r120 = new LinkedHashMap();
        ArrayList r121 = new ArrayList();
        int r122 = sc.a.a;
        r96.add("click");
        if (com.bytedance.android.bst.api.f.e().isOriginReportEnable("video_product_list") == true) goto L246;
        BtmItemBuilder r123 = new BtmItemBuilder(null, Boolean.FALSE, 1, null).withView(r55);
    L247:
        r121.add(new com.bytedance.android.shopping.feed.event.i());
        if (r55 == null) goto L258;
        if (r91 == null) goto L258;
        if (r91 != null) goto L253;
        Intrinsics.throwNpe();
    L253:
        com.bytedance.android.bst.api.b r124 = new com.bytedance.android.bst.api.b(r55, r91);
        r124.a = r119;
        r124.b = r94;
        r124.c.addAll(r121);
        r124.d.putAll(r120);
        ((ArrayList) r124.e).addAll(r96);
        if (r123 == null) goto L259;
        if (r91 != null) goto L257;
        Intrinsics.throwNpe();
    L257:
        r123.copy(r91);
    L259:
        if (r124 == null) goto L262;
        com.bytedance.android.bst.api.f.b(r124);
    L258:
        r124 = null;
        goto L259
    L246:
        r123 = null;
    L236:
        r116 = 0;
        goto L237
    L261:
        FeedProductEventTracker.D(FeedProductEventTracker.a, r55.getContext(), r110, BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r53.a, Boolean.FALSE).withPageFinder(r53.b).build()), true, null, 16);
    L193:
        r50 = null;
        goto L198
    L177:
        r41 = null;
        goto L178
    L172:
        if (r38.b() != true) goto L174;
        FeedProductEventTracker r97 = FeedProductEventTracker.a;
        rd3.a r98 = this.m;
        r97.getClass();
        FeedProductEventTracker.p(r98);
        goto L174
    L168:
        if (r3.isUseAnchorInfo() != true) goto L169;
        return;
    L339:
        return;
    L17:
        if (r3.isOnlyHeadImg() != true) goto L65;
        View r99 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r99 instanceof MainProductCardDetailView) == true) goto L21;
        r99 = null;
    L21:
        MainProductCardDetailView r100 = (MainProductCardDetailView) r99;
        if (r100 == null) goto L56;
        Function3<View, String, String, Unit> r101 = this.o;
        rd3.a r102 = this.m;
        Intrinsics.checkNotNullParameter(r101, "detailOnClickListener");
        LinearLayout r125 = new LinearLayout(r100.getContext());
        ShoppingAsyncInflater.a r126 = ShoppingAsyncInflater.e;
        Context r127 = r125.getContext();
        r126.getClass();
        ShoppingAsyncInflater.a.a(r127).aU(2131560701, r125, true);
        Unit r128 = Unit.INSTANCE;
        r100.Q = r125;
        if (ld3.d.e(ld3.d.b()) == false) goto L31;
        LinearLayout.LayoutParams r129 = new LinearLayout.LayoutParams(-1, -2);
        r129.setMargins(0, com.bytedance.android.shopping.extensions.b.a(-16), 0, 0);
        ViewGroup r130 = r100.Q;
        if (r130 == null) goto L28;
        r130.setLayoutParams(r129);
    L28:
        ViewGroup r131 = r100.Q;
        if (r131 == null) goto L31;
        r131.setBackgroundColor(-1);
    L31:
        View r132 = r100.getDetailRootView();
        if ((r132 instanceof LinearLayout) == true) goto L34;
        r132 = null;
    L34:
        LinearLayout r133 = (LinearLayout) r132;
        if (r133 == null) goto L37;
        r133.addView(r100.Q, 1);
    L37:
        InflowSkuWidget r134 = r100.getSkuWidget();
        if (r134 == null) goto L40;
        r134.setVisibility(8);
    L40:
        r100.getPriceAndSalesView().setVisibility(8);
        r100.getPriceContainer().setVisibility(8);
        r100.getBarContainer().setVisibility(8);
        r100.getExtraInfoContainer().setVisibility(8);
        r100.getDiscountInfoContainer().setVisibility(8);
        r100.getProductTitleView().setVisibility(8);
        r100.getBottomBarView().setVisibility(8);
        ViewGroup r135 = r100.Q;
        if (r135 == null) goto L43;
        r135.setVisibility(0);
    L43:
        if (r102 == null) goto L51;
        Promotion r136 = r102.f();
        if (r136 == null) goto L51;
        PromotionProductStruct r137 = r136.getPromotionInfo();
        if (r137 == null) goto L51;
        BaseCardHeaderView r138 = r100.getCardHeaderView();
        if (r138 == null) goto L51;
        r138.a(new v(m.b(r137), r102), r101);
    L51:
        int r103 = ld3.c.a;
        com.bytedance.android.shopping.feed.widget.p r104 = new com.bytedance.android.shopping.feed.widget.p(r100);
        if (ld3.d.e(ld3.d.b()) == false) goto L56;
        ViewTreeObserver r105 = r100.getViewTreeObserver();
        if (r105 == null) goto L56;
        r105.addOnGlobalLayoutListener(r104);
    L56:
        rd3.a r106 = this.m;
        if (r106 == null) goto L159;
        ProductFeedViewModel r107 = r106.c;
        if (r107 == null) goto L159;
        AnchorV3Param r108 = r107.m907getAnchorV3Param();
        if (r108 == null) goto L159;
        d r109 = i.a.get(r108.getFullPageMonitorName());
        if (r109 == null) goto L159;
        r109.a("skeleton_render_end");
    L7:
        r3 = null;
        goto L9
    }

    public MainProductCardDetailVH(ViewGroup r5, JediBaseFragment r6, ProductFeedAdapter r7) {
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter(r7, "adapter");
        int r0 = MainProductCardDetailView.R;
        Context r8 = r5.getContext();
        Intrinsics.checkNotNullParameter(r8, "context");
        if (ld3.b.a() == false) goto L5;
        Map r1 = ShoppingAsyncCacheInflater.d;
        MainProductCardDetailView r9 = (MainProductCardDetailView) ShoppingAsyncCacheInflater.a.a(r8).b("ec_commerce_main_feed_product_detail_card_view", new com.bytedance.android.shopping.feed.widget.o());
    L6:
        super(r6, r7, r9);
        return;
    L5:
        r9 = new MainProductCardDetailView(r8, null, 6, 0);
        goto L6
    }

    @Override // com.bytedance.android.shopping.feed.viewholder.BaseProductFeedCardVH
    public final void b4(ProductFeedAdapter.b<PromotionProductStruct> r5, int r6, List r7) {
        ProductFeedAdapter.b<PromotionProductStruct> r8 = r5;
        Intrinsics.checkNotNullParameter(r8, "item");
        PromotionProductStruct r0 = r8.b;
        if (r0 == null) goto L9;
        PromotionProductBaseStruct r1 = r0.getBaseInfo();
        if (r1 == null) goto L9;
        if (r1.isSoldOut() != true) goto L9;
        return;
    L9:
        rd3.a.C0231a r2 = rd3.a.r;
        ProductFeedViewModel r3 = c4();
        PromotionProductStruct r4 = r8.b;
        if (r4 == null) goto L15;
        PromotionProductBaseStruct r9 = r4.getBaseInfo();
        if (r9 == null) goto L15;
        String r10 = r9.getPromotionId();
        if (r10 == null) goto L15;
    L16:
        r2.getClass();
        rd3.a r11 = rd3.a.C0231a.b(r3, r10, r8);
        this.m = r11;
        String r12 = this.q.B2();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.m = r12;
        rd3.a r13 = this.m;
        if (r13 == null) goto L19;
        r13.f = r6;
    L19:
        View r14 = null;
        if (r6 <= 0) goto L28;
        View r15 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r15 instanceof MainProductCardDetailView) == false) goto L25;
        r14 = r15;
    L25:
        MainProductCardDetailView r16 = (MainProductCardDetailView) r14;
        if (r16 == null) goto L35;
        r16.setProductAttentionVisible(true);
    L35:
        c4().setHeadAnchorInflowFeedItem(this.m);
        super.b4(r8, r6, r7);
        return;
    L28:
        View r17 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r17 instanceof MainProductCardDetailView) == false) goto L32;
        r14 = r17;
    L32:
        MainProductCardDetailView r18 = (MainProductCardDetailView) r14;
        if (r18 == null) goto L35;
        r18.setProductAttentionVisible(false);
    L15:
        r10 = "-1";
        goto L16
    }

    @Override // com.bytedance.android.shopping.feed.viewholder.BaseProductFeedCardVH
    public final void d4(View r23, String r24, String r25, String r26) {
        Intrinsics.checkNotNullParameter(r23, FreqActions.ACTION_VIEW);
        rd3.a r2 = this.m;
        if (r2 == null) goto L13;
        ProductFeedViewModel r3 = r2.c;
        if (r3 == null) goto L13;
        PromotionProductStruct r4 = (PromotionProductStruct) ((ProductFeedAdapter.b) getItem()).b;
        if (r4 == null) goto L11;
        PromotionProductBaseStruct r5 = r4.getBaseInfo();
        if (r5 == null) goto L11;
        String r6 = r5.getProductId();
    L12:
        r3.setCurrentProductId(r6);
    L11:
        r6 = null;
    L13:
        FeedProductEventTracker.m(FeedProductEventTracker.a, this.m, r25, null, null, Boolean.TRUE, ((RecyclerView.ViewHolder) this).itemView.getContext(), null, 76);
        BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7365.c4701.d5727", Boolean.FALSE).withView(r23).build());
        if (r25 != null) goto L16;
        ProductFeedActionHelper.h(r23, this.m, r24, r25, null, null, 112);
        return;
    L16:
        int r0 = r25.hashCode();
        if (r0 == 110986) goto L25;
        if (r0 == 93819220) goto L22;
        return;
    L22:
        if (r25.equals("blank") == false) goto L140;
    L26:
        int r1 = q.a;
        rd3.a r14 = this.m;
        String r12 = InflowMainCardLocationType.HALF.getType();
        BaseCardDetailView r10 = this.r;
        Intrinsics.checkNotNullParameter("a1.b7365.c4701.d5727", "btm");
        Intrinsics.checkNotNullParameter(r12, "inflowMainCardLocation");
        if (r14 == null) goto L142;
        ProductFeedViewModel r7 = r14.c;
        if (r7 == null) goto L143;
        Fragment r8 = r7.getFlowFragment();
        if (r8 == null) goto L144;
        Context r9 = r8.getContext();
        if (r9 == null) goto L146;
        ProductFeedViewModel r11 = r14.c;
        if (r11 == null) goto L38;
        Fragment r13 = r11.getFlowFragment();
    L40:
        if ((r13 instanceof ProductFeedContentFragment) == true) goto L42;
        r13 = null;
    L42:
        ProductFeedContentFragment r15 = (ProductFeedContentFragment) r13;
        if (r15 == null) goto L147;
        if (r10 == null) goto L148;
        ProductFeedAdapter r16 = r15.o;
        if (r16 == null) goto L149;
        ProductFeedViewModel r17 = r14.c;
        if (r17 == null) goto L150;
        Promotion r18 = r14.f();
        if (r18 == null) goto L60;
        PromotionProductStruct r19 = r18.getPromotionInfo();
        if (r19 == null) goto L60;
        PromotionProductBaseStruct r20 = r19.getBaseInfo();
        if (r20 == null) goto L60;
        String r21 = r20.getProductId();
    L61:
        r17.setCurrentProductId(r21);
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L68
        Gson r27 = new Gson();     // Catch: Throwable -> L68
        AnchorV3Param r28 = r17.m907getAnchorV3Param();     // Catch: Throwable -> L68
        if (r28 == null) goto L65;
        String r29 = r28.getEntranceInfo();     // Catch: Throwable -> L68
    L66:
        Object r30 = Result.constructor-impl((JsonObject) r27.fromJson(r29, JsonObject.class));     // Catch: Throwable -> L68
    L71:
        if (Result.isFailure-impl(r30) == false) goto L73;
        r30 = null;
    L73:
        JsonObject r31 = (JsonObject) r30;
        if (r31 == null) goto L76;
        r31.addProperty("display_rank", String.valueOf(r14.f));
    L76:
        if (r31 == null) goto L78;
        r31.addProperty("inflow_main_card_location", r12);
    L78:
        if (r31 == null) goto L80;
        r31.addProperty("search_id", null);
    L80:
        Iterator r32 = ((LinkedHashMap) r14.k).entrySet().iterator();
    L82:
        if (r32.hasNext() == false) goto L86;
        Map.Entry r33 = (Map.Entry) r32.next();
        if (r31 == null) goto L82;
        r31.addProperty((String) r33.getKey(), (String) r33.getValue());
        goto L82
    L86:
        TrackerProvider.a r34 = TrackerProvider.Companion;
        Activity r35 = d0.a.getActivity(r9);
        if ((r35 instanceof FragmentActivity) == true) goto L89;
        r35 = null;
    L89:
        FragmentActivity r36 = (FragmentActivity) r35;
        if (r36 != null) goto L92;
        o1 r37 = null;
    L96:
        if (r37 == null) goto L101;
        if (r31 == null) goto L99;
        String r38 = r31.toString();
    L100:
        r37.c("entrance_info", r38, "");
        goto L101
    L99:
        r38 = null;
    L101:
        com.bytedance.android.btm.api.model.d r39 = new com.bytedance.android.btm.api.model.d();
        r39.a = "a1.b7365.c4701.d5727";
        r39.b = PageFinder.via(r15);
        int r40 = o.a;
        Promotion r41 = r14.f();
        if (r41 == null) goto L104;
        PromotionProductStruct r42 = r41.getPromotionInfo();
    L105:
        String r43 = r16.B2();
        String r110 = String.valueOf(r14.f);
        Map<String, String> r44 = r14.k;
        Intrinsics.checkNotNullParameter(r17, "vm");
        Intrinsics.checkNotNullParameter(r10, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r43, "inflowProductCardMode");
        Intrinsics.checkNotNullParameter(r39, "btmModel");
        boolean r111 = true;
        if (f.b() == true) goto L123;
        if (r12 != null) goto L109;
    L112:
        boolean r45 = true;
    L113:
        if (r45 == false) goto L123;
        if (com.bytedance.android.bst.api.f.e().isBstBindEnable("video_product_list") == false) goto L121;
        FeedProductEventTracker.a.getClass();
        BaseCardDetailView r210 = r10;
        String r211 = r12;
        u0 r46 = FeedProductEventTracker.b(r17, r42, null, r25, true, r43, null, r110, false, r44, null);
        if (r46 == null) goto L122;
        g.a(r46, r210.getContext(), null);
        int r47 = sc.a.a;
        r46.getParams();
        com.bytedance.android.bst.api.f.g().b();
        BaseCardDetailView r48 = r210;
        r14 = r14;
    L130:
        ProductFeedActionHelper.h(r48, r14, "click", r25, r211, null, 16);
        return;
    L122:
        r48 = r210;
        goto L130
    L121:
        r210 = r10;
        r211 = r12;
        FeedProductEventTracker.o(FeedProductEventTracker.a, r17, r210.getContext(), r42, null, r25, true, r43, BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r39.a, Boolean.FALSE).withPageFinder(r39.b).build()), r110, true, r44, null, 2048);
        goto L122
    L109:
        if (r12.length() == 0) goto L112;
        r45 = false;
    L123:
        r211 = r12;
        r14 = r14;
        String r49 = r39.a;
        PromotionProductStruct r112 = r42;
        com.bytedance.android.shopping.feed.event.m r113 = new com.bytedance.android.shopping.feed.event.m(r42, r17, r10, r25, r43, r110, r44);
        if (r49.length() == 0) goto L127;
        r111 = false;
    L127:
        if (r111 == false) goto L129;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L129:
        r48 = r10;
        com.bytedance.android.bst.api.d r50 = new com.bytedance.android.bst.api.d(r48);
        r50.a = r49;
        r50.b = "click_product";
        r50.c = r112;
        r50.d = "like_shopping";
        r50.e = -1;
        r50.f = r113;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.c(r50);
        goto L130
    L104:
        r42 = null;
        goto L105
    L92:
        Object r51 = ViewModelProviders.of(r36).get(TrackerProvider.class).getTracker();
        if ((r51 instanceof o1) == true) goto L95;
        r51 = null;
    L95:
        r37 = (o1) r51;
        goto L96
    L65:
        r29 = null;
    L68:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
    L60:
        r21 = null;
        goto L61
    L150:
        return;
    L149:
        return;
    L148:
        return;
    L147:
        return;
    L38:
        r13 = null;
        goto L40
    L146:
        return;
    L144:
        return;
    L143:
        return;
    L142:
        return;
    L140:
        return;
    L25:
        if (r25.equals("pic") == true) goto L26;
    }
}
