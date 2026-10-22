package com.ss.android.ugc.aweme.search.common.saas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.search.common.helper.ECSearchAdapterHelper;
import com.ss.android.ugc.aweme.search.common.manager.ECSearchSaaSCommodityRelatedWordsFactory;
import com.ss.android.ugc.aweme.search.common.manager.ECSearchSaaSDoubleAnniexFactory;
import com.ss.android.ugc.aweme.search.common.manager.ECSearchSaaSDoubleImageCommodityFeedBoxBannerFactory;
import com.ss.android.ugc.aweme.search.common.manager.ECSearchSaaSInstantAddressFactory;
import com.ss.android.ugc.aweme.search.common.manager.ECSearchSaaSSingleAnniexFactory;
import com.ss.android.ugc.aweme.search.common.manager.ECSearchSaaSSingleImageCommodityFeedBoxBannerFactory;
import com.ss.android.ugc.aweme.search.common.manager.ECSearchSaaSTitleFactory;
import com.ss.android.ugc.aweme.search.common.manager.ECSearchViewHolderRegisterV2;
import com.ss.android.ugc.aweme.search.model.SearchEnterParam;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import com.ss.android.ugc.aweme.search.paas.ECSearchRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/ECSearchSaaSDepsHelper;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchSaaSDepsHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchSaaSDepsHelper f451981a = null;

    private ECSearchSaaSDepsHelper() {
    }

    static {
        f451981a = new ECSearchSaaSDepsHelper();
    }

    public static void c() {
        ECSearchViewHolderRegisterV2.f451724a.getClass();
        ECSearchAdapterHelper r100 = ECSearchAdapterHelper.f451621b;
        ECSearchSaaSSingleAnniexFactory r101 = new ECSearchSaaSSingleAnniexFactory();
        r100.getClass();
        ECSearchAdapterHelper.b(r101);
        ECSearchAdapterHelper.b(new ECSearchSaaSDoubleAnniexFactory());
        ECSearchAdapterHelper.b(new ECSearchSaaSTitleFactory());
        ECSearchAdapterHelper.b(new ECSearchSaaSDoubleImageCommodityFeedBoxBannerFactory());
        ECSearchAdapterHelper.b(new ECSearchSaaSSingleImageCommodityFeedBoxBannerFactory());
        ECSearchAdapterHelper.b(new ECSearchSaaSCommodityRelatedWordsFactory());
        ECSearchAdapterHelper.b(new ECSearchSaaSInstantAddressFactory());
    }

    public static View a(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return LayoutInflater.from(r100.getContext()).inflate(r101, r100, false);
    }

    public static void b(ECSearchSaaSDepsHelper r100, Context r101, SearchResultParam r110, SearchEnterParam r111) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "searchResultParam");
        Intrinsics.checkNotNullParameter(r111, "searchEnterParam");
        ((ECSearchRouteApi) ServiceManager.get().getService(ECSearchRouteApi.class)).routeToECSearch(r101, r110, r111, null, null, 1000);
    }
}
