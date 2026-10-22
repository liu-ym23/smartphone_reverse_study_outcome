package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraHSimplifiedCompletionBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f332677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f332678c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332676a;
    }

    public LarusDoraHSimplifiedCompletionBinding(ConstraintLayout r100, SimpleDraweeView r101, FrameLayout r102) {
        this.f332676a = r100;
        this.f332677b = r101;
        this.f332678c = r102;
    }
}
