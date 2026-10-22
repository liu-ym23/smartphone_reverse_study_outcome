package com.bytedance.android.ui.base.widget.round;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\fH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ui/base/widget/round/RoundFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipPath", "Landroid/graphics/Path;", "needClip", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "getPath", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoundFrameLayout extends FrameLayout {
    private Path clipPath;
    private boolean needClip;

    private final Path getPath() {
        Path r0 = this.clipPath;
        if (r0 != null) goto L5;
        this.clipPath = new Path();
    L6:
        Path r1 = this.clipPath;
        Intrinsics.checkNotNull(r1);
        r1.reset();
        Drawable r2 = getBackground();
        if (r2 == null) goto L11;
        BackgroundDrawable r3 = (BackgroundDrawable) r2;
        Path r4 = this.clipPath;
        Intrinsics.checkNotNull(r4);
        r4.addRoundRect(new RectF(getBackground().getBounds()), new float[]{r3.getCornerRadiusTL(), r3.getCornerRadiusTL(), r3.getCornerRadiusTR(), r3.getCornerRadiusTR(), r3.getCornerRadiusBR(), r3.getCornerRadiusBR(), r3.getCornerRadiusBL(), r3.getCornerRadiusBL()}, Path.Direction.CW);
        Path r5 = this.clipPath;
        Intrinsics.checkNotNull(r5);
        return r5;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ui.base.widget.round.BackgroundDrawable");
    L5:
        Intrinsics.checkNotNull(r0);
        r0.reset();
        goto L6
    }

    public RoundFrameLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        if (this.needClip == false) goto L5;
        int r0 = r3.save();
        r3.clipPath(getPath());
    L6:
        super.dispatchDraw(r3);
        if (this.needClip == false) goto L10;
        r3.restoreToCount(r0);
        return;
    L10:
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public RoundFrameLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public RoundFrameLayout(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.needClip = true;
        setBackground(new BackgroundDrawable(r7, r8, false, 4, null));
        if (r8 == null) goto L6;
        TypedArray r10 = r7.obtainStyledAttributes(r8, new int[]{2130969006, 2130969007, 2130969008, 2130969009, 2130969010, 2130969011, 2130969012, 2130969013, 2130969018, 2130969020, 2130969022, 2130969033, 2130969035, 2130969056, 2130969057, 2130973712, 2130973919, 2130974626, 2130974627});
        this.needClip = r10.getBoolean(16, this.needClip);
        r10.recycle();
        return;
    }
}
