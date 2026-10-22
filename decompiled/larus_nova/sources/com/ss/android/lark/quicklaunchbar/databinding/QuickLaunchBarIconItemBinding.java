package com.ss.android.lark.quicklaunchbar.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class QuickLaunchBarIconItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f439129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UDBadgeView f439130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UDBadgeView f439131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f439132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f439133e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f439129a;
    }

    public static QuickLaunchBarIconItemBinding a(View r100) {
        int r101 = R.id.badgeDotView;
        UDBadgeView r102 = (UDBadgeView) ViewBindings.findChildViewById(r100, R.id.badgeDotView);
        if (r102 == null) goto L13;
        r101 = R.id.badgeTextView;
        UDBadgeView r103 = (UDBadgeView) ViewBindings.findChildViewById(r100, R.id.badgeTextView);
        if (r103 == null) goto L13;
        r101 = R.id.ivIcon;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r100, R.id.ivIcon);
        if (r104 == null) goto L13;
        r101 = R.id.tvName;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r100, R.id.tvName);
        if (r105 == null) goto L13;
        return new QuickLaunchBarIconItemBinding((RelativeLayout) r100, r102, r103, r104, r105);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public QuickLaunchBarIconItemBinding(RelativeLayout r100, UDBadgeView r101, UDBadgeView r102, ImageView r103, TextView r104) {
        this.f439129a = r100;
        this.f439130b = r101;
        this.f439131c = r102;
        this.f439132d = r103;
        this.f439133e = r104;
    }
}
