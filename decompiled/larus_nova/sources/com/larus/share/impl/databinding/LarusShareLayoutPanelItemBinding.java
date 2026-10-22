package com.larus.share.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusShareLayoutPanelItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f368622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f368623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f368624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProgressBar f368625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f368626e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f368622a;
    }

    public LarusShareLayoutPanelItemBinding(LinearLayout r100, FrameLayout r101, ImageView r102, ProgressBar r103, TextView r104) {
        this.f368622a = r100;
        this.f368623b = r101;
        this.f368624c = r102;
        this.f368625d = r103;
        this.f368626e = r104;
    }
}
