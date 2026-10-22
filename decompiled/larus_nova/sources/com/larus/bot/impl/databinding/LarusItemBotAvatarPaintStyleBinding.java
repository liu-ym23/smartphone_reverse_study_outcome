package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusItemBotAvatarPaintStyleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f317775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f317776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f317777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f317778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f317779e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317775a;
    }

    public LarusItemBotAvatarPaintStyleBinding(ConstraintLayout r100, SimpleDraweeView r101, View r102, FrameLayout r103, TextView r104) {
        this.f317775a = r100;
        this.f317776b = r101;
        this.f317777c = r102;
        this.f317778d = r103;
        this.f317779e = r104;
    }
}
