package com.bytedance.android.shopping.sameproduct.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.api.anchorv3.ECAwemeItemInfo;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.anchorv3.ECProductDetailPageShowStyle;
import com.bytedance.android.shopping.api.anchorv3.ECProductInfo;
import com.bytedance.android.shopping.api.anchorv3.ECUIParam;
import com.bytedance.android.shopping.feed.event.u0;
import com.bytedance.android.shopping.feed.widget.FlowTinyProductView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.sameproduct.model.SameProductPageParams;
import com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import io.reactivex.disposables.Disposable;
import java.util.List;
import jd3.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/viewholder/MainProductCardVH;", "Lcom/bytedance/android/shopping/sameproduct/viewholder/BaseSimilarProductCardVH;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "Lcom/bytedance/android/shopping/sameproduct/viewholder/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainProductCardVH extends BaseSimilarProductCardVH<PromotionProductStruct> implements a {
    public rd3.a r;

    public final void onDestroy() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof FlowTinyProductView) == true) goto L5;
        r0 = null;
    L5:
        FlowTinyProductView r1 = (FlowTinyProductView) r0;
        if (r1 == null) goto L11;
        Disposable r2 = r1.c.c;
        if (r2 == null) goto L12;
        r2.dispose();
        return;
    L12:
        return;
    }

    public final void T3() {
        super/*com.bytedance.jedi.ext.adapter.JediViewHolder*/.T3();
        int r0 = dh3.d.a;
        Context r1 = ((RecyclerView.ViewHolder) this).itemView.getContext();
        SameProductViewModel r2 = d4();
        rd3.a.C0231a r3 = rd3.a.r;
        PromotionProductStruct r4 = (PromotionProductStruct) getItem();
        r3.getClass();
        rd3.a r5 = rd3.a.C0231a.c(r4);
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Promotion r6 = r5.f();
        if (r6 == null) goto L10;
        PromotionProductStruct r7 = r6.getPromotionInfo();
        if (r7 == null) goto L10;
        PromotionProductBaseStruct r8 = r7.getBaseInfo();
        if (r8 == null) goto L10;
        String r9 = r8.getProductId();
        if (r9 == null) goto L10;
    L12:
        if (r2.getShowedProductIds().contains(r9) == true) goto L39;
        r2.getShowedProductIds().add(r9);
        u r10 = new u();
        SameProductPageParams r11 = r2.getPageParams();
        Integer r12 = null;
        if (r11 == null) goto L17;
        String r13 = r11.getMainProductRecommendInfo();
    L18:
        r10.t = r13;
        SameProductPageParams r14 = r2.getPageParams();
        if (r14 == null) goto L21;
        String r15 = r14.getMainProductRequestId();
    L22:
        r10.u = r15;
        r10.p = String.valueOf(r5.f);
        r10.l = r9;
        Promotion r16 = r5.f();
        if (r16 == null) goto L29;
        PromotionProductStruct r17 = r16.getPromotionInfo();
        if (r17 == null) goto L29;
        PromotionProductBaseStruct r18 = r17.getBaseInfo();
        if (r18 == null) goto L29;
        String r19 = r18.getPromotionId();
    L30:
        r10.c = r19;
        Promotion r20 = r5.f();
        if (r20 == null) goto L37;
        PromotionProductStruct r21 = r20.getPromotionInfo();
        if (r21 == null) goto L37;
        PromotionProductBaseStruct r22 = r21.getBaseInfo();
        if (r22 == null) goto L37;
        r12 = r22.getPromotionSource();
    L37:
        r10.d = String.valueOf(r12);
        Unit r23 = Unit.INSTANCE;
        dh3.d.d(r10, r1);
        return;
    L29:
        r19 = null;
        goto L30
    L21:
        r15 = null;
        goto L22
    L17:
        r13 = null;
        goto L18
    L39:
        return;
    L10:
        r9 = "";
        goto L12
    }

    public final void a4(Object r4) {
        PromotionProductStruct r5 = (PromotionProductStruct) r4;
        Intrinsics.checkNotNullParameter(r5, "item");
        rd3.a.r.getClass();
        rd3.a r6 = rd3.a.C0231a.c(r5);
        this.r = r6;
        this.l = r6;
        r6.f = getAdapterPosition();
        rd3.a r7 = this.r;
        if (r7 == null) goto L26;
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        View r2 = null;
        if ((r0 instanceof FlowTinyProductView) == true) goto L7;
        r0 = null;
    L7:
        FlowTinyProductView r1 = (FlowTinyProductView) r0;
        if (r1 == null) goto L10;
        r1.b(r7);
    L10:
        View r8 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r8 instanceof FlowTinyProductView) == true) goto L13;
        r8 = null;
    L13:
        FlowTinyProductView r9 = (FlowTinyProductView) r8;
        if (r9 == null) goto L18;
        AppCompatButton r10 = r9.getBuyButton();
        if (r10 == null) goto L18;
        r10.setOnClickListener(new b(this));
    L18:
        View r11 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r11 instanceof FlowTinyProductView) == false) goto L22;
        r2 = r11;
    L22:
        FlowTinyProductView r3 = (FlowTinyProductView) r2;
        if (r3 == null) goto L27;
        r3.setOnClickListener(new c(this));
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.shopping.sameproduct.viewholder.BaseSimilarProductCardVH
    public final void c4(View r88) {
        Intrinsics.checkNotNullParameter(r88, FreqActions.ACTION_VIEW);
        int r2 = com.bytedance.android.shopping.sameproduct.helper.a.a;
        SameProductViewModel r3 = d4();
        rd3.a r4 = this.r;
        Intrinsics.checkNotNullParameter(r88, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Integer r1 = null;
        if (r4 == null) goto L7;
        Promotion r5 = r4.f();
        if (r5 == null) goto L7;
        PromotionProductStruct r6 = r5.getPromotionInfo();
    L9:
        if (z53.b.a(r88.getId(), 800) == true) goto L83;
        SameProductPageParams r7 = r3.getPageParams();
        if (r7 == null) goto L84;
        String r8 = r7.getEntranceInfo();
        if (r8 == null) goto L15;
        JSONObject r9 = z1.f(r8);
    L16:
        r9.put("group_id", r7.getVideoId());
        if (r6 == null) goto L21;
        PromotionProductBaseStruct r10 = r6.getBaseInfo();
        if (r10 == null) goto L21;
        String r11 = r10.getPromotionId();
    L22:
        r9.put(PdpOpenThirdParam.KEY_PROMOTION_ID, r11);
        r9.put("recommend_info", r7.getMainProductRecommendInfo());
        r9.put("request_id", r7.getMainProductRequestId());
        String r17 = r9.toString();
        JSONObject r12 = z1.g(r7.getRequestAdditions());
        if (r12 != null) goto L25;
        r12 = new JSONObject();
    L25:
        r12.put(SimilarProductParam.ENTER_FROM, "same_product_flow_page");
        if (r7.isFromFlowGuessULike() == false) goto L28;
        r12.put("same_product_scene", 2);
    L29:
        int r13 = ECSdk.a;
        IEShoppingService r14 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r14 == null) goto L85;
        p83.d r15 = r14.getAnchorV3Service();
        if (r15 == null) goto L86;
        Context r16 = r88.getContext();
        if (r6 == null) goto L38;
        PromotionProductBaseStruct r0 = r6.getBaseInfo();
        if (r0 == null) goto L38;
        String r18 = r0.getPromotionId();
    L40:
        if (r18 != null) goto L42;
        String r19 = "";
    L43:
        if (r6 == null) goto L47;
        PromotionProductBaseStruct r20 = r6.getBaseInfo();
        if (r20 == null) goto L47;
        String r21 = r20.getProductId();
    L49:
        if (r6 == null) goto L59;
        PromotionProductBaseStruct r22 = r6.getBaseInfo();
        if (r22 == null) goto L59;
        List r23 = r22.getImages();
        if (r23 == null) goto L59;
        ECUrlModel r24 = (ECUrlModel) CollectionsKt.getOrNull(r23, 0);
        if (r24 == null) goto L59;
        List r25 = r24.getUrlList();
        if (r25 == null) goto L59;
        String r26 = (String) CollectionsKt.getOrNull(r25, 0);
    L61:
        if (r6 == null) goto L65;
        PromotionProductBaseStruct r27 = r6.getBaseInfo();
        if (r27 == null) goto L65;
        r1 = r27.getPromotionSource();
    L65:
        ECProductInfo r110 = new ECProductInfo(r19, r21, null, null, 0, null, r26, null, com.bytedance.android.shopping.extensions.c.a(r1, SourceType.UNKNOWN.getType()), 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388284, null);
        String r47 = r7.getVideoId();
        String r28 = r7.getAuthorId();
        if (r28 != null) goto L68;
        String r48 = "";
    L69:
        String r29 = r7.getSecAuthorId();
        if (r29 != null) goto L72;
        String r49 = "";
    L73:
        ECAwemeItemInfo r111 = new ECAwemeItemInfo(r47, r48, r49, r7.getFollowStatus(), false, null, false, 0, null, null, null, null, false, false, null, null, null, null, null, false, 1048560, null);
        String r30 = r7.getMetaParams();
        if (r30 == null) goto L76;
        JSONObject r31 = z1.f(r30);
    L77:
        JSONObject r112 = r31;
        String r113 = r7.isReceptor();
        ECProductDetailPageShowStyle r210 = new ECProductDetailPageShowStyle(true, false, 0, true, 6, null);
        String r32 = r7.getEnterFrom();
        if (r32 != null) goto L80;
        String r33 = "";
    L81:
        String r34 = r7.getEcomEntranceForm();
        String r35 = r7.getV3EventsAdditions();
        int r36 = com.bytedance.android.shopping.sameproduct.helper.b.a;
        p83.d.a.b(r15, r16, r110, r111, r112, null, null, r17, null, r113, r210, null, new ECLogExtraData(r33, null, r34, r35, null, null, null, "product_flow_page", null, null, null, null, com.bytedance.android.shopping.sameproduct.helper.b.a(r7, r4, r3.getEcomSceneId()), null, null, null, null, null, 257906, null), r12, new ECUIParam(null, false, false, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, 0.0f, 0, null, -5, 1, null), Boolean.TRUE);
        return;
    L80:
        r33 = r32;
        goto L81
    L76:
        r31 = new JSONObject();
        goto L77
    L72:
        r49 = r29;
        goto L73
    L68:
        r48 = r28;
    L59:
        r26 = null;
    L47:
        r21 = null;
        goto L49
    L42:
        r19 = r18;
    L38:
        r18 = null;
        goto L40
    L86:
        return;
    L85:
        return;
    L28:
        r12.put("same_product_scene", 1);
    L21:
        r11 = null;
        goto L22
    L15:
        r9 = new JSONObject();
        goto L16
    L84:
        return;
    L83:
        return;
    L7:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.android.shopping.sameproduct.viewholder.BaseSimilarProductCardVH
    public final void f4(View r6) {
        Intrinsics.checkNotNullParameter(r6, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r6, FreqActions.ACTION_VIEW);
        int r7 = dh3.d.a;
        Context r8 = ((RecyclerView.ViewHolder) this).itemView.getContext();
        SameProductViewModel r0 = d4();
        rd3.a r1 = this.l;
        Intrinsics.checkNotNullParameter(r0, "viewModel");
        Integer r3 = null;
        u0 r2 = new u0(null);
        SameProductPageParams r4 = r0.getPageParams();
        if (r4 == null) goto L5;
        String r5 = r4.getMainProductRecommendInfo();
    L6:
        r2.F = r5;
        SameProductPageParams r9 = r0.getPageParams();
        if (r9 == null) goto L9;
        String r10 = r9.getMainProductRequestId();
    L10:
        r2.S = r10;
        if (r1 == null) goto L13;
        Integer r11 = Integer.valueOf(r1.f);
    L14:
        r2.w = String.valueOf(r11);
        if (r1 == null) goto L23;
        Promotion r12 = r1.f();
        if (r12 == null) goto L23;
        PromotionProductStruct r13 = r12.getPromotionInfo();
        if (r13 == null) goto L23;
        PromotionProductBaseStruct r14 = r13.getBaseInfo();
        if (r14 == null) goto L23;
        String r15 = r14.getProductId();
    L24:
        r2.t = r15;
        if (r1 == null) goto L33;
        Promotion r16 = r1.f();
        if (r16 == null) goto L33;
        PromotionProductStruct r17 = r16.getPromotionInfo();
        if (r17 == null) goto L33;
        PromotionProductBaseStruct r18 = r17.getBaseInfo();
        if (r18 == null) goto L33;
        String r19 = r18.getPromotionId();
    L34:
        r2.c = r19;
        if (r1 == null) goto L43;
        Promotion r20 = r1.f();
        if (r20 == null) goto L43;
        PromotionProductStruct r21 = r20.getPromotionInfo();
        if (r21 == null) goto L43;
        PromotionProductBaseStruct r22 = r21.getBaseInfo();
        if (r22 == null) goto L43;
        r3 = r22.getPromotionSource();
    L43:
        r2.d = String.valueOf(r3);
        Unit r23 = Unit.INSTANCE;
        dh3.d.d(r2, r8);
        return;
    L33:
        r19 = null;
    L23:
        r15 = null;
        goto L24
    L13:
        r11 = null;
        goto L14
    L9:
        r10 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public MainProductCardVH(Fragment r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        View r3 = null;
        super(r5, new FlowTinyProductView(r6.getContext(), null, 6, 0));
        View r7 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r7 instanceof FlowTinyProductView) == false) goto L6;
        r3 = r7;
    L6:
        FlowTinyProductView r4 = (FlowTinyProductView) r3;
        if (r4 == null) goto L9;
        r4.setStyle(2);
    L9:
        StaggeredGridDoubleColumnDecoration.a r8 = StaggeredGridDoubleColumnDecoration.g;
        View r9 = ((RecyclerView.ViewHolder) this).itemView;
        r8.getClass();
        StaggeredGridDoubleColumnDecoration.a.b(r9, true);
        this.q.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }
}
