package com.obric.oui.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final InterpolatorC4676a f402074n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OverScroller f402075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.c f402076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f402077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f402078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f402079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f402080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f402081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f402082h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f402083i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f402084j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f402085k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f402086l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f402087m;

    /* JADX INFO: renamed from: com.obric.oui.panel.a$a, reason: collision with other inner class name */
    public class InterpolatorC4676a implements Interpolator {
        public InterpolatorC4676a() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f402088a;

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f402088a;     // Catch: Throwable -> L4
            r100.f402080f.removeCallbacks(r100.f402087m);     // Catch: Throwable -> L4
            this.f402088a.f402086l = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100) {
            this.f402088a = r100;
        }
    }

    static {
        f402074n = new InterpolatorC4676a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View b(View r100) {
        if (r100 != 0) goto L6;
        return null;
    L6:
        if (r100.canScrollHorizontally(-this.f402085k) == false) goto L8;
    L21:
        return r100;
    L8:
        if ((r100 instanceof com.obric.oui.panel.b) == false) goto L13;
        if (((com.obric.oui.panel.b) r100).a() == true) goto L21;
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
        this.f402086l = false;
        this.f402087m = new b(this);
        this.f402075a = new OverScroller(r100, f402074n);
        this.f402080f = r101;
        this.f402076b = r102;
        ViewConfiguration r103 = ViewConfiguration.get(r100);
        this.f402079e = r103.getScaledTouchSlop();
        this.f402077c = r103.getScaledMaximumFlingVelocity();
        this.f402078d = r103.getScaledMinimumFlingVelocity();
    }

    public final int a(int r100, int r101, int r102) {
        if (r100 != 0) goto L5;
        return 0;
    L5:
        int r103 = this.f402080f.getWidth();
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
