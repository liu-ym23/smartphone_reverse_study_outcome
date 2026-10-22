package com.bytedance.ies.uikit.refresh;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import androidx.camera.video.AudioStats;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.common.utility.Logger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes19.dex */
public class I18nSwipeRefreshLayout extends ViewGroup {
    public static final int[] B = null;
    public final d A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f249107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f249108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f249109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f249110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f249111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f249112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f249113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f249114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f249115i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f249116j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DecelerateInterpolator f249117k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public i56.a f249118l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f249119m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f249120n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f249121o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MaterialProgressDrawable f249122p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i56.b f249123q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public i56.c f249124r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public i56.d f249125s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public i56.d f249126t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f249127u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f249128v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f249129w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f249130x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a f249131y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f249132z;

    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ I18nSwipeRefreshLayout f249133a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public a(I18nSwipeRefreshLayout r100) {
            this.f249133a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            I18nSwipeRefreshLayout r101 = this.f249133a;
            if (r101.f249108b == false) goto L5;
            MaterialProgressDrawable r102 = r101.f249122p;
            r102.f249141b.f249171u = 255;
            r102.start();
            boolean r103 = this.f249133a.f249128v;
        L6:
            I18nSwipeRefreshLayout r104 = this.f249133a;
            r104.f249112f = r104.f249118l.getTop();
            return;
        L5:
            r101.f249122p.stop();
            this.f249133a.f249118l.setVisibility(8);
            I18nSwipeRefreshLayout.a(this.f249133a);
            this.f249133a.getClass();
            I18nSwipeRefreshLayout r105 = this.f249133a;
            r105.e(r105.f249121o - r105.f249112f);
            goto L6
        }
    }

    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ I18nSwipeRefreshLayout f249134a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public b(I18nSwipeRefreshLayout r100) {
            this.f249134a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            I18nSwipeRefreshLayout r101 = this.f249134a;
            int[] r102 = I18nSwipeRefreshLayout.B;
            r101.getClass();
            I18nSwipeRefreshLayout r103 = this.f249134a;
            r103.getClass();
            i56.c r104 = new i56.c(r103);
            r103.f249124r = r104;
            r104.setDuration(150);
            i56.a r105 = r103.f249118l;
            r105.f488309a = null;
            r105.clearAnimation();
            r103.f249118l.startAnimation(r103.f249124r);
        }
    }

    public class c extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ I18nSwipeRefreshLayout f249135a;

        public c(I18nSwipeRefreshLayout r100) {
            this.f249135a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            I18nSwipeRefreshLayout r102 = this.f249135a;
            int[] r103 = I18nSwipeRefreshLayout.B;
            r102.getClass();
            I18nSwipeRefreshLayout r104 = this.f249135a;
            int r105 = (int) (r104.f249127u - Math.abs(r104.f249121o));
            I18nSwipeRefreshLayout r106 = this.f249135a;
            int r107 = r106.f249120n;
            this.f249135a.e((r107 + ((int) ((r105 - r107) * r100))) - r106.f249118l.getTop());
        }
    }

    public class d extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ I18nSwipeRefreshLayout f249136a;

        public d(I18nSwipeRefreshLayout r100) {
            this.f249136a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            I18nSwipeRefreshLayout r102 = this.f249136a;
            int r103 = r102.f249120n;
            r102.e((r103 + ((int) ((r102.f249121o - r103) * r100))) - r102.f249118l.getTop());
        }
    }

    public interface e {
    }

    public interface f {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
    }

    public void setOnRefreshListener(f r100) {
    }

    public void setStartEndRefreshListener(e r100) {
    }

    static {
        B = new int[]{R.attr.enabled};
    }

    public final void c() {
        if (this.f249107a != null) goto L11;
        int r100 = 0;
    L6:
        if (r100 >= getChildCount()) goto L15;
        View r101 = getChildAt(r100);
        if (r101.equals(this.f249118l) == false) goto L9;
        r100 = r100 + 1;
        goto L6
    L9:
        this.f249107a = r101;
        return;
    L15:
        return;
    }

    public I18nSwipeRefreshLayout(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ void a(I18nSwipeRefreshLayout r100) {
        r100.setColorViewAlpha(255);
    }

    private void setAnimationProgress(float r100) {
        ViewCompat.setScaleX(this.f249118l, r100);
        ViewCompat.setScaleY(this.f249118l, r100);
    }

    private void setColorViewAlpha(int r100) {
        this.f249118l.getBackground().setAlpha(r100);
        this.f249122p.f249141b.f249171u = r100;
    }

    public final void e(int r100) {
        this.f249118l.bringToFront();
        this.f249118l.offsetTopAndBottom(r100);
        this.f249112f = this.f249118l.getTop();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        c();
        int r101 = MotionEventCompat.getActionMasked(r100);
        int r102 = 0;
        if (isEnabled() == true) goto L5;
    L50:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.f249107a, -1) == true) goto L50;
        if (this.f249108b == true) goto L50;
        if (r101 == 0) goto L25;
        if (r101 != 1) goto L13;
    L24:
        this.f249115i = false;
        Logger.d("I18nSwipeRefreshLayout", "intercept cancel refresh");
        this.f249116j = -1;
    L49:
        return this.f249115i;
    L13:
        if (r101 != 2) goto L15;
    L33:
        int r103 = this.f249116j;
        if (r103 != (-1)) goto L36;
        return false;
    L36:
        int r104 = MotionEventCompat.findPointerIndex(r100, r103);
        if (r104 >= 0) goto L39;
        float r105 = -1.0f;
    L41:
        if (r105 != (-1.0f)) goto L44;
        return false;
    L44:
        if ((r105 - this.f249114h) <= this.f249109c) goto L49;
        if (this.f249115i == true) goto L49;
        this.f249115i = true;
        Logger.d("I18nSwipeRefreshLayout", "intercept going refresh");
        this.f249122p.f249141b.f249171u = 76;
        goto L49
    L39:
        r105 = MotionEventCompat.getY(r100, r104);
        goto L41
    L15:
        if (r101 == 3) goto L24;
        if (r101 != 6) goto L49;
        int r106 = MotionEventCompat.getActionIndex(r100);
        if (MotionEventCompat.getPointerId(r100, r106) != this.f249116j) goto L49;
        if (r106 != 0) goto L23;
        r102 = 1;
    L23:
        this.f249116j = MotionEventCompat.getPointerId(r100, r102);
        goto L49
    L25:
        e(this.f249121o - this.f249118l.getTop());
        int r107 = MotionEventCompat.getPointerId(r100, 0);
        this.f249116j = r107;
        this.f249115i = false;
        int r108 = MotionEventCompat.findPointerIndex(r100, r107);
        if (r108 >= 0) goto L28;
        float r109 = -1.0f;
    L30:
        if (r109 != (-1.0f)) goto L32;
        return false;
    L32:
        this.f249114h = r109;
        goto L33
    L28:
        r109 = MotionEventCompat.getY(r100, r108);
        goto L30
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        int r100 = MotionEventCompat.getActionMasked(r110);
        int r101 = 0;
        if (isEnabled() == true) goto L5;
    L91:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.f249107a, -1) == true) goto L91;
        if (r100 != 0) goto L10;
        this.f249116j = MotionEventCompat.getPointerId(r110, 0);
        this.f249115i = false;
    L90:
        return true;
    L10:
        if (r100 != 1) goto L12;
    L72:
        int r102 = this.f249116j;
        if (r102 != (-1)) goto L92;
        return false;
    L92:
        float r111 = (MotionEventCompat.getY(r110, MotionEventCompat.findPointerIndex(r110, r102)) - this.f249114h) * 0.5f;
        this.f249115i = false;
        if (r111 <= this.f249110d) goto L80;
        d(true, true);
    L84:
        this.f249116j = -1;
        return false;
    L80:
        this.f249108b = false;
        MaterialProgressDrawable r112 = this.f249122p;
        MaterialProgressDrawable.c r103 = r112.f249141b;
        r103.f249155e = 0.0f;
        r103.a();
        MaterialProgressDrawable.c r113 = r112.f249141b;
        r113.f249156f = 0.0f;
        r113.a();
        b r114 = new b(this);
        this.f249120n = this.f249112f;
        this.A.reset();
        this.A.setDuration(200);
        this.A.setInterpolator(this.f249117k);
        i56.a r104 = this.f249118l;
        r104.f488309a = r114;
        r104.clearAnimation();
        this.f249118l.startAnimation(this.A);
        MaterialProgressDrawable.c r115 = this.f249122p.f249141b;
        if (r115.f249165o == false) goto L83;
        r115.f249165o = false;
        r115.a();
    L83:
        Logger.d("I18nSwipeRefreshLayout", "on touch cancel refresh");
    L86:
        e = move-exception;
        e.printStackTrace();
        return true;
    L12:
        if (r100 != 2) goto L14;
        int r105 = MotionEventCompat.findPointerIndex(r110, this.f249116j);
        if (r105 >= 0) goto L94;
        return false;
    L94:
        float r116 = (MotionEventCompat.getY(r110, r105) - this.f249114h) * 0.5f;
        if (this.f249115i == false) goto L90;
        MaterialProgressDrawable.c r106 = this.f249122p.f249141b;
        if (r106.f249165o == true) goto L35;
        r106.f249165o = true;
        r106.a();
    L35:
        float r107 = r116 / this.f249110d;
        if (r107 >= 0.0f) goto L38;
        return false;
    L38:
        float r108 = Math.min(1.0f, Math.abs(r107));
        float r109 = (((float) Math.max(((double) r108) - 0.4d, AudioStats.AUDIO_AMPLITUDE_NONE)) * 5.0f) / 3.0f;
        float r117 = Math.abs(r116) - this.f249110d;
        float r118 = this.f249127u;
        double r119 = Math.max(0.0f, Math.min(r117, r118 * 2.0f) / r118) / 4.0f;
        float r120 = ((float) (r119 - Math.pow(r119, 2.0d))) * 2.0f;
        int r121 = this.f249121o + ((int) ((r118 * r108) + ((r118 * r120) * 2.0f)));
        if (this.f249118l.getVisibility() == 0) goto L41;
        this.f249118l.setVisibility(0);
    L41:
        ViewCompat.setScaleX(this.f249118l, 1.0f);
        ViewCompat.setScaleY(this.f249118l, 1.0f);
        if (r116 >= this.f249110d) goto L58;
        if (this.f249122p.f249141b.f249171u <= 76) goto L54;
        i56.d r122 = this.f249125s;
        if (r122 != null) goto L48;
    L52:
        if (r101 != 0) goto L54;
        i56.d r123 = new i56.d(this, this.f249122p.f249141b.f249171u, 76);
        r123.setDuration(300);
        i56.a r124 = this.f249118l;
        r124.f488309a = null;
        r124.clearAnimation();
        this.f249118l.startAnimation(r123);
        this.f249125s = r123;
        goto L54
    L48:
        if (r122.hasStarted() == false) goto L52;
        if (r122.hasEnded() == true) goto L52;
        r101 = 1;
    L54:
        MaterialProgressDrawable r125 = this.f249122p;
        float r126 = Math.min(0.8f, r109 * 0.8f);
        MaterialProgressDrawable.c r127 = r125.f249141b;
        r127.f249155e = 0.0f;
        r127.a();
        MaterialProgressDrawable.c r128 = r125.f249141b;
        r128.f249156f = r126;
        r128.a();
        MaterialProgressDrawable r129 = this.f249122p;
        float r130 = Math.min(1.0f, r109);
        MaterialProgressDrawable.c r131 = r129.f249141b;
        if (r130 == r131.f249167q) goto L68;
        r131.f249167q = r130;
        r131.a();
    L68:
        MaterialProgressDrawable.c r132 = this.f249122p.f249141b;
        r132.f249157g = (((r109 * 0.4f) - 0.25f) + (r120 * 2.0f)) * 0.5f;
        r132.a();
        e(r121 - this.f249112f);
        goto L90
    L58:
        if (this.f249122p.f249141b.f249171u >= 255) goto L68;
        i56.d r133 = this.f249126t;
        if (r133 != null) goto L62;
    L66:
        if (r101 != 0) goto L68;
        i56.d r134 = new i56.d(this, this.f249122p.f249141b.f249171u, 255);
        r134.setDuration(300);
        i56.a r135 = this.f249118l;
        r135.f488309a = null;
        r135.clearAnimation();
        this.f249118l.startAnimation(r134);
        this.f249126t = r134;
        goto L68
    L62:
        if (r133.hasStarted() == false) goto L66;
        if (r133.hasEnded() == true) goto L66;
        r101 = 1;
    L69:
        e = move-exception;
        e.printStackTrace();
        return true;
    L14:
        if (r100 == 3) goto L72;
        if (r100 != 5) goto L18;
        this.f249116j = MotionEventCompat.getPointerId(r110, MotionEventCompat.getActionIndex(r110));
        goto L90
    L18:
        if (r100 != 6) goto L90;
        int r136 = MotionEventCompat.getActionIndex(r110);
        if (MotionEventCompat.getPointerId(r110, r136) != this.f249116j) goto L90;
        if (r136 != 0) goto L24;
        r101 = 1;
    L24:
        this.f249116j = MotionEventCompat.getPointerId(r110, r101);
        goto L90
    }

    public void setColorScheme(int... r100) {
        setColorSchemeResources(r100);
    }

    public void setColorSchemeColors(int... r100) {
        c();
        MaterialProgressDrawable.c r101 = this.f249122p.f249141b;
        r101.f249160j = r100;
        r101.f249161k = 0;
        r101.f249161k = 0;
    }

    public void setColorSchemeResources(int... r100) {
        Resources r101 = getResources();
        int[] r102 = new int[r100.length];
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        r102[r103] = r101.getColor(r100[r103]);
        r103 = r103 + 1;
        goto L4
    L6:
        setColorSchemeColors(r102);
    }

    public void setDistanceToTriggerSync(int r100) {
        this.f249110d = r100;
    }

    public void setProgressBackgroundColor(int r100) {
        this.f249118l.setBackgroundColor(r100);
        MaterialProgressDrawable r101 = this.f249122p;
        r101.f249141b.f249173w = getResources().getColor(r100);
    }

    public void setRefreshing(boolean r100) {
        if (r100 == true) goto L5;
    L10:
        d(r100, false);
        return;
    L5:
        if (this.f249108b == r100) goto L10;
        this.f249108b = r100;
        e(((int) (this.f249127u + this.f249121o)) - this.f249112f);
        this.f249128v = false;
        a r101 = this.f249131y;
        this.f249118l.setVisibility(0);
        this.f249122p.f249141b.f249171u = 255;
        i56.b r102 = new i56.b(this);
        this.f249123q = r102;
        r102.setDuration(this.f249111e);
        if (r101 == null) goto L9;
        this.f249118l.f488309a = r101;
    L9:
        this.f249118l.clearAnimation();
        this.f249118l.startAnimation(this.f249123q);
    }

    public void setSize(int r100) {
        if (r100 != 0) goto L4;
    L6:
        Resources r101 = getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        if (r100 != 0) goto L9;
        int r103 = (int) (r102.density * 56.0f);
        this.f249129w = r103;
        this.f249130x = r103;
    L10:
        this.f249118l.setImageDrawable(null);
        this.f249122p.b(r100);
        this.f249118l.setImageDrawable(this.f249122p);
        return;
    L9:
        int r104 = (int) (r102.density * 40.0f);
        this.f249129w = r104;
        this.f249130x = r104;
        goto L10
    L4:
        if (r100 == 1) goto L6;
    }

    public I18nSwipeRefreshLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f249108b = false;
        this.f249110d = -1.0f;
        this.f249113g = false;
        this.f249116j = -1;
        this.f249119m = -1;
        this.f249131y = new a(this);
        this.f249132z = new c(this);
        this.A = new d(this);
        this.f249109c = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f249111e = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f249117k = new DecelerateInterpolator(2.0f);
        TypedArray r102 = r100.obtainStyledAttributes(r101, B);
        setEnabled(r102.getBoolean(0, true));
        r102.recycle();
        Resources r103 = getResources();
        DisplayMetrics r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics());
        int r105 = (int) (r104.density * 40.0f);
        this.f249129w = r105;
        this.f249130x = r105;
        this.f249118l = new i56.a(getContext());
        MaterialProgressDrawable r106 = new MaterialProgressDrawable(getContext(), this);
        this.f249122p = r106;
        r106.f249141b.f249173w = -328966;
        this.f249118l.setImageDrawable(r106);
        this.f249118l.setVisibility(8);
        addView(this.f249118l);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        float r107 = r104.density * 64.0f;
        this.f249127u = r107;
        this.f249110d = r107;
    }

    public static /* synthetic */ void b(I18nSwipeRefreshLayout r100, float r101) {
        r100.setAnimationProgress(r101);
    }

    public final void d(boolean r100, boolean r101) {
        if (this.f249108b == r100) goto L12;
        this.f249128v = r101;
        c();
        this.f249108b = r100;
        if (r100 == false) goto L10;
        int r102 = this.f249112f;
        a r103 = this.f249131y;
        this.f249120n = r102;
        this.f249132z.reset();
        this.f249132z.setDuration(200);
        this.f249132z.setInterpolator(this.f249117k);
        if (r103 == null) goto L9;
        this.f249118l.f488309a = r103;
    L9:
        this.f249118l.clearAnimation();
        this.f249118l.startAnimation(this.f249132z);
        return;
    L10:
        a r104 = this.f249131y;
        i56.c r105 = new i56.c(this);
        this.f249124r = r105;
        r105.setDuration(150);
        i56.a r106 = this.f249118l;
        r106.f488309a = r104;
        r106.clearAnimation();
        this.f249118l.startAnimation(this.f249124r);
        return;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        int r102 = this.f249119m;
        if (r102 >= 0) goto L6;
        return r101;
    L6:
        if (r101 != (r100 - 1)) goto L8;
        return r102;
    L8:
        if (r101 >= r102) goto L10;
        return r101;
    L10:
        return r101 + 1;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f249107a != null) goto L5;
        c();
    L5:
        View r102 = this.f249107a;
        if (r102 != null) goto L8;
        return;
    L8:
        r102.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f249118l.measure(View.MeasureSpec.makeMeasureSpec(this.f249129w, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f249130x, 1073741824));
        if (this.f249113g == true) goto L11;
        this.f249113g = true;
        int r103 = -this.f249118l.getMeasuredHeight();
        this.f249121o = r103;
        this.f249112f = r103;
    L11:
        this.f249119m = -1;
        int r104 = 0;
    L13:
        if (r104 >= getChildCount()) goto L21;
        if (getChildAt(r104) == this.f249118l) goto L16;
        r104 = r104 + 1;
        goto L13
    L16:
        this.f249119m = r104;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getMeasuredWidth();
        int r106 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.f249107a != null) goto L8;
        c();
    L8:
        View r107 = this.f249107a;
        if (r107 != null) goto L11;
        return;
    L11:
        int r108 = getPaddingLeft();
        int r109 = getPaddingTop();
        int r110 = (r105 - getPaddingLeft()) - getPaddingRight();
        r107.layout(r108, r109, r110 + r108, ((r106 - getPaddingTop()) - getPaddingBottom()) + r109);
        int r111 = this.f249118l.getMeasuredWidth();
        int r112 = this.f249118l.getMeasuredHeight();
        int r113 = r105 / 2;
        int r114 = r111 / 2;
        int r115 = this.f249112f;
        this.f249118l.layout(r113 - r114, r115, r113 + r114, r112 + r115);
    }
}
