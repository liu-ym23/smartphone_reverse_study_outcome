package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraPageWifiScanListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f333270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f333271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayoutCompat f333272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProgressBar f333273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f333274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f333275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RecyclerView f333276g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NovaTitleBarEx f333277h;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f333270a;
    }

    public LarusDoraPageWifiScanListBinding(ConstraintLayout r100, View r101, LinearLayoutCompat r102, ProgressBar r103, ImageView r104, TextView r105, RecyclerView r106, NovaTitleBarEx r107) {
        this.f333270a = r100;
        this.f333271b = r101;
        this.f333272c = r102;
        this.f333273d = r103;
        this.f333274e = r104;
        this.f333275f = r105;
        this.f333276g = r106;
        this.f333277h = r107;
    }
}
