package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes25.dex */
public final class LarusLayoutRecordMinutesSyncHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProgressBar f293257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f293258c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293256a;
    }

    public LarusLayoutRecordMinutesSyncHeaderBinding(ConstraintLayout r100, ProgressBar r101, TextView r102) {
        this.f293256a = r100;
        this.f293257b = r101;
        this.f293258c = r102;
    }
}
