package wr4;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.bytedance.ee.bear.browser.view.NestedScrollWebViewV2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements NestedScrollWebViewV2.b, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f560809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NestedScrollWebViewV2 f560810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f560811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f560812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f560813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f560814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f560815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f560816h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f560817i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f560818j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f560819k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f560820l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final GestureDetector f560821m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f560822n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f560823o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f560824p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f560825q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f560826r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f560827s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public MotionEvent f560828t;

    /* JADX INFO: renamed from: wr4.a$a, reason: collision with other inner class name */
    public static final class C8153a {
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f560829a;

        public b(a r100) {
            this.f560829a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            a r101 = this.f560829a;
            r101.f560822n = true;
            r101.d(null);
            tt5.a.h("ElasticCollapsedStrategy", "onLongPress true");
        }
    }

    static {
    }

    @Override // wr4.c
    public final boolean a() {
        return this.f560825q;
    }

    public final Context getContext() {
        return this.f560809a;
    }

    @Override // wr4.c
    public final void b(boolean r100) {
        tt5.a.h("ElasticCollapsedStrategy", "setNestedScrollEnable: " + r100);
        this.f560825q = r100;
    }

    @Override // wr4.c
    public final void c(boolean r100) {
        tt5.a.h("ElasticCollapsedStrategy", "setWebContentTop: " + r100);
        this.f560824p = r100;
    }

    public final void d(MotionEvent r100) {
        MotionEvent r101 = this.f560828t;
        if (r101 == null) goto L16;
        NestedScrollWebViewV2 r102 = this.f560810b;
        if (r100 == null) goto L8;
        r101 = r100;
    L8:
        r102.u(r101);
        if (r100 == null) goto L11;
        r100.recycle();
    L11:
        MotionEvent r103 = this.f560828t;
        if (r103 == null) goto L14;
        r103.recycle();
    L14:
        this.f560828t = null;
        return;
    }

    @Override // com.bytedance.ee.bear.browser.view.NestedScrollWebViewV2.b
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return this.f560810b.t(r100);
    }

    @Override // com.bytedance.ee.bear.browser.view.NestedScrollWebViewV2.b
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        if (this.f560825q == true) goto L7;
        return this.f560810b.u(r110);
    L7:
        if (r110.getAction() != 0) goto L10;
        this.f560822n = false;
    L10:
        if (this.f560823o != 0) goto L13;
        this.f560821m.onTouchEvent(r110);
    L13:
        if (this.f560822n == true) goto L15;
        int r100 = r110.getActionMasked();
        if (r100 != 0) goto L19;
        this.f560823o = 0;
        this.f560813e = r110.getY();
        r110.getX();
        this.f560811c = r110.getX();
        this.f560812d = r110.getY();
        this.f560826r = false;
        this.f560827s = false;
        this.f560828t = MotionEvent.obtain(r110);
        this.f560810b.startNestedScroll(2);
    L91:
        if (r110.getAction() != 0) goto L93;
        return true;
    L93:
        return this.f560810b.u(r110);
    L19:
        if (r100 == 1) goto L74;
        if (r100 == 2) goto L23;
        if (r100 == 3) goto L74;
    L23:
        this.f560814f = r110.getX();
        float r101 = r110.getY();
        this.f560815g = r101;
        this.f560816h = this.f560813e - r101;
        float r102 = this.f560812d - r101;
        float r103 = this.f560811c - this.f560814f;
        if (Math.abs(r103) > this.f560820l) goto L28;
        if (Math.abs(r102) > this.f560820l) goto L28;
    L34:
        tt5.a.h("ElasticCollapsedStrategy", "lock direction:" + this.f560823o + ", yTotalDiff:" + r102 + ", xTotlaDiff:" + r103 + " thisTouchY:" + this.f560815g + ", lashTouchY:" + this.f560813e);
        int r104 = this.f560823o;
        if (r104 == 1) goto L37;
        if (r104 != 2) goto L73;
        r110.offsetLocation(0.0f, -(r110.getY() - this.f560812d));
        d(null);
        return this.f560810b.u(r110);
    L73:
        return true;
    L37:
        if (this.f560810b.dispatchNestedPreScroll(0, (int) this.f560816h, this.f560818j, this.f560819k) == false) goto L39;
        this.f560826r = true;
        float r105 = this.f560816h - this.f560818j[1];
    L40:
        this.f560817i = r105;
        if (0.0f >= this.f560816h) goto L43;
        boolean r106 = true;
    L45:
        if (Math.abs(r105) >= 1.0f) goto L47;
        boolean r107 = true;
    L48:
        if (r106 == false) goto L51;
        if (r107 == false) goto L55;
    L56:
        boolean r108 = false;
    L57:
        if (r107 == true) goto L59;
        this.f560813e = this.f560815g - this.f560819k[1];
    L59:
        tt5.a.h("ElasticCollapsedStrategy", "one y move: originDiffY:" + this.f560816h + ", overplusDiffY:" + this.f560817i + " scrollUp: " + r106 + " consumeAll:" + r107 + " isWebContentTop:" + this.f560824p + ", webviewScroll:" + r108);
        r110.offsetLocation(0.0f, (float) this.f560819k[1]);
        if (r108 == false) goto L67;
        r110.offsetLocation(-(this.f560814f - this.f560811c), 0.0f);
        this.f560827s = true;
        if (this.f560828t == null) goto L65;
        MotionEvent r109 = MotionEvent.obtain(r110);
        r109.setAction(0);
        d(r109);
    L65:
        return this.f560810b.u(r110);
    L67:
        if (this.f560810b.dispatchNestedScroll(0, 0, 0, (int) this.f560817i, this.f560819k) == false) goto L69;
        this.f560826r = true;
        this.f560813e -= this.f560819k[1];
    L69:
        return true;
    L55:
        r108 = true;
        goto L57
    L51:
        if (r107 == true) goto L56;
        if (this.f560824p == true) goto L56;
    L47:
        r107 = false;
        goto L48
    L43:
        r106 = false;
        goto L45
    L39:
        r105 = this.f560816h;
    L28:
        if (this.f560823o != 0) goto L34;
        if (Math.abs(r103) <= Math.abs(r102)) goto L32;
        int r111 = 2;
    L33:
        this.f560823o = r111;
        goto L34
    L32:
        r111 = 1;
    L74:
        this.f560823o = 0;
        this.f560810b.stopNestedScroll();
        if (this.f560826r == true) goto L77;
    L87:
        d(null);
        return this.f560810b.u(r110);
    L77:
        if (this.f560827s == true) goto L87;
        r110.setAction(3);
        MotionEvent r112 = this.f560828t;
        if (r112 == null) goto L81;
        float r113 = r112.getX();
    L82:
        MotionEvent r114 = this.f560828t;
        if (r114 == null) goto L85;
        float r115 = r114.getY();
    L86:
        r110.setLocation(r113, r115);
        goto L87
    L85:
        r115 = r110.getY();
        goto L86
    L81:
        r113 = r110.getX();
        goto L82
    L15:
        return this.f560810b.u(r110);
    }

    public a(Context r100, NestedScrollWebViewV2 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "nestedScrollWebViewV2");
        this.f560809a = r100;
        this.f560810b = r101;
        this.f560818j = new int[2];
        this.f560819k = new int[2];
        this.f560820l = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f560821m = new GestureDetector(r100, new b(this));
        this.f560824p = true;
    }
}
