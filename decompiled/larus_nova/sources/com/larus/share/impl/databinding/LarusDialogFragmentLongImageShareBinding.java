package com.larus.share.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusDialogFragmentLongImageShareBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f368599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f368600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CardView f368601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f368602d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f368599a;
    }

    public LarusDialogFragmentLongImageShareBinding(ConstraintLayout r100, ImageView r101, CardView r102, RecyclerView r103) {
        this.f368599a = r100;
        this.f368600b = r101;
        this.f368601c = r102;
        this.f368602d = r103;
    }
}
