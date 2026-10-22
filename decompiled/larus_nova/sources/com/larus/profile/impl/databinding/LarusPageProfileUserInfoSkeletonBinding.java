package com.larus.profile.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusPageProfileUserInfoSkeletonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f366517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f366518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f366519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f366520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f366521e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f366517a;
    }

    public static LarusPageProfileUserInfoSkeletonBinding a(View r100) {
        int r101 = R.id.profile_info_skeleton_avatar;
        View r102 = ViewBindings.findChildViewById(r100, R.id.profile_info_skeleton_avatar);
        if (r102 == null) goto L13;
        r101 = R.id.profile_info_skeleton_bots_info;
        View r103 = ViewBindings.findChildViewById(r100, R.id.profile_info_skeleton_bots_info);
        if (r103 == null) goto L13;
        r101 = R.id.profile_info_skeleton_nickname;
        View r104 = ViewBindings.findChildViewById(r100, R.id.profile_info_skeleton_nickname);
        if (r104 == null) goto L13;
        r101 = R.id.profile_info_skeleton_username;
        View r105 = ViewBindings.findChildViewById(r100, R.id.profile_info_skeleton_username);
        if (r105 == null) goto L13;
        return new LarusPageProfileUserInfoSkeletonBinding((ConstraintLayout) r100, r102, r103, r104, r105);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusPageProfileUserInfoSkeletonBinding(ConstraintLayout r100, View r101, View r102, View r103, View r104) {
        this.f366517a = r100;
        this.f366518b = r101;
        this.f366519c = r102;
        this.f366520d = r103;
        this.f366521e = r104;
    }
}
