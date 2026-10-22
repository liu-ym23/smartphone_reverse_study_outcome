package com.larus.login.impl.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.login.impl.view.TouristTipLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusAccountLoginPageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f357424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f357425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f357426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f357427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f357428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f357429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f357430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f357431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Space f357432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f357433j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinearLayout f357434k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageView f357435l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinearLayout f357436m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ConstraintLayout f357437n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ViewStub f357438o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final UrlSpanTextView f357439p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Space f357440q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CheckBox f357441r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final LinearLayout f357442s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TouristTipLayout f357443t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextView f357444u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TextView f357445v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final TextView f357446w;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f357424a;
    }

    public static LarusAccountLoginPageBinding a(View r210) {
        int r100 = R.id.account_text_ll;
        LinearLayout r101 = (LinearLayout) ViewBindings.findChildViewById(r210, R.id.account_text_ll);
        if (r101 == null) goto L55;
        r100 = R.id.account_title;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r210, R.id.account_title);
        if (r102 == null) goto L55;
        r100 = R.id.account_title_loading;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r210, R.id.account_title_loading);
        if (r103 == null) goto L55;
        r100 = R.id.animator_title;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(r210, R.id.animator_title);
        if (r104 == null) goto L55;
        r100 = R.id.bottom_tips_container;
        ConstraintLayout r105 = (ConstraintLayout) ViewBindings.findChildViewById(r210, R.id.bottom_tips_container);
        if (r105 == null) goto L55;
        r100 = R.id.bottom_tips_divider;
        View r110 = ViewBindings.findChildViewById(r210, R.id.bottom_tips_divider);
        if (r110 == null) goto L55;
        r100 = R.id.constaint_layout;
        ConstraintLayout r111 = (ConstraintLayout) ViewBindings.findChildViewById(r210, R.id.constaint_layout);
        if (r111 == null) goto L55;
        r100 = R.id.downgrade_button;
        if (((TextView) ViewBindings.findChildViewById(r210, R.id.downgrade_button)) == null) goto L55;
        r100 = R.id.downgrade_login_items;
        if (((LinearLayout) ViewBindings.findChildViewById(r210, R.id.downgrade_login_items)) == null) goto L55;
        r100 = R.id.left_space;
        Space r112 = (Space) ViewBindings.findChildViewById(r210, R.id.left_space);
        if (r112 == null) goto L55;
        r100 = R.id.login_anim_move_view;
        View r113 = ViewBindings.findChildViewById(r210, R.id.login_anim_move_view);
        if (r113 == null) goto L55;
        r100 = R.id.login_bottom_items;
        LinearLayout r114 = (LinearLayout) ViewBindings.findChildViewById(r210, R.id.login_bottom_items);
        if (r114 == null) goto L55;
        r100 = R.id.login_button_fold;
        ImageView r115 = (ImageView) ViewBindings.findChildViewById(r210, R.id.login_button_fold);
        if (r115 == null) goto L55;
        r100 = R.id.login_items;
        LinearLayout r116 = (LinearLayout) ViewBindings.findChildViewById(r210, R.id.login_items);
        if (r116 == null) goto L55;
        r100 = R.id.login_items_container;
        ConstraintLayout r117 = (ConstraintLayout) ViewBindings.findChildViewById(r210, R.id.login_items_container);
        if (r117 == null) goto L55;
        r100 = R.id.obric_welcome_content_stub;
        ViewStub r118 = (ViewStub) ViewBindings.findChildViewById(r210, R.id.obric_welcome_content_stub);
        if (r118 == null) goto L55;
        r100 = R.id.privacy_policy_text;
        UrlSpanTextView r119 = (UrlSpanTextView) ViewBindings.findChildViewById(r210, R.id.privacy_policy_text);
        if (r119 == null) goto L55;
        r100 = R.id.right_bottom_tips_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r210, R.id.right_bottom_tips_container)) == null) goto L55;
        r100 = R.id.right_space;
        Space r211 = (Space) ViewBindings.findChildViewById(r210, R.id.right_space);
        if (r211 == null) goto L55;
        r100 = R.id.select_privacy_circle_view;
        CheckBox r212 = (CheckBox) ViewBindings.findChildViewById(r210, R.id.select_privacy_circle_view);
        if (r212 == null) goto L55;
        r100 = R.id.select_view;
        LinearLayout r213 = (LinearLayout) ViewBindings.findChildViewById(r210, R.id.select_view);
        if (r213 == null) goto L55;
        r100 = R.id.tourist_tip;
        TouristTipLayout r214 = (TouristTipLayout) ViewBindings.findChildViewById(r210, R.id.tourist_tip);
        if (r214 == null) goto L55;
        r100 = R.id.tv_login_by_lark;
        TextView r215 = (TextView) ViewBindings.findChildViewById(r210, R.id.tv_login_by_lark);
        if (r215 == null) goto L55;
        r100 = R.id.tv_no_login_feedback;
        TextView r216 = (TextView) ViewBindings.findChildViewById(r210, R.id.tv_no_login_feedback);
        if (r216 == null) goto L55;
        r100 = R.id.tv_no_login_use_directly;
        TextView r217 = (TextView) ViewBindings.findChildViewById(r210, R.id.tv_no_login_use_directly);
        if (r217 == null) goto L55;
        return new LarusAccountLoginPageBinding((ConstraintLayout) r210, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r211, r212, r213, r214, r215, r216, r217);
    L55:
        throw new NullPointerException("Missing required view with ID: ".concat(r210.getResources().getResourceName(r100)));
    }

    public LarusAccountLoginPageBinding(ConstraintLayout r100, LinearLayout r101, TextView r102, ImageView r103, SimpleDraweeView r104, ConstraintLayout r105, View r106, ConstraintLayout r110, Space r111, View r112, LinearLayout r113, ImageView r114, LinearLayout r115, ConstraintLayout r116, ViewStub r117, UrlSpanTextView r118, Space r119, CheckBox r210, LinearLayout r211, TouristTipLayout r212, TextView r213, TextView r214, TextView r215) {
        this.f357424a = r100;
        this.f357425b = r101;
        this.f357426c = r102;
        this.f357427d = r103;
        this.f357428e = r104;
        this.f357429f = r105;
        this.f357430g = r106;
        this.f357431h = r110;
        this.f357432i = r111;
        this.f357433j = r112;
        this.f357434k = r113;
        this.f357435l = r114;
        this.f357436m = r115;
        this.f357437n = r116;
        this.f357438o = r117;
        this.f357439p = r118;
        this.f357440q = r119;
        this.f357441r = r210;
        this.f357442s = r211;
        this.f357443t = r212;
        this.f357444u = r213;
        this.f357445v = r214;
        this.f357446w = r215;
    }
}
