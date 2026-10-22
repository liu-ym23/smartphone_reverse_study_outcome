package com.bytedance.android.shopping.mall.homepage.card;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements View.OnTouchListener {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r6) {
        int r7 = r6.getAction();
        boolean r0 = false;
        if (r7 != 0) goto L5;
        c r8 = this.a;
        r8.a.removeCallbacks(r8.b);
        r8.c = false;
        Handler r1 = r8.a;
        c.b r2 = r8.b;
        Object r9 = r8.i.get("long_click_effect_time");
        if ((r9 instanceof Integer) == true) goto L18;
        r9 = null;
    L18:
        Integer r10 = (Integer) r9;
        if (r10 == null) goto L21;
        int r11 = r10.intValue();
    L22:
        r1.postDelayed(r2, r11);
        this.a.e = r6.getRawX();
        this.a.f = r6.getRawY();
    L24:
        return this.a.c;
    L21:
        r11 = ViewConfiguration.getLongPressTimeout();
        goto L22
    L5:
        if (r7 != 1) goto L7;
        c r12 = this.a;
        r12.a.removeCallbacks(r12.b);
        goto L24
    L7:
        if (r7 == 2) goto L9;
        c r13 = this.a;
        r13.a.removeCallbacks(r13.b);
        goto L24
    L9:
        c r14 = this.a;
        float r3 = r6.getRawX();
        float r15 = r6.getRawY();
        float r4 = Math.abs(r3 - r14.e);
        float r16 = Math.abs(r15 - r14.f);
        if (((r4 * r4) + (r16 * r16)) <= (r14.d.getScaledTouchSlop() * r14.d.getScaledTouchSlop())) goto L12;
        r0 = true;
    L12:
        if (r0 == false) goto L24;
        c r17 = this.a;
        r17.a.removeCallbacks(r17.b);
        goto L24
    }
}
