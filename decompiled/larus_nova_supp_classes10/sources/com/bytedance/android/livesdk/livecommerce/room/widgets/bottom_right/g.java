package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g extends TouchDelegate {
    public final Rect a;
    public final Rect b;
    public final Rect c;
    public final View d;

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (this.c.contains((int) r5.getX(), (int) r5.getY()) == false) goto L28;
        Rect r0 = this.b;
        float r2 = 0.0f;
        if (0.0f >= r0.left) goto L7;
        float r1 = this.a.left + 0.0f;
    L9:
        if (r1 <= r0.right) goto L12;
        r1 = r1 - this.a.right;
    L12:
        if (0.0f >= r0.top) goto L15;
        r2 = 0.0f + this.a.top;
    L15:
        if (r2 <= r0.bottom) goto L17;
        r2 = r2 - this.a.bottom;
    L17:
        View r3 = this.d;
    L18:
        if (r3 == null) goto L25;
        if (r3.getTouchDelegate() == this) goto L25;
        r1 = r1 - r3.getLeft();
        r2 = r2 - r3.getTop();
        Object r4 = r3.getParent();
        if ((r4 instanceof View) == true) goto L24;
        r4 = null;
    L24:
        r3 = (View) r4;
    L25:
        r5.offsetLocation(r1, r2);
        return this.d.dispatchTouchEvent(r5);
    L7:
        r1 = 0.0f;
        goto L9
    L28:
        return super.onTouchEvent(r5);
    }

    public g(Rect r3, Rect r4, BottomRightCardManager.b r5) {
        Intrinsics.checkNotNullParameter(r3, "originBounds");
        Intrinsics.checkNotNullParameter(r4, "bounds");
        Intrinsics.checkNotNullParameter(r5, "delegateView");
        super(r4, r5);
        this.b = r3;
        this.c = r4;
        this.d = r5;
        Rect r6 = new Rect();
        r6.left = r3.left - r4.left;
        r6.right = r4.right - r3.right;
        r6.top = r3.top - r4.top;
        r6.bottom = r4.bottom - r3.bottom;
        Unit r7 = Unit.INSTANCE;
        this.a = r6;
    }
}
