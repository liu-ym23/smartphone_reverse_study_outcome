package com.suite.lark.platform.component.cta.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes36.dex */
public final class ItemBenefitListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f460499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f460500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f460501c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f460499a;
    }

    public ItemBenefitListBinding(LinearLayout r100, ImageView r101, TextView r102) {
        this.f460499a = r100;
        this.f460500b = r101;
        this.f460501c = r102;
    }
}
