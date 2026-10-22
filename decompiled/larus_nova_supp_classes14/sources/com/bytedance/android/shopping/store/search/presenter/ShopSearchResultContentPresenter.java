package com.bytedance.android.shopping.store.search.presenter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.shopping.store.router.hybridpage.fragment.SearchSliceResultPageFragment;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import com.bytedance.android.shopping.store.search.fragment.ShopSearchResultListFragment;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchResultViewModel;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopSearchResultContentPresenter extends QPresenter {
    public final Lazy e;
    public final Fragment f;

    public ShopSearchResultContentPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.f = r2;
        this.e = LazyKt.lazy(new ShopSearchResultContentPresenter$viewModel$2(this));
    }

    public final void A(QModel r5) {
        ECShopSearchParam r6 = ((ShopSearchResultViewModel) this.e.getValue()).getSearchParam();
        if (HybridPageConfigSetting.d == false) goto L5;
        int r0 = SearchSliceResultPageFragment.h;
        Intrinsics.checkNotNullParameter(r6, "searchParam");
        Fragment r1 = new SearchSliceResultPageFragment();
        Bundle r2 = new Bundle();
        r2.putSerializable("search_param", r6);
        Unit r7 = Unit.INSTANCE;
        r1.setArguments(r2);
    L6:
        FragmentTransaction r8 = this.f.getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131387415) == true) goto L10;
        r8 = r8.replace(2131387415, r1);
    L10:
        r8.commitAllowingStateLoss();
        return;
    L5:
        int r3 = ShopSearchResultListFragment.h;
        Intrinsics.checkNotNullParameter(r6, "searchParam");
        r1 = new ShopSearchResultListFragment();
        Bundle r4 = new Bundle();
        r4.putSerializable("store_param", r6);
        Unit r9 = Unit.INSTANCE;
        r1.setArguments(r4);
        goto L6
    }
}
