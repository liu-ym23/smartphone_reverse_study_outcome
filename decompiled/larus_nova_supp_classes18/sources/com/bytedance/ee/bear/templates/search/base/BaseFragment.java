package com.bytedance.ee.bear.templates.search.base;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\rH&J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0007H&J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/templates/search/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "presenter", "Lcom/bytedance/ee/bear/templates/search/base/BasePresenter;", "searchView", "Lcom/bytedance/ee/bear/templates/search/base/ISearchListView;", "getSearchView", "()Lcom/bytedance/ee/bear/templates/search/base/ISearchListView;", "setSearchView", "(Lcom/bytedance/ee/bear/templates/search/base/ISearchListView;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initMVP", "rootView", "getIModel", "Lcom/bytedance/ee/bear/templates/search/base/ISearchListModel;", "getIView", "getIPresenter", "model", "onDestroyView", "setUserVisibleHint", "isVisibleToUser", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseFragment extends Fragment {
    public BasePresenter d;
    public f e;

    public abstract e S90();

    public abstract BasePresenter T90(e r1, f r2);

    public abstract f U90(View r1);

    public final void onDestroyView() {
        super.onDestroyView();
        BasePresenter r0 = this.d;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public BaseFragment() {
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        f r3 = this.e;
        if (r3 == null) goto L6;
        r3.b();
        return;
    }

    public final void setUserVisibleHint(boolean r2) {
        f r0 = this.e;
        if (r0 == null) goto L5;
        r0.d3(r2);
    L5:
        super.setUserVisibleHint(r2);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        BasePresenter r4 = T90(S90(), U90(r2));
        this.d = r4;
        if (r4 == null) goto L6;
        r4.create();
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561250, r3, false);
    }
}
