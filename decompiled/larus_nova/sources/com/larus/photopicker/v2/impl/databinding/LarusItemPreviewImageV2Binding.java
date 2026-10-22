package com.larus.photopicker.v2.impl.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusItemPreviewImageV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScaleGestureLayout f364429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScaleGestureLayout f364430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f364431c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f364429a;
    }

    public LarusItemPreviewImageV2Binding(ScaleGestureLayout r100, ScaleGestureLayout r101, SimpleDraweeView r102) {
        this.f364429a = r100;
        this.f364430b = r101;
        this.f364431c = r102;
    }
}
