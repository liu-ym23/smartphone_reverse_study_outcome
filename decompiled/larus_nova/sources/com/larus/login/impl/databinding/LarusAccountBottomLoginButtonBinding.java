package com.larus.login.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusAccountBottomLoginButtonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f357392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f357393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Button f357394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f357395d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f357392a;
    }

    public static LarusAccountBottomLoginButtonBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_account_bottom_login_button, r101, false);
        r101.addView(r102);
        int r103 = R.id.button_iv;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r102, R.id.button_iv);
        if (r104 == null) goto L9;
        r103 = R.id.button_login;
        Button r105 = (Button) ViewBindings.findChildViewById(r102, R.id.button_login);
        if (r105 == null) goto L9;
        FrameLayout r106 = (FrameLayout) r102;
        return new LarusAccountBottomLoginButtonBinding(r106, r104, r105, r106);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusAccountBottomLoginButtonBinding(FrameLayout r100, ImageView r101, Button r102, FrameLayout r103) {
        this.f357392a = r100;
        this.f357393b = r101;
        this.f357394c = r102;
        this.f357395d = r103;
    }
}
