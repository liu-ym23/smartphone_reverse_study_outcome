package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDialogScanDeviceBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f332502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f332503b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332502a;
    }

    public LarusDoraDialogScanDeviceBinding(FrameLayout r100, RoundLinearLayout r101, RecyclerView r102) {
        this.f332502a = r100;
        this.f332503b = r102;
    }
}
