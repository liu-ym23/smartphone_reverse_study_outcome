package com.ss.android.ugc.aweme.discover.commodity.holder;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.ss.android.ugc.aweme.discover.commodity.helper.ECSearchResourceHelper;
import com.ss.android.ugc.aweme.discover.model.BannerTagStruct;
import com.ss.android.ugc.aweme.discover.model.ECGradientStruct;
import com.ss.android.ugc.aweme.discover.model.FeedBoxBanner;
import com.ss.android.ugc.aweme.discover.model.FeedBoxBannerBackground;
import com.ss.android.ugc.aweme.discover.model.FeedBoxBannerSceneInfo;
import com.ss.android.ugc.aweme.discover.model.ImgContent;
import com.ss.android.ugc.aweme.discover.model.ImgTextContent;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import com.ss.android.ugc.aweme.discover.model.UrlStruct;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderItem;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderLine;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectItemStatus;
import com.ss.android.ugc.aweme.search.common.ab.ECSearchExperiment;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import com.ss.android.ugc.aweme.search.common.manager.ECSearchParamsManager;
import com.ss.android.ugc.aweme.search.common.mob.BaseSearchResultMobEvent;
import com.ss.android.ugc.aweme.search.common.mob.SearchParamsUtils;
import com.ss.android.ugc.aweme.search.common.utils.ViewExtKt;
import com.ss.android.ugc.aweme.search.filter.ECSearchFilterViewModel;
import com.ss.android.ugc.aweme.search.utils.DimensUtilKt;
import com.ss.android.ugc.aweme.search.utils.StringUtilsKt;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import com.ttnet.org.chromium.base.BaseSwitches;
import df6.q;
import df6.u;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/SearchCommodityFeedBoxBannerViewHolder;", "Lcom/ss/android/ugc/aweme/discover/commodity/holder/ECSearchBaseViewHolder;", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SearchCommodityFeedBoxBannerViewHolder extends ECSearchBaseViewHolder {
    public static final Companion F = null;
    public final SearchCommodityFeedBoxBannerViewHolder$singleImgObserver$1 A;
    public final SearchCommodityFeedBoxBannerViewHolder$buttonObserver$1 B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f450058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f450059j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f450060k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f450061l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f450062m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f450063n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f450064o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f450065p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f450066q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f450067r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f450068s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f450069t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f450070u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f450071v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final View.OnClickListener f450072w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final View.OnClickListener f450073x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ECSearchFilterViewModel f450074y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final SearchCommodityFeedBoxBannerViewHolder$bgObserver$1 f450075z;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/SearchCommodityFeedBoxBannerViewHolder$Companion;", "", "", "BANNER", "Ljava/lang/String;", "", "BannerContentTypeImg", "I", "BannerContentTypeImgText", "ENTRANCE_INFO", "TAG", "", "VIEW_HOLDER_RADIUS", FaceService.girlLabel, "VIEW_HOLDER_RADIUS_NEW", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        F = new Companion(0);
    }

    public abstract int d4();

    public final LinearLayout g4() {
        return (LinearLayout) this.f450059j.getValue();
    }

    public final View h4() {
        return (View) this.f450058i.getValue();
    }

    public final SmartImageView i4() {
        return (SmartImageView) this.f450060k.getValue();
    }

    public final View j4() {
        return (View) this.f450069t.getValue();
    }

    public final TextView k4() {
        return (TextView) this.f450070u.getValue();
    }

    public final SmartImageView l4() {
        return (SmartImageView) this.f450061l.getValue();
    }

    public final LinearLayout m4() {
        return (LinearLayout) this.f450062m.getValue();
    }

    public final SmartImageView n4() {
        return (SmartImageView) this.f450063n.getValue();
    }

    public final TextView q4() {
        return (TextView) this.f450064o.getValue();
    }

    public abstract boolean r4();

    public final JSONObject e4() {
        SearchAggregateCommodity r100 = this.f450050c;
        if (r100 == null) goto L8;
        Map<String, Object> r101 = r100.getLogInfo();
        if (r101 == null) goto L8;
        Object r102 = r101.get("search_result_id");
        if (r102 == null) goto L8;
    L14:
        if (r102 == null) goto L16;
        String r103 = r102.toString();
    L17:
        SearchParamsUtils r104 = SearchParamsUtils.f451780a;
        String r105 = V3().f453302e;
        r104.getClass();
        JSONObject r106 = new JSONObject();
        r106.putOpt("search_id", r105);
        r106.putOpt("pipeline_version", null);
        ECSearchParamsManager.f451721b.getClass();
        ECSearchParam r107 = (ECSearchParam) CollectionsKt.lastOrNull(ECSearchParamsManager.f451720a);
        if (r107 == null) goto L20;
        String r108 = r107.getPassThroughParams();
    L22:
        if (StringUtilsKt.a(r108) == false) goto L24;
        r106.putOpt(ECFindSimilarConfig.SEARCH_PASSTHROUGH_PARAMS, r108);
    L24:
        r106.putOpt(ILiveRoomPlayFragmentConstant.EXTRA_LIST_ITEM_ID, null);
        r106.putOpt("search_result_id", r103);
        r106.putOpt("previous_page", null);
        r106.putOpt("search_jump", null);
        r106.putOpt("search_enter_from_merge", null);
        r106.putOpt("log_extra", null);
        r106.putOpt("value", null);
        r106.putOpt("is_ad", null);
        return r106;
    L20:
        r108 = null;
        goto L22
    L16:
        r103 = null;
    L8:
        SearchAggregateCommodity r109 = this.f450050c;
        if (r109 == null) goto L13;
        Map<String, Object> r110 = r109.getLogInfo();
        if (r110 == null) goto L13;
        r102 = r110.get("feed_box_id");
    L13:
        r102 = null;
        goto L14
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.holder.ECSearchBaseViewHolder
    public void Z3() {
        super.Z3();
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.holder.ECSearchBaseViewHolder
    public final void X3(BaseSearchResultMobEvent<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super.X3(r100);
        Unit r101 = Unit.INSTANCE;
        SearchAggregateCommodity r102 = this.f450050c;
        Object r103 = null;
        if (r102 == null) goto L5;
        FeedBoxBanner r104 = r102.getFeedBanner();
    L7:
        if (d4() != 1) goto L13;
        if (r104 == null) goto L18;
        ImgContent r105 = r104.getImgContent();
        if (r105 == null) goto L18;
        String r106 = r105.getBannerSchema();
    L19:
        r100.f("banner_url", r106);
        SearchAggregateCommodity r107 = this.f450050c;
        if (r107 == null) goto L26;
        Map<String, Object> r108 = r107.getLogInfo();
        if (r108 == null) goto L26;
        Object r109 = r108.get(ILiveRoomPlayFragmentConstant.EXTRA_INSERT_TYPE);
        if (r109 == null) goto L26;
        String r110 = r109.toString();
    L27:
        r100.f(ILiveRoomPlayFragmentConstant.EXTRA_INSERT_TYPE, r110);
        if (r104 == null) goto L45;
        FeedBoxBannerSceneInfo r111 = r104.getSceneInfo();
        if (r111 == null) goto L46;
        String r112 = r111.getSearchForceInsertInfo();
        if (r112 == null) goto L47;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L35
        Object r114 = Result.m9449constructorimpl(new JSONObject(r112).optString("product_id"));     // Catch: Throwable -> L35
    L38:
        if (Result.m9455isFailureimpl(r114) == true) goto L41;
        r103 = r114;
    L41:
        r100.f("banner_product_id", (String) r103);
        return;
    L35:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L26:
        r110 = null;
    L18:
        r106 = null;
        goto L19
    L13:
        if (d4() != 2) goto L18;
        if (r104 == null) goto L18;
        ImgTextContent r116 = r104.getImgTextContent();
        if (r116 == null) goto L18;
        r106 = r116.getBannerSchema();
        goto L19
    L5:
        r104 = null;
        goto L7
    }

    public final void f4(Function1<? super FeedBoxBanner, Unit> r100) {
        SearchAggregateCommodity r101 = this.f450050c;
        if (r101 == null) goto L16;
        FeedBoxBanner r102 = r101.getFeedBanner();
        if (r102 == null) goto L9;
        FeedBoxBannerSceneInfo r103 = r102.getSceneInfo();
        if (r103 == null) goto L9;
        Integer r104 = r103.getBannerSceneType();
    L10:
        if (r104 != null) goto L13;
        return;
    L13:
        if (r104.intValue() != 4) goto L17;
        FeedBoxBanner r105 = r101.getFeedBanner();
        Intrinsics.checkNotNull(r105);
        r100.invoke(r105);
        return;
    L17:
        return;
    L9:
        r104 = null;
        goto L10
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.holder.ECSearchBaseViewHolder, android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r100, "p0");
        l4().getViewTreeObserver().addOnGlobalLayoutListener(this.f450075z);
        j4().getViewTreeObserver().addOnGlobalLayoutListener(this.B);
        if (r4() == true) goto L5;
        return;
    L5:
        if (d4() != 2) goto L9;
        g4().getViewTreeObserver().addOnGlobalLayoutListener(this.A);
        return;
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.holder.ECSearchBaseViewHolder, android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r100, "p0");
        l4().getViewTreeObserver().removeOnGlobalLayoutListener(this.f450075z);
        j4().getViewTreeObserver().removeOnGlobalLayoutListener(this.B);
        g4().getViewTreeObserver().removeOnGlobalLayoutListener(this.A);
    }

    /* JADX WARN: Type inference failed for: r12v2, types: [com.ss.android.ugc.aweme.discover.commodity.holder.SearchCommodityFeedBoxBannerViewHolder$bgObserver$1] */
    /* JADX WARN: Type inference failed for: r12v3, types: [com.ss.android.ugc.aweme.discover.commodity.holder.SearchCommodityFeedBoxBannerViewHolder$singleImgObserver$1] */
    /* JADX WARN: Type inference failed for: r12v4, types: [com.ss.android.ugc.aweme.discover.commodity.holder.SearchCommodityFeedBoxBannerViewHolder$buttonObserver$1] */
    public SearchCommodityFeedBoxBannerViewHolder(final View r110, Fragment r111) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        Intrinsics.checkNotNullParameter(r111, WidgetService.PARAM_FRAGMENT);
        super(r110);
        this.f450058i = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$bannerRoot$2(this));
        this.f450059j = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$bannerContainer$2(this));
        this.f450060k = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$bgImg$2(this));
        this.f450061l = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$img$2(this));
        this.f450062m = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$imgTextContainer$2(this));
        this.f450063n = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$tagImg$2(this));
        this.f450064o = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$tagText$2(this));
        this.f450065p = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$tagHint$2(this));
        this.f450066q = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$tagContainer$2(this));
        this.f450067r = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$title$2(this));
        this.f450068s = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$subTitle$2(this));
        this.f450069t = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$button$2(this));
        this.f450070u = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$buttonText$2(this));
        this.f450071v = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$buttonImg$2(this));
        this.f450072w = new SearchCommodityFeedBoxBannerViewHolder$itemOnClick$1(this);
        this.f450073x = new SearchCommodityFeedBoxBannerViewHolder$buttonOnClick$1(this);
        ECSearchFilterViewModel.Companion.getClass();
        this.f450074y = ECSearchFilterViewModel.Companion.a(r111);
        this.f450075z = new SearchCommodityFeedBoxBannerViewHolder$bgObserver$1(this);
        this.A = new SearchCommodityFeedBoxBannerViewHolder$singleImgObserver$1(this);
        this.B = new SearchCommodityFeedBoxBannerViewHolder$buttonObserver$1(this);
        ViewGroup.LayoutParams r100 = null;
        t4(this, null, null, 7);
        int r112 = d4();
        if (r112 != 1) goto L5;
        ViewExtKt.q(l4());
        ViewExtKt.e(m4());
        g4().setOrientation(1);
        if (r4() == false) goto L56;
        SmartImageView r113 = l4();
        ViewGroup.LayoutParams r101 = r113.getLayoutParams();
        if ((r101 instanceof ViewGroup.LayoutParams) == false) goto L53;
        r100 = r101;
    L53:
        if (r100 == null) goto L55;
        r100.width = -1;
        r100.height = -2;
        r113.setLayoutParams(r100);
    L55:
        SmartImageView r114 = l4();
        ViewGroup.LayoutParams r102 = l4().getLayoutParams();
        r102.width = -1;
        r102.height = -2;
        Unit r103 = Unit.INSTANCE;
        r114.setLayoutParams(r102);
        h4().setPadding(0, 0, 0, 0);
    L63:
        this.C = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$schemaClicker$2(this, r110));
        this.D = LazyKt.lazy(new SearchCommodityFeedBoxBannerViewHolder$sortParamsClicker$2(this));
        this.E = LazyKt.lazy(SearchCommodityFeedBoxBannerViewHolder$newProductClicker$2.INSTANCE);
        return;
    L56:
        SmartImageView r115 = l4();
        ViewGroup.LayoutParams r104 = r115.getLayoutParams();
        if ((r104 instanceof ViewGroup.LayoutParams) == false) goto L60;
        r100 = r104;
    L60:
        if (r100 == null) goto L62;
        r100.width = -1;
        r100.height = -2;
        r115.setLayoutParams(r100);
    L62:
        h4().setPadding(0, 0, 0, 0);
        goto L63
    L5:
        if (r112 == 2) goto L7;
        ViewExtKt.e(l4());
        ViewExtKt.e(m4());
        goto L63
    L7:
        ViewExtKt.q(l4());
        ViewExtKt.q(m4());
        if (r4() == false) goto L28;
        g4().setOrientation(0);
        SmartImageView r116 = l4();
        ViewGroup.LayoutParams r105 = r116.getLayoutParams();
        if ((r105 instanceof ViewGroup.LayoutParams) == true) goto L12;
        r105 = null;
    L12:
        if (r105 == null) goto L14;
        r105.width = -2;
        r105.height = DimenExtensionsKt.b(100);
        r116.setLayoutParams(r105);
    L14:
        LinearLayout r117 = m4();
        ViewGroup.LayoutParams r106 = r117.getLayoutParams();
        if ((r106 instanceof LinearLayout.LayoutParams) == true) goto L17;
        r106 = null;
    L17:
        LinearLayout.LayoutParams r107 = (LinearLayout.LayoutParams) r106;
        if (r107 == null) goto L20;
        r107.width = 0;
        r107.height = -2;
        r107.weight = 1.0f;
        r107.gravity = 16;
        r117.setLayoutParams(r107);
    L20:
        m4().setGravity(1);
        m4().setPadding(DimenExtensionsKt.b(16), DimenExtensionsKt.b(8), DimenExtensionsKt.b(16), DimenExtensionsKt.b(8));
        View r118 = j4();
        ViewGroup.LayoutParams r108 = r118.getLayoutParams();
        if ((r108 instanceof LinearLayout.LayoutParams) == false) goto L24;
        r100 = r108;
    L24:
        LinearLayout.LayoutParams r109 = (LinearLayout.LayoutParams) r100;
        if (r109 == null) goto L27;
        r109.width = -2;
        r109.height = -2;
        r118.setLayoutParams(r109);
    L27:
        j4().setPadding(DimenExtensionsKt.b(12), DimenExtensionsKt.b(5), DimenExtensionsKt.b(12), DimenExtensionsKt.b(5));
        h4().setPadding(0, 0, DimenExtensionsKt.b(Double.valueOf(4.5d)), 0);
        goto L63
    L28:
        g4().setOrientation(1);
        SmartImageView r119 = l4();
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
        if ((r120 instanceof ViewGroup.LayoutParams) == true) goto L31;
        r120 = null;
    L31:
        if (r120 == null) goto L33;
        r120.width = -1;
        r120.height = -2;
        r119.setLayoutParams(r120);
    L33:
        LinearLayout r121 = m4();
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
        if ((r122 instanceof LinearLayout.LayoutParams) == true) goto L36;
        r122 = null;
    L36:
        LinearLayout.LayoutParams r123 = (LinearLayout.LayoutParams) r122;
        if (r123 == null) goto L39;
        r123.width = -1;
        r123.height = -2;
        r123.weight = 0.0f;
        r123.gravity = 8388659;
        r121.setLayoutParams(r123);
    L39:
        m4().setGravity(8388659);
        m4().setPadding(DimenExtensionsKt.b(8), DimenExtensionsKt.b(8), DimenExtensionsKt.b(8), DimenExtensionsKt.b(8));
        View r124 = j4();
        ViewGroup.LayoutParams r125 = r124.getLayoutParams();
        if ((r125 instanceof LinearLayout.LayoutParams) == false) goto L43;
        r100 = r125;
    L43:
        LinearLayout.LayoutParams r126 = (LinearLayout.LayoutParams) r100;
        if (r126 == null) goto L46;
        r126.width = -1;
        r126.height = -2;
        r124.setLayoutParams(r126);
    L46:
        j4().setPadding(DimenExtensionsKt.b(12), DimenExtensionsKt.b(5), DimenExtensionsKt.b(12), DimenExtensionsKt.b(5));
        h4().setPadding(0, 0, 0, 0);
        goto L63
    }

    public static final View b4(SearchCommodityFeedBoxBannerViewHolder r100, int r101) {
        return r100.itemView.findViewById(r101);
    }

    public static final RenderItem c4(SearchCommodityFeedBoxBannerViewHolder r100, FeedBoxBanner r101) {
        r100.getClass();
        if (r101 == null) goto L25;
        FeedBoxBannerSceneInfo r102 = r101.getSceneInfo();
        if (r102 == null) goto L25;
        SelectItemStatus r103 = r102.getSwitchSortParams();
        if (r103 == null) goto L25;
        String r104 = r103.getDataId();
        if (r104 == null) goto L25;
        SelectInfo r105 = r100.f450074y.getData();
        if (r105 == null) goto L25;
        List<RenderLine> r106 = r105.getRenderInfo();
        if (r106 == null) goto L25;
        Iterator<T> r107 = r106.iterator();
    L16:
        if (r107.hasNext() == false) goto L25;
        List<RenderItem> r108 = ((RenderLine) r107.next()).getRenderItemList();
        if (r108 == null) goto L16;
        Iterator<T> r109 = r108.iterator();
    L21:
        if (r109.hasNext() == false) goto L16;
        RenderItem r110 = (RenderItem) r109.next();
        if (Intrinsics.areEqual(r110.getDataId(), r104) == false) goto L21;
        return r110;
    L25:
        return null;
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.holder.ECSearchBaseViewHolder
    public final void U3(SearchAggregateCommodity r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "searchAggregateCommodity");
        final FeedBoxBanner r112 = r110.getFeedBanner();
        if (r112 != null) goto L5;
        return;
    L5:
        int r113 = d4();
        UrlStruct r100 = null;
        ViewGroup.LayoutParams r101 = null;
        ViewGroup.LayoutParams r102 = null;
        UrlStruct r103 = null;
        String r104 = "";
        if (r113 != 1) goto L8;
        t4(this, null, null, 7);
        ViewExtKt.e(i4());
        if (r4() == false) goto L453;
        ImgContent r114 = r112.getImgContent();
        if (r114 == null) goto L449;
        UrlStruct r115 = r114.getSingleColumnBannerImg();
        if (r115 == null) goto L449;
        String r116 = r115.getImgUrl();
        if (r116 == null) goto L449;
        r104 = r116;
    L449:
        u r117 = q.e(r104);
        r117.f468294t = l4();
        r117.c();
        SmartImageView r118 = l4();
        ImgContent r119 = r112.getImgContent();
        if (r119 == null) goto L452;
        r103 = r119.getSingleColumnBannerImg();
    L452:
        u4(r118, r103);
    L465:
        this.itemView.setOnClickListener(this.f450072w);
        return;
    L453:
        ImgContent r120 = r112.getImgContent();
        if (r120 == null) goto L461;
        UrlStruct r121 = r120.getDoubleColumnBannerImg();
        if (r121 == null) goto L461;
        String r122 = r121.getImgUrl();
        if (r122 == null) goto L461;
        r104 = r122;
    L461:
        u r123 = q.e(r104);
        r123.f468294t = l4();
        r123.c();
        SmartImageView r124 = l4();
        ImgContent r125 = r112.getImgContent();
        if (r125 == null) goto L464;
        r100 = r125.getDoubleColumnBannerImg();
    L464:
        u4(r124, r100);
        goto L465
    L8:
        if (r113 != 2) goto L465;
        if (r4() == false) goto L36;
        SmartImageView r126 = l4();
        ViewGroup.LayoutParams r105 = r126.getLayoutParams();
        if ((r105 instanceof ViewGroup.LayoutParams) == true) goto L15;
        r105 = null;
    L15:
        if (r105 == null) goto L24;
        r105.width = -2;
        ImgTextContent r106 = r112.getImgTextContent();
        if (r106 == null) goto L19;
        BannerTagStruct r107 = r106.getButton();
    L20:
        if (r107 == null) goto L22;
        int r108 = DimenExtensionsKt.b(135);
    L23:
        r105.height = r108;
        r126.setLayoutParams(r105);
        goto L24
    L22:
        r108 = DimenExtensionsKt.b(100);
        goto L23
    L19:
        r107 = null;
    L24:
        ImgTextContent r127 = r112.getImgTextContent();
        if (r127 == null) goto L30;
        UrlStruct r128 = r127.getSingleColumnBannerImg();
        if (r128 == null) goto L30;
        String r129 = r128.getImgUrl();
        if (r129 == null) goto L30;
    L31:
        u r130 = q.e(r129);
        r130.f468294t = l4();
        r130.c();
        SmartImageView r131 = l4();
        ImgTextContent r109 = r112.getImgTextContent();
        if (r109 == null) goto L34;
        UrlStruct r132 = r109.getSingleColumnBannerImg();
    L35:
        v4(r131, r132);
    L48:
        ViewExtKt.q(i4());
        if (r4() == false) goto L74;
        ImgTextContent r133 = r112.getImgTextContent();
        if (r133 == null) goto L57;
        FeedBoxBannerBackground r134 = r133.getBackground();
        if (r134 == null) goto L57;
        UrlStruct r135 = r134.getSingleBackgroundImg();
        if (r135 == null) goto L57;
        String r136 = r135.getImgUrl();
    L58:
        if (r136 != null) goto L60;
    L63:
        boolean r137 = true;
    L64:
        if (r137 == true) goto L74;
        ImgTextContent r138 = r112.getImgTextContent();
        if (r138 == null) goto L72;
        FeedBoxBannerBackground r139 = r138.getBackground();
        if (r139 == null) goto L72;
        UrlStruct r140 = r139.getSingleBackgroundImg();
        if (r140 == null) goto L72;
        String r141 = r140.getImgUrl();
    L73:
        t4(this, r141, null, 5);
    L116:
        ImgTextContent r142 = r112.getImgTextContent();
        if (r142 == null) goto L123;
        BannerTagStruct r143 = r142.getIcon();
        if (r143 == null) goto L123;
        UrlStruct r144 = r143.getIconImg();
        if (r144 == null) goto L123;
        String r145 = r144.getImgUrl();
    L124:
        String r146 = "#00000000";
        if (r145 == null) goto L169;
        ViewExtKt.q(n4());
        ViewExtKt.e(q4());
        SmartImageView r147 = n4();
        GenericDraweeHierarchy r148 = n4().getHierarchy();
        r148.setRoundingParams(RoundingParams.fromCornersRadius(DimensUtilKt.a(2)));
        Unit r149 = Unit.INSTANCE;
        r147.setHierarchy(r148);
        n4().setOutlineProvider(new SearchCommodityFeedBoxBannerViewHolder$onBindImgTextBanner$5());
        ImgTextContent r150 = r112.getImgTextContent();
        if (r150 == null) goto L134;
        BannerTagStruct r151 = r150.getIcon();
        if (r151 == null) goto L134;
        UrlStruct r152 = r151.getIconImg();
        if (r152 == null) goto L134;
        String r153 = r152.getImgUrl();
        if (r153 == null) goto L134;
    L135:
        u r154 = q.e(r153);
        r154.f468294t = n4();
        r154.c();
        ImgTextContent r155 = r112.getImgTextContent();
        if (r155 == null) goto L144;
        BannerTagStruct r156 = r155.getIcon();
        if (r156 == null) goto L144;
        UrlStruct r157 = r156.getIconImg();
        if (r157 == null) goto L144;
        Integer r158 = r157.getWidth();
        if (r158 == null) goto L144;
        int r159 = r158.intValue();
    L145:
        if (r159 <= 0) goto L164;
        ImgTextContent r160 = r112.getImgTextContent();
        if (r160 == null) goto L155;
        BannerTagStruct r161 = r160.getIcon();
        if (r161 == null) goto L155;
        UrlStruct r162 = r161.getIconImg();
        if (r162 == null) goto L155;
        Integer r163 = r162.getHeight();
        if (r163 == null) goto L155;
        int r164 = r163.intValue();
    L156:
        if (r164 <= 0) goto L164;
        SmartImageView r165 = n4();
        ImgTextContent r166 = r112.getImgTextContent();
        if (r166 == null) goto L162;
        BannerTagStruct r167 = r166.getIcon();
        if (r167 == null) goto L162;
        UrlStruct r168 = r167.getIconImg();
    L163:
        v4(r165, r168);
    L234:
        TextView r169 = (TextView) this.f450065p.getValue();
        ImgTextContent r170 = r112.getImgTextContent();
        if (r170 == null) goto L241;
        BannerTagStruct r171 = r170.getIconTail();
        if (r171 == null) goto L241;
        String r172 = r171.getText();
        if (r172 == null) goto L241;
    L242:
        r169.setText(r172);
        TextView r173 = (TextView) this.f450065p.getValue();
        ImgTextContent r174 = r112.getImgTextContent();
        if (r174 == null) goto L247;
        BannerTagStruct r175 = r174.getIconTail();
        if (r175 == null) goto L247;
        String r176 = r175.getTextColor();
    L248:
        if (r176 != null) goto L250;
    L253:
        boolean r177 = true;
    L254:
        String r178 = "#FF5F4216";
        if (r177 == false) goto L257;
        r176 = "#FF5F4216";
    L257:
        r173.setTextColor(ColorProtector.parseColor(r176));
        View r179 = (View) this.f450066q.getValue();
        GradientDrawable r180 = new GradientDrawable();
        r180.setCornerRadius(DimensUtilKt.a(2));
        ImgTextContent r181 = r112.getImgTextContent();
        if (r181 == null) goto L262;
        BannerTagStruct r182 = r181.getIconTail();
        if (r182 == null) goto L262;
        ECGradientStruct r183 = r182.getBackgroundGradientColor();
    L263:
        if (r183 == null) goto L283;
        ImgTextContent r184 = r112.getImgTextContent();
        if (r184 == null) goto L272;
        BannerTagStruct r185 = r184.getIconTail();
        if (r185 == null) goto L272;
        ECGradientStruct r186 = r185.getBackgroundGradientColor();
        if (r186 == null) goto L272;
        String r187 = r186.getStartColor();
        if (r187 == null) goto L272;
    L273:
        ImgTextContent r188 = r112.getImgTextContent();
        if (r188 == null) goto L281;
        BannerTagStruct r189 = r188.getIconTail();
        if (r189 == null) goto L281;
        ECGradientStruct r190 = r189.getBackgroundGradientColor();
        if (r190 == null) goto L281;
        String r191 = r190.getEndColor();
        if (r191 == null) goto L281;
    L282:
        r180.setGradientType(0);
        r180.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        r180.setColors(new int[]{ColorProtector.parseColor(r187), ColorProtector.parseColor(r191)});
    L292:
        Unit r192 = Unit.INSTANCE;
        r179.setBackground(r180);
        TextView r193 = (TextView) this.f450067r.getValue();
        ImgTextContent r194 = r112.getImgTextContent();
        if (r194 == null) goto L299;
        BannerTagStruct r195 = r194.getMainTitle();
        if (r195 == null) goto L299;
        String r196 = r195.getText();
        if (r196 == null) goto L299;
    L300:
        r193.setText(r196);
        TextView r197 = (TextView) this.f450067r.getValue();
        ImgTextContent r198 = r112.getImgTextContent();
        if (r198 == null) goto L305;
        BannerTagStruct r199 = r198.getMainTitle();
        if (r199 == null) goto L305;
        String r200 = r199.getTextColor();
    L306:
        if (r200 != null) goto L308;
    L311:
        boolean r201 = true;
    L312:
        if (r201 == true) goto L315;
        r178 = r200;
    L315:
        r197.setTextColor(ColorProtector.parseColor(r178));
        TextView r1100 = (TextView) this.f450068s.getValue();
        ImgTextContent r202 = r112.getImgTextContent();
        if (r202 == null) goto L322;
        BannerTagStruct r203 = r202.getSubTitle();
        if (r203 == null) goto L322;
        String r204 = r203.getText();
        if (r204 == null) goto L322;
    L323:
        r1100.setText(r204);
        TextView r1101 = (TextView) this.f450068s.getValue();
        ImgTextContent r205 = r112.getImgTextContent();
        if (r205 == null) goto L328;
        BannerTagStruct r206 = r205.getSubTitle();
        if (r206 == null) goto L328;
        String r207 = r206.getTextColor();
    L329:
        if (r207 != null) goto L331;
    L334:
        boolean r208 = true;
    L335:
        String r209 = "#5F4216BF";
        if (r208 == false) goto L338;
        r207 = "#5F4216BF";
    L338:
        r1101.setTextColor(ColorProtector.parseColor(r207));
        ImgTextContent r1102 = r112.getImgTextContent();
        if (r1102 == null) goto L341;
        BannerTagStruct r1103 = r1102.getButton();
    L342:
        if (r1103 == null) goto L408;
        ViewExtKt.q(j4());
        k4().setMaxWidth(Integer.MAX_VALUE);
        ImgTextContent r1104 = r112.getImgTextContent();
        if (r1104 == null) goto L348;
        BannerTagStruct r1105 = r1104.getButton();
        if (r1105 == null) goto L348;
        String r1106 = r1105.getTextColor();
    L349:
        if (r1106 != null) goto L351;
    L354:
        boolean r210 = true;
    L355:
        if (r210 == true) goto L358;
        r209 = r1106;
    L358:
        int r1107 = ColorProtector.parseColor(r209);
        TextView r211 = k4();
        ViewGroup.LayoutParams r212 = k4().getLayoutParams();
        r212.width = -2;
        r211.setLayoutParams(r212);
        TextView r213 = k4();
        ImgTextContent r214 = r112.getImgTextContent();
        if (r214 == null) goto L365;
        BannerTagStruct r215 = r214.getButton();
        if (r215 == null) goto L365;
        String r216 = r215.getText();
        if (r216 == null) goto L365;
    L366:
        r213.setText(r216);
        k4().setTextColor(r1107);
        ((ImageView) this.f450071v.getValue()).setImageTintList(ColorStateList.valueOf(r1107));
        View r1108 = j4();
        GradientDrawable r217 = new GradientDrawable();
        r217.setCornerRadius(DimensUtilKt.a(6));
        ImgTextContent r218 = r112.getImgTextContent();
        if (r218 == null) goto L371;
        BannerTagStruct r219 = r218.getButton();
        if (r219 == null) goto L371;
        ECGradientStruct r220 = r219.getBackgroundGradientColor();
    L372:
        if (r220 == null) goto L393;
        ImgTextContent r221 = r112.getImgTextContent();
        if (r221 == null) goto L381;
        BannerTagStruct r222 = r221.getButton();
        if (r222 == null) goto L381;
        ECGradientStruct r223 = r222.getBackgroundGradientColor();
        if (r223 == null) goto L381;
        String r224 = r223.getStartColor();
        if (r224 == null) goto L381;
    L382:
        ImgTextContent r1109 = r112.getImgTextContent();
        if (r1109 == null) goto L392;
        BannerTagStruct r1110 = r1109.getButton();
        if (r1110 == null) goto L392;
        ECGradientStruct r1111 = r1110.getBackgroundGradientColor();
        if (r1111 == null) goto L392;
        String r1112 = r1111.getEndColor();
        if (r1112 == null) goto L392;
        r104 = r1112;
    L392:
        r217.setGradientType(0);
        r217.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        r217.setColors(new int[]{ColorProtector.parseColor(r224), ColorProtector.parseColor(r104)});
    L407:
        r1108.setBackground(r217);
        j4().setOnClickListener(this.f450073x);
    L410:
        if (r4() == false) goto L465;
        if (j4().getVisibility() != 8) goto L426;
        View r1113 = j4();
        ViewGroup.LayoutParams r1114 = r1113.getLayoutParams();
        if ((r1114 instanceof ViewGroup.MarginLayoutParams) == true) goto L416;
        r1114 = null;
    L416:
        ViewGroup.MarginLayoutParams r1115 = (ViewGroup.MarginLayoutParams) r1114;
        if (r1115 == null) goto L419;
        r1115.bottomMargin = DimenExtensionsKt.b(0);
        r1113.setLayoutParams(r1115);
    L419:
        TextView r1116 = (TextView) this.f450068s.getValue();
        ViewGroup.LayoutParams r1117 = r1116.getLayoutParams();
        if ((r1117 instanceof ViewGroup.MarginLayoutParams) == false) goto L423;
        r101 = r1117;
    L423:
        ViewGroup.MarginLayoutParams r225 = (ViewGroup.MarginLayoutParams) r101;
        if (r225 == null) goto L465;
        r225.bottomMargin = DimenExtensionsKt.b(0);
        r1116.setLayoutParams(r225);
        goto L465
    L426:
        View r1118 = j4();
        ViewGroup.LayoutParams r226 = r1118.getLayoutParams();
        if ((r226 instanceof ViewGroup.MarginLayoutParams) == true) goto L429;
        r226 = null;
    L429:
        ViewGroup.MarginLayoutParams r227 = (ViewGroup.MarginLayoutParams) r226;
        if (r227 == null) goto L432;
        r227.bottomMargin = DimenExtensionsKt.b(0);
        r1118.setLayoutParams(r227);
    L432:
        TextView r1119 = (TextView) this.f450068s.getValue();
        ViewGroup.LayoutParams r228 = r1119.getLayoutParams();
        if ((r228 instanceof ViewGroup.MarginLayoutParams) == false) goto L436;
        r102 = r228;
    L436:
        ViewGroup.MarginLayoutParams r229 = (ViewGroup.MarginLayoutParams) r102;
        if (r229 == null) goto L465;
        r229.bottomMargin = DimenExtensionsKt.b(8);
        r1119.setLayoutParams(r229);
    L381:
        r224 = "";
        goto L382
    L393:
        ImgTextContent r230 = r112.getImgTextContent();
        if (r230 == null) goto L398;
        BannerTagStruct r231 = r230.getButton();
        if (r231 == null) goto L398;
        String r232 = r231.getBackgroundColor();
    L399:
        if (r232 == null) goto L407;
        ImgTextContent r1120 = r112.getImgTextContent();
        if (r1120 == null) goto L405;
        BannerTagStruct r1121 = r1120.getButton();
        if (r1121 == null) goto L405;
        String r1122 = r1121.getBackgroundColor();
    L406:
        r217.setColor(ColorProtector.parseColor(r1122));
    L405:
        r1122 = null;
    L398:
        r232 = null;
    L371:
        r220 = null;
    L365:
        r216 = "";
        goto L366
    L351:
        if (StringsKt.isBlank(r1106) == true) goto L354;
        r210 = false;
    L348:
        r1106 = null;
        goto L349
    L408:
        ViewExtKt.e(j4());
        goto L410
    L341:
        r1103 = null;
        goto L342
    L331:
        if (StringsKt.isBlank(r207) == true) goto L334;
        r208 = false;
    L328:
        r207 = null;
    L322:
        r204 = "";
        goto L323
    L308:
        if (StringsKt.isBlank(r200) == true) goto L311;
        r201 = false;
    L305:
        r200 = null;
    L299:
        r196 = "";
    L281:
        r191 = "";
    L272:
        r187 = "";
        goto L273
    L283:
        ImgTextContent r233 = r112.getImgTextContent();
        if (r233 == null) goto L291;
        BannerTagStruct r234 = r233.getIconTail();
        if (r234 == null) goto L291;
        String r235 = r234.getBackgroundColor();
        if (r235 == null) goto L291;
        r146 = r235;
    L291:
        r180.setColor(ColorProtector.parseColor(r146));
    L262:
        r183 = null;
        goto L263
    L250:
        if (StringsKt.isBlank(r176) == true) goto L253;
        r177 = false;
    L247:
        r176 = null;
    L241:
        r172 = "";
    L162:
        r168 = null;
    L155:
        r164 = 0;
    L164:
        SmartImageView r1123 = n4();
        ViewGroup.LayoutParams r236 = r1123.getLayoutParams();
        if ((r236 instanceof ViewGroup.LayoutParams) == true) goto L167;
        r236 = null;
    L167:
        if (r236 == null) goto L234;
        r236.width = DimenExtensionsKt.b(56);
        r1123.setLayoutParams(r236);
    L144:
        r159 = 0;
    L134:
        r153 = "";
        goto L135
    L169:
        ImgTextContent r1124 = r112.getImgTextContent();
        if (r1124 == null) goto L174;
        BannerTagStruct r1125 = r1124.getIcon();
        if (r1125 == null) goto L174;
        String r1126 = r1125.getText();
    L175:
        if (r1126 == null) goto L233;
        ViewExtKt.e(n4());
        ViewExtKt.q(q4());
        TextView r1127 = q4();
        ImgTextContent r237 = r112.getImgTextContent();
        if (r237 == null) goto L183;
        BannerTagStruct r238 = r237.getIcon();
        if (r238 == null) goto L183;
        String r239 = r238.getText();
        if (r239 == null) goto L183;
    L184:
        r1127.setText(r239);
        TextView r1128 = q4();
        ImgTextContent r240 = r112.getImgTextContent();
        if (r240 == null) goto L189;
        BannerTagStruct r241 = r240.getIcon();
        if (r241 == null) goto L189;
        String r242 = r241.getTextColor();
    L190:
        if (r242 != null) goto L192;
    L195:
        boolean r243 = true;
    L196:
        if (r243 == false) goto L198;
        r242 = "#FFFFFFFF";
    L198:
        r1128.setTextColor(ColorProtector.parseColor(r242));
        TextView r1129 = q4();
        GradientDrawable r244 = new GradientDrawable();
        r244.setCornerRadius(DimensUtilKt.a(2));
        ImgTextContent r245 = r112.getImgTextContent();
        if (r245 == null) goto L203;
        BannerTagStruct r246 = r245.getIcon();
        if (r246 == null) goto L203;
        ECGradientStruct r247 = r246.getBackgroundGradientColor();
    L204:
        if (r247 == null) goto L224;
        ImgTextContent r248 = r112.getImgTextContent();
        if (r248 == null) goto L213;
        BannerTagStruct r249 = r248.getIcon();
        if (r249 == null) goto L213;
        ECGradientStruct r250 = r249.getBackgroundGradientColor();
        if (r250 == null) goto L213;
        String r251 = r250.getStartColor();
        if (r251 == null) goto L213;
    L214:
        ImgTextContent r252 = r112.getImgTextContent();
        if (r252 == null) goto L222;
        BannerTagStruct r253 = r252.getIcon();
        if (r253 == null) goto L222;
        ECGradientStruct r254 = r253.getBackgroundGradientColor();
        if (r254 == null) goto L222;
        String r255 = r254.getEndColor();
        if (r255 == null) goto L222;
    L223:
        r244.setGradientType(0);
        r244.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        r244.setColors(new int[]{ColorProtector.parseColor(r251), ColorProtector.parseColor(r255)});
    L232:
        Unit r256 = Unit.INSTANCE;
        r1129.setBackground(r244);
    L222:
        r255 = "";
    L213:
        r251 = "";
        goto L214
    L224:
        ImgTextContent r257 = r112.getImgTextContent();
        if (r257 == null) goto L230;
        BannerTagStruct r258 = r257.getIcon();
        if (r258 == null) goto L230;
        String r259 = r258.getBackgroundColor();
        if (r259 == null) goto L230;
    L231:
        r244.setColor(ColorProtector.parseColor(r259));
    L230:
        r259 = "#00000000";
    L203:
        r247 = null;
        goto L204
    L192:
        if (StringsKt.isBlank(r242) == true) goto L195;
        r243 = false;
    L189:
        r242 = null;
    L183:
        r239 = "";
        goto L184
    L233:
        ViewExtKt.e(n4());
        ViewExtKt.e(q4());
    L174:
        r1126 = null;
    L123:
        r145 = null;
    L72:
        r141 = null;
        goto L73
    L60:
        if (StringsKt.isBlank(r136) == true) goto L63;
        r137 = false;
    L57:
        r136 = null;
    L74:
        ImgTextContent r1130 = r112.getImgTextContent();
        if (r1130 == null) goto L81;
        FeedBoxBannerBackground r1131 = r1130.getBackground();
        if (r1131 == null) goto L81;
        UrlStruct r1132 = r1131.getDoubleBackgroundImg();
        if (r1132 == null) goto L81;
        String r1133 = r1132.getImgUrl();
    L82:
        if (r1133 != null) goto L84;
    L87:
        boolean r1134 = true;
    L88:
        if (r1134 == true) goto L98;
        ImgTextContent r1135 = r112.getImgTextContent();
        if (r1135 == null) goto L96;
        FeedBoxBannerBackground r1136 = r1135.getBackground();
        if (r1136 == null) goto L96;
        UrlStruct r1137 = r1136.getDoubleBackgroundImg();
        if (r1137 == null) goto L96;
        String r1138 = r1137.getImgUrl();
    L97:
        t4(this, r1138, null, 5);
    L96:
        r1138 = null;
        goto L97
    L98:
        ImgTextContent r1139 = r112.getImgTextContent();
        if (r1139 == null) goto L103;
        FeedBoxBannerBackground r1140 = r1139.getBackground();
        if (r1140 == null) goto L103;
        ECGradientStruct r1141 = r1140.getBackgroundGradientColor();
    L105:
        if (r1141 == null) goto L107;
        t4(this, null, new SearchCommodityFeedBoxBannerViewHolder$onBindImgTextBanner$2(this, r112), 3);
        goto L116
    L107:
        ImgTextContent r1142 = r112.getImgTextContent();
        if (r1142 == null) goto L112;
        FeedBoxBannerBackground r1143 = r1142.getBackground();
        if (r1143 == null) goto L112;
        String r1144 = r1143.getBackgroundColor();
    L113:
        if (r1144 == null) goto L115;
        t4(this, null, new SearchCommodityFeedBoxBannerViewHolder$onBindImgTextBanner$3(r112), 3);
        goto L116
    L115:
        t4(this, null, null, 7);
    L112:
        r1144 = null;
    L103:
        r1141 = null;
        goto L105
    L84:
        if (StringsKt.isBlank(r1133) == true) goto L87;
        r1134 = false;
    L81:
        r1133 = null;
        goto L82
    L34:
        r132 = null;
    L30:
        r129 = "";
        goto L31
    L36:
        ImgTextContent r1145 = r112.getImgTextContent();
        if (r1145 == null) goto L42;
        UrlStruct r1146 = r1145.getDoubleColumnBannerImg();
        if (r1146 == null) goto L42;
        String r1147 = r1146.getImgUrl();
        if (r1147 == null) goto L42;
    L43:
        u r1148 = q.e(r1147);
        r1148.f468294t = l4();
        r1148.c();
        SmartImageView r1149 = l4();
        ImgTextContent r260 = r112.getImgTextContent();
        if (r260 == null) goto L46;
        UrlStruct r261 = r260.getDoubleColumnBannerImg();
    L47:
        u4(r1149, r261);
        goto L48
    L46:
        r261 = null;
    L42:
        r1147 = "";
        goto L43
    }

    public final void s4(final View r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "buttonType");
        final SearchAggregateCommodity r102 = this.f450050c;
        if (r102 == null) goto L23;
        FeedBoxBanner r103 = r102.getFeedBanner();
        if (r103 == null) goto L9;
        FeedBoxBannerSceneInfo r104 = r103.getSceneInfo();
        if (r104 == null) goto L9;
        Integer r105 = r104.getBannerSceneType();
    L10:
        if (r105 != null) goto L13;
    L15:
        if (r105 != null) goto L18;
    L20:
        FeedBoxBannerClicker r106 = (SearchCommodityFeedBoxBannerViewHolder$schemaClicker$2.AnonymousClass1) this.C.getValue();
    L21:
        r106.a(r100, r102, new SearchCommodityFeedBoxBannerViewHolder$onItemClick$$inlined$also$lambda$1(r102, this, r100, r101));
        return;
    L18:
        if (r105.intValue() != 4) goto L20;
        r106 = (SearchCommodityFeedBoxBannerViewHolder$sortParamsClicker$2.AnonymousClass1) this.D.getValue();
        goto L21
    L13:
        if (r105.intValue() != 2) goto L15;
        r106 = (SearchCommodityFeedBoxBannerViewHolder$newProductClicker$2.AnonymousClass1) this.E.getValue();
    L9:
        r105 = null;
        goto L10
    }

    public final void u4(final SmartImageView r100, UrlStruct r101) {
        final int r102 = 0;
        if (r101 == null) goto L7;
        Integer r103 = r101.getWidth();
        if (r103 == null) goto L7;
        final int r104 = r103.intValue();
    L8:
        if (r101 == null) goto L12;
        Integer r105 = r101.getHeight();
        if (r105 == null) goto L12;
        r102 = r105.intValue();
    L12:
        r100.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        if (r104 <= 0) goto L24;
        if (r102 <= 0) goto L24;
        if (r100.getLayoutParams().width <= 0) goto L23;
        ViewGroup.LayoutParams r106 = r100.getLayoutParams();
        if ((r106 instanceof ViewGroup.LayoutParams) == true) goto L21;
        r106 = null;
    L21:
        if (r106 == null) goto L26;
        r106.height = (r100.getLayoutParams().width * r102) / r104;
        r100.setLayoutParams(r106);
        return;
    L26:
        return;
    L23:
        this.itemView.post(new SearchCommodityFeedBoxBannerViewHolder$updateImageHeightFromData$3(r100, r102, r104));
        return;
    L24:
        this.itemView.post(new SearchCommodityFeedBoxBannerViewHolder$updateImageHeightFromData$1(r100));
        return;
    L7:
        r104 = 0;
        goto L8
    }

    public final void v4(final SmartImageView r100, UrlStruct r101) {
        final int r102 = 0;
        if (r101 == null) goto L7;
        Integer r103 = r101.getWidth();
        if (r103 == null) goto L7;
        final int r104 = r103.intValue();
    L8:
        if (r101 == null) goto L12;
        Integer r105 = r101.getHeight();
        if (r105 == null) goto L12;
        r102 = r105.intValue();
    L12:
        r100.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        if (r104 <= 0) goto L24;
        if (r102 <= 0) goto L24;
        if (r100.getLayoutParams().height <= 0) goto L23;
        ViewGroup.LayoutParams r106 = r100.getLayoutParams();
        if ((r106 instanceof ViewGroup.LayoutParams) == true) goto L21;
        r106 = null;
    L21:
        if (r106 == null) goto L26;
        r106.width = (r100.getLayoutParams().height * r104) / r102;
        r100.setLayoutParams(r106);
        return;
    L26:
        return;
    L23:
        this.itemView.post(new SearchCommodityFeedBoxBannerViewHolder$updateImageWidthFromData$3(r100, r104, r102));
        return;
    L24:
        this.itemView.post(new SearchCommodityFeedBoxBannerViewHolder$updateImageWidthFromData$1(r100));
        return;
    L7:
        r104 = 0;
        goto L8
    }

    public static void t4(SearchCommodityFeedBoxBannerViewHolder r100, String r101, Function1 r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        float r102 = DimensUtilKt.a(Float.valueOf(12.0f));
    L7:
        if ((r111 & 2) == 0) goto L10;
        r101 = null;
    L10:
        if ((r111 & 4) == 0) goto L12;
        r110 = SearchCommodityFeedBoxBannerViewHolder$setCardRadiusAndBackground$1.INSTANCE;
    L12:
        r100.getClass();
        GradientDrawable r112 = new GradientDrawable();
        final Ref.FloatRef r103 = new Ref.FloatRef();
        r103.element = r102;
        ECSearchResourceHelper r104 = ECSearchResourceHelper.f450039b;
        r104.getClass();
        r103.element = DimensUtilKt.a(Float.valueOf(ECSearchResourceHelper.b(r104, ECSearchResourceHelper.ECSearchTokenKey.ECSearchCardRadius200Token)));
        r100.h4().setOutlineProvider(new SearchCommodityFeedBoxBannerViewHolder$setCardRadiusAndBackground$2(r103));
        boolean r105 = true;
        r100.h4().setClipToOutline(true);
        SmartImageView r106 = r100.l4();
        GenericDraweeHierarchy r107 = r100.l4().getHierarchy();
        GenericDraweeHierarchy r108 = r107;
        if (r100.d4() == 2) goto L15;
    L20:
        r108.setRoundingParams(RoundingParams.fromCornersRadius(r103.element));
    L21:
        Unit r109 = Unit.INSTANCE;
        r106.setHierarchy(r107);
        r112.setShape(0);
        if (r101 != null) goto L24;
    L27:
        if (r105 == false) goto L29;
        r110.invoke(r112);
        r100.i4().setImageDrawable(r112);
        return;
    L29:
        u r113 = q.e(r101);
        r113.f468294t = r100.i4();
        r113.c();
        return;
    L24:
        if (StringsKt.isBlank(r101) == true) goto L27;
        r105 = false;
        goto L27
    L15:
        if (ECSearchExperiment.n() == false) goto L20;
        if (r100.r4() == false) goto L19;
        float r114 = r103.element;
        r108.setRoundingParams(RoundingParams.fromCornersRadii(r114, 0.0f, 0.0f, r114));
        goto L21
    L19:
        float r115 = r103.element;
        r108.setRoundingParams(RoundingParams.fromCornersRadii(r115, r115, 0.0f, 0.0f));
        goto L21
    L5:
        r102 = 0.0f;
        goto L7
    }
}
