package com.larus.setting.impl.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.utils.a4;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 X2\u00020\u0001:\u0002XYB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00106\u001a\u000207H\u0002J(\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000fH\u0014J\u000e\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020\u000fJ\b\u0010?\u001a\u000207H\u0002J\u0010\u0010@\u001a\u0002072\u0006\u0010A\u001a\u00020BH\u0014J\u0010\u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u0002072\u0006\u0010G\u001a\u00020\rH\u0002J\u0010\u0010H\u001a\u0002072\u0006\u0010G\u001a\u00020\rH\u0002J\u0010\u0010I\u001a\u0002072\u0006\u0010J\u001a\u00020\u000fH\u0002J\u0018\u0010K\u001a\u00020\r2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u000fH\u0002J\u0010\u0010N\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\rH\u0002J\u000e\u0010O\u001a\u0002072\u0006\u0010P\u001a\u00020QJ\u000e\u0010S\u001a\u0002072\u0006\u0010T\u001a\u00020\u000fJ\u0010\u0010U\u001a\u00020\r2\u0006\u0010V\u001a\u00020\rH\u0002J\b\u0010W\u001a\u000207H\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/larus/setting/impl/view/FontSizeSettingView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getAttrs", "()Landroid/util/AttributeSet;", "setAttrs", "(Landroid/util/AttributeSet;)V", "mMargin", "", "mAxisColor", "", "mPointColor", "mCircleShadowColor", "mCircleStrokeColor", "mCircleColor", "mPointCount", "mCircleRadius", "mCurrentProgress", "mInitialPosition", "mItemWidth", "mHeight", "mWidth", "mAxisPaint", "Landroid/graphics/Paint;", "mPointPaint", "mCircleShadowPaintLarge", "mCircleShadowPaintSmall", "mCircleStrokePaint", "mCirclePaint", "mCircleX", "mCircleY", "lastTouchX", "isTrackingTouch", "", "mPoints", "", "Landroid/graphics/Point;", "standardDrawValue", "mAxisRect", "Landroid/graphics/RectF;", "mAxisHeight", "mAxisCornerRadius", "mPointRadius", "mPointEndMargin", "mAxisStartX", "mAxisEndX", "mPointStartX", "mPointEndX", "mAxisCenterY", "initAttrs", "", "onSizeChanged", "w", "h", "oldw", "oldh", "setPointCount", "count", "rebuildGeometry", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "stepProgressByTouchX", "x", "snapProgressByTouchX", "setProgressIfChanged", "newIndex", "getMidX", "leftIndex", "rightIndex", "getNearestIndex", "setChangeCallbackListener", "listener", "Lcom/larus/setting/impl/view/FontSizeSettingView$OnProgressChangeListener;", "onChangeListener", "setDefaultPosition", "position", "dp2px", "dp", "onAttachedToWindow", "Companion", "OnProgressChangeListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontSizeSettingView extends AppCompatTextView {
    public final RectF A;
    public final float B;
    public final float C;
    public final float D;
    public final float E;
    public float F;
    public float G;
    public float H;
    public b I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AttributeSet f368480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f368481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f368482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f368483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f368484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f368485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f368486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f368487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f368488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f368489j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f368490k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f368491l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f368492m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f368493n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Paint f368494o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Paint f368495p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Paint f368496q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Paint f368497r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Paint f368498s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Paint f368499t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f368500u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f368501v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f368502w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f368503x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<Point> f368504y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f368505z;

    public static final class a {
    }

    public interface b {
        void a(int r100);

        void b(int r100);
    }

    static {
    }

    public final void y() {
        int r100 = this.f368493n;
        if (r100 > 0) goto L5;
        return;
    L5:
        if (this.f368487h < 2) goto L23;
        float r101 = getHeight() * this.f368505z;
        this.H = r101;
        this.f368501v = r101;
        ((ArrayList) this.f368504y).clear();
        float r102 = this.f368481b;
        float r103 = r100;
        RectF r104 = this.A;
        float r105 = this.H;
        float r106 = 2;
        float r107 = this.B / r106;
        r104.set(r102, r105 - r107, r103 - r102, r105 + r107);
        float r108 = this.A.left;
        float r109 = this.E;
        this.F = r108 + r109;
        float r110 = (r103 - (this.f368481b * r106)) - (r106 * r109);
        if (r110 > 0.0f) goto L11;
        FLogger.f375446a.e("FontSizeSettingView", "rebuildGeometry, insufficient width: width=" + r100 + ", availableWidth=" + r110);
        return;
    L11:
        int r111 = this.f368487h;
        this.f368491l = (int) (r110 / (r111 - 1));
        int r112 = 0;
    L12:
        if (r112 >= r111) goto L14;
        ((ArrayList) this.f368504y).add(new Point(((int) this.F) + (this.f368491l * r112), (int) this.H));
        r112 = r112 + 1;
        goto L12
    L14:
        this.G = ((Point) ListProtector.get(this.f368504y, this.f368487h - 1)).x;
        int r113 = this.f368490k;
        if (r113 >= 0) goto L17;
    L19:
        FLogger.f375446a.i("FontSizeSettingView", "onSizeChanged, default circleX = " + this.f368500u + ", mInitialPosition = " + this.f368490k + ", points = " + this.f368504y);
        return;
    L17:
        if (r113 >= ((ArrayList) this.f368504y).size()) goto L19;
        this.f368500u = ((Point) ListProtector.get(this.f368504y, this.f368490k)).x;
        goto L19
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L6;
        setScaleX(-1.0f);
        return;
    }

    public final AttributeSet getAttrs() {
        return this.f368480a;
    }

    public FontSizeSettingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setProgressIfChanged(int r100) {
        int r101 = RangesKt.coerceIn(r100, 0, CollectionsKt.getLastIndex(this.f368504y));
        int r102 = this.f368489j;
        if (r101 != r102) goto L6;
        this.f368500u = ((Point) ListProtector.get(this.f368504y, r102)).x;
        invalidate();
        return;
    L6:
        this.f368489j = r101;
        this.f368500u = ((Point) ListProtector.get(this.f368504y, r101)).x;
        a4.f314971a.getClass();
        a4.a(5);
        b r103 = this.I;
        if (r103 == null) goto L9;
        r103.b(this.f368489j);
    L9:
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (CollectionUtils.isEmpty(this.f368504y) == false) goto L6;
        FLogger.f375446a.e("FontSizeSettingView", "mPoints is empty");
        return;
    L6:
        RectF r101 = this.A;
        float r102 = this.C;
        Paint r103 = this.f368494o;
        Paint r104 = null;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mAxisPaint");
        r103 = null;
    L9:
        r100.drawRoundRect(r101, r102, r102, r103);
        Iterator r105 = ((ArrayList) this.f368504y).iterator();
    L11:
        if (r105.hasNext() == false) goto L16;
        float r106 = ((Point) r105.next()).x;
        float r107 = this.H;
        float r108 = this.D;
        Paint r109 = this.f368495p;
        if (r109 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mPointPaint");
        r109 = null;
    L15:
        r100.drawCircle(r106, r107, r108, r109);
        goto L11
    L16:
        float r110 = this.f368500u;
        float r111 = this.F;
        if (r110 >= r111) goto L19;
        this.f368500u = r111;
    L19:
        float r112 = this.f368500u;
        float r113 = this.G;
        if (r112 <= r113) goto L22;
        this.f368500u = r113;
    L22:
        float r114 = this.f368500u;
        float r115 = this.f368501v;
        float r116 = this.f368488i;
        Paint r117 = this.f368496q;
        if (r117 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mCircleShadowPaintLarge");
        r117 = null;
    L25:
        r100.drawCircle(r114, r115, r116, r117);
        float r118 = this.f368500u;
        float r119 = this.f368501v;
        float r120 = this.f368488i;
        Paint r121 = this.f368497r;
        if (r121 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mCircleShadowPaintSmall");
        r121 = null;
    L28:
        r100.drawCircle(r118, r119, r120, r121);
        float r122 = this.f368500u;
        float r123 = this.f368501v;
        float r124 = this.f368488i;
        Paint r125 = this.f368499t;
        if (r125 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mCirclePaint");
        r125 = null;
    L31:
        r100.drawCircle(r122, r123, r124, r125);
        float r126 = this.f368500u;
        float r127 = this.f368501v;
        float r128 = this.f368488i;
        Paint r129 = this.f368498s;
        if (r129 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mCircleStrokePaint");
    L35:
        r100.drawCircle(r126, r127, r128, r104);
        return;
    L34:
        r104 = r129;
        goto L35
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (((ArrayList) this.f368504y).isEmpty() == true) goto L5;
        float r101 = RangesKt.coerceIn(r100.getX(), this.F, this.G);
        int r102 = r100.getAction();
        if (r102 != 0) goto L9;
        this.f368502w = r101;
        this.f368503x = true;
        ViewParent r103 = getParent();
        if (r103 == null) goto L63;
        r103.requestDisallowInterceptTouchEvent(true);
    L63:
        invalidate();
    L64:
        return true;
    L9:
        if (r102 != 1) goto L11;
        ViewParent r104 = getParent();
        if (r104 == null) goto L51;
        r104.requestDisallowInterceptTouchEvent(false);
    L51:
        if (this.f368491l > 0) goto L53;
        int r105 = RangesKt.coerceIn(this.f368489j, 0, CollectionsKt.getLastIndex(this.f368504y));
    L54:
        setProgressIfChanged(r105);
        if (this.f368503x == false) goto L59;
        b r106 = this.I;
        if (r106 == null) goto L59;
        r106.a(this.f368489j);
    L59:
        this.f368503x = false;
        goto L64
    L53:
        float r107 = RangesKt.coerceIn(r101, ((Point) CollectionsKt.first(this.f368504y)).x, ((Point) CollectionsKt.last(this.f368504y)).x);
        float r108 = r107 - ((Point) CollectionsKt.first(this.f368504y)).x;
        float r109 = this.f368491l;
        int r110 = RangesKt.coerceIn((int) ((r108 + (r109 / 2.0f)) / r109), 0, CollectionsKt.getLastIndex(this.f368504y));
        FLogger.f375446a.i("FontSizeSettingView", "getNearestIndex x=" + r101 + " clamped=" + r107 + " index=" + r110);
        r105 = r110;
        goto L54
    L11:
        if (r102 != 2) goto L13;
        ViewParent r111 = getParent();
        if (r111 == null) goto L27;
        r111.requestDisallowInterceptTouchEvent(true);
    L27:
        float r112 = r101 - this.f368502w;
        if (r112 != 0.0f) goto L30;
        boolean r113 = true;
    L31:
        if (r113 == true) goto L46;
        int r114 = RangesKt.coerceIn(this.f368489j, 0, CollectionsKt.getLastIndex(this.f368504y));
        if (r112 <= 0.0f) goto L40;
        int r115 = RangesKt.coerceAtMost(r114 + 1, CollectionsKt.getLastIndex(this.f368504y));
        if (r115 != r114) goto L38;
    L45:
        setProgressIfChanged(r114);
        goto L46
    L38:
        if (r101 < ((((Point) ListProtector.get(this.f368504y, r114)).x + ((Point) ListProtector.get(this.f368504y, r115)).x) / 2.0f)) goto L45;
    L44:
        r114 = r115;
        goto L45
    L40:
        r115 = RangesKt.coerceAtLeast(r114 - 1, 0);
        if (r115 == r114) goto L45;
        if (r101 > ((((Point) ListProtector.get(this.f368504y, r115)).x + ((Point) ListProtector.get(this.f368504y, r114)).x) / 2.0f)) goto L45;
    L46:
        this.f368502w = r101;
        goto L64
    L30:
        r113 = false;
        goto L31
    L13:
        if (r102 != 3) goto L64;
        ViewParent r116 = getParent();
        if (r116 == null) goto L19;
        r116.requestDisallowInterceptTouchEvent(false);
    L19:
        if (this.f368503x == false) goto L23;
        b r117 = this.I;
        if (r117 == null) goto L23;
        r117.a(this.f368489j);
    L23:
        this.f368503x = false;
        goto L64
    L5:
        return super.onTouchEvent(r100);
    }

    public final void setAttrs(AttributeSet r100) {
        this.f368480a = r100;
    }

    public final void setChangeCallbackListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.I = r100;
    }

    public final void setDefaultPosition(int r100) {
        this.f368490k = r100;
        this.f368489j = r100;
        if (r100 >= 0) goto L5;
    L7:
        b r101 = this.I;
        if (r101 == null) goto L10;
        r101.b(this.f368490k);
    L10:
        invalidate();
        return;
    L5:
        if (r100 >= ((ArrayList) this.f368504y).size()) goto L7;
        this.f368500u = ((Point) ListProtector.get(this.f368504y, r100)).x;
        goto L7
    }

    public final void setPointCount(int r100) {
        int r101 = RangesKt.coerceAtLeast(r100, 2);
        if (r101 != this.f368487h) goto L5;
        return;
    L5:
        this.f368487h = r101;
        if (this.f368493n > 0) goto L8;
    L12:
        invalidate();
        return;
    L8:
        if (this.f368492m <= 0) goto L12;
        y();
        int r102 = CollectionsKt.getLastIndex(this.f368504y);
        if (r102 < 0) goto L12;
        this.f368490k = RangesKt.coerceIn(this.f368490k, 0, r102);
        int r103 = RangesKt.coerceIn(this.f368489j, 0, r102);
        this.f368489j = r103;
        this.f368500u = ((Point) ListProtector.get(this.f368504y, r103)).x;
        goto L12
    }

    public final float x(float r100) {
        Resources r101 = getContext().getResources();
        return TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    public FontSizeSettingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f368480a = r101;
        this.f368481b = x(20.0f);
        AppHost.Companion r102 = AppHost.f326268a;
        this.f368482c = ContextCompat.getColor(r102.getApplication(), c.b(R.attr.larus_neutral_transparent_1, r102.getApplication(), R.color.larus_neutral_transparent_1));
        this.f368483d = ContextCompat.getColor(r102.getApplication(), c.b(R.attr.larus_neutral_transparent_3, r102.getApplication(), R.color.larus_neutral_transparent_3));
        this.f368484e = ColorProtector.parseColor("#1F000000");
        this.f368485f = ContextCompat.getColor(r102.getApplication(), c.b(R.attr.larus_neutral_transparent_1, r102.getApplication(), R.color.larus_neutral_transparent_1));
        this.f368486g = ContextCompat.getColor(r100, R.color.larus_static_white);
        this.f368487h = 6;
        this.f368488i = x(16.0f);
        this.f368490k = 2;
        this.f368504y = new ArrayList();
        this.f368505z = 0.5f;
        this.A = new RectF();
        this.B = x(16.0f);
        this.C = x(14.0f);
        this.D = x(4.0f);
        this.E = x(8.0f);
        TypedArray r103 = getContext().obtainStyledAttributes(this.f368480a, new int[]{R.attr.larus_axisColor, R.attr.larus_circleColor, R.attr.larus_circleShadowColor, R.attr.larus_circleStrokeColor, R.attr.larus_pointColor, R.attr.larus_pointCount});
        this.f368487h = r103.getInt(5, this.f368487h);
        this.f368482c = r103.getColor(0, this.f368482c);
        this.f368483d = r103.getColor(4, this.f368483d);
        this.f368486g = r103.getColor(1, this.f368486g);
        this.f368485f = r103.getColor(3, this.f368485f);
        this.f368484e = r103.getColor(2, this.f368484e);
        r103.recycle();
        if (this.f368487h >= 2) goto L5;
        this.f368487h = 2;
    L5:
        Paint r104 = new Paint(1);
        r104.setColor(this.f368482c);
        r104.setStyle(Paint.Style.FILL);
        this.f368494o = r104;
        Paint r105 = new Paint(1);
        r105.setColor(this.f368483d);
        r105.setStyle(Paint.Style.FILL);
        this.f368495p = r105;
        setLayerType(1, null);
        Paint r106 = new Paint(1);
        r106.setColor(this.f368486g);
        r106.setStyle(Paint.Style.FILL);
        this.f368499t = r106;
        Paint r107 = new Paint(1);
        r107.setColor(this.f368485f);
        r107.setStyle(Paint.Style.STROKE);
        r107.setStrokeWidth(x(0.5f));
        this.f368498s = r107;
        Paint r108 = new Paint(1);
        r108.setColor(this.f368486g);
        r108.setStyle(Paint.Style.FILL);
        r108.setShadowLayer(x(14.0f), 0.0f, x(4.0f), this.f368484e);
        this.f368496q = r108;
        Paint r109 = new Paint(1);
        r109.setColor(this.f368486g);
        r109.setStyle(Paint.Style.FILL);
        r109.setShadowLayer(x(4.0f), 0.0f, 0.0f, this.f368484e);
        this.f368497r = r109;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f368492m = r101;
        this.f368493n = r100;
        y();
    }
}
