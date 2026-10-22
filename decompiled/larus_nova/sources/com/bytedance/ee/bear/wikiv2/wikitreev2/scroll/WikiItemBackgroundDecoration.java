package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class WikiItemBackgroundDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f241656a;

    public WikiItemBackgroundDecoration(Context r100) {
        this.f241656a = n.k(r100, R.drawable.wiki_item_select_bg);
        n.k(r100, R.drawable.wiki_item_select_bg_more);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r100, RecyclerView r110, RecyclerView.State r111) {
        r100.save();
        int r112 = r110.getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r112) goto L13;
        View r102 = r110.getChildAt(r101);
        if ((r102 instanceof WikItemLeafView) == false) goto L12;
        SwipeMenuLayout r103 = (SwipeMenuLayout) r102.findViewById(R.id.swipe_menu_layout);
        View r104 = (View) r110.getParent();
        int r105 = r104.getRight();
        int r106 = r104.getScrollX();
        if (((WikItemLeafView) r102).f242239r == false) goto L12;
        if (r103.getScrollX() <= 0) goto L11;
        this.f241656a.setBounds(r102.getLeft() + r106, r102.getTop(), ((r105 - r103.getScrollX()) + r106) - n.d(8), r102.getBottom());
        this.f241656a.draw(r100);
        goto L12
    L11:
        this.f241656a.setBounds(r102.getLeft() + r106, r102.getTop(), (r105 - r103.getScrollX()) + r106, r102.getBottom());
        this.f241656a.draw(r100);
    L12:
        r101 = r101 + 1;
        goto L3
    L13:
        r100.restore();
    }
}
