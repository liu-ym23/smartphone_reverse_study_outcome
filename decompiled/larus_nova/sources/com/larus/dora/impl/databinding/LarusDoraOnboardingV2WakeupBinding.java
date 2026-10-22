package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.view.CustomBarCountAudioVisualizer;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.onboarding.DoraOnboardingNestedScrollView;
import com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingTopicView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.impl.view.DoraUrlSpanTextView;
import com.larus.nova.R;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraOnboardingV2WakeupBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraOnboardingNestedScrollView f332830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CircleSimpleDraweeView f332831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f332832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f332833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CustomBarCountAudioVisualizer f332834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f332835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f332836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RelativeLayout f332837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LottieAdapterView f332838i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LottieAdapterView f332839j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LarusDoraOnboardingMusicPanelBinding f332840k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DoraTextView f332841l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DoraLiteOnboardingTopicView f332842m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final DoraUrlSpanTextView f332843n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DoraTextView f332844o;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332830a;
    }

    public static LarusDoraOnboardingV2WakeupBinding a(LayoutInflater r110, ViewGroup r210) {
        View r100 = r110.inflate(R.layout.larus_dora_onboarding_v2_wakeup, r210, false);
        int r101 = R.id.dora_onboarding_avatar;
        CircleSimpleDraweeView r102 = (CircleSimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_avatar);
        if (r102 == null) goto L35;
        r101 = R.id.dora_onboarding_avatar_anchor_view;
        View r103 = ViewBindings.findChildViewById(r100, R.id.dora_onboarding_avatar_anchor_view);
        if (r103 == null) goto L35;
        r101 = R.id.dora_onboarding_bubble_anchor_view;
        View r104 = ViewBindings.findChildViewById(r100, R.id.dora_onboarding_bubble_anchor_view);
        if (r104 == null) goto L35;
        r101 = R.id.dora_onboarding_bubble_audio_anim;
        CustomBarCountAudioVisualizer r105 = (CustomBarCountAudioVisualizer) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_bubble_audio_anim);
        if (r105 == null) goto L35;
        r101 = R.id.dora_onboarding_bubble_bg;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_bubble_bg);
        if (r106 == null) goto L35;
        r101 = R.id.dora_onboarding_bubble_bg_anchor_view;
        View r111 = ViewBindings.findChildViewById(r100, R.id.dora_onboarding_bubble_bg_anchor_view);
        if (r111 == null) goto L35;
        r101 = R.id.dora_onboarding_bubble_speaking;
        RelativeLayout r112 = (RelativeLayout) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_bubble_speaking);
        if (r112 == null) goto L35;
        r101 = R.id.dora_onboarding_bubble_speaking_anim;
        LottieAdapterView r113 = (LottieAdapterView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_bubble_speaking_anim);
        if (r113 == null) goto L35;
        r101 = R.id.dora_onboarding_bubble_thinking;
        LottieAdapterView r114 = (LottieAdapterView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_bubble_thinking);
        if (r114 == null) goto L35;
        DoraOnboardingNestedScrollView r107 = (DoraOnboardingNestedScrollView) r100;
        r101 = R.id.dora_onboarding_music_panel;
        View r108 = ViewBindings.findChildViewById(r100, R.id.dora_onboarding_music_panel);
        if (r108 == null) goto L35;
        LarusDoraOnboardingMusicPanelBinding r115 = LarusDoraOnboardingMusicPanelBinding.a(r108);
        r101 = R.id.dora_onboarding_query_bottom_button_placeholder;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_query_bottom_button_placeholder)) == null) goto L35;
        r101 = R.id.dora_onboarding_query_title;
        DoraTextView r116 = (DoraTextView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_query_title);
        if (r116 == null) goto L35;
        r101 = R.id.dora_onboarding_query_topic_view;
        DoraLiteOnboardingTopicView r117 = (DoraLiteOnboardingTopicView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_query_topic_view);
        if (r117 == null) goto L35;
        r101 = R.id.dora_onboarding_wakeup_hint;
        DoraUrlSpanTextView r118 = (DoraUrlSpanTextView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_wakeup_hint);
        if (r118 == null) goto L35;
        r101 = R.id.dora_onboarding_wakeup_title;
        DoraTextView r119 = (DoraTextView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_wakeup_title);
        if (r119 == null) goto L35;
        return new LarusDoraOnboardingV2WakeupBinding(r107, r102, r103, r104, r105, r106, r111, r112, r113, r114, r115, r116, r117, r118, r119);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusDoraOnboardingV2WakeupBinding(DoraOnboardingNestedScrollView r100, CircleSimpleDraweeView r101, View r102, View r103, CustomBarCountAudioVisualizer r104, ImageView r105, View r106, RelativeLayout r107, LottieAdapterView r108, LottieAdapterView r110, LarusDoraOnboardingMusicPanelBinding r111, DoraTextView r112, DoraLiteOnboardingTopicView r113, DoraUrlSpanTextView r114, DoraTextView r115) {
        this.f332830a = r100;
        this.f332831b = r101;
        this.f332832c = r102;
        this.f332833d = r103;
        this.f332834e = r104;
        this.f332835f = r105;
        this.f332836g = r106;
        this.f332837h = r107;
        this.f332838i = r108;
        this.f332839j = r110;
        this.f332840k = r111;
        this.f332841l = r112;
        this.f332842m = r113;
        this.f332843n = r114;
        this.f332844o = r115;
    }
}
