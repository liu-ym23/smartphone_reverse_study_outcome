package com.ss.android.lark.floating.widget.activityfloat;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.ss.android.lark.floating.enums.SidePattern;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wfb.d;
import wfb.f;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010'\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0004J0\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0015J\b\u0010.\u001a\u00020\rH\u0002J\u0012\u0010/\u001a\u00020&2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020&2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00103\u001a\u00020\r2\u0006\u00100\u001a\u000201H\u0002J\b\u00104\u001a\u00020\rH\u0002J\b\u00105\u001a\u00020\rH\u0002J$\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u000208H\u0002J\b\u0010;\u001a\u00020\rH\u0002J\b\u0010<\u001a\u00020\rH\u0002J\r\u0010=\u001a\u00020\rH\u0000¢\u0006\u0002\b>J\b\u0010?\u001a\u00020\rH\u0014R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/ss/android/lark/floating/widget/activityfloat/AbstractDragFloatingView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getLayoutId", "()Ljava/lang/Integer;", "renderView", "", "view", "Landroid/view/View;", "config", "Lcom/ss/android/lark/floating/data/FloatConfig;", "getConfig", "()Lcom/ss/android/lark/floating/data/FloatConfig;", "setConfig", "(Lcom/ss/android/lark/floating/data/FloatConfig;)V", "parentHeight", "parentWidth", "lastX", "lastY", "leftDistance", "rightDistance", "topDistance", "bottomDistance", "minX", "minY", "parentRect", "Landroid/graphics/Rect;", "floatRect", "parentView", "Landroid/view/ViewGroup;", "isCreated", "", "initView", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "initParent", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "updateView", "touchOver", "sideAnim", "sideForLatest", "Lkotlin/Pair;", "", "x", "y", "initDistanceValue", "enterAnim", "exitAnim", "exitAnim$float_release", "onDetachedFromWindow", "float_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractDragFloatingView extends FrameLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f421857p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vfb.a f421858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f421859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f421860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f421861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f421862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f421863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f421864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f421865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f421866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f421867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f421868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f421869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f421870m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewGroup f421871n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f421872o;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f421873a = null;

        static {
            f421873a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f421874a = null;

        static {
            int[] r100 = new int[SidePattern.values().length];
            r100[SidePattern.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L49:
            r100[SidePattern.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L59:
            r100[SidePattern.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L37:
            r100[SidePattern.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[SidePattern.AUTO_HORIZONTAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L45:
            r100[SidePattern.AUTO_VERTICAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L55:
            r100[SidePattern.AUTO_SIDE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L41:
            r100[SidePattern.RESULT_LEFT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L51:
            r100[SidePattern.RESULT_RIGHT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L27
        L53:
            r100[SidePattern.RESULT_TOP.ordinal()] = 10;     // Catch: NoSuchFieldError -> L28
        L35:
            r100[SidePattern.RESULT_BOTTOM.ordinal()] = 11;     // Catch: NoSuchFieldError -> L29
        L47:
            r100[SidePattern.RESULT_HORIZONTAL.ordinal()] = 12;     // Catch: NoSuchFieldError -> L30
        L57:
            r100[SidePattern.RESULT_VERTICAL.ordinal()] = 13;     // Catch: NoSuchFieldError -> L31
        L33:
            r100[SidePattern.RESULT_SIDE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L32
        L17:
            f421874a = r100;
        }
    }

    public abstract void d(View r100);

    public abstract Integer getLayoutId();

    public final void a() {
        getGlobalVisibleRect(this.f421870m);
        Rect r100 = this.f421870m;
        int r101 = r100.left;
        Rect r102 = this.f421869l;
        int r103 = r101 - r102.left;
        this.f421863f = r103;
        int r104 = r102.right - r100.right;
        this.f421864g = r104;
        this.f421865h = r100.top - r102.top;
        this.f421866i = r102.bottom - r100.bottom;
        this.f421867j = Math.min(r103, r104);
        this.f421868k = Math.min(this.f421865h, this.f421866i);
        Log.i(this.f421863f + "   " + this.f421864g + "   " + this.f421865h + "   " + this.f421866i);
    }

    public final void e() {
        vfb.a r100 = this.f421858a;
        r100.f554615j = false;
        r100.f554614i = false;
        r100.getClass();
        wfb.a r101 = this.f421858a.B;
        if (r101 == null) goto L10;
        wfb.a.C8107a r102 = r101.a();
        if (r102 == null) goto L11;
        Function1<? super View, Unit> r103 = r102.f559501e;
        if (r103 == null) goto L12;
        r103.invoke(this);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void b() {
        ViewParent r100 = getParent();
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof ViewGroup) == false) goto L9;
        ViewGroup r101 = (ViewGroup) r100;
        this.f421871n = r101;
        this.f421859b = r101.getHeight();
        this.f421860c = r101.getWidth();
        r101.getGlobalVisibleRect(this.f421869l);
        Log.e("parentRect: " + this.f421869l);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f421858a.getClass();
        wfb.a r100 = this.f421858a.B;
        if (r100 == null) goto L10;
        wfb.a.C8107a r101 = r100.a();
        if (r101 == null) goto L11;
        Function0<Unit> r102 = r101.f559498b;
        if (r102 == null) goto L12;
        r102.invoke();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final vfb.a getConfig() {
        return this.f421858a;
    }

    public final void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r101 = getLayoutId();
        if (r101 == null) goto L8;
        d(LayoutInflater.from(r100).inflate(r101.intValue(), this));
        f r102 = this.f421858a.A;
        if (r102 == null) goto L9;
        r102.a(this);
        return;
    L9:
        return;
    }

    public final void f(MotionEvent r110) {
        this.f421858a.getClass();
        wfb.a r100 = this.f421858a.B;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        vfb.a r101 = this.f421858a;
        if (r101.f554613h == true) goto L8;
    L106:
        r101.f554614i = false;
        setPressed(true);
        return;
    L8:
        if (r101.f554615j == true) goto L106;
        int r102 = (int) r110.getRawX();
        int r103 = (int) r110.getRawY();
        int r111 = r110.getAction() & 255;
        if (r111 == 0) goto L104;
        float r104 = 0.0f;
        if (r111 == 1) goto L67;
        if (r111 == 2) goto L17;
        return;
    L17:
        if (this.f421859b > 0) goto L19;
        return;
    L19:
        if (this.f421860c <= 0) goto L108;
        int r112 = r102 - this.f421861d;
        int r105 = r103 - this.f421862e;
        vfb.a r106 = this.f421858a;
        if (r106.f554614i == false) goto L24;
    L26:
        r106.f554614i = true;
        float r107 = getX() + r112;
        float r113 = getY() + r105;
        if (r107 >= 0.0f) goto L30;
        r107 = 0.0f;
    L33:
        if (r113 >= 0.0f) goto L36;
        r113 = 0.0f;
    L39:
        switch(b.f421874a[this.f421858a.f554618m.ordinal()]) {
            case 1: goto L63;
            case 2: goto L62;
            case 3: goto L61;
            case 4: goto L58;
            case 5: goto L55;
            case 6: goto L52;
            case 7: goto L41;
            default: goto L60;
        };
    L41:
        Rect r108 = this.f421869l;
        int r109 = r102 - r108.left;
        this.f421863f = r109;
        int r114 = r108.right - r102;
        this.f421864g = r114;
        this.f421865h = r103 - r108.top;
        this.f421866i = r108.bottom - r103;
        this.f421867j = Math.min(r109, r114);
        int r115 = Math.min(this.f421865h, this.f421866i);
        this.f421868k = r115;
        int r116 = this.f421867j;
        if (r116 >= r115) goto L48;
        if (this.f421863f == r116) goto L51;
        r104 = this.f421860c - getWidth();
    L51:
        Pair r117 = new Pair(Float.valueOf(r104), Float.valueOf(r113));
        r104 = ((Number) r117.getFirst()).floatValue();
        r113 = ((Number) r117.getSecond()).floatValue();
        goto L63
    L48:
        if (this.f421865h != r115) goto L50;
        r104 = r107;
        r113 = 0.0f;
        goto L51
    L50:
        r113 = this.f421859b - getHeight();
        r104 = r107;
        goto L51
    L52:
        Rect r118 = this.f421869l;
        int r119 = r103 - r118.top;
        int r120 = r118.bottom;
        if (r119 <= (r120 - r103)) goto L59;
        r104 = r120 - getHeight();
    L59:
        r113 = r104;
        goto L60
    L55:
        Rect r121 = this.f421869l;
        int r122 = (r102 * 2) - r121.left;
        int r123 = r121.right;
        if (r122 <= r123) goto L63;
        r104 = r123 - getWidth();
        goto L63
    L58:
        r104 = this.f421869l.bottom - getHeight();
        goto L59
    L61:
        r104 = r107;
        r113 = 0.0f;
        goto L63
    L62:
        r104 = this.f421869l.right - getWidth();
    L63:
        setX(r104);
        setY(r113);
        this.f421861d = r102;
        this.f421862e = r103;
        this.f421858a.getClass();
        wfb.a r124 = this.f421858a.B;
        if (r124 == null) goto L109;
        r124.a();
        return;
    L109:
        return;
    L60:
        r104 = r107;
        goto L63
    L36:
        if (r113 <= (this.f421859b - getHeight())) goto L39;
        r113 = this.f421859b - getHeight();
        goto L39
    L30:
        if (r107 <= (this.f421860c - getWidth())) goto L33;
        r107 = this.f421860c - getWidth();
        goto L33
    L24:
        if (((r112 * r112) + (r105 * r105)) >= 81) goto L26;
        return;
    L108:
        return;
    L67:
        setPressed(!this.f421858a.f554614i);
        vfb.a r125 = this.f421858a;
        if (r125.f554614i == false) goto L111;
        SidePattern r126 = r125.f554618m;
        int[] r127 = b.f421874a;
        switch(r127[r126.ordinal()]) {
            case 8: goto L72;
            case 9: goto L72;
            case 10: goto L72;
            case 11: goto L72;
            case 12: goto L72;
            case 13: goto L72;
            case 14: goto L72;
            default: goto L71;
        };
    L71:
        e();
        return;
    L72:
        a();
        int r128 = r127[this.f421858a.f554618m.ordinal()];
        String r129 = LiveDegradeFpsAnimator.TRANSLATION_X;
        switch(r128) {
            case 8: goto L101;
            case 9: goto L100;
            case 10: goto L98;
            case 11: goto L97;
            case 12: goto L92;
            case 13: goto L87;
            case 14: goto L76;
            default: goto L74;
        };
    L74:
        float r130 = 0.0f;
    L103:
        ObjectAnimator r131 = ObjectAnimator.ofFloat(this, r129, new float[]{r104, r130});
        r131.addListener(new yfb.b(this));
        r131.start();
        return;
    L87:
        float r132 = getTranslationY();
        int r133 = this.f421865h;
        int r134 = this.f421866i;
        if (r133 >= r134) goto L90;
        float r135 = -r133;
    L91:
        float r136 = getTranslationY();
    L99:
        r104 = r132;
        r130 = r135 + r136;
        r129 = LiveDegradeFpsAnimator.TRANSLATION_Y;
        goto L103
    L90:
        r135 = r134;
        goto L91
    L92:
        float r137 = getTranslationX();
        int r138 = this.f421863f;
        int r139 = this.f421864g;
        if (r138 >= r139) goto L95;
        float r140 = -r138;
    L96:
        float r141 = getTranslationX();
    L102:
        float r142 = r141 + r140;
        r104 = r137;
        r130 = r142;
        goto L103
    L95:
        r140 = r139;
        goto L96
    L97:
        r132 = getTranslationY();
        r135 = this.f421866i;
        r136 = getTranslationY();
        goto L99
    L98:
        r132 = getTranslationY();
        r135 = -this.f421865h;
        r136 = getTranslationY();
        goto L99
    L100:
        r137 = getTranslationX();
        r140 = this.f421864g;
        r141 = getTranslationX();
        goto L102
    L101:
        r137 = getTranslationX();
        r140 = -this.f421863f;
        r141 = getTranslationX();
        goto L102
    L76:
        if (this.f421867j >= this.f421868k) goto L82;
        r137 = getTranslationX();
        int r143 = this.f421863f;
        int r144 = this.f421864g;
        if (r143 >= r144) goto L80;
        r140 = -r143;
    L81:
        r141 = getTranslationX();
        goto L102
    L80:
        r140 = r144;
        goto L81
    L82:
        r132 = getTranslationY();
        int r145 = this.f421865h;
        int r146 = this.f421866i;
        if (r145 >= r146) goto L85;
        r135 = -r145;
    L86:
        r136 = getTranslationY();
        goto L99
    L85:
        r135 = r146;
        goto L86
    L111:
        return;
    L104:
        this.f421858a.f554614i = false;
        setPressed(true);
        this.f421861d = r102;
        this.f421862e = r103;
        getParent().requestDisallowInterceptTouchEvent(true);
        b();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L5;
        f(r100);
    L5:
        if (this.f421858a.f554614i == false) goto L7;
    L10:
        return true;
    L7:
        if (super.onInterceptTouchEvent(r100) == true) goto L10;
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L5;
        f(r100);
    L5:
        if (this.f421858a.f554614i == false) goto L7;
    L10:
        return true;
    L7:
        if (super.onTouchEvent(r100) == true) goto L10;
        return false;
    }

    public final void setConfig(vfb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f421858a = r100;
    }

    public AbstractDragFloatingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f421869l = new Rect();
        this.f421870m = new Rect();
        new FrameLayout(r100, r101, r102);
        this.f421858a = new vfb.a(null);
        c(r100);
        setOnClickListener(a.f421873a);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f421872o == true) goto L20;
        this.f421872o = true;
        if (Intrinsics.areEqual(this.f421858a.f554630y, new Pair(0, 0)) == true) goto L7;
        setX(this.f421858a.f554630y.getFirst().intValue());
        setY(this.f421858a.f554630y.getSecond().intValue());
    L8:
        b();
        a();
        ViewGroup r105 = this.f421871n;
        if (r105 == null) goto L22;
        vfb.a r106 = this.f421858a;
        d r107 = r106.C;
        SidePattern r108 = r106.f554618m;
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r105, "parentView");
        Intrinsics.checkNotNullParameter(r108, "sidePattern");
        if (r107 == null) goto L14;
        Animator r109 = r107.a(this, r105, r108);
    L15:
        if (r109 == null) goto L17;
        r109.addListener(new yfb.a(this));
    L17:
        if (r109 == null) goto L21;
        r109.start();
        return;
    L21:
        return;
    L14:
        r109 = null;
        goto L15
    L22:
        return;
    L7:
        setX(getX() + this.f421858a.f554627v.getFirst().floatValue());
        setY(getY() + this.f421858a.f554627v.getSecond().floatValue());
        goto L8
    }
}
