package com.bytedance.awemeopen.apps.framework.base.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.utils.n0;

/* JADX INFO: loaded from: classes14.dex */
public class HollowTextView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f193159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PorterDuffXfermode f193160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuffXfermode f193161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f193162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f193163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f193164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f193165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f193166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f193167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f193168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f193169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f193170l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f193171m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f193172n;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f193173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f193174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f193175c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f193176d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f193177e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f193178f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f193179g;

        public a() {
        }
    }

    public final void a() {
        Paint r100 = new Paint();
        this.f193170l = r100;
        r100.setTextSize(this.f193163e);
        this.f193170l.setAntiAlias(true);
        this.f193170l.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.f193170l.setColor(this.f193164f);
        this.f193170l.setAntiAlias(true);
    }

    public String getText() {
        return this.f193159a;
    }

    public HollowTextView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        if (TextUtils.isEmpty(this.f193159a) == true) goto L30;
        int r100 = r110.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null);
        if (this.f193161c != null) goto L7;
        this.f193161c = new PorterDuffXfermode(PorterDuff.Mode.SRC);
    L7:
        this.f193170l.setXfermode(this.f193161c);
        if (this.f193165g > 0) goto L10;
        r110.drawRect(0.0f, 0.0f, this.f193171m, this.f193172n, this.f193170l);
    L26:
        if (this.f193160b != null) goto L28;
        this.f193160b = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    L28:
        this.f193170l.setXfermode(this.f193160b);
        r110.drawText(this.f193159a, getPaddingLeft(), (((int) (this.f193172n - this.f193170l.getFontMetrics().ascent)) >> 1) - 2, this.f193170l);
        r110.restoreToCount(r100);
        return;
    L10:
        if (this.f193162d != null) goto L12;
        this.f193162d = new RectF();
    L12:
        RectF r101 = this.f193162d;
        r101.left = 0.0f;
        r101.top = 0.0f;
        r101.right = this.f193171m;
        r101.bottom = this.f193172n;
        int r102 = this.f193165g;
        r110.drawRoundRect(r101, r102, r102, this.f193170l);
        if (this.f193166h == true) goto L16;
        int r103 = this.f193165g;
        r110.drawRect(0.0f, 0.0f, r103, r103, this.f193170l);
    L16:
        if (this.f193167i == true) goto L19;
        int r104 = this.f193171m;
        int r105 = this.f193165g;
        r110.drawRect(r104 - r105, 0.0f, r104, r105, this.f193170l);
    L19:
        if (this.f193168j == true) goto L22;
        int r106 = this.f193172n;
        int r107 = this.f193165g;
        r110.drawRect(0.0f, r106 - r107, r107, r106, this.f193170l);
    L22:
        if (this.f193169k == true) goto L26;
        int r108 = this.f193171m;
        int r109 = this.f193165g;
        int r111 = this.f193172n;
        r110.drawRect(r108 - r109, r111 - r109, r108, r111, this.f193170l);
        goto L26
    }

    public void setText(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.equals(this.f193159a) == true) goto L9;
        this.f193159a = r100;
        requestLayout();
        invalidate();
        setContentDescription(r100);
        return;
    }

    public HollowTextView(Context r100, a r101) {
        super(r100);
        this.f193159a = null;
        this.f193163e = r101.f193173a;
        this.f193164f = r101.f193174b;
        this.f193165g = r101.f193175c;
        this.f193166h = r101.f193176d;
        this.f193167i = r101.f193177e;
        this.f193168j = r101.f193178f;
        this.f193169k = r101.f193179g;
        a();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        this.f193171m = (((int) this.f193170l.measureText(this.f193159a)) + getPaddingLeft()) + getPaddingRight();
        this.f193172n = (this.f193163e + getPaddingTop()) + getPaddingBottom();
        int r102 = this.f193171m;
        int r103 = View.MeasureSpec.getMode(r100);
        int r104 = View.MeasureSpec.getSize(r100);
        if (r103 == Integer.MIN_VALUE) goto L7;
        if (r103 != 1073741824) goto L8;
        r102 = r104;
    L8:
        this.f193171m = r102;
        int r105 = this.f193172n;
        int r106 = View.MeasureSpec.getMode(r101);
        int r107 = View.MeasureSpec.getSize(r101);
        if (r106 == Integer.MIN_VALUE) goto L13;
        if (r106 != 1073741824) goto L14;
        r105 = r107;
    L14:
        this.f193172n = r105;
        setMeasuredDimension(this.f193171m, r105);
        return;
    L13:
        r105 = Math.min(r105, r107);
        goto L14
    L7:
        r102 = Math.min(r102, r104);
        goto L8
    }

    public HollowTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public HollowTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193163e = 15;
        this.f193164f = -1711276033;
        this.f193165g = 0;
        this.f193166h = false;
        this.f193167i = false;
        this.f193168j = false;
        this.f193169k = false;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.textSize, R.attr.text, R.attr.radius, com.larus.nova.R.attr.color, com.larus.nova.R.attr.isBottomLeftRound, com.larus.nova.R.attr.isBottomRightRound, com.larus.nova.R.attr.isTopLeftRound, com.larus.nova.R.attr.isTopRightRound});
        this.f193163e = (int) r103.getDimension(0, n0.a(r100, 15.0f));
        this.f193159a = r103.getString(1);
        this.f193164f = r103.getColor(3, 0);
        this.f193165g = (int) r103.getDimension(2, 0.0f);
        this.f193166h = r103.getBoolean(6, false);
        this.f193167i = r103.getBoolean(7, false);
        this.f193168j = r103.getBoolean(4, false);
        this.f193169k = r103.getBoolean(5, false);
        r103.recycle();
        a();
    }
}
