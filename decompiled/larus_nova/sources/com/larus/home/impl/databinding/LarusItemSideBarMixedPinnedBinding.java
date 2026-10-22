package com.larus.home.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusItemSideBarMixedPinnedBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f344312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f344313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f344314c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f344312a;
    }

    public LarusItemSideBarMixedPinnedBinding(ConstraintLayout r100, SimpleDraweeView r101, TextView r102) {
        this.f344312a = r100;
        this.f344313b = r101;
        this.f344314c = r102;
    }
}
