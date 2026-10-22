package com.larus.profile.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.bigimg.widget.LeftCreationEditView;
import com.larus.bmhome.bigimg.widget.NumericIndicator;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusCreationPagerLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f366433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LeftCreationEditView f366434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NumericIndicator f366435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f366436d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f366433a;
    }

    public LarusCreationPagerLayoutBinding(ConstraintLayout r100, LeftCreationEditView r101, NumericIndicator r102, FrameLayout r103) {
        this.f366433a = r100;
        this.f366434b = r101;
        this.f366435c = r102;
        this.f366436d = r103;
    }
}
