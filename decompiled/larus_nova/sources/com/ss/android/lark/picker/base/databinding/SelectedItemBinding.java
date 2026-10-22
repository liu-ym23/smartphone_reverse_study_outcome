package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class SelectedItemBinding implements ViewBinding {
    public final LarkAvatarView miniAvatar;
    private final RelativeLayout rootView;
    public final LarkAvatarView selectedAvatar;
    public final AppCompatImageView selectedTeamBadge;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SelectedItemBinding bind(View r100) {
        int r101 = R.id.mini_avatar;
        LarkAvatarView r102 = (LarkAvatarView) ViewBindings.findChildViewById(r100, R.id.mini_avatar);
        if (r102 == null) goto L11;
        r101 = R.id.selected_avatar;
        LarkAvatarView r103 = (LarkAvatarView) ViewBindings.findChildViewById(r100, R.id.selected_avatar);
        if (r103 == null) goto L11;
        r101 = R.id.selected_team_badge;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.selected_team_badge);
        if (r104 == null) goto L11;
        return new SelectedItemBinding((RelativeLayout) r100, r102, r103, r104);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static SelectedItemBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    public static SelectedItemBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.selected_item, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }

    private SelectedItemBinding(RelativeLayout r100, LarkAvatarView r101, LarkAvatarView r102, AppCompatImageView r103) {
        this.rootView = r100;
        this.miniAvatar = r101;
        this.selectedAvatar = r102;
        this.selectedTeamBadge = r103;
    }
}
