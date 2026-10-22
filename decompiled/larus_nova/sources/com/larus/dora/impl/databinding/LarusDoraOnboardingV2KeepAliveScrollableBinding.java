package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraOnboardingV2KeepAliveScrollableBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollView f332820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NestedScrollView f332821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CircleSimpleDraweeView f332822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DoraUrlSpanTextView f332823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ItemGroup f332824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DoraTextView f332825f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332820a;
    }

    public static LarusDoraOnboardingV2KeepAliveScrollableBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_dora_onboarding_v2_keep_alive_scrollable, r101, false);
        NestedScrollView r103 = (NestedScrollView) r102;
        int r104 = R.id.dora_onboarding_keep_alive_avatar;
        CircleSimpleDraweeView r105 = (CircleSimpleDraweeView) ViewBindings.findChildViewById(r102, R.id.dora_onboarding_keep_alive_avatar);
        if (r105 == null) goto L13;
        r104 = R.id.dora_onboarding_keep_alive_hint;
        DoraUrlSpanTextView r106 = (DoraUrlSpanTextView) ViewBindings.findChildViewById(r102, R.id.dora_onboarding_keep_alive_hint);
        if (r106 == null) goto L13;
        r104 = R.id.dora_onboarding_setting_group;
        ItemGroup r107 = (ItemGroup) ViewBindings.findChildViewById(r102, R.id.dora_onboarding_setting_group);
        if (r107 == null) goto L13;
        r104 = R.id.dora_onboarding_title;
        DoraTextView r108 = (DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_onboarding_title);
        if (r108 == null) goto L13;
        return new LarusDoraOnboardingV2KeepAliveScrollableBinding(r103, r103, r105, r106, r107, r108);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r104)));
    }

    public LarusDoraOnboardingV2KeepAliveScrollableBinding(NestedScrollView r100, NestedScrollView r101, CircleSimpleDraweeView r102, DoraUrlSpanTextView r103, ItemGroup r104, DoraTextView r105) {
        this.f332820a = r100;
        this.f332821b = r101;
        this.f332822c = r102;
        this.f332823d = r103;
        this.f332824e = r104;
        this.f332825f = r105;
    }
}
