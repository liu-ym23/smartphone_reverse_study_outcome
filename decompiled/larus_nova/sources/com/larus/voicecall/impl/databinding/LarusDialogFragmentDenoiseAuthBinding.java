package com.larus.voicecall.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.UrlSpanTextView;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusDialogFragmentDenoiseAuthBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f378212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatButton f378213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f378214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f378215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UrlSpanTextView f378216e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f378212a;
    }

    public LarusDialogFragmentDenoiseAuthBinding(ConstraintLayout r100, AppCompatButton r101, AppCompatTextView r102, AppCompatImageView r103, UrlSpanTextView r104) {
        this.f378212a = r100;
        this.f378213b = r101;
        this.f378214c = r102;
        this.f378215d = r103;
        this.f378216e = r104;
    }
}
