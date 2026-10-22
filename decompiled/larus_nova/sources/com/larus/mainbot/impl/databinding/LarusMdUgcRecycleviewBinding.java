package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusMdUgcRecycleviewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f358758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f358759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f358760c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358758a;
    }

    public LarusMdUgcRecycleviewBinding(LinearLayout r100, RecyclerView r101, TextView r102) {
        this.f358758a = r100;
        this.f358759b = r101;
        this.f358760c = r102;
    }
}
