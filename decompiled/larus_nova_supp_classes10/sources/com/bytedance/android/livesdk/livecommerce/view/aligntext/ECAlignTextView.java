package com.bytedance.android.livesdk.livecommerce.view.aligntext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pl2.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ECAlignTextView extends View {
    public List<a> a;
    public final Paint b;
    public List<Rect> c;

    public ECAlignTextView(Context r1) {
        super(r1);
        this.b = new Paint();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        super.onDraw(r10);
        int r0 = getHeight();
        if (this.a != null) goto L5;
        return;
    L5:
        if (this.c == null) goto L20;
        int r2 = 0;
        int r3 = 0;
    L9:
        if (r2 >= this.a.size()) goto L21;
        a r4 = (a) ListProtector.get(this.a, r2);
        Rect r5 = (Rect) ListProtector.get(this.c, r2);
        Paint r6 = this.b;
        if (r4 == null) goto L14;
        if (r6 == null) goto L14;
        r6.setTextSize(0.0f);
        r6.setColor(0);
        r6.setTypeface(null);
        r6.setAntiAlias(true);
    L14:
        r4.getClass();
        int r7 = r3 + 0;
        r10.drawText(null, r7 - r5.left, ((r0 - r5.bottom) - 0) + 0, this.b);
        r3 = r7 + r5.width();
        r2 = r2 + 1;
        goto L9
    L21:
        return;
    }

    public void setTextList(List<a> r4) {
        if (r4 != null) goto L5;
        List<a> r1 = null;
    L14:
        this.a = r1;
        if (r1 != null) goto L17;
    L28:
        this.c = null;
        return;
    L17:
        if (r1.isEmpty() == true) goto L28;
        this.c = new ArrayList();
        Iterator<a> r5 = r4.iterator();
        if (r5.hasNext() == true) goto L22;
        return;
    L22:
        a r6 = r5.next();
        new Rect();
        Paint r2 = this.b;
        if (r6 == null) goto L26;
        if (r2 == null) goto L26;
        r2.setTextSize(0.0f);
        r2.setColor(0);
        r2.setTypeface(null);
        r2.setAntiAlias(true);
    L26:
        r6.getClass();
        throw null;
    L5:
        Iterator<a> r3 = r4.iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        if (r3.next() == null) goto L12;
        if (TextUtils.isEmpty(null) == false) goto L7;
    L12:
        r3.remove();
        goto L7
    L13:
        r1 = r4;
        goto L14
    }

    public ECAlignTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = new Paint();
    }

    @Override // android.view.View
    public final void onMeasure(int r7, int r8) {
        int r0 = View.MeasureSpec.getMode(r7);
        int r9 = View.MeasureSpec.getSize(r7);
        int r2 = 0;
        if (r0 != 1073741824) goto L6;
    L18:
        int r1 = View.MeasureSpec.getMode(r8);
        int r10 = View.getDefaultSize(getMinimumHeight(), r8);
        if (r1 != 1073741824) goto L22;
        r2 = r10;
    L37:
        setMeasuredDimension(r9, r2);
        return;
    L22:
        if (this.c == null) goto L37;
        if (this.a == null) goto L37;
        int r3 = 0;
        int r4 = 0;
    L28:
        if (r3 >= this.a.size()) goto L33;
        Rect r5 = (Rect) ListProtector.get(this.c, r3);
        a r6 = (a) ListProtector.get(this.a, r3);
        int r11 = r5.height();
        r6.getClass();
        if ((r11 - 0) <= r4) goto L32;
        r4 = r5.height() - 0;
    L32:
        r3 = r3 + 1;
        goto L28
    L33:
        r2 = 0 + r4;
        if (r10 == 0) goto L37;
        r2 = Math.min(r2, r10);
        goto L37
    L6:
        if (this.a != null) goto L8;
    L17:
        r9 = 0;
        goto L18
    L8:
        if (this.c == null) goto L17;
        int r12 = 0;
        int r13 = 0;
    L12:
        if (r12 >= this.a.size()) goto L14;
        Rect r14 = (Rect) ListProtector.get(this.c, r12);
        ((a) ListProtector.get(this.a, r12)).getClass();
        r13 = (r13 + 0) + r14.width();
        r12 = r12 + 1;
        goto L12
    L14:
        if (r9 != 0) goto L16;
        r9 = r13;
        goto L18
    L16:
        r9 = Math.min(r13, r9);
        goto L18
    }

    public ECAlignTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = new Paint();
    }
}
