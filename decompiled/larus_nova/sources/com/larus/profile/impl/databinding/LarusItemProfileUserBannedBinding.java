package com.larus.profile.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusItemProfileUserBannedBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f366485a;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f366485a;
    }

    public LarusItemProfileUserBannedBinding(ConstraintLayout r100) {
        this.f366485a = r100;
    }

    public static LarusItemProfileUserBannedBinding a(View r100) {
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.profile_status_warning)) == null) goto L7;
        return new LarusItemProfileUserBannedBinding((ConstraintLayout) r100);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(R.id.profile_status_warning)));
    }
}
