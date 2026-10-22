package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricCardItemStyleTitleSubtitleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f386167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f386168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f386169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f386170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f386171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f386172f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386167a;
    }

    public ObricCardItemStyleTitleSubtitleBinding(ConstraintLayout r100, SimpleDraweeView r101, TextView r102, ImageView r103, TextView r104, TextView r105) {
        this.f386167a = r100;
        this.f386168b = r101;
        this.f386169c = r102;
        this.f386170d = r103;
        this.f386171e = r104;
        this.f386172f = r105;
    }
}
