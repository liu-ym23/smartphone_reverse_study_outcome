package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/VerticalDragFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VerticalDragFrameLayout extends FrameLayout {
    public float a;
    public boolean b;
    public final float c;
    public int d;
    public int e;

    public VerticalDragFrameLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VerticalDragFrameLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        int r1 = r6.getActionMasked();
        float r7 = r6.getY();
        if (r1 == 0) goto L18;
        if (r1 != 1) goto L9;
    L17:
        this.b = false;
        getParent().requestDisallowInterceptTouchEvent(false);
    L29:
        return false;
    L9:
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L17;
    L14:
        if (Math.abs(r7 - this.a) <= this.c) goto L29;
        this.b = true;
        return true;
    L18:
        getParent().requestDisallowInterceptTouchEvent(true);
        ViewParent r2 = getParent();
    L19:
        boolean r3 = r2 instanceof cs1.a;
        if (r3 == true) goto L26;
        if (r2 == null) goto L23;
        ViewParent r4 = r2.getParent();
    L24:
        if (r4 == null) goto L26;
        r2 = r2.getParent();
        goto L19
    L23:
        r4 = null;
    L26:
        if (r3 == false) goto L28;
        ((cs1.a) r2).setDisallowInterceptOnce(true);
    L28:
        this.a = r7;
        this.b = false;
        goto L29
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        if (this.b == false) goto L16;
        if (r3 == null) goto L16;
        float r0 = r3.getY();
        if (r3.getActionMasked() != 2) goto L19;
        float r4 = (getY() + r0) - this.a;
        if (r4 > this.d) goto L11;
        return true;
    L11:
        if (r4 >= this.e) goto L18;
        setY(r4);
        return true;
    L18:
        return true;
    L19:
        return true;
    L16:
        return super.onTouchEvent(r3);
    }

    public VerticalDragFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = 3.0f;
    }

    public /* synthetic */ VerticalDragFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
