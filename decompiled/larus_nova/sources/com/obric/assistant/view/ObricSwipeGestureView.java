package com.obric.assistant.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0004,-./B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0014J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0017J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/assistant/view/ObricSwipeGestureView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureDetector", "Landroid/view/GestureDetector;", "minimumFlingVelocity", "distance", "", "paint", "Landroid/graphics/Paint;", "rectF", "Landroid/graphics/RectF;", "topMarginPx", "rectHeightPx", "rectWidthPx", "getRectWidthPx", "()I", "cornerRadiusPx", "listener", "Lcom/obric/assistant/view/ObricSwipeGestureView$OnSwipeGestureListener;", "setOnSwipeGestureListener", "", "swipeConfig", "Lcom/obric/assistant/view/ObricSwipeGestureView$SwipeConfig;", "setSwipeConfig", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "dpToPx", "dp", "Companion", "OnSwipeGestureListener", "SwipeConfig", "IconGestureListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSwipeGestureView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GestureDetector f393982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f393983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f393984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f393985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f393986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f393987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f393988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f393989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f393990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f393991j;

    public static final class a {
    }

    public final class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricSwipeGestureView f393992a;

        public b(ObricSwipeGestureView r100) {
            this.f393992a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            c r101 = this.f393992a.f393990i;
            if (r101 == null) goto L7;
            r101.F4(new PointF(r100.getX(), r100.getY()));
            return true;
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            ObricSwipeGestureView r104 = this.f393992a;
            float r105 = r101.getRawY();
            if (r100 == null) goto L5;
            float r106 = r100.getRawY();
        L6:
            r104.f393984c = r105 - r106;
            ObricSwipeGestureView r107 = this.f393992a;
            int r108 = r107.f393983b;
            if (r103 >= (-r108)) goto L16;
            float r109 = r107.f393984c;
            if (r109 >= (-r107.f393991j.f393993a)) goto L16;
            c r110 = r107.f393990i;
            if (r110 == null) goto L13;
            r110.s5(r109, r103);
        L13:
            this.f393992a.f393984c = 0.0f;
            return true;
        L16:
            if (r103 <= r108) goto L24;
            float r111 = r107.f393984c;
            if (r111 <= r107.f393991j.f393994b) goto L26;
            c r112 = r107.f393990i;
            if (r112 == null) goto L22;
            r112.s5(r111, r103);
        L22:
            this.f393992a.f393984c = 0.0f;
            return true;
        L26:
            return false;
        L24:
            return false;
        L5:
            r106 = r101.getRawY();
            goto L6
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r101, "e2");
            ObricSwipeGestureView r104 = this.f393992a;
            float r105 = r101.getRawY();
            if (r100 == null) goto L5;
            float r106 = r100.getRawY();
        L6:
            r104.f393984c = r105 - r106;
            ObricSwipeGestureView r107 = this.f393992a;
            c r108 = r107.f393990i;
            if (r108 == null) goto L10;
            r108.E(r107.f393984c);
        L10:
            return super.onScroll(r100, r101, r102, r103);
        L5:
            r106 = r101.getRawY();
            goto L6
        }
    }

    public interface c {
        void E(float r100);

        void F4(PointF r100);

        void onDown(MotionEvent r100);

        void s5(float r100, float r101);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f393993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f393994b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f393993a == r101.f393993a) goto L12;
            return false;
        L12:
            if (this.f393994b == r101.f393994b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f393993a * 31) + this.f393994b;
        }

        public final String toString() {
            return "SwipeConfig(topDistance=" + this.f393993a + ", downDistance=" + this.f393994b + ')';
        }

        public d(int r100, int r101) {
            this.f393993a = r100;
            this.f393994b = r101;
        }
    }

    static {
    }

    public ObricSwipeGestureView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ObricSwipeGestureView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getRectWidthPx() {
        if (IWindowContextKt.isWindowContext(getContext()) == false) goto L6;
        return i5.W();
    L6:
        return i5.h0();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = (getWidth() - getRectWidthPx()) / 2.0f;
        this.f393986e.set(r101, this.f393987f, getRectWidthPx() + r101, this.f393987f + this.f393988g);
        RectF r102 = this.f393986e;
        float r103 = this.f393989h;
        r100.drawRoundRect(r102, r103, r103, this.f393985d);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("onTouchEvent action is ");
        r102.append(r100.getAction());
        r102.append(", isEnabled: ");
        r102.append(isEnabled());
        r102.append(", isVisible: ");
        boolean r103 = false;
        if (getVisibility() != 0) goto L5;
        boolean r104 = true;
    L6:
        r102.append(r104);
        r101.i("ObricSwipeGestureView", r102.toString());
        if (isEnabled() == true) goto L9;
    L31:
        return false;
    L9:
        if (getVisibility() != 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L31;
        this.f393982a.onTouchEvent(r100);
        if (r100.getAction() != 0) goto L20;
        this.f393984c = 0.0f;
        c r106 = this.f393990i;
        if (r106 == null) goto L30;
        r106.onDown(r100);
    L30:
        return true;
    L20:
        if (r100.getAction() != 1) goto L22;
    L23:
        float r107 = this.f393984c;
        if (r107 != 0.0f) goto L26;
        r103 = true;
    L26:
        if (r103 == true) goto L30;
        c r108 = this.f393990i;
        if (r108 == null) goto L30;
        r108.s5(r107, 0.0f);
        goto L30
    L22:
        if (r100.getAction() != 3) goto L30;
    L11:
        r105 = false;
        goto L12
    L5:
        r104 = false;
        goto L6
    }

    public final void setOnSwipeGestureListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f393990i = r100;
    }

    public final void setSwipeConfig(d r100) {
        Intrinsics.checkNotNullParameter(r100, "swipeConfig");
        this.f393991j = r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(View.resolveSize(getRectWidthPx(), r100), View.resolveSize((int) (this.f393987f + this.f393988g), r101));
    }

    public ObricSwipeGestureView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f393982a = new GestureDetector(r100, new b(this));
        this.f393983b = ViewConfiguration.get(r100).getScaledMinimumFlingVelocity();
        Paint r103 = new Paint();
        r103.setColor(864059520);
        r103.setAntiAlias(true);
        r103.setStyle(Paint.Style.FILL);
        this.f393985d = r103;
        this.f393986e = new RectF();
        Resources r104 = getContext().getResources();
        this.f393987f = TypedValue.applyDimension(1, 5.0f, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()));
        this.f393988g = i5.Y();
        this.f393989h = i5.z();
        this.f393991j = new d(-60, 60);
    }

    public /* synthetic */ ObricSwipeGestureView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
