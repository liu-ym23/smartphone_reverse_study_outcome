package s08;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC7551a f540024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AbstractC7551a f540025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AbstractC7551a f540026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AbstractC7551a f540027d;

    /* JADX INFO: renamed from: s08.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC7551a {

        /* JADX INFO: renamed from: s08.a$a$a, reason: collision with other inner class name */
        public static final class C7552a extends AbstractC7551a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f540028a;

            public final String toString() {
                return "DimensionPixelSize(" + this.f540028a + ')';
            }

            public C7552a(int r100) {
                this.f540028a = r100;
            }

            @Override // s08.a.AbstractC7551a
            public final int a(Context r100, int r101) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                return this.f540028a;
            }
        }

        /* JADX INFO: renamed from: s08.a$a$b */
        public static final class b extends AbstractC7551a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final float f540029a;

            public final String toString() {
                return "PercentSize(" + this.f540029a + ')';
            }

            public b(float r100) {
                this.f540029a = r100;
            }

            @Override // s08.a.AbstractC7551a
            public final int a(Context r100, int r101) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                return (int) (this.f540029a * r101);
            }
        }

        public AbstractC7551a() {
        }

        public abstract int a(Context r100, int r101);
    }

    public final AbstractC7551a getDialogHeight() {
        return this.f540027d;
    }

    public final AbstractC7551a getDialogWidth() {
        return this.f540026c;
    }

    public final AbstractC7551a getMaxHeight() {
        return this.f540025b;
    }

    public final AbstractC7551a getMaxWidth() {
        return this.f540024a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f540024a = new AbstractC7551a.C7552a(Integer.MAX_VALUE);
        this.f540025b = new AbstractC7551a.C7552a(Integer.MAX_VALUE);
        this.f540026c = new AbstractC7551a.C7552a(-2);
        this.f540027d = new AbstractC7551a.C7552a(-2);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100) {
        if (getChildCount() != 1) goto L5;
        return;
    L5:
        super.addView(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        View r101 = getChildAt(0);
        if (r101 == null) goto L5;
        Rect r102 = new Rect();
        r101.getHitRect(r102);
        if (r102.contains((int) r100.getX(), (int) r100.getY()) == false) goto L10;
        return false;
    L10:
        return super.onTouchEvent(r100);
    L5:
        return super.onTouchEvent(r100);
    }

    public final void setDialogHeight(AbstractC7551a r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f540027d = r100;
        requestLayout();
    }

    public final void setDialogWidth(AbstractC7551a r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f540026c = r100;
        requestLayout();
    }

    public final void setMaxHeight(AbstractC7551a r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f540025b = r100;
        requestLayout();
    }

    public final void setMaxWidth(AbstractC7551a r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f540024a = r100;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101) {
        if (getChildCount() != 1) goto L5;
        return;
    L5:
        super.addView(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = a(r100, this.f540026c, this.f540024a, getPaddingLeft() + getPaddingRight());
        int r104 = a(r101, this.f540027d, this.f540025b, getPaddingTop() + getPaddingBottom());
        View r105 = getChildAt(0);
        if (r105 != null) goto L5;
        return;
    L5:
        r105.measure(r103, r104);
        int r106 = this.f540024a.a(getContext(), r102);
        int r107 = (r105.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight();
        if (r105.getMeasuredWidth() >= r106) goto L8;
        r107 = r107 | 16777216;
    L8:
        setMeasuredDimension(r107, (r105.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        if (getChildCount() != 1) goto L5;
        return;
    L5:
        super.addView(r100, r101);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, int r102) {
        if (getChildCount() != 1) goto L5;
        return;
    L5:
        super.addView(r100, r101, r102);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (getChildCount() != 1) goto L5;
        return;
    L5:
        super.addView(r100, r101, r102);
    }

    public final int a(int r100, AbstractC7551a r101, AbstractC7551a r102, int r103) {
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = View.MeasureSpec.getMode(r100);
        if (r105 != 0) goto L5;
        return r100;
    L5:
        int r106 = r101.a(getContext(), r104);
        int r107 = r102.a(getContext(), r104);
        int r108 = r104 - r103;
        if (r106 <= 0) goto L10;
        r108 = Math.min(r108, Math.min(r106, r107));
    L8:
        r105 = 1073741824;
    L16:
        return View.MeasureSpec.makeMeasureSpec(r108, r105);
    L10:
        if (r106 != (-2)) goto L13;
        r108 = Math.min(r108, r107);
        r105 = Integer.MIN_VALUE;
        goto L16
    L13:
        if (r106 != (-1)) goto L16;
        goto L8
    }
}
