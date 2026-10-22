package com.larus.common_res.common_ui.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.CircleFrameLayout;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusLayoutAvatarTagViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f326746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f326747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CircleFrameLayout f326748c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326746a;
    }

    public LarusLayoutAvatarTagViewBinding(View r100, SimpleDraweeView r101, CircleFrameLayout r102) {
        this.f326746a = r100;
        this.f326747b = r101;
        this.f326748c = r102;
    }
}
