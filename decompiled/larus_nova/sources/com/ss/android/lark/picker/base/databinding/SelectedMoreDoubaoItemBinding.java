package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class SelectedMoreDoubaoItemBinding implements ViewBinding {
    public final View divider;
    public final LarkAvatarView ivAvatar;
    private final ConstraintLayout rootView;
    public final FrameLayout selectedRemove;
    public final TextView tvTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SelectedMoreDoubaoItemBinding bind(View r100) {
        int r101 = R.id.divider;
        View r102 = ViewBindings.findChildViewById(r100, R.id.divider);
        if (r102 == null) goto L13;
        r101 = R.id.iv_avatar;
        LarkAvatarView r103 = (LarkAvatarView) ViewBindings.findChildViewById(r100, R.id.iv_avatar);
        if (r103 == null) goto L13;
        r101 = R.id.selected_remove;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.selected_remove);
        if (r104 == null) goto L13;
        r101 = R.id.tv_title;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_title);
        if (r105 == null) goto L13;
        return new SelectedMoreDoubaoItemBinding((ConstraintLayout) r100, r102, r103, r104, r105);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static SelectedMoreDoubaoItemBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    public static SelectedMoreDoubaoItemBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.selected_more_doubao_item, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }

    private SelectedMoreDoubaoItemBinding(ConstraintLayout r100, View r101, LarkAvatarView r102, FrameLayout r103, TextView r104) {
        this.rootView = r100;
        this.divider = r101;
        this.ivAvatar = r102;
        this.selectedRemove = r103;
        this.tvTitle = r104;
    }
}
