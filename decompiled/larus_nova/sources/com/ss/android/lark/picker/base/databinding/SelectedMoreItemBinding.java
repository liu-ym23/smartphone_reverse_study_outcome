package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.view.AvatarItemViewWithMask;

/* JADX INFO: loaded from: classes37.dex */
public final class SelectedMoreItemBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final AvatarItemViewWithMask selectedItem;
    public final FrameLayout selectedRemove;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SelectedMoreItemBinding bind(View r100) {
        int r101 = R.id.selected_item;
        AvatarItemViewWithMask r102 = (AvatarItemViewWithMask) ViewBindings.findChildViewById(r100, R.id.selected_item);
        if (r102 == null) goto L9;
        r101 = R.id.selected_remove;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.selected_remove);
        if (r103 == null) goto L9;
        return new SelectedMoreItemBinding((ConstraintLayout) r100, r102, r103);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static SelectedMoreItemBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    private SelectedMoreItemBinding(ConstraintLayout r100, AvatarItemViewWithMask r101, FrameLayout r102) {
        this.rootView = r100;
        this.selectedItem = r101;
        this.selectedRemove = r102;
    }

    public static SelectedMoreItemBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.selected_more_item, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }
}
