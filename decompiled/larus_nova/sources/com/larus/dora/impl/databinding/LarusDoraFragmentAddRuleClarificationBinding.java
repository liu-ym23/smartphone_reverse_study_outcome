package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.MaxHeightRecyclerView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraFragmentAddRuleClarificationBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayoutCompat f332544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f332545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f332546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f332547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MaxHeightRecyclerView f332548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DoraTextView f332549g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332543a;
    }

    public LarusDoraFragmentAddRuleClarificationBinding(ConstraintLayout r100, LinearLayoutCompat r101, ProgressBar r102, TextView r103, TextView r104, MaxHeightRecyclerView r105, DoraTextView r106) {
        this.f332543a = r100;
        this.f332544b = r101;
        this.f332545c = r102;
        this.f332546d = r103;
        this.f332547e = r104;
        this.f332548f = r105;
        this.f332549g = r106;
    }
}
