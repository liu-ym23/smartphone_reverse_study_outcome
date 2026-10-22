package com.bytedance.awemeopen.apps.framework.base.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class PeriscopeLayout extends FrameLayout implements e {
    public static final /* synthetic */ int o = 0;
    public int a;
    public int b;
    public FrameLayout.LayoutParams c;
    public Drawable[] d;
    public final Random e;
    public Queue<ImageView> f;
    public int g;
    public int h;
    public int i;
    public int j;
    public final Handler k;
    public final a l;
    public boolean m;
    public int n;

    public class a implements Runnable {
        public final /* synthetic */ PeriscopeLayout a;

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a() {
            PeriscopeLayout r0 = this.a;
            int r1 = PeriscopeLayout.o;
            Context r2 = r0.getContext();
            if ((r2 instanceof Activity) == false) goto L5;
            boolean r3 = !((Activity) r2).isDestroyed();
        L6:
            if (r3 == false) goto L29;
            PeriscopeLayout r4 = this.a;
            if (r4.i != 0) goto L11;
            return;
        L11:
            if (r4.f.isEmpty() == false) goto L13;
            ImageView r5 = new ImageView(r4.getContext());
            r5.setLayoutParams(r4.c);
            r4.addView(r5);
            ImageView r6 = r5;
        L14:
            Drawable[] r7 = r4.d;
            int r8 = r4.n;
            r4.n = r8 + 1;
            r6.setImageDrawable(r7[r8 % 2]);
            float r9 = n0.a(r4.getContext(), 48.0f);
            float r10 = n0.a(r4.getContext(), 20.0f);
            float r11 = n0.a(r4.getContext(), 20.0f);
            if (r4.m == false) goto L17;
            float r12 = r4.b;
            r9 = (r12 - r9) - r11;
            r10 = (r12 - r10) - r11;
        L17:
            com.bytedance.awemeopen.apps.framework.utils.i r13 = new com.bytedance.awemeopen.apps.framework.utils.i(new PointF(r9, (r4.a - r4.g) - n0.a(r4.getContext(), 8.0f)), new PointF(r10, n0.a(r4.getContext(), 51.0f)));
            Object[] r14 = new Object[2];
            if (r4.m == false) goto L20;
            float r15 = r4.h - r11;
        L21:
            r14[0] = new PointF(r15, (r4.a - r4.g) - n0.a(r4.getContext(), 2.0f));
            if (r4.m == false) goto L24;
            float r16 = (r4.b - r11) - n0.a(r4.getContext(), r4.e.nextInt(30) + 12);
        L25:
            r14[1] = new PointF(r16, 0.0f);
            ValueAnimator r17 = ValueAnimator.ofObject(r13, r14);
            ValueAnimator.AnimatorUpdateListener r18 = new b(r4, r6);
            r17.addUpdateListener(r18);
            r17.setTarget(r6);
            r6.setTag(2131363081, r18);
            r17.setDuration(r4.j);
            r6.setTag(r17);
            r17.start();
            PeriscopeLayout r19 = this.a;
            Handler r20 = r19.k;
            if (r20 == null) goto L30;
            r20.postDelayed(this, r19.i);
            return;
        L30:
            return;
        L24:
            r16 = n0.a(r4.getContext(), r4.e.nextInt(30) + 12);
            goto L25
        L20:
            r15 = r4.b - r4.h;
            goto L21
        L13:
            r6 = (ImageView) ((LinkedList) r4.f).poll();
            goto L14
        L29:
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(PeriscopeLayout r1) {
            this.a = r1;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public View a;
        public final int b;
        public final int c;
        public final com.bytedance.awemeopen.apps.framework.utils.b d;
        public final /* synthetic */ PeriscopeLayout e;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r9) {
            View r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getTag() == null) goto L34;
            com.bytedance.awemeopen.apps.framework.utils.b r1 = this.d;
            if (r1 == null) goto L15;
            r1.getClass();
            long r2 = SystemClock.uptimeMillis();
            if ((r2 - r1.a) > 34) goto L12;
            boolean r3 = true;
        L13:
            if (r3 == false) goto L15;
            return;
        L12:
            r1.a = r2;
            r3 = false;
        L15:
            PointF r4 = (PointF) r9.getAnimatedValue();
            this.a.setX(r4.x);
            this.a.setY(r4.y);
            float r10 = r9.getAnimatedFraction();
            if (r10 > 0.7f) goto L19;
            float r5 = r10 / 0.7f;
            this.a.setAlpha(0.7f * r5);
            float r6 = (r5 * 0.3f) + 0.3f;
            this.a.setScaleX(r6);
            this.a.setScaleY(r6);
        L28:
            if (r10 > 0.5f) goto L30;
            this.a.setRotation(((r10 / 0.5f) * 20.0f) * this.b);
            return;
        L30:
            this.a.setRotation(((((r10 - 0.5f) / 0.5f) * 20.0f) * this.c) + (this.b * 20));
            return;
        L19:
            if (r10 > 0.8f) goto L22;
            this.a.setAlpha(0.7f);
            this.a.setScaleX(0.6f);
            this.a.setScaleY(0.6f);
            goto L28
        L22:
            if (r10 > 1.0f) goto L28;
            float r7 = (r10 - 0.8f) / 0.2f;
            this.a.setAlpha((1.0f - r7) * 0.7f);
            float r8 = (r7 * 0.1f) + 0.6f;
            this.a.setScaleX(r8);
            this.a.setScaleY(r8);
            if ((1.0f - r10) >= 1.0E-10d) goto L28;
            PeriscopeLayout r11 = this.e;
            View r12 = this.a;
            int r13 = PeriscopeLayout.o;
            r11.b(r12);
            return;
        }

        public b(PeriscopeLayout r3, View r4) {
            this.e = r3;
            this.a = r4;
            int r0 = -1;
            if (r3.e.nextBoolean() == false) goto L5;
            int r5 = 1;
        L6:
            this.b = r5;
            if (r3.e.nextBoolean() == false) goto L9;
            r0 = 1;
        L9:
            this.c = r0;
            this.d = new com.bytedance.awemeopen.apps.framework.utils.b();
            return;
        L5:
            r5 = -1;
            goto L6
        }
    }

    public final void a() {
        this.f = new LinkedList();
        this.d = new Drawable[2];
        Drawable r0 = getResources().getDrawable(2131231538);
        Drawable r1 = getResources().getDrawable(2131231539);
        Drawable[] r2 = this.d;
        r2[0] = r0;
        r2[1] = r1;
        this.g = r0.getIntrinsicHeight();
        this.h = r0.getIntrinsicWidth();
        this.c = new FrameLayout.LayoutParams(this.h, this.g);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.e
    public final void w() {
        this.j = 3000;
        this.i = 800;
        this.k.removeCallbacksAndMessages(null);
        this.k.postDelayed(this.l, this.e.nextInt(4) * 100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k.removeCallbacksAndMessages(null);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.e
    public final void stop() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        b(getChildAt(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        this.i = 0;
        this.k.removeCallbacksAndMessages(null);
        this.k.removeCallbacks(this.l);
    }

    public PeriscopeLayout(Context r2) {
        super(r2);
        this.e = new Random();
        this.k = new Handler(Looper.getMainLooper());
        this.l = new a(this);
        this.n = 0;
        a();
    }

    public final void b(View r4) {
        if (r4.getTag() != null) goto L5;
        return;
    L5:
        LinkedList r0 = (LinkedList) this.f;
        r0.add((ImageView) r4);
        ValueAnimator r1 = (ValueAnimator) r4.getTag();
        if (r1 == null) goto L9;
        r1.setTarget(null);
        r1.cancel();
        r1.removeAllUpdateListeners();
    L9:
        if ((r4.getTag(2131363081) instanceof b) == false) goto L13;
        b r2 = (b) r4.getTag(2131363081);
        if (r2 == null) goto L13;
        r2.a = null;
    L13:
        r4.setAlpha(0.0f);
        r4.setScaleX(0.3f);
        r4.setScaleY(0.3f);
        r4.setRotation(0.0f);
        r4.setTag(null);
    }

    public PeriscopeLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.e = new Random();
        this.k = new Handler(Looper.getMainLooper());
        this.l = new a(this);
        this.n = 0;
        a();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.b = getMeasuredWidth();
        this.a = getMeasuredHeight();
        boolean r3 = true;
        if (ViewCompat.getLayoutDirection(this) == 1) goto L6;
        r3 = false;
    L6:
        this.m = r3;
    }

    public PeriscopeLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.e = new Random();
        this.k = new Handler(Looper.getMainLooper());
        this.l = new a(this);
        this.n = 0;
        a();
    }
}
