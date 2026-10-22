package com.bytedance.ee.bear.facade.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sa5.v;
import sa5.w;

/* JADX INFO: loaded from: classes16.dex */
public class TouchMonitorLayout extends FrameLayout implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<w> f226404a;

    public TouchMonitorLayout(Context r100) {
        super(r100);
    }

    @Override // sa5.v
    public final void b(w r100) {
        List<w> r101 = this.f226404a;
        if (r101 == null) goto L6;
        ((ArrayList) r101).remove(r100);
        return;
    }

    @Override // sa5.v
    public final void c(w r100) {
        if (this.f226404a != null) goto L6;
        this.f226404a = new ArrayList();
    L6:
        if (this.f226404a.contains(r100) == true) goto L9;
        this.f226404a.add(r100);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f226404a == null) goto L14;
        if (r100.getAction() != 0) goto L14;
        Iterator r101 = ((ArrayList) this.f226404a).iterator();
    L8:
        if (r101.hasNext() == false) goto L14;
        if (((w) r101.next()).u70(r100) == false) goto L8;
        return true;
    L14:
        return super.onInterceptTouchEvent(r100);
    }

    public TouchMonitorLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public TouchMonitorLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
