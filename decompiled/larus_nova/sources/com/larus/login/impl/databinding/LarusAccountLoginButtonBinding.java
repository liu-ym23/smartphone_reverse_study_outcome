package com.larus.login.impl.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusAccountLoginButtonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f357402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f357403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Button f357404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f357405d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f357402a;
    }

    public static LarusAccountLoginButtonBinding a(View r100) {
        int r101 = R.id.button_iv;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r100, R.id.button_iv);
        if (r102 == null) goto L9;
        r101 = R.id.button_login;
        Button r103 = (Button) ViewBindings.findChildViewById(r100, R.id.button_login);
        if (r103 == null) goto L9;
        FrameLayout r104 = (FrameLayout) r100;
        return new LarusAccountLoginButtonBinding(r104, r102, r103, r104);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusAccountLoginButtonBinding(FrameLayout r100, ImageView r101, Button r102, FrameLayout r103) {
        this.f357402a = r100;
        this.f357403b = r101;
        this.f357404c = r102;
        this.f357405d = r103;
    }
}
