package com.larus.uaigc.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.LoadingWithRetryView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusPageTemplateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f373246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f373247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SwipeRefreshLayout f373248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LoadingWithRetryView f373249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f373250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f373251f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373246a;
    }

    public LarusPageTemplateBinding(ConstraintLayout r100, RecyclerView r101, SwipeRefreshLayout r102, LoadingWithRetryView r103, RecyclerView r104, FrameLayout r105) {
        this.f373246a = r100;
        this.f373247b = r101;
        this.f373248c = r102;
        this.f373249d = r103;
        this.f373250e = r104;
        this.f373251f = r105;
    }
}
