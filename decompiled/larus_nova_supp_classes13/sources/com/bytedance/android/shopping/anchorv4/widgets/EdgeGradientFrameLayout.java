package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/widgets/EdgeGradientFrameLayout;", "Landroid/widget/FrameLayout;", "", "value", "c", "Z", "isEnableGradient", "()Z", "setEnableGradient", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EdgeGradientFrameLayout extends FrameLayout {
    public final Paint a;
    public final Rect b;
    public boolean c;
    public final LinearGradient[] d;

    public EdgeGradientFrameLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public EdgeGradientFrameLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        ArraysKt.fill$default(this.d, null, 0, 0, 6, null);
        if (getWidth() != 0) goto L5;
    L29:
        invalidate();
        return;
    L5:
        if (getHeight() == 0) goto L29;
        Rect r0 = this.b;
        int r1 = r0.left;
        if (r1 != 0) goto L16;
        if (r0.right != 0) goto L16;
        if (r0.top != 0) goto L16;
        if (r0.bottom == 0) goto L29;
    L16:
        if (r1 <= 0) goto L19;
        this.d[0] = new LinearGradient(0.0f, 0.0f, this.b.left, 0.0f, new int[]{0, -1}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
    L19:
        if (this.b.right <= 0) goto L22;
        this.d[1] = new LinearGradient(getWidth() - this.b.right, 0.0f, getWidth(), 0.0f, new int[]{-1, 0}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
    L22:
        if (this.b.top <= 0) goto L25;
        this.d[2] = new LinearGradient(0.0f, 0.0f, 0.0f, this.b.top, new int[]{0, -1}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
    L25:
        if (this.b.bottom <= 0) goto L27;
        this.d[3] = new LinearGradient(0.0f, getHeight() - this.b.bottom, 0.0f, getHeight(), new int[]{-1, 0}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
    L27:
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        if (this.c == true) goto L6;
        super.dispatchDraw(r13);
        return;
    L6:
        int r0 = r13.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.dispatchDraw(r13);
        LinearGradient[] r1 = this.d;
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L12;
        LinearGradient r4 = r1[r3];
        if (r4 == null) goto L11;
        this.a.setShader(r4);
        r13.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.a);
    L11:
        r3 = r3 + 1;
        goto L7
    L12:
        r13.restoreToCount(r0);
    }

    public final void setEnableGradient(boolean r1) {
        this.c = r1;
        invalidate();
    }

    public EdgeGradientFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Paint r5 = new Paint();
        r5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        Unit r6 = Unit.INSTANCE;
        this.a = r5;
        this.b = new Rect();
        this.c = true;
        LinearGradient[] r7 = new LinearGradient[4];
        int r8 = 0;
    L3:
        if (r8 >= 4) goto L5;
        r7[r8] = null;
        r8 = r8 + 1;
        goto L3
    L5:
        this.d = r7;
    }

    public /* synthetic */ EdgeGradientFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void b(int r3, int r4, int r5, int r6) {
        Rect r0 = this.b;
        if (r0.left == r3) goto L5;
    L11:
        r0.left = r3;
        r0.top = r4;
        r0.right = r5;
        r0.bottom = r6;
        a();
        return;
    L5:
        if (r0.top != r4) goto L11;
        if (r0.right != r5) goto L11;
        if (r0.bottom != r6) goto L11;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        a();
    }
}
