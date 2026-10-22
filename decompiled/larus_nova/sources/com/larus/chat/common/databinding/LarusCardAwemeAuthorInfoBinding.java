package com.larus.chat.common.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusCardAwemeAuthorInfoBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f323904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoundAvatarImageView f323905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f323906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f323907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f323908e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f323904a;
    }

    public static LarusCardAwemeAuthorInfoBinding a(View r100) {
        int r101 = R.id.avatar;
        RoundAvatarImageView r102 = (RoundAvatarImageView) ViewBindings.findChildViewById(r100, R.id.avatar);
        if (r102 == null) goto L13;
        r101 = R.id.like_count;
        AppCompatTextView r103 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.like_count);
        if (r103 == null) goto L13;
        r101 = R.id.like_icon;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.like_icon);
        if (r104 == null) goto L13;
        r101 = R.id.nick_name;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.nick_name);
        if (r105 == null) goto L13;
        return new LarusCardAwemeAuthorInfoBinding((ConstraintLayout) r100, r102, r103, r104, r105);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusCardAwemeAuthorInfoBinding(ConstraintLayout r100, RoundAvatarImageView r101, AppCompatTextView r102, AppCompatImageView r103, AppCompatTextView r104) {
        this.f323904a = r100;
        this.f323905b = r101;
        this.f323906c = r102;
        this.f323907d = r103;
        this.f323908e = r104;
    }
}
