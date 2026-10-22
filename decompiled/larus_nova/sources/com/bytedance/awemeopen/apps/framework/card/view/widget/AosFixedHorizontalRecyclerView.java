package com.bytedance.awemeopen.apps.framework.card.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;

/* JADX INFO: loaded from: classes14.dex */
public class AosFixedHorizontalRecyclerView extends RecyclerView {
    public AosFixedHorizontalRecyclerView(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    L4:
        e = move-exception;
        AoLogger.c("AosFixedHorizontalRecyclerView", new Object[]{"dispatchTouchEvent error ", e});
        return false;
    }

    public AosFixedHorizontalRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public AosFixedHorizontalRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
