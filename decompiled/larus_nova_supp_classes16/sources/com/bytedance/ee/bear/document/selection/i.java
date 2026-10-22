package com.bytedance.ee.bear.document.selection;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ k a;

    public i(k r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r2) {
        tt5.a.b("SelectionHackHelper", "onLongPress");
        this.a.c();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r3) {
        tt5.a.b("SelectionHackHelper", "onSingleTapUp");
        k r4 = this.a;
        com.bytedance.ee.util.ui.j.e(r4.k);
        com.bytedance.ee.util.ui.j.d(r4.k, 100);
        return false;
    }
}
