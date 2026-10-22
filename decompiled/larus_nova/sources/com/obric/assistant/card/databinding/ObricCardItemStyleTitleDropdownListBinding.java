package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricCardItemStyleTitleDropdownListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f386162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f386163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f386164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f386165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f386166e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386162a;
    }

    public ObricCardItemStyleTitleDropdownListBinding(ConstraintLayout r100, LinearLayout r101, SimpleDraweeView r102, ConstraintLayout r103, TextView r104) {
        this.f386162a = r100;
        this.f386163b = r101;
        this.f386164c = r102;
        this.f386165d = r103;
        this.f386166e = r104;
    }
}
