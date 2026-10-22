package com.larus.office.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.office.plugins.slides.media.imggen.IndefinitePagerIndicator;
import com.larus.office.plugins.slides.media.widget.GenerateImageViewPagerContainer;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusSdkSlidesPageGenerateImageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f362209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f362210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IndefinitePagerIndicator f362211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NovaTitleBarEx f362212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GenerateImageViewPagerContainer f362213e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f362209a;
    }

    public LarusSdkSlidesPageGenerateImageBinding(ConstraintLayout r100, TextView r101, IndefinitePagerIndicator r102, NovaTitleBarEx r103, GenerateImageViewPagerContainer r104) {
        this.f362209a = r100;
        this.f362210b = r101;
        this.f362211c = r102;
        this.f362212d = r103;
        this.f362213e = r104;
    }
}
