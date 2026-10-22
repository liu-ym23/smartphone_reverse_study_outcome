package com.larus.camera.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutTitleRightIconViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f321512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f321513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f321514c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321512a;
    }

    public LarusLayoutTitleRightIconViewBinding(LinearLayout r100, TextView r101, ImageView r102) {
        this.f321512a = r100;
        this.f321513b = r101;
        this.f321514c = r102;
    }
}
