package com.larus.bot.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutBotBioEditBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f317830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatEditText f317831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarusBotCreateDescSkeletonBinding f317832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f317833d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317830a;
    }

    public LarusLayoutBotBioEditBinding(ConstraintLayout r100, AppCompatEditText r101, LarusBotCreateDescSkeletonBinding r102, AppCompatTextView r103) {
        this.f317830a = r100;
        this.f317831b = r101;
        this.f317832c = r102;
        this.f317833d = r103;
    }
}
