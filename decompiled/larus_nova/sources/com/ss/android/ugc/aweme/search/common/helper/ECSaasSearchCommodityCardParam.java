package com.ss.android.ugc.aweme.search.common.helper;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.discover.model.ISearchCommodityLynxParam;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import com.ss.android.ugc.aweme.search.ecommerce.api.srp.ECSearchBizScene;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/helper/ECSaasSearchCommodityCardParam;", "Lcom/ss/android/ugc/aweme/discover/model/ISearchCommodityLynxParam;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSaasSearchCommodityCardParam implements ISearchCommodityLynxParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f451611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f451612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f451613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f451614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f451615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f451616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Fragment f451617g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ECSearchParam f451618h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ECSearchBizScene f451619i;

    @Override // com.ss.android.ugc.aweme.discover.model.ISearchCommodityLynxParam
    public final String a() {
        Logger.a("OpenDetailMethod", "getSearchEnterMethod searchBizScene = " + this.f451619i);
        if (this.f451619i != ECSearchBizScene.HYBRID_SEARCH) goto L6;
        return "";
    L6:
        ECSearchParam r100 = this.f451618h;
        if (r100 != null) goto L11;
        return null;
    L11:
        return r100.getEnterMethod();
    }

    @Override // com.ss.android.ugc.aweme.discover.model.ISearchCommodityLynxParam
    public final String b() {
        return (String) this.f451611a.getValue();
    }

    @Override // com.ss.android.ugc.aweme.discover.model.ISearchCommodityLynxParam
    public final String c() {
        return (String) this.f451616f.getValue();
    }

    public final String d() {
        return (String) ((Void) this.f451612b.getValue());
    }

    public ECSaasSearchCommodityCardParam(Fragment r100, ECSearchParam r101, ECSearchBizScene r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f451617g = r100;
        this.f451618h = r101;
        this.f451619i = r102;
        this.f451611a = LazyKt.lazy(new ECSaasSearchCommodityCardParam$mSearchEnterFrom$2(this));
        this.f451612b = LazyKt.lazy(ECSaasSearchCommodityCardParam$mCommodityCenterTheme$2.INSTANCE);
        this.f451613c = LazyKt.lazy(new ECSaasSearchCommodityCardParam$mScreenWidthToDp$2(this));
        this.f451614d = LazyKt.lazy(new ECSaasSearchCommodityCardParam$mIsLandscapeInt$2(this));
        this.f451615e = LazyKt.lazy(new ECSaasSearchCommodityCardParam$mCurrentTabName$2(this));
        this.f451616f = LazyKt.lazy(ECSaasSearchCommodityCardParam$mSearchPageEnterFrom$2.INSTANCE);
    }
}
