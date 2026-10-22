package com.larus.login.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.RoundAvatarImageView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusItemPhoneLoginAccountBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f357575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f357576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RoundAvatarImageView f357577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f357578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f357579e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f357575a;
    }

    public LarusItemPhoneLoginAccountBinding(ConstraintLayout r100, AppCompatImageView r101, RoundAvatarImageView r102, AppCompatTextView r103, AppCompatTextView r104) {
        this.f357575a = r100;
        this.f357576b = r101;
        this.f357577c = r102;
        this.f357578d = r103;
        this.f357579e = r104;
    }
}
