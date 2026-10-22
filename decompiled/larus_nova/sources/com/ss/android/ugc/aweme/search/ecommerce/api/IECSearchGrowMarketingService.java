package com.ss.android.ugc.aweme.search.ecommerce.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.marketing.GetGeckoResPreloadServiceHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/ecommerce/api/IECSearchGrowMarketingService;", "", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECSearchGrowMarketingService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f452769a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/ecommerce/api/IECSearchGrowMarketingService$Companion;", "", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f452770a = null;

        private Companion() {
        }

        static {
            f452770a = new Companion();
        }

        @JvmStatic
        public static IECSearchGrowMarketingService a() {
            GetGeckoResPreloadServiceHelper.f451265a.getClass();
            return (IECSearchGrowMarketingService) ServiceManager.get().getService(IECSearchGrowMarketingService.class);
        }
    }

    static {
        f452769a = Companion.f452770a;
    }

    void a();

    void b(String r100);
}
