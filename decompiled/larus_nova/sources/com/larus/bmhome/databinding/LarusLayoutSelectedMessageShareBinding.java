package com.larus.bmhome.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.view.share.MessageListMaskView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutSelectedMessageShareBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f311067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MessageListMaskView f311068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f311069c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f311067a;
    }

    public LarusLayoutSelectedMessageShareBinding(ConstraintLayout r100, MessageListMaskView r101, View r102) {
        this.f311067a = r100;
        this.f311068b = r101;
        this.f311069c = r102;
    }
}
