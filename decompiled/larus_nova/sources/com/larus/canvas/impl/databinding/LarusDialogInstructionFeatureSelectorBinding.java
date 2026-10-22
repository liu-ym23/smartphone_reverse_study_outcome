package com.larus.canvas.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.roundlayout.RoundTextView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusDialogInstructionFeatureSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f323759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoundTextView f323760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f323761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NestedScrollView f323762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f323763e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f323759a;
    }

    public LarusDialogInstructionFeatureSelectorBinding(ConstraintLayout r100, RoundTextView r101, RecyclerView r102, NestedScrollView r103, View r104) {
        this.f323759a = r100;
        this.f323760b = r101;
        this.f323761c = r102;
        this.f323762d = r103;
        this.f323763e = r104;
    }
}
