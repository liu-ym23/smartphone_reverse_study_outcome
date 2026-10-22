package com.larus.community.impl.quickmenu;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\nJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/community/impl/quickmenu/QuickMenuItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "horizontalSpacing", "", "verticalSpacing", "includeEdge", "", "<init>", "(IIZ)V", "spacing", "(IZ)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "setGridItemOffsets", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "setLinearItemOffsets", "Landroidx/recyclerview/widget/LinearLayoutManager;", "setDefaultItemOffsets", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickMenuItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f329722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f329723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f329724c;

    public static final class a {
    }

    static {
    }

    public QuickMenuItemDecoration() {
        this(0, 0, false);
    }

    public QuickMenuItemDecoration(int r100, int r101, boolean r102) {
        this.f329722a = r100;
        this.f329723b = r101;
        this.f329724c = r102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        RecyclerView.LayoutManager r104 = r102.getLayoutManager();
        int r105 = 0;
        if ((r104 instanceof GridLayoutManager) == false) goto L20;
        GridLayoutManager r106 = (GridLayoutManager) r104;
        int r107 = r102.getChildAdapterPosition(r101);
        if (r107 == (-1)) goto L82;
        int r108 = r106.getSpanCount();
        int r109 = r107 % r108;
        RecyclerView.Adapter r110 = r102.getAdapter();
        if (r110 == null) goto L10;
        r105 = r110.getItemCount();
    L10:
        int r111 = r107 / r108;
        int r112 = ((r105 + r108) - 1) / r108;
        if (this.f329724c == false) goto L16;
        int r113 = this.f329722a;
        r100.left = r113 - ((r109 * r113) / r108);
        r100.right = ((r109 + 1) * r113) / r108;
        if (r111 != 0) goto L15;
        r100.top = this.f329723b;
    L15:
        r100.bottom = this.f329723b;
        return;
    L16:
        int r114 = this.f329722a;
        r100.left = (r109 * r114) / r108;
        r100.right = r114 - (((r109 + 1) * r114) / r108);
        if (r111 <= 0) goto L73;
        r100.top = this.f329723b;
        return;
    L73:
        return;
    L82:
        return;
    L20:
        if ((r104 instanceof LinearLayoutManager) == false) goto L55;
        LinearLayoutManager r115 = (LinearLayoutManager) r104;
        int r116 = r102.getChildAdapterPosition(r101);
        if (r116 == (-1)) goto L83;
        RecyclerView.Adapter r117 = r102.getAdapter();
        if (r117 == null) goto L28;
        r105 = r117.getItemCount();
    L28:
        if (r115.getOrientation() != 1) goto L43;
        if (this.f329724c == false) goto L40;
        int r118 = this.f329722a;
        r100.left = r118;
        r100.right = r118;
        int r119 = this.f329723b;
        if (r116 != 0) goto L34;
        int r120 = r119;
    L35:
        r100.top = r120;
        if (r116 == (r105 - 1)) goto L39;
        r119 = r119 / 2;
    L39:
        r100.bottom = r119;
        return;
    L34:
        r120 = r119 / 2;
        goto L35
    L40:
        if (r116 <= 0) goto L76;
        r100.top = this.f329723b;
        return;
    L76:
        return;
    L43:
        if (this.f329724c == false) goto L53;
        int r121 = this.f329723b;
        r100.top = r121;
        r100.bottom = r121;
        int r122 = this.f329722a;
        if (r116 != 0) goto L47;
        int r123 = r122;
    L48:
        r100.left = r123;
        if (r116 == (r105 - 1)) goto L52;
        r122 = r122 / 2;
    L52:
        r100.right = r122;
        return;
    L47:
        r123 = r122 / 2;
        goto L48
    L53:
        if (r116 <= 0) goto L79;
        r100.left = this.f329722a;
        return;
    L79:
        return;
    L83:
        return;
    L55:
        int r124 = r102.getChildAdapterPosition(r101);
        if (r124 == (-1)) goto L84;
        RecyclerView.Adapter r125 = r102.getAdapter();
        if (r125 == null) goto L62;
        r125.getItemCount();
    L62:
        if (this.f329724c == false) goto L64;
        int r126 = this.f329722a;
        int r127 = this.f329723b;
        r100.set(r126, r127, r126, r127);
        return;
    L64:
        if (r124 <= 0) goto L66;
        int r128 = this.f329723b;
    L67:
        r100.top = r128;
        if (r124 <= 0) goto L70;
        r105 = this.f329722a;
    L70:
        r100.left = r105;
        return;
    L66:
        r128 = 0;
        goto L67
    }
}
