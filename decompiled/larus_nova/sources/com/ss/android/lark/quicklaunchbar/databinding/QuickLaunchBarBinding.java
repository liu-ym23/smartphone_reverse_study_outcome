package com.ss.android.lark.quicklaunchbar.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes37.dex */
public final class QuickLaunchBarBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f439127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f439128b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f439127a;
    }

    public QuickLaunchBarBinding(FrameLayout r100, LinearLayout r101, LinearLayout r102) {
        this.f439127a = r100;
        this.f439128b = r101;
    }
}
