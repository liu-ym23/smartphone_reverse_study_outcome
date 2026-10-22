package com.ss.android.ugc.aweme.search.common.topsection;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import com.ss.android.ugc.aweme.discover.model.SearchShopWindowControlInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerAbility;", "Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerApi;", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MarketBannerAbility implements MarketBannerApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f452226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MarketBannerViewAbility f452227b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerAbility$Companion;", "", "()V", "TAG", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public MarketBannerAbility(MarketBannerViewAbility r100) {
        Intrinsics.checkNotNullParameter(r100, "bannerViewAbility");
        this.f452227b = r100;
        this.f452226a = LazyKt.lazy(MarketBannerAbility$status$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.ugc.aweme.search.common.topsection.MarketBannerApi
    public final void a(SearchAggregateCommodity r100) {
        Intrinsics.checkNotNullParameter(r100, "banner");
        Intrinsics.checkNotNullParameter(r100, "$this$isMarketBannerSlot");
        boolean r101 = false;
        MarketBannerStatus r102 = null;
        if (MarketBannerApiKt.a(r100) == false) goto L11;
        SearchShopWindowControlInfo r103 = r100.getControlInfo();
        if (r103 == null) goto L7;
        String r104 = r103.getCardSlotType();
    L9:
        if (Intrinsics.areEqual(r104, "ecom_search_marketing_banner") == false) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        MarketBannerStatus r106 = new MarketBannerStatus.Slot(r100);
    L27:
        if ((!Intrinsics.areEqual(r106, MarketBannerStatus.UNDEFINED.f452233b)) == false) goto L29;
        r102 = r106;
    L29:
        if (r102 != null) goto L31;
        return;
    L31:
        MarketBannerStatus r107 = (MarketBannerStatus) ((MutableLiveData) this.f452226a.getValue()).getValue();
        if ((r102 instanceof MarketBannerStatus.Slot) == false) goto L38;
        if (r107 != null) goto L35;
    L36:
        MarketBannerRenderIntent r108 = new MarketBannerRenderIntent(r102, r107);
        String r109 = r108.f452228a.f452230a;
        ((MutableLiveData) this.f452226a.getValue()).setValue(r108.f452228a);
        this.f452227b.a(r108);
        return;
    L35:
        if (Intrinsics.areEqual(r107, MarketBannerStatus.NULL.f452232b) == true) goto L36;
        return;
    L38:
        if ((r102 instanceof MarketBannerStatus.Banner) == false) goto L43;
        MarketBannerRenderIntent r110 = new MarketBannerRenderIntent(r102, r107);
        String r111 = r110.f452228a.f452230a;
        ((MutableLiveData) this.f452226a.getValue()).setValue(r110.f452228a);
        this.f452227b.a(r110);
        return;
    L43:
        return;
    L14:
        Intrinsics.checkNotNullParameter(r100, "$this$isMarketBanner");
        if (MarketBannerApiKt.a(r100) == false) goto L23;
        SearchShopWindowControlInfo r112 = r100.getControlInfo();
        if (r112 == null) goto L19;
        String r113 = r112.getCardSlotType();
    L21:
        if ((!Intrinsics.areEqual(r113, "ecom_search_marketing_banner")) == false) goto L23;
        r101 = true;
        goto L23
    L19:
        r113 = null;
    L23:
        if (r101 == false) goto L25;
        r106 = new MarketBannerStatus.Banner(r100);
        goto L27
    L25:
        r106 = MarketBannerStatus.UNDEFINED.f452233b;
        goto L27
    L7:
        r104 = null;
    L11:
        r105 = false;
        goto L12
    }
}
