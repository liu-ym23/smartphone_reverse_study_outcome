package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusCreateMenuItemLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f326628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f326629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f326630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f326631d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326628a;
    }

    public LarusCreateMenuItemLayoutBinding(View r100, SimpleDraweeView r101, LinearLayout r102, AppCompatTextView r103, SimpleDraweeView r104, AppCompatTextView r105, AppCompatTextView r106, ConstraintLayout r107, SimpleDraweeView r108, AppCompatTextView r110, FrameLayout r111) {
        this.f326628a = r100;
        this.f326629b = r101;
        this.f326630c = r104;
        this.f326631d = r111;
    }
}
