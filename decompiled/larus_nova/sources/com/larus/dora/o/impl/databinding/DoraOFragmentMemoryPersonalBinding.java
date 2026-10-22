package com.larus.dora.o.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.o.impl.memory.OViewPager2FixLayout;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraOFragmentMemoryPersonalBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OViewPager2FixLayout f338388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f338389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f338390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f338391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProgressBar f338392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f338393f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f338388a;
    }

    public DoraOFragmentMemoryPersonalBinding(OViewPager2FixLayout r100, LinearLayout r101, TextView r102, RecyclerView r103, ProgressBar r104, TextView r105) {
        this.f338388a = r100;
        this.f338389b = r101;
        this.f338390c = r102;
        this.f338391d = r103;
        this.f338392e = r104;
        this.f338393f = r105;
    }
}
