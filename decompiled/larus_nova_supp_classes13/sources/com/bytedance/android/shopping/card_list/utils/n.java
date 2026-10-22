package com.bytedance.android.shopping.card_list.utils;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements View.OnTouchListener {
    public final /* synthetic */ HalfPanelHelper a;

    public n(HalfPanelHelper r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r3, MotionEvent r4) {
        if (r3.getVisibility() == 0) goto L7;
        return false;
    L7:
        if (this.a.p.onTouchEvent(r4) == true) goto L19;
        HalfPanelHelper r5 = this.a;
        r5.getClass();
        int r1 = r4.getAction();
        if (r1 == 0) goto L18;
        if (r1 != 1) goto L19;
        int r6 = ((int) r4.getRawY()) - r5.a;
        if (r6 <= (r5.r.g.x20() / 2)) goto L16;
        r5.r.a();
        goto L19
    L16:
        if (r6 <= r5.l) goto L19;
        r5.e();
        goto L19
    L18:
        r5.a = (int) r4.getRawY();
    L19:
        return true;
    }
}
