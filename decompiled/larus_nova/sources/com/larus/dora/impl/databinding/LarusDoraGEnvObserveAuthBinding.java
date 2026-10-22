package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraGEnvObserveAuthBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f332586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoraTextView f332587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DoraTextView f332588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LarusDoraGOnboardingBottomBtnLayoutBinding f332589e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332585a;
    }

    public static LarusDoraGEnvObserveAuthBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_dora_g_env_observe_auth, r101, false);
        ConstraintLayout r103 = (ConstraintLayout) r102;
        int r104 = R.id.dora_g_env_observe_auth_btn_line;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r102, R.id.dora_g_env_observe_auth_btn_line);
        if (r105 == null) goto L29;
        r104 = R.id.dora_g_env_observe_auth_desc;
        if (((DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_g_env_observe_auth_desc)) == null) goto L29;
        r104 = R.id.dora_g_env_observe_auth_img;
        if (((ImageView) ViewBindings.findChildViewById(r102, R.id.dora_g_env_observe_auth_img)) == null) goto L29;
        r104 = R.id.dora_g_env_observe_auth_private;
        if (((DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_g_env_observe_auth_private)) == null) goto L29;
        r104 = R.id.dora_g_env_observe_auth_private_agree;
        DoraTextView r106 = (DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_g_env_observe_auth_private_agree);
        if (r106 == null) goto L29;
        r104 = R.id.dora_g_env_observe_auth_private_btn_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r102, R.id.dora_g_env_observe_auth_private_btn_container)) == null) goto L29;
        r104 = R.id.dora_g_env_observe_auth_private_disagree;
        DoraTextView r107 = (DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_g_env_observe_auth_private_disagree);
        if (r107 == null) goto L29;
        r104 = R.id.dora_g_env_observe_auth_private_tips_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r102, R.id.dora_g_env_observe_auth_private_tips_container)) == null) goto L29;
        r104 = R.id.dora_g_env_observe_auth_scroll;
        if (((ScrollView) ViewBindings.findChildViewById(r102, R.id.dora_g_env_observe_auth_scroll)) == null) goto L29;
        r104 = R.id.dora_g_env_observe_auth_title;
        if (((DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_g_env_observe_auth_title)) == null) goto L29;
        r104 = R.id.dora_g_onboarding_bottom_layout;
        View r108 = ViewBindings.findChildViewById(r102, R.id.dora_g_onboarding_bottom_layout);
        if (r108 == null) goto L29;
        LarusDoraGOnboardingBottomBtnLayoutBinding r109 = LarusDoraGOnboardingBottomBtnLayoutBinding.a(r108);
        r104 = R.id.title;
        if (((NovaTitleBarEx) ViewBindings.findChildViewById(r102, R.id.title)) == null) goto L29;
        return new LarusDoraGEnvObserveAuthBinding(r103, r105, r106, r107, r109);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r104)));
    }

    public LarusDoraGEnvObserveAuthBinding(ConstraintLayout r100, LinearLayout r101, DoraTextView r102, DoraTextView r103, LarusDoraGOnboardingBottomBtnLayoutBinding r104) {
        this.f332585a = r100;
        this.f332586b = r101;
        this.f332587c = r102;
        this.f332588d = r103;
        this.f332589e = r104;
    }
}
