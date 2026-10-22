package com.larus.community.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.community.impl.view.CommunityCreateButton;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusCommunityCreateFragmentLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f329019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommunityCreateButton f329020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f329021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NovaTitleBarEx f329022d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f329019a;
    }

    public LarusCommunityCreateFragmentLayoutBinding(ConstraintLayout r100, CommunityCreateButton r101, FrameLayout r102, NovaTitleBarEx r103) {
        this.f329019a = r100;
        this.f329020b = r101;
        this.f329021c = r102;
        this.f329022d = r103;
    }
}
