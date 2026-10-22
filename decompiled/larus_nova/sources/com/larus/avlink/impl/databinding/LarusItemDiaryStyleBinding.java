package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes25.dex */
public final class LarusItemDiaryStyleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f293225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f293226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f293227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f293228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f293229f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293224a;
    }

    public LarusItemDiaryStyleBinding(ConstraintLayout r100, SimpleDraweeView r101, TextView r102, TextView r103, ImageView r104, TextView r105) {
        this.f293224a = r100;
        this.f293225b = r101;
        this.f293226c = r102;
        this.f293227d = r103;
        this.f293228e = r104;
        this.f293229f = r105;
    }
}
