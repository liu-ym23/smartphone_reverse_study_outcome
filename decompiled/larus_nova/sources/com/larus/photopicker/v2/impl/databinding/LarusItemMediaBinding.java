package com.larus.photopicker.v2.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.photopicker.v2.impl.ui.AspectRatioFrameLayout;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusItemMediaBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AspectRatioFrameLayout f364414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f364415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f364416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f364417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f364418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f364419f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f364414a;
    }

    public LarusItemMediaBinding(AspectRatioFrameLayout r100, SimpleDraweeView r101, AppCompatTextView r102, FrameLayout r103, View r104, AppCompatTextView r105) {
        this.f364414a = r100;
        this.f364415b = r101;
        this.f364416c = r102;
        this.f364417d = r103;
        this.f364418e = r104;
        this.f364419f = r105;
    }
}
