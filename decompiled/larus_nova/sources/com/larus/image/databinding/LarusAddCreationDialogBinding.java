package com.larus.image.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusAddCreationDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f350909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f350910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f350911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f350912d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f350909a;
    }

    public LarusAddCreationDialogBinding(ConstraintLayout r100, AppCompatImageView r101, AppCompatTextView r102, AppCompatTextView r103) {
        this.f350909a = r100;
        this.f350910b = r101;
        this.f350911c = r102;
        this.f350912d = r103;
    }
}
