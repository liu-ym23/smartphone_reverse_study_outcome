package com.bytedance.awemeopen.apps.framework.feed.slide.framework.element;

import android.content.Context;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import tz3.a;

/* JADX INFO: loaded from: classes14.dex */
public abstract class BaseElement<E extends a, M extends b, C extends tz3.a, DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f195890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C f195891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f195892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f195893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f195894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final tz3.b<Boolean> f195895f;

    public abstract E b();

    public abstract M c();

    public abstract c<E, M> d();

    public abstract d e();

    public void k() {
    }

    public abstract void l(DATA r100);

    public void m() {
    }

    public void n() {
    }

    public abstract void o();

    public abstract void onCreate();

    public final C f() {
        C r100 = this.f195891b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    public final E g() {
        return (E) this.f195892c.getValue();
    }

    public final M h() {
        return (M) this.f195893d.getValue();
    }

    public final c<E, M> i() {
        return (c) this.f195894e.getValue();
    }

    public final void j() {
        this.f195895f.b(Boolean.FALSE);
    }

    public final void p() {
        this.f195895f.b(Boolean.TRUE);
    }

    public final Context getContext() {
        return this.f195890a;
    }

    public BaseElement(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f195890a = r100;
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.NONE;
        this.f195892c = LazyKt.lazy(r101, new BaseElement$event$2(this));
        this.f195893d = LazyKt.lazy(r101, new BaseElement$model$2(this));
        this.f195894e = LazyKt.lazy(r101, new BaseElement$view$2(this));
        this.f195895f = new tz3.b();
    }
}
