package com.larus.business.search.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusItemSearchLoadMoreBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f321226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f321227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f321228c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321226a;
    }

    public LarusItemSearchLoadMoreBinding(ConstraintLayout r100, LinearLayout r101, ProgressBar r102) {
        this.f321226a = r100;
        this.f321227b = r101;
        this.f321228c = r102;
    }
}
