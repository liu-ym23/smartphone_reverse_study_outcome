package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDialogPrivacyPolicyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f332496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoundConstraintLayout f332497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f332498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f332499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UrlSpanTextView f332500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f332501f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332496a;
    }

    public LarusDoraDialogPrivacyPolicyBinding(FrameLayout r100, RoundConstraintLayout r101, AppCompatTextView r102, ImageView r103, UrlSpanTextView r104, AppCompatTextView r105) {
        this.f332496a = r100;
        this.f332497b = r101;
        this.f332498c = r102;
        this.f332499d = r103;
        this.f332500e = r104;
        this.f332501f = r105;
    }
}
