package com.larus.profile.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusItemProfileBotListEmptyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f366471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f366472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f366473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f366474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f366475e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f366471a;
    }

    public static LarusItemProfileBotListEmptyBinding a(View r100) {
        ConstraintLayout r101 = (ConstraintLayout) r100;
        int r102 = R.id.creation_empty_action_button;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r100, R.id.creation_empty_action_button);
        if (r103 == null) goto L11;
        r102 = R.id.profile_info_avatar;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.profile_info_avatar);
        if (r104 == null) goto L11;
        r102 = R.id.profile_info_nickname;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.profile_info_nickname);
        if (r105 == null) goto L11;
        return new LarusItemProfileBotListEmptyBinding(r101, r101, r103, r104, r105);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r102)));
    }

    public LarusItemProfileBotListEmptyBinding(ConstraintLayout r100, ConstraintLayout r101, TextView r102, AppCompatImageView r103, AppCompatTextView r104) {
        this.f366471a = r100;
        this.f366472b = r101;
        this.f366473c = r102;
        this.f366474d = r103;
        this.f366475e = r104;
    }
}
