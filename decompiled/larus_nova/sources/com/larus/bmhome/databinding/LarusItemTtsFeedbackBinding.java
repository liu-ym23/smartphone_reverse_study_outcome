package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusItemTtsFeedbackBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f310997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f310998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f310999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f311000d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f310997a;
    }

    public LarusItemTtsFeedbackBinding(ConstraintLayout r100, TextView r101, SimpleDraweeView r102, AppCompatImageView r103) {
        this.f310997a = r100;
        this.f310998b = r101;
        this.f310999c = r102;
        this.f311000d = r103;
    }
}
