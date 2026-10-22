package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J$\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/widgets/CenterLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "<init>", "(Landroid/content/Context;IZ)V", "getContext", "()Landroid/content/Context;", "scrollToPosition", "", "position", "smoothScrollToPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "CenterSmoothScroller", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CenterLayoutManager extends LinearLayoutManager {
    public final Context a;

    public static final class a extends LinearSmoothScroller {
        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }

        public final int calculateDtToFit(int r1, int r2, int r3, int r4, int r5) {
            return (r3 + ((r4 - r3) / 2)) - (r1 + ((r2 - r1) / 2));
        }
    }

    public final Context getContext() {
        return this.a;
    }

    public final void scrollToPosition(int r3) {
        int r0 = getWidth();
        View r1 = getChildAt(r3);
        if (r1 == null) goto L5;
        int r2 = r1.getMeasuredWidth();
    L6:
        super.scrollToPositionWithOffset(r3, (r0 - r2) / 2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public CenterLayoutManager(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, false);
        this.a = r2;
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        a r4 = new a(this.a);
        r4.setTargetPosition(r3);
        startSmoothScroll(r4);
    }
}
