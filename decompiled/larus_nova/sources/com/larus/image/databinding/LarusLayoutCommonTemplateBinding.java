package com.larus.image.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusLayoutCommonTemplateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f350934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f350935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f350936c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f350934a;
    }

    public LarusLayoutCommonTemplateBinding(View r100, AppCompatTextView r101, ImageView r102) {
        this.f350934a = r100;
        this.f350935b = r101;
        this.f350936c = r102;
    }
}
