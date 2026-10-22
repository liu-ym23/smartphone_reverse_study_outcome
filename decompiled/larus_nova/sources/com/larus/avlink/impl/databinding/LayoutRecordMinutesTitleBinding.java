package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes25.dex */
public final class LayoutRecordMinutesTitleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f293346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f293347c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293345a;
    }

    public LayoutRecordMinutesTitleBinding(ConstraintLayout r100, ImageView r101, ImageView r102, TextView r103) {
        this.f293345a = r100;
        this.f293346b = r102;
        this.f293347c = r103;
    }
}
