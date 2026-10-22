package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricCardItemStyleIconContentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f386141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f386142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f386143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f386144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f386145e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386141a;
    }

    public ObricCardItemStyleIconContentBinding(ConstraintLayout r100, TextView r101, SimpleDraweeView r102, TextView r103, ConstraintLayout r104) {
        this.f386141a = r100;
        this.f386142b = r101;
        this.f386143c = r102;
        this.f386144d = r103;
        this.f386145e = r104;
    }
}
