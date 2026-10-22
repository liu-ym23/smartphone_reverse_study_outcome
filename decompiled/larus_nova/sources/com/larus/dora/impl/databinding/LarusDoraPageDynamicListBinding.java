package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;
import com.larus.dora.impl.dynamic.widget.NestedDynamicPageView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraPageDynamicListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HistoryDeviceNavigationBar f332901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NestedDynamicPageView f332902c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332900a;
    }

    public LarusDoraPageDynamicListBinding(ConstraintLayout r100, HistoryDeviceNavigationBar r101, NestedDynamicPageView r102) {
        this.f332900a = r100;
        this.f332901b = r101;
        this.f332902c = r102;
    }
}
