package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TabHighLightView extends View {
    public View a;
    public Integer b;
    public Float c;
    public Float d;
    public final Lazy e;
    public final a f;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ TabHighLightView a;

        public a(TabHighLightView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            this.a.a(r1, true);
        }
    }

    private final Paint getPaint() {
        return (Paint) this.e.getValue();
    }

    public TabHighLightView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.e = LazyKt.lazy(TabHighLightView$paint$2.INSTANCE);
        this.f = new a(this);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        super.onDraw(r13);
        Integer r0 = this.b;
        if (r0 == null) goto L17;
        int r1 = r0.intValue();
        Float r2 = this.d;
        if (r2 == null) goto L7;
        float r3 = r2.floatValue();
    L9:
        if (r3 > 0) goto L11;
        return;
    L11:
        Float r4 = this.c;
        if (r4 == null) goto L14;
        float r5 = r4.floatValue();
    L15:
        float r10 = r5;
        float r6 = (getHeight() - r3) / 2.0f;
        float r8 = (getHeight() + r3) / 2.0f;
        getPaint().setColor(r1);
        r13.drawRoundRect(0.0f, r6, getWidth(), r8, r10, r10, getPaint());
        return;
    L14:
        r5 = r3 / 2.0f;
        goto L15
    L7:
        r3 = getHeight();
        goto L9
    }

    public final void a(View r3, boolean r4) {
        if (r3.getHeight() != getHeight()) goto L7;
        if (r3.getWidth() != getWidth()) goto L7;
        return;
    L7:
        if (r3.isLaidOut() == true) goto L9;
        if (r4 == true) goto L9;
        return;
    L9:
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 != null) goto L12;
        r0 = new ViewGroup.LayoutParams(-2, -2);
    L12:
        r0.width = r3.getWidth();
        r0.height = r3.getHeight();
        Unit r1 = Unit.INSTANCE;
        setLayoutParams(r0);
        if (r4 == false) goto L18;
        setMeasuredDimension(r3.getWidth(), getMeasuredHeight());
        layout(0, r3.getTop(), r3.getWidth(), r3.getBottom());
        invalidate();
        return;
    }
}
