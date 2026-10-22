package com.bytedance.ee.bear.sheet.borderline;

import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/sheet/borderline/BorderStyleDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "setItemViewBackground", "position", "", "span", "childCount", "getSpanCount", "isFirstColumn", "", "isLastColumn", "isFirstRow", "isLastRow", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BorderStyleDecoration extends RecyclerView.ItemDecoration {
    public BorderStyleDecoration() {
    }

    public final void getItemOffsets(Rect r12, View r13, RecyclerView r14, RecyclerView.State r15) {
        Intrinsics.checkNotNullParameter(r12, "outRect");
        Intrinsics.checkNotNullParameter(r13, "view");
        Intrinsics.checkNotNullParameter(r14, "parent");
        Intrinsics.checkNotNullParameter(r15, "state");
        int r16 = r13.getResources().getDimensionPixelSize(2131168297);
        int r0 = r14.getChildAdapterPosition(r13);
        GridLayoutManager r1 = r14.getLayoutManager();
        if (r1 == null) goto L5;
        int r2 = r1.getSpanCount();
    L6:
        int r3 = (r0 + 1) % r2;
        if (r3 != 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L12;
        int r7 = 0;
    L13:
        r12.right = r7;
        int r8 = r0 / r2;
        if (r8 != 0) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == true) goto L20;
        r16 = 0;
    L20:
        r12.bottom = r16;
        RecyclerView.Adapter r17 = r14.getAdapter();
        if (r17 == null) goto L23;
        int r18 = r17.getItemCount();
    L24:
        float r19 = r13.getResources().getDimensionPixelSize(2131168383);
        if (r8 != 0) goto L27;
        boolean r110 = true;
    L29:
        if (r110 == true) goto L31;
    L36:
        float r111 = 0.0f;
    L37:
        if (r8 != 0) goto L39;
        boolean r10 = true;
    L40:
        if (r10 == false) goto L46;
        if (r3 != 0) goto L43;
        boolean r11 = true;
    L44:
        if (r11 == false) goto L46;
        float r20 = r19;
    L47:
        int r21 = r18 % r2;
        int r112 = r18 / r2;
        if (r21 != 0) goto L50;
        int r113 = r112;
    L51:
        int r22 = r8 + 1;
        if (r22 != r113) goto L54;
        boolean r114 = true;
    L55:
        if (r114 == true) goto L57;
    L62:
        float r4 = 0.0f;
    L63:
        if (r21 == 0) goto L66;
        r112 = r112 + 1;
    L66:
        if (r22 != r112) goto L68;
        boolean r115 = true;
    L69:
        if (r115 == false) goto L75;
        if (r3 != 0) goto L72;
        boolean r116 = true;
    L73:
        if (r116 == false) goto L75;
    L76:
        GradientDrawable r117 = new GradientDrawable();
        r117.setCornerRadii(new float[]{r111, r111, r20, r20, r19, r19, r4, r4});
        r13.setBackground(r117);
        r13.setBackgroundTintList(r13.getResources().getColorStateList(2131105842));
        return;
    L72:
        r116 = false;
    L75:
        r19 = 0.0f;
        goto L76
    L68:
        r115 = false;
        goto L69
    L57:
        if ((r0 % r2) != 0) goto L59;
        boolean r5 = true;
    L60:
        if (r5 == false) goto L62;
        r4 = r19;
        goto L63
    L59:
        r5 = false;
        goto L60
    L54:
        r114 = false;
        goto L55
    L50:
        r113 = r112 + 1;
        goto L51
    L43:
        r11 = false;
    L46:
        r20 = 0.0f;
        goto L47
    L39:
        r10 = false;
        goto L40
    L31:
        if ((r0 % r2) != 0) goto L33;
        boolean r118 = true;
    L34:
        if (r118 == false) goto L36;
        r111 = r19;
        goto L37
    L33:
        r118 = false;
        goto L34
    L27:
        r110 = false;
        goto L29
    L23:
        r18 = 0;
        goto L24
    L16:
        r9 = false;
        goto L17
    L12:
        r7 = r16;
        goto L13
    L9:
        r6 = false;
        goto L10
    L5:
        r2 = 4;
        goto L6
    }
}
