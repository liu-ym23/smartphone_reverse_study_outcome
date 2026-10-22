package com.bytedance.awemeopen.apps.framework.feed.pinch.utils;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f195816a;

    public a(b r100) {
        this.f195816a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r100) {
        b r101 = this.f195816a;
        r101.f195828l = r100.getX();
        b r102 = this.f195816a;
        r102.f195829m = r100.getY();
        this.f195816a.f195830n = 1;
        return true;
    }
}
