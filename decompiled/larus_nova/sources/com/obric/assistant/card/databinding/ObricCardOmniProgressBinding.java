package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.venus.ShapeConstraintLayout;
import com.obric.assistant.view.ObricShimmerProgressBar;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricCardOmniProgressBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f386189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f386190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObricShimmerProgressBar f386191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ShapeConstraintLayout f386192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f386193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f386194f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386189a;
    }

    public ObricCardOmniProgressBinding(RelativeLayout r100, TextView r101, ObricShimmerProgressBar r102, ShapeConstraintLayout r103, TextView r104, TextView r105) {
        this.f386189a = r100;
        this.f386190b = r101;
        this.f386191c = r102;
        this.f386192d = r103;
        this.f386193e = r104;
        this.f386194f = r105;
    }
}
