package com.bytedance.ee.bear.widgets.guidewindow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class GuideView extends FrameLayout {
    public ImageView a;
    public TextView b;
    public ImageView c;
    public int d;

    public GuideView(Context r1) {
        super(r1);
        a(r1);
    }

    public final void a(Context r3) {
        LayoutInflater.from(r3).inflate(2131568220, this, true);
        this.a = (ImageView) findViewById(2131375226);
        this.b = (TextView) findViewById(2131374145);
        this.c = (ImageView) findViewById(2131386031);
    }

    public void setIndicatorOffsetX(int r1) {
        this.d = r1;
        requestLayout();
    }

    public void setText(String r2) {
        this.b.setText(r2);
    }

    public GuideView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }

    public GuideView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        super.onLayout(r3, r4, r5, r6, r7);
        int r8 = this.a.getMeasuredWidth();
        int r9 = this.d;
        int r10 = r8 / 2;
        int r11 = r9 - r10;
        int r12 = r10 + r9;
        if (r11 < r4) goto L6;
        r4 = r11;
    L6:
        if (r12 > r6) goto L9;
        r6 = r12;
    L9:
        if (r9 == 0) goto L11;
        ImageView r13 = this.a;
        r13.layout(r4, r13.getTop(), r6, this.a.getBottom());
    L11:
        int r14 = n.f(getContext(), 12);
        TextView r15 = this.b;
        r15.layout(r15.getLeft(), this.a.getBottom(), this.b.getRight(), this.a.getBottom() + this.b.getHeight());
        this.c.layout(this.b.getLeft(), this.b.getTop() - r14, this.b.getRight(), r14);
    }
}
