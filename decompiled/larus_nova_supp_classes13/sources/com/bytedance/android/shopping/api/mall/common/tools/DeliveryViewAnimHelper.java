package com.bytedance.android.shopping.api.mall.common.tools;

import android.R;
import android.animation.Animator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import com.bytedance.android.ec.hybrid.list.view.MallLynxTaskBanner;
import com.bytedance.android.ec.hybrid.tools.UIToolsKt;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeliveryViewAnimHelper {
    public static Uri a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static Bitmap f;
    public static Bitmap g;
    public static String h;
    public static String i;
    public static String j;
    public static int k;
    public static final long l = 0;
    public static final Lazy m = null;
    public static final DeliveryViewAnimHelper n = null;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ ImageView f;
        public final /* synthetic */ ImageView g;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.api.mall.common.tools.DeliveryViewAnimHelper$a$a, reason: collision with other inner class name */
        public static final class C0022a implements Animator.AnimatorListener {
            public final /* synthetic */ a a;

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
            }

            public C0022a(a r1) {
                this.a = r1;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                ImageView r3 = this.a.f;
                if (r3 == null) goto L6;
                UIToolsKt.b(r3);
                return;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                ImageView r3 = this.a.f;
                if (r3 == null) goto L6;
                UIToolsKt.b(r3);
                return;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                ImageView r3 = this.a.f;
                if (r3 == null) goto L6;
                Intrinsics.checkNotNullParameter(r3, "$this$inVisible");
                r3.setVisibility(4);
                return;
            }
        }

        public static final class b implements Animator.AnimatorListener {
            public final /* synthetic */ a a;

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
            }

            public b(a r1) {
                this.a = r1;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                ImageView r3 = this.a.g;
                if (r3 == null) goto L6;
                UIToolsKt.b(r3);
                return;
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                ImageView r3 = this.a.g;
                if (r3 == null) goto L6;
                UIToolsKt.b(r3);
                return;
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            ViewTreeObserver r0 = this.a.getViewTreeObserver();
            if (r0 == null) goto L5;
            r0.removeOnPreDrawListener(this);
        L5:
            int[] r1 = new int[2];
            this.a.getLocationOnScreen(r1);
            float r2 = RangesKt.coerceAtMost(this.b / RangesKt.coerceAtLeast(this.a.getMeasuredWidth(), 1), 0.5f);
            float r3 = RangesKt.coerceAtMost(this.c / RangesKt.coerceAtLeast(this.a.getMeasuredHeight(), 1), 0.5f);
            float r4 = this.d - r1[0];
            float r5 = this.e - r1[1];
            View r6 = this.a;
            r6.setPivotX(0.0f);
            r6.setPivotY(0.0f);
            r6.setScaleX(r2);
            r6.setScaleY(r3);
            r6.setTranslationX(r4);
            r6.setTranslationY(r5);
            r6.setAlpha(0.0f);
            ImageView r7 = this.f;
            if (r7 == null) goto L24;
            ViewPropertyAnimator r8 = r7.animate();
            if (r8 == null) goto L24;
            ViewPropertyAnimator r9 = r8.alpha(0.0f);
            if (r9 == null) goto L24;
            ViewPropertyAnimator r10 = r9.translationX(0.0f);
            if (r10 == null) goto L24;
            ViewPropertyAnimator r11 = r10.translationY(0.0f);
            if (r11 == null) goto L24;
            ViewPropertyAnimator r12 = r11.scaleX(1.0f);
            if (r12 == null) goto L24;
            ViewPropertyAnimator r13 = r12.scaleY(1.0f);
            if (r13 == null) goto L24;
            Uri r14 = DeliveryViewAnimHelper.a;
            ViewPropertyAnimator r15 = r13.setDuration(DeliveryViewAnimHelper.l);
            if (r15 == null) goto L24;
            ViewPropertyAnimator r16 = r15.setListener(new C0022a(this));
            if (r16 == null) goto L24;
            r16.start();
        L24:
            View r17 = this.a;
            if (r17 == null) goto L43;
            ViewPropertyAnimator r18 = r17.animate();
            if (r18 == null) goto L43;
            ViewPropertyAnimator r19 = r18.alpha(1.0f);
            if (r19 == null) goto L43;
            ViewPropertyAnimator r20 = r19.translationX(0.0f);
            if (r20 == null) goto L43;
            ViewPropertyAnimator r21 = r20.translationY(0.0f);
            if (r21 == null) goto L43;
            ViewPropertyAnimator r22 = r21.scaleX(1.0f);
            if (r22 == null) goto L43;
            ViewPropertyAnimator r23 = r22.scaleY(1.0f);
            if (r23 == null) goto L43;
            Uri r24 = DeliveryViewAnimHelper.a;
            ViewPropertyAnimator r25 = r23.setDuration(DeliveryViewAnimHelper.l);
            if (r25 == null) goto L43;
            ViewPropertyAnimator r26 = r25.setListener(new b(this));
            if (r26 == null) goto L43;
            r26.start();
        L43:
            return true;
        }

        public a(View r1, int r2, int r3, int r4, int r5, ImageView r6, ImageView r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public DeliveryViewAnimHelper() {
    }

    public static void b() {
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        h = "";
        i = "";
        j = "";
        k = -1;
        a = null;
        f = null;
        g = null;
    }

    static {
        n = new DeliveryViewAnimHelper();
        h = "";
        i = "";
        j = "";
        k = -1;
        l = 250;
        m = LazyKt.lazy(DeliveryViewAnimHelper$deliveryService$2.INSTANCE);
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static Uri d(Uri r9, View r10) {
        if (r10 == null) goto L20;
        int r0 = View.generateViewId();
        Uri.Builder r11 = r9.buildUpon();
        r10.setId(r0);
        DeliveryViewAnimHelper r1 = n;
        r1.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Rect r3 = new Rect();     // Catch: Throwable -> L12
        boolean r4 = r10.getGlobalVisibleRect(r3);     // Catch: Throwable -> L12
        Activity r5 = MallLynxTaskBanner.b.getActivity(r10.getContext());     // Catch: Throwable -> L12
        if (r4 == false) goto L10;
        if (r5 == null) goto L10;
        Bitmap r6 = Bitmap.createBitmap(a(r5.getWindow()).getWidth(), a(r5.getWindow()).getHeight(), Bitmap.Config.RGB_565);     // Catch: Throwable -> L12
        PixelCopy.request(r5.getWindow(), r6, new f(r1, r6), new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L12
        Bitmap r7 = Bitmap.createBitmap(r3.width(), r3.height(), Bitmap.Config.RGB_565);     // Catch: Throwable -> L12
        PixelCopy.request(r5.getWindow(), r3, r7, new g(r1, r7), new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L12
    L10:
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r12 = Result.exceptionOrNull-impl(r8);
        if (r12 == null) goto L17;
        EnsureManager.ensureNotReachHere(r12);
    L17:
        r11.appendQueryParameter("share_element_view_id", String.valueOf(r0));
        r9 = r11.build();
        n.getClass();
        Rect r13 = new Rect();
        if (r10.getGlobalVisibleRect(r13) == false) goto L20;
        b = r13.left;
        c = r13.top;
        d = r13.width();
        e = r13.height();
    L12:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L20:
        return r9;
    }

    public static void c(Activity r11, ImageView r12, ImageView r13, int r14, int r15, int r16, int r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r11, "deliveryActivity");
        if (f != null) goto L5;
    L15:
        boolean r1 = false;
    L16:
        if (r1 == true) goto L18;
        return;
    L18:
        View r2 = a(r11.getWindow());
        View r4 = r11.findViewById(R.id.content);
        r11.overridePendingTransition(0, 0);
        if (r18 == false) goto L21;
        r4.setBackgroundColor(-1);
    L21:
        int[] r0 = new int[2];
        if (r13 == null) goto L24;
        r13.getLocationOnScreen(r0);
        r13.setPivotX(0.0f);
        r13.setPivotY(0.0f);
        r13.setTranslationX(r14 - r0[0]);
        r13.setTranslationY(r15 - r0[1]);
        r13.setAlpha(1.0f);
        b0.e(r13);
    L24:
        boolean r3 = r2 instanceof ViewGroup;
        if (r3 == true) goto L27;
        View r7 = null;
    L28:
        ViewGroup r8 = (ViewGroup) r7;
        if (r8 == null) goto L31;
        r8.addView(r12, 0);
    L31:
        if (r3 == true) goto L33;
        r2 = null;
    L33:
        ViewGroup r5 = (ViewGroup) r2;
        if (r5 == null) goto L36;
        r5.addView(r13, 1);
    L36:
        ViewTreeObserver r9 = r4.getViewTreeObserver();
        if (r9 == null) goto L40;
        r9.addOnPreDrawListener(new a(r4, r16, r17, r14, r15, r13, r12));
        return;
    L40:
        return;
    L27:
        r7 = r2;
        goto L28
    L5:
        if (g == null) goto L15;
        if (b <= 0) goto L15;
        if (c <= 0) goto L15;
        if (d <= 0) goto L15;
        if (e <= 0) goto L15;
        r1 = true;
        goto L16
    }
}
