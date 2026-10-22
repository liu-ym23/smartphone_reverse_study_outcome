package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraPageWifiSettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f333278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusDoraGOnboardingBottomBtnLayoutBinding f333279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f333280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DoraTextView f333281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f333282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NovaTitleBarEx f333283f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f333278a;
    }

    public static LarusDoraPageWifiSettingsBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_dora_page_wifi_settings, r101, false);
        ConstraintLayout r103 = (ConstraintLayout) r102;
        int r104 = R.id.dora_g_onboarding_bottom_layout;
        View r105 = ViewBindings.findChildViewById(r102, R.id.dora_g_onboarding_bottom_layout);
        if (r105 == null) goto L15;
        LarusDoraGOnboardingBottomBtnLayoutBinding r106 = LarusDoraGOnboardingBottomBtnLayoutBinding.a(r105);
        r104 = R.id.dora_page_mask;
        View r107 = ViewBindings.findChildViewById(r102, R.id.dora_page_mask);
        if (r107 == null) goto L15;
        r104 = R.id.dora_wifi_add_btn;
        DoraTextView r108 = (DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_wifi_add_btn);
        if (r108 == null) goto L15;
        r104 = R.id.dora_wifi_recycler_view;
        RecyclerView r109 = (RecyclerView) ViewBindings.findChildViewById(r102, R.id.dora_wifi_recycler_view);
        if (r109 == null) goto L15;
        r104 = R.id.title;
        NovaTitleBarEx r110 = (NovaTitleBarEx) ViewBindings.findChildViewById(r102, R.id.title);
        if (r110 == null) goto L15;
        return new LarusDoraPageWifiSettingsBinding(r103, r106, r107, r108, r109, r110);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r104)));
    }

    public LarusDoraPageWifiSettingsBinding(ConstraintLayout r100, LarusDoraGOnboardingBottomBtnLayoutBinding r101, View r102, DoraTextView r103, RecyclerView r104, NovaTitleBarEx r105) {
        this.f333278a = r100;
        this.f333279b = r101;
        this.f333280c = r102;
        this.f333281d = r103;
        this.f333282e = r104;
        this.f333283f = r105;
    }
}
