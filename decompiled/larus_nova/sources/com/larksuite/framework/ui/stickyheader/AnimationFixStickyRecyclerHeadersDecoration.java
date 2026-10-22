package com.larksuite.framework.ui.stickyheader;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import q28.c;
import r28.b;
import u28.a;

/* JADX INFO: loaded from: classes24.dex */
public class AnimationFixStickyRecyclerHeadersDecoration extends StickyRecyclerHeadersDecoration {
    public AnimationFixStickyRecyclerHeadersDecoration(c r100) {
        super(r100);
    }

    @Override // com.larksuite.framework.ui.stickyheader.StickyRecyclerHeadersDecoration, androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        if (r111.getItemAnimator() != null) goto L5;
    L20:
        super.onDrawOver(r110, r111, r112);
        return;
    L5:
        if (r111.getItemAnimator().isRunning() == false) goto L20;
        int r113 = r111.getPaddingLeft();
        int r100 = r111.getWidth() - r111.getPaddingRight();
        int r101 = r111.getChildCount();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L27;
        View r103 = r111.getChildAt(r102);
        int r104 = r111.getChildAdapterPosition(r103);
        if (r104 == (-1)) goto L19;
        boolean r105 = this.f285864e.e(r103, ((a) this.f285863d).a(r111), r104);
        if (r105 == false) goto L14;
    L15:
        View r106 = ((b) this.f285862c).a(r111, r104);
        boolean r107 = this.f285864e.g(r111, r103, r106, ((a) this.f285863d).a(r111));
        int r114 = r106.getHeight();
        if (r107 == false) goto L18;
        Rect r115 = new Rect();
        this.f285864e.f(r115, r111, r106, r103, r105);
        r115.toString();
        t28.a r108 = this.f285865f;
        int r109 = r115.top;
        r108.a(r111, r110, r106, new Rect(r113, r109, r100, r114 + r109));
        goto L19
    L18:
        int r116 = (int) (r103.getTranslationY() + 0.5f);
        RecyclerView.LayoutParams r117 = (RecyclerView.LayoutParams) r103.getLayoutParams();
        int r118 = (r103.getTop() - ((ViewGroup.MarginLayoutParams) r117).topMargin) + r116;
        Rect r119 = new Rect(r113, r118 - r114, r100, r118);
        this.f285865f.a(r111, r110, r106, r119);
        goto L19
    L14:
        if (this.f285864e.d(r104, ((a) this.f285863d).b(r111)) == true) goto L15;
    L19:
        r102 = r102 + 1;
        goto L7
    }
}
