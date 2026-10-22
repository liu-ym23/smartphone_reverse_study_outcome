package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.bytedance.common.utility.UIUtils;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y extends Drawable {
    public final Paint a;
    public final Context b;
    public final String c;
    public final float d;
    public final float e;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        int r0 = getBounds().right;
        int r1 = getBounds().bottom;
        this.a.setColor(th.a.a(this.b, 2131106191));
        this.a.setAntiAlias(true);
        this.a.setTextSize(UIUtils.dip2Px(this.b, this.e));
        r13.save();
        r13.rotate(this.d);
        float r2 = this.a.measureText(this.c);
        int r4 = 0;
        IntIterator r3 = RangesKt.step(new IntRange(0, r1), vf4.a.b(Float.valueOf(120.0f))).iterator();
    L4:
        if (r3.hasNext() == false) goto L14;
        int r5 = r3.nextInt();
        IntProgression r6 = RangesKt.step(new IntRange((int) ((-r0) + ((r4 % 2) * r2)), r0), (int) (vf4.a.b(Float.valueOf(64.0f)) + r2));
        int r7 = r6.getFirst();
        int r8 = r6.getLast();
        int r9 = r6.getStep();
        if (r9 < 0) goto L9;
        if (r7 <= r8) goto L10;
    L13:
        r4 = r4 + 1;
    L10:
        r13.drawText(this.c, r7, r5, this.a);
        if (r7 == r8) goto L13;
        r7 = r7 + r9;
        goto L10
    L9:
        if (r7 < r8) goto L13;
    L14:
        r13.restore();
    }

    public y(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "label");
        this.b = r2;
        this.c = r3;
        this.d = -15.0f;
        this.e = 12.0f;
        this.a = new Paint();
    }
}
