package com.larus.community.impl.detail.image;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 D2\u00020\u0001:\u0003BCDB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u000209H\u0016J\u0006\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u00020;J\u000e\u0010=\u001a\u0002052\u0006\u0010>\u001a\u00020\u0013J\u0010\u0010?\u001a\u00020\u00102\u0006\u00108\u001a\u000209H\u0002J\u0018\u0010\f\u001a\u0002052\u0006\u0010@\u001a\u00020\u000b2\u0006\u00108\u001a\u000209H\u0002J\b\u0010A\u001a\u000205H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006E"}, d2 = {"Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startPoint", "Landroid/graphics/PointF;", "midPoint", "lastPoint", "mode", "oldDist", "", "currentScale", "isDragging", "", "isInFullscreenMode", "()Z", "setInFullscreenMode", "(Z)V", "hasTriggeredZoom", "touchSlop", "isLongPressTriggered", "longPressTimeout", "", "longPressHandler", "Landroid/os/Handler;", "longPressRunnable", "Ljava/lang/Runnable;", "doubleTapTimeout", "lastTapTime", "lastTapX", "lastTapY", "isDoubleTapTriggered", "zoomListener", "Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView$OnZoomListener;", "getZoomListener", "()Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView$OnZoomListener;", "setZoomListener", "(Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView$OnZoomListener;)V", "onLongClickListenerInternal", "Landroid/view/View$OnLongClickListener;", "onDoubleTapListener", "Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView$OnDoubleTapListener;", "getOnDoubleTapListener", "()Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView$OnDoubleTapListener;", "setOnDoubleTapListener", "(Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView$OnDoubleTapListener;)V", "setOnLongClickListener", "", "l", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "getLocationInWindow", "Landroid/graphics/Rect;", "getGlobalVisibleRect", "setFullscreenMode", "fullscreen", "spacing", "point", "onDetachedFromWindow", "OnZoomListener", "OnDoubleTapListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationZoomableDraweeView extends SimpleDraweeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f329308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f329309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f329310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f329311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f329312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f329313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f329314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f329315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f329316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f329317j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f329318k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f329319l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f329320m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final r f329321n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f329322o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f329323p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f329324q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f329325r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f329326s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f329327t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View.OnLongClickListener f329328u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b f329329v;

    public static final class a {
    }

    public interface b {
        void c();
    }

    public interface c {
        void a(float r100);

        void b();

        void c(float r100, float r101);

        void d();

        void onDragEnd();

        void onDragStart();
    }

    static {
    }

    public CreationZoomableDraweeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CreationZoomableDraweeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Rect getLocationInWindow() {
        int[] r100 = new int[2];
        getLocationInWindow(r100);
        int r101 = r100[0];
        return new Rect(r101, r100[1], getWidth() + r101, r100[1] + getHeight());
    }

    public final Rect getGlobalVisibleRect() {
        Rect r100 = new Rect();
        getGlobalVisibleRect(r100);
        return r100;
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f329320m.removeCallbacks(this.f329321n);
    }

    public final b getOnDoubleTapListener() {
        return this.f329329v;
    }

    public final c getZoomListener() {
        return this.f329327t;
    }

    public static float j(MotionEvent r100) {
        if (r100.getPointerCount() >= 2) goto L6;
        return 0.0f;
    L6:
        float r101 = r100.getX(0) - r100.getX(1);
        float r102 = r100.getY(0) - r100.getY(1);
        return (float) Math.sqrt((r101 * r101) + (r102 * r102));
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        int r100 = r110.getActionMasked();
        int r101 = 0;
        if (r100 != 0) goto L5;
        this.f329308a.set(r110.getX(), r110.getY());
        this.f329310c.set(r110.getX(), r110.getY());
        this.f329316i = false;
        this.f329318k = false;
        this.f329326s = false;
        long r102 = System.currentTimeMillis();
        long r103 = r102 - this.f329323p;
        float r104 = Math.abs(r110.getX() - this.f329324q);
        float r105 = Math.abs(r110.getY() - this.f329325r);
        if (r103 >= this.f329322o) goto L110;
        float r106 = this.f329317j;
        if (r104 >= r106) goto L110;
        if (r105 >= r106) goto L110;
        this.f329320m.removeCallbacks(this.f329321n);
        this.f329326s = true;
        b r107 = this.f329329v;
        if (r107 == null) goto L106;
        r110.getX();
        r110.getY();
        r107.c();
        boolean r108 = true;
    L107:
        if (r108 == false) goto L110;
        this.f329323p = 0;
        return true;
    L106:
        r108 = false;
    L110:
        this.f329323p = r102;
        this.f329324q = r110.getX();
        this.f329325r = r110.getY();
        if (this.f329315h == false) goto L119;
        this.f329311d = 2;
        this.f329314g = true;
        c r109 = this.f329327t;
        if (r109 == null) goto L115;
        r110.getX();
        r110.getY();
        r109.onDragStart();
    L115:
        ViewParent r111 = getParent();
        if (r111 == null) goto L118;
        r111.requestDisallowInterceptTouchEvent(true);
    L118:
        this.f329320m.removeCallbacks(this.f329321n);
    L125:
        return true;
    L119:
        this.f329311d = 0;
        ViewParent r112 = getParent();
        if (r112 == null) goto L123;
        r112.requestDisallowInterceptTouchEvent(false);
    L123:
        if (this.f329328u == null) goto L125;
        this.f329320m.postDelayed(this.f329321n, this.f329319l);
        goto L125
    L5:
        if (r100 == 1) goto L70;
        if (r100 != 2) goto L8;
        float r113 = r110.getX() - this.f329308a.x;
        float r114 = r110.getY() - this.f329308a.y;
        if (Math.sqrt((r113 * r113) + (r114 * r114)) <= this.f329317j) goto L44;
        this.f329320m.removeCallbacks(this.f329321n);
    L44:
        if (this.f329311d != 1) goto L57;
        if (r110.getPointerCount() != 2) goto L57;
        float r115 = j(r110);
        if (r115 <= 10.0f) goto L55;
        this.f329313f = r115 / this.f329312e;
        f(this.f329309b, r110);
        if (this.f329316i == true) goto L52;
        this.f329316i = true;
    L52:
        c r116 = this.f329327t;
        if (r116 == null) goto L55;
        float r117 = this.f329313f;
        float r118 = this.f329309b.x;
        r116.a(r117);
    L55:
        return true;
    L57:
        if (this.f329311d == 2) goto L59;
    L69:
        return super.onTouchEvent(r110);
    L59:
        if (this.f329315h == false) goto L69;
        float r119 = r110.getX() - this.f329310c.x;
        float r120 = r110.getY() - this.f329310c.y;
        if (Math.abs(r119) <= this.f329317j) goto L63;
    L64:
        this.f329310c.set(r110.getX(), r110.getY());
        c r121 = this.f329327t;
        if (r121 == null) goto L67;
        r121.c(r119, r120);
    L67:
        return true;
    L63:
        if (Math.abs(r120) <= this.f329317j) goto L67;
    L8:
        if (r100 == 3) goto L70;
        if (r100 == 5) goto L32;
        if (r100 != 6) goto L69;
        if (r110.getPointerCount() != 2) goto L69;
        if (this.f329311d != 1) goto L69;
        if (r110.getActionIndex() != 0) goto L21;
        r101 = 1;
    L21:
        this.f329311d = 2;
        this.f329314g = true;
        this.f329310c.set(r110.getX(r101), r110.getY(r101));
        c r122 = this.f329327t;
        if (r122 == null) goto L25;
        r122.b();
    L25:
        if (this.f329315h == false) goto L29;
        c r123 = this.f329327t;
        if (r123 == null) goto L29;
        float r124 = this.f329310c.x;
        r123.onDragStart();
    L29:
        this.f329313f = 1.0f;
        return true;
    L32:
        if (r110.getPointerCount() != 2) goto L69;
        this.f329320m.removeCallbacks(this.f329321n);
        ViewParent r125 = getParent();
        if (r125 == null) goto L36;
        r125.requestDisallowInterceptTouchEvent(true);
    L36:
        this.f329312e = j(r110);
        f(this.f329309b, r110);
        this.f329311d = 1;
        this.f329314g = false;
        this.f329316i = false;
        c r126 = this.f329327t;
        if (r126 == null) goto L39;
        r126.d();
    L39:
        return true;
    L70:
        this.f329320m.removeCallbacks(this.f329321n);
        if (this.f329318k == false) goto L73;
    L96:
        return true;
    L73:
        if (this.f329326s == true) goto L96;
        int r127 = this.f329311d;
        if (r127 != 1) goto L86;
        c r128 = this.f329327t;
        if (r128 == null) goto L81;
        r128.b();
    L81:
        if (this.f329315h == false) goto L85;
        c r129 = this.f329327t;
        if (r129 == null) goto L85;
        r129.onDragEnd();
    L85:
        this.f329313f = 1.0f;
    L93:
        this.f329311d = 0;
        ViewParent r130 = getParent();
        if (r130 == null) goto L96;
        r130.requestDisallowInterceptTouchEvent(false);
        goto L96
    L86:
        if (r127 != 2) goto L93;
        if (this.f329314g == false) goto L93;
        c r131 = this.f329327t;
        if (r131 == null) goto L92;
        r131.onDragEnd();
    L92:
        this.f329314g = false;
        goto L93
    }

    public final void setFullscreenMode(boolean r100) {
        this.f329315h = r100;
    }

    public final void setInFullscreenMode(boolean r100) {
        this.f329315h = r100;
    }

    public final void setOnDoubleTapListener(b r100) {
        this.f329329v = r100;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        this.f329328u = r100;
        super.setOnLongClickListener(r100);
    }

    public final void setZoomListener(c r100) {
        this.f329327t = r100;
    }

    public static void f(PointF r100, MotionEvent r101) {
        if (r101.getPointerCount() >= 2) goto L5;
        return;
    L5:
        float r102 = r101.getX(0) + r101.getX(1);
        float r103 = r101.getY(0) + r101.getY(1);
        float r104 = 2;
        r100.set(r102 / r104, r103 / r104);
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.larus.community.impl.detail.image.r] */
    public CreationZoomableDraweeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f329308a = new PointF();
        this.f329309b = new PointF();
        this.f329310c = new PointF();
        this.f329312e = 1.0f;
        this.f329313f = 1.0f;
        this.f329317j = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f329319l = ViewConfiguration.getLongPressTimeout();
        this.f329320m = new Handler(Looper.getMainLooper());
        this.f329321n = new r(this);
        this.f329322o = ViewConfiguration.getDoubleTapTimeout();
        setClickable(true);
        setFocusable(true);
    }

    public /* synthetic */ CreationZoomableDraweeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
