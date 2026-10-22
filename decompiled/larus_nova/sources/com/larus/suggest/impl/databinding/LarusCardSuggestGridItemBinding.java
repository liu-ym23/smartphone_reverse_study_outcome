package com.larus.suggest.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusCardSuggestGridItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f369814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f369815b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f369814a;
    }

    public LarusCardSuggestGridItemBinding(ConstraintLayout r100, SimpleDraweeView r101, TextView r102, TextView r103, SimpleDraweeView r104) {
        this.f369814a = r100;
        this.f369815b = r104;
    }
}
