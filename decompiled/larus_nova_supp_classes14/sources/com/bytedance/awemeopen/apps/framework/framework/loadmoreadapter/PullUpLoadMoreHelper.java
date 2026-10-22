package com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class PullUpLoadMoreHelper implements RecyclerView.OnItemTouchListener {
    public final RecyclerView a;
    public final LoadMoreRecyclerViewAdapter.b b;
    public boolean c;
    public boolean d;
    public final int e;
    public float f;

    public final void onRequestDisallowInterceptTouchEvent(boolean r1) {
    }

    public final void onTouchEvent(RecyclerView r1, MotionEvent r2) {
    }

    public PullUpLoadMoreHelper(RecyclerView r2, LoadMoreRecyclerViewAdapter.b r3) {
        this.c = false;
        this.d = false;
        this.a = r2;
        this.b = r3;
        this.e = ViewConfiguration.get(r2.getContext()).getScaledTouchSlop();
        r2.addOnItemTouchListener(this);
    }

    public final boolean onInterceptTouchEvent(RecyclerView r4, MotionEvent r5) {
        if (r5.getAction() != 0) goto L5;
        this.f = r5.getY();
        this.d = true;
    L5:
        RecyclerView r6 = this.a;
        if (r6 != null) goto L8;
    L21:
        return false;
    L8:
        if (this.c == false) goto L21;
        if (this.d == false) goto L21;
        if (r6.canScrollVertically(1) == true) goto L21;
        if ((this.f - r5.getY()) <= this.e) goto L21;
        LoadMoreRecyclerViewAdapter.b r7 = this.b;
        if ((r7 instanceof LoadMoreRecyclerViewAdapter.c) == false) goto L18;
        ((LoadMoreRecyclerViewAdapter.c) r7).Zc(0);
    L20:
        this.c = false;
        this.d = false;
        goto L21
    L18:
        if (r7 == null) goto L20;
        r7.a();
        goto L20
    }
}
