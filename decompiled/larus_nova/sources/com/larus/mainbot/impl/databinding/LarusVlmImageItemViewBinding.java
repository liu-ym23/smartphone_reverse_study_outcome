package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundTextView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusVlmImageItemViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f358824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f358825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f358826c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358824a;
    }

    public LarusVlmImageItemViewBinding(ConstraintLayout r100, SimpleDraweeView r101, RoundTextView r102, SimpleDraweeView r103, TextView r104, View r105) {
        this.f358824a = r100;
        this.f358825b = r101;
        this.f358826c = r105;
    }
}
