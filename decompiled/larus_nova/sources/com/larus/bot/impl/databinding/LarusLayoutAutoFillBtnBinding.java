package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.GradientTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutAutoFillBtnBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f317815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GradientTextView f317816b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317815a;
    }

    public static LarusLayoutAutoFillBtnBinding a(View r100) {
        int r101 = R.id.auto_fill_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.auto_fill_icon)) == null) goto L9;
        r101 = R.id.auto_fill_title;
        GradientTextView r102 = (GradientTextView) ViewBindings.findChildViewById(r100, R.id.auto_fill_title);
        if (r102 == null) goto L9;
        return new LarusLayoutAutoFillBtnBinding((LinearLayout) r100, r102);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusLayoutAutoFillBtnBinding(LinearLayout r100, GradientTextView r101) {
        this.f317815a = r100;
        this.f317816b = r101;
    }
}
