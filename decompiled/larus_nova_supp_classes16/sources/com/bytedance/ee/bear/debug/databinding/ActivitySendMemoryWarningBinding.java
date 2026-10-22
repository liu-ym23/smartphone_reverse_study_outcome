package com.bytedance.ee.bear.debug.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ActivitySendMemoryWarningBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final TextView c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public ActivitySendMemoryWarningBinding(ConstraintLayout r1, TextView r2, TextView r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
