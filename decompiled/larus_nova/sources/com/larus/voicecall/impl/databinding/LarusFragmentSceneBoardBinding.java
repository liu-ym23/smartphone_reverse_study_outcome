package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusFragmentSceneBoardBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f378231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f378232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f378233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f378234d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f378231a;
    }

    public LarusFragmentSceneBoardBinding(LinearLayout r100, View r101, RecyclerView r102, ConstraintLayout r103, View r104) {
        this.f378231a = r100;
        this.f378232b = r101;
        this.f378233c = r102;
        this.f378234d = r104;
    }
}
