package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraFunctionIntroductionFragmentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f332569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f332570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f332571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraTextView f332572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DoraTextView f332573f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332568a;
    }

    public LarusDoraFunctionIntroductionFragmentBinding(ConstraintLayout r100, SimpleDraweeView r101, LinearLayout r102, ImageView r103, DoraTextView r104, DoraTextView r105) {
        this.f332568a = r100;
        this.f332569b = r101;
        this.f332570c = r102;
        this.f332571d = r103;
        this.f332572e = r104;
        this.f332573f = r105;
    }
}
