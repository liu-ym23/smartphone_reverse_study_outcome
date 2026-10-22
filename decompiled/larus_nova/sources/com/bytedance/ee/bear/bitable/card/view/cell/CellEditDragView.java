package com.bytedance.ee.bear.bitable.card.view.cell;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.ee.bear.facade.common.widget.d;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public class CellEditDragView extends CommonActionPanelLayout implements d.b {
    public int A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b f207266v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public a f207267w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f207268x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f207269y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f207270z;

    public interface a {
        void a(int r100, int r101);
    }

    public interface b {
        void Q5();

        void W6();

        void X6();
    }

    public class c implements b {
        @Override // com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView.b
        public final void Q5() {
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView.b
        public void W6() {
        }

        public c() {
        }
    }

    public final void n() {
        if (getDragUtil() != null) goto L5;
        return;
    L5:
        getDragUtil().l(this.f207269y);
    }

    public CellEditDragView(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.b
    public final void a(int r100) {
        a r101 = this.f207267w;
        if (r101 == null) goto L5;
        int r102 = this.A;
        this.A = r100;
        r101.a(r102, r100);
    L5:
        b r103 = this.f207266v;
        if (r103 == null) goto L16;
        if (r100 != 0) goto L9;
        r103.X6();
        return;
    L9:
        float r104 = r100;
        if (Math.abs(r104 - this.f207269y) >= 1.0f) goto L13;
        this.f207266v.W6();
        return;
    L13:
        if (Math.abs(r104 - this.f207270z) >= 1.0f) goto L19;
        this.f207266v.Q5();
        return;
    L19:
        return;
    }

    public final void m(boolean r100) {
        if (getDragUtil() == null) goto L18;
        boolean r101 = true;
        if (getDragUtil() == null) goto L10;
        d r102 = getDragUtil();
        if (r102.b() >= ((int) r102.f226588c[2])) goto L10;
        r101 = false;
    L10:
        if (r101 == true) goto L21;
        if (r100 == false) goto L16;
        d r103 = getDragUtil();
        float r104 = r103.f226588c[2];
        if (r104 <= r103.b()) goto L19;
        r103.k(r104);
        return;
    L19:
        return;
    L16:
        getDragUtil().l(this.f207270z);
        return;
    L21:
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    }

    public void setHeightChangedListener(a r100) {
        this.f207267w = r100;
    }

    public void setOnPositionChangeListener(b r100) {
        this.f207266v = r100;
    }

    public CellEditDragView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CellEditDragView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setOrientation(1);
        setFocusable(true);
        setFocusableInTouchMode(true);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maxHeight, R.attr.maxHeightPercent, R.attr.midHeight, R.attr.midHeightPercent, R.attr.minHeight, R.attr.minHeightPercent});
        float r104 = r103.getFloat(5, 0.0f);     // Catch: Throwable -> L6
        float r105 = r103.getFloat(3, 0.45f);     // Catch: Throwable -> L6
        float r106 = r103.getFloat(1, 0.85f);     // Catch: Throwable -> L6
        this.f207268x = r103.getDimensionPixelSize(4, (int) (cu5.c.c() * r104));     // Catch: Throwable -> L6
        this.f207269y = r103.getDimensionPixelSize(2, (int) (cu5.c.c() * r105));     // Catch: Throwable -> L6
        this.f207270z = r103.getDimensionPixelSize(0, (int) (cu5.c.c() * r106));     // Catch: Throwable -> L6
        r103.recycle();
        l(this.f207268x, this.f207269y, this.f207270z);
        b(true);
        setOnDragViewHeightChangeListener(this);
        return;
    L6:
        th = move-exception;
        r103.recycle();
        throw th;
    }
}
