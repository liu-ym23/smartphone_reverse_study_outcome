package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraGRebindBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f332661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f332662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NovaTitleBarEx f332663d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332660a;
    }

    public LarusDoraGRebindBinding(ConstraintLayout r100, RecyclerView r101, View r102, NovaTitleBarEx r103) {
        this.f332660a = r100;
        this.f332661b = r101;
        this.f332662c = r102;
        this.f332663d = r103;
    }
}
