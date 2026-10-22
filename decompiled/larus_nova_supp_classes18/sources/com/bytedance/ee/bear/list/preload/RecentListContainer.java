package com.bytedance.ee.bear.list.preload;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RecentListContainer extends FrameLayout {
    public BaseRecyclerView a;
    public boolean b;
    public a c;

    public interface a {
        void a();
    }

    public RecentListContainer(Context r1) {
        super(r1);
        this.b = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        super.dispatchDraw(r2);
        if (this.b == false) goto L5;
        return;
    L5:
        if (this.a.getChildCount() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L14;
        this.b = true;
        a r4 = this.c;
        if (r4 == null) goto L15;
        r4.a();
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r3 = false;
        goto L8
    }

    public void setFirstPageViewListener(a r1) {
        this.c = r1;
    }

    public RecentListContainer(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = false;
    }

    public RecentListContainer(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = false;
    }
}
