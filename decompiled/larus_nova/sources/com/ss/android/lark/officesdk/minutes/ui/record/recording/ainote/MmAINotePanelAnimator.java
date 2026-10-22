package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.os.Build;
import android.os.SystemClock;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes37.dex */
public final class MmAINotePanelAnimator {
    public static final /* synthetic */ int Q = 0;
    public float A;
    public boolean B;
    public float C;
    public Float D;
    public float E;
    public VelocityTracker F;
    public long G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public MmAINoteSheetState f435967J;
    public boolean K;
    public boolean L;
    public long M;
    public Interpolator N;
    public k O;
    public final Map<TextView, Runnable> P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mwb.b f435968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f435969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f435970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f435971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Boolean, Unit> f435972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f435973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f435974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f435975h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f435976i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewGroup f435977j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DecelerateInterpolator f435978k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f435979l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f435980m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f435981n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public MmAINoteSheetState f435982o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FullStateSource f435983p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ValueAnimator f435984q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f435985r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ValueAnimator f435986s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f435987t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f435988u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public MmAINoteSheetState f435989v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f435990w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f435991x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f435992y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f435993z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINotePanelAnimator$FullStateSource;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL_SHOW", "KEYBOARD_PROMOTED", "MANUAL_GESTURE", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FullStateSource extends Enum<FullStateSource> {
        public static final FullStateSource INITIAL_SHOW = null;
        public static final FullStateSource KEYBOARD_PROMOTED = null;
        public static final FullStateSource MANUAL_GESTURE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FullStateSource[] f435994a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f435995b = null;

        public static EnumEntries<FullStateSource> getEntries() {
            return f435995b;
        }

        static {
            FullStateSource r100 = new FullStateSource("INITIAL_SHOW", 0);
            INITIAL_SHOW = r100;
            FullStateSource r101 = new FullStateSource("KEYBOARD_PROMOTED", 1);
            KEYBOARD_PROMOTED = r101;
            FullStateSource r102 = new FullStateSource("MANUAL_GESTURE", 2);
            MANUAL_GESTURE = r102;
            FullStateSource[] r103 = {r100, r101, r102};
            f435994a = r103;
            f435995b = EnumEntriesKt.enumEntries(r103);
        }

        public static FullStateSource[] values() {
            return (FullStateSource[]) f435994a.clone();
        }

        public static FullStateSource valueOf(String r100) {
            return (FullStateSource) r27.a.a(FullStateSource.class, r100);
        }

        public FullStateSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmAINotePanelAnimator f435996a;

        public a(MmAINotePanelAnimator r100) {
            this.f435996a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f435996a.f435970c.invoke();
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmAINotePanelAnimator f435997a;

        public b(MmAINotePanelAnimator r100) {
            this.f435997a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f435997a.f435970c.invoke();
        }
    }

    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmAINotePanelAnimator f435998a;

