package com.bytedance.ee.bear.bitable.toolbox.view;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class e extends GestureDetector.SimpleOnGestureListener {
    public e() {
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        d r5 = (d) this;
        if (Math.abs(r4) > Math.abs(r3)) goto L5;
        return false;
    L5:
        if (r4 <= 0.0f) goto L8;
        BitableToolboxFragment r6 = r5.a;
        BitableToolboxFragment.ScrollDirection r7 = BitableToolboxFragment.ScrollDirection.DOWN;
        int r8 = BitableToolboxFragment.n;
        r6.Y90(r7);
        BitableToolboxFragment.U90(r5.a, r7);
        return false;
    L8:
        if (r4 >= 0.0f) goto L14;
        BitableToolboxFragment r9 = r5.a;
        BitableToolboxFragment.ScrollDirection r10 = BitableToolboxFragment.ScrollDirection.UP;
        int r11 = BitableToolboxFragment.n;
        r9.Y90(r10);
        BitableToolboxFragment.U90(r5.a, r10);
        return false;
    L14:
        return false;
    }
}
