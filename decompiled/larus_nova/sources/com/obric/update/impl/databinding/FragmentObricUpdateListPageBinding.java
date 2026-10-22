package com.obric.update.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes34.dex */
public final class FragmentObricUpdateListPageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f404058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NovaTitleBarEx f404059b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f404058a;
    }

    public FragmentObricUpdateListPageBinding(ConstraintLayout r100, RecyclerView r101, NovaTitleBarEx r102) {
        this.f404058a = r100;
        this.f404059b = r102;
    }
}
