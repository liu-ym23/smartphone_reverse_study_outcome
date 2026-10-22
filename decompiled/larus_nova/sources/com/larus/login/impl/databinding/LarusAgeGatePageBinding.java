package com.larus.login.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.RectangleButton;
import com.larus.common_ui.widget.datepicker.DatePicker;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusAgeGatePageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f357481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DatePicker f357482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f357483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectangleButton f357484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f357485e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f357481a;
    }

    public LarusAgeGatePageBinding(ConstraintLayout r100, DatePicker r101, TextView r102, RectangleButton r103, ImageView r104, TextView r105) {
        this.f357481a = r100;
        this.f357482b = r101;
        this.f357483c = r102;
        this.f357484d = r103;
        this.f357485e = r105;
    }
}
