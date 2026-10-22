package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraAilabKeywordListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoundAvatarImageView f332355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoraTextView f332356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f332357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraTextView f332358e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332354a;
    }

    public LarusDoraAilabKeywordListItemBinding(ConstraintLayout r100, RoundAvatarImageView r101, DoraTextView r102, ImageView r103, DoraTextView r104) {
        this.f332354a = r100;
        this.f332355b = r101;
        this.f332356c = r102;
        this.f332357d = r103;
        this.f332358e = r104;
    }
}
