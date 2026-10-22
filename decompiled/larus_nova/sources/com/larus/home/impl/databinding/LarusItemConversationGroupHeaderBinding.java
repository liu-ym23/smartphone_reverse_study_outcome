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
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusItemConversationGroupHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f344274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f344275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f344276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f344277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f344278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f344279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RedDotTextView f344280g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f344281h;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f344274a;
    }

    public static LarusItemConversationGroupHeaderBinding a(LayoutInflater r110, ViewGroup r111) {
        View r112 = r110.inflate(R.layout.larus_item_conversation_group_header, r111, false);
        int r113 = R.id.group_action;
        FrameLayout r100 = (FrameLayout) ViewBindings.findChildViewById(r112, R.id.group_action);
        if (r100 == null) goto L21;
        r113 = R.id.group_expand_arrow;
        ImageView r101 = (ImageView) ViewBindings.findChildViewById(r112, R.id.group_expand_arrow);
        if (r101 == null) goto L21;
        r113 = R.id.group_inline_action;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r112, R.id.group_inline_action);
        if (r102 == null) goto L21;
        r113 = R.id.group_inline_action_container;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r112, R.id.group_inline_action_container);
        if (r103 == null) goto L21;
        r113 = R.id.group_more;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r112, R.id.group_more);
        if (r104 == null) goto L21;
        r113 = R.id.group_red_badge;
        RedDotTextView r105 = (RedDotTextView) ViewBindings.findChildViewById(r112, R.id.group_red_badge);
        if (r105 == null) goto L21;
        r113 = R.id.group_title;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r112, R.id.group_title);
        if (r106 == null) goto L21;
        r113 = R.id.group_title_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r112, R.id.group_title_container)) == null) goto L21;
        return new LarusItemConversationGroupHeaderBinding((ConstraintLayout) r112, r100, r101, r102, r103, r104, r105, r106);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
    }

    public LarusItemConversationGroupHeaderBinding(ConstraintLayout r100, FrameLayout r101, ImageView r102, ImageView r103, LinearLayout r104, ImageView r105, RedDotTextView r106, TextView r107) {
        this.f344274a = r100;
        this.f344275b = r101;
        this.f344276c = r102;
        this.f344277d = r103;
        this.f344278e = r104;
        this.f344279f = r105;
        this.f344280g = r106;
        this.f344281h = r107;
    }
}
