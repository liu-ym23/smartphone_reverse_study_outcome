package com.larus.mainbot.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusMdSimpleImageGroupSingleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f358752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f358753b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358752a;
    }

    public LarusMdSimpleImageGroupSingleBinding(ConstraintLayout r100, SimpleDraweeView r101) {
        this.f358752a = r100;
        this.f358753b = r101;
    }
}
