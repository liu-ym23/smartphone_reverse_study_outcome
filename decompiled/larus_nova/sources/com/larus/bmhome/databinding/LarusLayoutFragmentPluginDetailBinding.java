package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutFragmentPluginDetailBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f311026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f311027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f311028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f311029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f311030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f311031f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311026a;
    }

    public LarusLayoutFragmentPluginDetailBinding(ConstraintLayout r100, TextView r101, AppCompatImageView r102, TextView r103, SimpleDraweeView r104, TextView r105) {
        this.f311026a = r100;
        this.f311027b = r101;
        this.f311028c = r102;
        this.f311029d = r103;
        this.f311030e = r104;
        this.f311031f = r105;
    }
}
