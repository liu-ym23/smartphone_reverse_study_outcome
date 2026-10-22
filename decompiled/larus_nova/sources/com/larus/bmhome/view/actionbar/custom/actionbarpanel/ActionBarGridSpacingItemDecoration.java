package com.larus.bmhome.view.actionbar.custom.actionbarpanel;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J0\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/view/actionbar/custom/actionbarpanel/ActionBarGridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "horizontalSpacing", "", "verticalSpacing", "topOrBottomVerticalSpacing", "edgeEnabled", "", "<init>", "(IIIZ)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "makeGridSpacing", "position", "itemCount", "orientation", "spanCount", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionBarGridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f315826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f315827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f315828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f315829d;

    public static final class a {
    }

    static {
    }

    public ActionBarGridSpacingItemDecoration(int r100, int r101, int r102) {
        this.f315826a = r100;
        this.f315827b = r101;
        this.f315828c = r102;
        this.f315829d = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r110) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r110, "state");
        RecyclerView.LayoutManager r103 = r102.getLayoutManager();
        if ((r103 instanceof GridLayoutManager) == false) goto L43;
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = r110.getItemCount();
        GridLayoutManager r106 = (GridLayoutManager) r103;
        int r111 = r106.getOrientation();
        int r107 = r106.getSpanCount();
        if ((r105 % r107) != 0) goto L7;
        int r108 = r105 / r107;
    L8:
        if (r111 != 0) goto L10;
        int r109 = r104 / r107;
    L11:
        if (r111 != 0) goto L13;
        int r112 = r104 % r107;
    L14:
        int r113 = 0;
        if (r112 != 0) goto L17;
        boolean r114 = true;
    L18:
        if (r111 != 0) goto L23;
        if (r112 == (r107 - 1)) goto L24;
    L25:
        boolean r115 = false;
    L26:
        boolean r116 = this.f315829d;
        int r117 = this.f315826a;
        if (r116 == false) goto L29;
        int r118 = (r107 - r109) * r117;
    L30:
        r100.left = r118 / r107;
        if (r114 == false) goto L33;
        int r119 = this.f315828c;
    L34:
        r100.top = r119;
        if (r116 == false) goto L37;
        int r120 = (r117 * (r109 + 1)) / r107;
    L38:
        r100.right = r120;
        if (r115 == false) goto L41;
        r113 = this.f315828c;
    L41:
        r100.bottom = r113;
        return;
    L37:
        r120 = (r117 * (r107 - (r109 + 1))) / r107;
        goto L38
    L33:
        r119 = this.f315827b;
        goto L34
    L29:
        r118 = r117 * r109;
    L24:
        r115 = true;
        goto L26
    L23:
        if (r112 != (r108 - 1)) goto L25;
    L17:
        r114 = false;
        goto L18
    L13:
        r112 = r104 / r107;
        goto L14
    L10:
        r109 = r104 % r107;
        goto L11
    L7:
        r108 = (r105 / r107) + 1;
        goto L8
    }
}
