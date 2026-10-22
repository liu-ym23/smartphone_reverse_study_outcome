package com.larus.drive.biz.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusFragmentDriveFolderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f341124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f341125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NovaTitleBarEx f341126c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f341124a;
    }

    public LarusFragmentDriveFolderBinding(ConstraintLayout r100, FrameLayout r101, NovaTitleBarEx r102) {
        this.f341124a = r100;
        this.f341125b = r101;
        this.f341126c = r102;
    }
}
