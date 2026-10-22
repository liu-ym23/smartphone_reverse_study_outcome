package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ECRoundedCornerImageView;", "Landroid/widget/ImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECRoundedCornerImageView extends ImageView {
    public float a;
    public float b;
    public float c;
    public float d;
    public Path e;

    public ECRoundedCornerImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECRoundedCornerImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.e != null) goto L6;
        super.dispatchDraw(r2);
        return;
    L6:
        r2.save();
        Path r0 = this.e;
        if (r0 == null) goto L9;
        r2.clipPath(r0);
    L9:
        super.dispatchDraw(r2);
        r2.restore();
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.e != null) goto L6;
        super.draw(r2);
        return;
    L6:
        r2.save();
        Path r0 = this.e;
        if (r0 == null) goto L9;
        r2.clipPath(r0);
    L9:
        super.draw(r2);
        r2.restore();
    }

    public final void a(float r3, float r4) {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = r3;
        this.d = r4;
        if (r3 != 0.0f) goto L8;
        if (r4 != 0.0f) goto L8;
        this.e = null;
    L16:
        invalidate();
        return;
    L8:
        if (this.e != null) goto L10;
        this.e = new Path();
    L10:
        Path r5 = this.e;
        if (r5 == null) goto L13;
        r5.reset();
    L13:
        RectF r6 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float r0 = this.a;
        float r1 = this.b;
        float r2 = this.c;
        float r7 = this.d;
        float[] r8 = {r0, r0, r1, r1, r2, r2, r7, r7};
        Path r9 = this.e;
        if (r9 == null) goto L16;
        r9.addRoundRect(r6, r8, Path.Direction.CW);
        goto L16
    }

    public ECRoundedCornerImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ECRoundedCornerImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
