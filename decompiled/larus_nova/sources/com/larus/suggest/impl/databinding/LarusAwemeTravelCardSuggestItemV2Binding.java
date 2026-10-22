package com.larus.suggest.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusAwemeTravelCardSuggestItemV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f369812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f369813b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f369812a;
    }

    public LarusAwemeTravelCardSuggestItemV2Binding(ConstraintLayout r100, SimpleDraweeView r101, TextView r102) {
        this.f369812a = r100;
        this.f369813b = r101;
    }
}
