package com.bytedance.ee.bear.sheet.borderline;

import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/sheet/borderline/BorderStyleDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "setItemViewBackground", "position", "", "span", "childCount", "getSpanCount", "isFirstColumn", "", "isLastColumn", "isFirstRow", "isLastRow", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BorderStyleDecoration extends RecyclerView.ItemDecoration {
    public BorderStyleDecoration() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r110, View r111, RecyclerView r112, RecyclerView.State r113) {
        Intrinsics.checkNotNullParameter(r110, "outRect");
        Intrinsics.checkNotNullParameter(r111, "view");
        Intrinsics.checkNotNullParameter(r112, "parent");
        Intrinsics.checkNotNullParameter(r113, "state");
        int r114 = r111.getResources().getDimensionPixelSize(R.dimen.space_kit_len_1);
        int r100 = r112.getChildAdapterPosition(r111);
        GridLayoutManager r101 = (GridLayoutManager) r112.getLayoutManager();
        if (r101 == null) goto L5;
        int r102 = r101.getSpanCount();
    L6:
        int r103 = (r100 + 1) % r102;
        if (r103 != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        int r105 = 0;
    L13:
        r110.right = r105;
        int r106 = r100 / r102;
        if (r106 != 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == true) goto L20;
        r114 = 0;
    L20:
        r110.bottom = r114;
        RecyclerView.Adapter r115 = r112.getAdapter();
        if (r115 == null) goto L23;
        int r116 = r115.getItemCount();
    L24:
        float r117 = r111.getResources().getDimensionPixelSize(R.dimen.space_radius_m);
        if (r106 != 0) goto L27;
        boolean r118 = true;
    L29:
        if (r118 == true) goto L31;
    L36:
        float r119 = 0.0f;
    L37:
        if (r106 != 0) goto L39;
        boolean r108 = true;
    L40:
        if (r108 == false) goto L46;
        if (r103 != 0) goto L43;
        boolean r109 = true;
    L44:
        if (r109 == false) goto L46;
        float r120 = r117;
    L47:
        int r121 = r116 % r102;
        int r122 = r116 / r102;
        if (r121 != 0) goto L50;
        int r123 = r122;
    L51:
        int r124 = r106 + 1;
        if (r124 != r123) goto L54;
        boolean r125 = true;
    L55:
        if (r125 == true) goto L57;
    L62:
        float r126 = 0.0f;
    L63:
        if (r121 == 0) goto L66;
        r122 = r122 + 1;
    L66:
        if (r124 != r122) goto L68;
        boolean r127 = true;
    L69:
        if (r127 == false) goto L75;
        if (r103 != 0) goto L72;
        boolean r128 = true;
    L73:
        if (r128 == false) goto L75;
    L76:
        GradientDrawable r129 = new GradientDrawable();
        r129.setCornerRadii(new float[]{r119, r119, r120, r120, r117, r117, r126, r126});
        r111.setBackground(r129);
        r111.setBackgroundTintList(r111.getResources().getColorStateList(R.color.sheet_attr_item_bg_tint_selector));
        return;
    L72:
        r128 = false;
    L75:
        r117 = 0.0f;
        goto L76
    L68:
        r127 = false;
        goto L69
    L57:
        if ((r100 % r102) != 0) goto L59;
        boolean r130 = true;
    L60:
        if (r130 == false) goto L62;
        r126 = r117;
        goto L63
    L59:
        r130 = false;
        goto L60
    L54:
        r125 = false;
        goto L55
    L50:
        r123 = r122 + 1;
        goto L51
    L43:
        r109 = false;
    L46:
        r120 = 0.0f;
        goto L47
    L39:
        r108 = false;
        goto L40
    L31:
        if ((r100 % r102) != 0) goto L33;
        boolean r131 = true;
    L34:
        if (r131 == false) goto L36;
        r119 = r117;
        goto L37
    L33:
        r131 = false;
        goto L34
    L27:
        r118 = false;
        goto L29
    L23:
        r116 = 0;
        goto L24
    L16:
        r107 = false;
        goto L17
    L12:
        r105 = r114;
        goto L13
    L9:
        r104 = false;
        goto L10
    L5:
        r102 = 4;
        goto L6
    }
}
