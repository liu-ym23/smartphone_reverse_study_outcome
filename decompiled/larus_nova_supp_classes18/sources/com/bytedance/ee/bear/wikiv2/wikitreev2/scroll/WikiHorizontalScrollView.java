package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;
import com.bytedance.ee.bear.wikiv2.common.widget.InterceptableRecyclerView;
import gq5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiHorizontalScrollView extends HorizontalScrollView {
    public a a;
    public float b;
    public float c;
    public boolean d;
    public String e;

    public interface a {
        void onScrollChanged();
    }

    public WikiHorizontalScrollView(Context r1) {
        super(r1);
        this.d = false;
        this.e = "";
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        int r1 = r8.getAction();     // Catch: Exception -> L45
        if (r1 != 0) goto L6;
        this.b = r8.getX();     // Catch: Exception -> L45
        this.c = r8.getY();     // Catch: Exception -> L45
        this.d = false;     // Catch: Exception -> L45
    L44:
        return super.onInterceptTouchEvent(r8);
    L6:
        if (r1 != 1) goto L8;
    L41:
        this.c = 0.0f;     // Catch: Exception -> L45
        this.b = 0.0f;     // Catch: Exception -> L45
        this.d = false;     // Catch: Exception -> L45
        goto L44
    L8:
        if (r1 != 2) goto L10;
        float r2 = r8.getX();     // Catch: Exception -> L45
        if (Math.abs(r2 - this.b) > Math.abs(r8.getY() - this.c)) goto L15;
    L40:
        return false;
    L15:
        if (Math.abs(r2 - this.b) <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L40;
        int r4 = r8.getPointerCount();     // Catch: Exception -> L45
        int r5 = com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a.f;     // Catch: Exception -> L45
        if (r4 >= 2) goto L19;
        View r3 = ((InterceptableRecyclerView) findViewById(2131384076)).findChildViewUnder(r8.getX(), r8.getY());     // Catch: Exception -> L45
        if (r3 == null) goto L26;
        View r6 = r3.findViewById(2131387820);     // Catch: Exception -> L45
    L28:
        if (r2 <= this.b) goto L40;
        if (r6 == null) goto L34;
        if (r6.getScrollX() == 0) goto L34;
        return false;
    L34:
        if (canScrollHorizontally(-1) == false) goto L40;
        if (this.d == true) goto L39;
        d.n(new d.g(Boolean.FALSE, this.e));     // Catch: Exception -> L45
        this.d = true;     // Catch: Exception -> L45
    L39:
        return super.onInterceptTouchEvent(r8);
    L26:
        r6 = null;
        goto L28
    L19:
        if (this.d == true) goto L22;
        d.n(new d.g(Boolean.FALSE, this.e));     // Catch: Exception -> L45
        this.d = true;     // Catch: Exception -> L45
    L22:
        return super.onInterceptTouchEvent(r8);
    L10:
        if (r1 == 3) goto L41;
    L45:
        return false;
    }

    public void setScrollChangeListener(a r1) {
        this.a = r1;
    }

    public WikiHorizontalScrollView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.d = false;
        this.e = "";
    }

    @Override // android.view.View
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        a r5 = this.a;
        if (r5 == null) goto L6;
        r5.onScrollChanged();
        return;
    }
}
