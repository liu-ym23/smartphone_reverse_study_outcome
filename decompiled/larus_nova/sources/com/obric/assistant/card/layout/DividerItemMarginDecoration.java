package com.obric.assistant.card.layout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/card/layout/DividerItemMarginDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "dividerHeightPx", "", "dividerColor", "leftMarginPx", "rightMarginPx", "<init>", "(IIII)V", "paint", "Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DividerItemMarginDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f386310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f386311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f386312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f386313d;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        super.onDraw(r110, r111, r112);
        int r100 = r111.getChildCount();
        RecyclerView.LayoutManager r113 = r111.getLayoutManager();
        if (r113 != null) goto L5;
        return;
    L5:
        int r114 = 0;
    L6:
        if (r114 >= r100) goto L16;
        View r101 = r111.getChildAt(r114);
        int r102 = r111.getChildAdapterPosition(r101);
        RecyclerView.Adapter r103 = r111.getAdapter();
        if (r103 == null) goto L12;
        boolean r104 = true;
        if (r102 != (r103.getItemCount() - 1)) goto L12;
    L13:
        if (r104 == true) goto L15;
        int r105 = r113.getDecoratedLeft(r101) + this.f386311b;
        int r106 = r113.getDecoratedRight(r101) - this.f386312c;
        int r107 = r113.getDecoratedBottom(r101);
        int r108 = this.f386310a;
        int r109 = r107 - r108;
        r110.drawRect(r105, r109, r106, r108 + r109, this.f386313d);
    L15:
        r114 = r114 + 1;
    L12:
        r104 = false;
        goto L13
    }

    public DividerItemMarginDecoration(int r100, int r101, int r102, int r103) {
        this.f386310a = r100;
        this.f386311b = r102;
        this.f386312c = r103;
        Paint r104 = new Paint();
        r104.setColor(r101);
        r104.setStyle(Paint.Style.FILL);
        this.f386313d = r104;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.Adapter r105 = r102.getAdapter();
        boolean r106 = false;
        if (r105 != null) goto L5;
    L7:
        if (r106 == true) goto L10;
        r100.bottom = this.f386310a;
        return;
    L10:
        return;
    L5:
        if (r104 != (r105.getItemCount() - 1)) goto L7;
        r106 = true;
        goto L7
    }
}
