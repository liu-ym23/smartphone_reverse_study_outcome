package com.larus.image.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusLayoutCommonDownLoadBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f350930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f350931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f350932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f350933d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f350930a;
    }

    public LarusLayoutCommonDownLoadBinding(View r100, ImageView r101, ProgressBar r102, AppCompatTextView r103) {
        this.f350930a = r100;
        this.f350931b = r101;
        this.f350932c = r102;
        this.f350933d = r103;
    }
}
