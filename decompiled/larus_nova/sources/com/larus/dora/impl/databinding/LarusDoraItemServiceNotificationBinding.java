package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraItemServiceNotificationBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f332766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f332767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f332768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraTextView f332769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DoraTextView f332770f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332765a;
    }

    public LarusDoraItemServiceNotificationBinding(ConstraintLayout r100, View r101, SimpleDraweeView r102, AppCompatImageView r103, DoraTextView r104, DoraTextView r105) {
        this.f332765a = r100;
        this.f332766b = r101;
        this.f332767c = r102;
        this.f332768d = r103;
        this.f332769e = r104;
        this.f332770f = r105;
    }
}
