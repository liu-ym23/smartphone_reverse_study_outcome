package iwb;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes37.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f496259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f496260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f496261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f496262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f496263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f496264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f496265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f496266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f496267i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f496268j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f496269k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f496270l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public iwb.b f496271m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function0<Unit> f496272n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super hwb.d, Unit> f496273o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f496274p;

    /* JADX INFO: renamed from: iwb.a$a, reason: collision with other inner class name */
    public static final class C6363a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f496275a;

        public b(a r100) {
            this.f496275a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r100 = this.f496275a.f496267i;     // Catch: Throwable -> L11
            if (r100.f496279a.isLaidOut() == true) goto L5;
            return;
        L5:
            if (r100.f496281c == false) goto L8;
            return;
        L8:
            if (r100.f496282d == true) goto L19;
            r100.e(true);     // Catch: Throwable -> L11
            return;
        L19:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f496276a;

        public c(a r100) {
            this.f496276a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r100 = this.f496276a.f496267i;     // Catch: Throwable -> L14
            FrameLayout r101 = r100.f496279a.getFloatView$officesdk_minutes_base_ui_release();     // Catch: Throwable -> L14
            if (r101.getWidth() > 0) goto L5;
        L19:
            return;
        L5:
            if (r101.getHeight() <= 0) goto L19;
            if (r100.f496281c == true) goto L19;
            if (r100.f496282d == false) goto L12;
            r100.e(false);     // Catch: Throwable -> L14
            goto L19
        L12:
            r100.d(false);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        iwb.b r100 = this.f496271m;
        if (r100 != null) goto L6;
    L9:
        removeCallbacks(this.f496274p);
        this.f496267i.b();
        super.onDetachedFromWindow();
        return;
    L6:
        if (getViewTreeObserver().isAlive() == false) goto L8;
        getViewTreeObserver().removeOnPreDrawListener(r100);
    L8:
        this.f496271m = null;
        goto L9
    }

    public final void a() {
        long r100 = SystemClock.uptimeMillis();
        MotionEvent r101 = MotionEvent.obtain(r100, r100, 3, 0.0f, 0.0f, 0);
        super.dispatchTouchEvent(r101);
        r101.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f496271m != null) goto L7;
        this.f496271m = new iwb.b(this);
        getViewTreeObserver().addOnPreDrawListener(this.f496271m);
        return;
    }

    public final View getContentView$officesdk_minutes_base_ui_release() {
        return this.f496269k;
    }

    public final FrameLayout getFloatView$officesdk_minutes_base_ui_release() {
        return this.f496259a;
    }

    public final Function0<Unit> getOnFirstPositioned$officesdk_minutes_base_ui_release() {
        return this.f496272n;
    }

    public final Function1<hwb.d, Unit> getOnLayoutStateChanged$officesdk_minutes_base_ui_release() {
        return this.f496273o;
    }

    public final void b(hwb.d r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Function1<? super hwb.d, Unit> r101 = this.f496273o;
        if (r101 == null) goto L6;
        r101.invoke(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        f r100 = this.f496268j;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "ev");
        int r101 = r110.getActionMasked();
        boolean r102 = false;
        if (r101 == 0) goto L76;
        if (r101 == 1) goto L62;
        if (r101 == 2) goto L10;
        if (r101 == 3) goto L62;
    L95:
        if (r102 == false) goto L98;
        return true;
    L98:
        return super.dispatchTouchEvent(r110);
    L10:
        if (r100.f496305g == false) goto L95;
        if (r100.f496300b.f496281c == true) goto L95;
        int r103 = (int) r110.getRawX();
        int r104 = (int) r110.getRawY();
        if (r100.f496306h == true) goto L20;
        if ((Math.abs(r103 - r100.f496301c) + Math.abs(r104 - r100.f496302d)) < 5) goto L95;
    L20:
        if (r100.f496306h == true) goto L31;
        r100.f496306h = true;
        a r105 = r100.f496299a;
        r105.removeCallbacks(r105.f496274p);
        d r106 = r100.f496300b;
        r106.b();
        ViewGroup.LayoutParams r107 = r106.f496279a.getFloatView$officesdk_minutes_base_ui_release().getLayoutParams();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r107;
        if (r108.gravity == 0) goto L30;
        r108.gravity = 0;
        e r109 = r106.f496280b;
        if (r109.f496298a.getWidth() > 0) goto L26;
    L28:
        int r111 = 0;
    L29:
        r108.leftMargin = r111;
        r108.topMargin = r106.f496280b.b();
        r108.rightMargin = 0;
        r108.bottomMargin = 0;
        r106.f496279a.getFloatView$officesdk_minutes_base_ui_release().setLayoutParams(r108);
        goto L30
    L26:
        if (r109.f496298a.getFloatView$officesdk_minutes_base_ui_release().getWidth() <= 0) goto L28;
        r111 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r109.f496298a.getWidth() - r109.f496298a.getFloatView$officesdk_minutes_base_ui_release().getWidth(), 0), r109.e());
    L30:
        r100.f496299a.a();
    L31:
        d r112 = r100.f496300b;
        int r113 = r103 - r100.f496303e;
        int r114 = r104 - r100.f496304f;
        if (r112.f496281c == true) goto L61;
        ViewGroup.LayoutParams r115 = r112.f496279a.getFloatView$officesdk_minutes_base_ui_release().getLayoutParams();
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r116 = (FrameLayout.LayoutParams) r115;
        e r117 = r112.f496280b;
        int r118 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r116.leftMargin + r113, r117.d()), r117.e());
        int r119 = r112.f496280b.c(r116.topMargin + r114);
        r116.gravity = 0;
        r116.leftMargin = r118;
        r116.topMargin = r119;
        r112.f496279a.getFloatView$officesdk_minutes_base_ui_release().setLayoutParams(r116);
        boolean r120 = r112.f496282d;
        if (r118 > (-r112.f496280b.f496298a.f496265g)) goto L37;
    L40:
        boolean r121 = true;
    L41:
        r112.f496282d = r121;
        if (r120 != r121) goto L44;
    L48:
        boolean r122 = r112.f496283e;
        if (r118 > r112.f496280b.d()) goto L51;
    L54:
        boolean r123 = true;
    L55:
        r112.f496283e = r123;
        if (r122 == r123) goto L61;
        if (r118 < (r112.f496279a.getWidth() / 2)) goto L60;
        r102 = true;
    L60:
        r112.f496284f = r102;
        r112.f496279a.c(r112.f496283e, r102);
        goto L61
    L51:
        if (r118 >= r112.f496280b.e()) goto L54;
        r123 = false;
        goto L55
    L44:
        if (r118 < (r112.f496279a.getWidth() / 2)) goto L46;
        boolean r124 = true;
    L47:
        r112.f496284f = r124;
        int r125 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FLOAT, "updateSideHideStatus", "hidden=" + r112.f496282d + ", right=" + r112.f496284f, null, 8);
        goto L48
    L46:
        r124 = false;
        goto L47
    L37:
        if (r118 >= ((r112.f496279a.getWidth() - r112.f496279a.getFloatView$officesdk_minutes_base_ui_release().getWidth()) + r112.f496280b.f496298a.f496265g)) goto L40;
        r121 = false;
    L61:
        r100.f496303e = r103;
        r100.f496304f = r104;
        r102 = true;
    L62:
        ViewParent r126 = r100.f496299a.getParent();
        if (r126 == null) goto L65;
        r126.requestDisallowInterceptTouchEvent(false);
    L65:
        boolean r127 = r100.f496306h;
        r100.f496305g = false;
        r100.f496306h = false;
        if (r127 == false) goto L75;
        d r128 = r100.f496300b;
        if (r128.f496282d == false) goto L70;
        r128.e(true);
    L71:
        a r129 = r100.f496299a;
        if (r129.f496270l == false) goto L75;
        r129.removeCallbacks(r129.f496274p);
        r129.postDelayed(r129.f496274p, 3000);
        goto L75
    L70:
        r128.d(true);
    L75:
        r102 = r127;
        goto L95
    L76:
        int r130 = (int) r110.getRawX();
        int r131 = (int) r110.getRawY();
        FrameLayout r132 = r100.f496299a.getFloatView$officesdk_minutes_base_ui_release();
        int[] r133 = new int[2];
        r132.getLocationOnScreen(r133);
        int r134 = r133[0];
        int r135 = r133[1];
        int r136 = r132.getWidth() + r134;
        int r137 = r132.getHeight() + r135;
        if (r134 > r130) goto L80;
        if (r130 > r136) goto L80;
        boolean r138 = true;
    L81:
        if (r138 == false) goto L88;
        if (r135 > r131) goto L85;
        if (r131 > r137) goto L85;
        boolean r139 = true;
    L86:
        if (r139 == false) goto L88;
        boolean r140 = true;
    L89:
        r100.f496305g = false;
        r100.f496306h = false;
        if (r140 == false) goto L95;
        r100.f496305g = true;
        r100.f496301c = r130;
        r100.f496302d = r131;
        r100.f496303e = r130;
        r100.f496304f = r131;
        ViewParent r141 = r100.f496299a.getParent();
        if (r141 == null) goto L95;
        r141.requestDisallowInterceptTouchEvent(true);
    L85:
        r139 = false;
    L88:
        r140 = false;
    L80:
        r138 = false;
        goto L81
    }

    public final void setContent(View r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f496269k = r100;
        this.f496261c.removeAllViews();
        this.f496261c.addView(r100, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void setOnFirstPositioned$officesdk_minutes_base_ui_release(Function0<Unit> r100) {
        this.f496272n = r100;
    }

    public final void setOnLayoutStateChanged$officesdk_minutes_base_ui_release(Function1<? super hwb.d, Unit> r100) {
        this.f496273o = r100;
    }

    public a(Context r110, hwb.a r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "spec");
        super(r110);
        FrameLayout r100 = new FrameLayout(r110);
        this.f496259a = r100;
        View r101 = LayoutInflater.from(r110).inflate(r111.f487430a, r100, false);
        this.f496260b = r101;
        FrameLayout r102 = (FrameLayout) r101.findViewById(r111.f487431b);
        this.f496261c = r102;
        FrameLayout r103 = (FrameLayout) r101.findViewById(r111.f487432c);
        this.f496262d = r103;
        FrameLayout r104 = (FrameLayout) r101.findViewById(r111.f487433d);
        this.f496263e = r104;
        FrameLayout r105 = (FrameLayout) r101.findViewById(r111.f487434e);
        this.f496264f = r105;
        int r106 = UIHelper.dp2px(r111.f487435f);
        int r112 = UIHelper.dp2px(r111.f487436g);
        int r113 = UIHelper.dp2px(r111.f487437h);
        this.f496265g = r113;
        this.f496266h = UIHelper.dp2px(r111.f487438i);
        int r107 = r113 * 2;
        int r114 = r107 + r106;
        int r108 = r107 + r112;
        d r115 = new d(this, new e(this));
        this.f496267i = r115;
        this.f496268j = new f(this, r115);
        this.f496270l = true;
        this.f496274p = new b(this);
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(false);
        r100.setVisibility(4);
        r100.setClipChildren(false);
        r100.setClipToPadding(false);
        r101.setLayoutParams(new FrameLayout.LayoutParams(r114, r108));
        Object r109 = r102.getParent();
        UDShadowLayout.LayoutParams r116 = null;
        if ((r109 instanceof View) == false) goto L5;
        View r117 = (View) r109;
    L6:
        if (r117 == null) goto L14;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if ((r118 instanceof UDShadowLayout.LayoutParams) == false) goto L10;
        r116 = (UDShadowLayout.LayoutParams) r118;
    L10:
        if (r116 != null) goto L12;
        UDShadowLayout.LayoutParams r119 = new UDShadowLayout.LayoutParams(r106, r112);
    L13:
        ((ViewGroup.MarginLayoutParams) r119).width = r106;
        ((ViewGroup.MarginLayoutParams) r119).height = r112;
        r119.setMargins(r113, r113, r113, r113);
        r117.setLayoutParams(r119);
        goto L14
    L12:
        r119 = r116;
    L14:
        FrameLayout.LayoutParams r120 = new FrameLayout.LayoutParams(r114, r108);
        r120.gravity = 17;
        Unit r121 = Unit.INSTANCE;
        r100.addView(r101, r120);
        FrameLayout.LayoutParams r122 = new FrameLayout.LayoutParams(r114, r108);
        r122.gravity = 53;
        addView(r100, r122);
        r103.setVisibility(4);
        r104.setVisibility(4);
        r105.setVisibility(4);
        Iterator r123 = CollectionsKt.listOf(new FrameLayout[]{r104, r105}).iterator();
    L16:
        if (r123.hasNext() == false) goto L18;
        ((FrameLayout) r123.next()).setOnClickListener(new iwb.c(this));
        goto L16
    L18:
        return;
    L5:
        r117 = null;
        goto L6
    }

    public final void c(boolean r100, boolean r101) {
        int r102 = 0;
        setVisibility(0);
        setAlpha(1.0f);
        this.f496259a.setVisibility(0);
        this.f496259a.setAlpha(1.0f);
        this.f496260b.setVisibility(0);
        this.f496260b.setAlpha(1.0f);
        this.f496261c.setAlpha(1.0f);
        this.f496262d.setAlpha(1.0f);
        this.f496263e.setAlpha(1.0f);
        this.f496264f.setAlpha(1.0f);
        FrameLayout r103 = this.f496261c;
        if (r100 == false) goto L5;
        int r104 = 4;
    L6:
        r103.setVisibility(r104);
        View r105 = this.f496269k;
        if (r105 == null) goto L12;
        if (r100 == false) goto L10;
        int r106 = 4;
    L11:
        r105.setVisibility(r106);
        goto L12
    L10:
        r106 = 0;
    L12:
        FrameLayout r107 = this.f496262d;
        if (r100 == false) goto L15;
        int r108 = 0;
    L16:
        r107.setVisibility(r108);
        FrameLayout r109 = this.f496263e;
        if (r100 == false) goto L20;
        if (r101 == false) goto L20;
        int r110 = 0;
    L21:
        r109.setVisibility(r110);
        FrameLayout r111 = this.f496264f;
        if (r100 == false) goto L25;
        if (r101 == true) goto L25;
    L26:
        r111.setVisibility(r102);
        return;
    L25:
        r102 = 4;
    L20:
        r110 = 4;
        goto L21
    L15:
        r108 = 4;
        goto L16
    L5:
        r104 = 0;
        goto L6
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 <= 0) goto L7;
        if (r101 <= 0) goto L8;
        post(new c(this));
        return;
    L8:
        return;
    }
}
