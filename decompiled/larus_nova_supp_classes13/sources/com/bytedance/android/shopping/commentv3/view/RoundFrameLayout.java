package com.bytedance.android.shopping.commentv3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/view/RoundFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Path;", "getPath", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoundFrameLayout extends FrameLayout {
    public Path a;
    public float b;
    public float c;
    public float d;
    public float e;

    public RoundFrameLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RoundFrameLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Path getPath() {
        Path r0 = this.a;
        if (r0 != null) goto L6;
        r0 = new Path();
    L6:
        if (this.a != null) goto L8;
        this.a = r0;
    L8:
        r0.reset();
        RectF r1 = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        float r3 = this.b;
        float r4 = this.c;
        float r5 = this.d;
        float r6 = this.e;
        r0.addRoundRect(r1, new float[]{r3, r3, r4, r4, r5, r5, r6, r6}, Path.Direction.CW);
        return r0;
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        r2.save();
        r2.clipPath(getPath());
        super.draw(r2);
        r2.restore();
    }

    public RoundFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ RoundFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
