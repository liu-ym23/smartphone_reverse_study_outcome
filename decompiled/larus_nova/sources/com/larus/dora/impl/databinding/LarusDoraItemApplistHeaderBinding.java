package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraItemApplistHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f332709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f332710b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332709a;
    }

    public LarusDoraItemApplistHeaderBinding(FrameLayout r100, TextView r101) {
        this.f332709a = r100;
        this.f332710b = r101;
    }
}
