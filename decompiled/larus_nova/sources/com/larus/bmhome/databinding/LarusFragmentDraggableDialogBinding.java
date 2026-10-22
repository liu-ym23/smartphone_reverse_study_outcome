package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusFragmentDraggableDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f310893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f310894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f310895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProgressBar f310896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f310897e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f310893a;
    }

    public LarusFragmentDraggableDialogBinding(ConstraintLayout r100, View r101, ProgressBar r102, ProgressBar r103, RecyclerView r104) {
        this.f310893a = r100;
        this.f310894b = r101;
        this.f310895c = r102;
        this.f310896d = r103;
        this.f310897e = r104;
    }
}
