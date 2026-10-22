package com.bytedance.android.shopping.anchorv4.voavhs.blur;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.utils.b2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class RealtimeBlurView extends View {
    public static int p;
    public static final StopException q = null;
    public float a;
    public int b;
    public float c;
    public e d;
    public boolean e;
    public Bitmap f;
    public Bitmap g;
    public Canvas h;
    public boolean i;
    public final Paint j;
    public final Rect k;
    public final Rect l;
    public View m;
    public boolean n;
    public final b o;

    public static class StopException extends RuntimeException {
        private StopException() {
        }

        public /* synthetic */ StopException(a r1) {
            this();
        }
    }

    public class a implements Function0<Unit> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ RealtimeBlurView b;

        public final Object invoke() {
            RealtimeBlurView r0 = this.b;
            f.a r1 = f.g;
            Context r2 = this.a;
            r1.getClass();
            r0.d = f.a.b(r2);
            return null;
        }

        public a(RealtimeBlurView r1, Context r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ RealtimeBlurView a;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            int[] r0 = new int[2];
            RealtimeBlurView r1 = this.a;
            Bitmap r2 = r1.g;
            View r3 = r1.m;
            if (r3 != null) goto L5;
        L64:
            return true;
        L5:
            if (r1.isShown() == false) goto L64;
            RealtimeBlurView r4 = this.a;
            if (r4.d == null) goto L42;
            float r5 = r4.c;
            if (r5 != 0.0f) goto L12;
            r4.a();
            goto L42
        L12:
            float r8 = r4.a;
            if (r8 != 0.0f) goto L15;
            r8 = 4.0f;
        L15:
            float r6 = r5 / r8;
            if (r6 <= 25.0f) goto L18;
            r8 = (r8 * r6) / 25.0f;
            r6 = 25.0f;
        L18:
            int r7 = r4.getWidth();
            int r9 = r4.getHeight();
            int r10 = Math.max(1, (int) (r7 / r8));
            int r11 = Math.max(1, (int) (r9 / r8));
            boolean r12 = r4.e;
            if (r4.h == null) goto L26;
            Bitmap r13 = r4.g;
            if (r13 == null) goto L26;
            if (r13.getWidth() != r10) goto L26;
            if (r4.g.getHeight() != r11) goto L26;
        L34:
            if (r12 == false) goto L40;
            e r14 = r4.d;
            if (r14 == null) goto L40;
            if (r14.a(r4.getContext(), r4.f, r6) == false) goto L42;
            r4.e = false;
        L40:
            boolean r15 = true;
        L43:
            if (r15 == false) goto L64;
            if (this.a.g == r2) goto L47;
            boolean r16 = true;
        L48:
            r3.getLocationOnScreen(r0);
            int r17 = -r0[0];
            int r18 = -r0[1];
            this.a.getLocationOnScreen(r0);
            int r19 = r17 + r0[0];
            int r20 = r18 + r0[1];
            RealtimeBlurView r21 = this.a;
            r21.f.eraseColor(r21.b & 16777215);
            int r22 = this.a.h.save();
            RealtimeBlurView r23 = this.a;
            r23.i = true;
            RealtimeBlurView.p++;
            r23.h.scale((r23.f.getWidth() * 1.0f) / this.a.getWidth(), (this.a.f.getHeight() * 1.0f) / this.a.getHeight());     // Catch: StopException -> L65 Throwable -> L54
            this.a.h.translate(-r19, -r20);     // Catch: StopException -> L65 Throwable -> L54
            if (r3.getBackground() == null) goto L52;
            r3.getBackground().draw(this.a.h);     // Catch: StopException -> L65 Throwable -> L54
        L52:
            r3.draw(this.a.h);     // Catch: StopException -> L65 Throwable -> L54
        L54:
            th = move-exception;
            RealtimeBlurView r24 = this.a;
            r24.i = false;
            RealtimeBlurView.p--;
            r24.h.restoreToCount(r22);
            throw th;
        L53:
            RealtimeBlurView r25 = this.a;
            r25.i = false;
            RealtimeBlurView.p--;
            r25.h.restoreToCount(r22);
            RealtimeBlurView r26 = this.a;
            Bitmap r27 = r26.f;
            Bitmap r28 = r26.g;
            e r29 = r26.d;
            if (r29 == null) goto L60;
            r29.b(r27, r28);
        L60:
            if (r16 == false) goto L62;
        L63:
            this.a.invalidate();
            goto L64
        L62:
            if (this.a.n == false) goto L64;
        L47:
            r16 = false;
        L26:
            r4.b();
            Bitmap r30 = Bitmap.createBitmap(r10, r11, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L66
            r4.f = r30;     // Catch: Throwable -> L66
            if (r30 == null) goto L41;
            r4.h = new Canvas(r4.f);     // Catch: Throwable -> L66
            Bitmap r31 = Bitmap.createBitmap(r10, r11, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L66
            r4.g = r31;     // Catch: Throwable -> L66
            if (r31 == null) goto L41;
            r12 = true;
        L41:
            r4.a();
        L42:
            r15 = false;
            goto L43
        }

        public b(RealtimeBlurView r1) {
            this.a = r1;
        }
    }

    static {
        q = new StopException(null);
    }

    public final void b() {
        Bitmap r0 = this.f;
        if (r0 == null) goto L5;
        r0.recycle();
        this.f = null;
    L5:
        Bitmap r1 = this.g;
        if (r1 == null) goto L9;
        r1.recycle();
        this.g = null;
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        View r0 = this.m;
        if (r0 == null) goto L5;
        r0.getViewTreeObserver().removeOnPreDrawListener(this.o);
    L5:
        a();
        super.onDetachedFromWindow();
    }

    public final void a() {
        b();
        e r0 = this.d;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public View getActivityDecorView() {
        Context r0 = getContext();
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L12;
        if (r0 == null) goto L12;
        if ((r0 instanceof Activity) == true) goto L12;
        if ((r0 instanceof ContextWrapper) == false) goto L12;
        r0 = ((ContextWrapper) r0).getBaseContext();
        r1 = r1 + 1;
    L12:
        if ((r0 instanceof Activity) == false) goto L19;
        View r2 = ((Activity) r0).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L18;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L18;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L18:
        return r2;
    L19:
        return null;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object r0 = getParent();
        if ((r0 instanceof View) == false) goto L5;
        this.m = (View) r0;
    L5:
        View r1 = this.m;
        boolean r2 = false;
        if (r1 == null) goto L13;
        r1.getViewTreeObserver().addOnPreDrawListener(this.o);
        if (this.m.getRootView() == getRootView()) goto L10;
        r2 = true;
    L10:
        this.n = r2;
        if (r2 == false) goto L15;
        this.m.postInvalidate();
        return;
    L15:
        return;
    L13:
        this.n = false;
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        if (this.i == true) goto L9;
        if (p > 0) goto L10;
        super.draw(r2);
        return;
    L10:
        return;
    L9:
        throw q;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        super.onDraw(r6);
        Bitmap r0 = this.g;
        int r1 = this.b;
        if (r0 == null) goto L5;
        Rect r2 = this.k;
        r2.right = r0.getWidth();
        Rect r3 = this.k;
        r3.bottom = r0.getHeight();
        Rect r4 = this.l;
        r4.right = getWidth();
        Rect r5 = this.l;
        r5.bottom = getHeight();
        r6.drawBitmap(r0, this.k, this.l, null);
    L5:
        this.j.setColor(r1);
        r6.drawRect(this.l, this.j);
    }

    public void setBlurRadius(float r2) {
        if (this.c == r2) goto L6;
        this.c = r2;
        this.e = true;
        invalidate();
        return;
    }

    public void setDownsampleFactor(float r2) {
        if (r2 <= 0.0f) goto L9;
        if (this.a == r2) goto L10;
        this.a = r2;
        this.e = true;
        b();
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Downsample factor must be greater than 0.");
    }

    public void setOverlayColor(int r2) {
        if (this.b == r2) goto L6;
        this.b = r2;
        invalidate();
        return;
    }

    public RealtimeBlurView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.k = new Rect();
        this.l = new Rect();
        this.o = new b(this);
        if (PdpPerfOpt.e() == false) goto L5;
        b2.b(new a(this, r3));
    L6:
        TypedArray r5 = r3.obtainStyledAttributes(r4, new int[]{2130973737, 2130973738, 2130973739});
        Resources r6 = r3.getResources();
        this.c = r5.getDimension(0, TypedValue.applyDimension(1, 10.0f, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        this.a = r5.getFloat(1, 4.0f);
        this.b = r5.getColor(2, -1426063361);
        r5.recycle();
        this.j = new Paint();
        return;
    L5:
        f.g.getClass();
        this.d = f.a.b(r3);
        goto L6
    }
}
