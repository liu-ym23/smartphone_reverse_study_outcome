package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDialogScanDeviceItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f332505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f332506c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332504a;
    }

    public LarusDoraDialogScanDeviceItemBinding(ConstraintLayout r100, TextView r101, TextView r102) {
        this.f332504a = r100;
        this.f332505b = r101;
        this.f332506c = r102;
    }
}
