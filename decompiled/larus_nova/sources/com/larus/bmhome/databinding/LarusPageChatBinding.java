package com.larus.bmhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.layout.widget.NestedScrollableContainer;
import com.larus.bmhome.double_post.drag_panel.ChatAwemeNestedContainer;
import com.larus.bmhome.view.BottomMenuGridLayout;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.common_ui.view.TouchInterceptingView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageChatBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatConstraintLayout f311085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChatAwemeNestedContainer f311086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f311087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f311088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BottomMenuGridLayout f311089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f311090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ChatConstraintLayout f311091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f311092h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f311093i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f311094j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TouchInterceptingView f311095k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TouchInterceptingView f311096l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final FrameLayout f311097m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ChatMessageList f311098n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final NestedScrollableContainer f311099o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final FrameLayout f311100p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f311101q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final FrameLayout f311102r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final LinearLayout f311103s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LinearLayout f311104t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TouchInterceptingView f311105u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TouchInterceptingView f311106v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final TextView f311107w;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311085a;
    }

    public static LarusPageChatBinding a(View r210) {
        int r100 = R.id.aweme_container;
        ChatAwemeNestedContainer r101 = (ChatAwemeNestedContainer) ViewBindings.findChildViewById(r210, R.id.aweme_container);
        if (r101 == null) goto L81;
        r100 = R.id.aweme_list;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(r210, R.id.aweme_list);
        if (r102 == null) goto L81;
        r100 = R.id.bottom_floating_button_container;
        if (((ViewStub) ViewBindings.findChildViewById(r210, R.id.bottom_floating_button_container)) == null) goto L81;
        r100 = R.id.bottom_layout;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r210, R.id.bottom_layout);
        if (r103 == null) goto L81;
        r100 = R.id.bottom_menu;
        BottomMenuGridLayout r104 = (BottomMenuGridLayout) ViewBindings.findChildViewById(r210, R.id.bottom_menu);
        if (r104 == null) goto L81;
        r100 = R.id.cancel_modify_area;
        View r105 = ViewBindings.findChildViewById(r210, R.id.cancel_modify_area);
        if (r105 == null) goto L81;
        r100 = R.id.case_layout;
        if (((ViewStub) ViewBindings.findChildViewById(r210, R.id.case_layout)) == null) goto L81;
        r100 = R.id.chat_bubble_banner_overlay_stub;
        if (((ViewStub) ViewBindings.findChildViewById(r210, R.id.chat_bubble_banner_overlay_stub)) == null) goto L81;
        ChatConstraintLayout r110 = (ChatConstraintLayout) r210;
        r100 = R.id.collection_layout;
        if (((ViewStub) ViewBindings.findChildViewById(r210, R.id.collection_layout)) == null) goto L81;
        r100 = R.id.continue_talk_btn;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r210, R.id.continue_talk_btn);
        if (r111 == null) goto L81;
        r100 = R.id.continuous_talk_container;
        if (((ViewStub) ViewBindings.findChildViewById(r210, R.id.continuous_talk_container)) == null) goto L81;
        r100 = R.id.immers_guide;
        if (((ImageView) ViewBindings.findChildViewById(r210, R.id.immers_guide)) == null) goto L81;
        r100 = R.id.input;
        FrameLayout r112 = (FrameLayout) ViewBindings.findChildViewById(r210, R.id.input);
        if (r112 == null) goto L81;
        r100 = R.id.input_bar_overlay_container;
        FrameLayout r113 = (FrameLayout) ViewBindings.findChildViewById(r210, R.id.input_bar_overlay_container);
        if (r113 == null) goto L81;
        r100 = R.id.input_intercept_view;
        TouchInterceptingView r114 = (TouchInterceptingView) ViewBindings.findChildViewById(r210, R.id.input_intercept_view);
        if (r114 == null) goto L81;
        r100 = R.id.intercept_use_interact_view;
        TouchInterceptingView r115 = (TouchInterceptingView) ViewBindings.findChildViewById(r210, R.id.intercept_use_interact_view);
        if (r115 == null) goto L81;
        r100 = R.id.latest_photo_shortcut_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r210, R.id.latest_photo_shortcut_container)) == null) goto L81;
        r100 = R.id.layout_pc_local_cvs_hint;
        if (((ViewStub) ViewBindings.findChildViewById(r210, R.id.layout_pc_local_cvs_hint)) == null) goto L81;
        r100 = R.id.luckdog_stub_view;
        FrameLayout r116 = (FrameLayout) ViewBindings.findChildViewById(r210, R.id.luckdog_stub_view);
        if (r116 == null) goto L81;
        r100 = R.id.message_list;
        ChatMessageList r117 = (ChatMessageList) ViewBindings.findChildViewById(r210, R.id.message_list);
        if (r117 == null) goto L81;
        r100 = R.id.message_list_parent;
        NestedScrollableContainer r118 = (NestedScrollableContainer) ViewBindings.findChildViewById(r210, R.id.message_list_parent);
        if (r118 == null) goto L81;
        r100 = R.id.message_list_sub_parent;
        FrameLayout r119 = (FrameLayout) ViewBindings.findChildViewById(r210, R.id.message_list_sub_parent);
        if (r119 == null) goto L81;
        r100 = R.id.playback_layout;
        if (((ViewStub) ViewBindings.findChildViewById(r210, R.id.playback_layout)) == null) goto L81;
        r100 = R.id.share_layout;
        if (((ViewStub) ViewBindings.findChildViewById(r210, R.id.share_layout)) == null) goto L81;
        r100 = R.id.space_shortcut_x_pos;
        if (((Space) ViewBindings.findChildViewById(r210, R.id.space_shortcut_x_pos)) == null) goto L81;
        r100 = R.id.space_shortcut_y_pos;
        if (((Space) ViewBindings.findChildViewById(r210, R.id.space_shortcut_y_pos)) == null) goto L81;
        r100 = R.id.speaker;
        if (((ViewStub) ViewBindings.findChildViewById(r210, R.id.speaker)) == null) goto L81;
        r100 = R.id.splitter;
        View r211 = ViewBindings.findChildViewById(r210, R.id.splitter);
        if (r211 == null) goto L81;
        r100 = R.id.stub_latest_photo_shortcut;
        if (((ViewStub) ViewBindings.findChildViewById(r210, R.id.stub_latest_photo_shortcut)) == null) goto L81;
        r100 = R.id.title_container;
        FrameLayout r212 = (FrameLayout) ViewBindings.findChildViewById(r210, R.id.title_container);
        if (r212 == null) goto L81;
        r100 = R.id.toggle_next_one;
        LinearLayout r213 = (LinearLayout) ViewBindings.findChildViewById(r210, R.id.toggle_next_one);
        if (r213 == null) goto L81;
        r100 = R.id.toggle_pre_one;
        LinearLayout r214 = (LinearLayout) ViewBindings.findChildViewById(r210, R.id.toggle_pre_one);
        if (r214 == null) goto L81;
        r100 = R.id.top_button_intercept_view;
        TouchInterceptingView r215 = (TouchInterceptingView) ViewBindings.findChildViewById(r210, R.id.top_button_intercept_view);
        if (r215 == null) goto L81;
        r100 = R.id.top_floating_button_container;
        if (((ViewStub) ViewBindings.findChildViewById(r210, R.id.top_floating_button_container)) == null) goto L81;
        r100 = R.id.touch_intercepting_view;
        TouchInterceptingView r216 = (TouchInterceptingView) ViewBindings.findChildViewById(r210, R.id.touch_intercepting_view);
        if (r216 == null) goto L81;
        r100 = R.id.tv_login_guide_banner;
        TextView r217 = (TextView) ViewBindings.findChildViewById(r210, R.id.tv_login_guide_banner);
        if (r217 == null) goto L81;
        r100 = R.id.user_ban_intercept_view;
        if (((TouchInterceptingView) ViewBindings.findChildViewById(r210, R.id.user_ban_intercept_view)) == null) goto L81;
        r100 = R.id.view_stub_of_deep_think_top_header;
        if (((ViewStub) ViewBindings.findChildViewById(r210, R.id.view_stub_of_deep_think_top_header)) == null) goto L81;
        return new LarusPageChatBinding(r110, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r211, r212, r213, r214, r215, r216, r217);
    L81:
        throw new NullPointerException("Missing required view with ID: ".concat(r210.getResources().getResourceName(r100)));
    }

    public static LarusPageChatBinding b(LayoutInflater r100, ViewGroup r101) {
        return a(r100.inflate(R.layout.larus_page_chat, r101, false));
    }

    public LarusPageChatBinding(ChatConstraintLayout r100, ChatAwemeNestedContainer r101, FrameLayout r102, FrameLayout r103, BottomMenuGridLayout r104, View r105, ChatConstraintLayout r106, TextView r110, FrameLayout r111, FrameLayout r112, TouchInterceptingView r113, TouchInterceptingView r114, FrameLayout r115, ChatMessageList r116, NestedScrollableContainer r117, FrameLayout r118, View r119, FrameLayout r210, LinearLayout r211, LinearLayout r212, TouchInterceptingView r213, TouchInterceptingView r214, TextView r215) {
        this.f311085a = r100;
        this.f311086b = r101;
        this.f311087c = r102;
        this.f311088d = r103;
        this.f311089e = r104;
        this.f311090f = r105;
        this.f311091g = r106;
        this.f311092h = r110;
        this.f311093i = r111;
        this.f311094j = r112;
        this.f311095k = r113;
        this.f311096l = r114;
        this.f311097m = r115;
        this.f311098n = r116;
        this.f311099o = r117;
        this.f311100p = r118;
        this.f311101q = r119;
        this.f311102r = r210;
        this.f311103s = r211;
        this.f311104t = r212;
        this.f311105u = r213;
        this.f311106v = r214;
        this.f311107w = r215;
    }
}
