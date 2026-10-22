package com.bytedance.android.shopping.deepfeed.weights.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.ec.core.utils.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tc3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/video/VideoProgressBar;", "Landroid/view/View;", "", "getDragProgress", "getProgressHeight", "()F", "progressHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProgressBar extends View {
    public static final float m = 0.0f;
    public static final float n = 0.0f;
    public static final float o = 0.0f;
    public static final float p = 0.0f;
    public final Paint a;
    public float b;
    public float c;
    public float d;
    public final RectF e;
    public ValueAnimator f;
    public float g;
    public boolean h;
    public boolean i;
    public fd3.a j;
    public boolean k;
    public Integer l;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ VideoProgressBar a;

        public b(VideoProgressBar r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            VideoProgressBar r0 = this.a;
            Object r4 = r3.getAnimatedValue();
            if (r4 == null) goto L7;
            float r5 = ((Float) r4).floatValue();
            float r1 = VideoProgressBar.m;
            r0.c(r5);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ VideoProgressBar a;
        public final /* synthetic */ boolean b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.b == true) goto L8;
            fd3.a r3 = this.a.j;
            if (r3 == null) goto L9;
            r3.onDragEnd();
            return;
        L9:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.b == false) goto L8;
            fd3.a r3 = this.a.j;
            if (r3 == null) goto L9;
            r3.onDragStart();
            return;
        L9:
            return;
        }

        public c(VideoProgressBar r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public VideoProgressBar(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VideoProgressBar(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    static {
        m = q.a(2);
        n = q.a(12);
        o = q.a(8);
        p = q.a(16);
    }

    private final float getProgressHeight() {
        if (f.f() == false) goto L6;
        return 2.0f;
    L6:
        return m;
    }

    public final float getDragProgress() {
        return this.d;
    }

    public final boolean a(MotionEvent r6) {
        if (r6 == null) goto L4;
        Integer r0 = Integer.valueOf(r6.getAction());
    L6:
        if (r0 != null) goto L9;
    L18:
        if (r0 != null) goto L21;
    L23:
        if (r0 != null) goto L26;
    L32:
        if (r0 != null) goto L35;
    L45:
        return true;
    L35:
        if (r0.intValue() != 2) goto L45;
        if (this.i == false) goto L45;
        if (this.h == true) goto L41;
        this.h = true;
        b(true);
    L41:
        float r1 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(this.d + ((r6.getX() - this.g) / getWidth()), 1.0f), 0.0f);
        this.d = r1;
        fd3.a r2 = this.j;
        if (r2 == null) goto L44;
        r2.b(r1);
    L44:
        invalidate();
        this.g = r6.getX();
        goto L45
    L26:
        if (r0.intValue() != 3) goto L32;
    L28:
        if (this.h == false) goto L45;
        this.h = false;
        b(false);
        float r7 = this.d;
        this.c = r7;
        fd3.a r3 = this.j;
        if (r3 == null) goto L45;
        r3.a(r7);
        goto L45
    L21:
        if (r0.intValue() != 1) goto L23;
    L9:
        if (r0.intValue() != 0) goto L18;
        if (r6.getY() >= (getBottom() - com.bytedance.android.shopping.extensions.b.a(15))) goto L14;
        this.i = false;
        return false;
    L14:
        this.i = true;
        this.g = r6.getX();
        this.h = false;
        ViewParent r8 = getParent();
        if (r8 == null) goto L17;
        r8.requestDisallowInterceptTouchEvent(true);
    L17:
        this.d = this.c;
        goto L45
    L4:
        r0 = null;
        goto L6
    }

    public final void b(boolean r5) {
        ValueAnimator r0 = this.f;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (r5 == false) goto L8;
        float r1 = 0.0f;
    L9:
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{r1, 1.0f - r1});
        r2.setDuration(200);
        r2.addUpdateListener(new b(this));
        r2.addListener(new c(this, r5));
        r2.start();
        Unit r6 = Unit.INSTANCE;
        this.f = r2;
        return;
    L8:
        r1 = 1.0f;
        goto L9
    }

    public final void c(float r2) {
        this.b = r2;
        fd3.a r0 = this.j;
        if (r0 == null) goto L5;
        r0.c(r2);
    L5:
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        float r0 = (this.b * (n - getProgressHeight())) + getProgressHeight();
        float r2 = r0 / 2.0f;
        float r3 = getWidth();
        float r5 = 0;
        if (this.b <= r5) goto L5;
        float r4 = this.d;
    L6:
        float r6 = r3 * r4;
        float r7 = 0.0f;
        if (this.k == false) goto L9;
        this.e.set(0.0f, (getHeight() - r0) / 2.0f, getWidth(), (getHeight() + r0) / 2.0f);
    L10:
        this.a.setColor(1476395007);
        r12.drawRoundRect(this.e, r2, r2, this.a);
        this.a.setColor(-1056964609);
        RectF r1 = this.e;
        r1.right = r6;
        r12.drawRoundRect(r1, r2, r2, this.a);
        if (this.b <= r5) goto L22;
        this.a.setColor(-1);
        RectF r8 = this.e;
        float r9 = o;
        float r10 = this.b;
        float r11 = p;
        r8.set(((-r9) / 2.0f) * r10, ((-r11) / 2.0f) * r10, (r9 / 2.0f) * r10, (r11 / 2.0f) * r10);
        float r13 = 2;
        float r14 = r6 - (r2 - (this.e.width() / r13));
        if (r14 < r5) goto L17;
        r7 = r14;
    L17:
        if (this.k == false) goto L19;
        this.e.offset(r7, getHeight() / 2.0f);
    L20:
        float r15 = this.e.width() / r13;
        r12.drawRoundRect(this.e, r15, r15, this.a);
        return;
    L19:
        this.e.offset(r7, getHeight() - r2);
        goto L20
    L22:
        return;
    L9:
        this.e.set(0.0f, getHeight() - r0, getWidth(), getHeight());
        goto L10
    L5:
        r4 = this.c;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        int r3 = View.MeasureSpec.getSize(r1);
        Integer r4 = this.l;
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L6:
        setMeasuredDimension(r3, r5);
        return;
    L5:
        r5 = (int) n;
        goto L6
    }

    public VideoProgressBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new Paint(1);
        this.e = new RectF();
    }

    public /* synthetic */ VideoProgressBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
