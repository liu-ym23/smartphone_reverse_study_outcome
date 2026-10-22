package com.ss.android.lark.floating.widget.appfloat;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.floating.enums.SideHideDirection;
import com.ss.android.lark.floating.enums.SidePattern;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class TouchUtils {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f421901v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f421902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vfb.a f421903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f421904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f421905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f421906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f421907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f421908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f421909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f421910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f421911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f421912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f421913l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f421914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int[] f421915n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f421916o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f421917p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Animator f421918q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f421919r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f421920s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SideHideDirection f421921t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f421922u;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f421923a = null;

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
            r100[SidePattern.RESULT_VERTICAL.ordinal()] = 12;     // Catch: NoSuchFieldError -> L30
        L57:
            r100[SidePattern.RESULT_SIDE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L31
        L33:
            r100[SidePattern.RESULT_HORIZONTAL.ordinal()] = 14;     // Catch: NoSuchFieldError -> L32
        L17:
            f421923a = r100;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f421924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f421925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WindowManager f421926c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f421927d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f421928e;

        public c(boolean r100, h r101, WindowManager r102, View r103, ValueAnimator r104) {
            this.f421924a = r100;
            this.f421925b = r101;
            this.f421926c = r102;
            this.f421927d = r103;
            this.f421928e = r104;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
        L10:
            this.f421928e.cancel();
            return;
        L5:
            if (this.f421924a == false) goto L7;
            h r101 = this.f421925b;     // Catch: Exception -> L10
            Object r102 = r100.getAnimatedValue();     // Catch: Exception -> L10
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L10
            ((WindowManager.LayoutParams) r101.f421955a).x = ((Integer) r102).intValue();     // Catch: Exception -> L10
        L8:
            this.f421926c.updateViewLayout(this.f421927d, this.f421925b.f421955a);     // Catch: Exception -> L10
            return;
        L7:
            h r103 = this.f421925b;     // Catch: Exception -> L10
            Object r104 = r100.getAnimatedValue();     // Catch: Exception -> L10
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L10
            ((WindowManager.LayoutParams) r103.f421955a).y = ((Integer) r104).intValue();     // Catch: Exception -> L10
            goto L8
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TouchUtils f421929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f421930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f421931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AppFloatManager.b f421932d;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f421929a.c(this.f421930b, this.f421931c, false);
            AppFloatManager.b r101 = this.f421932d;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f421929a.c(this.f421930b, this.f421931c, false);
            AppFloatManager.b r101 = this.f421932d;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            TouchUtils r101 = this.f421929a;
            r101.f421903b.f554615j = true;
            TouchUtils.a(r101, this.f421931c);
        }

        public d(TouchUtils r100, View r101, boolean r102, AppFloatManager.b r103) {
            this.f421929a = r100;
            this.f421930b = r101;
            this.f421931c = r102;
            this.f421932d = r103;
        }
    }

    static {
    }

    public final int e() {
        int r100 = this.f421906e;
        vfb.a r101 = this.f421903b;
        return ((r100 - r101.f554612g) - r101.f554611f) - this.f421922u;
    }

    public final void l() {
        if (this.f421919r == false) goto L17;
        SidePattern r100 = this.f421903b.f554618m;
        int r101 = b.f421923a[r100.ordinal()];
        if (r101 != 8) goto L7;
        SideHideDirection r102 = SideHideDirection.LEFT;
    L18:
        this.f421921t = r102;
        return;
    L7:
        if (r101 != 9) goto L9;
        r102 = SideHideDirection.RIGHT;
        goto L18
    L9:
        if (r101 == 14) goto L12;
        r102 = SideHideDirection.NONE;
        goto L18
    L12:
        if (this.f421909h >= this.f421910i) goto L14;
        r102 = SideHideDirection.LEFT;
        goto L18
    L14:
        r102 = SideHideDirection.RIGHT;
        goto L18
    L17:
        r102 = SideHideDirection.NONE;
        goto L18
    }

    public final Context getContext() {
        return this.f421902a;
    }

    public static int k(View r100) {
        int r101 = xfb.d.f563555a;
        Intrinsics.checkNotNullParameter(r100, "view");
        Context r102 = r100.getContext().getApplicationContext();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r103 = r102.getResources();
        int r104 = r103.getIdentifier("status_bar_height", "dimen", "android");
        if (r104 > 0) goto L7;
        return 0;
    L7:
        return r103.getDimensionPixelSize(r104);
    }

    public final int d(View r100) {
        int r101 = 0 - r100.getWidth();
        vfb.a r102 = this.f421903b;
        return ((r101 + r102.f554612g) + r102.f554611f) + this.f421922u;
    }

    public final void h(final Function0<Unit> r100) {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("core.appfloat.windowsize_refactor") == false) goto L9;
        xfb.g r101 = xfb.g.f563558e;
        if (r101 != null) goto L8;
        r101 = new xfb.g();
        xfb.g.f563558e = r101;
    L8:
        Function1<Point, Unit> r102 = new TouchUtils$resetParentWidthAndHeight$1(this, r100);
        Intrinsics.checkNotNullParameter(r102, "callback");
        r101.f563562d.post(new xfb.h(r101, r102));
        return;
    L9:
        this.f421906e = xfb.d.b(this.f421902a);
        this.f421905d = this.f421903b.E.a(this.f421902a);
    }

    public TouchUtils(Context r100, vfb.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f421902a = r100;
        this.f421903b = r101;
        this.f421904c = new Rect();
        this.f421915n = new int[2];
        this.f421917p = true;
        this.f421921t = SideHideDirection.NONE;
        this.f421922u = UIHelper.dp2px(5.0f);
        if (FeatureGatingModule.getFeatureGatingService().isEnable("core.appfloat.windowsize_refactor") == false) goto L6;
        h(null);
        return;
    L6:
        if (this.f421906e != 0) goto L9;
        this.f421906e = xfb.d.b(r100);
    L9:
        if (this.f421905d != 0) goto L13;
        this.f421905d = r101.E.a(r100);
        return;
    }

    public static final void a(TouchUtils r100, boolean r101) {
        r100.f421920s = r100.f421919r;
        if (r101 == false) goto L16;
        wfb.a r102 = r100.f421903b.B;
        if (r102 == null) goto L17;
        wfb.a.C8107a r103 = r102.a();
        if (r103 == null) goto L18;
        Function2<? super Boolean, ? super Boolean, Unit> r104 = r103.f559502f;
        if (r104 == null) goto L19;
        Boolean r105 = Boolean.valueOf(r100.f421919r);
        if (r100.f421921t != SideHideDirection.RIGHT) goto L13;
        boolean r106 = true;
    L14:
        r104.invoke(r105, Boolean.valueOf(r106));
        return;
    L13:
        r106 = false;
        goto L14
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void f(h r100, View r101) {
        int r102 = ((WindowManager.LayoutParams) r100.f421955a).x;
        this.f421909h = r102;
        this.f421910i = this.f421906e - (r102 + r101.getRight());
        int r103 = ((WindowManager.LayoutParams) r100.f421955a).y;
        this.f421911j = r103;
        if (this.f421917p == false) goto L5;
        int r104 = ((this.f421905d - k(r101)) - this.f421911j) - r101.getHeight();
    L6:
        this.f421912k = r104;
        this.f421913l = Math.min(this.f421909h, this.f421910i);
        this.f421914m = Math.min(this.f421911j, this.f421912k);
        return;
    L5:
        r104 = (this.f421905d - r103) - r101.getHeight();
        goto L6
    }

    public final void c(View r100, boolean r101, boolean r102) {
        vfb.a r103 = this.f421903b;
        boolean r104 = false;
        r103.f554615j = false;
        r103.getClass();
        this.f421920s = this.f421919r;
        wfb.a r105 = this.f421903b.B;
        if (r105 == null) goto L9;
        wfb.a.C8107a r106 = r105.a();
        if (r106 == null) goto L9;
        Function1<? super View, Unit> r107 = r106.f559501e;
        if (r107 == null) goto L9;
        r107.invoke(r100);
    L9:
        if (r101 == false) goto L28;
        wfb.a r108 = this.f421903b.B;
        if (r108 == null) goto L17;
        wfb.a.C8107a r109 = r108.a();
        if (r109 == null) goto L17;
        Function1<? super Boolean, Unit> r110 = r109.f559504h;
        if (r110 == null) goto L17;
        r110.invoke(Boolean.valueOf(r102));
    L17:
        wfb.a r111 = this.f421903b.B;
        if (r111 == null) goto L29;
        wfb.a.C8107a r112 = r111.a();
        if (r112 == null) goto L30;
        Function2<? super Boolean, ? super Boolean, Unit> r113 = r112.f559503g;
        if (r113 == null) goto L31;
        Boolean r114 = Boolean.valueOf(this.f421919r);
        if (this.f421921t != SideHideDirection.RIGHT) goto L26;
        r104 = true;
    L26:
        r113.invoke(r114, Boolean.valueOf(r104));
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }

    public final void g(com.ss.android.lark.floating.widget.appfloat.d r100, h r110, int r111, WindowManager r112, AppFloatManager.d.a r113) {
        f(r110, r100);
        int r101 = 0;
        this.f421919r = false;
        this.f421920s = false;
        this.f421921t = SideHideDirection.NONE;
        SidePattern r102 = this.f421903b.f554618m;
        int[] r103 = b.f421923a;
        switch(r103[r102.ordinal()]) {
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L34;
            case 11: goto L30;
            case 12: goto L23;
            case 13: goto L10;
            case 14: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        int r104 = this.f421909h;
        int r105 = this.f421910i;
        if (r104 >= r105) goto L8;
        r101 = 0 - r111;
        goto L37
    L8:
        r101 = (((WindowManager.LayoutParams) r110.f421955a).x + r105) + r111;
    L34:
        int r114 = 0;
    L35:
        boolean r106 = false;
    L38:
        vfb.a r107 = this.f421903b;
        if (r107.f554626u == 8388613) goto L42;
    L68:
        b(r106, r110, r114, r112, r100, r113, true);
        return;
    L42:
        switch(r103[r107.f554618m.ordinal()]) {
            case 8: goto L66;
            case 9: goto L64;
            case 10: goto L63;
            case 11: goto L62;
            case 12: goto L59;
            case 13: goto L49;
            case 14: goto L45;
            default: goto L68;
        };
    L62:
        int r108 = this.f421903b.f554627v.getSecond().intValue();
    L65:
        r114 = r114 + r108;
        goto L68
    L63:
        int r109 = this.f421903b.f554627v.getSecond().intValue();
    L67:
        r114 = r114 - r109;
        goto L68
    L64:
        r108 = this.f421903b.f554627v.getFirst().intValue();
        goto L65
    L66:
        r109 = this.f421903b.f554627v.getFirst().intValue();
        goto L67
    L45:
        if (this.f421909h >= this.f421910i) goto L47;
        r109 = this.f421903b.f554627v.getFirst().intValue();
        goto L67
    L47:
        r108 = this.f421903b.f554627v.getFirst().intValue();
        goto L65
    L49:
        if (this.f421913l >= this.f421914m) goto L55;
        if (this.f421909h >= this.f421910i) goto L53;
        r109 = this.f421903b.f554627v.getFirst().intValue();
        goto L67
    L53:
        r108 = this.f421903b.f554627v.getFirst().intValue();
        goto L65
    L55:
        if (this.f421911j >= this.f421912k) goto L57;
        r109 = this.f421903b.f554627v.getSecond().intValue();
        goto L67
    L57:
        r108 = this.f421903b.f554627v.getSecond().intValue();
        goto L65
    L59:
        if (this.f421911j >= this.f421912k) goto L61;
        r109 = this.f421903b.f554627v.getSecond().intValue();
        goto L67
    L61:
        r108 = this.f421903b.f554627v.getSecond().intValue();
        goto L65
    L36:
        int r115 = ((WindowManager.LayoutParams) r110.f421955a).x;
        r101 = this.f421910i + r115;
    L37:
        r114 = r101;
        r106 = true;
        goto L38
    L10:
        if (this.f421913l >= this.f421914m) goto L16;
        int r116 = this.f421909h;
        int r117 = this.f421910i;
        if (r116 < r117) goto L37;
        r101 = ((WindowManager.LayoutParams) r110.f421955a).x + r117;
        goto L37
    L16:
        if (this.f421911j < this.f421912k) goto L34;
        if (this.f421917p == false) goto L21;
        int r118 = this.f421916o;
        int r119 = k(r100);
    L32:
        r114 = r118 - r119;
        goto L35
    L21:
        r114 = this.f421916o;
        goto L35
    L23:
        if (this.f421911j < this.f421912k) goto L34;
        if (this.f421917p == false) goto L28;
        r118 = this.f421916o;
        r119 = k(r100);
        goto L32
    L28:
        r114 = this.f421916o;
        goto L35
    L30:
        if (this.f421917p == false) goto L33;
        r118 = this.f421916o;
        r119 = k(r100);
        goto L32
    L33:
        r114 = this.f421916o;
        goto L35
    }

    public static /* synthetic */ void j(TouchUtils r100, h r110, int r111, WindowManager r112, com.ss.android.lark.floating.widget.appfloat.d r113, AppFloatManager.e r114, boolean r115) {
        r100.i(r110, r111, 0, r112, r113, r114, r115, false);
    }

    public final Animator b(boolean r100, h r110, int r111, WindowManager r112, View r113, AppFloatManager.b r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r112, "windowManager");
        Intrinsics.checkNotNullParameter(r113, "view");
        Animator r101 = this.f421918q;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        this.f421918q = null;
        int[] r102 = new int[2];
        if (r100 == false) goto L8;
        int r103 = ((WindowManager.LayoutParams) r110.f421955a).x;
    L9:
        r102[0] = r103;
        r102[1] = r111;
        ValueAnimator r116 = ValueAnimator.ofInt(r102);
        r116.addUpdateListener(new c(r100, r110, r112, r113, r116));
        r116.setDuration(300);
        r116.addListener(new d(this, r113, r115, r114));
        r116.start();
        this.f421918q = r116;
        Intrinsics.checkNotNull(r116);
        return r116;
    L8:
        r103 = ((WindowManager.LayoutParams) r110.f421955a).y;
        goto L9
    }

    public final Animator i(h r100, int r101, int r102, WindowManager r110, com.ss.android.lark.floating.widget.appfloat.d r111, AppFloatManager.e r112, boolean r113, boolean r114) {
        Animator r103 = this.f421918q;
        if (r103 == null) goto L5;
        r103.cancel();
    L5:
        this.f421918q = null;
        this.f421919r = false;
        this.f421920s = false;
        this.f421921t = SideHideDirection.NONE;
        WindowManagerLayoutParamsInternal r104 = r100.f421955a;
        Point r105 = new Point(((WindowManager.LayoutParams) r104).x, ((WindowManager.LayoutParams) r104).y);
        if (r102 != 0) goto L9;
        r102 = ((WindowManager.LayoutParams) r100.f421955a).y;
    L9:
        if (r102 < (this.f421905d - r111.getHeight())) goto L11;
        r102 = this.f421905d - r111.getHeight();
    L11:
        Point r106 = new Point(r101, r102);
        ValueAnimator r107 = ValueAnimator.ofObject(new g(new Point()), new Object[]{r105, r106});
        r107.setDuration(300);
        r107.addUpdateListener(new e(r100, r110, r111, r107));
        r107.addListener(new f(this, r111, r113, r114, r112));
        r107.start();
        this.f421918q = r107;
        return r107;
    }
}
