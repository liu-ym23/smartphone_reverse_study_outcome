package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraGOnboardingBottomBtnLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f332610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraTextView f332611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f332612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DoraTextView f332613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f332614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f332615f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332610a;
    }

    public static LarusDoraGOnboardingBottomBtnLayoutBinding a(View r100) {
        int r101 = R.id.dora_g_onboarding_bottom_btn_bottom;
        DoraTextView r102 = (DoraTextView) ViewBindings.findChildViewById(r100, R.id.dora_g_onboarding_bottom_btn_bottom);
        if (r102 == null) goto L13;
        LinearLayout r103 = (LinearLayout) r100;
        r101 = R.id.dora_g_onboarding_bottom_btn_top;
        DoraTextView r104 = (DoraTextView) ViewBindings.findChildViewById(r100, R.id.dora_g_onboarding_bottom_btn_top);
        if (r104 == null) goto L13;
        r101 = R.id.dora_g_onboarding_top_bottom_margin;
        View r105 = ViewBindings.findChildViewById(r100, R.id.dora_g_onboarding_top_bottom_margin);
        if (r105 == null) goto L13;
        r101 = R.id.dora_g_onboarding_top_margin;
        View r106 = ViewBindings.findChildViewById(r100, R.id.dora_g_onboarding_top_margin);
        if (r106 == null) goto L13;
        return new LarusDoraGOnboardingBottomBtnLayoutBinding(r103, r102, r103, r104, r105, r106);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusDoraGOnboardingBottomBtnLayoutBinding(LinearLayout r100, DoraTextView r101, LinearLayout r102, DoraTextView r103, View r104, View r105) {
        this.f332610a = r100;
        this.f332611b = r101;
        this.f332612c = r102;
        this.f332613d = r103;
        this.f332614e = r104;
        this.f332615f = r105;
    }
}
