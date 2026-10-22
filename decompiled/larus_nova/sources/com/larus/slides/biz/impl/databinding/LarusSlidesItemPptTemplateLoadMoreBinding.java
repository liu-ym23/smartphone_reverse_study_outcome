package com.larus.slides.biz.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusSlidesItemPptTemplateLoadMoreBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f369355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayoutCompat f369356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f369357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f369358d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f369355a;
    }

    public LarusSlidesItemPptTemplateLoadMoreBinding(ConstraintLayout r100, LinearLayoutCompat r101, ProgressBar r102, AppCompatTextView r103) {
        this.f369355a = r100;
        this.f369356b = r101;
        this.f369357c = r102;
        this.f369358d = r103;
    }
}
