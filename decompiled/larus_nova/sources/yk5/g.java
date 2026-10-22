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
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends yk5.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FragmentActivity f568154k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f568155l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f568156m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f568157n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f568158o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextView f568159p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Button f568160q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final TextView f568161r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final MaskView f568162s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final BearLottieView f568163t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f568164u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public uk5.d f568165v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RectF f568166w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final PointF f568167x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f568168y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f568169z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f568170a = null;

        static {
            int[] r100 = new int[FlowStyleHollowShape.values().length];
            r100[FlowStyleHollowShape.Circle.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[FlowStyleHollowShape.Capsule.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[FlowStyleHollowShape.RoundedRect.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[FlowStyleHollowShape.CustomRadius.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f568170a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f568171a;

        public c(g r100) {
            this.f568171a = r100;
        }

        public final void a() {
            g r100 = this.f568171a;
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r102 == null) goto L16;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L7;
            r101.post(DialogLancet.createDismissRunnable(r100));
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
        this.f568163t.cancelAnimation();
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
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
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // yk5.b, ep5.a, android.app.Dialog
    public final void show() {
        float r100 = this.f568158o.getY() + this.f568158o.getMeasuredHeight();
        if (this.f568158o.getY() >= 0.0f) goto L5;
    L13:
        this.f568129b = false;
        sk5.d.b r101 = this.f568137j;
        if (r101 == null) goto L16;
        ((vk5.b) r101).a();
    L16:
        sk5.d.b r102 = this.f568137j;
        if (r102 == null) goto L20;
        ((vk5.b) r102).c(this.f568129b);
    L20:
        if (this.f568158o.getY() >= 0.0f) goto L22;
        tt5.a.d("FlowOnBoardingDialog", "OnbaordingDialog's top < 0, don't show.");
        return;
    L22:
        tt5.a.d("FlowOnBoardingDialog", "OnbaordingDialog's height[" + r100 + "] > Screen'height[" + cu5.c.c() + "], don't show.");
        return;
    L5:
        if (r100 > cu5.c.c()) goto L13;
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

    public static View f(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // yk5.b, android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f568166w.contains(r100.getX(), r100.getY()) == false) goto L9;
        if (this.f568164u == false) goto L9;
        this.f568129b = true;
        boolean r101 = this.f568154k.dispatchTouchEvent(r100);
        com.bytedance.ee.util.ui.j.d(new c(this), 500);
        return r101;
    L9:
        return super.dispatchTouchEvent(r100);
    }

    public g(FragmentActivity r100, Window r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "currentActiveWindow");
        super(r100, r101, R.style.Space_OnBoardingDialog);
        this.f568154k = r100;
        this.f568166w = new RectF();
        this.f568167x = new PointF();
        View r102 = LayoutInflater.from(r100).inflate(R.layout.onboarding_flow_onboarding, null);
        this.f568128a = r102;
        this.f568155l = (TextView) r102.findViewById(R.id.onBoarding_flow_title);
        this.f568156m = (TextView) this.f568128a.findViewById(R.id.onBoarding_flow_hint);
        this.f568157n = this.f568128a.findViewById(R.id.onBoarding_flow_arrow);
        this.f568158o = this.f568128a.findViewById(R.id.onBoarding_flow_layout);
        this.f568159p = (TextView) this.f568128a.findViewById(R.id.onBoarding_flow_skip_btn);
        this.f568160q = (Button) this.f568128a.findViewById(R.id.onBoarding_flow_confirm_btn);
        this.f568161r = (TextView) this.f568128a.findViewById(R.id.onBoarding_flow_index);
        ImageView r103 = (ImageView) this.f568128a.findViewById(R.id.onBoarding_flow_image);
        this.f568163t = (BearLottieView) this.f568128a.findViewById(R.id.onBoarding_flow_lottieView);
        MaskView r104 = (MaskView) this.f568128a.findViewById(R.id.onBoarding_flow_mask);
        this.f568162s = r104;
        r104.setMaskColor(j08.b.b(com.bytedance.ee.util.ui.n.h(getContext(), R.color.lkui_N1000), 0.2f));
    }

    @Override // yk5.b
    public final void e(int r100, int r101, int r102) {
        MaskView r103 = this.f568162s;
        if (this.f568169z == false) goto L5;
        r102 = com.bytedance.ee.util.ui.n.h(getContext(), R.color.transparent);
    L5:
        r103.setMaskColor(r102);
        this.f568158o.setBackgroundTintList(ColorStateList.valueOf(r100));
        this.f568157n.setBackgroundTintList(ColorStateList.valueOf(r100));
        this.f568160q.setTextColor(r100);
        if (Build.VERSION.SDK_INT < 28) goto L9;
        this.f568158o.setOutlineSpotShadowColor(r101);
        this.f568158o.setOutlineAmbientShadowColor(r101);
        this.f568157n.setOutlineSpotShadowColor(r101);
        this.f568157n.setOutlineAmbientShadowColor(r101);
        this.f568160q.setOutlineSpotShadowColor(r101);
        this.f568160q.setOutlineAmbientShadowColor(r101);
        return;
    }

    public final void g(View r110, FlowStyleHollowShape r111, RectF r112) {
        if (r110 == null) goto L9;
        int[] r100 = new int[2];
        r110.getLocationOnScreen(r100);
        float r101 = r100[0];
        float r102 = r100[1];
        float r103 = r110.getWidth();
        float r104 = r110.getHeight();
        if (r111 != null) goto L7;
        FlowStyleHollowShape r105 = FlowStyleHollowShape.RoundedRect;
    L8:
        h(r101, r102, r103, r104, r105);
        return;
    L7:
        r105 = r111;
        goto L8
    L9:
        if (r112 == null) goto L15;
        float r113 = r112.left;
        float r114 = r112.top;
        float r115 = r112.width();
        float r116 = r112.height();
        if (r111 != null) goto L13;
        FlowStyleHollowShape r117 = FlowStyleHollowShape.RoundedRect;
    L14:
        h(r113, r114, r115, r116, r117);
        return;
    L13:
        r117 = r111;
        goto L14
    L15:
        tt5.a.d("FlowOnBoardingDialog", "No TargetView or targetRect is set!!");
    }

    public final void h(float r110, float r210, float r211, float r212, FlowStyleHollowShape r213) {
        RectF r100 = new RectF();
        View r101 = f(this.f568154k.getWindow());
        int r102 = r101.getMeasuredWidth();
        int r103 = r101.getMeasuredHeight();
        int r104 = com.bytedance.ee.util.ui.k.e(this.f568154k);
        int r105 = this.f568154k.getResources().getDimensionPixelSize(R.dimen.space_kit_len_3);
        int r106 = this.f568154k.getResources().getDimensionPixelSize(R.dimen.space_kit_len_8);
        int[] r107 = b.f568170a;
        int r108 = r107[r213.ordinal()];
        if (r108 == 1) goto L11;
        if (r108 == 2) goto L9;
        if (r108 == 3) goto L8;
        if (r108 != 4) goto L9;
    L8:
        float r109 = r110 + r211;
        float r111 = r210 + r212;
        float r112 = r110;
        float r113 = r210;
    L16:
        if (r112 >= 0.0f) goto L18;
        r112 = 0.0f;
    L18:
        float r114 = r102;
        if (r109 <= r114) goto L21;
        r109 = r114;
    L21:
        float r115 = r104;
        if (r113 >= r115) goto L24;
        r113 = r115;
    L24:
        float r116 = r103;
        if (r111 <= r116) goto L27;
        r111 = r116;
    L27:
        int r117 = r107[r213.ordinal()];
        if (r117 == 3) goto L32;
        if (r117 == 4) goto L31;
        float r118 = Math.min(r109 - r112, r111 - r113) / 2;
    L33:
        int r119 = (int) r118;
    L34:
        r100.set(r112, r113, r109, r111);
        this.f568162s.setHighlightRectRadius(r119);
        this.f568162s.setHighRect(r100);
        float r120 = r100.left;
        float r121 = r100.top;
        float r122 = r100.right;
        float r123 = r100.bottom;
        RectF r124 = this.f568166w;
        r124.left = r120;
        r124.right = r122;
        r124.top = r121;
        r124.bottom = r123;
        View r125 = f(this.f568154k.getWindow());
        int r126 = r125.getMeasuredWidth();
        int r127 = r125.getMeasuredHeight();
        int r128 = com.bytedance.ee.util.ui.k.e(this.f568154k);
        int r129 = this.f568154k.getResources().getDimensionPixelSize(R.dimen.space_kit_len_8);
        int r130 = this.f568154k.getResources().getDimensionPixelSize(R.dimen.onBoarding_arrow_width);
        if ((r121 - r128) <= (r127 - r123)) goto L37;
        float r131 = r130;
        float r132 = (r121 - r131) - r129;
        float r133 = ((r131 / 2) + r132) - this.f568158o.getMeasuredHeight();
    L38:
        float r134 = (r120 + r122) / 2;
        float r135 = this.f568154k.getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
        float r136 = r126 - r135;
        float r137 = r130;
        float r138 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r134 - (r130 / 2), r135), r136 - r137);
        float r139 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r134 - (this.f568158o.getMeasuredWidth() / 2), r135), r136 - this.f568158o.getMeasuredWidth()), r138 - com.bytedance.ee.util.ui.n.l(getContext(), R.dimen.space_radius_m)), ((com.bytedance.ee.util.ui.n.l(getContext(), R.dimen.space_radius_m) + r138) + r137) - this.f568158o.getMeasuredWidth());
        this.f568157n.setX(r138);
        this.f568157n.setY(r132);
        this.f568158o.setX(r139);
        this.f568158o.setY(r133);
        return;
    L37:
        r132 = r129 + r123;
        r133 = (r130 / 2) + r132;
        goto L38
    L31:
        r119 = this.f568168y;
        goto L34
    L32:
        r118 = Math.min(Math.min(r109 - r112, r111 - r113) / 2, r106);
    L9:
        float r140 = r105;
        float r141 = r110 - r140;
        float r142 = r210 - r140;
        r111 = r140 + (r210 + r212);
        r109 = (r110 + r211) + r140;
        r113 = r142;
        r112 = r141;
        goto L16
    L11:
        if (r211 >= r212) goto L13;
        float r143 = r212;
    L14:
        float r144 = r105;
        r112 = r110 - r144;
        r113 = r210 - r144;
        float r145 = (r110 + r143) + r144;
        r111 = (r210 + r143) + r144;
        r109 = r145;
        goto L16
    L13:
        r143 = r211;
        goto L14
    }
}
