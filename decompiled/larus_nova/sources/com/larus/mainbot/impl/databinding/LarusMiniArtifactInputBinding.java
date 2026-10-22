package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.BottomMenuGridLayout;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common_ui.view.TouchInterceptingView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusMiniArtifactInputBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatConstraintLayout f358776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f358777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BottomMenuGridLayout f358778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ChatConstraintLayout f358779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f358780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TouchInterceptingView f358781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f358782g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358776a;
    }

    public static LarusMiniArtifactInputBinding a(View r110) {
        int r100 = R.id.bottom_layout;
        FrameLayout r101 = (FrameLayout) ViewBindings.findChildViewById(r110, R.id.bottom_layout);
        if (r101 == null) goto L37;
        r100 = R.id.bottom_menu;
        BottomMenuGridLayout r102 = (BottomMenuGridLayout) ViewBindings.findChildViewById(r110, R.id.bottom_menu);
        if (r102 == null) goto L37;
        r100 = R.id.case_layout;
        if (((ViewStub) ViewBindings.findChildViewById(r110, R.id.case_layout)) == null) goto L37;
        ChatConstraintLayout r103 = (ChatConstraintLayout) r110;
        r100 = R.id.input;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r110, R.id.input);
        if (r104 == null) goto L37;
        r100 = R.id.input_delegate;
        if (((ViewStub) ViewBindings.findChildViewById(r110, R.id.input_delegate)) == null) goto L37;
        r100 = R.id.input_intercept_view;
        TouchInterceptingView r105 = (TouchInterceptingView) ViewBindings.findChildViewById(r110, R.id.input_intercept_view);
        if (r105 == null) goto L37;
        r100 = R.id.intercept_use_interact_view;
        if (((TouchInterceptingView) ViewBindings.findChildViewById(r110, R.id.intercept_use_interact_view)) == null) goto L37;
        r100 = R.id.latest_photo_shortcut_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r110, R.id.latest_photo_shortcut_container)) == null) goto L37;
        r100 = R.id.playback_layout;
        if (((ViewStub) ViewBindings.findChildViewById(r110, R.id.playback_layout)) == null) goto L37;
        r100 = R.id.space_shortcut_x_pos;
        if (((Space) ViewBindings.findChildViewById(r110, R.id.space_shortcut_x_pos)) == null) goto L37;
        r100 = R.id.space_shortcut_y_pos;
        if (((Space) ViewBindings.findChildViewById(r110, R.id.space_shortcut_y_pos)) == null) goto L37;
        r100 = R.id.speaker;
        if (((ViewStub) ViewBindings.findChildViewById(r110, R.id.speaker)) == null) goto L37;
        r100 = R.id.splitter;
        View r106 = ViewBindings.findChildViewById(r110, R.id.splitter);
        if (r106 == null) goto L37;
        r100 = R.id.stub_latest_photo_shortcut;
        if (((ViewStub) ViewBindings.findChildViewById(r110, R.id.stub_latest_photo_shortcut)) == null) goto L37;
        r100 = R.id.top_button_intercept_view;
        if (((TouchInterceptingView) ViewBindings.findChildViewById(r110, R.id.top_button_intercept_view)) == null) goto L37;
        r100 = R.id.touch_intercepting_view;
        if (((TouchInterceptingView) ViewBindings.findChildViewById(r110, R.id.touch_intercepting_view)) == null) goto L37;
        return new LarusMiniArtifactInputBinding(r103, r101, r102, r103, r104, r105, r106);
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r100)));
    }

    public LarusMiniArtifactInputBinding(ChatConstraintLayout r100, FrameLayout r101, BottomMenuGridLayout r102, ChatConstraintLayout r103, FrameLayout r104, TouchInterceptingView r105, View r106) {
        this.f358776a = r100;
        this.f358777b = r101;
        this.f358778c = r102;
        this.f358779d = r103;
        this.f358780e = r104;
        this.f358781f = r105;
        this.f358782g = r106;
    }
}
