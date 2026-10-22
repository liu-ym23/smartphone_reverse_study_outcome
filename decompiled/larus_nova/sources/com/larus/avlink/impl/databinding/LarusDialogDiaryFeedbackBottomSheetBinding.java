package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.chip.ChipGroup;

/* JADX INFO: loaded from: classes25.dex */
public final class LarusDialogDiaryFeedbackBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f293177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EditText f293178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ChipGroup f293179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f293180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f293181f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293176a;
    }

    public LarusDialogDiaryFeedbackBottomSheetBinding(ConstraintLayout r100, ImageView r101, EditText r102, ChipGroup r103, TextView r104, TextView r105) {
        this.f293176a = r100;
        this.f293177b = r101;
        this.f293178c = r102;
        this.f293179d = r103;
        this.f293180e = r104;
        this.f293181f = r105;
    }
}
