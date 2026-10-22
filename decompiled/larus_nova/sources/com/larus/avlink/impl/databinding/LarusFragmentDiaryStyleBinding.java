package com.larus.avlink.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes25.dex */
public final class LarusFragmentDiaryStyleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f293203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SwipeRefreshLayout f293204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NovaTitleBarEx f293205d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293202a;
    }

    public LarusFragmentDiaryStyleBinding(ConstraintLayout r100, RecyclerView r101, SwipeRefreshLayout r102, NovaTitleBarEx r103) {
        this.f293202a = r100;
        this.f293203b = r101;
        this.f293204c = r102;
        this.f293205d = r103;
    }
}
