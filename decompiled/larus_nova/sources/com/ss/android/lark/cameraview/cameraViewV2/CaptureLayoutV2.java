package com.ss.android.lark.cameraview.cameraViewV2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import c0b.c;
import c0b.d;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.camera_export.CameraFG;
import com.ss.android.lark.cameraview.w;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import d0b.e;
import d0b.f;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 M2\u00020\u0001:\u0002LMB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010'\u001a\u00020(2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010)\u001a\u00020(2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010*\u001a\u00020(2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010+\u001a\u00020(J\u0018\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0014J\b\u0010/\u001a\u00020(H\u0014J\b\u00100\u001a\u00020(H\u0014J\u0006\u00101\u001a\u00020(J\b\u00102\u001a\u00020(H\u0002J\u0006\u00103\u001a\u00020(J\u000e\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\u0007J\u000e\u00106\u001a\u00020(2\u0006\u00107\u001a\u000208J\u0016\u00109\u001a\u00020(2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020(2\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010;\u001a\u00020(J\u0010\u0010<\u001a\u00020(2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010=\u001a\u00020(2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0006\u0010>\u001a\u00020(J.\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020E0D2\b\b\u0002\u0010F\u001a\u00020\u0007H\u0002J\u0010\u0010G\u001a\u00020(2\u0006\u0010H\u001a\u00020EH\u0002J\u0012\u0010I\u001a\u00020@2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0018\u00010$R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/ss/android/lark/cameraview/cameraViewV2/CaptureLayoutV2;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dp80", "dp100", "dp20", "dp64", "captureListener", "Lcom/ss/android/lark/cameraview/listener/CaptureListener;", "typeListener", "Lcom/ss/android/lark/cameraview/listener/TypeListener;", "returnListener", "Lcom/ss/android/lark/cameraview/listener/ReturnListener;", "leftClickListener", "Lcom/ss/android/lark/cameraview/listener/ClickListener;", "rightClickListener", "btnCapture", "Lcom/ss/android/lark/cameraview/CaptureButton;", "ivCustomLeft", "Landroid/widget/ImageView;", "ivCustomRight", "customMargin", "layoutWidth", "layoutHeight", "buttonSize", "iconLeft", "iconRight", "customSize", "orientationListener", "Lcom/ss/android/lark/cameraview/cameraViewV2/CaptureLayoutV2$CameraOrientationListener;", "animatorSet", "Landroid/animation/AnimatorSet;", "setTypeListener", "", "setCaptureListener", "setReturnListener", "setCaptureBtnEnabled", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onAttachedToWindow", "onDetachedFromWindow", "startTypeBtnAnimator", "initView", "resetCaptureLayout", "setDuration", "duration", "setButtonMode", "mode", "", "setIconSrc", "setLeftIconSrc", "enableCaptureBtn", "setLeftClickListener", "setRightClickListener", "stopRecordWhenScreenOff", "isHitExpandChildView", "", "childView", "Landroid/view/View;", "touchPair", "Lkotlin/Pair;", "", "expandSize", "rotateFlashAndLens", "angle", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "CameraOrientationListener", "Companion", "cameraview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureLayoutV2 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0b.a f410878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0b.b f410879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0b.b f410880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w f410881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f410882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f410883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f410884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f410885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f410886i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f410887j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f410888k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AnimatorSet f410889l;

    public final class a extends OrientationEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f410890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CaptureLayoutV2 f410891b;

        /* JADX INFO: renamed from: com.ss.android.lark.cameraview.cameraViewV2.CaptureLayoutV2$a$a, reason: collision with other inner class name */
        public static final class RunnableC4776a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CaptureLayoutV2 f410892a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ float f410893b;

            public RunnableC4776a(CaptureLayoutV2 r100, float r101) {
                this.f410892a = r100;
                this.f410893b = r101;
            }

            public final void a() {
                CaptureLayoutV2 r100 = this.f410892a;
                float r101 = this.f410893b;
                if (r100.f410889l.isRunning() == true) goto L20;
                Log.d("CaptureLayoutV2", "[After Return] rotateFlashAndLens: " + r101);
                ImageView r102 = r100.f410883f;
                ImageView r103 = null;
                if (r102 != null) goto L8;
                Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
                r102 = null;
            L8:
                float[] r104 = new float[2];
                ImageView r105 = r100.f410883f;
                if (r105 != null) goto L11;
                Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
                r105 = null;
            L11:
                r104[0] = r105.getRotation();
                r104[1] = r101;
                ObjectAnimator r106 = ObjectAnimator.ofFloat(r102, "rotation", r104);
                ImageView r107 = r100.f410882e;
                if (r107 != null) goto L14;
                Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
                r107 = null;
            L14:
                float[] r110 = new float[2];
                ImageView r111 = r100.f410882e;
                if (r111 != null) goto L17;
                Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
            L18:
                r110[0] = r103.getRotation();
                r110[1] = r101;
                ObjectAnimator r108 = ObjectAnimator.ofFloat(r107, "rotation", r110);
                r100.f410889l.cancel();
                r100.f410889l.playTogether(new Animator[]{r108, r106});
                r100.f410889l.setDuration(200);
                r100.f410889l.start();
                return;
            L17:
                r103 = r111;
                goto L18
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

        @Override // android.view.OrientationEventListener
        public final void onOrientationChanged(int r110) {
            if (r110 != (-1)) goto L5;
            return;
        L5:
            float r100 = 90.0f;
            boolean r101 = true;
            if (CameraFG.getEnableAdaptPadAndFoldable() == false) goto L41;
            Display r102 = this.f410891b.getDisplay();
            if (r102 == null) goto L10;
            Integer r103 = Integer.valueOf(r102.getRotation());
        L12:
            if (r103 != null) goto L15;
        L17:
            if (r103 != null) goto L20;
        L22:
            if (r103 != null) goto L25;
        L27:
            char r104 = 0;
        L28:
            if (r104 == 0) goto L30;
        L29:
            r100 = 0.0f;
        L84:
            if (r100 == this.f410890a) goto L87;
            r101 = false;
        L87:
            if (r101 == false) goto L89;
            return;
        L89:
            this.f410890a = r100;
            CaptureLayoutV2 r105 = this.f410891b;
            r105.post(new RunnableC4776a(r105, r100));
            return;
        L30:
            int r106 = ((r110 % 360) + 360) % 360;
            long r111 = Math.round(((double) r106) / 90.0d) * ((long) 90);
            if (Math.abs(((long) r106) - r111) <= 35) goto L33;
            return;
        L33:
            int r107 = (int) (r111 % ((long) 360));
            if (r107 == 90) goto L39;
            if (r107 == 180) goto L38;
            if (r107 == 270) goto L84;
        L38:
            r100 = 180.0f;
            goto L84
        L39:
            r100 = -90.0f;
            goto L84
        L25:
            if (r103.intValue() != 3) goto L27;
            r104 = 270;
            goto L28
        L20:
            if (r103.intValue() != 2) goto L22;
            r104 = 180;
            goto L28
        L15:
            if (r103.intValue() != 1) goto L17;
            r104 = Matrix.MATRIX_TYPE_ZERO;
            goto L28
        L10:
            r103 = null;
            goto L12
        L41:
            if (80 <= r110) goto L43;
        L45:
            boolean r108 = false;
        L46:
            if (r108 == false) goto L49;
            r100 = -90.0f;
        L81:
            if (r100 <= 360.0f) goto L84;
            return;
        L49:
            if (170 <= r110) goto L51;
        L53:
            boolean r109 = false;
        L54:
            if (r109 == false) goto L57;
        L55:
            r100 = 0.0f;
            goto L81
        L57:
            if (260 <= r110) goto L59;
        L61:
            boolean r112 = false;
        L62:
            if (r112 == true) goto L81;
            if (r110 >= 0) goto L66;
        L68:
            boolean r113 = false;
        L69:
            if (r113 == true) goto L55;
            if (350 <= r110) goto L74;
        L76:
            boolean r114 = false;
        L77:
            if (r114 == true) goto L55;
            r100 = 361.0f;
            goto L81
        L74:
            if (r110 >= 361) goto L76;
            r114 = true;
            goto L77
        L66:
            if (r110 >= 11) goto L68;
            r113 = true;
            goto L69
        L59:
            if (r110 >= 281) goto L61;
            r112 = true;
            goto L62
        L51:
            if (r110 >= 191) goto L53;
            r109 = true;
            goto L54
        L43:
            if (r110 >= 101) goto L45;
            r108 = true;
            goto L46
        }

        public a(CaptureLayoutV2 r100, Context r101) {
            this.f410891b = r100;
            super(r101);
            ImageView r102 = r100.f410882e;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
            r102 = null;
        L5:
            this.f410890a = r102.getRotation();
        }
    }

    public static final class b {
    }

    static {
    }

    public CaptureLayoutV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CaptureLayoutV2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setReturnListener(e r100) {
    }

    public final void setTypeListener(f r100) {
    }

    public final void b() {
        w r100 = this.f410881d;
        ImageView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r100 = null;
    L5:
        r100.f411024a = 1;
        w r102 = this.f410881d;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r102 = null;
    L8:
        r102.setVisibility(0);
        if (this.f410886i == 0) goto L15;
        ImageView r103 = this.f410882e;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r103 = null;
    L13:
        r103.setVisibility(0);
    L15:
        if (this.f410887j == 0) goto L22;
        ImageView r104 = this.f410883f;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
    L20:
        r101.setVisibility(0);
        return;
    L19:
        r101 = r104;
        goto L20
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        a r100 = this.f410888k;
        if (r100 == null) goto L5;
        r100.enable();
    L5:
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        a r100 = this.f410888k;
        if (r100 == null) goto L5;
        r100.disable();
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L26;
        if (r100.getAction() != 0) goto L26;
        ImageView r101 = this.f410882e;
        ImageView r102 = null;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r101 = null;
    L9:
        if (a(this, r101, new Pair(Float.valueOf(r100.getRawX()), Float.valueOf(r100.getRawY()))) == false) goto L15;
        ImageView r103 = this.f410882e;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
    L14:
        r102.performClick();
        goto L26
    L13:
        r102 = r103;
        goto L14
    L15:
        ImageView r104 = this.f410883f;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
        r104 = null;
    L19:
        if (a(this, r104, new Pair(Float.valueOf(r100.getRawX()), Float.valueOf(r100.getRawY()))) == false) goto L26;
        ImageView r105 = this.f410883f;
        if (r105 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
    L24:
        r102.performClick();
        goto L26
    L23:
        r102 = r105;
    L26:
        return super.onTouchEvent(r100);
    }

    public final void setButtonMode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        w r101 = this.f410881d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r101 = null;
    L5:
        r101.setButtonMode(r100);
    }

    public final void setCaptureListener(d0b.a r100) {
        this.f410878a = r100;
    }

    public final void setDuration(int r100) {
        w r101 = this.f410881d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r101 = null;
    L5:
        r101.setDuration(r100);
    }

    public final void setLeftClickListener(d0b.b r100) {
        this.f410879b = r100;
    }

    public final void setLeftIconSrc(int r100) {
        this.f410886i = r100;
        ImageView r101 = null;
        if (r100 == 0) goto L15;
        ImageView r102 = this.f410882e;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r102 = null;
    L7:
        r102.setImageResource(r100);
        ImageView r103 = this.f410882e;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r103 = null;
    L10:
        r103.getDrawable().setTint(UIUtils.getColor(getContext(), R.color.white));
        ImageView r104 = this.f410882e;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
    L14:
        r101.setVisibility(0);
        return;
    L13:
        r101 = r104;
        goto L14
    L15:
        ImageView r105 = this.f410882e;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
    L19:
        r101.setVisibility(4);
        return;
    L18:
        r101 = r105;
        goto L19
    }

    public final void setRightClickListener(d0b.b r100) {
        this.f410880c = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(this.f410884g, this.f410885h);
    }

    public CaptureLayoutV2(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        UIUtils.dp2px(r110, 80.0f);
        int r113 = UIUtils.dp2px(r110, 100.0f);
        int r114 = UIUtils.dp2px(r110, 20.0f);
        int r100 = UIUtils.dp2px(r110, 64.0f);
        int r115 = UIUtils.dp2px(r110, 24.0f);
        this.f410889l = new AnimatorSet();
        this.f410884g = -1;
        this.f410885h = r113;
        setWillNotDraw(false);
        LinearLayout r101 = new LinearLayout(getContext());
        r101.setOrientation(0);
        r101.setLayoutParams(new LinearLayout.LayoutParams(-1, r113));
        r101.setGravity(17);
        w r102 = new w(getContext(), r100);
        this.f410881d = r102;
        int r103 = UIUtils.dp2px(getContext(), 18.0f);
        r102.f411032i = r103;
        r102.f411033j = r100 / 2;
        float r104 = (r102.f411039p + (r103 * 2)) / 2;
        r102.f411034k = r104;
        r102.f411035l = r104;
        float r105 = (r102.f411036m + r103) - (r102.f411031h / 2);
        float r106 = r102.f411034k;
        float r107 = r102.f411035l;
        r102.f411046w = new RectF(r106 - r105, r107 - r105, r106 + r105, r107 + r105);
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-1, -1);
        r108.gravity = 17;
        w r116 = this.f410881d;
        ImageView r109 = null;
        if (r116 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r116 = null;
    L5:
        r116.setLayoutParams(r108);
        w r117 = this.f410881d;
        if (r117 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r117 = null;
    L8:
        r117.setCaptureLisenter(new c0b.b(this));
        this.f410882e = new ImageView(getContext());
        FrameLayout.LayoutParams r118 = new FrameLayout.LayoutParams(r115, r115);
        r118.setMargins(0, 0, r114, 0);
        ImageView r119 = this.f410882e;
        if (r119 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r119 = null;
    L11:
        r119.setLayoutParams(r118);
        ImageView r120 = this.f410882e;
        if (r120 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r120 = null;
    L14:
        r120.setOnClickListener(new c(this));
        this.f410883f = new ImageView(getContext());
        FrameLayout.LayoutParams r121 = new FrameLayout.LayoutParams(r115, r115);
        r121.setMargins(r114, 0, 0, 0);
        ImageView r122 = this.f410883f;
        if (r122 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
        r122 = null;
    L17:
        r122.setLayoutParams(r121);
        ImageView r123 = this.f410883f;
        if (r123 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
        r123 = null;
    L20:
        r123.setOnClickListener(new d(this));
        this.f410888k = new a(this, getContext());
        ImageView r124 = this.f410882e;
        if (r124 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r124 = null;
    L23:
        r101.addView(r124);
        w r125 = this.f410881d;
        if (r125 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r125 = null;
    L26:
        r101.addView(r125);
        ImageView r126 = this.f410883f;
        if (r126 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
    L30:
        r101.addView(r109);
        addView(r101);
        return;
    L29:
        r109 = r126;
        goto L30
    }

    public static boolean a(CaptureLayoutV2 r100, View r101, Pair r102) {
        int r103 = UIUtils.dp2px(r100.getContext(), 20.0f);
        r100.getClass();
        int[] r104 = new int[2];
        r101.getLocationOnScreen(r104);
        float r105 = r104[0];
        float r106 = r104[1];
        float r107 = ((Number) r102.getFirst()).floatValue();
        float r108 = ((Number) r102.getSecond()).floatValue();
        RectF r109 = new RectF();
        float r110 = r103;
        r109.set(r105 - r110, r106 - r110, (r105 + r101.getWidth()) + r110, (r106 + r101.getHeight()) + r110);
        return r109.contains(r107, r108);
    }

    public /* synthetic */ CaptureLayoutV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
