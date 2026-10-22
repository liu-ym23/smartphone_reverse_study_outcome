package com.larus.home.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.CircleProgressBar;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.common_ui.widget.roundlayout.CircleFrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusItemSideBarConversationBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f344291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f344292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f344293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f344294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f344295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f344296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f344297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f344298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CircleFrameLayout f344299i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f344300j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinearLayout f344301k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CircleProgressBar f344302l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinearLayout f344303m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f344304n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f344305o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RedDotTextView f344306p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final TextView f344307q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final TextView f344308r;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f344291a;
    }

    public static LarusItemSideBarConversationBinding a(LayoutInflater r210, ViewGroup r211) {
        View r100 = r210.inflate(R.layout.larus_item_side_bar_conversation, r211, false);
        ConstraintLayout r101 = (ConstraintLayout) r100;
        int r102 = R.id.iv_avatar;
        SimpleDraweeView r103 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.iv_avatar);
        if (r103 == null) goto L39;
        r102 = R.id.iv_close_item;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r100, R.id.iv_close_item);
        if (r104 == null) goto L39;
        r102 = R.id.iv_conversation_with_job;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r100, R.id.iv_conversation_with_job);
        if (r105 == null) goto L39;
        r102 = R.id.iv_pin;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r100, R.id.iv_pin);
        if (r106 == null) goto L39;
        r102 = R.id.iv_realtime_call;
        ImageView r107 = (ImageView) ViewBindings.findChildViewById(r100, R.id.iv_realtime_call);
        if (r107 == null) goto L39;
        r102 = R.id.iv_receive_failed;
        ImageView r108 = (ImageView) ViewBindings.findChildViewById(r100, R.id.iv_receive_failed);
        if (r108 == null) goto L39;
        r102 = R.id.layout_avatar;
        CircleFrameLayout r110 = (CircleFrameLayout) ViewBindings.findChildViewById(r100, R.id.layout_avatar);
        if (r110 == null) goto L39;
        r102 = R.id.layout_end_action;
        FrameLayout r111 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.layout_end_action);
        if (r111 == null) goto L39;
        r102 = R.id.layout_pending_confirmation;
        LinearLayout r112 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.layout_pending_confirmation);
        if (r112 == null) goto L39;
        r102 = R.id.message_progress;
        CircleProgressBar r113 = (CircleProgressBar) ViewBindings.findChildViewById(r100, R.id.message_progress);
        if (r113 == null) goto L39;
        r102 = R.id.right_action_area;
        LinearLayout r114 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.right_action_area);
        if (r114 == null) goto L39;
        r102 = R.id.title_affix_area;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.title_affix_area)) == null) goto L39;
        r102 = R.id.title_end_gradient;
        View r115 = ViewBindings.findChildViewById(r100, R.id.title_end_gradient);
        if (r115 == null) goto L39;
        r102 = R.id.tv_enterprise_tag;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_enterprise_tag);
        if (r116 == null) goto L39;
        r102 = R.id.tv_red_dot;
        RedDotTextView r117 = (RedDotTextView) ViewBindings.findChildViewById(r100, R.id.tv_red_dot);
        if (r117 == null) goto L39;
        r102 = R.id.tv_review_tag;
        TextView r118 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_review_tag);
        if (r118 == null) goto L39;
        r102 = R.id.tv_title;
        TextView r119 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_title);
        if (r119 == null) goto L39;
        return new LarusItemSideBarConversationBinding(r101, r101, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119);
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r102)));
    }

    public LarusItemSideBarConversationBinding(ConstraintLayout r100, ConstraintLayout r101, SimpleDraweeView r102, ImageView r103, ImageView r104, ImageView r105, ImageView r106, ImageView r110, CircleFrameLayout r111, FrameLayout r112, LinearLayout r113, CircleProgressBar r114, LinearLayout r115, View r116, TextView r117, RedDotTextView r118, TextView r119, TextView r210) {
        this.f344291a = r100;
        this.f344292b = r101;
        this.f344293c = r102;
        this.f344294d = r103;
        this.f344295e = r104;
        this.f344296f = r105;
        this.f344297g = r106;
        this.f344298h = r110;
        this.f344299i = r111;
        this.f344300j = r112;
        this.f344301k = r113;
        this.f344302l = r114;
        this.f344303m = r115;
        this.f344304n = r116;
        this.f344305o = r117;
        this.f344306p = r118;
        this.f344307q = r119;
        this.f344308r = r210;
    }
}
