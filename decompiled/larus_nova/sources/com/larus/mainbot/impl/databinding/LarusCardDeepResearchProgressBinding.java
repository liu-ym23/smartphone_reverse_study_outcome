package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.layout.widget.ShimmerProgressBar;
import com.larus.common_ui.venus.ShapeConstraintLayout;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusCardDeepResearchProgressBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f358513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f358514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShimmerProgressBar f358515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ShapeConstraintLayout f358516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f358517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f358518f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358513a;
    }

    public LarusCardDeepResearchProgressBinding(FrameLayout r100, TextView r101, ShimmerProgressBar r102, ShapeConstraintLayout r103, TextView r104, TextView r105) {
        this.f358513a = r100;
        this.f358514b = r101;
        this.f358515c = r102;
        this.f358516d = r103;
        this.f358517e = r104;
        this.f358518f = r105;
    }
}
