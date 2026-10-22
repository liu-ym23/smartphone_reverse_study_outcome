package com.larus.livetutor.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.livetutor.impl.view.error.DefaultErrorView;

/* JADX INFO: loaded from: classes30.dex */
public final class LiveTutorHomeFeedContaierBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f355965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DefaultErrorView f355966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f355967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SwipeRefreshLayout f355968d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f355965a;
    }

    public LiveTutorHomeFeedContaierBinding(FrameLayout r100, DefaultErrorView r101, RecyclerView r102, SwipeRefreshLayout r103) {
        this.f355965a = r100;
        this.f355966b = r101;
        this.f355967c = r102;
        this.f355968d = r103;
    }
}
