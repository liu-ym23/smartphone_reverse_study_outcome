package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;

/* JADX INFO: loaded from: classes37.dex */
public final class AvatarItemViewWithMaskBinding implements ViewBinding {
    public final AvatarItemView avatarItem;
    public final View avatarItemMask;
    public final AppCompatImageView chatPreviewIcon;
    private final View rootView;

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static AvatarItemViewWithMaskBinding bind(View r100) {
        int r101 = R.id.avatar_item;
        AvatarItemView r102 = (AvatarItemView) ViewBindings.findChildViewById(r100, R.id.avatar_item);
        if (r102 == null) goto L11;
        r101 = R.id.avatar_item_mask;
        View r103 = ViewBindings.findChildViewById(r100, R.id.avatar_item_mask);
        if (r103 == null) goto L11;
        r101 = R.id.chat_preview_icon;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.chat_preview_icon);
        if (r104 == null) goto L11;
        return new AvatarItemViewWithMaskBinding(r100, r102, r103, r104);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static AvatarItemViewWithMaskBinding inflate(LayoutInflater r100, ViewGroup r101) {
        if (r101 == null) goto L6;
        r100.inflate(R.layout.avatar_item_view_with_mask, r101);
        return bind(r101);
    L6:
        throw new NullPointerException("parent");
    }

    private AvatarItemViewWithMaskBinding(View r100, AvatarItemView r101, View r102, AppCompatImageView r103) {
        this.rootView = r100;
        this.avatarItem = r101;
        this.avatarItemMask = r102;
        this.chatPreviewIcon = r103;
    }
}