        public c(MmAINotePanelAnimator r100) {
            this.f435998a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            if ((r103 - r101) == (r107 - r105)) goto L5;
        L8:
            boolean r109 = true;
        L9:
            if (r109 == false) goto L40;
            MmAINotePanelAnimator r110 = this.f435998a;
            if (r110.f435973f.isAttachedToWindow() == true) goto L13;
            return;
        L13:
            if (r110.K == false) goto L15;
            return;
        L15:
            if (r110.f435991x == false) goto L43;
            WindowInsetsCompat r111 = ViewCompat.getRootWindowInsets(r110.f435973f);
            if (r111 == null) goto L22;
            r110.f435987t = r111.getInsets(WindowInsetsCompat.Type.statusBars()).top;
        L22:
            if (r110.f435982o != MmAINoteSheetState.CLOSED) goto L24;
            MmAINoteSheetState r112 = null;
        L31:
            if (r112 != null) goto L34;
            return;
        L34:
            if (r110.f435982o == r112) goto L38;
            r110.f435982o = r112;
            if (r112 != MmAINoteSheetState.HALF) goto L38;
            r110.f435983p = null;
        L38:
            r110.h(r110.a(r112));
            return;
        L24:
            r112 = r110.f435967J;
            if (r112 != null) goto L31;
            if (r110.w() == false) goto L30;
            r112 = MmAINoteSheetState.FULL;
            goto L31
        L30:
            r112 = MmAINoteSheetState.HALF;
            goto L31
        L43:
            return;
        L40:
            return;
        L5:
            if ((r104 - r102) != (r108 - r106)) goto L8;
            r109 = false;
            goto L9
        }
    }

    public static final class d {
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f435999a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f436000b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f436001c = null;

        static {
            int[] r100 = new int[MmAINoteHint.values().length];
            r100[MmAINoteHint.SUBTITLE_MISSING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r100[MmAINoteHint.MARK_THROTTLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L6:
            f435999a = r100;
            int[] r101 = new int[MmAINoteSheetState.values().length];
            r101[MmAINoteSheetState.FULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L39:
            r101[MmAINoteSheetState.HALF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L33:
            r101[MmAINoteSheetState.CLOSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L11:
            f436000b = r101;
            int[] r102 = new int[FullStateSource.values().length];
            r102[FullStateSource.MANUAL_GESTURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L35:
            r102[FullStateSource.INITIAL_SHOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L25:
            r102[FullStateSource.KEYBOARD_PROMOTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L15:
            f436001c = r102;
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmAINotePanelAnimator f436002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f436003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f436004c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f436005d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f436006e;

        public f(MmAINotePanelAnimator r100, float r101, float r102, float r103, float r104) {
            this.f436002a = r100;
            this.f436003b = r101;
            this.f436004c = r102;
            this.f436005d = r103;
            this.f436006e = r104;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
            float r102 = ((Float) r101).floatValue();
            MmAINotePanelAnimator r103 = this.f436002a;
            float r104 = this.f436003b;
            r103.D = Float.valueOf(r104 + ((this.f436004c - r104) * r102));
            MmAINotePanelAnimator r105 = this.f436002a;
            float r106 = this.f436005d;
            r105.E = r106 + ((this.f436006e - r106) * r102);
            r105.e();
        }
    }

    public static final class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f436007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MmAINotePanelAnimator f436008b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f436009c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f436007a = true;
            this.f436008b.f435985r = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            MmAINotePanelAnimator r101 = this.f436008b;
            r101.f435985r = null;
            if (this.f436007a == false) goto L5;
            return;
        L5:
            r101.j();
            this.f436009c.invoke();
        }

        public g(MmAINotePanelAnimator r100, Function0<Unit> r101) {
            this.f436008b = r100;
            this.f436009c = r101;
        }
    }

    public static final class h implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmAINotePanelAnimator f436010a;

        public h(MmAINotePanelAnimator r100) {
            this.f436010a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            MmAINotePanelAnimator r101 = this.f436010a;
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
            r101.h(((Integer) r102).intValue());
        }
    }

    public static final class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmAINotePanelAnimator f436011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MmAINoteSheetState f436012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FullStateSource f436013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f436014d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f436015e;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            MmAINotePanelAnimator r101 = this.f436011a;
            if (r101.f435984q == r100) goto L5;
            return;
        L5:
            r101.f435984q = null;
            r101.f435982o = this.f436012b;
            r101.f435983p = this.f436013c;
            r101.h(this.f436014d);
            this.f436011a.j();
            MmAINotePanelAnimator r102 = this.f436011a;
            MmAINoteSheetState r103 = this.f436012b;
            r102.getClass();
            if (r103 == MmAINoteSheetState.HALF) goto L8;
        L10:
            Function0<Unit> r104 = this.f436015e;
            if (r104 == null) goto L14;
            r104.invoke();
            return;
        L14:
            return;
        L8:
            if (r102.I == false) goto L10;
            r102.I = false;
            r102.H = false;
            r102.F(0);
            goto L10
        }

        public i(MmAINotePanelAnimator r100, MmAINoteSheetState r101, FullStateSource r102, int r103, Function0<Unit> r104) {
            this.f436011a = r100;
            this.f436012b = r101;
            this.f436013c = r102;
            this.f436014d = r103;
            this.f436015e = r104;
        }
    }

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f436016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MmAINotePanelAnimator f436017b;

        public j(TextView r100, MmAINotePanelAnimator r101) {
            this.f436016a = r100;
            this.f436017b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f436016a.setVisibility(8);     // Catch: Throwable -> L4
            this.f436017b.P.remove(this.f436016a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void j() {
        this.C = 0.0f;
        this.D = null;
        this.E = 0.0f;
    }

    public final float A() {
        Float r100 = this.D;
        if (r100 != null) goto L5;
        MmAINoteSheetState r101 = this.f435982o;
        int r102 = e.f436000b[r101.ordinal()];
        if (r102 != 1) goto L9;
        return 1.0f;
    L9:
        if (r102 != 2) goto L11;
    L15:
        return 0.0f;
    L11:
        if (r102 == 3) goto L15;
        throw new NoWhenBranchMatchedException();
    L5:
        return r100.floatValue();
    }

    public final MmAINoteSheetState C() {
        FullStateSource r100 = this.f435983p;
        if (r100 != null) goto L5;
        int r101 = -1;
    L6:
        if (r101 != (-1)) goto L8;
        MmAINoteSheetState r102 = this.f435989v;
        if (r102 == null) goto L24;
        return r102;
    L24:
        return this.f435982o;
    L8:
        if (r101 == 1) goto L27;
        if (r101 == 2) goto L17;
        if (r101 == 3) goto L17;
        throw new NoWhenBranchMatchedException();
    L17:
        if (w() == false) goto L26;
        return MmAINoteSheetState.FULL;
    L26:
        return MmAINoteSheetState.HALF;
    L27:
        return MmAINoteSheetState.FULL;
    L5:
        r101 = e.f436001c[r100.ordinal()];
        goto L6
    }

    public final void e() {
        Float r100 = this.D;
        if (r100 == null) goto L5;
        float r101 = r100.floatValue();
    L6:
        g(MathKt.roundToInt(l() + ((q() - l()) * RangesKt.coerceIn(r101, 0.0f, 1.0f))), this.E);
        return;
    L5:
        r101 = A();
        goto L6
    }

    public final void i() {
        if (this.K == false) goto L5;
        return;
    L5:
        if (this.f435982o == MmAINoteSheetState.CLOSED) goto L16;
        ValueAnimator r100 = this.f435984q;
        if (r100 == null) goto L10;
        r100.cancel();
    L10:
        ValueAnimator r101 = this.f435985r;
        if (r101 == null) goto L13;
        r101.cancel();
    L13:
        this.f435992y = true;
        this.f435993z = m();
        float r102 = A();
        this.C = r102;
        this.D = Float.valueOf(r102);
        this.E = 0.0f;
        return;
    }

    public final int l() {
        float r100 = this.f435973f.getHeight();
        Resources r101 = this.f435973f.getResources();
        Float r102 = Float.valueOf(WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
        if (r102.floatValue() <= 0.0f) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L11;
        float r104 = r102.floatValue();
    L13:
        if ((this.f435973f.getWidth() / r104) < 840.0f) goto L15;
        float r105 = 0.56f;
    L17:
        return RangesKt.coerceIn(MathKt.roundToInt(r100 * r105), 0, q());
    L15:
        r105 = 0.65f;
        goto L17
    L11:
        r104 = 1.0f;
        goto L13
    L5:
        r103 = false;
        goto L6
    }

    public final int m() {
        return RangesKt.coerceAtLeast(this.f435973f.getHeight() - n(), 0);
    }

    public final int n() {
        ViewGroup.LayoutParams r100 = this.f435974g.getLayoutParams();
        if ((r100 instanceof FrameLayout.LayoutParams) == false) goto L5;
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) r100;
    L6:
        if (r101 == null) goto L8;
        int r102 = r101.height;
    L9:
        if (r102 <= 0) goto L12;
        return r102;
    L12:
        return this.f435974g.getHeight();
    L8:
        r102 = 0;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    public final int q() {
        return RangesKt.coerceAtLeast(this.f435973f.getHeight() - s(), 0);
    }

    public final int s() {
        return RangesKt.coerceIn(this.f435987t, 0, this.f435973f.getHeight());
    }

    public final int t() {
        return RangesKt.coerceAtLeast(this.f435973f.getHeight() - l(), s());
    }

    public final void v() {
        if (this.K == false) goto L5;
        return;
    L5:
        o("dismiss");
        this.K = true;
        View r100 = this.f435968a.f516011f.findFocus();
        if (r100 == null) goto L8;
        r100.clearFocus();
    L8:
        this.f435968a.f516011f.clearFocus();
        View r101 = this.f435968a.f516011f.findFocus();
        if (r101 == null) goto L11;
        r101.clearFocus();
    L11:
        this.f435968a.f516011f.clearFocus();
        u(this.f435973f);
        c(this.f435973f.getHeight(), 240, MmAINoteSheetState.CLOSED, null, "hide", new MmAINotePanelAnimator$hideSheet$1(this));
    }

    public final boolean w() {
        int r100 = this.f435969b.invoke().intValue();
        View r101 = this.f435975h;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        View r103 = this.f435968a.f516022q;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) + y9c.d.a(34);
        if (r100 <= RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(l(), 0) - r105, 0)) goto L14;
        return true;
    L14:
        return false;
    L9:
        r104 = Math.max(r103.getMeasuredHeight(), r103.getHeight());
        goto L10
    L5:
        r102 = Math.max(r101.getMeasuredHeight(), r101.getHeight());
        goto L6
    }

    public final MmAINoteSheetState B(int r100) {
        if (Math.abs(r100 - s()) > Math.abs(r100 - t())) goto L6;
        return MmAINoteSheetState.FULL;
    L6:
        return MmAINoteSheetState.HALF;
    }

    public final void E(TextView r100) {
        Runnable r101 = this.P.remove(r100);
        if (r101 == null) goto L5;
        r100.removeCallbacks(r101);
    L5:
        r100.setVisibility(0);
        r100.bringToFront();
        j r102 = new j(r100, this);
        this.P.put(r100, r102);
        r100.postDelayed(r102, 2000);
    }

    public final void F(int r100) {
        if (this.H == false) goto L5;
        return;
    L5:
        int r101 = y9c.d.a(34);
        if (r100 <= 0) goto L8;
        r101 = Math.max(r101, r100);
    L8:
        ViewGroup.LayoutParams r102 = this.f435968a.f516022q.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
    L12:
        if (r103 != null) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L19;
        return;
    L19:
        if (r103 == null) goto L21;
        r103.bottomMargin = r101;
        this.f435968a.f516022q.setLayoutParams(r103);
    L21:
        this.f435968a.f516022q.requestLayout();
        this.f435977j.requestLayout();
        return;
    L14:
        if (r103.bottomMargin != r101) goto L16;
        r104 = true;
        goto L17
    L11:
        r103 = null;
        goto L12
    }

    public final void G(float r100) {
        if (this.f435992y == true) goto L5;
        return;
    L5:
        float r101 = RangesKt.coerceAtLeast(q() - l(), 1.0f);
        if (r101 > 0.0f) goto L8;
        return;
    L8:
        int r102 = this.f435993z + MathKt.roundToInt(r100);
        int r103 = s();
        int r104 = this.f435973f.getHeight();
        if (r102 >= r103) goto L15;
        int r105 = r103 - r102;
        int r106 = this.f435980m;
        if (r105 <= r106) goto L14;
        r105 = MathKt.roundToInt((r105 - r106) * 0.35f) + r106;
    L14:
        r102 = r103 - r105;
    L22:
        if (r100 <= 0.0f) goto L32;
        float r107 = RangesKt.coerceAtLeast(r100 - (this.C * r101), 0.0f);
        if (r102 <= this.f435973f.getHeight()) goto L26;
        float r108 = r102 - this.f435973f.getHeight();
    L27:
        this.E = r108;
        if (r107 <= 0.0f) goto L30;
        Float r109 = Float.valueOf(0.0f);
    L31:
        this.D = r109;
    L33:
        e();
        return;
    L30:
        r109 = Float.valueOf(RangesKt.coerceIn(this.C - (r100 / r101), 0.0f, 1.0f));
        goto L31
    L26:
        r108 = r107;
        goto L27
    L32:
        this.E = 0.0f;
        this.D = Float.valueOf(RangesKt.coerceIn(this.C + ((-r100) / r101), 0.0f, 1.0f));
        goto L33
    L15:
        if (r102 <= r104) goto L22;
        int r110 = r102 - r104;
        int r111 = this.f435980m;
        if (r110 <= r111) goto L20;
        r110 = MathKt.roundToInt((r110 - r111) * 0.35f) + r111;
    L20:
        r102 = r110 + r104;
        goto L22
    }

    public final int a(MmAINoteSheetState r100) {
        int r101 = e.f436000b[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return this.f435973f.getHeight();
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return t();
    L13:
        return s();
    }

    public final void h(int r100) {
        int r101 = RangesKt.coerceIn(r100, s(), this.f435973f.getHeight());
        g(RangesKt.coerceAtLeast(this.f435973f.getHeight() - r101, 0), this.f435974g.getTranslationY());
    }

    public final void k(String r100) {
        if (this.K == false) goto L5;
        return;
    L5:
        if (this.f435973f.getHeight() <= 0) goto L10;
        this.f435983p = null;
        d(this, t(), 220, MmAINoteSheetState.HALF, null, r100);
        return;
    }

    public final void o(String r110) {
        if (this.f435973f.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (this.f435973f.isInTouchMode() == false) goto L17;
        return;
    L17:
        ViewParent r100 = this.f435973f.getRootView().getParent();     // Catch: Throwable -> L14
        if (r100 != null) goto L12;
        int r101 = bwb.b.f21271a;     // Catch: Throwable -> L14
        bwb.b.h(MmUiLogScene.AI_NOTE, "MmAINotePanelAnimator", "[enterTouchModeFromAINote] ViewRoot is unavailable reason=".concat(r110), null);     // Catch: Throwable -> L14
        return;
    L12:
        Method r102 = r100.getClass().getDeclaredMethod("ensureTouchMode", new Class[]{Boolean.TYPE});     // Catch: Throwable -> L14
        r102.setAccessible(true);     // Catch: Throwable -> L14
        Object r103 = r102.invoke(r100, new Object[]{Boolean.TRUE});     // Catch: Throwable -> L14
        int r104 = bwb.b.f21271a;     // Catch: Throwable -> L14
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINotePanelAnimator", "[enterTouchModeFromAINote] changed=" + r103 + " inTouchMode=" + this.f435973f.isInTouchMode() + " reason=" + r110, null, 8);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        int r105 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.AI_NOTE, "MmAINotePanelAnimator", "[enterTouchModeFromAINote] failed reason=" + r110 + " error=" + th.getClass().getSimpleName() + ':' + th.getMessage(), null);
    }

    public final void r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        ValueAnimator r101 = this.f435984q;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        ValueAnimator r102 = this.f435985r;
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        z(r100);
    }

    public final void u(View r100) {
        InputMethodManager r101 = (InputMethodManager) this.f435973f.getContext().getSystemService(InputMethodManager.class);
        if (r101 == null) goto L6;
        r101.hideSoftInputFromWindow(r100.getWindowToken(), 0);
        return;
    }

    public final int x(int r100) {
        return RangesKt.coerceAtLeast(r100 - this.f435990w, 0);
    }

    public final void y(String r100) {
        if (this.f435988u > 0) goto L5;
        return;
    L5:
        if (this.L == true) goto L10;
        this.L = true;
        int r101 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "[maybeDismissImeForPanelDrag] source=".concat(r100), null, null, 12);
        u(this.f435973f);
        return;
    }

    public final void z(String r100) {
        int r101 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "[release] reason=".concat(r100), null, null, 12);
        ValueAnimator r102 = this.f435984q;
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        ValueAnimator r103 = this.f435985r;
        if (r103 == null) goto L8;
        r103.cancel();
    L8:
        ValueAnimator r104 = this.f435986s;
        if (r104 == null) goto L11;
        r104.cancel();
    L11:
        VelocityTracker r105 = this.F;
        if (r105 == null) goto L14;
        r105.recycle();
    L14:
        this.F = null;
        this.f435984q = null;
        this.f435985r = null;
        this.f435986s = null;
        this.f435982o = MmAINoteSheetState.CLOSED;
        this.f435968a.f516015j.a();
        this.f435968a.f516020o.a();
        k r106 = this.O;
        if (r106 == null) goto L21;
        ViewTreeObserver r107 = this.f435973f.getViewTreeObserver();
        if (r107 == null) goto L21;
        if (r107.isAlive() == false) goto L21;
        r107.removeOnGlobalFocusChangeListener(r106);
    L21:
        this.O = null;
        this.f435972e.invoke(Boolean.FALSE);
        this.f435971d.invoke();
    }

    public final void D(float r110, float r111) {
        final float r100 = this.C;
        Float r101 = this.D;
        if (r101 == null) goto L5;
        float r102 = r101.floatValue();
    L6:
        float r103 = this.E;
        float r104 = y9c.d.a(2);
        float r105 = y9c.d.a(40);
        boolean r106 = true;
        if (r100 > 0.0f) goto L9;
    L11:
        boolean r107 = false;
    L13:
        if (r110 > 0.0f) goto L15;
    L18:
        if (r107 == false) goto L26;
        if (r110 < r105) goto L22;
    L23:
        b(r102, r102, r103, this.f435973f.getHeight(), new MmAINotePanelAnimator$settleAfterDrag$2(this));
        return;
    L22:
        if (r111 > this.f435981n) goto L23;
    L26:
        if (r103 <= 0.0f) goto L38;
        if (r110 < r104) goto L30;
    L33:
        if (r106 == false) goto L35;
        b(r102, r102, r103, this.f435973f.getHeight(), new MmAINotePanelAnimator$settleAfterDrag$3(this));
        return;
    L35:
        b(r102, 0.0f, r103, 0.0f, new MmAINotePanelAnimator$settleAfterDrag$4(this));
        return;
    L30:
        if (r111 > this.f435981n) goto L33;
        r106 = false;
        goto L33
    L38:
        if (r110 <= (-r104)) goto L51;
        float r108 = this.f435981n;
        if (r111 < (-r108)) goto L51;
        if (r110 < r104) goto L45;
    L50:
        r106 = false;
        goto L51
    L45:
        if (r111 > r108) goto L50;
        if (r102 <= r100) goto L50;
    L51:
        if (r106 == false) goto L53;
        b(r102, 1.0f, 0.0f, 0.0f, new MmAINotePanelAnimator$settleAfterDrag$5(this));
        return;
    L53:
        b(r102, 0.0f, 0.0f, 0.0f, new MmAINotePanelAnimator$settleAfterDrag$6(this));
        return;
    L15:
        if (r110 >= r105) goto L18;
        b(r102, r100, r103, 0.0f, new MmAINotePanelAnimator$settleAfterDrag$1(this, r100));
        return;
    L9:
        if (w() == false) goto L11;
        r107 = true;
        goto L13
    L5:
        r102 = r100;
        goto L6
    }

    public final void g(int r100, float r101) {
        boolean r102 = false;
        int r103 = RangesKt.coerceIn(r100, 0, q());
        ViewGroup.LayoutParams r104 = this.f435974g.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r104;
        if (r105.height == r103) goto L5;
    L6:
        r105.height = r103;
        r105.gravity = 80;
        this.f435974g.setLayoutParams(r105);
    L8:
        if (this.f435974g.getTranslationY() != r101) goto L10;
        r102 = true;
    L10:
        if (r102 == true) goto L13;
        this.f435974g.setTranslationY(r101);
    L13:
        if (r101 <= 0.0f) goto L15;
        float r106 = RangesKt.coerceIn(1.0f - (r101 / Math.max(1, this.f435973f.getHeight())), 0.0f, 1.0f);
    L16:
        this.f435968a.f516008c.setAlpha((RangesKt.coerceIn(r103 / Math.max(1, l()), 0.0f, 1.0f) * 1.0f) * r106);
        return;
    L15:
        r106 = 1.0f;
        goto L16
    L5:
        if (r105.gravity == 80) goto L8;
        goto L6
    }

    public final void p(FullStateSource r100, String r110) {
        if (this.K == false) goto L5;
        return;
    L5:
        if (this.f435973f.getHeight() <= 0) goto L10;
        this.f435983p = r100;
        d(this, s(), 220, MmAINoteSheetState.FULL, r100, r110);
        return;
    }

    public final void f(int r100, int r101, String r110, boolean r111) {
        this.f435990w = r101;
        if (this.K == false) goto L6;
        this.f435988u = r100;
        return;
    L6:
        int r102 = x(r100);
        int r103 = x(this.f435988u);
        if (SystemClock.uptimeMillis() >= this.G) goto L11;
        if (r102 != 0) goto L11;
        return;
    L11:
        if (r102 > 0) goto L13;
    L15:
        if (r102 != 0) goto L21;
        if (r103 <= 0) goto L21;
        if (this.L == true) goto L21;
        this.f435967J = C();
    L21:
        if (r102 != 0) goto L29;
        if (r103 <= 0) goto L29;
        if (this.L == true) goto L29;
        if (this.f435967J != MmAINoteSheetState.HALF) goto L29;
        this.H = true;
        this.I = true;
    L29:
        if (this.H == true) goto L49;
        if (r102 > 0) goto L32;
    L46:
        int r104 = r102;
    L47:
        F(r104);
        goto L49
    L32:
        if (this.f435990w <= 0) goto L46;
        if (this.f435973f.getHeight() <= 0) goto L42;
        Resources r105 = this.f435973f.getResources();
        int r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).heightPixels;
        if (r106 <= 0) goto L42;
        int[] r107 = new int[2];
        this.f435973f.getLocationOnScreen(r107);
        if ((r107[1] + this.f435973f.getHeight()) < (r106 - y9c.d.a(2))) goto L42;
        boolean r108 = true;
    L43:
        if (r108 == false) goto L46;
        r104 = r100;
    L42:
        r108 = false;
    L49:
        if (r111 == false) goto L51;
        int r112 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINotePanelAnimator", "[applyKeyboardHeight] source=" + r110 + " imeBottom=" + r100 + " keyboardLift=" + r102 + " stableBottomInset=" + this.f435990w, null, 8);
    L51:
        ValueAnimator r113 = this.f435984q;
        if (r113 != null) goto L54;
    L56:
        boolean r114 = false;
    L58:
        if (this.f435973f.getHeight() <= 0) goto L68;
        if (this.f435992y == true) goto L68;
        if (r102 != 0) goto L68;
        if (r103 != 0) goto L68;
        MmAINoteSheetState r109 = this.f435982o;
        if (r109 == MmAINoteSheetState.CLOSED) goto L68;
        if (r114 == true) goto L68;
        h(a(r109));
    L68:
        if (this.f435973f.getHeight() != 0) goto L70;
        this.f435988u = r100;
        return;
    L70:
        if (r100 > 0) goto L72;
    L88:
        int r115 = x(r100);
        int r116 = x(this.f435988u);
        if (r115 <= 0) goto L97;
        if (r116 != 0) goto L97;
        MmAINoteSheetState r117 = this.f435982o;
        this.f435989v = r117;
        MmAINoteSheetState r118 = MmAINoteSheetState.FULL;
        if (r117 == r118) goto L97;
        this.f435983p = FullStateSource.KEYBOARD_PROMOTED;
        ValueAnimator r119 = this.f435984q;
        if (r119 == null) goto L96;
        r119.cancel();
    L96:
        j();
        this.f435982o = r118;
    L97:
        if (r115 != 0) goto L116;
        if (r116 <= 0) goto L116;
        if (this.L == false) goto L102;
        this.f435989v = null;
        this.f435967J = null;
        this.L = false;
        this.f435988u = r100;
        return;
    L102:
        MmAINoteSheetState r120 = this.f435967J;
        if (r120 != null) goto L105;
        r120 = C();
    L105:
        int r121 = e.f436000b[r120.ordinal()];
        if (r121 == 1) goto L114;
        if (r121 != 2) goto L109;
        k("ime_hide");
    L115:
        this.f435989v = null;
        this.f435967J = null;
        this.f435988u = r100;
        return;
    L109:
        if (r121 == 3) goto L115;
        throw new NoWhenBranchMatchedException();
    L114:
        this.H = false;
        this.I = false;
        F(0);
        this.f435982o = MmAINoteSheetState.FULL;
        h(s());
    L116:
        if (r115 <= 0) goto L118;
        h(Math.max(s(), a(MmAINoteSheetState.FULL) - r115));
    L118:
        this.f435988u = r100;
        return;
    L72:
        if (this.f435988u != 0) goto L88;
        if (this.f435991x == false) goto L88;
        if (this.f435983p != FullStateSource.INITIAL_SHOW) goto L88;
        if (this.f435974g.getTranslationY() <= 0.0f) goto L88;
        if (n() != q()) goto L88;
        int r122 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "[finishInitialFullScreenOpenIfNeeded] reason=ime_started", null, null, 12);
        ValueAnimator r123 = this.f435984q;
        if (r123 == null) goto L87;
        r123.cancel();
    L87:
        g(q(), 0.0f);
        goto L88
    L54:
        if (r113.isRunning() != true) goto L56;
        r114 = true;
        goto L58
    L13:
        if (this.H == false) goto L15;
        this.H = false;
        this.I = false;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmAINotePanelAnimator(mwb.b r100, Function0<Integer> r101, Function0<Unit> r102, Function0<Unit> r103, Function1<? super Boolean, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "contentHeightProvider");
        Intrinsics.checkNotNullParameter(r102, "onCloseRequested");
        Intrinsics.checkNotNullParameter(r103, "onDismissed");
        Intrinsics.checkNotNullParameter(r104, "onVisibilityChanged");
        this.f435968a = r100;
        this.f435969b = r101;
        this.f435970c = r102;
        this.f435971d = r103;
        this.f435972e = r104;
        FrameLayout r105 = r100.f516007b;
        this.f435973f = r105;
        FrameLayout r106 = r100.f516010e;
        this.f435974g = r106;
        View r107 = r100.f516012g;
        this.f435975h = r107;
        View r108 = r100.f516026u;
        this.f435976i = r108;
        this.f435977j = r100.f516014i;
        this.f435978k = new DecelerateInterpolator();
        this.f435979l = ViewConfiguration.get(r105.getContext()).getScaledTouchSlop();
        this.f435980m = y9c.d.a(60);
        this.f435981n = y9c.d.a(1200);
        this.f435982o = MmAINoteSheetState.CLOSED;
        this.M = 285;
        this.N = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
        this.P = new LinkedHashMap();
        r105.setClickable(true);
        r105.setFocusable(true);
        r105.setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r105.setDefaultFocusHighlightEnabled(false);
    L5:
        r105.setClipChildren(false);
        r105.setClipToPadding(false);
        r100.f516009d.setClipChildren(false);
        r100.f516009d.setClipToPadding(false);
        r106.setClipChildren(false);
        r106.setClipToPadding(false);
        r106.setClickable(true);
        r100.f516022q.setClickable(true);
        r100.f516008c.setOnClickListener(new a(this));
        r108.setOnClickListener(new b(this));
        r107.setClickable(true);
        r107.setOnClickListener(new l(this));
        r107.setOnTouchListener(new m(this));
        r100.f516013h.setGestureListener(new com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.j(this));
        k r109 = new k(this);
        this.O = r109;
        r105.getViewTreeObserver().addOnGlobalFocusChangeListener(r109);
        r105.addOnLayoutChangeListener(new c(this));
    }

    public final void b(float r100, float r110, float r111, float r112, Function0<Unit> r113) {
        ValueAnimator r101 = this.f435985r;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        float r102 = Math.abs(r110 - r100);
        float r103 = Math.abs(r112 - r111);
        if (r102 < 0.001f) goto L8;
    L11:
        this.C = r100;
        this.D = Float.valueOf(r100);
        this.E = r111;
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r112 > r111) goto L14;
    L16:
        if (r112 <= r111) goto L18;
        long r105 = 260;
    L19:
        r104.setDuration(r105);
        r104.setInterpolator(new AccelerateDecelerateInterpolator());
        r104.addUpdateListener(new f(this, r100, r110, r111, r112));
        r104.addListener(new g(this, r113));
        r104.start();
        this.f435985r = r104;
        return;
    L18:
        r105 = 180;
        goto L19
    L14:
        if (r100 <= 0.0f) goto L16;
        r105 = 300;
        goto L19
    L8:
        if (r103 >= 1.0f) goto L11;
        j();
        r113.invoke();
    }

    public static /* synthetic */ void d(MmAINotePanelAnimator r100, int r101, long r110, MmAINoteSheetState r111, FullStateSource r112, String r113) {
        r100.c(r101, r110, r111, r112, r113, null);
    }

    public final void c(int r100, long r101, MmAINoteSheetState r110, FullStateSource r111, String r112, Function0<Unit> r113) {
        int r102 = m();
        if (r102 != r100) goto L12;
        this.f435982o = r110;
        this.f435983p = r111;
        h(r100);
        j();
        if (r110 == MmAINoteSheetState.HALF) goto L7;
    L9:
        if (r113 == null) goto L20;
        r113.invoke();
        return;
    L20:
        return;
    L7:
        if (this.I == false) goto L9;
        this.I = false;
        this.H = false;
        F(0);
        goto L9
    L12:
        ValueAnimator r103 = this.f435984q;
        if (r103 == null) goto L15;
        r103.cancel();
    L15:
        ValueAnimator r104 = this.f435985r;
        if (r104 == null) goto L18;
        r104.cancel();
    L18:
        int r105 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "[animateSheetTo] reason=" + r112 + " from=" + r102 + " target=" + r100 + " state=" + r110, null, null, 12);
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{r102, r100});
        r114.setDuration(r101);
        r114.setInterpolator(this.f435978k);
        r114.addUpdateListener(new h(this));
        r114.addListener(new i(this, r110, r111, r100, r113));
        r114.start();
        this.f435984q = r114;
    }
}
