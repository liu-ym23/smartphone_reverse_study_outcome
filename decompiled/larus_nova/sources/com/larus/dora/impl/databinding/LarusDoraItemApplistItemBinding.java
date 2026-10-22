package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraItemApplistItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f332712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f332713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f332714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f332715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f332716f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332711a;
    }

    public LarusDoraItemApplistItemBinding(ConstraintLayout r100, ImageView r101, LinearLayout r102, SimpleDraweeView r103, TextView r104, View r105) {
        this.f332711a = r100;
        this.f332712b = r101;
        this.f332713c = r102;
        this.f332714d = r103;
        this.f332715e = r104;
        this.f332716f = r105;
    }
}
