package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.larus.voicecall.impl.continue_talk.ChatContinuousTalkLayout;
import com.larus.voicecall.impl.ui.VoiceCallVideoView;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusLayoutContinuousBottomContainerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f378256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceCallVideoView f378257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f378258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ChatContinuousTalkLayout f378259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f378260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f378261f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f378256a;
    }

    public static LarusLayoutContinuousBottomContainerBinding a(View r100) {
        int r101 = R.id.call_video_view;
        VoiceCallVideoView r102 = (VoiceCallVideoView) ViewBindings.findChildViewById(r100, R.id.call_video_view);
        if (r102 == null) goto L13;
        FrameLayout r103 = (FrameLayout) r100;
        r101 = R.id.continuous_talk_controller;
        ChatContinuousTalkLayout r104 = (ChatContinuousTalkLayout) ViewBindings.findChildViewById(r100, R.id.continuous_talk_controller);
        if (r104 == null) goto L13;
        r101 = R.id.fl_root_realtime_call_fragment;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.fl_root_realtime_call_fragment);
        if (r105 == null) goto L13;
        r101 = R.id.realtime_call_top_mask;
        View r106 = ViewBindings.findChildViewById(r100, R.id.realtime_call_top_mask);
        if (r106 == null) goto L13;
        return new LarusLayoutContinuousBottomContainerBinding(r103, r102, r103, r104, r105, r106);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusLayoutContinuousBottomContainerBinding(FrameLayout r100, VoiceCallVideoView r101, FrameLayout r102, ChatContinuousTalkLayout r103, LinearLayout r104, View r105) {
        this.f378256a = r100;
        this.f378257b = r101;
        this.f378258c = r102;
        this.f378259d = r103;
        this.f378260e = r104;
        this.f378261f = r105;
    }
}
