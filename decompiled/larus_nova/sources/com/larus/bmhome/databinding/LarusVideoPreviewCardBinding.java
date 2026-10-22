package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusVideoPreviewCardBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f311274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f311275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f311276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f311277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProgressBar f311278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f311279f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311274a;
    }

    public LarusVideoPreviewCardBinding(ConstraintLayout r100, FrameLayout r101, SimpleDraweeView r102, ImageView r103, ProgressBar r104, TextView r105) {
        this.f311274a = r100;
        this.f311275b = r101;
        this.f311276c = r102;
        this.f311277d = r103;
        this.f311278e = r104;
        this.f311279f = r105;
    }
}
