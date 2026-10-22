package com.larus.instruction.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.roundlayout.RoundTextView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusDialogInstructionFeatureSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f351542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoundTextView f351543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f351544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NestedScrollView f351545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f351546e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f351542a;
    }

    public LarusDialogInstructionFeatureSelectorBinding(ConstraintLayout r100, RoundTextView r101, RecyclerView r102, NestedScrollView r103, View r104) {
        this.f351542a = r100;
        this.f351543b = r101;
        this.f351544c = r102;
        this.f351545d = r103;
        this.f351546e = r104;
    }
}
