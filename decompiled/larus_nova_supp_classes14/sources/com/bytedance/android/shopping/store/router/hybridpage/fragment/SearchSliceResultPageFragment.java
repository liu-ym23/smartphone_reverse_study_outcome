package com.bytedance.android.shopping.store.router.hybridpage.fragment;

import android.os.Bundle;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.store.router.hybridpage.slice.SliceProductCardData;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/fragment/SearchSliceResultPageFragment;", "Lcom/bytedance/android/shopping/store/router/hybridpage/fragment/HybridPageFragment;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSliceResultPageFragment extends HybridPageFragment {
    public static final /* synthetic */ int h = 0;

    public static final class a {
    }

    static {
    }

    public SearchSliceResultPageFragment() {
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.fragment.HybridPageFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L5;
        Serializable r5 = r4.getSerializable("search_param");
    L6:
        if (r5 == null) goto L12;
        ECShopSearchParam r6 = (ECShopSearchParam) r5;
        HybridPageViewModel r0 = T90();
        SliceProductCardData.Companion.getClass();
        r0.setSliceProductCardData(SliceProductCardData.a.a(r6));
        T90().setSearchParam(r6);
        T90().setRouterQuery(T90().buildRouterQuery());
        T90().initEventParams();
        String r7 = T90().getConfigJsonUrl();
        if (r7 == null) goto L13;
        ECLiveHybridUtil.a r1 = ECLiveHybridUtil.a;
        ECLiveHybridUtil.g(r7, new SearchSliceResultPageFragment$parseConfigJsonData$$inlined$let$lambda$1(this));
        return;
    L13:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.search.router.ECShopSearchParam");
    L5:
        r5 = null;
        goto L6
    }
}
