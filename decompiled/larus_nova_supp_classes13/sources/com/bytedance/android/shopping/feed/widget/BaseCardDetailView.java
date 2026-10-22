package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ActivityCountDownTimer;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.core.widget.RoundedLinearLayout;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.BenefitComponent;
import com.bytedance.android.ec.model.response.anchorv3.CommonGirdleStructV2;
import com.bytedance.android.ec.model.response.anchorv3.CountDown;
import com.bytedance.android.ec.model.response.anchorv3.ExchangeCoupons;
import com.bytedance.android.ec.model.response.anchorv3.MarketingBanner;
import com.bytedance.android.ec.model.response.anchorv3.MarketingTip;
import com.bytedance.android.ec.model.response.anchorv3.MarketingTipComponent;
import com.bytedance.android.ec.model.response.anchorv3.PriceDescription;
import com.bytedance.android.ec.model.response.anchorv3.PriceV2;
import com.bytedance.android.ec.model.response.anchorv3.ProductSpecInfoStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionAppointment;
import com.bytedance.android.ec.model.response.anchorv3.PromotionMarketFloor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBannerStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductLogisticsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStructV2;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductServiceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.ec.model.response.anchorv3.SpecDetail;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.activities.view.AbsActivitiesBarView;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.info.CouponGroupLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.AnchorV3LogisticsLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.AnchorV3PreSecKillLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.AnchorV3PresaleDepositLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.AnchorV3RankInfoLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.InflowFeedServiceView;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.anchorv3.utils.y;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.feed.adapter.InflowSkuAdapter;
import com.bytedance.android.shopping.feed.banner.VideoProductFeedBanner;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.f1;
import com.bytedance.android.shopping.feed.event.k0;
import com.bytedance.android.shopping.feed.event.q0;
import com.bytedance.android.shopping.feed.event.r0;
import com.bytedance.android.shopping.feed.event.t0;
import com.bytedance.android.shopping.feed.view.InflowFeedCommentView;
import com.bytedance.android.shopping.feed.view.InflowSkuThumbnail;
import com.bytedance.android.shopping.feed.view.bottombar.InflowFeedBottomBarView;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.inflowcardtitle.InFlowCardTitleView;
import com.bytedance.android.shopping.feed.widget.inflowsellingpoint.InFlowSellingPointAreaView;
import com.bytedance.android.shopping.inflow.detail.viewholder.info.BenefitGroupLayout;
import com.bytedance.android.shopping.inflow.detail.viewholder.info.MarketingBannerLayout;
import com.bytedance.android.shopping.inflow.view.ActivityBarShopLayout;
import com.bytedance.android.shopping.inflow.view.InFlowActivityLayout;
import com.bytedance.android.shopping.inflow.view.InFlowNumberBannerIndicatorView;
import com.bytedance.android.shopping.inflow.view.InFlowRankLayout;
import com.bytedance.android.shopping.inflow.view.MainCardImageBannerAdapter;
import com.bytedance.android.shopping.inflow.view.PresaleActivityBarLayout;
import com.bytedance.android.shopping.inflow.view.TopRoundRelativeLayout;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.product.flow.banner.BannerHolder;
import com.bytedance.android.shopping.product.flow.view.info.ProductFlowCardPriceAndSalesView;
import com.bytedance.android.shopping.product.flow.view.info.ProductFlowCardTitleView;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0007\u0012\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001\u0012\f\b\u0002\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u0001\u0012\n\b\u0002\u0010\u009d\u0001\u001a\u00030\u009c\u0001¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00101\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\"\u00105\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010(\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010E\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010M\u001a\u00020F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010Q\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010 \u001a\u0004\bO\u0010\"\"\u0004\bP\u0010$R\"\u0010U\u001a\u00020&8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bR\u0010(\u001a\u0004\bS\u0010*\"\u0004\bT\u0010,R$\u0010]\u001a\u0004\u0018\u00010V8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R$\u0010e\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010i\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u00108\u001a\u0004\bg\u0010:\"\u0004\bh\u0010<R\u001a\u0010l\u001a\u00020&8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bj\u0010(\u001a\u0004\bk\u0010*R\u0017\u0010r\u001a\u00020m8\u0006¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u0017\u0010x\u001a\u00020s8\u0006¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010wR\u0017\u0010{\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\by\u0010\u0010\u001a\u0004\bz\u0010\u0012R(\u0010\u0083\u0001\u001a\u0004\u0018\u00010|8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R1\u0010\u008c\u0001\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u0084\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R1\u0010\u0091\u0001\u001a\n\u0012\u0005\u0012\u00030\u008d\u00010\u0084\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u0087\u0001\u001a\u0006\b\u008f\u0001\u0010\u0089\u0001\"\u0006\b\u0090\u0001\u0010\u008b\u0001R\u001d\u0010\u0097\u0001\u001a\u00030\u0092\u00018\u0006¢\u0006\u0010\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001¨\u0006 \u0001"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/BaseCardDetailView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/feed/widget/ExchangeCouponView$b;", "", "factor", "", "setTransitionFactor", "Lcom/bytedance/android/shopping/feed/widget/BaseCardHeaderView;", "a", "Lcom/bytedance/android/shopping/feed/widget/BaseCardHeaderView;", "getCardHeaderView", "()Lcom/bytedance/android/shopping/feed/widget/BaseCardHeaderView;", "setCardHeaderView", "(Lcom/bytedance/android/shopping/feed/widget/BaseCardHeaderView;)V", "cardHeaderView", "b", "Landroid/widget/FrameLayout;", "getHeaderViewContainer", "()Landroid/widget/FrameLayout;", "setHeaderViewContainer", "(Landroid/widget/FrameLayout;)V", "headerViewContainer", "Lcom/bytedance/android/shopping/feed/widget/InflowSkuWidget;", "c", "Lcom/bytedance/android/shopping/feed/widget/InflowSkuWidget;", "getSkuWidget", "()Lcom/bytedance/android/shopping/feed/widget/InflowSkuWidget;", "setSkuWidget", "(Lcom/bytedance/android/shopping/feed/widget/InflowSkuWidget;)V", "skuWidget", "Lcom/bytedance/android/shopping/inflow/view/TopRoundRelativeLayout;", "d", "Lcom/bytedance/android/shopping/inflow/view/TopRoundRelativeLayout;", "getPriceContainer", "()Lcom/bytedance/android/shopping/inflow/view/TopRoundRelativeLayout;", "setPriceContainer", "(Lcom/bytedance/android/shopping/inflow/view/TopRoundRelativeLayout;)V", "priceContainer", "Landroid/view/View;", "e", "Landroid/view/View;", "getPriceAndSalesView", "()Landroid/view/View;", "setPriceAndSalesView", "(Landroid/view/View;)V", "priceAndSalesView", "f", "getProductTitleView", "setProductTitleView", "productTitleView", "g", "getProductTitleDivider", "setProductTitleDivider", "productTitleDivider", "Landroid/view/ViewGroup;", "h", "Landroid/view/ViewGroup;", "getSameProductEntrance", "()Landroid/view/ViewGroup;", "setSameProductEntrance", "(Landroid/view/ViewGroup;)V", "sameProductEntrance", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "getExtraInfoContainer", "()Landroid/widget/LinearLayout;", "setExtraInfoContainer", "(Landroid/widget/LinearLayout;)V", "extraInfoContainer", "Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView;", "k", "Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView;", "getBottomBarView", "()Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView;", "setBottomBarView", "(Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView;)V", "bottomBarView", "m", "getBarContainer", "setBarContainer", "barContainer", "n", "getDetailRootView", "setDetailRootView", "detailRootView", "Lcom/bytedance/android/shopping/feed/viewmodel/ProductFeedViewModel;", "s", "Lcom/bytedance/android/shopping/feed/viewmodel/ProductFeedViewModel;", "getViewModel", "()Lcom/bytedance/android/shopping/feed/viewmodel/ProductFeedViewModel;", "setViewModel", "(Lcom/bytedance/android/shopping/feed/viewmodel/ProductFeedViewModel;)V", "viewModel", "Lrd3/a;", "u", "Lrd3/a;", "getAnchorInflowFeedItem", "()Lrd3/a;", "setAnchorInflowFeedItem", "(Lrd3/a;)V", "anchorInflowFeedItem", "x", "getDiscountInfoContainer", "setDiscountInfoContainer", "discountInfoContainer", "F", "getStrokeView", "strokeView", "Landroid/widget/FrameLayout$LayoutParams;", "H", "Landroid/widget/FrameLayout$LayoutParams;", "getRightSafeguardInfoViewParams", "()Landroid/widget/FrameLayout$LayoutParams;", "rightSafeguardInfoViewParams", "Landroid/widget/LinearLayout$LayoutParams;", "I", "Landroid/widget/LinearLayout$LayoutParams;", "getRightContainerViewParams", "()Landroid/widget/LinearLayout$LayoutParams;", "rightContainerViewParams", "J", "getRightContainerView", "rightContainerView", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/InflowFeedServiceView;", "K", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/InflowFeedServiceView;", "getRightSafeguardInfoView", "()Lcom/bytedance/android/shopping/anchorv3/detail/widget/InflowFeedServiceView;", "setRightSafeguardInfoView", "(Lcom/bytedance/android/shopping/anchorv3/detail/widget/InflowFeedServiceView;)V", "rightSafeguardInfoView", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/ec/model/response/anchorv3/SpecDetail;", "L", "Landroidx/lifecycle/MutableLiveData;", "getSpecDetailLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setSpecDetailLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "specDetailLiveData", "Lcom/bytedance/android/ec/model/sku/SkuProductDetailInfo;", "M", "getSkuProductDetailInfo", "setSkuProductDetailInfo", "skuProductDetailInfo", "Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView$a;", "O", "Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView$a;", "getBottomBarCallBack", "()Lcom/bytedance/android/shopping/feed/view/bottombar/InflowFeedBottomBarView$a;", "bottomBarCallBack", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseCardDetailView extends FrameLayout implements ExchangeCouponView.b {
    public static final /* synthetic */ int P = 0;
    public final MarketingBannerLayout A;
    public final boolean B;
    public final LinearLayout.LayoutParams C;
    public final FrameLayout.LayoutParams D;
    public final FrameLayout.LayoutParams E;
    public final View F;
    public Function3<? super View, ? super String, ? super String, Unit> G;
    public final FrameLayout.LayoutParams H;
    public final LinearLayout.LayoutParams I;
    public final FrameLayout J;
    public InflowFeedServiceView K;
    public MutableLiveData<SpecDetail> L;
    public MutableLiveData<SkuProductDetailInfo> M;
    public final k N;
    public final j O;
    public BaseCardHeaderView a;
    public FrameLayout b;
    public InflowSkuWidget c;
    public TopRoundRelativeLayout d;
    public View e;
    public View f;
    public View g;
    public ViewGroup h;
    public LinearLayout i;
    public final FrameLayout j;
    public InflowFeedBottomBarView k;
    public final ViewGroup l;
    public TopRoundRelativeLayout m;
    public View n;
    public final FrameLayout o;
    public AbsActivitiesBarView p;
    public InFlowActivityLayout q;
    public PromotionProductStruct r;
    public ProductFeedViewModel s;
    public AnchorV3PreSecKillLayout t;
    public rd3.a u;
    public InflowFeedCommentView v;
    public View w;
    public ViewGroup x;
    public final BenefitGroupLayout y;
    public final ExchangeCouponView z;

    public static final class a extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ BaseCardDetailView g;

        public a(BaseCardDetailView r3) {
            this.g = r3;
            super(null, "bind_product_flow_card", 1);
        }

        public final void a(View r4) {
            Intrinsics.checkNotNullParameter(r4, "v");
            BaseCardDetailView r5 = this.g;
            Function3<? super View, ? super String, ? super String, Unit> r0 = r5.G;
            if (r0 == null) goto L6;
            Unit r6 = (Unit) r0.invoke(r5.l, "click", "blank");
            return;
        }
    }

    public static final class b extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ BaseCardDetailView g;

        public b(BaseCardDetailView r3) {
            this.g = r3;
            super(null, "bind_product_flow_card", 1);
        }

        public final void a(View r4) {
            Intrinsics.checkNotNullParameter(r4, "v");
            BaseCardDetailView r5 = this.g;
            Function3<? super View, ? super String, ? super String, Unit> r0 = r5.G;
            if (r0 == null) goto L6;
            Unit r6 = (Unit) r0.invoke(r5.getBarContainer(), "click", "blank");
            return;
        }
    }

    public static final class c extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ BaseCardDetailView g;

        public c(BaseCardDetailView r3) {
            this.g = r3;
            super(null, "bind_product_flow_card", 1);
        }

        public final void a(View r4) {
            Intrinsics.checkNotNullParameter(r4, "v");
            BaseCardDetailView r5 = this.g;
            Function3<? super View, ? super String, ? super String, Unit> r0 = r5.G;
            if (r0 == null) goto L6;
            Unit r6 = (Unit) r0.invoke(r5.getPriceAndSalesView(), "click", "blank");
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ BaseCardDetailView a;
        public final /* synthetic */ ProductFeedViewModel b;
        public final /* synthetic */ rd3.a c;

        public d(BaseCardDetailView r1, ProductFeedViewModel r2, rd3.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r18) {
            SpecDetail r1 = (SpecDetail) r18;
            Long r3 = null;
            if (this.a.getPriceAndSalesView().getVisibility() != 0) goto L80;
            BaseCardDetailView r2 = this.a;
            if (r2.B == false) goto L64;
            View r4 = r2.getPriceAndSalesView();
            if (r4 == null) goto L63;
            InFlowPriceAreaView r5 = (InFlowPriceAreaView) r4;
            Integer r6 = r5.g;
            long r7 = 0;
            if (r6 != null) goto L12;
        L36:
            if (r6 != null) goto L39;
        L67:
            BaseCardHeaderView r8 = this.a.getCardHeaderView();
            if (r8 == null) goto L103;
            VideoProductFeedBanner r9 = r8.b;
            if (r9 == null) goto L103;
            if (r9.f.getVisibility() != 0) goto L103;
            InFlowNumberBannerIndicatorView r10 = r9.f;
            if (r1 == null) goto L76;
            String r11 = r1.getName();
        L77:
            r10.setDescription(r11);
            goto L103
        L76:
            r11 = null;
        L103:
            Promotion r12 = this.c.f();
            if (r12 == null) goto L114;
            PromotionProductStruct r13 = r12.getPromotionInfo();
            if (r13 == null) goto L114;
            PromotionProductBaseStruct r14 = r13.getBaseInfo();
            if (r14 == null) goto L114;
            ProductSpecInfoStruct r15 = r14.getSpecInfo();
            if (r15 == null) goto L114;
            List r16 = r15.getSpecSeqs();
            if (r16 == null) goto L114;
            int r17 = r16.size();
        L116:
            if (this.b.getSkuPanelState() != null) goto L118;
            this.b.setSkuPanelState(new SkuRestoreState(r17));
        L118:
            String[] r19 = new String[r17];
            int r20 = 0;
        L119:
            if (r20 >= r17) goto L121;
            r19[r20] = null;
            r20 = r20 + 1;
            goto L119
        L121:
            if (r17 <= 0) goto L125;
            if (r1 == null) goto L124;
            r3 = Long.valueOf(r1.getSpecDetailId());
        L124:
            r19[0] = String.valueOf(r3);
        L125:
            SkuRestoreState r21 = this.b.getSkuPanelState();
            if (r21 == null) goto L130;
            SkuRestoreState.saveSelectedSpec$default(r21, r19, Long.valueOf(r17), null, null, null, null, 0, 120, null);
            return;
        L130:
            return;
        L114:
            r17 = 0;
            goto L116
        L39:
            if (r6.intValue() != 1) goto L67;
            InFlowPriceViewV1 r22 = r5.c;
            if (r22 == null) goto L67;
            if (r1 == null) goto L61;
            Long r23 = r1.getEffectivePrice();
            if (r23 == null) goto L46;
            long r24 = r23.longValue();
        L48:
            if (r24 <= 0) goto L61;
            Long r25 = r1.getMarketPrice();
            if (r25 == null) goto L53;
            r25.longValue();
        L53:
            Long r26 = r1.getEffectivePrice();
            if (r26 == null) goto L56;
            long r27 = r26.longValue();
        L57:
            Long r28 = r1.getDiscountPrice();
            if (r28 == null) goto L60;
            r7 = r28.longValue();
        L60:
            r22.c(r27, 0, r7);
            r22.a.C(InFlowPriceViewV1$updateSpecPrice$1.INSTANCE);
            goto L67
        L56:
            r27 = 0;
            goto L57
        L46:
            r24 = 0;
        L61:
            r22.b();
            goto L67
        L12:
            if (r6.intValue() != 0) goto L36;
            final InFlowPriceViewV0 r29 = r5.d;
            if (r29 == null) goto L67;
            if (r1 == null) goto L35;
            Long r30 = r1.getEffectivePrice();
            if (r30 == null) goto L19;
            long r31 = r30.longValue();
        L21:
            if (r31 <= 0) goto L35;
            Long r32 = r1.getMarketPrice();
            if (r32 == null) goto L26;
            long r110 = r32.longValue();
        L27:
            Long r33 = r1.getEffectivePrice();
            if (r33 == null) goto L30;
            long r34 = r33.longValue();
        L31:
            Long r35 = r1.getDiscountPrice();
            if (r35 == null) goto L34;
            r7 = r35.longValue();
        L34:
            r29.b(r34, r7, r110);
            r29.a.C(new InFlowPriceViewV0$updateSpecPrice$1(r29));
            goto L67
        L30:
            r34 = 0;
            goto L31
        L26:
            r110 = 0;
            goto L27
        L19:
            r31 = 0;
        L35:
            r29.a();
            goto L67
        L63:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.feed.widget.InFlowPriceAreaView");
        L64:
            View r36 = r2.getPriceAndSalesView();
            if (r36 == null) goto L79;
            ((ProductFlowCardPriceAndSalesView) r36).b(r1);
            goto L67
        L79:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.product.flow.view.info.ProductFlowCardPriceAndSalesView");
        L80:
            AbsActivitiesBarView r37 = this.a.p;
            if (r37 == null) goto L103;
            if (r37.getVisibility() != 0) goto L103;
            BaseCardDetailView r38 = this.a;
            if (r38.B == true) goto L103;
            AbsActivitiesBarView r39 = r38.p;
            if ((r39 instanceof ActivityBarShopLayout) == true) goto L89;
            r39 = null;
        L89:
            ActivityBarShopLayout r40 = (ActivityBarShopLayout) r39;
            if (r40 == null) goto L92;
            r40.setSpecPrice(r1);
        L92:
            BaseCardHeaderView r41 = this.a.getCardHeaderView();
            if (r41 == null) goto L103;
            VideoProductFeedBanner r42 = r41.b;
            if (r42 == null) goto L103;
            if (r42.f.getVisibility() != 0) goto L103;
            InFlowNumberBannerIndicatorView r43 = r42.f;
            if (r1 == null) goto L101;
            String r44 = r1.getName();
        L102:
            r43.setDescription(r44);
            goto L103
        L101:
            r44 = null;
            goto L102
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ BaseCardDetailView a;
        public final /* synthetic */ rd3.a b;

        public e(BaseCardDetailView r1, rd3.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r6) {
            SkuProductDetailInfo r7 = (SkuProductDetailInfo) r6;
            if (r7 == null) goto L41;
            Promotion r0 = this.b.f();
            if (r0 == null) goto L32;
            PromotionProductStruct r1 = r0.getPromotionInfo();
            if (r1 == null) goto L32;
            PromotionProductBaseStruct r2 = r1.getBaseInfo();
            if (r2 == null) goto L32;
            ProductSpecInfoStruct r3 = r2.getSpecInfo();
            if (r3 == null) goto L32;
            List r4 = r3.getSpecList();
            if (r4 == null) goto L32;
            Iterator<T> r5 = r4.iterator();
        L16:
            Unit r8 = null;
            if (r5.hasNext() == false) goto L25;
            T r9 = r5.next();
            String r10 = String.valueOf(((SpecDetail) r9).getSpecDetailId());
            String[] r11 = r7.getSpecArray();
            if (r11 == null) goto L21;
            String r12 = (String) ArraysKt.firstOrNull(r11);
        L23:
            if (Intrinsics.areEqual(r10, r12) == false) goto L16;
        L26:
            SpecDetail r13 = (SpecDetail) r9;
            if (r13 == null) goto L32;
            InflowSkuWidget r14 = this.a.getSkuWidget();
            if (r14 == null) goto L31;
            Intrinsics.checkNotNullParameter(r13, "specDetail");
            r14.a(String.valueOf(r13.getSpecDetailId()));
            r8 = Unit.INSTANCE;
        L31:
            if (r8 == null) goto L32;
            return;
        L21:
            r12 = null;
            goto L23
        L25:
            r9 = null;
        L32:
            InflowSkuWidget r15 = this.a.getSkuWidget();
            if (r15 == null) goto L40;
            r15.a("");
            Unit r16 = Unit.INSTANCE;
            return;
        L40:
            return;
        }
    }

    public static final class f extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ ExchangeCoupons g;
        public final /* synthetic */ BaseCardDetailView h;
        public final /* synthetic */ rd3.a i;
        public final /* synthetic */ Function3 j;

        public final void a(View r8) {
            Intrinsics.checkNotNullParameter(r8, "v");
            FeedProductEventTracker r9 = FeedProductEventTracker.a;
            Context r0 = this.h.getContext();
            rd3.a r1 = this.i;
            r9.getClass();
            String r10 = "";
            String r2 = null;
            if (r1 == null) goto L46;
            Promotion r3 = r1.f();
            if (r3 == null) goto L46;
            PromotionProductStruct r4 = r3.getPromotionInfo();
            if (r4 == null) goto L46;
            com.bytedance.android.shopping.feed.event.u r5 = new com.bytedance.android.shopping.feed.event.u();
            PromotionProductExtraStruct r6 = r4.getExtraInfo();
            if (r6 == null) goto L14;
            String r7 = r6.getLogExtra();
            if (r7 == null) goto L14;
            JSONObject r11 = z1.g(r7);
        L15:
            r5.a = "product_flow_page";
            ProductFeedViewModel r12 = r1.c;
            if (r12 == null) goto L23;
            AnchorV3Param r13 = r12.m907getAnchorV3Param();
            if (r13 == null) goto L23;
            AnchorV3PromotionRequestParam r14 = r13.getRequestParam();
            if (r14 == null) goto L23;
            String r15 = r14.getSourcePage();
            if (r15 == null) goto L23;
        L24:
            r5.b = r15;
            r5.c = "under_price_panel";
            if (r11 == null) goto L34;
            String r16 = r11.optString("exchange_coupon_activity_name");
            if (r16 == null) goto L34;
            if (cg4.a.a(r16) == true) goto L32;
            r16 = null;
        L32:
            if (r16 == null) goto L34;
            r5.d = r16;
        L34:
            r5.e = "ok";
            ProductFeedViewModel r17 = r1.c;
            if (r17 == null) goto L40;
            AnchorV3Param r18 = r17.m907getAnchorV3Param();
            if (r18 == null) goto L40;
            String r19 = r18.getVideoId();
            if (r19 == null) goto L40;
        L41:
            r5.f = r19;
            PromotionProductBaseStruct r20 = r4.getBaseInfo();
            if (r20 == null) goto L44;
            String r21 = r20.getProductId();
        L45:
            r5.g = r21;
            com.bytedance.android.shopping.feed.event.g.c(r5, r0, null);
            goto L46
        L44:
            r21 = null;
        L40:
            r19 = "";
        L23:
            r15 = "";
        L14:
            r11 = null;
        L46:
            String r22 = this.g.getSchema();
            if (r22 != null) goto L49;
            return;
        L49:
            if (cg4.a.a(r22) == false) goto L51;
            r2 = r22;
        L51:
            if (r2 == null) goto L67;
            com.bytedance.android.ec.sdk.helper.p r23 = com.bytedance.android.ec.sdk.helper.p.a;
            Context r24 = this.h.getContext();
            int r25 = com.bytedance.android.shopping.feed.utils.b.a;
            rd3.a r26 = this.i;
            Intrinsics.checkNotNullParameter(r2, "schema");
            Uri.Builder r27 = UriProtector.parse(r2).buildUpon();
            if (r26 == null) goto L64;
            ProductFeedViewModel r28 = r26.c;
            if (r28 == null) goto L64;
            AnchorV3Param r29 = r28.m907getAnchorV3Param();
            if (r29 == null) goto L64;
            AnchorV3PromotionRequestParam r30 = r29.getRequestParam();
            if (r30 == null) goto L64;
            String r31 = r30.getSourcePage();
            if (r31 == null) goto L64;
            r10 = r31;
        L64:
            r27.appendQueryParameter("previous_page", r10);
            r23.openSchema(r24, r27.toString());
            return;
        }

        public f(ExchangeCoupons r1, BaseCardDetailView r2, rd3.a r3, Function3 r4) {
            this.g = r1;
            this.h = r2;
            this.i = r3;
            this.j = r4;
            super(null, "bind_product_flow_card", 1);
        }
    }

    public static final class g implements InFlowCardTitleView.b {
        public final /* synthetic */ BaseCardDetailView a;
        public final /* synthetic */ rd3.a b;
        public final /* synthetic */ Function3 c;

        @Override // com.bytedance.android.shopping.feed.widget.inflowcardtitle.InFlowCardTitleView.b
        public final void a() {
            new com.bytedance.android.shopping.feed.widget.popupview.c(this.a.getProductTitleView()).c(this.b);
        }

        public g(BaseCardDetailView r1, rd3.a r2, Function3 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ InflowFeedServiceView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ BaseCardDetailView c;
        public final /* synthetic */ ProductFeedViewModel d;
        public final /* synthetic */ Function3 e;

        public h(InflowFeedServiceView r1, boolean r2, BaseCardDetailView r3, ProductFeedViewModel r4, Function3 r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            StringBuffer r0 = new StringBuffer();
            Iterator r1 = com.bytedance.commerce.base.view.b.a(this.a).iterator();
        L4:
            if (r1.hasNext() == false) goto L11;
            View r2 = (View) r1.next();
            if (r2.getVisibility() != 0) goto L4;
            if ((r2 instanceof TextView) == false) goto L4;
            r0.append(((TextView) r2).getText().toString() + ",");
            goto L4
        L11:
            if (r0.length() <= 0) goto L13;
            boolean r3 = true;
        L14:
            if (r3 == false) goto L32;
            FeedProductEventTracker r4 = FeedProductEventTracker.a;
            Context r5 = this.c.getContext();
            ProductFeedViewModel r6 = this.d;
            String r7 = r0.substring(0, StringsKt.getLastIndex(r0));
            boolean r8 = this.b;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r7, "text");
            if (r6 == null) goto L33;
            AnchorV3Param r9 = r6.m907getAnchorV3Param();
            if (r9 == null) goto L34;
            com.bytedance.android.shopping.feed.event.f r10 = new com.bytedance.android.shopping.feed.event.f();
            r10.c = r9.getRequestParam().getItemId();
            r10.a = "product_flow_page";
            r10.b = r9.getProductId();
            r10.d = r7;
            if (r8 == false) goto L22;
            String r11 = "guess_you_like_product";
        L23:
            r10.e = r11;
            com.bytedance.android.shopping.feed.event.g.c(r10, r5, null);
            return;
        L22:
            r11 = null;
            goto L23
        L34:
            return;
        L33:
            return;
        L32:
            return;
        L13:
            r3 = false;
            goto L14
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ BaseCardDetailView g;
        public final /* synthetic */ Ref.ObjectRef h;
        public final /* synthetic */ Ref.BooleanRef i;
        public final /* synthetic */ Ref.ObjectRef j;
        public final /* synthetic */ MarketingTip k;

        public final void a(View r26) {
            Intrinsics.checkNotNullParameter(r26, "v");
            if (cg4.a.a((String) this.h.element) == false) goto L101;
            boolean r3 = true;
            BaseCardDetailView r4 = null;
            if (this.i.element == false) goto L21;
            FeedProductEventTracker r2 = FeedProductEventTracker.a;
            Context r5 = this.g.getContext();
            String r6 = ((StringBuilder) this.j.element).toString();
            MarketingTip r7 = this.k;
            if (r7 == null) goto L11;
            Integer r8 = r7.getType();
            if (r8 == null) goto L11;
            int r9 = r8.intValue();
        L12:
            BaseCardDetailView r10 = this.g;
            if ((r10 instanceof MainProductCardDetailView) == false) goto L17;
            r4 = r10;
        L17:
            if (((MainProductCardDetailView) r4) != null) goto L20;
            r3 = false;
        L20:
            r2.getClass();
            FeedProductEventTracker.K(r5, r6, r9, false, r3);
        L99:
            String r11 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "c3043.d9668", PageFinder.via(r26), null, 4, null);
            com.bytedance.android.ec.sdk.helper.p r12 = com.bytedance.android.ec.sdk.helper.p.a;
            Context r1 = r26.getContext();
            int r13 = md3.a.a;
            r12.openSchema(r1, md3.a.a((String) this.h.element, r11));
            return;
        L11:
            r9 = 0;
            goto L12
        L21:
            FeedProductEventTracker r14 = FeedProductEventTracker.a;
            rd3.a r15 = this.g.getAnchorInflowFeedItem();
            Context r16 = r26.getContext();
            String r18 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7365.c3043.d9668", Boolean.FALSE).withView(r26).build());
            r14.getClass();
            if (r15 == null) goto L26;
            ProductFeedViewModel r17 = r15.c;
            if (r17 == null) goto L26;
            AnchorV3Param r19 = r17.m907getAnchorV3Param();
        L28:
            if (r19 == null) goto L37;
            String r20 = r19.getEntranceInfo();
            if (r20 == null) goto L37;
            JSONObject r21 = z1.g(r20);
            if (r21 == null) goto L37;
            String r22 = r21.optString("product_source_page", "");
            if (r22 != null) goto L36;
            r22 = "";
        L36:
            String r110 = r22;
        L39:
            if (r15 == null) goto L50;
            Promotion r23 = r15.f();
            if (r23 == null) goto L50;
            PromotionProductStruct r24 = r23.getPromotionInfo();
            if (r24 == null) goto L50;
            PromotionProductBaseStruct r25 = r24.getBaseInfo();
            if (r25 == null) goto L50;
            String r27 = r25.getProductId();
            if (r27 == null) goto L50;
            String r111 = r27;
        L51:
            if (r15 != null) goto L53;
        L55:
            String r112 = "";
        L56:
            if (r19 == null) goto L61;
            String r28 = r19.getAuthorId();
            if (r28 == null) goto L61;
            String r113 = r28;
        L62:
            if (r15 == null) goto L73;
            ProductFeedViewModel r29 = r15.c;
            if (r29 == null) goto L73;
            PromotionProductStruct r30 = r29.getPromotion();
            if (r30 == null) goto L73;
            PromotionProductBaseStruct r31 = r30.getBaseInfo();
            if (r31 == null) goto L73;
            String r32 = r31.getPromotionId();
            if (r32 == null) goto L73;
            String r114 = r32;
        L74:
            if (r15 == null) goto L82;
            ProductFeedViewModel r33 = r15.c;
            if (r33 == null) goto L82;
            PromotionProductStruct r34 = r33.getPromotion();
            if (r34 == null) goto L82;
            PromotionProductBaseStruct r35 = r34.getBaseInfo();
            if (r35 == null) goto L82;
            Integer r36 = r35.getPromotionSource();
        L83:
            String r115 = String.valueOf(r36);
            if (r19 == null) goto L89;
            String r37 = r19.getVideoId();
            if (r37 == null) goto L89;
            String r116 = r37;
        L90:
            if (r19 == null) goto L97;
            ECLogExtraData r38 = r19.getLogExtraData();
            if (r38 == null) goto L97;
            String r39 = r38.getEnterFrom();
            if (r39 == null) goto L97;
            String r117 = r39;
        L98:
            com.bytedance.android.shopping.feed.event.g.c(new t0(r111, r112, r113, r114, r115, r116, r110, r117, r18), r16, null);
        L97:
            r117 = "";
        L89:
            r116 = "";
        L82:
            r36 = null;
        L73:
            r114 = "";
        L61:
            r113 = "";
            goto L62
        L53:
            if (r15.e != true) goto L55;
            r112 = "guess_you_like_product";
        L50:
            r111 = "";
        L37:
            r110 = "";
        L26:
            r19 = null;
            goto L28
        }

        public i(BaseCardDetailView r1, Ref.ObjectRef r2, Ref.BooleanRef r3, Ref.ObjectRef r4, MarketingTip r5) {
            this.g = r1;
            this.h = r2;
            this.i = r3;
            this.j = r4;
            this.k = r5;
            super(null, "bind_product_flow_card", 1);
        }
    }

    public static final class j implements InflowFeedBottomBarView.a {
        public final /* synthetic */ BaseCardDetailView a;

        public j(BaseCardDetailView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.feed.view.bottombar.InflowFeedBottomBarView.a
        public final void a(boolean r5) {
            rd3.a r0 = this.a.getAnchorInflowFeedItem();
            ActivityVO r1 = null;
            if (r0 == null) goto L7;
            Promotion r2 = r0.f();
            if (r2 == null) goto L7;
            PromotionProductStruct r3 = r2.getPromotionInfo();
        L8:
            if (r3 == null) goto L13;
            int r4 = f53.a.c(r3).getSales();
            if (r5 == false) goto L12;
            int r6 = r4 + 1;
        L14:
            if (r3 == null) goto L22;
            PromotionProductPrivilegesStruct r7 = r3.getPrivilegeInfo();
            if (r7 == null) goto L22;
            PromotionProductActivitiesStruct r8 = r7.getActivities();
            if (r8 == null) goto L22;
            PromotionAppointment r9 = r8.getAppointActivity();
            if (r9 == null) goto L22;
            r9.setAppointment(r5);
            r9.setAppointmentNum(r6);
        L22:
            BaseCardDetailView r10 = this.a;
            if (r3 == null) goto L25;
            r1 = f53.a.c(r3);
        L25:
            r10.d(r1);
            this.a.g();
            return;
        L12:
            r6 = r4 - 1;
            goto L14
        L13:
            r6 = 0;
        L7:
            r3 = null;
            goto L8
        }

        @Override // com.bytedance.android.shopping.feed.view.bottombar.InflowFeedBottomBarView.a
        public final void b(InflowCardBuyButton r2) {
            Intrinsics.checkNotNullParameter(r2, "productFeedBuyButton");
            Intrinsics.checkNotNullParameter(r2, "productFeedBuyButton");
        }

        @Override // com.bytedance.android.shopping.feed.view.bottombar.InflowFeedBottomBarView.a
        public final void c(View r2) {
            Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
            Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ BaseCardDetailView a;

        public k(BaseCardDetailView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            sd3.a r6 = (sd3.a) r5;
            BaseCardDetailView r0 = this.a;
            int r1 = BaseCardDetailView.P;
            r0.getClass();
            if (Intrinsics.areEqual(r6.a, Boolean.TRUE) == false) goto L27;
            String r7 = r6.b;
            rd3.a r2 = r0.u;
            if (r2 == null) goto L13;
            Promotion r3 = r2.f();
            if (r3 == null) goto L13;
            PromotionProductStruct r4 = r3.getPromotionInfo();
            if (r4 == null) goto L13;
            PromotionProductBaseStruct r8 = r4.getBaseInfo();
            if (r8 == null) goto L13;
            String r9 = r8.getProductId();
        L15:
            if (Intrinsics.areEqual(r7, r9) == false) goto L27;
            FrameLayout r10 = r0.o;
            if (r10 == null) goto L27;
            if (r10.getChildCount() != 0) goto L27;
            FrameLayout r11 = r0.o;
            if (r11 == null) goto L27;
            if (r11.getVisibility() != 8) goto L27;
            FrameLayout r12 = r0.o;
            if (r12 == null) goto L35;
            r12.addView(new com.bytedance.android.shopping.feed.widget.gesture.b(r12.getContext(), new com.bytedance.android.shopping.feed.widget.b(r12), 12));
            r12.setOnTouchListener(new com.bytedance.android.shopping.feed.widget.c(r12));
            r12.setVisibility(0);
            sk.a.a.getClass();
            com.bytedance.android.ec.sdk.helper.q.a.d("ec_inflow_long_press_gesture_times_" + com.bytedance.android.ec.sdk.helper.r.a.getCurrentUserId(), 1);
            return;
        L35:
            return;
        L13:
            r9 = null;
        L27:
            FrameLayout r13 = r0.o;
            if (r13 != null) goto L30;
            return;
        L30:
            if (r13.getVisibility() != 0) goto L38;
            FrameLayout r14 = r0.o;
            if (r14 == null) goto L39;
            r14.removeAllViews();
            r14.setVisibility(8);
            return;
        L39:
            return;
        }
    }

    public BaseCardDetailView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseCardDetailView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public void e() {
    }

    @Override // com.bytedance.android.shopping.feed.widget.ExchangeCouponView.b
    public final void a() {
        FeedProductEventTracker r0 = FeedProductEventTracker.a;
        Context r1 = getContext();
        rd3.a r2 = this.u;
        r0.getClass();
        if (r2 == null) goto L48;
        Promotion r3 = r2.f();
        if (r3 == null) goto L49;
        PromotionProductStruct r4 = r3.getPromotionInfo();
        if (r4 == null) goto L50;
        com.bytedance.android.shopping.feed.event.z1 r5 = new com.bytedance.android.shopping.feed.event.z1();
        PromotionProductExtraStruct r6 = r4.getExtraInfo();
        if (r6 == null) goto L14;
        String r7 = r6.getLogExtra();
        if (r7 == null) goto L14;
        JSONObject r8 = z1.g(r7);
    L15:
        r5.a = "product_flow_page";
        ProductFeedViewModel r9 = r2.c;
        String r10 = "";
        if (r9 == null) goto L23;
        AnchorV3Param r11 = r9.m907getAnchorV3Param();
        if (r11 == null) goto L23;
        AnchorV3PromotionRequestParam r12 = r11.getRequestParam();
        if (r12 == null) goto L23;
        String r13 = r12.getSourcePage();
        if (r13 == null) goto L23;
    L24:
        r5.b = r13;
        r5.c = "under_price_panel";
        if (r8 == null) goto L34;
        String r14 = r8.optString("exchange_coupon_activity_name");
        if (r14 == null) goto L34;
        if (cg4.a.a(r14) == true) goto L32;
        r14 = null;
    L32:
        if (r14 == null) goto L34;
        r5.d = r14;
    L34:
        ProductFeedViewModel r15 = r2.c;
        if (r15 == null) goto L42;
        AnchorV3Param r16 = r15.m907getAnchorV3Param();
        if (r16 == null) goto L42;
        String r17 = r16.getVideoId();
        if (r17 == null) goto L42;
        r10 = r17;
    L42:
        r5.e = r10;
        PromotionProductBaseStruct r18 = r4.getBaseInfo();
        if (r18 == null) goto L45;
        String r19 = r18.getProductId();
    L46:
        r5.f = r19;
        com.bytedance.android.shopping.feed.event.g.c(r5, r1, null);
        return;
    L45:
        r19 = null;
    L23:
        r13 = "";
    L14:
        r8 = null;
        goto L15
    L50:
        return;
    L49:
        return;
    }

    public final void g() {
        PromotionProductStruct r0 = this.r;
        if (r0 == null) goto L29;
        ActivityVO r2 = f53.a.c(r0);
        d(r2);
        CommonGirdleStructV2 r1 = null;
        if (this.B == false) goto L16;
        InFlowActivityLayout r3 = this.q;
        if (r3 == null) goto L30;
        PromotionProductStruct r4 = this.r;
        if (r4 == null) goto L15;
        PromotionProductPrivilegesStruct r5 = r4.getPrivilegeInfo();
        if (r5 == null) goto L15;
        PromotionProductActivitiesStruct r6 = r5.getActivities();
        if (r6 == null) goto L15;
        r1 = r6.getCommonGirdleV2();
    L15:
        r3.c(r1);
        return;
    L30:
        return;
    L16:
        AbsActivitiesBarView r7 = this.p;
        if (r7 == null) goto L32;
        PromotionProductStruct r8 = this.r;
        if (r8 == null) goto L23;
        PromotionProductBaseStruct r9 = r8.getBaseInfo();
        if (r9 == null) goto L23;
        Long r10 = r9.getSales();
    L24:
        ProductFeedViewModel r11 = this.s;
        if (r11 == null) goto L27;
        r1 = r11.m907getAnchorV3Param();
    L27:
        r7.f(r2, r10, false, r1, this.r, true);
        return;
    L23:
        r10 = null;
        goto L24
    L32:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        InflowFeedCommentView r0 = this.v;
        if (r0 == null) goto L8;
        ECViewFlipper r1 = r0.b;
        if (r1 == null) goto L9;
        r1.startFlipping();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InflowFeedCommentView r0 = this.v;
        if (r0 == null) goto L7;
        ECViewFlipper r1 = r0.b;
        if (r1 == null) goto L7;
        r1.stopFlipping();
    L7:
        ProductFeedViewModel r2 = this.s;
        if (r2 == null) goto L13;
        MutableLiveData<sd3.a> r3 = r2.getGestureGuideLiveData();
        if (r3 == null) goto L14;
        r3.removeObserver(this.N);
        return;
    L14:
        return;
    }

    public final rd3.a getAnchorInflowFeedItem() {
        return this.u;
    }

    public final TopRoundRelativeLayout getBarContainer() {
        return this.m;
    }

    public final InflowFeedBottomBarView.a getBottomBarCallBack() {
        return this.O;
    }

    public final InflowFeedBottomBarView getBottomBarView() {
        return this.k;
    }

    public final BaseCardHeaderView getCardHeaderView() {
        return this.a;
    }

    public final View getDetailRootView() {
        return this.n;
    }

    public final ViewGroup getDiscountInfoContainer() {
        return this.x;
    }

    public final LinearLayout getExtraInfoContainer() {
        return this.i;
    }

    public final FrameLayout getHeaderViewContainer() {
        return this.b;
    }

    public final View getPriceAndSalesView() {
        return this.e;
    }

    public final TopRoundRelativeLayout getPriceContainer() {
        return this.d;
    }

    public final View getProductTitleDivider() {
        return this.g;
    }

    public final View getProductTitleView() {
        return this.f;
    }

    public final FrameLayout getRightContainerView() {
        return this.J;
    }

    public final LinearLayout.LayoutParams getRightContainerViewParams() {
        return this.I;
    }

    public final InflowFeedServiceView getRightSafeguardInfoView() {
        return this.K;
    }

    public final FrameLayout.LayoutParams getRightSafeguardInfoViewParams() {
        return this.H;
    }

    public final ViewGroup getSameProductEntrance() {
        return this.h;
    }

    public final MutableLiveData<SkuProductDetailInfo> getSkuProductDetailInfo() {
        return this.M;
    }

    public final InflowSkuWidget getSkuWidget() {
        return this.c;
    }

    public final MutableLiveData<SpecDetail> getSpecDetailLiveData() {
        return this.L;
    }

    public final View getStrokeView() {
        return this.F;
    }

    public final ProductFeedViewModel getViewModel() {
        return this.s;
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
    public final void c(MarketingTip r20) {
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = null;
        PromotionProductStruct r1 = this.r;
        if (r1 == null) goto L13;
        PromotionProductPrivilegesStruct r2 = r1.getPrivilegeInfo();
        if (r2 == null) goto L13;
        PromotionProductCouponsStruct r4 = r2.getCoupons();
        if (r4 == null) goto L13;
        BenefitComponent r5 = r4.getBenefitComponent();
        if (r5 == null) goto L13;
        Map r6 = r5.getData();
        if (r6 == null) goto L13;
        r3.element = (String) r6.get("jump_url");
        String r7 = (String) r6.get("detail");
    L14:
        Ref.BooleanRef r8 = new Ref.BooleanRef();
        r8.element = false;
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = new StringBuilder("");
        if (r7 != null) goto L17;
    L20:
        boolean r10 = true;
    L22:
        if (r10 == false) goto L57;
        if (r20 == null) goto L57;
        StringBuilder r11 = new StringBuilder("");
        List r12 = r20.getTipComponentList();
        if (r12 == null) goto L43;
        Iterator r13 = r12.iterator();
        CountDown r14 = null;
    L28:
        if (r13.hasNext() == false) goto L44;
        MarketingTipComponent r15 = (MarketingTipComponent) r13.next();
        Integer r16 = r15.getType();
        if (r16 == null) goto L35;
        if (r16.intValue() != 1) goto L35;
        r11.append(r15.getText());
        StringBuilder r17 = (StringBuilder) r9.element;
        r17.append(r15.getText());
        r9.element = r17;
    L35:
        if (r16 == null) goto L28;
        if (r16.intValue() != 2) goto L28;
        if (r15.getCountDown() == null) goto L42;
        r11.append("%s:%s:%s");
    L42:
        r14 = r15.getCountDown();
    L44:
        r7 = r11.toString();
        r3.element = r20.getJumpUrl();
        FeedProductEventTracker r18 = FeedProductEventTracker.a;
        Context r19 = getContext();
        String r110 = ((StringBuilder) r9.element).toString();
        Integer r111 = r20.getType();
        if (r111 == null) goto L47;
        int r112 = r111.intValue();
    L49:
        if ((this instanceof MainProductCardDetailView) == true) goto L51;
        BaseCardDetailView r113 = null;
    L53:
        if (((MainProductCardDetailView) r113) == null) goto L55;
        boolean r114 = true;
    L56:
        r18.getClass();
        FeedProductEventTracker.L(r19, r110, r112, false, r114);
        r8.element = true;
    L59:
        if (cg4.a.a(r7) == false) goto L111;
        this.y.setVisibility(0);
        BenefitGroupLayout r21 = this.y;
        String r115 = (String) r3.element;
        oe3.a r116 = new oe3.a(r115, r7, r14);
        PromotionProductStruct r117 = this.r;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r116, "data");
        TextView r0 = r21.a;
        if (r0 == null) goto L63;
        r0.setText(r7);
    L63:
        r21.c = r7;
        if (cg4.a.a(r115) == false) goto L68;
        ImageView r22 = r21.b;
        if (r22 == null) goto L72;
        r22.setVisibility(0);
    L72:
        if (r21.d == false) goto L98;
        if (r117 == null) goto L87;
        PromotionDepositPresaleActivity r23 = f53.a.c(r117).getDepositPresaleActivity();
        if (r23 == null) goto L87;
        if (com.bytedance.android.ec.model.n.b(r23) != true) goto L87;
        if (a53.a.a() != 1) goto L87;
        TextView r24 = r21.a;
        if (r24 == null) goto L83;
        int r25 = g1.a;
        r24.setTextColor(g1.a.a(r21.getContext(), 2131102478));
    L83:
        ImageView r26 = r21.b;
        if (r26 == null) goto L86;
        int r27 = g1.a;
        r26.setImageDrawable(g1.a.b(r21.getContext(), 2131234573));
    L86:
        r21.setBackgroundResource(2131234576);
    L88:
        ImageView r28 = r21.b;
        if (r28 == null) goto L93;
        ViewGroup.LayoutParams r29 = r28.getLayoutParams();
        if (r29 == null) goto L93;
        r29.width = com.bytedance.android.shopping.extensions.b.b(8);
    L93:
        ImageView r30 = r21.b;
        if (r30 == null) goto L98;
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
        if (r31 == null) goto L98;
        r31.height = com.bytedance.android.shopping.extensions.b.b(8);
    L87:
        r21.setBackgroundResource(2131234575);
    L98:
        if (r14 != null) goto L113;
    L110:
        this.y.setOnClickListener(new i(this, r3, r8, r9, r20));
        return;
    L113:
        TextView r32 = r21.a;     // Catch: Exception -> L107
        if (r32 == null) goto L109;
        String r33 = r21.c;     // Catch: Exception -> L107
        if (r33 == null) goto L104;
        String r34 = String.format(r33, Arrays.copyOf(new Object[]{"00", "00", "00"}, 3));     // Catch: Exception -> L107
    L105:
        r32.setText(r34);     // Catch: Exception -> L107
        goto L109
    L104:
        r34 = null;
    L109:
        Lazy r35 = ActivityCountDownTimer.c;
        ActivityCountDownTimer.a.a().a(System.currentTimeMillis() / 1000, r14.getEndTime(), r21, null);
    L107:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L109
    L68:
        ImageView r36 = r21.b;
        if (r36 == null) goto L72;
        r36.setVisibility(8);
        goto L72
    L111:
        this.y.setVisibility(8);
        return;
    L55:
        r114 = false;
        goto L56
    L51:
        r113 = this;
        goto L53
    L47:
        r112 = 0;
        goto L49
    L43:
        r14 = null;
    L57:
        r14 = null;
        goto L59
    L17:
        if (r7.length() == 0) goto L20;
        r10 = false;
    L13:
        r7 = null;
        goto L14
    }

    public final void d(ActivityVO r4) {
        int r0 = y.a;
        if (r4 == null) goto L19;
        boolean r1 = true;
        if (r4.getActivityType() != 1) goto L7;
    L20:
        if (r1 == true) goto L22;
        return;
    L22:
        if (this.B == false) goto L26;
        InFlowActivityLayout r5 = this.q;
        if (r5 == null) goto L31;
        r5.stopCountDown();
        return;
    L31:
        return;
    L26:
        AbsActivitiesBarView r6 = this.p;
        if (r6 == null) goto L33;
        r6.stopCountDown();
        return;
    L33:
        return;
    L7:
        if (r4.getActivityType() == 2) goto L20;
        if (r4.getActivityType() == 3) goto L20;
        if (r4.getActivityType() == 6) goto L20;
        if (r4.getActivityType() == 7) goto L20;
        if (r4.getActivityType() == 8) goto L20;
        if (r4.getActivityType() == 13) goto L20;
    L19:
        r1 = false;
        goto L20
    }

    public final void f(PromotionProductStruct r13) {
        PromotionProductBaseStruct r0 = r13.getBaseInfo();
        ViewGroup.LayoutParams r2 = null;
        if (r0 == null) goto L7;
        List r1 = r0.getImages();
        if (r1 == null) goto L7;
        ECUrlModel r3 = (ECUrlModel) CollectionsKt.getOrNull(r1, 0);
    L9:
        if (r3 == null) goto L74;
        PromotionProductBaseStruct r5 = r13.getBaseInfo();
        if (r5 == null) goto L15;
        ProductSpecInfoStruct r6 = r5.getSpecInfo();
        if (r6 == null) goto L15;
        List r7 = r6.getSpecList();
    L16:
        List r8 = r7;
        if (r8 != null) goto L19;
    L22:
        boolean r9 = true;
    L23:
        if (r9 == true) goto L69;
        PromotionProductBaseStruct r10 = r13.getBaseInfo();
        if (r10 == null) goto L31;
        ProductSpecInfoStruct r11 = r10.getSpecInfo();
        if (r11 == null) goto L31;
        List r12 = r11.getSpecList();
        if (r12 == null) goto L31;
        int r14 = r12.size();
    L32:
        if (r14 <= 1) goto L69;
        f1 r15 = new f1();
        r15.a = "sku";
        r15.b = "InflowSkuWidget";
        rd3.a r16 = this.u;
        if (r16 == null) goto L37;
        String r17 = r16.d;
    L38:
        r15.c = r17;
        r15.post(null, null);
        InflowSkuWidget r18 = this.c;
        rd3.a r19 = this.u;
        if (r18 == null) goto L65;
        if (r19 == null) goto L65;
        PromotionProductBaseStruct r110 = r13.getBaseInfo();
        if (r110 == null) goto L44;
        ProductSpecInfoStruct r111 = r110.getSpecInfo();
    L45:
        BaseCardHeaderView r20 = this.a;
        MutableLiveData<SpecDetail> r21 = this.L;
        Intrinsics.checkNotNullParameter(r3, "mainImg");
        Intrinsics.checkNotNullParameter(r21, "specDetailLiveData");
        Intrinsics.checkNotNullParameter(r19, "anchorInflowFeedItem");
        if (r111 == null) goto L65;
        if (r20 == null) goto L65;
        r18.d = r21;
        r18.c = r20.getVideoProductFeedBanner();
        r18.g = "main_pic";
        InflowSkuThumbnail r22 = r18.a;
        if (r22 == null) goto L53;
        ImageExtensionsKt.v(r22.getImageView(), r3, null, 8190);
        r22.a();
        r22.setTag("main_pic");
        r22.c(true);
        r22.setOnClickListener(new n(r22, r18, r19));
    L53:
        List r4 = r111.getSpecList();
        if (r4 == null) goto L56;
        int r23 = r4.size();
    L57:
        TextView r24 = r18.b;
        if (r24 != null) goto L60;
    L64:
        r18.f.a = r111.getSpecList();
        InflowSkuAdapter r112 = r18.f;
        r112.b = r19;
        r112.c = r18;
        r112.notifyDataSetChanged();
        goto L65
    L60:
        if (r23 >= 10) goto L62;
        StringBuilder r25 = new StringBuilder();
        r25.append(r23);
        r25.append(" 款");
    L63:
        r24.setText(r25.toString());
        goto L64
    L62:
        r25 = new StringBuilder();
        r25.append(r23);
        r25.append(27454);
        goto L63
    L56:
        r23 = 0;
        goto L57
    L44:
        r111 = null;
    L65:
        InflowSkuWidget r113 = this.c;
        if (r113 == null) goto L68;
        r113.setVisibility(0);
    L68:
        FeedProductEventTracker r114 = FeedProductEventTracker.a;
        Context r26 = getContext();
        rd3.a r27 = this.u;
        r114.getClass();
        Single.fromCallable(new k0(2, r26, CollectionsKt.listOf(new String[]{PdpOpenThirdParam.KEY_PRODUCT_ID, "commodity_id", "commodity_type"}), r27)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
        Unit r115 = Unit.INSTANCE;
    L73:
        if (r115 == null) goto L74;
    L77:
        InflowSkuWidget r116 = this.c;
        if (r116 != null) goto L80;
    L97:
        InflowSkuWidget r117 = this.c;
        if (r117 != null) goto L100;
        return;
    L100:
        if (r117.getVisibility() != 0) goto L116;
        AbsActivitiesBarView r118 = this.p;
        if (r118 != null) goto L104;
        return;
    L104:
        if (r118.getVisibility() != 0) goto L118;
        InflowSkuWidget r119 = this.c;
        if (r119 == null) goto L119;
        ViewGroup.LayoutParams r28 = r119.getLayoutParams();
        if ((r28 instanceof ViewGroup.MarginLayoutParams) == false) goto L111;
        r2 = r28;
    L111:
        ViewGroup.MarginLayoutParams r29 = (ViewGroup.MarginLayoutParams) r2;
        if (r29 == null) goto L120;
        r29.topMargin = com.bytedance.android.shopping.extensions.b.b(4);
        r29.bottomMargin = com.bytedance.android.shopping.extensions.b.b(2);
        r119.setLayoutParams(r29);
        return;
    L120:
        return;
    L119:
        return;
    L118:
        return;
    L116:
        return;
    L80:
        if (r116.getVisibility() != 0) goto L97;
        if (this.e.getVisibility() != 0) goto L97;
        View r120 = this.e;
        ViewGroup.LayoutParams r30 = r120.getLayoutParams();
        if ((r30 instanceof ViewGroup.MarginLayoutParams) == true) goto L86;
        r30 = null;
    L86:
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
        if (r31 == null) goto L89;
        r31.topMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r120.setLayoutParams(r31);
    L89:
        InflowSkuWidget r121 = this.c;
        if (r121 == null) goto L97;
        ViewGroup.LayoutParams r32 = r121.getLayoutParams();
        if ((r32 instanceof ViewGroup.MarginLayoutParams) == true) goto L94;
        r32 = null;
    L94:
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) r32;
        if (r33 == null) goto L97;
        r33.topMargin = com.bytedance.android.shopping.extensions.b.b(8);
        r121.setLayoutParams(r33);
        goto L97
    L37:
        r17 = null;
    L31:
        r14 = 0;
    L69:
        InflowSkuWidget r122 = this.c;
        if (r122 == null) goto L72;
        r122.setVisibility(8);
        r115 = Unit.INSTANCE;
        goto L73
    L72:
        r115 = null;
        goto L73
    L19:
        if (r8.isEmpty() == true) goto L22;
        r9 = false;
    L15:
        r7 = null;
    L74:
        InflowSkuWidget r123 = this.c;
        if (r123 == null) goto L77;
        r123.setVisibility(8);
        Unit r124 = Unit.INSTANCE;
    L7:
        r3 = null;
        goto L9
    }

    public final void h(rd3.a r4) {
        BaseCardHeaderView r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L7;
        VideoProductFeedBanner r2 = r0.getVideoProductFeedBanner();
        if (r2 == null) goto L7;
        RecyclerView.Adapter<BannerHolder> r3 = r2.getAdapter();
    L9:
        if ((r3 instanceof MainCardImageBannerAdapter) == true) goto L11;
        r3 = null;
    L11:
        MainCardImageBannerAdapter r5 = (MainCardImageBannerAdapter) r3;
        if (r5 == null) goto L30;
        r5.b = r4;
        if (r4 == null) goto L17;
        r1 = r4.o;
    L17:
        if (r1 != null) goto L19;
    L22:
        boolean r6 = true;
    L23:
        if (r6 == true) goto L31;
        BaseCardHeaderView r7 = this.a;
        if (r7 == null) goto L32;
        VideoProductFeedBanner r8 = r7.getVideoProductFeedBanner();
        if (r8 == null) goto L33;
        r8.b.notifyItemChanged(0, "updateGoodPriceStrip");
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L19:
        if (r1.length() == 0) goto L22;
        r6 = false;
        goto L23
    L30:
        return;
    L7:
        r3 = null;
        goto L9
    }

    public final void setAnchorInflowFeedItem(rd3.a r1) {
        this.u = r1;
    }

    public final void setBarContainer(TopRoundRelativeLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.m = r2;
    }

    public final void setBottomBarView(InflowFeedBottomBarView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k = r2;
    }

    public final void setCardHeaderView(BaseCardHeaderView r1) {
        this.a = r1;
    }

    public final void setDetailRootView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.n = r2;
    }

    public final void setDiscountInfoContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.x = r2;
    }

    public final void setExtraInfoContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    public final void setHeaderViewContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setPriceAndSalesView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setPriceContainer(TopRoundRelativeLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setProductTitleDivider(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public final void setProductTitleView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void setRightSafeguardInfoView(InflowFeedServiceView r1) {
        this.K = r1;
    }

    public final void setSameProductEntrance(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public final void setSkuProductDetailInfo(MutableLiveData<SkuProductDetailInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.M = r2;
    }

    public final void setSkuWidget(InflowSkuWidget r1) {
        this.c = r1;
    }

    public final void setSpecDetailLiveData(MutableLiveData<SpecDetail> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.L = r2;
    }

    public final void setTransitionFactor(float r3) {
        Drawable r0 = this.n.getBackground();
        if ((r0 instanceof com.bytedance.android.shopping.feed.widget.d) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.shopping.feed.widget.d r1 = (com.bytedance.android.shopping.feed.widget.d) r0;
        if (r1 == null) goto L9;
        r1.a(r3);
        return;
    }

    public final void setViewModel(ProductFeedViewModel r1) {
        this.s = r1;
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
    public void b(final Function3<? super View, ? super String, ? super String, Unit> r26, final rd3.a r27) {
        Intrinsics.checkNotNullParameter(r26, "detailOnClickListener");
        this.u = r27;
        if (r27 == null) goto L648;
        final ProductFeedViewModel r5 = r27.c;
        if (r5 == null) goto L652;
        InnerFlowPageStyleDTO r1 = r5.getInnerFlowPageStyle();
        if (r1 == null) goto L12;
        PageStyle r2 = r1.getPageStyle();
        if (r2 == null) goto L12;
        Integer r3 = r2.getCardShadow();
    L14:
        if (r3 != null) goto L17;
    L19:
        this.G = r26;
        Context r4 = getContext();
        if ((r4 instanceof LifecycleOwner) == true) goto L22;
        r4 = null;
    L22:
        LifecycleOwner r6 = (LifecycleOwner) r4;
        if (r6 == null) goto L25;
        r5.getGestureGuideLiveData().observe(r6, this.N);
        this.L.observe(r6, new d(this, r5, r27));
        this.M.observe(r6, new e(this, r27));
    L25:
        Promotion r7 = r27.f();
        if (r7 == null) goto L649;
        PromotionProductStruct r8 = r7.getPromotionInfo();
        if (r8 == null) goto L650;
        boolean r9 = r27.e;
        InnerFlowPageStyleDTO r10 = r5.getInnerFlowPageStyle();
        if (r10 == null) goto L36;
        PageStyle r11 = r10.getPageStyle();
        if (r11 == null) goto L36;
        Integer r12 = r11.getShowCount();
        if (r12 == null) goto L36;
        int r13 = r12.intValue();
    L37:
        BaseCardHeaderView r14 = this.a;
        if (r14 == null) goto L47;
        v r15 = new v(d63.m.b(r8), r27);
        InflowSkuWidget r16 = this.c;
        Integer r17 = Integer.valueOf(r13);
        Intrinsics.checkNotNullParameter(r15, "data");
        Intrinsics.checkNotNullParameter(r26, "detailOnClickListener");
        com.bytedance.android.shopping.feed.banner.d r0 = r14.k;
        if (r17 != null) goto L43;
    L45:
        boolean r18 = false;
    L46:
        r0.a = r18;
        r14.a(r15, r26);
        r14.b.setSkuWidget(r16);
        goto L47
    L43:
        if (r17.intValue() != 1) goto L45;
        r18 = true;
    L47:
        this.l.removeAllViews();
        this.m.removeAllViews();
        TopRoundRelativeLayout r19 = this.m;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        if ((r20 instanceof ViewGroup.MarginLayoutParams) == true) goto L50;
        r20 = null;
    L50:
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r20;
        if (r21 == null) goto L53;
        r21.topMargin = 0;
        r19.setLayoutParams(r21);
    L53:
        this.r = r8;
        this.s = r5;
        if (this.B == false) goto L277;
        PromotionProductPrivilegesStruct r22 = r8.getPrivilegeInfo();
        if (r22 == null) goto L84;
        PromotionProductActivitiesStruct r23 = r22.getActivities();
        if (r23 == null) goto L84;
        CommonGirdleStructV2 r24 = r23.getCommonGirdleV2();
        if (r24 == null) goto L84;
        HashMap<String, Queue<View>> r110 = com.bytedance.android.shopping.feed.view.i.a;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L64;
        boolean r111 = true;
    L65:
        if (r111 == false) goto L83;
        Queue<View> r112 = com.bytedance.android.shopping.feed.view.i.a.get(InFlowActivityLayout.class.getName());
        if (r112 == null) goto L69;
        View r113 = r112.poll();
    L71:
        if ((r113 instanceof InFlowActivityLayout) == true) goto L73;
        r113 = null;
    L73:
        InFlowActivityLayout r114 = (InFlowActivityLayout) r113;
        if (r114 != null) goto L76;
        r114 = new InFlowActivityLayout(getContext(), null, 6, 0);
    L76:
        this.q = r114;
        r114.c(r24);
        this.m.addView(this.q, this.E);
        TopRoundRelativeLayout r25 = this.m;
        ViewGroup.LayoutParams r115 = r25.getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == true) goto L79;
        r115 = null;
    L79:
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
        if (r116 == null) goto L84;
        r116.topMargin = com.bytedance.android.shopping.extensions.b.b(-16);
        r25.setLayoutParams(r116);
        goto L84
    L69:
        r113 = null;
        goto L71
    L83:
        throw new IllegalStateException("only main thread can touch");
    L64:
        r111 = false;
    L84:
        this.e.setVisibility(0);
        if (ld3.c.g() == true) goto L87;
    L89:
        PromotionProductPriceStruct r28 = r8.getProductPrice();
        if (r28 == null) goto L92;
        String r29 = r28.getPriceLowLabel();
    L94:
        if (cg4.a.a(r29) == false) goto L96;
        int r30 = 2;
    L112:
        if (ld3.c.g() == false) goto L120;
        if (r30 != 3) goto L120;
        View r31 = this.e;
        ViewGroup.LayoutParams r117 = r31.getLayoutParams();
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == true) goto L117;
        r117 = null;
    L117:
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r117;
        if (r118 == null) goto L120;
        r118.bottomMargin = com.bytedance.android.shopping.extensions.b.b(2);
        r31.setLayoutParams(r118);
    L120:
        View r32 = this.e;
        if ((r32 instanceof InFlowPriceAreaView) == true) goto L123;
        r32 = null;
    L123:
        InFlowPriceAreaView r33 = (InFlowPriceAreaView) r32;
        if (r33 == null) goto L126;
        r33.setStyle(r30);
    L126:
        View r34 = this.e;
        if ((r34 instanceof InFlowPriceAreaView) == true) goto L129;
        r34 = null;
    L129:
        InFlowPriceAreaView r35 = (InFlowPriceAreaView) r34;
        if (r35 == null) goto L276;
        Intrinsics.checkNotNullParameter(r8, "promotionProductStruct");
        Integer r36 = r35.g;
        if (r36 != null) goto L135;
    L139:
        if (r36 != null) goto L142;
    L146:
        if (r36 != null) goto L149;
    L177:
        if (r36 != null) goto L180;
    L247:
        PromotionProductBaseStruct r37 = r8.getBaseInfo();
        if (r37 == null) goto L250;
        SalesInfoStruct r38 = r37.getSalesInfo();
    L251:
        if (r38 == null) goto L260;
        String r39 = r38.getText();
        if (r39 == null) goto L260;
        if (com.bytedance.android.shopping.extensions.k.c(r39) == true) goto L258;
        r39 = null;
    L258:
        if (r39 == null) goto L260;
        r35.b.setText(r39);
        r35.b.setVisibility(0);
        Unit r40 = Unit.INSTANCE;
    L274:
        if (r40 != null) goto L276;
        r35.b.setVisibility(8);
        Unit r41 = Unit.INSTANCE;
    L260:
        PromotionProductBaseStruct r42 = r8.getBaseInfo();
        if (r42 == null) goto L273;
        Long r43 = r42.getSales();
        if (r43 == null) goto L273;
        if (r43.longValue() <= 0) goto L267;
        boolean r44 = true;
    L268:
        if (r44 == true) goto L271;
        r43 = null;
    L271:
        if (r43 == null) goto L273;
        r35.b.setText(th.a.h(r35.getContext(), 2131913958, new Object[]{com.bytedance.android.shopping.utils.k0.a(r43.longValue())}));
        r35.b.setVisibility(0);
        r40 = Unit.INSTANCE;
        goto L274
    L267:
        r44 = false;
    L273:
        r40 = null;
        goto L274
    L250:
        r38 = null;
        goto L251
    L180:
        if (r36.intValue() != 3) goto L247;
        PromotionProductPriceStructV2 r45 = r8.getProductPriceV2();
        if (r45 == null) goto L247;
        final InFlowPriceViewV2 r119 = r35.f;
        if (r119 == null) goto L247;
        Intrinsics.checkNotNullParameter(r45, "promotionProductStruct");
        r119.e = r45;
        PriceV2 r46 = r45.getMainPrice();
        PromotionProductPriceStructV2 r47 = r119.e;
        if (r47 == null) goto L188;
        final PriceV2 r48 = r47.getSubPrice();
    L189:
        if (r46 == null) goto L193;
        Long r49 = r46.getMinPrice();
        if (r49 == null) goto L193;
        final long r120 = r49.longValue();
    L194:
        if (r48 == null) goto L198;
        Long r50 = r48.getMinPrice();
        if (r50 == null) goto L198;
        long r210 = r50.longValue();
    L200:
        if (r120 <= 0) goto L246;
        PriceView r51 = r119.a;
        if (r51 == null) goto L205;
        r51.C(new BasePriceViewV2$updatePrice$1(r119, r120));
    L205:
        if (ECAppInfoService.e.f() == true) goto L212;
        PriceView r52 = r119.a;
        if (r52 == null) goto L209;
        ViewGroup.LayoutParams r121 = r52.getLayoutParams();
        r121.height = com.bytedance.android.shopping.extensions.b.a(26);
        r52.setLayoutParams(r121);
    L209:
        RelativeLayout r53 = r119.d;
        if (r53 == null) goto L212;
        ViewGroup.LayoutParams r122 = r53.getLayoutParams();
        r122.height = com.bytedance.android.shopping.extensions.b.a(26);
        r53.setLayoutParams(r122);
    L212:
        PromotionProductPriceStructV2 r54 = r119.e;
        if (r54 == null) goto L217;
        PriceDescription r55 = r54.getPriceDescription();
        if (r55 == null) goto L217;
        String r56 = r55.getText();
    L219:
        if (TextUtils.isEmpty(r56) == true) goto L229;
        PriceView r57 = r119.b;
        if (r57 == null) goto L223;
        r57.setVisibility(8);
    L223:
        TextView r58 = r119.c;
        if (r58 == null) goto L226;
        r58.setVisibility(0);
    L226:
        TextView r59 = r119.c;
        if (r59 == null) goto L247;
        r59.setText(r56);
        goto L247
    L229:
        final long r123 = r210;
        if (r123 <= 0) goto L240;
        PriceView r60 = r119.b;
        if (r60 == null) goto L234;
        r60.setVisibility(0);
    L234:
        TextView r61 = r119.c;
        if (r61 == null) goto L237;
        r61.setVisibility(8);
    L237:
        PriceView r62 = r119.b;
        if (r62 == null) goto L247;
        r62.C(new BasePriceViewV2$updatePrice$4(r119, r123, r48));
        goto L247
    L240:
        PriceView r63 = r119.b;
        if (r63 == null) goto L243;
        r63.setVisibility(8);
    L243:
        TextView r64 = r119.c;
        if (r64 == null) goto L247;
        r64.setVisibility(8);
    L217:
        r56 = null;
        goto L219
    L246:
        r119.setVisibility(8);
    L198:
        r210 = 0;
    L193:
        r120 = 0;
        goto L194
    L188:
        r48 = null;
        goto L189
    L149:
        if (r36.intValue() != 2) goto L177;
        final InFlowPriceViewWithLowPrice r65 = r35.e;
        if (r65 == null) goto L247;
        Intrinsics.checkNotNullParameter(r8, "promotionProductStruct");
        r65.d = r8;
        PromotionProductPriceStruct r66 = r8.getProductPrice();
        r65.c = r66;
        int r124 = com.bytedance.android.shopping.feed.utils.c.a;
        Long r67 = com.bytedance.android.shopping.feed.utils.c.e(r66);
        if (r67 == null) goto L155;
        long r125 = r67.longValue();
    L156:
        Long r68 = com.bytedance.android.shopping.feed.utils.c.b(r65.c).getMinPrice();
        if (r68 == null) goto L159;
        final long r126 = r68.longValue();
        long r127 = r125;
    L160:
        r65.a.setVisibility(0);
        if (r126 <= 0) goto L164;
        r65.a.C(new InFlowPriceViewWithLowPrice$updatePrice$1(r65, r126));
    L167:
        PromotionProductStruct r69 = r65.d;
        if (r69 == null) goto L172;
        PromotionProductPriceStruct r70 = r69.getProductPrice();
        if (r70 == null) goto L172;
        String r71 = r70.getPriceLowLabel();
    L174:
        if (com.bytedance.android.shopping.extensions.k.c(r71) == false) goto L176;
        r65.b.setText(r71);
        r65.b.setVisibility(0);
        goto L247
    L176:
        r65.b.setVisibility(8);
    L172:
        r71 = null;
        goto L174
    L164:
        if (r127 <= 0) goto L166;
        final long r128 = r127;
        r65.a.C(new InFlowPriceViewWithLowPrice$updatePrice$2(r65, r128));
        goto L167
    L166:
        r65.setVisibility(8);
        goto L167
    L159:
        r127 = r125;
        r126 = 0;
        goto L160
    L155:
        r125 = 0;
        goto L156
    L142:
        if (r36.intValue() != 1) goto L146;
        InFlowPriceViewV1 r72 = r35.c;
        if (r72 == null) goto L247;
        Intrinsics.checkNotNullParameter(r8, "promotionProductStruct");
        r72.b = r8;
        r72.d = r8.getProductPrice();
        r72.b();
        goto L247
    L135:
        if (r36.intValue() != 0) goto L139;
        InFlowPriceViewV0 r73 = r35.d;
        if (r73 == null) goto L247;
        Intrinsics.checkNotNullParameter(r8, "promotionProductStruct");
        r73.f = r8;
        r73.e = r8.getProductPrice();
        r73.a();
    L276:
        String r74 = "only main thread can touch";
        int r129 = 8;
    L415:
        f(r8);
        this.x.removeAllViews();
        CouponGroupLayout r75 = com.bytedance.android.shopping.feed.view.i.a(r8);
        if (r75 != null) goto L418;
        com.bytedance.android.shopping.feed.view.q.a r76 = com.bytedance.android.shopping.feed.view.q.b;
        Context r77 = getContext();
        r76.getClass();
        r75 = com.bytedance.android.shopping.feed.view.q.a.b(r8, r77);
    L418:
        if (r75 == null) goto L420;
        this.x.addView(r75);
        this.x.setVisibility(0);
    L421:
        Lazy r78 = ECAppInfoService.a;
        if (ECAppInfoService.k() == false) goto L436;
        Promotion r79 = r27.f();
        if (r79 == null) goto L432;
        PromotionProductStruct r80 = r79.getPromotionInfo();
        if (r80 == null) goto L432;
        PromotionProductPrivilegesStruct r81 = r80.getPrivilegeInfo();
        if (r81 == null) goto L432;
        PromotionProductCouponsStruct r82 = r81.getCoupons();
        if (r82 == null) goto L432;
        ExchangeCoupons r84 = r82.getExchangeCoupons();
    L433:
        if (r84 != null) goto L435;
        this.z.setVisibility(r129);
        goto L436
    L435:
        this.z.setVisibility(0);
        this.z.setOnClickListener(new f(r84, this, r27, r26));
        this.z.b(r84, this);
    L432:
        r84 = null;
    L436:
        PromotionProductPrivilegesStruct r85 = r8.getPrivilegeInfo();
        if (r85 == null) goto L441;
        PromotionProductCouponsStruct r86 = r85.getCoupons();
        if (r86 == null) goto L441;
        MarketingTip r87 = r86.getMarketingTip();
    L442:
        c(r87);
        PromotionProductPrivilegesStruct r88 = r8.getPrivilegeInfo();
        if (r88 == null) goto L457;
        PromotionProductCouponsStruct r89 = r88.getCoupons();
        if (r89 == null) goto L457;
        MarketingBanner r90 = r89.getMarketingBanner();
        if (r90 == null) goto L457;
        this.A.setVisibility(0);
        MarketingBannerLayout r91 = this.A;
        if ((this instanceof MainProductCardDetailView) == true) goto L451;
        BaseCardDetailView r130 = null;
    L453:
        if (((MainProductCardDetailView) r130) == null) goto L455;
        boolean r131 = true;
    L456:
        r91.a(r90, r131);
    L459:
        if (this.B == false) goto L494;
        View r92 = this.f;
        if ((r92 instanceof InFlowCardTitleView) == true) goto L463;
        r92 = null;
    L463:
        InFlowCardTitleView r132 = (InFlowCardTitleView) r92;
        if (r132 == null) goto L512;
        PromotionProductBaseStruct r94 = r8.getBaseInfo();
        if (r94 == null) goto L468;
        String r133 = r94.getTitle();
    L469:
        PromotionProductPrivilegesStruct r95 = r8.getPrivilegeInfo();
        if (r95 == null) goto L476;
        PromotionProductActivitiesStruct r96 = r95.getActivities();
        if (r96 == null) goto L476;
        PromotionMarketFloor r97 = r96.getPlatformTextActivity();
        if (r97 == null) goto L476;
        ECUrlModel r134 = r97.getIcon();
    L477:
        PromotionProductPrivilegesStruct r98 = r8.getPrivilegeInfo();
        if (r98 == null) goto L482;
        List r99 = r98.getBanners();
        if (r99 == null) goto L482;
        PromotionProductBannerStruct r135 = (PromotionProductBannerStruct) CollectionsKt.firstOrNull(r99);
    L483:
        PromotionProductExtraStruct r100 = r8.getExtraInfo();
        if (r100 == null) goto L486;
        String r101 = r100.getTitleSearchSchema();
    L487:
        if (r101 != null) goto L489;
    L492:
        boolean r136 = true;
    L493:
        r132.a(r133, r134, r135, !r136, new g(this, r27, r26));
        goto L512
    L489:
        if (r101.length() == 0) goto L492;
        r136 = false;
        goto L493
    L486:
        r101 = null;
    L482:
        r135 = null;
    L476:
        r134 = null;
        goto L477
    L468:
        r133 = null;
    L512:
        Long r137 = null;
    L513:
        com.bytedance.android.ec.core.widget.f.c(this.f, r137, "bind_product_flow_card", new BaseCardDetailView$bind$$inlined$let$lambda$5(this, r27, r5, r26), 1);
        this.i.removeAllViews();
        this.J.removeAllViews();
        View r102 = com.bytedance.android.shopping.feed.view.i.b(r8, r5.m907getAnchorV3Param(), r5, r27);
        if (r102 != null) goto L516;
        com.bytedance.android.shopping.feed.view.q.a r103 = com.bytedance.android.shopping.feed.view.q.b;
        Context r104 = getContext();
        AnchorV3Param r138 = r5.m907getAnchorV3Param();
        r103.getClass();
        r102 = com.bytedance.android.shopping.feed.view.q.a.a(r8, r104, r138, r5, r27);
    L516:
        this.w = r102;
        if ((r102 instanceof AnchorV3LogisticsLayout) == false) goto L530;
        PromotionProductPrivilegesStruct r105 = r8.getPrivilegeInfo();
        if (r105 == null) goto L530;
        PromotionProductLogisticsStruct r106 = r105.getLogistics();
        if (r106 == null) goto L530;
        String r107 = r106.getExtraLog();
        if (r107 == null) goto L530;
        JSONObject r108 = com.bytedance.android.shopping.extensions.k.w(r107);
        if (r108 == null) goto L530;
        String r109 = r108.optString("product_promise_info");
        if (r109 == null) goto L530;
        r27.k.put("product_promise_info", r109);
    L530:
        if (this.w == null) goto L608;
        this.i.setVisibility(0);
        this.i.addView(this.w, this.C);
        if (this.B == false) goto L550;
        View r139 = this.w;
        if ((r139 instanceof InFlowSellingPointAreaView) == true) goto L536;
        View r140 = null;
    L537:
        InFlowSellingPointAreaView r141 = (InFlowSellingPointAreaView) r140;
        if (r141 == null) goto L549;
        if (r141.b != true) goto L549;
        if ((r139 instanceof InFlowRankLayout) == true) goto L545;
        r139 = null;
    L545:
        InFlowRankLayout r142 = (InFlowRankLayout) r139;
        if (r142 == null) goto L556;
        r142.setOnClickCallBack(new BaseCardDetailView$bind$$inlined$let$lambda$6(this, r27, r5, r26));
    L556:
        View r143 = this.w;
        if ((r143 instanceof InFlowSellingPointAreaView) == false) goto L559;
    L606:
        int r144 = 6;
    L607:
        int r145 = 0;
    L609:
        InflowFeedBottomBarView r146 = this.k;
        MutableLiveData<SkuProductDetailInfo> r147 = this.M;
        BaseCardHeaderView r148 = this.a;
        if (r148 == null) goto L612;
        VideoProductFeedBanner r149 = r148.getVideoProductFeedBanner();
    L613:
        r146.a(r27, r147, r149);
        this.j.removeAllViews();
        if (r27.b() == false) goto L633;
        f1 r150 = new f1();
        r150.a = "comment";
        r150.b = "InflowFeedCommentView";
        r150.c = r27.d;
        r150.post(null, null);
        this.j.setVisibility(r145);
        HashMap<String, Queue<View>> r151 = com.bytedance.android.shopping.feed.view.i.a;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L618;
        boolean r152 = true;
    L619:
        if (r152 == false) goto L632;
        Queue<View> r153 = com.bytedance.android.shopping.feed.view.i.a.get(InflowFeedCommentView.class.getName());
        if (r153 == null) goto L623;
        View r154 = r153.poll();
    L625:
        if ((r154 instanceof InflowFeedCommentView) == true) goto L627;
        r154 = null;
    L627:
        InflowFeedCommentView r155 = (InflowFeedCommentView) r154;
        if (r155 != null) goto L630;
        r155 = new InflowFeedCommentView(getContext(), null, r144, r145);
        r155.b(r27);
        Unit r156 = Unit.INSTANCE;
    L630:
        this.v = r155;
        this.j.addView(r155);
        return;
    L623:
        r154 = null;
        goto L625
    L632:
        throw new IllegalStateException(r74);
    L618:
        r152 = false;
        goto L619
    L633:
        this.j.setVisibility(r129);
        return;
    L612:
        r149 = null;
        goto L613
    L559:
        if ((r143 instanceof InflowFeedServiceView) == true) goto L606;
        if ((r143 instanceof WindowEntryInfoView) == true) goto L606;
        if ((r143 instanceof AnchorV3LogisticsLayout) == true) goto L606;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L567;
        boolean r157 = true;
    L568:
        if (r157 == false) goto L605;
        Queue<View> r158 = com.bytedance.android.shopping.feed.view.i.a.get(InflowFeedServiceView.class.getName());
        if (r158 == null) goto L572;
        View r159 = r158.poll();
    L574:
        if ((r159 instanceof InflowFeedServiceView) == true) goto L576;
        r159 = null;
    L576:
        InflowFeedServiceView r160 = (InflowFeedServiceView) r159;
        if (r160 != null) goto L579;
        r144 = 6;
        r160 = new InflowFeedServiceView(getContext(), null, 6, 0);
    L580:
        this.K = r160;
        r160.setTextColor(ag4.a.b(2131101196));
        r160.setTextSizeDP(11.0f);
        PromotionProductPrivilegesStruct r161 = r8.getPrivilegeInfo();
        if (r161 == null) goto L600;
        List r162 = r161.getServices();
        if (r162 == null) goto L600;
        ArrayList r163 = new ArrayList();
        Iterator r164 = r162.iterator();
    L586:
        if (r164.hasNext() == false) goto L596;
        Object r165 = r164.next();
        Integer r166 = ((PromotionProductServiceStruct) r165).getServiceType();
        if (r166 != null) goto L591;
    L593:
        boolean r167 = false;
    L594:
        if (r167 == true) goto L586;
        r163.add(r165);
        goto L586
    L591:
        if (r166.intValue() != 11) goto L593;
        r167 = true;
        goto L594
    L596:
        ArrayList r168 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r163, 10));
        Iterator r169 = r163.iterator();
    L598:
        if (r169.hasNext() == false) goto L601;
        r168.add(((PromotionProductServiceStruct) r169.next()).getTitle());
    L601:
        r160.b(r168);
        InflowFeedServiceView r170 = this.K;
        if (r170 == null) goto L607;
        this.J.addView(r170, this.H);
        this.i.addView(this.J, this.I);
        r145 = 0;
        r170.post(new h(r170, r9, this, r5, r26));
    L600:
        r168 = null;
        goto L601
    L579:
        r144 = 6;
        goto L580
    L572:
        r159 = null;
        goto L574
    L605:
        throw new IllegalStateException(r74);
    L567:
        r157 = false;
    L549:
        this.i.setVisibility(r129);
        goto L556
    L536:
        r140 = r139;
        goto L537
    L550:
        View r171 = this.w;
        if ((r171 instanceof AnchorV3RankInfoLayout) == true) goto L553;
        r171 = null;
    L553:
        AnchorV3RankInfoLayout r172 = (AnchorV3RankInfoLayout) r171;
        if (r172 == null) goto L556;
        r172.setOnClickCallBack(new BaseCardDetailView$bind$$inlined$let$lambda$7(this, r27, r5, r26));
        goto L556
    L608:
        r144 = 6;
        r145 = 0;
        this.i.setVisibility(r129);
        goto L609
    L494:
        View r173 = this.f;
        if ((r173 instanceof ProductFlowCardTitleView) == true) goto L497;
        r173 = null;
    L497:
        ProductFlowCardTitleView r174 = (ProductFlowCardTitleView) r173;
        if (r174 == null) goto L512;
        PromotionProductBaseStruct r175 = r8.getBaseInfo();
        if (r175 == null) goto L502;
        String r176 = r175.getTitle();
    L503:
        PromotionProductPrivilegesStruct r177 = r8.getPrivilegeInfo();
        if (r177 == null) goto L510;
        PromotionProductActivitiesStruct r178 = r177.getActivities();
        if (r178 == null) goto L510;
        PromotionMarketFloor r179 = r178.getPlatformTextActivity();
        if (r179 == null) goto L510;
        ECUrlModel r180 = r179.getIcon();
    L511:
        int r181 = ProductFlowCardTitleView.d;
        r137 = null;
        r174.a(r176, r180, null);
    L510:
        r180 = null;
        goto L511
    L502:
        r176 = null;
        goto L503
    L455:
        r131 = false;
        goto L456
    L451:
        r130 = this;
    L457:
        this.A.setVisibility(r129);
    L441:
        r87 = null;
        goto L442
    L420:
        this.x.setVisibility(r129);
        goto L421
    L96:
        int r182 = ld3.d.a;
        int r183 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r184 = 0;
        Result.Companion r185 = Result.Companion;     // Catch: Throwable -> L101
        jj4.b r186 = jj4.b.b;     // Catch: Throwable -> L101
        Object r187 = jj4.a.a("video_inner_new_price_express", Integer.class, r184, false);     // Catch: Throwable -> L101
        if (r187 != null) goto L108;
        Intrinsics.throwNpe();     // Catch: Throwable -> L101
    L108:
        if (ld3.d.e(((Number) r187).intValue()) == false) goto L110;
        r30 = 1;
        goto L112
    L110:
        r30 = 0;
    L101:
        th = move-exception;
        Result.Companion r188 = Result.Companion;
        Object r189 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r189) == true) goto L106;
        r184 = r189;
    L106:
        r187 = r184;
        goto L108
    L92:
        r29 = null;
        goto L94
    L87:
        if (r8.getProductPriceV2() == null) goto L89;
        r30 = 3;
        goto L112
    L277:
        ActivityVO r190 = f53.a.c(r8);
        if (r190.getCanShowActivityBarStyle() == true) goto L280;
    L308:
        r74 = "only main thread can touch";
        r129 = 8;
        PromotionDepositPresaleActivity r191 = r190.getDepositPresaleActivity();
        if (r191 == null) goto L325;
        if (com.bytedance.android.ec.model.n.b(r191) != true) goto L325;
        if (r190.getNeedShowActivityBarStyle() == false) goto L325;
        if (a53.a.a() != 1) goto L325;
        this.p = new PresaleActivityBarLayout(getContext(), null, 6, 0);
        this.e.setVisibility(8);
        this.e.setOnClickListener(null);
        AbsActivitiesBarView r192 = this.p;
        if (r192 == null) goto L323;
        PromotionProductBaseStruct r193 = r8.getBaseInfo();
        if (r193 == null) goto L321;
        Long r194 = r193.getSales();
    L322:
        r192.f(r190, r194, false, r5.m907getAnchorV3Param(), r8, true);
        goto L323
    L321:
        r194 = null;
    L323:
        this.m.addView(this.p, this.E);
    L325:
        if (r190.isPreSeckillActivity() == false) goto L331;
        PromotionProductBaseStruct r195 = r8.getBaseInfo();
        if (r195 != null) goto L329;
    L330:
        boolean r196 = true;
    L332:
        boolean r197 = r190.isDepositActivity();
        if (r196 == false) goto L352;
        HashMap<String, Queue<View>> r198 = com.bytedance.android.shopping.feed.view.i.a;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L337;
        boolean r199 = true;
    L338:
        if (r199 == false) goto L351;
        Queue<View> r200 = com.bytedance.android.shopping.feed.view.i.a.get(AnchorV3PreSecKillLayout.class.getName());
        if (r200 == null) goto L342;
        View r201 = r200.poll();
    L344:
        if ((r201 instanceof AnchorV3PreSecKillLayout) == true) goto L346;
        r201 = null;
    L346:
        AnchorV3PreSecKillLayout r202 = (AnchorV3PreSecKillLayout) r201;
        if (r202 != null) goto L349;
        r202 = new AnchorV3PreSecKillLayout(getContext(), null, 6, 0);
    L349:
        this.t = r202;
        r202.setSecKillInfo(r8);
        this.l.addView(this.t, this.D);
    L391:
        this.e.setVisibility(0);
        PromotionProductPrivilegesStruct r203 = r8.getPrivilegeInfo();
        if (r203 == null) goto L396;
        PromotionProductActivitiesStruct r204 = r203.getActivities();
        if (r204 == null) goto L396;
        Integer r205 = Integer.valueOf(r204.getActivityStyle());
    L397:
        if (r205 != null) goto L400;
    L402:
        int r206 = 0;
    L403:
        View r207 = this.e;
        if ((r207 instanceof ProductFlowCardPriceAndSalesView) == true) goto L406;
        r207 = null;
    L406:
        ProductFlowCardPriceAndSalesView r208 = (ProductFlowCardPriceAndSalesView) r207;
        if (r208 == null) goto L409;
        r208.setStyle(r206);
    L409:
        View r209 = this.e;
        if ((r209 instanceof ProductFlowCardPriceAndSalesView) == true) goto L412;
        r209 = null;
    L412:
        ProductFlowCardPriceAndSalesView r211 = (ProductFlowCardPriceAndSalesView) r209;
        if (r211 == null) goto L415;
        r211.a(r8);
        goto L415
    L400:
        if (r205.intValue() != 1) goto L402;
        r206 = 1;
    L396:
        r205 = null;
        goto L397
    L342:
        r201 = null;
        goto L344
    L351:
        throw new IllegalStateException(r74);
    L337:
        r199 = false;
        goto L338
    L352:
        if (r197 == false) goto L391;
        HashMap<String, Queue<View>> r212 = com.bytedance.android.shopping.feed.view.i.a;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L356;
        boolean r213 = true;
    L357:
        if (r213 == false) goto L390;
        Queue<View> r214 = com.bytedance.android.shopping.feed.view.i.a.get(AnchorV3PresaleDepositLayout.class.getName());
        if (r214 == null) goto L361;
        View r215 = r214.poll();
    L363:
        if ((r215 instanceof AnchorV3PresaleDepositLayout) == true) goto L365;
        r215 = null;
    L365:
        AnchorV3PresaleDepositLayout r216 = (AnchorV3PresaleDepositLayout) r215;
        if (r216 != null) goto L368;
        r216 = new AnchorV3PresaleDepositLayout(getContext(), null, 6, 0);
    L368:
        PromotionProductPrivilegesStruct r217 = r8.getPrivilegeInfo();
        if (r217 == null) goto L386;
        List r218 = r217.getBanners();
        if (r218 == null) goto L386;
        Iterator r219 = r218.iterator();
    L374:
        if (r219.hasNext() == false) goto L384;
        Object r1100 = r219.next();
        Integer r1101 = ((PromotionProductBannerStruct) r1100).getBannerType();
        if (r1101 != null) goto L379;
    L381:
        boolean r1102 = false;
    L382:
        if (r1102 == false) goto L374;
    L385:
        PromotionProductBannerStruct r220 = (PromotionProductBannerStruct) r1100;
    L387:
        if (r220 == null) goto L391;
        AnchorV3PresaleDepositLayout.b(r216, r220);
        this.l.addView(r216, this.D);
        goto L391
    L379:
        if (r1101.intValue() != 4) goto L381;
        r1102 = true;
        goto L382
    L384:
        r1100 = null;
    L386:
        r220 = null;
        goto L387
    L361:
        r215 = null;
        goto L363
    L390:
        throw new IllegalStateException(r74);
    L356:
        r213 = false;
        goto L357
    L329:
        if (r195.isSoldOut() != true) goto L330;
    L331:
        r196 = false;
        goto L332
    L280:
        if (r190.getNeedShowActivityBarStyle() == false) goto L308;
        this.e.setVisibility(8);
        this.e.setOnClickListener(null);
        HashMap<String, Queue<View>> r221 = com.bytedance.android.shopping.feed.view.i.a;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L284;
        boolean r222 = true;
    L285:
        if (r222 == false) goto L307;
        Queue<View> r223 = com.bytedance.android.shopping.feed.view.i.a.get(AbsActivitiesBarView.class.getName());
        if (r223 == null) goto L289;
        View r224 = r223.poll();
    L291:
        if ((r224 instanceof AbsActivitiesBarView) == true) goto L293;
        r224 = null;
    L293:
        AbsActivitiesBarView r225 = (AbsActivitiesBarView) r224;
        if (r225 != null) goto L296;
        r225 = new ActivityBarShopLayout(getContext(), null, 6, 0);
    L296:
        AbsActivitiesBarView r1103 = r225;
        this.p = r1103;
        PromotionProductBaseStruct r226 = r8.getBaseInfo();
        if (r226 == null) goto L299;
        Long r1104 = r226.getSales();
    L300:
        r74 = "only main thread can touch";
        r129 = 8;
        r1103.f(r190, r1104, false, r5.m907getAnchorV3Param(), r8, true);
        this.m.addView(this.p, this.E);
        TopRoundRelativeLayout r227 = this.m;
        ViewGroup.LayoutParams r228 = r227.getLayoutParams();
        if ((r228 instanceof ViewGroup.MarginLayoutParams) == true) goto L303;
        r228 = null;
    L303:
        ViewGroup.MarginLayoutParams r229 = (ViewGroup.MarginLayoutParams) r228;
        if (r229 == null) goto L415;
        r229.topMargin = com.bytedance.android.shopping.extensions.b.b(-12);
        r227.setLayoutParams(r229);
        goto L415
    L299:
        r1104 = null;
        goto L300
    L289:
        r224 = null;
        goto L291
    L307:
        throw new IllegalStateException("only main thread can touch");
    L284:
        r222 = false;
    L36:
        r13 = 0;
        goto L37
    L650:
        return;
    L649:
        return;
    L17:
        if (r3.intValue() != 1) goto L19;
        this.F.setBackgroundResource(2131233520);
    L12:
        r3 = null;
        goto L14
    L652:
        return;
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
    public BaseCardDetailView(Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15);
        boolean r16 = ld3.d.e(ld3.d.b());
        this.B = r16;
        this.C = new LinearLayout.LayoutParams(-2, -2);
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-1, -2);
        int r6 = 0;
        r17.setMargins(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(12), 0);
        Unit r3 = Unit.INSTANCE;
        this.D = r17;
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-1, -2);
        r18.setMargins(0, 0, 0, com.bytedance.android.shopping.extensions.b.b(3));
        this.E = r18;
        int r19 = com.bytedance.android.shopping.extensions.b.b(36);
        com.bytedance.android.shopping.extensions.b.b(24);
        View r4 = new View(r13);
        this.F = r4;
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-1, -2);
        r5.gravity = 8388613;
        this.H = r5;
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-1, -2);
        r7.leftMargin = r19;
        this.I = r7;
        this.J = new FrameLayout(r13);
        this.L = new MutableLiveData();
        this.M = new MutableLiveData();
        this.N = new k(this);
        j r110 = new j(this);
        this.O = r110;
        if (ld3.b.a() == false) goto L5;
        Map r8 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r13).aU(2131560568, this, true);
    L6:
        this.o = (FrameLayout) findViewById(2131373631);
        View r9 = findViewById(2131383125);
        this.n = r9;
        AttributeSet r10 = null;
        if (r16 == true) goto L9;
    L14:
        this.b = (FrameLayout) findViewById(2131374319);
        this.c = (InflowSkuWidget) findViewById(2131383147);
        this.d = (TopRoundRelativeLayout) findViewById(2131383118);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-1, -2);
        int r0 = 6;
        if (r16 == false) goto L23;
        this.d.setBorderRadius(com.bytedance.android.shopping.extensions.b.a(12));
        TopRoundRelativeLayout r12 = this.d;
        ViewGroup.LayoutParams r111 = r12.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == true) goto L19;
        r111 = null;
    L19:
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        if (r112 == null) goto L22;
        r112.topMargin = com.bytedance.android.shopping.extensions.b.b(-16);
        r12.setLayoutParams(r112);
    L22:
        r11.setMargins(com.bytedance.android.shopping.extensions.b.a(12), com.bytedance.android.shopping.extensions.b.a(12), com.bytedance.android.shopping.extensions.b.a(12), 0);
        View r20 = new InFlowPriceAreaView(r13, r10, r0, r6);
    L24:
        this.e = r20;
        this.d.addView(r20, r11);
        if (r16 == false) goto L27;
        View r113 = findViewById(2131383124);
    L28:
        this.f = r113;
        r113.setVisibility(0);
        this.g = findViewById(2131388858);
        this.h = (ViewGroup) findViewById(2131380866);
        this.i = (LinearLayout) findViewById(2131383130);
        InflowFeedBottomBarView r114 = (InflowFeedBottomBarView) findViewById(2131383122);
        this.k = r114;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        float r21 = se3.a.a;
        r115.height = (int) se3.a.a(this.k.getLayoutParams().height);
        if (r16 == false) goto L36;
        InflowFeedBottomBarView r116 = this.k;
        ViewGroup.LayoutParams r22 = r116.getLayoutParams();
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == true) goto L33;
        r22 = null;
    L33:
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
        if (r23 == null) goto L36;
        r23.topMargin = com.bytedance.android.shopping.extensions.b.b(16);
        r23.bottomMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r116.setLayoutParams(r23);
    L36:
        int r117 = ECSdk.a;
        s83.g r118 = (s83.g) ECSdk.a(s83.g.class);
        if (r118 == null) goto L39;
        r118.k0(this.k);
    L39:
        ViewGroup r119 = (ViewGroup) findViewById(2131383117);
        this.l = r119;
        TopRoundRelativeLayout r24 = (TopRoundRelativeLayout) findViewById(2131383116);
        this.m = r24;
        if (r16 == false) goto L42;
        r24.setBorderRadius(com.bytedance.android.shopping.extensions.b.a(12));
    L42:
        this.j = (FrameLayout) findViewById(2131383119);
        this.x = (ViewGroup) findViewById(2131383129);
        BenefitGroupLayout r2 = (BenefitGroupLayout) findViewById(2131383114);
        this.y = r2;
        if (r16 == false) goto L50;
        ViewGroup.LayoutParams r120 = r2.getLayoutParams();
        if ((r120 instanceof ViewGroup.MarginLayoutParams) == true) goto L47;
        r120 = null;
    L47:
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
        if (r121 == null) goto L50;
        r121.topMargin = com.bytedance.android.shopping.extensions.b.b(6);
        r2.setLayoutParams(r121);
    L50:
        this.A = (MarketingBannerLayout) findViewById(2131383142);
        this.z = (ExchangeCouponView) findViewById(2131371848);
        View r122 = this.n;
        if ((r122 instanceof LinearLayout) == true) goto L53;
        r122 = null;
    L53:
        LinearLayout r123 = (LinearLayout) r122;
        if (r123 == null) goto L56;
        r123.addView(r4, new FrameLayout.LayoutParams(-1, -1));
    L56:
        this.n.setBackgroundResource(2131233431);
        com.bytedance.android.ec.core.widget.f.c(this.i, null, "bind_product_flow_card", new AnonymousClass4(this), 1);
        r119.setOnClickListener(new a(this));
        this.m.setOnClickListener(new b(this));
        this.e.setOnClickListener(new c(this));
        this.k.setOnBottomBarEventCallBack(r110);
        return;
    L27:
        r113 = findViewById(2131383123);
        goto L28
    L23:
        r11.setMargins(com.bytedance.android.shopping.extensions.b.a(12), com.bytedance.android.shopping.extensions.b.a(14), com.bytedance.android.shopping.extensions.b.a(12), 0);
        r20 = new ProductFlowCardPriceAndSalesView(r13, r10, r0, r6);
        goto L24
    L9:
        if ((r9 instanceof RoundedLinearLayout) == true) goto L11;
        r9 = null;
    L11:
        RoundedLinearLayout r25 = (RoundedLinearLayout) r9;
        if (r25 == null) goto L14;
        r25.setRadius(com.bytedance.android.shopping.extensions.b.b(16));
        goto L14
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r13).aU(2131560568, this, true);
        goto L6
    }

    public /* synthetic */ BaseCardDetailView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
