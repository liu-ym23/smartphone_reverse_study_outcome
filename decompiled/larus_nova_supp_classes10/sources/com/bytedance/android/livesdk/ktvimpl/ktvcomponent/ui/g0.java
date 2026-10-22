package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import android.view.ViewTreeObserver;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ i0 b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        i0 r0 = this.b;
        TextView r1 = this.a;
        i0.a(r0, r1, r1.getWidth(), this.a.getHeight());
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public g0(TextView r1, i0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
