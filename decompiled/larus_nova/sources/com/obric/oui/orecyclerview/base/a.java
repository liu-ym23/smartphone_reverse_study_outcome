package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f401531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f401532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f401533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f401534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f401535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f401536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f401537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f401538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DisplayMetrics f401539i;

    /* JADX INFO: renamed from: com.obric.oui.orecyclerview.base.a$a, reason: collision with other inner class name */
    public static final class C4674a {
    }

    static {
    }

    public final void a() {
        if (this.f401532b != (-1)) goto L6;
        return;
    L6:
        if (this.f401537g != 1) goto L8;
        return;
    L8:
        d.a r100 = this.f401533c.b(AnimationUtils.currentAnimationTimeMillis() - this.f401532b);
        this.f401534d = TypedValue.applyDimension(1, r100.f401549a, this.f401539i);
        boolean r101 = r100.f401550b;
        this.f401538h = r101;
        if (r101 == false) goto L12;
        this.f401537g = 0;
        return;
    }

    public final void d() {
        float r100 = this.f401534d / this.f401539i.density;
        this.f401532b = AnimationUtils.currentAnimationTimeMillis();
        this.f401533c.a((-r100) / 100.0f, r100);
        this.f401537g = 2;
        this.f401538h = false;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f401532b = -1;
        this.f401533c = new d();
        this.f401538h = true;
        Resources r101 = r100.getResources();
        this.f401539i = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
    }

    public final void b(int r100) {
        float r101 = (r100 / 1000.0f) / this.f401539i.density;
        this.f401532b = AnimationUtils.currentAnimationTimeMillis();
        this.f401533c.a(r101, 0.0f);
        this.f401537g = 2;
        this.f401538h = false;
    }

    public final float c(float r100, boolean r101, boolean r110) {
        boolean r102 = false;
        if (Math.signum(r100) != Math.signum(this.f401534d)) goto L5;
        boolean r103 = true;
    L7:
        if (r103 != r101) goto L59;
        if (r110 == true) goto L59;
        float r111 = this.f401539i.density;
        float r104 = r100 / r111;
        if (this.f401537g == 1) goto L21;
        int r105 = b.f401540a;
        float r112 = b.a.a(Math.abs(this.f401534d / r111), this.f401531a) * (-Math.signum(this.f401534d));
        this.f401535e = r112;
        if (r112 != 0.0f) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == false) goto L18;
        float r113 = Math.signum(r104);
    L19:
        this.f401536f = r113;
    L26:
        float r114 = this.f401535e;
        float r107 = r104 + r114;
        this.f401535e = r107;
        float r108 = Math.signum(r107);
        float r109 = this.f401536f;
        if (r108 != r109) goto L29;
        boolean r115 = true;
    L30:
        if (r115 == true) goto L40;
        if (r109 != 0.0f) goto L34;
        boolean r116 = true;
    L35:
        if (r116 == true) goto L40;
        if (r101 == false) goto L38;
        this.f401535e = 0.0f;
        this.f401536f = 0.0f;
        r107 = 0.0f;
    L45:
        int r117 = b.f401540a;
        this.f401534d = TypedValue.applyDimension(1, (-b.a.b(Math.abs(r107), this.f401531a)) * Math.signum(r107), this.f401539i);
        this.f401537g = 1;
        this.f401538h = false;
        if (r103 == true) goto L48;
        return 0.0f;
    L48:
        if (r107 != 0.0f) goto L50;
        boolean r118 = true;
    L51:
        if (r118 == true) goto L53;
        return r100;
    L53:
        if (r114 != 0.0f) goto L55;
        r102 = true;
    L55:
        if (r102 == false) goto L62;
        return r100;
    L62:
        return -TypedValue.applyDimension(1, r114, this.f401539i);
    L50:
        r118 = false;
        goto L51
    L38:
        this.f401536f = Math.signum(r107);
        goto L45
    L34:
        r116 = false;
    L40:
        if (this.f401535e != 0.0f) goto L42;
        boolean r119 = true;
    L43:
        if (r119 == false) goto L45;
        this.f401536f = 0.0f;
        goto L45
    L42:
        r119 = false;
        goto L43
    L29:
        r115 = false;
        goto L30
    L18:
        r113 = Math.signum(r112);
        goto L19
    L15:
        r106 = false;
        goto L16
    L21:
        if (this.f401536f != 0.0f) goto L23;
        boolean r120 = true;
    L24:
        if (r120 == false) goto L26;
        this.f401536f = Math.signum(r104);
        goto L26
    L23:
        r120 = false;
    L59:
        return 0.0f;
    L5:
        r103 = false;
        goto L7
    }
}
