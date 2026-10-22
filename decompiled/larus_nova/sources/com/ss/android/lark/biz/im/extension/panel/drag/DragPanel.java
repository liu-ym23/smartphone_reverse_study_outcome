package com.ss.android.lark.biz.im.extension.panel.drag;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.biz.im.extension.panel.drag.view.DragPanelContainerLayout;
import com.ss.android.lark.biz.im.extension.panel.drag.view.DragPanelLayout;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
public final class DragPanel implements i {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f410502r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f410503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f410504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f410505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f410506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f410507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f410508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f410509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f410510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f410511i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewGroup f410512j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f410513k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0<Unit> f410514l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f410515m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CopyOnWriteArrayList<k> f410516n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CopyOnWriteArrayList<j> f410517o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.ss.android.lark.insets.h f410518p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Integer f410519q;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/biz/im/extension/panel/drag/DragPanel$PanelChangeActionType;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST_SHOW", "FULL_EXPAND", "FULL_DISMISS", "HALF_DISMISS", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PanelChangeActionType extends Enum<PanelChangeActionType> {
        public static final PanelChangeActionType FIRST_SHOW = null;
        public static final PanelChangeActionType FULL_DISMISS = null;
        public static final PanelChangeActionType FULL_EXPAND = null;
        public static final PanelChangeActionType HALF_DISMISS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PanelChangeActionType[] f410520a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f410521b = null;

        public static EnumEntries<PanelChangeActionType> getEntries() {
            return f410521b;
        }

        static {
            PanelChangeActionType r100 = new PanelChangeActionType("FIRST_SHOW", 0);
            FIRST_SHOW = r100;
            PanelChangeActionType r101 = new PanelChangeActionType("FULL_EXPAND", 1);
            FULL_EXPAND = r101;
            PanelChangeActionType r102 = new PanelChangeActionType("FULL_DISMISS", 2);
            FULL_DISMISS = r102;
            PanelChangeActionType r103 = new PanelChangeActionType("HALF_DISMISS", 3);
            HALF_DISMISS = r103;
            PanelChangeActionType[] r104 = {r100, r101, r102, r103};
            f410520a = r104;
            f410521b = EnumEntriesKt.enumEntries(r104);
        }

        public static PanelChangeActionType[] values() {
            return (PanelChangeActionType[]) f410520a.clone();
        }

        public static PanelChangeActionType valueOf(String r100) {
            return (PanelChangeActionType) r27.a.a(PanelChangeActionType.class, r100);
        }

        public PanelChangeActionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f410522a = null;

