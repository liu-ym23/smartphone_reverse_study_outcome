package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.CustomCircularProgressBar;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusSubtitleHolderSingleImageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f378307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f378308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CustomCircularProgressBar f378309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f378310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f378311e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f378307a;
    }

    public LarusSubtitleHolderSingleImageBinding(ConstraintLayout r100, SimpleDraweeView r101, CustomCircularProgressBar r102, ImageView r103, View r104) {
        this.f378307a = r100;
        this.f378308b = r101;
        this.f378309c = r102;
        this.f378310d = r103;
        this.f378311e = r104;
    }
}
