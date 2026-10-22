package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraWifiListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f333327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraTextView f333328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f333329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DoraTextView f333330d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f333327a;
    }

    public LarusDoraWifiListItemBinding(ConstraintLayout r100, DoraTextView r101, ProgressBar r102, DoraTextView r103) {
        this.f333327a = r100;
        this.f333328b = r101;
        this.f333329c = r102;
        this.f333330d = r103;
    }
}
