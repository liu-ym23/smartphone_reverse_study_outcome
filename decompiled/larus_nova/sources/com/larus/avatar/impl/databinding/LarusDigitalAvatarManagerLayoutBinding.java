package com.larus.avatar.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.common_ui.widget.roundlayout.RoundTextView;

/* JADX INFO: loaded from: classes23.dex */
public final class LarusDigitalAvatarManagerLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundConstraintLayout f290746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f290747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f290748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RoundTextView f290749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f290750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SimpleDraweeView f290751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f290752g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f290746a;
    }

    public LarusDigitalAvatarManagerLayoutBinding(RoundConstraintLayout r100, FrameLayout r101, AppCompatTextView r102, RoundTextView r103, AppCompatTextView r104, SimpleDraweeView r105, AppCompatImageView r106, LarusDigitalAvatarManagerNewEntryLayoutBinding r107) {
        this.f290746a = r100;
        this.f290747b = r101;
        this.f290748c = r102;
        this.f290749d = r103;
        this.f290750e = r104;
        this.f290751f = r105;
        this.f290752g = r106;
    }
}
