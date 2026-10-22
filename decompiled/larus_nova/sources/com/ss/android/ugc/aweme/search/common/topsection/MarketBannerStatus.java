package com.ss.android.ugc.aweme.search.common.topsection;

import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerStatus;", "", "Banner", "NULL", "Slot", "UNDEFINED", "Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerStatus$Banner;", "Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerStatus$NULL;", "Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerStatus$Slot;", "Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerStatus$UNDEFINED;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MarketBannerStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f452230a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerStatus$Banner;", "Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerStatus;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Banner extends MarketBannerStatus {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SearchAggregateCommodity f452231b;

        public Banner(SearchAggregateCommodity r100) {
            Intrinsics.checkNotNullParameter(r100, "banner");
            super("banner");
            this.f452231b = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerStatus$NULL;", "Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerStatus;", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class NULL extends MarketBannerStatus {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final NULL f452232b = null;

        static {
            f452232b = new NULL();
        }

        private NULL() {
            super("null");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerStatus$Slot;", "Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerStatus;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Slot extends MarketBannerStatus {
        public Slot(SearchAggregateCommodity r100) {
            Intrinsics.checkNotNullParameter(r100, "slot");
            super("slot");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerStatus$UNDEFINED;", "Lcom/ss/android/ugc/aweme/search/common/topsection/MarketBannerStatus;", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UNDEFINED extends MarketBannerStatus {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final UNDEFINED f452233b = null;

        static {
            f452233b = new UNDEFINED();
        }

        private UNDEFINED() {
            super("undefined");
        }
    }

    public MarketBannerStatus(String r100) {
        this.f452230a = r100;
    }
}
