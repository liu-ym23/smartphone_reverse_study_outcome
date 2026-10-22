package yk5;

import android.content.res.ColorStateList;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.onboarding.export.ui.FlowStyleHollowShape;
import com.bytedance.ee.bear.onboarding.view.MaskView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends yk5.b {
    public final FragmentActivity k;
    public final TextView l;
    public final TextView m;
    public final View n;
    public final View o;
    public final TextView p;
    public final Button q;
    public final TextView r;
    public final MaskView s;
    public final BearLottieView t;
    public boolean u;
    public uk5.d v;
    public final RectF w;
    public final PointF x;
    public int y;
    public boolean z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowStyleHollowShape.values().length];
            r0[FlowStyleHollowShape.Circle.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[FlowStyleHollowShape.Capsule.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[FlowStyleHollowShape.RoundedRect.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[FlowStyleHollowShape.CustomRadius.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ g a;

        public c(g r1) {
            this.a = r1;
        }

        public final void a() {
            g r0 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r0);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r2 == null) goto L16;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r1.getLooper()) goto L7;
            r1.post(DialogLancet.createDismissRunnable(r0));
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
    }

    static {
    }

    @Override // yk5.b, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        this.t.cancelAnimation();
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // yk5.b, ep5.a, android.app.Dialog
    public final void show() {
        float r0 = this.o.getY() + this.o.getMeasuredHeight();
        if (this.o.getY() >= 0.0f) goto L5;
    L13:
        this.b = false;
        sk5.d.b r1 = this.j;
        if (r1 == null) goto L16;
        ((vk5.b) r1).a();
    L16:
        sk5.d.b r2 = this.j;
        if (r2 == null) goto L20;
        ((vk5.b) r2).c(this.b);
    L20:
        if (this.o.getY() >= 0.0f) goto L22;
        tt5.a.d("FlowOnBoardingDialog", "OnbaordingDialog's top < 0, don't show.");
        return;
    L22:
        tt5.a.d("FlowOnBoardingDialog", "OnbaordingDialog's height[" + r0 + "] > Screen'height[" + cu5.c.c() + "], don't show.");
        return;
    L5:
        if (r0 > cu5.c.c()) goto L13;
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L25;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L25:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L11:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    public static View f(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // yk5.b, android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        if (this.w.contains(r4.getX(), r4.getY()) == false) goto L9;
        if (this.u == false) goto L9;
        this.b = true;
        boolean r5 = this.k.dispatchTouchEvent(r4);
        com.bytedance.ee.util.ui.j.d(new c(this), 500);
        return r5;
    L9:
        return super.dispatchTouchEvent(r4);
    }

    public g(FragmentActivity r2, Window r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "currentActiveWindow");
        super(r2, r3, 2131953437);
        this.k = r2;
        this.w = new RectF();
        this.x = new PointF();
        View r4 = LayoutInflater.from(r2).inflate(2131564120, null);
        this.a = r4;
        this.l = (TextView) r4.findViewById(2131381454);
        this.m = (TextView) this.a.findViewById(2131381447);
        this.n = this.a.findViewById(2131381445);
        this.o = this.a.findViewById(2131381450);
        this.p = (TextView) this.a.findViewById(2131381453);
        this.q = (Button) this.a.findViewById(2131381446);
        this.r = (TextView) this.a.findViewById(2131381449);
        ImageView r5 = (ImageView) this.a.findViewById(2131381448);
        this.t = this.a.findViewById(2131381451);
        MaskView r6 = (MaskView) this.a.findViewById(2131381452);
        this.s = r6;
        r6.setMaskColor(j08.b.b(com.bytedance.ee.util.ui.n.h(getContext(), 2131103451), 0.2f));
    }

    @Override // yk5.b
    public final void e(int r3, int r4, int r5) {
        MaskView r0 = this.s;
        if (this.z == false) goto L5;
        r5 = com.bytedance.ee.util.ui.n.h(getContext(), 2131106784);
    L5:
        r0.setMaskColor(r5);
        this.o.setBackgroundTintList(ColorStateList.valueOf(r3));
        this.n.setBackgroundTintList(ColorStateList.valueOf(r3));
        this.q.setTextColor(r3);
        if (Build.VERSION.SDK_INT < 28) goto L9;
        this.o.setOutlineSpotShadowColor(r4);
        this.o.setOutlineAmbientShadowColor(r4);
        this.n.setOutlineSpotShadowColor(r4);
        this.n.setOutlineAmbientShadowColor(r4);
        this.q.setOutlineSpotShadowColor(r4);
        this.q.setOutlineAmbientShadowColor(r4);
        return;
    }

    public final void g(View r16, FlowStyleHollowShape r17, RectF r18) {
        if (r16 == null) goto L9;
        int[] r1 = new int[2];
        r16.getLocationOnScreen(r1);
        float r4 = r1[0];
        float r5 = r1[1];
        float r6 = r16.getWidth();
        float r7 = r16.getHeight();
        if (r17 != null) goto L7;
        FlowStyleHollowShape r8 = FlowStyleHollowShape.RoundedRect;
    L8:
        h(r4, r5, r6, r7, r8);
        return;
    L7:
        r8 = r17;
        goto L8
    L9:
        if (r18 == null) goto L15;
        float r10 = r18.left;
        float r11 = r18.top;
        float r12 = r18.width();
        float r13 = r18.height();
        if (r17 != null) goto L13;
        FlowStyleHollowShape r14 = FlowStyleHollowShape.RoundedRect;
    L14:
        h(r10, r11, r12, r13, r14);
        return;
    L13:
        r14 = r17;
        goto L14
    L15:
        tt5.a.d("FlowOnBoardingDialog", "No TargetView or targetRect is set!!");
    }

    public final void h(float r19, float r20, float r21, float r22, FlowStyleHollowShape r23) {
        RectF r1 = new RectF();
        View r2 = f(this.k.getWindow());
        int r3 = r2.getMeasuredWidth();
        int r4 = r2.getMeasuredHeight();
        int r5 = com.bytedance.ee.util.ui.k.e(this.k);
        int r6 = this.k.getResources().getDimensionPixelSize(2131168333);
        int r7 = this.k.getResources().getDimensionPixelSize(2131168369);
        int[] r8 = b.a;
        int r9 = r8[r23.ordinal()];
        if (r9 == 1) goto L11;
        if (r9 == 2) goto L9;
        if (r9 == 3) goto L8;
        if (r9 != 4) goto L9;
    L8:
        float r10 = r19 + r21;
        float r11 = r20 + r22;
        float r12 = r19;
        float r14 = r20;
    L16:
        if (r12 >= 0.0f) goto L18;
        r12 = 0.0f;
    L18:
        float r13 = r3;
        if (r10 <= r13) goto L21;
        r10 = r13;
    L21:
        float r15 = r5;
        if (r14 >= r15) goto L24;
        r14 = r15;
    L24:
        float r16 = r4;
        if (r11 <= r16) goto L27;
        r11 = r16;
    L27:
        int r17 = r8[r23.ordinal()];
        if (r17 == 3) goto L32;
        if (r17 == 4) goto L31;
        float r18 = Math.min(r10 - r12, r11 - r14) / 2;
    L33:
        int r24 = (int) r18;
    L34:
        r1.set(r12, r14, r10, r11);
        this.s.setHighlightRectRadius(r24);
        this.s.setHighRect(r1);
        float r25 = r1.left;
        float r26 = r1.top;
        float r27 = r1.right;
        float r28 = r1.bottom;
        RectF r29 = this.w;
        r29.left = r25;
        r29.right = r27;
        r29.top = r26;
        r29.bottom = r28;
        View r30 = f(this.k.getWindow());
        int r31 = r30.getMeasuredWidth();
        int r32 = r30.getMeasuredHeight();
        int r33 = com.bytedance.ee.util.ui.k.e(this.k);
        int r34 = this.k.getResources().getDimensionPixelSize(2131168369);
        int r35 = this.k.getResources().getDimensionPixelSize(2131167883);
        if ((r26 - r33) <= (r32 - r28)) goto L37;
        float r36 = r35;
        float r37 = (r26 - r36) - r34;
        float r38 = ((r36 / 2) + r37) - this.o.getMeasuredHeight();
    L38:
        float r39 = (r25 + r27) / 2;
        float r40 = this.k.getResources().getDimensionPixelSize(2131168315);
        float r41 = r31 - r40;
        float r42 = r35;
        float r43 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r39 - (r35 / 2), r40), r41 - r42);
        float r44 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r39 - (this.o.getMeasuredWidth() / 2), r40), r41 - this.o.getMeasuredWidth()), r43 - com.bytedance.ee.util.ui.n.l(getContext(), 2131168383)), ((com.bytedance.ee.util.ui.n.l(getContext(), 2131168383) + r43) + r42) - this.o.getMeasuredWidth());
        this.n.setX(r43);
        this.n.setY(r37);
        this.o.setX(r44);
        this.o.setY(r38);
        return;
    L37:
        r37 = r34 + r28;
        r38 = (r35 / 2) + r37;
        goto L38
    L31:
        r24 = this.y;
        goto L34
    L32:
        r18 = Math.min(Math.min(r10 - r12, r11 - r14) / 2, r7);
    L9:
        float r45 = r6;
        float r46 = r19 - r45;
        float r110 = r20 - r45;
        r11 = r45 + (r20 + r22);
        r10 = (r19 + r21) + r45;
        r14 = r110;
        r12 = r46;
        goto L16
    L11:
        if (r21 >= r22) goto L13;
        float r47 = r22;
    L14:
        float r48 = r6;
        r12 = r19 - r48;
        r14 = r20 - r48;
        float r111 = (r19 + r47) + r48;
        r11 = (r20 + r47) + r48;
        r10 = r111;
        goto L16
    L13:
        r47 = r21;
        goto L14
    }
}
