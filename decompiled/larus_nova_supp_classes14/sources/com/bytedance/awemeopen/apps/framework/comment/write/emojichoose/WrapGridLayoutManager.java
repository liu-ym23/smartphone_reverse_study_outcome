package com.bytedance.awemeopen.apps.framework.comment.write.emojichoose;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class WrapGridLayoutManager extends GridLayoutManager {
    public final float a;

    public class a extends LinearSmoothScroller {
        public final /* synthetic */ WrapGridLayoutManager a;

        public final int calculateTimeForScrolling(int r2) {
            return (int) (super.calculateTimeForScrolling(r2) * this.a.a);
        }

        public final PointF computeScrollVectorForPosition(int r2) {
            return this.a.computeScrollVectorForPosition(r2);
        }

        public a(WrapGridLayoutManager r1, Context r2) {
            this.a = r1;
            super(r2);
        }
    }

    public final void onAdapterChanged(RecyclerView.Adapter r1, RecyclerView.Adapter r2) {
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onAdapterChanged(r1, r2);
    }

    public final void onLayoutChildren(RecyclerView.Recycler r2, RecyclerView.State r3) {
        super.onLayoutChildren(r2, r3);     // Catch: IndexOutOfBoundsException -> L4 NullPointerException -> L6
        goto L10
    L9:
        return;
    L4:
        AoLogger.c("probe", new Object[]{"meet a IndexOutOfBoundsException in RecyclerView"});
        return;
    }

    public final int scrollVerticallyBy(int r2, RecyclerView.Recycler r3, RecyclerView.State r4) {
        return super.scrollVerticallyBy(r2, r3, r4);
    L5:
        return 0;
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        a r4 = new a(this, r1.getContext());
        r4.setTargetPosition(r3);
        startSmoothScroll(r4);
    }

    public WrapGridLayoutManager(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.a = 3.0f;
    }
}
