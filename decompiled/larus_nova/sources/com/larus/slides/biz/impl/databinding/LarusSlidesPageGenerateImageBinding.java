package com.larus.slides.biz.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.slides.impl.select.IndefinitePagerIndicator;
import com.larus.slides.impl.select.widget.GenerateImageViewPagerContainer;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusSlidesPageGenerateImageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f369367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f369368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IndefinitePagerIndicator f369369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NovaTitleBarEx f369370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GenerateImageViewPagerContainer f369371e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f369367a;
    }

    public LarusSlidesPageGenerateImageBinding(ConstraintLayout r100, TextView r101, IndefinitePagerIndicator r102, NovaTitleBarEx r103, GenerateImageViewPagerContainer r104) {
        this.f369367a = r100;
        this.f369368b = r101;
        this.f369369c = r102;
        this.f369370d = r103;
        this.f369371e = r104;
    }
}
