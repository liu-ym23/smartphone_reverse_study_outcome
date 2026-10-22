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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TouchMonitorLayout extends FrameLayout implements v {
    public List<w> a;

    public TouchMonitorLayout(Context r1) {
        super(r1);
    }

    @Override // sa5.v
    public final void b(w r2) {
        List<w> r0 = this.a;
        if (r0 == null) goto L6;
        ((ArrayList) r0).remove(r2);
        return;
    }

    @Override // sa5.v
    public final void c(w r2) {
        if (this.a != null) goto L6;
        this.a = new ArrayList();
    L6:
        if (this.a.contains(r2) == true) goto L9;
        this.a.add(r2);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r3) {
        if (this.a == null) goto L14;
        if (r3.getAction() != 0) goto L14;
        Iterator r0 = ((ArrayList) this.a).iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        if (((w) r0.next()).u70(r3) == false) goto L8;
        return true;
    L14:
        return super.onInterceptTouchEvent(r3);
    }

    public TouchMonitorLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public TouchMonitorLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
