package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class ViewSearchSkeletonLayoutBinding implements ViewBinding {
    public final View icon;
    private final ConstraintLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewSearchSkeletonLayoutBinding bind(View r100) {
        View r101 = ViewBindings.findChildViewById(r100, R.id.icon);
        if (r101 == null) goto L7;
        return new ViewSearchSkeletonLayoutBinding((ConstraintLayout) r100, r101);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(R.id.icon)));
    }

    public static ViewSearchSkeletonLayoutBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    private ViewSearchSkeletonLayoutBinding(ConstraintLayout r100, View r101) {
        this.rootView = r100;
        this.icon = r101;
    }

    public static ViewSearchSkeletonLayoutBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.view_search_skeleton_layout, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }
}
