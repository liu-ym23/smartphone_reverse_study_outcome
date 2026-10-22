package com.larus.bmhome.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.bot.share.ImmerseBgBitmapImageView;
import com.larus.bmhome.chat.view.share.MessageListMaskView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutSelectedMessageShareImmersiveBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f311070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f311071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f311072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImmerseBgBitmapImageView f311073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MessageListMaskView f311074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f311075f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311070a;
    }

    public LarusLayoutSelectedMessageShareImmersiveBinding(ConstraintLayout r100, ConstraintLayout r101, View r102, ImmerseBgBitmapImageView r103, MessageListMaskView r104, View r105) {
        this.f311070a = r100;
        this.f311071b = r101;
        this.f311072c = r102;
        this.f311073d = r103;
        this.f311074e = r104;
        this.f311075f = r105;
    }
}
