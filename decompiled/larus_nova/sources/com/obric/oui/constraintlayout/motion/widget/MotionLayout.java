package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.camera.video.AudioStats;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.widget.NestedScrollView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.helper.widget.MotionEffect;
import com.obric.oui.constraintlayout.widget.Barrier;
import com.obric.oui.constraintlayout.widget.ConstraintHelper;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.Constraints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes34.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static boolean F2;
    public final HashMap<View, n> A;
    public long B;
    public float C;
    public float D;
    public float E;
    public final ArrayList<Integer> E2;
    public long F;
    public float G;
    public int G1;
    public boolean H;
    public ArrayList<MotionHelper> H0;
    public int H1;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public i f399940J;
    public int K;
    public e L;
    public ArrayList<MotionHelper> L0;
    public int L1;
    public boolean M;
    public float M1;
    public final vla.b N;
    public final d O;
    public com.obric.oui.constraintlayout.motion.widget.b P;
    public CopyOnWriteArrayList<i> P0;
    public final tla.d P1;
    public int Q;
    public boolean Q1;
    public int R;
    public boolean S;
    public h S1;
    public float T;
    public Runnable T1;
    public float U;
    public long V;
    public int V0;
    public final Rect V1;
    public float W;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public long f399941b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public boolean f399942b2;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public float f399943g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public TransitionState f399944g2;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f399945h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public final f f399946h2;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f399947k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public float f399948k1;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public ArrayList<MotionHelper> f399949p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public boolean f399950p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public boolean f399951p2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public q f399952q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public o f399953r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Interpolator f399954s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f399955t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f399956u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f399957v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f399958v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public final RectF f399959v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f399960w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f399961x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public int f399962x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public View f399963x2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f399964y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public int f399965y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public Matrix f399966y2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f399967z;

    public static final enum TransitionState extends Enum<TransitionState> {
        public static final TransitionState FINISHED = null;
        public static final TransitionState MOVING = null;
        public static final TransitionState SETUP = null;
        public static final TransitionState UNDEFINED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TransitionState[] f399968a = null;

        static {
            TransitionState r100 = new TransitionState("UNDEFINED", 0);
            UNDEFINED = r100;
            TransitionState r101 = new TransitionState("SETUP", 1);
            SETUP = r101;
            TransitionState r102 = new TransitionState("MOVING", 2);
            MOVING = r102;
            TransitionState r103 = new TransitionState("FINISHED", 3);
            FINISHED = r103;
            f399968a = new TransitionState[]{r100, r101, r102, r103};
        }

        public static TransitionState[] values() {
            return (TransitionState[]) f399968a.clone();
        }

        public static TransitionState valueOf(String r100) {
            return (TransitionState) r27.a.a(TransitionState.class, r100);
        }

        public TransitionState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f399969a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f399969a.setNestedScrollingEnabled(true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(View r100) {
            this.f399969a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f399970a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f399970a.S1.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(MotionLayout r100) {
            this.f399970a = r100;
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f399971a = null;

        static {
            int[] r100 = new int[TransitionState.values().length];
            f399971a = r100;
            r100[TransitionState.UNDEFINED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f399971a[TransitionState.SETUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f399971a[TransitionState.MOVING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f399971a[TransitionState.FINISHED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class d extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f399972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f399973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f399974c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f399975d;

        @Override // com.obric.oui.constraintlayout.motion.widget.o
        public final float a() {
            return this.f399975d.f399955t;
        }

        public d(MotionLayout r100) {
            this.f399975d = r100;
            this.f399972a = 0.0f;
            this.f399973b = 0.0f;
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = this.f399972a;
            if (r101 <= 0.0f) goto L10;
            float r102 = this.f399974c;
            if ((r101 / r102) >= r100) goto L7;
            r100 = r101 / r102;
        L7:
            float r103 = r101 - (r102 * r100);
            this.f399975d.f399955t = r103;
            float r104 = (r101 * r100) - (((r102 * r100) * r100) / 2.0f);
            float r105 = this.f399973b;
        L9:
            return r104 + r105;
        L10:
            float r106 = this.f399974c;
            if (((-r101) / r106) >= r100) goto L13;
            r100 = (-r101) / r106;
        L13:
            float r107 = (r106 * r100) + r101;
            this.f399975d.f399955t = r107;
            r104 = (r101 * r100) + (((r106 * r100) * r100) / 2.0f);
            r105 = this.f399973b;
            goto L9
        }
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float[] f399976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f399977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f399978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Path f399979d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Paint f399980e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Paint f399981f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Paint f399982g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Paint f399983h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Paint f399984i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float[] f399985j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f399986k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Rect f399987l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f399988m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f399989n;

        public e(MotionLayout r100) {
            this.f399989n = r100;
            this.f399987l = new Rect();
            this.f399988m = 1;
            Paint r101 = new Paint();
            this.f399980e = r101;
            r101.setAntiAlias(true);
            r101.setColor(-21965);
            r101.setStrokeWidth(2.0f);
            r101.setStyle(Paint.Style.STROKE);
            Paint r102 = new Paint();
            this.f399981f = r102;
            r102.setAntiAlias(true);
            r102.setColor(-2067046);
            r102.setStrokeWidth(2.0f);
            r102.setStyle(Paint.Style.STROKE);
            Paint r103 = new Paint();
            this.f399982g = r103;
            r103.setAntiAlias(true);
            r103.setColor(-13391360);
            r103.setStrokeWidth(2.0f);
            r103.setStyle(Paint.Style.STROKE);
            Paint r104 = new Paint();
            this.f399983h = r104;
            r104.setAntiAlias(true);
            r104.setColor(-13391360);
            Resources r105 = r100.getContext().getResources();
            r104.setTextSize(WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density * 12.0f);
            this.f399985j = new float[8];
            Paint r106 = new Paint();
            this.f399984i = r106;
            r106.setAntiAlias(true);
            r103.setPathEffect(new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f));
            this.f399978c = new float[100];
            this.f399977b = new int[50];
        }

        public final void b(Canvas r110) {
            float[] r100 = this.f399976a;
            float r101 = r100[0];
            float r102 = r100[1];
            float r103 = r100[r100.length - 2];
            float r104 = r100[r100.length - 1];
            r110.drawLine(Math.min(r101, r103), Math.max(r102, r104), Math.max(r101, r103), Math.max(r102, r104), this.f399982g);
            r110.drawLine(Math.min(r101, r103), Math.min(r102, r104), Math.min(r101, r103), Math.max(r102, r104), this.f399982g);
        }

        public final void f(String r100, Paint r101) {
            r101.getTextBounds(r100, 0, r100.length(), this.f399987l);
        }

        public final void c(Canvas r110, float r210, float r211) {
            float[] r100 = this.f399976a;
            float r101 = r100[0];
            float r102 = r100[1];
            float r103 = r100[r100.length - 2];
            float r104 = r100[r100.length - 1];
            float r105 = Math.min(r101, r103);
            float r111 = Math.max(r102, r104);
            float r106 = r210 - Math.min(r101, r103);
            float r112 = Math.max(r102, r104) - r211;
            String r107 = "" + (((int) (((double) ((r106 * 100.0f) / Math.abs(r103 - r101))) + 0.5d)) / 100.0f);
            f(r107, this.f399983h);
            r110.drawText(r107, ((r106 / 2.0f) - (this.f399987l.width() / 2)) + r105, r211 - 20.0f, this.f399983h);
            r110.drawLine(r210, r211, Math.min(r101, r103), r211, this.f399982g);
            String r108 = "" + (((int) (((double) ((r112 * 100.0f) / Math.abs(r104 - r102))) + 0.5d)) / 100.0f);
            f(r108, this.f399983h);
            r110.drawText(r108, r210 + 5.0f, r111 - ((r112 / 2.0f) - (this.f399987l.height() / 2)), this.f399983h);
            r110.drawLine(r210, r211, r210, Math.max(r102, r104), this.f399982g);
        }

        public final void d(Canvas r110, float r111, float r112) {
            float[] r100 = this.f399976a;
            float r101 = r100[0];
            float r102 = r100[1];
            float r103 = r100[r100.length - 2];
            float r104 = r100[r100.length - 1];
            float r105 = (float) Math.hypot(r101 - r103, r102 - r104);
            float r106 = r103 - r101;
            float r107 = r104 - r102;
            float r108 = (((r111 - r101) * r106) + ((r112 - r102) * r107)) / (r105 * r105);
            float r109 = r101 + (r106 * r108);
            float r113 = r102 + (r108 * r107);
            Path r114 = new Path();
            r114.moveTo(r111, r112);
            r114.lineTo(r109, r113);
            float r115 = (float) Math.hypot(r109 - r111, r113 - r112);
            String r116 = "" + (((int) ((r115 * 100.0f) / r105)) / 100.0f);
            f(r116, this.f399983h);
            r110.drawTextOnPath(r116, r114, (r115 / 2.0f) - (this.f399987l.width() / 2), -20.0f, this.f399983h);
            r110.drawLine(r111, r112, r109, r113, this.f399982g);
        }

        public final void a(Canvas r210, int r211, int r212, n r213) {
            if (r211 != 4) goto L18;
            int r100 = 0;
            boolean r101 = false;
            boolean r110 = false;
        L6:
            if (r100 >= this.f399986k) goto L13;
            int r102 = this.f399977b[r100];
            if (r102 != 1) goto L10;
            r101 = true;
        L10:
            if (r102 != 0) goto L12;
            r110 = true;
        L12:
            r100 = r100 + 1;
            goto L6
        L13:
            if (r101 == false) goto L15;
            float[] r103 = this.f399976a;
            r210.drawLine(r103[0], r103[1], r103[r103.length - 2], r103[r103.length - 1], this.f399982g);
        L15:
            if (r110 == false) goto L18;
            b(r210);
        L18:
            if (r211 != 2) goto L21;
            float[] r104 = this.f399976a;
            r210.drawLine(r104[0], r104[1], r104[r104.length - 2], r104[r104.length - 1], this.f399982g);
        L21:
            if (r211 != 3) goto L23;
            b(r210);
        L23:
            r210.drawLines(this.f399976a, this.f399980e);
            View r105 = r213.f400115b;
            if (r105 == null) goto L26;
            int r111 = r105.getWidth();
            int r112 = r213.f400115b.getHeight();
        L27:
            int r106 = 1;
        L29:
            if (r106 >= (r212 - 1)) goto L55;
            if (r211 == 4) goto L32;
        L34:
            float[] r107 = this.f399978c;
            int r108 = r106 * 2;
            float r109 = r107[r108];
            float r113 = r107[r108 + 1];
            this.f399979d.reset();
            this.f399979d.moveTo(r109, r113 + 10.0f);
            this.f399979d.lineTo(r109 + 10.0f, r113);
            this.f399979d.lineTo(r109, r113 - 10.0f);
            this.f399979d.lineTo(r109 - 10.0f, r113);
            this.f399979d.close();
            int r114 = r106 - 1;
            p r115 = (p) ListProtector.get(r213.f400134u, r114);
            if (r211 != 4) goto L45;
            int r116 = this.f399977b[r114];
            if (r116 != 1) goto L40;
            d(r210, r109 - 0.0f, r113 - 0.0f);
        L44:
            r210.drawPath(this.f399979d, this.f399984i);
        L46:
            if (r211 != 2) goto L48;
            d(r210, r109 - 0.0f, r113 - 0.0f);
        L48:
            if (r211 != 3) goto L51;
            c(r210, r109 - 0.0f, r113 - 0.0f);
        L51:
            if (r211 != 6) goto L53;
            e(r210, r109 - 0.0f, r113 - 0.0f, r111, r112);
        L53:
            r210.drawPath(this.f399979d, this.f399984i);
        L54:
            r106 = r106 + 1;
            goto L29
        L40:
            if (r116 != 0) goto L42;
            c(r210, r109 - 0.0f, r113 - 0.0f);
            goto L44
        L42:
            if (r116 != 2) goto L44;
            e(r210, r109 - 0.0f, r113 - 0.0f, r111, r112);
            goto L44
        L45:
            r113 = r113;
            r109 = r109;
            r106 = r106;
            goto L46
        L32:
            if (this.f399977b[r106 - 1] != 0) goto L34;
            r106 = r106;
            goto L54
        L55:
            float[] r117 = this.f399976a;
            if (r117.length <= 1) goto L65;
            r210.drawCircle(r117[0], r117[1], 8.0f, this.f399981f);
            float[] r118 = this.f399976a;
            r210.drawCircle(r118[r118.length - 2], r118[r118.length - 1], 8.0f, this.f399981f);
            return;
        L65:
            return;
        L26:
            r111 = 0;
            r112 = 0;
            goto L27
        }

        public final void e(Canvas r110, float r111, float r112, int r113, int r210) {
            String r100 = "" + (((int) (((double) (((r111 - (r113 / 2)) * 100.0f) / (this.f399989n.getWidth() - r113))) + 0.5d)) / 100.0f);
            f(r100, this.f399983h);
            r110.drawText(r100, ((r111 / 2.0f) - (this.f399987l.width() / 2)) + 0.0f, r112 - 20.0f, this.f399983h);
            r110.drawLine(r111, r112, Math.min(0.0f, 1.0f), r112, this.f399982g);
            String r101 = "" + (((int) (((double) (((r112 - (r210 / 2)) * 100.0f) / (this.f399989n.getHeight() - r210))) + 0.5d)) / 100.0f);
            f(r101, this.f399983h);
            r110.drawText(r101, r111 + 5.0f, 0.0f - ((r112 / 2.0f) - (this.f399987l.height() / 2)), this.f399983h);
            r110.drawLine(r111, r112, r111, Math.max(0.0f, 1.0f), this.f399982g);
        }
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.obric.oui.constraintlayout.core.widgets.d f399990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.obric.oui.constraintlayout.core.widgets.d f399991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.obric.oui.constraintlayout.widget.a f399992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.obric.oui.constraintlayout.widget.a f399993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f399994e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f399995f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f399996g;

        public final void a() {
            int r100 = this.f399996g.getChildCount();
            this.f399996g.A.clear();
            SparseArray r101 = new SparseArray();
            int[] r102 = new int[r100];
            int r103 = 0;
        L3:
            if (r103 >= r100) goto L5;
            View r104 = this.f399996g.getChildAt(r103);
            n r105 = new n(r104);
            int r106 = r104.getId();
            r102[r103] = r106;
            r101.put(r106, r105);
            this.f399996g.A.put(r104, r105);
            r103 = r103 + 1;
            goto L3
        L5:
            int r107 = 0;
        L7:
            if (r107 >= r100) goto L55;
            View r108 = this.f399996g.getChildAt(r107);
            n r109 = this.f399996g.A.get(r108);
            if (r109 == null) goto L54;
            if (this.f399992c == null) goto L42;
            ConstraintWidget r110 = d(this.f399990a, r108);
            if (r110 == null) goto L40;
            Rect r111 = MotionLayout.k(this.f399996g, r110);
            com.obric.oui.constraintlayout.widget.a r112 = this.f399992c;
            int r113 = this.f399996g.getWidth();
            int r114 = this.f399996g.getHeight();
            int r115 = r112.f400482d;
            if (r115 == 0) goto L18;
            n.g(r111, r109.f400114a, r115, r113, r114);
        L18:
            p r116 = r109.f400119f;
            r116.f400143c = 0.0f;
            r116.f400144d = 0.0f;
            r109.f(r116);
            r109.f400119f.d(r111.left, r111.top, r111.width(), r111.height());
            com.obric.oui.constraintlayout.widget.a.C4670a r117 = r112.h(r109.f400116c);
            r109.f400119f.a(r117);
            r109.f400125l = r117.f400489d.f400557g;
            r109.f400121h.d(r111, r112, r115, r109.f400116c);
            r109.C = r117.f400491f.f400578i;
            com.obric.oui.constraintlayout.widget.a.c r118 = r117.f400489d;
            r109.E = r118.f400560j;
            r109.F = r118.f400559i;
            Context r119 = r109.f400115b.getContext();
            com.obric.oui.constraintlayout.widget.a.c r120 = r117.f400489d;
            int r121 = r120.f400562l;
            String r122 = r120.f400561k;
            int r123 = r120.f400563m;
            if (r121 == (-2)) goto L37;
            if (r121 == (-1)) goto L36;
            if (r121 != 0) goto L23;
            Interpolator r124 = new AccelerateDecelerateInterpolator();
        L38:
            r109.G = r124;
        L44:
            if (this.f399993d == null) goto L54;
            ConstraintWidget r125 = d(this.f399991b, r108);
            if (r125 == null) goto L52;
            Rect r126 = MotionLayout.k(this.f399996g, r125);
            com.obric.oui.constraintlayout.widget.a r127 = this.f399993d;
            int r128 = this.f399996g.getWidth();
            int r129 = this.f399996g.getHeight();
            int r130 = r127.f400482d;
            if (r130 == 0) goto L50;
            n.g(r126, r109.f400114a, r130, r128, r129);
            r126 = r109.f400114a;
        L50:
            p r131 = r109.f400120g;
            r131.f400143c = 1.0f;
            r131.f400144d = 1.0f;
            r109.f(r131);
            r109.f400120g.d(r126.left, r126.top, r126.width(), r126.height());
            r109.f400120g.a(r127.h(r109.f400116c));
            r109.f400122i.d(r126, r127, r130, r109.f400116c);
            goto L54
        L52:
            if (this.f399996g.K == 0) goto L54;
            com.obric.oui.constraintlayout.motion.widget.a.b();
            com.obric.oui.constraintlayout.motion.widget.a.d(r108);
            r108.getClass();
            goto L54
        L23:
            if (r121 != 1) goto L25;
            r124 = new AccelerateInterpolator();
            goto L38
        L25:
            if (r121 != 2) goto L27;
            r124 = new DecelerateInterpolator();
            goto L38
        L27:
            if (r121 != 4) goto L29;
            r124 = new BounceInterpolator();
            goto L38
        L29:
            if (r121 == 5) goto L31;
            r124 = null;
            goto L38
        L31:
            r124 = new OvershootInterpolator();
            goto L38
        L36:
            r124 = new m(tla.c.c(r122));
            goto L38
        L37:
            r124 = AnimationUtils.loadInterpolator(r119, r123);
            goto L38
        L40:
            if (this.f399996g.K == 0) goto L44;
            com.obric.oui.constraintlayout.motion.widget.a.b();
            com.obric.oui.constraintlayout.motion.widget.a.d(r108);
            r108.getClass();
            goto L44
        L42:
            this.f399996g.getClass();
        L54:
            r107 = r107 + 1;
            goto L7
        L55:
            int r132 = 0;
        L56:
            if (r132 >= r100) goto L61;
            n r133 = (n) r101.get(r102[r132]);
            int r134 = r133.f400119f.f400151k;
            if (r134 == (-1)) goto L60;
            n r135 = (n) r101.get(r134);
            r133.f400119f.f(r135, r135.f400119f);
            r133.f400120g.f(r135, r135.f400120g);
        L60:
            r132 = r132 + 1;
            goto L56
        }

        public final void f() {
            MotionLayout r100 = this.f399996g;
            int r101 = r100.f399961x;
            int r102 = r100.f399964y;
            int r103 = View.MeasureSpec.getMode(r101);
            int r104 = View.MeasureSpec.getMode(r102);
            MotionLayout r105 = this.f399996g;
            r105.H1 = r103;
            r105.L1 = r104;
            b(r101, r102);
            int r106 = 0;
            boolean r107 = true;
            if ((this.f399996g.getParent() instanceof MotionLayout) == true) goto L5;
        L8:
            boolean r108 = true;
        L9:
            if (r108 == false) goto L18;
            b(r101, r102);
            this.f399996g.f399958v1 = this.f399990a.t();
            this.f399996g.f399962x1 = this.f399990a.n();
            this.f399996g.f399965y1 = this.f399991b.t();
            this.f399996g.G1 = this.f399991b.n();
            MotionLayout r109 = this.f399996g;
            if (r109.f399958v1 == r109.f399965y1) goto L13;
        L16:
            boolean r110 = true;
        L17:
            r109.f399950p1 = r110;
            goto L18
        L13:
            if (r109.f399962x1 != r109.G1) goto L16;
            r110 = false;
        L18:
            MotionLayout r111 = this.f399996g;
            int r112 = r111.f399958v1;
            int r113 = r111.f399962x1;
            int r114 = r111.H1;
            if (r114 == Integer.MIN_VALUE) goto L21;
            if (r114 == 0) goto L21;
        L22:
            int r115 = r111.L1;
            if (r115 == Integer.MIN_VALUE) goto L25;
            if (r115 == 0) goto L25;
        L26:
            int r116 = r113;
            com.obric.oui.constraintlayout.core.widgets.d r117 = this.f399990a;
            if (r117.L0 == false) goto L29;
        L32:
            boolean r118 = true;
        L34:
            if (r117.M0 == false) goto L36;
        L39:
            boolean r119 = true;
        L40:
            r111.g(r101, r102, r112, r116, r118, r119);
            MotionLayout r120 = this.f399996g;
            int r121 = r120.getChildCount();
            r120.f399946h2.a();
            r120.I = true;
            SparseArray r122 = new SparseArray();
            int r123 = 0;
        L41:
            if (r123 >= r121) goto L43;
            View r124 = r120.getChildAt(r123);
            r122.put(r124.getId(), r120.A.get(r124));
            r123 = r123 + 1;
            goto L41
        L43:
            int r125 = r120.getWidth();
            int r126 = r120.getHeight();
            q.b r127 = r120.f399952q.f400160c;
            if (r127 == null) goto L46;
            int r128 = r127.f400193p;
        L47:
            if (r128 == (-1)) goto L54;
            int r129 = 0;
        L49:
            if (r129 >= r121) goto L54;
            n r130 = r120.A.get(r120.getChildAt(r129));
            if (r130 == null) goto L53;
            r130.B = r128;
        L53:
            r129 = r129 + 1;
        L54:
            SparseBooleanArray r131 = new SparseBooleanArray();
            int[] r132 = new int[r120.A.size()];
            int r133 = 0;
            int r134 = 0;
        L55:
            if (r133 >= r121) goto L61;
            n r135 = r120.A.get(r120.getChildAt(r133));
            int r136 = r135.f400119f.f400151k;
            if (r136 == (-1)) goto L59;
            r131.put(r136, true);
            r132[r134] = r135.f400119f.f400151k;
            r134 = r134 + 1;
        L59:
            r133 = r133 + 1;
            goto L55
        L61:
            if (r120.L0 == null) goto L80;
            int r137 = 0;
        L63:
            if (r137 >= r134) goto L69;
            n r138 = r120.A.get(r120.findViewById(r132[r137]));
            if (r138 == null) goto L68;
            r120.f399952q.f(r138);
        L68:
            r137 = r137 + 1;
            goto L63
        L69:
            Iterator<MotionHelper> r139 = r120.L0.iterator();
        L71:
            if (r139.hasNext() == false) goto L73;
            r139.next().u(r120, r120.A);
            goto L71
        L73:
            int r140 = 0;
        L74:
            if (r140 >= r134) goto L87;
            n r141 = r120.A.get(r120.findViewById(r132[r140]));
            if (r141 == null) goto L79;
            r141.h(r125, r126, r120.getNanoTime());
        L79:
            r140 = r140 + 1;
        L87:
            int r142 = 0;
        L88:
            if (r142 >= r121) goto L95;
            View r143 = r120.getChildAt(r142);
            n r144 = r120.A.get(r143);
            if (r131.get(r143.getId()) == true) goto L94;
            if (r144 == null) goto L94;
            r120.f399952q.f(r144);
            r144.h(r125, r126, r120.getNanoTime());
        L94:
            r142 = r142 + 1;
            goto L88
        L95:
            q.b r145 = r120.f399952q.f400160c;
            if (r145 == null) goto L98;
            float r146 = r145.f400186i;
        L100:
            if (r146 != 0.0f) goto L102;
            return;
        L102:
            if (r146 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L104;
            boolean r147 = true;
        L105:
            float r148 = Math.abs(r146);
            float r149 = Float.MAX_VALUE;
            float r150 = -3.4028235E38f;
            int r151 = 0;
            float r152 = Float.MAX_VALUE;
            float r153 = -3.4028235E38f;
        L106:
            if (r151 >= r121) goto L115;
            n r154 = r120.A.get(r120.getChildAt(r151));
            if (Float.isNaN(r154.f400125l) == false) goto L117;
            p r155 = r154.f400120g;
            float r156 = r155.f400145e;
            float r157 = r155.f400146f;
            if (r147 == false) goto L113;
            float r158 = r157 - r156;
        L114:
            r152 = Math.min(r152, r158);
            r153 = Math.max(r153, r158);
            r151 = r151 + 1;
            goto L106
        L113:
            r158 = r157 + r156;
        L117:
            if (r107 == false) goto L132;
            int r159 = 0;
        L119:
            if (r159 >= r121) goto L124;
            n r160 = r120.A.get(r120.getChildAt(r159));
            if (Float.isNaN(r160.f400125l) == true) goto L123;
            r149 = Math.min(r149, r160.f400125l);
            r150 = Math.max(r150, r160.f400125l);
        L123:
            r159 = r159 + 1;
        L124:
            if (r106 >= r121) goto L174;
            n r161 = r120.A.get(r120.getChildAt(r106));
            if (Float.isNaN(r161.f400125l) == true) goto L131;
            r161.f400127n = 1.0f / (1.0f - r148);
            if (r147 == false) goto L130;
            r161.f400126m = r148 - (((r150 - r161.f400125l) / (r150 - r149)) * r148);
            goto L131
        L130:
            r161.f400126m = r148 - (((r161.f400125l - r149) * r148) / (r150 - r149));
        L131:
            r106 = r106 + 1;
            goto L124
        L174:
            return;
        L132:
            if (r106 >= r121) goto L175;
            n r162 = r120.A.get(r120.getChildAt(r106));
            p r163 = r162.f400120g;
            float r164 = r163.f400145e;
            float r165 = r163.f400146f;
            if (r147 == false) goto L136;
            float r166 = r165 - r164;
        L137:
            r162.f400127n = 1.0f / (1.0f - r148);
            r162.f400126m = r148 - (((r166 - r152) * r148) / (r153 - r152));
            r106 = r106 + 1;
            goto L132
        L136:
            r166 = r165 + r164;
            goto L137
        L175:
            return;
        L115:
            r107 = false;
            goto L117
        L104:
            r147 = false;
            goto L105
        L98:
            r146 = 0.0f;
            goto L100
        L80:
            int r167 = 0;
        L81:
            if (r167 >= r134) goto L87;
            n r168 = r120.A.get(r120.findViewById(r132[r167]));
            if (r168 == null) goto L86;
            r120.f399952q.f(r168);
            r168.h(r125, r126, r120.getNanoTime());
        L86:
            r167 = r167 + 1;
            goto L81
        L46:
            r128 = -1;
            goto L47
        L36:
            if (this.f399991b.M0 == true) goto L39;
            r119 = false;
            goto L40
        L29:
            if (this.f399991b.L0 == true) goto L32;
            r118 = false;
        L25:
            r113 = (int) (r113 + (r111.M1 * (r111.G1 - r113)));
        L21:
            r112 = (int) (r112 + (r111.M1 * (r111.f399965y1 - r112)));
            goto L22
        L5:
            if (r103 != 1073741824) goto L8;
            if (r104 != 1073741824) goto L8;
            r108 = false;
            goto L9
        }

        public f(MotionLayout r100) {
            this.f399996g = r100;
            this.f399990a = new com.obric.oui.constraintlayout.core.widgets.d();
            this.f399991b = new com.obric.oui.constraintlayout.core.widgets.d();
            this.f399992c = null;
            this.f399993d = null;
        }

        public static void c(com.obric.oui.constraintlayout.core.widgets.d r100, com.obric.oui.constraintlayout.core.widgets.d r101) {
            ArrayList<ConstraintWidget> r102 = r100.f550644x0;
            HashMap<ConstraintWidget, ConstraintWidget> r103 = new HashMap();
            r103.put(r100, r101);
            r101.f550644x0.clear();
            r101.i(r100, r103);
            Iterator<ConstraintWidget> r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L25;
            ConstraintWidget r105 = r104.next();
            if ((r105 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L9;
            ConstraintWidget r106 = new com.obric.oui.constraintlayout.core.widgets.a();
        L21:
            r101.f550644x0.add(r106);
            ConstraintWidget r107 = r106.X;
            if (r107 == null) goto L24;
            ((ula.c) r107).f550644x0.remove(r106);
            r106.F();
        L24:
            r106.X = r101;
            r103.put(r105, r106);
            goto L4
        L9:
            if ((r105 instanceof com.obric.oui.constraintlayout.core.widgets.f) == false) goto L12;
            r106 = new com.obric.oui.constraintlayout.core.widgets.f();
            goto L21
        L12:
            if ((r105 instanceof com.obric.oui.constraintlayout.core.widgets.e) == false) goto L15;
            r106 = new com.obric.oui.constraintlayout.core.widgets.e();
            goto L21
        L15:
            if ((r105 instanceof com.obric.oui.constraintlayout.core.widgets.h) == false) goto L18;
            r106 = new com.obric.oui.constraintlayout.core.widgets.h();
            goto L21
        L18:
            if ((r105 instanceof ula.b) == false) goto L20;
            r106 = new ula.b();
            goto L21
        L20:
            r106 = new ConstraintWidget();
            goto L21
        L25:
            Iterator<ConstraintWidget> r108 = r102.iterator();
        L27:
            if (r108.hasNext() == false) goto L29;
            ConstraintWidget r109 = r108.next();
            r103.get(r109).i(r109, r103);
            goto L27
        }

        public static ConstraintWidget d(com.obric.oui.constraintlayout.core.widgets.d r100, View r101) {
            if (r100.f399720j0 != r101) goto L5;
            return r100;
        L5:
            ArrayList<ConstraintWidget> r102 = r100.f550644x0;
            int r103 = r102.size();
            int r104 = 0;
        L6:
            if (r104 >= r103) goto L11;
            ConstraintWidget r105 = (ConstraintWidget) ListProtector.get(r102, r104);
            if (r105.f399720j0 == r101) goto L9;
            r104 = r104 + 1;
            goto L6
        L9:
            return r105;
        L11:
            return null;
        }

        public final void b(int r100, int r101) {
            int r102 = this.f399996g.getOptimizationLevel();
            MotionLayout r103 = this.f399996g;
            if (r103.f399957v != r103.getStartState()) goto L26;
            MotionLayout r104 = this.f399996g;
            com.obric.oui.constraintlayout.core.widgets.d r105 = this.f399991b;
            com.obric.oui.constraintlayout.widget.a r106 = this.f399993d;
            if (r106 != null) goto L7;
        L10:
            int r107 = r100;
        L11:
            if (r106 != null) goto L13;
        L16:
            int r108 = r101;
        L17:
            r104.h(r105, r102, r107, r108);
            com.obric.oui.constraintlayout.widget.a r109 = this.f399992c;
            if (r109 == null) goto L49;
            MotionLayout r110 = this.f399996g;
            com.obric.oui.constraintlayout.core.widgets.d r111 = this.f399990a;
            int r112 = r109.f400482d;
            if (r112 != 0) goto L22;
            int r113 = r100;
        L23:
            if (r112 != 0) goto L25;
            r100 = r101;
        L25:
            r110.h(r111, r102, r113, r100);
            return;
        L22:
            r113 = r101;
            goto L23
        L49:
            return;
        L13:
            if (r106.f400482d == 0) goto L16;
            r108 = r100;
            goto L17
        L7:
            if (r106.f400482d == 0) goto L10;
            r107 = r101;
            goto L11
        L26:
            com.obric.oui.constraintlayout.widget.a r114 = this.f399992c;
            if (r114 == null) goto L36;
            MotionLayout r115 = this.f399996g;
            com.obric.oui.constraintlayout.core.widgets.d r116 = this.f399990a;
            int r117 = r114.f400482d;
            if (r117 != 0) goto L31;
            int r118 = r100;
        L32:
            if (r117 != 0) goto L34;
            int r119 = r101;
        L35:
            r115.h(r116, r102, r118, r119);
            goto L36
        L34:
            r119 = r100;
            goto L35
        L31:
            r118 = r101;
        L36:
            MotionLayout r120 = this.f399996g;
            com.obric.oui.constraintlayout.core.widgets.d r121 = this.f399991b;
            com.obric.oui.constraintlayout.widget.a r122 = this.f399993d;
            if (r122 != null) goto L39;
        L42:
            int r123 = r100;
        L43:
            if (r122 != null) goto L45;
        L46:
            r100 = r101;
        L47:
            r120.h(r121, r102, r123, r100);
            return;
        L45:
            if (r122.f400482d != 0) goto L47;
        L39:
            if (r122.f400482d == 0) goto L42;
            r123 = r101;
            goto L43
        }

        public final void e(com.obric.oui.constraintlayout.widget.a r100, com.obric.oui.constraintlayout.widget.a r101) {
            this.f399992c = r100;
            this.f399993d = r101;
            this.f399990a = new com.obric.oui.constraintlayout.core.widgets.d();
            com.obric.oui.constraintlayout.core.widgets.d r102 = new com.obric.oui.constraintlayout.core.widgets.d();
            this.f399991b = r102;
            com.obric.oui.constraintlayout.core.widgets.d r103 = this.f399990a;
            MotionLayout r104 = this.f399996g;
            boolean r105 = MotionLayout.F2;
            com.obric.oui.constraintlayout.core.widgets.d r106 = r104.f400389c;
            com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC4669b r107 = r106.B0;
            r103.B0 = r107;
            r103.f399835z0.f399799f = r107;
            com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC4669b r108 = r106.B0;
            r102.B0 = r108;
            r102.f399835z0.f399799f = r108;
            r103.f550644x0.clear();
            this.f399991b.f550644x0.clear();
            c(this.f399996g.f400389c, this.f399990a);
            c(this.f399996g.f400389c, this.f399991b);
            if (this.f399996g.E <= 0.5d) goto L7;
            if (r100 == null) goto L6;
            g(this.f399990a, r100);
        L6:
            g(this.f399991b, r101);
        L10:
            this.f399990a.C0 = this.f399996g.e();
            com.obric.oui.constraintlayout.core.widgets.d r109 = this.f399990a;
            r109.f399834y0.c(r109);
            this.f399991b.C0 = this.f399996g.e();
            com.obric.oui.constraintlayout.core.widgets.d r110 = this.f399991b;
            r110.f399834y0.c(r110);
            ViewGroup.LayoutParams r111 = this.f399996g.getLayoutParams();
            if (r111 != null) goto L13;
            return;
        L13:
            if (r111.width != (-2)) goto L16;
            com.obric.oui.constraintlayout.core.widgets.d r112 = this.f399990a;
            ConstraintWidget.DimensionBehaviour r113 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            r112.O(r113);
            this.f399991b.O(r113);
        L16:
            if (r111.height != (-2)) goto L20;
            com.obric.oui.constraintlayout.core.widgets.d r114 = this.f399990a;
            ConstraintWidget.DimensionBehaviour r115 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            r114.P(r115);
            this.f399991b.P(r115);
            return;
        L20:
            return;
        L7:
            g(this.f399991b, r101);
            if (r100 == null) goto L10;
            g(this.f399990a, r100);
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void g(com.obric.oui.constraintlayout.core.widgets.d r110, com.obric.oui.constraintlayout.widget.a r111) {
            SparseArray<ConstraintWidget> r100 = new SparseArray();
            Constraints.LayoutParams r101 = new Constraints.LayoutParams();
            r100.clear();
            r100.put(0, r110);
            r100.put(this.f399996g.getId(), r110);
            if (r111 != null) goto L5;
        L7:
            Iterator<ConstraintWidget> r102 = r110.f550644x0.iterator();
        L9:
            if (r102.hasNext() == false) goto L11;
            ConstraintWidget r103 = r102.next();
            r103.f399724l0 = true;
            r100.put(((View) r103.f399720j0).getId(), r103);
            goto L9
        L11:
            Iterator<ConstraintWidget> r112 = r110.f550644x0.iterator();
        L13:
            if (r112.hasNext() == false) goto L35;
            ConstraintWidget r113 = r112.next();
            View r114 = (View) r113.f399720j0;
            int r104 = r114.getId();
            if (r111.f400485g.containsKey(Integer.valueOf(r104)) == false) goto L19;
            com.obric.oui.constraintlayout.widget.a.C4670a r105 = r111.f400485g.get(Integer.valueOf(r104));
            if (r105 == null) goto L19;
            r105.a(r101);
        L19:
            r113.Q(r111.h(r114.getId()).f400490e.f400512c);
            r113.N(r111.h(r114.getId()).f400490e.f400514d);
            if ((r114 instanceof ConstraintHelper) == false) goto L31;
            ConstraintHelper r106 = (ConstraintHelper) r114;
            int r107 = r106.getId();
            if (r111.f400485g.containsKey(Integer.valueOf(r107)) == false) goto L29;
            com.obric.oui.constraintlayout.widget.a.C4670a r108 = r111.f400485g.get(Integer.valueOf(r107));
            if (r108 == null) goto L29;
            if ((r113 instanceof ula.b) == false) goto L29;
            r106.o(r108, (ula.b) r113, r101, r100);
        L29:
            if ((r114 instanceof Barrier) == false) goto L31;
            ((Barrier) r114).t();
        L31:
            r101.resolveLayoutDirection(this.f399996g.getLayoutDirection());
            MotionLayout r109 = this.f399996g;
            boolean r115 = MotionLayout.F2;
            r109.a(false, r114, r113, r101, r100);
            if (r111.h(r114.getId()).f400488c.f400566c == 1) goto L33;
            r113.f399722k0 = r111.h(r114.getId()).f400488c.f400565b;
            goto L13
        L33:
            r113.f399722k0 = r114.getVisibility();
            goto L13
        L35:
            Iterator<ConstraintWidget> r116 = r110.f550644x0.iterator();
        L37:
            if (r116.hasNext() == false) goto L47;
            ConstraintWidget r117 = r116.next();
            if ((r117 instanceof com.obric.oui.constraintlayout.core.widgets.i) == false) goto L37;
            ConstraintHelper r118 = (ConstraintHelper) r117.f399720j0;
            ula.a r119 = (ula.a) r117;
            r118.s(r119, r100);
            com.obric.oui.constraintlayout.core.widgets.i r120 = (com.obric.oui.constraintlayout.core.widgets.i) r119;
            int r121 = 0;
        L42:
            if (r121 >= r120.f550643y0) goto L37;
            ConstraintWidget r122 = r120.f550642x0[r121];
            if (r122 == null) goto L46;
            r122.I = true;
        L46:
            r121 = r121 + 1;
            goto L42
        L47:
            return;
        L5:
            if (r111.f400482d == 0) goto L7;
            MotionLayout r123 = this.f399996g;
            com.obric.oui.constraintlayout.core.widgets.d r124 = this.f399991b;
            int r125 = r123.getOptimizationLevel();
            int r126 = View.MeasureSpec.makeMeasureSpec(this.f399996g.getHeight(), 1073741824);
            int r127 = View.MeasureSpec.makeMeasureSpec(this.f399996g.getWidth(), 1073741824);
            boolean r128 = MotionLayout.F2;
            r123.h(r124, r125, r126, r127);
            goto L7
        }
    }

    public static class g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f399997b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VelocityTracker f399998a;

        public g() {
        }

        static {
            f399997b = new g();
        }
    }

    public class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f399999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f400000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f400001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f400002d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ MotionLayout f400003e;

        public final void a() {
            int r100 = this.f400001c;
            if (r100 == (-1)) goto L5;
        L6:
            if (r100 != (-1)) goto L14;
            MotionLayout r101 = this.f400003e;
            int r102 = this.f400002d;
            if (r101.isAttachedToWindow() == false) goto L10;
            r101.A(r102, -1);
        L18:
            this.f400003e.setState(TransitionState.SETUP);
        L20:
            if (Float.isNaN(this.f400000b) == true) goto L22;
            MotionLayout r103 = this.f400003e;
            float r104 = this.f399999a;
            float r105 = this.f400000b;
            if (r103.isAttachedToWindow() == false) goto L29;
            r103.setProgress(r104);
            r103.setState(TransitionState.MOVING);
            r103.f399955t = r105;
            float r106 = 1.0f;
            if (r105 == 0.0f) goto L39;
            if (r105 > 0.0f) goto L37;
            r106 = 0.0f;
        L37:
            r103.l(r106);
        L47:
            this.f399999a = Float.NaN;
            this.f400000b = Float.NaN;
            this.f400001c = -1;
            this.f400002d = -1;
            return;
        L39:
            if (r104 == 0.0f) goto L47;
            if (r104 == 1.0f) goto L47;
            if (r104 > 0.5f) goto L46;
            r106 = 0.0f;
        L46:
            r103.l(r106);
            goto L47
        L29:
            if (r103.S1 != null) goto L31;
            r103.S1 = new h(r103);
        L31:
            h r107 = r103.S1;
            r107.f399999a = r104;
            r107.f400000b = r105;
            goto L47
        L22:
            if (Float.isNaN(this.f399999a) == false) goto L24;
            return;
        L24:
            this.f400003e.setProgress(this.f399999a);
            return;
        L10:
            if (r101.S1 != null) goto L12;
            r101.S1 = new h(r101);
        L12:
            r101.S1.f400002d = r102;
            goto L18
        L14:
            int r108 = this.f400002d;
            if (r108 != (-1)) goto L17;
            this.f400003e.x(r100, -1, -1);
            goto L18
        L17:
            this.f400003e.y(r100, r108);
            goto L18
        L5:
            if (this.f400002d == (-1)) goto L20;
            goto L6
        }

        public h(MotionLayout r100) {
            this.f400003e = r100;
            this.f399999a = Float.NaN;
            this.f400000b = Float.NaN;
            this.f400001c = -1;
            this.f400002d = -1;
        }
    }

    public interface i {
        void a();

        void b();

        void c(int r100);

        void d();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
    }

    public int[] getConstraintSetIds() {
        q r100 = this.f399952q;
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.f400164g.size();
        int[] r102 = new int[r101];
        int r103 = 0;
    L7:
        if (r103 >= r101) goto L9;
        r102[r103] = r100.f400164g.keyAt(r103);
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    }

    public ArrayList<q.b> getDefinedTransitions() {
        q r100 = this.f399952q;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f400161d;
    }

    public com.obric.oui.constraintlayout.motion.widget.b getDesignTool() {
        if (this.P != null) goto L6;
        this.P = new com.obric.oui.constraintlayout.motion.widget.b();
    L6:
        return this.P;
    }

    public Bundle getTransitionState() {
        if (this.S1 != null) goto L5;
        this.S1 = new h(this);
    L5:
        h r100 = this.S1;
        MotionLayout r101 = r100.f400003e;
        r100.f400002d = r101.f399960w;
        r100.f400001c = r101.f399956u;
        r100.f400000b = r101.getVelocity();
        r100.f399999a = r100.f400003e.getProgress();
        h r102 = this.S1;
        r102.getClass();
        Bundle r103 = new Bundle();
        r103.putFloat("motion.progress", r102.f399999a);
        r103.putFloat("motion.velocity", r102.f400000b);
        r103.putInt("motion.StartState", r102.f400001c);
        r103.putInt("motion.EndState", r102.f400002d);
        return r103;
    }

    public long getTransitionTimeMs() {
        q r100 = this.f399952q;
        if (r100 == null) goto L6;
        this.C = r100.c() / 1000.0f;
    L6:
        return (long) (this.C * 1000.0f);
    }

    public final void o() {
        if (this.f399940J != null) goto L9;
        CopyOnWriteArrayList<i> r100 = this.P0;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.f399948k1 != this.D) goto L11;
        return;
    L11:
        if (this.f399945h1 == (-1)) goto L21;
        i r101 = this.f399940J;
        if (r101 == null) goto L15;
        r101.d();
    L15:
        CopyOnWriteArrayList<i> r102 = this.P0;
        if (r102 == null) goto L21;
        Iterator<i> r103 = r102.iterator();
    L19:
        if (r103.hasNext() == false) goto L21;
        r103.next().d();
    L21:
        this.f399945h1 = -1;
        this.f399948k1 = this.D;
        i r104 = this.f399940J;
        if (r104 == null) goto L24;
        r104.b();
    L24:
        CopyOnWriteArrayList<i> r105 = this.P0;
        if (r105 == null) goto L35;
        Iterator<i> r106 = r105.iterator();
    L28:
        if (r106.hasNext() == false) goto L36;
        r106.next().b();
        goto L28
    L36:
        return;
    }

    public final void p() {
        if (this.f399940J != null) goto L9;
        CopyOnWriteArrayList<i> r100 = this.P0;
        if (r100 != null) goto L7;
    L18:
        v();
        Runnable r101 = this.T1;
        if (r101 == null) goto L22;
        r101.run();
        this.T1 = null;
        return;
    L22:
        return;
    L7:
        if (r100.isEmpty() == true) goto L18;
    L9:
        if (this.f399945h1 != (-1)) goto L18;
        this.f399945h1 = this.f399957v;
        if (this.E2.isEmpty() == true) goto L13;
        ArrayList<Integer> r102 = this.E2;
        int r103 = ((Integer) ListProtector.get(r102, r102.size() - 1)).intValue();
    L14:
        int r104 = this.f399957v;
        if (r103 == r104) goto L18;
        if (r104 == (-1)) goto L18;
        this.E2.add(Integer.valueOf(r104));
        goto L18
    L13:
        r103 = -1;
        goto L14
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f399950p1 == false) goto L5;
    L19:
        super.requestLayout();
        return;
    L5:
        if (this.f399957v != (-1)) goto L19;
        q r100 = this.f399952q;
        if (r100 == null) goto L19;
        q.b r101 = r100.f400160c;
        if (r101 == null) goto L19;
        int r102 = r101.f400194q;
        if (r102 != 0) goto L14;
        return;
    L14:
        if (r102 != 2) goto L19;
        int r103 = getChildCount();
        int r104 = 0;
    L16:
        if (r104 >= r103) goto L18;
        View r105 = getChildAt(r104);
        this.A.get(r105).f400117d = true;
        r104 = r104 + 1;
        goto L16
    }

    public final void u() {
        q r100 = this.f399952q;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.a(this, this.f399957v) == false) goto L9;
        requestLayout();
        return;
    L9:
        int r101 = this.f399957v;
        View r102 = null;
        if (r101 == (-1)) goto L60;
        q r103 = this.f399952q;
        Iterator<q.b> r104 = r103.f400161d.iterator();
    L13:
        if (r104.hasNext() == false) goto L26;
        q.b r105 = r104.next();
        if (r105.f400190m.size() <= 0) goto L13;
        Iterator<q.b.a> r106 = r105.f400190m.iterator();
    L18:
        if (r106.hasNext() == false) goto L13;
        int r107 = r106.next().f400197b;
        if (r107 == (-1)) goto L18;
        View r108 = findViewById(r107);
        if (r108 == null) goto L18;
        r108.setOnClickListener(null);
        goto L18
    L26:
        Iterator<q.b> r109 = r103.f400163f.iterator();
    L28:
        if (r109.hasNext() == false) goto L41;
        q.b r110 = r109.next();
        if (r110.f400190m.size() <= 0) goto L28;
        Iterator<q.b.a> r111 = r110.f400190m.iterator();
    L33:
        if (r111.hasNext() == false) goto L28;
        int r112 = r111.next().f400197b;
        if (r112 == (-1)) goto L33;
        View r113 = findViewById(r112);
        if (r113 == null) goto L33;
        r113.setOnClickListener(null);
        goto L33
    L41:
        Iterator<q.b> r114 = r103.f400161d.iterator();
    L43:
        if (r114.hasNext() == false) goto L50;
        q.b r115 = r114.next();
        if (r115.f400190m.size() <= 0) goto L43;
        Iterator<q.b.a> r116 = r115.f400190m.iterator();
    L48:
        if (r116.hasNext() == false) goto L43;
        r116.next().a(this, r101, r115);
        goto L48
    L50:
        Iterator<q.b> r117 = r103.f400163f.iterator();
    L52:
        if (r117.hasNext() == false) goto L60;
        q.b r118 = r117.next();
        if (r118.f400190m.size() <= 0) goto L52;
        Iterator<q.b.a> r119 = r118.f400190m.iterator();
    L57:
        if (r119.hasNext() == false) goto L52;
        r119.next().a(this, r101, r118);
    L60:
        if (this.f399952q.o() == false) goto L108;
        q.b r120 = this.f399952q.f400160c;
        if (r120 == null) goto L109;
        t r121 = r120.f400189l;
        if (r121 == null) goto L110;
        int r122 = r121.f400202d;
        if (r122 == (-1)) goto L71;
        r102 = r121.f400216r.findViewById(r122);
        if (r102 != null) goto L71;
        com.obric.oui.constraintlayout.motion.widget.a.c(r121.f400216r.getContext(), r121.f400202d);
    L71:
        if ((r102 instanceof NestedScrollView) == false) goto L111;
        NestedScrollView r123 = (NestedScrollView) r102;
        r123.setOnTouchListener(new r());
        r123.setOnScrollChangeListener(new s());
        return;
    L111:
        return;
    L110:
        return;
    L109:
        return;
    }

    public final void v() {
        if (this.f399940J != null) goto L9;
        CopyOnWriteArrayList<i> r100 = this.P0;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isEmpty() == false) goto L9;
        return;
    L9:
        Iterator<Integer> r101 = this.E2.iterator();
    L11:
        if (r101.hasNext() == false) goto L21;
        Integer r102 = r101.next();
        i r103 = this.f399940J;
        if (r103 == null) goto L15;
        r103.c(r102.intValue());
    L15:
        CopyOnWriteArrayList<i> r104 = this.P0;
        if (r104 == null) goto L11;
        Iterator<i> r105 = r104.iterator();
    L19:
        if (r105.hasNext() == false) goto L11;
        r105.next().c(r102.intValue());
        goto L19
    L21:
        this.E2.clear();
    }

    public final void w() {
        this.f399946h2.f();
        invalidate();
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display r100 = getDisplay();
        if (r100 == null) goto L5;
        r100.getRotation();
    L5:
        q r101 = this.f399952q;
        if (r101 == null) goto L33;
        int r102 = this.f399957v;
        if (r102 == (-1)) goto L33;
        com.obric.oui.constraintlayout.widget.a r103 = r101.b(r102);
        q r104 = this.f399952q;
        int r105 = 0;
    L11:
        if (r105 >= r104.f400164g.size()) goto L24;
        int r106 = r104.f400164g.keyAt(r105);
        int r107 = r104.f400166i.get(r106);
        int r108 = r104.f400166i.size();
    L13:
        if (r107 <= 0) goto L20;
        if (r107 == r106) goto L18;
        int r109 = r108 - 1;
        if (r108 < 0) goto L18;
        r107 = r104.f400166i.get(r107);
        r108 = r109;
    L18:
        boolean r110 = true;
    L21:
        if (r110 == true) goto L24;
        r104.m(r106, this);
        r105 = r105 + 1;
        goto L11
    L20:
        r110 = false;
    L24:
        ArrayList<MotionHelper> r111 = this.L0;
        if (r111 == null) goto L30;
        Iterator<MotionHelper> r112 = r111.iterator();
    L28:
        if (r112.hasNext() == false) goto L30;
        r112.next().getClass();
    L30:
        if (r103 == null) goto L32;
        r103.b(this);
    L32:
        this.f399956u = this.f399957v;
    L33:
        u();
        h r113 = this.S1;
        if (r113 != null) goto L36;
        q r114 = this.f399952q;
        if (r114 == null) goto L55;
        q.b r115 = r114.f400160c;
        if (r115 != null) goto L44;
        return;
    L44:
        if (r115.f400191n != 4) goto L57;
        l(1.0f);
        this.T1 = null;
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
        return;
    L57:
        return;
    L55:
        return;
    L36:
        if (this.f399942b2 == false) goto L38;
        post(new b(this));
        return;
    L38:
        r113.a();
    }

    @Override // android.view.View
    public final String toString() {
        Context r100 = getContext();
        return com.obric.oui.constraintlayout.motion.widget.a.c(r100, this.f399956u) + "->" + com.obric.oui.constraintlayout.motion.widget.a.c(r100, this.f399960w) + " (pos:" + this.E + " Dpos/Dt:" + this.f399955t;
    }

    public int getCurrentState() {
        return this.f399957v;
    }

    public int getEndState() {
        return this.f399960w;
    }

    public float getProgress() {
        return this.E;
    }

    public q getScene() {
        return this.f399952q;
    }

    public int getStartState() {
        return this.f399956u;
    }

    public float getTargetPosition() {
        return this.G;
    }

    public float getVelocity() {
        return this.f399955t;
    }

    public MotionLayout(Context r100) {
        super(r100);
        this.f399954s = null;
        this.f399955t = 0.0f;
        this.f399956u = -1;
        this.f399957v = -1;
        this.f399960w = -1;
        this.f399961x = 0;
        this.f399964y = 0;
        this.f399967z = true;
        this.A = new HashMap();
        this.B = 0;
        this.C = 1.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        this.G = 0.0f;
        this.I = false;
        this.K = 0;
        this.M = false;
        this.N = new vla.b();
        this.O = new d(this);
        this.S = false;
        this.f399947k0 = false;
        this.f399949p0 = null;
        this.H0 = null;
        this.L0 = null;
        this.P0 = null;
        this.V0 = 0;
        this.f399941b1 = -1;
        this.f399943g1 = 0.0f;
        this.f399945h1 = 0;
        this.f399948k1 = 0.0f;
        this.f399950p1 = false;
        this.P1 = new tla.d();
        this.Q1 = false;
        this.T1 = null;
        new HashMap();
        this.V1 = new Rect();
        this.f399942b2 = false;
        this.f399944g2 = TransitionState.UNDEFINED;
        this.f399946h2 = new f(this);
        this.f399951p2 = false;
        this.f399959v2 = new RectF();
        this.f399963x2 = null;
        this.f399966y2 = null;
        this.E2 = new ArrayList();
        t(null);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r210) {
        MotionLayout r100 = this;
        Canvas r101 = r210;
        ArrayList<MotionHelper> r102 = r100.L0;
        if (r102 == null) goto L8;
        Iterator<MotionHelper> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r103.next().getClass();
    L8:
        char r104 = 0;
        r100.n(false);
        q r105 = r100.f399952q;
        if (r105 == null) goto L22;
        y r106 = r105.f400174q;
        if (r106 == null) goto L22;
        ArrayList<w.a> r107 = r106.f400265d;
        if (r107 == null) goto L22;
        Iterator<w.a> r108 = r107.iterator();
    L17:
        if (r108.hasNext() == false) goto L19;
        r108.next().a();
        goto L17
    L19:
        r106.f400265d.removeAll(r106.f400266e);
        r106.f400266e.clear();
        if (r106.f400265d.isEmpty() == false) goto L22;
        r106.f400265d = null;
    L22:
        super.dispatchDraw(r210);
        if (r100.f399952q != null) goto L26;
        return;
    L26:
        if ((r100.K & 1) != 1) goto L41;
        if (isInEditMode() == true) goto L41;
        r100.V0++;
        long r109 = getNanoTime();
        long r110 = r100.f399941b1;
        if (r110 == (-1)) goto L34;
        long r111 = r109 - r110;
        if (r111 <= 200000000) goto L35;
        r100.f399943g1 = ((int) ((r100.V0 / (r111 * 1.0E-9f)) * 100.0f)) / 100.0f;
        r100.V0 = 0;
        r100.f399941b1 = r109;
    L35:
        Paint r112 = new Paint();
        r112.setTextSize(42.0f);
        float r113 = ((int) (getProgress() * 1000.0f)) / 10.0f;
        String r114 = r100.f399943g1 + " fps " + com.obric.oui.constraintlayout.motion.widget.a.e(r100, r100.f399956u) + " -> ";
        StringBuilder r115 = new StringBuilder();
        r115.append(r114);
        r115.append(com.obric.oui.constraintlayout.motion.widget.a.e(r100, r100.f399960w));
        r115.append(" (progress: ");
        r115.append(r113);
        r115.append(" ) state=");
        int r116 = r100.f399957v;
        if (r116 != (-1)) goto L38;
        String r117 = "undefined";
    L39:
        r115.append(r117);
        String r118 = r115.toString();
        r112.setColor(-16777216);
        r101.drawText(r118, 11.0f, getHeight() - 29, r112);
        r112.setColor(-7864184);
        r101.drawText(r118, 10.0f, getHeight() - 30, r112);
        goto L41
    L38:
        r117 = com.obric.oui.constraintlayout.motion.widget.a.e(r100, r116);
        goto L39
    L34:
        r100.f399941b1 = r109;
    L41:
        if (r100.K > 1) goto L43;
    L184:
        r100 = this;
    L185:
        ArrayList<MotionHelper> r119 = r100.L0;
        if (r119 == null) goto L191;
        Iterator<MotionHelper> r120 = r119.iterator();
    L189:
        if (r120.hasNext() == false) goto L221;
        r120.next().getClass();
        goto L189
    L221:
        return;
    L191:
        return;
    L43:
        if (r100.L != null) goto L45;
        r100.L = new e(r100);
    L45:
        e r121 = r100.L;
        HashMap<View, n> r122 = r100.A;
        int r123 = r100.f399952q.c();
        int r124 = r100.K;
        r121.getClass();
        if (r122 == null) goto L184;
        if (r122.size() == 0) goto L185;
        r210.save();
        if (r121.f399989n.isInEditMode() == false) goto L53;
    L55:
        Iterator<n> r125 = r122.values().iterator();
        Canvas r126 = r101;
    L57:
        if (r125.hasNext() == false) goto L183;
        n r127 = r125.next();
        int r128 = r127.f400119f.f400142b;
        Iterator<p> r129 = r127.f400134u.iterator();
    L60:
        if (r129.hasNext() == false) goto L62;
        r128 = Math.max(r128, r129.next().f400142b);
        goto L60
    L62:
        int r130 = Math.max(r128, r127.f400120g.f400142b);
        if (r124 <= 0) goto L66;
        if (r130 != 0) goto L66;
        r130 = 1;
    L66:
        if (r130 == 0) goto L57;
        float[] r131 = r121.f399978c;
        int[] r132 = r121.f399977b;
        if (r131 == null) goto L81;
        double[] r133 = r127.f400123j[r104].g();
        if (r132 == null) goto L76;
        Iterator<p> r134 = r127.f400134u.iterator();
        int r135 = 0;
    L74:
        if (r134.hasNext() == false) goto L76;
        r132[r135] = r134.next().f400155o;
        r135 = r135 + 1;
    L76:
        int r136 = 0;
        int r137 = 0;
    L78:
        if (r136 >= r133.length) goto L80;
        r127.f400123j[r104].c(r133[r136], r127.f400129p);
        float[] r211 = r131;
        r127.f400119f.c(r133[r136], r127.f400128o, r127.f400129p, r211, r137);
        r137 = r137 + 2;
        r136 = r136 + 1;
        r125 = r125;
        r124 = r124;
        r131 = r211;
        r133 = r133;
        r104 = 0;
        goto L78
    L80:
        Iterator<n> r212 = r125;
        int r213 = r124;
        int r138 = r137 / 2;
    L82:
        r121.f399986k = r138;
        if (r130 < 1) goto L181;
        int r139 = r123 / 16;
        float[] r140 = r121.f399976a;
        if (r140 != null) goto L87;
    L88:
        r121.f399976a = new float[r139 * 2];
        r121.f399979d = new Path();
    L89:
        float r141 = r121.f399988m;
        r126.translate(r141, r141);
        r121.f399980e.setColor(1996488704);
        r121.f399984i.setColor(1996488704);
        r121.f399981f.setColor(1996488704);
        r121.f399982g.setColor(1996488704);
        float[] r142 = r121.f399976a;
        float r143 = 1.0f;
        float r144 = 1.0f / (r139 - 1);
        HashMap<String, vla.d> r145 = r127.f400138y;
        if (r145 != null) goto L92;
        vla.d r146 = null;
    L93:
        HashMap<String, vla.d> r147 = r127.f400138y;
        if (r147 != null) goto L96;
        vla.d r148 = null;
    L97:
        HashMap<String, vla.c> r149 = r127.f400139z;
        if (r149 != null) goto L100;
        vla.c r150 = null;
    L101:
        HashMap<String, vla.c> r151 = r127.f400139z;
        if (r151 != null) goto L104;
        vla.c r152 = null;
    L105:
        int r153 = 0;
    L106:
        float r154 = Float.NaN;
        if (r153 >= r139) goto L152;
        float r155 = r153 * r144;
        int r156 = r139;
        float r157 = r127.f400127n;
        if (r157 == r143) goto L118;
        float r158 = r127.f400126m;
        if (r155 >= r158) goto L114;
        r155 = 0.0f;
    L114:
        if (r155 <= r158) goto L118;
        if (r155 >= 1.0d) goto L118;
        float r159 = Math.min((r155 - r158) * r157, 1.0f);
    L119:
        double r160 = r159;
        tla.c r161 = r127.f400119f.f400141a;
        Iterator<p> r162 = r127.f400134u.iterator();
        float r163 = 0.0f;
    L121:
        if (r162.hasNext() == false) goto L131;
        Iterator<p> r214 = r162;
        p r164 = r162.next();
        float r215 = r144;
        tla.c r165 = r164.f400141a;
        if (r165 == null) goto L130;
        float r166 = r164.f400143c;
        if (r166 >= r159) goto L128;
        r163 = r166;
        r161 = r165;
        goto L130
    L128:
        if (Float.isNaN(r154) == false) goto L130;
        r154 = r164.f400143c;
    L130:
        r162 = r214;
        r144 = r215;
        goto L121
    L131:
        float r216 = r144;
        if (r161 != null) goto L134;
    L137:
        r127.f400123j[0].c(r160, r127.f400129p);
        tla.a r167 = r127.f400124k;
        if (r167 == null) goto L142;
        double[] r168 = r127.f400129p;
        if (r168.length <= 0) goto L142;
        r167.c(r160, r168);
    L142:
        int r217 = r153 * 2;
        int r218 = r123;
        vla.c r169 = r152;
        int r219 = r153;
        double r170 = r160;
        vla.d r171 = r148;
        r127.f400119f.c(r170, r127.f400128o, r127.f400129p, r142, r217);
        if (r150 == null) goto L145;
        r142[r217] = r142[r217] + r150.a(r159);
    L147:
        if (r169 == null) goto L149;
        int r220 = r217 + 1;
        r142[r220] = r142[r220] + r169.a(r159);
    L151:
        r153 = r219 + 1;
        r148 = r171;
        r152 = r169;
        r139 = r156;
        r144 = r216;
        r123 = r218;
        r143 = 1.0f;
        goto L106
    L149:
        if (r171 == null) goto L151;
        int r221 = r217 + 1;
        r142[r221] = r142[r221] + r171.a(r159);
        goto L151
    L145:
        if (r146 == null) goto L147;
        r142[r217] = r142[r217] + r146.a(r159);
        goto L147
    L134:
        if (Float.isNaN(r154) == false) goto L136;
        r154 = 1.0f;
    L136:
        float r172 = r154 - r163;
        r160 = (((float) r161.a((r159 - r163) / r172)) * r172) + r163;
    L118:
        r159 = r155;
        goto L119
    L152:
        int r222 = r123;
        r121.a(r210, r130, r121.f399986k, r127);
        r121.f399980e.setColor(-21965);
        r121.f399981f.setColor(-2067046);
        r121.f399984i.setColor(-2067046);
        r121.f399982g.setColor(-13391360);
        float r173 = -r121.f399988m;
        r210.translate(r173, r173);
        r121.a(r210, r130, r121.f399986k, r127);
        if (r130 != 5) goto L179;
        r121.f399979d.reset();
        int r174 = 0;
    L156:
        if (r174 > 50) goto L178;
        float[] r175 = r121.f399985j;
        r127.f400123j[0].c(r127.b(r174 / 50, null), r127.f400129p);
        p r176 = r127.f400119f;
        int[] r177 = r127.f400128o;
        double[] r178 = r127.f400129p;
        float r179 = r176.f400145e;
        float r180 = r176.f400146f;
        float r181 = r176.f400147g;
        float r182 = r176.f400148h;
        int r183 = 0;
    L159:
        if (r183 >= r177.length) goto L174;
        float r184 = (float) r178[r183];
        int r185 = r177[r183];
        if (r185 != 1) goto L163;
        r179 = r184;
    L172:
        r183 = r183 + 1;
        goto L159
    L163:
        if (r185 == 2) goto L170;
        if (r185 != 3) goto L166;
        r181 = r184;
        goto L172
    L166:
        if (r185 != 4) goto L172;
        r182 = r184;
        goto L172
    L170:
        r180 = r184;
        goto L172
    L174:
        if (r176.f400153m == null) goto L177;
        double r186 = 0.0f;
        double r187 = r179;
        double r188 = r180;
        float r189 = (float) (((Math.sin(r188) * r187) + r186) - ((double) (r181 / 2.0f)));
        r180 = (float) ((r186 - (r187 * Math.cos(r188))) - ((double) (r182 / 2.0f)));
        r179 = r189;
    L177:
        float r190 = r181 + r179;
        float r191 = r182 + r180;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        float r192 = r179 + 0.0f;
        float r193 = r180 + 0.0f;
        float r194 = r190 + 0.0f;
        float r195 = r191 + 0.0f;
        r175[0] = r192;
        r175[1] = r193;
        r175[2] = r194;
        r175[3] = r193;
        r175[4] = r194;
        r175[5] = r195;
        r175[6] = r192;
        r175[7] = r195;
        Path r196 = r121.f399979d;
        float[] r197 = r121.f399985j;
        r196.moveTo(r197[0], r197[1]);
        Path r198 = r121.f399979d;
        float[] r199 = r121.f399985j;
        r198.lineTo(r199[2], r199[3]);
        Path r200 = r121.f399979d;
        float[] r201 = r121.f399985j;
        r200.lineTo(r201[4], r201[5]);
        Path r202 = r121.f399979d;
        float[] r203 = r121.f399985j;
        r202.lineTo(r203[6], r203[7]);
        r121.f399979d.close();
        r174 = r174 + 1;
        goto L156
    L178:
        r121.f399980e.setColor(1140850688);
        Canvas r204 = r210;
        r204.translate(2.0f, 2.0f);
        r204.drawPath(r121.f399979d, r121.f399980e);
        r204.translate(-2.0f, -2.0f);
        r121.f399980e.setColor(-65536);
        r204.drawPath(r121.f399979d, r121.f399980e);
    L180:
        r126 = r204;
    L182:
        r104 = 0;
        r101 = r204;
        r125 = r212;
        r124 = r213;
        r123 = r222;
        goto L57
    L179:
        r204 = r210;
        goto L180
    L104:
        r152 = r151.get(LiveDegradeFpsAnimator.TRANSLATION_Y);
        goto L105
    L100:
        r150 = r149.get(LiveDegradeFpsAnimator.TRANSLATION_X);
        goto L101
    L96:
        r148 = r147.get(LiveDegradeFpsAnimator.TRANSLATION_Y);
        goto L97
    L92:
        r146 = r145.get(LiveDegradeFpsAnimator.TRANSLATION_X);
        goto L93
    L87:
        if (r140.length == (r139 * 2)) goto L89;
    L181:
        r204 = r101;
        r222 = r123;
        goto L182
    L81:
        r212 = r125;
        r213 = r124;
        r138 = 0;
        goto L82
    L183:
        r210.restore();
        goto L184
    L53:
        if ((r124 & 1) != 2) goto L55;
        String r1100 = r121.f399989n.getContext().getResources().getResourceName(r121.f399989n.f399960w) + ":" + r121.f399989n.getProgress();
        r101.drawText(r1100, 10.0f, r121.f399989n.getHeight() - 30, r121.f399983h);
        r101.drawText(r1100, 11.0f, r121.f399989n.getHeight() - 29, r121.f399980e);
        goto L55
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout
    public final void f(int r100) {
        this.f400397k = null;
    }

    public final void l(float r100) {
        q r101 = this.f399952q;
        if (r101 != null) goto L5;
        return;
    L5:
        float r102 = this.E;
        float r103 = this.D;
        if (r102 != r103) goto L8;
    L10:
        float r104 = this.E;
        if (r104 != r100) goto L13;
        return;
    L13:
        this.M = false;
        this.G = r100;
        this.C = r101.c() / 1000.0f;
        setProgress(this.G);
        this.f399953r = null;
        this.f399954s = this.f399952q.e();
        this.H = false;
        this.B = getNanoTime();
        this.I = true;
        this.D = r104;
        this.E = r104;
        invalidate();
        return;
    L8:
        if (this.H == false) goto L10;
        this.E = r103;
        goto L10
    }

    public final void m(boolean r100) {
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L19;
        View r103 = getChildAt(r102);
        n r104 = this.A.get(r103);
        if (r104 == null) goto L18;
        if ("button".equals(com.obric.oui.constraintlayout.motion.widget.a.d(r104.f400115b)) == false) goto L18;
        if (r104.A == null) goto L18;
        int r105 = 0;
    L11:
        k[] r106 = r104.A;
        if (r105 >= r106.length) goto L18;
        k r107 = r106[r105];
        if (r100 == false) goto L16;
        float r108 = -100.0f;
    L17:
        r107.h(r108, r104.f400115b);
        r105 = r105 + 1;
        goto L11
    L16:
        r108 = 100.0f;
    L18:
        r102 = r102 + 1;
        goto L3
    }

    public final void n(boolean r210) {
        if (this.F != (-1)) goto L5;
        this.F = getNanoTime();
    L5:
        float r100 = this.E;
        if (r100 > 0.0f) goto L8;
    L10:
        boolean r101 = false;
        boolean r102 = true;
        if (this.f399947k0 == false) goto L13;
    L17:
        float r103 = Math.signum(this.G - r100);
        long r104 = getNanoTime();
        o r105 = this.f399953r;
        if ((r105 instanceof o) == true) goto L20;
        float r110 = (((r104 - this.F) * r103) * 1.0E-9f) / this.C;
    L21:
        float r111 = this.E + r110;
        if (this.H == false) goto L25;
        r111 = this.G;
    L25:
        if (r103 <= 0.0f) goto L29;
        if (r111 < this.G) goto L29;
    L32:
        r111 = this.G;
        this.I = false;
        boolean r112 = true;
    L34:
        this.E = r111;
        this.D = r111;
        this.F = r104;
        if (r105 == null) goto L67;
        if (r112 == true) goto L67;
        if (this.M == false) goto L62;
        float r106 = r105.getInterpolation((r104 - this.B) * 1.0E-9f);
        o r107 = this.f399953r;
        vla.b r108 = this.N;
        if (r107 == r108) goto L42;
        char r109 = 0;
    L46:
        this.E = r106;
        this.F = r104;
        o r113 = this.f399953r;
        if ((r113 instanceof o) == false) goto L70;
        float r114 = r113.a();
        this.f399955t = r114;
        if ((Math.abs(r114) * this.C) > 1.0E-5f) goto L53;
        if (r109 != 2) goto L53;
        this.I = false;
    L53:
        if (r114 <= 0.0f) goto L58;
        if (r106 < 1.0f) goto L58;
        this.E = 1.0f;
        this.I = false;
        r106 = 1.0f;
    L58:
        if (r114 >= 0.0f) goto L70;
        if (r106 > 0.0f) goto L70;
        this.E = 0.0f;
        this.I = false;
        r106 = 0.0f;
    L70:
        if (Math.abs(this.f399955t) <= 1.0E-5f) goto L72;
        setState(TransitionState.MOVING);
    L72:
        if (r109 == 1) goto L86;
        if (r103 <= 0.0f) goto L77;
        if (r106 < this.G) goto L77;
    L80:
        r106 = this.G;
        this.I = false;
    L82:
        if (r106 < 1.0f) goto L84;
    L85:
        this.I = false;
        setState(TransitionState.FINISHED);
        goto L86
    L84:
        if (r106 > 0.0f) goto L86;
    L77:
        if (r103 > 0.0f) goto L82;
        if (r106 > this.G) goto L82;
    L86:
        int r115 = getChildCount();
        this.f399947k0 = false;
        long r116 = getNanoTime();
        this.M1 = r106;
        Interpolator r117 = this.f399954s;
        if (r117 != null) goto L89;
        float r118 = r106;
    L90:
        Interpolator r119 = this.f399954s;
        if (r119 == null) goto L93;
        float r120 = r119.getInterpolation((r103 / this.C) + r106);
        this.f399955t = r120;
        this.f399955t = r120 - this.f399954s.getInterpolation(r106);
    L93:
        int r121 = 0;
    L94:
        if (r121 >= r115) goto L99;
        View r122 = getChildAt(r121);
        n r123 = this.A.get(r122);
        if (r123 == null) goto L98;
        this.f399947k0 = r123.e(r122, r118, r116, this.P1) | this.f399947k0;
    L98:
        r121 = r121 + 1;
        goto L94
    L99:
        if (r103 <= 0.0f) goto L103;
        if (r106 < this.G) goto L103;
    L106:
        boolean r124 = true;
    L109:
        if (this.f399947k0 == true) goto L115;
        if (this.I == true) goto L115;
        if (r124 == false) goto L115;
        setState(TransitionState.FINISHED);
    L115:
        if (this.f399950p1 == false) goto L117;
        requestLayout();
    L117:
        this.f399947k0 = (!r124) | this.f399947k0;
        if (r106 > 0.0f) goto L125;
        int r125 = this.f399956u;
        if (r125 == (-1)) goto L125;
        if (this.f399957v == r125) goto L125;
        this.f399957v = r125;
        this.f399952q.b(r125).a(this);
        setState(TransitionState.FINISHED);
        r101 = true;
    L125:
        if (r106 < 1.0d) goto L130;
        int r126 = this.f399957v;
        int r127 = this.f399960w;
        if (r126 == r127) goto L130;
        this.f399957v = r127;
        this.f399952q.b(r127).a(this);
        setState(TransitionState.FINISHED);
        r101 = true;
    L130:
        if (this.f399947k0 == false) goto L132;
    L142:
        invalidate();
    L144:
        if (this.f399947k0 == false) goto L146;
    L155:
        float r128 = this.E;
        if (r128 < 1.0f) goto L164;
        int r129 = this.f399957v;
        int r130 = this.f399960w;
        if (r129 != r130) goto L161;
        r102 = r101;
    L161:
        this.f399957v = r130;
    L162:
        r101 = r102;
    L170:
        this.f399951p2 |= r101;
        if (r101 == true) goto L173;
    L175:
        this.D = this.E;
        return;
    L173:
        if (this.Q1 == true) goto L175;
        requestLayout();
        goto L175
    L164:
        if (r128 > 0.0f) goto L170;
        int r131 = this.f399957v;
        int r132 = this.f399956u;
        if (r131 != r132) goto L169;
        r102 = r101;
    L169:
        this.f399957v = r132;
        goto L162
    L146:
        if (this.I == true) goto L155;
        if (r103 <= 0.0f) goto L151;
        if (r106 != 1.0f) goto L151;
    L154:
        u();
    L151:
        if (r103 >= 0.0f) goto L155;
        if (r106 != 0.0f) goto L155;
    L132:
        if (this.I == true) goto L142;
        if (r103 <= 0.0f) goto L138;
        if (r106 != 1.0f) goto L138;
    L141:
        setState(TransitionState.FINISHED);
    L138:
        if (r103 >= 0.0f) goto L144;
        if (r106 != 0.0f) goto L144;
    L103:
        if (r103 <= 0.0f) goto L105;
    L107:
        r124 = false;
        goto L109
    L105:
        if (r106 > this.G) goto L107;
    L89:
        r118 = r117.getInterpolation(r106);
        goto L90
    L42:
        if (r108.f555711c.a() == false) goto L44;
        r109 = 2;
        goto L46
    L44:
        r109 = 1;
        goto L46
    L62:
        float r133 = r105.getInterpolation(r111);
        o r134 = this.f399953r;
        if ((r134 instanceof o) == false) goto L65;
        this.f399955t = r134.a();
    L66:
        r111 = r133;
    L68:
        r106 = r111;
        r109 = 0;
        goto L70
    L65:
        this.f399955t = ((r134.getInterpolation(r111 + r110) - r133) * r103) / r110;
    L67:
        this.f399955t = r110;
    L29:
        if (r103 <= 0.0f) goto L31;
    L33:
        r112 = false;
        goto L34
    L31:
        if (r111 > this.G) goto L33;
    L20:
        r110 = 0.0f;
        goto L21
    L13:
        if (this.I == false) goto L155;
        if (r210 == true) goto L17;
        if (this.G == r100) goto L155;
    L8:
        if (r100 >= 1.0f) goto L10;
        this.f399957v = -1;
        goto L10
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r210) {
        q r100 = this.f399952q;
        if (r100 != null) goto L5;
    L104:
        return false;
    L5:
        if (this.f399967z == false) goto L104;
        y r101 = r100.f400174q;
        if (r101 == null) goto L76;
        int r110 = r101.f400262a.getCurrentState();
        if (r110 == (-1)) goto L76;
        if (r101.f400264c != null) goto L23;
        r101.f400264c = new HashSet();
        Iterator<w> r102 = r101.f400263b.iterator();
    L16:
        if (r102.hasNext() == false) goto L23;
        w r103 = r102.next();
        int r104 = r101.f400262a.getChildCount();
        int r105 = 0;
    L18:
        if (r105 >= r104) goto L16;
        View r106 = r101.f400262a.getChildAt(r105);
        if (r103.c(r106) == false) goto L22;
        r106.getId();
        r101.f400264c.add(r106);
    L22:
        r105 = r105 + 1;
    L23:
        float r111 = r210.getX();
        float r112 = r210.getY();
        Rect r113 = new Rect();
        int r114 = r210.getAction();
        ArrayList<w.a> r107 = r101.f400265d;
        int r108 = 2;
        if (r107 != null) goto L26;
    L42:
        if (r114 == 0) goto L45;
        if (r114 != 1) goto L76;
    L45:
        q r109 = r101.f400262a.f399952q;
        if (r109 != null) goto L48;
        com.obric.oui.constraintlayout.widget.a r115 = null;
    L49:
        com.obric.oui.constraintlayout.widget.a r116 = r115;
        Iterator<w> r117 = r101.f400263b.iterator();
    L51:
        if (r117.hasNext() == false) goto L76;
        w r118 = r117.next();
        int r119 = r118.f400229b;
        if (r119 != 1) goto L56;
        if (r114 == 0) goto L62;
    L63:
        boolean r120 = false;
    L64:
        if (r120 == false) goto L51;
        Iterator<View> r121 = r101.f400264c.iterator();
    L67:
        if (r121.hasNext() == false) goto L51;
        View r122 = r121.next();
        if (r118.c(r122) == false) goto L67;
        r122.getHitRect(r113);
        if (r113.contains((int) r111, (int) r112) == false) goto L75;
        r118.a(r101, r101.f400262a, r110, r116, new View[]{r122});
    L75:
        r118 = r118;
        r108 = 2;
    L62:
        r120 = true;
        goto L64
    L56:
        if (r119 != r108) goto L60;
        if (r114 != 1) goto L63;
    L60:
        if (r119 != 3) goto L63;
        if (r114 != 0) goto L63;
    L48:
        r115 = r109.b(r110);
        goto L49
    L26:
        if (r107.isEmpty() == true) goto L42;
        Iterator<w.a> r123 = r101.f400265d.iterator();
    L29:
        if (r123.hasNext() == false) goto L42;
        w.a r124 = r123.next();
        if (r114 != 1) goto L32;
        if (r124.f400256h == true) goto L29;
        r124.b();
        goto L29
    L32:
        if (r114 != 2) goto L33;
        r124.f400251c.f400115b.getHitRect(r124.f400260l);
        if (r124.f400260l.contains((int) r111, (int) r112) == true) goto L29;
        if (r124.f400256h == true) goto L29;
        r124.b();
        goto L29
    L33:
        r124.getClass();
    L76:
        q.b r125 = this.f399952q.f400160c;
        if (r125 == null) goto L104;
        if ((true ^ r125.f400192o) == false) goto L104;
        t r126 = r125.f400189l;
        if (r126 == null) goto L104;
        if (r210.getAction() != 0) goto L89;
        RectF r127 = r126.b(this, new RectF());
        if (r127 == null) goto L89;
        if (r127.contains(r210.getX(), r210.getY()) == true) goto L89;
        return false;
    L89:
        int r128 = r126.f400203e;
        if (r128 == (-1)) goto L104;
        View r129 = this.f399963x2;
        if (r129 != null) goto L94;
    L95:
        this.f399963x2 = findViewById(r128);
    L96:
        View r130 = this.f399963x2;
        if (r130 == null) goto L104;
        this.f399959v2.set(r130.getLeft(), this.f399963x2.getTop(), this.f399963x2.getRight(), this.f399963x2.getBottom());
        if (this.f399959v2.contains(r210.getX(), r210.getY()) == false) goto L104;
        if (s(this.f399963x2.getLeft(), this.f399963x2.getTop(), this.f399963x2, r210) == true) goto L104;
        return onTouchEvent(r210);
    L94:
        if (r129.getId() == r128) goto L96;
        goto L95
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int r100) {
        q r101 = this.f399952q;
        if (r101 == null) goto L10;
        boolean r102 = e();
        r101.f400173p = r102;
        q.b r103 = r101.f400160c;
        if (r103 == null) goto L11;
        t r104 = r103.f400189l;
        if (r104 == null) goto L12;
        r104.c(r102);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r310) {
        q r100 = this.f399952q;
        if (r100 == null) goto L379;
        if (this.f399967z == false) goto L379;
        if (r100.o() == false) goto L379;
        q r101 = this.f399952q;
        q.b r102 = r101.f400160c;
        if (r102 != null) goto L11;
    L14:
        int r103 = getCurrentState();
        RectF r104 = new RectF();
        if (r101.f400172o != null) goto L17;
        r101.f400158a.getClass();
        g r105 = g.f399997b;
        r105.f399998a = VelocityTracker.obtain();
        r101.f400172o = r105;
    L17:
        VelocityTracker r106 = r101.f400172o.f399998a;
        if (r106 == null) goto L21;
        r106.addMovement(r310);
    L21:
        if (r103 == (-1)) goto L107;
        int r110 = r310.getAction();
        if (r110 == 0) goto L92;
        if (r110 != 2) goto L107;
        if (r101.f400170m == true) goto L107;
        float r111 = r310.getRawY() - r101.f400176s;
        float r112 = r310.getRawX() - r101.f400175r;
        if (r112 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L32;
    L33:
        MotionEvent r113 = r101.f400169l;
        if (r113 == null) goto L369;
        if (r103 == (-1)) goto L83;
        wla.c r114 = r101.f400159b;
        if (r114 == null) goto L42;
        int r115 = r114.a(r103);
        if (r115 == (-1)) goto L42;
    L43:
        ArrayList r116 = new ArrayList();
        Iterator<q.b> r117 = r101.f400161d.iterator();
    L45:
        if (r117.hasNext() == false) goto L52;
        q.b r107 = r117.next();
        if (r107.f400181d != r115) goto L49;
    L50:
        r116.add(r107);
        goto L45
    L49:
        if (r107.f400180c != r115) goto L45;
    L52:
        RectF r108 = new RectF();
        Iterator r109 = r116.iterator();
        float r118 = 0.0f;
        q.b r119 = null;
    L54:
        if (r109.hasNext() == false) goto L84;
        q.b r120 = (q.b) r109.next();
        if (r120.f400192o == true) goto L81;
        t r121 = r120.f400189l;
        if (r121 == null) goto L81;
        r121.c(r101.f400173p);
        RectF r122 = r120.f400189l.b(r101.f400158a, r108);
        if (r122 != null) goto L63;
    L65:
        RectF r123 = r120.f400189l.a(r101.f400158a, r108);
        if (r123 != null) goto L68;
    L70:
        t r124 = r120.f400189l;
        float r125 = (r124.f400209k * r112) + (r124.f400210l * r111);
        if (r124.f400208j == false) goto L75;
        float r126 = r113.getX();
        r120.f400189l.getClass();
        float r127 = r126 - 0.5f;
        float r128 = r113.getY();
        r120.f400189l.getClass();
        float r129 = r128 - 0.5f;
        r125 = ((float) (Math.atan2(r111 + r129, r112 + r127) - Math.atan2(r127, r129))) * 10.0f;
    L75:
        if (r120.f400180c != r103) goto L77;
        float r130 = -1.0f;
    L78:
        float r131 = r130 * r125;
        if (r131 <= r118) goto L82;
        r118 = r131;
        r119 = r120;
    L82:
        r108 = r108;
        r109 = r109;
        r111 = r111;
        r112 = r112;
        goto L54
    L77:
        r130 = 1.1f;
        goto L78
    L68:
        if (r123.contains(r113.getX(), r113.getY()) == true) goto L70;
    L63:
        if (r122.contains(r113.getX(), r113.getY()) == true) goto L65;
    L81:
        r108 = r108;
        r109 = r109;
        r111 = r111;
        r112 = r112;
    L84:
        if (r119 == null) goto L107;
        setTransition(r119);
        RectF r132 = r101.f400160c.f400189l.b(r101.f400158a, r104);
        if (r132 != null) goto L88;
    L90:
        boolean r133 = false;
    L91:
        r101.f400171n = r133;
        t r134 = r101.f400160c.f400189l;
        float r135 = r101.f400175r;
        float r136 = r101.f400176s;
        r134.f400214p = r135;
        r134.f400215q = r136;
        r134.f400211m = false;
        goto L107
    L88:
        if (r132.contains(r101.f400169l.getX(), r101.f400169l.getY()) == true) goto L90;
        r133 = true;
    L42:
        r115 = r103;
        goto L43
    L83:
        r119 = r101.f400160c;
    L369:
        q.b r137 = this.f399952q.f400160c;
        if ((r137.f400195r & 4) == 0) goto L372;
        boolean r138 = true;
    L373:
        if (r138 == true) goto L375;
        return true;
    L375:
        return r137.f400189l.f400211m;
    L372:
        r138 = false;
        goto L373
    L32:
        if (r111 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L369;
    L92:
        r101.f400175r = r310.getRawX();
        r101.f400176s = r310.getRawY();
        r101.f400169l = r310;
        r101.f400170m = false;
        t r139 = r101.f400160c.f400189l;
        if (r139 == null) goto L369;
        RectF r140 = r139.a(r101.f400158a, r104);
        if (r140 != null) goto L97;
    L99:
        RectF r141 = r101.f400160c.f400189l.b(r101.f400158a, r104);
        if (r141 != null) goto L102;
    L104:
        r101.f400171n = false;
    L105:
        t r142 = r101.f400160c.f400189l;
        float r143 = r101.f400175r;
        float r144 = r101.f400176s;
        r142.f400214p = r143;
        r142.f400215q = r144;
        goto L369
    L102:
        if (r141.contains(r101.f400169l.getX(), r101.f400169l.getY()) == true) goto L104;
        r101.f400171n = true;
        goto L105
    L97:
        if (r140.contains(r101.f400169l.getX(), r101.f400169l.getY()) == true) goto L99;
        r101.f400169l = null;
        r101.f400170m = true;
    L107:
        if (r101.f400170m == true) goto L369;
        q.b r145 = r101.f400160c;
        if (r145 == null) goto L358;
        t r146 = r145.f400189l;
        if (r146 == null) goto L358;
        if (r101.f400171n == true) goto L358;
        g r147 = r101.f400172o;
        if (r146.f400208j == false) goto L237;
        VelocityTracker r148 = r147.f399998a;
        if (r148 == null) goto L120;
        r148.addMovement(r310);
    L120:
        int r149 = r310.getAction();
        if (r149 != 0) goto L123;
        r146.f400214p = r310.getRawX();
        r146.f400215q = r310.getRawY();
        r146.f400211m = false;
        goto L358
    L123:
        if (r149 != 1) goto L125;
        r146.f400211m = false;
        VelocityTracker r150 = r147.f399998a;
        if (r150 == null) goto L181;
        r150.computeCurrentVelocity(16);
    L181:
        VelocityTracker r151 = r147.f399998a;
        if (r151 == null) goto L184;
        float r152 = r151.getXVelocity();
    L185:
        VelocityTracker r153 = r147.f399998a;
        if (r153 == null) goto L188;
        float r154 = r153.getYVelocity();
    L189:
        float r155 = r146.f400216r.getProgress();
        float r156 = r146.f400216r.getWidth() / 2.0f;
        float r157 = r146.f400216r.getHeight() / 2.0f;
        int r158 = r146.f400207i;
        if (r158 == (-1)) goto L192;
        View r159 = r146.f400216r.findViewById(r158);
        r146.f400216r.getLocationOnScreen(r146.f400213o);
        float r160 = r146.f400213o[0] + ((r159.getLeft() + r159.getRight()) / 2.0f);
        float r161 = r146.f400213o[1];
        int r162 = r159.getTop();
        int r163 = r159.getBottom();
    L195:
        float r210 = r160;
        r157 = ((r162 + r163) / 2.0f) + r161;
        r156 = r210;
    L196:
        float r164 = r310.getRawX() - r156;
        float r165 = r310.getRawY() - r157;
        double r166 = Math.toDegrees(Math.atan2(r165, r164));
        int r167 = r146.f400202d;
        if (r167 == (-1)) goto L199;
        r146.f400216r.q(r167, r155, r146.f400206h, r146.f400205g, r146.f400212n);
        float[] r168 = r146.f400212n;
        r168[1] = (float) Math.toDegrees(r168[1]);
    L200:
        float r169 = ((float) (Math.toDegrees(Math.atan2(r154 + r165, r152 + r164)) - r166)) * 62.5f;
        if (Float.isNaN(r169) == true) goto L203;
        float r170 = (((r169 * 3.0f) * r146.f400220v) / r146.f400212n[1]) + r155;
    L205:
        if (r170 == 0.0f) goto L232;
        if (r170 == 1.0f) goto L232;
        int r171 = r146.f400201c;
        if (r171 == 3) goto L232;
        float r172 = (r169 * r146.f400220v) / r146.f400212n[1];
        if (r170 >= 0.5d) goto L213;
        float r173 = 0.0f;
    L215:
        if (r171 != 6) goto L221;
        if ((r155 + r172) >= 0.0f) goto L219;
        r172 = Math.abs(r172);
    L219:
        r173 = 1.0f;
    L221:
        if (r146.f400201c == 7) goto L223;
    L226:
        r146.f400216r.z(r146.f400201c, r173, r172 * 3.0f);
        if (0.0f < r155) goto L229;
    L230:
        r146.f400216r.setState(TransitionState.FINISHED);
        goto L358
    L229:
        if (1.0f > r155) goto L358;
    L223:
        if ((r155 + r172) <= 1.0f) goto L225;
        r172 = -Math.abs(r172);
    L225:
        r173 = 0.0f;
        goto L226
    L213:
        r173 = 1.0f;
    L232:
        if (0.0f < r170) goto L234;
    L235:
        r146.f400216r.setState(TransitionState.FINISHED);
        goto L358
    L234:
        if (1.0f > r170) goto L358;
    L203:
        r170 = r155;
        goto L205
    L199:
        r146.f400212n[1] = 360.0f;
        goto L200
    L192:
        int r174 = r146.f400202d;
        if (r174 == (-1)) goto L196;
        MotionLayout r175 = r146.f400216r;
        View r176 = r146.f400216r.findViewById(r175.A.get(r175.findViewById(r174)).f400119f.f400151k);
        r146.f400216r.getLocationOnScreen(r146.f400213o);
        r160 = r146.f400213o[0] + ((r176.getLeft() + r176.getRight()) / 2.0f);
        r161 = r146.f400213o[1];
        r162 = r176.getTop();
        r163 = r176.getBottom();
        goto L195
    L188:
        r154 = 0.0f;
        goto L189
    L184:
        r152 = 0.0f;
        goto L185
    L125:
        if (r149 != 2) goto L358;
        r310.getRawY();
        r310.getRawX();
        float r177 = r146.f400216r.getWidth() / 2.0f;
        float r178 = r146.f400216r.getHeight() / 2.0f;
        int r179 = r146.f400207i;
        if (r179 == (-1)) goto L130;
        View r180 = r146.f400216r.findViewById(r179);
        r146.f400216r.getLocationOnScreen(r146.f400213o);
        float r181 = r146.f400213o[0] + ((r180.getLeft() + r180.getRight()) / 2.0f);
        r178 = ((r180.getTop() + r180.getBottom()) / 2.0f) + r146.f400213o[1];
        r177 = r181;
    L136:
        float r182 = r310.getRawX() - r177;
        float r183 = r310.getRawY() - r178;
        double r184 = Math.atan2(r310.getRawY() - r178, r310.getRawX() - r177);
        float r185 = (float) (((r184 - Math.atan2(r146.f400215q - r178, r146.f400214p - r177)) * 180.0d) / 3.141592653589793d);
        if (r185 <= 330.0f) goto L140;
        r185 = r185 - 360.0f;
    L143:
        if (Math.abs(r185) <= 0.01d) goto L145;
    L146:
        float r186 = r146.f400216r.getProgress();
        if (r146.f400211m == true) goto L149;
        r146.f400211m = true;
        r146.f400216r.setProgress(r186);
    L149:
        int r187 = r146.f400202d;
        if (r187 == (-1)) goto L152;
        r146.f400216r.q(r187, r186, r146.f400206h, r146.f400205g, r146.f400212n);
        float[] r188 = r146.f400212n;
        char r189 = 1;
        r188[1] = (float) Math.toDegrees(r188[1]);
    L153:
        float r190 = Math.max(Math.min(r186 + ((r185 * r146.f400220v) / r146.f400212n[r189]), 1.0f), 0.0f);
        float r191 = r146.f400216r.getProgress();
        if (r190 != r191) goto L156;
        r146.f400216r.f399955t = 0.0f;
    L177:
        r146.f400214p = r310.getRawX();
        r146.f400215q = r310.getRawY();
        goto L358
    L156:
        if (r191 != 0.0f) goto L158;
    L159:
        MotionLayout r192 = r146.f400216r;
        if (r191 != 0.0f) goto L162;
        boolean r193 = true;
    L163:
        r192.m(r193);
    L164:
        r146.f400216r.setProgress(r190);
        VelocityTracker r194 = r147.f399998a;
        if (r194 == null) goto L167;
        r194.computeCurrentVelocity(1000);
    L167:
        VelocityTracker r195 = r147.f399998a;
        if (r195 == null) goto L170;
        float r196 = r195.getXVelocity();
    L171:
        VelocityTracker r197 = r147.f399998a;
        if (r197 == null) goto L174;
        float r198 = r197.getYVelocity();
    L175:
        double r199 = r198;
        double r200 = r196;
        float r201 = (float) ((Math.hypot(r199, r200) * Math.sin(Math.atan2(r199, r200) - r184)) / Math.hypot(r182, r183));
        r146.f400216r.f399955t = (float) Math.toDegrees(r201);
        goto L177
    L174:
        r198 = 0.0f;
        goto L175
    L170:
        r196 = 0.0f;
        goto L171
    L162:
        r193 = false;
        goto L163
    L158:
        if (r191 != 1.0f) goto L164;
    L152:
        r189 = 1;
        r146.f400212n[1] = 360.0f;
        goto L153
    L145:
        if (r146.f400211m == false) goto L358;
    L140:
        if (r185 >= (-330.0f)) goto L143;
        r185 = r185 + 360.0f;
        goto L143
    L130:
        int r202 = r146.f400202d;
        if (r202 == (-1)) goto L136;
        MotionLayout r203 = r146.f400216r;
        View r204 = r146.f400216r.findViewById(r203.A.get(r203.findViewById(r202)).f400119f.f400151k);
        if (r204 == null) goto L136;
        r146.f400216r.getLocationOnScreen(r146.f400213o);
        r177 = r146.f400213o[0] + ((r204.getLeft() + r204.getRight()) / 2.0f);
        r178 = r146.f400213o[1] + ((r204.getTop() + r204.getBottom()) / 2.0f);
        goto L136
    L237:
        VelocityTracker r205 = r147.f399998a;
        if (r205 == null) goto L240;
        r205.addMovement(r310);
    L240:
        int r206 = r310.getAction();
        if (r206 != 0) goto L243;
        r146.f400214p = r310.getRawX();
        r146.f400215q = r310.getRawY();
        r146.f400211m = false;
        goto L358
    L243:
        if (r206 != 1) goto L245;
        r146.f400211m = false;
        VelocityTracker r207 = r147.f399998a;
        if (r207 == null) goto L304;
        r207.computeCurrentVelocity(1000);
    L304:
        VelocityTracker r208 = r147.f399998a;
        if (r208 == null) goto L307;
        float r209 = r208.getXVelocity();
    L308:
        VelocityTracker r211 = r147.f399998a;
        if (r211 == null) goto L311;
        float r212 = r211.getYVelocity();
    L312:
        float r213 = r146.f400216r.getProgress();
        int r214 = r146.f400202d;
        if (r214 == (-1)) goto L315;
        r146.f400216r.q(r214, r213, r146.f400206h, r146.f400205g, r146.f400212n);
        char r215 = 0;
        char r1100 = 1;
    L316:
        float r216 = r146.f400209k;
        float[] r217 = r146.f400212n;
        float r1101 = r217[r215];
        float r218 = r217[r1100];
        if (r216 == 0.0f) goto L319;
        float r219 = r209 / r1101;
    L321:
        if (Float.isNaN(r219) == true) goto L323;
        float r220 = (r219 / 3.0f) + r213;
    L325:
        if (r220 == 0.0f) goto L352;
        if (r220 == 1.0f) goto L352;
        int r221 = r146.f400201c;
        if (r221 == 3) goto L352;
        if (r220 >= 0.5d) goto L333;
        float r222 = 0.0f;
    L335:
        if (r221 != 6) goto L341;
        if ((r213 + r219) >= 0.0f) goto L339;
        r219 = Math.abs(r219);
    L339:
        r222 = 1.0f;
    L341:
        if (r146.f400201c == 7) goto L343;
    L346:
        r146.f400216r.z(r146.f400201c, r222, r219);
        if (0.0f < r213) goto L349;
    L350:
        r146.f400216r.setState(TransitionState.FINISHED);
        goto L358
    L349:
        if (1.0f > r213) goto L358;
    L343:
        if ((r213 + r219) <= 1.0f) goto L345;
        r219 = -Math.abs(r219);
    L345:
        r222 = 0.0f;
        goto L346
    L333:
        r222 = 1.0f;
    L352:
        if (0.0f < r220) goto L354;
    L355:
        r146.f400216r.setState(TransitionState.FINISHED);
        goto L358
    L354:
        if (1.0f > r220) goto L358;
    L323:
        r220 = r213;
        goto L325
    L319:
        r219 = r212 / r218;
        goto L321
    L315:
        float r223 = Math.min(r146.f400216r.getWidth(), r146.f400216r.getHeight());
        float[] r224 = r146.f400212n;
        r1100 = 1;
        r224[1] = r146.f400210l * r223;
        r215 = 0;
        r224[0] = r223 * r146.f400209k;
        goto L316
    L311:
        r212 = 0.0f;
        goto L312
    L307:
        r209 = 0.0f;
        goto L308
    L245:
        if (r206 != 2) goto L358;
        float r225 = r310.getRawY() - r146.f400215q;
        float r226 = r310.getRawX() - r146.f400214p;
        if (Math.abs((r146.f400209k * r226) + (r146.f400210l * r225)) <= r146.f400222x) goto L250;
    L251:
        float r227 = r146.f400216r.getProgress();
        if (r146.f400211m == true) goto L254;
        r146.f400211m = true;
        r146.f400216r.setProgress(r227);
    L254:
        int r228 = r146.f400202d;
        if (r228 == (-1)) goto L257;
        r146.f400216r.q(r228, r227, r146.f400206h, r146.f400205g, r146.f400212n);
        char r1102 = 0;
        char r1103 = 1;
    L258:
        float r229 = r146.f400209k;
        float[] r230 = r146.f400212n;
        if (Math.abs(((r229 * r230[r1102]) + (r146.f400210l * r230[r1103])) * r146.f400220v) >= 0.01d) goto L261;
        float[] r231 = r146.f400212n;
        char r232 = 0;
        r231[0] = 0.01f;
        char r1104 = 1;
        r231[1] = 0.01f;
    L263:
        if (r146.f400209k == 0.0f) goto L265;
        float r233 = r226 / r146.f400212n[r232];
    L266:
        float r234 = Math.max(Math.min(r227 + r233, 1.0f), 0.0f);
        if (r146.f400201c != 6) goto L270;
        r234 = Math.max(r234, 0.01f);
    L270:
        if (r146.f400201c != 7) goto L272;
        r234 = Math.min(r234, 0.99f);
    L272:
        float r235 = r146.f400216r.getProgress();
        if (r234 != r235) goto L275;
        r146.f400216r.f399955t = 0.0f;
    L300:
        r146.f400214p = r310.getRawX();
        r146.f400215q = r310.getRawY();
        goto L358
    L275:
        if (r235 != 0.0f) goto L277;
    L278:
        MotionLayout r236 = r146.f400216r;
        if (r235 != 0.0f) goto L281;
        boolean r237 = true;
    L282:
        r236.m(r237);
    L283:
        r146.f400216r.setProgress(r234);
        VelocityTracker r238 = r147.f399998a;
        if (r238 == null) goto L286;
        r238.computeCurrentVelocity(1000);
    L286:
        VelocityTracker r239 = r147.f399998a;
        if (r239 == null) goto L289;
        float r240 = r239.getXVelocity();
    L290:
        VelocityTracker r241 = r147.f399998a;
        if (r241 == null) goto L293;
        float r242 = r241.getYVelocity();
    L295:
        if (r146.f400209k == 0.0f) goto L297;
        float r243 = r240 / r146.f400212n[0];
    L298:
        r146.f400216r.f399955t = r243;
        goto L300
    L297:
        r243 = r242 / r146.f400212n[1];
        goto L298
    L293:
        r242 = 0.0f;
        goto L295
    L289:
        r240 = 0.0f;
        goto L290
    L281:
        r237 = false;
        goto L282
    L277:
        if (r235 != 1.0f) goto L283;
    L265:
        r233 = r225 / r146.f400212n[r1104];
        goto L266
    L261:
        r232 = 0;
        r1104 = 1;
        goto L263
    L257:
        float r244 = Math.min(r146.f400216r.getWidth(), r146.f400216r.getHeight());
        float[] r245 = r146.f400212n;
        r1103 = 1;
        r245[1] = r146.f400210l * r244;
        r1102 = 0;
        r245[0] = r244 * r146.f400209k;
        goto L258
    L250:
        if (r146.f400211m == true) goto L251;
    L358:
        r101.f400175r = r310.getRawX();
        r101.f400176s = r310.getRawY();
        if (r310.getAction() != 1) goto L369;
        g r246 = r101.f400172o;
        if (r246 == null) goto L369;
        VelocityTracker r247 = r246.f399998a;
        if (r247 == null) goto L365;
        r247.recycle();
        g r248 = null;
        r246.f399998a = null;
    L366:
        r101.f400172o = r248;
        int r249 = this.f399957v;
        if (r249 == (-1)) goto L369;
        r101.a(this, r249);
        goto L369
    L365:
        r248 = null;
        goto L366
    L11:
        if ((!r102.f400192o) == true) goto L14;
        return super.onTouchEvent(r310);
    L379:
        return super.onTouchEvent(r310);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewAdded(View r100) {
        super.onViewAdded(r100);
        if ((r100 instanceof MotionHelper) == false) goto L26;
        MotionHelper r101 = (MotionHelper) r100;
        if (this.P0 != null) goto L7;
        this.P0 = new CopyOnWriteArrayList();
    L7:
        this.P0.add(r101);
        if (r101.f399936j == false) goto L14;
        if (this.f399949p0 != null) goto L12;
        this.f399949p0 = new ArrayList();
    L12:
        this.f399949p0.add(r101);
    L14:
        if (r101.f399937k == false) goto L20;
        if (this.H0 != null) goto L18;
        this.H0 = new ArrayList();
    L18:
        this.H0.add(r101);
    L20:
        if ((r101 instanceof MotionEffect) == true) goto L22;
        return;
    L22:
        if (this.L0 != null) goto L24;
        this.L0 = new ArrayList();
    L24:
        this.L0.add(r101);
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View r100) {
        super.onViewRemoved(r100);
        ArrayList<MotionHelper> r101 = this.f399949p0;
        if (r101 == null) goto L5;
        r101.remove(r100);
    L5:
        ArrayList<MotionHelper> r102 = this.H0;
        if (r102 == null) goto L9;
        r102.remove(r100);
        return;
    }

    public final q.b r(int r100) {
        Iterator<q.b> r101 = this.f399952q.f400161d.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        q.b r102 = r101.next();
        if (r102.f400178a != r100) goto L4;
        return r102;
    L8:
        return null;
    }

    public void setDebugMode(int r100) {
        this.K = r100;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean r100) {
        this.f399942b2 = r100;
    }

    public void setInteractionEnabled(boolean r100) {
        this.f399967z = r100;
    }

    public void setInterpolatedProgress(float r100) {
        if (this.f399952q == null) goto L8;
        setState(TransitionState.MOVING);
        Interpolator r101 = this.f399952q.e();
        if (r101 == null) goto L8;
        setProgress(r101.getInterpolation(r100));
        return;
    L8:
        setProgress(r100);
    }

    public void setOnHide(float r100) {
        ArrayList<MotionHelper> r101 = this.H0;
        if (r101 == null) goto L7;
        int r102 = r101.size();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        ((MotionHelper) ListProtector.get(this.H0, r103)).setProgress(r100);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    public void setOnShow(float r100) {
        ArrayList<MotionHelper> r101 = this.f399949p0;
        if (r101 == null) goto L7;
        int r102 = r101.size();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        ((MotionHelper) ListProtector.get(this.f399949p0, r103)).setProgress(r100);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    public void setProgress(float r100) {
        if (isAttachedToWindow() == true) goto L10;
        if (this.S1 != null) goto L7;
        this.S1 = new h(this);
    L7:
        this.S1.f399999a = r100;
        return;
    L10:
        if (r100 > 0.0f) goto L20;
        if (this.E == 1.0f) goto L14;
    L16:
        this.f399957v = this.f399956u;
        if (this.E != 0.0f) goto L31;
        setState(TransitionState.FINISHED);
    L31:
        if (this.f399952q != null) goto L33;
        return;
    L33:
        this.H = true;
        this.G = r100;
        this.D = r100;
        this.F = -1;
        this.B = -1;
        this.f399953r = null;
        this.I = true;
        invalidate();
        return;
    L14:
        if (this.f399957v != this.f399960w) goto L16;
        setState(TransitionState.MOVING);
        goto L16
    L20:
        if (r100 >= 1.0f) goto L22;
        this.f399957v = -1;
        setState(TransitionState.MOVING);
        goto L31
    L22:
        if (this.E == 0.0f) goto L24;
    L26:
        this.f399957v = this.f399960w;
        if (this.E != 1.0f) goto L31;
        setState(TransitionState.FINISHED);
        goto L31
    L24:
        if (this.f399957v != this.f399956u) goto L26;
        setState(TransitionState.MOVING);
        goto L26
    }

    public void setScene(q r100) {
        this.f399952q = r100;
        boolean r101 = e();
        r100.f400173p = r101;
        q.b r102 = r100.f400160c;
        if (r102 == null) goto L7;
        t r103 = r102.f400189l;
        if (r103 == null) goto L7;
        r103.c(r101);
    L7:
        w();
    }

    public void setStartState(int r100) {
        if (isAttachedToWindow() == false) goto L5;
        this.f399957v = r100;
        return;
    L5:
        if (this.S1 != null) goto L7;
        this.S1 = new h(this);
    L7:
        h r101 = this.S1;
        r101.f400001c = r100;
        r101.f400002d = r100;
    }

    public void setState(TransitionState r100) {
        TransitionState r101 = TransitionState.FINISHED;
        if (r100 == r101) goto L5;
    L7:
        TransitionState r102 = this.f399944g2;
        this.f399944g2 = r100;
        TransitionState r103 = TransitionState.MOVING;
        if (r102 != r103) goto L11;
        if (r100 != r103) goto L11;
        o();
    L11:
        int r104 = c.f399971a[r102.ordinal()];
        if (r104 != 1) goto L14;
    L20:
        if (r100 != r103) goto L22;
        o();
    L22:
        if (r100 != r101) goto L27;
        p();
        return;
    L27:
        return;
    L14:
        if (r104 == 2) goto L20;
        if (r104 != 3) goto L28;
        if (r100 != r101) goto L25;
        p();
        return;
    L25:
        return;
    L28:
        return;
    L5:
        if (this.f399957v != (-1)) goto L7;
    }

    public void setTransition(int r100) {
        if (this.f399952q == null) goto L38;
        q.b r101 = r(r100);
        this.f399956u = r101.f400181d;
        this.f399960w = r101.f400180c;
        if (isAttachedToWindow() == false) goto L7;
        int r102 = this.f399957v;
        if (r102 != this.f399956u) goto L15;
        float r103 = 0.0f;
    L18:
        q r104 = this.f399952q;
        r104.f400160c = r101;
        t r105 = r101.f400189l;
        if (r105 == null) goto L21;
        r105.c(r104.f400173p);
    L21:
        this.f399946h2.e(this.f399952q.b(this.f399956u), this.f399952q.b(this.f399960w));
        w();
        if (this.E == r103) goto L30;
        if (r103 != 0.0f) goto L27;
        m(true);
        this.f399952q.b(this.f399956u).b(this);
        goto L30
    L27:
        if (r103 != 1.0f) goto L30;
        m(false);
        this.f399952q.b(this.f399960w).b(this);
    L30:
        if (Float.isNaN(r103) == false) goto L32;
        float r106 = 0.0f;
    L33:
        this.E = r106;
        if (Float.isNaN(r103) == false) goto L36;
        com.obric.oui.constraintlayout.motion.widget.a.b();
        l(0.0f);
        return;
    L36:
        setProgress(r103);
        return;
    L32:
        r106 = r103;
        goto L33
    L15:
        if (r102 != this.f399960w) goto L17;
        r103 = 1.0f;
        goto L18
    L17:
        r103 = Float.NaN;
        goto L18
    L7:
        if (this.S1 != null) goto L9;
        this.S1 = new h(this);
    L9:
        h r107 = this.S1;
        r107.f400001c = this.f399956u;
        r107.f400002d = this.f399960w;
        return;
    }

    public void setTransitionDuration(int r100) {
        q r101 = this.f399952q;
        if (r101 != null) goto L5;
        return;
    L5:
        q.b r102 = r101.f400160c;
        if (r102 == null) goto L8;
        r102.f400185h = Math.max(r100, 8);
        return;
    L8:
        r101.f400167j = r100;
    }

    public void setTransitionListener(i r100) {
        this.f399940J = r100;
    }

    public void setTransitionState(Bundle r100) {
        if (this.S1 != null) goto L5;
        this.S1 = new h(this);
    L5:
        h r101 = this.S1;
        r101.getClass();
        r101.f399999a = r100.getFloat("motion.progress");
        r101.f400000b = r100.getFloat("motion.velocity");
        r101.f400001c = r100.getInt("motion.StartState");
        r101.f400002d = r100.getInt("motion.EndState");
        if (isAttachedToWindow() == false) goto L9;
        this.S1.a();
        return;
    }

    public final void t(AttributeSet r110) {
        F2 = isInEditMode();
        int r100 = -1;
        int r101 = 0;
        if (r110 == null) goto L33;
        TypedArray r111 = getContext().obtainStyledAttributes(r110, new int[]{R.attr.applyMotionScene, R.attr.currentState, R.attr.layoutDescription, R.attr.motionDebug, R.attr.motionProgress, R.attr.showPaths});
        int r102 = r111.getIndexCount();
        int r103 = 0;
        boolean r104 = true;
    L5:
        if (r103 >= r102) goto L29;
        int r105 = r111.getIndex(r103);
        int r106 = 2;
        if (r105 != 2) goto L9;
        int r107 = r111.getResourceId(r105, -1);
        this.f399952q = new q(getContext(), this, r107);
    L28:
        r103 = r103 + 1;
        goto L5
    L9:
        if (r105 != 1) goto L12;
        this.f399957v = r111.getResourceId(r105, -1);
        goto L28
    L12:
        if (r105 != 4) goto L14;
        this.G = r111.getFloat(r105, 0.0f);
        this.I = true;
        goto L28
    L14:
        if (r105 != 0) goto L17;
        r104 = r111.getBoolean(r105, r104);
        goto L28
    L17:
        if (r105 != 5) goto L26;
        if (this.K != 0) goto L28;
        if (r111.getBoolean(r105, false) == true) goto L24;
        r106 = 0;
    L24:
        this.K = r106;
        goto L28
    L26:
        if (r105 != 3) goto L28;
        this.K = r111.getInt(r105, 0);
        goto L28
    L29:
        r111.recycle();
        if (r104 == true) goto L33;
        this.f399952q = null;
    L33:
        if (this.K == 0) goto L76;
        q r112 = this.f399952q;
        if (r112 == null) goto L76;
        int r113 = r112.h();
        q r108 = this.f399952q;
        com.obric.oui.constraintlayout.widget.a r109 = r108.b(r108.h());
        com.obric.oui.constraintlayout.motion.widget.a.c(getContext(), r113);
        int r114 = getChildCount();
        int r115 = 0;
    L38:
        if (r115 >= r114) goto L46;
        View r116 = getChildAt(r115);
        int r117 = r116.getId();
        if (r117 == (-1)) goto L43;
    L43:
        if (r109.i(r117) != null) goto L45;
        com.obric.oui.constraintlayout.motion.widget.a.d(r116);
    L45:
        r115 = r115 + 1;
        goto L38
    L46:
        Integer[] r118 = (Integer[]) r109.f400485g.keySet().toArray(new Integer[0]);
        int r119 = r118.length;
        int[] r120 = new int[r119];
        int r121 = 0;
    L47:
        if (r121 >= r119) goto L49;
        r120[r121] = r118[r121].intValue();
        r121 = r121 + 1;
    L49:
        if (r101 >= r119) goto L60;
        int r122 = r120[r101];
        com.obric.oui.constraintlayout.motion.widget.a.c(getContext(), r122);
        if (findViewById(r120[r101]) == null) goto L54;
    L54:
        if (r109.h(r122).f400490e.f400514d == (-1)) goto L57;
    L57:
        if (r109.h(r122).f400490e.f400512c == (-1)) goto L59;
    L59:
        r101 = r101 + 1;
        goto L49
    L60:
        SparseIntArray r123 = new SparseIntArray();
        SparseIntArray r124 = new SparseIntArray();
        Iterator<q.b> r125 = this.f399952q.f400161d.iterator();
    L62:
        if (r125.hasNext() == false) goto L76;
        q.b r126 = r125.next();
        q.b r127 = this.f399952q.f400160c;
        int r128 = r126.f400181d;
        int r129 = r126.f400180c;
        com.obric.oui.constraintlayout.motion.widget.a.c(getContext(), r128);
        com.obric.oui.constraintlayout.motion.widget.a.c(getContext(), r129);
        if (r123.get(r128) == r129) goto L67;
    L67:
        if (r124.get(r129) == r128) goto L69;
    L69:
        r123.put(r128, r129);
        r124.put(r129, r128);
        if (this.f399952q.b(r128) == null) goto L73;
    L73:
        if (this.f399952q.b(r129) != null) goto L62;
    L76:
        if (this.f399957v != (-1)) goto L106;
        q r130 = this.f399952q;
        if (r130 == null) goto L107;
        this.f399957v = r130.h();
        this.f399956u = this.f399952q.h();
        q.b r131 = this.f399952q.f400160c;
        if (r131 == null) goto L83;
        r100 = r131.f400180c;
    L83:
        this.f399960w = r100;
        return;
    L107:
        return;
    }

    public void setTransition(q.b r100) {
        q r101 = this.f399952q;
        r101.f400160c = r100;
        if (r100 == null) goto L7;
        t r102 = r100.f400189l;
        if (r102 == null) goto L7;
        r102.c(r101.f400173p);
    L7:
        setState(TransitionState.SETUP);
        int r103 = this.f399957v;
        q.b r104 = this.f399952q.f400160c;
        int r105 = -1;
        if (r104 != null) goto L10;
        int r106 = -1;
    L11:
        if (r103 != r106) goto L13;
        this.E = 1.0f;
        this.D = 1.0f;
        this.G = 1.0f;
    L14:
        boolean r107 = true;
        if ((r100.f400195r & 1) != 0) goto L18;
        r107 = false;
    L18:
        if (r107 == false) goto L20;
        long r108 = -1;
    L21:
        this.F = r108;
        int r109 = this.f399952q.h();
        q r110 = this.f399952q;
        q.b r111 = r110.f400160c;
        if (r111 == null) goto L26;
        r105 = r111.f400180c;
    L26:
        if (r109 == this.f399956u) goto L28;
    L30:
        this.f399956u = r109;
        this.f399960w = r105;
        r110.n(r109, r105);
        this.f399946h2.e(this.f399952q.b(this.f399956u), this.f399952q.b(this.f399960w));
        f r112 = this.f399946h2;
        int r113 = this.f399956u;
        int r114 = this.f399960w;
        r112.f399994e = r113;
        r112.f399995f = r114;
        r112.f();
        w();
        return;
    L28:
        if (r105 != this.f399960w) goto L30;
        return;
    L20:
        r108 = getNanoTime();
        goto L21
    L13:
        this.E = 0.0f;
        this.D = 0.0f;
        this.G = 0.0f;
        goto L14
    L10:
        r106 = r104.f400180c;
        goto L11
    }

    public MotionLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f399954s = null;
        this.f399955t = 0.0f;
        this.f399956u = -1;
        this.f399957v = -1;
        this.f399960w = -1;
        this.f399961x = 0;
        this.f399964y = 0;
        this.f399967z = true;
        this.A = new HashMap();
        this.B = 0;
        this.C = 1.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        this.G = 0.0f;
        this.I = false;
        this.K = 0;
        this.M = false;
        this.N = new vla.b();
        this.O = new d(this);
        this.S = false;
        this.f399947k0 = false;
        this.f399949p0 = null;
        this.H0 = null;
        this.L0 = null;
        this.P0 = null;
        this.V0 = 0;
        this.f399941b1 = -1;
        this.f399943g1 = 0.0f;
        this.f399945h1 = 0;
        this.f399948k1 = 0.0f;
        this.f399950p1 = false;
        this.P1 = new tla.d();
        this.Q1 = false;
        this.T1 = null;
        new HashMap();
        this.V1 = new Rect();
        this.f399942b2 = false;
        this.f399944g2 = TransitionState.UNDEFINED;
        this.f399946h2 = new f(this);
        this.f399951p2 = false;
        this.f399959v2 = new RectF();
        this.f399963x2 = null;
        this.f399966y2 = null;
        this.E2 = new ArrayList();
        t(r101);
    }

    public static Rect k(MotionLayout r100, ConstraintWidget r101) {
        Rect r102 = r100.V1;
        r102.top = r101.v();
        Rect r103 = r100.V1;
        r103.left = r101.u();
        Rect r104 = r100.V1;
        int r105 = r101.t();
        Rect r106 = r100.V1;
        r104.right = r105 + r106.left;
        int r107 = r101.n();
        Rect r108 = r100.V1;
        r106.bottom = r107 + r108.top;
        return r108;
    }

    public final void A(int r110, int r111) {
        q r100 = this.f399952q;
        if (r100 == null) goto L37;
        wla.c r101 = r100.f400159b;
        if (r101 == null) goto L37;
        int r102 = this.f399957v;
        float r103 = -1;
        wla.c.a r104 = r101.f560229b.get(r110);
        if (r104 != null) goto L10;
        r102 = r110;
    L35:
        if (r102 == (-1)) goto L37;
        r110 = r102;
        goto L37
    L10:
        if (r103 == (-1.0f)) goto L26;
        if (r103 == (-1.0f)) goto L26;
        Iterator<wla.c.b> r105 = r104.f560231b.iterator();
        wla.c.b r106 = null;
    L15:
        if (r105.hasNext() == false) goto L22;
        wla.c.b r107 = r105.next();
        if (r107.a(r103, r103) == false) goto L15;
        if (r102 == r107.f560237e) goto L35;
        r106 = r107;
        goto L15
    L22:
        if (r106 == null) goto L24;
        r102 = r106.f560237e;
        goto L35
    L24:
        r102 = r104.f560232c;
    L26:
        if (r104.f560232c == r102) goto L35;
        Iterator<wla.c.b> r108 = r104.f560231b.iterator();
    L30:
        if (r108.hasNext() == false) goto L34;
        if (r102 != r108.next().f560237e) goto L30;
    L34:
        r102 = r104.f560232c;
    L37:
        int r109 = this.f399957v;
        if (r109 != r110) goto L41;
        return;
    L41:
        if (this.f399956u != r110) goto L47;
        l(0.0f);
        if (r111 <= 0) goto L141;
        this.C = r111 / 1000.0f;
        return;
    L141:
        return;
    L47:
        if (this.f399960w != r110) goto L52;
        l(1.0f);
        if (r111 <= 0) goto L142;
        this.C = r111 / 1000.0f;
        return;
    L142:
        return;
    L52:
        this.f399960w = r110;
        if (r109 == (-1)) goto L58;
        y(r109, r110);
        l(1.0f);
        this.E = 0.0f;
        l(1.0f);
        this.T1 = null;
        if (r111 <= 0) goto L143;
        this.C = r111 / 1000.0f;
        return;
    L143:
        return;
    L58:
        int r112 = 0;
        this.M = false;
        this.G = 1.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        this.F = getNanoTime();
        this.B = getNanoTime();
        this.H = false;
        this.f399953r = null;
        if (r111 != (-1)) goto L61;
        this.C = this.f399952q.c() / 1000.0f;
    L61:
        this.f399956u = -1;
        this.f399952q.n(-1, this.f399960w);
        SparseArray r113 = new SparseArray();
        if (r111 != 0) goto L64;
        this.C = this.f399952q.c() / 1000.0f;
    L66:
        int r114 = getChildCount();
        this.A.clear();
        int r115 = 0;
    L67:
        if (r115 >= r114) goto L69;
        View r116 = getChildAt(r115);
        this.A.put(r116, new n(r116));
        r113.put(r116.getId(), this.A.get(r116));
        r115 = r115 + 1;
        goto L67
    L69:
        this.I = true;
        this.f399946h2.e(null, this.f399952q.b(r110));
        w();
        this.f399946h2.a();
        int r117 = getChildCount();
        int r118 = 0;
    L70:
        if (r118 >= r117) goto L76;
        View r119 = getChildAt(r118);
        n r120 = this.A.get(r119);
        if (r120 == null) goto L75;
        p r121 = r120.f400119f;
        r121.f400143c = 0.0f;
        r121.f400144d = 0.0f;
        r121.d(r119.getX(), r119.getY(), r119.getWidth(), r119.getHeight());
        l r122 = r120.f400121h;
        r122.getClass();
        r119.getX();
        r119.getY();
        r119.getWidth();
        r119.getHeight();
        r122.b(r119);
    L75:
        r118 = r118 + 1;
        goto L70
    L76:
        int r123 = getWidth();
        int r124 = getHeight();
        if (this.L0 == null) goto L96;
        int r125 = 0;
    L79:
        if (r125 >= r114) goto L85;
        n r126 = this.A.get(getChildAt(r125));
        if (r126 == null) goto L84;
        this.f399952q.f(r126);
    L84:
        r125 = r125 + 1;
        goto L79
    L85:
        Iterator<MotionHelper> r127 = this.L0.iterator();
    L87:
        if (r127.hasNext() == false) goto L89;
        r127.next().u(this, this.A);
        goto L87
    L89:
        int r128 = 0;
    L90:
        if (r128 >= r114) goto L103;
        n r129 = this.A.get(getChildAt(r128));
        if (r129 == null) goto L95;
        r129.h(r123, r124, getNanoTime());
    L95:
        r128 = r128 + 1;
    L103:
        q.b r130 = this.f399952q.f400160c;
        if (r130 == null) goto L106;
        float r131 = r130.f400186i;
    L108:
        if (r131 == 0.0f) goto L114;
        float r132 = Float.MAX_VALUE;
        float r133 = -3.4028235E38f;
        int r134 = 0;
    L110:
        if (r134 >= r114) goto L112;
        p r135 = this.A.get(getChildAt(r134)).f400120g;
        float r136 = r135.f400146f + r135.f400145e;
        r132 = Math.min(r132, r136);
        r133 = Math.max(r133, r136);
        r134 = r134 + 1;
    L112:
        if (r112 >= r114) goto L114;
        n r137 = this.A.get(getChildAt(r112));
        p r138 = r137.f400120g;
        float r139 = r138.f400145e;
        float r140 = r138.f400146f;
        r137.f400127n = 1.0f / (1.0f - r131);
        r137.f400126m = r131 - ((((r139 + r140) - r132) * r131) / (r133 - r132));
        r112 = r112 + 1;
    L114:
        this.D = 0.0f;
        this.E = 0.0f;
        this.I = true;
        invalidate();
        return;
    L106:
        r131 = 0.0f;
        goto L108
    L96:
        int r141 = 0;
    L97:
        if (r141 >= r114) goto L103;
        n r142 = this.A.get(getChildAt(r141));
        if (r142 == null) goto L102;
        this.f399952q.f(r142);
        r142.h(r123, r124, getNanoTime());
    L102:
        r141 = r141 + 1;
        goto L97
    L64:
        if (r111 <= 0) goto L66;
        this.C = r111 / 1000.0f;
        goto L66
    }

    public final void B(int r100, com.obric.oui.constraintlayout.widget.a r101) {
        q r102 = this.f399952q;
        if (r102 == null) goto L5;
        r102.f400164g.put(r100, r101);
    L5:
        this.f399946h2.e(this.f399952q.b(this.f399956u), this.f399952q.b(this.f399960w));
        w();
        if (this.f399957v != r100) goto L9;
        r101.b(this);
        return;
    }

    public final void C(int r110, View... r111) {
        q r100 = this.f399952q;
        if (r100 == null) goto L32;
        y r101 = r100.f400174q;
        r101.getClass();
        ArrayList r102 = new ArrayList();
        Iterator<w> r103 = r101.f400263b.iterator();
    L6:
        if (r103.hasNext() == false) goto L43;
        w r104 = r103.next();
        if (r104.f400228a != r110) goto L6;
        int r105 = r111.length;
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L16;
        View r107 = r111[r106];
        if (r104.b(r107) == false) goto L14;
        r102.add(r107);
    L14:
        r106 = r106 + 1;
        goto L10
    L16:
        if (r102.isEmpty() == true) goto L6;
        View[] r108 = (View[]) r102.toArray(new View[0]);
        int r109 = r101.f400262a.getCurrentState();
        if (r104.f400232e != 2) goto L20;
        r104.a(r101, r101.f400262a, r109, null, r108);
    L31:
        r102.clear();
        goto L6
    L20:
        if (r109 != (-1)) goto L22;
        r101.f400262a.toString();
        goto L31
    L22:
        q r112 = r101.f400262a.f399952q;
        if (r112 != null) goto L25;
        com.obric.oui.constraintlayout.widget.a r113 = null;
    L26:
        com.obric.oui.constraintlayout.widget.a r114 = r113;
        if (r114 == null) goto L31;
        r104.a(r101, r101.f400262a, r109, r114, r108);
        goto L31
    L25:
        r113 = r112.b(r109);
        goto L26
    L43:
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        if (this.f399952q != null) goto L6;
        super.onMeasure(r110, r111);
        return;
    L6:
        int r100 = 0;
        boolean r101 = true;
        if (this.f399961x == r110) goto L9;
    L12:
        boolean r102 = true;
    L14:
        if (this.f399951p2 == false) goto L17;
        this.f399951p2 = false;
        u();
        v();
        r102 = true;
    L17:
        if (this.f400394h == false) goto L19;
        r102 = true;
    L19:
        this.f399961x = r110;
        this.f399964y = r111;
        int r103 = this.f399952q.h();
        q.b r104 = this.f399952q.f400160c;
        if (r104 != null) goto L22;
        int r105 = -1;
    L23:
        if (r102 == true) goto L33;
        f r106 = this.f399946h2;
        if (r103 == r106.f399994e) goto L27;
    L30:
        boolean r107 = true;
    L31:
        if (r107 == true) goto L33;
    L35:
        if (r102 == false) goto L37;
        super.onMeasure(r110, r111);
    L37:
        boolean r108 = true;
    L39:
        if (this.f399950p1 == true) goto L41;
        if (r108 == true) goto L41;
    L50:
        float r109 = Math.signum(this.G - this.E);
        long r112 = getNanoTime();
        o r113 = this.f399953r;
        if ((r113 instanceof vla.b) == true) goto L53;
        float r114 = (((r112 - this.F) * r109) * 1.0E-9f) / this.C;
    L54:
        float r115 = this.E + r114;
        if (this.H == false) goto L58;
        r115 = this.G;
    L58:
        if (r109 <= 0.0f) goto L62;
        if (r115 < this.G) goto L62;
    L65:
        r115 = this.G;
    L67:
        if (r113 == null) goto L73;
        if (r101 == true) goto L73;
        if (this.M == false) goto L72;
        r115 = r113.getInterpolation((r112 - this.B) * 1.0E-9f);
        goto L73
    L72:
        r115 = r113.getInterpolation(r115);
    L73:
        if (r109 <= 0.0f) goto L77;
        if (r115 < this.G) goto L77;
    L80:
        r115 = this.G;
    L81:
        this.M1 = r115;
        int r116 = getChildCount();
        long r117 = getNanoTime();
        Interpolator r118 = this.f399954s;
        if (r118 == null) goto L85;
        r115 = r118.getInterpolation(r115);
    L85:
        if (r100 >= r116) goto L91;
        View r119 = getChildAt(r100);
        n r120 = this.A.get(r119);
        if (r120 == null) goto L89;
        r120.e(r119, r115, r117, this.P1);
    L89:
        r100 = r100 + 1;
        goto L85
    L91:
        if (this.f399950p1 == false) goto L98;
        requestLayout();
        return;
    L98:
        return;
    L77:
        if (r109 > 0.0f) goto L81;
        if (r115 > this.G) goto L81;
    L62:
        if (r109 <= 0.0f) goto L64;
    L66:
        r101 = false;
        goto L67
    L64:
        if (r115 > this.G) goto L66;
    L53:
        r114 = 0.0f;
    L41:
        int r121 = getPaddingTop() + getPaddingBottom();
        int r122 = this.f400389c.t() + (getPaddingLeft() + getPaddingRight());
        int r123 = this.f400389c.n() + r121;
        int r124 = this.H1;
        if (r124 == Integer.MIN_VALUE) goto L44;
        if (r124 == 0) goto L44;
    L45:
        int r125 = this.L1;
        if (r125 == Integer.MIN_VALUE) goto L48;
        if (r125 == 0) goto L48;
    L49:
        setMeasuredDimension(r122, r123);
    L48:
        int r126 = this.f399962x1;
        r123 = (int) (r126 + (this.M1 * (this.G1 - r126)));
        requestLayout();
    L44:
        int r127 = this.f399958v1;
        r122 = (int) (r127 + (this.M1 * (this.f399965y1 - r127)));
        requestLayout();
        goto L45
    L27:
        if (r105 != r106.f399995f) goto L30;
        r107 = false;
    L33:
        if (this.f399956u == (-1)) goto L35;
        super.onMeasure(r110, r111);
        this.f399946h2.e(this.f399952q.b(r103), this.f399952q.b(r105));
        this.f399946h2.f();
        f r128 = this.f399946h2;
        r128.f399994e = r103;
        r128.f399995f = r105;
        r108 = false;
        goto L39
    L22:
        r105 = r104.f400180c;
        goto L23
    L9:
        if (this.f399964y != r111) goto L12;
        r102 = false;
        goto L14
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r110, int r111) {
        q r112 = this.f399952q;
        if (r112 == null) goto L30;
        float r113 = this.W;
        float r100 = 0.0f;
        if (r113 == 0.0f) goto L36;
        float r101 = this.T / r113;
        float r102 = this.U / r113;
        q.b r114 = r112.f400160c;
        if (r114 == null) goto L31;
        t r115 = r114.f400189l;
        if (r115 == null) goto L32;
        r115.f400211m = false;
        float r103 = r115.f400216r.getProgress();
        r115.f400216r.q(r115.f400202d, r103, r115.f400206h, r115.f400205g, r115.f400212n);
        float r104 = r115.f400209k;
        float[] r105 = r115.f400212n;
        float r116 = r105[0];
        float r106 = r115.f400210l;
        float r107 = r105[1];
        if (r104 == 0.0f) goto L14;
        float r108 = (r101 * r104) / r116;
    L16:
        if (Float.isNaN(r108) == true) goto L19;
        r103 = r103 + (r108 / 3.0f);
    L19:
        if (r103 != 0.0f) goto L21;
        return;
    L21:
        if (r103 == 1.0f) goto L34;
        int r109 = r115.f400201c;
        if (r109 == 3) goto L35;
        MotionLayout r117 = r115.f400216r;
        if (r103 < 0.5d) goto L28;
        r100 = 1.0f;
    L28:
        r117.z(r109, r100, r108);
        return;
    L35:
        return;
    L34:
        return;
    L14:
        r108 = (r102 * r106) / r107;
        goto L16
    L32:
        return;
    L31:
        return;
    L36:
        return;
    }

    public final void y(int r100, int r101) {
        if (isAttachedToWindow() == false) goto L5;
        q r102 = this.f399952q;
        if (r102 == null) goto L13;
        this.f399956u = r100;
        this.f399960w = r101;
        r102.n(r100, r101);
        this.f399946h2.e(this.f399952q.b(r100), this.f399952q.b(r101));
        w();
        this.E = 0.0f;
        l(0.0f);
        return;
    L13:
        return;
    L5:
        if (this.S1 != null) goto L7;
        this.S1 = new h(this);
    L7:
        h r103 = this.S1;
        r103.f400001c = r100;
        r103.f400002d = r101;
    }

    public MotionLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f399954s = null;
        this.f399955t = 0.0f;
        this.f399956u = -1;
        this.f399957v = -1;
        this.f399960w = -1;
        this.f399961x = 0;
        this.f399964y = 0;
        this.f399967z = true;
        this.A = new HashMap();
        this.B = 0;
        this.C = 1.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        this.G = 0.0f;
        this.I = false;
        this.K = 0;
        this.M = false;
        this.N = new vla.b();
        this.O = new d(this);
        this.S = false;
        this.f399947k0 = false;
        this.f399949p0 = null;
        this.H0 = null;
        this.L0 = null;
        this.P0 = null;
        this.V0 = 0;
        this.f399941b1 = -1;
        this.f399943g1 = 0.0f;
        this.f399945h1 = 0;
        this.f399948k1 = 0.0f;
        this.f399950p1 = false;
        this.P1 = new tla.d();
        this.Q1 = false;
        this.T1 = null;
        new HashMap();
        this.V1 = new Rect();
        this.f399942b2 = false;
        this.f399944g2 = TransitionState.UNDEFINED;
        this.f399946h2 = new f(this);
        this.f399951p2 = false;
        this.f399959v2 = new RectF();
        this.f399963x2 = null;
        this.f399966y2 = null;
        this.E2 = new ArrayList();
        t(r101);
    }

    public final void x(int r100, int r101, int r102) {
        setState(TransitionState.SETUP);
        this.f399957v = r100;
        this.f399956u = -1;
        this.f399960w = -1;
        wla.a r103 = this.f400397k;
        if (r103 == null) goto L36;
        float r104 = -1;
        int r105 = r103.f560214b;
        if (r105 != r100) goto L26;
        if (r100 != (-1)) goto L8;
        wla.a.C8130a r106 = r103.f560216d.valueAt(0);
    L9:
        int r107 = r103.f560215c;
        if (r107 != (-1)) goto L12;
    L14:
        int r108 = r106.a(r104, r104);
        if (r103.f560215c == r108) goto L45;
        if (r108 != (-1)) goto L19;
        com.obric.oui.constraintlayout.widget.a r109 = null;
    L20:
        if (r108 == (-1)) goto L23;
        int r110 = ((wla.a.b) ListProtector.get(r106.f560219b, r108)).f560226e;
    L23:
        if (r109 == null) goto L46;
        r103.f560215c = r108;
        r109.b(r103.f560213a);
        return;
    L46:
        return;
    L19:
        r109 = ((wla.a.b) ListProtector.get(r106.f560219b, r108)).f560227f;
        goto L20
    L45:
        return;
    L12:
        if (((wla.a.b) ListProtector.get(r106.f560219b, r107)).a(r104, r104) == false) goto L14;
        return;
    L8:
        r106 = r103.f560216d.get(r105);
        goto L9
    L26:
        r103.f560214b = r100;
        wla.a.C8130a r111 = r103.f560216d.get(r100);
        int r112 = r111.a(r104, r104);
        if (r112 != (-1)) goto L29;
        com.obric.oui.constraintlayout.widget.a r113 = r111.f560221d;
    L30:
        if (r112 == (-1)) goto L33;
        int r114 = ((wla.a.b) ListProtector.get(r111.f560219b, r112)).f560226e;
    L33:
        if (r113 == null) goto L41;
        r103.f560215c = r112;
        r113.b(r103.f560213a);
        return;
    L41:
        return;
    L29:
        r113 = ((wla.a.b) ListProtector.get(r111.f560219b, r112)).f560227f;
        goto L30
    L36:
        q r115 = this.f399952q;
        if (r115 == null) goto L43;
        r115.b(r100).b(this);
        return;
    }

    public final void z(int r110, float r111, float r112) {
        if (this.f399952q != null) goto L6;
        return;
    L6:
        if (this.E != r111) goto L8;
        return;
    L8:
        boolean r100 = true;
        this.M = true;
        this.B = getNanoTime();
        float r101 = this.f399952q.c() / 1000.0f;
        this.C = r101;
        this.G = r111;
        this.I = true;
        if (r110 == 0) goto L38;
        if (r110 == 1) goto L38;
        if (r110 == 2) goto L38;
        if (r110 != 4) goto L15;
        d r113 = this.O;
        float r114 = this.E;
        float r102 = this.f399952q.g();
        r113.f399972a = r112;
        r113.f399973b = r114;
        r113.f399974c = r102;
        this.f399953r = this.O;
    L90:
        this.H = false;
        this.B = getNanoTime();
        invalidate();
        return;
    L15:
        if (r110 == 5) goto L19;
        if (r110 == 6) goto L38;
        if (r110 == 7) goto L38;
    L19:
        float r115 = this.E;
        float r103 = this.f399952q.g();
        if (r112 <= 0.0f) goto L24;
        float r104 = r112 / r103;
        if ((r115 + ((r112 * r104) - (((r103 * r104) * r104) / 2.0f))) > 1.0f) goto L28;
    L27:
        r100 = false;
    L28:
        if (r100 == false) goto L30;
        d r116 = this.O;
        float r117 = this.E;
        float r105 = this.f399952q.g();
        r116.f399972a = r112;
        r116.f399973b = r117;
        r116.f399974c = r105;
        this.f399953r = this.O;
        goto L90
    L30:
        vla.b r106 = this.N;
        float r107 = this.E;
        float r108 = this.C;
        float r109 = this.f399952q.g();
        q.b r118 = this.f399952q.f400160c;
        if (r118 == null) goto L35;
        t r119 = r118.f400189l;
        if (r119 == null) goto L35;
        float r120 = r119.f400217s;
    L36:
        r106.b(r107, r111, r112, r108, r109, r120);
        this.f399955t = 0.0f;
        int r121 = this.f399957v;
        this.G = r111;
        this.f399957v = r121;
        this.f399953r = this.N;
    L35:
        r120 = 0.0f;
        goto L36
    L24:
        float r122 = (-r112) / r103;
        if ((r115 + ((r112 * r122) + (((r103 * r122) * r122) / 2.0f))) >= 0.0f) goto L27;
    L38:
        if (r110 == 1) goto L44;
        if (r110 == 7) goto L44;
        if (r110 == 2) goto L43;
        if (r110 == 6) goto L43;
    L45:
        q r123 = this.f399952q;
        q.b r124 = r123.f400160c;
        if (r124 == null) goto L50;
        t r125 = r124.f400189l;
        if (r125 == null) goto L50;
        int r126 = r125.D;
    L51:
        if (r126 != 0) goto L59;
        vla.b r127 = this.N;
        float r128 = this.E;
        float r129 = r123.g();
        q.b r130 = this.f399952q.f400160c;
        if (r130 == null) goto L57;
        t r131 = r130.f400189l;
        if (r131 == null) goto L57;
        float r132 = r131.f400217s;
    L58:
        r127.b(r128, r111, r112, r101, r129, r132);
    L89:
        int r133 = this.f399957v;
        this.G = r111;
        this.f399957v = r133;
        this.f399953r = this.N;
    L57:
        r132 = 0.0f;
        goto L58
    L59:
        vla.b r134 = this.N;
        float r135 = this.E;
        if (r124 == null) goto L64;
        t r136 = r124.f400189l;
        if (r136 == null) goto L64;
        float r137 = r136.f400224z;
    L65:
        if (r124 == null) goto L69;
        t r138 = r124.f400189l;
        if (r138 == null) goto L69;
        float r139 = r138.A;
    L70:
        if (r124 == null) goto L74;
        t r140 = r124.f400189l;
        if (r140 == null) goto L74;
        float r141 = r140.f400223y;
    L75:
        if (r124 == null) goto L79;
        t r142 = r124.f400189l;
        if (r142 == null) goto L79;
        float r143 = r142.B;
    L80:
        if (r124 == null) goto L84;
        t r144 = r124.f400189l;
        if (r144 == null) goto L84;
        int r145 = r144.C;
    L86:
        if (r134.f555710b != null) goto L88;
        r134.f555710b = new tla.l();
    L88:
        tla.l r146 = r134.f555710b;
        r134.f555711c = r146;
        r146.f546718c = r111;
        r146.f546716a = r141;
        r146.f546720e = r135;
        r146.f546717b = r139;
        r146.f546722g = r137;
        r146.f546723h = r143;
        r146.f546724i = r145;
        r146.f546719d = 0.0f;
    L84:
        r145 = 0;
    L79:
        r143 = 0.0f;
    L74:
        r141 = 0.0f;
    L69:
        r139 = 0.0f;
    L64:
        r137 = 0.0f;
    L50:
        r126 = 0;
    L43:
        r111 = 1.0f;
    L44:
        r111 = 0.0f;
        goto L45
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        this.V = getNanoTime();
        this.W = 0.0f;
        this.T = 0.0f;
        this.U = 0.0f;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        q r104 = this.f399952q;
        if (r104 == null) goto L13;
        q.b r105 = r104.f400160c;
        if (r105 == null) goto L15;
        t r106 = r105.f400189l;
        if (r106 != null) goto L9;
        return false;
    L9:
        if ((r106.f400221w & 2) != 0) goto L17;
        return true;
    L17:
        return false;
    L15:
        return false;
    L13:
        return false;
    }

    public final boolean s(float r100, float r101, View r110, MotionEvent r111) {
        if ((r110 instanceof ViewGroup) == false) goto L10;
        ViewGroup r102 = (ViewGroup) r110;
        int r103 = r102.getChildCount() - 1;
    L5:
        if (r103 < 0) goto L10;
        View r104 = r102.getChildAt(r103);
        if (s((r104.getLeft() + r100) - r110.getScrollX(), (r104.getTop() + r101) - r110.getScrollY(), r104, r111) == true) goto L8;
        r103 = r103 - 1;
        goto L5
    L8:
        boolean r105 = true;
    L11:
        if (r105 == true) goto L26;
        this.f399959v2.set(r100, r101, (r110.getRight() + r100) - r110.getLeft(), (r110.getBottom() + r101) - r110.getTop());
        if (r111.getAction() == 0) goto L15;
    L16:
        float r106 = -r100;
        float r107 = -r101;
        Matrix r108 = r110.getMatrix();
        if (r108.isIdentity() == false) goto L19;
        r111.offsetLocation(r106, r107);
        boolean r112 = r110.onTouchEvent(r111);
        r111.offsetLocation(-r106, -r107);
    L23:
        if (r112 == false) goto L26;
        return true;
    L19:
        MotionEvent r113 = MotionEvent.obtain(r111);
        r113.offsetLocation(r106, r107);
        if (this.f399966y2 != null) goto L22;
        this.f399966y2 = new Matrix();
    L22:
        r108.invert(this.f399966y2);
        r113.transform(this.f399966y2);
        r112 = r110.onTouchEvent(r113);
        r113.recycle();
        goto L23
    L15:
        if (this.f399959v2.contains(r111.getX(), r111.getY()) == true) goto L16;
    L26:
        return r105;
    L10:
        r105 = false;
        goto L11
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        this.Q1 = true;
    L17:
        th = move-exception;
        this.Q1 = false;
        throw th;
    L4:
        if (this.f399952q != null) goto L8;
        super.onLayout(r100, r101, r102, r103, r104);     // Catch: Throwable -> L17
        this.Q1 = false;
        return;
    L8:
        int r105 = r103 - r101;
        int r106 = r104 - r102;
        if (this.Q == r105) goto L12;
    L13:
        w();     // Catch: Throwable -> L17
        n(true);     // Catch: Throwable -> L17
    L14:
        this.Q = r105;     // Catch: Throwable -> L17
        this.R = r106;     // Catch: Throwable -> L17
        this.Q1 = false;
        return;
    L12:
        if (this.R == r106) goto L14;
        goto L13
    }

    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r210, int r211, int r212, int[] r213, int r214) {
        q r100 = this.f399952q;
        if (r100 != null) goto L5;
        return;
    L5:
        q.b r101 = r100.f400160c;
        if (r101 == null) goto L95;
        boolean r102 = !r101.f400192o;
        if (r102 == false) goto L97;
        int r103 = -1;
        if (r102 == false) goto L19;
        t r104 = r101.f400189l;
        if (r104 == null) goto L19;
        int r105 = r104.f400203e;
        if (r105 == (-1)) goto L19;
        if (r210.getId() == r105) goto L19;
        return;
    L19:
        q.b r106 = r100.f400160c;
        if (r106 == null) goto L24;
        t r107 = r106.f400189l;
        if (r107 == null) goto L24;
        boolean r108 = r107.f400219u;
    L26:
        if (r108 == false) goto L39;
        t r109 = r101.f400189l;
        if (r109 != null) goto L30;
    L32:
        float r110 = this.D;
        if (r110 == 1.0f) goto L37;
        if (r110 != 0.0f) goto L39;
    L37:
        if (r210.canScrollVertically(r103) == false) goto L39;
        return;
    L30:
        if ((r109.f400221w & 4) == 0) goto L32;
        r103 = r212;
    L39:
        t r111 = r101.f400189l;
        if (r111 != null) goto L42;
    L68:
        float r112 = this.D;
        long r113 = getNanoTime();
        float r114 = r211;
        this.T = r114;
        float r115 = r212;
        this.U = r115;
        this.W = (float) ((r113 - this.V) * 1.0E-9d);
        this.V = r113;
        q.b r116 = r100.f400160c;
        if (r116 == null) goto L86;
        t r117 = r116.f400189l;
        if (r117 == null) goto L86;
        float r118 = r117.f400216r.getProgress();
        if (r117.f400211m == true) goto L75;
        r117.f400211m = true;
        r117.f400216r.setProgress(r118);
    L75:
        r117.f400216r.q(r117.f400202d, r118, r117.f400206h, r117.f400205g, r117.f400212n);
        float r119 = r117.f400209k;
        float[] r120 = r117.f400212n;
        if (Math.abs((r119 * r120[0]) + (r117.f400210l * r120[1])) >= 0.01d) goto L78;
        float[] r121 = r117.f400212n;
        r121[0] = 0.01f;
        r121[1] = 0.01f;
    L78:
        float r122 = r117.f400209k;
        if (r122 == 0.0f) goto L81;
        float r123 = (r114 * r122) / r117.f400212n[0];
    L82:
        float r124 = Math.max(Math.min(r118 + r123, 1.0f), 0.0f);
        if (r124 == r117.f400216r.getProgress()) goto L86;
        r117.f400216r.setProgress(r124);
        goto L86
    L81:
        r123 = (r115 * r117.f400210l) / r117.f400212n[1];
    L86:
        if (r112 == this.D) goto L88;
        r213[0] = r211;
        ?? r125 = 1;
        r213[1] = r212;
    L89:
        n(false);
        if (r213[0] == 0) goto L92;
    L93:
        this.S = r125;
        return;
    L92:
        if (r213[r125] != 0) goto L93;
        return;
    L88:
        r125 = 1;
        goto L89
    L42:
        if ((r111.f400221w & 1) == 0) goto L68;
        float r126 = r211;
        float r127 = r212;
        q.b r128 = r100.f400160c;
        if (r128 == null) goto L57;
        t r129 = r128.f400189l;
        if (r129 == null) goto L57;
        r129.f400216r.q(r129.f400202d, r129.f400216r.getProgress(), r129.f400206h, r129.f400205g, r129.f400212n);
        float r130 = r129.f400209k;
        if (r130 == 0.0f) goto L53;
        float[] r131 = r129.f400212n;
        if (r131[0] != 0.0f) goto L52;
        r131[0] = 1.0E-7f;
    L52:
        float r132 = (r126 * r130) / r131[0];
    L58:
        float r133 = this.E;
        if (r133 > 0.0f) goto L63;
        if (r132 >= 0.0f) goto L63;
    L66:
        r210.setNestedScrollingEnabled(false);
        r210.post(new a(r210));
        return;
    L63:
        if (r133 < 1.0f) goto L68;
        if (r132 <= 0.0f) goto L68;
    L53:
        float[] r134 = r129.f400212n;
        if (r134[1] != 0.0f) goto L56;
        r134[1] = 1.0E-7f;
    L56:
        r132 = (r127 * r129.f400210l) / r134[1];
    L57:
        r132 = 0.0f;
    L24:
        r108 = false;
        goto L26
    L97:
        return;
    }

    public final void q(int r100, float r101, float r102, float r103, float[] r104) {
        HashMap<View, n> r105 = this.A;
        View r106 = b(r100);
        n r107 = r105.get(r106);
        if (r107 == null) goto L5;
        r107.d(r101, r102, r103, r104);
        r106.getY();
        return;
    L5:
        if (r106 == null) goto L9;
        r106.getContext().getResources().getResourceName(r100);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105, int[] r106) {
        if (this.S == true) goto L6;
        if (r101 != 0) goto L6;
        if (r102 != 0) goto L6;
    L7:
        this.S = false;
        return;
    L6:
        r106[0] = r106[0] + r103;
        r106[1] = r106[1] + r104;
        goto L7
    }
}
