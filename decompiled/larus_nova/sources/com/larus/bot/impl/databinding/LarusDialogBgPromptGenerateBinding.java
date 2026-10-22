package com.larus.bot.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget.PromptInputButtonView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusDialogBgPromptGenerateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f317735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatEditText f317736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PromptInputButtonView f317737c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317735a;
    }

    public LarusDialogBgPromptGenerateBinding(ConstraintLayout r100, AppCompatEditText r101, PromptInputButtonView r102) {
        this.f317735a = r100;
        this.f317736b = r101;
        this.f317737c = r102;
    }
}
