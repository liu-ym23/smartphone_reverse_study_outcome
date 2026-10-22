package com.larus.home.impl.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.home.impl.main.tab.config.BottomTabGradientTextView;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusMainTabTextViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f344349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f344350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BottomTabGradientTextView f344351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RedDotTextView f344352d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f344349a;
    }

    public LarusMainTabTextViewBinding(View r100, View r101, BottomTabGradientTextView r102, RedDotTextView r103) {
        this.f344349a = r100;
        this.f344350b = r101;
        this.f344351c = r102;
        this.f344352d = r103;
    }
}
