package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraBatteryGuideToastBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f332360b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332359a;
    }

    public LarusDoraBatteryGuideToastBinding(ConstraintLayout r100, SimpleDraweeView r101, DoraTextView r102, LinearLayoutCompat r103, LottieAdapterView r104, DoraTextView r105, LinearLayoutCompat r106, LottieAdapterView r107, DoraTextView r108, Barrier r110) {
        this.f332359a = r100;
        this.f332360b = r101;
    }
}
