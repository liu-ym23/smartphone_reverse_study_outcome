package com.larus.login.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.RectangleButton;
import com.larus.common_ui.widget.datepicker.DatePicker;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusFragmentAgeGateScrollBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f357525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DatePicker f357526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectangleButton f357527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f357528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f357529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f357530f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f357525a;
    }

    public LarusFragmentAgeGateScrollBinding(ConstraintLayout r100, DatePicker r101, RectangleButton r102, ImageView r103, TextView r104, TextView r105) {
        this.f357525a = r100;
        this.f357526b = r101;
        this.f357527c = r102;
        this.f357528d = r103;
        this.f357529e = r104;
        this.f357530f = r105;
    }
}
