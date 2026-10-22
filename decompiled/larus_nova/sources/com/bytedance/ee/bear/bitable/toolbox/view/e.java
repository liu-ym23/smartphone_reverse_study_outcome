package com.bytedance.ee.bear.bitable.toolbox.view;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes16.dex */
public abstract class e extends GestureDetector.SimpleOnGestureListener {
    public e() {
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        d r104 = (d) this;
        if (Math.abs(r103) > Math.abs(r102)) goto L5;
        return false;
    L5:
        if (r103 <= 0.0f) goto L8;
        BitableToolboxFragment r105 = r104.f216038a;
        BitableToolboxFragment.ScrollDirection r106 = BitableToolboxFragment.ScrollDirection.DOWN;
        int r107 = BitableToolboxFragment.f216007n;
        r105.Y90(r106);
        BitableToolboxFragment.U90(r104.f216038a, r106);
        return false;
    L8:
        if (r103 >= 0.0f) goto L14;
        BitableToolboxFragment r108 = r104.f216038a;
        BitableToolboxFragment.ScrollDirection r109 = BitableToolboxFragment.ScrollDirection.UP;
        int r110 = BitableToolboxFragment.f216007n;
        r108.Y90(r109);
        BitableToolboxFragment.U90(r104.f216038a, r109);
        return false;
    L14:
        return false;
    }
}
