package com.bytedance.ee.bear.document.plugin.selection;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes16.dex */
public final class o extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f220944a;

    public o(q r100) {
        this.f220944a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        tt5.a.b("SelectionHackHelper", "onLongPress");
        this.f220944a.c();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        tt5.a.b("SelectionHackHelper", "onSingleTapUp");
        q r101 = this.f220944a;
        com.bytedance.ee.util.ui.j.e(r101.f220957k);
        com.bytedance.ee.util.ui.j.d(r101.f220957k, 100);
        return false;
    }
}
