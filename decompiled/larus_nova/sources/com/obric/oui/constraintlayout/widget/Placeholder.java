package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public class Placeholder extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f400467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f400468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f400469c;

    public View getContent() {
        return this.f400468b;
    }

    public int getEmptyVisibility() {
        return this.f400469c;
    }

    public Placeholder(Context r100) {
        super(r100);
        this.f400467a = -1;
        this.f400468b = null;
        this.f400469c = 4;
        a(null);
    }

    public final void a(AttributeSet r100) {
        super.setVisibility(this.f400469c);
        this.f400467a = -1;
        if (r100 == null) goto L19;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.content, R.attr.placeholder_emptyVisibility});
        int r102 = r101.getIndexCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L13;
        int r104 = r101.getIndex(r103);
        if (r104 != 0) goto L10;
        this.f400467a = r101.getResourceId(r104, this.f400467a);
    L12:
        r103 = r103 + 1;
        goto L5
    L10:
        if (r104 != 1) goto L12;
        this.f400469c = r101.getInt(r104, this.f400469c);
        goto L12
    L13:
        r101.recycle();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        if (isInEditMode() == false) goto L6;
        r100.drawRGB(223, 223, 223);
        Paint r101 = new Paint();
        r101.setARGB(255, 210, 210, 210);
        r101.setTextAlign(Paint.Align.CENTER);
        r101.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        Rect r102 = new Rect();
        r100.getClipBounds(r102);
        r101.setTextSize(r102.height());
        int r103 = r102.height();
        int r104 = r102.width();
        r101.setTextAlign(Paint.Align.LEFT);
        r101.getTextBounds("?", 0, 1, r102);
        r100.drawText("?", ((r104 / 2.0f) - (r102.width() / 2.0f)) - r102.left, ((r103 / 2.0f) + (r102.height() / 2.0f)) - r102.bottom, r101);
        return;
    }

    public void setContentId(int r100) {
        if (this.f400467a != r100) goto L5;
        return;
    L5:
        View r101 = this.f400468b;
        if (r101 == null) goto L8;
        r101.setVisibility(0);
        ((ConstraintLayout.LayoutParams) this.f400468b.getLayoutParams()).f400414f0 = false;
        this.f400468b = null;
    L8:
        this.f400467a = r100;
        if (r100 == (-1)) goto L14;
        View r102 = ((View) getParent()).findViewById(r100);
        if (r102 == null) goto L15;
        r102.setVisibility(8);
        return;
    L15:
        return;
    }

    public void setEmptyVisibility(int r100) {
        this.f400469c = r100;
    }

    public Placeholder(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f400467a = -1;
        this.f400468b = null;
        this.f400469c = 4;
        a(r101);
    }

    public Placeholder(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f400467a = -1;
        this.f400468b = null;
        this.f400469c = 4;
        a(r101);
    }
}
