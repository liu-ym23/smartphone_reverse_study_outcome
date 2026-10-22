package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.TitleAvatarImageView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusLayoutLeftAvatarBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f326761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TitleAvatarImageView f326762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f326763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f326764d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326761a;
    }

    public LarusLayoutLeftAvatarBinding(ConstraintLayout r100, TitleAvatarImageView r101, TextView r102, TextView r103) {
        this.f326761a = r100;
        this.f326762b = r101;
        this.f326763c = r102;
        this.f326764d = r103;
    }
}
