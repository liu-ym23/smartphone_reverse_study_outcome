package com.larus.chat.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.legacy.widget.Space;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.view.TitleAvatarImageView;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.nova.R;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes4.dex */
public final class LarusChatTitleAlignLeftStyleBinding implements ViewBinding {
    public final TabLayout A;
    public final TextView B;
    public final TextView C;
    public final LottieAdapterView D;
    public final FrameLayout E;
    public final AppCompatImageView F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f323916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f323917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TitleAvatarImageView f323918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f323919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RedDotTextView f323920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f323921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f323922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f323923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Barrier f323924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f323925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConstraintLayout f323926k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Barrier f323927l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Guideline f323928m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Space f323929n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AppCompatImageView f323930o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final FrameLayout f323931p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ImageView f323932q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final FrameLayout f323933r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AppCompatImageView f323934s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final FrameLayout f323935t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextView f323936u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final FrameLayout f323937v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AppCompatImageView f323938w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final View f323939x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AppCompatImageView f323940y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextView f323941z;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f323916a;
    }

    public static LarusChatTitleAlignLeftStyleBinding a(LayoutInflater r310, ViewGroup r311) {
        if (r311 == null) goto L71;
        r310.inflate(R.layout.larus_chat_title_align_left_style, r311);
        int r100 = R.id.add_bot;
        AppCompatImageView r101 = (AppCompatImageView) ViewBindings.findChildViewById(r311, R.id.add_bot);
        if (r101 == null) goto L69;
        r100 = R.id.avatar;
        TitleAvatarImageView r102 = (TitleAvatarImageView) ViewBindings.findChildViewById(r311, R.id.avatar);
        if (r102 == null) goto L69;
        r100 = R.id.back_icon;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r311, R.id.back_icon);
        if (r103 == null) goto L69;
        r100 = R.id.chat_title_red_dot;
        RedDotTextView r104 = (RedDotTextView) ViewBindings.findChildViewById(r311, R.id.chat_title_red_dot);
        if (r104 == null) goto L69;
        r100 = R.id.create_new_cvs;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r311, R.id.create_new_cvs);
        if (r105 == null) goto L69;
        r100 = R.id.ic_arrow;
        AppCompatImageView r106 = (AppCompatImageView) ViewBindings.findChildViewById(r311, R.id.ic_arrow);
        if (r106 == null) goto L69;
        r100 = R.id.iv_history;
        ImageView r107 = (ImageView) ViewBindings.findChildViewById(r311, R.id.iv_history);
        if (r107 == null) goto L69;
        r100 = R.id.larus_chat_left_entry_end_barrier;
        Barrier r108 = (Barrier) ViewBindings.findChildViewById(r311, R.id.larus_chat_left_entry_end_barrier);
        if (r108 == null) goto L69;
        r100 = R.id.larus_chat_top_left_create_new_cvs;
        AppCompatImageView r110 = (AppCompatImageView) ViewBindings.findChildViewById(r311, R.id.larus_chat_top_left_create_new_cvs);
        if (r110 == null) goto L69;
        r100 = R.id.main_container;
        ConstraintLayout r111 = (ConstraintLayout) ViewBindings.findChildViewById(r311, R.id.main_container);
        if (r111 == null) goto L69;
        r100 = R.id.main_container_end_barrier;
        Barrier r112 = (Barrier) ViewBindings.findChildViewById(r311, R.id.main_container_end_barrier);
        if (r112 == null) goto L69;
        r100 = R.id.main_container_start_barrier;
        Guideline r113 = (Guideline) ViewBindings.findChildViewById(r311, R.id.main_container_start_barrier);
        if (r113 == null) goto L69;
        r100 = R.id.min_end_space;
        Space r114 = (Space) ViewBindings.findChildViewById(r311, R.id.min_end_space);
        if (r114 == null) goto L69;
        r100 = R.id.more;
        AppCompatImageView r115 = (AppCompatImageView) ViewBindings.findChildViewById(r311, R.id.more);
        if (r115 == null) goto L69;
        r100 = R.id.more_add_bot;
        FrameLayout r116 = (FrameLayout) ViewBindings.findChildViewById(r311, R.id.more_add_bot);
        if (r116 == null) goto L69;
        r100 = R.id.multitask_management_icon;
        ImageView r117 = (ImageView) ViewBindings.findChildViewById(r311, R.id.multitask_management_icon);
        if (r117 == null) goto L69;
        r100 = R.id.page_size_icon_slot;
        FrameLayout r118 = (FrameLayout) ViewBindings.findChildViewById(r311, R.id.page_size_icon_slot);
        if (r118 == null) goto L69;
        r100 = R.id.real_time_call;
        AppCompatImageView r119 = (AppCompatImageView) ViewBindings.findChildViewById(r311, R.id.real_time_call);
        if (r119 == null) goto L69;
        r100 = R.id.real_time_call_ic_container;
        FrameLayout r210 = (FrameLayout) ViewBindings.findChildViewById(r311, R.id.real_time_call_ic_container);
        if (r210 == null) goto L69;
        r100 = R.id.real_time_call_red_dot;
        TextView r211 = (TextView) ViewBindings.findChildViewById(r311, R.id.real_time_call_red_dot);
        if (r211 == null) goto L69;
        r100 = R.id.search_icon;
        FrameLayout r212 = (FrameLayout) ViewBindings.findChildViewById(r311, R.id.search_icon);
        if (r212 == null) goto L69;
        r100 = R.id.search_icon_image;
        AppCompatImageView r213 = (AppCompatImageView) ViewBindings.findChildViewById(r311, R.id.search_icon_image);
        if (r213 == null) goto L69;
        r100 = R.id.search_icon_red_dot;
        View r214 = ViewBindings.findChildViewById(r311, R.id.search_icon_red_dot);
        if (r214 == null) goto L69;
        r100 = R.id.side_nav_icon;
        AppCompatImageView r215 = (AppCompatImageView) ViewBindings.findChildViewById(r311, R.id.side_nav_icon);
        if (r215 == null) goto L69;
        r100 = R.id.subtitle;
        TextView r216 = (TextView) ViewBindings.findChildViewById(r311, R.id.subtitle);
        if (r216 == null) goto L69;
        r100 = R.id.tab_layout;
        TabLayout r217 = (TabLayout) ViewBindings.findChildViewById(r311, R.id.tab_layout);
        if (r217 == null) goto L69;
        r100 = R.id.tag;
        TextView r218 = (TextView) ViewBindings.findChildViewById(r311, R.id.tag);
        if (r218 == null) goto L69;
        r100 = R.id.title;
        TextView r219 = (TextView) ViewBindings.findChildViewById(r311, R.id.title);
        if (r219 == null) goto L69;
        r100 = R.id.tts;
        LottieAdapterView r312 = (LottieAdapterView) ViewBindings.findChildViewById(r311, R.id.tts);
        if (r312 == null) goto L69;
        r100 = R.id.tts_container;
        FrameLayout r313 = (FrameLayout) ViewBindings.findChildViewById(r311, R.id.tts_container);
        if (r313 == null) goto L69;
        r100 = R.id.tts_continuous_talk;
        AppCompatImageView r314 = (AppCompatImageView) ViewBindings.findChildViewById(r311, R.id.tts_continuous_talk);
        if (r314 == null) goto L69;
        return new LarusChatTitleAlignLeftStyleBinding(r311, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r312, r313, r314);
    L69:
        throw new NullPointerException("Missing required view with ID: ".concat(r311.getResources().getResourceName(r100)));
    L71:
        throw new NullPointerException("parent");
    }

    public LarusChatTitleAlignLeftStyleBinding(View r100, AppCompatImageView r101, TitleAvatarImageView r102, AppCompatImageView r103, RedDotTextView r104, AppCompatImageView r105, AppCompatImageView r106, ImageView r110, Barrier r111, AppCompatImageView r112, ConstraintLayout r113, Barrier r114, Guideline r115, Space r116, AppCompatImageView r117, FrameLayout r118, ImageView r119, FrameLayout r210, AppCompatImageView r211, FrameLayout r212, TextView r213, FrameLayout r214, AppCompatImageView r215, View r216, AppCompatImageView r217, TextView r218, TabLayout r219, TextView r310, TextView r311, LottieAdapterView r312, FrameLayout r313, AppCompatImageView r314) {
        this.f323916a = r100;
        this.f323917b = r101;
        this.f323918c = r102;
        this.f323919d = r103;
        this.f323920e = r104;
        this.f323921f = r105;
        this.f323922g = r106;
        this.f323923h = r110;
        this.f323924i = r111;
        this.f323925j = r112;
        this.f323926k = r113;
        this.f323927l = r114;
        this.f323928m = r115;
        this.f323929n = r116;
        this.f323930o = r117;
        this.f323931p = r118;
        this.f323932q = r119;
        this.f323933r = r210;
        this.f323934s = r211;
        this.f323935t = r212;
        this.f323936u = r213;
        this.f323937v = r214;
        this.f323938w = r215;
        this.f323939x = r216;
        this.f323940y = r217;
        this.f323941z = r218;
        this.A = r219;
        this.B = r310;
        this.C = r311;
        this.D = r312;
        this.E = r313;
        this.F = r314;
    }
}
