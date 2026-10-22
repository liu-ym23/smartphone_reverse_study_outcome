package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusBlockItemButtonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f358430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f358431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f358432c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358430a;
    }

    public LarusBlockItemButtonBinding(LinearLayout r100, AppCompatTextView r101, SimpleDraweeView r102) {
        this.f358430a = r100;
        this.f358431b = r101;
        this.f358432c = r102;
    }
}
