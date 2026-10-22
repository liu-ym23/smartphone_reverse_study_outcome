package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;
import com.bytedance.ee.bear.wikiv2.common.widget.InterceptableRecyclerView;
import com.larus.nova.R;
import gq5.d;

/* JADX INFO: loaded from: classes18.dex */
public class WikiHorizontalScrollView extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f241651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f241652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f241653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f241654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f241655e;

    public interface a {
        void onScrollChanged();
    }

    public WikiHorizontalScrollView(Context r100) {
        super(r100);
        this.f241654d = false;
        this.f241655e = "";
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();     // Catch: Exception -> L45
        if (r101 != 0) goto L6;
        this.f241652b = r100.getX();     // Catch: Exception -> L45
        this.f241653c = r100.getY();     // Catch: Exception -> L45
        this.f241654d = false;     // Catch: Exception -> L45
    L44:
        return super.onInterceptTouchEvent(r100);
    L6:
        if (r101 != 1) goto L8;
    L41:
        this.f241653c = 0.0f;     // Catch: Exception -> L45
        this.f241652b = 0.0f;     // Catch: Exception -> L45
        this.f241654d = false;     // Catch: Exception -> L45
        goto L44
    L8:
        if (r101 != 2) goto L10;
        float r102 = r100.getX();     // Catch: Exception -> L45
        if (Math.abs(r102 - this.f241652b) > Math.abs(r100.getY() - this.f241653c)) goto L15;
    L40:
        return false;
    L15:
        if (Math.abs(r102 - this.f241652b) <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L40;
        int r103 = r100.getPointerCount();     // Catch: Exception -> L45
        int r104 = com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a.f241670f;     // Catch: Exception -> L45
        if (r103 >= 2) goto L19;
        View r105 = ((InterceptableRecyclerView) findViewById(R.id.recycler_view)).findChildViewUnder(r100.getX(), r100.getY());     // Catch: Exception -> L45
        if (r105 == null) goto L26;
        View r106 = r105.findViewById(R.id.swipe_menu_layout);     // Catch: Exception -> L45
    L28:
        if (r102 <= this.f241652b) goto L40;
        if (r106 == null) goto L34;
        if (r106.getScrollX() == 0) goto L34;
        return false;
    L34:
        if (canScrollHorizontally(-1) == false) goto L40;
        if (this.f241654d == true) goto L39;
        d.n(new d.g(Boolean.FALSE, this.f241655e));     // Catch: Exception -> L45
        this.f241654d = true;     // Catch: Exception -> L45
    L39:
        return super.onInterceptTouchEvent(r100);
    L26:
        r106 = null;
        goto L28
    L19:
        if (this.f241654d == true) goto L22;
        d.n(new d.g(Boolean.FALSE, this.f241655e));     // Catch: Exception -> L45
        this.f241654d = true;     // Catch: Exception -> L45
    L22:
        return super.onInterceptTouchEvent(r100);
    L10:
        if (r101 == 3) goto L41;
    L45:
        return false;
    }

    public void setScrollChangeListener(a r100) {
        this.f241651a = r100;
    }

    public WikiHorizontalScrollView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f241654d = false;
        this.f241655e = "";
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        a r104 = this.f241651a;
        if (r104 == null) goto L6;
        r104.onScrollChanged();
        return;
    }
}
