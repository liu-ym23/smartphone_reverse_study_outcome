package com.larus.community.impl.databinding;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusCommunityCreationFeedComponentLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SwipeRefreshLayout f329078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f329079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SwipeRefreshLayout f329080c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f329078a;
    }

    public LarusCommunityCreationFeedComponentLayoutBinding(SwipeRefreshLayout r100, RecyclerView r101, SwipeRefreshLayout r102) {
        this.f329078a = r100;
        this.f329079b = r101;
        this.f329080c = r102;
    }
}
