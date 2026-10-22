package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraTextBtnBalloonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f333299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f333300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f333301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f333302d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f333299a;
    }

    public static LarusDoraTextBtnBalloonBinding a(LayoutInflater r100) {
        View r101 = r100.inflate(R.layout.larus_dora_text_btn_balloon, null, false);
        int r102 = R.id.dora_keep_alive_root;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.dora_keep_alive_root)) == null) goto L13;
        r102 = R.id.dora_text_btn_balloon_btn;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r101, R.id.dora_text_btn_balloon_btn);
        if (r103 == null) goto L13;
        r102 = R.id.dora_text_btn_balloon_close_btn;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r101, R.id.dora_text_btn_balloon_close_btn);
        if (r104 == null) goto L13;
        r102 = R.id.dora_text_btn_balloon_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r101, R.id.dora_text_btn_balloon_text);
        if (r105 == null) goto L13;
        return new LarusDoraTextBtnBalloonBinding((ConstraintLayout) r101, r103, r104, r105);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    public LarusDoraTextBtnBalloonBinding(ConstraintLayout r100, TextView r101, ImageView r102, TextView r103) {
        this.f333299a = r100;
        this.f333300b = r101;
        this.f333301c = r102;
        this.f333302d = r103;
    }
}
