package com.larus.profile.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusPageProfileInfoErrorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f366509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f366510b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f366509a;
    }

    public static LarusPageProfileInfoErrorBinding a(View r100) {
        int r101 = R.id.profile_info_error_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.profile_info_error_icon)) == null) goto L9;
        r101 = R.id.profile_info_error_text;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.profile_info_error_text)) == null) goto L9;
        ConstraintLayout r102 = (ConstraintLayout) r100;
        return new LarusPageProfileInfoErrorBinding(r102, r102);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusPageProfileInfoErrorBinding(ConstraintLayout r100, ConstraintLayout r101) {
        this.f366509a = r100;
        this.f366510b = r101;
    }
}
