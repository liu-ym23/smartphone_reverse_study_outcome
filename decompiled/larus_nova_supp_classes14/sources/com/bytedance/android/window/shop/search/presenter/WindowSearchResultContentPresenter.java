package com.bytedance.android.window.shop.search.presenter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.window.shop.search.fragment.WindowSearchResultListFragment;
import com.bytedance.android.window.shop.search.router.ECWindowSearchParam;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchResultViewModel;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowSearchResultContentPresenter extends QPresenter {
    public final Lazy e;
    public final Fragment f;

    public WindowSearchResultContentPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.f = r2;
        this.e = LazyKt.lazy(new WindowSearchResultContentPresenter$viewModel$2(this));
    }

    public final void A(QModel r5) {
        ECWindowSearchParam r6 = ((WindowSearchResultViewModel) this.e.getValue()).getSearchParam();
        int r0 = WindowSearchResultListFragment.g;
        Intrinsics.checkNotNullParameter(r6, "searchParam");
        WindowSearchResultListFragment r1 = new WindowSearchResultListFragment();
        Bundle r2 = new Bundle();
        r2.putSerializable("store_param", r6);
        Unit r7 = Unit.INSTANCE;
        r1.setArguments(r2);
        FragmentTransaction r8 = this.f.getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131387415) == true) goto L6;
        r8 = r8.replace(2131387415, r1);
    L6:
        r8.commitAllowingStateLoss();
    }
}
