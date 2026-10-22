package com.larus.dora.o.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.refresh.SuperSwipeRefreshLayout;
import com.larus.dora.o.impl.memory.OViewPager2FixLayout;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraOFragmentMemoryEventBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OViewPager2FixLayout f338382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f338383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f338384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProgressBar f338385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SuperSwipeRefreshLayout f338386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f338387f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f338382a;
    }

    public DoraOFragmentMemoryEventBinding(OViewPager2FixLayout r100, TextView r101, RecyclerView r102, ProgressBar r103, SuperSwipeRefreshLayout r104, TextView r105) {
        this.f338382a = r100;
        this.f338383b = r101;
        this.f338384c = r102;
        this.f338385d = r103;
        this.f338386e = r104;
        this.f338387f = r105;
    }
}
