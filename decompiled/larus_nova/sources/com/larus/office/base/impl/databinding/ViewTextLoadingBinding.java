package com.larus.office.base.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes29.dex */
public final class ViewTextLoadingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f360572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f360573b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f360572a;
    }

    public ViewTextLoadingBinding(FrameLayout r100, TextView r101) {
        this.f360572a = r100;
        this.f360573b = r101;
    }
}
