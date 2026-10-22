package com.bytedance.ee.bear.debug.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes16.dex */
public final class ActivitySendMemoryWarningBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f217368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f217369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f217370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f217371d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f217368a;
    }

    public ActivitySendMemoryWarningBinding(ConstraintLayout r100, TextView r101, TextView r102, TextView r103) {
        this.f217368a = r100;
        this.f217369b = r101;
        this.f217370c = r102;
        this.f217371d = r103;
    }
}
