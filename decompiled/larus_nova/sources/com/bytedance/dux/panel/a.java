package com.bytedance.dux.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final InterpolatorC2964a f205338n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OverScroller f205339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.c f205340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f205341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f205342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f205343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f205344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f205345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f205346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f205347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f205348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f205349k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f205350l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f205351m;

    /* JADX INFO: renamed from: com.bytedance.dux.panel.a$a, reason: collision with other inner class name */
    public class InterpolatorC2964a implements Interpolator {
        public InterpolatorC2964a() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f205352a;

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f205352a;     // Catch: Throwable -> L4
            r100.f205344f.removeCallbacks(r100.f205351m);     // Catch: Throwable -> L4
            this.f205352a.f205350l = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100) {
            this.f205352a = r100;
        }
    }

    static {
        f205338n = new InterpolatorC2964a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View b(View r100) {
        if (r100 != 0) goto L6;
        return null;
    L6:
        if (r100.canScrollHorizontally(-this.f205349k) == false) goto L8;
    L21:
        return r100;
    L8:
        if ((r100 instanceof c) == false) goto L13;
        if (((c) r100).a() == true) goto L21;
    L13:
        if ((r100 instanceof ViewGroup) == false) goto L20;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L15:
        if (r103 >= r102) goto L20;
        View r104 = b(r101.getChildAt(r103));
        if (r104 != null) goto L18;
        r103 = r103 + 1;
        goto L15
    L18:
        return r104;
    L20:
        return null;
    }

    public a(Context r100, ViewGroup r101, d.c r102) {
        this.f205350l = false;
        this.f205351m = new b(this);
        this.f205339a = new OverScroller(r100, f205338n);
        this.f205344f = r101;
        this.f205340b = r102;
        ViewConfiguration r103 = ViewConfiguration.get(r100);
        this.f205343e = r103.getScaledTouchSlop();
        this.f205341c = r103.getScaledMaximumFlingVelocity();
        this.f205342d = r103.getScaledMinimumFlingVelocity();
    }

    public final int a(int r100, int r101, int r102) {
        if (r100 != 0) goto L5;
        return 0;
    L5:
        int r103 = this.f205344f.getWidth();
        float r104 = r103 / 2;
        float r105 = r104 + (((float) Math.sin((Math.min(1.0f, Math.abs(r100) / r103) - 0.5f) * 0.47123894f)) * r104);
        int r106 = Math.abs(r101);
        if (r106 <= 0) goto L8;
        int r107 = Math.round(Math.abs(r105 / r106) * 1000.0f) * 4;
    L10:
        return Math.min(r107, 600);
    L8:
        r107 = (int) (((Math.abs(r100) / r102) + 1.0f) * 256.0f);
        goto L10
    }
}
