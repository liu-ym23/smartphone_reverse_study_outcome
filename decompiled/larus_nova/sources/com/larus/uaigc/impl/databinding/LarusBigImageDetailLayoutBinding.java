package com.larus.uaigc.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.bigimg.widget.LeftCreationEditView;
import com.larus.bmhome.bigimg.widget.NumericIndicator;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusBigImageDetailLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f373093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LeftCreationEditView f373094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewPager2 f373095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NumericIndicator f373096d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373093a;
    }

    public LarusBigImageDetailLayoutBinding(ConstraintLayout r100, LeftCreationEditView r101, ViewPager2 r102, NumericIndicator r103) {
        this.f373093a = r100;
        this.f373094b = r101;
        this.f373095c = r102;
        this.f373096d = r103;
    }
}
