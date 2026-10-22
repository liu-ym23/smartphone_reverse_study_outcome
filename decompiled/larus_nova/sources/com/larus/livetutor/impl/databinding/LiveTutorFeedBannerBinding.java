package com.larus.livetutor.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LiveTutorFeedBannerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f355939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f355940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f355941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f355942d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f355939a;
    }

    public LiveTutorFeedBannerBinding(ConstraintLayout r100, TextView r101, TextView r102, TextView r103) {
        this.f355939a = r100;
        this.f355940b = r101;
        this.f355941c = r102;
        this.f355942d = r103;
    }
}
