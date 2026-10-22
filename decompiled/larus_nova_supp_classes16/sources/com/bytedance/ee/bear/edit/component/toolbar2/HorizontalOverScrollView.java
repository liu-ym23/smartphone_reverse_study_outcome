package com.bytedance.ee.bear.edit.component.toolbar2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class HorizontalOverScrollView extends HorizontalScrollView {
    public final List<a> a;

    public interface a {
        void a(int r1);
    }

    public HorizontalOverScrollView(Context r1) {
        super(r1);
        this.a = new ArrayList();
    }

    public HorizontalOverScrollView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = new ArrayList();
    }

    @Override // android.view.View
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        if (((ArrayList) this.a).size() <= 0) goto L8;
        Iterator r5 = ((ArrayList) this.a).iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        a r6 = (a) r5.next();
        int r7 = getScrollX();
        getScrollY();
        r6.a(r7);
        goto L6
    L10:
        return;
    }
}
