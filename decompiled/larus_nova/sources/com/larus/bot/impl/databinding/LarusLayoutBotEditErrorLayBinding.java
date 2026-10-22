package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutBotEditErrorLayBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f317852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f317853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f317854c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317852a;
    }

    public static LarusLayoutBotEditErrorLayBinding a(View r100) {
        FrameLayout r101 = (FrameLayout) r100;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r100, R.id.tips);
        if (r102 == null) goto L7;
        return new LarusLayoutBotEditErrorLayBinding(r101, r101, r102);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(R.id.tips)));
    }

    public LarusLayoutBotEditErrorLayBinding(FrameLayout r100, FrameLayout r101, TextView r102) {
        this.f317852a = r100;
        this.f317853b = r101;
        this.f317854c = r102;
    }
}
