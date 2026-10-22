package com.ss.android.lark.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes38.dex */
public class PointRecoderRecyclerView extends CommonRecyclerView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f448178k;

    public interface a {
        void a(float r100);
    }

    public a getTouchViewListener() {
        return this.f448178k;
    }

    public PointRecoderRecyclerView(Context r100) {
        super(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f448178k == null) goto L6;
        r100.getRawX();
        float r101 = r100.getRawY();
        this.f448178k.a(r101);
    L6:
        return super.onInterceptTouchEvent(r100);
    }

    public void setTouchViewListener(a r100) {
        this.f448178k = r100;
    }

    public PointRecoderRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public PointRecoderRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
