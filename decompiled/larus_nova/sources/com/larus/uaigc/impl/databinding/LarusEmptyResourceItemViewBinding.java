package com.larus.uaigc.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusEmptyResourceItemViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f373108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f373109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f373110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f373111d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373108a;
    }

    public LarusEmptyResourceItemViewBinding(ConstraintLayout r100, ConstraintLayout r101, SimpleDraweeView r102, TextView r103) {
        this.f373108a = r100;
        this.f373109b = r101;
        this.f373110c = r102;
        this.f373111d = r103;
    }
}
