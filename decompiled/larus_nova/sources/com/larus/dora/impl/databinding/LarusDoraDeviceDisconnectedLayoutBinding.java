package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDeviceDisconnectedLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f332374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoraTextView f332375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f332376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProgressBar f332377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DoraTextView f332378f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332373a;
    }

    public LarusDoraDeviceDisconnectedLayoutBinding(ConstraintLayout r100, ConstraintLayout r101, DoraTextView r102, SimpleDraweeView r103, ProgressBar r104, DoraTextView r105) {
        this.f332373a = r100;
        this.f332374b = r101;
        this.f332375c = r102;
        this.f332376d = r103;
        this.f332377e = r104;
        this.f332378f = r105;
    }
}
