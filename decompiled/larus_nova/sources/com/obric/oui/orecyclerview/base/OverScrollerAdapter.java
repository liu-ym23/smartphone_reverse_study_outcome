package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class OverScrollerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f401523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Interpolator f401524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f401525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f401526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f401527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f401528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f401529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f401530h;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        if (this.f401528f == false) goto L7;
        return d().computeScrollOffset();
    L7:
        if (this.f401529g != (-1)) goto L10;
        return false;
    L10:
        this.f401530h = AnimationUtils.currentAnimationTimeMillis() - this.f401529g;
        return !e();
    }

    public final int b() {
        if (this.f401528f == false) goto L7;
        return d().getCurrX();
    L7:
        return (int) ((c) this.f401526d.getValue()).c(this.f401530h).f401543a;
    }

    public final int c() {
        if (this.f401528f == false) goto L7;
        return d().getCurrY();
    L7:
        return (int) ((c) this.f401527e.getValue()).c(this.f401530h).f401543a;
    }

    public final OverScroller d() {
        return (OverScroller) this.f401525c.getValue();
    }

    public final boolean e() {
        if (this.f401528f == true) goto L5;
        c.b r100 = ((c) this.f401526d.getValue()).c(this.f401530h);
        c.b r101 = ((c) this.f401527e.getValue()).c(this.f401530h);
        if (r100.f401545c == true) goto L9;
    L11:
        return false;
    L9:
        if (r101.f401545c == false) goto L11;
        return true;
    L5:
        return d().isFinished();
    }

    public OverScrollerAdapter(Context r100, Interpolator r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "interpolator");
        this.f401523a = r100;
        this.f401524b = r101;
        this.f401525c = LazyKt.lazy(new OverScrollerAdapter$systemOverScroller$2(this));
        this.f401526d = LazyKt.lazy(OverScrollerAdapter$fluidScrollerX$2.INSTANCE);
        this.f401527e = LazyKt.lazy(OverScrollerAdapter$fluidScrollerY$2.INSTANCE);
        this.f401528f = true;
        this.f401529g = -1;
        this.f401530h = -1;
    }
}
