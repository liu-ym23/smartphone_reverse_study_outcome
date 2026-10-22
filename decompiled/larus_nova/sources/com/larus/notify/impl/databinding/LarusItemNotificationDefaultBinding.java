package com.larus.notify.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.CircleFrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusItemNotificationDefaultBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f360259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f360260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f360261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f360262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CircleFrameLayout f360263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f360264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f360265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f360266h;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f360259a;
    }

    public static LarusItemNotificationDefaultBinding a(LayoutInflater r110, ViewGroup r111) {
        View r112 = r110.inflate(R.layout.larus_item_notification_default, r111, false);
        int r113 = R.id.avatar;
        SimpleDraweeView r100 = (SimpleDraweeView) ViewBindings.findChildViewById(r112, R.id.avatar);
        if (r100 == null) goto L21;
        r113 = R.id.body;
        TextView r101 = (TextView) ViewBindings.findChildViewById(r112, R.id.body);
        if (r101 == null) goto L21;
        r113 = R.id.create_time;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r112, R.id.create_time);
        if (r102 == null) goto L21;
        r113 = R.id.left_container;
        CircleFrameLayout r103 = (CircleFrameLayout) ViewBindings.findChildViewById(r112, R.id.left_container);
        if (r103 == null) goto L21;
        r113 = R.id.right_container;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r112, R.id.right_container);
        if (r104 == null) goto L21;
        r113 = R.id.text_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r112, R.id.text_container)) == null) goto L21;
        r113 = R.id.title;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r112, R.id.title);
        if (r105 == null) goto L21;
        r113 = R.id.unread_dot;
        View r106 = ViewBindings.findChildViewById(r112, R.id.unread_dot);
        if (r106 == null) goto L21;
        return new LarusItemNotificationDefaultBinding((ConstraintLayout) r112, r100, r101, r102, r103, r104, r105, r106);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
    }

    public LarusItemNotificationDefaultBinding(ConstraintLayout r100, SimpleDraweeView r101, TextView r102, TextView r103, CircleFrameLayout r104, FrameLayout r105, TextView r106, View r107) {
        this.f360259a = r100;
        this.f360260b = r101;
        this.f360261c = r102;
        this.f360262d = r103;
        this.f360263e = r104;
        this.f360264f = r105;
        this.f360265g = r106;
        this.f360266h = r107;
    }
}
