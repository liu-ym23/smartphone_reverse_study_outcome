package com.larus.photopicker.v2.impl.others.scale;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.google.android.material.animation.MatrixEvaluator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import qp9.a0;
import qp9.h;
import qp9.i;
import qp9.j;
import qp9.l;
import qp9.m;
import qp9.q;
import qp9.y;
import qp9.z;
import rp9.c;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000Ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001e*\u00014\b\u0007\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0084\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020:H\u0017J(\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0014J\u0016\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007J\u000e\u0010D\u001a\u00020<2\u0006\u00103\u001a\u00020$J<\u0010E\u001a\u00020<2\b\u0010F\u001a\u0004\u0018\u00010\u000f2\b\u0010G\u001a\u0004\u0018\u00010\u000f2\u0006\u0010H\u001a\u00020\u001d2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NJJ\u0010O\u001a\u00020<2\b\u0010F\u001a\u0004\u0018\u00010\u000f2\b\u0010G\u001a\u0004\u0018\u00010\u000f2\u0006\u0010H\u001a\u00020\u001d2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020<0QJ \u0010R\u001a\u00020\u00112\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH\u0014J \u0010Z\u001a\u00020<2\u0006\u0010[\u001a\u00020:2\u0006\u0010\\\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020\u001dH\u0002J\u0018\u0010^\u001a\u00020<2\u0006\u0010\\\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020\u001dH\u0002J \u0010_\u001a\u00020<2\u0006\u0010`\u001a\u00020\u001d2\u0006\u0010a\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020\u001dH\u0002J\b\u0010c\u001a\u00020<H\u0002J\b\u0010d\u001a\u00020<H\u0002J\b\u0010e\u001a\u00020<H\u0002J\u001e\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010g2\u0006\u0010h\u001a\u00020\rH\u0002J$\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0g2\u0006\u0010a\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020\u001dH\u0002J\u0018\u0010l\u001a\u00020<2\u0006\u0010m\u001a\u00020\u001d2\u0006\u0010n\u001a\u00020\u001dH\u0002J\b\u0010o\u001a\u00020<H\u0016J\u0018\u0010p\u001a\u00020<2\u0006\u0010a\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020\u001dH\u0002J\b\u0010q\u001a\u00020<H\u0002J\u0018\u0010r\u001a\u00020\u00162\u0006\u0010s\u001a\u00020\u000b2\u0006\u0010t\u001a\u00020\u000bH\u0002J\u0010\u0010u\u001a\u00020\u00162\u0006\u0010v\u001a\u00020\u001dH\u0002J\b\u0010w\u001a\u00020<H\u0002J\b\u0010x\u001a\u00020\u0011H\u0002J \u0010y\u001a\u00020<2\u0006\u0010z\u001a\u00020\u001d2\u0006\u0010a\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020\u001dH\u0002J\u0018\u0010{\u001a\u00020<2\u0006\u0010|\u001a\u00020\u001d2\u0006\u0010}\u001a\u00020\u001dH\u0002J\b\u0010~\u001a\u00020\rH\u0002J\u001a\u0010\u007f\u001a\u00020<2\u0007\u0010\u0080\u0001\u001a\u00020\u001d2\u0007\u0010\u0081\u0001\u001a\u00020\u001dH\u0002J\u0007\u0010\u0082\u0001\u001a\u00020<J\u0010\u0010\u0083\u0001\u001a\u00020<2\u0007\u0010\u0083\u0001\u001a\u00020\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u001a\u00100\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0085\u0001"}, d2 = {"Lcom/larus/photopicker/v2/impl/others/scale/ScaleGestureLayout;", "Lcom/larus/photopicker/v2/impl/others/scale/ClipFrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "displayMatrix", "Landroid/graphics/Matrix;", "displayRectF", "Landroid/graphics/RectF;", "videoRect", "Landroid/graphics/Rect;", "scaleEndExecute", "", "scroller", "Landroid/widget/OverScroller;", "scrollByMultiPoint", "autoFitAnimator", "Landroid/animation/Animator;", "springBackAnimator", "appearOrDisAppearAnimator", "Landroid/animation/AnimatorSet;", "animationRunnable", "Ljava/lang/Runnable;", "totalDragDistanceY", "", "totalDragDistanceX", "currentAlpha", "curScaleFactor", "fastOutSlowInInterpolator", "Landroidx/interpolator/view/animation/FastOutSlowInInterpolator;", "scaleGestureLayoutListener", "Lcom/larus/photopicker/v2/impl/others/scale/ScaleGestureLayoutListener;", "matrixEvaluator", "Lcom/google/android/material/animation/MatrixEvaluator;", "isExit", "minScaleValue", "getMinScaleValue", "()F", "setMinScaleValue", "(F)V", "maxScaleValue", "getMaxScaleValue", "setMaxScaleValue", "doubleClickScaleValue", "getDoubleClickScaleValue", "setDoubleClickScaleValue", "listener", "com/larus/photopicker/v2/impl/others/scale/ScaleGestureLayout$listener$1", "Lcom/larus/photopicker/v2/impl/others/scale/ScaleGestureLayout$listener$1;", "gestureDetector", "Lcom/larus/photopicker/v2/impl/others/scale/CombinationGestureDetector;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "setVideoSize", "videoWidth", "videoHeight", "setZoomListener", "animateAppear", "fromRect", "visibleRect", "radius", "maskInsetPixel", "", "listItemScaleType", "Lcom/larus/photopicker/v2/impl/others/ListItemScaleType;", "animationConfiguration", "Lcom/larus/photopicker/v2/impl/others/scale/AppearOrDisappearAnimationConfiguration;", "animateDisappear", "endAction", "Lkotlin/Function0;", "drawChildContent", "canvas", "Landroid/graphics/Canvas;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "drawingTime", "", "isDragging", "zoomOutIfNeeded", "motionEvent", "distanceX", "distanceY", "moveIfNeeded", "scaleIfNeeded", "scaleFactor", "focusX", "focusY", "restoreFromMoveEnd", "restoreFromScaleEnd", "autoFitForScale", "calculateAutoFitValue", "Lkotlin/Pair;", "displayRect", "calculateFocusPoint", "previousScrollX", "previousScrollY", "flingIfNeeded", "velocityX", "velocityY", "computeScroll", "doubleTapIfNeed", "executePendingAppearAnimation", "createMatrixAnimator", "fromMatrix", "toMatrix", "createAlphaAnimator", "resultValue", "resetGestureDetectorState", "isAnimationAppearRunning", "scaleMatrix", "scaleValue", "translateBy", "deltaX", "deltaY", "getCurrentDisPlayRectF", "calculateDisplayArea", "viewWidth", "viewHeight", BasicTestActionHandler.TEST_ACTION_RESET, "enableScale", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScaleGestureLayout extends ClipFrameLayout {
    public static final /* synthetic */ int M = 0;
    public float A;
    public final FastOutSlowInInterpolator B;
    public a0 C;
    public final MatrixEvaluator D;
    public boolean E;
    public float F;
    public float G;
    public float H;
    public final h I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f364569J;
    public int K;
    public int L;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Matrix f364570n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RectF f364571o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Rect f364572p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f364573q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final OverScroller f364574r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f364575s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Animator f364576t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Animator f364577u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AnimatorSet f364578v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public q f364579w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f364580x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f364581y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f364582z;

    public static final class a {
    }

    public static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScaleGestureLayout f364583a;

        @Override // qp9.i
        public final void onLongPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        public b(ScaleGestureLayout r100) {
            this.f364583a = r100;
        }

        @Override // qp9.i
        public final void a(c r100) {
            Intrinsics.checkNotNullParameter(r100, "detector");
            ScaleGestureLayout r101 = this.f364583a;
            if (r101.f364573q == false) goto L7;
            r101.f364573q = false;
            return;
        L7:
            if (r101.A > 1.0f) goto L30;
            float r102 = r101.f364580x;
            if (r102 > 0.0f) goto L12;
        L19:
            Animator r103 = r101.f364577u;
            if (r103 != null) goto L22;
        L24:
            boolean r104 = false;
        L25:
            if (r104 == true) goto L31;
            Animator r105 = r101.j(new Matrix(r101.f364570n), new Matrix());
            r105.addListener(new y(r101));
            AnimatorSet r106 = new AnimatorSet();
            r106.playTogether(new Animator[]{r105, r101.i(1.0f)});
            r106.start();
            r101.f364577u = r106;
            return;
        L31:
            return;
        L22:
            if (r103.isRunning() != true) goto L24;
            r104 = true;
            goto L25
        L12:
            if (Math.abs(r102) <= (r101.getHeight() * 0.2f)) goto L19;
            if (r101.E == true) goto L18;
            r101.E = true;
            a0 r107 = r101.C;
            if (r107 == null) goto L18;
            r107.onExit();
        L18:
            r101.l();
            return;
        }

        @Override // qp9.i
        public final void b(j r100) {
            Intrinsics.checkNotNullParameter(r100, "detector");
            ScaleGestureLayout r101 = this.f364583a;
            r101.f364573q = true;
            a0 r102 = r101.C;
            if (r102 == null) goto L5;
            r102.b();
        L5:
            ScaleGestureLayout.f(this.f364583a);
        }

        @Override // qp9.i
        public final boolean c(j r100) {
            Intrinsics.checkNotNullParameter(r100, "detector");
            boolean r101 = true;
            this.f364583a.getParent().requestDisallowInterceptTouchEvent(true);
            ScaleGestureLayout r102 = this.f364583a;
            if (r102.A >= 1.0f) goto L5;
        L7:
            r101 = false;
        L8:
            if (r101 == false) goto L12;
            a0 r103 = r102.C;
            if (r103 == null) goto L12;
            r103.a();
        L12:
            return r101;
        L5:
            if (r102.f364569J == true) goto L7;
            goto L7
        }

        @Override // qp9.i
        public final boolean d(j r100) {
            Intrinsics.checkNotNullParameter(r100, "detector");
            boolean r101 = false;
            if (r100.f534410n != (-1.0f)) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L8;
        L20:
            float r103 = r100.f534410n;
            float r104 = r100.f534402f;
            float r105 = r100.f534403g;
            if (Float.isNaN(r103) == false) goto L23;
        L38:
            return false;
        L23:
            if (Float.isInfinite(r103) == true) goto L38;
            ScaleGestureLayout r106 = this.f364583a;
            int r107 = ScaleGestureLayout.M;
            r106.getClass();
            if (r103 != 1.0f) goto L28;
            r101 = true;
        L28:
            if (r101 == true) goto L37;
            int r108 = sp9.c.f542914a;
            float r109 = sp9.c.a(r106.f364570n);
            if (r103 >= 1.0f) goto L34;
            r103 = Math.max(r106.F / r109, r103);
        L36:
            Pair<Float, Float> r110 = r106.h(r104, r105);
            r106.f364570n.postScale(r103, r103, r110.getFirst().floatValue(), r110.getSecond().floatValue());
            r106.A = sp9.c.a(r106.f364570n);
            r106.invalidate();
            goto L37
        L34:
            if (r103 <= 1.0f) goto L36;
            r103 = Math.min(r106.G / r109, r103);
        L37:
            return true;
        L8:
            if (r100.f534408l != (-1.0f)) goto L10;
            boolean r111 = true;
        L11:
            if (r111 == false) goto L13;
            float r112 = r100.f534406j;
            float r113 = r100.f534407k;
            r100.f534408l = (float) Math.sqrt((r112 * r112) + (r113 * r113));
        L13:
            float r114 = r100.f534408l;
            if (r100.f534409m != (-1.0f)) goto L16;
            boolean r115 = true;
        L17:
            if (r115 == false) goto L19;
            float r116 = r100.f534404h;
            float r117 = r100.f534405i;
            r100.f534409m = (float) Math.sqrt((r116 * r116) + (r117 * r117));
        L19:
            r100.f534410n = r114 / r100.f534409m;
            goto L20
        L16:
            r115 = false;
            goto L17
        L10:
            r111 = false;
            goto L11
        L5:
            r102 = false;
            goto L6
        }

        @Override // qp9.i
        public final void onDoubleTap(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            ScaleGestureLayout r101 = this.f364583a;
            float r102 = r100.getX();
            float r103 = r100.getY();
            AnimatorSet r104 = r101.f364578v;
            boolean r105 = false;
            if (r104 != null) goto L5;
        L7:
            boolean r106 = false;
        L8:
            if (r106 == true) goto L38;
            Animator r107 = r101.f364576t;
            if (r107 != null) goto L12;
        L14:
            boolean r108 = false;
        L15:
            if (r108 == true) goto L39;
            Animator r109 = r101.f364577u;
            if (r109 != null) goto L20;
        L22:
            if (r105 == false) goto L26;
            Animator r110 = r101.f364577u;
            if (r110 == null) goto L26;
            r110.cancel();
        L26:
            int r111 = sp9.b.f542913a;
            if (sp9.b.c(r101.A, r101.H) == false) goto L29;
            Matrix r112 = new Matrix();
        L36:
            Animator r113 = r101.j(new Matrix(r101.f364570n), r112);
            r113.start();
            r101.f364577u = r113;
            return;
        L29:
            float r114 = r101.A;
            float r115 = r101.H;
            if ((r114 * r115) <= r115) goto L32;
            r115 = r115 / r114;
        L32:
            Matrix r116 = new Matrix(r101.f364570n);
            Pair<Float, Float> r117 = r101.h(r102, r103);
            r116.postScale(r115, r115, r117.getFirst().floatValue(), r117.getSecond().floatValue());
            RectF r118 = new RectF(r101.f364571o);
            r116.mapRect(r118);
            Pair<Float, Float> r119 = r101.g(r118);
            if (r119 == null) goto L35;
            r116.postTranslate(r119.getFirst().floatValue(), r119.getSecond().floatValue());
        L35:
            r112 = r116;
            goto L36
        L20:
            if (r109.isRunning() != true) goto L22;
            r105 = true;
            goto L22
        L39:
            return;
        L12:
            if (r107.isRunning() != true) goto L14;
            r108 = true;
            goto L15
        L38:
            return;
        L5:
            if (r104.isRunning() != true) goto L7;
            r106 = true;
            goto L8
        }

        @Override // qp9.i
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            if (r100.getPointerCount() <= 2) goto L5;
            this.f364583a.getParent().requestDisallowInterceptTouchEvent(true);
        L5:
            AnimatorSet r101 = this.f364583a.f364578v;
            if (r101 != null) goto L8;
        L10:
            boolean r102 = false;
        L11:
            if (r102 == false) goto L13;
            return false;
        L13:
            ScaleGestureLayout r103 = this.f364583a;
            if (r103.A <= 1.0f) goto L16;
            r103.getParent().requestDisallowInterceptTouchEvent(true);
        L16:
            this.f364583a.f364574r.forceFinished(true);
            return true;
        L8:
            if (r101.isRunning() != true) goto L10;
            r102 = true;
            goto L11
        }

        @Override // qp9.i
        public final void onSingleTapConfirmed(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            a0 r101 = this.f364583a.C;
            if (r101 == null) goto L6;
            r101.onClick();
            return;
        }

        @Override // qp9.i
        public final void onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r100, "e1");
            Intrinsics.checkNotNullParameter(r101, "e2");
            ScaleGestureLayout.d(this.f364583a, r102, r103);
        }

        @Override // qp9.i
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r110, float r111) {
            Intrinsics.checkNotNullParameter(r100, "e1");
            Intrinsics.checkNotNullParameter(r101, "e2");
            boolean r102 = false;
            if (this.f364583a.f364573q == false) goto L6;
            return false;
        L6:
            if (r101.getPointerCount() < 3) goto L8;
            return false;
        L8:
            ScaleGestureLayout r103 = this.f364583a;
            if (r101.getPointerCount() <= 1) goto L11;
            boolean r104 = true;
        L12:
            r103.f364575s = r104;
            ScaleGestureLayout r105 = this.f364583a;
            if (r105.f364575s == false) goto L15;
            r105.m(-r110, -r111);
        L33:
            return true;
        L15:
            float r106 = r105.A;
            if (r106 <= 1.0f) goto L19;
            ScaleGestureLayout.e(r105, -r110, -r111);
            goto L33
        L19:
            if (r106 != 1.0f) goto L21;
            r102 = true;
        L21:
            if (r102 == false) goto L33;
            float r112 = -r110;
            float r113 = -r111;
            float r107 = r105.f364581y + r112;
            r105.f364581y = r107;
            float r108 = r105.f364580x + r113;
            r105.f364580x = r108;
            if (r105.f364569J == true) goto L28;
            if (r108 <= Math.abs(r107)) goto L28;
            r105.f364569J = true;
            r105.getParent().requestDisallowInterceptTouchEvent(true);
        L28:
            if (r105.f364569J == false) goto L33;
            int r109 = sp9.c.f542914a;
            RectF r114 = new RectF(0.0f, 0.0f, r105.getWidth(), r105.getHeight());
            float r115 = r105.f364580x;
            Intrinsics.checkNotNullParameter(r114, "viewRect");
            float r116 = 1.0f - Math.min(1.0f, Math.abs(r115) / (r114.height() * 1.0f));
            r105.f364582z = r116;
            a0 r117 = r105.C;
            if (r117 == null) goto L32;
            r117.c(r116);
        L32:
            RectF r118 = new RectF(0.0f, 0.0f, r105.getWidth(), r105.getHeight());
            float r119 = r105.f364580x;
            Intrinsics.checkNotNullParameter(r118, "viewRect");
            float r120 = ((Math.min(1.0f, Math.abs(r119) / (r118.height() * 1.0f)) * (-0.5f)) + 1.0f) / sp9.c.a(r105.f364570n);
            Matrix r121 = r105.f364570n;
            r121.postTranslate(r112, r113);
            r121.postScale(r120, r120, r101.getX(), r101.getY());
            r105.invalidate();
            goto L33
        L11:
            r104 = false;
            goto L12
        }
    }

    static {
    }

    public ScaleGestureLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ScaleGestureLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static /* synthetic */ void c(ScaleGestureLayout r100) {
        setVideoSize$lambda$0(r100);
    }

    public final void l() {
        this.f364581y = 0.0f;
        this.f364580x = 0.0f;
        this.A = 1.0f;
        this.f364582z = 1.0f;
        this.f364575s = false;
        this.f364569J = false;
        ViewParent r100 = getParent();
        if (r100 == null) goto L6;
        r100.requestDisallowInterceptTouchEvent(false);
        return;
    }

    private final RectF getCurrentDisPlayRectF() {
        RectF r100 = new RectF(this.f364571o);
        this.f364570n.mapRect(r100);
        return r100;
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f364574r.computeScrollOffset() == false) goto L6;
        int r100 = this.K;
        int r101 = this.L;
        int r102 = this.f364574r.getCurrX();
        int r103 = this.f364574r.getCurrY();
        this.K = r102;
        this.L = r103;
        m(r102 - r100, r103 - r101);
        return;
    }

    public final void k() {
        this.f364570n.reset();
        Animator r100 = this.f364576t;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f364576t = null;
        AnimatorSet r101 = this.f364578v;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f364578v = null;
        Animator r102 = this.f364577u;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        this.f364577u = null;
        this.f364579w = null;
        l();
        invalidate();
    }

    public final float getDoubleClickScaleValue() {
        return this.H;
    }

    public final float getMaxScaleValue() {
        return this.G;
    }

    public final float getMinScaleValue() {
        return this.F;
    }

    public static final void f(ScaleGestureLayout r100) {
        boolean r101 = false;
        if (r100.A < 1.0f) goto L25;
        Animator r102 = r100.f364576t;
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L34;
        Animator r104 = r100.f364577u;
        if (r104 != null) goto L14;
    L16:
        if (r101 == false) goto L19;
        return;
    L19:
        if (r100.f364574r.isFinished() == false) goto L37;
        Pair<Float, Float> r105 = r100.g(r100.getCurrentDisPlayRectF());
        if (r105 == null) goto L38;
        Matrix r106 = new Matrix(r100.f364570n);
        r106.postTranslate(r105.getFirst().floatValue(), r105.getSecond().floatValue());
        Animator r107 = r100.j(new Matrix(r100.f364570n), r106);
        r107.start();
        r100.f364576t = r107;
        return;
    L38:
        return;
    L37:
        return;
    L14:
        if (r104.isRunning() != true) goto L16;
        r101 = true;
        goto L16
    L34:
        return;
    L7:
        if (r102.isRunning() != true) goto L9;
        r103 = true;
        goto L10
    L25:
        Animator r108 = r100.f364577u;
        if (r108 != null) goto L28;
    L30:
        if (r101 == true) goto L39;
        Animator r109 = r100.j(r100.f364570n, new Matrix());
        r109.addListener(new z(r100));
        r109.start();
        r100.f364577u = r109;
        return;
    L39:
        return;
    L28:
        if (r108.isRunning() != true) goto L30;
        r101 = true;
        goto L30
    }

    private static final void setVideoSize$lambda$0(ScaleGestureLayout r100) {
        float r101 = r100.getWidth();
        float r102 = r100.getHeight();
        Rect r103 = r100.f364572p;
        if (r103 == null) goto L16;
        float r104 = r103.width();
        Rect r105 = r100.f364572p;
        if (r105 == null) goto L17;
        float r106 = r105.height();
        float r107 = r104 / r106;
        float r108 = r101 / r102;
        float r109 = 0.0f;
        if (r107 <= r108) goto L10;
        float r110 = (r106 * r101) / r104;
        float r111 = (r102 - r110) / 2;
        float r112 = r110 + r111;
    L14:
        r100.f364571o = new RectF(r109, r111, r101, r112);
        return;
    L10:
        if (r107 >= r108) goto L12;
        float r113 = r100.getHeight();
        float r114 = (r104 * r102) / r106;
        float r115 = (r101 - r114) / 2;
        float r116 = r115 + r114;
    L13:
        r109 = r115;
        r101 = r116;
        r112 = r113;
        r111 = 0.0f;
        goto L14
    L12:
        r113 = r102;
        r116 = r101;
        r115 = 0.0f;
        goto L13
    L17:
        return;
    }

    public final Pair<Float, Float> g(RectF r100) {
        int r101 = sp9.b.f542913a;
        float r102 = 0.0f;
        if (sp9.b.e(r100.left, 0.0f) == false) goto L13;
        if (sp9.b.e(r100.top, 0.0f) == false) goto L13;
        if (sp9.b.c(r100.right, getWidth()) == false) goto L13;
        if (sp9.b.c(r100.bottom, getHeight()) == false) goto L13;
        return null;
    L13:
        if (r100.width() >= getWidth()) goto L16;
        float r103 = getWidth() / 2;
        float r104 = r100.centerX();
    L25:
        float r105 = r103 - r104;
    L28:
        if (r100.height() >= getHeight()) goto L31;
        float r106 = getHeight() / 2;
        float r107 = r100.centerY();
    L40:
        r102 = r106 - r107;
    L42:
        return new Pair(Float.valueOf(r105), Float.valueOf(r102));
    L31:
        if (sp9.b.b(r100.top, 0.0f) == false) goto L36;
        if (sp9.b.b(r100.bottom, getHeight()) == false) goto L36;
        r102 = -r100.top;
    L36:
        if (sp9.b.d(r100.top, 0.0f) == false) goto L42;
        if (sp9.b.d(r100.bottom, getHeight()) == false) goto L42;
        r106 = getHeight();
        r107 = r100.bottom;
        goto L40
    L16:
        if (sp9.b.b(r100.left, 0.0f) == false) goto L21;
        if (sp9.b.b(r100.right, getWidth()) == false) goto L21;
        r105 = -r100.left;
    L21:
        if (sp9.b.d(r100.left, 0.0f) == true) goto L23;
    L26:
        r105 = 0.0f;
        goto L28
    L23:
        if (sp9.b.e(r100.right, getWidth()) == false) goto L26;
        r103 = getWidth();
        r104 = r100.right;
        goto L25
    }

    public final Animator i(float r100) {
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{this.f364582z, r100});
        r101.addUpdateListener(new m(this));
        return r101;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        boolean r100 = false;
        if (getChildCount() != 0) goto L5;
        return false;
    L5:
        h r101 = this.I;
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r110, "motionEvent");
        if (r101.f534393b == false) goto L79;
        j r102 = r101.f534395d;
        r102.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r110, "event");
        if (r110.getActionMasked() != 0) goto L11;
        r102.b();
    L11:
        if (r102.f534413q == false) goto L14;
    L77:
        r101.f534396e.a(r110);
        r101.f534394c.onTouchEvent(r110);
    L81:
        return true;
    L14:
        if (r102.f534398b == false) goto L62;
        int r103 = r110.getActionMasked();
        if (r103 != 1) goto L18;
        r102.b();
        goto L77
    L18:
        if (r103 != 2) goto L20;
        r102.c(this, r110);
        if ((r102.f534411o / r102.f534412p) <= 0.67f) goto L77;
        if (r102.f534397a.a(this, r102) == false) goto L77;
        MotionEvent r104 = r102.f534399c;
        Intrinsics.checkNotNull(r104);
        r104.recycle();
        r102.f534399c = MotionEvent.obtain(r110);
        goto L77
    L20:
        if (r103 == 3) goto L55;
        if (r103 != 5) goto L23;
        r102.f534397a.c(this, r102);
        int r105 = r102.f534414r;
        int r106 = r102.f534415s;
        r102.b();
        r102.f534399c = MotionEvent.obtain(r110);
        if (r102.f534416t == true) goto L49;
        r105 = r106;
    L49:
        r102.f534414r = r105;
        r102.f534415s = r110.getPointerId(r110.getActionIndex());
        r102.f534416t = false;
        if (r110.findPointerIndex(r102.f534414r) >= 0) goto L52;
    L53:
        r102.f534414r = r110.getPointerId(j.a(r110, r102.f534415s, -1));
    L54:
        r102.c(this, r110);
        r102.f534398b = r102.f534397a.b(this, r102);
        goto L77
    L52:
        if (r102.f534414r != r102.f534415s) goto L54;
    L23:
        if (r103 != 6) goto L77;
        int r107 = r110.getPointerCount();
        int r108 = r110.getActionIndex();
        int r109 = r110.getPointerId(r108);
        if (r107 <= 2) goto L39;
        int r111 = r102.f534414r;
        if (r109 != r111) goto L33;
        int r112 = j.a(r110, r102.f534415s, r108);
        if (r112 < 0) goto L37;
        r102.f534397a.c(this, r102);
        r102.f534414r = r110.getPointerId(r112);
        r102.f534416t = true;
        r102.f534399c = MotionEvent.obtain(r110);
        r102.c(this, r110);
        r102.f534398b = r102.f534397a.b(this, r102);
    L38:
        MotionEvent r113 = r102.f534399c;
        Intrinsics.checkNotNull(r113);
        r113.recycle();
        r102.f534399c = MotionEvent.obtain(r110);
        r102.c(this, r110);
    L40:
        if (r100 == false) goto L77;
        r102.c(this, r110);
        int r114 = r102.f534414r;
        if (r109 != r114) goto L44;
        r114 = r102.f534415s;
    L44:
        int r115 = r110.findPointerIndex(r114);
        r102.f534402f = r110.getX(r115);
        r102.f534403g = r110.getY(r115);
        r102.f534397a.c(this, r102);
        r102.b();
        r102.f534414r = r114;
        r102.f534416t = true;
    L37:
        r100 = true;
        goto L38
    L33:
        if (r109 != r102.f534415s) goto L38;
        int r116 = j.a(r110, r111, r108);
        if (r116 < 0) goto L37;
        r102.f534397a.c(this, r102);
        r102.f534415s = r110.getPointerId(r116);
        r102.f534416t = false;
        r102.f534399c = MotionEvent.obtain(r110);
        r102.c(this, r110);
        r102.f534398b = r102.f534397a.b(this, r102);
        goto L38
    L39:
        r100 = true;
        goto L40
    L55:
        r102.f534397a.c(this, r102);
        r102.b();
        goto L77
    L62:
        int r117 = r110.getActionMasked();
        if (r117 == 0) goto L76;
        if (r117 == 1) goto L75;
        if (r117 != 5) goto L77;
        MotionEvent r118 = r102.f534399c;
        if (r118 == null) goto L70;
        Intrinsics.checkNotNull(r118);
        r118.recycle();
    L70:
        r102.f534399c = MotionEvent.obtain(r110);
        int r119 = r110.getActionIndex();
        int r120 = r110.findPointerIndex(r102.f534414r);
        int r121 = r110.getPointerId(r119);
        r102.f534415s = r121;
        if (r120 < 0) goto L73;
        if (r120 == r119) goto L73;
    L74:
        r102.f534416t = false;
        r102.c(this, r110);
        r102.f534398b = r102.f534397a.b(this, r102);
    L73:
        r102.f534414r = r110.getPointerId(j.a(r110, r121, -1));
        goto L74
    L75:
        r102.b();
        goto L77
    L76:
        r102.f534414r = r110.getPointerId(0);
        r102.f534416t = true;
        goto L77
    L79:
        if (r110.getPointerCount() != 1) goto L81;
        r101.f534396e.a(r110);
        r101.f534394c.onTouchEvent(r110);
        goto L81
    }

    public final void setDoubleClickScaleValue(float r100) {
        this.H = r100;
    }

    public final void setMaxScaleValue(float r100) {
        this.G = r100;
    }

    public final void setMinScaleValue(float r100) {
        this.F = r100;
    }

    public final void setZoomListener(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.C = r100;
    }

    public final Pair<Float, Float> h(float r100, float r101) {
        RectF r102 = getCurrentDisPlayRectF();
        int r103 = sp9.b.f542913a;
        if (sp9.b.d(r100, r102.left) == false) goto L6;
        r100 = r102.left;
    L9:
        if (sp9.b.d(r101, r102.top) == false) goto L12;
        r101 = r102.top;
    L15:
        return new Pair(Float.valueOf(r100), Float.valueOf(r101));
    L12:
        if (sp9.b.b(r101, r102.bottom) == false) goto L15;
        r101 = r102.bottom;
        goto L15
    L6:
        if (sp9.b.b(r100, r102.right) == false) goto L9;
        r100 = r102.right;
        goto L9
    }

    public final Animator j(Matrix r100, Matrix r101) {
        ValueAnimator r102 = ValueAnimator.ofObject(this.D, new Object[]{r100, r101});
        r102.addUpdateListener(new l(this));
        r102.setInterpolator(this.B);
        return r102;
    }

    public final void m(float r100, float r101) {
        if (sp9.b.a(r100, 0.0f) == true) goto L5;
    L7:
        this.f364570n.postTranslate(r100, r101);
        invalidate();
        return;
    L5:
        if (sp9.b.a(r101, 0.0f) == false) goto L7;
    }

    public ScaleGestureLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f364570n = new Matrix();
        this.f364574r = new OverScroller(r100);
        this.f364582z = 1.0f;
        this.A = 1.0f;
        this.B = new FastOutSlowInInterpolator();
        this.D = new MatrixEvaluator();
        this.F = 0.7f;
        this.G = 10.0f;
        this.H = 3.0f;
        this.I = new h(r100, new b(this));
    }

    public static final void d(ScaleGestureLayout r210, float r211, float r212) {
        Animator r100 = r210.f364576t;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L63;
        Animator r103 = r210.f364577u;
        if (r103 != null) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == true) goto L64;
        AnimatorSet r105 = r210.f364578v;
        if (r105 != null) goto L19;
    L21:
        boolean r106 = false;
    L22:
        if (r106 == true) goto L65;
        RectF r107 = r210.getCurrentDisPlayRectF();
        if (r107.width() < r210.getWidth()) goto L27;
    L29:
        float r108 = -Math.max(r107.right - r210.getWidth(), 0.0f);
        float r109 = 0;
        float r110 = Math.max(r109 - r107.left, 0.0f);
        float r111 = -Math.max(r107.bottom - r210.getHeight(), 0.0f);
        float r112 = Math.max(r109 - r107.top, 0.0f);
        if (sp9.b.a(r108, 0.0f) == false) goto L39;
        if (sp9.b.a(r110, 0.0f) == false) goto L39;
        if (sp9.b.a(r111, 0.0f) == false) goto L39;
        if (sp9.b.a(r112, 0.0f) == false) goto L39;
        return;
    L39:
        if (r211 <= 0.0f) goto L43;
        if (r110 <= 0.0f) goto L43;
    L46:
        boolean r113 = true;
    L49:
        if (r212 <= 0.0f) goto L53;
        if (r112 <= 0.0f) goto L53;
    L58:
        if (r113 == true) goto L61;
        if (r101 == true) goto L61;
        return;
    L61:
        r210.K = 0;
        r210.L = 0;
        r210.f364574r.fling(0, 0, (int) r211, (int) r212, (int) r108, (int) r110, (int) r111, (int) r112);
        ViewCompat.postInvalidateOnAnimation(r210);
        return;
    L53:
        if (r212 < 0.0f) goto L55;
    L57:
        r101 = false;
        goto L58
    L55:
        if (r111 >= 0.0f) goto L57;
    L43:
        if (r211 < 0.0f) goto L45;
    L47:
        r113 = false;
        goto L49
    L45:
        if (r108 >= 0.0f) goto L47;
    L27:
        if (r107.height() >= r210.getHeight()) goto L29;
        return;
    L65:
        return;
    L19:
        if (r105.isRunning() != true) goto L21;
        r106 = true;
        goto L22
    L64:
        return;
    L12:
        if (r103.isRunning() != true) goto L14;
        r104 = true;
        goto L15
    L63:
        return;
    L5:
        if (r100.isRunning() != true) goto L7;
        r102 = true;
        goto L8
    }

    public static final void e(ScaleGestureLayout r100, float r101, float r102) {
        RectF r103 = r100.getCurrentDisPlayRectF();
        int r104 = sp9.b.f542913a;
        if (sp9.b.c(r103.left, 0.0f) == false) goto L8;
        if (sp9.b.e(r103.right, r100.getWidth()) == false) goto L8;
    L22:
        float r105 = 0.0f;
    L34:
        if (sp9.b.c(r103.top, 0.0f) == false) goto L39;
        if (sp9.b.e(r103.bottom, r100.getHeight()) == false) goto L39;
    L53:
        float r106 = 0.0f;
    L65:
        if (Math.abs(r101) > Math.abs(r102)) goto L67;
    L83:
        r100.m(r105, r106);
        return;
    L67:
        if (sp9.b.a(r105, 0.0f) == false) goto L83;
        boolean r107 = true;
        if (r101 > 0.0f) goto L71;
    L73:
        boolean r108 = false;
    L75:
        if (r101 < 0.0f) goto L77;
    L79:
        r107 = false;
    L80:
        if (r108 == true) goto L82;
        if (r107 == false) goto L83;
    L82:
        r100.getParent().requestDisallowInterceptTouchEvent(false);
        return;
    L77:
        if (sp9.b.e(r103.right, r100.getWidth()) == false) goto L79;
    L71:
        if (sp9.b.c(r103.left, 0.0f) == false) goto L73;
        r108 = true;
    L39:
        if (sp9.b.c(r103.top, 0.0f) == false) goto L47;
        if (sp9.b.b(r103.bottom, r100.getHeight()) == false) goto L47;
        if (r102 >= 0.0f) goto L53;
        float r109 = Math.min(Math.abs(r103.bottom - r100.getHeight()), Math.abs(r102));
    L62:
        r106 = -r109;
    L47:
        if (sp9.b.d(r103.top, 0.0f) == false) goto L55;
        if (sp9.b.e(r103.bottom, r100.getHeight()) == false) goto L55;
        if (r102 < 0.0f) goto L53;
        r106 = Math.min(Math.abs(r103.top), Math.abs(r102));
    L55:
        if (sp9.b.d(r103.top, 0.0f) == true) goto L57;
    L63:
        r106 = r102;
        goto L65
    L57:
        if (sp9.b.b(r103.bottom, r100.getHeight()) == false) goto L63;
        if (r102 < 0.0f) goto L61;
        r106 = Math.min(Math.abs(r103.top), Math.abs(r102));
        goto L65
    L61:
        r109 = Math.min(Math.abs(r103.bottom - r100.getHeight()), Math.abs(r102));
    L8:
        if (sp9.b.c(r103.left, 0.0f) == false) goto L16;
        if (sp9.b.b(r103.right, r100.getWidth()) == false) goto L16;
        if (r101 >= 0.0f) goto L22;
        float r110 = Math.min(Math.abs(r103.right - r100.getWidth()), Math.abs(r101));
    L31:
        r105 = -r110;
    L16:
        if (sp9.b.d(r103.left, 0.0f) == false) goto L24;
        if (sp9.b.e(r103.right, r100.getWidth()) == false) goto L24;
        if (r101 < 0.0f) goto L22;
        r105 = Math.min(Math.abs(r103.left), Math.abs(r101));
    L24:
        if (sp9.b.d(r103.left, 0.0f) == true) goto L26;
    L32:
        r105 = r101;
        goto L34
    L26:
        if (sp9.b.b(r103.right, r100.getWidth()) == false) goto L32;
        if (r101 < 0.0f) goto L30;
        r105 = Math.min(Math.abs(r103.left), Math.abs(r101));
        goto L34
    L30:
        r110 = Math.min(Math.abs(r103.right - r100.getWidth()), Math.abs(r101));
        goto L31
    }

    @Override // com.larus.photopicker.v2.impl.others.scale.ClipFrameLayout
    public final boolean a(Canvas r100, View r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        r100.save();
        r100.concat(this.f364570n);
        boolean r103 = super.a(r100, r101, r102);
        r100.restore();
        return r103;
    }

    public /* synthetic */ ScaleGestureLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.larus.photopicker.v2.impl.others.scale.ClipFrameLayout, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (getWidth() > 0) goto L5;
    L7:
        boolean r104 = false;
    L9:
        if (this.f364572p == null) goto L18;
        if (r104 == true) goto L12;
        return;
    L12:
        if (this.f364570n.isIdentity() == false) goto L20;
        q r105 = this.f364579w;
        if (r105 == null) goto L21;
        this.f364579w = null;
        r105.run();
        return;
    L21:
        return;
    L20:
        return;
    L18:
        return;
    L5:
        if (getHeight() <= 0) goto L7;
        r104 = true;
        goto L9
    }
}
