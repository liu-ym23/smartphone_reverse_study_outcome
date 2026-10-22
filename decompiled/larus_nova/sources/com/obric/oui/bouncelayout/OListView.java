package com.obric.oui.bouncelayout;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.OverScroller;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0013\u0014B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/bouncelayout/OListView;", "Landroid/widget/ListView;", "", "Landroid/widget/OverScroller;", "getOverScrollerOrNull", "", "getBounceTranslation", "Lcom/obric/oui/bouncelayout/e;", "listener", "", "setOnBounceTranslationListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OListView extends ListView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f398946t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile b f398947u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BounceEdgeEffect f398948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BounceEdgeEffect f398949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f398950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f398951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f398952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f398953f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f398954g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f398955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f398956i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Field f398957j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Field f398958k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Field f398959l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Field f398960m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f398961n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final BounceTranslationDelegate f398962o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.obric.oui.bouncelayout.b f398963p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.obric.oui.bouncelayout.a f398964q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Field f398965r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Field f398966s;

    public static final class a {
        public static b a() {
            Field r100 = b(AbsListView.class, "mEdgeGlowTop");     // Catch: Throwable -> L19
            if (r100 != null) goto L6;
            r100 = b(AbsListView.class, "mTopGlow");     // Catch: Throwable -> L19
        L6:
            Field r101 = r100;
            Field r102 = b(AbsListView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L19
            if (r102 != null) goto L9;
            r102 = b(AbsListView.class, "mBottomGlow");     // Catch: Throwable -> L19
        L9:
            Field r103 = r102;
            Field r104 = b(AbsListView.class, "mScroller");     // Catch: Throwable -> L19
            Field r105 = b(AbsListView.class, "mFlingRunnable");     // Catch: Throwable -> L19
            if (r105 == null) goto L14;
            Class<?> r106 = r105.getType();     // Catch: Throwable -> L19
            if (r106 == null) goto L14;
            a r107 = OListView.f398946t;     // Catch: Throwable -> L19
            Field r108 = b(r106, "mScroller");     // Catch: Throwable -> L19
        L15:
            Field r109 = r108;
            return new b(r101, r103, r104, r105, r109, b(AbsListView.class, "mTouchMode"));
        L14:
            r108 = null;
        L20:
            return new b(0);
        }

        public a() {
        }

        public static Field b(Class r100, String r101) {
            Field r102 = r100.getDeclaredField(r101);     // Catch: Throwable -> L4
            r102.setAccessible(true);     // Catch: Throwable -> L4
            return r102;
        L5:
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Field f398967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Field f398968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Field f398969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Field f398970d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Field f398971e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Field f398972f;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f398967a, r101.f398967a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f398968b, r101.f398968b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f398969c, r101.f398969c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f398970d, r101.f398970d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f398971e, r101.f398971e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f398972f, r101.f398972f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            Field r100 = this.f398967a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Field r104 = this.f398968b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Field r107 = this.f398969c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Field r110 = this.f398970d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            Field r113 = this.f398971e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            Field r116 = this.f398972f;
            if (r116 == null) goto L27;
            r101 = r116.hashCode();
        L27:
            return r115 + r101;
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReflectionFields(edgeFieldTop=" + this.f398967a + ", edgeFieldBottom=" + this.f398968b + ", scrollerField=" + this.f398969c + ", flingRunnableField=" + this.f398970d + ", flingRunnableScrollerField=" + this.f398971e + ", touchModeField=" + this.f398972f + ')';
        }

        public /* synthetic */ b(int r100) {
            this(null, null, null, null, null, null);
        }

        public b(Field r100, Field r101, Field r102, Field r103, Field r104, Field r105) {
            this.f398967a = r100;
            this.f398968b = r101;
            this.f398969c = r102;
            this.f398970d = r103;
            this.f398971e = r104;
            this.f398972f = r105;
        }
    }

    static {
        f398946t = new a();
    }

    public OListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final OverScroller getOverScrollerOrNull() {
        Field r100 = this.f398957j;     // Catch: Throwable -> L32
        if (r100 != null) goto L6;
        Object r101 = null;
    L8:
        if ((r101 instanceof OverScroller) == false) goto L11;
        OverScroller r102 = (OverScroller) r101;     // Catch: Throwable -> L32
    L12:
        if (r102 == null) goto L34;
        return r102;
    L11:
        r102 = null;
        goto L12
    L6:
        r101 = r100.get(this);     // Catch: Throwable -> L32
    L34:
        Field r103 = this.f398958k;     // Catch: Throwable -> L19
        if (r103 == null) goto L20;
        Object r104 = r103.get(this);     // Catch: Throwable -> L19
    L21:
        if (r104 != null) goto L36;
        return null;
    L36:
        Field r105 = this.f398959l;     // Catch: Throwable -> L33
        if (r105 != null) goto L26;
        Object r106 = null;
    L28:
        if ((r106 instanceof OverScroller) == false) goto L40;
        return (OverScroller) r106;
    L40:
        return null;
    L26:
        r106 = r105.get(r104);     // Catch: Throwable -> L33
    L41:
        return null;
    L20:
        r104 = null;
        goto L21
    }

    public final void c() {
        if (this.f398954g == true) goto L5;
        return;
    L5:
        boolean r100 = b(this.f398948a);
        boolean r101 = b(this.f398949b);
        if (r100 == false) goto L9;
        if (r101 == true) goto L9;
    L18:
        byte r102 = 0;
    L27:
        if (r102 == 0) goto L34;
        if (r102 != 1) goto L38;
        BounceEdgeEffect r103 = this.f398949b;
        if (r103 == null) goto L38;
        r103.onRelease();
    L38:
        this.f398954g = false;
        invalidate();
        return;
    L34:
        BounceEdgeEffect r104 = this.f398948a;
        if (r104 == null) goto L38;
        r104.onRelease();
    L9:
        if (r101 == false) goto L12;
        if (r100 == true) goto L12;
    L25:
        r102 = 1;
    L12:
        BounceEdgeEffect r105 = this.f398948a;
        if (r105 != null) goto L15;
        float r106 = 0.0f;
    L17:
        if (r106 > 0.0f) goto L18;
        BounceEdgeEffect r107 = this.f398949b;
        if (r107 != null) goto L22;
        float r108 = 0.0f;
    L24:
        if (r108 < 0.0f) goto L25;
        r102 = -1;
        goto L27
    L22:
        r108 = r107.f398883f;
        goto L24
    L15:
        r106 = r105.f398883f;
        goto L17
    }

    public final boolean d() {
        if (this.f398950c == true) goto L5;
        return false;
    L5:
        OverScroller r100 = getOverScrollerOrNull();
        BounceEdgeEffect r101 = this.f398948a;
        if (r101 != null) goto L8;
        float r102 = 0.0f;
    L10:
        if (r102 != 0.0f) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L25;
        BounceEdgeEffect r104 = this.f398949b;
        if (r104 != null) goto L17;
        float r105 = 0.0f;
    L19:
        if (r105 != 0.0f) goto L21;
        boolean r106 = true;
    L22:
        if (r106 == false) goto L25;
        boolean r107 = false;
    L26:
        if (r101 != null) goto L29;
    L31:
        boolean r108 = false;
    L32:
        if (r108 == true) goto L43;
        BounceEdgeEffect r109 = this.f398949b;
        if (r109 != null) goto L37;
    L39:
        boolean r110 = false;
    L40:
        if (r110 == true) goto L43;
        boolean r111 = false;
    L44:
        if (r107 == true) goto L49;
        if (r111 == true) goto L49;
        this.f398951d = 0.0f;
        this.f398952e = 0;
        this.f398953f = computeVerticalScrollOffset();
        return false;
    L49:
        if (r100 != null) goto L52;
    L54:
        boolean r112 = false;
    L55:
        if (r112 == false) goto L59;
        if (r100 == null) goto L59;
        r100.abortAnimation();
    L59:
        Runnable r113 = null;
        Field r114 = this.f398958k;     // Catch: Throwable -> L92
        if (r114 != null) goto L63;
        Object r115 = null;
    L65:
        if ((r115 instanceof Runnable) == false) goto L68;
        Runnable r116 = (Runnable) r115;     // Catch: Throwable -> L92
    L69:
        if (r116 == null) goto L95;
    L79:
        r113 = r116;
    L80:
        if (r113 == null) goto L82;
        removeCallbacks(r113);
    L82:
        BounceEdgeEffect r117 = this.f398948a;
        if (r117 == null) goto L86;
        r117.q();
    L86:
        BounceEdgeEffect r118 = this.f398949b;
        if (r118 == null) goto L90;
        r118.q();
    L90:
        invalidate();
        this.f398951d = 0.0f;
        this.f398952e = 0;
        this.f398953f = computeVerticalScrollOffset();
        return true;
    L95:
        Field r119 = this.f398958k;     // Catch: Throwable -> L78
        if (r119 != null) goto L73;
        Object r120 = null;
    L75:
        if ((r120 instanceof Runnable) == false) goto L80;
        r116 = (Runnable) r120;     // Catch: Throwable -> L78
    L73:
        r120 = r119.get(this);     // Catch: Throwable -> L78
        goto L75
    L63:
        r115 = r114.get(this);     // Catch: Throwable -> L92
    L68:
        r116 = null;
        goto L69
    L52:
        if (r100.isFinished() == true) goto L54;
        r112 = true;
        goto L55
    L37:
        if (r109.isFinished() == true) goto L39;
        r110 = true;
    L43:
        r111 = true;
        goto L44
    L29:
        if (r101.isFinished() == true) goto L31;
        r108 = true;
        goto L32
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = r104.f398883f;
    L25:
        r107 = true;
        goto L26
    L12:
        r103 = false;
        goto L13
    L8:
        r102 = r101.f398883f;
        goto L10
    }

    public float getBounceTranslation() {
        BounceEdgeEffect r100 = this.f398948a;
        float r101 = 0.0f;
        if (r100 != null) goto L5;
        float r102 = 0.0f;
    L6:
        BounceEdgeEffect r103 = this.f398949b;
        if (r103 == null) goto L11;
        r101 = r103.f398883f;
    L11:
        return r102 + r101;
    L5:
        r102 = r100.f398883f;
        goto L6
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.f398950c == true) goto L6;
        return;
    L6:
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) goto L8;
        return;
    L8:
        int r100 = computeVerticalScrollOffset();
        OverScroller r101 = getOverScrollerOrNull();
        boolean r102 = true;
        if (r101 != null) goto L11;
    L66:
        float r103 = this.f398951d;
        if (r103 <= 0.0f) goto L81;
        boolean r104 = !canScrollList(-1);
        boolean r105 = true ^ canScrollList(1);
        int r106 = this.f398952e;
        if (r106 >= 0) goto L75;
        if (r104 == false) goto L75;
        BounceEdgeEffect r107 = this.f398948a;
        if (r107 == null) goto L81;
        r107.onAbsorb((int) r103);
    L75:
        if (r106 <= 0) goto L81;
        if (r105 == false) goto L81;
        BounceEdgeEffect r108 = this.f398949b;
        if (r108 == null) goto L81;
        r108.onAbsorb(-((int) r103));
    L81:
        this.f398951d = 0.0f;
        this.f398952e = 0;
        this.f398953f = r100;
        return;
    L11:
        if (r101.isFinished() == true) goto L66;
        float r109 = r101.getCurrVelocity();
        this.f398951d = r109;
        int r110 = r100 - this.f398953f;
        if (r110 <= 0) goto L15;
        this.f398952e = 1;
    L17:
        int r111 = c.f399049a;
        this.f398953f = r100;
        if (r109 <= 0.0f) goto L86;
        boolean r112 = !canScrollList(-1);
        boolean r113 = !canScrollList(1);
        if (this.f398952e >= 0) goto L36;
        if (r112 == false) goto L36;
        BounceEdgeEffect r114 = this.f398948a;
        if (r114 != null) goto L27;
    L29:
        boolean r115 = false;
    L30:
        if (r115 == false) goto L36;
        BounceEdgeEffect r116 = this.f398948a;
        if (r116 == null) goto L51;
        r116.onAbsorb((int) r109);
    L51:
        if (r102 == false) goto L85;
        r101.abortAnimation();
        Runnable r117 = null;
        Field r118 = this.f398958k;     // Catch: Throwable -> L61
        if (r118 != null) goto L56;
        Object r119 = null;
    L58:
        if ((r119 instanceof Runnable) == false) goto L62;
        r117 = (Runnable) r119;     // Catch: Throwable -> L61
        goto L62
    L56:
        r119 = r118.get(this);     // Catch: Throwable -> L61
    L62:
        if (r117 == null) goto L64;
        removeCallbacks(r117);
    L64:
        this.f398951d = 0.0f;
        this.f398952e = 0;
        invalidate();
        return;
    L85:
        return;
    L27:
        if (r114.isFinished() != true) goto L29;
        r115 = true;
    L36:
        if (this.f398952e <= 0) goto L50;
        if (r113 == false) goto L50;
        BounceEdgeEffect r120 = this.f398949b;
        if (r120 != null) goto L42;
    L44:
        boolean r121 = false;
    L45:
        if (r121 == false) goto L50;
        BounceEdgeEffect r122 = this.f398949b;
        if (r122 == null) goto L51;
        r122.onAbsorb(-((int) r109));
        goto L51
    L42:
        if (r120.isFinished() != true) goto L44;
        r121 = true;
    L50:
        r102 = false;
        goto L51
    L86:
        return;
    L15:
        if (r110 >= 0) goto L17;
        this.f398952e = -1;
        goto L17
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BounceEdgeEffect r100 = this.f398948a;
        if (r100 == null) goto L6;
        r100.c();
    L6:
        BounceEdgeEffect r101 = this.f398949b;
        if (r101 == null) goto L11;
        r101.c();
        return;
    }

    public static boolean b(BounceEdgeEffect r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getDistance() != 0.0f) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
    L16:
        return true;
    L10:
        if (r100.f398883f != 0.0f) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L16;
        if (r100.isFinished() == false) goto L16;
        return false;
    L12:
        r102 = false;
        goto L13
    L7:
        r101 = false;
        goto L8
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        BounceEdgeEffect r101 = this.f398948a;
        if (r101 != null) goto L7;
        float r102 = 0.0f;
    L8:
        BounceEdgeEffect r103 = this.f398949b;
        if (r103 != null) goto L11;
        float r104 = 0.0f;
    L12:
        float r105 = r102 + r104;
        if (r105 != 0.0f) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == true) goto L18;
        int r107 = r100.save();
        r100.translate(0.0f, r105);
        super.dispatchDraw(r100);
        r100.restoreToCount(r107);
        return;
    L18:
        super.dispatchDraw(r100);
        return;
    L15:
        r106 = false;
        goto L16
    L11:
        r104 = r103.f398883f;
        goto L12
    L7:
        r102 = r101.f398883f;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(final MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        this.f398963p.c(r100);
        com.obric.oui.bouncelayout.b r101 = this.f398963p;
        Boolean r102 = r101.b(r100, 0.0f, -r101.f399043e, new OListView$dispatchTouchEvent$handled$1(this, r100));
        if (r102 != null) goto L5;
        boolean r103 = super.dispatchTouchEvent(r100);
    L7:
        if (r100.getActionMasked() != 1) goto L9;
    L10:
        c();
    L11:
        return r103;
    L9:
        if (r100.getActionMasked() != 3) goto L11;
    L5:
        r103 = r102.booleanValue();
        goto L7
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getActionMasked();
        boolean r102 = true;
        if (r101 == 0) goto L35;
        if (r101 != 1) goto L6;
    L27:
        com.obric.oui.bouncelayout.a r103 = this.f398964q;
        r103.f399033o = false;
        r103.f399034p = -1;
        r103.f399038t = -1;
        VelocityTracker r104 = r103.f399037s;
        if (r104 == null) goto L31;
        r104.recycle();
    L31:
        r103.f399037s = null;
        c();
    L33:
        return super.onInterceptTouchEvent(r100);
    L6:
        if (r101 == 2) goto L21;
        if (r101 == 3) goto L27;
        if (r101 == 5) goto L18;
        if (r101 != 6) goto L33;
        if (this.f398964q.e(r100) == false) goto L33;
        return true;
    L18:
        if (this.f398964q.d(r100) == false) goto L33;
        return true;
    L21:
        if (this.f398963p.d(r100) == false) goto L23;
        return false;
    L23:
        com.obric.oui.bouncelayout.a r105 = this.f398964q;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r105.n(r100) == false) goto L33;
        this.f398954g = false;
        return true;
    L35:
        if (d() == false) goto L37;
    L40:
        this.f398954g = r102;
        this.f398964q.c(r100);
        boolean r106 = super.onInterceptTouchEvent(r100);
        if (this.f398963p.d(r100) == false) goto L43;
        return false;
    L43:
        return r106;
    L37:
        if (this.f398954g == true) goto L40;
        r102 = false;
        goto L40
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getActionMasked();
        boolean r102 = false;
        if (r101 == 0) goto L30;
        if (r101 == 1) goto L25;
        if (r101 == 2) goto L21;
        if (r101 == 3) goto L25;
        if (r101 == 5) goto L18;
        if (r101 != 6) goto L38;
        if (this.f398964q.e(r100) == false) goto L38;
        return true;
    L38:
        return super.onTouchEvent(r100);
    L18:
        if (this.f398964q.d(r100) == false) goto L38;
        return true;
    L21:
        if (this.f398964q.h(r100) == false) goto L38;
        this.f398954g = false;
        return true;
    L25:
        if (this.f398964q.g(r100) == false) goto L28;
        this.f398954g = false;
        return true;
    L28:
        c();
        goto L38
    L30:
        if (d() == false) goto L32;
    L33:
        r102 = true;
    L34:
        this.f398954g = r102;
        if (this.f398964q.f(r100) == false) goto L38;
        return true;
    L32:
        if (this.f398954g == false) goto L34;
        goto L33
    }

    public void setOnBounceTranslationListener(e r100) {
        BounceTranslationDelegate r101 = this.f398962o;
        r101.f398910c = r100;
        r101.a();
    }

    public static final /* synthetic */ boolean a(OListView r100, MotionEvent r101) {
        return super.dispatchTouchEvent(r101);
    }

    public OListView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        d r113 = new d(new OListView$overscrollDelegate$1(this), new OListView$overscrollDelegate$2(this));
        this.f398961n = r113;
        BounceTranslationDelegate r114 = new BounceTranslationDelegate(new OListView$translationDelegate$1(this), new OListView$translationDelegate$2(this));
        this.f398962o = r114;
        this.f398963p = new com.obric.oui.bouncelayout.b(this, new OListView$clickDuringOverScrollDelegate$1(this), new OListView$clickDuringOverScrollDelegate$2(this));
        this.f398964q = new com.obric.oui.bouncelayout.a(this, new OListView$bounceGestureDelegate$1(this), new OListView$bounceGestureDelegate$2(this), new OListView$bounceGestureDelegate$3(this), new OListView$bounceGestureDelegate$4(this), new OListView$bounceGestureDelegate$5(this), new OListView$bounceGestureDelegate$6(this));
        setOverScrollMode(0);
        WeakHashMap<View, BounceEdgeEffect.a.C4666a> r100 = BounceEdgeEffect.f398877u;
        BounceEdgeEffect.a.a("Landroid/widget/AbsListView;");
        a r101 = f398946t;
        b r102 = f398947u;
        if (r102 != null) goto L13;
        monitor-enter(r101);
        r102 = f398947u;     // Catch: Throwable -> L10
        if (r102 != null) goto L8;
        r102 = a.a();     // Catch: Throwable -> L10
        f398947u = r102;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);
    L10:
        th = move-exception;
        throw th;
    L13:
        Field r103 = r102.f398967a;
        this.f398965r = r103;
        Field r104 = r102.f398968b;
        this.f398966s = r104;
        this.f398957j = r102.f398969c;
        this.f398958k = r102.f398970d;
        this.f398959l = r102.f398971e;
        this.f398960m = r102.f398972f;
        if (r103 == null) goto L63;
        if (r104 == null) goto L64;
    L30:
        Field r115 = this.f398965r;
        Field r116 = this.f398966s;
        if (r115 != null) goto L61;
    L35:
        if (r116 == null) goto L47;
        Object r117 = this.f398956i;     // Catch: Throwable -> L40
        if (r117 == null) goto L47;
        r116.set(this, r117);     // Catch: Throwable -> L40
    L40:
        BounceEdgeEffect r118 = this.f398948a;
        if (r118 == null) goto L44;
        r118.c();
    L44:
        BounceEdgeEffect r119 = this.f398949b;
        if (r119 == null) goto L55;
    L54:
        r119.c();
    L55:
        this.f398948a = null;
        this.f398949b = null;
        this.f398950c = false;
        return;
    L47:
        BounceEdgeEffect r120 = this.f398948a;
        if (r120 == null) goto L51;
        r120.c();
    L51:
        r119 = this.f398949b;
        if (r119 != null) goto L54;
    L61:
        Object r105 = this.f398955h;     // Catch: Throwable -> L40
        if (r105 == null) goto L35;
        r115.set(this, r105);     // Catch: Throwable -> L40
        goto L35
    L18:
        if (this.f398955h != null) goto L21;
        this.f398955h = r103.get(this);     // Catch: Throwable -> L30
    L21:
        if (this.f398956i != null) goto L23;
        this.f398956i = r104.get(this);     // Catch: Throwable -> L30
    L23:
        r113.b();     // Catch: Throwable -> L30
        BounceEdgeEffect r106 = new BounceEdgeEffect(getContext(), this, 0, r113.f399052c);     // Catch: Throwable -> L30
        BounceEdgeEffect r107 = new BounceEdgeEffect(getContext(), this, 1, r113.f399052c);     // Catch: Throwable -> L30
        if (getWidth() > 0) goto L26;
    L28:
        r103.set(this, r106);     // Catch: Throwable -> L30
        r104.set(this, r107);     // Catch: Throwable -> L30
        this.f398948a = r106;     // Catch: Throwable -> L30
        this.f398949b = r107;     // Catch: Throwable -> L30
        r113.a();     // Catch: Throwable -> L30
        r114.a();     // Catch: Throwable -> L30
        this.f398950c = true;     // Catch: Throwable -> L30
        return;
    L26:
        if (getHeight() <= 0) goto L28;
        r106.setSize(getWidth(), getHeight());     // Catch: Throwable -> L30
        r107.setSize(getWidth(), getHeight());     // Catch: Throwable -> L30
        goto L28
    L64:
        return;
    }

    public /* synthetic */ OListView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = R.attr.listViewStyle;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f398961n.b();
        BounceEdgeEffect r104 = this.f398948a;
        if (r104 == null) goto L6;
        r104.setSize(r100, r101);
    L6:
        BounceEdgeEffect r105 = this.f398949b;
        if (r105 == null) goto L11;
        r105.setSize(r100, r101);
        return;
    }
}
