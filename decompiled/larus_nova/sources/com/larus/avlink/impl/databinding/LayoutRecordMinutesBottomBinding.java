package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes25.dex */
public final class LayoutRecordMinutesBottomBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f293341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f293342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f293343d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293340a;
    }

    public LayoutRecordMinutesBottomBinding(ConstraintLayout r100, ConstraintLayout r101, TextView r102, LinearLayout r103) {
        this.f293340a = r100;
        this.f293341b = r101;
        this.f293342c = r102;
        this.f293343d = r103;
    }
}
