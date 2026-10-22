package com.bytedance.awemeopen.apps.framework.feed.pinch.utils;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r3) {
        b r0 = this.a;
        r0.l = r3.getX();
        b r1 = this.a;
        r1.m = r3.getY();
        this.a.n = 1;
        return true;
    }
}
