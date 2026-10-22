package com.larus.business.search.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.search.SearchBar;
import com.larus.common_ui.widget.LoadingWithRetryView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusFragmentCombineSearchBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f321213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LoadingWithRetryView f321214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SearchBar f321215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f321216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f321217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RecyclerView f321218f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321213a;
    }

    public LarusFragmentCombineSearchBinding(RelativeLayout r100, LoadingWithRetryView r101, SearchBar r102, FrameLayout r103, RecyclerView r104, RecyclerView r105) {
        this.f321213a = r100;
        this.f321214b = r101;
        this.f321215c = r102;
        this.f321216d = r103;
        this.f321217e = r104;
        this.f321218f = r105;
    }
}
