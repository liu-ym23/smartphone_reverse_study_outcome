package com.larus.voice_setting.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusDialogAuthorizeUgcVoiceBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f376054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatButton f376055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f376056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LarusItemAuthorizeUgcVoiceBinding f376057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LarusItemAuthorizeUgcVoiceBinding f376058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LarusItemAuthorizeUgcVoiceBinding f376059f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f376054a;
    }

    public static LarusDialogAuthorizeUgcVoiceBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_dialog_authorize_ugc_voice, r101, false);
        int r103 = R.id.button_agree;
        AppCompatButton r104 = (AppCompatButton) ViewBindings.findChildViewById(r102, R.id.button_agree);
        if (r104 == null) goto L17;
        r103 = R.id.cancel;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.cancel);
        if (r105 == null) goto L17;
        r103 = R.id.layout_item_home;
        View r106 = ViewBindings.findChildViewById(r102, R.id.layout_item_home);
        if (r106 == null) goto L17;
        LarusItemAuthorizeUgcVoiceBinding r107 = LarusItemAuthorizeUgcVoiceBinding.a(r106);
        r103 = R.id.layout_item_limit;
        View r108 = ViewBindings.findChildViewById(r102, R.id.layout_item_limit);
        if (r108 == null) goto L17;
        LarusItemAuthorizeUgcVoiceBinding r109 = LarusItemAuthorizeUgcVoiceBinding.a(r108);
        r103 = R.id.layout_item_sound;
        View r110 = ViewBindings.findChildViewById(r102, R.id.layout_item_sound);
        if (r110 == null) goto L17;
        LarusItemAuthorizeUgcVoiceBinding r111 = LarusItemAuthorizeUgcVoiceBinding.a(r110);
        r103 = R.id.text_title;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.text_title)) == null) goto L17;
        return new LarusDialogAuthorizeUgcVoiceBinding((ConstraintLayout) r102, r104, r105, r107, r109, r111);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusDialogAuthorizeUgcVoiceBinding(ConstraintLayout r100, AppCompatButton r101, AppCompatImageView r102, LarusItemAuthorizeUgcVoiceBinding r103, LarusItemAuthorizeUgcVoiceBinding r104, LarusItemAuthorizeUgcVoiceBinding r105) {
        this.f376054a = r100;
        this.f376055b = r101;
        this.f376056c = r102;
        this.f376057d = r103;
        this.f376058e = r104;
        this.f376059f = r105;
    }
}
