package com.larus.avatar.impl.upload.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/avatar/impl/upload/utils/UploadPhotoDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "includeEdge", "", "dividerColor", "<init>", "(IIZI)V", "paint", "Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UploadPhotoDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f291321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f291322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f291323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f291324d;

    public UploadPhotoDecoration(int r100, int r101, int r102) {
        this.f291321a = r100;
        this.f291322b = r101;
        this.f291323c = false;
        Paint r103 = new Paint();
        this.f291324d = r103;
        r103.setColor(r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        int r113 = r111.getChildCount();
        int r100 = 0;
    L3:
        if (r100 >= r113) goto L5;
        View r101 = r111.getChildAt(r100);
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams r103 = (RecyclerView.LayoutParams) r102;
        int r104 = r101.getRight() + ((ViewGroup.MarginLayoutParams) r103).rightMargin;
        int r105 = this.f291322b + r104;
        r110.drawRect(r104, r101.getTop() - ((ViewGroup.MarginLayoutParams) r103).topMargin, r105, (r101.getBottom() + ((ViewGroup.MarginLayoutParams) r103).bottomMargin) + this.f291322b, this.f291324d);
        r100 = r100 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = this.f291321a;
        int r106 = r104 % r105;
        if (this.f291323c == false) goto L8;
        int r107 = this.f291322b;
        r100.left = r107 - ((r106 * r107) / r105);
        r100.right = ((r106 + 1) * r107) / r105;
        if (r104 >= r105) goto L7;
        r100.top = r107;
    L7:
        r100.bottom = r107;
        return;
    L8:
        int r108 = this.f291322b;
        r100.left = (r106 * r108) / r105;
        r100.right = r108 - (((r106 + 1) * r108) / r105);
        if (r104 < r105) goto L13;
        r100.top = r108;
        return;
    }
}
