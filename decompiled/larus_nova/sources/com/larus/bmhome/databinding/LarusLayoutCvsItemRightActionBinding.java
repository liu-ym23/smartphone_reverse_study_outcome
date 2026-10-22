package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.RedDotTextView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutCvsItemRightActionBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f311016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f311017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RedDotTextView f311018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f311019d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311016a;
    }

    public LarusLayoutCvsItemRightActionBinding(View r100, FrameLayout r101, RedDotTextView r102, SimpleDraweeView r103) {
        this.f311016a = r100;
        this.f311017b = r101;
        this.f311018c = r102;
        this.f311019d = r103;
    }
}
