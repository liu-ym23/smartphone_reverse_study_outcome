package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraFeatureIntroductionFragmentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f332538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f332539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NestedScrollView f332540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f332541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraTextView f332542e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332538a;
    }

    public LarusDoraFeatureIntroductionFragmentBinding(LinearLayout r100, LinearLayout r101, NestedScrollView r102, AppCompatImageView r103, DoraTextView r104) {
        this.f332538a = r100;
        this.f332539b = r101;
        this.f332540c = r102;
        this.f332541d = r103;
        this.f332542e = r104;
    }
}
