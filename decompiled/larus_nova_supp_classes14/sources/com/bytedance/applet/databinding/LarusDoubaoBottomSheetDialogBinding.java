package com.bytedance.applet.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.UrlSpanTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LarusDoubaoBottomSheetDialogBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final SimpleDraweeView b;
    public final TextView c;
    public final LinearLayout d;
    public final UrlSpanTextView e;
    public final View f;
    public final FrameLayout g;
    public final NestedScrollView h;
    public final TextView i;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoubaoBottomSheetDialogBinding(ConstraintLayout r1, SimpleDraweeView r2, TextView r3, LinearLayout r4, UrlSpanTextView r5, View r6, FrameLayout r7, NestedScrollView r8, TextView r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
