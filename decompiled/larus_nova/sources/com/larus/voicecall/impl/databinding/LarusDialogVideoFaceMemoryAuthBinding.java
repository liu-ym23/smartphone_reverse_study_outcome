package com.larus.voicecall.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusDialogVideoFaceMemoryAuthBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f378227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f378228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatButton f378229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f378230d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f378227a;
    }

    public LarusDialogVideoFaceMemoryAuthBinding(ConstraintLayout r100, AppCompatImageView r101, AppCompatButton r102, AppCompatTextView r103) {
        this.f378227a = r100;
        this.f378228b = r101;
        this.f378229c = r102;
        this.f378230d = r103;
    }
}
