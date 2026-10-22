package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraMovieView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDeviceScanLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f332440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayoutCompat f332441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f332442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraMovieView f332443e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332439a;
    }

    public LarusDoraDeviceScanLayoutBinding(ConstraintLayout r100, TextView r101, LinearLayoutCompat r102, AppCompatImageView r103, DoraMovieView r104) {
        this.f332439a = r100;
        this.f332440b = r101;
        this.f332441c = r102;
        this.f332442d = r103;
        this.f332443e = r104;
    }
}
