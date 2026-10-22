package com.bytedance.ee.bear.share.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/share/view/DividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mHeight", "", "mLPadding", "mRPadding", "colour", "<init>", "(IIII)V", "mPaint", "Landroid/graphics/Paint;", "onDrawOver", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f237265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f237266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f237267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f237268d;

    public DividerItemDecoration(int r100, int r101, int r102) {
        this.f237265a = r100;
        this.f237266b = r101;
        this.f237267c = 0;
        Paint r103 = new Paint();
        this.f237268d = r103;
        r103.setColor(r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        int r113 = r111.getChildCount() - 1;
        int r100 = 0;
    L3:
        if (r100 >= r113) goto L5;
        View r101 = r111.getChildAt(r100);
        int r102 = r101.getBottom() - this.f237265a;
        int r103 = r101.getBottom();
        int r104 = r101.getLeft() + this.f237266b;
        int r105 = r101.getRight() - this.f237267c;
        int r106 = (int) (r101.getTranslationY() + 0.5f);
        r110.save();
        r110.drawRect(r104, r102 + r106, r105, r103 + r106, this.f237268d);
        r110.restore();
        r100 = r100 + 1;
        goto L3
    }
}
