package com.bytedance.ee.bear.doc.structure;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import com.bytedance.ee.util.ui.j;
import mz4.m;

/* JADX INFO: loaded from: classes16.dex */
public class ParagraphLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f218190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f218191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f218192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f218193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f218194e;

    public interface a {
    }

    public ParagraphLayout(Context r100) {
        super(r100);
        this.f218193d = -1;
        this.f218192c = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 != 2) goto L8;
        if (this.f218191b == false) goto L8;
        return true;
    L8:
        if (super.onInterceptTouchEvent(r100) == false) goto L10;
        return true;
    L10:
        int r102 = r101 & 255;
        if (r102 != 0) goto L13;
        int r103 = (int) r100.getY();
        this.f218191b = false;
        this.f218190a = r103;
        this.f218193d = r100.getPointerId(0);
        a r104 = this.f218194e;
        if (r104 == null) goto L32;
        float r105 = r100.getY();
        FloatingStructureFragment r106 = ((m) r104).f516520a;
        r106.f218166h = r105;
        r106.f218167i = r106.f218169k.getY();
        r106.f218168j = 0;
        j.e(r106.f218183y);
        r106.f218171m = r106.f218165g.computeContentHeight();
    L32:
        return this.f218191b;
    L13:
        if (r102 == 1) goto L27;
        if (r102 != 2) goto L16;
        int r107 = this.f218193d;
        if (r107 != (-1)) goto L21;
        tt5.a.h("ParagraphLayout", "invalid pointer");
        goto L32
    L21:
        int r108 = r100.findPointerIndex(r107);
        if (r108 != (-1)) goto L24;
        tt5.a.d("ParagraphLayout", "Invalid pointerId=" + r107 + " in onInterceptTouchEvent");
        goto L32
    L24:
        int r109 = (int) r100.getY(r108);
        if (Math.abs(r109 - this.f218190a) <= this.f218192c) goto L32;
        this.f218191b = true;
        this.f218190a = r109;
        goto L32
    L16:
        if (r102 != 3) goto L32;
    L27:
        this.f218191b = false;
        this.f218193d = -1;
        goto L32
    }

    public void setOnActionDownListener(a r100) {
        this.f218194e = r100;
    }

    public ParagraphLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f218193d = -1;
        this.f218192c = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    public ParagraphLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f218193d = -1;
        this.f218192c = ViewConfiguration.get(r100).getScaledTouchSlop();
    }
}
