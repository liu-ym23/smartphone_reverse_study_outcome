package com.larksuite.component.universe_design.menu.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes24.dex */
public final class UdItemMenuBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f285131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f285132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f285133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f285134d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f285131a;
    }

    public UdItemMenuBinding(ConstraintLayout r100, TextView r101, ImageView r102, TextView r103) {
        this.f285131a = r100;
        this.f285132b = r101;
        this.f285133c = r102;
        this.f285134d = r103;
    }
}
