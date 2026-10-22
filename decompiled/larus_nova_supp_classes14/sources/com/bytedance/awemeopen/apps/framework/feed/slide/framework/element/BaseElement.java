package com.bytedance.awemeopen.apps.framework.feed.slide.framework.element;

import android.content.Context;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import tz3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class BaseElement<E extends a, M extends b, C extends tz3.a, DATA> {
    public final Context a;
    public C b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final tz3.b<Boolean> f;

    public abstract E b();

    public abstract M c();

    public abstract c<E, M> d();

    public abstract d e();

    public void k() {
    }

    public abstract void l(DATA r1);

    public void m() {
    }

    public void n() {
    }

    public abstract void o();

    public abstract void onCreate();

    public final C f() {
        C r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    public final E g() {
        return (E) this.c.getValue();
    }

    public final M h() {
        return (M) this.d.getValue();
    }

    public final c<E, M> i() {
        return (c) this.e.getValue();
    }

    public final void j() {
        this.f.b(Boolean.FALSE);
    }

    public final void p() {
        this.f.b(Boolean.TRUE);
    }

    public final Context getContext() {
        return this.a;
    }

    public BaseElement(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.c = LazyKt.lazy(r3, new BaseElement$event$2(this));
        this.d = LazyKt.lazy(r3, new BaseElement$model$2(this));
        this.e = LazyKt.lazy(r3, new BaseElement$view$2(this));
        this.f = new tz3.b();
    }
}
