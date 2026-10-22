package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusDialogAvatarPromptInputBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f317732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f317733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatEditText f317734c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317732a;
    }

    public LarusDialogAvatarPromptInputBinding(FrameLayout r100, ImageView r101, AppCompatEditText r102) {
        this.f317732a = r100;
        this.f317733b = r101;
        this.f317734c = r102;
    }
}
