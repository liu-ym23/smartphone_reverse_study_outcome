package com.ss.android.lark.thirdshare.panel.content;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/thirdshare/panel/content/ShareViewGridDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "viewWidth", "", "<init>", "(I)V", "getViewWidth", "()I", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "third-share-panel_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareViewGridDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f441286a;

    public ShareViewGridDecoration(int r100) {
        this.f441286a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.LayoutManager r105 = r102.getLayoutManager();
        if ((r105 instanceof GridLayoutManager) == false) goto L5;
        GridLayoutManager r106 = (GridLayoutManager) r105;
    L6:
        if (r106 != null) goto L8;
        return;
    L8:
        int r107 = r106.getSpanCount();
        int r108 = (((r106.getWidth() - r106.getPaddingLeft()) - r106.getPaddingRight()) - (this.f441286a * r107)) / r107;
        if (r107 <= 1) goto L11;
        int r109 = r108 / (r107 - 1);
    L12:
        int r110 = r109 * (r104 % r107);
        if ((r104 / r107) <= 0) goto L15;
        c.R1.getClass();
        int r111 = (int) c.a.f441290c.toPixels(r101.getContext());
    L16:
        r100.set(r110, r111, 0, 0);
        return;
    L15:
        r111 = 0;
        goto L16
    L11:
        r109 = 0;
        goto L12
    L5:
        r106 = null;
        goto L6
    }
}
