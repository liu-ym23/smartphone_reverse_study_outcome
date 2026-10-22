package com.larus.login.impl.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.RectangleButton;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusFragmentAgeGateInputBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f357521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditText f357522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectangleButton f357523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f357524d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f357521a;
    }

    public LarusFragmentAgeGateInputBinding(ConstraintLayout r100, EditText r101, RectangleButton r102, ImageView r103, TextView r104) {
        this.f357521a = r100;
        this.f357522b = r101;
        this.f357523c = r102;
        this.f357524d = r104;
    }
}
