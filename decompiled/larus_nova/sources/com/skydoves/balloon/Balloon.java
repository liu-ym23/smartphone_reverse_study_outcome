package com.skydoves.balloon;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.text.HtmlCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBinding;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.skydoves.balloon.databinding.BalloonLayoutBodyBinding;
import com.skydoves.balloon.databinding.BalloonLayoutOverlayBinding;
import com.skydoves.balloon.extensions.BalloonDefaultLifecycleObserver;
import com.skydoves.balloon.overlay.BalloonAnchorOverlayView;
import com.skydoves.balloon.overlay.BalloonOverlayAnimation;
import com.skydoves.balloon.radius.RadiusLayout;
import com.skydoves.balloon.vectortext.VectorTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u000b\fJ!\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0083\bJ$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¨\u0006\r"}, d2 = {"Lcom/skydoves/balloon/Balloon;", "Lcom/skydoves/balloon/extensions/BalloonDefaultLifecycleObserver;", "Landroid/view/View;", "anchor", "Lkotlin/Function0;", "", "block", "update", "", "xOff", "yOff", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "balloon_release"}, k = 1, mv = {1, 7, 1})
public final class Balloon implements BalloonDefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f406018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f406019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BalloonLayoutBodyBinding f406020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BalloonLayoutOverlayBinding f406021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PopupWindow f406022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PopupWindow f406023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f406024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f406025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.skydoves.balloon.j f406026i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f406027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f406028k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f406029l;

    @BalloonInlineDsl
    public static final class a {
        public final int A;
        public final IconGravity B;
        public final int C;
        public final int D;
        public final int E;
        public final int F;
        public final float G;
        public float H;
        public View I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public boolean f406030J;
        public int K;
        public final kqa.b L;
        public final int M;
        public com.skydoves.balloon.i N;
        public com.skydoves.balloon.j O;
        public k P;
        public View.OnTouchListener Q;
        public View.OnTouchListener R;
        public boolean S;
        public boolean T;
        public boolean U;
        public long V;
        public LifecycleOwner W;
        public int X;
        public final int Y;
        public BalloonAnimation Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f406031a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public final BalloonOverlayAnimation f406032a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f406033b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public final long f406034b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f406035c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public final BalloonHighlightAnimation f406036c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f406037d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public final int f406038d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f406039e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public final boolean f406040e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f406041f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public final int f406042f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f406043g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public boolean f406044g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f406045h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public final boolean f406046h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f406047i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public final boolean f406048i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f406049j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f406050k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f406051l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f406052m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f406053n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f406054o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f406055p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public ArrowPositionRules f406056q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final ArrowOrientationRules f406057r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public ArrowOrientation f406058s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public Drawable f406059t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final float f406060u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f406061v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public float f406062w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final CharSequence f406063x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f406064y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f406065z;

        public final void i() {
            this.H = MathKt.roundToInt(TypedValue.applyDimension(1, 0, a(Resources.getSystem())));
        }

        public final void m() {
            float r100 = 0;
            this.f406041f = MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem())));
            this.f406043g = MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem())));
            this.f406045h = MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem())));
            this.f406047i = MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem())));
        }

        public final Balloon b() {
            return new Balloon(this.f406031a, this);
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f406031a = r100;
            this.f406033b = Integer.MIN_VALUE;
            this.f406035c = new Point(a(Resources.getSystem()).widthPixels, a(Resources.getSystem()).heightPixels).x;
            this.f406039e = Integer.MIN_VALUE;
            this.f406052m = true;
            this.f406053n = Integer.MIN_VALUE;
            this.f406054o = MathKt.roundToInt(TypedValue.applyDimension(1, 12, a(Resources.getSystem())));
            this.f406055p = 0.5f;
            this.f406056q = ArrowPositionRules.ALIGN_BALLOON;
            this.f406057r = ArrowOrientationRules.ALIGN_ANCHOR;
            this.f406058s = ArrowOrientation.BOTTOM;
            this.f406060u = 2.5f;
            this.f406061v = -16777216;
            this.f406062w = TypedValue.applyDimension(1, 5.0f, a(Resources.getSystem()));
            StringCompanionObject r101 = StringCompanionObject.INSTANCE;
            this.f406063x = "";
            int r102 = -1;
            this.f406064y = -1;
            this.f406065z = 12.0f;
            this.A = 17;
            this.B = IconGravity.START;
            float r103 = 28;
            this.C = MathKt.roundToInt(TypedValue.applyDimension(1, r103, a(Resources.getSystem())));
            this.D = MathKt.roundToInt(TypedValue.applyDimension(1, r103, a(Resources.getSystem())));
            this.E = MathKt.roundToInt(TypedValue.applyDimension(1, 8, a(Resources.getSystem())));
            this.F = Integer.MIN_VALUE;
            this.G = 1.0f;
            this.H = TypedValue.applyDimension(1, 2.0f, a(Resources.getSystem()));
            this.L = kqa.b.f505660a;
            this.M = 17;
            this.S = true;
            this.U = true;
            this.V = -1;
            this.X = Integer.MIN_VALUE;
            this.Y = Integer.MIN_VALUE;
            this.Z = BalloonAnimation.FADE;
            this.f406032a0 = BalloonOverlayAnimation.FADE;
            this.f406034b0 = 500;
            this.f406036c0 = BalloonHighlightAnimation.NONE;
            this.f406038d0 = Integer.MIN_VALUE;
            if (r100.getResources().getConfiguration().getLayoutDirection() != 1) goto L5;
            boolean r104 = true;
        L6:
            this.f406040e0 = r104;
            if (r104 == true) goto L10;
            r102 = 1;
        L10:
            this.f406042f0 = r102;
            this.f406044g0 = true;
            this.f406046h0 = true;
            this.f406048i0 = true;
            return;
        L5:
            r104 = false;
            goto L6
        }

        public static DisplayMetrics a(Resources r100) {
            return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        }

        public final void c(int r100) {
            Context r101 = this.f406031a;
            Intrinsics.checkNotNullParameter(r101, "<this>");
            Drawable r102 = AppCompatResources.getDrawable(r101, r100);
            if (r102 == null) goto L5;
            Drawable r103 = r102.mutate();
        L6:
            this.f406059t = r103;
            if (r102 != null) goto L9;
            return;
        L9:
            if (this.f406054o != Integer.MIN_VALUE) goto L13;
            this.f406054o = Math.max(r102.getIntrinsicWidth(), r102.getIntrinsicHeight());
            return;
        L13:
            return;
        L5:
            r103 = null;
            goto L6
        }

        public final void d(ArrowOrientation r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f406058s = r100;
        }

        public final void e(ArrowPositionRules r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f406056q = r100;
        }

        public final void f(int r100) {
            int r101 = Integer.MIN_VALUE;
            if (r100 == Integer.MIN_VALUE) goto L6;
            r101 = MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem())));
        L6:
            this.f406054o = r101;
        }

        public final void g(BalloonAnimation r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.Z = r100;
            if (r100 != BalloonAnimation.CIRCULAR) goto L6;
            this.f406044g0 = false;
            return;
        }

        public final void h(boolean r100) {
            this.S = r100;
            if (r100 == true) goto L6;
            this.f406044g0 = r100;
            return;
        }

        public final void j(int r100) {
            if (r100 <= 0) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L13;
            this.f406039e = MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem())));
            return;
        L13:
            throw new IllegalArgumentException("The height of the balloon must bigger than zero.".toString());
        L5:
            if (r100 == Integer.MIN_VALUE) goto L8;
            r101 = false;
            goto L9
        }

        public final void k(ViewBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            this.I = r100.getRoot();
        }

        public final /* synthetic */ void l(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "block");
            this.N = new com.skydoves.balloon.i(r100);
        }

        public final void n(int r100) {
            if (r100 <= 0) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L13;
            this.f406033b = MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem())));
            return;
        L13:
            throw new IllegalArgumentException("The width of the balloon must bigger than zero.".toString());
        L5:
            if (r100 == Integer.MIN_VALUE) goto L8;
            r101 = false;
            goto L9
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract Balloon a();
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f406066a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f406067b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f406068c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f406069d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f406070e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f406071f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int[] f406072g = null;

        static {
            int[] r100 = new int[ArrowOrientation.values().length];
            r100[ArrowOrientation.BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L38
        L92:
            r100[ArrowOrientation.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L39
        L108:
            r100[ArrowOrientation.START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L40
        L70:
            r100[ArrowOrientation.END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L41
        L10:
            f406066a = r100;
            int[] r101 = new int[ArrowPositionRules.values().length];
            r101[ArrowPositionRules.ALIGN_BALLOON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L42
        L96:
            r101[ArrowPositionRules.ALIGN_ANCHOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L43
        L13:
            f406067b = r101;
            int[] r102 = new int[BalloonAnimation.values().length];
            r102[BalloonAnimation.ELASTIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L44
        L86:
            r102[BalloonAnimation.CIRCULAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L45
        L98:
            r102[BalloonAnimation.FADE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L46
        L62:
            r102[BalloonAnimation.OVERSHOOT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L47
        L74:
            r102[BalloonAnimation.NONE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L48
        L19:
            f406068c = r102;
            int[] r103 = new int[BalloonOverlayAnimation.values().length];
            r103[BalloonOverlayAnimation.FADE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L49
        L21:
            f406069d = r103;
            int[] r104 = new int[BalloonHighlightAnimation.values().length];
            r104[BalloonHighlightAnimation.HEARTBEAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L50
        L102:
            r104[BalloonHighlightAnimation.SHAKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L51
        L64:
            r104[BalloonHighlightAnimation.BREATH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L52
        L76:
            r104[BalloonHighlightAnimation.ROTATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L53
        L26:
            f406070e = r104;
            int[] r105 = new int[BalloonCenterAlign.values().length];
            r105[BalloonCenterAlign.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L54
        L66:
            r105[BalloonCenterAlign.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L55
        L80:
            r105[BalloonCenterAlign.START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L56
        L90:
            r105[BalloonCenterAlign.END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L57
        L31:
            f406071f = r105;
            int[] r106 = new int[BalloonAlign.values().length];
            r106[BalloonAlign.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
        L82:
            r106[BalloonAlign.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L59
        L94:
            r106[BalloonAlign.END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L60
        L106:
            r106[BalloonAlign.START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L61
        L36:
            f406072g = r106;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f406073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f406074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f406075c;

        public static final class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function0 f406076a;

            public a(Function0 r100) {
                this.f406076a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
                super.onAnimationEnd(r100);
                this.f406076a.invoke();
            }
        }

        public d(View r100, long r101, Function0 r102) {
            this.f406073a = r100;
            this.f406074b = r101;
            this.f406075c = r102;
        }

        public final void a() {
            if (this.f406073a.isAttachedToWindow() == false) goto L6;
            View r100 = this.f406073a;
            Animator r101 = ViewAnimationUtils.createCircularReveal(r100, (r100.getLeft() + this.f406073a.getRight()) / 2, (this.f406073a.getTop() + this.f406073a.getBottom()) / 2, Math.max(this.f406073a.getWidth(), this.f406073a.getHeight()), 0.0f);
            r101.setDuration(this.f406074b);
            r101.start();
            r101.addListener(new a(this.f406075c));
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Balloon f406077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f406078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View[] f406079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Balloon f406080d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f406081e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f406082f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f406083g;

        public e(Balloon r100, View r101, View[] r102, Balloon r103, View r104, int r105, int r106) {
            this.f406077a = r100;
            this.f406078b = r101;
            this.f406079c = r102;
            this.f406080d = r103;
            this.f406081e = r104;
            this.f406082f = r105;
            this.f406083g = r106;
        }

        public final void a() {
            Boolean r100 = Boolean.valueOf(this.f406077a.g(this.f406078b));
            if (r100.booleanValue() == true) goto L6;
            r100 = null;
        L6:
            if (r100 == null) goto L19;
            r100.booleanValue();
            this.f406077a.f406019b.getClass();
            Balloon r101 = this.f406077a;
            r101.f406024g = true;
            long r102 = r101.f406019b.V;
            if (r102 == (-1)) goto L11;
            r101.i(r102);
        L11:
            if (this.f406077a.n() == false) goto L13;
            Balloon r103 = this.f406077a;
            r103.z(r103.f406020c.f406141d);
        L14:
            this.f406077a.f406020c.f406138a.measure(0, 0);
            this.f406077a.f406019b.getClass();
            Balloon r104 = this.f406077a;
            r104.f406022e.setWidth(r104.m());
            Balloon r105 = this.f406077a;
            r105.f406022e.setHeight(r105.l());
            this.f406077a.f406020c.f406143f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f406077a.o(this.f406078b);
            this.f406077a.p();
            Balloon.b(this.f406077a);
            Balloon r106 = this.f406077a;
            View[] r107 = this.f406079c;
            Balloon.d(r106, (View[]) Arrays.copyOf(r107, r107.length));
            Balloon.c(this.f406077a);
            Balloon.a(this.f406077a);
            Balloon.e(this.f406077a);
            Balloon r108 = this.f406080d;
            PopupWindow r109 = r108.f406022e;
            View r110 = this.f406081e;
            int r111 = r108.f406019b.f406042f0 * (((r110.getMeasuredWidth() / 2) - (this.f406080d.m() / 2)) + this.f406082f);
            int r112 = this.f406083g;
            OverlaySource r113 = PopupWindowLancet.resolveSource(r110);
            if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r109, r110, r113) == true) goto L20;
            r109.showAsDropDown(r110, r111, r112);
            PopupWindowLancet.trackAfterShow(r109, r113, r110);
            return;
        L20:
            return;
        L13:
            Balloon r114 = this.f406077a;
            BalloonLayoutBodyBinding r115 = r114.f406020c;
            r114.q(r115.f406143f, r115.f406141d);
            goto L14
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Balloon f406084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f406085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View[] f406086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Balloon f406087d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f406088e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f406089f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f406090g;

        public f(Balloon r100, View r101, View[] r102, Balloon r103, View r104, int r105, int r106) {
            this.f406084a = r100;
            this.f406085b = r101;
            this.f406086c = r102;
            this.f406087d = r103;
            this.f406088e = r104;
            this.f406089f = r105;
            this.f406090g = r106;
        }

        public final void a() {
            Boolean r100 = Boolean.valueOf(this.f406084a.g(this.f406085b));
            if (r100.booleanValue() == true) goto L6;
            r100 = null;
        L6:
            if (r100 == null) goto L19;
            r100.booleanValue();
            this.f406084a.f406019b.getClass();
            Balloon r101 = this.f406084a;
            r101.f406024g = true;
            long r102 = r101.f406019b.V;
            if (r102 == (-1)) goto L11;
            r101.i(r102);
        L11:
            if (this.f406084a.n() == false) goto L13;
            Balloon r103 = this.f406084a;
            r103.z(r103.f406020c.f406141d);
        L14:
            this.f406084a.f406020c.f406138a.measure(0, 0);
            this.f406084a.f406019b.getClass();
            Balloon r104 = this.f406084a;
            r104.f406022e.setWidth(r104.m());
            Balloon r105 = this.f406084a;
            r105.f406022e.setHeight(r105.l());
            this.f406084a.f406020c.f406143f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f406084a.o(this.f406085b);
            this.f406084a.p();
            Balloon.b(this.f406084a);
            Balloon r106 = this.f406084a;
            View[] r107 = this.f406086c;
            Balloon.d(r106, (View[]) Arrays.copyOf(r107, r107.length));
            Balloon.c(this.f406084a);
            Balloon.a(this.f406084a);
            Balloon.e(this.f406084a);
            Balloon r108 = this.f406087d;
            PopupWindow r109 = r108.f406022e;
            View r110 = this.f406088e;
            int r111 = (-r108.m()) + this.f406089f;
            int r112 = ((-(this.f406087d.l() / 2)) - (this.f406088e.getMeasuredHeight() / 2)) + this.f406090g;
            OverlaySource r113 = PopupWindowLancet.resolveSource(r110);
            if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r109, r110, r113) == true) goto L20;
            r109.showAsDropDown(r110, r111, r112);
            PopupWindowLancet.trackAfterShow(r109, r113, r110);
            return;
        L20:
            return;
        L13:
            Balloon r114 = this.f406084a;
            BalloonLayoutBodyBinding r115 = r114.f406020c;
            r114.q(r115.f406143f, r115.f406141d);
            goto L14
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Balloon f406091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f406092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View[] f406093c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Balloon f406094d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f406095e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f406096f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f406097g;

        public g(Balloon r100, View r101, View[] r102, Balloon r103, View r104, int r105, int r106) {
            this.f406091a = r100;
            this.f406092b = r101;
            this.f406093c = r102;
            this.f406094d = r103;
            this.f406095e = r104;
            this.f406096f = r105;
            this.f406097g = r106;
        }

        public final void a() {
            Boolean r100 = Boolean.valueOf(this.f406091a.g(this.f406092b));
            if (r100.booleanValue() == true) goto L6;
            r100 = null;
        L6:
            if (r100 == null) goto L19;
            r100.booleanValue();
            this.f406091a.f406019b.getClass();
            Balloon r101 = this.f406091a;
            r101.f406024g = true;
            long r102 = r101.f406019b.V;
            if (r102 == (-1)) goto L11;
            r101.i(r102);
        L11:
            if (this.f406091a.n() == false) goto L13;
            Balloon r103 = this.f406091a;
            r103.z(r103.f406020c.f406141d);
        L14:
            this.f406091a.f406020c.f406138a.measure(0, 0);
            this.f406091a.f406019b.getClass();
            Balloon r104 = this.f406091a;
            r104.f406022e.setWidth(r104.m());
            Balloon r105 = this.f406091a;
            r105.f406022e.setHeight(r105.l());
            this.f406091a.f406020c.f406143f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f406091a.o(this.f406092b);
            this.f406091a.p();
            Balloon.b(this.f406091a);
            Balloon r106 = this.f406091a;
            View[] r107 = this.f406093c;
            Balloon.d(r106, (View[]) Arrays.copyOf(r107, r107.length));
            Balloon.c(this.f406091a);
            Balloon.a(this.f406091a);
            Balloon.e(this.f406091a);
            PopupWindow r108 = this.f406094d.f406022e;
            View r109 = this.f406095e;
            int r110 = r109.getMeasuredWidth() + this.f406096f;
            int r111 = ((-(this.f406094d.l() / 2)) - (this.f406095e.getMeasuredHeight() / 2)) + this.f406097g;
            OverlaySource r112 = PopupWindowLancet.resolveSource(r109);
            if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r108, r109, r112) == true) goto L20;
            r108.showAsDropDown(r109, r110, r111);
            PopupWindowLancet.trackAfterShow(r108, r112, r109);
            return;
        L20:
            return;
        L13:
            Balloon r113 = this.f406091a;
            BalloonLayoutBodyBinding r114 = r113.f406020c;
            r113.q(r114.f406143f, r114.f406141d);
            goto L14
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Balloon f406098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f406099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View[] f406100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Balloon f406101d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f406102e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f406103f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f406104g;

        public h(Balloon r100, View r101, View[] r102, Balloon r103, View r104, int r105, int r106) {
            this.f406098a = r100;
            this.f406099b = r101;
            this.f406100c = r102;
            this.f406101d = r103;
            this.f406102e = r104;
            this.f406103f = r105;
            this.f406104g = r106;
        }

        public final void a() {
            Boolean r100 = Boolean.valueOf(this.f406098a.g(this.f406099b));
            if (r100.booleanValue() == true) goto L6;
            r100 = null;
        L6:
            if (r100 == null) goto L19;
            r100.booleanValue();
            this.f406098a.f406019b.getClass();
            Balloon r101 = this.f406098a;
            r101.f406024g = true;
            long r102 = r101.f406019b.V;
            if (r102 == (-1)) goto L11;
            r101.i(r102);
        L11:
            if (this.f406098a.n() == false) goto L13;
            Balloon r103 = this.f406098a;
            r103.z(r103.f406020c.f406141d);
        L14:
            this.f406098a.f406020c.f406138a.measure(0, 0);
            this.f406098a.f406019b.getClass();
            Balloon r104 = this.f406098a;
            r104.f406022e.setWidth(r104.m());
            Balloon r105 = this.f406098a;
            r105.f406022e.setHeight(r105.l());
            this.f406098a.f406020c.f406143f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f406098a.o(this.f406099b);
            this.f406098a.p();
            Balloon.b(this.f406098a);
            Balloon r106 = this.f406098a;
            View[] r107 = this.f406100c;
            Balloon.d(r106, (View[]) Arrays.copyOf(r107, r107.length));
            Balloon.c(this.f406098a);
            Balloon.a(this.f406098a);
            Balloon.e(this.f406098a);
            Balloon r108 = this.f406101d;
            PopupWindow r109 = r108.f406022e;
            View r110 = this.f406102e;
            int r111 = r108.f406019b.f406042f0 * (((r110.getMeasuredWidth() / 2) - (this.f406101d.m() / 2)) + this.f406103f);
            int r112 = ((-this.f406101d.l()) - this.f406102e.getMeasuredHeight()) + this.f406104g;
            OverlaySource r113 = PopupWindowLancet.resolveSource(r110);
            if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r109, r110, r113) == true) goto L20;
            r109.showAsDropDown(r110, r111, r112);
            PopupWindowLancet.trackAfterShow(r109, r113, r110);
            return;
        L20:
            return;
        L13:
            Balloon r114 = this.f406098a;
            BalloonLayoutBodyBinding r115 = r114.f406020c;
            r114.q(r115.f406143f, r115.f406141d);
            goto L14
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Balloon f406105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f406106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View[] f406107c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Balloon f406108d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f406109e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f406110f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f406111g;

        public i(Balloon r100, View r101, View[] r102, Balloon r103, View r104, int r105, int r106) {
            this.f406105a = r100;
            this.f406106b = r101;
            this.f406107c = r102;
            this.f406108d = r103;
            this.f406109e = r104;
            this.f406110f = r105;
            this.f406111g = r106;
        }

        public final void a() {
            Boolean r100 = Boolean.valueOf(this.f406105a.g(this.f406106b));
            if (r100.booleanValue() == true) goto L6;
            r100 = null;
        L6:
            if (r100 == null) goto L19;
            r100.booleanValue();
            this.f406105a.f406019b.getClass();
            Balloon r101 = this.f406105a;
            r101.f406024g = true;
            long r102 = r101.f406019b.V;
            if (r102 == (-1)) goto L11;
            r101.i(r102);
        L11:
            if (this.f406105a.n() == false) goto L13;
            Balloon r103 = this.f406105a;
            r103.z(r103.f406020c.f406141d);
        L14:
            this.f406105a.f406020c.f406138a.measure(0, 0);
            this.f406105a.f406019b.getClass();
            Balloon r104 = this.f406105a;
            r104.f406022e.setWidth(r104.m());
            Balloon r105 = this.f406105a;
            r105.f406022e.setHeight(r105.l());
            this.f406105a.f406020c.f406143f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f406105a.o(this.f406106b);
            this.f406105a.p();
            Balloon.b(this.f406105a);
            Balloon r106 = this.f406105a;
            View[] r107 = this.f406107c;
            Balloon.d(r106, (View[]) Arrays.copyOf(r107, r107.length));
            Balloon.c(this.f406105a);
            Balloon.a(this.f406105a);
            Balloon.e(this.f406105a);
            PopupWindow r108 = this.f406108d.f406022e;
            View r109 = this.f406109e;
            int r110 = this.f406110f;
            int r111 = this.f406111g;
            OverlaySource r112 = PopupWindowLancet.resolveSource(r109);
            if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r108, r109, r112) == true) goto L20;
            r108.showAsDropDown(r109, r110, r111);
            PopupWindowLancet.trackAfterShow(r108, r112, r109);
            return;
        L20:
            return;
        L13:
            Balloon r113 = this.f406105a;
            BalloonLayoutBodyBinding r114 = r113.f406020c;
            r113.q(r114.f406143f, r114.f406141d);
            goto L14
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Balloon f406112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f406113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View[] f406114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BalloonCenterAlign f406115d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Balloon f406116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ View f406117f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f406118g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f406119h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f406120i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f406121j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f406122k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f406123l;

        public j(Balloon r100, View r101, View[] r102, BalloonCenterAlign r103, Balloon r104, View r105, int r106, int r107, int r108, int r110, int r111, int r112) {
            this.f406112a = r100;
            this.f406113b = r101;
            this.f406114c = r102;
            this.f406115d = r103;
            this.f406116e = r104;
            this.f406117f = r105;
            this.f406118g = r106;
            this.f406119h = r107;
            this.f406120i = r108;
            this.f406121j = r110;
            this.f406122k = r111;
            this.f406123l = r112;
        }

        public final void b() {
            Boolean r100 = Boolean.valueOf(this.f406112a.g(this.f406113b));
            if (r100.booleanValue() == true) goto L6;
            r100 = null;
        L6:
            if (r100 == null) goto L28;
            r100.booleanValue();
            this.f406112a.f406019b.getClass();
            Balloon r101 = this.f406112a;
            r101.f406024g = true;
            long r102 = r101.f406019b.V;
            if (r102 == (-1)) goto L11;
            r101.i(r102);
        L11:
            if (this.f406112a.n() == false) goto L13;
            Balloon r103 = this.f406112a;
            r103.z(r103.f406020c.f406141d);
        L14:
            this.f406112a.f406020c.f406138a.measure(0, 0);
            this.f406112a.f406019b.getClass();
            Balloon r104 = this.f406112a;
            r104.f406022e.setWidth(r104.m());
            Balloon r105 = this.f406112a;
            r105.f406022e.setHeight(r105.l());
            this.f406112a.f406020c.f406143f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f406112a.o(this.f406113b);
            this.f406112a.p();
            Balloon.b(this.f406112a);
            Balloon r106 = this.f406112a;
            View[] r107 = this.f406114c;
            Balloon.d(r106, (View[]) Arrays.copyOf(r107, r107.length));
            Balloon.c(this.f406112a);
            Balloon.a(this.f406112a);
            Balloon.e(this.f406112a);
            BalloonCenterAlign r108 = this.f406115d;
            int r109 = c.f406071f[r108.ordinal()];
            if (r109 != 1) goto L17;
            Balloon r110 = this.f406116e;
            a(r110.f406022e, this.f406117f, r110.f406019b.f406042f0 * ((this.f406118g - this.f406119h) + this.f406120i), (-(r110.l() + this.f406121j)) + this.f406122k);
            return;
        L17:
            if (r109 != 2) goto L19;
            Balloon r111 = this.f406116e;
            PopupWindow r112 = r111.f406022e;
            View r113 = this.f406117f;
            int r114 = r111.f406019b.f406042f0;
            int r115 = this.f406118g;
            a(r112, r113, r114 * ((r115 - this.f406119h) + this.f406120i), ((-this.f406123l) + r115) + this.f406122k);
            return;
        L19:
            if (r109 != 3) goto L21;
            Balloon r116 = this.f406116e;
            a(r116.f406022e, this.f406117f, r116.f406019b.f406042f0 * ((this.f406118g - r116.m()) + this.f406120i), ((-this.f406116e.l()) + this.f406121j) + this.f406122k);
            return;
        L21:
            if (r109 != 4) goto L32;
            Balloon r117 = this.f406116e;
            a(r117.f406022e, this.f406117f, r117.f406019b.f406042f0 * ((this.f406118g + r117.m()) + this.f406120i), ((-this.f406116e.l()) + this.f406121j) + this.f406122k);
            return;
        L32:
            return;
        L13:
            Balloon r118 = this.f406112a;
            BalloonLayoutBodyBinding r119 = r118.f406020c;
            r118.q(r119.f406143f, r119.f406141d);
            goto L14
        }

        @Override // java.lang.Runnable
        public final void run() {
            b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public static void a(PopupWindow r100, View r101, int r102, int r103) {
            OverlaySource r104 = PopupWindowLancet.resolveSource(r101);
            if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r100, r101, r104) == false) goto L5;
            return;
        L5:
            r100.showAsDropDown(r101, r102, r103);
            PopupWindowLancet.trackAfterShow(r100, r104, r101);
        }
    }

    public final void h() {
        if (this.f406024g == false) goto L9;
        Function0<Unit> r100 = new Balloon$dismiss$dismissWindow$1(this);
        if (this.f406019b.Z != BalloonAnimation.CIRCULAR) goto L7;
        View r101 = this.f406022e.getContentView();
        r101.post(new d(r101, this.f406019b.f406034b0, r100));
        return;
    L7:
        r100.invoke();
        return;
    }

    public final int l() {
        int r100 = this.f406019b.f406039e;
        if (r100 == Integer.MIN_VALUE) goto L6;
        return r100;
    L6:
        return this.f406020c.f406138a.getMeasuredHeight();
    }

    public final int m() {
        Resources r100 = Resources.getSystem();
        int r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).widthPixels;
        Resources r102 = Resources.getSystem();
        int r103 = new Point(r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).heightPixels).x;
        a r104 = this.f406019b;
        float r105 = r104.f406037d;
        if (r105 != 0.0f) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == false) goto L13;
        r104.getClass();
        int r107 = this.f406019b.f406033b;
        if (r107 != Integer.MIN_VALUE) goto L14;
        int r108 = this.f406020c.f406138a.getMeasuredWidth();
        this.f406019b.getClass();
        return RangesKt.coerceIn(r108, 0, this.f406019b.f406035c);
    L14:
        return RangesKt.coerceAtMost(r107, r103);
    L13:
        return (int) (r103 * r105);
    L5:
        r106 = false;
        goto L6
    }

    public final boolean n() {
        this.f406019b.getClass();
        if (this.f406019b.I == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void p() {
        a r100 = this.f406019b;
        int r101 = r100.f406054o - 1;
        int r102 = (int) r100.H;
        FrameLayout r103 = this.f406020c.f406142e;
        ArrowOrientation r104 = r100.f406058s;
        int r105 = c.f406066a[r104.ordinal()];
        if (r105 != 1) goto L5;
        r103.setPadding(r102, r101, r102, RangesKt.coerceAtLeast(r101, r102));
        return;
    L5:
        if (r105 != 2) goto L7;
        r103.setPadding(r102, r101, r102, RangesKt.coerceAtLeast(r101, r102));
        return;
    L7:
        if (r105 != 3) goto L9;
        r103.setPadding(r101, r102, r101, r102);
        return;
    L9:
        if (r105 != 4) goto L19;
        r103.setPadding(r101, r102, r101, r102);
        return;
    }

    public static final void a(Balloon r100) {
        a r101 = r100.f406019b;
        int r102 = r101.X;
        if (r102 != Integer.MIN_VALUE) goto L19;
        BalloonAnimation r103 = r101.Z;
        int r104 = c.f406068c[r103.ordinal()];
        if (r104 != 1) goto L7;
        r100.f406022e.setAnimationStyle(R.style.Balloon_Elastic_Anim);
        return;
    L7:
        if (r104 != 2) goto L9;
        final View r105 = r100.f406022e.getContentView();
        final long r106 = r100.f406019b.f406034b0;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        r105.setVisibility(4);
        r105.post(new jqa.c(r105, r106));
        r100.f406022e.setAnimationStyle(R.style.Balloon_Normal_Dispose_Anim);
        return;
    L9:
        if (r104 == 3) goto L16;
        if (r104 != 4) goto L12;
        r100.f406022e.setAnimationStyle(R.style.Balloon_Overshoot_Anim);
        return;
    L12:
        if (r104 != 5) goto L26;
        r100.f406022e.setAnimationStyle(R.style.Balloon_Normal_Anim);
        return;
    L26:
        return;
    L16:
        r100.f406022e.setAnimationStyle(R.style.Balloon_Fade_Anim);
        return;
    L19:
        r100.f406022e.setAnimationStyle(r102);
    }

    public static final void b(Balloon r100) {
        a r101 = r100.f406019b;
        if (r101.Y != Integer.MIN_VALUE) goto L8;
        BalloonOverlayAnimation r102 = r101.f406032a0;
        if (c.f406069d[r102.ordinal()] != 1) goto L7;
        r100.f406023f.setAnimationStyle(R.style.Balloon_Fade_Anim);
        return;
    L7:
        r100.f406023f.setAnimationStyle(R.style.Balloon_Normal_Anim);
        return;
    L8:
        r100.f406023f.setAnimationStyle(r101.X);
    }

    public static final void c(Balloon r100) {
        r100.f406019b.getClass();
    }

    public static final void e(final Balloon r100) {
        r100.f406020c.f406139b.post(new com.skydoves.balloon.c(r100));
    }

    public static void f(ViewGroup r100) {
        r100.setFitsSystemWindows(false);
        IntRange r101 = RangesKt.until(0, r100.getChildCount());
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<Integer> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(r100.getChildAt(((IntIterator) r103).nextInt()));
        goto L4
    L6:
        Iterator r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        View r105 = (View) r104.next();
        r105.setFitsSystemWindows(false);
        if ((r105 instanceof ViewGroup) == false) goto L8;
        f((ViewGroup) r105);
        goto L8
    }

    public final boolean g(View r100) {
        if (this.f406024g == false) goto L5;
        return false;
    L5:
        if (this.f406025h == true) goto L20;
        Context r101 = this.f406018a;
        if ((r101 instanceof Activity) == true) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L14;
        return false;
    L14:
        if (this.f406022e.getContentView().getParent() == null) goto L16;
        return false;
    L16:
        if (ViewCompat.isAttachedToWindow(r100) == false) goto L23;
        return true;
    L23:
        return false;
    L9:
        if (((Activity) r101).isFinishing() == false) goto L11;
        r102 = true;
        goto L12
    L20:
        return false;
    }

    public final void i(long r100) {
        ((Handler) this.f406027j.getValue()).postDelayed((com.skydoves.balloon.a) this.f406028k.getValue(), r100);
    }

    public final float j(View r100) {
        int r101 = jqa.d.a(this.f406020c.f406142e).x;
        int r102 = jqa.d.a(r100).x;
        a r103 = this.f406019b;
        float r104 = (r103.f406054o * r103.f406060u) + 0;
        float r105 = m() - r104;
        a r106 = this.f406019b;
        float r107 = (r105 - r106.f406049j) - r106.f406050k;
        int r108 = c.f406067b[r106.f406056q.ordinal()];
        if (r108 != 1) goto L5;
        float r109 = this.f406020c.f406144g.getWidth();
        a r110 = this.f406019b;
        return (r109 * r110.f406055p) - (r110.f406054o * 0.5f);
    L5:
        if (r108 != 2) goto L20;
        if ((r100.getWidth() + r102) >= r101) goto L10;
        return r104;
    L10:
        if ((m() + r101) < r102) goto L23;
        float r111 = r100.getWidth();
        a r112 = this.f406019b;
        float r113 = ((r111 * r112.f406055p) + r102) - r101;
        int r114 = r112.f406054o;
        float r115 = r113 - (r114 * 0.5f);
        if (r115 > (r114 * 2)) goto L16;
        return r104;
    L16:
        if (r115 > (m() - (this.f406019b.f406054o * 2))) goto L23;
        return r115;
    L23:
        return r107;
    L20:
        throw new NoWhenBranchMatchedException();
    }

    public final float k(View r100) {
        boolean r101 = this.f406019b.f406046h0;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Rect r102 = new Rect();
        Context r103 = r100.getContext();
        if ((r103 instanceof Activity) == false) goto L11;
        if (r101 == false) goto L11;
        View r104 = ((Activity) r103).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L10;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r105 = ThreadMethodProxy.currentThread();
        if (r105 == com.larus.home.impl.utils.c.f346341a) goto L10;
        com.larus.home.impl.utils.c.a(r105, "getDecorView");
    L10:
        r104.getWindowVisibleDisplayFrame(r102);
        int r106 = r102.top;
    L12:
        int r107 = jqa.d.a(this.f406020c.f406142e).y - r106;
        int r108 = jqa.d.a(r100).y - r106;
        a r109 = this.f406019b;
        float r110 = r109.f406054o * r109.f406060u;
        float r111 = 0;
        float r112 = r110 + r111;
        float r113 = l() - r112;
        this.f406019b.getClass();
        float r114 = r113 - r111;
        a r115 = this.f406019b;
        float r116 = r114 - r115.f406051l;
        int r117 = r115.f406054o / 2;
        int r118 = c.f406067b[r115.f406056q.ordinal()];
        if (r118 == 1) goto L31;
        if (r118 != 2) goto L29;
        if ((r100.getHeight() + r108) >= r107) goto L19;
        return r112;
    L19:
        if ((l() + r107) < r108) goto L32;
        float r119 = r100.getHeight();
        a r120 = this.f406019b;
        float r121 = (((r119 * r120.f406055p) + r108) - r107) - r117;
        if (r121 > (r120.f406054o * 2)) goto L25;
        return r112;
    L25:
        if (r121 > (l() - (this.f406019b.f406054o * 2))) goto L32;
        return r121;
    L32:
        return r116;
    L29:
        throw new NoWhenBranchMatchedException();
    L31:
        return (this.f406020c.f406144g.getHeight() * this.f406019b.f406055p) - r117;
    L11:
        r106 = 0;
        goto L12
    }

    public final void o(final View r100) {
        final ImageView r101 = this.f406020c.f406140c;
        int r102 = this.f406019b.f406054o;
        r101.setLayoutParams(new FrameLayout.LayoutParams(r102, r102));
        r101.setAlpha(this.f406019b.G);
        Drawable r103 = this.f406019b.f406059t;
        if (r103 == null) goto L5;
        r101.setImageDrawable(r103);
    L5:
        this.f406019b.getClass();
        this.f406019b.getClass();
        this.f406019b.getClass();
        this.f406019b.getClass();
        r101.setPadding(0, 0, 0, 0);
        a r104 = this.f406019b;
        int r105 = r104.f406053n;
        if (r105 == Integer.MIN_VALUE) goto L8;
        ImageViewCompat.setImageTintList(r101, ColorStateList.valueOf(r105));
    L9:
        r101.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        this.f406020c.f406141d.post(new com.skydoves.balloon.b(this, r100, r101));
        return;
    L8:
        ImageViewCompat.setImageTintList(r101, ColorStateList.valueOf(r104.f406061v));
        goto L9
    }

    public final void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f406025h = true;
        PopupWindow r101 = this.f406023f;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
        PopupWindow r102 = this.f406022e;
        PopupWindowLancet.handleDismissBeforeOrigin(r102);
        r102.dismiss();
        LifecycleOwner r103 = this.f406019b.W;
        if (r103 == null) goto L8;
        Lifecycle r104 = r103.getLifecycle();
        if (r104 == null) goto L9;
        r104.removeObserver(this);
        return;
    L9:
        return;
    }

    public final void r(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        com.skydoves.balloon.i r101 = new com.skydoves.balloon.i(r100);
        this.f406022e.setOnDismissListener(new com.skydoves.balloon.g(this, r101));
    }

    public final void update(View r100) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        update(r100, 0, 0);
    }

    public final void z(ViewGroup r100) {
        int r101 = r100.getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        View r103 = r100.getChildAt(r102);
        if ((r103 instanceof TextView) == false) goto L8;
        q((TextView) r103, r100);
    L10:
        r102 = r102 + 1;
        goto L3
    L8:
        if ((r103 instanceof ViewGroup) == false) goto L10;
        z((ViewGroup) r103);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Balloon(Context r310, a r311) {
        this.f406018a = r310;
        this.f406019b = r311;
        View r100 = LayoutInflater.from(r310).inflate(R.layout.balloon_layout_body, null, false);
        FrameLayout r101 = (FrameLayout) r100;
        int r102 = R.id.balloon_arrow;
        ImageView r110 = (ImageView) r100.findViewById(R.id.balloon_arrow);
        if (r110 == null) goto L103;
        r102 = R.id.balloon_card;
        RadiusLayout r111 = (RadiusLayout) r100.findViewById(R.id.balloon_card);
        if (r111 == null) goto L103;
        r102 = R.id.balloon_content;
        FrameLayout r112 = (FrameLayout) r100.findViewById(R.id.balloon_content);
        if (r112 == null) goto L103;
        r102 = R.id.balloon_text;
        VectorTextView r113 = (VectorTextView) r100.findViewById(R.id.balloon_text);
        if (r113 == null) goto L103;
        r102 = R.id.balloon_wrapper;
        FrameLayout r114 = (FrameLayout) r100.findViewById(R.id.balloon_wrapper);
        if (r114 == null) goto L103;
        FrameLayout r103 = (FrameLayout) r100;
        this.f406020c = new BalloonLayoutBodyBinding(r103, r101, r110, r111, r112, r113, r114);
        View r104 = LayoutInflater.from(r310).inflate(R.layout.balloon_layout_overlay, null, false);
        if (r104 == null) goto L101;
        BalloonAnchorOverlayView r105 = (BalloonAnchorOverlayView) r104;
        this.f406021d = new BalloonLayoutOverlayBinding(r105, r105);
        PopupWindow r106 = new PopupWindow(r103, -2, -2);
        this.f406022e = r106;
        PopupWindow r107 = new PopupWindow(r105, -1, -1);
        this.f406023f = r107;
        this.f406026i = r311.O;
        LazyThreadSafetyMode r108 = LazyThreadSafetyMode.NONE;
        this.f406027j = LazyKt.lazy(r108, Balloon$handler$2.INSTANCE);
        this.f406028k = LazyKt.lazy(r108, new Balloon$autoDismissRunnable$2(this));
        this.f406029l = LazyKt.lazy(r108, new Balloon$balloonPersistence$2(this));
        r111.setAlpha(r311.G);
        r111.setRadius(r311.f406062w);
        ViewCompat.setElevation(r111, r311.H);
        GradientDrawable r109 = new GradientDrawable();
        r109.setColor(r311.f406061v);
        r109.setCornerRadius(r311.f406062w);
        r111.setBackground(r109);
        r111.setPadding(r311.f406041f, r311.f406043g, r311.f406045h, r311.f406047i);
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r115).setMargins(r311.f406050k, 0, r311.f406049j, r311.f406051l);
        r106.setOutsideTouchable(true);
        r106.setFocusable(r311.f406044g0);
        r106.setBackgroundDrawable(new ColorDrawable(0));
        r106.setElevation(r311.H);
        boolean r116 = r311.f406048i0;
        int r117 = Build.VERSION.SDK_INT;
        if (r117 < 22) goto L18;
        r106.setAttachedInDecor(r116);
    L18:
        if (n() == false) goto L30;
        View r118 = r311.I;
        if (r118 == null) goto L29;
        ViewParent r119 = r118.getParent();
        if ((r119 instanceof ViewGroup) == false) goto L24;
        ViewGroup r120 = (ViewGroup) r119;
    L25:
        if (r120 == null) goto L27;
        r120.removeView(r118);
    L27:
        r111.removeAllViews();
        r111.addView(r118);
        z(r111);
        r103 = r103;
        r106 = r106;
    L76:
        p();
        if (r311.f406030J == false) goto L80;
        r105.setOverlayColor(r311.K);
        r105.setOverlayPadding(0.0f);
        r105.setOverlayPosition(null);
        r105.setBalloonOverlayShape(r311.L);
        r105.setOverlayPaddingColor(0);
        r107.setClippingEnabled(false);
    L80:
        if (r311.T == false) goto L82;
        r114.setOnClickListener(new com.skydoves.balloon.d(this));
    L82:
        PopupWindow r121 = r106;
        r121.setOnDismissListener(new com.skydoves.balloon.g(this, r311.N));
        r121.setTouchInterceptor(new com.skydoves.balloon.h(this, r311.P));
        View.OnTouchListener r122 = r311.Q;
        if (r122 == null) goto L85;
        r121.setTouchInterceptor(r122);
    L85:
        r105.setOnClickListener(new com.skydoves.balloon.f(this));
        View.OnTouchListener r123 = r311.R;
        if (r123 == null) goto L88;
        r107.setTouchInterceptor(r123);
    L88:
        f(r103);
        LifecycleOwner r124 = r311.W;
        if (r124 == null) goto L91;
    L93:
        if (r124 == null) goto L105;
        Lifecycle r125 = r124.getLifecycle();
        if (r125 == null) goto L106;
        r125.addObserver(this);
        return;
    L106:
        return;
    L105:
        return;
    L91:
        if ((r310 instanceof LifecycleOwner) == false) goto L93;
        LifecycleOwner r126 = (LifecycleOwner) r310;
        r311.W = r126;
        r126.getLifecycle().addObserver(this);
        return;
    L24:
        r120 = null;
        goto L25
    L29:
        throw new IllegalArgumentException("The custom layout is null.");
    L30:
        m.a r127 = new m.a(r113.getContext());
        r127.f406168b = null;
        r127.f406170d = r311.C;
        r127.f406171e = r311.D;
        r127.f406173g = r311.F;
        r127.f406172f = r311.E;
        IconGravity r128 = r311.B;
        Intrinsics.checkNotNullParameter(r128, "value");
        r127.f406169c = r128;
        m r129 = new m(r127);
        Intrinsics.checkNotNullParameter(r113, "<this>");
        Intrinsics.checkNotNullParameter(r129, "iconForm");
        if (r129.f406160a == null) goto L55;
        int r130 = r129.f406162c;
        int r131 = r129.f406163d;
        int r132 = r129.f406164e;
        CharSequence r133 = r129.f406166g;
        Integer r134 = Integer.valueOf(r129.f406165f);
        if (r134.intValue() == Integer.MIN_VALUE) goto L35;
        boolean r135 = true;
    L37:
        if (Boolean.valueOf(r135).booleanValue() == false) goto L39;
        Integer r210 = r134;
    L40:
        lqa.a r136 = new lqa.a(null, null, null, null, r133, Integer.valueOf(r132), Integer.valueOf(r130), Integer.valueOf(r131), null, r210, null, null, null, 238079);
        int r137 = jqa.b.a.f500102a[r129.f406161b.ordinal()];
        if (r137 != 1) goto L43;
        r136.f510367e = r129.f406160a;
        r136.f510363a = null;
    L53:
        r113.setDrawableTextViewParams(r136);
        goto L55
    L43:
        if (r137 != 2) goto L45;
        r136.f510370h = r129.f406160a;
        r136.f510366d = null;
        goto L53
    L45:
        if (r137 != 3) goto L47;
        r136.f510369g = r129.f406160a;
        r136.f510365c = null;
        goto L53
    L47:
        if (r137 != 4) goto L53;
        r136.f510368f = r129.f406160a;
        r136.f510364b = null;
        goto L53
    L39:
        r210 = null;
        goto L40
    L35:
        r135 = false;
    L55:
        boolean r138 = r311.f406040e0;
        lqa.a r139 = r113.f406208a;
        if (r139 == null) goto L58;
        r139.f510371i = r138;
        jqa.b.a(r113, r139);
    L58:
        q.a r140 = new q.a(r113.getContext());
        CharSequence r141 = r311.f406063x;
        Intrinsics.checkNotNullParameter(r141, "value");
        r140.f406197b = r141;
        r140.f406198c = r311.f406065z;
        r140.f406199d = r311.f406064y;
        r140.f406200e = false;
        r140.f406204i = r311.A;
        r140.f406201f = 0;
        r140.f406202g = null;
        r140.f406203h = null;
        r113.setMovementMethod(null);
        q r142 = new q(r140);
        Intrinsics.checkNotNullParameter(r113, "<this>");
        Intrinsics.checkNotNullParameter(r142, "textForm");
        boolean r143 = r142.f406191d;
        if (r143 != true) goto L64;
        String r144 = r142.f406188a.toString();
        if (r117 < 24) goto L63;
        CharSequence r145 = Html.fromHtml(r144, 0);
    L66:
        r113.setText(r145);
        r113.setTextSize(r142.f406189b);
        r113.setGravity(r142.f406195h);
        r113.setTextColor(r142.f406190c);
        Float r146 = r142.f406194g;
        if (r146 == null) goto L69;
        r113.setLineSpacing(r146.floatValue(), 1.0f);
    L69:
        Typeface r147 = r142.f406193f;
        if (r147 == null) goto L72;
        r113.setTypeface(r147);
        Unit r148 = Unit.INSTANCE;
    L73:
        if (r148 != null) goto L75;
        r113.setTypeface(r113.getTypeface(), r142.f406192e);
    L75:
        q(r113, r111);
        goto L76
    L72:
        r148 = null;
        goto L73
    L63:
        r145 = HtmlCompat.fromHtml(r144, 0);
        goto L66
    L64:
        if (r143 == true) goto L99;
        r145 = r142.f406188a;
        goto L66
    L99:
        throw new NoWhenBranchMatchedException();
    L101:
        throw new NullPointerException("rootView");
    L103:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r102)));
    }

    public static final void d(Balloon r100, View... r110) {
        if (r100.f406019b.f406030J == false) goto L21;
        View r101 = r110[0];
        if (r110.length != 1) goto L7;
        r100.f406021d.f406146b.setAnchorView(r101);
    L8:
        PopupWindow r111 = r100.f406023f;
        int r102 = r100.f406019b.M;
        if (PopupWindowLancet.hasSubWindowToken(r101) == false) goto L12;
        return;
    L12:
        if ((r111 instanceof PopupWindow) == true) goto L14;
    L16:
        OverlaySource r103 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r111, r101, r103, r102, 0, 0) == true) goto L24;
        r111.showAtLocation(r101, r102, 0, 0);
        PopupWindowLancet.trackAfterShow(r111, r103, r101);
        return;
    L24:
        return;
    L14:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r111) == false) goto L16;
        r111.showAtLocation(r101, r102, 0, 0);
        return;
    L7:
        r100.f406021d.f406146b.setAnchorViewList(ArraysKt.toList(r110));
        goto L8
    }

    private final void update(View r100, Function0<Unit> r101) {
        if (this.f406024g == false) goto L6;
        o(r100);
        r101.invoke();
        return;
    }

    public final void q(TextView r100, View r110) {
        int r101 = (int) r100.getPaint().measureText(r100.getText().toString());
        Drawable[] r102 = r100.getCompoundDrawablesRelative();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        boolean r103 = false;
        if (r102[0] == null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L27;
        Drawable[] r105 = r100.getCompoundDrawablesRelative();
        Intrinsics.checkNotNullParameter(r105, "<this>");
        Drawable r106 = r105[0];
        if (r106 == null) goto L13;
        int r107 = r106.getIntrinsicHeight();
    L14:
        Drawable r108 = r105[2];
        if (r108 == null) goto L17;
        int r109 = r108.getIntrinsicHeight();
    L18:
        r100.setMinHeight(RangesKt.coerceAtLeast(r107, r109));
        Drawable[] r111 = r100.getCompoundDrawablesRelative();
        Intrinsics.checkNotNullParameter(r111, "<this>");
        Drawable r112 = r111[0];
        if (r112 == null) goto L21;
        int r113 = r112.getIntrinsicWidth();
    L22:
        Drawable r114 = r111[2];
        if (r114 == null) goto L25;
        int r115 = r114.getIntrinsicWidth();
    L26:
        int r116 = r113 + r115;
        int r117 = r100.getCompoundPaddingStart();
        int r118 = r100.getCompoundPaddingEnd();
    L52:
        r101 = r101 + (r116 + (r117 + r118));
    L53:
        Resources r119 = Resources.getSystem();
        int r120 = WindowDisplayMetricsOverride.apply(r119, r119.getDisplayMetrics()).widthPixels;
        Resources r121 = Resources.getSystem();
        int r122 = new Point(r120, WindowDisplayMetricsOverride.apply(r121, r121.getDisplayMetrics()).heightPixels).x;
        int r123 = r110.getPaddingLeft() + r110.getPaddingRight();
        this.f406019b.getClass();
        a r124 = this.f406019b;
        int r125 = r123 + (((r124.f406049j + 0) + r124.f406050k) + (r124.f406054o * 2));
        int r126 = r124.f406035c - r125;
        float r127 = r124.f406037d;
        if (r127 != 0.0f) goto L56;
        r103 = true;
    L56:
        if (r103 == true) goto L58;
        int r128 = (int) (r122 * r127);
    L61:
        int r129 = r128 - r125;
    L63:
        r100.setMaxWidth(r129);
        return;
    L58:
        r128 = r124.f406033b;
        if (r128 == Integer.MIN_VALUE) goto L62;
        if (r128 <= r122) goto L61;
    L62:
        r129 = RangesKt.coerceAtMost(r101, r126);
        goto L63
    L25:
        r115 = 0;
        goto L26
    L21:
        r113 = 0;
        goto L22
    L17:
        r109 = 0;
        goto L18
    L13:
        r107 = 0;
        goto L14
    L27:
        Drawable[] r130 = r100.getCompoundDrawables();
        Intrinsics.checkNotNullParameter(r130, "<this>");
        if (r130[0] == null) goto L30;
    L33:
        boolean r131 = true;
    L34:
        if (r131 == false) goto L53;
        Drawable[] r132 = r100.getCompoundDrawables();
        Intrinsics.checkNotNullParameter(r132, "<this>");
        Drawable r133 = r132[0];
        if (r133 == null) goto L38;
        int r134 = r133.getIntrinsicHeight();
    L39:
        Drawable r135 = r132[2];
        if (r135 == null) goto L42;
        int r136 = r135.getIntrinsicHeight();
    L43:
        r100.setMinHeight(RangesKt.coerceAtLeast(r134, r136));
        Drawable[] r137 = r100.getCompoundDrawables();
        Intrinsics.checkNotNullParameter(r137, "<this>");
        Drawable r138 = r137[0];
        if (r138 == null) goto L46;
        int r139 = r138.getIntrinsicWidth();
    L47:
        Drawable r140 = r137[2];
        if (r140 == null) goto L50;
        int r141 = r140.getIntrinsicWidth();
    L51:
        r116 = r139 + r141;
        r117 = r100.getCompoundPaddingStart();
        r118 = r100.getCompoundPaddingEnd();
        goto L52
    L50:
        r141 = 0;
        goto L51
    L46:
        r139 = 0;
        goto L47
    L42:
        r136 = 0;
        goto L43
    L38:
        r134 = 0;
        goto L39
    L30:
        if (r130[2] != null) goto L33;
        r131 = false;
        goto L34
    L5:
        if (r102[2] != null) goto L8;
        r104 = false;
        goto L9
    }

    public final void update(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        update(r100, r101, 0);
    }

    public final void s(View r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "anchor");
        View[] r100 = {r110};
        if (g(r110) == false) goto L5;
        r110.post(new e(this, r110, r100, this, r110, r111, r112));
        return;
    L5:
        this.f406019b.getClass();
    }

    public final void t(View r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "anchor");
        View[] r100 = {r110};
        if (g(r110) == false) goto L5;
        r110.post(new f(this, r110, r100, this, r110, r111, r112));
        return;
    L5:
        this.f406019b.getClass();
    }

    public final void u(View r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "anchor");
        View[] r100 = {r110};
        if (g(r110) == false) goto L5;
        r110.post(new g(this, r110, r100, this, r110, r111, r112));
        return;
    L5:
        this.f406019b.getClass();
    }

    public final void update(View r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "anchor");
        if (this.f406024g == false) goto L17;
        o(r110);
        PopupWindow r100 = this.f406022e;
        int r101 = m();
        int r102 = l();
        if ((r100 instanceof PopupWindow) == false) goto L10;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r100) == false) goto L10;
        r100.update(r110, r111, r112, r101, r102);
    L14:
        if (this.f406019b.f406030J == false) goto L18;
        BalloonAnchorOverlayView r113 = this.f406021d.f406146b;
        r113.f406186k = true;
        r113.invalidate();
        return;
    L18:
        return;
    L10:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r100, r110, r111, r112, r101, r102) == true) goto L14;
        r100.update(r110, r111, r112, r101, r102);
        goto L14
    }

    public final void v(View r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "anchor");
        View[] r100 = {r110};
        if (g(r110) == false) goto L5;
        r110.post(new h(this, r110, r100, this, r110, r111, r112));
        return;
    L5:
        this.f406019b.getClass();
    }

    public final void x(View r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "anchor");
        View[] r100 = {r110};
        if (g(r110) == false) goto L5;
        r110.post(new i(this, r110, r100, this, r110, r111, r112));
        return;
    L5:
        this.f406019b.getClass();
    }

    public static /* synthetic */ void w(Balloon r100, View r101, int r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = 0;
    L5:
        r100.v(r101, 0, r102);
    }

    public final void y(View r110, int r111, int r112, BalloonCenterAlign r210) {
        BalloonCenterAlign r100 = r210;
        Intrinsics.checkNotNullParameter(r110, "anchor");
        Intrinsics.checkNotNullParameter(r100, "centerAlign");
        int r101 = MathKt.roundToInt(r110.getMeasuredWidth() * 0.5f);
        int r113 = MathKt.roundToInt(r110.getMeasuredHeight() * 0.5f);
        int r102 = MathKt.roundToInt(m() * 0.5f);
        int r114 = MathKt.roundToInt(l() * 0.5f);
        BalloonCenterAlign.a r103 = BalloonCenterAlign.Companion;
        boolean r104 = this.f406019b.f406040e0;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r104 == false) goto L9;
        int r105 = BalloonCenterAlign.a.C4700a.f406128a[r210.ordinal()];
        if (r105 != 1) goto L8;
        r100 = BalloonCenterAlign.END;
        goto L9
    L8:
        if (r105 != 2) goto L9;
        r100 = BalloonCenterAlign.START;
    L9:
        BalloonCenterAlign r106 = r100;
        View[] r107 = {r110};
        if (g(r110) == false) goto L15;
        r110.post(new j(this, r110, r107, r106, this, r110, r101, r102, r111, r113, r112, r114));
        return;
    L15:
        this.f406019b.getClass();
    }
}
