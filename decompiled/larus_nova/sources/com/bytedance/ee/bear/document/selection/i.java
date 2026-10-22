package com.bytedance.ee.bear.document.selection;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes16.dex */
public final class i extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f221651a;

    public i(k r100) {
        this.f221651a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        tt5.a.b("SelectionHackHelper", "onLongPress");
        this.f221651a.c();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        tt5.a.b("SelectionHackHelper", "onSingleTapUp");
        k r101 = this.f221651a;
        com.bytedance.ee.util.ui.j.e(r101.f221666k);
        com.bytedance.ee.util.ui.j.d(r101.f221666k, 100);
        return false;
    }
}
