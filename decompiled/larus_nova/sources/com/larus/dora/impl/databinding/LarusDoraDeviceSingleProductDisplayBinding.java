package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDeviceSingleProductDisplayBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f332445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarusDoraDeviceBatteryLayoutBinding f332446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f332447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraTextView f332448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SimpleDraweeView f332449f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332444a;
    }

    public LarusDoraDeviceSingleProductDisplayBinding(ConstraintLayout r100, ConstraintLayout r101, LarusDoraDeviceBatteryLayoutBinding r102, SimpleDraweeView r103, DoraTextView r104, SimpleDraweeView r105) {
        this.f332444a = r100;
        this.f332445b = r101;
        this.f332446c = r102;
        this.f332447d = r103;
        this.f332448e = r104;
        this.f332449f = r105;
    }
}
