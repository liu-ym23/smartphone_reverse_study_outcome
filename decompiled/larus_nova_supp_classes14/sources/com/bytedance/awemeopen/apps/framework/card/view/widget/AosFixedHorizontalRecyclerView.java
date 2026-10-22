package com.bytedance.awemeopen.apps.framework.card.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class AosFixedHorizontalRecyclerView extends RecyclerView {
    public AosFixedHorizontalRecyclerView(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r4);
    L4:
        e = move-exception;
        AoLogger.c("AosFixedHorizontalRecyclerView", new Object[]{"dispatchTouchEvent error ", e});
        return false;
    }

    public AosFixedHorizontalRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public AosFixedHorizontalRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
