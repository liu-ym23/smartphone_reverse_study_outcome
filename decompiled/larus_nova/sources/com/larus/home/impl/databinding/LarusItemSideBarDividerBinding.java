package com.larus.home.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusItemSideBarDividerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f344309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f344310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f344311c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f344309a;
    }

    public static LarusItemSideBarDividerBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_item_side_bar_divider, r101, false);
        int r103 = R.id.blank_space;
        View r104 = ViewBindings.findChildViewById(r102, R.id.blank_space);
        if (r104 == null) goto L9;
        r103 = R.id.line;
        View r105 = ViewBindings.findChildViewById(r102, R.id.line);
        if (r105 == null) goto L9;
        return new LarusItemSideBarDividerBinding((ConstraintLayout) r102, r104, r105);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusItemSideBarDividerBinding(ConstraintLayout r100, View r101, View r102) {
        this.f344309a = r100;
        this.f344310b = r101;
        this.f344311c = r102;
    }
}
