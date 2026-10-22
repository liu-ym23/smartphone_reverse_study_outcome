package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDialogServiceNotificationSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f332508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f332509c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332507a;
    }

    public LarusDoraDialogServiceNotificationSheetBinding(ConstraintLayout r100, RecyclerView r101, AppCompatImageView r102) {
        this.f332507a = r100;
        this.f332508b = r101;
        this.f332509c = r102;
    }
}
