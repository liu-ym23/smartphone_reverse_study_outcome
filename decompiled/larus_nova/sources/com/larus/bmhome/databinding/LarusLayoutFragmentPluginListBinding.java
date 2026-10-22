package com.larus.bmhome.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutFragmentPluginListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f311032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f311033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f311034c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311032a;
    }

    public LarusLayoutFragmentPluginListBinding(ConstraintLayout r100, AppCompatImageView r101, RecyclerView r102) {
        this.f311032a = r100;
        this.f311033b = r101;
        this.f311034c = r102;
    }
}
