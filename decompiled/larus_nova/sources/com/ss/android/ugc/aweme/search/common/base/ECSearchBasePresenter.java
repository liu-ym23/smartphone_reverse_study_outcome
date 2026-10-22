package com.ss.android.ugc.aweme.search.common.base;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/base/ECSearchBasePresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECSearchBasePresenter extends QFragmentPresenter implements LifecycleObserver {
    public ECSearchBasePresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }
}
