package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class WikiDividerDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f241648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f241649b;

    public WikiDividerDecoration(Context r100) {
        this.f241649b = new Rect();
        this.f241648a = n.k(r100, R.drawable.wiki_tree_divider);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        if (r111.getLayoutManager() != null) goto L5;
        return;
    L5:
        if (this.f241648a == null) goto L47;
        r110.save();
        if (r111.getClipToPadding() == false) goto L10;
        int r113 = r111.getPaddingLeft();
        int r100 = r111.getWidth() - r111.getPaddingRight();
        r110.clipRect(r113, r111.getPaddingTop(), r100, r111.getHeight() - r111.getPaddingBottom());
    L11:
        int r101 = r111.getChildCount();
        int r102 = 0;
    L12:
        if (r102 >= r101) goto L41;
        View r103 = r111.getChildAt(r102);
        r111.getDecoratedBoundsWithMargins(r103, this.f241649b);
        View r104 = r103.findViewById(R.id.header);
        if (r104 == null) goto L16;
        r113 = r103.getLeft() + r104.getPaddingLeft();
    L16:
        int r105 = this.f241649b.bottom + Math.round(r103.getTranslationY());
        int r106 = r105 - this.f241648a.getIntrinsicHeight();
        int r107 = r101 - 1;
        if (r102 != r107) goto L19;
        r106 = r103.getBottom();
        r105 = r103.getBottom() + this.f241648a.getIntrinsicHeight();
    L19:
        this.f241648a.setBounds(r113, r106, r100, r105);
        if (r102 >= r107) goto L22;
        View r108 = r111.getChildAt(r102 + 1);
    L24:
        if ((r103 instanceof WikItemLeafView) == false) goto L28;
        if (((WikItemLeafView) r103).f242239r == false) goto L28;
    L31:
        boolean r109 = false;
    L34:
        if ((r103 instanceof WikItemRootView) == true) goto L36;
    L38:
        if (r109 == false) goto L40;
        this.f241648a.draw(r110);
    L40:
        r102 = r102 + 1;
        goto L12
    L36:
        if (((WikItemRootView) r103).f242217u == false) goto L38;
        r109 = false;
    L28:
        if ((r108 instanceof WikItemLeafView) == true) goto L30;
    L32:
        r109 = true;
        goto L34
    L30:
        if (((WikItemLeafView) r108).f242239r == false) goto L32;
    L22:
        r108 = null;
        goto L24
    L41:
        r110.restore();
        return;
    L10:
        r100 = r111.getWidth();
        r113 = 0;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Drawable r104 = this.f241648a;
        if (r104 != null) goto L6;
        r100.set(0, 0, 0, 0);
        return;
    L6:
        r100.set(0, 0, 0, r104.getIntrinsicHeight());
    }
}
