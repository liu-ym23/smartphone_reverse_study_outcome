package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/item/video/VideoProgressBar;", "Landroid/view/View;", "", "getDragProgress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProgressBar extends View {
    public static final float q = 0.0f;
    public static final float r = 0.0f;
    public final Paint a;
    public float b;
    public float c;
    public float d;
    public final RectF e;
    public ValueAnimator f;
    public float g;
    public boolean h;
    public boolean i;
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b j;
    public int k;
    public int l;
    public boolean m;
    public float n;
    public float o;
    public int p;

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
            float r1 = VideoProgressBar.q;
            r0.d(r5);
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
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b r3 = this.a.j;
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
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b r3 = this.a.j;
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

    static {
        q = q.a(8);
        r = q.a(16);
    }

    public final float getDragProgress() {
        return this.d;
    }

    public final boolean b(MotionEvent r6) {
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
        c(true);
    L41:
        float r1 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(this.d + ((r6.getX() - this.g) / getWidth()), 1.0f), 0.0f);
        this.d = r1;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b r2 = this.j;
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
        c(false);
        float r7 = this.d;
        this.c = r7;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b r3 = this.j;
        if (r3 == null) goto L45;
        r3.a(r7);
        goto L45
    L21:
        if (r0.intValue() != 1) goto L23;
    L9:
        if (r0.intValue() != 0) goto L18;
        if (r6.getY() >= (getBottom() - this.p)) goto L14;
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

    public final void c(boolean r5) {
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

    public final void d(float r2) {
        this.b = r2;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b r0 = this.j;
        if (r0 == null) goto L5;
        r0.c(r2);
    L5:
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        float r0 = this.b;
        float r1 = this.o;
        float r2 = this.n;
        float r3 = (r0 * (r1 - r2)) + r2;
        float r4 = r3 / 2.0f;
        float r5 = getWidth();
        float r6 = 0;
        if (this.b <= r6) goto L5;
        float r7 = this.d;
    L6:
        float r8 = r5 * r7;
        float r9 = 0.0f;
        if (this.m == false) goto L9;
        this.e.set(0.0f, (getHeight() - r3) / 2.0f, getWidth(), (getHeight() + r3) / 2.0f);
    L10:
        this.a.setColor(this.k);
        r12.drawRoundRect(this.e, r4, r4, this.a);
        this.a.setColor(this.l);
        RectF r10 = this.e;
        r10.right = r8;
        r12.drawRoundRect(r10, r4, r4, this.a);
        if (this.b <= r6) goto L22;
        this.a.setColor(-1);
        RectF r11 = this.e;
        float r13 = q;
        float r14 = this.b;
        float r15 = r;
        r11.set(((-r13) / 2.0f) * r14, ((-r15) / 2.0f) * r14, (r13 / 2.0f) * r14, (r15 / 2.0f) * r14);
        float r16 = 2;
        float r17 = r8 - (r4 - (this.e.width() / r16));
        if (r17 < r6) goto L17;
        r9 = r17;
    L17:
        if (this.m == false) goto L19;
        this.e.offset(r9, getHeight() / 2.0f);
    L20:
        float r18 = this.e.width() / r16;
        r12.drawRoundRect(this.e, r18, r18, this.a);
        return;
    L19:
        this.e.offset(r9, getHeight() - r4);
        goto L20
    L22:
        return;
    L9:
        this.e.set(0.0f, getHeight() - r3, getWidth(), getHeight());
        goto L10
    L5:
        r7 = this.c;
        goto L6
    }

    public VideoProgressBar(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new Paint(1);
        this.e = new RectF();
        this.k = 1476395007;
        this.l = -1056964609;
        this.n = q.a(2);
        this.o = q.a(12);
        this.p = com.bytedance.android.shopping.extensions.b.a(44);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        setMeasuredDimension(View.MeasureSpec.getSize(r1), (int) this.o);
    }

    public static void a(VideoProgressBar r2, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.b r3, boolean r4, Float r5, Integer r6, int r7, int r8, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r4 = false;
    L6:
        if ((r9 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r9 & 16) == 0) goto L12;
        r6 = null;
    L12:
        if ((r9 & 32) == 0) goto L15;
        r7 = 1476395007;
    L15:
        if ((r9 & 64) == 0) goto L17;
        r8 = -1056964609;
    L17:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "callback");
        r2.j = r3;
        r2.m = r4;
        r2.k = r7;
        r2.l = r8;
        if (r5 == null) goto L20;
        r2.n = r5.floatValue();
    L20:
        if (r6 == null) goto L23;
        r2.p = r6.intValue();
        return;
    }
}
