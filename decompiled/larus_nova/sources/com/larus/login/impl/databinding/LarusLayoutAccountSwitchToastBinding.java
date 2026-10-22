package com.larus.login.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.nova.R;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusLayoutAccountSwitchToastBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialCardView f357582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoundAvatarImageView f357583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LottieAdapterView f357584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f357585d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f357582a;
    }

    public static LarusLayoutAccountSwitchToastBinding a(LayoutInflater r100) {
        View r101 = r100.inflate(R.layout.larus_layout_account_switch_toast, null, false);
        int r102 = R.id.icon;
        RoundAvatarImageView r103 = (RoundAvatarImageView) ViewBindings.findChildViewById(r101, R.id.icon);
        if (r103 == null) goto L11;
        r102 = R.id.lottie;
        LottieAdapterView r104 = (LottieAdapterView) ViewBindings.findChildViewById(r101, R.id.lottie);
        if (r104 == null) goto L11;
        r102 = R.id.text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r101, R.id.text);
        if (r105 == null) goto L11;
        return new LarusLayoutAccountSwitchToastBinding((MaterialCardView) r101, r103, r104, r105);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    public LarusLayoutAccountSwitchToastBinding(MaterialCardView r100, RoundAvatarImageView r101, LottieAdapterView r102, TextView r103) {
        this.f357582a = r100;
        this.f357583b = r101;
        this.f357584c = r102;
        this.f357585d = r103;
    }
}
