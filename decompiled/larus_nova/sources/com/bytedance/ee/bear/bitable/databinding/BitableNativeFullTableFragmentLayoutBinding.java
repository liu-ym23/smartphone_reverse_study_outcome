package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.BitableNativeViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.titlebar.BitableBaseTitleBar;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableNativeFullTableFragmentLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f210962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableNativeViewContainer f210963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BitableBaseTitleBar f210964c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210962a;
    }

    public BitableNativeFullTableFragmentLayoutBinding(ConstraintLayout r100, BitableNativeViewContainer r101, BitableBaseTitleBar r102) {
        this.f210962a = r100;
        this.f210963b = r101;
        this.f210964c = r102;
    }
}
