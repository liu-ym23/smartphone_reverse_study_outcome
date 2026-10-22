package com.ss.android.lark.widget.select;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScrollView f448401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<s> f448402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f448403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f448404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r.a f448405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f448406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f448407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f448408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f448409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f448410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f448411k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f448412l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f448413m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f448414n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f448415o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f448416p;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.widget.select.r
    public final void release() {
        if (this.f448410j == false) goto L5;
        return;
    L5:
        stop();
        this.f448404d = null;
        this.f448405e = null;
        this.f448410j = true;
    }

    @Override // com.ss.android.lark.widget.select.r
    public final void stop() {
        d r100 = this.f448409i;
        if (r100 == null) goto L5;
        r100.run();
    L5:
        this.f448409i = null;
        this.f448408h = 0;
    }

    @Override // com.ss.android.lark.widget.select.r
    public final boolean a(float r100) {
        if (this.f448410j == false) goto L5;
        return false;
    L5:
        s r101 = this.f448402b.invoke();
        float r102 = r101.f448514a;
        float r103 = r101.f448515b;
        if (r102 < r103) goto L8;
        return false;
    L8:
        if (r100 >= r102) goto L10;
        return false;
    L10:
        if (r100 > r103) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // com.ss.android.lark.widget.select.r
    public final void c(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (this.f448410j == false) goto L5;
        return;
    L5:
        this.f448406f = r110.getRawX();
        this.f448407g = r110.getRawY();
        int r100 = r110.getActionMasked();
        int r101 = -1;
        if (r100 != 1) goto L8;
        float r111 = r110.getRawY();
        r.a r102 = this.f448405e;
        if (r102 == null) goto L68;
        s r103 = this.f448402b.invoke();
        if (this.f448408h != 1) goto L46;
    L59:
        float r112 = this.f448406f;
        float r104 = r103.f448515b - this.f448413m;
        m r105 = ((k) r102).f448436a;
        m.b r106 = r105.f448453p;
        if (r106 == null) goto L68;
        int r107 = m.b.f448461q;
        r106.c(r112, r104, 1);
        m.b r113 = r105.f448444g;
        if (r113 == null) goto L65;
        r113.d();
    L65:
        m.b r114 = r105.f448445h;
        if (r114 == null) goto L68;
        r114.d();
        goto L68
    L46:
        if (r111 > r103.f448515b) goto L59;
        float r108 = r103.f448514a;
        if (r111 > r108) goto L68;
        float r115 = this.f448406f;
        float r109 = r108 + this.f448413m;
        m r116 = ((k) r102).f448436a;
        m.b r117 = r116.f448453p;
        if (r117 == null) goto L68;
        int r118 = m.b.f448461q;
        r117.c(r115, r109, -1);
        m.b r119 = r116.f448444g;
        if (r119 == null) goto L56;
        r119.d();
    L56:
        m.b r120 = r116.f448445h;
        if (r120 == null) goto L68;
        r120.d();
    L68:
        stop();
        return;
    L8:
        if (r100 != 2) goto L10;
        float r121 = r110.getRawY();
        View r122 = this.f448404d;
        if (r122 == null) goto L75;
        s r123 = this.f448402b.invoke();
        if (r123.f448514a < r123.f448515b) goto L19;
        stop();
        return;
    L19:
        r122.getLocationOnScreen(this.f448411k);
        float r124 = this.f448411k[1];
        float r125 = r122.getHeight() + r124;
        float r126 = r123.f448514a;
        float r127 = this.f448412l;
        float r128 = r127 + r126;
        float r129 = r123.f448515b - r127;
        if (r121 > r128) goto L27;
        if (r124 >= r126) goto L27;
        if (this.f448401a.canScrollVertically(-1) == false) goto L27;
    L35:
        if (r101 == this.f448408h) goto L76;
        stop();
        if (r101 == 0) goto L72;
        this.f448408h = r101;
        ScrollView r130 = this.f448401a;
        Ref.BooleanRef r131 = new Ref.BooleanRef();
        r131.element = true;
        e r132 = new e(r131, r130, r101, this);
        r130.postOnAnimation(r132);
        this.f448409i = new d(r131, r130, r132);
        return;
    L72:
        return;
    L76:
        return;
    L27:
        if (r121 >= r129) goto L29;
    L33:
        r101 = 0;
        goto L35
    L29:
        if (r125 <= r123.f448515b) goto L33;
        if (this.f448401a.canScrollVertically(1) == false) goto L33;
        r101 = 1;
        goto L35
    L75:
        return;
    L10:
        if (r100 != 3) goto L74;
        stop();
        return;
    }

    @Override // com.ss.android.lark.widget.select.r
    public final void b(View r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "selectionView");
        Intrinsics.checkNotNullParameter(r101, "positionUpdater");
        if (this.f448410j == false) goto L5;
        return;
    L5:
        this.f448404d = r100;
        this.f448405e = r101;
    }

    public c(Context r100, ScrollView r101, Function0<s> r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scrollView");
        Intrinsics.checkNotNullParameter(r102, "boundsProvider");
        Intrinsics.checkNotNullParameter(r103, "beforeScroll");
        this.f448401a = r101;
        this.f448402b = r102;
        this.f448403c = r103;
        this.f448411k = new int[2];
        this.f448412l = UIUtils.dp2px(r100, 80.0f);
        this.f448413m = UIUtils.dp2px(r100, 10.0f);
        this.f448414n = UIUtils.dp2px(r100, 20.0f);
        this.f448415o = UIUtils.dp2px(r100, 1.0f);
        this.f448416p = UIUtils.dp2px(r100, 8.0f);
    }
}
