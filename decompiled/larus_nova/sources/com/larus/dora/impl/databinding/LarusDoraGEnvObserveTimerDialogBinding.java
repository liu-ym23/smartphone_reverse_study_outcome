package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraGEnvObserveTimerDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f332601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraTextView f332602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoraTextView f332603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f332604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraTextView f332605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f332606f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332601a;
    }

    public static LarusDoraGEnvObserveTimerDialogBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_dora_g_env_observe_timer_dialog, r101, false);
        int r103 = R.id.dora_g_env_observe_timer_dialog_cancel;
        DoraTextView r104 = (DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_g_env_observe_timer_dialog_cancel);
        if (r104 == null) goto L15;
        r103 = R.id.dora_g_env_observe_timer_dialog_confirm;
        DoraTextView r105 = (DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_g_env_observe_timer_dialog_confirm);
        if (r105 == null) goto L15;
        r103 = R.id.dora_g_env_observe_timer_dialog_tips;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.dora_g_env_observe_timer_dialog_tips);
        if (r106 == null) goto L15;
        r103 = R.id.dora_g_env_observe_timer_dialog_title;
        DoraTextView r107 = (DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_g_env_observe_timer_dialog_title);
        if (r107 == null) goto L15;
        r103 = R.id.time_layout;
        LinearLayout r108 = (LinearLayout) ViewBindings.findChildViewById(r102, R.id.time_layout);
        if (r108 == null) goto L15;
        return new LarusDoraGEnvObserveTimerDialogBinding((FrameLayout) r102, r104, r105, r106, r107, r108);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusDoraGEnvObserveTimerDialogBinding(FrameLayout r100, DoraTextView r101, DoraTextView r102, AppCompatTextView r103, DoraTextView r104, LinearLayout r105) {
        this.f332601a = r100;
        this.f332602b = r101;
        this.f332603c = r102;
        this.f332604d = r103;
        this.f332605e = r104;
        this.f332606f = r105;
    }
}
