package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraKeepAliveItemLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f332773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f332774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DoraTextView f332775d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332772a;
    }

    public LarusDoraKeepAliveItemLayoutBinding(ConstraintLayout r100, SimpleDraweeView r101, ImageView r102, DoraTextView r103) {
        this.f332772a = r100;
        this.f332773b = r101;
        this.f332774c = r102;
        this.f332775d = r103;
    }
}
