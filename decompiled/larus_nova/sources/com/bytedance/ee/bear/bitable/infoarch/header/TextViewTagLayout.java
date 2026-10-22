package com.bytedance.ee.bear.bitable.infoarch.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0014J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016J \u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0002J\u0010\u0010/\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u00100\u001a\u00020%2\u0006\u00101\u001a\u000202H\u0014J\f\u00103\u001a\u00020\n*\u00020.H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/header/TextViewTagLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "baseOffset", "", "value", "Landroid/graphics/drawable/Drawable;", "tagDrawable", "getTagDrawable", "()Landroid/graphics/drawable/Drawable;", "setTagDrawable", "(Landroid/graphics/drawable/Drawable;)V", "tagPaddingLeft", "getTagPaddingLeft", "()I", "setTagPaddingLeft", "(I)V", "onTagClickListener", "Landroid/view/View$OnClickListener;", "getOnTagClickListener", "()Landroid/view/View$OnClickListener;", "setOnTagClickListener", "(Landroid/view/View$OnClickListener;)V", "isTagTailing", "", "tagBounds", "Landroid/graphics/Rect;", "tagOffsetX", "", "tagOffsetY", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "measureTagOnTextView", "textView", "Landroid/widget/TextView;", "offsetTagDrawable", "onDraw", "canvas", "Landroid/graphics/Canvas;", "realLineCount", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextViewTagLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f213221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f213222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f213223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View.OnClickListener f213224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f213225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f213226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f213227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f213228h;

    public final View.OnClickListener getOnTagClickListener() {
        return this.f213224d;
    }

    public final Drawable getTagDrawable() {
        return this.f213222b;
    }

    public final int getTagPaddingLeft() {
        return this.f213223c;
    }

    public TextViewTagLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f213221a = n.c(2.0f);
        this.f213226f = new Rect();
        setWillNotDraw(false);
    }

    public static int a(TextView r100) {
        if (r100.getLineCount() <= r100.getMaxLines()) goto L6;
        return r100.getMaxLines();
    L6:
        return r100.getLineCount();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.save();
        r100.translate(this.f213227g, this.f213228h);
        Drawable r101 = this.f213222b;
        if (r101 == null) goto L5;
        r101.draw(r100);
    L5:
        r100.restore();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f213222b == null) goto L13;
        if (r100.getAction() != 0) goto L13;
        int r101 = (int) r100.getX();
        int r102 = (int) r100.getY();
        if (this.f213224d == null) goto L13;
        if (this.f213226f.contains(r101, r102) == false) goto L13;
        return true;
    L13:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f213222b == null) goto L17;
        int r101 = (int) r100.getX();
        int r102 = (int) r100.getY();
        int r103 = r100.getAction();
        if (r103 == 0) goto L15;
        if (r103 != 1) goto L9;
        boolean r104 = this.f213226f.contains(r101, r102);
        View.OnClickListener r105 = this.f213224d;
        if (r105 == null) goto L19;
        r105.onClick(this);
        return r104;
    L19:
        return r104;
    L9:
        if (r103 == 2) goto L15;
        return super.onTouchEvent(r100);
    L15:
        return this.f213226f.contains(r101, r102);
    L17:
        return super.onTouchEvent(r100);
    }

    public final void setOnTagClickListener(View.OnClickListener r100) {
        this.f213224d = r100;
    }

    public final void setTagDrawable(Drawable r100) {
        this.f213222b = r100;
        requestLayout();
    }

    public final void setTagPaddingLeft(int r100) {
        this.f213223c = r100;
    }

    public TextViewTagLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f213221a = n.c(2.0f);
        this.f213226f = new Rect();
        setWillNotDraw(false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        super.onMeasure(r100, r110);
        int r101 = 0;
        View r102 = getChildAt(0);
        if (r102 != null) goto L6;
        return;
    L6:
        if ((r102 instanceof TextView) == false) goto L65;
        TextView r103 = (TextView) r102;
        if (this.f213222b == null) goto L49;
        Layout r104 = r103.getLayout();
        if (r104 != null) goto L13;
        this.f213225e = false;
        goto L49
    L13:
        int r105 = View.MeasureSpec.getMode(r100);
        int r106 = View.MeasureSpec.getSize(r100);
        if (r105 == Integer.MIN_VALUE) goto L17;
        if (r105 == 1073741824) goto L17;
        int r107 = r104.getWidth();
    L18:
        Drawable r108 = this.f213222b;
        if (r108 == null) goto L26;
        int r109 = r108.getBounds().right;
        if (r107 < ((((r104.getLineWidth(a(r103) - 1) + r109) + getPaddingLeft()) + getPaddingRight()) + this.f213223c)) goto L23;
        boolean r111 = true;
    L24:
        this.f213225e = r111;
        goto L26
    L23:
        r111 = false;
    L26:
        if (this.f213225e == true) goto L28;
        int r112 = View.MeasureSpec.getMode(r110);
        int r113 = View.MeasureSpec.getSize(r110);
        int r114 = r103.getLineHeight();
        if (r112 == Integer.MIN_VALUE) goto L48;
        if (r112 == 1073741824) goto L48;
        setMeasuredDimension(getMeasuredWidth(), (getMeasuredHeight() + r114) + this.f213221a);
    L48:
        setMeasuredDimension(getMeasuredWidth(), Math.min(r114 + getMeasuredHeight(), r113));
        goto L49
    L28:
        if (a(r103) != 1) goto L49;
        int r115 = getMeasuredWidth();
        Drawable r116 = this.f213222b;
        if (r116 == null) goto L34;
        Rect r117 = r116.getBounds();
        if (r117 == null) goto L34;
        int r118 = r117.right;
    L36:
        if (((r115 + r118) + this.f213223c) >= r107) goto L43;
        int r119 = getMeasuredWidth();
        Drawable r120 = this.f213222b;
        if (r120 == null) goto L42;
        Rect r121 = r120.getBounds();
        if (r121 == null) goto L42;
        r101 = r121.right;
    L42:
        r107 = (r119 + r101) + this.f213223c;
    L43:
        setMeasuredDimension(r107, getMeasuredHeight());
    L34:
        r118 = 0;
    L17:
        r107 = Math.max(r106, r104.getWidth());
    L49:
        Drawable r122 = this.f213222b;
        if (r122 != null) goto L52;
        this.f213226f.setEmpty();
        return;
    L52:
        Paint.FontMetrics r123 = r103.getPaint().getFontMetrics();
        if (r103.getLayout() != null) goto L56;
        return;
    L56:
        if (this.f213225e == false) goto L62;
        float r124 = r103.getLayout().getLineTop(a(r103) - 1);
        float r125 = r103.getLayout().getLineBottom(a(r103) - 1);
        float r126 = (r103.getLayout().getLineWidth(a(r103) - 1) + getPaddingLeft()) + this.f213223c;
        if (a(r103) <= 1) goto L60;
        float r127 = (r125 - r124) / 2;
    L61:
        float r128 = r124 + r127;
    L63:
        float r129 = r128 - (r122.getBounds().bottom / 2.0f);
        this.f213226f.set(r122.getBounds());
        this.f213226f.offset((int) r126, (int) r129);
        this.f213227g = r126;
        this.f213228h = r129;
        return;
    L60:
        float r130 = r123.descent;
        float r131 = r123.ascent;
        r127 = ((r130 - r131) / 2) + (r131 - r123.top);
        goto L61
    L62:
        r128 = r103.getLayout().getLineBottom(a(r103) - 1) + ((r123.bottom - r123.top) / 2);
        r126 = getPaddingLeft();
        goto L63
    }
}
