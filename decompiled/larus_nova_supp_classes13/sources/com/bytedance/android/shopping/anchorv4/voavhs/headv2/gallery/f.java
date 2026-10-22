package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements PopupWindow.OnDismissListener {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        e r0 = this.a;
        View r1 = r0.b;
        if (r1 == null) goto L6;
        r1.removeCallbacks(r0.c);
        return;
    }
}
