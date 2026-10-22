package com.ss.android.lark.contact.base.common_ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class IndexBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f418541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f418542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f418543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f418544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f418545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f418546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f418547g;

    public class a implements b {
        @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
        public final void a(String r100) {
        }

        @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
        public final void b() {
        }

        @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
        public final void c(String r100) {
        }

        public a() {
        }
    }

    public interface b {
        void a(String r100);

        void b();

        void c(String r100);
    }

    private b getDummyListener() {
        return new a();
    }

    private int getSuggestedMinWidth() {
        Iterator<String> r100 = this.f418543c.iterator();
        String r101 = "";
    L4:
        if (r100.hasNext() == false) goto L9;
        String r102 = r100.next();
        if (r101.length() >= r102.length()) goto L4;
        r101 = r102;
        goto L4
    L9:
        return (int) (((double) this.f418545e.measureText(r101)) + 0.5d);
    }

    public IndexBar(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        float r101 = r100.getY();
        int r102 = this.f418544d;
        b r103 = this.f418542b;
        int r104 = (int) ((r101 / getHeight()) * this.f418543c.size());
        if (r104 < this.f418543c.size()) goto L5;
        r104 = this.f418543c.size() - 1;
    L7:
        int r105 = r100.getAction();
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L11;
    L13:
        invalidate();
        String r106 = (String) ListProtector.get(this.f418543c, r104);
        r103.b();
    L20:
        return true;
    L11:
        if (r105 == 3) goto L13;
    L15:
        if (r102 == r104) goto L20;
        if (r104 < 0) goto L20;
        if (r104 >= this.f418543c.size()) goto L20;
        r103.c((String) ListProtector.get(this.f418543c, r104));
        this.f418544d = r104;
        invalidate();
        goto L20
    L14:
        r103.a((String) ListProtector.get(this.f418543c, r104));
        goto L15
    L5:
        if (r104 >= 0) goto L7;
        r104 = 0;
        goto L7
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        int r101 = getHeight();
        int r102 = getWidth();
        if (r101 != 0) goto L5;
        return;
    L5:
        int r103 = r101 / this.f418543c.size();
        int r104 = 0;
    L7:
        if (r104 >= this.f418543c.size()) goto L13;
        float r105 = (r102 / 2) - (this.f418545e.measureText((String) ListProtector.get(this.f418543c, r104)) / 2.0f);
        int r106 = r104 + 1;
        float r107 = r103 * r106;
        if (r104 != this.f418544d) goto L11;
        r100.drawText((String) ListProtector.get(this.f418543c, r104), r105, r107 - this.f418547g, this.f418546f);
    L12:
        r104 = r106;
        goto L7
    L11:
        r100.drawText((String) ListProtector.get(this.f418543c, r104), r105, r107 - this.f418547g, this.f418545e);
        goto L12
    }

    public void setFocusIndex(int r100) {
        this.f418544d = r100;
        invalidate();
    }

    public void setNavigators(List<String> r100) {
        this.f418543c = r100;
        invalidate();
        requestLayout();
    }

    public void setOnTouchingLetterChangedListener(b r100) {
        this.f418542b = r100;
    }

    public IndexBar(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100, r101);
    }

    public final void a(Context r100, AttributeSet r101) {
        this.f418542b = getDummyListener();
        this.f418543c = new ArrayList(0);
        this.f418544d = 0;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.bold, R.attr.focusLetterColor, R.attr.letterColor, R.attr.letterSize, R.attr.letterSpacingExtra});
        float r103 = r102.getDimension(3, 8.0f);
        int r104 = r102.getColor(2, ContextCompat.getColor(getContext(), android.R.color.white));
        this.f418541a = r102.getFloat(4, 1.4f);
        int r105 = r102.getColor(1, ContextCompat.getColor(getContext(), android.R.color.white));
        boolean r106 = r102.getBoolean(0, true);
        r102.recycle();
        if (r106 == false) goto L5;
        Typeface r107 = h18.e.b(r100, 1);
    L6:
        Paint r108 = new Paint();
        this.f418545e = r108;
        r108.setTypeface(r107);
        this.f418545e.setAntiAlias(true);
        this.f418545e.setColor(r104);
        this.f418545e.setTextSize(r103);
        Paint r109 = new Paint();
        this.f418546f = r109;
        r109.setTypeface(r107);
        this.f418546f.setAntiAlias(true);
        this.f418546f.setFakeBoldText(true);
        this.f418546f.setTextSize(r103);
        this.f418546f.setColor(r105);
        return;
    L5:
        r107 = h18.e.a(r100);
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        if (r102 == 1073741824) goto L9;
        int r104 = getSuggestedMinWidth();
        if (r102 != Integer.MIN_VALUE) goto L8;
        r103 = Math.min(r104, r103);
        goto L9
    L8:
        r103 = r104;
    L9:
        int r105 = View.MeasureSpec.getMode(r101);
        int r106 = View.MeasureSpec.getSize(r101);
        if (r105 == 1073741824) goto L16;
        Paint.FontMetrics r107 = this.f418545e.getFontMetrics();
        float r108 = r107.bottom;
        float r109 = r108 - r107.top;
        this.f418547g = r108 * this.f418541a;
        int r110 = (int) ((this.f418543c.size() * r109) * this.f418541a);
        if (r105 != Integer.MIN_VALUE) goto L15;
        r106 = Math.min(r110, r106);
        goto L16
    L15:
        r106 = r110;
    L16:
        setMeasuredDimension(r103, r106);
    }

    public IndexBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100, r101);
    }
}
