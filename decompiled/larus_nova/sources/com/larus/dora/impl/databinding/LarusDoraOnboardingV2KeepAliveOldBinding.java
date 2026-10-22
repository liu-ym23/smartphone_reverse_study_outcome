package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraOnboardingV2KeepAliveOldBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraUrlSpanTextView f332819b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332818a;
    }

    public LarusDoraOnboardingV2KeepAliveOldBinding(ConstraintLayout r100, DoraUrlSpanTextView r101) {
        this.f332818a = r100;
        this.f332819b = r101;
    }

    public static LarusDoraOnboardingV2KeepAliveOldBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_dora_onboarding_v2_keep_alive_old, r101, false);
        ConstraintLayout r103 = (ConstraintLayout) r102;
        int r104 = R.id.dora_onboarding_keep_alive_content;
        if (((ScrollView) ViewBindings.findChildViewById(r102, R.id.dora_onboarding_keep_alive_content)) == null) goto L9;
        r104 = R.id.dora_onboarding_keep_alive_hint;
        DoraUrlSpanTextView r105 = (DoraUrlSpanTextView) ViewBindings.findChildViewById(r102, R.id.dora_onboarding_keep_alive_hint);
        if (r105 == null) goto L9;
        return new LarusDoraOnboardingV2KeepAliveOldBinding(r103, r105);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r104)));
    }
}
