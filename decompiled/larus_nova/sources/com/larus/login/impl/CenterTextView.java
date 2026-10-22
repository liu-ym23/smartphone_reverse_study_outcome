package com.larus.login.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public class CenterTextView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f357145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f357146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f357147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f357148d;

    public final void a() {
        Paint r100 = new Paint(1);
        this.f357145a = r100;
        r100.setTextSize(48.0f);
        this.f357145a.setColor(ContextCompat.getColor(getContext(), R.color.larus_neutral_100));
        this.f357145a.setTextAlign(Paint.Align.CENTER);
        Paint r101 = new Paint(1);
        this.f357146b = r101;
        r101.setColor(ContextCompat.getColor(getContext(), R.color.larus_primary_transparent_1));
        this.f357147c = new Rect();
    }

    public CenterTextView(Context r100) {
        super(r100);
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        int r101 = getWidth();
        int r102 = getHeight();
        Rect r103 = this.f357147c;
        int r104 = (r101 / 2) - 32;
        r103.left = r104;
        int r105 = (r102 / 2) - 32;
        r103.top = r105;
        r103.right = r104 + 64;
        r103.bottom = r105 + 64;
        r100.drawRect(r103, this.f357146b);
        r100.drawText(this.f357148d, this.f357147c.centerX(), this.f357147c.centerY() + 24, this.f357145a);
    }

    public void setText(String r100) {
        this.f357148d = r100;
        invalidate();
    }

    public CenterTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public CenterTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
