package com.bytedance.android.shopping.store.router.hybridpage.presenter.page;

import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.router.hybridpage.event.PageCardEventManager;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import com.bytedance.android.shopping.store.router.hybridpage.slice.SliceProductCardData;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/presenter/page/SearchResultPageCardPresenter;", "Lcom/bytedance/android/shopping/store/router/hybridpage/presenter/page/HybridPageCardPresenter;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchResultPageCardPresenter extends HybridPageCardPresenter {
    @Override // com.bytedance.android.shopping.store.router.hybridpage.presenter.page.HybridPageCardPresenter
    public final Map<String, Object> h0() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("ec_shop_search_result_hybrid_refactor", Integer.valueOf(((Number) HybridPageConfigSetting.c.getValue()).intValue()));
        return r0;
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.presenter.page.HybridPageCardPresenter
    public final String i0() {
        return ShopSliceUniqueId.SEARCH_RESULT_PAGE.getId();
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.presenter.page.HybridPageCardPresenter
    public final void k0() {
        ReentrantReadWriteLock r0 = PageCardEventManager.a;
        String r1 = j0().getSceneId();
        SliceProductCardData r2 = j0().getSliceProductCardData();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getSearchKeyword();
    L6:
        String r5 = "";
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        SliceProductCardData r6 = j0().getSliceProductCardData();
        if (r6 == null) goto L12;
        String r7 = r6.getSearchSource();
    L13:
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        SliceProductCardData r8 = j0().getSliceProductCardData();
        if (r8 == null) goto L18;
        r3 = r8.getSearchGroupID();
    L18:
        if (r3 == null) goto L21;
        r5 = r3;
    L21:
        PageCardEventManager.h(r1, r4, r7, r5);
        return;
    L12:
        r7 = null;
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    public SearchResultPageCardPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }
}
