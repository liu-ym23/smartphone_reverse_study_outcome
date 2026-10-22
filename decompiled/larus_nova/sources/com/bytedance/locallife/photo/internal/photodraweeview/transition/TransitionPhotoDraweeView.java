package com.bytedance.locallife.photo.internal.photodraweeview.transition;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0003\u000bB'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u001a¢\u0006\u0004\b%\u0010&R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lcom/bytedance/locallife/photo/internal/photodraweeview/transition/TransitionPhotoDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/view/GestureDetector$SimpleOnGestureListener;", "getTapListener", "()Landroid/view/GestureDetector$SimpleOnGestureListener;", "setTapListener", "(Landroid/view/GestureDetector$SimpleOnGestureListener;)V", "tapListener", "", "b", FaceService.girlLabel, "getMinScaleFactor", "()F", "setMinScaleFactor", "(F)V", "minScaleFactor", "c", "getMidScaleFactor", "setMidScaleFactor", "midScaleFactor", "d", "getMaxScaleFactor", "setMaxScaleFactor", "maxScaleFactor", "", "q", "Lkotlin/Lazy;", "getTouchSlop", "()I", "touchSlop", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public class TransitionPhotoDraweeView extends SimpleDraweeView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f262041t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f262042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f262043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f262044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f262045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.bytedance.locallife.photo.internal.photodraweeview.transition.a> f262046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.locallife.photo.internal.photodraweeview.transition.a f262047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Matrix f262048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f262049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f262050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f262051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f262052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f262053l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f262054m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f262055n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f262056o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f262057p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f262058q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ScaleGestureDetector f262059r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final GestureDetector f262060s;

    public final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TransitionPhotoDraweeView f262061a;

        public a(TransitionPhotoDraweeView r100) {
            this.f262061a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            TransitionPhotoDraweeView r101 = this.f262061a;
            r101.f262048g.getValues(r101.f262049h);
            TransitionPhotoDraweeView r102 = this.f262061a;
            float r103 = r102.f262049h[0];
            if (r103 >= (r102.getMidScaleFactor() * 0.99f)) goto L6;
            float r104 = this.f262061a.getMidScaleFactor();
        L9:
            TransitionPhotoDraweeView r105 = this.f262061a;
            float r106 = r100.getX();
            float r107 = r100.getY();
            r105.f262048g.getValues(r105.f262049h);
            float r108 = RangesKt.coerceAtLeast(r105.f262049h[0], 0.01f);
            ValueAnimator r109 = ValueAnimator.ofFloat(new float[]{r108, r104});
            r109.setDuration(220);
            r109.setInterpolator(new AccelerateDecelerateInterpolator());
            Ref.FloatRef r110 = new Ref.FloatRef();
            r110.element = r108;
            r109.addUpdateListener(new com.bytedance.locallife.photo.internal.photodraweeview.transition.b(r110, r105, r106, r107));
            r109.start();
            GestureDetector.SimpleOnGestureListener r111 = this.f262061a.getTapListener();
            if (r111 == null) goto L12;
            r111.onDoubleTap(r100);
        L12:
            return true;
        L6:
            if (r103 >= (this.f262061a.getMaxScaleFactor() * 0.99f)) goto L8;
            r104 = this.f262061a.getMaxScaleFactor();
            goto L9
        L8:
            r104 = this.f262061a.getMinScaleFactor();
            goto L9
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            this.f262061a.performLongClick();
            GestureDetector.SimpleOnGestureListener r101 = this.f262061a.getTapListener();
            if (r101 == null) goto L6;
            r101.onLongPress(r100);
            return;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            this.f262061a.performClick();
            GestureDetector.SimpleOnGestureListener r101 = this.f262061a.getTapListener();
            if (r101 == null) goto L5;
            r101.onSingleTapConfirmed(r100);
        L5:
            this.f262061a.k();
            return true;
        }
    }

    public final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TransitionPhotoDraweeView f262062a;

        public b(TransitionPhotoDraweeView r100) {
            this.f262062a = r100;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r100) {
            Intrinsics.checkNotNullParameter(r100, "detector");
            TransitionPhotoDraweeView r101 = this.f262062a;
            r101.f262048g.getValues(r101.f262049h);
            float r102 = RangesKt.coerceAtLeast(this.f262062a.f262049h[0], 0.01f);
            float r103 = RangesKt.coerceIn(r100.getScaleFactor() * r102, this.f262062a.getMinScaleFactor() * 0.85f, this.f262062a.getMaxScaleFactor() * 1.15f) / r102;
            this.f262062a.f262048g.postScale(r103, r103, r100.getFocusX(), r100.getFocusY());
            this.f262062a.j();
            this.f262062a.invalidate();
            return true;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TransitionPhotoDraweeView f262063a;

        public c(TransitionPhotoDraweeView r100) {
            this.f262063a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TransitionPhotoDraweeView.f(this.f262063a, 3);     // Catch: Throwable -> L4
            this.f262063a.setTranslationY(0.0f);     // Catch: Throwable -> L4
            this.f262063a.setTranslationX(0.0f);     // Catch: Throwable -> L4
            this.f262063a.setScaleX(1.0f);     // Catch: Throwable -> L4
            this.f262063a.setScaleY(1.0f);     // Catch: Throwable -> L4
            this.f262063a.setAlpha(1.0f);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public TransitionPhotoDraweeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TransitionPhotoDraweeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getTouchSlop() {
        return ((Number) this.f262058q.getValue()).intValue();
    }

    public final void j() {
        this.f262048g.getValues(this.f262049h);
        float[] r100 = this.f262049h;
        boolean r101 = false;
        float r102 = r100[0];
        float r103 = r100[2];
        float r104 = r100[5];
        if (r102 > 1.01f) goto L6;
        this.f262048g.reset();
        return;
    L6:
        float r105 = r102 - 1.0f;
        float r106 = getWidth() * r105;
        float r107 = getHeight() * r105;
        float r108 = RangesKt.coerceIn(r103, -r106, 0.0f);
        float r109 = RangesKt.coerceIn(r104, -r107, 0.0f);
        if (r108 != r103) goto L9;
        boolean r110 = true;
    L10:
        if (r110 == true) goto L12;
    L15:
        this.f262048g.postTranslate(r108 - r103, r109 - r104);
        return;
    L12:
        if (r109 != r104) goto L14;
        r101 = true;
    L14:
        if (r101 == false) goto L15;
        return;
    L9:
        r110 = false;
        goto L10
    }

    public final void k() {
        animate().cancel();
        Iterator r100 = new ArrayList(this.f262046e).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.locallife.photo.internal.photodraweeview.transition.a) r100.next()).onTransitionBegin(3);
        goto L4
    L6:
        animate().translationY(RangesKt.coerceAtLeast(getHeight(), getTranslationY() + 400.0f)).alpha(0.0f).setDuration(180).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new c(this)).start();
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r100 = getParent();
    L3:
        if (r100 == null) goto L7;
        if ((r100 instanceof RecyclerView) == true) goto L7;
        r100 = r100.getParent();
    L7:
        TransitionPagerAdapter r101 = null;
        if ((r100 instanceof RecyclerView) == false) goto L10;
        RecyclerView r102 = (RecyclerView) r100;
    L11:
        if (r102 == null) goto L25;
        RecyclerView.Adapter r103 = r102.getAdapter();
        if ((r103 instanceof TransitionPagerAdapter) == false) goto L16;
        r101 = (TransitionPagerAdapter) r103;
    L16:
        if (r101 == null) goto L26;
        com.bytedance.locallife.photo.internal.photodraweeview.transition.a r104 = r101.f262040a;
        if (r104 == null) goto L27;
        this.f262047f = r104;
        ((ArrayList) this.f262046e).add(r104);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L10:
        r102 = null;
        goto L11
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.locallife.photo.internal.photodraweeview.transition.a r100 = this.f262047f;
        if (r100 == null) goto L5;
        ((ArrayList) this.f262046e).remove(r100);
    L5:
        this.f262047f = null;
    }

    public final float getMaxScaleFactor() {
        return this.f262045d;
    }

    public final float getMidScaleFactor() {
        return this.f262044c;
    }

    public final float getMinScaleFactor() {
        return this.f262043b;
    }

    public final GestureDetector.SimpleOnGestureListener getTapListener() {
        return this.f262042a;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = r100.save();
        r100.concat(this.f262048g);
        super.onDraw(r100);
        r100.restoreToCount(r101);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (r110.getPointerCount() < 2) goto L5;
        this.f262056o = true;
    L5:
        this.f262059r.onTouchEvent(r110);
        this.f262060s.onTouchEvent(r110);
        int r100 = r110.getActionMasked();
        if (r100 != 0) goto L8;
        this.f262052k = r110.getX();
        this.f262053l = r110.getY();
        this.f262050i = r110.getX();
        this.f262051j = r110.getY();
        this.f262054m = false;
        this.f262055n = false;
        this.f262056o = false;
        this.f262057p = false;
        ViewParent r111 = getParent();
        if (r111 == null) goto L74;
        r111.requestDisallowInterceptTouchEvent(true);
    L74:
        return true;
    L8:
        if (r100 == 1) goto L65;
        if (r100 != 2) goto L11;
        float r101 = r110.getX() - this.f262050i;
        float r102 = r110.getY() - this.f262051j;
        float r103 = r110.getX() - this.f262052k;
        float r104 = r110.getY() - this.f262053l;
        this.f262050i = r110.getX();
        this.f262051j = r110.getY();
        if (this.f262059r.isInProgress() == true) goto L74;
        if (this.f262056o == true) goto L74;
        if (this.f262054m == true) goto L26;
        if (Math.abs(r103) <= getTouchSlop()) goto L23;
    L24:
        this.f262054m = true;
        goto L26
    L23:
        if (Math.abs(r104) > getTouchSlop()) goto L24;
    L26:
        if (this.f262054m == false) goto L74;
        this.f262048g.getValues(this.f262049h);
        if (this.f262049h[0] <= 1.01f) goto L31;
        boolean r112 = true;
    L32:
        if (r112 == false) goto L37;
        this.f262048g.postTranslate(r101, r102);
        j();
        invalidate();
        ViewParent r113 = getParent();
        if (r113 == null) goto L74;
        r113.requestDisallowInterceptTouchEvent(true);
        goto L74
    L37:
        if (r104 > getTouchSlop()) goto L39;
    L41:
        boolean r114 = false;
    L42:
        boolean r105 = this.f262055n;
        if (r105 == true) goto L49;
        if (r114 == true) goto L49;
        ViewParent r115 = getParent();
        if (r115 == null) goto L74;
        r115.requestDisallowInterceptTouchEvent(false);
    L49:
        if (r105 == true) goto L54;
        this.f262055n = true;
        ViewParent r116 = getParent();
        if (r116 == null) goto L54;
        r116.requestDisallowInterceptTouchEvent(true);
    L54:
        if (this.f262057p == true) goto L59;
        this.f262057p = true;
        Iterator r117 = new ArrayList(this.f262046e).iterator();
    L57:
        if (r117.hasNext() == false) goto L59;
        ((com.bytedance.locallife.photo.internal.photodraweeview.transition.a) r117.next()).onTransitionBegin(1);
    L59:
        float r118 = RangesKt.coerceAtLeast(r104, 0.0f);
        setTranslationY(r118);
        setTranslationX(r103 / 2.0f);
        float r119 = RangesKt.coerceIn(r118 / RangesKt.coerceAtLeast(getHeight() / 4.0f, 160.0f), 0.0f, 1.0f);
        Iterator r106 = new ArrayList(this.f262046e).iterator();
    L61:
        if (r106.hasNext() == false) goto L63;
        ((com.bytedance.locallife.photo.internal.photodraweeview.transition.a) r106.next()).onTransitionChanged(1, r119);
        goto L61
    L63:
        float r107 = 1.0f - (r119 * 0.25f);
        setScaleX(r107);
        setScaleY(r107);
        goto L74
    L39:
        if (r104 <= (Math.abs(r103) * 1.2f)) goto L41;
        r114 = true;
        goto L42
    L31:
        r112 = false;
        goto L32
    L11:
        if (r100 != 3) goto L74;
    L65:
        if (this.f262055n == true) goto L67;
    L70:
        this.f262054m = false;
        this.f262055n = false;
        this.f262056o = false;
        goto L74
    L67:
        if (getTranslationY() <= RangesKt.coerceAtLeast(getHeight() / 4.0f, 160.0f)) goto L69;
        k();
        goto L70
    L69:
        animate().cancel();
        animate().translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new com.bytedance.locallife.photo.internal.photodraweeview.transition.c(this)).start();
        goto L70
    }

    public final void setMaxScaleFactor(float r100) {
        this.f262045d = r100;
    }

    public final void setMidScaleFactor(float r100) {
        this.f262044c = r100;
    }

    public final void setMinScaleFactor(float r100) {
        this.f262043b = r100;
    }

    public final void setTapListener(GestureDetector.SimpleOnGestureListener r100) {
        this.f262042a = r100;
    }

    public static final void f(TransitionPhotoDraweeView r100, int r101) {
        r100.getClass();
        Iterator r102 = new ArrayList(r100.f262046e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.locallife.photo.internal.photodraweeview.transition.a) r102.next()).onTransitionEnd(r101);
        goto L4
    }

    @Override // com.facebook.drawee.view.GenericDraweeView
    public final void inflateHierarchy(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        GenericDraweeHierarchyBuilder r102 = new GenericDraweeHierarchyBuilder(r100.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        GenericDraweeHierarchyInflater.updateBuilder(r102, r100, r101);
        setAspectRatio(r102.getDesiredAspectRatio());
        setHierarchy(r102.build());
    }

    public TransitionPhotoDraweeView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f262043b = 1.0f;
        this.f262044c = 1.75f;
        this.f262045d = 3.0f;
        this.f262046e = new ArrayList();
        this.f262048g = new Matrix();
        this.f262049h = new float[9];
        this.f262058q = LazyKt.lazy(new TransitionPhotoDraweeView$touchSlop$2(r100));
        this.f262059r = new ScaleGestureDetector(r100, new b(this));
        GestureDetector r103 = new GestureDetector(r100, new a(this));
        this.f262060s = r103;
        r103.setIsLongpressEnabled(true);
    }

    public /* synthetic */ TransitionPhotoDraweeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f262048g.reset();
    }
}
