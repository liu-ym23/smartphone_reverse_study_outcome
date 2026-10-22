package com.bytedance.android.shopping.mall.feed.opt;

import com.bytedance.android.ec.hybrid.data.g;
import com.bytedance.android.shopping.api.mall.IECMallAddressService;
import com.bytedance.android.shopping.api.mall.feed.IECMallFeedService;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.mall.feed.ECMallFeedOptService;
import com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SaasHomepagePrefetch implements g {
    public final Lazy a;
    public final Object b;
    public volatile Pair<String, HomePageDTO> c;
    public volatile boolean d;
    public Function2<? super String, ? super HomePageDTO, Unit> e;
    public Function0<Unit> f;
    public final a.C0088a g;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.opt.SaasHomepagePrefetch$a$a, reason: collision with other inner class name */
        public static final class C0088a {
            public final String a;
            public final Map<String, String> b;

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof C0088a) == false) goto L10;
                C0088a r4 = (C0088a) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public final int hashCode() {
                String r0 = this.a;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                Map<String, String> r4 = this.b;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "SaasHomePrefetchParams(pageName=" + this.a + ", requestParams=" + this.b + ")";
            }

            public C0088a(String r2, Map<String, String> r3) {
                Intrinsics.checkNotNullParameter(r2, "pageName");
                Intrinsics.checkNotNullParameter(r3, "requestParams");
                this.a = r2;
                this.b = r3;
            }
        }
    }

    static {
    }

    public final /* synthetic */ void g(Map r1, String r2) {
    }

    public SaasHomepagePrefetch(a.C0088a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.g = r2;
        this.a = LazyKt.lazy(new SaasHomepagePrefetch$fetcher$2(this));
        this.b = new Object();
    }

    public final Map<String, Object> a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "apiKey");
        HashMap r5 = new HashMap();
        r5.put(PdpOpenThirdParam.KEY_PAGE_NAME, this.g.a);
        r5.put("cursor", "0");
        r5.put("page_num", "1");
        r5.put(SimilarProductParam.ENTER_FROM, "");
        r5.put("recommend_back_up_offset", "0");
        IECMallAddressService r0 = (IECMallAddressService) ServiceManager.get().getService(IECMallAddressService.class);
        if (r0 == null) goto L15;
        String r1 = null;
        String r2 = r0.getAddress(null, "a1.b1923.c0.d0");
        if (r2 == null) goto L15;
        if (r2.length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        r1 = r2;
    L12:
        if (r1 == null) goto L15;
        r5.put("ec_address_data", r1);
        goto L15
    L9:
        r3 = false;
    L15:
        if (Intrinsics.areEqual(this.g.a, "order_list_page") == false) goto L21;
        IECMallFeedService r6 = (IECMallFeedService) ServiceManager.get().getService(IECMallFeedService.class);
        if (r6 == null) goto L22;
        ECMallFeedOptService r7 = r6.c();
        if (r7 == null) goto L22;
        r5.putAll(r7.b(this.g.b));
    L22:
        ECMallFavoriteSectionHelper.K.getClass();
        if (Intrinsics.areEqual(ECMallFavoriteSectionHelper.a.a().a(), Boolean.TRUE) == false) goto L25;
        r5.put("is_active_refresh", Boolean.FALSE);
    L25:
        return r5;
    L21:
        r5.putAll(this.g.b);
        goto L22
    }

    public final Map c(List r1) {
        return new HashMap();
    }

    public final Map d(String r1) {
        return new HashMap();
    }

    public final Map e(String r1, String r2) {
        return new HashMap();
    }

    public final Map f(String r1, Map r2) {
        return new HashMap();
    }

    public final Map b(String r1, String r2, Map r3) {
        return new HashMap();
    }
}
