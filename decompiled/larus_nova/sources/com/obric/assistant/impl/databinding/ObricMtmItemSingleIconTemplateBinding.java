package com.obric.assistant.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricMtmItemSingleIconTemplateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f389604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f389605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f389606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f389607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f389608e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f389604a;
    }

    public ObricMtmItemSingleIconTemplateBinding(ConstraintLayout r100, FrameLayout r101, TextView r102, SimpleDraweeView r103, TextView r104) {
        this.f389604a = r100;
        this.f389605b = r101;
        this.f389606c = r102;
        this.f389607d = r103;
        this.f389608e = r104;
    }
}
