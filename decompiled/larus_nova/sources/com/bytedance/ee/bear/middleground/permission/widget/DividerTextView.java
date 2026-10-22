package com.bytedance.ee.bear.middleground.permission.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class DividerTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f234303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f234304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f234305c;

    public DividerTextView(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        float r101 = n.c(0.5f) / 2.0f;
        if (this.f234304b == false) goto L6;
        r100.drawLine(0.0f, r101, getMeasuredWidth(), r101, this.f234303a);
    L6:
        if (this.f234305c == false) goto L9;
        r100.drawLine(0.0f, getMeasuredHeight() - r101, getMeasuredWidth(), getMeasuredHeight() - r101, this.f234303a);
        return;
    }

    public DividerTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DividerTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.bottomLine, R.attr.topLine});
        this.f234304b = r103.getBoolean(1, true);
        this.f234305c = r103.getBoolean(0, true);
        r103.recycle();
        Paint r104 = new Paint();
        this.f234303a = r104;
        r104.setColor(r100.getResources().getColor(R.color.line_divider_default));
        this.f234303a.setAntiAlias(true);
        this.f234303a.setStrokeWidth(n.c(0.5f));
        this.f234303a.setStyle(Paint.Style.FILL);
        setBackgroundColor(r100.getResources().getColor(R.color.bg_base));
    }
}
