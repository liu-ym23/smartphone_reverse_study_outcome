package com.larus.ugc.feed.impl.databinding;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusCommunityCreationFeedComponentLayoutKmpBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SwipeRefreshLayout f374725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f374726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SwipeRefreshLayout f374727c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f374725a;
    }

    public LarusCommunityCreationFeedComponentLayoutKmpBinding(SwipeRefreshLayout r100, RecyclerView r101, SwipeRefreshLayout r102) {
        this.f374725a = r100;
        this.f374726b = r101;
        this.f374727c = r102;
    }
}
