package com.bytedance.android.shopping.orderlist.common.widgets.bubble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/bubble/BubbleShadowLayout;", "Landroid/view/View;", "", "color", "", "setShadowColor", "", "radius", "setShadowRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BubbleShadowLayout extends View {
    public int a;
    public float b;
    public final Paint c;
    public final RectF d;

    public BubbleShadowLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BubbleShadowLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        this.c.setAntiAlias(true);
        this.c.setColor(0);
        this.c.setShadowLayer(this.b, 0.0f, 0.0f, this.a);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        super.onDraw(r3);
        r3.drawRect(this.d, this.c);
    }

    public final void setShadowColor(int r1) {
        this.a = r1;
        a();
        invalidate();
    }

    public final void setShadowRadius(float r1) {
        this.b = r1;
        a();
        invalidate();
    }

    public BubbleShadowLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = ColorProtector.parseColor("#1A000000");
        this.b = q.a(12);
        this.c = new Paint();
        this.d = new RectF();
        setLayerType(1, null);
        setWillNotDraw(false);
        a();
    }

    public /* synthetic */ BubbleShadowLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        float r6 = r2;
        float r7 = this.b;
        this.d.set(r6 + r7, r3 + r7, r4 - r7, r5 - r7);
    }
}
