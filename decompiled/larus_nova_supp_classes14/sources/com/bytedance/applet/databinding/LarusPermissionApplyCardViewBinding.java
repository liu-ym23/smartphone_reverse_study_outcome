package com.bytedance.applet.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.applet.block.permissionapplycard.view.PermissionApplyCardView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LarusPermissionApplyCardViewBinding implements ViewBinding {
    public final View a;
    public final RoundTextView b;
    public final RoundTextView c;
    public final View d;
    public final SimpleDraweeView e;
    public final ProgressBar f;
    public final ProgressBar g;
    public final TextView h;
    public final TextView i;
    public final TextView j;

    public final View getRoot() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LarusPermissionApplyCardViewBinding(PermissionApplyCardView r1, RoundTextView r2, RoundTextView r3, View r4, SimpleDraweeView r5, ProgressBar r6, ProgressBar r7, TextView r8, TextView r9, TextView r10) {
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
    }
}
