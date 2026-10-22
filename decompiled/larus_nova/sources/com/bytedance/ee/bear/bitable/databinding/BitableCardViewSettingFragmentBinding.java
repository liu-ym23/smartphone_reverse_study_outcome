package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableCardViewSettingFragmentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollView f210723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f210724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f210725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f210726d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210723a;
    }

    public BitableCardViewSettingFragmentBinding(NestedScrollView r100, TextView r101, FrameLayout r102, LinearLayout r103) {
        this.f210723a = r100;
        this.f210724b = r101;
        this.f210725c = r102;
        this.f210726d = r103;
    }
}
