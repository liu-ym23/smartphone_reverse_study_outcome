package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes25.dex */
public final class LayoutRecordLoadingOrRetryViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProgressBar f293336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f293337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f293338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f293339e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293335a;
    }

    public LayoutRecordLoadingOrRetryViewBinding(ConstraintLayout r100, ProgressBar r101, TextView r102, ImageView r103, TextView r104) {
        this.f293335a = r100;
        this.f293336b = r101;
        this.f293337c = r102;
        this.f293338d = r103;
        this.f293339e = r104;
    }
}
