package com.bytedance.applet.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ai.view.input.FloatingSpeakerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LarusAppletWebBrowserBinding implements ViewBinding {
    public final LinearLayout a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final View e;
    public final FloatingSpeakerView f;
    public final ProgressBar g;
    public final ConstraintLayout h;
    public final TextView i;
    public final FrameLayout j;
    public final LinearLayout k;

    public final View getRoot() {
        return this.a;
    }

    public LarusAppletWebBrowserBinding(LinearLayout r1, ImageView r2, ImageView r3, ImageView r4, View r5, FloatingSpeakerView r6, ProgressBar r7, ConstraintLayout r8, TextView r9, FrameLayout r10, LinearLayout r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }
}
