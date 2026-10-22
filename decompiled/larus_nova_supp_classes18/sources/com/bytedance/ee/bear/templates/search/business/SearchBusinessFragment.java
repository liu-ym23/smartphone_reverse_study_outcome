package com.bytedance.ee.bear.templates.search.business;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.templates.search.base.BaseFragment;
import com.bytedance.ee.bear.templates.search.base.BasePresenter;
import com.bytedance.ee.bear.templates.search.base.BaseView;
import com.bytedance.ee.bear.templates.search.base.e;
import com.bytedance.ee.bear.templates.search.base.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/templates/search/business/SearchBusinessFragment;", "Lcom/bytedance/ee/bear/templates/search/base/BaseFragment;", "<init>", "()V", "getIModel", "Lcom/bytedance/ee/bear/templates/search/base/ISearchListModel;", "getIView", "Lcom/bytedance/ee/bear/templates/search/base/ISearchListView;", "rootView", "Landroid/view/View;", "getIPresenter", "Lcom/bytedance/ee/bear/templates/search/base/BasePresenter;", "model", "view", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchBusinessFragment extends BaseFragment {
    public static final /* synthetic */ int f = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.templates.search.base.BaseFragment
    public final e S90() {
        FragmentActivity r1 = getActivity();
        Intrinsics.checkNotNull(r1);
        return new do5.a(r1);
    }

    public SearchBusinessFragment() {
    }

    @Override // com.bytedance.ee.bear.templates.search.base.BaseFragment
    public final f U90(View r4) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        FragmentActivity r1 = getActivity();
        Intrinsics.checkNotNull(r1);
        BaseView r0 = new BaseView(r1, this, r4, 6);
        this.e = r0;
        r0.d3(getUserVisibleHint());
        return r0;
    }

    @Override // com.bytedance.ee.bear.templates.search.base.BaseFragment
    public final BasePresenter T90(e r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        return new BasePresenter(this, r2, r3);
    }
}
