package com.larus.drive.sdk.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusItemBaseFileSelectBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f341739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f341740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f341741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f341742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f341743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f341744f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f341739a;
    }

    public LarusItemBaseFileSelectBinding(ConstraintLayout r100, AppCompatImageView r101, View r102, AppCompatTextView r103, SimpleDraweeView r104, AppCompatTextView r105) {
        this.f341739a = r100;
        this.f341740b = r101;
        this.f341741c = r102;
        this.f341742d = r103;
        this.f341743e = r104;
        this.f341744f = r105;
    }
}
