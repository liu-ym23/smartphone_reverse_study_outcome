package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutAiGenBgChooseCheckBoxBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f317813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f317814b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317813a;
    }

    public static LarusLayoutAiGenBgChooseCheckBoxBinding a(View r100) {
        ImageView r101 = (ImageView) ViewBindings.findChildViewById(r100, R.id.checked_iv);
        if (r101 == null) goto L7;
        return new LarusLayoutAiGenBgChooseCheckBoxBinding((FrameLayout) r100, r101);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(R.id.checked_iv)));
    }

    public LarusLayoutAiGenBgChooseCheckBoxBinding(FrameLayout r100, ImageView r101) {
        this.f317813a = r100;
        this.f317814b = r101;
    }
}
