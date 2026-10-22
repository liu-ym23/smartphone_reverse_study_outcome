package com.bytedance.locallife.pdp.album.adapter;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes21.dex */
public class PullUpLoadMoreHelper implements RecyclerView.OnItemTouchListener {
    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean r100) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView r100, MotionEvent r101) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView r100, MotionEvent r101) {
        if (r101.getAction() != 0) goto L7;
        r101.getX();
        r101.getY();
        return false;
    L7:
        return false;
    }
}
