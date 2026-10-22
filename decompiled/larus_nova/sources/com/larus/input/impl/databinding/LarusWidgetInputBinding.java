package com.larus.input.impl.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.bmhome.view.actionbar.custom.actionbarpanel.CustomActionBarPanel;
import com.larus.bmhome.view.resourcebar.ResourceBar;
import com.larus.chat.common.databinding.LarusWidgetInputSuggestedActionBinding;
import com.larus.common_ui.view.ChatInputInnerView;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.common_ui.widget.input.audiowave.gradient.AudioWaveGradientView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LarusWidgetInputBinding implements ViewBinding {
    public final FrameLayout A;
    public final TextView B;
    public final View C;
    public final FrameLayout D;
    public final View E;
    public final FrameLayout F;
    public final LinearLayout G;
    public final ConstraintLayout H;
    public final ConstraintLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Barrier f351490J;
    public final View K;
    public final LarusWidgetInputSuggestedActionBinding L;
    public final ViewStub M;
    public final AppCompatImageView N;
    public final ResourceBar O;
    public final FrameLayout P;
    public final ProgressBar Q;
    public final ChatInputInnerView R;
    public final FrameLayout S;
    public final FrameLayout T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f351491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f351492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f351493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f351494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GradientMaskView f351495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CustomActionBarPanel f351496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f351497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f351498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f351499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f351500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AppCompatImageView f351501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AppCompatImageView f351502l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final FrameLayout f351503m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ViewStub f351504n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ViewStub f351505o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageView f351506p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConstraintLayout f351507q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AppCompatImageView f351508r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f351509s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AppCompatImageView f351510t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final FrameLayout f351511u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AppCompatImageView f351512v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final FrameLayout f351513w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AppCompatImageView f351514x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final LottieAnimationView f351515y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AudioWaveGradientView f351516z;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f351491a;
    }

    public static LarusWidgetInputBinding a(View r410) {
        int r100 = R.id.action_ai_gen;
        AppCompatImageView r101 = (AppCompatImageView) ViewBindings.findChildViewById(r410, R.id.action_ai_gen);
        if (r101 == null) goto L99;
        r100 = R.id.action_area;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r410, R.id.action_area);
        if (r102 == null) goto L99;
        r100 = R.id.action_bar;
        RecyclerView r103 = (RecyclerView) ViewBindings.findChildViewById(r410, R.id.action_bar);
        if (r103 == null) goto L99;
        r100 = R.id.action_bar_container;
        GradientMaskView r104 = (GradientMaskView) ViewBindings.findChildViewById(r410, R.id.action_bar_container);
        if (r104 == null) goto L99;
        r100 = R.id.action_bar_panel;
        CustomActionBarPanel r105 = (CustomActionBarPanel) ViewBindings.findChildViewById(r410, R.id.action_bar_panel);
        if (r105 == null) goto L99;
        r100 = R.id.action_break;
        AppCompatImageView r106 = (AppCompatImageView) ViewBindings.findChildViewById(r410, R.id.action_break);
        if (r106 == null) goto L99;
        r100 = R.id.action_entrance;
        FrameLayout r107 = (FrameLayout) ViewBindings.findChildViewById(r410, R.id.action_entrance);
        if (r107 == null) goto L99;
        r100 = R.id.action_entrance_iv;
        AppCompatImageView r108 = (AppCompatImageView) ViewBindings.findChildViewById(r410, R.id.action_entrance_iv);
        if (r108 == null) goto L99;
        r100 = R.id.action_entrance_red_dot;
        TextView r110 = (TextView) ViewBindings.findChildViewById(r410, R.id.action_entrance_red_dot);
        if (r110 == null) goto L99;
        r100 = R.id.action_full_screen;
        AppCompatImageView r111 = (AppCompatImageView) ViewBindings.findChildViewById(r410, R.id.action_full_screen);
        if (r111 == null) goto L99;
        r100 = R.id.action_input;
        AppCompatImageView r112 = (AppCompatImageView) ViewBindings.findChildViewById(r410, R.id.action_input);
        if (r112 == null) goto L99;
        r100 = R.id.action_menu_entrance;
        FrameLayout r113 = (FrameLayout) ViewBindings.findChildViewById(r410, R.id.action_menu_entrance);
        if (r113 == null) goto L99;
        r100 = R.id.action_modify_cancel;
        ViewStub r114 = (ViewStub) ViewBindings.findChildViewById(r410, R.id.action_modify_cancel);
        if (r114 == null) goto L99;
        r100 = R.id.action_modify_confirm;
        ViewStub r115 = (ViewStub) ViewBindings.findChildViewById(r410, R.id.action_modify_confirm);
        if (r115 == null) goto L99;
        r100 = R.id.action_modify_confirm_new;
        ImageView r116 = (ImageView) ViewBindings.findChildViewById(r410, R.id.action_modify_confirm_new);
        if (r116 == null) goto L99;
        r100 = R.id.action_press_speak_group;
        ConstraintLayout r117 = (ConstraintLayout) ViewBindings.findChildViewById(r410, R.id.action_press_speak_group);
        if (r117 == null) goto L99;
        r100 = R.id.action_press_speak_icon;
        AppCompatImageView r118 = (AppCompatImageView) ViewBindings.findChildViewById(r410, R.id.action_press_speak_icon);
        if (r118 == null) goto L99;
        r100 = R.id.action_press_speak_text;
        TextView r119 = (TextView) ViewBindings.findChildViewById(r410, R.id.action_press_speak_text);
        if (r119 == null) goto L99;
        r100 = R.id.action_send;
        AppCompatImageView r210 = (AppCompatImageView) ViewBindings.findChildViewById(r410, R.id.action_send);
        if (r210 == null) goto L99;
        r100 = R.id.action_send_container;
        FrameLayout r211 = (FrameLayout) ViewBindings.findChildViewById(r410, R.id.action_send_container);
        if (r211 == null) goto L99;
        r100 = R.id.action_speak;
        AppCompatImageView r212 = (AppCompatImageView) ViewBindings.findChildViewById(r410, R.id.action_speak);
        if (r212 == null) goto L99;
        r100 = R.id.action_speak_group;
        FrameLayout r213 = (FrameLayout) ViewBindings.findChildViewById(r410, R.id.action_speak_group);
        if (r213 == null) goto L99;
        r100 = R.id.action_speech;
        AppCompatImageView r214 = (AppCompatImageView) ViewBindings.findChildViewById(r410, R.id.action_speech);
        if (r214 == null) goto L99;
        r100 = R.id.action_voice_input;
        LottieAnimationView r215 = (LottieAnimationView) ViewBindings.findChildViewById(r410, R.id.action_voice_input);
        if (r215 == null) goto L99;
        r100 = R.id.audio_visualizer;
        AudioWaveGradientView r216 = (AudioWaveGradientView) ViewBindings.findChildViewById(r410, R.id.audio_visualizer);
        if (r216 == null) goto L99;
        r100 = R.id.chat_input_mention_panel;
        FrameLayout r217 = (FrameLayout) ViewBindings.findChildViewById(r410, R.id.chat_input_mention_panel);
        if (r217 == null) goto L99;
        r100 = R.id.disclaimer;
        TextView r218 = (TextView) ViewBindings.findChildViewById(r410, R.id.disclaimer);
        if (r218 == null) goto L99;
        r100 = R.id.divider_input_area_above;
        View r219 = ViewBindings.findChildViewById(r410, R.id.divider_input_area_above);
        if (r219 == null) goto L99;
        r100 = R.id.divider_input_area_above_container;
        FrameLayout r310 = (FrameLayout) ViewBindings.findChildViewById(r410, R.id.divider_input_area_above_container);
        if (r310 == null) goto L99;
        r100 = R.id.divider_input_area_below;
        View r311 = ViewBindings.findChildViewById(r410, R.id.divider_input_area_below);
        if (r311 == null) goto L99;
        r100 = R.id.focus_holder;
        if (((EditText) ViewBindings.findChildViewById(r410, R.id.focus_holder)) == null) goto L99;
        r100 = R.id.input_above_layout;
        FrameLayout r312 = (FrameLayout) ViewBindings.findChildViewById(r410, R.id.input_above_layout);
        if (r312 == null) goto L99;
        r100 = R.id.input_above_ll_container;
        LinearLayout r313 = (LinearLayout) ViewBindings.findChildViewById(r410, R.id.input_above_ll_container);
        if (r313 == null) goto L99;
        r100 = R.id.input_area;
        ConstraintLayout r314 = (ConstraintLayout) ViewBindings.findChildViewById(r410, R.id.input_area);
        if (r314 == null) goto L99;
        r100 = R.id.input_area_container;
        ConstraintLayout r315 = (ConstraintLayout) ViewBindings.findChildViewById(r410, R.id.input_area_container);
        if (r315 == null) goto L99;
        r100 = R.id.input_barrier;
        Barrier r316 = (Barrier) ViewBindings.findChildViewById(r410, R.id.input_barrier);
        if (r316 == null) goto L99;
        r100 = R.id.input_center_anchor;
        View r317 = ViewBindings.findChildViewById(r410, R.id.input_center_anchor);
        if (r317 == null) goto L99;
        r100 = R.id.input_editor_container;
        if (((ViewStub) ViewBindings.findChildViewById(r410, R.id.input_editor_container)) == null) goto L99;
        r100 = R.id.input_suggested_action_container;
        View r318 = ViewBindings.findChildViewById(r410, R.id.input_suggested_action_container);
        if (r318 == null) goto L99;
        LarusWidgetInputSuggestedActionBinding r319 = LarusWidgetInputSuggestedActionBinding.a(r318);
        r100 = R.id.input_text;
        ViewStub r320 = (ViewStub) ViewBindings.findChildViewById(r410, R.id.input_text);
        if (r320 == null) goto L99;
        r100 = R.id.iv_action_menu_entrance;
        AppCompatImageView r411 = (AppCompatImageView) ViewBindings.findChildViewById(r410, R.id.iv_action_menu_entrance);
        if (r411 == null) goto L99;
        r100 = R.id.layout_multi_attachment_area;
        ResourceBar r412 = (ResourceBar) ViewBindings.findChildViewById(r410, R.id.layout_multi_attachment_area);
        if (r412 == null) goto L99;
        r100 = R.id.layout_resource_bar_attachment_holder;
        FrameLayout r413 = (FrameLayout) ViewBindings.findChildViewById(r410, R.id.layout_resource_bar_attachment_holder);
        if (r413 == null) goto L99;
        r100 = R.id.progress_ai_gen;
        ProgressBar r414 = (ProgressBar) ViewBindings.findChildViewById(r410, R.id.progress_ai_gen);
        if (r414 == null) goto L99;
        r100 = R.id.speak_area;
        ChatInputInnerView r415 = (ChatInputInnerView) ViewBindings.findChildViewById(r410, R.id.speak_area);
        if (r415 == null) goto L99;
        r100 = R.id.voice_input_container;
        FrameLayout r416 = (FrameLayout) ViewBindings.findChildViewById(r410, R.id.voice_input_container);
        if (r416 == null) goto L99;
        r100 = R.id.voice_visualizer_container;
        FrameLayout r417 = (FrameLayout) ViewBindings.findChildViewById(r410, R.id.voice_visualizer_container);
        if (r417 == null) goto L99;
        return new LarusWidgetInputBinding(r410, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r319, r320, r411, r412, r413, r414, r415, r416, r417);
    L99:
        throw new NullPointerException("Missing required view with ID: ".concat(r410.getResources().getResourceName(r100)));
    }

    public LarusWidgetInputBinding(View r100, AppCompatImageView r101, LinearLayout r102, RecyclerView r103, GradientMaskView r104, CustomActionBarPanel r105, AppCompatImageView r106, FrameLayout r110, AppCompatImageView r111, TextView r112, AppCompatImageView r113, AppCompatImageView r114, FrameLayout r115, ViewStub r116, ViewStub r117, ImageView r118, ConstraintLayout r119, AppCompatImageView r210, TextView r211, AppCompatImageView r212, FrameLayout r213, AppCompatImageView r214, FrameLayout r215, AppCompatImageView r216, LottieAnimationView r217, AudioWaveGradientView r218, FrameLayout r219, TextView r310, View r311, FrameLayout r312, View r313, FrameLayout r314, LinearLayout r315, ConstraintLayout r316, ConstraintLayout r317, Barrier r318, View r319, LarusWidgetInputSuggestedActionBinding r410, ViewStub r411, AppCompatImageView r412, ResourceBar r413, FrameLayout r414, ProgressBar r415, ChatInputInnerView r416, FrameLayout r417, FrameLayout r418) {
        this.f351491a = r100;
        this.f351492b = r101;
        this.f351493c = r102;
        this.f351494d = r103;
        this.f351495e = r104;
        this.f351496f = r105;
        this.f351497g = r106;
        this.f351498h = r110;
        this.f351499i = r111;
        this.f351500j = r112;
        this.f351501k = r113;
        this.f351502l = r114;
        this.f351503m = r115;
        this.f351504n = r116;
        this.f351505o = r117;
        this.f351506p = r118;
        this.f351507q = r119;
        this.f351508r = r210;
        this.f351509s = r211;
        this.f351510t = r212;
        this.f351511u = r213;
        this.f351512v = r214;
        this.f351513w = r215;
        this.f351514x = r216;
        this.f351515y = r217;
        this.f351516z = r218;
        this.A = r219;
        this.B = r310;
        this.C = r311;
        this.D = r312;
        this.E = r313;
        this.F = r314;
        this.G = r315;
        this.H = r316;
        this.I = r317;
        this.f351490J = r318;
        this.K = r319;
        this.L = r410;
        this.M = r411;
        this.N = r412;
        this.O = r413;
        this.P = r414;
        this.Q = r415;
        this.R = r416;
        this.S = r417;
        this.T = r418;
    }
}
