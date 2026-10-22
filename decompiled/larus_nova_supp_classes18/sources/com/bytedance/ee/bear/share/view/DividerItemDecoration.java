package com.bytedance.ee.bear.share.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/share/view/DividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mHeight", "", "mLPadding", "mRPadding", "colour", "<init>", "(IIII)V", "mPaint", "Landroid/graphics/Paint;", "onDrawOver", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final Paint d;

    public DividerItemDecoration(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = 0;
        Paint r4 = new Paint();
        this.d = r4;
        r4.setColor(r3);
    }

    public final void onDrawOver(Canvas r13, RecyclerView r14, RecyclerView.State r15) {
        Intrinsics.checkNotNullParameter(r13, "c");
        Intrinsics.checkNotNullParameter(r14, "parent");
        Intrinsics.checkNotNullParameter(r15, "state");
        int r16 = r14.getChildCount() - 1;
        int r0 = 0;
    L3:
        if (r0 >= r16) goto L5;
        View r1 = r14.getChildAt(r0);
        int r2 = r1.getBottom() - this.a;
        int r3 = r1.getBottom();
        int r4 = r1.getLeft() + this.b;
        int r5 = r1.getRight() - this.c;
        int r6 = (int) (r1.getTranslationY() + 0.5f);
        r13.save();
        r13.drawRect(r4, r2 + r6, r5, r3 + r6, this.d);
        r13.restore();
        r0 = r0 + 1;
        goto L3
    }
}