        static {
            int[] r100 = new int[PanelChangeActionType.values().length];
            r100[PanelChangeActionType.FIRST_SHOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[PanelChangeActionType.FULL_EXPAND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[PanelChangeActionType.FULL_DISMISS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[PanelChangeActionType.HALF_DISMISS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f410522a = r100;
        }
    }

    static {
    }

    public final void c() {
        if (this.f410515m == true) goto L6;
        Log.w("ActionPanelV2", "dismissImmediately: wrong state, isAddedContainer=false, method return");
        return;
    L6:
        Function0<Unit> r100 = new DragPanel$dismissImmediately$1(this);
        if (this.f410513k == false) goto L9;
        this.f410514l = new DragPanel$doActionAfterAnimation$1(r100, this);
        return;
    L9:
        r100.invoke();
    }

    public final DragPanelLayout d() {
        return (DragPanelLayout) this.f410511i.getValue();
    }

    public final DragPanelContainerLayout e() {
        return (DragPanelContainerLayout) this.f410509g.getValue();
    }

    public final void g() {
        Iterator<View> r100 = ViewGroupKt.getChildren(this.f410505c).iterator();
    L3:
        DragPanelContainerLayout r101 = null;
        if (r100.hasNext() == false) goto L8;
        View r102 = r100.next();
        if ((r102 instanceof DragPanelContainerLayout) == false) goto L3;
    L9:
        View r103 = r102;
        if (r103 != null) goto L12;
    L18:
        this.f410505c.addView(e(), new FrameLayout.LayoutParams(-1, -1));
        this.f410515m = true;
        KeyboardUtils.hideKeyboard(this.f410503a, e());
        e().setFocusable(true);
        e().setFocusableInTouchMode(true);
        e().requestFocus();
        int r104 = this.f410505c.getWidth();
        float r105 = this.f410505c.getHeight();
        int r106 = (int) (this.f410504b.f410542a.c().a() * r105);
        d().measure(View.MeasureSpec.makeMeasureSpec(r104, 1073741824), View.MeasureSpec.makeMeasureSpec(r106, Integer.MIN_VALUE));
        int r107 = d().getMeasuredHeight();
        if (this.f410504b.f410542a.c().b() == false) goto L21;
        int r108 = r106;
    L22:
        DragPanelLayout r109 = d();
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        if (r110 == null) goto L42;
        r110.height = r108;
        r109.setLayoutParams(r110);
        int r111 = 0;
        if (Intrinsics.areEqual(this.f410512j, d()) == true) goto L31;
        this.f410512j.measure(0, 0);
        ViewGroup r112 = this.f410512j;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if (r113 == null) goto L30;
        r113.height = this.f410512j.getMeasuredHeight();
        r112.setLayoutParams(r113);
        r111 = this.f410512j.getMeasuredHeight() - r107;
        goto L31
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L31:
        int r114 = (int) (this.f410504b.f410544c.a() * r105);
        if (this.f410504b.f410544c.b() == true) goto L35;
        r114 = RangesKt.coerceAtMost(r107, r114);
    L35:
        this.f410506d = r114 + r111;
        if (this.f410504b.f410542a.c().b() == false) goto L38;
        int r115 = r106 + r111;
    L39:
        this.f410507e = r115;
        h(this, true, 0.0f, this.f410506d, 250, new DragPanel$show$1(this), new DragPanel$show$2(this));
        return;
    L38:
        r115 = RangesKt.coerceAtMost(r107, r106) + r111;
        goto L39
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L21:
        r108 = RangesKt.coerceAtMost(r107, r106);
        goto L22
    L12:
        if ((r103 instanceof DragPanelContainerLayout) == false) goto L14;
        r101 = (DragPanelContainerLayout) r103;
    L14:
        if (r101 == null) goto L18;
        com.ss.android.lark.biz.im.extension.panel.drag.view.a r116 = r101.f410564a;
        if (r116 == null) goto L18;
        r116.a();
        goto L18
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.i
    public final void dismiss() {
        f(this);
    }

    public static void f(final DragPanel r100) {
        final float r101 = Math.max(r100.f410507e - r100.f410512j.getTranslationY(), 0.0f);
        if (r100.f410508f != r100.f410507e) goto L5;
        final PanelChangeActionType r102 = PanelChangeActionType.FULL_DISMISS;
    L6:
        Function0<Unit> r103 = new DragPanel$innerDismiss$1(r100, r101, r102);
        if (r100.f410513k == false) goto L9;
        r100.f410514l = new DragPanel$doActionAfterAnimation$1(r103, r100);
        return;
    L9:
        r103.invoke();
        return;
    L5:
        r102 = PanelChangeActionType.HALF_DISMISS;
        goto L6
    }

    public static final void a(DragPanel r100, float r101) {
        Drawable r102 = r100.e().getBackground();
        if ((r102 instanceof ColorDrawable) == false) goto L5;
        ColorDrawable r103 = (ColorDrawable) r102;
    L6:
        if (r103 == null) goto L10;
        r103.setAlpha((int) (r101 * 256));
        r103.invalidateSelf();
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static void b(g r100, PanelChangeActionType r101, float r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r103, "alphaAction");
        if (r100.f410542a.a() != 0) goto L5;
        return;
    L5:
        int r104 = b.f410522a[r101.ordinal()];
        boolean r105 = true;
        if (r104 != 1) goto L8;
        Pair r106 = TuplesKt.to(Float.valueOf(r100.f410542a.d()), Float.valueOf(r100.f410545d));
    L19:
        float r107 = ((Number) r106.component1()).floatValue();
        float r108 = ((Number) r106.component2()).floatValue();
        if (r107 == r108) goto L23;
        r105 = false;
    L23:
        if (r105 == false) goto L25;
        return;
    L25:
        r103.invoke(Float.valueOf(Math.max(r107 + ((r108 - r107) * r102), 0.0f)));
        return;
    L8:
        if (r104 != 2) goto L10;
        r106 = TuplesKt.to(Float.valueOf(r100.f410545d), Float.valueOf(r100.f410542a.b()));
        goto L19
    L10:
        if (r104 != 3) goto L12;
        r106 = TuplesKt.to(Float.valueOf(r100.f410542a.b()), Float.valueOf(r100.f410542a.d()));
        goto L19
    L12:
        if (r104 != 4) goto L15;
        r106 = TuplesKt.to(Float.valueOf(r100.f410545d), Float.valueOf(r100.f410542a.d()));
        goto L19
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public DragPanel(Context r100, Activity r101, com.ss.android.lark.chat.cot.detail.m r102, com.ss.android.lark.chat.cot.detail.c r103, g r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "containerProvider");
        Intrinsics.checkNotNullParameter(r103, "contentController");
        Intrinsics.checkNotNullParameter(r104, "config");
        this.f410503a = r100;
        this.f410504b = r104;
        this.f410505c = r102.a();
        LazyThreadSafetyMode r105 = LazyThreadSafetyMode.NONE;
        this.f410509g = LazyKt.lazy(r105, new DragPanel$rootView$2(this));
        Lazy r106 = LazyKt.lazy(r105, new DragPanel$shadowLayout$2(this));
        this.f410510h = r106;
        this.f410511i = LazyKt.lazy(r105, new DragPanel$panelLayout$2(this));
        this.f410514l = DragPanel$actionAfterAnimator$1.INSTANCE;
        this.f410516n = new CopyOnWriteArrayList();
        this.f410517o = new CopyOnWriteArrayList();
        Integer r107 = null;
        if (r101 == null) goto L5;
        com.ss.android.lark.insets.h r108 = WindowInsetsUtils.c(r101);
    L6:
        this.f410518p = r108;
        if (r108 == null) goto L9;
        r107 = Integer.valueOf(r108.f427738f);
    L9:
        this.f410519q = r107;
        ConstraintLayout.LayoutParams r109 = new ConstraintLayout.LayoutParams(-1, 0);
        r109.startToStart = 0;
        r109.endToEnd = 0;
        r109.bottomToBottom = 0;
        if (r104.f410543b.f410551d == false) goto L12;
        e().addView((UDShadowLayout) r106.getValue(), r109);
        UDShadowLayout r110 = (UDShadowLayout) r106.getValue();
        DragPanelLayout r111 = d();
        UDShadowLayout.LayoutParams r112 = new UDShadowLayout.LayoutParams(-1, -1);
        r112.setMargins(0, (int) h18.d.a(r100, 4.0f), 0, 0);
        Unit r113 = Unit.INSTANCE;
        r110.addView(r111, r112);
        this.f410512j = (UDShadowLayout) r106.getValue();
    L13:
        d().addView(r103.c(r100, d()), new ViewGroup.LayoutParams(-1, -1));
        Intrinsics.checkNotNullParameter(this, "control");
        r103.f414952f = this;
        return;
    L12:
        e().addView(d(), r109);
        d().setVisibility(4);
        this.f410512j = d();
        goto L13
    L5:
        r108 = null;
        goto L6
    }

    public static void h(DragPanel r100, boolean r101, float r102, float r103, long r104, Function0 r110, Function1 r111) {
        DragPanel$startPanelAnim$1 r105 = DragPanel$startPanelAnim$1.INSTANCE;
        float r106 = r100.f410507e;
        float r107 = r106 - r102;
        float r108 = (r106 - r103) - r107;
        ValueAnimator r109 = ValueAnimator.ofFloat(new float[]{1000.0f});
        r109.setInterpolator(new AccelerateDecelerateInterpolator());
        r109.setDuration(r104);
        r109.addUpdateListener(new e(r107, r108, r100, r111));
        r109.addListener(new f(r100, r101, r105, r110));
        r109.start();
    }
}
