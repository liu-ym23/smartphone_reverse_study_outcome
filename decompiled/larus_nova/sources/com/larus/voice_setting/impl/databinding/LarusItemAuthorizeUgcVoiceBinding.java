package com.larus.voice_setting.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusItemAuthorizeUgcVoiceBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f376106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f376107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f376108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f376109d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f376106a;
    }

    public static LarusItemAuthorizeUgcVoiceBinding a(View r100) {
        int r101 = R.id.icon;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.icon);
        if (r102 == null) goto L11;
        r101 = R.id.text_content;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r100, R.id.text_content);
        if (r103 == null) goto L11;
        r101 = R.id.text_title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r100, R.id.text_title);
        if (r104 == null) goto L11;
        return new LarusItemAuthorizeUgcVoiceBinding((ConstraintLayout) r100, r102, r103, r104);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusItemAuthorizeUgcVoiceBinding(ConstraintLayout r100, AppCompatImageView r101, TextView r102, TextView r103) {
        this.f376106a = r100;
        this.f376107b = r101;
        this.f376108c = r102;
        this.f376109d = r103;
    }
}
