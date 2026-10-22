package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView;
import com.bytedance.ee.util.ui.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements WikiHorizontalScrollView.a {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiHorizontalScrollView.a
    public final void onScrollChanged() {
        a r0 = this.a;
        RecyclerView r1 = r0.c;
        if (r1 == null) goto L14;
        int r3 = r1.getChildCount();
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L14;
        View r5 = r1.getChildAt(r4);
        if ((r5 instanceof WikItemRootView) == false) goto L9;
    L10:
        WikiHorizontalScrollView r6 = r0.b;
        if (r6 == null) goto L13;
        r5.setScrollX(-r6.getScrollX());
    L13:
        r4 = r4 + 1;
        goto L5
    L9:
        if ((r5 instanceof WikItemLeafView) == true) goto L13;
    L14:
        RecyclerView r2 = this.a.c;
        if (r2 == null) goto L32;
        int r7 = r2.getChildCount();
        int r8 = 0;
    L17:
        if (r8 >= r7) goto L32;
        View r9 = r2.getChildAt(r8);
        if ((r9 instanceof WikItemLeafView) == false) goto L21;
        WikItemLeafView r10 = (WikItemLeafView) r9;
    L22:
        if (r10 != null) goto L24;
    L26:
        boolean r11 = false;
    L27:
        if (r11 == false) goto L31;
        int r12 = r2.getChildAdapterPosition(r10);
        RecyclerView.Adapter r13 = r2.getAdapter();
        if (r13 == null) goto L31;
        r13.notifyItemChanged(r12);
    L31:
        r8 = r8 + 1;
        goto L17
    L24:
        if (r10.r != true) goto L26;
        r11 = true;
        goto L27
    L21:
        r10 = null;
    L32:
        RecyclerView r14 = this.a.c;
        if (r14 == null) goto L46;
        int r15 = r14.getChildCount();
        int r16 = 0;
    L35:
        if (r16 >= r15) goto L46;
        View r17 = r14.getChildAt(r16).findViewById(2131387820);
        if (r17 != null) goto L39;
    L41:
        boolean r18 = false;
    L42:
        if (r18 == true) goto L45;
        if (r17 == null) goto L45;
        r17.setScrollX(0);
    L45:
        r16 = r16 + 1;
        goto L35
    L39:
        if (r17.getScrollX() != 0) goto L41;
        r18 = true;
    L46:
        a r19 = this.a;
        j.e(r19.e);
        j.d(r19.e, 300);
    }
}
