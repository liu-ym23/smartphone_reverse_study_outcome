package com.ss.texturerender.touch;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public class TouchHelper extends GestureDetector.SimpleOnGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
    private GestureDetector mGestureDetector;
    private ArrayList<GestureDetector.SimpleOnGestureListener> mGestureListener;
    private ScaleGestureDetector mScaleGestureDetector;
    private ArrayList<ScaleGestureDetector.OnScaleGestureListener> mScaleGestureListener;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent r100) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector r100) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector r100) {
    }

    public void release() {
        ArrayList<GestureDetector.SimpleOnGestureListener> r100 = this.mGestureListener;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    public TouchHelper(Context r100) {
        this.mGestureDetector = new GestureDetector(r100, this);
        this.mScaleGestureDetector = new ScaleGestureDetector(r100, this);
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector r100) {
        ArrayList<ScaleGestureDetector.OnScaleGestureListener> r101 = this.mScaleGestureListener;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.isEmpty() == true) goto L16;
        Iterator<ScaleGestureDetector.OnScaleGestureListener> r102 = this.mScaleGestureListener.iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        r102.next().onScale(r100);
        goto L9
    L11:
        return true;
    L16:
        return false;
    }

    public boolean onTouchEvent(MotionEvent r100) {
        if (this.mGestureDetector == null) goto L8;
        if (r100.getPointerCount() != 1) goto L8;
        this.mGestureDetector.onTouchEvent(r100);
    L8:
        if (this.mScaleGestureDetector != null) goto L10;
        return false;
    L10:
        if (r100.getPointerCount() != 2) goto L15;
        this.mScaleGestureDetector.onTouchEvent(r100);
        return false;
    L15:
        return false;
    }

    public void register(GestureDetector.SimpleOnGestureListener r100) {
        if (this.mGestureListener != null) goto L6;
        this.mGestureListener = new ArrayList();
    L6:
        if (this.mGestureListener.contains(r100) == true) goto L9;
        this.mGestureListener.add(r100);
        return;
    }

    public void unregister(GestureDetector.SimpleOnGestureListener r100) {
        ArrayList<GestureDetector.SimpleOnGestureListener> r101 = this.mGestureListener;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void register(ScaleGestureDetector.OnScaleGestureListener r100) {
        if (this.mScaleGestureListener != null) goto L6;
        this.mScaleGestureListener = new ArrayList();
    L6:
        if (this.mScaleGestureListener.contains(r100) == true) goto L9;
        this.mScaleGestureListener.add(r100);
        return;
    }

    public void unregister(ScaleGestureDetector.OnScaleGestureListener r100) {
        ArrayList<ScaleGestureDetector.OnScaleGestureListener> r101 = this.mScaleGestureListener;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        ArrayList<GestureDetector.SimpleOnGestureListener> r104 = this.mGestureListener;
        if (r104 != null) goto L5;
        return false;
    L5:
        if (r104.isEmpty() == true) goto L16;
        Iterator<GestureDetector.SimpleOnGestureListener> r105 = this.mGestureListener.iterator();
    L9:
        if (r105.hasNext() == false) goto L11;
        r105.next().onScroll(r100, r101, r102, r103);
        goto L9
    L11:
        return true;
    L16:
        return false;
    }
}
