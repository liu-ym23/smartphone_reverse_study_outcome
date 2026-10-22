package com.bytedance.android.shopping.widget.rittag.viewimpl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.response.RitTagUI;
import com.bytedance.android.shopping.widget.rittag.RitTagPart;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class RitTagSplitView extends View implements com.bytedance.android.shopping.widget.rittag.b {
    public static final /* synthetic */ int f = 0;
    public RitTagUI.RitTagUIItem.SplitItem.SplitStyle a;
    public int b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;

    public static final class a {
    }

    static {
    }

    private final Paint getDashPaint() {
        return (Paint) this.c.getValue();
    }

    private final int getDefaultStrokeSize() {
        return ((Number) this.e.getValue()).intValue();
    }

    private final Paint getPointPaint() {
        return (Paint) this.d.getValue();
    }

    @Override // com.bytedance.android.shopping.widget.rittag.b
    public final View i() {
        return this;
    }

    public RitTagSplitView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = RitTagUI.RitTagUIItem.SplitItem.SplitStyle.NONE;
        this.c = LazyKt.lazy(new RitTagSplitView$dashPaint$2(this));
        this.d = LazyKt.lazy(RitTagSplitView$pointPaint$2.INSTANCE);
        this.e = LazyKt.lazy(RitTagSplitView$defaultStrokeSize$2.INSTANCE);
    }

    public static final /* synthetic */ int a(RitTagSplitView r0) {
        return r0.getDefaultStrokeSize();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r15) {
        Intrinsics.checkNotNullParameter(r15, "canvas");
        super.onDraw(r15);
        int r0 = b.a[this.a.ordinal()];
        if (r0 != 1) goto L5;
        r15.drawColor(0);
        Unit r16 = Unit.INSTANCE;
        return;
    L5:
        if (r0 != 2) goto L7;
        r15.drawColor(this.b);
        Unit r17 = Unit.INSTANCE;
        return;
    L7:
        if (r0 == 3) goto L16;
        if (r0 != 4) goto L15;
        int r1 = this.b;
        if (r15 == null) goto L13;
        getPointPaint().setColor(r1);
        getPointPaint().setStrokeWidth(getWidth() / 2.0f);
        r15.drawPoint(getWidth() / 2.0f, getHeight() / 2.0f, getPointPaint());
    L13:
        Unit r18 = Unit.INSTANCE;
        return;
    L15:
        throw new NoWhenBranchMatchedException();
    L16:
        int r2 = this.b;
        if (r15 == null) goto L24;
        getDashPaint().setColor(r2);
        float r3 = getPaddingTop();
        float r4 = getHeight() - r3;
        int r5 = RangesKt.coerceAtLeast(getHeight() / 4, 2);
        float r12 = getWidth() / 2.0f;
        float r13 = r5;
        int r6 = (int) ((0.7f * r13) / 2.0f);
        int r7 = r5 / 2;
        r15.drawLine(r12, r3, r12, r3 + r6, getDashPaint());
        float r8 = r3 + (r6 + r7);
    L21:
        if (r8 >= r4) goto L23;
        r15.drawLine(r12, r8, r12, r8 + r7, getDashPaint());
        r8 = r8 + r13;
        goto L21
    L23:
        float r9 = r4 - getDefaultStrokeSize();
        r15.drawLine(r12, r9, r12, r9 + getDefaultStrokeSize(), getDashPaint());
    L24:
        Unit r19 = Unit.INSTANCE;
    }

    @Override // com.bytedance.android.shopping.widget.rittag.b
    public final void l(RitTagUI.RitTagUIItem r2, RitTagPart r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "part");
        RitTagUI.RitTagUIItem.SplitItem r4 = r2.getSplit();
        if (r4 == null) goto L6;
        RitTagUI.RitTagUIItem.SplitItem.SplitStyle r5 = r4.getSplitStyle();
        if (r5 == null) goto L6;
    L7:
        int r0 = s.a;
        RitTagUI.RitTagUIItem.SplitItem r6 = r2.getSplit();
        if (r6 == null) goto L10;
        String r7 = r6.getColor();
    L11:
        int r8 = s.a(r7, 0);
        if (this.a == r5) goto L14;
    L16:
        this.a = r5;
        this.b = r8;
        invalidate();
        return;
    L14:
        if (this.b != r8) goto L16;
        return;
    L10:
        r7 = null;
    L6:
        r5 = RitTagUI.RitTagUIItem.SplitItem.SplitStyle.NONE;
        goto L7
    }
}
