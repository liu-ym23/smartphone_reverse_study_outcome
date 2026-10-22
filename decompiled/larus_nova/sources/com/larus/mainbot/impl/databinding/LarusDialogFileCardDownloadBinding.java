package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusDialogFileCardDownloadBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f358582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f358583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f358584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProgressBar f358585d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358582a;
    }

    public LarusDialogFileCardDownloadBinding(ConstraintLayout r100, TextView r101, View r102, ProgressBar r103) {
        this.f358582a = r100;
        this.f358583b = r101;
        this.f358584c = r102;
        this.f358585d = r103;
    }
}
